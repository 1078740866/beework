package Ansin.web.bean;

import java.util.Arrays;

/**
 * 説明会Bean
 * @author楊卿赫
 * @date 2020-11-11 17:25:58
 */
public class BriefingInfoTblBean {
	
	//説明会ID
	private String briefingId;
	//会社ID
	private String companyId;
	//会社名
	private String companyNm;
	//説明会名
	private String briefingNm;
	//説明会方式
	private String briefingType;
	//説明会日付
	private String briefingDate;
	//開始時刻
	private String dateFrom;
	//終了時刻
	private String dateTo;
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
	private String proCntPlan;
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
	private byte[] photoAddress1Pic;
	//会社画像2
	private String photoAddress2;
	private byte[] photoAddress2Pic;
	//会社画像3
	private String photoAddress3;
	private byte[] photoAddress3Pic;
	//確認状態
	private String statusFlg;
	//備考
	private String remarks;
	//使用状態
	private String useFlg;
	public String getBriefingId() {
		return briefingId;
	}
	public void setBriefingId(String briefingId) {
		this.briefingId = briefingId;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getCompanyNm() {
		return companyNm;
	}
	public void setCompanyNm(String companyNm) {
		this.companyNm = companyNm;
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
	public String getBriefingDate() {
		return briefingDate;
	}
	public void setBriefingDate(String briefingDate) {
		this.briefingDate = briefingDate;
	}
	public String getDateFrom() {
		return dateFrom;
	}
	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}
	public String getDateTo() {
		return dateTo;
	}
	public void setDateTo(String dateTo) {
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
	public String getProCntPlan() {
		return proCntPlan;
	}
	public void setProCntPlan(String proCntPlan) {
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
	public byte[] getPhotoAddress1Pic() {
		return photoAddress1Pic;
	}
	public void setPhotoAddress1Pic(byte[] photoAddress1Pic) {
		this.photoAddress1Pic = photoAddress1Pic;
	}
	public String getPhotoAddress2() {
		return photoAddress2;
	}
	public void setPhotoAddress2(String photoAddress2) {
		this.photoAddress2 = photoAddress2;
	}
	public byte[] getPhotoAddress2Pic() {
		return photoAddress2Pic;
	}
	public void setPhotoAddress2Pic(byte[] photoAddress2Pic) {
		this.photoAddress2Pic = photoAddress2Pic;
	}
	public String getPhotoAddress3() {
		return photoAddress3;
	}
	public void setPhotoAddress3(String photoAddress3) {
		this.photoAddress3 = photoAddress3;
	}
	public byte[] getPhotoAddress3Pic() {
		return photoAddress3Pic;
	}
	public void setPhotoAddress3Pic(byte[] photoAddress3Pic) {
		this.photoAddress3Pic = photoAddress3Pic;
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
		return "BriefingInfoTblBean [briefingId=" + briefingId + ", companyId=" + companyId + ", companyNm=" + companyNm
				+ ", briefingNm=" + briefingNm + ", briefingType=" + briefingType + ", briefingDate=" + briefingDate
				+ ", dateFrom=" + dateFrom + ", dateTo=" + dateTo + ", postal=" + postal + ", prefeNm=" + prefeNm
				+ ", briefingAddress1=" + briefingAddress1 + ", briefingAddress2=" + briefingAddress2
				+ ", briefingContent=" + briefingContent + ", proCntPlan=" + proCntPlan + ", teaNm=" + teaNm
				+ ", teaIntro=" + teaIntro + ", tel=" + tel + ", charge=" + charge + ", photoAddress1=" + photoAddress1
				+ ", photoAddress1Pic=" + Arrays.toString(photoAddress1Pic) + ", photoAddress2=" + photoAddress2
				+ ", photoAddress2Pic=" + Arrays.toString(photoAddress2Pic) + ", photoAddress3=" + photoAddress3
				+ ", photoAddress3Pic=" + Arrays.toString(photoAddress3Pic) + ", statusFlg=" + statusFlg + ", remarks="
				+ remarks + ", useFlg=" + useFlg + ", getBriefingId()=" + getBriefingId() + ", getCompanyId()="
				+ getCompanyId() + ", getCompanyNm()=" + getCompanyNm() + ", getBriefingNm()=" + getBriefingNm()
				+ ", getBriefingType()=" + getBriefingType() + ", getBriefingDate()=" + getBriefingDate()
				+ ", getDateFrom()=" + getDateFrom() + ", getDateTo()=" + getDateTo() + ", getPostal()=" + getPostal()
				+ ", getPrefeNm()=" + getPrefeNm() + ", getBriefingAddress1()=" + getBriefingAddress1()
				+ ", getBriefingAddress2()=" + getBriefingAddress2() + ", getBriefingContent()=" + getBriefingContent()
				+ ", getProCntPlan()=" + getProCntPlan() + ", getTeaNm()=" + getTeaNm() + ", getTeaIntro()="
				+ getTeaIntro() + ", getTel()=" + getTel() + ", getCharge()=" + getCharge() + ", getPhotoAddress1()="
				+ getPhotoAddress1() + ", getPhotoAddress1Pic()=" + Arrays.toString(getPhotoAddress1Pic())
				+ ", getPhotoAddress2()=" + getPhotoAddress2() + ", getPhotoAddress2Pic()="
				+ Arrays.toString(getPhotoAddress2Pic()) + ", getPhotoAddress3()=" + getPhotoAddress3()
				+ ", getPhotoAddress3Pic()=" + Arrays.toString(getPhotoAddress3Pic()) + ", getStatusFlg()="
				+ getStatusFlg() + ", getRemarks()=" + getRemarks() + ", getUseFlg()=" + getUseFlg() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	

}
