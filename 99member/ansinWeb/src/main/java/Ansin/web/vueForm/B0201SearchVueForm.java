package Ansin.web.vueForm;

import java.util.ArrayList;

import Ansin.web.bean.DegreeBean;
import Ansin.web.bean.EduSectionBean;
import Ansin.web.bean.PositionBean;

public class B0201SearchVueForm {

	// 検索条件
	// 職位
	private ArrayList<PositionBean> positionBeanList;
	// 職位ID
	private Integer positionId;
	// 経験年数(FROM)
	private Integer workYearsFrom;
	// 経験年数(TO)
	private Integer workYearsTo;
	// 学位
	private ArrayList<DegreeBean> degreeBeanList;
	// 学位ID
	private String degreeId;
	// 年齢(FROM)
	private Integer ageFrom;
	// 年齢(TO)
	private Integer ageTo;
	// 学歴区分
	private ArrayList<EduSectionBean> eduSectionList;
	// 学歴区分ID
	private String eduSectionId;
	// 住所
	private String address;
	// キーワード検索名前
	private String name;
	// 応募状態
	private String applicationStatus;
	// 会社ID
	private Integer companyId;
	// 選択されたイベント
	private String hdnSentakuEvent;
	// 応募者ID
	private ArrayList<Integer> applicantIdList;
	// 職位ID
	private ArrayList<Integer> positionIdList;

	public ArrayList<PositionBean> getPositionBeanList() {
		return positionBeanList;
	}
	public Integer getPositionId() {
		return positionId;
	}
	public Integer getWorkYearsFrom() {
		return workYearsFrom;
	}
	public Integer getWorkYearsTo() {
		return workYearsTo;
	}
	public ArrayList<DegreeBean> getDegreeBeanList() {
		return degreeBeanList;
	}
	public String getDegreeId() {
		return degreeId;
	}

	public Integer getAgeFrom() {
		return ageFrom;
	}
	public Integer getAgeTo() {
		return ageTo;
	}
	public void setAgeFrom(Integer ageFrom) {
		this.ageFrom = ageFrom;
	}
	public void setAgeTo(Integer ageTo) {
		this.ageTo = ageTo;
	}
	public ArrayList<EduSectionBean> getEduSectionList() {
		return eduSectionList;
	}
	public String getEduSectionId() {
		return eduSectionId;
	}
	public String getAddress() {
		return address;
	}
	public String getName() {
		return name;
	}
	public String getApplicationStatus() {
		return applicationStatus;
	}
	public Integer getCompanyId() {
		return companyId;
	}
	public void setPositionBeanList(ArrayList<PositionBean> positionBeanList) {
		this.positionBeanList = positionBeanList;
	}
	public void setPositionId(Integer positionId) {
		this.positionId = positionId;
	}
	public void setWorkYearsFrom(Integer workYearsFrom) {
		this.workYearsFrom = workYearsFrom;
	}
	public void setWorkYearsTo(Integer workYearsTo) {
		this.workYearsTo = workYearsTo;
	}
	public void setDegreeBeanList(ArrayList<DegreeBean> degreeBeanList) {
		this.degreeBeanList = degreeBeanList;
	}
	public void setDegreeId(String degreeId) {
		this.degreeId = degreeId;
	}
	public void setEduSectionList(ArrayList<EduSectionBean> eduSectionList) {
		this.eduSectionList = eduSectionList;
	}
	public void setEduSectionId(String eduSectionId) {
		this.eduSectionId = eduSectionId;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setApplicationStatus(String applicationStatus) {
		this.applicationStatus = applicationStatus;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	public String getHdnSentakuEvent() {
		return hdnSentakuEvent;
	}
	public ArrayList<Integer> getApplicantIdList() {
		return applicantIdList;
	}
	public ArrayList<Integer> getPositionIdList() {
		return positionIdList;
	}
	public void setHdnSentakuEvent(String hdnSentakuEvent) {
		this.hdnSentakuEvent = hdnSentakuEvent;
	}
	public void setApplicantIdList(ArrayList<Integer> applicantIdList) {
		this.applicantIdList = applicantIdList;
	}
	public void setPositionIdList(ArrayList<Integer> positionIdList) {
		this.positionIdList = positionIdList;
	}


}
