package Ansin.web.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ansin.web.bean.PositionTblBean;
import Ansin.web.entity.PositionTblEntity;
import Ansin.web.mapper.ApplicationTblMapper;
import Ansin.web.mapper.PositionTblMapper;
import Ansin.web.service.A020205Service;
import Ansin.web.util.EditUtil;
import Ansin.web.vueForm.A020205VueForm;

@Service
public class IA020205ServiceImpl implements A020205Service{
	
	@Autowired
	private PositionTblMapper positionTblMapper;
	@Autowired
	private ApplicationTblMapper applicationTblMapper;
	
	
	/**
	 * 職位一覧リスト
	 */
	@Override
	public List<PositionTblBean> getPositionAll(A020205VueForm a020205VueForm) {
		
		List<PositionTblEntity> positionTblEntityList = positionTblMapper.getPositionList(a020205VueForm);
		
		List<PositionTblBean> positionTblList = new ArrayList<PositionTblBean>();
		
		for(PositionTblEntity positionTblEntity : positionTblEntityList) {
			
			PositionTblBean positionTblBean = new PositionTblBean();
			
			BeanUtils.copyProperties(positionTblEntity, positionTblBean);
			
			positionTblBean.setCompanyId(EditUtil.intUtil(positionTblEntity.getCompanyId()));
			positionTblBean.setUserCd(EditUtil.intUtil(positionTblEntity.getUserCd()));
			positionTblBean.setPositionId(EditUtil.intUtil(positionTblEntity.getPositionId()));
			positionTblBean.setIndustryId(EditUtil.intUtil(positionTblEntity.getIndustryId()));
			positionTblBean.setJobTypeId(EditUtil.intUtil(positionTblEntity.getJobTypeId()));
			positionTblBean.setSkillId(EditUtil.intUtil(positionTblEntity.getSkillId()));
			positionTblBean.setWorkTimeFrom(EditUtil.dateUtil(positionTblEntity.getWorkTimeFrom()));
			positionTblBean.setWorkTimeTo(EditUtil.dateUtil(positionTblEntity.getWorkTimeTo()));
			positionTblBean.setSalaryMin(EditUtil.intUtil(positionTblEntity.getSalaryMin()));
			positionTblBean.setSalaryMax(EditUtil.intUtil(positionTblEntity.getSalaryMax()));
			positionTblBean.setPeoCnt(EditUtil.intUtil(positionTblEntity.getPeoCnt()));
			positionTblBean.setWorkDateStr(EditUtil.dateUtil(positionTblEntity.getWorkDateStr()));
			positionTblBean.setExpDate(EditUtil.dateUtil(positionTblEntity.getExpDate()));
			positionTblBean.setUpdateTime(EditUtil.dateUtil(positionTblEntity.getUpdateTime()));

			positionTblList.add(positionTblBean);
		}		
 		return positionTblList;
	}
	/**
	 * 職位をオンラインするとオフラインするまたは複数操作
	 */
	@Override
	public Integer positionOnlineOrOffline(List<Integer> positionIdList, String onlineStatus, Integer companyId,
			Integer userCd) {
		return positionTblMapper.positionOnlineOrOffline(positionIdList, onlineStatus, companyId, userCd);
	}
	
	@Override
	public Integer deleteApplication(A020205VueForm a020205VueForm) {
		int deleteApplication = applicationTblMapper.deleteAppl(a020205VueForm);
		return deleteApplication;
	}
	
}
