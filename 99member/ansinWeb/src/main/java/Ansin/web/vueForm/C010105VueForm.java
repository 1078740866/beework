package Ansin.web.vueForm;

public class C010105VueForm {

	// sessionから会社ID
	private Integer companyId;
	// sessionから会社usercd
	private Integer userCd;
	// 応募者ID
	private Integer applicantId;
	// 言語ID
	private Integer languageId;
	// レベル区分
	private String levelSection;
	private Integer appLanId;

	public Integer getAppLanId() {
		return appLanId;
	}

	public void setAppLanId(Integer appLanId) {
		this.appLanId = appLanId;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public Integer getUserCd() {
		return userCd;
	}

	public void setUserCd(Integer userCd) {
		this.userCd = userCd;
	}

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

}
