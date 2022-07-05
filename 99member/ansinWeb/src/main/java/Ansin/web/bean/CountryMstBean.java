package Ansin.web.bean;

import java.io.Serializable;

public class CountryMstBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private String countryId;
	private String countryNm;
	private String countryZip;

	public CountryMstBean() {
		super();
	}

	public CountryMstBean(String countryId, String countryNm) {
		super();
		this.countryId = countryId;
		this.countryNm = countryNm;

	}

	/**
	 * @return the countryId
	 */
	public String getCountryId() {
		return countryId;
	}

	/**
	 * @param countryId the countryId to set
	 */
	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	/**
	 * @return the countryNm
	 */
	public String getCountryNm() {
		return countryNm;
	}

	/**
	 * @param countryNm the countryNm to set
	 */
	public void setCountryNm(String countryNm) {
		this.countryNm = countryNm;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "IndustryInfoEntity [countryId=" + countryId + ", countryNm=" + countryNm + "]";
	}

	public String getCountryZip() {
		return countryZip;
	}

	public void setCountryZip(String countryZip) {
		this.countryZip = countryZip;
	}
}
