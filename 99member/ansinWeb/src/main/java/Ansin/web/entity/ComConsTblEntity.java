package Ansin.web.entity;

import java.sql.Timestamp;
/**
 * 会社支払履歴Entity
 * @author 楊卿赫
 *
 */
public class ComConsTblEntity {
	
	//会社ID
	private Integer companyId;
	//支払ID
	private Integer consId;
	//支払ハニーコイン
	private Integer consHoney;
	//取得ポイント
	private Integer earnPoint;
	//支払項目ID
	private Integer itemId;
	//支払項目名
	private String itemNm;
	//クーポンID
	private Integer couponId;
	//クーポン名
	private String couponNm;
	//削除フラグ
	private String delFlg;
	//作成日時
	private Timestamp createTime;
	//作成者
	private String createBy;
	//更新日時
	private Timestamp updateTime;
	//更新者
	private String updateBy;
	
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	public Integer getConsId() {
		return consId;
	}
	public void setConsId(Integer consId) {
		this.consId = consId;
	}
	public Integer getConsHoney() {
		return consHoney;
	}
	public void setConsHoney(Integer consHoney) {
		this.consHoney = consHoney;
	}
	public Integer getEarnPoint() {
		return earnPoint;
	}
	public void setEarnPoint(Integer earnPoint) {
		this.earnPoint = earnPoint;
	}
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public String getItemNm() {
		return itemNm;
	}
	public void setItemNm(String itemNm) {
		this.itemNm = itemNm;
	}
	public Integer getCouponId() {
		return couponId;
	}
	public void setCouponId(Integer couponId) {
		this.couponId = couponId;
	}
	public String getCouponNm() {
		return couponNm;
	}
	public void setCouponNm(String couponNm) {
		this.couponNm = couponNm;
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
	@Override
	public String toString() {
		return "ComconsTblEntity [companyId=" + companyId + ", consId=" + consId + ", consHoney=" + consHoney
				+ ", earnPoint=" + earnPoint + ", itemId=" + itemId + ", itemNm=" + itemNm + ", couponId=" + couponId
				+ ", couponNm=" + couponNm + ", delFlg=" + delFlg + ", createTime=" + createTime + ", createBy="
				+ createBy + ", updateTime=" + updateTime + ", updateBy=" + updateBy + "]";
	}
	
	
}
