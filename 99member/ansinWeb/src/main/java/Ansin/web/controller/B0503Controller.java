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
import Ansin.web.bean.TrainingApplTblBean;
import Ansin.web.entity.UserTblEntity;
import Ansin.web.serviceimpl.IB0503ServiceImpl;
import Ansin.web.vueForm.B0503VueForm;
/**
 * B0503_研修応募者管理
 * @author 劉智浩
 *
 */
@RestController
@RequestMapping("/B0503")
public class B0503Controller {
	@Autowired
	private IB0503ServiceImpl b0503Service;
	/**
	 * 研修応募者一覧初期方法と名前入力検索方法
	 * @param trainingApplTblEntity
	 * @param session
	 * @param results
	 * @return
	 */
	@RequestMapping(value = "/init", method = RequestMethod.POST)
    public CommonResult<List<TrainingApplTblBean>> Init(@RequestBody @Valid B0503VueForm b0503VueForm,HttpSession session,BindingResult results) {
		
		if (results.hasErrors()) {
			return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
		}
		
		// SESSIONから会社IDを取得
		UserTblEntity user = (UserTblEntity) session.getAttribute("USER");
		b0503VueForm.setCompanyId(user.getCompanyId());
        // SESSIONからユーザーCD取得
		b0503VueForm.setUserCd(user.getUserCd());
		
		//LIST取得
		List<TrainingApplTblBean> trainingApplTblBean = b0503Service.getTrainingAppl(b0503VueForm);
		
		return CommonResult.success(trainingApplTblBean);
		
    }
	
	/**
	 * 研修応募者を受け取れ方法
	 * @param trainingApplTblEntity
	 * @param session
	 * @param results
	 * @return
	 */
	@RequestMapping(value = "/changeStatus", method = {RequestMethod.POST })
	 public CommonResult<List<TrainingApplTblBean>> b0503update(@RequestBody @Valid B0503VueForm b0503VueForm,HttpSession session,BindingResult results) {
		
		if (results.hasErrors()) {
			return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
		}
		
		// SESSIONから会社IDを取得
		UserTblEntity user = (UserTblEntity) session.getAttribute("USER");
		b0503VueForm.setCompanyId(user.getCompanyId());
        // SESSIONからユーザーCD取得
		b0503VueForm.setUserCd(user.getUserCd());
		
		// 受け取れまたは拒否
		int applConfirmUpdate = b0503Service.applUpdateConfirmOrDeny(b0503VueForm);
		
		//成功するかどうか判断します
		if (applConfirmUpdate == 0 ) {
			return CommonResult.failed("失敗");
		}else {
			List<TrainingApplTblBean> trainingApplTblBean = b0503Service.getTrainingAppl(b0503VueForm);
			
			return CommonResult.success(trainingApplTblBean);
		}     
	}
	
}
