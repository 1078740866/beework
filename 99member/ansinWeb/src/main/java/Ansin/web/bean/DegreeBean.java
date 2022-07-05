package Ansin.web.bean;

public class DegreeBean {

	public DegreeBean(String id, String name) {
		this.degreeId = id;
		this.degreeNm = name;
	}

	// 学位
	private String degreeId;
	private String degreeNm;

	public String getDegreeId() {
		return degreeId;
	}

	public void setDegreeId(String degreeId) {
		this.degreeId = degreeId;
	}

	public String getDegreeNm() {
		return degreeNm;
	}

	public void setDegreeNm(String degreeNm) {
		this.degreeNm = degreeNm;
	}

}
