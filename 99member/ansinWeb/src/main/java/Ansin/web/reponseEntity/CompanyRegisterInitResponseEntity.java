package Ansin.web.reponseEntity;

import java.io.Serializable;
import java.util.List;

import Ansin.web.bean.CountryMstBean;
import Ansin.web.bean.IndustryMstBean;
import Ansin.web.bean.PrefecturesMstBean;

public class CompanyRegisterInitResponseEntity  implements Serializable {
	private static final long serialVersionUID = 1L;

	// 業種リストを定義
	List<IndustryMstBean> industryList;

	// 都道府県リストを定義
	List<PrefecturesMstBean> prefecturesList;

	// 国リストを定義
	List<CountryMstBean> countryList;

	public CompanyRegisterInitResponseEntity() {
		super();
	}

	public CompanyRegisterInitResponseEntity(List<IndustryMstBean> industryList, List<CountryMstBean> countryList, List<PrefecturesMstBean> prefecturesList) {
		super();
		this.industryList = industryList;
		this.countryList = countryList;
		this.prefecturesList = prefecturesList;
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

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
