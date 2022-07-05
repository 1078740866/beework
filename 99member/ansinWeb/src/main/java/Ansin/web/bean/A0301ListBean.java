package Ansin.web.bean;

public class A0301ListBean {

	// ユーザーコード
	private Integer userCd;
	// 会社ID
	private Integer companyId;
	// 名前
	private String userName;
	// 性別
	private String sex;
	// 状態コード
	private String userStatusCd;
	// 状態
	private String userStatus;
	// 電話番号
	private String userTel;
	// 写真アドレス
	private String photoAddress;
	// メール
	private String userMail;
	// 最後ログイン日時
	private String updateTime;

	public Integer getUserCd() {
		return userCd;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public String getUserName() {
		return userName;
	}

	public String getSex() {
		return sex;
	}

	public String getUserStatusCd() {
		return userStatusCd;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public String getUserTel() {
		return userTel;
	}

	public String getPhotoAddress() {
		return photoAddress;
	}

	public String getUserMail() {
		return userMail;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUserCd(Integer userCd) {
		this.userCd = userCd;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setUserStatusCd(String userStatusCd) {
		this.userStatusCd = userStatusCd;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	public void setPhotoAddress(String photoAddress) {
		this.photoAddress = photoAddress;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

}
