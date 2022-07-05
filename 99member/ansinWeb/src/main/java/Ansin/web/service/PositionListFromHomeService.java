package Ansin.web.service;

import java.io.IOException;
import java.util.List;

import Ansin.web.bean.CompanyAndUserBean;
import Ansin.web.bean.PositionListFromHomeBean;
import Ansin.web.vueForm.HomeVueForm;

public interface PositionListFromHomeService {

	// 検索ボタンをクリックして、職位情報を取得
	List<PositionListFromHomeBean> getPositionBySearchIdResponse(HomeVueForm homeVueForm);
	
	//会社情報を取得
	CompanyAndUserBean getCompanyById(Integer companyId);
	
	// 取得会社LOGO編集
	CompanyAndUserBean confirmOutput(CompanyAndUserBean bean) throws IOException;
	
	// 会社の職位情報を取得
	List<PositionListFromHomeBean> getPositionByCompany(Integer companyId);
	
	
}
