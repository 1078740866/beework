package Ansin.web.service;

import java.util.List;

import Ansin.web.bean.IndustryMstBean;
import Ansin.web.bean.TrainingInfoTblBean;
import Ansin.web.vueForm.B0501VueForm;

public interface B0501Service {

	// 研修情報を取得
	List<TrainingInfoTblBean> getAllTrainingInitCount(B0501VueForm trainingEntity);
	// 研修情報の削除または複数削除
	int update(List<Integer> trainingIdList,Integer companyId,Integer userCd);
	// 全部業種を取得
	List<IndustryMstBean> getAllIndustry();
	
	
}
