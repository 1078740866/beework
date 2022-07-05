package Ansin.web.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ansin.web.bean.IndustryMstBean;
import Ansin.web.bean.JobtypeMstBean;
import Ansin.web.bean.PositionTblBean;
import Ansin.web.bean.PrefecturesMstBean;
import Ansin.web.entity.ApplicantInfoTblEntity;
import Ansin.web.entity.ApplicantSkillTblEntity;
import Ansin.web.entity.IndustryMstEntity;
import Ansin.web.entity.JobtypeMstEntity;
import Ansin.web.entity.PositionTblEntity;
import Ansin.web.entity.PrefecturesMstEntity;
import Ansin.web.mapper.ApplicantInfoTblMapper;
import Ansin.web.mapper.ApplicantSkillTblMapper;
import Ansin.web.mapper.ApplicationTblMapper;
import Ansin.web.mapper.IndustryMstMapper;
import Ansin.web.mapper.JobtypeMstMapper;
import Ansin.web.mapper.PositionTblMapper;
import Ansin.web.mapper.PrefecturesMstMapper;
import Ansin.web.service.C0201Service;
import Ansin.web.util.EditUtil;
import Ansin.web.vueForm.C0201ListVueForm;
import Ansin.web.vueForm.C0201VueForm;

@Service
public class IC0201ServiceImpl implements C0201Service{
	
	 @Autowired
	 private PositionTblMapper positionTblMapper;
	 @Autowired
	 private ApplicantInfoTblMapper applicantInfoTblMapper;
	 @Autowired
	 private ApplicationTblMapper applicationTblMapper;
	 @Autowired
	 private ApplicantSkillTblMapper applicantSkillTblMapper;
	 @Autowired
	 private IndustryMstMapper industryMstMapper;
	 @Autowired
	 private JobtypeMstMapper jobtypeMstMapper;
	 @Autowired
	 private PrefecturesMstMapper prefecturesMstMapper;

	 /**
	 * 職位推薦一覧リスト
	 * @param c0201ListVueForm
	 * @return List<PositionTblBean>
	*/
	@Override
	public List<PositionTblBean> getRecommend(Integer userCd) {
		
		//個人情報取得
		ApplicantInfoTblEntity app = applicantInfoTblMapper.getTerms(userCd);
		
		if(app != null) {
			//個人スキルリスト取得
			List<ApplicantSkillTblEntity> skills = applicantSkillTblMapper.getSkill(app.getApplicantId());
			
			List<PositionTblEntity> positionTblEntityList;
			
			if(skills == null || skills.isEmpty()){
				 positionTblEntityList = positionTblMapper.getRecommend(app,null);
				
			}else {
				positionTblEntityList = positionTblMapper.getRecommend(app,skills);
			}	
			
			List<PositionTblBean> positionTblList = new ArrayList<PositionTblBean>();
			
			for(PositionTblEntity positionTblEntity : positionTblEntityList) {
				
				PositionTblBean positionTblBean = new PositionTblBean();
				
				BeanUtils.copyProperties(positionTblEntity, positionTblBean);
				
				positionTblBean.setCompanyId(EditUtil.intUtil(positionTblEntity.getCompanyId()));
				positionTblBean.setUserCd(EditUtil.intUtil(positionTblEntity.getUserCd()));
				positionTblBean.setPositionId(EditUtil.intUtil(positionTblEntity.getPositionId()));
				positionTblBean.setIndustryId(EditUtil.intUtil(positionTblEntity.getIndustryId()));
				positionTblBean.setJobTypeId(EditUtil.intUtil(positionTblEntity.getJobTypeId()));
				positionTblBean.setSkillId(EditUtil.intUtil(positionTblEntity.getSkillId()));
				positionTblBean.setWorkTimeFrom(EditUtil.dateUtil(positionTblEntity.getWorkTimeFrom()));
				positionTblBean.setWorkTimeTo(EditUtil.dateUtil(positionTblEntity.getWorkTimeTo()));
				positionTblBean.setSalaryMin(EditUtil.intUtil(positionTblEntity.getSalaryMin()));
				positionTblBean.setSalaryMax(EditUtil.intUtil(positionTblEntity.getSalaryMax()));
				positionTblBean.setPeoCnt(EditUtil.intUtil(positionTblEntity.getPeoCnt()));
				positionTblBean.setWorkDateStr(EditUtil.dateUtil(positionTblEntity.getWorkDateStr()));
				positionTblBean.setExpDate(EditUtil.dateUtil(positionTblEntity.getExpDate()));
				positionTblBean.setUpdateTime(EditUtil.dateUtil(positionTblEntity.getUpdateTime()));
	
				positionTblList.add(positionTblBean);
			}		
			return positionTblList;
		}
 		return null;
	}

	 /**
	 * 職位検索一覧リスト
	 * @param c0201ListVueForm
	 * @return List<PositionTblBean>
	*/
	@Override
	public List<PositionTblBean> getList(C0201ListVueForm c0201ListVueForm) {
		c0201ListVueForm.setApplicantId(applicantInfoTblMapper.getApplicantIds(c0201ListVueForm.getUserCd()));
		
		List<PositionTblEntity> positionTblEntityList = positionTblMapper.getDates(c0201ListVueForm);
		
		if(positionTblEntityList != null && !positionTblEntityList.isEmpty()) {
			
			List<PositionTblBean> positionTblList = new ArrayList<PositionTblBean>();
			
			for(PositionTblEntity positionTblEntity : positionTblEntityList) {
				
				PositionTblBean positionTblBean = new PositionTblBean();
				
				BeanUtils.copyProperties(positionTblEntity, positionTblBean);
				
				positionTblBean.setCompanyId(EditUtil.intUtil(positionTblEntity.getCompanyId()));
				positionTblBean.setUserCd(EditUtil.intUtil(positionTblEntity.getUserCd()));
				positionTblBean.setPositionId(EditUtil.intUtil(positionTblEntity.getPositionId()));
				positionTblBean.setIndustryId(EditUtil.intUtil(positionTblEntity.getIndustryId()));
				positionTblBean.setJobTypeId(EditUtil.intUtil(positionTblEntity.getJobTypeId()));
				positionTblBean.setSkillId(EditUtil.intUtil(positionTblEntity.getSkillId()));
				positionTblBean.setWorkTimeFrom(EditUtil.dateUtil(positionTblEntity.getWorkTimeFrom()));
				positionTblBean.setWorkTimeTo(EditUtil.dateUtil(positionTblEntity.getWorkTimeTo()));
				positionTblBean.setSalaryMin(EditUtil.intUtil(positionTblEntity.getSalaryMin()));
				positionTblBean.setSalaryMax(EditUtil.intUtil(positionTblEntity.getSalaryMax()));
				positionTblBean.setPeoCnt(EditUtil.intUtil(positionTblEntity.getPeoCnt()));
				positionTblBean.setWorkDateStr(EditUtil.dateUtil(positionTblEntity.getWorkDateStr()));
				positionTblBean.setExpDate(EditUtil.dateUtil(positionTblEntity.getExpDate()));
				positionTblBean.setUpdateTime(EditUtil.dateUtil(positionTblEntity.getUpdateTime()));

				positionTblList.add(positionTblBean);
			}
			return positionTblList;
		}
		
		return null;
	}

	
	
	@Override
	public List<PositionTblBean> getPost(C0201ListVueForm c0201ListVueForm) {
		
		List<PositionTblEntity> positionTblEntityList = positionTblMapper.getPost(c0201ListVueForm);
		
		List<PositionTblBean> positionTblList = new ArrayList<PositionTblBean>();
		
		for(PositionTblEntity positionTblEntity : positionTblEntityList) {
			
			PositionTblBean positionTblBean = new PositionTblBean();
			
			BeanUtils.copyProperties(positionTblEntity, positionTblBean);
			
			positionTblBean.setCompanyId(EditUtil.intUtil(positionTblEntity.getCompanyId()));
			positionTblBean.setUserCd(EditUtil.intUtil(positionTblEntity.getUserCd()));
			positionTblBean.setPositionId(EditUtil.intUtil(positionTblEntity.getPositionId()));
			positionTblBean.setIndustryId(EditUtil.intUtil(positionTblEntity.getIndustryId()));
			positionTblBean.setJobTypeId(EditUtil.intUtil(positionTblEntity.getJobTypeId()));
			positionTblBean.setSkillId(EditUtil.intUtil(positionTblEntity.getSkillId()));
			positionTblBean.setWorkTimeFrom(EditUtil.dateUtil(positionTblEntity.getWorkTimeFrom()));
			positionTblBean.setWorkTimeTo(EditUtil.dateUtil(positionTblEntity.getWorkTimeTo()));
			positionTblBean.setSalaryMin(EditUtil.intUtil(positionTblEntity.getSalaryMin()));
			positionTblBean.setSalaryMax(EditUtil.intUtil(positionTblEntity.getSalaryMax()));
			positionTblBean.setPeoCnt(EditUtil.intUtil(positionTblEntity.getPeoCnt()));
			positionTblBean.setWorkDateStr(EditUtil.dateUtil(positionTblEntity.getWorkDateStr()));
			positionTblBean.setExpDate(EditUtil.dateUtil(positionTblEntity.getExpDate()));
			positionTblBean.setUpdateTime(EditUtil.dateUtil(positionTblEntity.getUpdateTime()));

			positionTblList.add(positionTblBean);
		}		
 		return positionTblList;
	}

	@Override
	public List<PositionTblBean> getLike(C0201ListVueForm c0201ListVueForm) {
		
		List<PositionTblEntity> positionTblEntityList = positionTblMapper.getLike(c0201ListVueForm);
		
		List<PositionTblBean> positionTblList = new ArrayList<PositionTblBean>();
		
		for(PositionTblEntity positionTblEntity : positionTblEntityList) {
			
			PositionTblBean positionTblBean = new PositionTblBean();
			
			BeanUtils.copyProperties(positionTblEntity, positionTblBean);
			
			positionTblBean.setCompanyId(EditUtil.intUtil(positionTblEntity.getCompanyId()));
			positionTblBean.setUserCd(EditUtil.intUtil(positionTblEntity.getUserCd()));
			positionTblBean.setPositionId(EditUtil.intUtil(positionTblEntity.getPositionId()));
			positionTblBean.setIndustryId(EditUtil.intUtil(positionTblEntity.getIndustryId()));
			positionTblBean.setJobTypeId(EditUtil.intUtil(positionTblEntity.getJobTypeId()));
			positionTblBean.setSkillId(EditUtil.intUtil(positionTblEntity.getSkillId()));
			positionTblBean.setWorkTimeFrom(EditUtil.dateUtil(positionTblEntity.getWorkTimeFrom()));
			positionTblBean.setWorkTimeTo(EditUtil.dateUtil(positionTblEntity.getWorkTimeTo()));
			positionTblBean.setSalaryMin(EditUtil.intUtil(positionTblEntity.getSalaryMin()));
			positionTblBean.setSalaryMax(EditUtil.intUtil(positionTblEntity.getSalaryMax()));
			positionTblBean.setPeoCnt(EditUtil.intUtil(positionTblEntity.getPeoCnt()));
			positionTblBean.setWorkDateStr(EditUtil.dateUtil(positionTblEntity.getWorkDateStr()));
			positionTblBean.setExpDate(EditUtil.dateUtil(positionTblEntity.getExpDate()));
			positionTblBean.setUpdateTime(EditUtil.dateUtil(positionTblEntity.getUpdateTime()));

			positionTblList.add(positionTblBean);
		}		
 		return positionTblList;
	}
	
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
	public List<JobtypeMstBean> getAllJobtype() {
		List<JobtypeMstEntity> allJobtype = jobtypeMstMapper.getAll();
		List<JobtypeMstBean> allJobtypeBean = new ArrayList<JobtypeMstBean>();
		for(JobtypeMstEntity jobtypeMstEntity : allJobtype) {
			JobtypeMstBean jobtypeMstBean = new JobtypeMstBean();
			allJobtypeBean.add(jobtypeMstBean);
			BeanUtils.copyProperties(jobtypeMstEntity, jobtypeMstBean);
			jobtypeMstBean.setIndustryId(EditUtil.intUtil(jobtypeMstEntity.getIndustryId()));
			jobtypeMstBean.setJobtypeId(EditUtil.intUtil(jobtypeMstEntity.getJobtypeId()));
		}
		return allJobtypeBean;
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

	@Override
	public Integer getAppId(Integer userCd) {
		Integer applicantId = applicantInfoTblMapper.getApplicantIds(userCd);
		return applicantId;
	}
	
	@Override
	public Integer insertPost(List<C0201VueForm> c0201VueForm) {
		int insertPost = applicationTblMapper.insertPost(c0201VueForm);
		return insertPost;
	}

	@Override
	public Integer insertLike(List<C0201VueForm> c0201VueForm) {
		int insertLike = applicationTblMapper.insertLike(c0201VueForm);
		return insertLike;
	}

	@Override
	public Integer updateLike(List<C0201VueForm> c0201VueForm,Integer userCd,Integer applicantId) {
		int updateLike = applicationTblMapper.updateLike(c0201VueForm,userCd,applicantId);
		return updateLike;
	}

	@Override
	public Integer deleteApplication(List<C0201VueForm> c0201VueForm,Integer userCd,Integer applicantId) {
		int deleteApplication = applicationTblMapper.deleteApplication(c0201VueForm,userCd,applicantId);
		return deleteApplication;
	}

	

}
