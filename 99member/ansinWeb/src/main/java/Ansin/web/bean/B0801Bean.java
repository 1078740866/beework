package Ansin.web.bean;

import java.util.List;

public class B0801Bean {
	//会社ハニーコイン
	private ComHoneyCoinBean comHoneyCoinBean;
	//会社ポイント
	private ComPointBean comPointBean;
	//会社クーポンリスト
	private List<ComCouponBean> comCouponBeans;
	public ComHoneyCoinBean getComHoneyCoinBean() {
		return comHoneyCoinBean;
	}
	public void setComHoneyCoinBean(ComHoneyCoinBean comHoneyCoinBean) {
		this.comHoneyCoinBean = comHoneyCoinBean;
	}
	public ComPointBean getComPointBean() {
		return comPointBean;
	}
	public void setComPointBean(ComPointBean comPointBean) {
		this.comPointBean = comPointBean;
	}
	public List<ComCouponBean> getComCouponBeans() {
		return comCouponBeans;
	}
	public void setComCouponBeans(List<ComCouponBean> comCouponBeans) {
		this.comCouponBeans = comCouponBeans;
	}
	@Override
	public String toString() {
		return "B0801Bean [comHoneyCoinBean=" + comHoneyCoinBean + ", comPointBean=" + comPointBean
				+ ", comCouponBeans=" + comCouponBeans + ", getComHoneyCoinBean()=" + getComHoneyCoinBean()
				+ ", getComPointBean()=" + getComPointBean() + ", getComCouponBeans()=" + getComCouponBeans()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
}
