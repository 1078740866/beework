package Ansin.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Ansin.web.api.CommonResult;
import Ansin.web.bean.B0003Bean;
import Ansin.web.bean.ComChargeBean;
import Ansin.web.entity.UserTblEntity;
import Ansin.web.serviceimpl.IB0003ServiceImpl;

/**
 * B0003_会社管理画面
 * @author 楊卿赫
 *
 */
@RestController
@RequestMapping("/B0003")
public class B0003Controller {
	
		@Autowired
		private IB0003ServiceImpl iB0003ServiceImpl;
		
		/**
		 * 会社管理画面初期一覧取得
		 * @param results
		 * @param session
		 * @return B0003Bean
		 * @throws IOException 
		 */
		@RequestMapping(value = "/init", method = RequestMethod.POST)
		public CommonResult<B0003Bean> getComchargeResult(HttpSession session) throws IOException {
			
			// SESSIONから会社IDを取得
			UserTblEntity user = (UserTblEntity) session.getAttribute("USER");
			
			B0003Bean b0003Bean = new B0003Bean();
			
			ComChargeBean comChargeBean = iB0003ServiceImpl.getUser(user.getUserCd(), user.getCompanyId());
			
			ComChargeBean comChargeBeanOutput = iB0003ServiceImpl.confirmOutput(comChargeBean);
			
			//ユーザー情報取得
			b0003Bean.setUserTblBean(comChargeBeanOutput);
			//未処理件数取得
			b0003Bean.setCount(iB0003ServiceImpl.getCount(user.getCompanyId()));
			//人材推薦リスト取得
			b0003Bean.setB0301Beans(iB0003ServiceImpl.getList(user.getCompanyId()));
			
			return CommonResult.success(b0003Bean);

		}
		
}
