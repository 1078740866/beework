package Ansin.web.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import Ansin.web.entity.A0601ReportEntity;
import Ansin.web.entity.ApplicantInfoTblEntity;
import Ansin.web.entity.ApplicantSkillTblEntity;
import Ansin.web.entity.IdListEntity;
import Ansin.web.entity.PositionTblBySearchIdEntity;
import Ansin.web.entity.PositionTblEntity;
import Ansin.web.vueForm.A020205VueForm;
import Ansin.web.vueForm.A070103VueForm;
import Ansin.web.vueForm.B0101VueForm;
import Ansin.web.vueForm.B0102VueForm;
import Ansin.web.vueForm.C0201ListVueForm;
import Ansin.web.vueForm.HomeVueForm;

@Mapper
public interface PositionTblMapper {

    // すべて取得
    ArrayList<PositionTblEntity> getAll(@Param("companyId") Integer companyId);

    // すべて取得
    ArrayList<PositionTblEntity> getPositionForDroplist(@Param("companyId") Integer companyId);
    
    // Homeに関するすべて取得
    ArrayList<PositionTblBySearchIdEntity> getAllBySearchId(@Param("homeVueForm") HomeVueForm homeVueForm);

    // B0101VueFormからすべて取得
    List<PositionTblEntity> getAllPosition(@Param("b0101VueForm") B0101VueForm b0101VueForm);

    //C0003VueFormからすべて取得
    List<PositionTblEntity> getPosition(@Param("userCd") Integer userCd);

    // B0101職位をオンラインするとオフラインするまたは複数操作
    int positionOnlineOrOffline(@Param("positionIdList") List<Integer> positionIdList,
            @Param("onlineStatus") String onlineStatus, @Param("companyId") Integer companyId,
            @Param("userCd") Integer userCd);

    // B0101職位を削除または複数削除
    int positionDelete(@Param("positionIdList") List<Integer> positionIdList, @Param("companyId") Integer companyId,
            @Param("userCd") Integer userCd);
// B0101職位を削除または複数top
    int positionTop(@Param("positionIdList") List<Integer> positionIdList,
            @Param("topStatus") String topStatus, @Param("companyId") Integer companyId,
            @Param("userCd") Integer userCd);

    //B0102職位詳細画面情報検索
    PositionTblEntity getOne(@Param("positionId") Integer positionId);

    // B0102職位テーブル情報を追加する
    int addPosition(@Param("b0102VueForm") B0102VueForm b0102VueForm);

    // B0102職位テーブル情報を更新する
    int updPosition(@Param("b0102VueForm") B0102VueForm b0102VueForm);

    //C0201職位推薦
    List<PositionTblEntity> getRecommend(
    		@Param("applicantInfoTblEntity") ApplicantInfoTblEntity applicantInfoTblEntity
    		, @Param("skills") List<ApplicantSkillTblEntity> skills
    		);

    //C0201職位一覧
    List<PositionTblEntity> getDates(@Param("c0201ListVueForm") C0201ListVueForm c0201ListVueForm);
    
    //C0201応募済み一覧
    List<PositionTblEntity> getPost(@Param("c0201ListVueForm") C0201ListVueForm c0201ListVueForm);

    //C0201職位気に入る一覧
    List<PositionTblEntity> getLike(@Param("c0201ListVueForm") C0201ListVueForm c0201ListVueForm);

    //A020205職位一覧
    List<PositionTblEntity> getPositionList(@Param("c0201ListVueForm") A020205VueForm a020205VueForm);

    //A070103職位一覧
    List<PositionTblEntity> getPo(@Param("a070103VueForm") A070103VueForm a070103VueForm);

    //A070103職位単数または複数承認、拒否
    Integer positionConfirmOrDeny(@Param("list")List<IdListEntity> list,
			 @Param("userCd")Integer userCd,
			 @Param("statusFlg")String statusFlg);
    
    //職位名取得
    String getName(@Param("positionId") Integer positionId);
    
    //A0601通報職位単数または複数
    Integer reportPosition(@Param("positionIds")List<Integer> positionIds,
			 @Param("userCd")Integer userCd);
    
    //複数職位取得
    List<A0601ReportEntity> positionListSelect(@Param("positionIds")List<Integer> positionIds);
    
    //会社の総職位数を取得
    Integer getPositionCount(@Param("companyId") Integer companyId);
    
    // 会社の職位を取得
    ArrayList<PositionTblBySearchIdEntity> getAllByCompanyId(@Param("companyId") Integer companyId);

}
