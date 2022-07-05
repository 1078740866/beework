package Ansin.web.reponseEntity;

import java.io.Serializable;

import Ansin.web.entity.CompanyTblEntity;
import Ansin.web.entity.UserTblEntity;

public class CompanyRegisterResponseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private CompanyTblEntity companyEntity;
	private UserTblEntity userEntity;
	
	public CompanyRegisterResponseEntity() {
		super();
	}

	public CompanyTblEntity getCompanyInfoEntity() {
		return companyEntity;
	}

	public void setCompanyInfoEntity(CompanyTblEntity companyInfoEntity) {
		this.companyEntity = companyInfoEntity;
	}

	public UserTblEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserTblEntity userEntity) {
		this.userEntity = userEntity;
	}
	
	
	
}
