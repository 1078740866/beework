package Ansin.web.mapper;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import Ansin.web.entity.ComConsTblEntity;
import Ansin.web.vueForm.ComConsVueForm;

@Mapper
public interface ComConsTblMapper {
	
	/**
	 * 消費履歴リストを取得
	 * @param b0804VueForm
	 * @return　List<ComconsTblEntity>
	 */
	List<ComConsTblEntity> getComconsTblEntityList(@Param("comcons") ComConsTblEntity comcons,@Param("dateFrom") Timestamp dateFrom,@Param("dateTo") Timestamp dateTo);

	/**
	 * 会社支払
	 * @param comConsVueForm
	 * @return Integer
	 */
	Integer gerCons(@Param("comConsVueForm")ComConsVueForm comConsVueForm);
	
}
