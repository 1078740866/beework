package Ansin.web.bean;

public class ApplicationTblBean {
		//会社ID
		private String companyId;
		//職位ID
		private String positionId;
		//応募者ID
		private String applicantId;
		//会社応募状態
		private String appComStatus;
		//応募者応募状態
		private String appAppStatus;
		public String getCompanyId() {
			return companyId;
		}
		public void setCompanyId(String companyId) {
			this.companyId = companyId;
		}
		public String getPositionId() {
			return positionId;
		}
		public void setPositionId(String positionId) {
			this.positionId = positionId;
		}
		public String getApplicantId() {
			return applicantId;
		}
		public void setApplicantId(String applicantId) {
			this.applicantId = applicantId;
		}
		public String getAppComStatus() {
			return appComStatus;
		}
		public void setAppComStatus(String appComStatus) {
			this.appComStatus = appComStatus;
		}
		public String getAppAppStatus() {
			return appAppStatus;
		}
		public void setAppAppStatus(String appAppStatus) {
			this.appAppStatus = appAppStatus;
		}

}
