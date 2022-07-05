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
import Ansin.web.bean.A0802Bean;
import Ansin.web.bean.A0803Bean;
import Ansin.web.bean.MessageBean;
import Ansin.web.entity.UserTblEntity;
import Ansin.web.serviceimpl.IA0801ServiceImpl;
import Ansin.web.vueForm.A0801VueForm;
import Ansin.web.vueForm.A0802VueForm;
import Ansin.web.vueForm.A0803VueForm;
/**
 * A0801_メッセージ送信画面
 * @author 楊卿赫
 *
 */
@RestController
@RequestMapping("/A0801")
public class A0801Controller {

	@Autowired
	private IA0801ServiceImpl iA0801ServiceImpl;

	/**
	 * メッセージ送信ボタン押下
	 * @param a0801VueForm
	 * @param results
	 * @param request
	 * @return String
	 */
	@RequestMapping(value = "/send", method = RequestMethod.POST)
	public CommonResult<String> init(@RequestBody @Valid A0801VueForm a0801VueForm, BindingResult results, HttpSession session) {
		
		if (results.hasErrors()) {
			return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
		}
		
		//SESSIONから会社IDとユーザーコードを取得
		UserTblEntity user = (UserTblEntity) session.getAttribute("USERA");
		a0801VueForm.setSendId(user.getUserCd());
		
		int count = iA0801ServiceImpl.send(a0801VueForm);
		
		if (count == 0) {
			return CommonResult.failed("失敗");	
		}else {
			return CommonResult.success("成功");
		}

	}
	
	/**
	 * 宛先一覧画面初期表示と検索ボタン押下
	 * @param a0802VueForm
	 * @param results
	 * @param request
	 * @return List<A0802Bean>
	 */
	@RequestMapping(value = "/userPop", method = RequestMethod.POST)
	public CommonResult<List<A0802Bean>> userPop(@RequestBody @Valid A0802VueForm a0802VueForm, BindingResult results, HttpSession session) {
		
		if (results.hasErrors()) {
			return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
		}
		
		return CommonResult.success(iA0801ServiceImpl.getUserList(a0802VueForm));	

	}
	
	
	/**
	 * 送信履歴画面初期表示と検索ボタン押下
	 * @param a0803VueForm
	 * @param results
	 * @param request
	 * @return List<A0803Bean>
	 */
	@RequestMapping(value = "/addressList", method = RequestMethod.POST)
	public CommonResult<List<A0803Bean>> addressList(@RequestBody @Valid A0803VueForm a0803VueForm, BindingResult results, HttpSession session) {
		
		if (results.hasErrors()) {
			return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
		}
		
		// SESSIONから会社IDを取得
		UserTblEntity user = (UserTblEntity) session.getAttribute("USERA");
		a0803VueForm.setUserCd(user.getUserCd());
		
		return CommonResult.success(iA0801ServiceImpl.getAddress(a0803VueForm));	

	}
	
	/**
	 *  送信履歴画面一つメッセージLINK押下
	 * @param a0803VueForm
	 * @param results
	 * @param request
	 * @return MessageBean
	 */
	@RequestMapping(value = "/getMessage", method = RequestMethod.POST)
	public CommonResult<MessageBean> getMessage(@RequestBody @Valid A0803VueForm a0803VueForm, BindingResult results, HttpSession session) {
		
		if (results.hasErrors()) {
			return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
		}
		
		return CommonResult.success(iA0801ServiceImpl.getMessage(a0803VueForm));	

	}
	

}
