package Ansin.web.bean;

public class A0802Bean {
	//ユーザーコード
	private String userCd;
	//ユーザーメール
	private String mail;
	//会社名
	private String companyNm;
	//権限
	private String authority;
	//ユーザー電話
	private String tel;
	//名前
	private String userNm;
	public String getUserCd() {
		return userCd;
	}
	public void setUserCd(String userCd) {
		this.userCd = userCd;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getCompanyNm() {
		return companyNm;
	}
	public void setCompanyNm(String companyNm) {
		this.companyNm = companyNm;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getUserNm() {
		return userNm;
	}
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}
	@Override
	public String toString() {
		return "A0802Bean [userCd=" + userCd + ", mail=" + mail + ", companyNm=" + companyNm + ", authority="
				+ authority + ", tel=" + tel + ", userNm=" + userNm + ", getUserCd()=" + getUserCd() + ", getMail()="
				+ getMail() + ", getCompanyNm()=" + getCompanyNm() + ", getAuthority()=" + getAuthority()
				+ ", getTel()=" + getTel() + ", getUserNm()=" + getUserNm() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
}
