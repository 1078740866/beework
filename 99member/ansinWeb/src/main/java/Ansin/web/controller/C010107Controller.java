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
import Ansin.web.bean.C010101ListBean;
import Ansin.web.bean.ProjectHisTblBean;
import Ansin.web.entity.UserTblEntity;
import Ansin.web.serviceimpl.IC010107ServiceImpl;
import Ansin.web.vueForm.C010107VueForm;

/**
 * C010101履歴書詳細画面07
 * 
 * @author 劉智浩
 *
 */
@RestController
@RequestMapping("/C010107")
public class C010107Controller {

	@Autowired
	private IC010107ServiceImpl c010107Service;

	/**
	 * C0101応募者のプロジェクト履歴を新規
	 * 
	 * @param c010107VueForm
	 * @param session
	 * @param results
	 * @return getApplicantProjectHisList
	 */
	@RequestMapping(value = "/insertProjectHis", method = { RequestMethod.POST })
	public CommonResult<C010101ListBean> c010107insertProjectHis(@RequestBody @Valid C010107VueForm c010107VueForm,
			HttpSession session, BindingResult results) {

		if (results.hasErrors()) {
			return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
		}
		// SESSIONから会社IDとユーザーコードを取得
		UserTblEntity user = (UserTblEntity) session.getAttribute("USERC");
		c010107VueForm.setCompanyId(user.getCompanyId());
		c010107VueForm.setUserCd(user.getUserCd());

		int insertApplicantProjectHis = c010107Service.projectHisInsert(c010107VueForm);

		if (insertApplicantProjectHis == 0) {
			return CommonResult.failed("失敗");
		} else {
			// 出力を取得する
			C010101ListBean c010101ListBean = new C010101ListBean();
			// 応募者プロジェクト履歴を取得する
			List<ProjectHisTblBean> getApplicantProjectHisList = c010107Service.getAll(c010107VueForm.getApplicantId());

			c010101ListBean.setProjectHisTblBean(getApplicantProjectHisList);

			return CommonResult.success(c010101ListBean);
		}
	}

	/**
	 * C0101応募者のプロジェクト履歴を更新
	 * 
	 * @param c010107VueForm
	 * @param session
	 * @param results
	 * @return getApplicantProjectHisList
	 */
	@RequestMapping(value = "/updateProjectHis", method = { RequestMethod.POST })
	public CommonResult<C010101ListBean> c010107updateProjectHis(@RequestBody @Valid C010107VueForm c010107VueForm,
			HttpSession session, BindingResult results) {

		if (results.hasErrors()) {
			return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
		}
		// SESSIONから会社IDとユーザーコードを取得
		UserTblEntity user = (UserTblEntity) session.getAttribute("USERC");
		c010107VueForm.setCompanyId(user.getCompanyId());
		c010107VueForm.setUserCd(user.getUserCd());

		int updateApplicantProjectHis = c010107Service.projectHisUpdate(c010107VueForm);

		if (updateApplicantProjectHis == 0) {
			return CommonResult.failed("失敗");
		} else {
			// 出力を取得する
			C010101ListBean c010101ListBean = new C010101ListBean();
			// 応募者プロジェクト履歴を取得する
			List<ProjectHisTblBean> getApplicantProjectHisList = c010107Service.getAll(c010107VueForm.getApplicantId());

			c010101ListBean.setProjectHisTblBean(getApplicantProjectHisList);

			return CommonResult.success(c010101ListBean);
		}
	}

	/**
	 * C0101応募者のプロジェクト履歴を削除
	 * 
	 * @param applicantId
	 * @param projectId
	 * @param session
	 * @param results
	 * @return c0101001Entity
	 */
	@RequestMapping(value = "/deleteProjectHis", method = { RequestMethod.POST })
	public CommonResult<C010101ListBean> c010107deleteProjectHis(@RequestBody @Valid C010107VueForm c010107VueForm,
			HttpSession session, BindingResult results) {

		if (results.hasErrors()) {
			return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
		}
		// SESSIONから会社IDとユーザーコードを取得
		UserTblEntity user = (UserTblEntity) session.getAttribute("USERC");
		c010107VueForm.setUserCd(user.getUserCd());

		int deleteApplicantProjectHis = c010107Service.projectHisDelete(c010107VueForm.getApplicantId(),
				c010107VueForm.getProjectId(), c010107VueForm.getUserCd());

		if (deleteApplicantProjectHis == 0) {
			return CommonResult.failed("失敗");
		} else {
			// 出力を取得する
			C010101ListBean c010101ListBean = new C010101ListBean();
			// 応募者プロジェクト履歴を取得する
			List<ProjectHisTblBean> getApplicantProjectHisList = c010107Service.getAll(c010107VueForm.getApplicantId());

			c010101ListBean.setProjectHisTblBean(getApplicantProjectHisList);

			return CommonResult.success(c010101ListBean);
		}
	}

}
