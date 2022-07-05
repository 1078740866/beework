package Ansin.web.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import Ansin.web.api.CommonResult;
import Ansin.web.bean.B0801Bean;
import Ansin.web.bean.ComCouponBean;
import Ansin.web.entity.UserTblEntity;
import Ansin.web.serviceimpl.IB0801ServiceImpl;

/**
 * B0801_資産情報画面
 * @author 楊卿赫
 *
 */
@RestController
@RequestMapping("/B0801")
public class B0801Controller {
	
		@Autowired
		private IB0801ServiceImpl iB0801ServiceImpl;
		
		/**
		 * 会社チャージ履歴リストと支払履歴リストを取得
		 * @param b0804VueForm
		 * @param results
		 * @param session
		 * @return List<ComChargeBean>
		 */
		@RequestMapping(value = "/init", method = RequestMethod.POST)
		public CommonResult<B0801Bean> init(HttpSession session) {
			
			// SESSIONから会社IDを取得
			UserTblEntity user = (UserTblEntity) session.getAttribute("USER");
			
			B0801Bean bean = iB0801ServiceImpl.getAll(user.getCompanyId());
			
			return CommonResult.success(bean);

		}
		
		/**
		 * タッブ押下会社クーポンリスト検索
		 * @param jsonTab
		 * @param session
		 * @return
		 */
		@RequestMapping(value = "/tabChange", method = RequestMethod.POST)
		public CommonResult<List<ComCouponBean>> tabChange(@RequestBody JSONObject jsonTab, HttpSession session) {
			
			// TAB状態取得
			Map<String, Object> jsonToMap =  JSONObject.parseObject(jsonTab.toJSONString());
			String statusFlg = (String)jsonToMap.get("statusFlg");
			
			// SESSIONから会社IDを取得
			UserTblEntity user = (UserTblEntity) session.getAttribute("USER");
			
			List<ComCouponBean> bean = iB0801ServiceImpl.getCouponAll(user.getCompanyId(),statusFlg);
			
			return CommonResult.success(bean);

		}
		
		
}
