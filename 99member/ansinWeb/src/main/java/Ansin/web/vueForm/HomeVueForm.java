package Ansin.web.vueForm;

public class HomeVueForm {
	
	// 会社名または業種名
	private String searchNm;
	// 業種ID
	private Integer industryId;
	// 職種ID
	private Integer jobtypeId;
	// 都道府県名
	private String prefeNm;
	// 言語
	private String language;
	// 言語レベル区分
	private String levelSection;
	// 広告ID
	private Integer adId;
	
	/**
	 * @return the searchNm
	 */
	public String getSearchNm() {
		return searchNm;
	}
	/**
	 * @param searchNm the searchNm to set
	 */
	public void setSearchNm(String searchNm) {
		this.searchNm = searchNm;
	}
	/**
	 * @return the industryId
	 */
	public Integer getIndustryId() {
		return industryId;
	}
	/**
	 * @param industryId the industryId to set
	 */
	public void setIndustryId(Integer industryId) {
		this.industryId = industryId;
	}
	/**
	 * @return the jobtypeId
	 */
	public Integer getJobtypeId() {
		return jobtypeId;
	}
	/**
	 * @param jobtypeId the jobtypeId to set
	 */
	public void setJobtypeId(Integer jobtypeId) {
		this.jobtypeId = jobtypeId;
	}
	/**
	 * @return the prefeNm
	 */
	public String getPrefeNm() {
		return prefeNm;
	}
	/**
	 * @param prefeNm the prefeNm to set
	 */
	public void setPrefeNm(String prefeNm) {
		this.prefeNm = prefeNm;
	}
	/**
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}
	/**
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}
	/**
	 * @return the levelSection
	 */
	public String getLevelSection() {
		return levelSection;
	}
	/**
	 * @param levelSection the levelSection to set
	 */
	public void setLevelSection(String levelSection) {
		this.levelSection = levelSection;
	}
	/**
	 * @return the adId
	 */
	public Integer getAdId() {
		return adId;
	}
	/**
	 * @param adId the adId to set
	 */
	public void setAdId(Integer adId) {
		this.adId = adId;
	}
}
