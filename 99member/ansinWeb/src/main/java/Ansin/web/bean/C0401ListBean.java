package Ansin.web.bean;

import java.util.List;

public class C0401ListBean {
		
		//C0401説明会推薦一覧リスト
		private List<BriefingInfoTblBean> getBriefing;
		//C0401説明会応募済み一覧リスト
		private List<BriefingInfoTblBean> getBriefingPost;
		//C0401説明会気に入る一覧リスト
		private List<BriefingInfoTblBean> getBriefingLike;
		//C0401初期都道県選択リストを取得
		private List<PrefecturesMstBean> prefecturesMstBean;
		//履歴有無状態（0：有、１：なし）
		private String statusFlg;
		public List<BriefingInfoTblBean> getGetBriefing() {
			return getBriefing;
		}
		public void setGetBriefing(List<BriefingInfoTblBean> getBriefing) {
			this.getBriefing = getBriefing;
		}
		public List<BriefingInfoTblBean> getGetBriefingPost() {
			return getBriefingPost;
		}
		public void setGetBriefingPost(List<BriefingInfoTblBean> getBriefingPost) {
			this.getBriefingPost = getBriefingPost;
		}
		public List<BriefingInfoTblBean> getGetBriefingLike() {
			return getBriefingLike;
		}
		public void setGetBriefingLike(List<BriefingInfoTblBean> getBriefingLike) {
			this.getBriefingLike = getBriefingLike;
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
