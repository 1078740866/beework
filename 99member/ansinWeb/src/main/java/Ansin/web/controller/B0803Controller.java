package Ansin.web.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Ansin.web.api.CommonResult;
import Ansin.web.bean.CompanyInfoBean;
import Ansin.web.entity.UserTblEntity;
import Ansin.web.serviceimpl.IB0803ServiceImpl;
import Ansin.web.vueForm.B0803VueForm;

/**
 * B0803_チャージ画面
 * @author 楊卿赫
 *
 */
@RestController
@RequestMapping("/B0803")
public class B0803Controller {
	
		@Autowired
		private IB0803ServiceImpl b0803Service;
		
		/**
		 * チャージ画面初期表示
		 * @param session
		 * @return CompanyInfoBean
		 */
		@RequestMapping(value = "/init", method = RequestMethod.POST)
		public CommonResult<CompanyInfoBean> getComchargeResult(HttpSession session) {

			// SESSIONから会社IDを取得
			UserTblEntity user = (UserTblEntity) session.getAttribute("USER");
			
			//チャージ画面初期表示取得
			CompanyInfoBean companyInfoBean = b0803Service.getCompany(user.getCompanyId());
			
			return CommonResult.success(companyInfoBean);

		}
		
		/**
		 * チャージボタン押下
		 * @param session
		 * @return CompanyInfoBean
		 */
		@RequestMapping(value = "/charge", method = RequestMethod.POST)
		public CommonResult<String> getCharge(@RequestBody @Valid B0803VueForm b0803VueForm,
				BindingResult results, HttpSession session) {

			// SESSIONから会社IDを取得
			UserTblEntity user = (UserTblEntity) session.getAttribute("USER");
			b0803VueForm.setUserCd(user.getUserCd());
			
			//チャージ
			Integer flg = b0803Service.getCharge(b0803VueForm);
			
			if(flg != 1) {
				return CommonResult.failed("失敗");
			}else {
				return CommonResult.success("成功");
			}

		}
		
}
