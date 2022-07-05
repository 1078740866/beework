package Ansin.web.bean;

public class CompanyInfoBean{
	
	//会社ID
	private String companyId;
	//会社名
	private String companyNm;
	//電話番号
	private String companyTel;
	//メール
	private String companyMail;
	//会員ID
	private String levelId;
	//会員名
	private String levelNm;
	//残高
	private String remainder;
	//割引マスター
	private WaribikiMstBean bean;
	
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
	public String getCompanyTel() {
		return companyTel;
	}
	public void setCompanyTel(String companyTel) {
		this.companyTel = companyTel;
	}
	public String getCompanyMail() {
		return companyMail;
	}
	public void setCompanyMail(String companyMail) {
		this.companyMail = companyMail;
	}
	public String getLevelId() {
		return levelId;
	}
	public void setLevelId(String levelId) {
		this.levelId = levelId;
	}
	public String getLevelNm() {
		return levelNm;
	}
	public void setLevelNm(String levelNm) {
		this.levelNm = levelNm;
	}
	public String getRemainder() {
		return remainder;
	}
	public void setRemainder(String remainder) {
		this.remainder = remainder;
	}
	
	public WaribikiMstBean getBean() {
		return bean;
	}
	public void setBean(WaribikiMstBean bean) {
		this.bean = bean;
	}
	@Override
	public String toString() {
		return "CompanyInfoBean [companyId=" + companyId + ", companyNm=" + companyNm + ", companyTel=" + companyTel
				+ ", companyMail=" + companyMail + ", levelId=" + levelId + ", levelNm=" + levelNm + ", remainder="
				+ remainder + ", bean=" + bean + "]";
	}
	
	
}
