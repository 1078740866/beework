package Ansin.web.service;

import java.util.List;

import Ansin.web.bean.BriefingApplTblBean;
import Ansin.web.vueForm.B0603VueForm;

public interface B0603Service {

	// 説明会応募者リストを取得
	List<BriefingApplTblBean> getBriefingApplEntities(B0603VueForm b0603VueForm);
	
}
