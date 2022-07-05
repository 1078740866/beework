package Ansin.web.vueForm;

public class B0002PopVueForm {

	private String companyNm;
//	@NotBlank(message="規模を入力してください。")
	private String companyScale;
//    @NotBlank(message="国を入力してください。")
	private String country;
//    @NotBlank(message="業種を入力してください。")
    private String industryCd1;
//    @NotBlank(message="都道府県を入力してください。")
    private String address1;
	public String getCompanyNm() {
		return companyNm;
	}
	public void setCompanyNm(String companyNm) {
		this.companyNm = companyNm;
	}
	public String getCompanyScale() {
		return companyScale;
	}
	public void setCompanyScale(String companyScale) {
		this.companyScale = companyScale;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getIndustryCd1() {
		return industryCd1;
	}
	public void setIndustryCd1(String industryCd1) {
		this.industryCd1 = industryCd1;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}


}
