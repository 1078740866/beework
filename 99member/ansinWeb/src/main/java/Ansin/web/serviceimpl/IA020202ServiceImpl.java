package Ansin.web.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ansin.web.bean.IndustryMstBean;
import Ansin.web.bean.TrainingInfoTblBean;
import Ansin.web.entity.IndustryMstEntity;
import Ansin.web.entity.TrainingInfoTblEntity;
import Ansin.web.mapper.IndustryMstMapper;
import Ansin.web.mapper.TrainingApplTblMapper;
import Ansin.web.mapper.TrainingTblMapper;
import Ansin.web.service.A020202Service;
import Ansin.web.util.EditUtil;
import Ansin.web.vueForm.A020202VueForm;

@Service
public class IA020202ServiceImpl implements A020202Service{
	@Autowired
	private TrainingTblMapper trainingTblMapper;
	@Autowired
	private IndustryMstMapper industryMapper;
	@Autowired
	private TrainingApplTblMapper trainingApplTblMapper;

	/**
	 * 研修情報を取得
	 * @return training
	 */
	@Override
	public List<TrainingInfoTblBean> getAllTrainingInitCount(A020202VueForm trainingEntity){
		List<TrainingInfoTblEntity> trainingInfoTblEntity = trainingTblMapper.getAllTra(trainingEntity);
		List<TrainingInfoTblBean> trainingInfoTblBean = new ArrayList<TrainingInfoTblBean>();
		for (TrainingInfoTblEntity trainingInfoEntity : trainingInfoTblEntity) {
			TrainingInfoTblBean bean = new TrainingInfoTblBean();
			BeanUtils.copyProperties(trainingInfoEntity, bean);
			bean.setCompanyId(EditUtil.intUtil(trainingInfoEntity.getCompanyId()));
			bean.setIndustryId(EditUtil.intUtil(trainingInfoEntity.getIndustryId()));
			bean.setTrainingId(EditUtil.intUtil(trainingInfoEntity.getTrainingId()));
			bean.setDateFrom(EditUtil.dateUtil(trainingInfoEntity.getDateFrom()));
			bean.setDateTo(EditUtil.dateUtil(trainingInfoEntity.getDateTo()));
			bean.setTimeFrom(EditUtil.timeUtil(trainingInfoEntity.getTimeFrom()));
			bean.setTimeTo(EditUtil.timeUtil(trainingInfoEntity.getTimeTo()));
			bean.setProCnt(EditUtil.intUtil(trainingInfoEntity.getProCnt()));
			bean.setCost(EditUtil.intUtil(trainingInfoEntity.getCost()));
			trainingInfoTblBean.add(bean);
		}
		return trainingInfoTblBean;
	}
		
	/**
	 * 研修情報の削除または複数削除
	 * @return 
	 */
	@Override
	public Integer update(List<Integer> trainingIdList,Integer userCd,Integer applicantId) {
		Integer updateReturn = trainingApplTblMapper.deleteTra(trainingIdList, userCd, applicantId);
		return updateReturn;
	}

	/**
	 * 全部業種を取得
	 * @return
	 */
	@Override
	public List<IndustryMstBean> getAllIndustry(){
		List<IndustryMstEntity> industryMstEntity = industryMapper.getAll();
		List<IndustryMstBean> industryMstBean = new ArrayList<IndustryMstBean>();
		for (IndustryMstEntity industryEntity : industryMstEntity) {
			IndustryMstBean bean = new IndustryMstBean();
			BeanUtils.copyProperties(industryEntity, bean);
			bean.setIndustryId(EditUtil.intUtil(industryEntity.getIndustryId()));
			industryMstBean.add(bean);
		}
		return industryMstBean;
	}
	
}
