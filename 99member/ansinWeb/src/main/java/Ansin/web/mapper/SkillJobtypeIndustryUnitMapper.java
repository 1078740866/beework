package Ansin.web.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import Ansin.web.entity.SkillJobtypeIndustryUnitEntity;

@Mapper
public interface SkillJobtypeIndustryUnitMapper {
	// スキルと所属する業種、職種をすべて取得
	ArrayList<SkillJobtypeIndustryUnitEntity> getAll();
	
}
