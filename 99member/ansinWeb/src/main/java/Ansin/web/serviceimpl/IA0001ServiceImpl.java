package Ansin.web.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ansin.web.entity.UserTblEntity;
import Ansin.web.mapper.UserTblMapper;
import Ansin.web.service.A0001Service;
import Ansin.web.vueForm.A0001VueForm;

@Service
public class IA0001ServiceImpl implements A0001Service{
	
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
    	UserTblEntity user = userTblMapper.loginA(a0001VueForm);

    	return user;
	}
	

}
