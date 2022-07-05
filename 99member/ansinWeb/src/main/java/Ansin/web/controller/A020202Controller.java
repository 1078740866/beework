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
import Ansin.web.bean.B0501ListBean;
import Ansin.web.bean.IndustryMstBean;
import Ansin.web.bean.TrainingInfoTblBean;
import Ansin.web.entity.UserTblEntity;
import Ansin.web.serviceimpl.IA020202ServiceImpl;
import Ansin.web.vueForm.A020202VueForm;

/**
 * A020202_応募者研修一覧
 * @author 楊卿赫
 *
 */
@RestController
@RequestMapping("/A020202")
public class A020202Controller {
	
	@Autowired
    private IA020202ServiceImpl iA020202ServiceImpl;
	
	/**
	 * 研修会一覧初期方法とボタン押下検索方法
	 * @param vueForm
	 * @param session
	 * @param results
	 * @return TrainingInitCountEntity
	 */
	@RequestMapping(value = "/init", method = RequestMethod.POST)
    public CommonResult<B0501ListBean> Init(@RequestBody @Valid A020202VueForm vueForm,HttpSession session,BindingResult results) {
		
		if (results.hasErrors()) {
			return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
		}
		
		// 業種を取得
		List<IndustryMstBean> industryMstBean =  iA020202ServiceImpl.getAllIndustry();
		//研修リスト取得
		List<TrainingInfoTblBean> trainingInfoTblBean = iA020202ServiceImpl.getAllTrainingInitCount(vueForm);
		
		// 出力を取得
		B0501ListBean trainingInitCountEntity = new B0501ListBean();
		
		trainingInitCountEntity.setTrainingInfoTblBean(trainingInfoTblBean);
		
		trainingInitCountEntity.setIndustryMstBean(industryMstBean);
		
		return CommonResult.success(trainingInitCountEntity);
		
    }
	
	/**
	   *  削除方法
	 * @param vueForm
	 * @param session
	 * @param results
	 * @return String
	 */
	@RequestMapping(value = "/update", method = {RequestMethod.POST })
	 public CommonResult<B0501ListBean> update(@RequestBody @Valid A020202VueForm vueForm,HttpSession session,BindingResult results) {
		
		if (results.hasErrors()) {
			return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
		}
		
		// SESSIONから会社IDを取得
		UserTblEntity user = (UserTblEntity) session.getAttribute("USERA");
        // SESSIONからユーザーCD取得
		vueForm.setUserCd(user.getUserCd());
		
		// 削除
		int trainingUpdate = iA020202ServiceImpl.update(vueForm.getTrainingIds(),vueForm.getUserCd(),vueForm.getApplicantId());
		
		if (trainingUpdate == 0 ) {
			return CommonResult.failed("失敗");
		}else {
			// 出力を取得
			B0501ListBean trainingInitCountEntity = new B0501ListBean();
			
			A020202VueForm vueForm1 = new A020202VueForm();
			
			// 業種を取得
			List<IndustryMstBean> industryMstBean =  iA020202ServiceImpl.getAllIndustry();
			
			List<TrainingInfoTblBean> trainingInfoTblBean = iA020202ServiceImpl.getAllTrainingInitCount(vueForm1);
			
			trainingInitCountEntity.setTrainingInfoTblBean(trainingInfoTblBean);
			
			trainingInitCountEntity.setIndustryMstBean(industryMstBean);
			
			return CommonResult.success(trainingInitCountEntity);
		}
     
	}
	

}
	 

