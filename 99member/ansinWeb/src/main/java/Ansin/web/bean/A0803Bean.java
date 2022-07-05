package Ansin.web.bean;

public class A0803Bean {
	//メッセージID
	private String internalMessageId;
	//宛先
	private String name;
	//日付
	private String aDate;
	//件名
	private String subject;
	//状態
	private String status;
	
	public String getInternalMessageId() {
		return internalMessageId;
	}
	public void setInternalMessageId(String internalMessageId) {
		this.internalMessageId = internalMessageId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getaDate() {
		return aDate;
	}
	public void setaDate(String aDate) {
		this.aDate = aDate;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "A0803Bean [internalMessageId=" + internalMessageId + ", name=" + name + ", aDate=" + aDate
				+ ", subject=" + subject + ", status=" + status + ", getInternalMessageId()=" + getInternalMessageId()
				+ ", getName()=" + getName() + ", getaDate()=" + getaDate() + ", getSubject()=" + getSubject()
				+ ", getStatus()=" + getStatus() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
}
