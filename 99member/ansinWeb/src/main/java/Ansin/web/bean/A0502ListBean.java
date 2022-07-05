package Ansin.web.bean;

import java.util.List;

public class A0502ListBean {
	
	private AdTblBean adTblBean;
	
	private List<LayoutMstBean> layoutMstBeans;

	public AdTblBean getAdTblBean() {
		return adTblBean;
	}

	public void setAdTblBean(AdTblBean adTblBean) {
		this.adTblBean = adTblBean;
	}

	public List<LayoutMstBean> getLayoutMstBeans() {
		return layoutMstBeans;
	}

	public void setLayoutMstBeans(List<LayoutMstBean> layoutMstBeans) {
		this.layoutMstBeans = layoutMstBeans;
	}

	@Override
	public String toString() {
		return "A0502ListBean [adTblBean=" + adTblBean + ", layoutMstBeans=" + layoutMstBeans + ", getAdTblBean()="
				+ getAdTblBean() + ", getLayoutMstBeans()=" + getLayoutMstBeans() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}
