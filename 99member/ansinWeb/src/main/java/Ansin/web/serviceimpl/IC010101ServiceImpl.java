package Ansin.web.serviceimpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ansin.web.bean.ApplicantEduTblBean;
import Ansin.web.bean.ApplicantInfoTblBean;
import Ansin.web.bean.ApplicantLanTblBean;
import Ansin.web.bean.ApplicantQuaTblBean;
import Ansin.web.bean.ApplicantSkillTblBean;
import Ansin.web.bean.ApplicantWorkHisTblBean;
import Ansin.web.bean.CountryMstBean;
import Ansin.web.bean.IndustryMstBean;
import Ansin.web.bean.JobtypeMstBean;
import Ansin.web.bean.LanMstBean;
import Ansin.web.bean.PrefecturesMstBean;
import Ansin.web.bean.ProjectHisTblBean;
import Ansin.web.bean.SkillMstBean;
import Ansin.web.bean.UserInfoBean;
import Ansin.web.entity.ApplicantConnEntity;
import Ansin.web.entity.ApplicantEduTblEntity;
import Ansin.web.entity.ApplicantLanTblEntity;
import Ansin.web.entity.ApplicantQuaTblEntity;
import Ansin.web.entity.ApplicantSkillTblEntity;
import Ansin.web.entity.ApplicantWorkHisTblEntity;
import Ansin.web.entity.CountryMstEntity;
import Ansin.web.entity.IndustryMstEntity;
import Ansin.web.entity.JobtypeMstEntity;
import Ansin.web.entity.LanMstEntity;
import Ansin.web.entity.PrefecturesMstEntity;
import Ansin.web.entity.ProjectHisTblEntity;
import Ansin.web.entity.SkillMstEntity;
import Ansin.web.entity.UserTblEntity;
import Ansin.web.mapper.AdAddressMstMapper;
import Ansin.web.mapper.ApplicantEduTblMapper;
import Ansin.web.mapper.ApplicantInfoTblMapper;
import Ansin.web.mapper.ApplicantLanTblMapper;
import Ansin.web.mapper.ApplicantQuaTblMapper;
import Ansin.web.mapper.ApplicantSkillTblMapper;
import Ansin.web.mapper.ApplicantWorkHisTblMapper;
import Ansin.web.mapper.CountryMstMapper;
import Ansin.web.mapper.IndustryMstMapper;
import Ansin.web.mapper.JobtypeMstMapper;
import Ansin.web.mapper.LanMstMapper;
import Ansin.web.mapper.PrefecturesMstMapper;
import Ansin.web.mapper.ProjectHisTblMapper;
import Ansin.web.mapper.SkillMstMapper;
import Ansin.web.mapper.UserTblMapper;
import Ansin.web.service.C010101Service;
import Ansin.web.util.EditUtil;
import Ansin.web.vueForm.C010101VueForm;

@Service
public class IC010101ServiceImpl implements C010101Service {

	@Autowired
	private UserTblMapper userTblMapper;
	@Autowired
	private CountryMstMapper countryMstMapper;
	@Autowired
	private IndustryMstMapper industryMstMapper;
	@Autowired
	private JobtypeMstMapper jobtypeMstMapper;
	@Autowired
	private PrefecturesMstMapper prefecturesMstMapper;
	@Autowired
	private ApplicantInfoTblMapper applicantInfoTblMapper;
	@Autowired
	private SkillMstMapper skillMstMapper;
	@Autowired
	private LanMstMapper lanMstMapper;
	@Autowired
	private ApplicantQuaTblMapper applicantQuaTblMapper;
	@Autowired
	private ApplicantSkillTblMapper applicantSkillTblMapper;
	@Autowired
	private ApplicantWorkHisTblMapper applicantWorkHisTblMapper;
	@Autowired
	private ApplicantLanTblMapper applicantLanTblMapper;
	@Autowired
	private ApplicantEduTblMapper applicantEduTblMapper;
	@Autowired
	private ProjectHisTblMapper projectHisTblMapper;
	@Autowired
	private AdAddressMstMapper adAddressMstMapper;

	/**
	 * C010101応募者情報を取得
	 */
	@Override
	public ApplicantInfoTblBean getApplicantInfo(Integer userCd) {
		ApplicantConnEntity applicantInfo = applicantInfoTblMapper.getApplicantInfo(userCd);
		ApplicantInfoTblBean applicantInfoBean = new ApplicantInfoTblBean();
		if (applicantInfo != null) {
			BeanUtils.copyProperties(applicantInfo, applicantInfoBean);
			applicantInfoBean.setApplicantId(EditUtil.intUtil(applicantInfo.getApplicantId()));
			applicantInfoBean.setUserCd(EditUtil.intUtil(applicantInfo.getUserCd()));
			applicantInfoBean.setBirthday(EditUtil.dateUtil(applicantInfo.getBirthday()));
			applicantInfoBean.setCountryId(EditUtil.intUtil(applicantInfo.getCountryId()));
			applicantInfoBean.setHopeLand1(EditUtil.intUtil(applicantInfo.getHopeLand1()));
			applicantInfoBean.setHopeLand2(EditUtil.intUtil(applicantInfo.getHopeLand2()));
			applicantInfoBean.setHopeLand3(EditUtil.intUtil(applicantInfo.getHopeLand3()));
			applicantInfoBean.setWorkYears(EditUtil.intUtil(applicantInfo.getWorkYears()));
			applicantInfoBean.setIndustryId1(EditUtil.intUtil(applicantInfo.getIndustryId1()));
			applicantInfoBean.setJobtypeId1_1(EditUtil.intUtil(applicantInfo.getJobtypeId1_1()));
			applicantInfoBean.setJobtypeId1_2(EditUtil.intUtil(applicantInfo.getJobtypeId1_2()));
			applicantInfoBean.setJobtypeId1_3(EditUtil.intUtil(applicantInfo.getJobtypeId1_3()));
			applicantInfoBean.setIndustryId2(EditUtil.intUtil(applicantInfo.getIndustryId2()));
			applicantInfoBean.setJobtypeId2_1(EditUtil.intUtil(applicantInfo.getJobtypeId2_1()));
			applicantInfoBean.setJobtypeId2_2(EditUtil.intUtil(applicantInfo.getJobtypeId2_2()));
			applicantInfoBean.setJobtypeId2_3(EditUtil.intUtil(applicantInfo.getJobtypeId2_3()));
			applicantInfoBean.setIndustryId3(EditUtil.intUtil(applicantInfo.getIndustryId3()));
			applicantInfoBean.setJobtypeId3_1(EditUtil.intUtil(applicantInfo.getJobtypeId3_1()));
			applicantInfoBean.setJobtypeId3_2(EditUtil.intUtil(applicantInfo.getJobtypeId3_2()));
			applicantInfoBean.setJobtypeId3_3(EditUtil.intUtil(applicantInfo.getJobtypeId3_3()));
			applicantInfoBean.setHopeSalaryFrom(EditUtil.intUtil(applicantInfo.getHopeSalaryFrom()));
			applicantInfoBean.setHopeSalaryTo(EditUtil.intUtil(applicantInfo.getHopeSalaryTo()));
			applicantInfoBean.setRemainder(EditUtil.intUtil(applicantInfo.getRemainder()));
			applicantInfoBean.setPoint(EditUtil.intUtil(applicantInfo.getPoint()));
			applicantInfoBean.setLevelId(EditUtil.intUtil(applicantInfo.getLevelId()));
			return applicantInfoBean;
		}
		return applicantInfoBean;
	}

	/**
	 * C010101初期国選択リストを取得
	 */
	@Override
	public List<CountryMstBean> getAll() {
		List<CountryMstEntity> allCou = countryMstMapper.getAll();
		List<CountryMstBean> allCouBean = new ArrayList<CountryMstBean>();
		for (CountryMstEntity countryMstEntity : allCou) {
			CountryMstBean countryMstBean = new CountryMstBean();
			allCouBean.add(countryMstBean);
			BeanUtils.copyProperties(countryMstEntity, countryMstBean);
			countryMstBean.setCountryId(EditUtil.intUtil(countryMstEntity.getCountryId()));
		}
		return allCouBean;
	}

	/**
	 * C010101初期業種選択リストを取得
	 */
	@Override
	public List<IndustryMstBean> getAllIndustry() {
		List<IndustryMstEntity> allIndustry = industryMstMapper.getAll();
		List<IndustryMstBean> allIndustryBean = new ArrayList<IndustryMstBean>();
		for (IndustryMstEntity industryMstEntity : allIndustry) {
			IndustryMstBean industryMstBean = new IndustryMstBean();
			allIndustryBean.add(industryMstBean);
			BeanUtils.copyProperties(industryMstEntity, industryMstBean);
			industryMstBean.setIndustryId(EditUtil.intUtil(industryMstEntity.getIndustryId()));
		}
		return allIndustryBean;
	}

	/**
	 * C010101初期職種選択リストを取得
	 */
	@Override
	public List<JobtypeMstBean> getAllJobtype() {
		List<JobtypeMstEntity> allJobtype = jobtypeMstMapper.getAll();
		List<JobtypeMstBean> allJobtypeBean = new ArrayList<JobtypeMstBean>();
		for (JobtypeMstEntity jobtypeMstEntity : allJobtype) {
			JobtypeMstBean jobtypeMstBean = new JobtypeMstBean();
			allJobtypeBean.add(jobtypeMstBean);
			BeanUtils.copyProperties(jobtypeMstEntity, jobtypeMstBean);
			jobtypeMstBean.setIndustryId(EditUtil.intUtil(jobtypeMstEntity.getIndustryId()));
			jobtypeMstBean.setJobtypeId(EditUtil.intUtil(jobtypeMstEntity.getJobtypeId()));
		}
		return allJobtypeBean;
	}

	/**
	 * C010101初期都道県選択リストを取得
	 */
	@Override
	public List<PrefecturesMstBean> getPreAndCity() {
		List<PrefecturesMstEntity> allPrefectures = prefecturesMstMapper.getAll();
		List<PrefecturesMstBean> allPrefecturesBean = new ArrayList<PrefecturesMstBean>();
		for (PrefecturesMstEntity prefecturesMstEntity : allPrefectures) {
			PrefecturesMstBean prefecturesMstBean = new PrefecturesMstBean();
			allPrefecturesBean.add(prefecturesMstBean);
			BeanUtils.copyProperties(prefecturesMstEntity, prefecturesMstBean);
			prefecturesMstBean.setPrefeId(EditUtil.intUtil(prefecturesMstEntity.getPrefeId()));
		}
		return allPrefecturesBean;
	}

	/**
	 * C010101初期スキル選択リストを取得
	 */
	@Override
	public List<SkillMstBean> getAllSkill() {
		List<SkillMstEntity> allSkill = skillMstMapper.getAll();
		List<SkillMstBean> allSkillBean = new ArrayList<SkillMstBean>();
		for (SkillMstEntity skillMstEntity : allSkill) {
			SkillMstBean skillMstBean = new SkillMstBean();
			allSkillBean.add(skillMstBean);
			BeanUtils.copyProperties(skillMstEntity, skillMstBean);
			skillMstBean.setIndustryId(EditUtil.intUtil(skillMstEntity.getIndustryId()));
			skillMstBean.setJobtypeId(EditUtil.intUtil(skillMstEntity.getJobtypeId()));
			skillMstBean.setSkillId(EditUtil.intUtil(skillMstEntity.getSkillId()));
		}
		return allSkillBean;
	}

	/**
	 * C010101初期言語能力選択リストを取得
	 */
	@Override
	public List<LanMstBean> getAllLan() {
		List<LanMstEntity> allLan = lanMstMapper.getAll();
		List<LanMstBean> allLanBean = new ArrayList<LanMstBean>();
		for (LanMstEntity lanMstEntity : allLan) {
			LanMstBean lanMstBean = new LanMstBean();
			allLanBean.add(lanMstBean);
			BeanUtils.copyProperties(lanMstEntity, lanMstBean);
			lanMstBean.setLanguageId(EditUtil.intUtil(lanMstEntity.getLanguageId()));
		}
		return allLanBean;
	}

	/**
	 * C0101応募者のスキルリスト
	 */
	@Override
	public List<ApplicantSkillTblBean> getApplicantSkill(Integer applicantId) {
		List<ApplicantSkillTblEntity> applicantSkill = applicantSkillTblMapper.getSkill(applicantId);
		List<ApplicantSkillTblBean> applicantSkillBean = new ArrayList<ApplicantSkillTblBean>();
		for (ApplicantSkillTblEntity applicantSkillTblEntity : applicantSkill) {
			ApplicantSkillTblBean applicantSkillTblBean = new ApplicantSkillTblBean();
			applicantSkillBean.add(applicantSkillTblBean);
			BeanUtils.copyProperties(applicantSkillTblEntity, applicantSkillTblBean);
			applicantSkillTblBean.setApplicantId(EditUtil.intUtil(applicantSkillTblEntity.getApplicantId()));
			applicantSkillTblBean.setAppSkillId(EditUtil.intUtil(applicantSkillTblEntity.getAppSkillId()));
			applicantSkillTblBean.setSkillId(EditUtil.intUtil(applicantSkillTblEntity.getSkillId()));
		}
		return applicantSkillBean;
	}

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
			try {
				confirmOutput(applicantQuaTblBean);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return applicantQuaBean;
	}

	/**
	 * C0101応募者の職歴リスト
	 */
	@Override
	public List<ApplicantWorkHisTblBean> getApplicantWorkHis(Integer applicantId) {
		List<ApplicantWorkHisTblEntity> applicantWorkHis = applicantWorkHisTblMapper.getApplicantWorkHis(applicantId);
		List<ApplicantWorkHisTblBean> applicantWorkHisBean = new ArrayList<ApplicantWorkHisTblBean>();
		for (ApplicantWorkHisTblEntity applicantWorkHisTblEntity : applicantWorkHis) {
			ApplicantWorkHisTblBean applicantWorkHisTblBean = new ApplicantWorkHisTblBean();
			applicantWorkHisBean.add(applicantWorkHisTblBean);
			BeanUtils.copyProperties(applicantWorkHisTblEntity, applicantWorkHisTblBean);
			applicantWorkHisTblBean.setApplicantId(EditUtil.intUtil(applicantWorkHisTblEntity.getApplicantId()));
			applicantWorkHisTblBean.setWorkHisId(EditUtil.intUtil(applicantWorkHisTblEntity.getWorkHisId()));
			applicantWorkHisTblBean.setIndustryId1(EditUtil.intUtil(applicantWorkHisTblEntity.getIndustryId1()));
			applicantWorkHisTblBean.setJobtypeId1_1(EditUtil.intUtil(applicantWorkHisTblEntity.getJobtypeId1_1()));
			applicantWorkHisTblBean.setJobtypeId1_2(EditUtil.intUtil(applicantWorkHisTblEntity.getJobtypeId1_2()));
			applicantWorkHisTblBean.setJobtypeId1_3(EditUtil.intUtil(applicantWorkHisTblEntity.getJobtypeId1_3()));
			applicantWorkHisTblBean.setWorkDateFrom(EditUtil.dateUtil(applicantWorkHisTblEntity.getWorkDateFrom()));
			applicantWorkHisTblBean.setWorkDateTo(EditUtil.dateUtil(applicantWorkHisTblEntity.getWorkDateTo()));
		}
		return applicantWorkHisBean;
	}

	/**
	 * C0101応募者の言語能力リスト
	 */
	@Override
	public List<ApplicantLanTblBean> getAll(Integer applicantId) {
		List<ApplicantLanTblEntity> lan = applicantLanTblMapper.getAll(applicantId);
		List<ApplicantLanTblBean> lanBean = new ArrayList<ApplicantLanTblBean>();
		for (ApplicantLanTblEntity applicantLanTblEntity : lan) {
			ApplicantLanTblBean applicantLanTblBean = new ApplicantLanTblBean();
			lanBean.add(applicantLanTblBean);
			BeanUtils.copyProperties(applicantLanTblEntity, applicantLanTblBean);
			applicantLanTblBean.setAppLanId(EditUtil.intUtil(applicantLanTblEntity.getAppLanId()));
			applicantLanTblBean.setApplicantId(EditUtil.intUtil(applicantLanTblEntity.getApplicantId()));
			applicantLanTblBean.setLanguageId(EditUtil.intUtil(applicantLanTblEntity.getLanguageId()));
		}
		return lanBean;
	}

	/**
	 * C0101応募者の学歴能力リスト
	 */
	@Override
	public List<ApplicantEduTblBean> getEdu(Integer applicantId) {
		List<ApplicantEduTblEntity> edu = applicantEduTblMapper.getEdu(applicantId);
		List<ApplicantEduTblBean> eduBean = new ArrayList<ApplicantEduTblBean>();
		for (ApplicantEduTblEntity applicantEduTblEntity : edu) {
			ApplicantEduTblBean applicantEduTblBean = new ApplicantEduTblBean();
			eduBean.add(applicantEduTblBean);
			BeanUtils.copyProperties(applicantEduTblEntity, applicantEduTblBean);
			applicantEduTblBean.setEducationId(EditUtil.intUtil(applicantEduTblEntity.getEducationId()));
			applicantEduTblBean.setApplicantId(EditUtil.intUtil(applicantEduTblEntity.getApplicantId()));
			applicantEduTblBean.setEduDateFrom(EditUtil.dateUtil(applicantEduTblEntity.getEduDateFrom()));
			applicantEduTblBean.setEduDateTo(EditUtil.dateUtil(applicantEduTblEntity.getEduDateTo()));
			try {
				confirmOutput(applicantEduTblBean);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return eduBean;
	}

	/**
	 * C0101応募者のプロジェクト履歴リスト
	 */
	@Override
	public List<ProjectHisTblBean> getProjectHis(Integer applicantId) {
		List<ProjectHisTblEntity> projectHis = projectHisTblMapper.getAll(applicantId);
		List<ProjectHisTblBean> projectHisBean = new ArrayList<ProjectHisTblBean>();
		for (ProjectHisTblEntity projectHisTblEntity : projectHis) {
			ProjectHisTblBean projectHisTblBean = new ProjectHisTblBean();
			projectHisBean.add(projectHisTblBean);
			BeanUtils.copyProperties(projectHisTblEntity, projectHisTblBean);
			projectHisTblBean.setProjectId(EditUtil.intUtil(projectHisTblEntity.getProjectId()));
			projectHisTblBean.setApplicantId(EditUtil.intUtil(projectHisTblEntity.getApplicantId()));
			projectHisTblBean.setProDateFrom(EditUtil.dateUtil(projectHisTblEntity.getProDateFrom()));
			projectHisTblBean.setProDateTo(EditUtil.dateUtil(projectHisTblEntity.getProDateTo()));
			projectHisTblBean.setProCnt(EditUtil.intUtil(projectHisTblEntity.getProCnt()));
		}

		return projectHisBean;
	}

	/**
	 * C010101応募者情報を挿入
	 */
	@Override
	public int insertApplicant(C010101VueForm c010101VueForm) {
		int insertApplicantReturn = applicantInfoTblMapper.insertApplicant(c010101VueForm);
		return insertApplicantReturn;
	}

	/**
	 * C010101応募者情報を更新
	 */
	@Override
	public int updateApplicant(C010101VueForm c010101VueForm) {
		// TODO Auto-generated method stub
		int updateApplicantReturn = applicantInfoTblMapper.updateApplicant(c010101VueForm);
		return updateApplicantReturn;
	}

	/**
	 * 郵便番号から都道府県名取得
	 */
	@Override
	public String getPrefeNm(String postal) {
		String str = adAddressMstMapper.getPrefeNm(postal);
		return str;
	}

	@Override
	public ApplicantInfoTblBean getApplicantAll(Integer applicantId) {

		// 応募者情報取得
		ApplicantConnEntity applicantInfo = applicantInfoTblMapper.getApplicant(applicantId);
		ApplicantInfoTblBean applicantInfoBean = new ApplicantInfoTblBean();
		if (applicantInfo != null) {
			BeanUtils.copyProperties(applicantInfo, applicantInfoBean);
			applicantInfoBean.setApplicantId(EditUtil.intUtil(applicantInfo.getApplicantId()));
			applicantInfoBean.setUserCd(EditUtil.intUtil(applicantInfo.getUserCd()));
			applicantInfoBean.setBirthday(EditUtil.dateUtil(applicantInfo.getBirthday()));
			applicantInfoBean.setCountryId(EditUtil.intUtil(applicantInfo.getCountryId()));
			applicantInfoBean.setHopeLand1(EditUtil.intUtil(applicantInfo.getHopeLand1()));
			applicantInfoBean.setHopeLand2(EditUtil.intUtil(applicantInfo.getHopeLand2()));
			applicantInfoBean.setHopeLand3(EditUtil.intUtil(applicantInfo.getHopeLand3()));
			applicantInfoBean.setWorkYears(EditUtil.intUtil(applicantInfo.getWorkYears()));
			applicantInfoBean.setIndustryId1(EditUtil.intUtil(applicantInfo.getIndustryId1()));
			applicantInfoBean.setJobtypeId1_1(EditUtil.intUtil(applicantInfo.getJobtypeId1_1()));
			applicantInfoBean.setJobtypeId1_2(EditUtil.intUtil(applicantInfo.getJobtypeId1_2()));
			applicantInfoBean.setJobtypeId1_3(EditUtil.intUtil(applicantInfo.getJobtypeId1_3()));
			applicantInfoBean.setIndustryId2(EditUtil.intUtil(applicantInfo.getIndustryId2()));
			applicantInfoBean.setJobtypeId2_1(EditUtil.intUtil(applicantInfo.getJobtypeId2_1()));
			applicantInfoBean.setJobtypeId2_2(EditUtil.intUtil(applicantInfo.getJobtypeId2_2()));
			applicantInfoBean.setJobtypeId2_3(EditUtil.intUtil(applicantInfo.getJobtypeId2_3()));
			applicantInfoBean.setIndustryId3(EditUtil.intUtil(applicantInfo.getIndustryId3()));
			applicantInfoBean.setJobtypeId3_1(EditUtil.intUtil(applicantInfo.getJobtypeId3_1()));
			applicantInfoBean.setJobtypeId3_2(EditUtil.intUtil(applicantInfo.getJobtypeId3_2()));
			applicantInfoBean.setJobtypeId3_3(EditUtil.intUtil(applicantInfo.getJobtypeId3_3()));
			applicantInfoBean.setHopeSalaryFrom(EditUtil.intUtil(applicantInfo.getHopeSalaryFrom()));
			applicantInfoBean.setHopeSalaryTo(EditUtil.intUtil(applicantInfo.getHopeSalaryTo()));
			applicantInfoBean.setRemainder(EditUtil.intUtil(applicantInfo.getRemainder()));
			applicantInfoBean.setPoint(EditUtil.intUtil(applicantInfo.getPoint()));
			applicantInfoBean.setLevelId(EditUtil.intUtil(applicantInfo.getLevelId()));
			return applicantInfoBean;
		}
		return null;
	}

	@Override
	public ApplicantQuaTblBean confirmOutput(ApplicantQuaTblBean applicantQuaTblBean) throws IOException {
		ApplicantQuaTblBean applicantQuaTblOutput;
		applicantQuaTblOutput = applicantQuaTblBean;

		// 謄本を取得
		String adress = applicantQuaTblOutput.getQuaAddress();// 資格画像
		FileInputStream is = null;
		File filePic = new File(adress);
		try {
			is = new FileInputStream(filePic);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		if (is != null) {
			int i = is.available(); // ファイルサイズ
			byte data[] = new byte[i];
			is.read(data); // データ読込
			is.close();
			applicantQuaTblOutput.setPhotoPic(data);
		}
		return applicantQuaTblOutput;
	}

	@Override
	public ApplicantEduTblBean confirmOutput(ApplicantEduTblBean applicantEduTblBean) throws IOException {
		ApplicantEduTblBean applicantEduTblOutput;
		applicantEduTblOutput = applicantEduTblBean;

		// 謄本を取得
		String adress = applicantEduTblOutput.getDegreePic1();// 資格画像
		FileInputStream is = null;
		File filePic = new File(adress);
		try {
			is = new FileInputStream(filePic);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		if (is != null) {
			int i = is.available(); // ファイルサイズ
			byte data[] = new byte[i];
			is.read(data); // データ読込
			is.close();
			applicantEduTblOutput.setPhotoPic(data);
		}
		return applicantEduTblOutput;
	}

	@Override
	public ApplicantInfoTblBean confirmOutput(ApplicantInfoTblBean applicantInfoTblBean) throws IOException {
		ApplicantInfoTblBean applicantInfoOutput;
		applicantInfoOutput = applicantInfoTblBean;

		if (applicantInfoOutput.getPhoto() != null) {
			// 謄本を取得
			String adress = applicantInfoOutput.getPhoto();// 資格画像
			FileInputStream is = null;
			File filePic = new File(adress);
			try {
				is = new FileInputStream(filePic);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			if (is != null) {
				int i = is.available(); // ファイルサイズ
				byte data[] = new byte[i];
				is.read(data); // データ読込
				is.close();
				applicantInfoOutput.setPhotoPic(data);
			}
			return applicantInfoOutput;
		} else {
			return null;
		}

	}

	@Override
	public UserInfoBean getUserInfo(Integer userCd) {
		UserTblEntity userTblEntity = userTblMapper.getUserInfoByUserCd(userCd);
		UserInfoBean userInfoBean = new UserInfoBean();
		if (userTblEntity != null) {
			BeanUtils.copyProperties(userTblEntity, userInfoBean);
			userInfoBean.setUserCd(EditUtil.intUtil(userTblEntity.getUserCd()));
			userInfoBean.setCompanyId(EditUtil.intUtil(userTblEntity.getCompanyId()));
			userInfoBean.setCountryZip(EditUtil.intUtil(userTblEntity.getCountryZip()));
			userInfoBean.setPhotoAddress(userTblEntity.getPhotoAddress());
		}
		return userInfoBean;
	}

}
