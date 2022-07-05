package Ansin.web.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ansin.web.bean.ApplicantLanTblBean;
import Ansin.web.entity.ApplicantLanTblEntity;
import Ansin.web.mapper.ApplicantLanTblMapper;
import Ansin.web.service.C010105Service;
import Ansin.web.util.EditUtil;
import Ansin.web.vueForm.C010105VueForm;

@Service
public class IC010105ServiceImpl implements C010105Service{
	
	@Autowired
	private ApplicantLanTblMapper applicantLanTblMapper;
	
	/**
	 *  C0101応募者の言語リスト
	 */
	@Override
	public List<ApplicantLanTblBean> getAll(Integer applicantId) {
		List<ApplicantLanTblEntity> lan = applicantLanTblMapper.getAll(applicantId);
		List<ApplicantLanTblBean> lanBean = new ArrayList<ApplicantLanTblBean>();
		for(ApplicantLanTblEntity applicantLanTblEntity : lan) {
			ApplicantLanTblBean applicantLanTblBean = new ApplicantLanTblBean();
			lanBean.add(applicantLanTblBean);
			BeanUtils.copyProperties(applicantLanTblEntity, applicantLanTblBean);
			applicantLanTblBean.setApplicantId(EditUtil.intUtil(applicantLanTblEntity.getApplicantId()));
			applicantLanTblBean.setLanguageId(EditUtil.intUtil(applicantLanTblEntity.getLanguageId()));
		}
		return lanBean;
	}
	/**
	 * C0101応募者の言語を新規
	 */
	@Override
	public int lanInsert(C010105VueForm c010105VueForm) {
		// TODO Auto-generated method stub
		int lanInsert = applicantLanTblMapper.lanInsert(c010105VueForm);
		return lanInsert;
	}
	/**
	 *  C0101応募者の言語を更新
	 */
	@Override
	public int lanUpdate(C010105VueForm c010105VueForm) {
		// TODO Auto-generated method stub
		int lanUpdate = applicantLanTblMapper.lanUpdate(c010105VueForm);
		return lanUpdate;
	}
	/**
	 * C0101応募者の言語を削除
	 */
	@Override
	public int lanDelete(Integer applicantId, Integer languageId, Integer userCd) {
		// TODO Auto-generated method stub
		int lanDelete = applicantLanTblMapper.lanDelete(applicantId, languageId, userCd);
		return lanDelete;
	}
}
