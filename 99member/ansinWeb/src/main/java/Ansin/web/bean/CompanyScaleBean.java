package Ansin.web.bean;

import java.io.Serializable;

public class CompanyScaleBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private String companyScale;
	private String companyScaleNm;

	public CompanyScaleBean() {
		super();
	}

	public CompanyScaleBean(String companyScale, String companyScaleNm) {
		super();
		this.companyScale = companyScale;
		this.companyScaleNm = companyScaleNm;

	}



	public String getCompanyScale() {
		return companyScale;
	}

	public String getCompanyScaleNm() {
		return companyScaleNm;
	}

	public void setCompanyScale(String companyScale) {
		this.companyScale = companyScale;
	}

	public void setCompanyScaleNm(String companyScaleNm) {
		this.companyScaleNm = companyScaleNm;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "IndustryInfoEntity [companyScale=" + companyScale + ", companyScaleNm=" + companyScaleNm + "]";
	}

}
