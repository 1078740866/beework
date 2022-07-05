package Ansin.web.entity;

import java.sql.Timestamp;

public class A0601ListEntity {
	
	//通報ID
	private Integer reportId;
	//通報区分
	private String reportSection;
	//種類区分
	private String typeSection;
	//会社ID
	private Integer companyId;
	//会社名
	private String companyNm;
	//職位ID
	private Integer positionId;
	//職位名
	private String positionNm;
	//研修会ID
	private Integer trainingId;
	//研修会名
	private String trainingNm;
	//説明会ID
	private Integer briefingId;
	//説明会名
	private String briefingNm;
	//応募者ID
	private Integer applicantId;
	//ユーザーコード
	private Integer userCd;
	//ユーザー名
	private String firstName;
	private String lastName;
	//通報内容
	private String reportText;
	//スクリーンショット
	private String screenshot;
	//処理区分
	private String processingSection;
	//通報時間
	private Timestamp updateTime;
	public Integer getReportId() {
		return reportId;
	}
	public void setReportId(Integer reportId) {
		this.reportId = reportId;
	}
	public String getReportSection() {
		return reportSection;
	}
	public void setReportSection(String reportSection) {
		this.reportSection = reportSection;
	}
	public String getTypeSection() {
		return typeSection;
	}
	public void setTypeSection(String typeSection) {
		this.typeSection = typeSection;
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
	public Integer getPositionId() {
		return positionId;
	}
	public void setPositionId(Integer positionId) {
		this.positionId = positionId;
	}
	public String getPositionNm() {
		return positionNm;
	}
	public void setPositionNm(String positionNm) {
		this.positionNm = positionNm;
	}
	public Integer getTrainingId() {
		return trainingId;
	}
	public void setTrainingId(Integer trainingId) {
		this.trainingId = trainingId;
	}
	public String getTrainingNm() {
		return trainingNm;
	}
	public void setTrainingNm(String trainingNm) {
		this.trainingNm = trainingNm;
	}
	public Integer getBriefingId() {
		return briefingId;
	}
	public void setBriefingId(Integer briefingId) {
		this.briefingId = briefingId;
	}
	public String getBriefingNm() {
		return briefingNm;
	}
	public void setBriefingNm(String briefingNm) {
		this.briefingNm = briefingNm;
	}
	public Integer getApplicantId() {
		return applicantId;
	}
	public void setApplicantId(Integer applicantId) {
		this.applicantId = applicantId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getProcessingSection() {
		return processingSection;
	}
	public void setProcessingSection(String processingSection) {
		this.processingSection = processingSection;
	}
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	public Integer getUserCd() {
		return userCd;
	}
	public void setUserCd(Integer userCd) {
		this.userCd = userCd;
	}
	public String getReportText() {
		return reportText;
	}
	public void setReportText(String reportText) {
		this.reportText = reportText;
	}
	public String getScreenshot() {
		return screenshot;
	}
	public void setScreenshot(String screenshot) {
		this.screenshot = screenshot;
	}
	
	
	
}
