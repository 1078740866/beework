package Ansin.web.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import Ansin.web.entity.A0601ReportEntity;
import Ansin.web.entity.ApplicantConnEntity;
import Ansin.web.entity.IdListEntity;
import Ansin.web.entity.TrainingInfoTblEntity;
import Ansin.web.vueForm.A020202VueForm;
import Ansin.web.vueForm.A070104VueForm;
import Ansin.web.vueForm.B0501VueForm;
import Ansin.web.vueForm.B0502VueForm;
import Ansin.web.vueForm.C0301ListVueForm;


@Mapper
public interface TrainingTblMapper {
	
	/**
	   *  研修情報を取得
	 * @param trainingEntity
	 * @return trainingEntityList
	 */
	 List<TrainingInfoTblEntity> getAllTraining(@Param("b0501VueForm")B0501VueForm b0501VueForm);

	 /**
	     *  研修情報を削除
	  * @param trainingIdList
	  * @param companyId
	  * @return Integer
	  */
	 Integer update(@Param("trainingIdList")List<Integer> trainingIdList,
			 @Param("companyId")Integer companyId,
			 @Param("userCd")Integer userCd);
	 
	 /**
	 * 研修情報を改修
	 * @param trainingEntity
	 * @return Integer
	 */
	 Integer specificsUpdate(@Param("b0502VueForm")B0502VueForm b0502VueForm);
	
	 /**
	  * 研修情報を新規
	 * @param trainingEntity
	 * @return Integer
	 */
	 Integer specificsInsert(@Param("b0502VueForm")B0502VueForm b0502VueForm);
	 
	 /**
	  * C0301検索ボタン押下
	  * @param c0301ListVueForm
	  * @return
	  */
	 List<TrainingInfoTblEntity> getList(@Param("c0301ListVueForm")C0301ListVueForm c0301ListVueForm);

	 /**
	  * C0301研修推薦一覧リスト
	  * @param c0301ListVueForm
	  * @return
	  */
	 List<TrainingInfoTblEntity> getTraining(@Param("app")ApplicantConnEntity app);
	 /**
	  * C0301研修応募済み一覧リスト
	  * @param c0301ListVueForm
	  * @return
	  */
	 List<TrainingInfoTblEntity> getTrainingPost(@Param("c0301ListVueForm")C0301ListVueForm c0301ListVueForm);
	 /**
	  * C0301研修気に入る一覧リスト
	  * @param c0301ListVueForm
	  * @return
	  */
	 List<TrainingInfoTblEntity> getTrainingLike(@Param("c0301ListVueForm")C0301ListVueForm c0301ListVueForm);
	 /**
	  * A020202研修情報を取得
	  * @param a020202VueForm
	  * @return  List<TrainingInfoTblEntity>
	  */
	 List<TrainingInfoTblEntity> getAllTra(@Param("a020202VueForm")A020202VueForm a020202VueForm);
	 
 /**
	  * A0701_04_承認一覧画面(研修会)一覧リスト
	  * @param a070104VueForm
	  * @return
	  */
	 List<TrainingInfoTblEntity> getTra(@Param("a070104VueForm") A070104VueForm a070104VueForm);
	 /**
	  * A0701_04_承認一覧画面(研修会)単数または複数承認、拒否
	  * @param a070104VueForm
	  * @return
	  */
	 int trainingConfirmOrDeny(@Param("list")List<IdListEntity> list,
			 @Param("userCd")Integer userCd,
			 @Param("statusFlg")String statusFlg);
	 
	 /**
	  * 研修名取得
	  * @param trainingId
	  * @return String
	  */
	 String getName(@Param("trainingId")Integer trainingId);
	 
	//A0601通報研修会単数または複数
    Integer reportTraining(@Param("trainingIds")List<Integer> trainingIds,
			 @Param("userCd")Integer userCd);
	 
    //複数研修会取得
    List<A0601ReportEntity> trainingListSelect(@Param("trainingIds")List<Integer> trainingIds);
    
    
    //研修会詳細画面情報
    TrainingInfoTblEntity getOne(@Param("trainingId") Integer trainingId);
}
