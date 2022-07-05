package Ansin.web.vueForm;

import java.util.Date;
import java.util.List;

public class A0501VueForm {
	
	//ユーザーコード
	private Integer userCd;
	//レイアウトID
	private Integer layoutId;
	//オンライン状態
	private String onlineFlg;
	//支払状態
	private String chargeFlg;
	//有効期間FROM
	private Date dateFrom;
	//有効期間TO
	private Date dateTo;
	//広告IDリスト
	private List<Integer> adIds;
	public Integer getUserCd() {
		return userCd;
	}
	public void setUserCd(Integer userCd) {
		this.userCd = userCd;
	}
	public Integer getLayoutId() {
		return layoutId;
	}
	public void setLayoutId(Integer layoutId) {
		this.layoutId = layoutId;
	}
	public String getOnlineFlg() {
		return onlineFlg;
	}
	public void setOnlineFlg(String onlineFlg) {
		this.onlineFlg = onlineFlg;
	}
	public String getChargeFlg() {
		return chargeFlg;
	}
	public void setChargeFlg(String chargeFlg) {
		this.chargeFlg = chargeFlg;
	}
	public Date getDateFrom() {
		return dateFrom;
	}
	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}
	public Date getDateTo() {
		return dateTo;
	}
	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}
	public List<Integer> getAdIds() {
		return adIds;
	}
	public void setAdIds(List<Integer> adIds) {
		this.adIds = adIds;
	}
	@Override
	public String toString() {
		return "A0501VueForm [userCd=" + userCd + ", layoutId=" + layoutId + ", onlineFlg=" + onlineFlg + ", chargeFlg="
				+ chargeFlg + ", dateFrom=" + dateFrom + ", dateTo=" + dateTo + ", adIds=" + adIds + ", getUserCd()="
				+ getUserCd() + ", getLayoutId()=" + getLayoutId() + ", getOnlineFlg()=" + getOnlineFlg()
				+ ", getChargeFlg()=" + getChargeFlg() + ", getDateFrom()=" + getDateFrom() + ", getDateTo()="
				+ getDateTo() + ", getAdIds()=" + getAdIds() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
	
}
