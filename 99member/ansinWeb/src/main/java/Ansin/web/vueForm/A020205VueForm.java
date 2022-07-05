package Ansin.web.vueForm;

import java.util.List;

public class A020205VueForm {
	
		//応募者ID
		private Integer applicantId;
		//sessionから会社ID
		private Integer companyId;
		//sessionから会社usercd
		private Integer userCd;
		//職位名
		private String positionNm;
		//募集状態
		private String onlineStatus;
		//確認状態
		private String checkStatus;
		//職位ID
		private List<Integer> positionId;
		
		
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
		public String getPositionNm() {
			return positionNm;
		}
		public void setPositionNm(String positionNm) {
			this.positionNm = positionNm;
		}
		public List<Integer> getPositionId() {
			return positionId;
		}
		public void setPositionId(List<Integer> positionId) {
			this.positionId = positionId;
		}
		public String getOnlineStatus() {
			return onlineStatus;
		}
		public void setOnlineStatus(String onlineStatus) {
			this.onlineStatus = onlineStatus;
		}
		public String getCheckStatus() {
			return checkStatus;
		}
		public void setCheckStatus(String checkStatus) {
			this.checkStatus = checkStatus;
		}
		@Override
		public String toString() {
			return "A020205VueForm [applicantId=" + applicantId + ", companyId=" + companyId + ", userCd=" + userCd
					+ ", positionNm=" + positionNm + ", onlineStatus=" + onlineStatus + ", checkStatus=" + checkStatus
					+ ", positionId=" + positionId + ", getApplicantId()=" + getApplicantId() + ", getCompanyId()="
					+ getCompanyId() + ", getUserCd()=" + getUserCd() + ", getPositionNm()=" + getPositionNm()
					+ ", getPositionId()=" + getPositionId() + ", getOnlineStatus()=" + getOnlineStatus()
					+ ", getCheckStatus()=" + getCheckStatus() + ", getClass()=" + getClass() + ", hashCode()="
					+ hashCode() + ", toString()=" + super.toString() + "]";
		}
		
}
