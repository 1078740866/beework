package Ansin.web.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * ユーザーテーブル
 *
 * @author 楊
 *
 */
public class UserTblEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	// ユーザーコード
	private Integer userCd;
	// パスワード
	private String pwd;
	// 会社ID
	private Integer companyId;
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
	private Integer countryZip;
	// ユーザー電話番号
	private String userTel;
	// ユーザーメール
	private String userMail;
	// 写真アドレス
	private String  photoAddress;
	// ユーザー状態
	private String userStatus;
	// 削除フラグ
	private String delFlg;
	// 作成日時
	private Timestamp createTime;
	// 作成者
	private String createBy;
	// 更新日時
	private Timestamp updateTime;
	// 更新者
	private String updateBy;
	//会社名
	private String companyNm;

	public UserTblEntity() {
		super();
	}

	public Integer getUserCd() {
		return userCd;
	}

	public void setUserCd(Integer userCd) {
		this.userCd = userCd;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
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

	public Integer getCountryZip() {
		return countryZip;
	}

	public void setCountryZip(Integer countryZip) {
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

	public String  getPhotoAddress() {
		return photoAddress;
	}

	public void setPhotoAddress(String  photoAddress) {
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

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
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
	

	public String getCompanyNm() {
		return companyNm;
	}

	public void setCompanyNm(String companyNm) {
		this.companyNm = companyNm;
	}

	@Override
	public String toString() {
		return "UserTblEntity [userCd=" + userCd + ", pwd=" + pwd + ", companyId=" + companyId + ", authority="
				+ authority + ", firstNameKana=" + firstNameKana + ", firstName=" + firstName + ", lastNameKana="
				+ lastNameKana + ", lastName=" + lastName + ", sex=" + sex + ", countryZip=" + countryZip + ", userTel="
				+ userTel + ", userMail=" + userMail + ", photoAddress=" + photoAddress + ", userStatus=" + userStatus
				+ ", delFlg=" + delFlg + ", createTime=" + createTime + ", createBy=" + createBy + ", updateTime="
				+ updateTime + ", updateBy=" + updateBy + "]";
	}



}