package Ansin.web.bean;

import java.util.List;

import Ansin.web.entity.ItemMstEntity;

/**
 * 
 * @author 楊卿赫
 * @date 2020-10-30 15:26:23
 */

// チャージ履歴と支払履歴一覧リスト
public class B0804ListBean {

	//支払項目リスト
	private List<ItemMstEntity> itemMstEntityList;
	//消費履歴リスト
	private List<ComChargeTblBean> comChargeBean;
	//チャージ履歴リスト
	private List<ComConsTblBean> comConsTblBean;
	
	public List<ItemMstEntity> getItemMstEntityList() {
		return itemMstEntityList;
	}
	public void setItemMstEntityList(List<ItemMstEntity> itemMstEntityList) {
		this.itemMstEntityList = itemMstEntityList;
	}
	public List<ComChargeTblBean> getComChargeBean() {
		return comChargeBean;
	}
	public void setComChargeBean(List<ComChargeTblBean> comChargeBean) {
		this.comChargeBean = comChargeBean;
	}
	public List<ComConsTblBean> getComConsTblBean() {
		return comConsTblBean;
	}
	public void setComConsTblBean(List<ComConsTblBean> comConsTblBean) {
		this.comConsTblBean = comConsTblBean;
	}
	@Override
	public String toString() {
		return "B0804ListBean [itemMstEntityList=" + itemMstEntityList + ", comChargeBean=" + comChargeBean
				+ ", comConsTblBean=" + comConsTblBean + ", getItemMstEntityList()=" + getItemMstEntityList()
				+ ", getComChargeBean()=" + getComChargeBean() + ", getComConsTblBean()=" + getComConsTblBean()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
}
