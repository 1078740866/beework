package Ansin.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import Ansin.web.entity.ItemMstEntity;

@Mapper
public interface ItemMstMapper {
	
	/**
	 * 支払項目リストを取得
	 * @return List<ItemMstEntity>
	 */
	List<ItemMstEntity> getAll();

}
