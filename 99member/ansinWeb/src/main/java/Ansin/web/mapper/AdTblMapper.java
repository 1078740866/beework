package Ansin.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import Ansin.web.entity.A0501ListEntity;
import Ansin.web.entity.AdTblEntity;
import Ansin.web.vueForm.A0501VueForm;
import Ansin.web.vueForm.A0502VueForm;

@Mapper
public interface AdTblMapper {
		//広告リストを取得
		List<A0501ListEntity> getAll(@Param("a0501VueForm") A0501VueForm a0501VueForm);
		
		//広告リストを取得
		List<AdTblEntity> getAllInit();
		
		//広告リストを取得
		AdTblEntity getOne(@Param("adId") Integer adId);
		
		//単数削除または複数削除
		Integer delete(@Param("adIds") List<Integer> adIds
				,@Param("userCd")Integer userCd);
		
		//広告更新
		Integer update(@Param("a0502VueForm") A0502VueForm a0502VueForm);
		
		//広告登録
		Integer insert(@Param("a0502VueForm") A0502VueForm a0502VueForm);
		
		//検索状態更新できるのデータ
		List<Integer> getSelectFlg();
		
		//状態変更
		Integer updagtFlg(@Param("list") List<Integer> list);
}
