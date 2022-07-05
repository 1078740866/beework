package Ansin.web.vueForm;

import java.util.Date;

public class C010102VueForm {

	// sessionから会社ID
	private Integer companyId;
	// sessionから会社usercd
	private Integer userCd;
	// 応募者資格ID
	private Integer appQuaId;
	// 応募者ID
	private Integer applicantId;
	// 資格
	private String quaNm;
	// 資格番号
	private String quaNum;
	// 資格画像アドレス
	private String quaAddress;
	private byte[] quaAddressFile;
	// 取得日
	private Date acquisitionDate;
	// その他名前
	private String otherNm;
	// 備考
	private String remarks;

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public Integer getUserCd() {
		return userCd;
	}

	public void setUserCd(Integer userCd) {
		this.userCd = userCd;
	}

	public Integer getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(Integer applicantId) {
		this.applicantId = applicantId;
	}

	public String getQuaNum() {
		return quaNum;
	}

	public void setQuaNum(String quaNum) {
		this.quaNum = quaNum;
	}

	public String getQuaAddress() {
		return quaAddress;
	}

	public void setQuaAddress(String quaAddress) {
		this.quaAddress = quaAddress;
	}

	public Date getAcquisitionDate() {
		return acquisitionDate;
	}

	public void setAcquisitionDate(Date acquisitionDate) {
		this.acquisitionDate = acquisitionDate;
	}

	public String getOtherNm() {
		return otherNm;
	}

	public void setOtherNm(String otherNm) {
		this.otherNm = otherNm;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Integer getAppQuaId() {
		return appQuaId;
	}

	public void setAppQuaId(Integer appQuaId) {
		this.appQuaId = appQuaId;
	}

	public String getQuaNm() {
		return quaNm;
	}

	public void setQuaNm(String quaNm) {
		this.quaNm = quaNm;
	}

	public byte[] getQuaAddressFile() {
		return quaAddressFile;
	}

	public void setQuaAddressFile(byte[] quaAddressFile) {
		this.quaAddressFile = quaAddressFile;
	}

}
