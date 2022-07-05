package Ansin.web.vueForm;

import java.util.List;

/**
 * B0401 会社一覧画面 VueForm
 * 
 * @author 王 凱
 * @date 2020-11-15 16:49:51
 */

public class A0101VueForm {
	// ユーザーID
	private Integer userCd;
	// 会社ID
	private Integer companyId;
	// 会社名
	private String companyNm;
	// 会社所在地1
	private String address1;
	// 業種ID1
	private Integer industryId1;
	// 会社規模
	private String companyScale;
	// 国ID
	private Integer countryId;
	// 事業内容
	private String businessContent;
	// 複数面接ID
	private List<Integer> companyIdList;

	public Integer getUserCd() {
		return userCd;
	}
	public void setUserCd(Integer userCd) {
		this.userCd = userCd;
	}
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	public String getCompanyNm() {
		return companyNm;
	}
	public void setCompanyNm(String companyNm) {
		this.companyNm = companyNm;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public Integer getIndustryId1() {
		return industryId1;
	}
	public void setIndustryId1(Integer industryId1) {
		this.industryId1 = industryId1;
	}
	public String getCompanyScale() {
		return companyScale;
	}
	public void setCompanyScale(String companyScale) {
		this.companyScale = companyScale;
	}
	public Integer getCountryId() {
		return countryId;
	}
	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}
	public String getBusinessContent() {
		return businessContent;
	}
	public void setBusinessContent(String businessContent) {
		this.businessContent = businessContent;
	}
	public List<Integer> getCompanyIdList() {
		return companyIdList;
	}
	public void setCompanyIdList(List<Integer> companyIdList) {
		this.companyIdList = companyIdList;
	}
}
