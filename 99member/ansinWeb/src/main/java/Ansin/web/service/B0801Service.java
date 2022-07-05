package Ansin.web.service;

import java.util.List;

import Ansin.web.bean.B0801Bean;
import Ansin.web.bean.ComCouponBean;

public interface B0801Service {

	// 会社資産情報取得
	B0801Bean getAll(Integer companyId);
	// 会社クーポン情報取得
	List<ComCouponBean> getCouponAll(Integer companyId,String statusFlg);
	
}
