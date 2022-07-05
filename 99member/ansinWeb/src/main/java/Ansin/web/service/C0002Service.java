package Ansin.web.service;

import Ansin.web.entity.UserTblEntity;

public interface C0002Service {
	/**
	 * ユーザー新規	
	 * @param c0002VueForm
	 * @return int
	 */
	int insertUserInfo(UserTblEntity userEntity);
	/**
	 *  メール存在チェック
	 * @param userEmail
	 * @return int
	 */
	Integer checkEmail(String userEmail);
}
