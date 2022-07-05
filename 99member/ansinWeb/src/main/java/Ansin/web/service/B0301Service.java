package Ansin.web.service;

import java.util.List;

import Ansin.web.bean.ApplicantRecommendInitBean;
import Ansin.web.bean.B0301Bean;
import Ansin.web.vueForm.B0301VueForm;


public interface B0301Service {
	
	/**
	 * 画面初期化情報を取得
	 * @return
	 */ 
	ApplicantRecommendInitBean getApplicantRecommendInitResponse();
	
	/**
	 * B0301一覧リスト
	 * @param b0301VueForm
	 * @return
	 */
	List<B0301Bean> getAll(B0301VueForm b0301VueForm);
}
