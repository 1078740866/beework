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
import Ansin.web.bean.A0803Bean;
import Ansin.web.bean.MessageBean;
import Ansin.web.entity.UserTblEntity;
import Ansin.web.serviceimpl.IB0901ServiceImpl;
import Ansin.web.vueForm.A0803VueForm;

/**
 * B0901_受信画面
 * @author 楊卿赫
 *
 */
@RestController
@RequestMapping("/B0901")
public class B0901Controller {
	
		@Autowired
		private IB0901ServiceImpl iB0901ServiceImpl;
		
		/**
		 * 受信一覧を取得
		 * @param a0803VueForm
		 * @param results
		 * @param request
		 * @return  List<A0803Bean>
		 */
		@RequestMapping(value = "/select", method = RequestMethod.POST)
		public CommonResult<List<A0803Bean>> select(@RequestBody @Valid A0803VueForm a0803VueForm, BindingResult results,  HttpSession session) {
			
			if (results.hasErrors()) {
				return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
			}
			
			// SESSIONから会社IDを取得
			UserTblEntity user = (UserTblEntity) session.getAttribute("USER");
			a0803VueForm.setUserCd(user.getUserCd());
			
			return CommonResult.success(iB0901ServiceImpl.select(a0803VueForm));	

		}
		
		/**
		 *  受信履歴画面一つメッセージLINK押下
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
			
			UserTblEntity user = (UserTblEntity) session.getAttribute("USER");
			
			return CommonResult.success(iB0901ServiceImpl.getMessage(a0803VueForm, user.getUserCd()));	

		}
		
		
}
