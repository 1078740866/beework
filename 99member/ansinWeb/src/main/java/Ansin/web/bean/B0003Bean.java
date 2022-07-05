package Ansin.web.bean;

import java.util.List;

public class B0003Bean {
	
	//未処理件数
	private String count;
	//ユーザー情報
	private ComChargeBean userTblBean;
	//人材推薦リスト
	private List<B0301Bean> b0301Beans;
	
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public ComChargeBean getUserTblBean() {
		return userTblBean;
	}
	public void setUserTblBean(ComChargeBean userTblBean) {
		this.userTblBean = userTblBean;
	}
	public List<B0301Bean> getB0301Beans() {
		return b0301Beans;
	}
	public void setB0301Beans(List<B0301Bean> b0301Beans) {
		this.b0301Beans = b0301Beans;
	}
	@Override
	public String toString() {
		return "B0003Bean [count=" + count + ", userTblBean=" + userTblBean + ", b0301Beans=" + b0301Beans + "]";
	}


}
