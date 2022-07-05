package Ansin.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import Ansin.web.entity.CompanyTblEntity;
import Ansin.web.entity.CountryTblEntity;
import Ansin.web.entity.IndustryMstEntity;
import Ansin.web.entity.UserTblEntity;

@Mapper
public interface CompanyRegisterMapper {

	List<IndustryMstEntity> getIndustryInfoAll();

	List<CountryTblEntity> getCountryInfoAll();

	List<CompanyTblEntity> getCompanyInfoAll();

	CompanyTblEntity getCompanyInfoById(Integer id);

	UserTblEntity getUserInfoById(Integer userCd);

	List<CompanyTblEntity> selectCompanyInfo(String companyNm, String address1, Integer industryId, String companyScale,
			Integer countryId);

	int getCompanyCount();

	int getUserCount();

	String getCompanyMax();

	String getUserMax();

	int selectCompanyCount(String companyNm, String address1, String industryId, String companyScale);

	void insertCompanyInfo(CompanyTblEntity companyInfoEntity);

	void insertUserInfo(UserTblEntity userEntity);

	//void update(UserInfoEntity user);

	//void delete(String id);

}
