package Ansin.web.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import Ansin.web.api.CommonResult;
import Ansin.web.bean.A0502ListBean;
import Ansin.web.bean.AdTblBean;
import Ansin.web.bean.B0002PopListBean;
import Ansin.web.bean.CompanyRegisterInitBean;
import Ansin.web.bean.LayoutMstBean;
import Ansin.web.entity.CompanyTblPopEntity;
import Ansin.web.entity.UserTblEntity;
import Ansin.web.serviceimpl.IA0502ServiceImpl;
import Ansin.web.util.EditUtil;
import Ansin.web.vueForm.A0502VueForm;
import Ansin.web.vueForm.B0002PopVueForm;
/**
 * A0502_広告詳細画面
 * @author 楊卿赫
 *
 */
@RestController
@RequestMapping("/A0502")
public class A0502Controller {
	
	@Autowired
	private IA0502ServiceImpl iA0502ServiceImpl;
	
	
	/**
	   *  広告を改修する前レイアウト初期表示の内容	
	   *   レイアウトを取得
	 * @return　List<LayoutMstBean>
	 */
	@RequestMapping(value = "/initLayout", method = {RequestMethod.POST })
	 public CommonResult<List<LayoutMstBean>> LayoutSelect() {
		return CommonResult.success(iA0502ServiceImpl.getLayoutAll());
	}
	/**
	 * 広告詳細初期表示
	 * @param jsonAdId
	 * @return AdTblBean
	 */
	@RequestMapping(value = "/initAd", method = RequestMethod.POST)
	public CommonResult<A0502ListBean> Init(@RequestBody JSONObject jsonAdId) {
		
		// TAB状態取得
		Map<String, Object> jsonToMap =  JSONObject.parseObject(jsonAdId.toJSONString());
		Integer adId = (Integer)jsonToMap.get("adId");
		
		A0502ListBean bean = new A0502ListBean();
		
		//一つ広告詳細情報取得
		bean.setAdTblBean(iA0502ServiceImpl.getOne(adId));
		
		//レイアウトリスト取得
		bean.setLayoutMstBeans(iA0502ServiceImpl.getLayoutAll());
		
		return CommonResult.success(bean);
	}
	
	/**
	 * 広告登録または更新
	 * @param jsonAdId
	 * @return AdTblBean
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public CommonResult<List<AdTblBean>> insert(@RequestBody @Valid A0502VueForm a0502VueForm,HttpSession session,BindingResult results) {
		
		if (results.hasErrors()) {
			return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
		}
		
		//SESSIONから会社IDとユーザーコードを取得
		UserTblEntity user = (UserTblEntity) session.getAttribute("USERA");
		if (user==null) {
			return CommonResult.failed("セッションが切れました。再度ログインしてください。");
		}
		
		a0502VueForm.setUserCd(user.getUserCd());
		
		//AdId != null 更新
		if (a0502VueForm.getAdId() != null) {
			
			int count = iA0502ServiceImpl.update(a0502VueForm);
			
			if (count == 0) {
				return CommonResult.failed("更新失敗");
			}else {
				//一つ広告詳細情報取得
				return CommonResult.success(iA0502ServiceImpl.getAll());
			}
		//AdId = null 登録
		}else {
			int count = iA0502ServiceImpl.insert(a0502VueForm);
			
			if (count == 0) {
				return CommonResult.failed("登録失敗");
			}else {
				//一つ広告詳細情報取得
				return CommonResult.success(iA0502ServiceImpl.getAll());
			}
		}
		
	}
	
	/**
     *自動SHELｌ起動の更新状態
	* @param b0002POPVueForm
	* @param results
	* @return B0002PopListBean
	*/
	@RequestMapping(value = "/selectFlg", method = RequestMethod.POST)
	public CommonResult<String> selectFlg() {
		
		//検索状態更新できるのデータ
		List<Integer> entity = iA0502ServiceImpl.getSelectFlg();
		
		//状態変更
		int count = iA0502ServiceImpl.updateFlg(entity);
		
		return CommonResult.success("更新成功数:" + count);
		
	}
	
	/**
	   *  会社新規登録画面初期表示
	 * @return CompanyRegisterInitResponseEntity
	 */
	@RequestMapping(value = "/init", method = RequestMethod.GET)
  public CommonResult<CompanyRegisterInitBean> Init() {

		// 画面戻り値を取得
		CompanyRegisterInitBean companyRegisterInitBean = iA0502ServiceImpl.getCompanyRegisterInitResponse();

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
		List<CompanyTblPopEntity> companyList = iA0502ServiceImpl.selectCompanyInfo(companyNm, "", null, "",null);

		// PopList戻り値を取得
		B0002PopListBean b0002PopListBean = iA0502ServiceImpl.getPopListInfo(companyList);

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
		List<CompanyTblPopEntity> companyList = iA0502ServiceImpl.selectCompanyInfo(b0002POPVueForm.getCompanyNm(),
				b0002POPVueForm.getAddress1(), EditUtil.intUtil(b0002POPVueForm.getIndustryCd1()), b0002POPVueForm.getCompanyScale(),
				EditUtil.intUtil(b0002POPVueForm.getCountry()));

		// PopList戻り値を取得
		B0002PopListBean b0002PopListBean = iA0502ServiceImpl.getPopListInfo(companyList);

		return CommonResult.success(b0002PopListBean);
	}

}
