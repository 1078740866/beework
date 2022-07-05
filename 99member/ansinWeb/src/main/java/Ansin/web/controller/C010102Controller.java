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
import Ansin.web.bean.ApplicantQuaTblBean;
import Ansin.web.bean.C010101ListBean;
import Ansin.web.entity.UserTblEntity;
import Ansin.web.serviceimpl.IC010102ServiceImpl;
import Ansin.web.vueForm.C010102VueForm;

/**
 * C010101履歴書詳細画面02
 * 
 * @author 劉智浩
 *
 */
@RestController
@RequestMapping("/C010102")
public class C010102Controller {

	@Value("${uploadfile.path}")
	private String uploadpath;

	@Autowired
	private IC010102ServiceImpl c010102Service;

	/**
	 * C0101応募者の資格を新規
	 * 
	 * @param c010102VueForm
	 * @param session
	 * @param results
	 * @return getApplicantQuaList
	 */
	@RequestMapping(value = "/insertQua", method = { RequestMethod.POST })
	public CommonResult<C010101ListBean> c010102insertQua(@RequestBody @Valid C010102VueForm c010102VueForm,
			HttpSession session, BindingResult results) {

		if (results.hasErrors()) {
			return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
		}
		// SESSIONから会社IDとユーザーコードを取得
		UserTblEntity user = (UserTblEntity) session.getAttribute("USERC");
		c010102VueForm.setCompanyId(user.getCompanyId());
		c010102VueForm.setUserCd(user.getUserCd());

		int insertApplicantQua = c010102Service.insertQua(c010102VueForm);

		if (insertApplicantQua == 0) {
			return CommonResult.failed("失敗");
		} else {
			// 出力を取得する
			C010101ListBean c010101ListBean = new C010101ListBean();
			// 応募者資格を取得する
			List<ApplicantQuaTblBean> getApplicantQuaList = c010102Service
					.getApplicantQua(c010102VueForm.getApplicantId());

			c010101ListBean.setApplicantQuaTblBean(getApplicantQuaList);

			return CommonResult.success(c010101ListBean);
		}
	}

	/**
	 * C0101応募者の資格を更新
	 * 
	 * @param c010102VueForm
	 * @param session
	 * @param results
	 * @return getApplicantQuaList
	 */
	@RequestMapping(value = "/updateQua", method = { RequestMethod.POST })
	public CommonResult<C010101ListBean> c010102updateQua(@RequestBody @Valid C010102VueForm c010102VueForm,
			HttpSession session, BindingResult results) {

		if (results.hasErrors()) {
			return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
		}
		// SESSIONから会社IDとユーザーコードを取得
		UserTblEntity user = (UserTblEntity) session.getAttribute("USERC");
		c010102VueForm.setCompanyId(user.getCompanyId());
		c010102VueForm.setUserCd(user.getUserCd());

		int updateApplicantQua = c010102Service.updateQua(c010102VueForm);

		if (updateApplicantQua == 0) {
			return CommonResult.failed("失敗");
		} else {
			// 出力を取得する
			C010101ListBean c010101ListBean = new C010101ListBean();
			// 応募者資格を取得する
			List<ApplicantQuaTblBean> getApplicantQuaList = c010102Service
					.getApplicantQua(c010102VueForm.getApplicantId());

			c010101ListBean.setApplicantQuaTblBean(getApplicantQuaList);

			return CommonResult.success(c010101ListBean);
		}
	}

	/**
	 * C0101応募者の資格を削除
	 * 
	 * @param applicantId
	 * @param appQuaId
	 * @param session
	 * @param results
	 * @return c0101001Entity
	 */
	@RequestMapping(value = "/deleteQua", method = { RequestMethod.POST })
	public CommonResult<C010101ListBean> c010102deleteQua(@RequestBody @Valid C010102VueForm vueform,
			HttpSession session, BindingResult results) {

		if (results.hasErrors()) {
			return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
		}

		UserTblEntity user = (UserTblEntity) session.getAttribute("USERC");

		int deleteApplicantQua = c010102Service.deleteQua(vueform.getApplicantId(), vueform.getAppQuaId(),
				user.getUserCd());

		if (deleteApplicantQua == 0) {
			return CommonResult.failed("失敗");
		} else {
			// 出力を取得する
			C010101ListBean c010101ListBean = new C010101ListBean();
			// 応募者資格を取得する
			List<ApplicantQuaTblBean> getApplicantQuaList = c010102Service.getApplicantQua(vueform.getApplicantId());

			c010101ListBean.setApplicantQuaTblBean(getApplicantQuaList);

			return CommonResult.success(c010101ListBean);
		}
	}
}
