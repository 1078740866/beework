package Ansin.web.entity;

import java.io.Serializable;
import java.util.Date;

public class ApplicantEduTblEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer educationId;
	private Integer applicantId;
	private String eduSection;
	private Date eduDateFrom;
	private Date eduDateTo;
	private String degree;
	private String schoolNm;
	private String majorNm;
	private String degreePic1;
	private String delFlg;
	private Date createTime;
	private String createBy;
	private Date updateTime;
	private String updateBy;

	
	public ApplicantEduTblEntity() {
		super();
	}


	public ApplicantEduTblEntity(Integer educationId, Integer applicantId, String eduSection, Date eduDateFrom,
			Date eduDateTo, String degree, String schoolNm, String majorNm, String degreePic1, String delFlg, Date createTime, String createBy, Date updateTime, String updateBy) {
		super();
		this.educationId = educationId;
		this.applicantId = applicantId;
		this.eduSection = eduSection;
		this.eduDateFrom = eduDateFrom;
		this.eduDateTo = eduDateTo;
		this.degree = degree;
		this.schoolNm = schoolNm;
		this.majorNm = majorNm;
		this.degreePic1 = degreePic1;
		this.delFlg = delFlg;
		this.createTime = createTime;
		this.createBy = createBy;
		this.updateTime = updateTime;
		this.updateBy = updateBy;
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


	public String getEduSection() {
		return eduSection;
	}


	public void setEduSection(String eduSection) {
		this.eduSection = eduSection;
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


	public String getDegreePic1() {
		return degreePic1;
	}


	public void setDegreePic1(String degreePic1) {
		this.degreePic1 = degreePic1;
	}


	public String getDelFlg() {
		return delFlg;
	}


	public void setDelFlg(String delFlg) {
		this.delFlg = delFlg;
	}


	public Date getCreateTime() {
		return createTime;
	}


	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}


	public String getCreateBy() {
		return createBy;
	}


	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}


	public Date getUpdateTime() {
		return updateTime;
	}


	public void setUpdateTime(Date updateTime) {
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


	@Override
	public String toString() {
		return "ApplicantEduTblEntity [educationId=" + educationId + ", applicantId=" + applicantId + ", eduSection="
				+ eduSection + ", eduDateFrom=" + eduDateFrom + ", eduDateTo=" + eduDateTo + ", degree=" + degree
				+ ", schoolNm=" + schoolNm + ", majorNm=" + majorNm + ", degreePic1=" + degreePic1 + ", delFlg=" + delFlg + ", createTime=" + createTime
				+ ", createBy=" + createBy + ", updateTime=" + updateTime + ", updateBy=" + updateBy + "]";
	}

	
}
