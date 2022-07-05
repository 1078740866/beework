package Ansin.web.vueForm;

import javax.validation.Valid;

public class B0002VueForm {

	@Valid
	private CompanyInfo companyInfo;

	/**
	 * @return the companyInfo
	 */

	public CompanyInfo getCompanyInfo() {
		return companyInfo;
	}

	/**
	 * @param companyInfo the companyInfo to set
	 */
	public void setCompanyInfo(CompanyInfo companyInfo) {
		this.companyInfo = companyInfo;
	}

	@Override
	public String toString() {
		return "CompanyRegister [companyInfo=" + companyInfo + "]";
	}



}
