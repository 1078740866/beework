package Ansin.web.bean;

import java.util.List;

public class ApplicantRecommendInitBean {
		
		//業種リストを定義
		private List<IndustryMstBean> industryList;
		//職種リストを定義
		private List<JobtypeMstBean> jobtypeList;
		//スキルリストを定義
		private List<SkillMstBean> skillList;
		//都道府県リストを定義
		private List<PrefecturesMstBean> prefecturesList;
		//言語リストを定義
		private List<LanMstBean> lanList;
		//人材推薦リスト
		private List<B0301Bean> b0301Beans;
		
		
		public List<IndustryMstBean> getIndustryList() {
			return industryList;
		}
		public void setIndustryList(List<IndustryMstBean> industryList) {
			this.industryList = industryList;
		}
		public List<JobtypeMstBean> getJobtypeList() {
			return jobtypeList;
		}
		public void setJobtypeList(List<JobtypeMstBean> jobtypeList) {
			this.jobtypeList = jobtypeList;
		}
		public List<SkillMstBean> getSkillList() {
			return skillList;
		}
		public void setSkillList(List<SkillMstBean> skillList) {
			this.skillList = skillList;
		}
		public List<PrefecturesMstBean> getPrefecturesList() {
			return prefecturesList;
		}
		public void setPrefecturesList(List<PrefecturesMstBean> prefecturesList) {
			this.prefecturesList = prefecturesList;
		}
		public List<LanMstBean> getLanList() {
			return lanList;
		}
		public void setLanList(List<LanMstBean> lanList) {
			this.lanList = lanList;
		}
		public List<B0301Bean> getB0301Beans() {
			return b0301Beans;
		}
		public void setB0301Beans(List<B0301Bean> b0301Beans) {
			this.b0301Beans = b0301Beans;
		}
		
		
}
