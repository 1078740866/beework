package Ansin.web.bean;

import java.io.Serializable;

public class WaribikiMstBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String waribiki1;
	private String waribiki2;
	private String waribiki3;
	private String waribiki4;
	private String waribiki5;
	private String syohizei;
	private String delFlg;
	private String createTime;
	private String createBy;
	private String updateTime;
	private String updateBy;
	public String getWaribiki1() {
		return waribiki1;
	}
	public void setWaribiki1(String waribiki1) {
		this.waribiki1 = waribiki1;
	}
	public String getWaribiki2() {
		return waribiki2;
	}
	public void setWaribiki2(String waribiki2) {
		this.waribiki2 = waribiki2;
	}
	public String getWaribiki3() {
		return waribiki3;
	}
	public void setWaribiki3(String waribiki3) {
		this.waribiki3 = waribiki3;
	}
	public String getWaribiki4() {
		return waribiki4;
	}
	public void setWaribiki4(String waribiki4) {
		this.waribiki4 = waribiki4;
	}
	public String getWaribiki5() {
		return waribiki5;
	}
	public void setWaribiki5(String waribiki5) {
		this.waribiki5 = waribiki5;
	}
	public String getSyohizei() {
		return syohizei;
	}
	public void setSyohizei(String syohizei) {
		this.syohizei = syohizei;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "WaribikiMstBean [waribiki1=" + waribiki1 + ", waribiki2=" + waribiki2 + ", waribiki3=" + waribiki3
				+ ", waribiki4=" + waribiki4 + ", waribiki5=" + waribiki5 + ", syohizei=" + syohizei + ", delFlg="
				+ delFlg + ", createTime=" + createTime + ", createBy=" + createBy + ", updateTime=" + updateTime
				+ ", updateBy=" + updateBy + "]";
	}
	

}
