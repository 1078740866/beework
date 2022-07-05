package Ansin.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import Ansin.web.vueForm.A020205VueForm;
import Ansin.web.vueForm.C0201VueForm;

@Mapper
public interface ApplicationTblMapper {
	
	//未処理件数取得
	Integer getCount(@Param("companyId") Integer companyId);
	//C0201応募テーブルに応募済みを追加
	Integer insertPost(@Param("c0201VueForm")List<C0201VueForm> c0201VueForm);
	//C0201応募テーブルに気に入るを追加
	Integer insertLike(@Param("c0201VueForm")List<C0201VueForm> c0201VueForm);
	//C0201単数または複数気に入る
	Integer updateLike(@Param("c0201VueForm")List<C0201VueForm> c0201VueForm,@Param("userCd")Integer userCd,@Param("applicantId")Integer applicantId);
	//C0201単数または複数削除
	Integer deleteApplication(@Param("c0201VueForm")List<C0201VueForm> c0201VueForm,@Param("userCd")Integer userCd,@Param("applicantId")Integer applicantId);
	//A020205単数または複数削除
	Integer deleteAppl(@Param("a020205VueForm")A020205VueForm a020205VueForm);

}
