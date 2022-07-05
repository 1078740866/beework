package Ansin.web.bean;

import java.io.Serializable;
import java.util.List;

public class CompanyRegisterInitBean  implements Serializable {
	private static final long serialVersionUID = 1L;

	// 業種リストを定義
	List<IndustryMstBean> industryList;

	// 都道府県リストを定義
	List<PrefecturesMstBean> prefecturesList;

	// 国リストを定義
	List<CountryMstBean> countryList;

	// 規模リストを定義
	List<CompanyScaleBean> companyScaleList;

	public CompanyRegisterInitBean() {
		super();
	}

	public CompanyRegisterInitBean(List<IndustryMstBean> industryList, List<CountryMstBean> countryList,
			List<PrefecturesMstBean> prefecturesList, List<CompanyScaleBean> companyScaleList) {
		super();
		this.industryList = industryList;
		this.countryList = countryList;
		this.prefecturesList = prefecturesList;
		this.companyScaleList = companyScaleList;
	}

	/**
	 * @return the industryList
	 */
	public List<IndustryMstBean> getIndustryList() {
		return industryList;
	}

	/**
	 * @param industryList the industryList to set
	 */
	public void setIndustryList(List<IndustryMstBean> industryList) {
		this.industryList = industryList;
	}

	/**
	 * @return the countryList
	 */
	public List<CountryMstBean> getCountryList() {
		return countryList;
	}

	/**
	 * @param countryList the countryList to set
	 */
	public void setCountryList(List<CountryMstBean> countryList) {
		this.countryList = countryList;
	}

	public List<PrefecturesMstBean> getPrefecturesList() {
		return prefecturesList;
	}

	public void setPrefecturesList(List<PrefecturesMstBean> prefecturesList) {
		this.prefecturesList = prefecturesList;
	}

	public List<CompanyScaleBean> getCompanyScaleList() {
		return companyScaleList;
	}

	public void setCompanyScaleList(List<CompanyScaleBean> companyScaleList) {
		this.companyScaleList = companyScaleList;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
