package Ansin.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Ansin.web.api.CommonResult;
import Ansin.web.bean.ApplicantLanTblBean;
import Ansin.web.bean.C010101ListBean;
import Ansin.web.bean.C010105DeleteBean;
import Ansin.web.entity.UserTblEntity;
import Ansin.web.serviceimpl.IC010105ServiceImpl;
import Ansin.web.vueForm.C010105VueForm;

/**
 * C010101履歴書詳細画面05
 * 
 * @author 劉智浩
 *
 */
@RestController
@RequestMapping("/C010105")
public class C010105Controller {

	@Autowired
	private IC010105ServiceImpl c010105Service;

	/**
	 * C0101応募者の言語を新規
	 * 
	 * @param c010105VueForm
	 * @param session
	 * @param results
	 * @return getApplicantLanList
	 */
	@RequestMapping(value = "/insertLan", method = { RequestMethod.POST })
	public CommonResult<C010101ListBean> c010105insertLan(@RequestBody @Valid C010105VueForm c010105VueForm,
			HttpSession session, BindingResult results) {

		if (results.hasErrors()) {
			return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
		}
		// SESSIONから会社IDとユーザーコードを取得
		UserTblEntity user = (UserTblEntity) session.getAttribute("USERC");
		c010105VueForm.setCompanyId(user.getCompanyId());
		c010105VueForm.setUserCd(user.getUserCd());

		int insertApplicantLan = c010105Service.lanInsert(c010105VueForm);

		if (insertApplicantLan == 0) {
			return CommonResult.failed("失敗");
		} else {
			// 出力を取得する
			C010101ListBean c010101ListBean = new C010101ListBean();
			// 応募者言語を取得する
			List<ApplicantLanTblBean> getApplicantLanList = c010105Service.getAll(c010105VueForm.getApplicantId());

			c010101ListBean.setApplicantLanTblBean(getApplicantLanList);

			return CommonResult.success(c010101ListBean);
		}
	}

	/**
	 * C0101応募者の言語を更新
	 * 
	 * @param c010105VueForm
	 * @param session
	 * @param results
	 * @return getApplicantLanList
	 */
	@RequestMapping(value = "/updateLan", method = { RequestMethod.POST })
	public CommonResult<C010101ListBean> c010105updateLan(@RequestBody @Valid C010105VueForm c010105VueForm,
			HttpSession session, BindingResult results) {

		if (results.hasErrors()) {
			return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
		}
		// SESSIONから会社IDとユーザーコードを取得
		UserTblEntity user = (UserTblEntity) session.getAttribute("USERC");
		c010105VueForm.setCompanyId(user.getCompanyId());
		c010105VueForm.setUserCd(user.getUserCd());

		int updateApplicantLan = c010105Service.lanUpdate(c010105VueForm);

		if (updateApplicantLan == 0) {
			return CommonResult.failed("失敗");
		} else {
			// 出力を取得する
			C010101ListBean c010101ListBean = new C010101ListBean();
			// 応募者言語を取得する
			List<ApplicantLanTblBean> getApplicantLanList = c010105Service.getAll(c010105VueForm.getApplicantId());

			c010101ListBean.setApplicantLanTblBean(getApplicantLanList);

			return CommonResult.success(c010101ListBean);
		}
	}

	/**
	 * C0101応募者の言語を削除
	 * 
	 * @param applicantId
	 * @param languageId
	 * @param session
	 * @param results
	 * @return c0101001Entity
	 */
	@PostMapping(value = "/deleteLan")
	public CommonResult<C010101ListBean> c010105deleteLan(@RequestBody @Valid C010105DeleteBean c010105DeleteBean,
			HttpSession session, BindingResult results) {

		Integer applicantInteger = Integer.parseInt(c010105DeleteBean.getApplicantId());
		Integer languageInteger = Integer.parseInt(c010105DeleteBean.getLanguageId());

		if (results.hasErrors()) {
			return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
		}
		// SESSIONから会社IDとユーザーコードを取得
		UserTblEntity user = (UserTblEntity) session.getAttribute("USERC");

		int deleteApplicantLan = c010105Service.lanDelete(applicantInteger, languageInteger, user.getUserCd());

		if (deleteApplicantLan == 0) {
			return CommonResult.failed("失敗");
		} else {
			// 出力を取得する
			C010101ListBean c010101ListBean = new C010101ListBean();
			// 応募者言語を取得する
			List<ApplicantLanTblBean> getApplicantLanList = c010105Service.getAll(applicantInteger);

			c010101ListBean.setApplicantLanTblBean(getApplicantLanList);

			return CommonResult.success(c010101ListBean);
		}
	}

}
