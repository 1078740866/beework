package Ansin.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import Ansin.web.api.CommonResult;
import Ansin.web.bean.AdAddressBean;
import Ansin.web.bean.IndustryMstBean;
import Ansin.web.bean.JobtypeMstBean;
import Ansin.web.bean.SkillMstBean;
import Ansin.web.entity.UserTblEntity;
import Ansin.web.serviceimpl.IB0102ServiceImpl;
import Ansin.web.vueForm.B0102VueForm;

/**
 * B0102_職位詳細情報 positionInfoServiceController
 * 
 * @author コウ テンキ
 * @date 2020-10-29 13:36:23
 */

@RestController
@RequestMapping("/B0102")
public class B0102Controller {

    @Autowired
    private IB0102ServiceImpl b0102Service;
    
    /**
	   *  研修情報を改修する前職種初期表示の内容	
	   *   業種を取得
	 * @return　List<IndustryMstBean>
	 */
	@RequestMapping(value = "/initIndustry", method = {RequestMethod.POST })
	 public CommonResult<List<IndustryMstBean>> IndustrySelect() {
		return CommonResult.success(b0102Service.getIndustryAll());
	}
	
	/**
	   *  研修情報を改修する前業種初期表示の内容	
	   *   業種を取得
	 * @return　List<IndustryMstBean>
	 */
	@RequestMapping(value = "/initJobtype", method = {RequestMethod.POST })
	 public CommonResult<List<JobtypeMstBean>> JobtypeSelect() {
		return CommonResult.success(b0102Service.getJobtypeAll());
	}
	
	/**
	  *  研修情報を改修する前skill初期表示の内容	
	 * skillを取得
	 * @return
	 */
	@RequestMapping(value = "/initSkill", method = {RequestMethod.POST })
	 public CommonResult<List<SkillMstBean>> SkillSelect() {
		return CommonResult.success(b0102Service.getSkillAll());
	}
	
	  /**
     * 都道府県と所属市区町村を取得
	* @param companyPostal
	* @return PrefecturestAndCityBean
	*/
	@RequestMapping(value = "/searchPostal", method = RequestMethod.POST)
	public CommonResult<List<AdAddressBean>> searchPostal(@RequestBody JSONObject Postal, BindingResult results) {

		// 郵便番号取得
		Map<String, Object> jsonToMap =  JSONObject.parseObject(Postal.toJSONString());
		String postal = (String)jsonToMap.get("Postal");

		// 郵便番号通り、会社情報を取得
		List<String> str = b0102Service.getPostaOne(postal);

		// PopList戻り値を取得
		List<AdAddressBean> adAddressBean = new ArrayList<AdAddressBean>();
		if (str != null) {
			BeanUtils.copyProperties(str, adAddressBean);
		}
		return CommonResult.success(adAddressBean);
	}
	
	/**
	 * 
	 * @param b0102VueForm
	 * @param results
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
    public CommonResult<B0102VueForm> registerCompany(@RequestBody @Valid B0102VueForm b0102VueForm, BindingResult results) throws IOException {

		if (results.hasErrors()) {
			return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
		}
		
		// 新規登録確認画面編集
		B0102VueForm b0102VueFormOutput = b0102Service.confirmOutput(b0102VueForm);
		
        return CommonResult.success(b0102VueFormOutput);

    }
	
    /**
     * B0102 職位情報追加
     * 
     * @param b0102VueForm
     * @param session
     * @param results
     * @return 情報追加結果
     */
    @RequestMapping(value = "/addPosition", method = RequestMethod.POST)
    public CommonResult<String> addPosition(@RequestBody @Valid B0102VueForm b0102VueForm, HttpSession session,
            BindingResult results) {

        if (results.hasErrors()) {
            return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
        }
        //SESSIONから会社IDとユーザーコードを取得
      	UserTblEntity user = (UserTblEntity) session.getAttribute("USER");
      	b0102VueForm.setCompanyId(user.getCompanyId());
      	b0102VueForm.setUserCd(user.getUserCd());
      	
		//都道府県を取得
		b0102VueForm.setPrefeNm(b0102Service.getPrefeNm(b0102VueForm.getPostal()));

		// 会社情報追加
		int count = b0102Service.addPosition(b0102VueForm);
		
		if (count != 1) {
			return CommonResult.failed();
		}
		return CommonResult.success("");
    }

    /**
     * B0102 職位更新追加
     * 
     * @param b0102VueForm
     * @param session
     * @param results
     * @return 情報更新結果
     */
    @RequestMapping(value = "/updPosition", method = RequestMethod.POST)
    public CommonResult<String> updPosition(@RequestBody @Valid B0102VueForm b0102VueForm, HttpSession session,
            BindingResult results) {

        if (results.hasErrors()) {
            return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
        }
        //SESSIONから会社IDとユーザーコードを取得
      	UserTblEntity user = (UserTblEntity) session.getAttribute("USER");
      	b0102VueForm.setCompanyId(user.getCompanyId());
      	b0102VueForm.setUserCd(user.getUserCd());
      	
		//都道府県を取得
		b0102VueForm.setPrefeNm(b0102Service.getPrefeNm(b0102VueForm.getPostal()));

		// 会社情報追加
		int count = b0102Service.updPosition(b0102VueForm);
		
		if (count != 1) {
			return CommonResult.failed();
		}
		return CommonResult.success("");
    }

}
