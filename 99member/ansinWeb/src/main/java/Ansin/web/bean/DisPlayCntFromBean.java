package Ansin.web.bean;

public class DisPlayCntFromBean {

	public DisPlayCntFromBean(String code, String name) {
		this.disPlayCntCode = code;
		this.disPlayCntName = name;
	}
    // 学位
	private String disPlayCntCode;
	private String disPlayCntName;
	public String getDisPlayCntCode() {
		return disPlayCntCode;
	}
	public void setDisPlayCntCode(String disPlayCntCode) {
		this.disPlayCntCode = disPlayCntCode;
	}
	public String getDisPlayCntName() {
		return disPlayCntName;
	}
	public void setDisPlayCntName(String disPlayCntName) {
		this.disPlayCntName = disPlayCntName;
	}


}
