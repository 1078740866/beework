package Ansin.web.vueForm;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public class B0601VueForm {
	
	//会社ID
	private Integer companyId;
	//ユーザーコード
	private Integer userCd;
	// 説明会方式
	private String briefingType;
	//説明会日付
	private Date briefingDate;
	// 開始時刻
	private Time dateFrom;
	// 終了時刻
	private Time dateTo;
	// 確認状態
	private String statusFlg;
	// 説明会IDLIST
	private List<Integer> briefingIds;
	//説明会名検索
	private String briefingNm;
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	public Integer getUserCd() {
		return userCd;
	}
	public void setUserCd(Integer userCd) {
		this.userCd = userCd;
	}
	public String getBriefingType() {
		return briefingType;
	}
	public void setBriefingType(String briefingType) {
		this.briefingType = briefingType;
	}
	public Date getBriefingDate() {
		return briefingDate;
	}
	public void setBriefingDate(Date briefingDate) {
		this.briefingDate = briefingDate;
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
	public String getStatusFlg() {
		return statusFlg;
	}
	public void setStatusFlg(String statusFlg) {
		this.statusFlg = statusFlg;
	}
	public List<Integer> getBriefingIds() {
		return briefingIds;
	}
	public void setBriefingIds(List<Integer> briefingIds) {
		this.briefingIds = briefingIds;
	}
	public String getBriefingNm() {
		return briefingNm;
	}
	public void setBriefingNm(String briefingNm) {
		this.briefingNm = briefingNm;
	}
	@Override
	public String toString() {
		return "B0601VueForm [companyId=" + companyId + ", userCd=" + userCd + ", briefingType=" + briefingType
				+ ", briefingDate=" + briefingDate + ", dateFrom=" + dateFrom + ", dateTo=" + dateTo + ", statusFlg="
				+ statusFlg + ", briefingIds=" + briefingIds + ", briefingNm= " + briefingNm + "]";
	}


}
