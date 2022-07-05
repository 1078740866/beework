package Ansin.web.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ansin.web.bean.ApplicantRecommendInitBean;
import Ansin.web.bean.B0301Bean;
import Ansin.web.bean.IndustryMstBean;
import Ansin.web.bean.JobtypeMstBean;
import Ansin.web.bean.LanMstBean;
import Ansin.web.bean.PrefecturesMstBean;
import Ansin.web.bean.SkillMstBean;
import Ansin.web.entity.B0301Entity;
import Ansin.web.entity.IndustryMstEntity;
import Ansin.web.entity.JobtypeMstEntity;
import Ansin.web.entity.LanMstEntity;
import Ansin.web.entity.PrefecturesMstEntity;
import Ansin.web.entity.SkillMstEntity;
import Ansin.web.mapper.B0301ListMapper;
import Ansin.web.mapper.IndustryMstMapper;
import Ansin.web.mapper.JobtypeMstMapper;
import Ansin.web.mapper.LanMstMapper;
import Ansin.web.mapper.PrefecturesMstMapper;
import Ansin.web.mapper.SkillMstMapper;
import Ansin.web.service.B0301Service;
import Ansin.web.util.DateFormatUtil;
import Ansin.web.util.EditUtil;
import Ansin.web.vueForm.B0301VueForm;

@Service
public class IB0301ServiceImpl implements B0301Service{
	@Autowired
	private B0301ListMapper b0301ListMapper;
	@Autowired
	private IndustryMstMapper industryMstMapper;
	@Autowired
	private JobtypeMstMapper jobtypeMstMapper;
	@Autowired
	private SkillMstMapper skillMstMapper;
	@Autowired
	private PrefecturesMstMapper prefecturesMstMapper;
	@Autowired
	private LanMstMapper lanMstMapper;
	
	
	
	/**
	 * 画面初期化情報を取得
	 * @return applicantRecommendInitBean
	 */
	@Override
	public ApplicantRecommendInitBean getApplicantRecommendInitResponse() {
		// TODO Auto-generated method stub
		ApplicantRecommendInitBean applicantRecommendInitBean = new ApplicantRecommendInitBean();
		
		// 業種を取得
		List<IndustryMstEntity> industryMstEntityList = industryMstMapper.getAll();
		List<IndustryMstBean> industryMstList = new ArrayList<IndustryMstBean>();
		for (IndustryMstEntity industryMstEntity : industryMstEntityList) {
			IndustryMstBean industryMstBean = new IndustryMstBean();
			industryMstList.add(industryMstBean);
			BeanUtils.copyProperties(industryMstEntity, industryMstBean);
			industryMstBean.setIndustryId(EditUtil.intUtil(industryMstEntity.getIndustryId()));
		}
		applicantRecommendInitBean.setIndustryList(industryMstList);
		
		//職種リストを取得
		List<JobtypeMstEntity> jobtypeMstEntityList = jobtypeMstMapper.getAll();
		List<JobtypeMstBean> jobtypeMstList = new ArrayList<JobtypeMstBean>();
		for (JobtypeMstEntity jobtypeMstEntity : jobtypeMstEntityList) {
			JobtypeMstBean jobtypeMstBean = new JobtypeMstBean();
			jobtypeMstList.add(jobtypeMstBean);
			BeanUtils.copyProperties(jobtypeMstEntity, jobtypeMstBean);
			jobtypeMstBean.setJobtypeId(EditUtil.intUtil(jobtypeMstEntity.getJobtypeId()));
			jobtypeMstBean.setIndustryId(EditUtil.intUtil(jobtypeMstEntity.getIndustryId()));
		}
		applicantRecommendInitBean.setJobtypeList(jobtypeMstList);
		
		//スキルリストを取得
		List<SkillMstEntity> skillMstEntityList = skillMstMapper.getAll();
		List<SkillMstBean> skillMstList = new ArrayList<SkillMstBean>();
		for (SkillMstEntity skillMstEntity : skillMstEntityList) {
			SkillMstBean skillMstBean = new SkillMstBean();
			skillMstList.add(skillMstBean);
			BeanUtils.copyProperties(skillMstEntity, skillMstBean);
			skillMstBean.setSkillId(EditUtil.intUtil(skillMstEntity.getSkillId()));
			skillMstBean.setIndustryId(EditUtil.intUtil(skillMstEntity.getIndustryId()));
		}
		applicantRecommendInitBean.setSkillList(skillMstList);;
		
		// 都道府県を取得
		List<PrefecturesMstEntity> prefecturesMstEntityList = prefecturesMstMapper.getAll();
		List<PrefecturesMstBean> prefecturesList = new ArrayList<PrefecturesMstBean>();
		for (PrefecturesMstEntity prefecturesMstEntity : prefecturesMstEntityList) {
			PrefecturesMstBean prefecturesMstBean = new PrefecturesMstBean();
			prefecturesList.add(prefecturesMstBean);
			BeanUtils.copyProperties(prefecturesMstEntity, prefecturesMstBean);
			prefecturesMstBean.setPrefeId(EditUtil.intUtil(prefecturesMstEntity.getPrefeId()));
		}
		applicantRecommendInitBean.setPrefecturesList(prefecturesList);
		
		//言語リストを取得
		List<LanMstEntity> lanMstEntityList = lanMstMapper.getAll();
		List<LanMstBean> LanMstList = new ArrayList<LanMstBean>();
		for (LanMstEntity lanMstEntity : lanMstEntityList) {
			LanMstBean lanMstBean = new LanMstBean();
			LanMstList.add(lanMstBean);
			BeanUtils.copyProperties(lanMstEntity, lanMstBean);
			lanMstBean.setLanguageId(EditUtil.intUtil(lanMstEntity.getLanguageId()));
		}
		applicantRecommendInitBean.setLanList(LanMstList);
		
		return applicantRecommendInitBean;
	}

	/**
	 * B0301一覧リスト
	 */
	@Override
	public List<B0301Bean> getAll(B0301VueForm b0301VueForm) {
		
		List<B0301Entity> b0301EntityList = b0301ListMapper.getAll(b0301VueForm);
		
		List<B0301Bean> b0301List = new ArrayList<B0301Bean>();
		
		for(B0301Entity b0301 : b0301EntityList) {
			
			B0301Bean b0301Bean = new B0301Bean();
			
			BeanUtils.copyProperties(b0301, b0301Bean);
			
			b0301Bean.setUserCd(EditUtil.intUtil(b0301.getUserCd()));;
			b0301Bean.setApplicantId(EditUtil.intUtil(b0301.getApplicantId()));
			b0301Bean.setBirthday(EditUtil.intUtil(DateFormatUtil.getAge(b0301.getBirthday())));
			b0301Bean.setHopeSalaryFrom(EditUtil.intUtil(b0301.getHopeSalaryFrom()));
			b0301Bean.setHopeSalaryTo(EditUtil.intUtil(b0301.getHopeSalaryTo()));
			b0301Bean.setWorkYears(EditUtil.intUtil(b0301.getWorkYears()));
			b0301Bean.setName(b0301.getFirstName() + " " +b0301.getLastName());
			b0301Bean.setUpdateTime(EditUtil.timeStampUtil(b0301.getUpdateTime()));

			b0301List.add(b0301Bean);
		}
 		
		return b0301List;
	
	}
	
}
