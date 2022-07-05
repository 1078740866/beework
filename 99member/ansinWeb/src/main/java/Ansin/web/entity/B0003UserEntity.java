package Ansin.web.entity;

public class B0003UserEntity {
	
	//姓
	private String firstName;
	//名
	private String lastName;
	//権限
	private String authority;
	//会員レベル
	private String levelNm;
	//会社名
	private String companyNm;
	//残高
	private Integer remainder;
	//写真
	private String photo;
	
	
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
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public String getLevelNm() {
		return levelNm;
	}
	public void setLevelNm(String levelNm) {
		this.levelNm = levelNm;
	}
	public Integer getRemainder() {
		return remainder;
	}
	public void setRemainder(Integer remainder) {
		this.remainder = remainder;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	public String getCompanyNm() {
		return companyNm;
	}
	public void setCompanyNm(String companyNm) {
		this.companyNm = companyNm;
	}
	@Override
	public String toString() {
		return "B0003UserEntity [firstName=" + firstName + ", lastName=" + lastName + ", authority=" + authority
				+ ", levelNm=" + levelNm + ", companyNm=" + companyNm + ", remainder=" + remainder + ", photo=" + photo
				+ "]";
	}
	
}
