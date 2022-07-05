package Ansin.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import Ansin.web.entity.ComCoinPointEntity;
import Ansin.web.entity.CompanyTblEntity;
import Ansin.web.entity.CompanyTblPopEntity;
import Ansin.web.vueForm.A070102VueForm;

@Mapper
public interface CompanyTblMapper {

	/**
	 * 会社一つ取得
	 * @param companyId
	 * @return CompanyTblEntity
	 */
	CompanyTblEntity getCompanyInfoById(@Param("companyId") Integer companyId);
	
	
	/**
	 * ホームページの会社一つ取得
	 * @param companyId
	 * @return CompanyTblEntity
	 */
	CompanyTblPopEntity getInfoById(@Param("companyId") Integer companyId);

	/**
	 * 会社リスト取得
	 * @param companyNm
	 * @param address1
	 * @param industryId
	 * @param companyScale
	 * @param countryId
	 * @return List<CompanyTblEntity>
	 */
	List<CompanyTblEntity> selectCompanyInfo(String companyNm, String address1, Integer industryId, String companyScale,
			Integer countryId);
	
	/**
	 * 会社Popリスト取得
	 * @param companyNm
	 * @param address1
	 * @param industryId
	 * @param companyScale
	 * @param countryId
	 * @return List<CompanyTblEntity>
	 */
	List<CompanyTblPopEntity> selectCompanyPop(String companyNm, String address1, Integer industryId, String companyScale,
			Integer countryId);
	
	/**
	 * 会社登録
	 * @param companyInfoEntity
	 * @return Integer
	 */
	Integer insertCompanyInfo(CompanyTblEntity companyInfoEntity);
	
	/**
	 * A0701_02_承認一覧画面(会社)一覧リスト
	 * @param a070102VueForm
	 * @return
	 */
	List<CompanyTblEntity> selectCompany(@Param("a070102VueForm") A070102VueForm a070102VueForm);
	
	/**
	 * A0701_02_承認一覧画面(会社)単数または複数承認、拒否
	 * @param a070102VueForm
	 * @return
	 */
	Integer updateCompanyInfo(@Param("companyIdList")List<Integer> companyIdList,
			 @Param("userCd")Integer userCd,
			 @Param("statusFlg")String statusFlg);

	/**
	 * 会社チャージ情報取得
	 * @param companyId
	 * @return ComHoneyCoinEntity
	 */
	ComCoinPointEntity getCharge(@Param("companyId") Integer companyId);
	
	/**
	 * 会社支払情報取得
	 * @param companyId
	 * @return ComHoneyCoinEntity
	 */
	ComCoinPointEntity getCons(@Param("companyId") Integer companyId);
	
	/**
	 * 会社今月取得コイン情報取得
	 * @param companyId
	 * @return ComHoneyCoinEntity
	 */
	ComCoinPointEntity getMonthAcquired(@Param("companyId") Integer companyId);
	
	/**
	 * 会社今月使用コイン情報取得
	 * @param companyId
	 * @return ComHoneyCoinEntity
	 */
	ComCoinPointEntity getMonthUsed(@Param("companyId") Integer companyId);
	
	/**
	 * 会社まもなく締切日の情報取得
	 * @param companyId
	 * @return ComHoneyCoinEntity
	 */
	ComCoinPointEntity getLastDate(@Param("companyId") Integer companyId);

	/**
	 * 会社削除
	 * 
	 * @param interviewIdList
	 * @param companyId
	 * @param userCd
	 * @return int
	 */
	int update(@Param("companyIdList") List<Integer> companyIdList, 
			@Param("companyId") Integer companyId,
			@Param("userCd")Integer userCd);

	/**
	 * 会社クーポン残高取得
	 * @param companyId
	 * @return Integer
	 */
	Integer selectBalance(@Param("companyId") Integer companyId);
	
	
	/**
	 * 会社金額更新
	 * @param companyId
	 * @param Money
	 * @param coin
	 * @return Integer
	 */
	Integer changeCom(@Param("companyId")Integer companyId,
			@Param("money")Integer money, 
			@Param("coin")Integer coin);

	
	/**
	 * 会社名取得
	 * @param companyId
	 * @return String
	 */
	String getName(@Param("companyId") Integer companyId);
	
	
	/**
	 * 会社IDからユーザーコード取得
	 * @param List<Integer>
	 * @return List<Integer>
	 */
	List<Integer> getUsers(@Param("list") List<Integer> list);
	
}
