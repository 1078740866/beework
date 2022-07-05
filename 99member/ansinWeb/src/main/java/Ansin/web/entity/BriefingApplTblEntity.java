package Ansin.web.entity;

import java.util.Date;

/**
 * 
 * @author コウ テンキ
 * @date 2020-10-16 15:25:58
 */

// 説明会応募者
public class BriefingApplTblEntity {

    // 会社ID
    private Integer companyId;
    // 説明会ID
    private Integer briefingId;
    // 応募者ID
    private Integer applicantId;
    // ユーザーコード
    private Integer userCd;
    // 姓
    private String firstName;
    // 氏名
    private String lastName;
    // 生年月日
    private Date birthday;
    // 都道府県名
    private String prefeNm;
    // 最寄駅
    private String station;
    // 性別
    private String sex;
    // 卒業学校
    private String graduationSchool;
    // 専攻
    private String graduationMajor;
    // 電話番号
    private String userTel;
    // 仕事状況
    private String workSituation;
    
    
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	public Integer getBriefingId() {
		return briefingId;
	}
	public void setBriefingId(Integer briefingId) {
		this.briefingId = briefingId;
	}
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
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getPrefeNm() {
		return prefeNm;
	}
	public void setPrefeNm(String prefeNm) {
		this.prefeNm = prefeNm;
	}
	public String getStation() {
		return station;
	}
	public void setStation(String station) {
		this.station = station;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getGraduationSchool() {
		return graduationSchool;
	}
	public void setGraduationSchool(String graduationSchool) {
		this.graduationSchool = graduationSchool;
	}
	public String getGraduationMajor() {
		return graduationMajor;
	}
	public void setGraduationMajor(String graduationMajor) {
		this.graduationMajor = graduationMajor;
	}
	public String getUserTel() {
		return userTel;
	}
	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}
	public String getWorkSituation() {
		return workSituation;
	}
	public void setWorkSituation(String workSituation) {
		this.workSituation = workSituation;
	}
	@Override
	public String toString() {
		return "BriefingApplTblEntity [companyId=" + companyId + ", briefingId=" + briefingId + ", applicantId="
				+ applicantId + ", userCd=" + userCd + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", birthday=" + birthday + ", prefeNm=" + prefeNm + ", station=" + station + ", sex=" + sex
				+ ", graduationSchool=" + graduationSchool + ", graduationMajor=" + graduationMajor + ", userTel="
				+ userTel + ", workSituation=" + workSituation + ", getCompanyId()=" + getCompanyId()
				+ ", getBriefingId()=" + getBriefingId() + ", getApplicantId()=" + getApplicantId() + ", getUserCd()="
				+ getUserCd() + ", getFirstName()=" + getFirstName() + ", getLastName()=" + getLastName()
				+ ", getBirthday()=" + getBirthday() + ", getPrefeNm()=" + getPrefeNm() + ", getStation()="
				+ getStation() + ", getSex()=" + getSex() + ", getGraduationSchool()=" + getGraduationSchool()
				+ ", getGraduationMajor()=" + getGraduationMajor() + ", getUserTel()=" + getUserTel()
				+ ", getWorkSituation()=" + getWorkSituation() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

}
