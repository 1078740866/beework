package Ansin.web.vueForm;

public class A0602VueForm {
	
	//通報ID
	private Integer reportId;
	//処理状態
	private String status;
	//ユーザーコード
	private Integer userCd;
	
	
	public Integer getReportId() {
		return reportId;
	}
	public void setReportId(Integer reportId) {
		this.reportId = reportId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getUserCd() {
		return userCd;
	}
	public void setUserCd(Integer userCd) {
		this.userCd = userCd;
	}
	@Override
	public String toString() {
		return "A0602VueForm [reportId=" + reportId + ", status=" + status + ", userCd=" + userCd + ", getReportId()="
				+ getReportId() + ", getStatus()=" + getStatus() + ", getUserCd()=" + getUserCd() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}
