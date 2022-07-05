package Ansin.web.bean;

public class ApplicantQuaTblBean {
	// 応募者資格ID
	private String appQuaId;
	// 応募者ID
	private String applicantId;
	// 資格名
	private String quaNm;
	// 資格番号
	private String quaNum;
	// 資格画像アドレス
	private String quaAddress;
	// 取得日
	private String acquisitionDate;
	// 備考
	private String remarks;
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

	private byte[] photoPic;

	public String getAppQuaId() {
		return appQuaId;
	}

	public void setAppQuaId(String appQuaId) {
		this.appQuaId = appQuaId;
	}

	public String getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(String applicantId) {
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

	public String getAcquisitionDate() {
		return acquisitionDate;
	}

	public void setAcquisitionDate(String acquisitionDate) {
		this.acquisitionDate = acquisitionDate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
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

	public String getQuaNm() {
		return quaNm;
	}

	public void setQuaNm(String quaNm) {
		this.quaNm = quaNm;
	}

	public byte[] getPhotoPic() {
		return photoPic;
	}

	public void setPhotoPic(byte[] photoPic) {
		this.photoPic = photoPic;
	}

}
