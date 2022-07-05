package Ansin.web.vueForm;

import java.sql.Timestamp;
import java.util.List;

public class A070102VueForm {
	
	//ユーザーコード
	private Integer userCd;
	//会社ID
	private Integer cpmpanyId;
	//会社IDリスト
	private List<Integer> companyIds;
	//会社名
	private String companyNm;
	//業種ID
	private Integer industryId;
	//更新日時
	private Timestamp updateTime;
	//都道府县名
	private String prefeNm;
	//状態FLG（0：承認、１：拒否）
	private String statusFlg;
	
	
	public String getCompanyNm() {
		return companyNm;
	}
	public void setCompanyNm(String companyNm) {
		this.companyNm = companyNm;
	}
	public Integer getIndustryId() {
		return industryId;
	}
	public void setIndustryId(Integer industryId) {
		this.industryId = industryId;
	}
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	public Integer getCpmpanyId() {
		return cpmpanyId;
	}
	public void setCpmpanyId(Integer cpmpanyId) {
		this.cpmpanyId = cpmpanyId;
	}
	public List<Integer> getCompanyIds() {
		return companyIds;
	}
	public void setCompanyIds(List<Integer> companyIds) {
		this.companyIds = companyIds;
	}
	public Integer getUserCd() {
		return userCd;
	}
	public void setUserCd(Integer userCd) {
		this.userCd = userCd;
	}
	public String getPrefeNm() {
		return prefeNm;
	}
	public void setPrefeNm(String prefeNm) {
		this.prefeNm = prefeNm;
	}
	public String getStatusFlg() {
		return statusFlg;
	}
	public void setStatusFlg(String statusFlg) {
		this.statusFlg = statusFlg;
	}
	@Override
	public String toString() {
		return "A070102VueForm [userCd=" + userCd + ", cpmpanyId=" + cpmpanyId + ", companyIds=" + companyIds
				+ ", companyNm=" + companyNm + ", industryId=" + industryId + ", updateTime=" + updateTime
				+ ", prefeNm=" + prefeNm + ", statusFlg=" + statusFlg + "]";
	}

}
