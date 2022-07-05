package Ansin.web.entity;

import java.util.Date;

public class ApplicantLanTblEntity {
	private Integer appLanId;
	// 応募者ID
	private Integer applicantId;
	// 言語ID
	private Integer languageId;
	// レベル区分
	private String levelSection;
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

	public Integer getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(Integer applicantId) {
		this.applicantId = applicantId;
	}

	public Integer getLanguageId() {
		return languageId;
	}

	public void setLanguageId(Integer languageId) {
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

	public Integer getAppLanId() {
		return appLanId;
	}

	public void setAppLanId(Integer appLanId) {
		this.appLanId = appLanId;
	}

}
