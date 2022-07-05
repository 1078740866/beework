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
import Ansin.web.bean.ApplicantSkillTblBean;
import Ansin.web.bean.C010101ListBean;
import Ansin.web.entity.UserTblEntity;
import Ansin.web.serviceimpl.IC010103ServiceImpl;
import Ansin.web.util.EditUtil;
import Ansin.web.vueForm.C010103DeleteVueForm;
import Ansin.web.vueForm.C010103VueForm;

/**
 * C010101履歴書詳細画面03
 * 
 * @author 劉智浩
 *
 */
@RestController
@RequestMapping("/C010103")
public class C010103Controller {

	@Autowired
	private IC010103ServiceImpl c010103Service;

	/**
	 * C0101応募者のスキルを新規
	 * 
	 * @param c010103VueForm
	 * @param session
	 * @param results
	 * @return getApplicantSkillList
	 */
	@RequestMapping(value = "/insertSkill", method = { RequestMethod.POST })
	public CommonResult<C010101ListBean> c010103insertSkill(@RequestBody @Valid C010103VueForm c010103VueForm,
			HttpSession session, BindingResult results) {

		if (results.hasErrors()) {
			return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
		}
		// SESSIONから会社IDとユーザーコードを取得
		UserTblEntity user = (UserTblEntity) session.getAttribute("USERC");
		c010103VueForm.setCompanyId(user.getCompanyId());
		c010103VueForm.setUserCd(user.getUserCd());

		int insertApplicantSkill = c010103Service.skillInsert(c010103VueForm);

		if (insertApplicantSkill == 0) {
			return CommonResult.failed("失敗");
		} else {
			// 出力を取得する
			C010101ListBean c010101ListBean = new C010101ListBean();
			// 応募者のスキルを取得する
			List<ApplicantSkillTblBean> getApplicantSkillList = c010103Service
					.getApplicantSkill(c010103VueForm.getApplicantId());

			c010101ListBean.setApplicantSkillTblBean(getApplicantSkillList);

			return CommonResult.success(c010101ListBean);
		}
	}

	/**
	 * C0101応募者のスキルを更新
	 * 
	 * @param c010103VueForm
	 * @param session
	 * @param results
	 * @return getApplicantSkillList
	 */
	@RequestMapping(value = "/updateSkill", method = { RequestMethod.POST })
	public CommonResult<C010101ListBean> c010103updateSkill(@RequestBody @Valid C010103VueForm c010103VueForm,
			HttpSession session, BindingResult results) {

		if (results.hasErrors()) {
			return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
		}
		// SESSIONから会社IDとユーザーコードを取得
		UserTblEntity user = (UserTblEntity) session.getAttribute("USERC");
		c010103VueForm.setCompanyId(user.getCompanyId());
		c010103VueForm.setUserCd(user.getUserCd());

		int updateApplicantSkill = c010103Service.skillUpdate(c010103VueForm);

		if (updateApplicantSkill == 0) {
			return CommonResult.failed("失敗");
		} else {
			// 出力を取得する
			C010101ListBean c010101ListBean = new C010101ListBean();
			// 応募者のスキルを取得する
			List<ApplicantSkillTblBean> getApplicantSkillList = c010103Service
					.getApplicantSkill(c010103VueForm.getApplicantId());

			c010101ListBean.setApplicantSkillTblBean(getApplicantSkillList);

			return CommonResult.success(c010101ListBean);
		}
	}

	/**
	 * C0101応募者のスキルを削除
	 * 
	 * @param applicantId
	 * @param appSkillId
	 * @param session
	 * @param results
	 * @return c0101001Entity
	 */
	@RequestMapping(value = "/deleteSkill", method = { RequestMethod.POST })
	public CommonResult<C010101ListBean> c010103deleteSkill(
			@RequestBody @Valid C010103DeleteVueForm c010103DeleteVueForm, HttpSession session, BindingResult results) {

		if (results.hasErrors()) {
			return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
		}
		// SESSIONから会社IDとユーザーコードを取得
		UserTblEntity user = (UserTblEntity) session.getAttribute("USERC");

		int deleteApplicantSkill = c010103Service.skillDelete(c010103DeleteVueForm.getApplicantId(),
				c010103DeleteVueForm.getAppSkillId(), user.getUserCd());

		if (deleteApplicantSkill == 0) {
			return CommonResult.failed("失敗");
		} else {
			// 出力を取得する
			C010101ListBean c010101ListBean = new C010101ListBean();

			int appId = EditUtil.intUtil(c010103DeleteVueForm.getApplicantId());
			// 応募者のスキルを取得する
			List<ApplicantSkillTblBean> getApplicantSkillList = c010103Service.getApplicantSkill(appId);

			c010101ListBean.setApplicantSkillTblBean(getApplicantSkillList);

			return CommonResult.success(c010101ListBean);
		}
	}

}
