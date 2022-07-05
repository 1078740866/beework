package Ansin.web.service;

import java.io.IOException;
import java.util.List;

import Ansin.web.bean.CountryMstBean;
import Ansin.web.bean.UserInfoBean;
import Ansin.web.entity.UserTblEntity;
import Ansin.web.vueForm.A0902VueForm;
import Ansin.web.vueForm.B0002VueForm;

public interface A0901Service {
	
		//個人情報画面(システム管理者)
		UserInfoBean getUserInfoA(Integer userCd);
		//個人情報画面(会社員)
		UserInfoBean getUserInfoB(Integer userCd);
		//個人情報画面(応募者)
		UserInfoBean getUserInfoC(Integer userCd);
		//国番号を取得
		List<CountryMstBean> getAll();
		//個人情報を更新する
		Integer updateUserInfo(UserTblEntity userEntity);
		//パスワードを取得
		String getPassword(Integer userCd);
		//パスワードを更新
		Integer updateUserPassword(A0902VueForm a0902VueForm,Integer userCd);
		
		UserInfoBean confirmOutput(UserInfoBean usrInfoBean) throws IOException;

		
}
