package Ansin.web.service;

import java.util.List;

import Ansin.web.bean.UserInfoBean;
import Ansin.web.vueForm.A070101VueForm;

public interface A070101Service {
		
		//B0805未認証会社員取得
		List<UserInfoBean> getEmployeeAll(Integer companyId, A070101VueForm a070101VueForm);
		
		//すべてユーザー取得
		List<UserInfoBean> getAll(A070101VueForm a070101VueForm);
		
		//未認証ユーザーから単数承認または複数承認（システム管理者）
		Integer updateUserStatusA(List<Integer> userCdList, Integer userCd);
		
		//未認証ユーザーから単数承認または複数承認（会社会員）
		Integer updateUserStatusC(List<Integer> userCdList,  Integer userCd);
		
		//未認証ユーザーから単数承認または複数拒否（すべて拒否）
		Integer rejectUserStatus(List<Integer> userCdList, Integer userCd);


}
