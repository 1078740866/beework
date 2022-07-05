package Ansin.web.serviceimpl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ansin.web.bean.CompanyInfoBean;
import Ansin.web.bean.WaribikiMstBean;
import Ansin.web.entity.CompanyTblEntity;
import Ansin.web.entity.WaribikiMstEntity;
import Ansin.web.mapper.ComChargeTblMapper;
import Ansin.web.mapper.CompanyTblMapper;
import Ansin.web.mapper.WaribikiMstMapper;
import Ansin.web.service.B0803Service;
import Ansin.web.util.EditUtil;
import Ansin.web.vueForm.B0803VueForm;

@Service
public class IB0803ServiceImpl implements B0803Service{
	
	@Autowired
	private CompanyTblMapper companyTblMapper;
	@Autowired
	private ComChargeTblMapper comChargeTblMapper;	
	@Autowired
	private WaribikiMstMapper waribikiMstMapper;	
	
	/**
	 * チャージ時会社情報取得
	 * 
	 * @param companyId
	 * @return CompanyInfoBean
	 */
	@Override
	public CompanyInfoBean getCompany(Integer companyId) {
		CompanyTblEntity companyTblEntity =  companyTblMapper.getCompanyInfoById(companyId);
		WaribikiMstEntity waribikiMstEntity  =  waribikiMstMapper.getAll();
		CompanyInfoBean bean = new CompanyInfoBean();
		if (companyTblEntity != null) {
			BeanUtils.copyProperties(companyTblEntity, bean);
			bean.setCompanyId(EditUtil.intUtil(companyTblEntity.getCompanyId()));
			bean.setLevelId(EditUtil.intUtil(companyTblEntity.getLevelId()));
			bean.setRemainder(EditUtil.intUtil(companyTblEntity.getRemainder()));
			WaribikiMstBean bean2 = new WaribikiMstBean();
			bean2.setWaribiki1(EditUtil.doubleUtil(waribikiMstEntity.getWaribiki1()));
			bean2.setWaribiki2(EditUtil.doubleUtil(waribikiMstEntity.getWaribiki2()));
			bean2.setWaribiki3(EditUtil.doubleUtil(waribikiMstEntity.getWaribiki3()));
			bean2.setWaribiki4(EditUtil.doubleUtil(waribikiMstEntity.getWaribiki4()));
			bean2.setWaribiki5(EditUtil.doubleUtil(waribikiMstEntity.getWaribiki5()));
			bean2.setSyohizei(EditUtil.doubleUtil(waribikiMstEntity.getSyohizei()));
			bean2.setCreateTime(EditUtil.timeStampUtil(waribikiMstEntity.getCreateTime()));
			bean2.setUpdateTime(EditUtil.timeStampUtil(waribikiMstEntity.getUpdateTime()));
			bean.setBean(bean2);
			return bean;
		} else {
			return null;
		}
	}
	
	/**
	 * チャージ
	 * 
	 * @param comChargeTblEntity
	 * @return Integer
	 */
	@Override
	public Integer getCharge(B0803VueForm b0803VueForm) {
		switch (b0803VueForm.getPayMethod()) {
		case "0":
			b0803VueForm.setPayMethod("クレジットカード");
			break;
		case "1":
			b0803VueForm.setPayMethod("コンビニ");
			break;
		case "2":
			b0803VueForm.setPayMethod("携帯");
			break;
		case "3":
			b0803VueForm.setPayMethod("銀行振込");
			break;
		default:
		}
		return comChargeTblMapper.gerCharge(b0803VueForm);
	}
	

}
