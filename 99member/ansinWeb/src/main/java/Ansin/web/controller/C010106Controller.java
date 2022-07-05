package Ansin.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Ansin.web.api.CommonResult;
import Ansin.web.bean.ApplicantEduTblBean;
import Ansin.web.bean.C010101ListBean;
import Ansin.web.entity.UserTblEntity;
import Ansin.web.serviceimpl.IC010106ServiceImpl;
import Ansin.web.vueForm.C010106VueForm;

/**
 * C010101履歴書詳細画面06
 * 
 * @author 劉智浩
 *
 */
@RestController
@RequestMapping("/C010106")
public class C010106Controller {

	@Value("${uploadfile.path}")
	private String uploadpath;

	@Autowired
	private IC010106ServiceImpl c010106Service;

	/**
	 * C0101応募者の学歴を新規
	 * 
	 * @param c010106VueForm
	 * @param session
	 * @param results
	 * @return getApplicantEduList
	 */
	@RequestMapping(value = "/insertEdu", method = { RequestMethod.POST })
	public CommonResult<C010101ListBean> c010106insertEdu(@RequestBody @Valid C010106VueForm c010106VueForm,
			HttpSession session, BindingResult results) {

		if (results.hasErrors()) {
			return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
		}
		// SESSIONから会社IDとユーザーコードを取得
		UserTblEntity user = (UserTblEntity) session.getAttribute("USERC");
		c010106VueForm.setCompanyId(user.getCompanyId());
		c010106VueForm.setUserCd(user.getUserCd());

		int insertApplicantEdu = c010106Service.eduInsert(c010106VueForm);

		if (insertApplicantEdu == 0) {
			return CommonResult.failed("失敗");
		} else {
			// 出力を取得する
			C010101ListBean c010101ListBean = new C010101ListBean();
			// 応募者学歴を取得する
			List<ApplicantEduTblBean> getApplicantEduList = c010106Service.getEdu(c010106VueForm.getApplicantId());

			c010101ListBean.setApplicantEduTblBean(getApplicantEduList);

			return CommonResult.success(c010101ListBean);
		}
	}

	/**
	 * C0101応募者の学歴を更新
	 * 
	 * @param c010106VueForm
	 * @param session
	 * @param results
	 * @return getApplicantEduList
	 */
	@RequestMapping(value = "/updateEdu", method = { RequestMethod.POST })
	public CommonResult<C010101ListBean> c010106updateEdu(@RequestBody @Valid C010106VueForm c010106VueForm,
			HttpSession session, BindingResult results) {

		if (results.hasErrors()) {
			return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
		}
		// SESSIONから会社IDとユーザーコードを取得
		UserTblEntity user = (UserTblEntity) session.getAttribute("USERC");
		c010106VueForm.setCompanyId(user.getCompanyId());
		c010106VueForm.setUserCd(user.getUserCd());

		int updateApplicantEdu = c010106Service.eduUpdate(c010106VueForm);

		if (updateApplicantEdu == 0) {
			return CommonResult.failed("失敗");
		} else {
			// 出力を取得する
			C010101ListBean c010101ListBean = new C010101ListBean();
			// 応募者学歴を取得する
			List<ApplicantEduTblBean> getApplicantEduList = c010106Service.getEdu(c010106VueForm.getApplicantId());

			c010101ListBean.setApplicantEduTblBean(getApplicantEduList);

			return CommonResult.success(c010101ListBean);
		}
	}

	/**
	 * C0101応募者の学歴を削除
	 * 
	 * @param applicantId
	 * @param educationId
	 * @param session
	 * @param results
	 * @return c0101001Entity
	 */
	@RequestMapping(value = "/deleteEdu", method = { RequestMethod.POST })
	public CommonResult<C010101ListBean> c010106deleteEdu(@RequestBody @Valid C010106VueForm c010106VueForm,
			HttpSession session, BindingResult results) {

		if (results.hasErrors()) {
			return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
		}
		// SESSIONから会社IDとユーザーコードを取得
		UserTblEntity user = (UserTblEntity) session.getAttribute("USERC");
		c010106VueForm.setUserCd(user.getUserCd());

		int deleteApplicantEdu = c010106Service.eduDelete(c010106VueForm.getApplicantId(),
				c010106VueForm.getEducationId(), c010106VueForm.getUserCd());

		if (deleteApplicantEdu == 0) {
			return CommonResult.failed("失敗");
		} else {
			// 出力を取得する
			C010101ListBean c010101ListBean = new C010101ListBean();
			// 応募者学歴を取得する
			List<ApplicantEduTblBean> getApplicantEduList = c010106Service.getEdu(c010106VueForm.getApplicantId());

			c010101ListBean.setApplicantEduTblBean(getApplicantEduList);

			return CommonResult.success(c010101ListBean);
		}
	}

}
