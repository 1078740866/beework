package Ansin.web.bean;

import java.io.Serializable;
import java.util.List;

public class HomeInitBean implements Serializable {
	
	// serialVersionUID
	private static final long serialVersionUID = 1L;
	
	// 職種リストを定義
	List<JobtypeMstBean> jobtypeList;
	
	// 広告リストを定義
	List<AdTblBean> adList;
	
	public HomeInitBean() {
		super();
	}
	
	public HomeInitBean(List<IndustryMstBean> industryList, List<JobtypeMstBean> jobtypeList, List<AdTblBean> adList) {
		super();
		
		this.jobtypeList = jobtypeList;
		this.adList = adList;
	}

	/**
	 * @return the jobtypeList
	 */
	public List<JobtypeMstBean> getJobtypeList() {
		return jobtypeList;
	}

	/**
	 * @param jobtypeList the jobtypeList to set
	 */
	public void setJobtypeList(List<JobtypeMstBean> jobtypeList) {
		this.jobtypeList = jobtypeList;
	}

	/**
	 * @return the adList
	 */
	public List<AdTblBean> getAdList() {
		return adList;
	}

	/**
	 * @param adList the adList to set
	 */
	public void setAdList(List<AdTblBean> adList) {
		this.adList = adList;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
