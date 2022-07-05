package Ansin.web.service;

import java.io.IOException;
import java.util.List;

import Ansin.web.bean.BriefingInfoTblBean;
import Ansin.web.vueForm.B0602VueForm;

public interface B0602Service {

	// 都道府県と所属市区町村を取得
	 List<String> getPostaOne(String postal);
	// 説明会情報を追加
	int insert(B0602VueForm briefingEntity);
	// 説明会情報を更新
	int update(B0602VueForm briefingEntity);
	// 都道府県名を取得
	String getPrefeNm(String postal);
	
	BriefingInfoTblBean confirmOutput(BriefingInfoTblBean briefingInfoTblBean) throws IOException;
	
}
