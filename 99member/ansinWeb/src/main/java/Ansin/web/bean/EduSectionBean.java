package Ansin.web.bean;

public class EduSectionBean {

	// 学歴区分
	private String eduSectionId;
	private String eduSectionNm;

	public EduSectionBean(String id, String name) {
		this.eduSectionId = id;
		this.eduSectionNm = name;
	}

	public String getEduSectionId() {
		return eduSectionId;
	}

	public void setEduSectionId(String eduSectionId) {
		this.eduSectionId = eduSectionId;
	}

	public String getEduSectionNm() {
		return eduSectionNm;
	}

	public void setEduSectionNm(String eduSectionNm) {
		this.eduSectionNm = eduSectionNm;
	}

}
