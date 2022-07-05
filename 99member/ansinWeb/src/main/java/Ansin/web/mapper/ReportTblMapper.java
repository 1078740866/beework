package Ansin.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import Ansin.web.entity.A0601ListEntity;
import Ansin.web.vueForm.A0601VueForm;

@Mapper
public interface ReportTblMapper {
	
	/**
	 * 通報一覧情報取得
	 * @return List<A0601ListEntity>
	 */
	List<A0601ListEntity> getReportAll(@Param("a0601VueForm") A0601VueForm a0601VueForm);
	
	
	/**
	 * 通報複数成功または複数失敗
	 * @return Integer
	 */
	Integer changeFlg(@Param("a0601VueForm") A0601VueForm a0601VueForm);
	
	/**
	 * 通報操作後データ取得
	 * @return List<A0601ListEntity>
	 */
	List<A0601ListEntity> getChangeData(@Param("reportIds") List<Integer> reportIds);
	
	/**
	 * 通報データの件数取得
	 * @return List<A0601ListEntity>
	 */
	Integer getCount(@Param("a0601VueForm") A0601VueForm a0601VueForm);
	
}
