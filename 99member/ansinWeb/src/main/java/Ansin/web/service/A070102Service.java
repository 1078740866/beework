package Ansin.web.service;

import java.util.List;

import Ansin.web.bean.CompanyListBean;
import Ansin.web.bean.IndustryMstBean;
import Ansin.web.bean.PrefecturesMstBean;
import Ansin.web.vueForm.A070102VueForm;

public interface A070102Service {
	
	//A0701_02_承認一覧画面(会社)一覧リスト	
	List<CompanyListBean> getCompanyInfo(A070102VueForm a070102VueForm);
	
	//業種リスト
	List<IndustryMstBean> getIndustryMst();
	
	//都道府県リスト	
	List<PrefecturesMstBean> getPrefecturesMst();
	
	//A0701_02_承認一覧画面(会社)単数または複数承認、拒否
	Integer companyConfirmOrDeny(List<Integer> companyIdList,Integer userCd,String statusFlg);
	
}
