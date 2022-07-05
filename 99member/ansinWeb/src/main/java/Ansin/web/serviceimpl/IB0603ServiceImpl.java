package Ansin.web.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ansin.web.bean.BriefingApplTblBean;
import Ansin.web.entity.BriefingApplTblEntity;
import Ansin.web.mapper.BriefingApplTblMapper;
import Ansin.web.service.B0603Service;
import Ansin.web.util.EditUtil;
import Ansin.web.vueForm.B0603VueForm;

@Service
public class IB0603ServiceImpl implements B0603Service{
	
	@Autowired
	private BriefingApplTblMapper briefingApplMapper;	
	
	/**
	 * 説明会応募者リストを取得する
	 * @param b0201VueForm
	 * @return List<BriefingApplEntity>
	 */
	@Override
	public List<BriefingApplTblBean> getBriefingApplEntities(B0603VueForm b0603VueForm) {
		List<BriefingApplTblEntity> briefingApplEntity = briefingApplMapper.briefingApplList(b0603VueForm);
		List<BriefingApplTblBean> briefingApplList = new ArrayList<BriefingApplTblBean>();
		for (BriefingApplTblEntity briefingAppl : briefingApplEntity) {
			BriefingApplTblBean bean = new BriefingApplTblBean();
			BeanUtils.copyProperties(briefingAppl, bean);
			bean.setApplicantId(EditUtil.intUtil(briefingAppl.getApplicantId()));
			bean.setBriefingId(EditUtil.intUtil(briefingAppl.getBriefingId()));
			bean.setCompanyId(EditUtil.intUtil(briefingAppl.getCompanyId()));
			bean.setUserCd(EditUtil.intUtil(briefingAppl.getUserCd()));
			bean.setBirthday(EditUtil.dateUtil(briefingAppl.getBirthday()));
			briefingApplList.add(bean);
		}
		return briefingApplList;
	}

}
