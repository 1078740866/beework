package Ansin.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import Ansin.web.entity.B0301Entity;
import Ansin.web.entity.CompanyTblEntity;
import Ansin.web.vueForm.B0301VueForm;

@Mapper
public interface B0301ListMapper {
		/**
		 * 一覧リスト
		 * @param b0301VueForm
		 * @return List<B0301Entity>
		 */
		List<B0301Entity> getAll(@Param("b0301VueForm") B0301VueForm b0301VueForm);
		
		/**
		 * 管理画面一覧リスト
		 * @param companyId
		 * @return List<B0301Entity>
		 */
		List<B0301Entity> getList(@Param("company")CompanyTblEntity company);
		
}
