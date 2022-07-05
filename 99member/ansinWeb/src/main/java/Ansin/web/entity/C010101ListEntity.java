package Ansin.web.entity;

import java.util.List;

public class C010101ListEntity {
	
	//C010101応募者情報を取得
	private ApplicantConnEntity applicantInfoTblEntity;
	//C010101初期国選択リストを取得
	private List<CountryMstEntity> couMstEntity;
	//C010101初期業種選択リストを取得
	private List<IndustryMstEntity> industryMstEntity;
	//C010101初期職種選択リストを取得
	private List<JobtypeMstEntity> jobtypeMstEntity;
	//C010101初期資格選択リストを取得
	private List<QuaMstEntity> quaMstEntity;
	//C010101初期スキル選択リストを取得
	private List<SkillMstEntity> skillMstEntity;
	//C010101初期言語能力選択リストを取得
	private List<LanMstEntity> lanMstEntity;
	//C0101応募者の資格リスト
	private List<ApplicantQuaTblEntity> getApplicantQuaEntity;
	//C0101応募者のスキルリスト
	private List<ApplicantSkillTblEntity> getApplicantSkillMstEntity;
	//C0101応募者の職歴リスト
	private List<ApplicantWorkHisTblEntity> getApplicantWorkHisTblEntity;	
	//C0101応募者の言語能力リスト
	private List<ApplicantLanTblEntity> getApplicantLanTblEntity;
	//C0101応募者の学歴能力リスト
	private List<ApplicantEduTblEntity> getApplicantEduTblEntity;
	//C0101応募者のプロジェクト履歴リスト
	private List<ProjectHisTblEntity> getProjectHisTblEntity;
	public ApplicantConnEntity getApplicantInfoTblEntity() {
		return applicantInfoTblEntity;
	}
	public void setApplicantInfoTblEntity(ApplicantConnEntity applicantInfoTblEntity) {
		this.applicantInfoTblEntity = applicantInfoTblEntity;
	}
	public List<CountryMstEntity> getCouMstEntity() {
		return couMstEntity;
	}
	public void setCouMstEntity(List<CountryMstEntity> couMstEntity) {
		this.couMstEntity = couMstEntity;
	}
	public List<IndustryMstEntity> getIndustryMstEntity() {
		return industryMstEntity;
	}
	public void setIndustryMstEntity(List<IndustryMstEntity> industryMstEntity) {
		this.industryMstEntity = industryMstEntity;
	}
	public List<JobtypeMstEntity> getJobtypeMstEntity() {
		return jobtypeMstEntity;
	}
	public void setJobtypeMstEntity(List<JobtypeMstEntity> jobtypeMstEntity) {
		this.jobtypeMstEntity = jobtypeMstEntity;
	}
	public List<QuaMstEntity> getQuaMstEntity() {
		return quaMstEntity;
	}
	public void setQuaMstEntity(List<QuaMstEntity> quaMstEntity) {
		this.quaMstEntity = quaMstEntity;
	}
	public List<SkillMstEntity> getSkillMstEntity() {
		return skillMstEntity;
	}
	public void setSkillMstEntity(List<SkillMstEntity> skillMstEntity) {
		this.skillMstEntity = skillMstEntity;
	}
	public List<LanMstEntity> getLanMstEntity() {
		return lanMstEntity;
	}
	public void setLanMstEntity(List<LanMstEntity> lanMstEntity) {
		this.lanMstEntity = lanMstEntity;
	}
	public List<ApplicantQuaTblEntity> getGetApplicantQuaEntity() {
		return getApplicantQuaEntity;
	}
	public void setGetApplicantQuaEntity(List<ApplicantQuaTblEntity> getApplicantQuaEntity) {
		this.getApplicantQuaEntity = getApplicantQuaEntity;
	}
	public List<ApplicantSkillTblEntity> getGetApplicantSkillMstEntity() {
		return getApplicantSkillMstEntity;
	}
	public void setGetApplicantSkillMstEntity(List<ApplicantSkillTblEntity> getApplicantSkillMstEntity) {
		this.getApplicantSkillMstEntity = getApplicantSkillMstEntity;
	}
	public List<ApplicantWorkHisTblEntity> getGetApplicantWorkHisTblEntity() {
		return getApplicantWorkHisTblEntity;
	}
	public void setGetApplicantWorkHisTblEntity(List<ApplicantWorkHisTblEntity> getApplicantWorkHisTblEntity) {
		this.getApplicantWorkHisTblEntity = getApplicantWorkHisTblEntity;
	}
	public List<ApplicantLanTblEntity> getGetApplicantLanTblEntity() {
		return getApplicantLanTblEntity;
	}
	public void setGetApplicantLanTblEntity(List<ApplicantLanTblEntity> getApplicantLanTblEntity) {
		this.getApplicantLanTblEntity = getApplicantLanTblEntity;
	}
	public List<ApplicantEduTblEntity> getGetApplicantEduTblEntity() {
		return getApplicantEduTblEntity;
	}
	public void setGetApplicantEduTblEntity(List<ApplicantEduTblEntity> getApplicantEduTblEntity) {
		this.getApplicantEduTblEntity = getApplicantEduTblEntity;
	}
	public List<ProjectHisTblEntity> getGetProjectHisTblEntity() {
		return getProjectHisTblEntity;
	}
	public void setGetProjectHisTblEntity(List<ProjectHisTblEntity> getProjectHisTblEntity) {
		this.getProjectHisTblEntity = getProjectHisTblEntity;
	}
	@Override
	public String toString() {
		return "C010101ListEntity [applicantInfoTblEntity=" + applicantInfoTblEntity + ", couMstEntity=" + couMstEntity
				+ ", industryMstEntity=" + industryMstEntity + ", jobtypeMstEntity=" + jobtypeMstEntity
				+ ", quaMstEntity=" + quaMstEntity + ", skillMstEntity=" + skillMstEntity + ", lanMstEntity="
				+ lanMstEntity + ", getApplicantQuaEntity=" + getApplicantQuaEntity + ", getApplicantSkillMstEntity="
				+ getApplicantSkillMstEntity + ", getApplicantWorkHisTblEntity=" + getApplicantWorkHisTblEntity
				+ ", getApplicantLanTblEntity=" + getApplicantLanTblEntity + ", getApplicantEduTblEntity="
				+ getApplicantEduTblEntity + ", getProjectHisTblEntity=" + getProjectHisTblEntity + "]";
	}

}
