package Ansin.web.vueForm;

import java.sql.Time;
import java.util.List;

import Ansin.web.entity.IdListEntity;

public class A070105VueForm {
			//userCd
			private Integer userCd;
			//説明会名
			private String briefingNm;
			//会社名
			private String companyNm;
			//説明会方式
			private String briefingType;
			private String dateFromString;
			private String dateToString;
			//日付FROM
			private Time dateFrom;	
			//日付TO
			private Time dateTo;
			//都道府県
			private String	prefeNm;
			//説明会ID
			private List<IdListEntity> listData;
			//確認状態
			private String statusFlg;
			
			public String getBriefingNm() {
				return briefingNm;
			}
			public void setBriefingNm(String briefingNm) {
				this.briefingNm = briefingNm;
			}
			public String getCompanyNm() {
				return companyNm;
			}
			public void setCompanyNm(String companyNm) {
				this.companyNm = companyNm;
			}
			public String getBriefingType() {
				return briefingType;
			}
			public void setBriefingType(String briefingType) {
				this.briefingType = briefingType;
			}

			public String getPrefeNm() {
				return prefeNm;
			}
			public void setPrefeNm(String prefeNm) {
				this.prefeNm = prefeNm;
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
			public String getDateFromString() {
				return dateFromString;
			}
			public void setDateFromString(String dateFromString) {
				this.dateFromString = dateFromString;
			}
			public String getDateToString() {
				return dateToString;
			}
			public void setDateToString(String dateToString) {
				this.dateToString = dateToString;
			}
			public Time getDateFrom() {
				return dateFrom;
			}
			public void setDateFrom(Time dateFrom) {
				this.dateFrom = dateFrom;
			}
			public Time getDateTo() {
				return dateTo;
			}
			public void setDateTo(Time dateTo) {
				this.dateTo = dateTo;
			}
			
			
			
			
}
