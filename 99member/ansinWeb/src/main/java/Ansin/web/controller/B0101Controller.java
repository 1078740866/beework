package Ansin.web.controller;

import java.io.IOException;
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
import Ansin.web.bean.PositionTblBean;
import Ansin.web.entity.UserTblEntity;
import Ansin.web.serviceimpl.IB0101ServiceImpl;
import Ansin.web.vueForm.B0101VueForm;

/**
 * B0101_職位一覧画面
 * @author 劉智浩
 *
 */
@RestController
@RequestMapping("/B0101")
public class B0101Controller {
	@Autowired
    private IB0101ServiceImpl b0101Service;
	/**
	 * 職位一覧リスト
	 * @param b0101VueForm
	 * @param session
	 * @param results
	 * @return b0101Entity一覧リスト
	 * @throws IOException 
	 */
	@RequestMapping(value = "/init", method = RequestMethod.POST)
	public CommonResult<List<PositionTblBean>> Init(@RequestBody @Valid B0101VueForm b0101VueForm,HttpSession session,BindingResult results) throws IOException {
		if (results.hasErrors()) {
			return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
		}
		 //SESSIONから会社IDとユーザーコードを取得
      	UserTblEntity user = (UserTblEntity) session.getAttribute("USER");
      	b0101VueForm.setCompanyId(user.getCompanyId());
      	b0101VueForm.setUserCd(user.getUserCd());

		// 出力を取得する
      	List<PositionTblBean> positionTblBean = b0101Service.getPositionAll(b0101VueForm);
      	
		return CommonResult.success(b0101Service.confirmOutput(positionTblBean));
	}
	/**
	 * 職位をオンラインするとオフラインするまたは複数操作
	 * @param b0101VueForm
	 * @param session
	 * @param results
	 * @return 失敗または成功
	 */
	@RequestMapping(value = "/onlineoffline", method = {RequestMethod.POST })
	 public CommonResult<List<PositionTblBean>> b0101onlineoffline(@RequestBody @Valid B0101VueForm b0101VueForm,HttpSession session,BindingResult results) {
		
		if (results.hasErrors()) {
			return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
		}
		//SESSIONから会社IDとユーザーコードを取得
      	UserTblEntity user = (UserTblEntity) session.getAttribute("USER");
      	b0101VueForm.setCompanyId(user.getCompanyId());
      	b0101VueForm.setUserCd(user.getUserCd());

		
		int positionOnlineOffline = b0101Service.positionOnlineOrOffline(b0101VueForm.getPositionIds(), b0101VueForm.getOnlineStatus(), b0101VueForm.getCompanyId(), b0101VueForm.getUserCd());
		
		if (positionOnlineOffline == 0 ) {
			return CommonResult.failed();
		}else {
			
			List<PositionTblBean> positionTblBean = b0101Service.getPositionAll(b0101VueForm);
			
			return CommonResult.success(positionTblBean);
		}    	
	}
	/**
	 * 職位を削除または複数削除
	 * @param b0101VueForm
	 * @param session
	 * @param results
	 * @return 失敗または成功
	 */
	@RequestMapping(value = "/delete", method = {RequestMethod.POST })
	 public CommonResult<List<PositionTblBean>> b0101delete(@RequestBody @Valid B0101VueForm b0101VueForm,HttpSession session,BindingResult results) {
		
		if (results.hasErrors()) {
			return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
		}
		//SESSIONから会社IDとユーザーコードを取得
      	UserTblEntity user = (UserTblEntity) session.getAttribute("USER");
      	b0101VueForm.setCompanyId(user.getCompanyId());
      	b0101VueForm.setUserCd(user.getUserCd());

		int positionDelete = b0101Service.positionDelete(b0101VueForm.getPositionIds(), b0101VueForm.getCompanyId(), b0101VueForm.getUserCd());
		
		if (positionDelete == 0 ) {
			return CommonResult.failed("失敗");
		}else {
			
			List<PositionTblBean> positionTblBean = b0101Service.getPositionAll(b0101VueForm);
			
			return CommonResult.success(positionTblBean);
		}  
	}
	/**
	 * 職位をtopまたは複数top
	 * @param b0101VueForm
	 * @param session
	 * @param results
	 * @return
	 */
	@RequestMapping(value = "/top", method = {RequestMethod.POST })
	 public CommonResult<List<PositionTblBean>> b0101top(@RequestBody @Valid B0101VueForm b0101VueForm,HttpSession session,BindingResult results) {
		
		if (results.hasErrors()) {
			return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
		}
		//SESSIONから会社IDとユーザーコードを取得
     	UserTblEntity user = (UserTblEntity) session.getAttribute("USER");
     	b0101VueForm.setCompanyId(user.getCompanyId());
     	b0101VueForm.setUserCd(user.getUserCd());

		int positionTop = b0101Service.positionTop(b0101VueForm.getPositionIds(),b0101VueForm.getTopStatus(), b0101VueForm.getCompanyId(), b0101VueForm.getUserCd());
		
		if (positionTop == 0 ) {
			return CommonResult.failed("失敗");
		}else {
			
			List<PositionTblBean> positionTblBean = b0101Service.getPositionAll(b0101VueForm);
			
			return CommonResult.success(positionTblBean);
		}  
	}
}
