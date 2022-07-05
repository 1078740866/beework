package Ansin.web.bean;

import java.io.Serializable;

public class PrefecturestAndCityBean implements Serializable {
	private static final long serialVersionUID = 1L;

	//都道府県ID
	private String prefeId;
	//都道府県名
	private String prefeNm;
	//市区町村ID
	private String cityId;
    //市区町村名
	private String cityNm;
	//郵便番号
	private int postal;

	public PrefecturestAndCityBean() {
		super();
	}

	public PrefecturestAndCityBean(String prefeId, String prefeNm, String cityId, String cityNm,
			int postal) {
		super();
		this.prefeId = prefeId;
		this.prefeNm = prefeNm;
		this.cityId = cityId;
		this.cityNm = cityNm;
		this.postal = postal;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getPrefeId() {
		return prefeId;
	}

	public void setPrefeId(String prefeId) {
		this.prefeId = prefeId;
	}

	public String getPrefeNm() {
		return prefeNm;
	}

	public void setPrefeNm(String prefeNm) {
		this.prefeNm = prefeNm;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getCityNm() {
		return cityNm;
	}

	public void setCityNm(String cityNm) {
		this.cityNm = cityNm;
	}

	public int getPostal() {
		return postal;
	}

	public void setPostal(int postal) {
		this.postal = postal;
	}



}
