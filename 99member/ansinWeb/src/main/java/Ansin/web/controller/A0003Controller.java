package Ansin.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Ansin.web.api.CommonResult;
import Ansin.web.bean.ComChargeBean;
import Ansin.web.entity.UserTblEntity;
/**
 * A0003_システム管理者管理画面
 * @author 楊卿赫
 *
 */
@RestController
@RequestMapping("/A0003")
public class A0003Controller {
	
	/**
	 * ユーザー情報取得
	 * @param session
	 * @return UserTblBean
	 */
	@RequestMapping(value = "/init", method = RequestMethod.POST)
	public CommonResult<ComChargeBean> Init(HttpSession session) {
		
		// SESSIONから会社IDを取得
		UserTblEntity user = (UserTblEntity) session.getAttribute("USERA");
		
		// 出力を取得する
		ComChargeBean userTblBean = new ComChargeBean();
		
		userTblBean.setUserName(user.getLastName()  + user.getFirstName());
		
		userTblBean.setPhoto(user.getPhotoAddress());
		
		userTblBean.setAuthority(user.getAuthority());
		
		return CommonResult.success(userTblBean);
	}

}
