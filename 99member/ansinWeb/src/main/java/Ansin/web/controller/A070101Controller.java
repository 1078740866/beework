package Ansin.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Ansin.web.api.CommonResult;
import Ansin.web.bean.UserInfoBean;
import Ansin.web.entity.UserTblEntity;
import Ansin.web.serviceimpl.IA070101ServiceImpl;
import Ansin.web.vueForm.A070101VueForm;
/**
 * A0701_01_承認一覧画面(管理者)
 * @author 劉智浩
 *
 */
@RestController
@RequestMapping("/A070101")
public class A070101Controller {
		
	@Autowired
    private IA070101ServiceImpl a070101Service;
	
	int updateUserStatus;

	
	/**
	 * A070101未認証ユーザー一覧リストとB0805未認証会社員一覧リスト
	 * @param a070101VueForm
	 * @param session
	 * @param results
	 * @return
	 */
	@RequestMapping(value = "/init", method = RequestMethod.POST)
    public CommonResult<List<UserInfoBean>> Init(@RequestBody @Valid A070101VueForm a070101VueForm,HttpSession session,BindingResult results) {
		
		if (results.hasErrors()) {
			return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
		}
		
		UserTblEntity user = (UserTblEntity) session.getAttribute("USERA");
		UserTblEntity user2 = (UserTblEntity) session.getAttribute("USER");
		
		if(user != null && user.getAuthority().equals("スーパー管理者")) {
				//すべてユーザー取得
				List<UserInfoBean> userInfoBean = a070101Service.getAll(a070101VueForm);
				return CommonResult.success(userInfoBean);
			
		}else if (user2 != null && user2.getAuthority().equals("会社会員管理員(認証済み)")) {
			//会社会員LIST取得
			List<UserInfoBean> userInfoBean = a070101Service.getEmployeeAll(user2.getCompanyId(), a070101VueForm);
			for (UserInfoBean userBean : userInfoBean) {
				if (userBean.getAuthority().equals("会社会員(認証済み)")) {
					userBean.setAuthority("認証済み");
				}else if (userBean.getAuthority().equals("会社会員(未認証)")) {
					userBean.setAuthority("未認証");
				}else {
					continue;
				}
			}
			return CommonResult.success(userInfoBean);
		}else {
			return CommonResult.failed("sessionタイムアウトの期限が切れました,もう一度登録お願いします。");
		}
    }
	
	/**
	 * 未認証ユーザーから単数承認または複数承認（システム管理者、会社会員管理者）
	 * @param a070101VueForm
	 * @param session
	 * @param results
	 * @return List<UserInfoBean>
	 */
	@RequestMapping(value = "/updateUserStatus", method = {RequestMethod.POST })
	 public CommonResult<List<UserInfoBean>> updateUserStatus(@RequestBody @Valid A070101VueForm a070101VueForm,HttpSession session,BindingResult results) {
		
		if (results.hasErrors()) {
			return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
		}
		
		UserTblEntity user = (UserTblEntity) session.getAttribute("USERA");
		UserTblEntity user2 = (UserTblEntity) session.getAttribute("USER");
		
		//スーパー管理者
		if (user != null && user.getAuthority().equals("スーパー管理者")) {
			
			if (a070101VueForm.getAuthority().equals("会社会員(未認証)")) {
				
				if (a070101VueForm.getStatusFlg().equals("0")) {
					// ユーザー単数または複数承認(会社会員)
					updateUserStatus = a070101Service.updateUserStatusC(a070101VueForm.getUserCds(), user.getUserCd());
				}else {
					// ユーザー単数または複数拒否(会社会員)
					updateUserStatus = a070101Service.rejectUserStatus(a070101VueForm.getUserCds(), user.getUserCd());
				}
					
				//成功するかどうか判断します
				if (updateUserStatus == 0 ) {
					return CommonResult.failed("失敗");
				}else {
					A070101VueForm a070101VueForm1 = new A070101VueForm();
					//LIST取得
					List<UserInfoBean> userInfoBean = a070101Service.getAll(a070101VueForm1);
					
					return CommonResult.success(userInfoBean);
				}     
			}else {
				
				if (a070101VueForm.getStatusFlg().equals("0")) {
					// ユーザー単数または複数承認(システム管理者)
					updateUserStatus = a070101Service.updateUserStatusA(a070101VueForm.getUserCds(), user.getUserCd());
				}else {
					// ユーザー単数または複数拒否(システム管理者)
					updateUserStatus = a070101Service.rejectUserStatus(a070101VueForm.getUserCds(), user.getUserCd());
				}
				
				//成功するかどうか判断します
				if (updateUserStatus == 0 ) {
					return CommonResult.failed("失敗");
				}else {
					A070101VueForm a070101VueForm1 = new A070101VueForm();
					//LIST取得
					List<UserInfoBean> userInfoBean = a070101Service.getAll(a070101VueForm1);
					
					return CommonResult.success(userInfoBean);
				}     
			}
		//ほかのユーザー
		}else if (user2 != null && user2.getAuthority().equals("会社会員管理員(認証済み)")) {
			
			if (a070101VueForm.getStatusFlg().equals("0")) {
				// ユーザー単数または複数承認(会社会員)
				updateUserStatus = a070101Service.updateUserStatusC(a070101VueForm.getUserCds(), user2.getUserCd());
			}else {
				// ユーザー単数または複数拒否(会社会員)
				updateUserStatus = a070101Service.rejectUserStatus(a070101VueForm.getUserCds(), user2.getUserCd());
			}
					
			//成功するかどうか判断します
			if (updateUserStatus == 0 ) {
				return CommonResult.failed("失敗");
			}else {
				A070101VueForm a070101VueForm1 = new A070101VueForm();
				//LIST取得
				List<UserInfoBean> userInfoBean = a070101Service.getEmployeeAll(user2.getCompanyId(), a070101VueForm1);
				
				return CommonResult.success(userInfoBean);
			}     
		}else {
				return null;
		}
	}		

}
