package Ansin.web.bean;

import java.io.Serializable;

public class IndustryMstBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private String industryId;
	private String industryNm;

	public IndustryMstBean() {
		super();
	}

	public IndustryMstBean(String industryId, String industryNm) {
		super();
		this.industryId = industryId;
		this.industryNm = industryNm;

	}

	/**
	 * @return the industryId
	 */
	public String getIndustryId() {
		return industryId;
	}

	/**
	 * @param industryId the industryId to set
	 */
	public void setIndustryId(String industryId) {
		this.industryId = industryId;
	}

	/**
	 * @return the industryNm
	 */
	public String getIndustryNm() {
		return industryNm;
	}

	/**
	 * @param industryNm the industryNm to set
	 */
	public void setIndustryNm(String industryNm) {
		this.industryNm = industryNm;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "IndustryInfoEntity [industryId=" + industryId + ", industryNm=" + industryNm + "]";
	}

}
