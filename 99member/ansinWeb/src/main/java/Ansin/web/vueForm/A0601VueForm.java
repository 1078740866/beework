package Ansin.web.vueForm;

import java.util.List;

public class A0601VueForm {
	
	//通報IDリスト
	private List<Integer> reportIds;
	//種類区分
	private String typeSection;
	//通報区分
	private String reportSection;
	//ユーザーコード
	private Integer userCd;
	//通報ID
	private Integer reportId;
	//状態フラグ
	private String statusFlg;
	//何件/ページ
	private Integer limit;
	//FROMの位置
	private Integer offset;
	
	
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	public Integer getOffset() {
		return offset;
	}
	public void setOffset(Integer offset) {
		this.offset = offset;
	}
	public List<Integer> getReportIds() {
		return reportIds;
	}
	public void setReportIds(List<Integer> reportIds) {
		this.reportIds = reportIds;
	}
	public String getTypeSection() {
		return typeSection;
	}
	public void setTypeSection(String typeSection) {
		this.typeSection = typeSection;
	}
	public String getReportSection() {
		return reportSection;
	}
	public void setReportSection(String reportSection) {
		this.reportSection = reportSection;
	}
	public Integer getUserCd() {
		return userCd;
	}
	public void setUserCd(Integer userCd) {
		this.userCd = userCd;
	}
	public Integer getReportId() {
		return reportId;
	}
	public void setReportId(Integer reportId) {
		this.reportId = reportId;
	}
	public String getStatusFlg() {
		return statusFlg;
	}
	public void setStatusFlg(String statusFlg) {
		this.statusFlg = statusFlg;
	}
	
	
}
