package Ansin.web.vueForm;

import java.util.List;

public class A0801VueForm {

	//送信者ID
	private Integer sendId;
	//受信者ID
	private List<Integer> recid;
	//件名
	private String subject;
	//メッセージ本文ID
	private Integer internalMessageTextId;
	//メッセージ本文内容
	private String internalMessageText;
	public Integer getSendId() {
		return sendId;
	}
	public void setSendId(Integer sendId) {
		this.sendId = sendId;
	}
	public List<Integer> getRecid() {
		return recid;
	}
	public void setRecid(List<Integer> recid) {
		this.recid = recid;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
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
	@Override
	public String toString() {
		return "A0801VueForm [sendId=" + sendId + ", recid=" + recid + ", subject=" + subject
				+ ", internalMessageTextId=" + internalMessageTextId + ", internalMessageText=" + internalMessageText
				+ "]";
	}
	
	

}
