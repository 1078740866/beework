package Ansin.web.service;

import java.util.List;

import Ansin.web.bean.BriefingInfoTblBean;
import Ansin.web.vueForm.A020203VueForm;

public interface A020203Service {
	
	// 説明会情報を取得
	List<BriefingInfoTblBean> getBriefingInfoEntities(A020203VueForm a020203VueForm);
	// 説明会情報を削除
	int delBriefingInfoEntities(List<Integer> BriefingIds,Integer applicantId,Integer userCd);
	
}
