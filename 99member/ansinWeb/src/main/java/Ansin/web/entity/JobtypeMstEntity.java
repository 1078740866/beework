package Ansin.web.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class JobtypeMstEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	private Integer jobtypeId;
	private Integer industryId;
	private String jobtypeNm;
	private String delFlg;
	private Timestamp createTime;
	private String createBy;
	private Timestamp updateTime;
	private String updateBy;
	
	public JobtypeMstEntity() {
		super();
	}

	public JobtypeMstEntity(Integer jobtypeId, Integer industryId, String jobtypeNm, String delFlg, Timestamp createTime,
			String createBy, Timestamp updateTime, String updateBy) {
		super();
		this.jobtypeId = jobtypeId;
		this.industryId = industryId;
		this.jobtypeNm = jobtypeNm;
		this.delFlg = delFlg;
		this.createTime = createTime;
		this.createBy = createBy;
		this.updateTime = updateTime;
		this.updateBy = updateBy;
	}

	public Integer getJobtypeId() {
		return jobtypeId;
	}

	public void setJobtypeId(Integer jobtypeId) {
		this.jobtypeId = jobtypeId;
	}

	public Integer getIndustryId() {
		return industryId;
	}

	public void setIndustryId(Integer industryId) {
		this.industryId = industryId;
	}

	public String getJobtypeNm() {
		return jobtypeNm;
	}

	public void setJobtypeNm(String jobtypeNm) {
		this.jobtypeNm = jobtypeNm;
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
	
	
	
	
	
}
