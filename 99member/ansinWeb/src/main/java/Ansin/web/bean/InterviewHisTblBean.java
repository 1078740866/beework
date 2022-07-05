package Ansin.web.bean;

public class InterviewHisTblBean {
	// 面接ID
    private String interviewId;
    // 会社ID
    private String companyId;
    // 応募者ID
    private String positionId;
    // 職位ID
    private String applicantId;
    // 面接方式
    private String interviewType;
    // 職位名
    private String positionNm;
    // 姓
    private String name;
    // 面談施行状態
    private String statusFlg;
    // 担当者氏名
    private String responsible;
    // 連絡先
    private String tel;
    // 面接日
    private String interviewDate;
    // 開始時刻
    private String dateFrom;
    // 終了時刻
    private String dateTo;
    // 面接地
    private String interviewAddress;
    // 備考
    private String remarks;
    // 写真
    private String photo;
    private byte[] photoPic;
    //会社名
    private String companyNm;
	public String getInterviewId() {
		return interviewId;
	}
	public void setInterviewId(String interviewId) {
		this.interviewId = interviewId;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getPositionId() {
		return positionId;
	}
	public void setPositionId(String positionId) {
		this.positionId = positionId;
	}
	public String getApplicantId() {
		return applicantId;
	}
	public void setApplicantId(String applicantId) {
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getInterviewDate() {
		return interviewDate;
	}
	public void setInterviewDate(String interviewDate) {
		this.interviewDate = interviewDate;
	}
	public String getDateFrom() {
		return dateFrom;
	}
	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}
	public String getDateTo() {
		return dateTo;
	}
	public void setDateTo(String dateTo) {
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
	
	public String getCompanyNm() {
		return companyNm;
	}
	public void setCompanyNm(String companyNm) {
		this.companyNm = companyNm;
	}
	@Override
	public String toString() {
		return "InterviewHisTblBean [interviewId=" + interviewId + ", companyId=" + companyId + ", positionId="
				+ positionId + ", applicantId=" + applicantId + ", interviewType=" + interviewType + ", positionNm="
				+ positionNm + ", name=" + name + ", statusFlg=" + statusFlg + ", responsible=" + responsible + ", tel="
				+ tel + ", interviewDate=" + interviewDate + ", dateFrom=" + dateFrom + ", dateTo=" + dateTo
				+ ", interviewAddress=" + interviewAddress + ", remarks=" + remarks + ", photo=" + photo
				+ ", getInterviewId()=" + getInterviewId() + ", getCompanyId()=" + getCompanyId() + ", getPositionId()="
				+ getPositionId() + ", getApplicantId()=" + getApplicantId() + ", getInterviewType()="
				+ getInterviewType() + ", getPositionNm()=" + getPositionNm() + ", getName()=" + getName()
				+ ", getStatusFlg()=" + getStatusFlg() + ", getResponsible()=" + getResponsible() + ", getTel()="
				+ getTel() + ", getInterviewDate()=" + getInterviewDate() + ", getDateFrom()=" + getDateFrom()
				+ ", getDateTo()=" + getDateTo() + ", getInterviewAddress()=" + getInterviewAddress()
				+ ", getRemarks()=" + getRemarks() + ", getPhoto()=" + getPhoto() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	public byte[] getPhotoPic() {
		return photoPic;
	}
	public void setPhotoPic(byte[] photoPic) {
		this.photoPic = photoPic;
	}
    
}
