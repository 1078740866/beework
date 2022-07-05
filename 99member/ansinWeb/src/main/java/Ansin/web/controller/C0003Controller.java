package Ansin.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Ansin.web.api.CommonResult;
import Ansin.web.entity.C0003ListEntity;
import Ansin.web.entity.UserTblEntity;
import Ansin.web.serviceimpl.IC0003ServiceImpl;
/**
 * C0003_応募者管理画面
 * @author 劉智浩
 *
 */
@RestController
@RequestMapping("/C0003")
public class C0003Controller {
	
	@Autowired
	private IC0003ServiceImpl c0003Service;
	
	/**
	 *  応募者管理画面
	 * @param c0003VueForm
	 * @param session
	 * @param results
	 * @return c0003Entity
	 */
	/**
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/init", method = RequestMethod.POST)
	public CommonResult<C0003ListEntity> Init(HttpSession session) {
		
		// SESSIONから会社IDを取得
		UserTblEntity user = (UserTblEntity) session.getAttribute("USERC");
		
		// 出力を取得する
		C0003ListEntity c0003Entity = new C0003ListEntity();
		
		c0003Entity.setPositionTblBean(c0003Service.getPosition(user.getUserCd()));
		
		c0003Entity.setUserName(user.getFirstName() + " " + user.getLastName());
		
		c0003Entity.setPhoto(user.getPhotoAddress());
		
		return CommonResult.success(c0003Entity);
	}

}
