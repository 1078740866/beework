package Ansin.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Ansin.web.api.CommonResult;
import Ansin.web.bean.InterviewHisTblBean;
import Ansin.web.entity.UserTblEntity;
import Ansin.web.serviceimpl.IB0401ServiceImpl;
import Ansin.web.vueForm.B0401VueForm;

/**
 * B0401 面接一覧画面Controller
 * 
 * @author コウ テンキ
 * @date 2020-10-19 18:50:10
 */

@RestController
@RequestMapping("/B0401")
public class B0401Controller {

	@Autowired
	private IB0401ServiceImpl b0401Service;

	/**
	 * 初期値またはサーチ結果を表示する
	 * 
	 * @param b0401VueForm
	 * @param session
	 * @param results
	 * @return interviewHisTblBean
	 */

	@PostMapping(value = "/select")
	public CommonResult<List<InterviewHisTblBean>> select(@RequestBody @Valid B0401VueForm b0401VueForm,
			HttpSession session, BindingResult results) {

		if (results.hasErrors()) {
			return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
		}
		// SESSIONから会社IDとユーザーコードを取得
		UserTblEntity user = (UserTblEntity) session.getAttribute("USER");
		b0401VueForm.setCompanyId(user.getCompanyId());
		b0401VueForm.setUserCd(user.getUserCd());

		List<InterviewHisTblBean> interviewHisTblBean = b0401Service.getInterviewHisTblEntityList(b0401VueForm);

		return CommonResult.success(interviewHisTblBean);

	}

	/**
	 * シングルな削除と複数削除
	 * 
	 * @param interviewHisTblEntities
	 * @param session
	 * @param results
	 * @return CommonResult<Integer>
	 */
	@PostMapping(value = "/delete")
	public CommonResult<Integer> delete(@RequestBody @Valid B0401VueForm b0401VueForm, HttpSession session,
			BindingResult results) {

		if (results.hasErrors()) {
			return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
		}
		// SESSIONから会社IDとユーザーコードを取得
		UserTblEntity user = (UserTblEntity) session.getAttribute("USER");
		b0401VueForm.setCompanyId(user.getCompanyId());
		b0401VueForm.setUserCd(user.getUserCd());

		// 更新数
		int count = b0401Service.update(b0401VueForm.getInterviewIds(), b0401VueForm.getCompanyId(), b0401VueForm.getUserCd());

		// 更新数の判断
		if (count != 0) {
			return CommonResult.success(count);
		} else {
			return CommonResult.validateFailed("error");
		}
	}

}
