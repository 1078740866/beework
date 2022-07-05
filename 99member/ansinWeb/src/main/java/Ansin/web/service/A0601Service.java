package Ansin.web.service;

import java.io.IOException;
import java.util.List;

import Ansin.web.bean.A0601ListBean;
import Ansin.web.vueForm.A0601VueForm;

public interface A0601Service {
	
	//通報一覧情報取得
	List<A0601ListBean> getAll(A0601VueForm a0601VueForm);
	
	//通報処理(職位)
	Integer getSection(A0601VueForm a0601VueForm);
	
	//通報のスクリーンショット転換
	List<A0601ListBean> confirmOutput(List<A0601ListBean> bean) throws IOException;
	
	//通報データ件数を取得
	String getCount(A0601VueForm a0601VueForm);
		
}
