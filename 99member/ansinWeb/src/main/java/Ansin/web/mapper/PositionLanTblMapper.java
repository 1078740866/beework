package Ansin.web.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import Ansin.web.entity.HomePositionLanEntity;
import Ansin.web.entity.PositionTblBySearchIdEntity;

@Mapper
public interface PositionLanTblMapper {
	
	// Homeに関するすべて取得
    ArrayList<HomePositionLanEntity> getLanInfo(@Param("positionTblBySearchIdEntity") List<PositionTblBySearchIdEntity> positionTblBySearchIdEntity);
}
