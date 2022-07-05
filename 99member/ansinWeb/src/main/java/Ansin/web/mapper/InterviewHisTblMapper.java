package Ansin.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import Ansin.web.entity.InterviewHisTblEntity;
import Ansin.web.vueForm.A020204VueForm;
import Ansin.web.vueForm.B0401VueForm;

/**
 * B0401 面接一覧画面 Mapper
 * 
 * @author コウ テンキ
 * @date 2020-10-19 14:28:25
 */

@Mapper
public interface InterviewHisTblMapper {

	/**
	 * B0401 面接一覧画面データ
	 * @param b0401VueForm
	 * @return B0401ListEntity
	 */
	List<InterviewHisTblEntity> getAllInterviewHisTblEntities(@Param("b0401VueForm") B0401VueForm b0401VueForm);
	
	/**
	 * B0401 面接一覧画面削除
	 * @param interviewIdList
	 * @param companyId
	 * @return int
	 */
	int update(@Param("interviewIdList")List<Integer> interviewIdList,
			 @Param("companyId")Integer companyId,
			 @Param("userCd")Integer userCd);
	
	/**
	 * A020204 面接一覧画面データ
	 * @param b0401VueForm
	 * @return B0401ListEntity
	 */
	List<InterviewHisTblEntity> getInterview(@Param("a020204VueForm") A020204VueForm a020204VueForm);
	/**
	 * A020204 面接一覧画面削除
	 * @param interviewIdList
	 * @param applicantId
	 * @return int
	 */
	int updateInterview(@Param("interviewIdList")List<Integer> interviewIdList,
			 @Param("applicantId")Integer applicantId);
	/**
	 * 当面接の会社名取得
	 * @param interviewId
	 * @return String
	 */
	String getName(@Param("interviewId")Integer interviewId);
	
	/**
	 * C0501_面接一覧画面データ（未処理）
	 * @param b0401VueForm
	 * @return B0401ListEntity
	 */
	List<InterviewHisTblEntity> getAllForUser(@Param("b0401VueForm") B0401VueForm b0401VueForm);
	
	/**
	 * C0501_面接一覧画面データ（処理後）
	 * @param b0401VueForm
	 * @return B0401ListEntity
	 */
	List<InterviewHisTblEntity> getAllInfoUser(@Param("b0401VueForm") B0401VueForm b0401VueForm);
	
	
	
	/**
	 * C0501_面接一覧ユーザー多数受けたまたは多数断る
	 * @param interviewIdList
	 * @param userCd
	 * @param statusFlg 
	 * @return int
	 */
	int updateStatus(@Param("interviewIdList")List<Integer> interviewIdList,
			 @Param("userCd")Integer userCd,
			 @Param("statusFlg")String statusFlg);

}
