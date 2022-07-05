package Ansin.web.vueForm;

import java.util.List;

/**
 * @author 楊卿赫
 *
 */
public class A070101VueForm {
		//ユーザーコード
		private Integer userCd;
		//権限
		private String authority;
		//ユーザーメール
		private String userMail;
		//姓名
		private String userName;
		//ユーザーリスト
		private List<Integer> userCds;
		//状態FLG（0：承認、１：拒否）
		private String statusFlg;
		public Integer getUserCd() {
			return userCd;
		}
		public void setUserCd(Integer userCd) {
			this.userCd = userCd;
		}
		public String getUserMail() {
			return userMail;
		}
		public void setUserMail(String userMail) {
			this.userMail = userMail;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getAuthority() {
			return authority;
		}
		public void setAuthority(String authority) {
			this.authority = authority;
		}
		public List<Integer> getUserCds() {
			return userCds;
		}
		public void setUserCds(List<Integer> userCds) {
			this.userCds = userCds;
		}
		public String getStatusFlg() {
			return statusFlg;
		}
		public void setStatusFlg(String statusFlg) {
			this.statusFlg = statusFlg;
		}
		@Override
		public String toString() {
			return "A070101VueForm [userCd=" + userCd + ", authority=" + authority + ", userMail=" + userMail
					+ ", userName=" + userName + ", userCds=" + userCds + ", statusFlg=" + statusFlg + "]";
		}
		

}
