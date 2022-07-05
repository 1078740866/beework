package Ansin.web.service;

import java.util.List;

import Ansin.web.bean.A0803Bean;
import Ansin.web.bean.MessageBean;
import Ansin.web.vueForm.A0803VueForm;

public interface B0901Service {

	// 会社受信情報取得
	List<A0803Bean> select(A0803VueForm a0803VueForm);
	
	 //一つメッセージ情報取得
	MessageBean getMessage(A0803VueForm a0803VueForm,Integer userCd);
	
	
}
