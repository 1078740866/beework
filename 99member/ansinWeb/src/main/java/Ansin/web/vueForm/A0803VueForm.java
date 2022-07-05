package Ansin.web.vueForm;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

public class A0803VueForm {
	
	//宛先
	private String address;
	//件名
	private String subject;
	//日付FROM
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	private Timestamp dateFrom;
	//日付TO
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	private Timestamp dateTo;
	//送信者/受信者
	private Integer userCd;
	//メッセージID
	private Integer internalMessageId;
	//内部メッセージ確認状態
	private String statusFlg;
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Timestamp getDateFrom() {
		return dateFrom;
	}
	public void setDateFrom(Timestamp dateFrom) {
		this.dateFrom = dateFrom;
	}
	public Timestamp getDateTo() {
		return dateTo;
	}
	public void setDateTo(Timestamp dateTo) {
		this.dateTo = dateTo;
	}
	public Integer getUserCd() {
		return userCd;
	}
	public void setUserCd(Integer userCd) {
		this.userCd = userCd;
	}
	public Integer getInternalMessageId() {
		return internalMessageId;
	}
	public void setInternalMessageId(Integer internalMessageId) {
		this.internalMessageId = internalMessageId;
	}
	public String getStatusFlg() {
		return statusFlg;
	}
	public void setStatusFlg(String statusFlg) {
		this.statusFlg = statusFlg;
	}
	@Override
	public String toString() {
		return "A0803VueForm [address=" + address + ", subject=" + subject + ", dateFrom=" + dateFrom + ", dateTo="
				+ dateTo + ", userCd=" + userCd + ", internalMessageId=" + internalMessageId + ", statusFlg="
				+ statusFlg + "]";
	}
	
}
