package Ansin.web.bean;

public class ApplicantSkillTblBean {
	// 業種ID
	private String industryId;
	// 職種ID
	private String jobtypeId;
	// 応募者スキルID
	private String appSkillId;
	// 応募者ID
	private String applicantId;
	// スキルID
	private String skillId;
	// 経験区分
	private String expSection;
	// その他名前
	private String otherNm;
	// 削除フラグ
	private String delFlg;
	// 作成日時
	private String createTime;
	// 作成者
	private String createBy;
	// 更新日時
	private String updateTime;
	// 更新者
	private String updateBy;
	// skill名
	private String skillNm;
	// 業種名
	private String industryNm;
	// 職種名
	private String jobtypeNm;

	public String getIndustryId() {
		return industryId;
	}

	public void setIndustryId(String industryId) {
		this.industryId = industryId;
	}

	public String getJobtypeId() {
		return jobtypeId;
	}

	public void setJobtypeId(String jobtypeId) {
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

	public String getAppSkillId() {
		return appSkillId;
	}

	public void setAppSkillId(String appSkillId) {
		this.appSkillId = appSkillId;
	}

	public String getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(String applicantId) {
		this.applicantId = applicantId;
	}

	public String getSkillId() {
		return skillId;
	}

	public void setSkillId(String skillId) {
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

	public String getDelFlg() {
		return delFlg;
	}

	public void setDelFlg(String delFlg) {
		this.delFlg = delFlg;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
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
