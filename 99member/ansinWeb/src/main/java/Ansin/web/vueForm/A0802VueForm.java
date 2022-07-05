package Ansin.web.vueForm;

public class A0802VueForm {
	
	//ユーザーメール
	private String userMail;
	//会社名
	private String companyNm;
	//ユーザー名
	private String userName;
	public String getUserMail() {
		return userMail;
	}
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	public String getCompanyNm() {
		return companyNm;
	}
	public void setCompanyNm(String companyNm) {
		this.companyNm = companyNm;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "A0802VueForm [userMail=" + userMail + ", companyNm=" + companyNm + ", userName=" + userName
				+ ", getUserMail()=" + getUserMail() + ", getCompanyNm()=" + getCompanyNm() + ", getUserName()="
				+ getUserName() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	
}
