package Ansin.web.service;

import java.util.List;

import Ansin.web.bean.CouponMstBean;
import Ansin.web.vueForm.B0802VueForm;

public interface B0802Service {
		
		//クーポン一覧リスト
		List<CouponMstBean> getAllCoupon();
		
		//クーポンを購入する
		Integer insertCoupon(List<B0802VueForm> beans);
		
		//ポイント残高取得
		Integer selectBalance(Integer companyId);
}
