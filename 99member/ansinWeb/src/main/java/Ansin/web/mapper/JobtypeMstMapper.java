package Ansin.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import Ansin.web.entity.JobtypeMstEntity;

@Mapper
public interface JobtypeMstMapper {
	// すべて取得
	List<JobtypeMstEntity> getAll();
	// 一つ取得
	JobtypeMstEntity getOne(@Param("jobtypeId") String jobtypeId);
	
}
