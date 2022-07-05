package Ansin.web.bean;

import java.util.List;

public class C0301ListBean {
	
			//C0301研修推薦一覧リスト
			private List<TrainingInfoTblBean> getTraining;
			//C0301研修応募済み一覧リスト
			private List<TrainingInfoTblBean> getTrainingPost;
			//C0301研修気に入る一覧リスト
			private List<TrainingInfoTblBean> getTrainingLike;
			//C0301初期業種選択リストを取得
			private List<IndustryMstBean> industryMstBean;
			//C0301初期都道県選択リストを取得
			private List<PrefecturesMstBean> prefecturesMstBean;
			//履歴有無状態（0：有、１：なし）
			private String statusFlg;
			
			public List<TrainingInfoTblBean> getGetTraining() {
				return getTraining;
			}
			public void setGetTraining(List<TrainingInfoTblBean> getTraining) {
				this.getTraining = getTraining;
			}
			public List<TrainingInfoTblBean> getGetTrainingPost() {
				return getTrainingPost;
			}
			public void setGetTrainingPost(List<TrainingInfoTblBean> getTrainingPost) {
				this.getTrainingPost = getTrainingPost;
			}
			public List<TrainingInfoTblBean> getGetTrainingLike() {
				return getTrainingLike;
			}
			public void setGetTrainingLike(List<TrainingInfoTblBean> getTrainingLike) {
				this.getTrainingLike = getTrainingLike;
			}
			public List<IndustryMstBean> getIndustryMstBean() {
				return industryMstBean;
			}
			public void setIndustryMstBean(List<IndustryMstBean> industryMstBean) {
				this.industryMstBean = industryMstBean;
			}
			public List<PrefecturesMstBean> getPrefecturesMstBean() {
				return prefecturesMstBean;
			}
			public void setPrefecturesMstBean(List<PrefecturesMstBean> prefecturesMstBean) {
				this.prefecturesMstBean = prefecturesMstBean;
			}
			public String getStatusFlg() {
				return statusFlg;
			}
			public void setStatusFlg(String statusFlg) {
				this.statusFlg = statusFlg;
			}
			
			
}
