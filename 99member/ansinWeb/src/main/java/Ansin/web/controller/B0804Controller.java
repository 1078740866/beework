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
import Ansin.web.bean.ComChargeTblBean;
import Ansin.web.bean.ComConsTblBean;
import Ansin.web.entity.ComChargeTblEntity;
import Ansin.web.entity.ComConsTblEntity;
import Ansin.web.entity.UserTblEntity;
import Ansin.web.serviceimpl.IB0804ServiceImpl;
import Ansin.web.util.EditUtil;
import Ansin.web.vueForm.B0804VueForm;

/**
 * B0804_履歴画面
 * @author 楊卿赫
 *
 */
@RestController
@RequestMapping("/B0804")
public class B0804Controller {
	
		@Autowired
		private IB0804ServiceImpl b0804Service;
		
		/**
		 * 会社チャージ履歴リストと支払履歴リストを取得
		 * @param b0804VueForm
		 * @param results
		 * @param session
		 * @return List<ComChargeBean>
		 */
		@RequestMapping(value = "/comcharge", method = RequestMethod.POST)
		public CommonResult<List<ComChargeTblBean>> getComchargeResult(@RequestBody @Valid B0804VueForm b0804VueForm,
				BindingResult results, HttpSession session) {

			if (results.hasErrors()) {
				return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
			}
			
			//編集
			ComChargeTblEntity comCharge = b0804Service.editB08041(b0804VueForm);
			
			// SESSIONから会社IDを取得
			UserTblEntity user = (UserTblEntity) session.getAttribute("USER");
			comCharge.setCompanyId(user.getCompanyId());
			
			// チャージ履歴リストを取得
			List<ComChargeTblBean> comChargeBean = b0804Service.getComchargeTblEntityList(comCharge
					,EditUtil.timeStampUtil(b0804VueForm.getChargeFrom())
					,EditUtil.timeStampUtil(b0804VueForm.getChargeTo()));
			
			return CommonResult.success(comChargeBean);

		}
		
		/**
		 * 消費履歴リストを取得
		 * @param b0804VueForm
		 * @param results
		 * @param session
		 * @return List<ComConsTblBean>
		 */
		@RequestMapping(value = "/comcons", method = RequestMethod.POST)
		public CommonResult<List<ComConsTblBean>> getComconsResult(@RequestBody @Valid B0804VueForm b0804VueForm,
				BindingResult results, HttpSession session) {

			if (results.hasErrors()) {
				return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
			}
			
			//編集
			ComConsTblEntity comCons = b0804Service.editB08042(b0804VueForm);
			
			// SESSIONから会社IDを取得
			UserTblEntity user = (UserTblEntity) session.getAttribute("USER");
			comCons.setCompanyId(user.getCompanyId());
			
			// 消費履歴リストを取得
			List<ComConsTblBean> comConsBean = b0804Service.getComconsTblEntityList(comCons
					,EditUtil.timeStampUtil(b0804VueForm.getConsFrom())
					,EditUtil.timeStampUtil(b0804VueForm.getConsTo()));

			return CommonResult.success(comConsBean);

		}
		
		/**
		 * 会社チャージ状態変更
		 * @param b0804VueForm
		 * @param results
		 * @param session
		 * @return List<ComChargeBean>
		 */
		@RequestMapping(value = "/changeChargeFlg", method = RequestMethod.POST)
		public CommonResult<String> changeChargeFlg(@RequestBody @Valid B0804VueForm b0804VueForm,
				BindingResult results, HttpSession session) {

			if (results.hasErrors()) {
				return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
			}
			
			// SESSIONから会社IDを取得
			UserTblEntity user = (UserTblEntity) session.getAttribute("USER");
			
			// チャージ履歴リストを取得
			int count = b0804Service.changeChargeFlg(user.getCompanyId(), EditUtil.intUtil(b0804VueForm.getChargeId()));
			
			if(count != 1) {
				return CommonResult.failed("失敗");

			}else {
				
				//会社金額更新
				b0804Service.changeCom(user.getCompanyId(),
						EditUtil.intUtil(b0804VueForm.getChargeMoney()),
						EditUtil.intUtil(b0804VueForm.getChargeHoney()));
				
				return CommonResult.success("成功");
			}
			

		}
		

}
