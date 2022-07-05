package Ansin.web.serviceimpl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ansin.web.bean.InterviewHisTblBean;
import Ansin.web.entity.InterviewHisTblEntity;
import Ansin.web.mapper.InterviewInfoMapper;
import Ansin.web.service.B0402Service;
import Ansin.web.util.EditUtil;
import Ansin.web.vueForm.B0402VueForm;

/**
 * B0402 面接詳細情報 interviewInfo
 * 
 * @author コウ テンキ
 * @date 2020-10-22 14:19:27
 */

@Service
public class IB0402ServiceImpl implements B0402Service {

	@Autowired
	private InterviewInfoMapper interviewInfoMapper;

	/**
	 * B0402 面接詳細情報 初期表示
	 * 
	 * @param interviewId
	 * @return B0402VueForm
	 */
	@Override
	public InterviewHisTblBean getInit(Integer interviewId) {
		InterviewHisTblEntity interviewHisTblEntity = interviewInfoMapper.getInit(interviewId);
		InterviewHisTblBean interviewHisTblBean = new InterviewHisTblBean();
		if (interviewHisTblEntity != null) {
			BeanUtils.copyProperties(interviewHisTblEntity, interviewHisTblBean);
			interviewHisTblBean.setInterviewId(EditUtil.intUtil(interviewHisTblEntity.getInterviewId()));
			interviewHisTblBean.setCompanyId(EditUtil.intUtil(interviewHisTblEntity.getCompanyId()));
			interviewHisTblBean.setPositionId(EditUtil.intUtil(interviewHisTblEntity.getPositionId()));
			interviewHisTblBean.setApplicantId(EditUtil.intUtil(interviewHisTblEntity.getApplicantId()));
			interviewHisTblBean.setInterviewDate(EditUtil.dateUtil(interviewHisTblEntity.getInterviewDate()));
			interviewHisTblBean.setDateFrom(EditUtil.timeUtil(interviewHisTblEntity.getDateFrom()));
			interviewHisTblBean.setDateTo(EditUtil.timeUtil(interviewHisTblEntity.getDateTo()));
		}
		return interviewHisTblBean;
	}

	/**
	 * B0402 面接詳細情報 データ更新
	 * 
	 * @param b0402VueForm
	 * @return Integer
	 */
	@Override
	public Integer update(B0402VueForm b0402VueForm) {
		return interviewInfoMapper.update(b0402VueForm);
	}

	
	/**
	 * B0402 面接詳細情報 データ新規
	 * 
	 * @param b0402VueForm
	 * @return Integer
	 */
	@Override
	public Integer insert(B0402VueForm b0402VueForm) {
		return interviewInfoMapper.insert(b0402VueForm);
	}



}
