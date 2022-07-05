package Ansin.web.bean;

/**
 * 会社チャージ履歴Bean
 * @author 楊卿赫
 *
 */
public class ComChargeTblBean {
	
	//会社ID
	private String companyId;
	//チャージID
	private String chargeId;
	//チャージ日時
	private String chargeTime;
	//チャージ金額
	private String chargeMoney;
	//チャージハニーコイン
	private String chargeHoney;
	//支払方式
	private String payMethod;
	//支払状態
	private String statusFlg;
	//ハニーコイン残高
	private String remainder;
	//ハニーコイン締切日
	private String honeyLastDate;
	
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getChargeId() {
		return chargeId;
	}
	public void setChargeId(String chargeId) {
		this.chargeId = chargeId;
	}
	public String getChargeTime() {
		return chargeTime;
	}
	public void setChargeTime(String chargeTime) {
		this.chargeTime = chargeTime;
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
	public String getPayMethod() {
		return payMethod;
	}
	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}
	public String getStatusFlg() {
		return statusFlg;
	}
	public void setStatusFlg(String statusFlg) {
		this.statusFlg = statusFlg;
	}
	public String getRemainder() {
		return remainder;
	}
	public void setRemainder(String remainder) {
		this.remainder = remainder;
	}
	public String getHoneyLastDate() {
		return honeyLastDate;
	}
	public void setHoneyLastDate(String honeyLastDate) {
		this.honeyLastDate = honeyLastDate;
	}
	@Override
	public String toString() {
		return "ComChargeTblBean [companyId=" + companyId + ", chargeId=" + chargeId + ", chargeTime=" + chargeTime
				+ ", chargeMoney=" + chargeMoney + ", chargeHoney=" + chargeHoney + ", payMethod=" + payMethod
				+ ", statusFlg=" + statusFlg + ", remainder=" + remainder + ", honeyLastDate=" + honeyLastDate + "]";
	}
	
	
	
	
}
