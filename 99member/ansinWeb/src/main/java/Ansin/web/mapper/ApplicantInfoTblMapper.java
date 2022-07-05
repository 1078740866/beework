package Ansin.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import Ansin.web.entity.A0201ListEntity;
import Ansin.web.entity.ApplicantConnEntity;
import Ansin.web.entity.ApplicantInfoTblEntity;
import Ansin.web.entity.UserTblEntity;
import Ansin.web.vueForm.A0201VueForm;
import Ansin.web.vueForm.C010101VueForm;

@Mapper
public interface ApplicantInfoTblMapper {
	// すべて取得
	List<ApplicantInfoTblEntity> getAll();
	// 一つ取得
	ApplicantInfoTblEntity getOne(@Param("applicantId") Integer applicantId);
	//C010101応募者情報詳細取得	
	ApplicantConnEntity getApplicant(@Param("applicantId") Integer applicantId);
	//C010101応募者情報を取得	
	ApplicantConnEntity getApplicantInfo(@Param("userCd") Integer userCd);
	//C010101応募者情報を挿入
	int insertApplicant(@Param("c010101VueForm")C010101VueForm c010101VueForm);
	//C010101応募者情報を更新
	int updateApplicant(@Param("c010101VueForm")C010101VueForm c010101VueForm);
	//C010101応募者情報を削除
	int deleteApplicant(@Param("applicantIds")List<Integer> applicantIds);
	////C0201応募者を登録
	Integer getApplicantIds(@Param("userCd") Integer userCd);
	// すべて取得
	List<A0201ListEntity> getList(@Param("a0201VueForm") A0201VueForm a0201VueForm);
	//A020201応募者情報を取得	
	ApplicantConnEntity getAppl(@Param("applicantId") Integer applicantId);
	//個人条件取得
	ApplicantInfoTblEntity getTerms(@Param("userCd") Integer userCd);
	//ユーザー名前取得
	UserTblEntity getName(@Param("applicantId") Integer applicantId);
	
}
