package Ansin.web.vueForm;

import java.sql.Date;
import java.sql.Time;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * B0402 面接詳細情報 interviewInfo
 * 
 * @author コウ テンキ
 * @date 2020-10-21 17:10:50
 */

public class B0402VueForm {

	// 面接ID
	private Integer interviewId;
	// 会社ID
	private Integer companyId;
	// 職位ID
	private Integer positionId;
	// 応募者ID
	private Integer applicantId;
	// 面接方式
	@NotBlank(message="面接方式を入力してください")
	private String interviewType;
	// 連絡先
	@NotBlank(message="連絡先を入力してください")
	private String tel;
	// 担当者氏名
	@NotBlank(message="担当者氏名を入力してください")
	private String responsible;
	// 面接地
	private String interviewAddress;
	// 面接日
	@NotNull(message="面接日を入力してください")
	private Date interviewDate;
	// 開始時刻
	@NotNull(message="開始時刻を入力してください")
	private Time dateFrom;
	// 終了時刻
	@NotNull(message="終了時刻を入力してください")
	private Time dateTo;
	// 面談施行状態
	private String statusFlg;
	// 備考
	private String remarks;
	// 職位名
	@NotBlank(message="職位名を入力してください")
	private String positionNm;
	// 氏名
	private String firstName;
	// 姓
	private String lastName;
	// 写真
	private String photo;
	// 更新時間
	private Time updateTime;
	// 更新者
	private Integer userCd;
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
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getResponsible() {
		return responsible;
	}
	public void setResponsible(String responsible) {
		this.responsible = responsible;
	}
	public String getInterviewAddress() {
		return interviewAddress;
	}
	public void setInterviewAddress(String interviewAddress) {
		this.interviewAddress = interviewAddress;
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
	public String getStatusFlg() {
		return statusFlg;
	}
	public void setStatusFlg(String statusFlg) {
		this.statusFlg = statusFlg;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
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
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Time getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Time updateTime) {
		this.updateTime = updateTime;
	}
	public Integer getUserCd() {
		return userCd;
	}
	public void setUserCd(Integer userCd) {
		this.userCd = userCd;
	}
	@Override
	public String toString() {
		return "B0402VueForm [interviewId=" + interviewId + ", companyId=" + companyId + ", positionId=" + positionId
				+ ", applicantId=" + applicantId + ", interviewType=" + interviewType + ", tel=" + tel
				+ ", responsible=" + responsible + ", interviewAddress=" + interviewAddress + ", interviewDate="
				+ interviewDate + ", dateFrom=" + dateFrom + ", dateTo=" + dateTo + ", statusFlg=" + statusFlg
				+ ", remarks=" + remarks + ", positionNm=" + positionNm + ", firstName=" + firstName + ", lastName="
				+ lastName + ", photo=" + photo + ", updateTime=" + updateTime + ", userCd=" + userCd + "]";
	}
	

}
