package Ansin.web.bean;

public class AdTblBean {
	
	//広告ID
	private String adId;
	//レイアウトID
	private String layoutId;
	//値段
	private String salary;
	//会社ID
	private String companyId;
	//会社名
	private String companyNm;
	//内容
	private String content;
	//写真
	private String photo;
	private byte[] photoAddress;
	//リンク
	private String link;
	//有効期間FROM
	private String dateFrom;
	//有効期間TO
	private String dateTo;
	//日数
	private String days;
	//総額
	private String sum;
	//オンライン状態
	private String onlineFlg;
	//支払状態
	private String chargeFlg;
	public String getAdId() {
		return adId;
	}
	public void setAdId(String adId) {
		this.adId = adId;
	}
	public String getLayoutId() {
		return layoutId;
	}
	public void setLayoutId(String layoutId) {
		this.layoutId = layoutId;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
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
	public String getDateFrom() {
		return dateFrom;
	}
	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}
	public String getDateTo() {
		return dateTo;
	}
	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}
	public String getSum() {
		return sum;
	}
	public void setSum(String sum) {
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
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getDays() {
		return days;
	}
	public void setDays(String days) {
		this.days = days;
	}
	
	public byte[] getPhotoAddress() {
		return photoAddress;
	}
	public void setPhotoAddress(byte[] photoAddress) {
		this.photoAddress = photoAddress;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	
	
}
