package Ansin.web.bean;

public class UpdateTimeFromBean {

	public UpdateTimeFromBean(String code, String name) {
		this.updateTimeCode = code;
		this.updateTimeName = name;
	}

    // 更新日時
	private String updateTimeCode;
	private String updateTimeName;
	public String getUpdateTimeCode() {
		return updateTimeCode;
	}
	public void setUpdateTimeCode(String updateTimeCode) {
		this.updateTimeCode = updateTimeCode;
	}
	public String getUpdateTimeName() {
		return updateTimeName;
	}
	public void setUpdateTimeName(String updateTimeName) {
		this.updateTimeName = updateTimeName;
	}

}
