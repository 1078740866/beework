package Ansin.web.vueForm;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class C010101VueForm {
	// sessionから会社ID
	private Integer companyId;
	// sessionから会社usercd
	private Integer userCd;
	// 応募者ID
	private Integer applicantId;
	// 写真
	private String photo;
	// 国ID
	@NotNull(message = "国を入力してください")
	private Integer countryId;
	// 生年月日
	@NotNull(message = "生年月日を入力してください")
	private Date birthday;
	// 郵便番号
	@NotBlank(message = "郵便番号を入力してください")
	private String applicantPostal;
	// 住所1
	@NotBlank(message = "住所を入力してください")
	private String address1;
	// 住所2
	@NotBlank(message = "住所を入力してください")
	private String address2;
	// 都道府県名
	private String prefeNm;
	// 最寄駅
	@NotBlank(message = "最寄駅を入力してください")
	private String station;
	// 業種ID1
	@NotNull(message = "業種を入力してください")
	private Integer industryId1;
	// 職種ID1_1
	@NotNull(message = "職種を入力してください")
	private Integer jobtypeId1_1;
	// 職種ID1_2
	private Integer jobtypeId1_2;
	// 職種ID1_3
	private Integer jobtypeId1_3;
	// 業種ID2
	private Integer industryId2;
	// 職種ID2_1
	private Integer jobtypeId2_1;
	// 職種ID2_2
	private Integer jobtypeId2_2;
	// 職種ID2_3
	private Integer jobtypeId2_3;
	// 業種ID3
	private Integer industryId3;
	// 職種ID3_1
	private Integer jobtypeId3_1;
	// 職種ID3_2
	private Integer jobtypeId3_2;
	// 職種ID3_3
	private Integer jobtypeId3_3;
	// 希望地1
	private Integer hopeLand1;
	// 希望地2
	private Integer hopeLand2;
	// 希望地3
	private Integer hopeLand3;
	// 卒業学校
	@NotBlank(message = "卒業学校を入力してください")
	private String graduationSchool;
	// 専攻
	private String graduationMajor;
	// 最終学歴
	@NotBlank(message = "最終学歴を入力してください")
	private String finalEducation;
	// 仕事経験年数
	@NotNull(message = "仕事経験年数を入力してください")
	private int workYears;
	// 希望給与下限
	@NotNull(message = "希望給与下限を入力してください")
	private int hopeSalaryFrom;
	// 希望給与上限
	@NotNull(message = "希望給与上限を入力してください")
	private int hopeSalaryTo;
	// 仕事状況
	@NotBlank(message = "仕事状況を入力してください")
	private String workSituation;
	// 特技
	private String specialty;
	// 志望理由
	private String reason;
	// アピール
	private String introduce;
	// 趣味
	private String interest;
	// 備考
	private String remarks;

	public Integer getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(Integer applicantId) {
		this.applicantId = applicantId;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getApplicantPostal() {
		return applicantPostal;
	}

	public void setApplicantPostal(String applicantPostal) {
		this.applicantPostal = applicantPostal;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getStation() {
		return station;
	}

	public void setStation(String station) {
		this.station = station;
	}

	public Integer getIndustryId1() {
		return industryId1;
	}

	public void setIndustryId1(Integer industryId1) {
		this.industryId1 = industryId1;
	}

	public Integer getJobtypeId1_1() {
		return jobtypeId1_1;
	}

	public void setJobtypeId1_1(Integer jobtypeId1_1) {
		this.jobtypeId1_1 = jobtypeId1_1;
	}

	public Integer getJobtypeId1_2() {
		return jobtypeId1_2;
	}

	public void setJobtypeId1_2(Integer jobtypeId1_2) {
		this.jobtypeId1_2 = jobtypeId1_2;
	}

	public Integer getJobtypeId1_3() {
		return jobtypeId1_3;
	}

	public void setJobtypeId1_3(Integer jobtypeId1_3) {
		this.jobtypeId1_3 = jobtypeId1_3;
	}

	public Integer getIndustryId2() {
		return industryId2;
	}

	public void setIndustryId2(Integer industryId2) {
		this.industryId2 = industryId2;
	}

	public Integer getJobtypeId2_1() {
		return jobtypeId2_1;
	}

	public void setJobtypeId2_1(Integer jobtypeId2_1) {
		this.jobtypeId2_1 = jobtypeId2_1;
	}

	public Integer getJobtypeId2_2() {
		return jobtypeId2_2;
	}

	public void setJobtypeId2_2(Integer jobtypeId2_2) {
		this.jobtypeId2_2 = jobtypeId2_2;
	}

	public Integer getJobtypeId2_3() {
		return jobtypeId2_3;
	}

	public void setJobtypeId2_3(Integer jobtypeId2_3) {
		this.jobtypeId2_3 = jobtypeId2_3;
	}

	public Integer getIndustryId3() {
		return industryId3;
	}

	public void setIndustryId3(Integer industryId3) {
		this.industryId3 = industryId3;
	}

	public Integer getJobtypeId3_1() {
		return jobtypeId3_1;
	}

	public void setJobtypeId3_1(Integer jobtypeId3_1) {
		this.jobtypeId3_1 = jobtypeId3_1;
	}

	public Integer getJobtypeId3_2() {
		return jobtypeId3_2;
	}

	public void setJobtypeId3_2(Integer jobtypeId3_2) {
		this.jobtypeId3_2 = jobtypeId3_2;
	}

	public Integer getJobtypeId3_3() {
		return jobtypeId3_3;
	}

	public void setJobtypeId3_3(Integer jobtypeId3_3) {
		this.jobtypeId3_3 = jobtypeId3_3;
	}

	public Integer getHopeLand1() {
		return hopeLand1;
	}

	public void setHopeLand1(Integer hopeLand1) {
		this.hopeLand1 = hopeLand1;
	}

	public Integer getHopeLand2() {
		return hopeLand2;
	}

	public void setHopeLand2(Integer hopeLand2) {
		this.hopeLand2 = hopeLand2;
	}

	public Integer getHopeLand3() {
		return hopeLand3;
	}

	public void setHopeLand3(Integer hopeLand3) {
		this.hopeLand3 = hopeLand3;
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

	public String getFinalEducation() {
		return finalEducation;
	}

	public void setFinalEducation(String finalEducation) {
		this.finalEducation = finalEducation;
	}

	public int getWorkYears() {
		return workYears;
	}

	public void setWorkYears(int workYears) {
		this.workYears = workYears;
	}

	public int getHopeSalaryFrom() {
		return hopeSalaryFrom;
	}

	public void setHopeSalaryFrom(int hopeSalaryFrom) {
		this.hopeSalaryFrom = hopeSalaryFrom;
	}

	public int getHopeSalaryTo() {
		return hopeSalaryTo;
	}

	public void setHopeSalaryTo(int hopeSalaryTo) {
		this.hopeSalaryTo = hopeSalaryTo;
	}

	public String getWorkSituation() {
		return workSituation;
	}

	public void setWorkSituation(String workSituation) {
		this.workSituation = workSituation;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
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

	public String getPrefeNm() {
		return prefeNm;
	}

	public void setPrefeNm(String prefeNm) {
		this.prefeNm = prefeNm;
	}

}
