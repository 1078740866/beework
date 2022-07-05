package Ansin.web.entity;



public class TestGoods2Entity {
	
	
	private String goodsDetail;
	private String goodsPhoto;
	private String goodsLink;
	private String goodsName;
	private String goodsTag;
	private String goodsPrice;


	public String getGoodsDetail() {
		return goodsDetail;
	}
	public void setGoodsDetail(String goodsDetail) {
		this.goodsDetail = goodsDetail;
	}
	public String getGoodsPhoto() {
		return goodsPhoto;
	}
	public void setGoodsPhoto(String goodsPhoto) {
		this.goodsPhoto = goodsPhoto;
	}
	public String getGoodsLink() {
		return goodsLink;
	}
	public void setGoodsLink(String goodsLink) {
		this.goodsLink = goodsLink;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getGoodsTag() {
		return goodsTag;
	}
	public void setGoodsTag(String goodsTag) {
		this.goodsTag = goodsTag;
	}
	public String getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(String goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	
	@Override
	public String toString() {
		return "TestGoods2Entity [goodsDetail=" + goodsDetail + ", goodsPhoto=" + goodsPhoto + ", goodsLink="
				+ goodsLink + ", goodsName=" + goodsName + ", goodsTag=" + goodsTag + ", goodsPrice=" + goodsPrice
				+"]";
	}
}
