package Ansin.web.service;

import java.util.List;
import java.io.IOException;

import Ansin.web.bean.CompanyRegisterInitBean;
import Ansin.web.entity.CompanyTblEntity;
import Ansin.web.entity.CompanyTblPopEntity;
import Ansin.web.entity.UserTblEntity;
import Ansin.web.vueForm.B0002VueForm;

public interface B0002Service {

	// 画面初期化情報を取得
	CompanyRegisterInitBean getCompanyRegisterInitResponse();
	// 会社データを挿入、ユーザーデータを挿入
	Integer insertCompanyInfo(CompanyTblEntity companyInfoEntity);
	Integer insertUserInfo(UserTblEntity userEntity);
	// 検索条件通り、会社情報を取得
	List<CompanyTblPopEntity> selectCompanyInfo(String companyNm, String address1, Integer industryId1, String companyScale,Integer countryId);
	// 会社名通り、会社情報を取得
	List<CompanyTblPopEntity> selectCompanyInfo(String companyNm);
	// 都道府県と所属市区町村を取得
	List<String> getPostaOne(String postal);
	// 都道府県を取得
	String getPrefeNm(String postal);
	// メール存在チェック
	Integer checkEmail(String userEmail);
	// 新規登録確認画面編集
	B0002VueForm confirmOutput(B0002VueForm b0002VueForm) throws IOException;

}
