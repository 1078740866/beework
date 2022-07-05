package Ansin.web.vueForm;

import java.sql.Time;
import java.util.Date;

public class C0301ListVueForm {
	
	//研修名
	private String trainingNm;
	//会社名
	private String companyNm;
	//都道府県
	private String	prefeNm;
	//業種ID
	private Integer	industryId;
	//日付FROM
	private Date dateFrom;	
	//日付TO
	private Date dateTo;	
	//時間FROM
	private Time timeFrom;	
	//時間TO
	private Time timeTo;	
	//料金有無
	private Integer salary;
	//ユーザーコード
	private Integer userCd;
	//応募者ID
	private Integer applicantId;
	
	public String getTrainingNm() {
		return trainingNm;
	}
	public void setTrainingNm(String trainingNm) {
		this.trainingNm = trainingNm;
	}
	public String getCompanyNm() {
		return companyNm;
	}
	public void setCompanyNm(String companyNm) {
		this.companyNm = companyNm;
	}
	public String getPrefeNm() {
		return prefeNm;
	}
	public void setPrefeNm(String prefeNm) {
		this.prefeNm = prefeNm;
	}
	public Integer getIndustryId() {
		return industryId;
	}
	public void setIndustryId(Integer industryId) {
		this.industryId = industryId;
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
	public Time getTimeFrom() {
		return timeFrom;
	}
	public void setTimeFrom(Time timeFrom) {
		this.timeFrom = timeFrom;
	}
	public Time getTimeTo() {
		return timeTo;
	}
	public void setTimeTo(Time timeTo) {
		this.timeTo = timeTo;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
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
	

}
