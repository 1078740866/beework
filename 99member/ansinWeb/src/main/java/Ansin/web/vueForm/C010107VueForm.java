package Ansin.web.vueForm;

import java.util.Date;

public class C010107VueForm {
	//sessionから会社ID
	private Integer companyId;
	//sessionから会社usercd
	private Integer userCd;	
	//プロジェクトID					
	private Integer projectId;			
	//応募者ID
	private Integer applicantId;			
	//プロジェクト名前
	private String projectNm;			
	//開始日付
	private Date proDateFrom;			
	//終了日付
	private Date proDateTo;				
	//役割
	private String proRole;				
	//プロジェクト人数
	private int proCnt;					
	//職務内容
	private String proDuties;			
	//使用技術
	private String proTec;				
	//プロジェクト内容
	private String proContent;
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	public Integer getApplicantId() {
		return applicantId;
	}
	public void setApplicantId(Integer applicantId) {
		this.applicantId = applicantId;
	}
	public String getProjectNm() {
		return projectNm;
	}
	public void setProjectNm(String projectNm) {
		this.projectNm = projectNm;
	}
	public Date getProDateFrom() {
		return proDateFrom;
	}
	public void setProDateFrom(Date proDateFrom) {
		this.proDateFrom = proDateFrom;
	}
	public Date getProDateTo() {
		return proDateTo;
	}
	public void setProDateTo(Date proDateTo) {
		this.proDateTo = proDateTo;
	}
	public String getProRole() {
		return proRole;
	}
	public void setProRole(String proRole) {
		this.proRole = proRole;
	}
	public int getProCnt() {
		return proCnt;
	}
	public void setProCnt(int proCnt) {
		this.proCnt = proCnt;
	}
	public String getProDuties() {
		return proDuties;
	}
	public void setProDuties(String proDuties) {
		this.proDuties = proDuties;
	}
	public String getProTec() {
		return proTec;
	}
	public void setProTec(String proTec) {
		this.proTec = proTec;
	}
	public String getProContent() {
		return proContent;
	}
	public void setProContent(String proContent) {
		this.proContent = proContent;
	}
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
}
