package Ansin.web.vueForm;

import java.util.List;

import Ansin.web.entity.IdListEntity;

public class A070104VueForm {
	
		//userCd
		private Integer userCd;
		//研修名
		private String trainingNm;
		//会社名
		private String companyNm;
		//都道府県
		private String	prefeNm;
		//業種ID
		private Integer	industryId;
		//業種名
		private String industryNm;
		//確認状態
		private String statusFlg;
		//研修ID
		private List<IdListEntity> listData;
		public String getTrainingNm() {
			return trainingNm;
		}
		public void setTrainingNm(String trainingNm) {
			this.trainingNm = trainingNm;
		}
		public String getCompanyNm() {
			return companyNm;
		}
		public void setCompanyNm(String companyNm) {
			this.companyNm = companyNm;
		}
		public String getPrefeNm() {
			return prefeNm;
		}
		public void setPrefeNm(String prefeNm) {
			this.prefeNm = prefeNm;
		}
		public Integer getIndustryId() {
			return industryId;
		}
		public void setIndustryId(Integer industryId) {
			this.industryId = industryId;
		}
		public String getIndustryNm() {
			return industryNm;
		}
		public void setIndustryNm(String industryNm) {
			this.industryNm = industryNm;
		}
		public List<IdListEntity> getListData() {
			return listData;
		}
		public void setListData(List<IdListEntity> listData) {
			this.listData = listData;
		}
		public Integer getUserCd() {
			return userCd;
		}
		public void setUserCd(Integer userCd) {
			this.userCd = userCd;
		}
		public String getStatusFlg() {
			return statusFlg;
		}
		public void setStatusFlg(String statusFlg) {
			this.statusFlg = statusFlg;
		}
		
		
}
