package Ansin.web.service;

import java.util.List;

import Ansin.web.entity.CompanyTblEntity;
import Ansin.web.vueForm.A0101VueForm;

/**
 * A0101 会社一覧画面Service Interface
 * 
 * @author 王 凱
 * @date 2020-11-15 16:49:51
 */

public interface A0101Service {
	/**
	 * A0101 会社一覧画面「検索」ボタンを押す
	 * 
	 * @param a0101VueForm
	 * @return List<CompanyTblEntity>
	 */
	List<CompanyTblEntity> getCompanyTblEntityList(A0101VueForm a0101VueForm);

	/**
	 * A0101 会社一覧画面削除
	 * 
	 * @param companyIdList
	 * @param companyId
	 * @param userCd
	 * @return Integer
	 */
	Integer update(List<Integer> companyIdList, Integer companyId, Integer userCd);

}
