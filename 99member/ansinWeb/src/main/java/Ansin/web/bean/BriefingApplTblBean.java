package Ansin.web.bean;

/**
 * 説明会Bean
 * @author楊卿赫
 * @date 2020-11-11 17:25:58
 */
public class BriefingApplTblBean {

    // 会社ID
    private String companyId;
    // 説明会ID
    private String briefingId;
    // 応募者ID
    private String applicantId;
    // ユーザーコード
    private String userCd;
    // 姓
    private String firstName;
    // 氏名
    private String lastName;
    // 生年月日
    private String birthday;
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
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getBriefingId() {
		return briefingId;
	}
	public void setBriefingId(String briefingId) {
		this.briefingId = briefingId;
	}
	public String getApplicantId() {
		return applicantId;
	}
	public void setApplicantId(String applicantId) {
		this.applicantId = applicantId;
	}
	public String getUserCd() {
		return userCd;
	}
	public void setUserCd(String userCd) {
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
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
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
		return "BriefingApplTblBean [companyId=" + companyId + ", briefingId=" + briefingId + ", applicantId="
				+ applicantId + ", userCd=" + userCd + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", birthday=" + birthday + ", prefeNm=" + prefeNm + ", station=" + station + ", sex=" + sex
				+ ", graduationSchool=" + graduationSchool + ", graduationMajor=" + graduationMajor + ", userTel="
				+ userTel + ", workSituation=" + workSituation + "]";
	}
    
}
