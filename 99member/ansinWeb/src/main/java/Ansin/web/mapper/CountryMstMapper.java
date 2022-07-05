package Ansin.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import Ansin.web.entity.CountryMstEntity;

public interface CountryMstMapper {
	// すべて取得
	List<CountryMstEntity> getAll();
	// 一つ取得
	CountryMstEntity getOne(@Param("countryId") Integer countryId);
	// 複数削除
	Integer deleteMultiple(@Param("countryList")List<CountryMstEntity> countryList);
	// 一つ削除
	Integer deleteOne(@Param("countryId") String countryId);
	// 複数更新
	Integer updateMultiple(@Param("countryList")List<CountryMstEntity> countryList);
	// 一つ更新
	Integer updateOne(@Param("countryId") String countryId);
	// 複数挿入
	Integer insertMultiple(@Param("countryList")List<CountryMstEntity> countryList);
	// 一つ挿入
	Integer insertOne(@Param("countryId") String countryId);
}
