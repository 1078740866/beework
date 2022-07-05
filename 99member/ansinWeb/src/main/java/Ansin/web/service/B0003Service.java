package Ansin.web.service;

import java.io.IOException;
import java.util.List;

import Ansin.web.bean.B0301Bean;
import Ansin.web.bean.ComChargeBean;
import Ansin.web.bean.UserInfoBean;

public interface B0003Service {

	//未処理件数
	String getCount(Integer companyId);
	//ユーザー情報取得
	ComChargeBean getUser(Integer userCd,Integer companyId);
	//人材推薦リスト取得
	List<B0301Bean> getList(Integer companyId);
	
	ComChargeBean confirmOutput(ComChargeBean comChargeBean) throws IOException;
	
	B0301Bean confirmOutput(B0301Bean b0301Bean) throws IOException;
	
}
