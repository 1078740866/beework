package Ansin.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import Ansin.web.entity.BriefingApplTblEntity;
import Ansin.web.vueForm.B0603VueForm;
import Ansin.web.vueForm.C0401VueForm;

/**
 * 
 * @author コウ　テンキ
 * @date 2020-10-16 18:06:36
 */
@Mapper
public interface BriefingApplTblMapper {
	
	/**
	 *  説明会応募者情報を取得する
	 * @param briefingApplEntity
	 * @return List<BriefingApplEntity>
	 */
	List<BriefingApplTblEntity> briefingApplList(@Param("b0603VueForm") B0603VueForm b0603VueForm);
	
	//C0401説明会応募者テーブルに応募済みを追加
	Integer insertPost(@Param("c0401VueForm")List<C0401VueForm> c0401VueForm);
		
	//C0401説明会応募者テーブルに気に入るを追加
	Integer insertLike(@Param("c0401VueForm")List<C0401VueForm> c0401VueForm);
		
	//C0401説明会応募者テーブルに単数または複数気に入るを更新する
	Integer updateLike(@Param("c0401VueForm")List<C0401VueForm> c0401VueForm,@Param("userCd")Integer userCd,@Param("applicantId")Integer applicantId);
		
	//C0401説明会応募者テーブルに単数または複数削除する
	Integer deleteBriefingAppl(@Param("c0401VueForm")List<C0401VueForm> c0401VueForm,@Param("userCd")Integer userCd,@Param("applicantId")Integer applicantId);
	
	/**
	   *   説明会情報を削除
	 * @param briefingIds
	 * @param applicantId
	 * @return int
	 */
	Integer deleteBrie(@Param("briefingIds") List<Integer> briefingIds
			,@Param("applicantId")Integer applicantId
			,@Param("userCd")Integer userCd);
	
}
