package Ansin.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import Ansin.web.entity.LanMstEntity;

@Mapper
public interface LanMstMapper {
			
		//言語能力選択リストを取得
		List<LanMstEntity> getAll();
		
}
