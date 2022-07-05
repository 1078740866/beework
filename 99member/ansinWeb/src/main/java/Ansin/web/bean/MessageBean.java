package Ansin.web.bean;

public class MessageBean {
	//メッセージID
	private String internalMessageId;
	//件名
	private String subject;
	//確認状態
	private String stutsFlg;
	//メッセージ本文ID
	private String internalMessageTextId;
	//メッセージ本文
	private String internalMessageText;
	//送信者
	private String sendId;
	//名前(送信者)
	private String sName;
	//受信者
	private String recId;
	//名前(受信者)
	private String rName;
	//受信時間
	private String timeString;
	
	public String getInternalMessageId() {
		return internalMessageId;
	}
	public void setInternalMessageId(String internalMessageId) {
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
	public String getInternalMessageTextId() {
		return internalMessageTextId;
	}
	public void setInternalMessageTextId(String internalMessageTextId) {
		this.internalMessageTextId = internalMessageTextId;
	}
	public String getInternalMessageText() {
		return internalMessageText;
	}
	public void setInternalMessageText(String internalMessageText) {
		this.internalMessageText = internalMessageText;
	}
	public String getSendId() {
		return sendId;
	}
	public void setSendId(String sendId) {
		this.sendId = sendId;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getRecId() {
		return recId;
	}
	public void setRecId(String recId) {
		this.recId = recId;
	}
	public String getrName() {
		return rName;
	}
	public void setrName(String rName) {
		this.rName = rName;
	}
	
	public String getTimeString() {
		return timeString;
	}
	public void setTimeString(String timeString) {
		this.timeString = timeString;
	}
	@Override
	public String toString() {
		return "MessageBean [internalMessageId=" + internalMessageId + ", subject=" + subject + ", stutsFlg=" + stutsFlg
				+ ", internalMessageTextId=" + internalMessageTextId + ", internalMessageText=" + internalMessageText
				+ ", sendId=" + sendId + ", sName=" + sName + ", recId=" + recId + ", rName=" + rName + ", timeString="
				+ timeString + ", getInternalMessageId()=" + getInternalMessageId() + ", getSubject()=" + getSubject()
				+ ", getStutsFlg()=" + getStutsFlg() + ", getInternalMessageTextId()=" + getInternalMessageTextId()
				+ ", getInternalMessageText()=" + getInternalMessageText() + ", getSendId()=" + getSendId()
				+ ", getsName()=" + getsName() + ", getRecId()=" + getRecId() + ", getrName()=" + getrName()
				+ ", getTimeString()=" + getTimeString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
}
