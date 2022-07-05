package Ansin.web.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ansin.web.bean.IndustryMstBean;
import Ansin.web.bean.PrefecturesMstBean;
import Ansin.web.bean.TrainingInfoTblBean;
import Ansin.web.entity.ApplicantConnEntity;
import Ansin.web.entity.IndustryMstEntity;
import Ansin.web.entity.PrefecturesMstEntity;
import Ansin.web.entity.TrainingInfoTblEntity;
import Ansin.web.mapper.ApplicantInfoTblMapper;
import Ansin.web.mapper.IndustryMstMapper;
import Ansin.web.mapper.PrefecturesMstMapper;
import Ansin.web.mapper.TrainingApplTblMapper;
import Ansin.web.mapper.TrainingTblMapper;
import Ansin.web.service.C0301Service;
import Ansin.web.util.EditUtil;
import Ansin.web.vueForm.C0301ListVueForm;
import Ansin.web.vueForm.C0301VueForm;

@Service
public class IC0301ServiceImpl implements C0301Service{
	
	 @Autowired
	 private TrainingTblMapper trainingTblMapper;
	 @Autowired
	 private TrainingApplTblMapper trainingApplTblMapper;
	 @Autowired
	 private ApplicantInfoTblMapper applicantInfoTblMapper;
	 @Autowired
	 private IndustryMstMapper industryMstMapper;
	 @Autowired
	 private PrefecturesMstMapper prefecturesMstMapper;
	
	 
	 @Override
	public List<IndustryMstBean> getAllIndustry() {
			List<IndustryMstEntity> allIndustry = industryMstMapper.getAll();
			List<IndustryMstBean> allIndustryBean = new ArrayList<IndustryMstBean>();
			for(IndustryMstEntity industryMstEntity : allIndustry) {
				IndustryMstBean industryMstBean = new IndustryMstBean();
				allIndustryBean.add(industryMstBean);
				BeanUtils.copyProperties(industryMstEntity, industryMstBean);
				industryMstBean.setIndustryId(EditUtil.intUtil(industryMstEntity.getIndustryId()));
			}
			return allIndustryBean;
		}
	@Override
	public List<PrefecturesMstBean> getPreAndCity() {
		List<PrefecturesMstEntity> allPrefectures = prefecturesMstMapper.getAll();
		List<PrefecturesMstBean> allPrefecturesBean = new ArrayList<PrefecturesMstBean>();
		for(PrefecturesMstEntity prefecturesMstEntity : allPrefectures) {
			PrefecturesMstBean prefecturesMstBean = new PrefecturesMstBean();
			allPrefecturesBean.add(prefecturesMstBean);
			BeanUtils.copyProperties(prefecturesMstEntity, prefecturesMstBean);
			prefecturesMstBean.setPrefeId(EditUtil.intUtil(prefecturesMstEntity.getPrefeId()));
		}
		return allPrefecturesBean;
	}
	
	/**
	 * C0301研修推薦一覧リスト
	 * @param c0301VueForm
	 * @return List<TrainingInfoTblBean>
	 */
	@Override
	public List<TrainingInfoTblBean> getTraining(Integer userCd) {
		
		//個人情報取得
		ApplicantConnEntity app = applicantInfoTblMapper.getApplicantInfo(userCd);
		
		if(app != null) {
			List<TrainingInfoTblEntity> trainingInfoTblEntity = trainingTblMapper.getTraining(app);
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
		return null;
	}
	
	/**
	 * C0301検査ボタン押下リスト
	 * @param c0301VueForm
	 * @return List<TrainingInfoTblBean>
	 */
	@Override
	public List<TrainingInfoTblBean> getList(C0301ListVueForm c0301ListVueForm) {
		c0301ListVueForm.setApplicantId(applicantInfoTblMapper.getApplicantIds(c0301ListVueForm.getUserCd()));
		List<TrainingInfoTblEntity> trainingInfoTblEntity = trainingTblMapper.getList(c0301ListVueForm);
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
	
	@Override
	public List<TrainingInfoTblBean> getTrainingPost(C0301ListVueForm c0301ListVueForm) {
		List<TrainingInfoTblEntity> trainingInfoTblEntity = trainingTblMapper.getTrainingPost(c0301ListVueForm);
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
	@Override
	public List<TrainingInfoTblBean> getTrainingLike(C0301ListVueForm c0301ListVueForm) {
		List<TrainingInfoTblEntity> trainingInfoTblEntity = trainingTblMapper.getTrainingLike(c0301ListVueForm);
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
	@Override
	public Integer getAppId(Integer userCd) {
		Integer applicantId = applicantInfoTblMapper.getApplicantIds(userCd);
		return applicantId;
	}
	@Override
	public Integer insertPost(List<C0301VueForm> c0301VueForm) {
		int insertPost = trainingApplTblMapper.insertPost(c0301VueForm);
		return insertPost;
	}
	@Override
	public Integer insertLike(List<C0301VueForm> c0301VueForm) {
		int insertLike = trainingApplTblMapper.insertLike(c0301VueForm);
		return insertLike;
	}
	@Override
	public Integer updateLike(List<C0301VueForm> c0301VueForm, Integer userCd, Integer applicantId) {
		int updateLike = trainingApplTblMapper.updateLike(c0301VueForm, userCd, applicantId);
		return updateLike;
	}
	@Override
	public Integer deleteTrainingAppl(List<C0301VueForm> c0301VueForm, Integer userCd, Integer applicantId) {
		int deleteApplication = trainingApplTblMapper.deleteTrainingAppl(c0301VueForm, userCd, applicantId);
		return deleteApplication;
	}
	 
	 
}
