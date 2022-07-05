package Ansin.web.bean;

/**
 * 会社支払履歴Bean
 * @author 楊卿赫
 *
 */
public class ComConsTblBean {
	
	//会社ID
	private String companyId;
	//支払ID
	private String consId;
	//支払ハニーコイン
	private String consHoney;
	//取得ポイント
	private String earnPoint;
	//支払項目ID
	private String itemId;
	//支払項目名
	private String itemNm;
	//クーポンID
	private String couponId;
	//クーポン名
	private String couponNm;

	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getConsId() {
		return consId;
	}
	public void setConsId(String consId) {
		this.consId = consId;
	}
	public String getConsHoney() {
		return consHoney;
	}
	public void setConsHoney(String consHoney) {
		this.consHoney = consHoney;
	}
	public String getEarnPoint() {
		return earnPoint;
	}
	public void setEarnPoint(String earnPoint) {
		this.earnPoint = earnPoint;
	}
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
	public String getCouponId() {
		return couponId;
	}
	public void setCouponId(String couponId) {
		this.couponId = couponId;
	}
	public String getCouponNm() {
		return couponNm;
	}
	public void setCouponNm(String couponNm) {
		this.couponNm = couponNm;
	}
	@Override
	public String toString() {
		return "ComConsTblBean [companyId=" + companyId + ", consId=" + consId + ", consHoney=" + consHoney
				+ ", earnPoint=" + earnPoint + ", itemId=" + itemId + ", itemNm=" + itemNm + ", couponId=" + couponId
				+ ", couponNm=" + couponNm + "]";
	}
	
	
}
