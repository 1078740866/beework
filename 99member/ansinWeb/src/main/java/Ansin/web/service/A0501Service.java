package Ansin.web.service;

import java.util.List;

import Ansin.web.bean.A0501Bean;
import Ansin.web.bean.AdTblBean;
import Ansin.web.vueForm.A0501VueForm;

public interface A0501Service {
	
	//広告リスト取得
	List<A0501Bean> getAll(A0501VueForm a0501VueForm);
	
	//一つ広告取得
	AdTblBean getOne(Integer adId);
	
	//単数削除または複数削除
	Integer delete(List<Integer> adIds,Integer userCd);
	
}
