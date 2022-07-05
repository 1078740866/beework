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
import Ansin.web.bean.A070104ListBean;
import Ansin.web.bean.IndustryMstBean;
import Ansin.web.bean.PrefecturesMstBean;
import Ansin.web.bean.TrainingInfoTblBean;
import Ansin.web.entity.UserTblEntity;
import Ansin.web.serviceimpl.IA070104ServiceImpl;
import Ansin.web.vueForm.A070104VueForm;
/**
 * A0701_04_承認一覧画面(研修会)
 * @author 劉智浩
 *
 */
@RestController
@RequestMapping("/A070104")
public class A070104Controller {
		
	@Autowired
    private IA070104ServiceImpl a070104Service;
	
	int trainingConfirmOrDeny;
	
	/**
	 * A0701_04_承認一覧画面(研修会)一覧リスト
	 * @param a070104VueForm
	 * @param session
	 * @param results
	 * @return
	 */
	@RequestMapping(value = "/init", method = RequestMethod.POST)
    public CommonResult<A070104ListBean> Init(@RequestBody @Valid A070104VueForm a070104VueForm,HttpSession session,BindingResult results) {
		
		if (results.hasErrors()) {
			return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
		}
		
		// 業種を取得
		List<IndustryMstBean> industryMstBean = a070104Service.getAllIndustry();
		
		//都道府県を取得
		List<PrefecturesMstBean> prefecturesMstBean = a070104Service.getAllPrefe();
		
		//研修リスト取得
		List<TrainingInfoTblBean> trainingInfoTblBean = a070104Service.getTra(a070104VueForm);
		
		A070104ListBean bean = new A070104ListBean();
		
		bean.setIndustryMstBean(industryMstBean);
		
		bean.setPrefecturesMstBean(prefecturesMstBean);
		
		bean.setTrainingInfoTblBean(trainingInfoTblBean);
		
		return CommonResult.success(bean);
		
    }
	
	/**
	 * A0701_04_承認一覧画面(研修会)単数または複数承認、拒否
	 * @param a070104VueForm
	 * @param session
	 * @param results
	 * @return
	 */
	@RequestMapping(value = "/trainingConfirmOrDeny", method = {RequestMethod.POST })
	 public CommonResult<A070104ListBean> trainingConfirmOrDeny(@RequestBody @Valid A070104VueForm a070104VueForm,HttpSession session,BindingResult results) {
		
		if (results.hasErrors()) {
			return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
		}
		
		UserTblEntity user = (UserTblEntity) session.getAttribute("USERA");
		
		if (a070104VueForm.getListData() != null && a070104VueForm.getListData().size() != 0) {
			// 研修会単数または複数承認、拒否
			trainingConfirmOrDeny = a070104Service.trainingConfirmOrDeny(a070104VueForm.getListData(), user.getUserCd(),a070104VueForm.getStatusFlg());
		}else {
			
		}
		//成功するかどうか判断します
		if (trainingConfirmOrDeny == 0 ) {
			return CommonResult.failed("失敗");
		}else {
			
			A070104VueForm a070104VueForm1 = new A070104VueForm();
			
			// 業種を取得
			List<IndustryMstBean> industryMstBean = a070104Service.getAllIndustry();
			
			//都道府県を取得
			List<PrefecturesMstBean> prefecturesMstBean = a070104Service.getAllPrefe();
			
			//研修リスト取得
			List<TrainingInfoTblBean> trainingInfoTblBean = a070104Service.getTra(a070104VueForm1);
			
			A070104ListBean bean = new A070104ListBean();
			
			bean.setIndustryMstBean(industryMstBean);
			
			bean.setPrefecturesMstBean(prefecturesMstBean);
			
			bean.setTrainingInfoTblBean(trainingInfoTblBean);
			
			return CommonResult.success(bean);
		}     
	}
	
}
