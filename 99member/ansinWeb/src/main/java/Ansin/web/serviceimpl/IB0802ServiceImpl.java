package Ansin.web.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ansin.web.bean.CouponMstBean;
import Ansin.web.entity.CouponMstEntity;
import Ansin.web.mapper.CompanyCouponTblMapper;
import Ansin.web.mapper.CompanyTblMapper;
import Ansin.web.mapper.CouponMstMapper;
import Ansin.web.service.B0802Service;
import Ansin.web.util.EditUtil;
import Ansin.web.vueForm.B0802VueForm;
@Service
public class IB0802ServiceImpl implements B0802Service{
	
	@Autowired
	private CouponMstMapper couponMstMapper;
	@Autowired
	private CompanyCouponTblMapper companyCouponTblMapper;
	@Autowired
	private CompanyTblMapper companyTblMapper;
	

	/**
	 * クーポン一覧リスト
	 */
	@Override
	public List<CouponMstBean> getAllCoupon() {
		List<CouponMstEntity> couponMstEntity = couponMstMapper.getAll();
		List<CouponMstBean> couponMstBean = new ArrayList<CouponMstBean>();
		for(CouponMstEntity couponEntity : couponMstEntity) {
			CouponMstBean couponBean = new CouponMstBean();
			BeanUtils.copyProperties(couponEntity, couponBean);
			couponBean.setCouponId(EditUtil.intUtil(couponEntity.getCouponId()));
			couponBean.setPointNum(EditUtil.intUtil(couponEntity.getPointNum()));
			couponBean.setExpDays(EditUtil.intUtil(couponEntity.getExpDays()));
			couponMstBean.add(couponBean);
		}
		return couponMstBean;
	}

	/**
	 * クーポンを購入する
	 */
	@Override
	public Integer insertCoupon(List<B0802VueForm> beans) {
		Integer insertCoupon = companyCouponTblMapper.insertCoupon(beans);
		return insertCoupon;
	}
	
	/**
	 * クーポン残高を取得する
	 */
	@Override
	public Integer selectBalance(Integer companyId) {
		return companyTblMapper.selectBalance(companyId);
	}

}
