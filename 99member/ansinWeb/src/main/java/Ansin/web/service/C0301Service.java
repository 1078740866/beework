package Ansin.web.service;

import java.util.List;

import Ansin.web.bean.IndustryMstBean;
import Ansin.web.bean.PrefecturesMstBean;
import Ansin.web.bean.TrainingInfoTblBean;
import Ansin.web.vueForm.C0301ListVueForm;
import Ansin.web.vueForm.C0301VueForm;

public interface C0301Service {
		
		//C0301初期業種選択リストを取得
		List<IndustryMstBean> getAllIndustry();
		
		//C0301初期都道県選択リストを取得
		List<PrefecturesMstBean> getPreAndCity();
		
		//C0301検索ボタン押下リスト
		List<TrainingInfoTblBean> getList(C0301ListVueForm c0301ListVueForm);
		
		//C0301研修推薦一覧リスト
		List<TrainingInfoTblBean> getTraining(Integer userCd);
		
		//C0301研修応募済み一覧リスト
		List<TrainingInfoTblBean> getTrainingPost(C0301ListVueForm c0301ListVueForm);
		
		//C0301研修気に入る一覧リスト
		List<TrainingInfoTblBean> getTrainingLike(C0301ListVueForm c0301ListVueForm);	
		
		//取得userCd
	    Integer getAppId(Integer userCd);
		
	    //C0301研修応募者テーブルに応募済みを追加
		Integer insertPost(List<C0301VueForm> c0301VueForm);
		
		//C0301研修応募者テーブルに気に入るを追加
		Integer insertLike(List<C0301VueForm> c0301VueForm);
		
		//C0301研修応募者テーブルに単数または複数気に入るを更新する
		Integer updateLike(List<C0301VueForm> c0301VueForm,Integer userCd,Integer applicantId);
		
		//C0301研修応募者テーブルに単数または複数削除する
		Integer deleteTrainingAppl(List<C0301VueForm> c0301VueForm,Integer userCd,Integer applicantId);
}
