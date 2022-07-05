package Ansin.web.entity;

import java.util.List;

/**
 * 
 * @author 楊卿赫
 * @date 2020-10-30 15:26:23
 */

// 説明会応募者一覧
public class B0804ListEntity {

	//支払項目リスト
	private List<ItemMstEntity> itemMstEntityList;
	//消費履歴リスト
	private List<ComConsTblEntity> comconsTblEntityList;
	//チャージ履歴リスト
	private List<ComChargeTblEntity> comchargeTblEntityList;
	public List<ItemMstEntity> getItemMstEntityList() {
		return itemMstEntityList;
	}
	public void setItemMstEntityList(List<ItemMstEntity> itemMstEntityList) {
		this.itemMstEntityList = itemMstEntityList;
	}
	public List<ComConsTblEntity> getComconsTblEntityList() {
		return comconsTblEntityList;
	}
	public void setComconsTblEntityList(List<ComConsTblEntity> comconsTblEntityList) {
		this.comconsTblEntityList = comconsTblEntityList;
	}
	public List<ComChargeTblEntity> getComchargeTblEntityList() {
		return comchargeTblEntityList;
	}
	public void setComchargeTblEntityList(List<ComChargeTblEntity> comchargeTblEntityList) {
		this.comchargeTblEntityList = comchargeTblEntityList;
	}
	@Override
	public String toString() {
		return "B0804ListEntity [itemMstEntityList=" + itemMstEntityList + ", comconsTblEntityList="
				+ comconsTblEntityList + ", comchargeTblEntityList=" + comchargeTblEntityList + "]";
	}
	
	
	

}
