package Ansin.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import Ansin.web.entity.LayoutMstEntity;

@Mapper
public interface LayoutMstMapper {
	
	//すべて取得
	List<LayoutMstEntity> getAll();
	
}
