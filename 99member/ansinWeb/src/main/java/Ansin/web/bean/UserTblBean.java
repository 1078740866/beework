package Ansin.web.bean;

public class UserTblBean {
	private static final long serialVersionUID = 1L;

	// ユーザーコード
	private String userCd;
	// パスワード
	private String pwd;
	// 会社ID
	private String companyId;
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
	private String photoAddress;
	// ユーザー状態
	private String userStatus;
	// 削除フラグ
	private String delFlg;
	// 作成日時
	private String createTime;
	// 作成者
	private String createBy;
	// 更新日時
	private String updateTime;
	// 更新者
	private String updateBy;
	
	
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
	public String getDelFlg() {
		return delFlg;
	}
	public void setDelFlg(String delFlg) {
		this.delFlg = delFlg;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return "UserTblBean [userCd=" + userCd + ", pwd=" + pwd + ", companyId=" + companyId + ", authority="
				+ authority + ", firstNameKana=" + firstNameKana + ", firstName=" + firstName + ", lastNameKana="
				+ lastNameKana + ", lastName=" + lastName + ", sex=" + sex + ", countryZip=" + countryZip + ", userTel="
				+ userTel + ", userMail=" + userMail + ", photoAddress=" + photoAddress + ", userStatus=" + userStatus
				+ ", delFlg=" + delFlg + ", createTime=" + createTime + ", createBy=" + createBy + ", updateTime="
				+ updateTime + ", updateBy=" + updateBy + ", getUserCd()=" + getUserCd() + ", getPwd()=" + getPwd()
				+ ", getCompanyId()=" + getCompanyId() + ", getAuthority()=" + getAuthority() + ", getFirstNameKana()="
				+ getFirstNameKana() + ", getFirstName()=" + getFirstName() + ", getLastNameKana()=" + getLastNameKana()
				+ ", getLastName()=" + getLastName() + ", getSex()=" + getSex() + ", getCountryZip()=" + getCountryZip()
				+ ", getUserTel()=" + getUserTel() + ", getUserMail()=" + getUserMail() + ", getPhotoAddress()="
				+ getPhotoAddress() + ", getUserStatus()=" + getUserStatus() + ", getDelFlg()=" + getDelFlg()
				+ ", getCreateTime()=" + getCreateTime() + ", getCreateBy()=" + getCreateBy() + ", getUpdateTime()="
				+ getUpdateTime() + ", getUpdateBy()=" + getUpdateBy() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	

}
