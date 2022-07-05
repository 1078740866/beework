package Ansin.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Ansin.web.api.CommonResult;
import Ansin.web.bean.A0901ListBean;
import Ansin.web.bean.UserInfoBean;
import Ansin.web.entity.UserTblEntity;
import Ansin.web.serviceimpl.IA0901ServiceImpl;
import Ansin.web.util.CheckUtil;
import Ansin.web.vueForm.A0002VueForm;
import Ansin.web.vueForm.A0902VueForm;
/**
 * A0901_個人情報画面「管理者」、「会社員」、「応募者」
 * A0902_パスワード修正画面
 * @author 劉智浩
 *
 */
@RestController
@RequestMapping("/A0901")
public class A0901Controller {
	
	@Autowired
    private IA0901ServiceImpl a0901Service;
	
	
	/**
	 * A0901_個人情報画面「管理者」
	 * @param a0002VueForm
	 * @param session
	 * @param results
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value = "/initUserInfoA", method = RequestMethod.POST)
	public CommonResult<A0901ListBean> InitUserInfoA(HttpSession session) throws IOException {
		
		// SESSIONからユーザーCD取得
		UserTblEntity user = (UserTblEntity) session.getAttribute("USERA");
		
		// 出力を取得する
		A0901ListBean a0901ListBean = new A0901ListBean();

		//応募者情報を取得する
		UserInfoBean userInfoBean = a0901Service.getUserInfoA(user.getUserCd());
		
		UserInfoBean userInfoBeanOutput=a0901Service.confirmOutput(userInfoBean);
		
		a0901ListBean.setUserInfoBeanA(userInfoBeanOutput);
		
		return CommonResult.success(a0901ListBean);
	}
	
	/**
	 * A0901_個人情報画面「会社員」
	 * @param a0002VueForm
	 * @param session
	 * @param results
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value = "/initUserInfoB", method = RequestMethod.POST)
	public CommonResult<A0901ListBean> InitUserInfoB(HttpSession session) throws IOException {
		
		// SESSIONからユーザーCD取得
		UserTblEntity user = (UserTblEntity) session.getAttribute("USER");
	
		// 出力を取得する
		A0901ListBean a0901ListBean = new A0901ListBean();

		//応募者情報を取得する
		UserInfoBean userInfoBean = a0901Service.getUserInfoB(user.getUserCd());
		
		UserInfoBean userInfoBeanOutput=a0901Service.confirmOutput(userInfoBean);
		
		a0901ListBean.setUserInfoBeanB(userInfoBeanOutput);
		
		return CommonResult.success(a0901ListBean);
	}
	
	/**
	 * A0901_個人情報画面「応募者」
	 * @param a0002VueForm
	 * @param session
	 * @param results
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value = "/initUserInfoC", method = RequestMethod.POST)
	public CommonResult<A0901ListBean> InitUserInfoC(HttpSession session) throws IOException {
		
		// SESSIONからユーザーCD取得
		UserTblEntity user = (UserTblEntity) session.getAttribute("USERC");
		
		// 出力を取得する
		A0901ListBean a0901ListBean = new A0901ListBean();

		//応募者情報を取得する
		UserInfoBean userInfoBean = a0901Service.getUserInfoC(user.getUserCd());
		
		UserInfoBean userInfoBeanOutput=a0901Service.confirmOutput(userInfoBean);
		
		a0901ListBean.setUserInfoBeanC(userInfoBeanOutput);
		
		return CommonResult.success(a0901ListBean);
	}
	
	/**
	 * A0901_個人情報更新
	 * @param a0002VueForm
	 * @param session
	 * @param results
	 * @return
	 */
	 @RequestMapping(value = "/userInfoUpdate", method = RequestMethod.POST)
	    public CommonResult<String> userInfoUpdate(@RequestBody @Valid A0002VueForm a0002VueForm, HttpSession session,BindingResult results) {

			if (results.hasErrors()) {
				return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
			}
			
			// sessionよりユーザ情報を取得
			UserTblEntity user=new UserTblEntity();
			if (a0002VueForm.getAuthority().equals("会社会員管理員(認証済み)")) {
				user = (UserTblEntity) session.getAttribute("USER");
			}else if(a0002VueForm.getAuthority().equals("システム管理者(認証済み)")) {
				user = (UserTblEntity) session.getAttribute("USERA");
			}else {
				user = (UserTblEntity) session.getAttribute("USERC");
			}
			
			// ユーザ情報編集
			UserTblEntity userEntity = a0901Service.editUserInfo(a0002VueForm);
			
			// SESSIONからユーザーCD取得
			userEntity.setUserCd(user.getUserCd());
			
			// ユーザー情報追加
			int count = a0901Service.updateUserInfo(userEntity);
			
			if (count != 1) {
				return CommonResult.failed();
			}

			return CommonResult.success("");
		}
	 
	 /**
	  *  A0902_パスワード修正画面
	  * @param a0902VueForm
	  * @param session
	  * @param results
	  * @return
	  */
	 @RequestMapping(value = "/userPasswordUpdate", method = RequestMethod.POST)
	    public CommonResult<String> userPasswordUpdate(@RequestBody @Valid A0902VueForm a0902VueForm, HttpSession session,BindingResult results) {

			if (results.hasErrors()) {
				return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
			}
			
			String userPassword = a0901Service.getPassword(Integer.valueOf((String) session.getAttribute("userCd")));
			
			// 「既存パスワード」と「入力し元パスワード」一致性チェック
			// TODO メッセージ「E0010」が出力される
			if (!CheckUtil.checkEqual(userPassword, a0902VueForm.getOldPwd())) {
				return CommonResult.validateFailed("4");
			}
			// 「パスワード」正確性チェック
			// TODO メッセージ「E0002-2」が出力される
			if (!CheckUtil.checkPwdFormat(a0902VueForm.getNewPwd())) {
				return CommonResult.validateFailed("5");
			}
			// 「パスワード」と「確認パスワード」一致性チェック
			// TODO メッセージ「E0010」が出力される
			if (!CheckUtil.checkEqual(a0902VueForm.getNewPwd(), a0902VueForm.getNewPwdre())) {
				return CommonResult.validateFailed("4");
			}
			
			int updateUserPassword = a0901Service.updateUserPassword(a0902VueForm, Integer.valueOf((String) session.getAttribute("userCd")));

				
			if (updateUserPassword != 1) {
				return CommonResult.failed();
			}

			return CommonResult.success("");
		} 
	 
}
