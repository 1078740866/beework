package Ansin.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import Ansin.web.entity.ApplicantWorkHisTblEntity;
import Ansin.web.vueForm.C010104VueForm;

@Mapper
public interface ApplicantWorkHisTblMapper {
	
		//C0101応募者の職歴リスト	
		List<ApplicantWorkHisTblEntity> getApplicantWorkHis(@Param("applicantId") Integer applicantId);
		//C0101応募者の職歴を新規
		int workHisInsert(@Param("c010104VueForm") C010104VueForm c010104VueForm);
		//C0101応募者の職歴を更新
		int workHisUpdate(@Param("c010104VueForm") C010104VueForm c010104VueForm);
		//C0101応募者の職歴を削除
		int workHisDelete(@Param("applicantId") Integer applicantId,@Param("workHisId") Integer workHisId,@Param("userCd") Integer userCd);
}
