package Ansin.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import Ansin.web.entity.ApplicantSkillTblEntity;
import Ansin.web.vueForm.C010103VueForm;

@Mapper
public interface ApplicantSkillTblMapper {
	
		//C0101応募者のスキルリスト
		List<ApplicantSkillTblEntity> getSkill(@Param("applicantId") Integer applicantId);
		//C0101応募者のスキルを新規
		int skillInsert(@Param("c010103VueForm") C010103VueForm c010103VueForm);
		//C0101応募者のスキルを更新
		int skillUpdate(@Param("c010103VueForm") C010103VueForm c010103VueForm);
		//C0101応募者のスキルを削除
		int skillDelete(@Param("applicantId") Integer applicantId,@Param("appSkillId") Integer appSkillId,@Param("userCd") Integer userCd);
}
