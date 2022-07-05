package Ansin.web.controller;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Ansin.web.api.CommonResult;
import Ansin.web.bean.LoginBean;
import Ansin.web.entity.UserTblEntity;
import Ansin.web.serviceimpl.IB0001ServiceImpl;
import Ansin.web.serviceimpl.IMailServiceImpl;
import Ansin.web.serviceimpl.IUserServiceImpl;
import Ansin.web.util.CheckUtil;
import Ansin.web.util.MD5Util;
import Ansin.web.vueForm.A0001VueForm;
import Ansin.web.vueForm.B0004VueForm;
/**
 * B0004_パスワードリセット
 * @author yyj
 *
 */
@RestController
@RequestMapping("/B0004")
public class B0004Controller {

	@Autowired
	private IB0001ServiceImpl b0001Service;

	@Autowired
	private IMailServiceImpl mailService;

	@Autowired
	private IUserServiceImpl userService;

	/**
	   *  メールチェック
	 * @param user
	 * @param results
	 * @param request
	 * @return String
	 */
	@RequestMapping(value = "/checkMail", method = RequestMethod.POST)
	public CommonResult<LoginBean> checkMail(@RequestBody @Valid A0001VueForm a0001VueForm, BindingResult results, HttpServletRequest request,HttpSession session) {

		LoginBean loginBean =new LoginBean();
		if (results.hasErrors()) {
			return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
		}

		// メールフォーマットチェック
		if (!CheckUtil.checkEmail(a0001VueForm.getUserMail())) {
			return CommonResult.validateFailed();
		}

		// 登録検証
		UserTblEntity beanUser = b0001Service.findByMail(a0001VueForm.getUserMail());

		if (beanUser != null) {
			mailService.sendPwReSetMail("yeyanjijp@gmail.com", "12345");

			// ユーザー情報をSESSIONに保存する
			session.setAttribute("USER", beanUser);

			// 成功の時、200をWEBに戻る
			return CommonResult.success(loginBean);
		}else {
			// 失敗の時、200以外をWEBに戻る
			return CommonResult.validateFailed("メール存在しない");
		}

	}

	/**
	   *  メールチェック
	 * @param user
	 * @param results
	 * @param request
	 * @return String
	 */
	@RequestMapping(value = "/sendPwMail", method = RequestMethod.POST)
	public CommonResult<LoginBean> sendPwMail(@RequestBody @Valid B0004VueForm b0004VueForm, BindingResult results, HttpServletRequest request,HttpSession session) {

		LoginBean loginBean =new LoginBean();

		// メールフォーマットチェック
		if (!CheckUtil.checkEmail(b0004VueForm.getUserMail())) {
			return CommonResult.validateFailed();
		}

		Random random = new Random();
		String code=String.format("%04d",random.nextInt(9999));
		// 登録検証
		UserTblEntity beanUser = b0001Service.findByMail(b0004VueForm.getUserMail());

		if (beanUser != null) {
			mailService.sendPwReSetMail(beanUser.getUserMail(), code);

            session.setAttribute("mailVerifyCode", code);

			// 成功の時、200をWEBに戻る
			return CommonResult.success(loginBean);
		}else {
			// 失敗の時、200以外をWEBに戻る
			return CommonResult.validateFailed("メール存在しない");
		}

	}

	/**
	   *  メールチェック
	 * @param user
	 * @param results
	 * @param request
	 * @return String
	 */
	@RequestMapping(value = "/checkMailCode", method = RequestMethod.POST)
	public CommonResult<String> checkMailCode(@RequestBody @Valid B0004VueForm b0004VueForm, BindingResult results, HttpServletRequest request,HttpSession session) {

		String code = b0004VueForm.getMailCode();
        String captchaId = (String) session.getAttribute("mailVerifyCode");
        System.out.println("验证码是：" + captchaId);
        System.out.println("用户输入的是：" + code);
        if (!captchaId.equals(code)) {
            System.out.println("输入错误");
    		return CommonResult.success("输入错误");
        } else {
            System.out.println("输入正确");
    		return CommonResult.success("输入正确");
        }

	}

	/**
	   *  メールチェック
	 * @param user
	 * @param results
	 * @param request
	 * @return String
	 */
	@RequestMapping(value = "/changePassword", method = RequestMethod.POST)
	public CommonResult<String> changePassword(@RequestBody @Valid B0004VueForm b0004VueForm, BindingResult results, HttpServletRequest request,HttpSession session) {

		
		// 「パスワード」と「確認パスワード」一致性チェック
		if (!CheckUtil.checkEqual(b0004VueForm.getPassword(), b0004VueForm.getPasswordConfirm())) {
			return CommonResult.validateFailed("パスワードと確認パスワードが一致しません。");
		}
		
		UserTblEntity userEntity = new UserTblEntity();
		userEntity.setUserMail(b0004VueForm.getUserMail());
		userEntity.setPwd(MD5Util.md5Util(b0004VueForm.getPassword()));
		int i= userService.updateUserPwdW(userEntity);

		if(i==1) {
			return CommonResult.success("输入正确");
		}else {
			return CommonResult.success("输入不正");
		}

	}
}