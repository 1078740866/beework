package Ansin.web.service;

import java.util.List;

import Ansin.web.bean.A0201ListBean;
import Ansin.web.bean.IndustryMstBean;
import Ansin.web.bean.JobtypeMstBean;
import Ansin.web.bean.LanMstBean;
import Ansin.web.bean.PrefecturesMstBean;
import Ansin.web.vueForm.A0201VueForm;

public interface A0201Service {
	/**
	 * 管理者一覧初期表示
	 * @param a0301VueForm
	 * @return List<UserTblBean>
	 */
	List<A0201ListBean> getApplicantList(A0201VueForm a0201VueForm);
	
	List<LanMstBean> getLanList();
	
	List<IndustryMstBean> getIndustryList();
	
	List<JobtypeMstBean> getJobtypeList();
	
	List<PrefecturesMstBean> getPrefeList();
	
	Integer delete(List<Integer> applicantIds);
}
