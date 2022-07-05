package Ansin.web.bean;

import java.io.Serializable;
import java.util.List;

public class B0002PopListBean implements Serializable {
	private static final long serialVersionUID = 1L;

	List<CompanyTblPopBean> CompanyTblBeanList;

	//private int pageCount;

	public B0002PopListBean() {
		super();
	}

	public List<CompanyTblPopBean> getCompanyTblBeanList() {
		return CompanyTblBeanList;
	}

	public void setCompanyTblBeanList(List<CompanyTblPopBean> companyTblBeanList) {
		CompanyTblBeanList = companyTblBeanList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "B0002PopListBean [CompanyTblBeanList=" + CompanyTblBeanList + "]";
	}

//	public B0002PopListBean(List<CompanyTblBean> CompanyTblBeanList, int pageCount) {
//		super();
//		this.CompanyTblBeanList = CompanyTblBeanList;
//		this.pageCount = pageCount;
//	}
	

//	/**
//	 * @return the pageCount
//	 */
//	public int getPageCount() {
//		return pageCount;
//	}
//
//	/**
//	 * @param pageCount the pageCount to set
//	 */
//	public void setPageCount(int pageCount) {
//		this.pageCount = pageCount;
//	}
//
//	/**
//	 * @return the serialversionuid
//	 */
//	public static long getSerialversionuid() {
//		return serialVersionUID;
//	}
	
	
	

}
