package Ansin.web.vueForm;

import java.util.List;

public class B0101VueForm {
		//sessionから会社ID
		private Integer companyId;
		//sessionから会社usercd
		private Integer userCd;
		//職位名
		private String positionNm;
		//トップ状態
		private String topStatus;
		//募集状態
		private String onlineStatus;
		//確認状態
		private String checkStatus;
		//職位ID
		private List<Integer> positionIds;
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
		public List<Integer> getPositionIds() {
			return positionIds;
		}
		public void setPositionIds(List<Integer> positionIds) {
			this.positionIds = positionIds;
		}
		public String getTopStatus() {
			return topStatus;
		}
		public void setTopStatus(String topStatus) {
			this.topStatus = topStatus;
		}
		
	
}
