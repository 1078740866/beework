package Ansin.web.serviceimpl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ansin.web.entity.UserTblEntity;
import Ansin.web.mapper.UserTblMapper;
import Ansin.web.service.C0002Service;
import Ansin.web.util.EditUtil;
import Ansin.web.util.MD5Util;
import Ansin.web.vueForm.A0002VueForm;

@Service
public class IC0002ServiceImpl implements C0002Service{
	
		@Autowired
		private UserTblMapper userTblMapper;
		
		/**
		 *  メール存在チェック
		 * @param userEmail
		 * @return int
		 */
		@Override
		public Integer checkEmail(String userEmail) {
			return userTblMapper.userEmailCheck(userEmail);
		}
		
		/**
		 * ユーザーデータを挿入
		 * @param companyInfoEntity
		 */
		@Override
		public int insertUserInfo(UserTblEntity userEntity) {
			return userTblMapper.insertUserInfo(userEntity);
		}
		
		/**
		 *　ユーザー情報編集する
		 * @param companyInfo
		 * @return userEntity
		 */
		public UserTblEntity editUserInfo(A0002VueForm a0002VueForm){

			UserTblEntity userEntity = new UserTblEntity();
			
			if (a0002VueForm != null) {
				BeanUtils.copyProperties(a0002VueForm, userEntity);
				userEntity.setAuthority("応募者");
				userEntity.setCompanyId(99999999);
				userEntity.setCountryZip(EditUtil.intUtil(a0002VueForm.getCountryZip()));
				userEntity.setPwd(MD5Util.md5Util(a0002VueForm.getPwd()));
				userEntity.setPhotoAddress(a0002VueForm.getPhotoAddress());
			}
			return userEntity;
		}

}
