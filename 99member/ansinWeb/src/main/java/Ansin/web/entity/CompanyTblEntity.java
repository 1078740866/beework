package Ansin.web.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class CompanyTblEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer companyId;
	private String companyNm;
	private String validitySection;
	private String companyTel;
	private String companyMail;
	private String companyScale;
	private String companyPostal;
	private Integer countryId;
	private String prefeNm;
	private String address1;
	private String address2;
	private Integer industryId1;
	private Integer industryId2;
	private Integer industryId3;
	private String industryNm1;
	private String industryNm2;
	private String industryNm3;
	private String businessContent;
	private BigDecimal capital;
	private BigDecimal salesAmount;
	private String homepage;
	private String licenseAddress;
	private String companyLogo;
	private String photoAddress1;
	private String photoAddress2;
	private String photoAddress3;
	private String videoAddress1;
	private String videoAddress2;
	private String videoAddress3;
	private Integer payConsSum;
	private Integer remainder;
	private Integer point;
	private Integer levelId;
	private String delFlg;
	private Timestamp createTime;
	private String createBy;
	private Timestamp updateTime;
	private String updateBy;
	private String levelNm;
	
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	public String getCompanyNm() {
		return companyNm;
	}
	public void setCompanyNm(String companyNm) {
		this.companyNm = companyNm;
	}
	public String getValiditySection() {
		return validitySection;
	}
	public void setValiditySection(String validitySection) {
		this.validitySection = validitySection;
	}
	public String getCompanyTel() {
		return companyTel;
	}
	public void setCompanyTel(String companyTel) {
		this.companyTel = companyTel;
	}
	public String getCompanyMail() {
		return companyMail;
	}
	public void setCompanyMail(String companyMail) {
		this.companyMail = companyMail;
	}
	public String getCompanyScale() {
		return companyScale;
	}
	public void setCompanyScale(String companyScale) {
		this.companyScale = companyScale;
	}
	public String getCompanyPostal() {
		return companyPostal;
	}
	public void setCompanyPostal(String companyPostal) {
		this.companyPostal = companyPostal;
	}
	public Integer getCountryId() {
		return countryId;
	}
	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
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
	public Integer getIndustryId1() {
		return industryId1;
	}
	public void setIndustryId1(Integer industryId1) {
		this.industryId1 = industryId1;
	}
	public Integer getIndustryId2() {
		return industryId2;
	}
	public void setIndustryId2(Integer industryId2) {
		this.industryId2 = industryId2;
	}
	public Integer getIndustryId3() {
		return industryId3;
	}
	public void setIndustryId3(Integer industryId3) {
		this.industryId3 = industryId3;
	}
	public String getBusinessContent() {
		return businessContent;
	}
	public void setBusinessContent(String businessContent) {
		this.businessContent = businessContent;
	}
	public BigDecimal getCapital() {
		return capital;
	}
	public void setCapital(BigDecimal capital) {
		this.capital = capital;
	}
	public BigDecimal getSalesAmount() {
		return salesAmount;
	}
	public void setSalesAmount(BigDecimal salesAmount) {
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
	public Integer getPayConsSum() {
		return payConsSum;
	}
	public void setPayConsSum(Integer payConsSum) {
		this.payConsSum = payConsSum;
	}
	public Integer getRemainder() {
		return remainder;
	}
	public void setRemainder(Integer remainder) {
		this.remainder = remainder;
	}
	public Integer getPoint() {
		return point;
	}
	public void setPoint(Integer point) {
		this.point = point;
	}
	public Integer getLevelId() {
		return levelId;
	}
	public void setLevelId(Integer levelId) {
		this.levelId = levelId;
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
	public String getPrefeNm() {
		return prefeNm;
	}
	public void setPrefeNm(String prefeNm) {
		this.prefeNm = prefeNm;
	}
	
	public String getLevelNm() {
		return levelNm;
	}
	public void setLevelNm(String levelNm) {
		this.levelNm = levelNm;
	}
	
	public String getIndustryNm1() {
		return industryNm1;
	}
	public void setIndustryNm1(String industryNm1) {
		this.industryNm1 = industryNm1;
	}
	public String getIndustryNm2() {
		return industryNm2;
	}
	public void setIndustryNm2(String industryNm2) {
		this.industryNm2 = industryNm2;
	}
	public String getIndustryNm3() {
		return industryNm3;
	}
	public void setIndustryNm3(String industryNm3) {
		this.industryNm3 = industryNm3;
	}
	@Override
	public String toString() {
		return "CompanyTblEntity [companyId=" + companyId + ", companyNm=" + companyNm + ", validitySection="
				+ validitySection + ", companyTel=" + companyTel + ", companyMail=" + companyMail + ", companyScale="
				+ companyScale + ", companyPostal=" + companyPostal + ", countryId=" + countryId + ", prefeNm="
				+ prefeNm + ", address1=" + address1 + ", address2=" + address2 + ", industryId1=" + industryId1
				+ ", industryId2=" + industryId2 + ", industryId3=" + industryId3 + ", industryNm1=" + industryNm1
				+ ", industryNm2=" + industryNm2 + ", industryNm3=" + industryNm3 + ", businessContent="
				+ businessContent + ", capital=" + capital + ", salesAmount=" + salesAmount + ", homepage=" + homepage
				+ ", licenseAddress=" + licenseAddress + ", companyLogo=" + companyLogo + ", photoAddress1="
				+ photoAddress1 + ", photoAddress2=" + photoAddress2 + ", photoAddress3=" + photoAddress3
				+ ", videoAddress1=" + videoAddress1 + ", videoAddress2=" + videoAddress2 + ", videoAddress3="
				+ videoAddress3 + ", payConsSum=" + payConsSum + ", remainder=" + remainder + ", point=" + point
				+ ", levelId=" + levelId + ", delFlg=" + delFlg + ", createTime=" + createTime + ", createBy="
				+ createBy + ", updateTime=" + updateTime + ", updateBy=" + updateBy + ", levelNm=" + levelNm + "]";
	}
	

}
