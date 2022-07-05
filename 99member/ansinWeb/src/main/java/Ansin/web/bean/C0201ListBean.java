package Ansin.web.bean;

import java.util.List;

public class C0201ListBean {
		//C0201職位推薦一覧リスト
		private List<PositionTblBean> getAll;
		//C0201職位推薦応募済み一覧リスト
		private List<PositionTblBean> getPost;
		//C0201職位推薦気に入る一覧リスト
		private List<PositionTblBean> getLike;
		//C010101初期業種選択リストを取得
		private List<IndustryMstBean> industryMstBean;
		//C010101初期職種選択リストを取得
		private List<JobtypeMstBean> jobtypeMstBean;
		//C010101初期都道県選択リストを取得
		private List<PrefecturesMstBean> prefecturesMstBean;
		//履歴有無状態（0：有、１：なし）
		private String statusFlg;
		public List<PositionTblBean> getGetAll() {
			return getAll;
		}
		public void setGetAll(List<PositionTblBean> getAll) {
			this.getAll = getAll;
		}
		public List<PositionTblBean> getGetPost() {
			return getPost;
		}
		public void setGetPost(List<PositionTblBean> getPost) {
			this.getPost = getPost;
		}
		public List<PositionTblBean> getGetLike() {
			return getLike;
		}
		public void setGetLike(List<PositionTblBean> getLike) {
			this.getLike = getLike;
		}
		public List<IndustryMstBean> getIndustryMstBean() {
			return industryMstBean;
		}
		public void setIndustryMstBean(List<IndustryMstBean> industryMstBean) {
			this.industryMstBean = industryMstBean;
		}
		public List<JobtypeMstBean> getJobtypeMstBean() {
			return jobtypeMstBean;
		}
		public void setJobtypeMstBean(List<JobtypeMstBean> jobtypeMstBean) {
			this.jobtypeMstBean = jobtypeMstBean;
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
