package Ansin.web.service;

import java.util.List;

import Ansin.web.bean.TrainingApplTblBean;
import Ansin.web.vueForm.B0503VueForm;

public interface B0503Service {
	
	// 研修応募者を取得
	List<TrainingApplTblBean> getTrainingAppl(B0503VueForm B0503VueForm);
	// 研修応募者を受け取れまたは拒否
	int applUpdateConfirmOrDeny(B0503VueForm b0503VueForm);
	
}
