package Ansin.web.bean;

public class LayoutMstBean {
	
	//レイアウトID
	private String layoutId;
	//値段
	private String layoutMoney;
	public String getLayoutId() {
		return layoutId;
	}
	public void setLayoutId(String layoutId) {
		this.layoutId = layoutId;
	}
	public String getLayoutMoney() {
		return layoutMoney;
	}
	public void setLayoutMoney(String layoutMoney) {
		this.layoutMoney = layoutMoney;
	}
	@Override
	public String toString() {
		return "LayoutMstBean [layoutId=" + layoutId + ", layoutMoney=" + layoutMoney + "]";
	}
	
	
	
}
