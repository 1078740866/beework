package Ansin.web.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class WaribikiMstEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Double waribiki1;
	private Double waribiki2;
	private Double waribiki3;
	private Double waribiki4;
	private Double waribiki5;
	private Double syohizei;
	private String delFlg;
	private Timestamp createTime;
	private String createBy;
	private Timestamp updateTime;
	private String updateBy;
	public Double getWaribiki1() {
		return waribiki1;
	}
	public void setWaribiki1(Double waribiki1) {
		this.waribiki1 = waribiki1;
	}
	public Double getWaribiki2() {
		return waribiki2;
	}
	public void setWaribiki2(Double waribiki2) {
		this.waribiki2 = waribiki2;
	}
	public Double getWaribiki3() {
		return waribiki3;
	}
	public void setWaribiki3(Double waribiki3) {
		this.waribiki3 = waribiki3;
	}
	public Double getWaribiki4() {
		return waribiki4;
	}
	public void setWaribiki4(Double waribiki4) {
		this.waribiki4 = waribiki4;
	}
	public Double getWaribiki5() {
		return waribiki5;
	}
	public void setWaribiki5(Double waribiki5) {
		this.waribiki5 = waribiki5;
	}
	public Double getSyohizei() {
		return syohizei;
	}
	public void setSyohizei(Double syohizei) {
		this.syohizei = syohizei;
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
	@Override
	public String toString() {
		return "WaribikiMstEntity [waribiki1=" + waribiki1 + ", waribiki2=" + waribiki2 + ", waribiki3=" + waribiki3
				+ ", waribiki4=" + waribiki4 + ", waribiki5=" + waribiki5 + ", syohizei=" + syohizei + ", delFlg="
				+ delFlg + ", createTime=" + createTime + ", createBy=" + createBy + ", updateTime=" + updateTime
				+ ", updateBy=" + updateBy + "]";
	}
	
	
}
