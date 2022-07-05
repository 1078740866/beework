package Ansin.web.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import Ansin.web.entity.ApplicantEduTblEntity;
import Ansin.web.vueForm.C010106VueForm;

@Mapper
public interface ApplicantEduTblMapper {
	// すべて取得
	List<ApplicantEduTblEntity> getAll();
	// 一つ取得
	ApplicantEduTblEntity getOne(@Param("educationId") String educationId);
	// 複数削除
	Integer deleteMultiple(@Param("educationList")List<ApplicantEduTblEntity> educationList);
	// 一つ削除
	Integer deleteOne(@Param("educationId") String educationId);
	// 複数更新
	Integer updateMultiple(@Param("educationList")List<ApplicantEduTblEntity> educationList);
	// 一つ更新
	Integer updateOne(@Param("educationId") String educationId);
	// 複数挿入
	Integer insertMultiple(@Param("educationList")List<ApplicantEduTblEntity> educationList);
	// 一つ挿入
	Integer insertOne(@Param("educationId") String educationId);
	//C0101応募者の学歴リスト
	ArrayList<ApplicantEduTblEntity> getEdu(@Param("applicantId") Integer applicantId);
	//C0101応募者の学歴を新規
	int eduInsert(@Param("c010106VueForm") C010106VueForm c010106VueForm);
	//C0101応募者の学歴を更新
	int eduUpdate(@Param("c010106VueForm") C010106VueForm c010106VueForm);
	//C0101応募者の学歴を削除
	int eduDelete(@Param("applicantId") Integer applicantId,@Param("educationId") Integer educationId,@Param("userCd") Integer userCd);
}
