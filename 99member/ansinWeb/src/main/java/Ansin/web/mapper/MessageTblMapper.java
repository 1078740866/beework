package Ansin.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import Ansin.web.entity.A0803ListEntity;
import Ansin.web.entity.MessageEntity;
import Ansin.web.vueForm.A0801VueForm;
import Ansin.web.vueForm.A0803VueForm;

@Mapper
public interface MessageTblMapper {
	
	//送信ボタン押下
	Integer insert(@Param("a0801VueForm")A0801VueForm a0801VueForm,@Param("item")List<Integer> recId);
	//送信一覧取得
	List<A0803ListEntity> getAddress(@Param("a0803VueForm")A0803VueForm a0803VueForm);
	//メッセージLINK押下
	MessageEntity getMessage(@Param("a0803VueForm")A0803VueForm a0803VueForm);
	//受信一覧取得
	List<A0803ListEntity> getSelect(@Param("a0803VueForm")A0803VueForm a0803VueForm);	
	//メッセージ状態変更
	Integer flgChange(@Param("userCd")Integer userCd, @Param("internalMessageId")Integer messageId);
	
	Integer systemReportInsert(
			@Param("sendId")Integer sendId, 
			@Param("recId")Integer recId, 
			@Param("messageTextId")Integer messageTextId);
}
