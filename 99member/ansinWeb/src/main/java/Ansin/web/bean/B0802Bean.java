package Ansin.web.bean;

import java.util.List;

public class B0802Bean {
	
	private List<CouponMstBean> lists;
	
	private String couponBalance;

	public List<CouponMstBean> getLists() {
		return lists;
	}

	public void setLists(List<CouponMstBean> lists) {
		this.lists = lists;
	}

	public String getCouponBalance() {
		return couponBalance;
	}

	public void setCouponBalance(String couponBalance) {
		this.couponBalance = couponBalance;
	}

	@Override
	public String toString() {
		return "B0802Bean [lists=" + lists + ", couponBalance=" + couponBalance + ", getLists()=" + getLists()
				+ ", getCouponBalance()=" + getCouponBalance() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

	
	
	
}
