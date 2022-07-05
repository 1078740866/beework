package Ansin.web.entity;

import java.util.Date;

public class AdTblEntity {

	//広告ID
	private Integer adId;
	//レイアウトID
	private Integer layoutId;
	//値段
	private Integer salary;
	//会社ID
	private Integer companyId;
	//会社名
	private String companyNm;
	//内容
	private String content;
	//写真
	private String photo;
	//リンク
	private String link;
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
	public String getCompanyNm() {
		return companyNm;
	}
	public void setCompanyNm(String companyNm) {
		this.companyNm = companyNm;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "AdTblEntity [adId=" + adId + ", layoutId=" + layoutId + ", salary=" + salary + ", companyId="
				+ companyId + ", companyNm=" + companyNm + ", photo=" + photo + ", link=" + link + ", dateFrom="
				+ dateFrom + ", dateTo=" + dateTo + ", days=" + days + ", sum=" + sum + ", onlineFlg=" + onlineFlg
				+ ", chargeFlg=" + chargeFlg + "]";
	}

}
