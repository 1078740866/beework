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
import Ansin.web.bean.ApplicantWorkHisTblBean;
import Ansin.web.bean.C010101ListBean;
import Ansin.web.entity.UserTblEntity;
import Ansin.web.serviceimpl.IC010104ServiceImpl;
import Ansin.web.vueForm.C010104VueForm;

/**
 * C010101履歴書詳細画面04
 * 
 * @author 劉智浩
 *
 */
@RestController
@RequestMapping("/C010104")
public class C010104Controller {

	@Autowired
	private IC010104ServiceImpl c010104Service;

	/**
	 * C0101応募者の職歴を新規
	 * 
	 * @param c010104VueForm
	 * @param session
	 * @param results
	 * @return getApplicantWorkHisList
	 */
	@RequestMapping(value = "/insertWorkHis", method = { RequestMethod.POST })
	public CommonResult<C010101ListBean> c010104insertWorkHis(@RequestBody @Valid C010104VueForm c010104VueForm,
			HttpSession session, BindingResult results) {

		if (results.hasErrors()) {
			return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
		}
		// SESSIONから会社IDとユーザーコードを取得
		UserTblEntity user = (UserTblEntity) session.getAttribute("USERC");
		c010104VueForm.setCompanyId(user.getCompanyId());
		c010104VueForm.setUserCd(user.getUserCd());

		int insertApplicantWorkHis = c010104Service.workHisInsert(c010104VueForm);

		if (insertApplicantWorkHis == 0) {
			return CommonResult.failed("失敗");
		} else {
			// 出力を取得する
			C010101ListBean c010101ListBean = new C010101ListBean();
			// 職歴を取得する
			List<ApplicantWorkHisTblBean> getApplicantWorkHisList = c010104Service
					.getApplicantWorkHis(c010104VueForm.getApplicantId());

			c010101ListBean.setApplicantWorkHisTblBean(getApplicantWorkHisList);

			return CommonResult.success(c010101ListBean);
		}
	}

	/**
	 * C0101応募者の職歴を更新
	 * 
	 * @param c010104VueForm
	 * @param session
	 * @param results
	 * @return getApplicantWorkHisList
	 */
	@RequestMapping(value = "/updateWorkHis", method = { RequestMethod.POST })
	public CommonResult<C010101ListBean> c010104updateWorkHis(@RequestBody @Valid C010104VueForm c010104VueForm,
			HttpSession session, BindingResult results) {

		if (results.hasErrors()) {
			return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
		}
		// SESSIONから会社IDとユーザーコードを取得
		UserTblEntity user = (UserTblEntity) session.getAttribute("USERC");
		c010104VueForm.setCompanyId(user.getCompanyId());
		c010104VueForm.setUserCd(user.getUserCd());

		int updateApplicantWorkHis = c010104Service.workHisUpdate(c010104VueForm);

		if (updateApplicantWorkHis == 0) {
			return CommonResult.failed("失敗");
		} else {
			// 出力を取得する
			C010101ListBean c010101ListBean = new C010101ListBean();
			// 職歴を取得する
			List<ApplicantWorkHisTblBean> getApplicantWorkHisList = c010104Service
					.getApplicantWorkHis(c010104VueForm.getApplicantId());

			c010101ListBean.setApplicantWorkHisTblBean(getApplicantWorkHisList);

			return CommonResult.success(c010101ListBean);
		}
	}

	/**
	 * C0101応募者の職歴を削除
	 * 
	 * @param applicantId
	 * @param workHisId
	 * @param session
	 * @param results
	 * @return c0101001Entity
	 */
	@RequestMapping(value = "/deleteWorkHis", method = { RequestMethod.POST })
	public CommonResult<C010101ListBean> c010104deleteWorkHis(@RequestBody @Valid C010104VueForm c010104VueForm,
			HttpSession session, BindingResult results) {

		if (results.hasErrors()) {
			return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
		}
		// SESSIONから会社IDとユーザーコードを取得
		UserTblEntity user = (UserTblEntity) session.getAttribute("USERC");
		c010104VueForm.setUserCd(user.getUserCd());

		int deleteApplicantWorkHis = c010104Service.workHisDelete(c010104VueForm.getApplicantId(),
				c010104VueForm.getWorkHisId(), c010104VueForm.getUserCd());

		if (deleteApplicantWorkHis == 0) {
			return CommonResult.failed("失敗");
		} else {
			// 出力を取得する
			C010101ListBean c010101ListBean = new C010101ListBean();
			// 職歴を取得する
			List<ApplicantWorkHisTblBean> getApplicantWorkHisList = c010104Service
					.getApplicantWorkHis(c010104VueForm.getApplicantId());

			c010101ListBean.setApplicantWorkHisTblBean(getApplicantWorkHisList);

			return CommonResult.success(c010101ListBean);
		}
	}

}
