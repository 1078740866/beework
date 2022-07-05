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
import Ansin.web.entity.CompanyTblEntity;
import Ansin.web.entity.UserTblEntity;
import Ansin.web.serviceimpl.IA0101ServiceImpl;
import Ansin.web.vueForm.A0101VueForm;

/**
 * A0101 会社一覧画面Controller
 * 
 * @author 王 凱
 * @date 2020-11-15 16:49:51
 */

@RestController
@RequestMapping("/A0101")
public class A0101Controller {

	@Autowired
	private IA0101ServiceImpl a0101Service;

	/**
	 * 初期値またはサーチ結果を表示する
	 * @param b0401VueForm
	 * @param session
	 * @param results
	 * @return interviewHisTblBean
	 */

	@PostMapping(value = "/select")
	public CommonResult< List<CompanyTblEntity>> select(@RequestBody @Valid A0101VueForm a0101VueForm, HttpSession session,
			BindingResult results) {

		if (results.hasErrors()) {
			return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
		}

		//SESSIONから会社IDとユーザーコードを取得
		UserTblEntity user = (UserTblEntity) session.getAttribute("USERA");
		a0101VueForm.setUserCd(user.getUserCd());

		List<CompanyTblEntity> interviewHisTblBean = a0101Service.getCompanyTblEntityList(a0101VueForm);
		return CommonResult.success(interviewHisTblBean);

	}

	/**
	 * 会社削除と複数削除
	 * 
	 * @param a0101VueForm
	 * @param session
	 * @param results
	 * @return CommonResult<Integer>
	 */
	@PostMapping(value = "/delete")
	public CommonResult<Integer> delete(
			@RequestBody @Valid A0101VueForm a0101VueForm,
			HttpSession session,
			BindingResult results) {

		if (results.hasErrors()) {
			return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
		}

		//SESSIONから会社IDとユーザーコードを取得
		UserTblEntity user = (UserTblEntity) session.getAttribute("USERA");
		a0101VueForm.setUserCd(user.getUserCd());

		// 更新数
		int count = a0101Service.update(
				a0101VueForm.getCompanyIdList(),
				a0101VueForm.getCompanyId(),
				a0101VueForm.getUserCd());

		// 更新数の判断
		if (count != 0) {
			return CommonResult.success(count);
		} else {
			return CommonResult.validateFailed("error");
		}
	}

}
