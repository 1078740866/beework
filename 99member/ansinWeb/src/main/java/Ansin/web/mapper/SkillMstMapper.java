package Ansin.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import Ansin.web.entity.SkillMstEntity;

@Mapper
public interface SkillMstMapper {
	//スキル選択リストを取得		
	List<SkillMstEntity> getAll();
}
