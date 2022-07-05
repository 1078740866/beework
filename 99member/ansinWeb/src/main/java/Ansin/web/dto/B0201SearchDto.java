package Ansin.web.dto;

public class B0201SearchDto {

	// 検索条件
	// 職位
	private Integer positionId;
	// 経験年数(FROM)
	private Integer workYearsFrom;
	// 経験年数(TO)
	private Integer workYearsTo;
	// 学位
	private String degreeId;
	// 年齢(FROM)
	private String ageFrom;
	// 年齢(TO)
	private String ageTo;
	// 学歴区分
	private String eduSectionId;
	// 住所
	private String address;
	// キーワード検索名前
	private String name;
	// 応募状態
	private String applicationStatus;
	// 会社ID
	private Integer companyId;
	public Integer getPositionId() {
		return positionId;
	}
	public Integer getWorkYearsFrom() {
		return workYearsFrom;
	}
	public Integer getWorkYearsTo() {
		return workYearsTo;
	}
	public String getDegreeId() {
		return degreeId;
	}
	public String getAgeFrom() {
		return ageFrom;
	}
	public String getAgeTo() {
		return ageTo;
	}
	public String getEduSectionId() {
		return eduSectionId;
	}
	public String getAddress() {
		return address;
	}
	public String getName() {
		return name;
	}
	public String getApplicationStatus() {
		return applicationStatus;
	}
	public Integer getCompanyId() {
		return companyId;
	}
	public void setPositionId(Integer positionId) {
		this.positionId = positionId;
	}
	public void setWorkYearsFrom(Integer workYearsFrom) {
		this.workYearsFrom = workYearsFrom;
	}
	public void setWorkYearsTo(Integer workYearsTo) {
		this.workYearsTo = workYearsTo;
	}
	public void setDegreeId(String degreeId) {
		this.degreeId = degreeId;
	}
	public void setAgeFrom(String ageFrom) {
		this.ageFrom = ageFrom;
	}
	public void setAgeTo(String ageTo) {
		this.ageTo = ageTo;
	}
	public void setEduSectionId(String eduSectionId) {
		this.eduSectionId = eduSectionId;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setApplicationStatus(String applicationStatus) {
		this.applicationStatus = applicationStatus;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}


}
