package Ansin.web.vueForm;

import java.util.Date;
import java.util.List;

/**
 * A020204面接一覧画面 VueForm
 * 
 * @author 楊卿赫
 * @date 2020-11-18 11:03:33
 */

public class A020204VueForm {
	
	//応募者ID
	private Integer applicantId;
	//userCd
	private Integer userCd;
    // 会社ID
    private Integer companyId;
    // 面接方式
    private String interviewType;
    //面接日
    private Date interviewDateFrom;
    private Date interviewDateTo;
    // 開始時刻
    private String DateFrom;
    // 面接日付TO
    private String DateTo;
    // 面接状態
    private String statusFlg;
    // 面接ID
    private  Integer interviewId;
    // 複数面接ID
    private List<Integer> interviewIds;
    
    
	public Integer getApplicantId() {
		return applicantId;
	}
	public void setApplicantId(Integer applicantId) {
		this.applicantId = applicantId;
	}
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
	public String getInterviewType() {
		return interviewType;
	}
	public void setInterviewType(String interviewType) {
		this.interviewType = interviewType;
	}
	public Date getInterviewDateFrom() {
		return interviewDateFrom;
	}
	public void setInterviewDateFrom(Date interviewDateFrom) {
		this.interviewDateFrom = interviewDateFrom;
	}
	public Date getInterviewDateTo() {
		return interviewDateTo;
	}
	public void setInterviewDateTo(Date interviewDateTo) {
		this.interviewDateTo = interviewDateTo;
	}
	public String getDateFrom() {
		return DateFrom;
	}
	public void setDateFrom(String dateFrom) {
		DateFrom = dateFrom;
	}
	public String getDateTo() {
		return DateTo;
	}
	public void setDateTo(String dateTo) {
		DateTo = dateTo;
	}
	public String getStatusFlg() {
		return statusFlg;
	}
	public void setStatusFlg(String statusFlg) {
		this.statusFlg = statusFlg;
	}
	public Integer getInterviewId() {
		return interviewId;
	}
	public void setInterviewId(Integer interviewId) {
		this.interviewId = interviewId;
	}
	public List<Integer> getInterviewIds() {
		return interviewIds;
	}
	public void setInterviewIds(List<Integer> interviewIds) {
		this.interviewIds = interviewIds;
	}
	@Override
	public String toString() {
		return "A020204VueForm [applicantId=" + applicantId + ", userCd=" + userCd + ", companyId=" + companyId
				+ ", interviewType=" + interviewType + ", interviewDateFrom=" + interviewDateFrom + ", interviewDateTo="
				+ interviewDateTo + ", DateFrom=" + DateFrom + ", DateTo=" + DateTo + ", statusFlg=" + statusFlg
				+ ", interviewId=" + interviewId + ", interviewIds=" + interviewIds + ", getApplicantId()="
				+ getApplicantId() + ", getUserCd()=" + getUserCd() + ", getCompanyId()=" + getCompanyId()
				+ ", getInterviewType()=" + getInterviewType() + ", getInterviewDateFrom()=" + getInterviewDateFrom()
				+ ", getInterviewDateTo()=" + getInterviewDateTo() + ", getDateFrom()=" + getDateFrom()
				+ ", getDateTo()=" + getDateTo() + ", getStatusFlg()=" + getStatusFlg() + ", getInterviewId()="
				+ getInterviewId() + ", getInterviewIds()=" + getInterviewIds() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
  
}
