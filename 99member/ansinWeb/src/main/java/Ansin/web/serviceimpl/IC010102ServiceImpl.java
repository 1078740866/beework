package Ansin.web.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ansin.web.bean.ApplicantQuaTblBean;
import Ansin.web.entity.ApplicantQuaTblEntity;
import Ansin.web.mapper.ApplicantQuaTblMapper;
import Ansin.web.service.C010102Service;
import Ansin.web.util.EditUtil;
import Ansin.web.vueForm.C010102VueForm;

@Service
public class IC010102ServiceImpl implements C010102Service {

	@Autowired
	private ApplicantQuaTblMapper applicantQuaTblMapper;

	/**
	 * C0101応募者の資格リスト
	 */
	@Override
	public List<ApplicantQuaTblBean> getApplicantQua(Integer applicantId) {
		List<ApplicantQuaTblEntity> applicantQua = applicantQuaTblMapper.getQua(applicantId);
		List<ApplicantQuaTblBean> applicantQuaBean = new ArrayList<ApplicantQuaTblBean>();
		for (ApplicantQuaTblEntity applicantQuaTblEntity : applicantQua) {
			ApplicantQuaTblBean applicantQuaTblBean = new ApplicantQuaTblBean();
			applicantQuaBean.add(applicantQuaTblBean);
			BeanUtils.copyProperties(applicantQuaTblEntity, applicantQuaTblBean);
			applicantQuaTblBean.setAppQuaId(EditUtil.intUtil(applicantQuaTblEntity.getAppQuaId()));
			applicantQuaTblBean.setApplicantId(EditUtil.intUtil(applicantQuaTblEntity.getApplicantId()));
			applicantQuaTblBean.setAcquisitionDate(EditUtil.dateUtil(applicantQuaTblEntity.getAcquisitionDate()));
		}
		return applicantQuaBean;
	}

	/**
	 * C0101応募者の資格を新規
	 */
	@Override
	public int insertQua(C010102VueForm c010102VueForm) {
		// TODO Auto-generated method stub
		int insertQua = applicantQuaTblMapper.quaInsert(c010102VueForm);
		return insertQua;
	}

	/**
	 * C0101応募者の資格を更新
	 */
	@Override
	public int updateQua(C010102VueForm c010102VueForm) {
		// TODO Auto-generated method stub
		int updateQua = applicantQuaTblMapper.quaUpdate(c010102VueForm);
		return updateQua;
	}

	/**
	 * C0101応募者の資格を削除
	 */
	@Override
	public int deleteQua(Integer applicantId, Integer appQuaId, Integer userCd) {
		// TODO Auto-generated method stub
		int deleteQua = applicantQuaTblMapper.quaDelete(applicantId, appQuaId, userCd);
		return deleteQua;
	}

}
