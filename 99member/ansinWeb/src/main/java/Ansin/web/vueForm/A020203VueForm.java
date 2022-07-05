package Ansin.web.vueForm;

import java.util.Date;
import java.util.List;

public class A020203VueForm {
	
	//応募者ID
	private Integer applicantId;
	//会社ID
	private Integer companyId;
	//ユーザーコード
	private Integer userCd;
	// 説明会方式
	private String briefingType;
	// 開始時刻
	private Date dateFrom;
	// 終了時刻
	private Date dateTo;
	// 確認状態
	private String statusFlg;
	// 説明会IDLIST
	private List<Integer> briefingIds;
	
	
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
	public Integer getUserCd() {
		return userCd;
	}
	public void setUserCd(Integer userCd) {
		this.userCd = userCd;
	}
	public String getBriefingType() {
		return briefingType;
	}
	public void setBriefingType(String briefingType) {
		this.briefingType = briefingType;
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
	public String getStatusFlg() {
		return statusFlg;
	}
	public void setStatusFlg(String statusFlg) {
		this.statusFlg = statusFlg;
	}
	public List<Integer> getBriefingIds() {
		return briefingIds;
	}
	public void setBriefingIds(List<Integer> briefingIds) {
		this.briefingIds = briefingIds;
	}
	@Override
	public String toString() {
		return "A020203VueForm [applicantId=" + applicantId + ", companyId=" + companyId + ", userCd=" + userCd
				+ ", briefingType=" + briefingType + ", dateFrom=" + dateFrom + ", dateTo=" + dateTo + ", statusFlg="
				+ statusFlg + ", briefingIds=" + briefingIds + ", getApplicantId()=" + getApplicantId()
				+ ", getCompanyId()=" + getCompanyId() + ", getUserCd()=" + getUserCd() + ", getBriefingType()="
				+ getBriefingType() + ", getDateFrom()=" + getDateFrom() + ", getDateTo()=" + getDateTo()
				+ ", getStatusFlg()=" + getStatusFlg() + ", getBriefingIds()=" + getBriefingIds() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}
