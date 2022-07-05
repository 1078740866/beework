package Ansin.web.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ansin.web.bean.InterviewHisTblBean;
import Ansin.web.entity.InterviewHisTblEntity;
import Ansin.web.mapper.InterviewHisTblMapper;
import Ansin.web.service.A020204Service;
import Ansin.web.util.EditUtil;
import Ansin.web.vueForm.A020204VueForm;

/**
 * A020204面接一覧画面Service
 * 
 * @author 楊卿赫
 * @date 2020-11-18 17:30:07
 */

@Service
public class IA020204ServiceImpl implements A020204Service {

	@Autowired
	private InterviewHisTblMapper interviewHisTblMapper;

	/**
	 * A020204 面接一覧画面データ
	 * 
	 * @param b0401VueForm
	 * @return List<InterviewHisTblEntity>
	 */
	@Override
	public List<InterviewHisTblBean> getInterviewHisTblEntityList(A020204VueForm a020204VueForm) {
		List<InterviewHisTblEntity> interviewHisTblEntityList = interviewHisTblMapper.getInterview(a020204VueForm);
		List<InterviewHisTblBean> interviewHisTblBeanList = new ArrayList<InterviewHisTblBean>();
		
		for(InterviewHisTblEntity interviewHisTblEntity : interviewHisTblEntityList) {
			InterviewHisTblBean interviewHisTblBean = new InterviewHisTblBean();
			BeanUtils.copyProperties(interviewHisTblEntity, interviewHisTblBean);
			interviewHisTblBean.setInterviewId(EditUtil.intUtil(interviewHisTblEntity.getInterviewId()));
			interviewHisTblBean.setCompanyId(EditUtil.intUtil(interviewHisTblEntity.getCompanyId()));
			interviewHisTblBean.setPositionId(EditUtil.intUtil(interviewHisTblEntity.getPositionId()));
			interviewHisTblBean.setApplicantId(EditUtil.intUtil(interviewHisTblEntity.getApplicantId()));
			interviewHisTblBean.setInterviewDate(EditUtil.dateUtil(interviewHisTblEntity.getInterviewDate()));
			interviewHisTblBean.setDateFrom(EditUtil.timeUtil(interviewHisTblEntity.getDateFrom()));
			interviewHisTblBean.setDateTo(EditUtil.timeUtil(interviewHisTblEntity.getDateTo()));
			interviewHisTblBeanList.add(interviewHisTblBean);
		}
		return interviewHisTblBeanList;
	}

	/**
	 * A020204 面接一覧画面削除
	 * 
	 * @param interviewIdList
	 * @param companyId
	 * @return int
	 */
	@Override
	public Integer update(List<Integer> interviewIdList, Integer applicantId) {
		return interviewHisTblMapper.updateInterview(interviewIdList, applicantId);
	}

	

}
