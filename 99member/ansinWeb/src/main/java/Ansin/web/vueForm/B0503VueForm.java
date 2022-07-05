package Ansin.web.vueForm;

import java.util.List;


public class B0503VueForm {
	
	//ユーザーコード
	private Integer userCd;
	//会社ID
	private Integer companyId;
	//研修ID
	private Integer trainingId;
	//名前
	private String name;
	//状態
	private String status;
	//応募者IDのリスト
	private List<Integer> applicantId;
	//研修状態
	private String statusFlg;
	
	public Integer getUserCd() {
		return userCd;
	}
	public void setUserCd(Integer userCd) {
		this.userCd = userCd;
	}
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	public Integer getTrainingId() {
		return trainingId;
	}
	public void setTrainingId(Integer trainingId) {
		this.trainingId = trainingId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<Integer> getApplicantId() {
		return applicantId;
	}
	public void setApplicantId(List<Integer> applicantId) {
		this.applicantId = applicantId;
	}
	public String getStatusFlg() {
		return statusFlg;
	}
	public void setStatusFlg(String statusFlg) {
		this.statusFlg = statusFlg;
	}
	@Override
	public String toString() {
		return "B0503VueForm [companyId=" + companyId + ", trainingId=" + trainingId + ", name=" + name + ", status="
				+ status + ", applicantId=" + applicantId + "]";
	}
	
		
}
