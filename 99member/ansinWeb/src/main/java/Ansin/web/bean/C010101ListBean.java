package Ansin.web.bean;

import java.util.List;

public class C010101ListBean {
	// 応募者情報を取得する
	private ApplicantInfoTblBean applicantInfoTblBean;
	private UserInfoBean userInfoBean;
	// C010101初期国選択リストを取得
	private List<CountryMstBean> countryMstBean;
	// C010101初期業種選択リストを取得
	private List<IndustryMstBean> industryMstBean;
	// C010101初期職種選択リストを取得
	private List<JobtypeMstBean> jobtypeMstBean;
	// C010101初期都道県選択リストを取得
	private List<PrefecturesMstBean> prefecturesMstBean;
	// C010101初期スキル選択リストを取得
	private List<SkillMstBean> skillMstBean;
	// C010101初期言語能力選択リストを取得
	private List<LanMstBean> lanMstBean;
	// C0101応募者の資格リスト
	private List<ApplicantQuaTblBean> applicantQuaTblBean;
	// C0101応募者のスキルリスト
	private List<ApplicantSkillTblBean> applicantSkillTblBean;
	// C0101応募者の職歴リスト
	private List<ApplicantWorkHisTblBean> applicantWorkHisTblBean;
	// C0101応募者の言語能力リスト
	private List<ApplicantLanTblBean> applicantLanTblBean;
	// C0101応募者の学歴能力リスト
	private List<ApplicantEduTblBean> applicantEduTblBean;
	// C0101応募者のプロジェクト履歴リスト
	private List<ProjectHisTblBean> projectHisTblBean;
	private String flgData;

	public ApplicantInfoTblBean getApplicantInfoTblBean() {
		return applicantInfoTblBean;
	}

	public void setApplicantInfoTblBean(ApplicantInfoTblBean applicantInfoTblBean) {
		this.applicantInfoTblBean = applicantInfoTblBean;
	}

	public List<CountryMstBean> getCountryMstBean() {
		return countryMstBean;
	}

	public void setCountryMstBean(List<CountryMstBean> countryMstBean) {
		this.countryMstBean = countryMstBean;
	}

	public List<IndustryMstBean> getIndustryMstBean() {
		return industryMstBean;
	}

	public void setIndustryMstBean(List<IndustryMstBean> industryMstBean) {
		this.industryMstBean = industryMstBean;
	}

	public List<JobtypeMstBean> getJobtypeMstBean() {
		return jobtypeMstBean;
	}

	public void setJobtypeMstBean(List<JobtypeMstBean> jobtypeMstBean) {
		this.jobtypeMstBean = jobtypeMstBean;
	}

	public List<PrefecturesMstBean> getPrefecturesMstBean() {
		return prefecturesMstBean;
	}

	public void setPrefecturesMstBean(List<PrefecturesMstBean> prefecturesMstBean) {
		this.prefecturesMstBean = prefecturesMstBean;
	}

	public List<SkillMstBean> getSkillMstBean() {
		return skillMstBean;
	}

	public void setSkillMstBean(List<SkillMstBean> skillMstBean) {
		this.skillMstBean = skillMstBean;
	}

	public List<LanMstBean> getLanMstBean() {
		return lanMstBean;
	}

	public void setLanMstBean(List<LanMstBean> lanMstBean) {
		this.lanMstBean = lanMstBean;
	}

	public List<ApplicantQuaTblBean> getApplicantQuaTblBean() {
		return applicantQuaTblBean;
	}

	public void setApplicantQuaTblBean(List<ApplicantQuaTblBean> applicantQuaTblBean) {
		this.applicantQuaTblBean = applicantQuaTblBean;
	}

	public List<ApplicantSkillTblBean> getApplicantSkillTblBean() {
		return applicantSkillTblBean;
	}

	public void setApplicantSkillTblBean(List<ApplicantSkillTblBean> applicantSkillTblBean) {
		this.applicantSkillTblBean = applicantSkillTblBean;
	}

	public List<ApplicantWorkHisTblBean> getApplicantWorkHisTblBean() {
		return applicantWorkHisTblBean;
	}

	public void setApplicantWorkHisTblBean(List<ApplicantWorkHisTblBean> applicantWorkHisTblBean) {
		this.applicantWorkHisTblBean = applicantWorkHisTblBean;
	}

	public List<ApplicantLanTblBean> getApplicantLanTblBean() {
		return applicantLanTblBean;
	}

	public void setApplicantLanTblBean(List<ApplicantLanTblBean> applicantLanTblBean) {
		this.applicantLanTblBean = applicantLanTblBean;
	}

	public List<ApplicantEduTblBean> getApplicantEduTblBean() {
		return applicantEduTblBean;
	}

	public void setApplicantEduTblBean(List<ApplicantEduTblBean> applicantEduTblBean) {
		this.applicantEduTblBean = applicantEduTblBean;
	}

	public List<ProjectHisTblBean> getProjectHisTblBean() {
		return projectHisTblBean;
	}

	public void setProjectHisTblBean(List<ProjectHisTblBean> projectHisTblBean) {
		this.projectHisTblBean = projectHisTblBean;
	}

	public String getFlgData() {
		return flgData;
	}

	public void setFlgData(String flgData) {
		this.flgData = flgData;
	}

	public UserInfoBean getUserInfoBean() {
		return userInfoBean;
	}

	public void setUserInfoBean(UserInfoBean userInfoBean) {
		this.userInfoBean = userInfoBean;
	}

}
