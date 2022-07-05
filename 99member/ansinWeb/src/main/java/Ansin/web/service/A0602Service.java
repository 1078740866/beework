package Ansin.web.service;

import Ansin.web.bean.BriefingInfoTblBean;
import Ansin.web.bean.PositionTblBean;
import Ansin.web.bean.TrainingInfoTblBean;

public interface A0602Service {
	
	//A0602_職位データ取得
	PositionTblBean getPosition(Integer positionId);

	//A0602_職位データ取得
	TrainingInfoTblBean getTraining(Integer trainingId);

	//A0602_職位データ取得
	BriefingInfoTblBean getBriefing(Integer briefingId);

	
}
