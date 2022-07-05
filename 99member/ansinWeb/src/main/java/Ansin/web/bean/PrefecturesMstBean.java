package Ansin.web.bean;

import java.io.Serializable;

public class PrefecturesMstBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//都道府県ID
	private String prefeId;
	//都道府県名
	private String prefeNm;

	public PrefecturesMstBean() {
		super();
	}

	public PrefecturesMstBean(String prefeId, String prefeNm) {
		super();
		this.prefeId = prefeId;
		this.prefeNm = prefeNm;

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

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "IndustryInfoEntity [prefeId=" + prefeId + ", prefeNm=" + prefeNm +  "]";
	}

}
