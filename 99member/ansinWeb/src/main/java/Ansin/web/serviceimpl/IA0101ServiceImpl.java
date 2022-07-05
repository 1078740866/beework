package Ansin.web.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ansin.web.entity.CompanyTblEntity;
import Ansin.web.mapper.CompanyTblMapper;
import Ansin.web.service.A0101Service;
import Ansin.web.vueForm.A0101VueForm;

/**
 * A0101 会社一覧画面Service
 * 
 * @author 王 凱
 * @date 2020-11-15 16:49:51
 */

@Service
public class IA0101ServiceImpl implements A0101Service {

	@Autowired
	private CompanyTblMapper companyTblMapper;

	/**
	 * A0101 会社一覧画面「検索」ボタンを押す
	 * 
	 * @param a0101VueForm
	 * @return List<CompanyTblEntity>
	 */
	@Override
	public List<CompanyTblEntity> getCompanyTblEntityList(A0101VueForm a0101VueForm) {
		return companyTblMapper.selectCompanyInfo(
				a0101VueForm.getCompanyNm(),
				a0101VueForm.getAddress1(),
				a0101VueForm.getIndustryId1(),
				a0101VueForm.getCompanyScale(),
				a0101VueForm.getCountryId());
	}

	/**
	 * A0101 会社一覧画面削除
	 * 
	 * @param companyIdList
	 * @param companyId
	 * @param userCd
	 * @return Integer
	 */
	@Override
	public Integer update(List<Integer> companyIdList, Integer companyId, Integer userCd) {
		return companyTblMapper.update(companyIdList, companyId, userCd);
	}

}
