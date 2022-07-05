package Ansin.web.serviceimpl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ansin.web.entity.UserTblEntity;
import Ansin.web.mapper.UserTblMapper;
import Ansin.web.service.B0001Service;
import Ansin.web.vueForm.A0001VueForm;

@Service
public class IB0001ServiceImpl implements B0001Service{

	@Autowired
	private UserTblMapper userTblMapper;

	/**
	 * 登録チェック用
	 * @param mail
	 * @param password
	 * @return user
	 */
	@Override
	public UserTblEntity loginCheck(A0001VueForm a0001VueForm) {
		// 登録チェック
    	UserTblEntity user = userTblMapper.loginB(a0001VueForm);

    	return user;
	}

	/**
	 * user情報取得
	 * @param mail
	 * @param password
	 * @return user
	 */
	public UserTblEntity findByMail(String mail) {
		// 登録チェック
    	UserTblEntity user = userTblMapper.getUserInfoBymail(mail);
    	return user;
	}

	public Set<String> findPermissions(String mail) {
		Set<String> permissions = new HashSet<>();
		permissions.add("sys:user:view");
		permissions.add("sys:user:add");
		permissions.add("sys:user:edit");
		permissions.add("sys:user:delete");
		return permissions;
	}

}