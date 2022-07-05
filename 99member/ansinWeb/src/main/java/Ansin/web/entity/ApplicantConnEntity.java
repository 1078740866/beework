package Ansin.web.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

public class ApplicantConnEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	// 応募者ID
	private Integer applicantId;
	// ユーザーコード
	private Integer userCd;
	// 生年月日
	private Date birthday;
	// 郵便番号
	private String applicantPostal;
	// 国ID
	private Integer countryId;
	// 都道府県名
	private String prefeNm;
	// 住所1
	private String address1;
	// 住所2
	private String address2;
	// 最寄駅
	private String station;
	// 希望地1
	private Integer hopeLand1;
	// 希望地2
	private Integer hopeLand2;
	// 希望地3
	private Integer hopeLand3;
	// 写真
	private String photo;
	// 仕事状況
	private String workSituation;
	// 卒業学校
	private String graduationSchool;
	// 専攻
	private String graduationMajor;
	// 仕事経験年数
	private Integer workYears;
	// 業種ID1
	private Integer industryId1;
	// 職種ID1_1
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
	// 最終学歴
	private String finalEducation;
	// 希望給与下限
	private Integer hopeSalaryFrom;
	// 希望給与上限
	private Integer hopeSalaryTo;
	// アピール
	private String introduce;
	// 志望理由
	private String reason;
	// 特技
	private String specialty;
	// 趣味
	private String interest;
	// ハニーコイン残高
	private Integer remainder;
	// ハニーポイント
	private Integer point;
	// レベルID
	private Integer levelId;
	// 備考
	private String remarks;
	// 削除フラグ
	private String delFlg;
	// 作成日時
	private Date createTime;
	// 作成者
	private String createBy;
	// 更新日時
	private Date updateTime;
	// 更新者
	private String updateBy;
	// 国名
	private String countryNm;
	// 業種名1
	private String industryNm1;
	// 業種名2
	private String industryNm2;
	// 業種名3
	private String industryNm3;
	// 職種名1_1
	private String jobtypeNm1_1;
	// 職種名1_2
	private String jobtypeNm1_2;
	// 職種名1_3
	private String jobtypeNm1_3;
	// 職種名2_1
	private String jobtypeNm2_1;
	// 職種名2_2
	private String jobtypeNm2_2;
	// 職種名2_3
	private String jobtypeNm2_3;
	// 職種名3_1
	private String jobtypeNm3_1;
	// 職種名3_2
	private String jobtypeNm3_2;
	// 職種名3_3
	private String jobtypeNm3_3;
	// 希望地名1
	private String hopeLandNm1;
	// 希望地名2
	private String hopeLandNm2;
	// 希望地名3
	private String hopeLandNm3;

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

	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public String getPrefeNm() {
		return prefeNm;
	}

	public void setPrefeNm(String prefeNm) {
		this.prefeNm = prefeNm;
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

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getWorkSituation() {
		return workSituation;
	}

	public void setWorkSituation(String workSituation) {
		this.workSituation = workSituation;
	}

	public String getgraduationSchool() {
		return graduationSchool;
	}

	public void setgraduationSchool(String graduationSchool) {
		this.graduationSchool = graduationSchool;
	}

	public String getGraduationMajor() {
		return graduationMajor;
	}

	public void setGraduationMajor(String graduationMajor) {
		this.graduationMajor = graduationMajor;
	}

	public Integer getWorkYears() {
		return workYears;
	}

	public void setWorkYears(Integer workYears) {
		this.workYears = workYears;
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

	public String getFinalEducation() {
		return finalEducation;
	}

	public void setFinalEducation(String finalEducation) {
		this.finalEducation = finalEducation;
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

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public Integer getRemainder() {
		return remainder;
	}

	public void setRemainder(Integer remainder) {
		this.remainder = remainder;
	}

	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	public Integer getLevelId() {
		return levelId;
	}

	public void setLevelId(Integer levelId) {
		this.levelId = levelId;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getDelFlg() {
		return delFlg;
	}

	public void setDelFlg(String delFlg) {
		this.delFlg = delFlg;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public String getCountryNm() {
		return countryNm;
	}

	public void setCountryNm(String countryNm) {
		this.countryNm = countryNm;
	}

	public String getIndustryNm1() {
		return industryNm1;
	}

	public void setIndustryNm1(String industryNm1) {
		this.industryNm1 = industryNm1;
	}

	public String getIndustryNm2() {
		return industryNm2;
	}

	public void setIndustryNm2(String industryNm2) {
		this.industryNm2 = industryNm2;
	}

	public String getIndustryNm3() {
		return industryNm3;
	}

	public void setIndustryNm3(String industryNm3) {
		this.industryNm3 = industryNm3;
	}

	public String getJobtypeNm1_1() {
		return jobtypeNm1_1;
	}

	public void setJobtypeNm1_1(String jobtypeNm1_1) {
		this.jobtypeNm1_1 = jobtypeNm1_1;
	}

	public String getJobtypeNm1_2() {
		return jobtypeNm1_2;
	}

	public void setJobtypeNm1_2(String jobtypeNm1_2) {
		this.jobtypeNm1_2 = jobtypeNm1_2;
	}

	public String getJobtypeNm1_3() {
		return jobtypeNm1_3;
	}

	public void setJobtypeNm1_3(String jobtypeNm1_3) {
		this.jobtypeNm1_3 = jobtypeNm1_3;
	}

	public String getJobtypeNm2_1() {
		return jobtypeNm2_1;
	}

	public void setJobtypeNm2_1(String jobtypeNm2_1) {
		this.jobtypeNm2_1 = jobtypeNm2_1;
	}

	public String getJobtypeNm2_2() {
		return jobtypeNm2_2;
	}

	public void setJobtypeNm2_2(String jobtypeNm2_2) {
		this.jobtypeNm2_2 = jobtypeNm2_2;
	}

	public String getJobtypeNm2_3() {
		return jobtypeNm2_3;
	}

	public void setJobtypeNm2_3(String jobtypeNm2_3) {
		this.jobtypeNm2_3 = jobtypeNm2_3;
	}

	public String getJobtypeNm3_1() {
		return jobtypeNm3_1;
	}

	public void setJobtypeNm3_1(String jobtypeNm3_1) {
		this.jobtypeNm3_1 = jobtypeNm3_1;
	}

	public String getJobtypeNm3_2() {
		return jobtypeNm3_2;
	}

	public void setJobtypeNm3_2(String jobtypeNm3_2) {
		this.jobtypeNm3_2 = jobtypeNm3_2;
	}

	public String getJobtypeNm3_3() {
		return jobtypeNm3_3;
	}

	public void setJobtypeNm3_3(String jobtypeNm3_3) {
		this.jobtypeNm3_3 = jobtypeNm3_3;
	}

	public String getHopeLandNm1() {
		return hopeLandNm1;
	}

	public void setHopeLandNm1(String hopeLandNm1) {
		this.hopeLandNm1 = hopeLandNm1;
	}

	public String getHopeLandNm2() {
		return hopeLandNm2;
	}

	public void setHopeLandNm2(String hopeLandNm2) {
		this.hopeLandNm2 = hopeLandNm2;
	}

	public String getHopeLandNm3() {
		return hopeLandNm3;
	}

	public void setHopeLandNm3(String hopeLandNm3) {
		this.hopeLandNm3 = hopeLandNm3;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ApplicantConnEntity [applicantId=" + applicantId + ", userCd=" + userCd + ", birthday=" + birthday
				+ ", applicantPostal=" + applicantPostal + ", countryId=" + countryId + ", prefeNm=" + prefeNm
				+ ", address1=" + address1 + ", address2=" + address2 + ", station=" + station + ", hopeLand1="
				+ hopeLand1 + ", hopeLand2=" + hopeLand2 + ", hopeLand3=" + hopeLand3 + ", photo=" + photo
				+ ", workSituation=" + workSituation + ", graduationSchool=" + graduationSchool + ", graduationMajor="
				+ graduationMajor + ", workYears=" + workYears + ", industryId1=" + industryId1 + ", jobtypeId1_1="
				+ jobtypeId1_1 + ", jobtypeId1_2=" + jobtypeId1_2 + ", jobtypeId1_3=" + jobtypeId1_3 + ", industryId2="
				+ industryId2 + ", jobtypeId2_1=" + jobtypeId2_1 + ", jobtypeId2_2=" + jobtypeId2_2 + ", jobtypeId2_3="
				+ jobtypeId2_3 + ", industryId3=" + industryId3 + ", jobtypeId3_1=" + jobtypeId3_1 + ", jobtypeId3_2="
				+ jobtypeId3_2 + ", jobtypeId3_3=" + jobtypeId3_3 + ", finalEducation=" + finalEducation
				+ ", hopeSalaryFrom=" + hopeSalaryFrom + ", hopeSalaryTo=" + hopeSalaryTo + ", introduce=" + introduce
				+ ", reason=" + reason + ", specialty=" + specialty + ", interest=" + interest + ", remainder="
				+ remainder + ", point=" + point + ", levelId=" + levelId + ", remarks=" + remarks + ", delFlg="
				+ delFlg + ", createTime=" + createTime + ", createBy=" + createBy + ", updateTime=" + updateTime
				+ ", updateBy=" + updateBy + ", countryNm=" + countryNm + ", industryNm1=" + industryNm1
				+ ", industryNm2=" + industryNm2 + ", industryNm3=" + industryNm3 + ", jobtypeNm1_1=" + jobtypeNm1_1
				+ ", jobtypeNm1_2=" + jobtypeNm1_2 + ", jobtypeNm1_3=" + jobtypeNm1_3 + ", jobtypeNm2_1=" + jobtypeNm2_1
				+ ", jobtypeNm2_2=" + jobtypeNm2_2 + ", jobtypeNm2_3=" + jobtypeNm2_3 + ", jobtypeNm3_1=" + jobtypeNm3_1
				+ ", jobtypeNm3_2=" + jobtypeNm3_2 + ", jobtypeNm3_3=" + jobtypeNm3_3 + ", hopeLandNm1=" + hopeLandNm1
				+ ", hopeLandNm2=" + hopeLandNm2 + ", hopeLandNm3=" + hopeLandNm3 + "]";
	}

}
