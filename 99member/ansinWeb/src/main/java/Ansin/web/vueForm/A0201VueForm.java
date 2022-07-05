package Ansin.web.vueForm;

import java.util.Date;
import java.util.List;

public class A0201VueForm {
		
		// 曖昧検索枠
		private String ambiguousBox;
		// 業種ID
		private Integer industryId;
		// 職種ID
		private Integer jobtypeId;
		// 学歴
		private String degree;
		// 年齢FROM
		private Integer ageFrom;
		// 年齢TO
		private Integer ageTo;
		// 生年月日FROM
		private Date birthdayFrom;
		// 生年月日TO
		private Date birthdayTo;
		// 給料FROM
		private Integer hopeSalaryFrom;
		// 給料TO
		private Integer hopeSalaryTo;
		// 希望地
		private Integer hopeLand;
		// 経験年数
		private Integer workYears;
		// 都道府県名
		private String prefeNm;
		// 言語能力
		private Integer languageId;
		//レベル区分
		private String levelSection;
		// 性別
		private String sex;
		//応募者IDリスト
		private List<Integer> applicantIds;
		
		public String getAmbiguousBox() {
			return ambiguousBox;
		}
		public void setAmbiguousBox(String ambiguousBox) {
			this.ambiguousBox = ambiguousBox;
		}
		public Integer getIndustryId() {
			return industryId;
		}
		public void setIndustryId(Integer industryId) {
			this.industryId = industryId;
		}
		public Integer getJobtypeId() {
			return jobtypeId;
		}
		public void setJobtypeId(Integer jobtypeId) {
			this.jobtypeId = jobtypeId;
		}
		public String getDegree() {
			return degree;
		}
		public void setDegree(String degree) {
			this.degree = degree;
		}
		public Integer getAgeFrom() {
			return ageFrom;
		}
		public void setAgeFrom(Integer ageFrom) {
			this.ageFrom = ageFrom;
		}
		public Integer getAgeTo() {
			return ageTo;
		}
		public void setAgeTo(Integer ageTo) {
			this.ageTo = ageTo;
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
		public Integer getHopeLand() {
			return hopeLand;
		}
		public void setHopeLand(Integer hopeLand) {
			this.hopeLand = hopeLand;
		}
		public Integer getWorkYears() {
			return workYears;
		}
		public void setWorkYears(Integer workYears) {
			this.workYears = workYears;
		}
		public String getPrefeNm() {
			return prefeNm;
		}
		public void setPrefeNm(String prefeNm) {
			this.prefeNm = prefeNm;
		}
		public String getLevelSection() {
			return levelSection;
		}
		public void setLevelSection(String levelSection) {
			this.levelSection = levelSection;
		}
		public String getSex() {
			return sex;
		}
		public void setSex(String sex) {
			this.sex = sex;
		}
		public Integer getLanguageId() {
			return languageId;
		}
		public void setLanguageId(Integer languageId) {
			this.languageId = languageId;
		}
		public Date getBirthdayFrom() {
			return birthdayFrom;
		}
		public void setBirthdayFrom(Date birthdayFrom) {
			this.birthdayFrom = birthdayFrom;
		}
		public Date getBirthdayTo() {
			return birthdayTo;
		}
		public void setBirthdayTo(Date birthdayTo) {
			this.birthdayTo = birthdayTo;
		}
		public List<Integer> getApplicantIds() {
			return applicantIds;
		}
		public void setApplicantIds(List<Integer> applicantIds) {
			this.applicantIds = applicantIds;
		}
		@Override
		public String toString() {
			return "A0201VueForm [ambiguousBox=" + ambiguousBox + ", industryId=" + industryId + ", jobtypeId="
					+ jobtypeId + ", degree=" + degree + ", ageFrom=" + ageFrom + ", ageTo=" + ageTo + ", birthdayFrom="
					+ birthdayFrom + ", birthdayTo=" + birthdayTo + ", hopeSalaryFrom=" + hopeSalaryFrom
					+ ", hopeSalaryTo=" + hopeSalaryTo + ", hopeLand=" + hopeLand + ", workYears=" + workYears
					+ ", prefeNm=" + prefeNm + ", languageId=" + languageId + ", levelSection=" + levelSection
					+ ", sex=" + sex + ", applicantIds=" + applicantIds + ", getAmbiguousBox()=" + getAmbiguousBox()
					+ ", getIndustryId()=" + getIndustryId() + ", getJobtypeId()=" + getJobtypeId() + ", getDegree()="
					+ getDegree() + ", getAgeFrom()=" + getAgeFrom() + ", getAgeTo()=" + getAgeTo()
					+ ", getHopeSalaryFrom()=" + getHopeSalaryFrom() + ", getHopeSalaryTo()=" + getHopeSalaryTo()
					+ ", getHopeLand()=" + getHopeLand() + ", getWorkYears()=" + getWorkYears() + ", getPrefeNm()="
					+ getPrefeNm() + ", getLevelSection()=" + getLevelSection() + ", getSex()=" + getSex()
					+ ", getLanguageId()=" + getLanguageId() + ", getBirthdayFrom()=" + getBirthdayFrom()
					+ ", getBirthdayTo()=" + getBirthdayTo() + ", getApplicantIds()=" + getApplicantIds()
					+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
					+ "]";
		}
		
		
}
