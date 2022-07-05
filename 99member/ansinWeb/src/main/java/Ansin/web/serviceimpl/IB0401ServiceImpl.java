package Ansin.web.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ansin.web.bean.InterviewHisTblBean;
import Ansin.web.entity.InterviewHisTblEntity;
import Ansin.web.mapper.InterviewHisTblMapper;
import Ansin.web.service.B0401Service;
import Ansin.web.util.EditUtil;
import Ansin.web.vueForm.B0401VueForm;

/**
 * B0401 面接一覧画面Service
 * 
 * @author コウ テンキ
 * @date 2020-10-19 17:30:07
 */

@Service
public class IB0401ServiceImpl implements B0401Service {

	@Autowired
	private InterviewHisTblMapper interviewHisTblMapper;

	/**
	 * B0401 面接一覧画面データ
	 * 
	 * @param b0401VueForm
	 * @return List<InterviewHisTblEntity>
	 */
	@Override
	public List<InterviewHisTblBean> getInterviewHisTblEntityList(B0401VueForm b0401VueForm) {
		List<InterviewHisTblEntity> interviewHisTblEntityList = interviewHisTblMapper.getAllInterviewHisTblEntities(b0401VueForm);
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
			interviewHisTblBean.setName(interviewHisTblEntity.getFirstName() + " " + interviewHisTblEntity.getLastName());
			interviewHisTblBeanList.add(interviewHisTblBean);
		}
		return interviewHisTblBeanList;
	}

	/**
	 * B0401 面接一覧画面削除
	 * 
	 * @param interviewIdList
	 * @param companyId
	 * @return int
	 */
	@Override
	public Integer update(List<Integer> interviewIdList, Integer companyId, Integer userCd) {
		return interviewHisTblMapper.update(interviewIdList, companyId, userCd);
	}

	

}
