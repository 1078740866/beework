package Ansin.web.vueForm;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * B0401 面接一覧画面 VueForm
 * 
 * @author コウ テンキ
 * @date 2020-10-19 11:03:33
 */

public class B0401VueForm {
	// userCd
	private Integer userCd;
	//応募者ID
	private Integer applicantId;
	// 会社ID
	private Integer companyId;
	// 面接方式
	private String interviewType;
	// 面接日
	@JsonFormat(pattern = "yyyy/MM/dd")
	private Date interviewDateFrom;
	@JsonFormat(pattern = "yyyy/MM/dd")
	private Date interviewDateTo;
	// 開始時刻
	private String dateFrom;
	// 面接日付TO
	private String dateTo;
	// 面接状態
	private String statusFlg;
	// 面接ID
	private Integer interviewId;
	// 複数面接ID
	private List<Integer> interviewIds;
	public Integer getUserCd() {
		return userCd;
	}
	public void setUserCd(Integer userCd) {
		this.userCd = userCd;
	}
	public Integer getApplicantId() {
		return applicantId;
	}
	public void setApplicantId(Integer applicantId) {
		this.applicantId = applicantId;
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
	
}
