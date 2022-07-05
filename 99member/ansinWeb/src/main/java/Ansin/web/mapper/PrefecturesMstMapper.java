package Ansin.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import Ansin.web.entity.PrefecturesMstEntity;

@Mapper
public interface PrefecturesMstMapper {
	// すべて取得
	List<PrefecturesMstEntity> getAll();

	// 一つ取得
	PrefecturesMstEntity getOne(@Param("prefeId") int prefeId);
}
