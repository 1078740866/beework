package Ansin.web.vueForm;

import java.util.List;

import Ansin.web.entity.IdListEntity;

public class A070103VueForm {
	
	//userCd
	private Integer userCd;
	//会社名
	private String companyNm;					
	//都道府県ID
	private Integer prefeId;
	//都道府県名
	private String prefeNm;
	//給料
	private Integer salary;						
	//業種ID
	private Integer industryId;					
	//職種ID
	private Integer jobtypeId;
	//業種名
	private String industryNm;
	//職種名
	private String jobtypeNm;
	//模糊查询
	private String likeSelect;
	//確認状態
	private String statusFlg;
	//職位ID
	private Integer positionId;
	//职位IDリスト
	private List<IdListEntity> listData;
	
	public String getCompanyNm() {
		return companyNm;
	}
	public void setCompanyNm(String companyNm) {
		this.companyNm = companyNm;
	}
	public Integer getPrefeId() {
		return prefeId;
	}
	public void setPrefeId(Integer prefeId) {
		this.prefeId = prefeId;
	}
	public String getPrefeNm() {
		return prefeNm;
	}
	public void setPrefeNm(String prefeNm) {
		this.prefeNm = prefeNm;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public Integer getIndustryId() {
		return industryId;
	}
	public void setIndustryId(Integer industryId) {
		this.industryId = industryId;
	}
	public Integer getJobtypeId() {
		return jobtypeId;
	}
	public void setJobtypeId(Integer jobtypeId) {
		this.jobtypeId = jobtypeId;
	}
	public String getIndustryNm() {
		return industryNm;
	}
	public void setIndustryNm(String industryNm) {
		this.industryNm = industryNm;
	}
	public String getJobtypeNm() {
		return jobtypeNm;
	}
	public void setJobtypeNm(String jobtypeNm) {
		this.jobtypeNm = jobtypeNm;
	}
	
	public Integer getPositionId() {
		return positionId;
	}
	public void setPositionId(Integer positionId) {
		this.positionId = positionId;
	}
	public List<IdListEntity> getListData() {
		return listData;
	}
	public void setListData(List<IdListEntity> listData) {
		this.listData = listData;
	}
	public Integer getUserCd() {
		return userCd;
	}
	public void setUserCd(Integer userCd) {
		this.userCd = userCd;
	}
	public String getLikeSelect() {
		return likeSelect;
	}
	public void setLikeSelect(String likeSelect) {
		this.likeSelect = likeSelect;
	}
	public String getStatusFlg() {
		return statusFlg;
	}
	public void setStatusFlg(String statusFlg) {
		this.statusFlg = statusFlg;
	}
	
}
