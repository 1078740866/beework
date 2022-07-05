 package Ansin.web.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;

import Ansin.web.api.CommonResult;
import Ansin.web.bean.B0002PopListBean;
import Ansin.web.bean.CompanyRegisterInitBean;
import Ansin.web.entity.CompanyTblEntity;
import Ansin.web.entity.CompanyTblPopEntity;
import Ansin.web.entity.UserTblEntity;
import Ansin.web.serviceimpl.IB0002ServiceImpl;
import Ansin.web.util.CheckUtil;
import Ansin.web.util.EditUtil;
import Ansin.web.vueForm.B0002PopVueForm;
import Ansin.web.vueForm.B0002VueForm;


 /**
 * B0002_会社新規
 */
@RestController
@RequestMapping("/B0002")
public class B0002Controller {

	@Value("${uploadfile.path}")
	private String uploadpath;

	@Autowired
    private IB0002ServiceImpl iB0002ServiceImpl;

	/**
	   *  会社新規登録画面初期表示
	 * @return CompanyRegisterInitResponseEntity
	 */
	@RequestMapping(value = "/init", method = RequestMethod.GET)
    public CommonResult<CompanyRegisterInitBean> Init() {

		// 画面戻り値を取得
		CompanyRegisterInitBean companyRegisterInitBean = iB0002ServiceImpl.getCompanyRegisterInitResponse();

		if (companyRegisterInitBean != null) {
			// TODO メッセージ「I0001」
			return CommonResult.success(companyRegisterInitBean);
		} else {
			// TODO エラーメッセージ「E0009」が出力される
			return CommonResult.validateFailed();
		}

    }

    /**
     *   会社画面Pop初期表示
	* @param jsonCompanyNm
	* @param results
	* @return B0002PopListBean
	*/
	@RequestMapping(value = "/initPop", method = RequestMethod.POST)
	public CommonResult<B0002PopListBean> initPop(@RequestBody JSONObject jsonCompanyNm, BindingResult results) {

		// 会社名取得
		Map<String, Object> jsonToMap =  JSONObject.parseObject(jsonCompanyNm.toJSONString());
		String companyNm = (String)jsonToMap.get("companyNm");

		// 検索条件通り、会社情報を取得
		List<CompanyTblPopEntity> companyList = iB0002ServiceImpl.selectCompanyInfo(companyNm, "", null, "",null);

		// PopList戻り値を取得
		B0002PopListBean b0002PopListBean = iB0002ServiceImpl.getPopListInfo(companyList);

		return CommonResult.success(b0002PopListBean);
	}

   /**
     *   画面Pop検索
	* @param b0002POPVueForm
	* @param results
	* @return B0002PopListBean
	*/
	@RequestMapping(value = "/searchPop", method = RequestMethod.POST)
	public CommonResult<B0002PopListBean> searchPop(@RequestBody B0002PopVueForm b0002POPVueForm, BindingResult results) {

		// 検索条件通り、会社情報を取得
		List<CompanyTblPopEntity> companyList = iB0002ServiceImpl.selectCompanyInfo(b0002POPVueForm.getCompanyNm(),
				b0002POPVueForm.getAddress1(), EditUtil.intUtil(b0002POPVueForm.getIndustryCd1()), b0002POPVueForm.getCompanyScale(),
				EditUtil.intUtil(b0002POPVueForm.getCountry()));

		// PopList戻り値を取得
		B0002PopListBean b0002PopListBean = iB0002ServiceImpl.getPopListInfo(companyList);

		return CommonResult.success(b0002PopListBean);
	}

   /**
     * 都道府県と所属市区町村を取得
	* @param companyPostal
	* @return PrefecturestAndCityBean
	*/
	@RequestMapping(value = "/searchPostal", method = RequestMethod.POST)
	public CommonResult<List<String>> searchPostal(@RequestBody JSONObject companyPostal, BindingResult results) {

		// 郵便番号取得
		Map<String, Object> jsonToMap =  JSONObject.parseObject(companyPostal.toJSONString());
		String postal = (String)jsonToMap.get("companyPostal");

		// 郵便番号通り、会社情報を取得
		List<String> str = iB0002ServiceImpl.getPostaOne(postal);
		
		// PopList戻り値を取得
		return CommonResult.success(str);
	}

	/**
	   *  新規会社確認
	 * @param b0002VueForm
	 * @return B0002VueForm
	 * @throws IOException 
	 */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public CommonResult<B0002VueForm> registerCompany(@RequestBody @Valid B0002VueForm b0002VueForm, BindingResult results) throws IOException {

		if (results.hasErrors()) {
			return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
		}
		
		// 郵便番号正確性チェック
		if (!CheckUtil.isPostal(b0002VueForm.getCompanyInfo().getCompanyPostal())) {
			return CommonResult.validateFailed("郵便番号が正しくありません。");
		}
		// メール存在チェック(ユーザー用)
		if (iB0002ServiceImpl.checkEmail(b0002VueForm.getCompanyInfo().getUserMail()) != 0) {
			return CommonResult.validateFailed("メールアドレスが既に存在します。");
		}
		// メール格式チェック(ユーザー用)
		if (!CheckUtil.checkEmail(b0002VueForm.getCompanyInfo().getUserMail())) {
			return CommonResult.validateFailed("メールアドレスの形式が正しくありません。");
		}
		// メールチェック(会社用)
		if (!CheckUtil.checkEmail(b0002VueForm.getCompanyInfo().getCompanyMail())) {
			return CommonResult.validateFailed("メールアドレスの形式が正しくありません。");
		}
		// 電話番号正確性チェック(会社用)
		if (!CheckUtil.isHalfNumeric(b0002VueForm.getCompanyInfo().getCompanyTel())) {
			return CommonResult.validateFailed("電話番号を半角数字で入力してください。");
		}
		// 電話番号正確性チェック(ユーザー用)
		if (!CheckUtil.isHalfNumeric(b0002VueForm.getCompanyInfo().getUserTel())) {
			return CommonResult.validateFailed("電話番号を半角数字で入力してください。");
		}
		// 「パスワード」と「確認パスワード」一致性チェック
		if (!CheckUtil.checkEqual(b0002VueForm.getCompanyInfo().getPassword(), b0002VueForm.getCompanyInfo().getRepassword())) {
			return CommonResult.validateFailed("パスワードと確認パスワードが一致しません。");
		}
		// 「パスワード」正確性チェック
		if (!CheckUtil.checkPwdFormat(b0002VueForm.getCompanyInfo().getPassword())) {
			return CommonResult.validateFailed("パスワードの形式が正しくありません。");
		}
		
		// 新規登録確認画面編集
		B0002VueForm b0002VueFormOutput=iB0002ServiceImpl.confirmOutput(b0002VueForm);
		
        return CommonResult.success(b0002VueFormOutput);

    }

	/**
	   *  新規会社登録
	 * @param b0002VueForm
	 * @return B0002VueForm
	 */
  @Transactional
  @RequestMapping(value = "/insertCompany", method = RequestMethod.POST)
  public CommonResult<String> insertCompany(@RequestBody B0002VueForm b0002VueForm, BindingResult results) {

	  	CompanyTblEntity companyEntity = new CompanyTblEntity();

	  	Integer companyId = EditUtil.intUtil(b0002VueForm.getCompanyInfo().getCompanyId());
	  	
		if(!"1".equals(b0002VueForm.getCompanyInfo().getPopFlg())) {
			//都道府県を取得
			b0002VueForm.getCompanyInfo().setPrefeNm(iB0002ServiceImpl.getPrefeNm(b0002VueForm.getCompanyInfo().getCompanyPostal()));
			//会社情報編集
			companyEntity = iB0002ServiceImpl.editCompanyInfo(b0002VueForm.getCompanyInfo());
			//会社情報追加
			int count = iB0002ServiceImpl.insertCompanyInfo(companyEntity);
			//取得会社ID
			companyId = companyEntity.getCompanyId();
			if (count != 1) {
				return CommonResult.failed();
			}
		}
		// ユーザ情報編集
		UserTblEntity userEntity = iB0002ServiceImpl.editUserInfo(b0002VueForm.getCompanyInfo(), companyId);
		// ユーザー情報追加
		int count = iB0002ServiceImpl.insertUserInfo(userEntity);
		
		if (count != 1) {
			return CommonResult.failed();
		}
		return CommonResult.success("");

  }
/**
   *  ファイルアップロード
 * @param b0002VueForm
 * @return B0002VueForm
 */
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public @ResponseBody String upload(@RequestParam("file") MultipartFile multipartFile, HttpSession session) throws IOException {

		//ファイル名を設定
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	 	String date = df.format(new Date());
	 	UUID uuid=UUID.randomUUID();
		String path = uploadpath + date + "/" ;
		String fileName = uuid.toString() + "_" + multipartFile.getOriginalFilename();

		File filepath = new File(path);
	    if(!filepath.exists()){  
	     filepath.mkdirs();  
	     }  

	    File file = new File(path, fileName);
		// ファイルを保存
			multipartFile.transferTo(file);
		
		return file.getAbsolutePath().replaceAll("\\\\", "/");

	}

}
