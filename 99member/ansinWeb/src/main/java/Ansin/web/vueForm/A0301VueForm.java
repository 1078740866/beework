package Ansin.web.vueForm;

import java.util.List;

public class A0301VueForm {

	    // ユーザー名
		private String userName;
		// メール
		private String userMail;
		// ユーザー電話番号
		private String userTel;
		// イベントフラグ
		private String eventFlg;
		//ユーザーコードリスト
		private List<Integer> userCdList;
		//ユーザー状態
		private String userStatusCd;
		//削除状態フラグ
		private String delFlg;

		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getUserMail() {
			return userMail;
		}
		public void setUserMail(String userMail) {
			this.userMail = userMail;
		}
		public String getUserTel() {
			return userTel;
		}
		public void setUserTel(String userTel) {
			this.userTel = userTel;
		}
		public List<Integer> getUserCdList() {
			return userCdList;
		}
		public void setUserCd(List<Integer> userCdList) {
			this.userCdList = userCdList;
		}
		public String getUserStatusCd() {
			return userStatusCd;
		}
		public void setUserStatusCd(String userStatusCd) {
			this.userStatusCd = userStatusCd;
		}

		public String getDelFlg() {
			return delFlg;
		}
		public void setDelFlg(String delFlg) {
			this.delFlg = delFlg;
		}

		public String getEventFlg() {
			return eventFlg;
		}
		public void setEventFlg(String eventFlg) {
			this.eventFlg = eventFlg;
		}
		@Override
		public String toString() {
			return "A0301VueForm [name=" + userName + ", userMail=" + userMail + ", userTel=" + userTel + ", userCd="
					+ userCdList + ", userFlg=" + userStatusCd + ", delFlg=" + delFlg + ", getName()=" + getUserName()
					+ ", getUserMail()=" + getUserMail() + ", getUserTel()=" + getUserTel() + ", getUserCd()="
					+ getUserCdList() + ", getUserFlg()=" + getUserStatusCd() + ", getDelFlg()=" + getDelFlg() + ", getClass()="
					+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
		}

}
