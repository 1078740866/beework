package Ansin.web.entity;

import java.util.Date;

public class CompanyCouponTblEntity {
	//会社クーポンID	
	private Integer comCouId;	
	//会社ID	
	private Integer companyId;	
	//クーポンID
	private Integer couponId;	
	//締め切り日
	private Date deadline;
	//使用状態
	private String statusFlg;	
	//削除フラグ
	private String delFlg;	
	//作成日時
	private Date createTime;	
	//作成者
	private String createBy;
	//更新日時
	private Date updateTime;
	//更新者
	private String updateBy;
	public Integer getComCouId() {
		return comCouId;
	}
	public void setComCouId(Integer comCouId) {
		this.comCouId = comCouId;
	}
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	public Integer getCouponId() {
		return couponId;
	}
	public void setCouponId(Integer couponId) {
		this.couponId = couponId;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	public String getStatusFlg() {
		return statusFlg;
	}
	public void setStatusFlg(String statusFlg) {
		this.statusFlg = statusFlg;
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
	
	
}
