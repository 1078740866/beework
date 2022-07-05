package Ansin.web.bean;

public class ComChargeBean {
	
	//ユーザー名前
	private String userName;
	//権限
	private String authority;
	//会員レベル
	private String levelNm;
	//会社名
	private String companyNm;
	//残高
	private String remainder;
	//写真
	private String photo;
	private byte[] photoPic;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	
	public String getCompanyNm() {
		return companyNm;
	}

	public void setCompanyNm(String companyNm) {
		this.companyNm = companyNm;
	}

	public String getRemainder() {
		return remainder;
	}

	public void setRemainder(String remainder) {
		this.remainder = remainder;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getLevelNm() {
		return levelNm;
	}

	public void setLevelNm(String levelNm) {
		this.levelNm = levelNm;
	}

	@Override
	public String toString() {
		return "ComChargeBean [userName=" + userName + ", authority=" + authority + ", levelNm=" + levelNm
				+ ", companyNm=" + companyNm + ", remainder=" + remainder + ", photo=" + photo + ", getUserName()="
				+ getUserName() + ", getAuthority()=" + getAuthority() + ", getCompanyNm()=" + getCompanyNm()
				+ ", getRemainder()=" + getRemainder() + ", getPhoto()=" + getPhoto() + ", getLevelNm()=" + getLevelNm()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	public byte[] getPhotoPic() {
		return photoPic;
	}

	public void setPhotoPic(byte[] photoPic) {
		this.photoPic = photoPic;
	}

}
