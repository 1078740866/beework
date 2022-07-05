package Ansin.web.bean;

import java.io.Serializable;

public class AdAddressBean implements Serializable {
	private static final long serialVersionUID = 1L;

	//住所1
	private String address1;

	public AdAddressBean() {
		super();
	}

	public AdAddressBean(String address1) {
		super();
		this.address1 = address1;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "PrefecturestAndCityBean [address1=" + address1 + "]";
	}

	

}
