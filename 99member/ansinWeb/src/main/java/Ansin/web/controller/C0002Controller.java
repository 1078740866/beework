package Ansin.web.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Ansin.web.api.CommonResult;
import Ansin.web.entity.UserTblEntity;
import Ansin.web.serviceimpl.IC0002ServiceImpl;
import Ansin.web.util.CheckUtil;
import Ansin.web.vueForm.A0002VueForm;
/**
 * C0002_応募者新規登録画面
 * @author 劉智浩
 *
 */
@RestController
@RequestMapping("/C0002")
public class C0002Controller {
	
	@Autowired
	private IC0002ServiceImpl c0002Service;
	
	/**
	 * ユーザー確認
	 * @param c0002VueForm
	 * @param session
	 * @param results
	 * @return C0002VueForm
	 */
	 @RequestMapping(value = "/userConf", method = RequestMethod.POST)
	    public CommonResult<A0002VueForm> userConf(@RequestBody @Valid A0002VueForm a0002VueForm, HttpSession session,BindingResult results) {

			if (results.hasErrors()) {
				return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
			}

			// メール存在チェック(ユーザー用)
			if (c0002Service.checkEmail(a0002VueForm.getUserMail()) != 0) {
				return CommonResult.validateFailed("メールアドレスが既に存在します。");
			}
			// メール格式チェック(ユーザー用)
			if (!CheckUtil.checkEmail(a0002VueForm.getUserMail())) {
				return CommonResult.validateFailed("メールアドレスの形式が正しくありません。");
			}
			// 電話番号正確性チェック
			if (!CheckUtil.isHalfNumeric(a0002VueForm.getUserTel())) {
				return CommonResult.validateFailed("電話番号を半角数字で入力してください。");
			}
			// 「パスワード」と「確認パスワード」一致性チェック
			if (!CheckUtil.checkEqual(a0002VueForm.getPwd(), a0002VueForm.getRepwd())) {
				return CommonResult.validateFailed("パスワードと確認パスワードが一致しません。");
			}
			// 「パスワード」正確性チェック
			if (!CheckUtil.checkPwdFormat(a0002VueForm.getPwd())) {
				return CommonResult.validateFailed("パスワードの形式が正しくありません。");
			}
			
			return CommonResult.success(a0002VueForm);
			
	    }
	 
	 /**
		 * ユーザー新規登録
		 * @param c0002VueForm
		 * @param session
		 * @param results
		 * @return String
		 */
	 @RequestMapping(value = "/userInsert", method = RequestMethod.POST)
	    public CommonResult<String> userInsert(@RequestBody @Valid A0002VueForm a0002VueForm, HttpSession session,BindingResult results) {

			if (results.hasErrors()) {
				return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
			}
			// ユーザ情報編集
			UserTblEntity userEntity = c0002Service.editUserInfo(a0002VueForm);
			// ユーザー情報追加
			int count = c0002Service.insertUserInfo(userEntity);
			
			if (count != 1) {
				return CommonResult.failed();
			}
			return CommonResult.success("");
			
	    }
	 
}
