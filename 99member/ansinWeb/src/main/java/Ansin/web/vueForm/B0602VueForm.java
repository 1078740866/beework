package Ansin.web.vueForm;

import java.sql.Time;
import java.util.Date;

public class B0602VueForm {
	
	//ユーザーコード
	private Integer userCd;
	//説明会ID
	private Integer briefingId;
	//会社ID
	private Integer companyId;
	//説明会名
	private String briefingNm;
	//説明会方式
	private String briefingType;
	//説明会日付
	private Date briefingDate;
	//開始時刻
	private Time dateFrom;
	//終了時刻
	private Time dateTo;
	//郵便番号
	private String postal;
	//都道府県名
	private String prefeNm;
	//説明会場所1
	private String briefingAddress1;
	//説明会場所2
	private String briefingAddress2;
	//説明会内容
	private String briefingContent;
	//予定人数
	private Integer proCntPlan;
	//講師氏名
	private String teaNm;
	//講師説明
	private String teaIntro;
	//連絡先
	private String tel;
	//担当
	private String charge;
	//会社画像1
	private String photoAddress1;
	//会社画像2
	private String photoAddress2;
	//会社画像3
	private String photoAddress3;
	//確認状態
	private String statusFlg;
	//備考
	private String remarks;
	//使用状態
	private String useFlg;
	
	
	public Integer getUserCd() {
		return userCd;
	}
	public void setUserCd(Integer userCd) {
		this.userCd = userCd;
	}
	public Integer getBriefingId() {
		return briefingId;
	}
	public void setBriefingId(Integer briefingId) {
		this.briefingId = briefingId;
	}
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	public String getBriefingNm() {
		return briefingNm;
	}
	public void setBriefingNm(String briefingNm) {
		this.briefingNm = briefingNm;
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
	public String getPostal() {
		return postal;
	}
	public void setPostal(String postal) {
		this.postal = postal;
	}
	public String getPrefeNm() {
		return prefeNm;
	}
	public void setPrefeNm(String prefeNm) {
		this.prefeNm = prefeNm;
	}
	public String getBriefingAddress1() {
		return briefingAddress1;
	}
	public void setBriefingAddress1(String briefingAddress1) {
		this.briefingAddress1 = briefingAddress1;
	}
	public String getBriefingAddress2() {
		return briefingAddress2;
	}
	public void setBriefingAddress2(String briefingAddress2) {
		this.briefingAddress2 = briefingAddress2;
	}
	public String getBriefingContent() {
		return briefingContent;
	}
	public void setBriefingContent(String briefingContent) {
		this.briefingContent = briefingContent;
	}
	public Integer getProCntPlan() {
		return proCntPlan;
	}
	public void setProCntPlan(Integer proCntPlan) {
		this.proCntPlan = proCntPlan;
	}
	public String getTeaNm() {
		return teaNm;
	}
	public void setTeaNm(String teaNm) {
		this.teaNm = teaNm;
	}
	public String getTeaIntro() {
		return teaIntro;
	}
	public void setTeaIntro(String teaIntro) {
		this.teaIntro = teaIntro;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getCharge() {
		return charge;
	}
	public void setCharge(String charge) {
		this.charge = charge;
	}
	public String getPhotoAddress1() {
		return photoAddress1;
	}
	public void setPhotoAddress1(String photoAddress1) {
		this.photoAddress1 = photoAddress1;
	}
	public String getPhotoAddress2() {
		return photoAddress2;
	}
	public void setPhotoAddress2(String photoAddress2) {
		this.photoAddress2 = photoAddress2;
	}
	public String getPhotoAddress3() {
		return photoAddress3;
	}
	public void setPhotoAddress3(String photoAddress3) {
		this.photoAddress3 = photoAddress3;
	}
	public String getStatusFlg() {
		return statusFlg;
	}
	public void setStatusFlg(String statusFlg) {
		this.statusFlg = statusFlg;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getUseFlg() {
		return useFlg;
	}
	public void setUseFlg(String useFlg) {
		this.useFlg = useFlg;
	}
	@Override
	public String toString() {
		return "B0602VueForm [userCd=" + userCd + ", briefingId=" + briefingId + ", companyId=" + companyId
				+ ", briefingNm=" + briefingNm + ", briefingType=" + briefingType + ", briefingDate=" + briefingDate
				+ ", dateFrom=" + dateFrom + ", dateTo=" + dateTo + ", postal=" + postal + ", prefeNm=" + prefeNm
				+ ", briefingAddress1=" + briefingAddress1 + ", briefingAddress2=" + briefingAddress2
				+ ", briefingContent=" + briefingContent + ", proCntPlan=" + proCntPlan + ", teaNm=" + teaNm
				+ ", teaIntro=" + teaIntro + ", tel=" + tel + ", charge=" + charge + ", photoAddress1=" + photoAddress1
				+ ", photoAddress2=" + photoAddress2 + ", photoAddress3=" + photoAddress3 + ", statusFlg=" + statusFlg
				+ ", remarks=" + remarks + ", useFlg=" + useFlg + "]";
	}
	
	
}
