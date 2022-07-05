package Ansin.web.entity;

import java.sql.Timestamp;

public class ItemMstEntity {
	
	//項目ID
	private String itemId;
	//項目名
	private String itemNm;
	//単価
	private int itemPrice;
	//単位週間
	private int itemUnit;
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
	
	
	
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getItemNm() {
		return itemNm;
	}
	public void setItemNm(String itemNm) {
		this.itemNm = itemNm;
	}
	public int getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	public int getItemUnit() {
		return itemUnit;
	}
	public void setItemUnit(int itemUnit) {
		this.itemUnit = itemUnit;
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
		return "ItemMstEntity [itemId=" + itemId + ", itemNm=" + itemNm + ", itemPrice=" + itemPrice + ", itemUnit="
				+ itemUnit + ", delFlg=" + delFlg + ", createTime=" + createTime + ", createBy=" + createBy
				+ ", updateTime=" + updateTime + ", updateBy=" + updateBy + "]";
	}


	

}
