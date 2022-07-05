package Ansin.web.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ansin.web.entity.UserTblEntity;
import Ansin.web.mapper.UserTblMapper;
import Ansin.web.service.UserService;

@Service
public class IUserServiceImpl implements UserService{

	@Autowired
	private UserTblMapper userTblMapper;

	@Override
	public Integer updateUserPwdW(UserTblEntity userEntity) {
		Integer updateUserInfo = userTblMapper.updateUserPwdW(userEntity);
		return updateUserInfo;
	}
}
