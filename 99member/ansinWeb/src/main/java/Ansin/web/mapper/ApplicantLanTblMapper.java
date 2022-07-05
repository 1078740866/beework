package Ansin.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import Ansin.web.entity.ApplicantLanTblEntity;
import Ansin.web.vueForm.C010105VueForm;
@Mapper
public interface ApplicantLanTblMapper {
	
		//C0101応募者の言語リスト			
		List<ApplicantLanTblEntity> getAll(@Param("applicantId") Integer applicantId);
		//C0101応募者の言語を新規
		int lanInsert(@Param("c010105VueForm") C010105VueForm c010105VueForm);
		//C0101応募者の言語を更新
		int lanUpdate(@Param("c010105VueForm") C010105VueForm c010105VueForm);
		//C0101応募者の言語を削除
		int lanDelete(@Param("applicantId") Integer applicantId,@Param("languageId") Integer languageId,@Param("userCd") Integer userCd);
}
