package Ansin.web.service;

import java.util.List;

import Ansin.web.bean.IndustryMstBean;
import Ansin.web.vueForm.B0502VueForm;

public interface B0502Service {

	// 画面初期化情報を取得
	List<IndustryMstBean> getIndustryAll();
	// 市区町村を取得
	List<String> getPostaOne(String postal);
	// 都道府県名を取得
	String getPrefeNm(String postal);
	// 研修情報を改修
	int specificsUpdate(B0502VueForm trainingEntity);
	// 研修情報を新規
	int specificsInsert(B0502VueForm trainingEntity);
	
}
