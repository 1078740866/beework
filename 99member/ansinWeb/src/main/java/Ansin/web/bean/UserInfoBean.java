package Ansin.web.bean;

import java.util.Arrays;

public class UserInfoBean {
	// ユーザーコード
	private String userCd;
	// パスワード
	private String pwd;
	// 会社ID
	private String companyId;
	//会社名
	private String companyNm;
	// 権限
	private String authority;
	// 氏名(カナ)
	private String firstNameKana;
	// 氏名
	private String firstName;
	// 姓(カナ)
	private String lastNameKana;
	// 姓
	private String lastName;
	// 性別
	private String sex;
	// 電話番号(国番号)
	private String countryZip;
	// ユーザー電話番号
	private String userTel;
	// ユーザーメール
	private String userMail;
	// 写真アドレス
	private String  photoAddress;
	private byte[] photoAddressPic;
	// ユーザー状態
	private String userStatus;
	public String getUserCd() {
		return userCd;
	}
	public void setUserCd(String userCd) {
		this.userCd = userCd;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public String getFirstNameKana() {
		return firstNameKana;
	}
	public void setFirstNameKana(String firstNameKana) {
		this.firstNameKana = firstNameKana;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastNameKana() {
		return lastNameKana;
	}
	public void setLastNameKana(String lastNameKana) {
		this.lastNameKana = lastNameKana;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getCountryZip() {
		return countryZip;
	}
	public void setCountryZip(String countryZip) {
		this.countryZip = countryZip;
	}
	public String getUserTel() {
		return userTel;
	}
	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}
	public String getUserMail() {
		return userMail;
	}
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	public String getPhotoAddress() {
		return photoAddress;
	}
	public void setPhotoAddress(String photoAddress) {
		this.photoAddress = photoAddress;
	}
	public String getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	public byte[] getPhotoAddressPic() {
		return photoAddressPic;
	}
	public void setPhotoAddressPic(byte[] photoAddressPic) {
		this.photoAddressPic = photoAddressPic;
	}
	
	public String getCompanyNm() {
		return companyNm;
	}
	public void setCompanyNm(String companyNm) {
		this.companyNm = companyNm;
	}
	@Override
	public String toString() {
		return "UserInfoBean [userCd=" + userCd + ", pwd=" + pwd + ", companyId=" + companyId + ", authority="
				+ authority + ", firstNameKana=" + firstNameKana + ", firstName=" + firstName + ", lastNameKana="
				+ lastNameKana + ", lastName=" + lastName + ", sex=" + sex + ", countryZip=" + countryZip + ", userTel="
				+ userTel + ", userMail=" + userMail + ", photoAddress=" + photoAddress + ", photoAddressPic="
				+ Arrays.toString(photoAddressPic) + ", userStatus=" + userStatus + "]";
	}
	
	
	
}
