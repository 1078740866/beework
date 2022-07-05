package Ansin.web.vueForm;

/**
 * B0804_履歴画面 VueForm
 * 
 * @author 楊卿赫
 * @date 2020-10-30 11:03:33
 *
 */
public class B0804VueForm {

	//チャージ日付FROM
	private String chargeFrom;
	//チャージ日付TO
	private String chargeTo;
	//注文状態
	private String statusFlg;
	//消費日付FROM
	private String consFrom;
	//消費日付TO
	private String consTo;
	//支払項目
	private String itemId;
	// チャージID
	private String chargeId;
	//チャージ金額
	private String chargeMoney;
	//チャージハニーコイン
	private String chargeHoney;


	public String getChargeFrom() {
		return chargeFrom;
	}



	public void setChargeFrom(String chargeFrom) {
		this.chargeFrom = chargeFrom;
	}



	public String getChargeTo() {
		return chargeTo;
	}



	public void setChargeTo(String chargeTo) {
		this.chargeTo = chargeTo;
	}



	public String getStatusFlg() {
		return statusFlg;
	}



	public void setStatusFlg(String statusFlg) {
		this.statusFlg = statusFlg;
	}



	public String getConsFrom() {
		return consFrom;
	}



	public void setConsFrom(String consFrom) {
		this.consFrom = consFrom;
	}



	public String getConsTo() {
		return consTo;
	}



	public void setConsTo(String consTo) {
		this.consTo = consTo;
	}



	public String getItemId() {
		return itemId;
	}



	public void setItemId(String itemId) {
		this.itemId = itemId;
	}



	public String getChargeId() {
		return chargeId;
	}



	public void setChargeId(String chargeId) {
		this.chargeId = chargeId;
	}


	public String getChargeMoney() {
		return chargeMoney;
	}



	public void setChargeMoney(String chargeMoney) {
		this.chargeMoney = chargeMoney;
	}



	public String getChargeHoney() {
		return chargeHoney;
	}



	public void setChargeHoney(String chargeHoney) {
		this.chargeHoney = chargeHoney;
	}



	@Override
	public String toString() {
		return "B0804VueForm [chargeFrom=" + chargeFrom + ", chargeTo=" + chargeTo + ", statusFlg=" + statusFlg
				+ ", consFrom=" + consFrom + ", consTo=" + consTo + ", itemId=" + itemId + ", chargeId=" + chargeId
				+ ", chargeMoney=" + chargeMoney + ", chargeHoney=" + chargeHoney + ", getChargeFrom()="
				+ getChargeFrom() + ", getChargeTo()=" + getChargeTo() + ", getStatusFlg()=" + getStatusFlg()
				+ ", getConsFrom()=" + getConsFrom() + ", getConsTo()=" + getConsTo() + ", getItemId()=" + getItemId()
				+ ", getChargeId()=" + getChargeId() + ", getChargeMoney()=" + getChargeMoney() + ", getChargeHoney()="
				+ getChargeHoney() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}



	
}
