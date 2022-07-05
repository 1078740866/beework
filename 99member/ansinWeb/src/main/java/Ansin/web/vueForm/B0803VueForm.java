package Ansin.web.vueForm;

import java.sql.Timestamp;

/**
 * B0803_チャージ画面 VueForm
 * 
 * @author 楊卿赫
 * @date 2020-11-13 19:03:33
 *
 */
public class B0803VueForm {
	
	//会社ID
	private Integer companyId;
	//チャージ日付
	private Timestamp chargeTime;
	//チャージ金額
	private Integer chargeMoney;
	//チャージハニーコイン
	private Integer chargeHoney;
	//支払方法
	private String payMethod;
	//支払状態
	private String statusFlg;
	//残高
	private Integer remainder;
	//締切日
	private Timestamp honeyLastDate;
	//ユーザーコード
	private Integer userCd;
	
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	public Timestamp getChargeTime() {
		return chargeTime;
	}
	public void setChargeTime(Timestamp chargeTime) {
		this.chargeTime = chargeTime;
	}
	public Integer getChargeMoney() {
		return chargeMoney;
	}
	public void setChargeMoney(Integer chargeMoney) {
		this.chargeMoney = chargeMoney;
	}
	public Integer getChargeHoney() {
		return chargeHoney;
	}
	public void setChargeHoney(Integer chargeHoney) {
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
	public Integer getRemainder() {
		return remainder;
	}
	public void setRemainder(Integer remainder) {
		this.remainder = remainder;
	}
	public Timestamp getHoneyLastDate() {
		return honeyLastDate;
	}
	public void setHoneyLastDate(Timestamp honeyLastDate) {
		this.honeyLastDate = honeyLastDate;
	}
	public Integer getUserCd() {
		return userCd;
	}
	public void setUserCd(Integer userCd) {
		this.userCd = userCd;
	}
	@Override
	public String toString() {
		return "B0803VueForm [companyId=" + companyId + ", chargeTime=" + chargeTime + ", chargeMoney=" + chargeMoney
				+ ", chargeHoney=" + chargeHoney + ", payMethod=" + payMethod + ", statusFlg=" + statusFlg
				+ ", remainder=" + remainder + ", honeyLastDate=" + honeyLastDate + ", userCd=" + userCd
				+ ", getCompanyId()=" + getCompanyId() + ", getChargeTime()=" + getChargeTime() + ", getChargeMoney()="
				+ getChargeMoney() + ", getChargeHoney()=" + getChargeHoney() + ", getPayMethod()=" + getPayMethod()
				+ ", getStatusFlg()=" + getStatusFlg() + ", getRemainder()=" + getRemainder() + ", getHoneyLastDate()="
				+ getHoneyLastDate() + ", getUserCd()=" + getUserCd() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
}
