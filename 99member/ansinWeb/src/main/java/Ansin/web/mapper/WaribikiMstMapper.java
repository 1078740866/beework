package Ansin.web.mapper;

import org.apache.ibatis.annotations.Mapper;

import Ansin.web.entity.WaribikiMstEntity;

@Mapper
public interface WaribikiMstMapper {
	
	// すべて取得
	WaribikiMstEntity getAll();

}
