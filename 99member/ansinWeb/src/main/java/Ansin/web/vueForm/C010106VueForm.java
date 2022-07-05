package Ansin.web.vueForm;

import java.util.Date;

public class C010106VueForm {
	
	//sessionから会社ID
	private Integer companyId;
	//sessionから会社usercd
	private Integer userCd;
	//学歴ID						
	private Integer educationId;		
	//応募者ID
	private Integer applicantId;		
	//学校名
	private String schoolNm;		
	//専攻
	private String majorNm;			
	//入学年月日
	private Date eduDateFrom;		
	//卒業年月日
	private Date eduDateTo;			
	//学位
	private String degree;			
	//学歴区分
	private String eduSection;		
	//学歴証明書写真1
	private String degreePic1;		
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
	public Integer getEducationId() {
		return educationId;
	}
	public void setEducationId(Integer educationId) {
		this.educationId = educationId;
	}
	public Integer getApplicantId() {
		return applicantId;
	}
	public void setApplicantId(Integer applicantId) {
		this.applicantId = applicantId;
	}
	public String getSchoolNm() {
		return schoolNm;
	}
	public void setSchoolNm(String schoolNm) {
		this.schoolNm = schoolNm;
	}
	public String getMajorNm() {
		return majorNm;
	}
	public void setMajorNm(String majorNm) {
		this.majorNm = majorNm;
	}
	public Date getEduDateFrom() {
		return eduDateFrom;
	}
	public void setEduDateFrom(Date eduDateFrom) {
		this.eduDateFrom = eduDateFrom;
	}
	public Date getEduDateTo() {
		return eduDateTo;
	}
	public void setEduDateTo(Date eduDateTo) {
		this.eduDateTo = eduDateTo;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getEduSection() {
		return eduSection;
	}
	public void setEduSection(String eduSection) {
		this.eduSection = eduSection;
	}
	public String getDegreePic1() {
		return degreePic1;
	}
	public void setDegreePic1(String degreePic1) {
		this.degreePic1 = degreePic1;
	}
	@Override
	public String toString() {
		return "C010106VueForm [companyId=" + companyId + ", userCd=" + userCd + ", educationId=" + educationId
				+ ", applicantId=" + applicantId + ", schoolNm=" + schoolNm + ", majorNm=" + majorNm + ", eduDateFrom="
				+ eduDateFrom + ", eduDateTo=" + eduDateTo + ", degree=" + degree + ", eduSection=" + eduSection
				+ ", degreePic1=" + degreePic1 + "]";
	}
	
	
	
}
