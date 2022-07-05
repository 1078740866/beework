package Ansin.web.vueForm;

import java.util.Date;
import java.util.List;

public class A020202VueForm{
	
	//ユーザーコード
	private Integer userCd;
	//応募者ID
	private Integer applicantId;
	// 研修名
	private String trainingNm;
	// 業種ID
	private Integer industryId;
	// 状態フラグ
	private String statusFlg;
	// 研修期間FROM
	private Date dateFrom;
	// 研修期間TO
	private Date dateTo;
	// 研修ID
	private Integer trainingId;
	// 研修IDLIST
	private List<Integer> trainingIds;
	
	public Integer getApplicantId() {
		return applicantId;
	}
	public void setApplicantId(Integer applicantId) {
		this.applicantId = applicantId;
	}
	public String getTrainingNm() {
		return trainingNm;
	}
	public void setTrainingNm(String trainingNm) {
		this.trainingNm = trainingNm;
	}
	public Integer getIndustryId() {
		return industryId;
	}
	public void setIndustryId(Integer industryId) {
		this.industryId = industryId;
	}
	public String getStatusFlg() {
		return statusFlg;
	}
	public void setStatusFlg(String statusFlg) {
		this.statusFlg = statusFlg;
	}
	public Date getDateFrom() {
		return dateFrom;
	}
	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}
	public Date getDateTo() {
		return dateTo;
	}
	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}
	public Integer getUserCd() {
		return userCd;
	}
	public void setUserCd(Integer userCd) {
		this.userCd = userCd;
	}
	public Integer getTrainingId() {
		return trainingId;
	}
	public void setTrainingId(Integer trainingId) {
		this.trainingId = trainingId;
	}
	public List<Integer> getTrainingIds() {
		return trainingIds;
	}
	public void setTrainingIds(List<Integer> trainingIds) {
		this.trainingIds = trainingIds;
	}
	@Override
	public String toString() {
		return "A020202VueForm [userCd=" + userCd + ", applicantId=" + applicantId + ", trainingNm=" + trainingNm
				+ ", industryId=" + industryId + ", statusFlg=" + statusFlg + ", dateFrom=" + dateFrom + ", dateTo="
				+ dateTo + ", trainingId=" + trainingId + ", trainingIds=" + trainingIds + ", getApplicantId()="
				+ getApplicantId() + ", getTrainingNm()=" + getTrainingNm() + ", getIndustryId()=" + getIndustryId()
				+ ", getStatusFlg()=" + getStatusFlg() + ", getDateFrom()=" + getDateFrom() + ", getDateTo()="
				+ getDateTo() + ", getUserCd()=" + getUserCd() + ", getTrainingId()=" + getTrainingId()
				+ ", getTrainingIds()=" + getTrainingIds() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
}