package Ansin.web.entity;

import java.sql.Date;
import java.sql.Time;

/**
 * B0401 面接一覧画面entity
 * 
 * @author コウ テンキ
 * @date 2020-10-19 17:15:18
 */
public class InterviewHisTblEntity {

    // 面接ID
    private Integer interviewId;
    // 会社ID
    private Integer companyId;
    // 応募者ID
    private Integer positionId;
    // 職位ID
    private Integer applicantId;
    // 面接方式
    private String interviewType;
    // 職位名
    private String positionNm;
    // 氏名
    private String firstName;
    // 姓
    private String lastName;
    // 面談施行状態
    private String statusFlg;
    // 担当者氏名
    private String responsible;
    // 連絡先
    private String tel;
    // 面接日
    private Date interviewDate;
    // 開始時刻
    private Time dateFrom;
    // 終了時刻
    private Time dateTo;
    // 面接地
    private String interviewAddress;
    // 備考
    private String remarks;
    // 写真
    private String photo;
	public Integer getInterviewId() {
		return interviewId;
	}
	public void setInterviewId(Integer interviewId) {
		this.interviewId = interviewId;
	}
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
	public String getInterviewType() {
		return interviewType;
	}
	public void setInterviewType(String interviewType) {
		this.interviewType = interviewType;
	}
	public String getPositionNm() {
		return positionNm;
	}
	public void setPositionNm(String positionNm) {
		this.positionNm = positionNm;
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
	public String getStatusFlg() {
		return statusFlg;
	}
	public void setStatusFlg(String statusFlg) {
		this.statusFlg = statusFlg;
	}
	public String getResponsible() {
		return responsible;
	}
	public void setResponsible(String responsible) {
		this.responsible = responsible;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Date getInterviewDate() {
		return interviewDate;
	}
	public void setInterviewDate(Date interviewDate) {
		this.interviewDate = interviewDate;
	}
	public Time getDateFrom() {
		return dateFrom;
	}
	public void setDateFrom(Time dateFrom) {
		this.dateFrom = dateFrom;
	}
	public Time getDateTo() {
		return dateTo;
	}
	public void setDateTo(Time dateTo) {
		this.dateTo = dateTo;
	}
	public String getInterviewAddress() {
		return interviewAddress;
	}
	public void setInterviewAddress(String interviewAddress) {
		this.interviewAddress = interviewAddress;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	@Override
	public String toString() {
		return "InterviewHisTblEntity [interviewId=" + interviewId + ", companyId=" + companyId + ", positionId="
				+ positionId + ", applicantId=" + applicantId + ", interviewType=" + interviewType + ", positionNm="
				+ positionNm + ", firstName=" + firstName + ", lastName=" + lastName + ", statusFlg=" + statusFlg
				+ ", responsible=" + responsible + ", tel=" + tel + ", interviewDate=" + interviewDate + ", dateFrom="
				+ dateFrom + ", dateTo=" + dateTo + ", interviewAddress=" + interviewAddress + ", remarks=" + remarks
				+ ", photo=" + photo + "]";
	}
  
}
