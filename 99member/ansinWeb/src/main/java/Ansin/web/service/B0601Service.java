package Ansin.web.service;

import java.util.List;

import Ansin.web.bean.BriefingInfoTblBean;
import Ansin.web.vueForm.B0601VueForm;

public interface B0601Service {
	
	// 説明会情報を取得
	List<BriefingInfoTblBean> getBriefingInfoEntities(B0601VueForm b0601VueForm);
	// 説明会情報を削除
	int delBriefingInfoEntities(List<Integer> BriefingIds,Integer companyId,Integer userCd);
	
}
