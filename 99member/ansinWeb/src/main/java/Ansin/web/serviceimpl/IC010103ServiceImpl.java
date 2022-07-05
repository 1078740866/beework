package Ansin.web.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ansin.web.bean.ApplicantSkillTblBean;
import Ansin.web.entity.ApplicantSkillTblEntity;
import Ansin.web.mapper.ApplicantSkillTblMapper;
import Ansin.web.service.C010103Service;
import Ansin.web.util.EditUtil;
import Ansin.web.vueForm.C010103VueForm;

@Service
public class IC010103ServiceImpl implements C010103Service {

	@Autowired
	private ApplicantSkillTblMapper applicantSkillTblMapper;

	/**
	 * C0101応募者のスキルリスト
	 */
	@Override
	public List<ApplicantSkillTblBean> getApplicantSkill(Integer applicantId) {
		List<ApplicantSkillTblEntity> applicantSkill = applicantSkillTblMapper.getSkill(applicantId);
		List<ApplicantSkillTblBean> applicantSkillBean = new ArrayList<ApplicantSkillTblBean>();
		for (ApplicantSkillTblEntity applicantSkillTblEntity : applicantSkill) {
			ApplicantSkillTblBean applicantSkillTblBean = new ApplicantSkillTblBean();
			applicantSkillBean.add(applicantSkillTblBean);
			BeanUtils.copyProperties(applicantSkillTblEntity, applicantSkillTblBean);
			applicantSkillTblBean.setApplicantId(EditUtil.intUtil(applicantSkillTblEntity.getApplicantId()));
			applicantSkillTblBean.setAppSkillId(EditUtil.intUtil(applicantSkillTblEntity.getAppSkillId()));
			applicantSkillTblBean.setSkillId(EditUtil.intUtil(applicantSkillTblEntity.getSkillId()));
			applicantSkillTblBean.setIndustryId(EditUtil.intUtil(applicantSkillTblEntity.getIndustryId()));
			applicantSkillTblBean.setJobtypeNm(EditUtil.intUtil(applicantSkillTblEntity.getJobtypeId()));
		}
		return applicantSkillBean;
	}

	/**
	 * C0101応募者のスキルを新規
	 */
	@Override
	public int skillInsert(C010103VueForm c010103VueForm) {
		// TODO Auto-generated method stub
		int skillInsert = applicantSkillTblMapper.skillInsert(c010103VueForm);
		return skillInsert;
	}

	/**
	 * C0101応募者のスキルを更新
	 */
	@Override
	public int skillUpdate(C010103VueForm c010103VueForm) {
		// TODO Auto-generated method stub
		int skillUpdate = applicantSkillTblMapper.skillUpdate(c010103VueForm);
		return skillUpdate;
	}

	/**
	 * C0101応募者のスキルを削除
	 */
	@Override
	public int skillDelete(String applicantId, String appSkillId, Integer userCd) {

		int a = EditUtil.intUtil(applicantId);
		int b = EditUtil.intUtil(appSkillId);

		// TODO Auto-generated method stub
		int skillDelete = applicantSkillTblMapper.skillDelete(a, b, userCd);
		return skillDelete;
	}

}
