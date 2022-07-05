package Ansin.web.entity;

import java.sql.Timestamp;

public class MessageEntity {
	//メッセージID
	private Integer internalMessageId;
	//件名
	private String subject;
	//確認状態
	private String stutsFlg;
	//メッセージ本文ID
	private Integer internalMessageTextId;
	//メッセージ本文
	private String internalMessageText;
	//送信者
	private Integer sendId;
	//受信者
	private Integer recId;
	//受信時間
	private Timestamp timeString;
	public Integer getInternalMessageId() {
		return internalMessageId;
	}
	public void setInternalMessageId(Integer internalMessageId) {
		this.internalMessageId = internalMessageId;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getStutsFlg() {
		return stutsFlg;
	}
	public void setStutsFlg(String stutsFlg) {
		this.stutsFlg = stutsFlg;
	}
	public Integer getInternalMessageTextId() {
		return internalMessageTextId;
	}
	public void setInternalMessageTextId(Integer internalMessageTextId) {
		this.internalMessageTextId = internalMessageTextId;
	}
	public String getInternalMessageText() {
		return internalMessageText;
	}
	public void setInternalMessageText(String internalMessageText) {
		this.internalMessageText = internalMessageText;
	}
	public Integer getSendId() {
		return sendId;
	}
	public void setSendId(Integer sendId) {
		this.sendId = sendId;
	}
	public Integer getRecId() {
		return recId;
	}
	public void setRecId(Integer recId) {
		this.recId = recId;
	}
	
	public Timestamp getTimeString() {
		return timeString;
	}
	public void setTimeString(Timestamp timeString) {
		this.timeString = timeString;
	}
	@Override
	public String toString() {
		return "MessageEntity [internalMessageId=" + internalMessageId + ", subject=" + subject + ", stutsFlg="
				+ stutsFlg + ", internalMessageTextId=" + internalMessageTextId + ", internalMessageText="
				+ internalMessageText + ", sendId=" + sendId + ", recId=" + recId + ", timeString=" + timeString + "]";
	}
	
}
