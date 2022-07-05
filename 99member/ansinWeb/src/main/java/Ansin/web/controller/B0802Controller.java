package Ansin.web.controller;

import java.util.ArrayList;
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
import Ansin.web.bean.B0802Bean;
import Ansin.web.entity.UserTblEntity;
import Ansin.web.serviceimpl.IB0802ServiceImpl;
import Ansin.web.util.EditUtil;
import Ansin.web.vueForm.B0802ListVueForm;
import Ansin.web.vueForm.B0802VueForm;

/**
 * B0802_クーポン券取得画面
 * 
 * @author 劉智浩
 *
 */
@RestController
@RequestMapping("/B0802")
public class B0802Controller {

	@Autowired
	private IB0802ServiceImpl b0802Service;

	/**
	 * クーポン一覧リスト
	 * 
	 * @return
	 */
	@RequestMapping(value = "/init", method = RequestMethod.POST)
	public CommonResult<B0802Bean> Coupon(HttpSession session) {
		
		// SESSIONから会社IDを取得
		UserTblEntity user = (UserTblEntity) session.getAttribute("USER");
		
		B0802Bean bean = new B0802Bean();
		
		//すべてクーポンリスト取得
		bean.setLists(b0802Service.getAllCoupon());
		
		//ポイント残高取得
		bean.setCouponBalance(EditUtil.intUtil(b0802Service.selectBalance(user.getCompanyId())));
		
		return CommonResult.success(bean);

	}

	/**
	 * クーポンを購入する
	 * 
	 * @param b0802ListVueForm
	 * @param session
	 * @param results
	 * @return Integer
	 */
	@RequestMapping(value = "/insertCoupon", method = { RequestMethod.POST })
	public CommonResult<Integer> insertCoupon(@RequestBody @Valid B0802ListVueForm b0802ListVueForm, HttpSession session,
			BindingResult results) {

		if (results.hasErrors()) {
			return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
		}

		// SESSIONから会社IDを取得
		UserTblEntity user = (UserTblEntity) session.getAttribute("USER");

		List<B0802VueForm> list = new ArrayList<B0802VueForm>();
		
		for (B0802VueForm beans : b0802ListVueForm.getBeans()) {
			for (int i = 0; i < beans.getCount(); i++) {
				B0802VueForm bean = new B0802VueForm();
				bean.setCompanyId(user.getCompanyId());
				bean.setCouponId(beans.getCouponId());
				bean.setExpDays(beans.getExpDays());
				bean.setUserCd(user.getUserCd());
				list.add(bean);
			}
		}
		// 登録
		int insertCoupon = b0802Service.insertCoupon(list);
		// 成功するかどうか判断します。
		if (insertCoupon == 0) {
			return CommonResult.failed();
		} else {
			return CommonResult.success(insertCoupon);
		}
	}
}
