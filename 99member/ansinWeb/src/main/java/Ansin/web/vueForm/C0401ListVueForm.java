package Ansin.web.vueForm;

import java.util.Date;

public class C0401ListVueForm {
		
		//説明会名
		private String briefingNm;
		//会社名
		private String companyNm;
		//説明会方式
		private String briefingType;
		//日付FROM
		private Date dateFrom;	
		//日付TO
		private Date dateTo;
		//都道府県
		private String	prefeNm;
		//userCd
		private Integer userCd;
		//応募者ID
		private Integer applicantId;
		
		
		public String getBriefingNm() {
			return briefingNm;
		}
		public void setBriefingNm(String briefingNm) {
			this.briefingNm = briefingNm;
		}
		public String getCompanyNm() {
			return companyNm;
		}
		public void setCompanyNm(String companyNm) {
			this.companyNm = companyNm;
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
		public String getPrefeNm() {
			return prefeNm;
		}
		public void setPrefeNm(String prefeNm) {
			this.prefeNm = prefeNm;
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
