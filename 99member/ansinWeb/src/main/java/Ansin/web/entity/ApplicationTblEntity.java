package Ansin.web.entity;

public class ApplicationTblEntity {
	
	//会社ID
	private Integer companyId;
	//職位ID
	private Integer positionId;
	//応募者ID
	private Integer applicantId;
	//会社応募状態
	private String appComStatus;
	//応募者応募状態
	private String appAppStatus;
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	public Integer getPositionId() {
		return positionId;
	}
	public void setPositionId(Integer positionId) {
		this.positionId = positionId;
	}
	public Integer getApplicantId() {
		return applicantId;
	}
	public void setApplicantId(Integer applicantId) {
		this.applicantId = applicantId;
	}
	public String getAppComStatus() {
		return appComStatus;
	}
	public void setAppComStatus(String appComStatus) {
		this.appComStatus = appComStatus;
	}
	public String getAppAppStatus() {
		return appAppStatus;
	}
	public void setAppAppStatus(String appAppStatus) {
		this.appAppStatus = appAppStatus;
	}
	

}
