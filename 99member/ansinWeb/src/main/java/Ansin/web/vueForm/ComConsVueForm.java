package Ansin.web.vueForm;

/**
 * 支払画面 VueForm
 * 
 * @author 楊卿赫
 * @date 2020-11-23 19:03:33
 *
 */
public class ComConsVueForm {
	
	//会社ID
	private Integer companyId;
	//支払ハニーコイン
	private Integer consHoney;
	//取得ポイント
	private Integer earnPoint;
	//支払項目ID
	private Integer itemId;
	//クーポンID
	private Integer couponId;
	//ユーザーコード
	private Integer userCd;
	
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
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
	public Integer getCouponId() {
		return couponId;
	}
	public void setCouponId(Integer couponId) {
		this.couponId = couponId;
	}
	public Integer getUserCd() {
		return userCd;
	}
	public void setUserCd(Integer userCd) {
		this.userCd = userCd;
	}
	@Override
	public String toString() {
		return "ComConsVueForm [companyId=" + companyId + ", consHoney=" + consHoney + ", earnPoint=" + earnPoint
				+ ", itemId=" + itemId + ", couponId=" + couponId + ", userCd=" + userCd + ", getCompanyId()="
				+ getCompanyId() + ", getConsHoney()=" + getConsHoney() + ", getEarnPoint()=" + getEarnPoint()
				+ ", getItemId()=" + getItemId() + ", getCouponId()=" + getCouponId() + ", getUserCd()=" + getUserCd()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	

	
}
