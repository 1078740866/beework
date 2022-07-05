package Ansin.web.entity;

public class A0802ListEntity {
	
	//ユーザーコード
	private Integer userCd;
	//姓
	private String firstName;
	//名
	private String lastName;
	//権限
	private String authority;
	//会社名
	private String companyNm;
	//ユーザーメール
	private String userMail;
	//ユーザー電話
	private String userTel;
	public Integer getUserCd() {
		return userCd;
	}
	public void setUserCd(Integer userCd) {
		this.userCd = userCd;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public String getCompanyNm() {
		return companyNm;
	}
	public void setCompanyNm(String companyNm) {
		this.companyNm = companyNm;
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
	@Override
	public String toString() {
		return "A0802ListEntity [userCd=" + userCd + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", authority=" + authority + ", companyNm=" + companyNm + ", userMail=" + userMail + ", userTel="
				+ userTel + ", getUserCd()=" + getUserCd() + ", getFirstName()=" + getFirstName() + ", getLastName()="
				+ getLastName() + ", getAuthority()=" + getAuthority() + ", getCompanyNm()=" + getCompanyNm()
				+ ", getUserMail()=" + getUserMail() + ", getUserTel()=" + getUserTel() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}
