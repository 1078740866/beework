package Ansin.web.service;

import java.util.List;

import Ansin.web.bean.IndustryMstBean;
import Ansin.web.bean.JobtypeMstBean;
import Ansin.web.bean.PositionTblBean;
import Ansin.web.bean.PrefecturesMstBean;
import Ansin.web.vueForm.C0201ListVueForm;
import Ansin.web.vueForm.C0201VueForm;

public interface C0201Service {
	
	//C0201初期業種選択リストを取得
	List<IndustryMstBean> getAllIndustry();
	//C0201初期職種選択リストを取得
	List<JobtypeMstBean> getAllJobtype();
	//C0201初期都道県選択リストを取得
	List<PrefecturesMstBean> getPreAndCity();
	//C0201職位推薦
    List<PositionTblBean> getRecommend(Integer userCd);
    //C0201職位一覧
    List<PositionTblBean> getList(C0201ListVueForm c0201ListVueForm);
    
    //C0201応募済み一覧
    List<PositionTblBean> getPost(C0201ListVueForm c0201ListVueForm);
    
    //C0201職位気に入る一覧
    List<PositionTblBean> getLike(C0201ListVueForm c0201ListVueForm);
    
    //取得userCd
    Integer getAppId(Integer userCd);
    
    //C0201応募テーブルに応募済みを追加
  	Integer insertPost(List<C0201VueForm> c0201VueForm);
  	
  	//C0201応募テーブルに気に入るを追加
  	Integer insertLike(List<C0201VueForm> c0201VueForm);
  	
  	//C0201単数または複数気に入る
  	Integer updateLike(List<C0201VueForm> c0201VueForm,Integer userCd,Integer applicantId);
  	
  	//C0201単数または複数削除
  	Integer deleteApplication(List<C0201VueForm> c0201VueForm,Integer userCd,Integer applicantId);
}
