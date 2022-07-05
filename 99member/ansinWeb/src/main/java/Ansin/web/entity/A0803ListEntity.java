package Ansin.web.entity;

import java.sql.Timestamp;

public class A0803ListEntity {
	//メッセージID
	private Integer internalMessageId;
	//姓
	private String firstName;
	//氏名
	private String lastName;
	//件名
	private String subject;
	//日付
	private Timestamp aDate;
	//状態
	private String status;
	//受信者
	private Integer recId;

	public Integer getInternalMessageId() {
		return internalMessageId;
	}

	public void setInternalMessageId(Integer internalMessageId) {
		this.internalMessageId = internalMessageId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	
	public Timestamp getaDate() {
		return aDate;
	}

	public void setaDate(Timestamp aDate) {
		this.aDate = aDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	public Integer getRecId() {
		return recId;
	}

	public void setRecId(Integer recId) {
		this.recId = recId;
	}

	@Override
	public String toString() {
		return "A0803ListEntity [internalMessageId=" + internalMessageId + ", firstName=" + firstName + ", lastName="
				+ lastName + ", subject=" + subject + ", aDate=" + aDate + ", status=" + status + ", recId=" + recId
				+ ", getInternalMessageId()=" + getInternalMessageId() + ", getFirstName()=" + getFirstName()
				+ ", getLastName()=" + getLastName() + ", getSubject()=" + getSubject() + ", getaDate()=" + getaDate()
				+ ", getStatus()=" + getStatus() + ", getRecId()=" + getRecId() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}


}
