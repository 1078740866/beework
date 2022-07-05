package Ansin.web.service;

import java.util.List;

import Ansin.web.bean.AdTblBean;
import Ansin.web.bean.CompanyRegisterInitBean;
import Ansin.web.bean.LayoutMstBean;
import Ansin.web.entity.CompanyTblPopEntity;
import Ansin.web.vueForm.A0502VueForm;

public interface A0502Service {
	
	//広告リスト取得
	List<AdTblBean> getAll();
	
	//一つ広告取得
	AdTblBean getOne(Integer adId);
	
	//更新
	Integer update(A0502VueForm a0502VueForm);
	
	//登録
	Integer insert(A0502VueForm a0502VueForm);
	
	//レイアウトリスト取得
	List<LayoutMstBean> getLayoutAll();
	
	//検索状態更新できるのデータ
	List<Integer> getSelectFlg();
	
	//状態変更
	Integer updateFlg(List<Integer> lists);
	
	// 画面初期化情報を取得
	CompanyRegisterInitBean getCompanyRegisterInitResponse();
	// 検索条件通り、会社情報を取得
	List<CompanyTblPopEntity> selectCompanyInfo(String companyNm, String address1, Integer industryId1, String companyScale,Integer countryId);
	// 会社名通り、会社情報を取得
	List<CompanyTblPopEntity> selectCompanyInfo(String companyNm);
	
}
