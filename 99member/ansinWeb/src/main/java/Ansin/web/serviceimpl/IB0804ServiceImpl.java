package Ansin.web.serviceimpl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ansin.web.bean.ComChargeTblBean;
import Ansin.web.bean.ComConsTblBean;
import Ansin.web.entity.ComChargeTblEntity;
import Ansin.web.entity.ComConsTblEntity;
import Ansin.web.mapper.ComChargeTblMapper;
import Ansin.web.mapper.ComConsTblMapper;
import Ansin.web.mapper.CompanyTblMapper;
import Ansin.web.mapper.CouponMstMapper;
import Ansin.web.service.B0804Service;
import Ansin.web.util.EditUtil;
import Ansin.web.vueForm.B0804VueForm;

@Service
public class IB0804ServiceImpl implements B0804Service{
	
	@Autowired
	private ComChargeTblMapper comchargeTblMapper;
	@Autowired
	private ComConsTblMapper comconsTblMapper;
	@Autowired
	private CompanyTblMapper companyTblMapper;
	@Autowired
	private CouponMstMapper couponMstMapper;
	
	
	/**
	 * チャージ履歴リストを取得
	 */
	@Override
	public List<ComChargeTblBean> getComchargeTblEntityList(ComChargeTblEntity comCharge,Timestamp dateFrom,Timestamp dateTo) {
		List<ComChargeTblEntity> comChargeTblEntity = comchargeTblMapper.getComchargeTblEntityList(comCharge, dateFrom, dateTo);
		List<ComChargeTblBean> comChargeBean = new ArrayList<ComChargeTblBean>();
		for (ComChargeTblEntity comChargeTbl : comChargeTblEntity) {
			ComChargeTblBean bean = new ComChargeTblBean();
			BeanUtils.copyProperties(comChargeTbl, bean);
			bean.setChargeId(EditUtil.intUtil(comChargeTbl.getChargeId()));
			bean.setCompanyId(EditUtil.intUtil(comChargeTbl.getCompanyId()));
			bean.setChargeTime(EditUtil.timeStampUtil(comChargeTbl.getChargeTime()));
			bean.setChargeMoney(EditUtil.intUtil(comChargeTbl.getChargeMoney()));
			bean.setChargeHoney(EditUtil.intUtil(comChargeTbl.getChargeHoney()));
			bean.setRemainder(EditUtil.intUtil(comChargeTbl.getRemainder()));
			bean.setHoneyLastDate(EditUtil.dateUtil(comChargeTbl.getHoneyLastDate()));
			comChargeBean.add(bean);
		}
		return comChargeBean;
	}

	/**
	 * 消費履歴リストを取得
	 */
	@Override
	public List<ComConsTblBean> getComconsTblEntityList(ComConsTblEntity comCons,Timestamp dateFrom,Timestamp dateTo) {
		List<ComConsTblEntity> comConsTblEntity = comconsTblMapper.getComconsTblEntityList(comCons,dateFrom,dateTo);
		List<ComConsTblBean> comConsBean = new ArrayList<ComConsTblBean>();
		for (ComConsTblEntity comConsTbl : comConsTblEntity) {
			ComConsTblBean bean = new ComConsTblBean();
			BeanUtils.copyProperties(comConsTbl, bean);
			bean.setCompanyId(EditUtil.intUtil(comConsTbl.getCompanyId()));
			bean.setConsHoney(EditUtil.intUtil(comConsTbl.getConsHoney()));
			bean.setConsId(EditUtil.intUtil(comConsTbl.getConsId()));
			bean.setCouponId(EditUtil.intUtil(comConsTbl.getCouponId()));
			bean.setEarnPoint(EditUtil.intUtil(comConsTbl.getEarnPoint()));
			bean.setItemId(EditUtil.intUtil(comConsTbl.getItemId()));
			if(comConsTbl.getCouponId() != null) {
				bean.setCouponNm(couponMstMapper.getCouponNm(comConsTbl.getCouponId()));
			}else {
				bean.setCouponNm("無し");
			}
			comConsBean.add(bean);
		}
		return comConsBean;
	}

	
	/**
	 * 会社チャージ履歴編集
	 * @param b0804VueForm
	 * @return ComchargeTblEntity
	 */
	public ComChargeTblEntity editB08041(B0804VueForm b0804VueForm) {
		ComChargeTblEntity comChargeTblEntity = new ComChargeTblEntity();
		if (b0804VueForm != null) {
			BeanUtils.copyProperties(b0804VueForm, comChargeTblEntity);
		}
		return comChargeTblEntity;
	}
	
	/**
	 * 会社支払履歴編集
	 * @param b0804VueForm
	 * @return ComconsTblEntity
	 */
	public ComConsTblEntity editB08042(B0804VueForm b0804VueForm) {
		ComConsTblEntity comConsTblEntity = new ComConsTblEntity();
		if (b0804VueForm != null) {
			BeanUtils.copyProperties(b0804VueForm, comConsTblEntity);
			comConsTblEntity.setItemId(EditUtil.intUtil(b0804VueForm.getItemId()));
		}
		return comConsTblEntity;
	}

	/**
	 * 会社チャージ状態変更
	 * @param companyId
	 * @param chargeId
	 * @return Integer
	 */
	@Override
	public Integer changeChargeFlg(Integer companyId, Integer chargeId) {
		return comchargeTblMapper.changeChargeFlg(companyId, chargeId);
	}


	@Override
	public Integer changeCom(Integer companyId, Integer Money, Integer coin) {
		return companyTblMapper.changeCom(companyId, Money, coin);
	}
	
}
