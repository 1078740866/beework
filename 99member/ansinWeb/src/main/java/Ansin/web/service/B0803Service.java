package Ansin.web.service;

import Ansin.web.bean.CompanyInfoBean;
import Ansin.web.vueForm.B0803VueForm;

public interface B0803Service {

	// チャージ時会社情報取得
	CompanyInfoBean getCompany(Integer companyId);
	
	// チャージ
	Integer getCharge(B0803VueForm b0803VueForm);
	
}
