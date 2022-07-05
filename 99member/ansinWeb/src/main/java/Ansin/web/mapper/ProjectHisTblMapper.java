package Ansin.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import Ansin.web.entity.ProjectHisTblEntity;
import Ansin.web.vueForm.C010107VueForm;
@Mapper
public interface ProjectHisTblMapper {
	
			//C0101応募者のプロジェクト履歴リスト			
			List<ProjectHisTblEntity> getAll(@Param("applicantId") Integer applicantId);
			//C0101応募者のプロジェクト履歴を新規
			int projectHisInsert(@Param("c010107VueForm") C010107VueForm c010107VueForm);
			//C0101応募者のプロジェクト履歴を更新
			int projectHisUpdate(@Param("c010107VueForm") C010107VueForm c010107VueForm);
			//C0101応募者のプロジェクト履歴を削除
			int projectHisDelete(@Param("applicantId") Integer applicantId,@Param("projectId") Integer projectId,@Param("userCd") Integer userCd);
}
