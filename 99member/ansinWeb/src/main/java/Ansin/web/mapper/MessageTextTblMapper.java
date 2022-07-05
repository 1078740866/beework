package Ansin.web.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MessageTextTblMapper {
	
	//送信ボタン押下
	Integer insert(@Param("message") String message,@Param("userCd") Integer userCd);
	//取得ID
	Integer getId();
	
	//システム通知送信ボタン押下
	Integer reportSystemMessage(
			@Param("positionNm")String positionNm,
			@Param("updateBy")Integer updateBy);
	
	//システム通知送信ボタン押下
	Integer reportSystemMessage2(
			@Param("trainingNm")String trainingNm,
			@Param("updateBy")Integer updateBy);
	
	
	//システム通知送信ボタン押下
	Integer reportSystemMessage3(
			@Param("briefingNm")String briefingNm,
			@Param("updateBy")Integer updateBy);
	
	//主キーを取得
	Integer getMaxId();

}
