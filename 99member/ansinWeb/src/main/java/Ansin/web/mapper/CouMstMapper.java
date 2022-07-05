package Ansin.web.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import Ansin.web.entity.CouMstEntity;

@Mapper
public interface CouMstMapper {
		
		//国選択リストを取得		
		ArrayList<CouMstEntity> getAll();
}
