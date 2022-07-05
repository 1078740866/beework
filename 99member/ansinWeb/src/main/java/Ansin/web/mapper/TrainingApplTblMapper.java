package Ansin.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import Ansin.web.entity.TrainingApplTblEntity;
import Ansin.web.vueForm.B0503VueForm;
import Ansin.web.vueForm.C0301VueForm;

@Mapper
public interface TrainingApplTblMapper {
	/**
	 * 研修応募者を取得
	 * @param B0503VueForm
	 * @return 
	 */
	List<TrainingApplTblEntity> getTrainingAppl(@Param("b0503VueForm")B0503VueForm B0503VueForm);
	/**
	 * 研修応募者を受け取れまたは拒否
	 * @param applicantIdList
	 * @param companyId
	 * @param training_id
	 * @param user_cd
	 * @return
	 */
	int applUpdateConfirmOrDeny(@Param("b0503VueForm")B0503VueForm b0503VueForm);
	
	//C0301研修応募者テーブルに応募済みを追加
	Integer insertPost(@Param("c0301VueForm")List<C0301VueForm> c0301VueForm);
	
	//C0301研修応募者テーブルに気に入るを追加
	Integer insertLike(@Param("c0301VueForm")List<C0301VueForm> c0301VueForm);
	
	//C0301研修応募者テーブルに単数または複数気に入るを更新する
	Integer updateLike(@Param("c0301VueForm")List<C0301VueForm> c0301VueForm,@Param("userCd")Integer userCd,@Param("applicantId")Integer applicantId);
	
	//C0301研修応募者テーブルに単数または複数削除する
	Integer deleteTrainingAppl(@Param("c0301VueForm")List<C0301VueForm> c0301VueForm,@Param("userCd")Integer userCd,@Param("applicantId")Integer applicantId);
	
	//C0301研修応募者テーブルに単数または複数削除する
	Integer deleteTra(@Param("trainingIdList")List<Integer> trainingIdList,@Param("userCd")Integer userCd,@Param("applicantId")Integer applicantId);
	
}
