package Ansin.web.bean;

public class ApplicantLanTblBean {
	// 応募者ID
	private String applicantId;
	// 言語ID
	private String languageId;
	// レベル区分
	private String levelSection;
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
	private String appLanId;

	public String getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(String applicantId) {
		this.applicantId = applicantId;
	}

	public String getLanguageId() {
		return languageId;
	}

	public void setLanguageId(String languageId) {
		this.languageId = languageId;
	}

	public String getLevelSection() {
		return levelSection;
	}

	public void setLevelSection(String levelSection) {
		this.levelSection = levelSection;
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

	public String getAppLanId() {
		return appLanId;
	}

	public void setAppLanId(String appLanId) {
		this.appLanId = appLanId;
	}

}
