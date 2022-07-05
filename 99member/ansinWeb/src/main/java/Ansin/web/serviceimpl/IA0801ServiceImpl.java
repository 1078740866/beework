package Ansin.web.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ansin.web.bean.A0802Bean;
import Ansin.web.bean.A0803Bean;
import Ansin.web.bean.MessageBean;
import Ansin.web.entity.A0802ListEntity;
import Ansin.web.entity.A0803ListEntity;
import Ansin.web.entity.MessageEntity;
import Ansin.web.entity.UserTblEntity;
import Ansin.web.mapper.MessageTblMapper;
import Ansin.web.mapper.MessageTextTblMapper;
import Ansin.web.mapper.UserTblMapper;
import Ansin.web.service.A0801Service;
import Ansin.web.util.EditUtil;
import Ansin.web.vueForm.A0801VueForm;
import Ansin.web.vueForm.A0802VueForm;
import Ansin.web.vueForm.A0803VueForm;

@Service
public class IA0801ServiceImpl implements A0801Service{
	
	@Autowired
	private MessageTblMapper messageTblMapper;
	@Autowired
	private MessageTextTblMapper messageTextTblMapper;
	@Autowired
	private UserTblMapper userTblMapper;
	
	
	/**
	 * 送信ボタン押下
	 * @param a0801VueForm
	 * @return Integer
	 */
	@Override
	public Integer send(A0801VueForm a0801VueForm) {
		//メッセージ本文テーブル挿入
		messageTextTblMapper.insert(a0801VueForm.getInternalMessageText(),a0801VueForm.getSendId());
		//取得MAXID
		Integer messageTextId  = messageTextTblMapper.getId();
		
		a0801VueForm.setInternalMessageTextId(messageTextId);
		
		//メッセージテーブル挿入
		return messageTblMapper.insert(a0801VueForm,a0801VueForm.getRecid());
	}
	
	/**
	 * 宛先一覧画面初期表示と検索ボタン押下
	 * @param a0802VueForm
	 * @return List<A0802Bean>
	 */
	@Override
	public List<A0802Bean> getUserList(A0802VueForm a0802VueForm) {
		List<A0802ListEntity> a0802ListEntities =  userTblMapper.getAddressList(a0802VueForm);
		//出力
		List<A0802Bean> beans = new ArrayList<A0802Bean>();
		//編集
		for (A0802ListEntity entity : a0802ListEntities) {
			A0802Bean bean = new A0802Bean();
			BeanUtils.copyProperties(entity, bean);
			bean.setMail(entity.getUserMail());
			bean.setTel(entity.getUserTel());
			bean.setUserCd(EditUtil.intUtil(entity.getUserCd()));
			bean.setUserNm(entity.getFirstName() + " " + entity.getLastName());
			beans.add(bean);
		}
		return beans;
	}
	
	/**
	 * 送信履歴画面初期表示と検索ボタン押下
	 * @param a0803VueForm
	 * @return List<A0803Bean>
	 */
	@Override
	public List<A0803Bean> getAddress(A0803VueForm a0803VueForm) {
		
		List<A0803ListEntity> a0802ListEntities = messageTblMapper.getAddress(a0803VueForm);
		
		//出力
		List<A0803Bean> beans = new ArrayList<A0803Bean>();
				
		//編集
		for (A0803ListEntity entity : a0802ListEntities) {
			A0803Bean bean = new A0803Bean();
			BeanUtils.copyProperties(entity, bean);
			bean.setaDate(EditUtil.timeStampUtil(entity.getaDate()));
			bean.setInternalMessageId(EditUtil.intUtil(entity.getInternalMessageId()));
			beans.add(bean);
			if(entity.getRecId() != 0) {
				UserTblEntity user = userTblMapper.getName(entity.getRecId());
				bean.setName(user.getFirstName() + " " + user.getLastName());
			}else {
				bean.setName("すべてユーザー");
			}
		}
		return beans;
	}
	
	/**
	 * 一つメッセージ取得
	 * @param a0803VueForm
	 * @return MessageBean
	 */
	@Override
	public MessageBean getMessage(A0803VueForm a0803VueForm) {
		MessageEntity messageEntity = messageTblMapper.getMessage(a0803VueForm);
		MessageBean bean = new MessageBean();
		if (messageEntity != null) {
			BeanUtils.copyProperties(messageEntity, bean);
			bean.setInternalMessageId(EditUtil.intUtil(messageEntity.getInternalMessageId()));
			bean.setInternalMessageTextId(EditUtil.intUtil(messageEntity.getInternalMessageTextId()));
			bean.setRecId(EditUtil.intUtil(messageEntity.getRecId()));
			bean.setSendId(EditUtil.intUtil(messageEntity.getSendId()));
			bean.setTimeString(EditUtil.timeStampUtil(messageEntity.getTimeString()));
			if(messageEntity.getRecId() != 0) {
				UserTblEntity user1 = userTblMapper.getName(messageEntity.getRecId());
				bean.setrName(user1.getFirstName() + " " + user1.getLastName());
				UserTblEntity user2 = userTblMapper.getName(messageEntity.getSendId());
				bean.setsName(user2.getFirstName() + " " + user2.getLastName());
			}else {
				bean.setrName("すべてユーザー");
				UserTblEntity user2 = userTblMapper.getName(messageEntity.getSendId());
				bean.setsName(user2.getFirstName() + " " + user2.getLastName());
			}
		}
		return bean;
	}
	
	

}
