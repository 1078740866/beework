package Ansin.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import Ansin.web.entity.QuaMstEntity;

@Mapper
public interface QuaMstMapper {
		//資格選択リストを取得
		List<QuaMstEntity> getAll();
}
