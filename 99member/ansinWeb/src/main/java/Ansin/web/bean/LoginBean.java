package Ansin.web.bean;

import Ansin.web.security.JwtAuthenticatioToken;

public class LoginBean {

	//ユーザーCD
	private Integer userCd;

	//ユーザー名前
	private String userName;
	
	//権限
	private String authority;

	//token
	private JwtAuthenticatioToken token;


	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public Integer getUserCd() {
		return userCd;
	}

	public void setUserCd(Integer integer) {
		this.userCd = integer;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public JwtAuthenticatioToken getToken() {
		return token;
	}

	public void setToken(JwtAuthenticatioToken token) {
		this.token = token;
	}
}
