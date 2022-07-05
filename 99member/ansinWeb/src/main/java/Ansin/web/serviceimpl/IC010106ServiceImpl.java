package Ansin.web.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ansin.web.bean.ApplicantEduTblBean;
import Ansin.web.entity.ApplicantEduTblEntity;
import Ansin.web.mapper.ApplicantEduTblMapper;
import Ansin.web.service.C010106Service;
import Ansin.web.util.EditUtil;
import Ansin.web.vueForm.C010106VueForm;

@Service
public class IC010106ServiceImpl implements C010106Service{
	
	@Autowired
	private ApplicantEduTblMapper applicantEduTblMapper;
	
	/**
	 *  C0101応募者の学歴リスト
	 */
	@Override
	public List<ApplicantEduTblBean> getEdu(Integer applicantId) {
		List<ApplicantEduTblEntity> edu = applicantEduTblMapper.getEdu(applicantId);
		List<ApplicantEduTblBean> eduBean = new ArrayList<ApplicantEduTblBean>();
		for(ApplicantEduTblEntity applicantEduTblEntity : edu) {
			ApplicantEduTblBean applicantEduTblBean = new ApplicantEduTblBean();
			eduBean.add(applicantEduTblBean);
			BeanUtils.copyProperties(applicantEduTblEntity, applicantEduTblBean);
			applicantEduTblBean.setEducationId(EditUtil.intUtil(applicantEduTblEntity.getEducationId()));
			applicantEduTblBean.setApplicantId(EditUtil.intUtil(applicantEduTblEntity.getApplicantId()));
			applicantEduTblBean.setEduDateFrom(EditUtil.dateUtil(applicantEduTblEntity.getEduDateFrom()));
			applicantEduTblBean.setEduDateTo(EditUtil.dateUtil(applicantEduTblEntity.getEduDateTo()));
		}
		return eduBean;
	}
	/**
	 *  C0101応募者の学歴を新規
	 */
	@Override
	public int eduInsert(C010106VueForm c010106VueForm) {
		// TODO Auto-generated method stub
		int eduInsert = applicantEduTblMapper.eduInsert(c010106VueForm);
		return eduInsert;
	}
	/**
	 * C0101応募者の学歴を更新
	 */
	@Override
	public int eduUpdate(C010106VueForm c010106VueForm) {
		// TODO Auto-generated method stub
		int eduUpdate = applicantEduTblMapper.eduUpdate(c010106VueForm);
		return eduUpdate;
	}
	/**
	 * C0101応募者の学歴を削除
	 */
	@Override
	public int eduDelete(Integer applicantId, Integer educationId, Integer userCd) {
		// TODO Auto-generated method stub
		int eduDelete = applicantEduTblMapper.eduDelete(applicantId, educationId, userCd);
		return eduDelete;
	}
}
