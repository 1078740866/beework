package Ansin.web.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ansin.web.bean.B0801Bean;
import Ansin.web.bean.ComCouponBean;
import Ansin.web.bean.ComHoneyCoinBean;
import Ansin.web.bean.ComPointBean;
import Ansin.web.entity.ComCoinPointEntity;
import Ansin.web.entity.ComCouponTblEntity;
import Ansin.web.mapper.CompanyTblMapper;
import Ansin.web.mapper.CouponMstMapper;
import Ansin.web.service.B0801Service;
import Ansin.web.util.EditUtil;

@Service
public class IB0801ServiceImpl implements B0801Service{
	
	@Autowired
	private CompanyTblMapper companyTblMapper;
	@Autowired
	private CouponMstMapper couponMstMapper;
	
	/**
	 * 会社資産情報取得
	 * @param companyId
	 * @return B0801Bean
	 */
	@Override
	public B0801Bean getAll(Integer companyId) {

		//会社ハニーコインとポイント取得
		//会社残高、会社ポイント残高、総チャージハニーコイン、総チャージ金額取得
		ComCoinPointEntity entityByCharge = companyTblMapper.getCharge(companyId);
		//総利用ハニーコイン、総利用ポイント取得
		ComCoinPointEntity entityByCons = companyTblMapper.getCons(companyId);
		//今月チャージハニーコイン取得
		ComCoinPointEntity entityByMonthAcquired = companyTblMapper.getMonthAcquired(companyId);
		//今月利用ハニーコイン取得
		ComCoinPointEntity entityByMonthUsed = companyTblMapper.getMonthUsed(companyId);
		//まもなく締切日と金額取得
		ComCoinPointEntity entityBytLastDate = companyTblMapper.getLastDate(companyId);
		
		B0801Bean bean = new B0801Bean();
		ComHoneyCoinBean comHoneyCoinBean = new ComHoneyCoinBean();
		ComPointBean comPointBean = new ComPointBean();
		List<ComCouponBean> comCouponBean = new ArrayList<ComCouponBean>();
		if(entityByCharge != null) {
			//ハニーコイン編集
			comHoneyCoinBean.setRemainderCoin(EditUtil.intUtil(entityByCharge.getRemainderCoin()));
			comHoneyCoinBean.setChargeSumMoney(EditUtil.intUtil(entityByCharge.getChargeSumMoney()));
			comHoneyCoinBean.setSumAcquiredCoin(EditUtil.intUtil(entityByCharge.getSumAcquiredCoin()));
			//ポイント編集
			comPointBean.setRemainderPoint(EditUtil.intUtil(entityByCharge.getRemainderPoint()));
		}else {
			//ハニーコイン編集
			comHoneyCoinBean.setRemainderCoin("0");
			comHoneyCoinBean.setChargeSumMoney("0");
			comHoneyCoinBean.setSumAcquiredCoin("0");
			//ポイント編集
			comPointBean.setRemainderPoint("0");
		}
		if(entityByCons != null) {
			//ハニーコイン編集
			comHoneyCoinBean.setSumUsedCoin(EditUtil.intUtil(entityByCons.getSumUsedCoin()));
			//ポイント編集
			comPointBean.setSumAcquiredPoint(EditUtil.intUtil(entityByCons.getSumAcquiredPoint()));
		}else {
			//ハニーコイン編集
			comHoneyCoinBean.setSumUsedCoin("0");
			//ポイント編集
			comPointBean.setSumAcquiredPoint("0");
		}
		if(entityByMonthAcquired != null) {
			//ハニーコイン編集
			comHoneyCoinBean.setMonAcquiredCoin(EditUtil.intUtil(entityByMonthAcquired.getMonAcquiredCoin()));
		}else {
			//ハニーコイン編集
			comHoneyCoinBean.setMonAcquiredCoin("0");
		}
		if (entityByMonthUsed  != null) {
			//ハニーコイン編集
			comHoneyCoinBean.setMonUsedCoin(EditUtil.intUtil(entityByMonthUsed.getMonUsedCoin()));
		}else {
			//ハニーコイン編集
			comHoneyCoinBean.setMonUsedCoin("0");
		}
		if (entityBytLastDate  != null) {
			comHoneyCoinBean.setDeadlineMoney(EditUtil.intUtil(entityBytLastDate.getDeadlineMoney()));
			comHoneyCoinBean.setDeadlineSoon(EditUtil.dateUtil(entityBytLastDate.getDeadlineSoon()));
		}else {
			comHoneyCoinBean.setDeadlineMoney("0");
			comHoneyCoinBean.setDeadlineSoon("");
		}
		//会社クーポンリスト取得
		List<ComCouponTblEntity> comCouponTblEntity =  couponMstMapper.getCompanyAll(companyId);
		for (ComCouponTblEntity comCouEntity : comCouponTblEntity) {
			ComCouponBean comCoubean = new ComCouponBean();
			BeanUtils.copyProperties(comCouEntity, comCoubean);
			comCoubean.setComCouId(EditUtil.intUtil(comCouEntity.getComCouId()));
			comCoubean.setCompanyId(EditUtil.intUtil(comCouEntity.getCompanyId()));
			comCoubean.setCouponId(EditUtil.intUtil(comCouEntity.getCouponId()));
			comCoubean.setDeadline(EditUtil.timeStampUtil(comCouEntity.getDeadline()));
			comCoubean.setExpDays(EditUtil.intUtil(comCouEntity.getExpDays()));
			comCoubean.setPointNum(EditUtil.intUtil(comCouEntity.getPointNum()));
			comCouponBean.add(comCoubean);
		}
		
		//出力
		bean.setComHoneyCoinBean(comHoneyCoinBean);
		//出力
		bean.setComPointBean(comPointBean);
		//出力
		bean.setComCouponBeans(comCouponBean);
		
		return bean;
	}
	
	/**
	 * 会社資産情報取得
	 * @param companyId
	 * @param statusFlg
	 * @return List<ComCouponBean>
	 */
	@Override
	public List<ComCouponBean> getCouponAll(Integer companyId, String statusFlg) {
		List<ComCouponTblEntity> comCouponTblEntity = couponMstMapper.getCouponAll(companyId, statusFlg);
		List<ComCouponBean> beans = new ArrayList<ComCouponBean>();
		for (ComCouponTblEntity comCouEntity : comCouponTblEntity) {
			ComCouponBean comCoubean = new ComCouponBean();
			BeanUtils.copyProperties(comCouEntity, comCoubean);
			comCoubean.setComCouId(EditUtil.intUtil(comCouEntity.getComCouId()));
			comCoubean.setCompanyId(EditUtil.intUtil(comCouEntity.getCompanyId()));
			comCoubean.setCouponId(EditUtil.intUtil(comCouEntity.getCouponId()));
			comCoubean.setDeadline(EditUtil.timeStampUtil(comCouEntity.getDeadline()));
			comCoubean.setExpDays(EditUtil.intUtil(comCouEntity.getExpDays()));
			comCoubean.setPointNum(EditUtil.intUtil(comCouEntity.getPointNum()));
			beans.add(comCoubean);
		}
		return beans;
	}	
	

}
