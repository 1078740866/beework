package Ansin.web.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Ansin.web.api.CommonResult;
import Ansin.web.bean.A070102ListBean;
import Ansin.web.entity.UserTblEntity;
import Ansin.web.serviceimpl.IA070102ServiceImpl;
import Ansin.web.vueForm.A070102VueForm;
/**
 * A0701_02_承認一覧画面(会社)
 * @author 劉智浩
 *
 */
@RestController
@RequestMapping("/A070102")
public class A070102Controller {

	
	@Autowired
    private IA070102ServiceImpl a070102Service;
	
	int updateUserStatus;
		
	/**
	 * A0701_02_承認一覧画面(会社)一覧リスト
	 * @param a070102VueForm
	 * @param session
	 * @param results
	 * @return A070102ListBean
	 */
	@RequestMapping(value = "/init", method = RequestMethod.POST)
    public CommonResult<A070102ListBean> Init(@RequestBody @Valid A070102VueForm a070102VueForm,HttpSession session,BindingResult results) {
		
		if (results.hasErrors()) {
			return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
		}
		
		A070102ListBean bean = new A070102ListBean();
		
		//都道府県リスト初期取得
		bean.setPrefecturesMstBean(a070102Service.getPrefecturesMst());
		
		//業種初期リスト取得
		bean.setIndustryMstBean(a070102Service.getIndustryMst());
		
		//会社LIST取得
		bean.setCompanyListBean(a070102Service.getCompanyInfo(a070102VueForm));
		
		return CommonResult.success(bean);
		
    }
	
	/**
	 * A0701_02_承認一覧画面(会社)単数または複数承認、拒否
	 * @param a070102VueForm
	 * @param session
	 * @param results
	 * @return
	 */
	@RequestMapping(value = "/companyConfirmOrDeny", method = {RequestMethod.POST })
	 public CommonResult<A070102ListBean> companyConfirmOrDeny(@RequestBody @Valid A070102VueForm a070102VueForm,HttpSession session,BindingResult results) {
		
		if (results.hasErrors()) {
			return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
		}
		
		UserTblEntity user = (UserTblEntity) session.getAttribute("USERA");
		
		// 会社単数または複数承認
		int companyConfirmOrDeny = a070102Service.companyConfirmOrDeny(a070102VueForm.getCompanyIds(), user.getUserCd(), a070102VueForm.getStatusFlg());
		
		//成功するかどうか判断します
		if (companyConfirmOrDeny == 0 ) {
			return CommonResult.failed("失敗");
		}else {
				A070102ListBean bean = new A070102ListBean();
				
				//都道府県リスト初期取得
				bean.setPrefecturesMstBean(a070102Service.getPrefecturesMst());
				
				//業種初期リスト取得
				bean.setIndustryMstBean(a070102Service.getIndustryMst());
				
				//会社LIST取得
				bean.setCompanyListBean(a070102Service.getCompanyInfo(a070102VueForm));
				
				return CommonResult.success(bean);
		}       
	}
	
}
