package Ansin.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Ansin.web.api.CommonResult;
import Ansin.web.bean.A070105ListBean;
import Ansin.web.bean.BriefingInfoTblBean;
import Ansin.web.bean.PrefecturesMstBean;
import Ansin.web.entity.UserTblEntity;
import Ansin.web.serviceimpl.IA070105ServiceImpl;
import Ansin.web.vueForm.A070105VueForm;
/**
 * A0701_05_承認一覧画面(説明会)
 * @author 劉智浩
 *
 */
@RestController
@RequestMapping("/A070105")
public class A070105Controller {
	
	@Autowired
    private IA070105ServiceImpl a070105Service;
	
	int briefingConfirmOrDeny;
	
	/**
	 * A0701_05_承認一覧画面(説明会)一覧リスト
	 * @param a070105VueForm
	 * @param session
	 * @param results
	 * @return
	 */
	@RequestMapping(value = "/init", method = RequestMethod.POST)
    public CommonResult<A070105ListBean> Init(@RequestBody @Valid A070105VueForm a070105VueForm,HttpSession session,BindingResult results) {
		
		if (results.hasErrors()) {
			return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
		}
		
		//LIST取得
		List<BriefingInfoTblBean> briefingInfoTblBean = a070105Service.getBrie(a070105VueForm);
		
		//都道府県を取得
		List<PrefecturesMstBean> prefecturesMstBean = a070105Service.getAllPrefe();
		
		A070105ListBean bean = new A070105ListBean();
		
		bean.setPrefecturesMstBean(prefecturesMstBean);
		
		bean.setBriefingInfoTblBean(briefingInfoTblBean);
		
		return CommonResult.success(bean);
		
    }
	
	/**
	 * A0701_05_承認一覧画面(説明会)単数または複数承認、拒否
	 * @param a070105VueForm
	 * @param session
	 * @param results
	 * @return
	 */
	@RequestMapping(value = "/briefingConfirmOrDeny", method = {RequestMethod.POST })
	 public CommonResult<A070105ListBean> briefingConfirmOrDeny(@RequestBody @Valid A070105VueForm a070105VueForm,HttpSession session,BindingResult results) {
		
		if (results.hasErrors()) {
			return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
		}
		
		UserTblEntity user = (UserTblEntity) session.getAttribute("USERA");
		
		if (a070105VueForm.getListData() != null && a070105VueForm.getListData().size() != 0) {
			// 説明会単数または複数承認、拒否
			briefingConfirmOrDeny = a070105Service.briefingConfirmOrDeny(a070105VueForm.getListData(), user.getUserCd(), a070105VueForm.getStatusFlg());
		}else {
			
		}
		
		//成功するかどうか判断します
		if (briefingConfirmOrDeny == 0 ) {
			return CommonResult.failed("失敗");
		}else {
			A070105VueForm a070105VueForm1 = new A070105VueForm();
			
			//LIST取得
			List<BriefingInfoTblBean> briefingInfoTblBean = a070105Service.getBrie(a070105VueForm1);
			
			//都道府県を取得
			List<PrefecturesMstBean> prefecturesMstBean = a070105Service.getAllPrefe();
			
			A070105ListBean bean = new A070105ListBean();

			bean.setPrefecturesMstBean(prefecturesMstBean);
			
			bean.setBriefingInfoTblBean(briefingInfoTblBean);
			
			return CommonResult.success(bean);
		}     
	}

}
