package Ansin.web.entity;

import java.util.Date;

public class ApplicantSkillTblEntity {

	// 業種ID
	private Integer industryId;
	// 職種ID
	private Integer jobtypeId;
	// 応募者スキルID
	private Integer appSkillId;
	// 応募者ID
	private Integer applicantId;
	// スキルID
	private Integer skillId;
	// 経験区分
	private String expSection;
	// その他名前
	private String otherNm;
	// 備考
	private String remarks;
	// 削除フラグ
	private String delFlg;
	// 作成日時
	private Date createTime;
	// 作成者
	private String createBy;
	// 更新日時
	private Date updateTime;
	// 更新者
	private String updateBy;
	// SKILL名
	private String skillNm;
	// 業種名
	private String industryNm;
	// 職種名
	private String jobtypeNm;

	public Integer getIndustryId() {
		return industryId;
	}

	public void setIndustryId(Integer industryId) {
		this.industryId = industryId;
	}

	public Integer getJobtypeId() {
		return jobtypeId;
	}

	public void setJobtypeId(Integer jobtypeId) {
		this.jobtypeId = jobtypeId;
	}

	public String getIndustryNm() {
		return industryNm;
	}

	public void setIndustryNm(String industryNm) {
		this.industryNm = industryNm;
	}

	public String getJobtypeNm() {
		return jobtypeNm;
	}

	public void setJobtypeNm(String jobtypeNm) {
		this.jobtypeNm = jobtypeNm;
	}

	public Integer getAppSkillId() {
		return appSkillId;
	}

	public void setAppSkillId(Integer appSkillId) {
		this.appSkillId = appSkillId;
	}

	public Integer getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(Integer applicantId) {
		this.applicantId = applicantId;
	}

	public Integer getSkillId() {
		return skillId;
	}

	public void setSkillId(Integer skillId) {
		this.skillId = skillId;
	}

	public String getExpSection() {
		return expSection;
	}

	public void setExpSection(String expSection) {
		this.expSection = expSection;
	}

	public String getOtherNm() {
		return otherNm;
	}

	public void setOtherNm(String otherNm) {
		this.otherNm = otherNm;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getDelFlg() {
		return delFlg;
	}

	public void setDelFlg(String delFlg) {
		this.delFlg = delFlg;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public String getSkillNm() {
		return skillNm;
	}

	public void setSkillNm(String skillNm) {
		this.skillNm = skillNm;
	}

}
