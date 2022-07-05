package Ansin.web.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class IndustryMstEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//業種ID
	private Integer industryId;
	//業種名
	private String industryNm;
	//削除フラグ
	private String delFlg;
	//作成時間
	private Timestamp createTime;
	//作成者
	private String createBy;
	//更新時間
	private Timestamp updateTime;
	//更新者
	private String updateBy;
	
	public IndustryMstEntity() {
		super();
	}
	
	public IndustryMstEntity(Integer industryId, String industryNm, String delFlg, Timestamp createTime, String createBy, Timestamp updateTime, String updateBy) {
		super();
		this.industryId = industryId;
		this.industryNm = industryNm;
		this.delFlg = delFlg;
		this.createTime = createTime;
		this.createBy = createBy;
		this.updateTime = updateTime;
		this.updateBy = updateBy;

	}

	/**
	 * @return the industryId
	 */
	public Integer getIndustryId() {
		return industryId;
	}

	/**
	 * @param industryId the industryId to set
	 */
	public void setIndustryId(Integer industryId) {
		this.industryId = industryId;
	}

	/**
	 * @return the industryNm
	 */
	public String getIndustryNm() {
		return industryNm;
	}

	/**
	 * @param industryNm the industryNm to set
	 */
	public void setIndustryNm(String industryNm) {
		this.industryNm = industryNm;
	}

	/**
	 * @return the delFlg
	 */
	public String getDelFlg() {
		return delFlg;
	}

	/**
	 * @param delFlg the delFlg to set
	 */
	public void setDelFlg(String delFlg) {
		this.delFlg = delFlg;
	}

	/**
	 * @return the createTime
	 */
	public Timestamp getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return the createBy
	 */
	public String getCreateBy() {
		return createBy;
	}

	/**
	 * @param createBy the createBy to set
	 */
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	/**
	 * @return the updateTime
	 */
	public Timestamp getUpdateTime() {
		return updateTime;
	}

	/**
	 * @param updateTime the updateTime to set
	 */
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * @return the updateBy
	 */
	public String getUpdateBy() {
		return updateBy;
	}

	/**
	 * @param updateBy the updateBy to set
	 */
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "IndustryInfoEntity [industryId=" + industryId + ", industryNm=" + industryNm + ", delFlg=" + delFlg
				+ ", createTime=" + createTime + ", createBy=" + createBy + ", updateTime=" + updateTime + ", updateBy="
				+ updateBy + "]";
	}

}
