package Ansin.web.service;

import java.util.List;

import Ansin.web.bean.IndustryMstBean;
import Ansin.web.bean.TrainingInfoTblBean;
import Ansin.web.vueForm.A020202VueForm;

public interface A020202Service {

	// 研修情報を取得
	List<TrainingInfoTblBean> getAllTrainingInitCount(A020202VueForm trainingEntity);
	// 研修情報の削除または複数削除
	Integer update(List<Integer> trainingIdList,Integer userCd,Integer applicantId);
	// 全部業種を取得
	List<IndustryMstBean> getAllIndustry();
	
	
}
