package Ansin.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import Ansin.web.entity.IndustryMstEntity;

@Mapper
public interface IndustryMstMapper {
	// すべて取得
	List<IndustryMstEntity> getAll();
	// 一つ取得
	IndustryMstEntity getOne(@Param("industryId") Integer industryId);


}
