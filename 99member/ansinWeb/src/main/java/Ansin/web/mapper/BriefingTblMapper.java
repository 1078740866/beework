package Ansin.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import Ansin.web.entity.A0601ReportEntity;
import Ansin.web.entity.ApplicantConnEntity;
import Ansin.web.entity.BriefingInfoTblEntity;
import Ansin.web.entity.IdListEntity;
import Ansin.web.vueForm.A020203VueForm;
import Ansin.web.vueForm.A070105VueForm;
import Ansin.web.vueForm.B0601VueForm;
import Ansin.web.vueForm.B0602VueForm;
import Ansin.web.vueForm.C0401ListVueForm;

@Mapper
public interface BriefingTblMapper {

	/**
	   *   説明会新規作成
	 * @param briefingEntity
	 * @return int
	 */
	int prefecturesCityInsert(@Param("b0602VueForm") B0602VueForm b0602VueForm);

	/**
	   *   説明会更新
	 * @param briefingEntity
	 * @return int
	 */
	int prefecturesCityUpdate(@Param("b0602VueForm") B0602VueForm b0602VueForm);
	
	/**
	   *   説明会初期表示と検索
	 * @param briefingInfoEntities
	 * @return List<BriefingEntity>
	 */
	List<BriefingInfoTblEntity> getBriefingInfoList(@Param("b0601VueForm") B0601VueForm b0601VueForm);
	
	/**
	   *   説明会情報を削除
	 * @param briefingIds
	 * @param companyId
	 * @return int
	 */
	int briefingInfoDelete(@Param("briefingIds") List<Integer> briefingIds
			,@Param("companyId")Integer companyId
			,@Param("userCd")Integer userCd);
	/**
	 * C0401説明会検索ボタン押下リスト
	 * @param c0401ListVueForm
	 * @return
	 */
	List<BriefingInfoTblEntity> getList(@Param("c0401ListVueForm")C0401ListVueForm c0401ListVueForm);
	/**
	 * C0401説明会推薦一覧リスト
	 * @param app
	 * @return
	 */
	List<BriefingInfoTblEntity> getBriefing(@Param("app")ApplicantConnEntity app);
	/**
	 * C0401説明会応募済み一覧リスト
	 * @param c0401ListVueForm
	 * @return
	 */
	List<BriefingInfoTblEntity> getBriefingPost(@Param("c0401ListVueForm")C0401ListVueForm c0401ListVueForm);
	/**
	 * C0401説明会気に入る一覧リスト
	 * @param c0401ListVueForm
	 * @return
	 */
	List<BriefingInfoTblEntity> getBriefingLike(@Param("c0401ListVueForm")C0401ListVueForm c0401ListVueForm);
	/**
	 * A020203説明会初期表示と検索
	 * @param briefingInfoEntities
	 * @return List<BriefingEntity>
	 */
	List<BriefingInfoTblEntity> getBrie(@Param("b0601VueForm") A020203VueForm b0601VueForm);
	/**
	 * A0701_05_承認一覧画面(説明会)一覧リスト
	 * @param a070105VueForm
	 * @return
	 */
	List<BriefingInfoTblEntity> getBrie2(@Param("a070105VueForm") A070105VueForm a070105VueForm);
	/**
	 * A0701_05_承認一覧画面(説明会)単数または複数承認、拒否
	 * @param a070105VueForm
	 * @return
	 */
	int briefingConfirmOrDeny(@Param("list")List<IdListEntity> list,
			 @Param("userCd")Integer userCd,
			 @Param("statusFlg")String statusFlg
			 );
	
	/**
	   *   説明会名取得
	 * @param briefingId
	 * @return String
	 */
	String getName(@Param("briefingId")Integer briefingId);
	
	//A0601通報説明会単数または複数
    Integer reportBriefing(@Param("briefingIds")List<Integer> briefingIds,
			 @Param("userCd")Integer userCd);
    
    
    //複数説明会取得
    List<A0601ReportEntity> briefingListSelect(@Param("briefingIds")List<Integer> briefingIds);
    
    //説明会詳細画面情報
    BriefingInfoTblEntity getOne(@Param("briefingId") Integer briefingId);
    
}
