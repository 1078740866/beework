package Ansin.web.service;

import java.util.List;

import Ansin.web.bean.BriefingInfoTblBean;
import Ansin.web.bean.PrefecturesMstBean;
import Ansin.web.vueForm.C0401ListVueForm;
import Ansin.web.vueForm.C0401VueForm;

public interface C0401Service {
			
			//C0401初期都道県選択リストを取得
			List<PrefecturesMstBean> getPreAndCity();
			
			//C0401説明会推薦一覧リスト
			List<BriefingInfoTblBean> getBriefing(Integer userCd);
			
			//C0401説明会検索ボタン押下リスト
			List<BriefingInfoTblBean> getList(C0401ListVueForm c0401ListVueForm);
			
			//C0401説明会応募済み一覧リスト
			List<BriefingInfoTblBean> getBriefingPost(C0401ListVueForm c0401ListVueForm);
			
			//C0401説明会気に入る一覧リスト
			List<BriefingInfoTblBean> getBriefingLike(C0401ListVueForm c0401ListVueForm);
			
			//取得userCd
		    Integer getAppId(Integer userCd);
		    
		    //C0401説明会応募者テーブルに応募済みを追加
			Integer insertPost(List<C0401VueForm> c0401VueForm);
			
			//C0401説明会応募者テーブルに気に入るを追加
			Integer insertLike(List<C0401VueForm> c0401VueForm);
			
			//C0401説明会応募者テーブルに単数または複数気に入るを更新する
			Integer updateLike(List<C0401VueForm> c0401VueForm,Integer userCd,Integer applicantId);
			
			//C0401説明会応募者テーブルに単数または複数削除する
			Integer deleteBriefingAppl(List<C0401VueForm> c0401VueForm,Integer userCd,Integer applicantId);
}
