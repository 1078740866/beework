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
import Ansin.web.service.B0501Service;
import Ansin.web.serviceimpl.IB0501ServiceImpl;
import Ansin.web.vueForm.B0501VueForm;

/**
 * B0501_研修一覧
 * 
 * @author 刘智浩
 *
 */
@RestController
@RequestMapping("/B0501")
public class B0501Controller {

	@Autowired
//	private IB0501ServiceImpl trainingService;
	private B0501Service trainingService;
	

	/**
	 * 研修会一覧初期方法とボタン押下検索方法
	 * 
	 * @param vueForm
	 * @param session
	 * @param results
	 * @return TrainingInitCountEntity
	 */
	@RequestMapping(value = "/init", method = RequestMethod.POST)
	public CommonResult<B0501ListBean> Init(@RequestBody @Valid B0501VueForm vueForm, HttpSession session,
			BindingResult results) {

		if (results.hasErrors()) {
			return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
		}

		// 業種を取得
		List<IndustryMstBean> industryMstBean = trainingService.getAllIndustry();

		// SESSIONから会社IDを取得
		UserTblEntity user = (UserTblEntity) session.getAttribute("USER");

		vueForm.setCompanyId(user.getCompanyId());
		// SESSIONからユーザーCD取得
		vueForm.setUserCd(user.getUserCd());

		List<TrainingInfoTblBean> trainingInfoTblBean = trainingService.getAllTrainingInitCount(vueForm);

		// 出力を取得
		B0501ListBean trainingInitCountEntity = new B0501ListBean();

		trainingInitCountEntity.setTrainingInfoTblBean(trainingInfoTblBean);

		trainingInitCountEntity.setIndustryMstBean(industryMstBean);

		return CommonResult.success(trainingInitCountEntity);

	}

	/**
	 * 削除方法
	 * 
	 * @param vueForm
	 * @param session
	 * @param results
	 * @return String
	 */
	@RequestMapping(value = "/update", method = { RequestMethod.POST })
	public CommonResult<B0501ListBean> update(@RequestBody @Valid B0501VueForm vueForm, HttpSession session,
			BindingResult results) {

		if (results.hasErrors()) {
			return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
		}

		// SESSIONから会社IDを取得
		//UserTblEntity user = (UserTblEntity) session.getAttribute("USER");
		vueForm.setCompanyId(1);
		// SESSIONからユーザーCD取得
		vueForm.setUserCd(1);

		// 削除
		int trainingUpdate = trainingService.update(vueForm.getTrainingIds(), vueForm.getCompanyId(),
				vueForm.getUserCd());

		if (trainingUpdate == 0) {
			return CommonResult.failed("失敗");
		} else {
			// 出力を取得
			B0501ListBean trainingInitCountEntity = new B0501ListBean();

			// 業種を取得
			List<IndustryMstBean> industryMstBean = trainingService.getAllIndustry();

			List<TrainingInfoTblBean> trainingInfoTblBean = trainingService.getAllTrainingInitCount(vueForm);

			trainingInitCountEntity.setTrainingInfoTblBean(trainingInfoTblBean);

			trainingInitCountEntity.setIndustryMstBean(industryMstBean);

			return CommonResult.success(trainingInitCountEntity);
		}

	}

}
