package Ansin.web.serviceimpl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ansin.web.bean.BriefingInfoTblBean;
import Ansin.web.bean.PositionTblBean;
import Ansin.web.bean.TrainingInfoTblBean;
import Ansin.web.entity.BriefingInfoTblEntity;
import Ansin.web.entity.PositionTblEntity;
import Ansin.web.entity.TrainingInfoTblEntity;
import Ansin.web.mapper.BriefingTblMapper;
import Ansin.web.mapper.PositionTblMapper;
import Ansin.web.mapper.TrainingTblMapper;
import Ansin.web.service.A0602Service;
import Ansin.web.util.EditUtil;
@Service
public class IA0602ServiceImpl implements A0602Service{
	
	@Autowired
	private PositionTblMapper positionTblMapper;
	@Autowired
	private TrainingTblMapper trainingTblMapper;
	@Autowired
	private BriefingTblMapper briefingTblMapper;
	

	/**
	 * 通報詳細情報取得(職位)
	 * @param positionId
	 * @return PositionTblBean
	 */
	@Override
	public PositionTblBean getPosition(Integer positionId) {
		PositionTblEntity position = positionTblMapper.getOne(positionId);
		if (position != null) {
			PositionTblBean bean = new PositionTblBean();
			BeanUtils.copyProperties(position, bean);
			bean.setCompanyId(EditUtil.intUtil(position.getCompanyId()));
			bean.setUserCd(EditUtil.intUtil(position.getUserCd()));
			bean.setPositionId(EditUtil.intUtil(position.getPositionId()));
			bean.setIndustryId(EditUtil.intUtil(position.getIndustryId()));
			bean.setJobTypeId(EditUtil.intUtil(position.getJobTypeId()));
			bean.setSkillId(EditUtil.intUtil(position.getSkillId()));
			bean.setWorkTimeFrom(EditUtil.timeUtil(position.getWorkTimeFrom()));
			bean.setWorkTimeTo(EditUtil.timeUtil(position.getWorkTimeTo()));
			bean.setSalaryMin(EditUtil.intUtil(position.getSalaryMin()));
			bean.setSalaryMax(EditUtil.intUtil(position.getSalaryMax()));
			bean.setPeoCnt(EditUtil.intUtil(position.getPeoCnt()));
			bean.setWorkDateStr(EditUtil.dateUtil(position.getWorkDateStr()));
			bean.setExpDate(EditUtil.dateUtil(position.getExpDate()));
			bean.setUpdateTime(EditUtil.dateUtil(position.getUpdateTime()));
			return bean;
		}
		return null;
	}


	/**
	 * 通報詳細情報取得(研修会)
	 * @param trainingId
	 * @return TrainingInfoTblBean
	 */
	@Override
	public TrainingInfoTblBean getTraining(Integer trainingId) {
		TrainingInfoTblEntity entity = trainingTblMapper.getOne(trainingId);
		if (entity != null) {
			TrainingInfoTblBean bean = new TrainingInfoTblBean();
			BeanUtils.copyProperties(entity, bean);
			bean.setCompanyId(EditUtil.intUtil(entity.getCompanyId()));
			bean.setIndustryId(EditUtil.intUtil(entity.getIndustryId()));
			bean.setTrainingId(EditUtil.intUtil(entity.getTrainingId()));
			bean.setDateFrom(EditUtil.dateUtil(entity.getDateFrom()));
			bean.setDateTo(EditUtil.dateUtil(entity.getDateTo()));
			bean.setTimeFrom(EditUtil.timeUtil(entity.getTimeFrom()));
			bean.setTimeTo(EditUtil.timeUtil(entity.getTimeTo()));
			bean.setProCnt(EditUtil.intUtil(entity.getProCnt()));
			bean.setCost(EditUtil.intUtil(entity.getCost()));
			return bean;
		}
		return null;
	}

	/**
	 * 通報詳細情報取得(説明会)
	 * @param briefingId
	 * @return BriefingInfoTblBean
	 */
	@Override
	public BriefingInfoTblBean getBriefing(Integer briefingId) {
		BriefingInfoTblEntity entity = briefingTblMapper.getOne(briefingId);
		if (entity != null) {
			BriefingInfoTblBean bean = new BriefingInfoTblBean();
    		BeanUtils.copyProperties(entity, bean);
    		bean.setBriefingId(EditUtil.intUtil(entity.getBriefingId()));
    		bean.setCompanyId(EditUtil.intUtil(entity.getCompanyId()));
    		bean.setBriefingDate(EditUtil.dateUtil(entity.getBriefingDate()));
    		bean.setDateFrom(EditUtil.timeUtil(entity.getDateFrom()));
    		bean.setDateTo(EditUtil.timeUtil(entity.getDateTo()));
    		bean.setProCntPlan(EditUtil.intUtil(entity.getProCntPlan()));
			return bean;
		}
		return null;
	}
	
}
