package Ansin.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AdAddressMstMapper {
		
		// 郵便番号によると、住所を取得
		List<String> getOne(@Param("postal") String postal);
		
		// 郵便番号によると、都道府県を取得
		String getPrefeNm(@Param("postal") String postal);

}
