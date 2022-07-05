package Ansin.web.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ansin.web.bean.A0301ListBean;
import Ansin.web.entity.UserTblEntity;
import Ansin.web.mapper.UserTblMapper;
import Ansin.web.service.A0301Service;
import Ansin.web.util.EditUtil;
import Ansin.web.vueForm.A0301VueForm;

@Service
public class IA0301ServiceImpl implements A0301Service{

	@Autowired
	private UserTblMapper userTblMapper;

	/**
	 * 管理者一覧初期表示
	 * @param a0301VueForm
	 * @return List<UserTblBean>
	 */
	@Override
	public List<A0301ListBean> getUserList(A0301VueForm a0301VueForm) {
		List<UserTblEntity> userTblEntity = userTblMapper.getUserList(a0301VueForm);
		List<A0301ListBean> bean = new ArrayList<A0301ListBean>();
		for (UserTblEntity user : userTblEntity) {
			A0301ListBean a0301ListBean = new A0301ListBean();
			BeanUtils.copyProperties(user, a0301ListBean);
			a0301ListBean.setSex("0".equals(user.getSex()) ? "男" : "女");
			a0301ListBean.setUserStatusCd(user.getUserStatus());
			a0301ListBean.setUserStatus("0".equals(user.getUserStatus()) ? "正常" : "禁止");
			a0301ListBean.setUserName(user.getFirstName() + " " + user.getLastName());
			a0301ListBean.setUpdateTime(EditUtil.timeStampUtil(user.getUpdateTime()));
			bean.add(a0301ListBean);
		}
		return bean;
	}

	/**
	 * 使用又は削除状態変更
	 * @param userCds
	 * @return List<UserTblBean>
	 */
	@Override
	public Integer changeUse(A0301VueForm a0301VueForm) {
		return userTblMapper.changeUse(a0301VueForm);
	}

	/**
	 * 削除状態変更
	 * @param userCds
	 * @return List<UserTblBean>
	 */
	@Override
	public Integer changeDel(A0301VueForm a0301VueForm) {
		a0301VueForm.setDelFlg("1");
		return userTblMapper.changeDel(a0301VueForm);
	}

}
