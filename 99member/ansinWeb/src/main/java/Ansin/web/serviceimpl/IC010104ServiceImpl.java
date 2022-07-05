package Ansin.web.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ansin.web.bean.ApplicantWorkHisTblBean;
import Ansin.web.entity.ApplicantWorkHisTblEntity;
import Ansin.web.mapper.ApplicantWorkHisTblMapper;
import Ansin.web.service.C010104Service;
import Ansin.web.util.EditUtil;
import Ansin.web.vueForm.C010104VueForm;

@Service
public class IC010104ServiceImpl implements C010104Service{
	
	@Autowired
	private ApplicantWorkHisTblMapper applicantWorkHisTblMapper;

	/**
	 * C0101応募者の職歴リスト
	 */
	@Override
	public List<ApplicantWorkHisTblBean> getApplicantWorkHis(Integer applicantId) {
		List<ApplicantWorkHisTblEntity> applicantWorkHis = applicantWorkHisTblMapper.getApplicantWorkHis(applicantId);
		List<ApplicantWorkHisTblBean> applicantWorkHisBean = new ArrayList<ApplicantWorkHisTblBean>();
		for(ApplicantWorkHisTblEntity applicantWorkHisTblEntity : applicantWorkHis) {
			ApplicantWorkHisTblBean applicantWorkHisTblBean = new ApplicantWorkHisTblBean();
			applicantWorkHisBean.add(applicantWorkHisTblBean);
			BeanUtils.copyProperties(applicantWorkHisTblEntity, applicantWorkHisTblBean);
			applicantWorkHisTblBean.setApplicantId(EditUtil.intUtil(applicantWorkHisTblEntity.getApplicantId()));
			applicantWorkHisTblBean.setWorkHisId(EditUtil.intUtil(applicantWorkHisTblEntity.getWorkHisId()));
			applicantWorkHisTblBean.setIndustryId1(EditUtil.intUtil(applicantWorkHisTblEntity.getIndustryId1()));
			applicantWorkHisTblBean.setJobtypeId1_1(EditUtil.intUtil(applicantWorkHisTblEntity.getJobtypeId1_1()));
			applicantWorkHisTblBean.setJobtypeId1_2(EditUtil.intUtil(applicantWorkHisTblEntity.getJobtypeId1_2()));
			applicantWorkHisTblBean.setJobtypeId1_3(EditUtil.intUtil(applicantWorkHisTblEntity.getJobtypeId1_3()));
			applicantWorkHisTblBean.setWorkDateFrom(EditUtil.dateUtil(applicantWorkHisTblEntity.getWorkDateFrom()));
			applicantWorkHisTblBean.setWorkDateTo(EditUtil.dateUtil(applicantWorkHisTblEntity.getWorkDateTo()));
		} 
		return applicantWorkHisBean;
	}
	/**
	 * C0101応募者の職歴を新規
	 */
	@Override
	public int workHisInsert(C010104VueForm c010104VueForm) {
		// TODO Auto-generated method stub
		int workHisInsert = applicantWorkHisTblMapper.workHisInsert(c010104VueForm);
		return workHisInsert;
	}
	/**
	 * C0101応募者の職歴を更新
	 */
	@Override
	public int workHisUpdate(C010104VueForm c010104VueForm) {
		// TODO Auto-generated method stub
		int workHisUpdate = applicantWorkHisTblMapper.workHisUpdate(c010104VueForm);
		return workHisUpdate;
	}
	/**
	 * C0101応募者の職歴を削除
	 */
	@Override
	public int workHisDelete(Integer applicantId, Integer workHisId, Integer userCd) {
		// TODO Auto-generated method stub
		int workHisDelete = applicantWorkHisTblMapper.workHisDelete(applicantId, workHisId, userCd);
		return workHisDelete;
	}
}
