package Ansin.web.vueForm;

/**
 * 
 * @author コウ テンキ
 * @date 2020-10-16 15:26:12
 */

//　説明会応募者画面データ
public class B0603VueForm {

    //会社ID
    private Integer companyId;
    //ユーザーコード
    private Integer userCd;
	// 説明会ID
	private Integer briefingId;
	// 名前
	private String name;
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	public Integer getUserCd() {
		return userCd;
	}
	public void setUserCd(Integer userCd) {
		this.userCd = userCd;
	}
	public Integer getBriefingId() {
		return briefingId;
	}
	public void setBriefingId(Integer briefingId) {
		this.briefingId = briefingId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "B0603VueForm [companyId=" + companyId + ", userCd=" + userCd + ", briefingId=" + briefingId + ", name="
				+ name + "]";
	}
	
	

}
