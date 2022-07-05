package Ansin.web.bean;


public class B0301Bean {
	
		//ユーザーコード
		private String userCd;
		//応募者ID
		private String applicantId;
		//応募者名前
		private String name;
		//業種名
		private String industryNm;
		//職種名
		private String jobtypeNm;
		//性別
		private String sex;	
		//生年月日
		private String birthday;
		//希望給与下限
		private String hopeSalaryFrom;	
		//希望給与上限
		private String hopeSalaryTo;
		//最寄駅
		private String station;	
		//最終学歴
		private String finalEducation;
		//卒業学校
		private String graduationSchool;
		//更新日時
		private String updateTime;
		//経験年数
		private String workYears;
		//住所１
		private String address1;
		//写真
		private String photo;
		private byte[] photoPic;
		
		public String getUserCd() {
			return userCd;
		}
		public void setUserCd(String userCd) {
			this.userCd = userCd;
		}
		public String getApplicantId() {
			return applicantId;
		}
		public void setApplicantId(String applicantId) {
			this.applicantId = applicantId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
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
		public String getBirthday() {
			return birthday;
		}
		public void setBirthday(String birthday) {
			this.birthday = birthday;
		}
		public String getHopeSalaryFrom() {
			return hopeSalaryFrom;
		}
		public void setHopeSalaryFrom(String hopeSalaryFrom) {
			this.hopeSalaryFrom = hopeSalaryFrom;
		}
		public String getHopeSalaryTo() {
			return hopeSalaryTo;
		}
		public void setHopeSalaryTo(String hopeSalaryTo) {
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
		public String getUpdateTime() {
			return updateTime;
		}
		public void setUpdateTime(String updateTime) {
			this.updateTime = updateTime;
		}
		public String getWorkYears() {
			return workYears;
		}
		public void setWorkYears(String workYears) {
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
		@Override
		public String toString() {
			return "B0301Bean [userCd=" + userCd + ", applicantId=" + applicantId + ", name=" + name + ", industryNm="
					+ industryNm + ", jobtypeNm=" + jobtypeNm + ", sex=" + sex + ", birthday=" + birthday
					+ ", hopeSalaryFrom=" + hopeSalaryFrom + ", hopeSalaryTo=" + hopeSalaryTo + ", station=" + station
					+ ", finalEducation=" + finalEducation + ", graduationSchool=" + graduationSchool + ", updateTime="
					+ updateTime + ", workYears=" + workYears + ", address1=" + address1 + ", getUserCd()="
					+ getUserCd() + ", getApplicantId()=" + getApplicantId() + ", getName()=" + getName()
					+ ", getIndustryNm()=" + getIndustryNm() + ", getJobtypeNm()=" + getJobtypeNm() + ", getSex()="
					+ getSex() + ", getBirthday()=" + getBirthday() + ", getHopeSalaryFrom()=" + getHopeSalaryFrom()
					+ ", getHopeSalaryTo()=" + getHopeSalaryTo() + ", getStation()=" + getStation()
					+ ", getFinalEducation()=" + getFinalEducation() + ", getGraduationSchool()="
					+ getGraduationSchool() + ", getUpdateTime()=" + getUpdateTime() + ", getWorkYears()="
					+ getWorkYears() + ", getAddress1()=" + getAddress1() + ", getClass()=" + getClass()
					+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
		}
		public byte[] getPhotoPic() {
			return photoPic;
		}
		public void setPhotoPic(byte[] photoPic) {
			this.photoPic = photoPic;
		}
		
}
