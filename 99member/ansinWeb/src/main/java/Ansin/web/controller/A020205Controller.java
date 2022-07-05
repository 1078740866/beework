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
import Ansin.web.bean.PositionTblBean;
import Ansin.web.entity.UserTblEntity;
import Ansin.web.serviceimpl.IA020205ServiceImpl;
import Ansin.web.vueForm.A020205VueForm;
import Ansin.web.vueForm.C0201ListVueForm;

/**
 * A020205職位一覧画面
 * @author 楊卿赫
 *
 */
@RestController
@RequestMapping("/A020205")
public class A020205Controller {
	
	@Autowired
    private IA020205ServiceImpl iA020205ServiceImpl;
	/**
	 * 職位一覧リスト
	 * @param b0101VueForm
	 * @param session
	 * @param results
	 * @return b0101Entity一覧リスト
	 */
	@RequestMapping(value = "/init", method = RequestMethod.POST)
	public CommonResult<List<PositionTblBean>> Init(@RequestBody @Valid A020205VueForm a020205VueForm,HttpSession session,BindingResult results) {
		if (results.hasErrors()) {
			return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
		}

		// 出力を取得する
      	List<PositionTblBean> positionTblBean = iA020205ServiceImpl.getPositionAll(a020205VueForm);
		
		return CommonResult.success(positionTblBean);
	}
	/**
	 * 職位をオンラインするとオフラインするまたは複数操作
	 * @param b0101VueForm
	 * @param session
	 * @param results
	 * @return 失敗または成功
	 */
	@RequestMapping(value = "/onlineoffline", method = {RequestMethod.POST })
	 public CommonResult<List<PositionTblBean>> b0101onlineoffline(@RequestBody @Valid A020205VueForm a020205VueForm,HttpSession session,BindingResult results) {
		
		if (results.hasErrors()) {
			return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
		}
		//SESSIONから会社IDとユーザーコードを取得
      	UserTblEntity user = (UserTblEntity) session.getAttribute("USERA");
      	a020205VueForm.setUserCd(user.getUserCd());

		int positionOnlineOffline = iA020205ServiceImpl.positionOnlineOrOffline(a020205VueForm.getPositionId()
				, a020205VueForm.getOnlineStatus()
				, a020205VueForm.getCompanyId()
				, a020205VueForm.getUserCd());
		
		if (positionOnlineOffline == 0 ) {
			return CommonResult.failed();
		}else {
			
			List<PositionTblBean> positionTblBean = iA020205ServiceImpl.getPositionAll(a020205VueForm);
			
			return CommonResult.success(positionTblBean);
		}    	
	}

	/**
	 * C0201単数または複数削除
	 * @param c0201VueForm
	 * @param session
	 * @param results
	 * @return C0201ListBean
	 */
	@RequestMapping(value = "/deleteApplication", method = {RequestMethod.POST })
	 public CommonResult<List<PositionTblBean>> deleteApplication(@RequestBody @Valid A020205VueForm a020205VueForm,C0201ListVueForm c0201ListVueForm,HttpSession session,BindingResult results) {
		
		if (results.hasErrors()) {
			return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
		}
		//SESSIONから会社IDとユーザーコードを取得
      	UserTblEntity user = (UserTblEntity) session.getAttribute("USERA");
      	a020205VueForm.setUserCd(user.getUserCd());

		int deleteApplication = iA020205ServiceImpl.deleteApplication(a020205VueForm);
		
		if (deleteApplication == 0 ) {
			return CommonResult.failed("失敗");
		}else {
			
			// 出力を取得する
			List<PositionTblBean> positionTblBean = iA020205ServiceImpl.getPositionAll(a020205VueForm);
			
			return CommonResult.success(positionTblBean);
			
			}    	
	}
	
	
	
}
