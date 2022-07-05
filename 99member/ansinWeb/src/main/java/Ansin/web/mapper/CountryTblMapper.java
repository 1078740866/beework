package Ansin.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import Ansin.web.entity.CountryTblEntity;

public interface CountryTblMapper {
	// すべて取得
	List<CountryTblEntity> getAll();
	// 一つ取得
	CountryTblEntity getOne(@Param("countryId") Integer countryId);
	// 複数削除
	Integer deleteMultiple(@Param("countryList")List<CountryTblEntity> countryList);
	// 一つ削除
	Integer deleteOne(@Param("countryId") String countryId);
	// 複数更新
	Integer updateMultiple(@Param("countryList")List<CountryTblEntity> countryList);
	// 一つ更新
	Integer updateOne(@Param("countryId") String countryId);
	// 複数挿入
	Integer insertMultiple(@Param("countryList")List<CountryTblEntity> countryList);
	// 一つ挿入
	Integer insertOne(@Param("countryId") String countryId);

}
