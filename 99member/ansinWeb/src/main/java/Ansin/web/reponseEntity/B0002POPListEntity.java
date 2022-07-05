package Ansin.web.reponseEntity;

import java.io.Serializable;
import java.util.List;

import Ansin.web.entity.CompanyTblEntity;

public class B0002POPListEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	List<CompanyTblEntity> companyRegisterList;
	
	private int pageCount;
	
	public B0002POPListEntity() {
		super();
	}
	
	public B0002POPListEntity(List<CompanyTblEntity> companyRegisterList, int pageCount) {
		super();
		this.companyRegisterList = companyRegisterList;
		this.pageCount = pageCount;
	}

	/**
	 * @return the companyRegisterList
	 */
	public List<CompanyTblEntity> getCompanyRegisterList() {
		return companyRegisterList;
	}

	/**
	 * @param company the companyRegisterList to set
	 */
	public void setCompanyRegisterList(List<CompanyTblEntity> company) {
		this.companyRegisterList = company;
	}

	/**
	 * @return the pageCount
	 */
	public int getPageCount() {
		return pageCount;
	}

	/**
	 * @param pageCount the pageCount to set
	 */
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
