package Ansin.web.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import Ansin.web.entity.InterviewHisTblEntity;
import Ansin.web.vueForm.B0402VueForm;

/**
 * B0402 面接詳細情報 Mapper
 * 
 * @author コウ テンキ
 * @date 2020-10-22 11:47:33
 */

@Mapper
public interface InterviewInfoMapper {

	/**
	 * B0402 面接詳細情報 初期表示
	 * 
	 * @param interviewId
	 * @return B0402VueForm
	 */
	InterviewHisTblEntity getInit(@Param("interviewId") Integer interviewId);

	/**
	 * B0402 面接詳細情報 データ更新
	 * 
	 * @param b0402VueForm
	 * @return Integer
	 */
	Integer update(@Param("b0402VueForm") B0402VueForm b0402VueForm);
	
	
	/**
	 * B0402 面接詳細情報 データ新規
	 * 
	 * @param b0402VueForm
	 * @return Integer
	 */
	Integer insert(@Param("b0402VueForm") B0402VueForm b0402VueForm);

}
