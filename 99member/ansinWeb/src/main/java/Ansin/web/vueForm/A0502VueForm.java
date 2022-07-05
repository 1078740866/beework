package Ansin.web.vueForm;

import java.util.Date;

public class A0502VueForm {

	//広告ID
	private Integer adId;
	//レイアウトID
	private Integer layoutId;
	//会社ID
	private Integer companyId;
	//写真
	private String photo;
	//リンク
	private String link;
	//内容
	private String content;
	//有効期間FROM
	private Date dateFrom;
	//有効期間TO
	private Date dateTo;
	//日数
	private Integer days;
	//総額
	private Integer sum;
	//オンライン状態
	private String onlineFlg;
	//支払状態
	private String chargeFlg;
	//ユーザーコード
	private Integer userCd;
	public Integer getAdId() {
		return adId;
	}
	public void setAdId(Integer adId) {
		this.adId = adId;
	}
	public Integer getLayoutId() {
		return layoutId;
	}
	public void setLayoutId(Integer layoutId) {
		this.layoutId = layoutId;
	}
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
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
	public Integer getDays() {
		return days;
	}
	public void setDays(Integer days) {
		this.days = days;
	}
	public Integer getSum() {
		return sum;
	}
	public void setSum(Integer sum) {
		this.sum = sum;
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
	
	public Integer getUserCd() {
		return userCd;
	}
	public void setUserCd(Integer userCd) {
		this.userCd = userCd;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	
}
