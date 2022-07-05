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
import Ansin.web.serviceimpl.IA0002ServiceImpl;
import Ansin.web.util.CheckUtil;
import Ansin.web.vueForm.A0002VueForm;
/**
 * A0002_システム管理者新規登録画面
 * @author 楊卿赫
 *
 */
@RestController
@RequestMapping("/A0002")
public class A0002Controller {
	
	@Autowired
	private IA0002ServiceImpl a0002Service;
	
	/**
	 * 新規システム管理者確認
	 * @param a0002VueForm
	 * @param session
	 * @param results
	 * @return a0002VueForm
	 */
	 @RequestMapping(value = "/userConf", method = RequestMethod.POST)
	    public CommonResult<A0002VueForm> userConf(@RequestBody @Valid A0002VueForm a0002VueForm, HttpSession session,BindingResult results) {

			if (results.hasErrors()) {
				return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
			}

			/********************
			  **  必須入力チェック ** 
			 ********************/
			// メール
			if ((a0002VueForm.getUserMail()).equals("")) {
				return CommonResult.validateFailed("メールアドレスを入力してください。");
			}
			// パスワード
			if ((a0002VueForm.getPwd()).equals("")) {
				return CommonResult.validateFailed("パスワードを入力してください。");
			}
			// パスワード確認
			if ((a0002VueForm.getRepwd()).equals("")) {
				return CommonResult.validateFailed("パスワード確認を入力してください。");
			}
			// 姓
			if ((a0002VueForm.getFirstName()).equals("")) {
				return CommonResult.validateFailed("姓を入力してください。");
			}
			// 姓（カナ）
			if ((a0002VueForm.getFirstNameKana()).equals("")) {
				return CommonResult.validateFailed("姓（カナ）を入力してください。");
			}
			// 名
			if ((a0002VueForm.getLastName()).equals("")) {
				return CommonResult.validateFailed("名を入力してください。");
			}
			// 名（カナ）
			if ((a0002VueForm.getLastNameKana()).equals("")) {
				return CommonResult.validateFailed("名（カナ）を入力してください。");
			}
			// 電話番号
			if ((a0002VueForm.getUserTel()).equals("")) {
				return CommonResult.validateFailed("電話番号を入力してください。");
			}
			// 写真
			if ((a0002VueForm.getPhotoAddress()).equals("")) {
				return CommonResult.validateFailed("写真を登録してください。");
			}

			/********************
			  **  形式チェック         ** 
			 ********************/
			// メール格式チェック(システム管理者用)
			if (!CheckUtil.checkEmail(a0002VueForm.getUserMail())) {
				return CommonResult.validateFailed("メールアドレスの形式が正しくありません。");
			}
			// メール存在チェック(システム管理者用)
			if (a0002Service.checkEmail(a0002VueForm.getUserMail()) != 0) {
				return CommonResult.validateFailed("メールアドレスが既に存在します。");
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
			UserTblEntity userEntity = a0002Service.editUserInfo(a0002VueForm);
			// ユーザー情報追加
			int count = a0002Service.insertUserInfo(userEntity);
			
			if (count != 1) {
				return CommonResult.failed();
			}
			return CommonResult.success("成功");
			
	    }
	 
}
