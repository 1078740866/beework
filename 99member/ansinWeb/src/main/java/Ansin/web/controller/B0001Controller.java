package Ansin.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Ansin.web.api.CommonResult;
import Ansin.web.bean.LoginBean;
import Ansin.web.entity.UserTblEntity;
import Ansin.web.security.JwtAuthenticatioToken;
import Ansin.web.serviceimpl.IB0001ServiceImpl;
import Ansin.web.util.CheckUtil;
import Ansin.web.util.MD5Util;
import Ansin.web.util.SecurityUtils;
import Ansin.web.vueForm.A0001VueForm;
/**
 * B0001_ユーザーLOGIN
 * @author 楊卿赫
 *
 */
@RestController
@RequestMapping("/B0001")
public class B0001Controller {

	@Autowired
	private IB0001ServiceImpl b0001Service;

    @Autowired
    private AuthenticationManager authenticationManager;

	/**
	   *  ユーザーLOGIN方法
	 * @param user
	 * @param results
	 * @param request
	 * @return String
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public CommonResult<LoginBean> login(@RequestBody @Valid A0001VueForm a0001VueForm, BindingResult results, HttpServletRequest request,HttpSession session) {

		LoginBean loginBean =new LoginBean();
		if (results.hasErrors()) {
			return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
		}

		// メールフォーマットチェック
		if (!CheckUtil.checkEmail(a0001VueForm.getUserMail())) {
			return CommonResult.validateFailed();
		}

		// パスワード桁数チェックとパスワード正確性チェック
		if (!CheckUtil.checkPwdFormat(a0001VueForm.getPassword())) {
			return CommonResult.validateFailed();
		}

		// パスワード暗号化処理
		a0001VueForm.setPassword(MD5Util.md5Util(a0001VueForm.getPassword()));

		// 登録検証
		UserTblEntity beanUser = b0001Service.loginCheck(a0001VueForm);

		if (beanUser != null) {
			
			//　ユーザ状態を判断
			if(beanUser.getUserStatus().equals("1")) {
				// 1の場合、登録失敗がある
				return CommonResult.validateFailed("当ユーザーが拒否されたため、ログインできません。");
			}
			
			//　ユーザ権限を判断
			if(beanUser.getAuthority().equals("会社会員(未認証)") || 
			   beanUser.getAuthority().equals("会社会員管理員(未認証)") 
			   ) {
				// 登録情報を審査中の場合、登録失敗がある
				return CommonResult.validateFailed("登録情報を審査しているため、ログインできません。しばらくお待ちください。");
			}
			
			// 系统登录认证
	        JwtAuthenticatioToken token = SecurityUtils.login(request, a0001VueForm.getUserMail(), a0001VueForm.getPassword(), authenticationManager);

			// ユーザー情報をSESSIONに保存する
			session.setAttribute("USER", beanUser);

			loginBean.setToken(token);

			loginBean.setUserCd(beanUser.getUserCd());

			// 画面のheaderにユーザ名を表示するため、追加
			loginBean.setUserName(beanUser.getFirstName().concat(beanUser.getLastName()));

			// 成功の時、200をWEBに戻る
			return CommonResult.success(loginBean);
		}else {
			// 失敗の時、200以外をWEBに戻る
			return CommonResult.validateFailed("ユーザ名やパスワードが誤っているため、ログインできません。");
		}

	}


}