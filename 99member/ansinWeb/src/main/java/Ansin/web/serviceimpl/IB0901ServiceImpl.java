package Ansin.web.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ansin.web.bean.A0803Bean;
import Ansin.web.bean.MessageBean;
import Ansin.web.entity.A0803ListEntity;
import Ansin.web.entity.MessageEntity;
import Ansin.web.entity.UserTblEntity;
import Ansin.web.mapper.MessageTblMapper;
import Ansin.web.mapper.UserTblMapper;
import Ansin.web.service.B0901Service;
import Ansin.web.util.EditUtil;
import Ansin.web.vueForm.A0803VueForm;

@Service
public class IB0901ServiceImpl implements B0901Service{
	
	@Autowired
	private MessageTblMapper messageTblMapper;
	@Autowired
	private UserTblMapper userTblMapper;
	
	/**
	 * 会社資産情報取得
	 * @param companyId
	 * @return B0801Bean
	 */
	@Override
	public List<A0803Bean> select(A0803VueForm a0803VueForm) {
		
		List<A0803ListEntity> a0802ListEntities = messageTblMapper.getSelect(a0803VueForm);
		//出力
		List<A0803Bean> beans = new ArrayList<A0803Bean>();
		//編集
		for (A0803ListEntity entity : a0802ListEntities) {
			A0803Bean bean = new A0803Bean();
			BeanUtils.copyProperties(entity, bean);
			bean.setName(entity.getFirstName() + " " + entity.getLastName());
			bean.setaDate(EditUtil.timeStampUtil(entity.getaDate()));
			bean.setInternalMessageId(EditUtil.intUtil(entity.getInternalMessageId()));
			beans.add(bean);
		}
		return beans;
	}
	
	/**
	 * 受信詳細取得
	 * @param a0803VueForm
	 * @return MessageBean
	 */
	@Override
	public MessageBean getMessage(A0803VueForm a0803VueForm, Integer userCd) {
		MessageEntity messageEntity = messageTblMapper.getMessage(a0803VueForm);
		if(messageEntity != null) {
			MessageBean bean = new MessageBean();
			BeanUtils.copyProperties(messageEntity, bean);
			bean.setInternalMessageId(EditUtil.intUtil(messageEntity.getInternalMessageId()));
			bean.setInternalMessageTextId(EditUtil.intUtil(messageEntity.getInternalMessageTextId()));
			bean.setRecId(EditUtil.intUtil(messageEntity.getRecId()));
			bean.setSendId(EditUtil.intUtil(messageEntity.getSendId()));
			bean.setTimeString(EditUtil.timeStampUtil(messageEntity.getTimeString()));
			//普通送信の時
			if(messageEntity.getRecId() != 0) {
				UserTblEntity user1 = userTblMapper.getName(messageEntity.getRecId());
				bean.setrName(user1.getFirstName() + " " + user1.getLastName());
				UserTblEntity user2 = userTblMapper.getName(messageEntity.getSendId());
				bean.setsName(user2.getFirstName() + " " + user2.getLastName());
				//メッセージ状態変更
				if(messageEntity.getStutsFlg().equals("0")) {	
					messageTblMapper.flgChange(a0803VueForm.getUserCd(),messageEntity.getInternalMessageId());
				}
			}else {
				//システム送信の時
				UserTblEntity user1 = userTblMapper.getName(userCd);
				bean.setrName(user1.getFirstName() + " " + user1.getLastName());
				UserTblEntity user2 = userTblMapper.getName(messageEntity.getSendId());
				bean.setsName(user2.getFirstName() + " " + user2.getLastName());
			}
			
			return bean;
		}
		return null;
	}

}
