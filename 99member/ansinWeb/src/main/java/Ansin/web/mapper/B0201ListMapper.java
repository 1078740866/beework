package Ansin.web.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import Ansin.web.dto.B0201SearchDto;
import Ansin.web.entity.B0201Entity;

@Mapper
public interface B0201ListMapper {

	// 明細リスト
	ArrayList<B0201Entity> getAll(@Param("searchDto") B0201SearchDto searchDto);

	// 削除
	int deleteMultiple(@Param("applicationStatus") String applicationStatus,
			@Param("companyId") Integer companyId,
			@Param("positionIdList") ArrayList<Integer> positionIdList,
			@Param("applicantIdList") ArrayList<Integer> applicantIdList);

}
