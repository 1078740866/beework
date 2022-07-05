package Ansin.web.entity;

import java.sql.Timestamp;
import java.util.Date;

public class B0301Entity {
	
	//ユーザーコード
	private Integer userCd;
	//応募者ID
	private Integer applicantId;
	//姓
	private String lastName;
	//氏名
	private String firstName;
	//業種名
	private String industryNm;
	//職種名
	private String jobtypeNm;
	//性別
	private String sex;	
	//生年月日
	private Date birthday;
	//希望給与下限
	private Integer hopeSalaryFrom;	
	//希望給与上限
	private Integer hopeSalaryTo;
	//最寄駅
	private String station;	
	//最終学歴
	private String finalEducation;
	//卒業学校
	private String graduationSchool;
	//更新日時
	private Timestamp updateTime;
	//経験年数
	private Integer workYears;
	//住所１
	private String address1;
	//写真
	private String photo;
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
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getIndustryNm() {
		return industryNm;
	}
	public void setIndustryNm(String industryNm) {
		this.industryNm = industryNm;
	}
	public String getJobtypeNm() {
		return jobtypeNm;
	}
	public void setJobtypeNm(String jobtypeNm) {
		this.jobtypeNm = jobtypeNm;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Integer getHopeSalaryFrom() {
		return hopeSalaryFrom;
	}
	public void setHopeSalaryFrom(Integer hopeSalaryFrom) {
		this.hopeSalaryFrom = hopeSalaryFrom;
	}
	public Integer getHopeSalaryTo() {
		return hopeSalaryTo;
	}
	public void setHopeSalaryTo(Integer hopeSalaryTo) {
		this.hopeSalaryTo = hopeSalaryTo;
	}
	public String getStation() {
		return station;
	}
	public void setStation(String station) {
		this.station = station;
	}
	public String getFinalEducation() {
		return finalEducation;
	}
	public void setFinalEducation(String finalEducation) {
		this.finalEducation = finalEducation;
	}
	public String getGraduationSchool() {
		return graduationSchool;
	}
	public void setGraduationSchool(String graduationSchool) {
		this.graduationSchool = graduationSchool;
	}
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	public Integer getWorkYears() {
		return workYears;
	}
	public void setWorkYears(Integer workYears) {
		this.workYears = workYears;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	
}
