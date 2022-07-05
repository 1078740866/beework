package Ansin.web.vueForm;

import java.util.Arrays;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class CompanyInfo {

	private String companyId;
	private String userCd;
	/**
	 *
	 */
	@NotBlank(message="国籍を選択してください。")
	private String countryId;
	@NotBlank(message="会社名を入力してください。")
	private String companyNm;
    @NotBlank(message="メールアドレスを入力して下さい。")
    @Email(message="メールアドレスはメールアドレス形式で入力してください。（例：abc@xxx.xxx）")
    private String companyMail;
    @NotBlank(message="電話番号を入力してください。")
    @Pattern(regexp = "^[0-9]*$", message="電話番号は半角数字で入力してください。")
    private String companyTel;
    @NotBlank(message="規模を選択してください。")
	private String companyScale;
    private String companyScaleNm;
	private String countryNm;
    @NotBlank(message="郵便番号を入力してください。")
    private String companyPostal;
    private String prefeNm;
    private String address1;
    @NotBlank(message="会社所在地2を入力してください。")
    private String address2;
    @NotBlank(message="業種を選択してください。")
    private String industryId1;
    private String industryId2;
    private String industryId3;
    private String industryId1Nm;
    private String industryId2Nm;
    private String industryId3Nm;
    @NotBlank(message="資本金を入力してください。")
    private String capital;
    @NotBlank(message="事業内容を入力してください。")
    private String businessContent;
    private String salesAmount;
    private String homepage;
    @NotBlank(message="藤本画像アドレスを入力してください。")
    private String licenseAddress;
    private byte[] licenseAddressPic;
    private String companyLogo;
    private String photoAddress1;
    private String photoAddress2;
    private String photoAddress3;
    private String videoAddress1;
    private String videoAddress2;
    private String videoAddress3;
    @NotBlank(message="メールを入力してください。")
    @Email(message = "メールアドレスはメールアドレス形式で入力してください。（例：abc@xxx.xxx）")
	private String userMail;
	@NotBlank(message="パスワードを入力してください。")
	@Pattern(regexp = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$", message="パスワードは正しく入力してください。")
	private String password;
	@NotBlank(message="パスワード確認を入力してください。")
	@Pattern(regexp = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$", message="パスワードは正しく入力してください。")
	private String repassword;
	@NotBlank(message="姓（カナ）を入力してください。")
	private String firstNameKana;
	@NotBlank(message="姓を入力してください。")
	private String firstName;
	@NotBlank(message="名（カナ）を入力してください。")
	private String lastNameKana;
	@NotBlank(message="名を入力してください。")
	private String lastName;
	@NotBlank(message="性別を入力してください。")
	private String sex;
	@NotBlank(message="電話番号(国番号)を入力してください。")
	@Pattern(regexp = "^[0-9]*$", message="電話番号(国番号)は半角数字で入力してください。")
	private String countryZip;
	@NotBlank(message="電話番号を入力してください。")
	@Pattern(regexp = "^[0-9]*$", message="電話番号は半角数字で入力してください。")
	private String userTel;
	private String photoAddress;
	private String popFlg;

	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getUserCd() {
		return userCd;
	}
	public void setUserCd(String userCd) {
		this.userCd = userCd;
	}
	public String getCountryId() {
		return countryId;
	}
	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}
	public String getCompanyNm() {
		return companyNm;
	}
	public void setCompanyNm(String companyNm) {
		this.companyNm = companyNm;
	}
	public String getCompanyMail() {
		return companyMail;
	}
	public void setCompanyMail(String companyMail) {
		this.companyMail = companyMail;
	}
	public String getCompanyTel() {
		return companyTel;
	}
	public void setCompanyTel(String companyTel) {
		this.companyTel = companyTel;
	}
	public String getCompanyScale() {
		return companyScale;
	}
	public void setCompanyScale(String companyScale) {
		this.companyScale = companyScale;
	}

	public String getCompanyScaleNm() {
		return companyScaleNm;
	}
	public void setCompanyScaleNm(String companyScaleNm) {
		this.companyScaleNm = companyScaleNm;
	}
	public String getCountryNm() {
		return countryNm;
	}
	public void setCountryNm(String countryNm) {
		this.countryNm = countryNm;
	}
	public String getCompanyPostal() {
		return companyPostal;
	}
	public void setCompanyPostal(String companyPostal) {
		this.companyPostal = companyPostal;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getIndustryId1() {
		return industryId1;
	}
	public void setIndustryId1(String industryId1) {
		this.industryId1 = industryId1;
	}
	public String getIndustryId2() {
		return industryId2;
	}
	public void setIndustryId2(String industryId2) {
		this.industryId2 = industryId2;
	}
	public String getIndustryId3() {
		return industryId3;
	}
	public void setIndustryId3(String industryId3) {
		this.industryId3 = industryId3;
	}
	public String getIndustryId1Nm() {
		return industryId1Nm;
	}
	public void setIndustryId1Nm(String industryId1Nm) {
		this.industryId1Nm = industryId1Nm;
	}
	public String getIndustryId2Nm() {
		return industryId2Nm;
	}
	public void setIndustryId2Nm(String industryId2Nm) {
		this.industryId2Nm = industryId2Nm;
	}
	public String getIndustryId3Nm() {
		return industryId3Nm;
	}
	public void setIndustryId3Nm(String industryId3Nm) {
		this.industryId3Nm = industryId3Nm;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
    
	public byte[] getLicenseAddressPic() {
		return licenseAddressPic;
	}
	public void setLicenseAddressPic(byte[] licenseAddressPic) {
		this.licenseAddressPic = licenseAddressPic;
	}
	public String getBusinessContent() {
		return businessContent;
	}
	public void setBusinessContent(String businessContent) {
		this.businessContent = businessContent;
	}
	public String getSalesAmount() {
		return salesAmount;
	}
	public void setSalesAmount(String salesAmount) {
		this.salesAmount = salesAmount;
	}
	public String getHomepage() {
		return homepage;
	}
	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}
	public String getLicenseAddress() {
		return licenseAddress;
	}
	public void setLicenseAddress(String licenseAddress) {
		this.licenseAddress = licenseAddress;
	}
	public String getCompanyLogo() {
		return companyLogo;
	}
	public void setCompanyLogo(String companyLogo) {
		this.companyLogo = companyLogo;
	}
	public String getPhotoAddress1() {
		return photoAddress1;
	}
	public void setPhotoAddress1(String photoAddress1) {
		this.photoAddress1 = photoAddress1;
	}
	public String getPhotoAddress2() {
		return photoAddress2;
	}
	public void setPhotoAddress2(String photoAddress2) {
		this.photoAddress2 = photoAddress2;
	}
	public String getPhotoAddress3() {
		return photoAddress3;
	}
	public void setPhotoAddress3(String photoAddress3) {
		this.photoAddress3 = photoAddress3;
	}
	public String getVideoAddress1() {
		return videoAddress1;
	}
	public void setVideoAddress1(String videoAddress1) {
		this.videoAddress1 = videoAddress1;
	}
	public String getVideoAddress2() {
		return videoAddress2;
	}
	public void setVideoAddress2(String videoAddress2) {
		this.videoAddress2 = videoAddress2;
	}
	public String getVideoAddress3() {
		return videoAddress3;
	}
	public void setVideoAddress3(String videoAddress3) {
		this.videoAddress3 = videoAddress3;
	}
	public String getUserMail() {
		return userMail;
	}
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
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
	public String getUserTel() {
		return userTel;
	}
	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}
	public String getPhotoAddress() {
		return photoAddress;
	}
	public void setPhotoAddress(String photoAddress) {
		this.photoAddress = photoAddress;
	}

	public String getCountryZip() {
		return countryZip;
	}
	public void setCountryZip(String countryZip) {
		this.countryZip = countryZip;
	}

	public String getPopFlg() {
		return popFlg;
	}
	public void setPopFlg(String popFlg) {
		this.popFlg = popFlg;
	}

	public String getPrefeNm() {
		return prefeNm;
	}
	public void setPrefeNm(String prefeNm) {
		this.prefeNm = prefeNm;
	}
	@Override
	public String toString() {
		return "CompanyInfo [companyId=" + companyId + ", userCd=" + userCd + ", countryId=" + countryId
				+ ", companyNm=" + companyNm + ", companyMail=" + companyMail + ", companyTel=" + companyTel
				+ ", companyScale=" + companyScale + ", companyScaleNm=" + companyScaleNm + ", countryNm=" + countryNm
				+ ", companyPostal=" + companyPostal + ", prefeNm=" + prefeNm + ", address1=" + address1 + ", address2="
				+ address2 + ", industryId1=" + industryId1 + ", industryId2=" + industryId2 + ", industryId3="
				+ industryId3 + ", industryId1Nm=" + industryId1Nm + ", industryId2Nm=" + industryId2Nm
				+ ", industryId3Nm=" + industryId3Nm + ", capital=" + capital + ", businessContent=" + businessContent
				+ ", salesAmount=" + salesAmount + ", homepage=" + homepage + ", licenseAddress=" + licenseAddress
				+ ", licenseAddressPic=" + Arrays.toString(licenseAddressPic) + ", companyLogo=" + companyLogo
				+ ", photoAddress1=" + photoAddress1 + ", photoAddress2=" + photoAddress2 + ", photoAddress3="
				+ photoAddress3 + ", videoAddress1=" + videoAddress1 + ", videoAddress2=" + videoAddress2
				+ ", videoAddress3=" + videoAddress3 + ", userMail=" + userMail + ", password=" + password
				+ ", repassword=" + repassword + ", firstNameKana=" + firstNameKana + ", firstName=" + firstName
				+ ", lastNameKana=" + lastNameKana + ", lastName=" + lastName + ", sex=" + sex + ", countryZip="
				+ countryZip + ", userTel=" + userTel + ", photoAddress=" + photoAddress + ", popFlg=" + popFlg + "]";
	}

}