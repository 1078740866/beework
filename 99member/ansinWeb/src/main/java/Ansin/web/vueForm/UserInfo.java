package Ansin.web.vueForm;

import javax.validation.constraints.NotBlank;

public class UserInfo {

	@NotBlank(message="メールを入力してください")
	private String userCd;
	@NotBlank(message="パスワードを入力してください")
	private String pwd;
	@NotBlank(message="会社所在地を入力してください")
	private String firstNameKana;
	@NotBlank(message="業種を入力してください")
	private String firstName;
	@NotBlank(message="会社所在地を入力してください")
	private String lastNameKana;
	@NotBlank(message="業種を入力してください")
	private String lastName;
	@NotBlank(message="会社所在地を入力してください")
	private String sex;
	@NotBlank(message="業種を入力してください")
	private String countryZip;
	@NotBlank(message="電話番号を入力してください")
	private String userTel;
	@NotBlank(message="規模を入力してください")
	private String photoAddress;
	
	/**
	 * @return the userCd
	 */
	public String getUserCd() {
		return userCd;
	}
	
	/**
	 * @param userCd the userCd to set
	 */
	public void setUserCd(String userCd) {
		this.userCd = userCd;
	}
	
	/**
	 * @return the pwd
	 */
	public String getPwd() {
		return pwd;
	}
	
	/**
	 * @param pwd the pwd to set
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	/**
	 * @return the firstNameKana
	 */
	public String getFirstNameKana() {
		return firstNameKana;
	}
	
	/**
	 * @param firstNameKana the firstNameKana to set
	 */
	public void setFirstNameKana(String firstNameKana) {
		this.firstNameKana = firstNameKana;
	}
	
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * @return the lastNameKana
	 */
	public String getLastNameKana() {
		return lastNameKana;
	}
	
	/**
	 * @param lastNameKana the lastNameKana to set
	 */
	public void setLastNameKana(String lastNameKana) {
		this.lastNameKana = lastNameKana;
	}
	
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}
	
	/**
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	/**
	 * @return the countryZip
	 */
	public String getCountryZip() {
		return countryZip;
	}
	
	/**
	 * @param countryZip the countryZip to set
	 */
	public void setCountryZip(String countryZip) {
		this.countryZip = countryZip;
	}
	
	/**
	 * @return the userTel
	 */
	public String getUserTel() {
		return userTel;
	}
	
	/**
	 * @param userTel the userTel to set
	 */
	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}
	
	/**
	 * @return the photoAddress
	 */
	public String getPhotoAddress() {
		return photoAddress;
	}
	
	/**
	 * @param photoAddress the photoAddress to set
	 */
	public void setPhotoAddress(String photoAddress) {
		this.photoAddress = photoAddress;
	}
	
}
