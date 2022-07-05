package Ansin.web.bean;

public class PositionTblBean {
	  // 会社ID
    private String companyId;
    // ユーザーコード
    private String userCd;
    // 職位ID
    private String positionId;
    // 業種ID
    private String industryId;
    // 業種名
    private String industryNm;
    // 職種名
    private String jobTypeNm;
    // スキル名
    private String skillNm;
    // 職種ID
    private String jobTypeId;
    //スキルID
    private String skillId;
    // 職位名
    private String positionNm;
    // 学歴要求
    private String degree;
    // 職位説明
    private String positionInt;
    // 仕事内容
    private String workContent;
    // 雇用方式区分
    private String contractSection;
    // 勤務開始時間
    private String workTimeFrom;
    // 勤務終了時間
    private String workTimeTo;
    // 郵便番号
    private String postal;
    //都道府县名
    private String prefeNm;
    // 場所1
    private String workAddress1;
    // 場所2
    private String workAddress2;
    // 最寄駅
    private String station;
    // 必須経験年数
    private String expYears;
    // 給料区分
    private String salarySection;
    // 最低限給料
    private String salaryMin;
    // 最高限給料
    private String salaryMax;
    // 人数
    private String peoCnt;
    // 休日・休暇
    private String holiday;
    // 雇用・労災保険
    private String empLaborIns;
    // 福利厚生
    private String welfare;
    // 研修有無
    private String trainingFlg;
    // 見学有無
    private String inspectionFlg;
    // 契約更新有無
    private String conUpdFlg;
    // 仕事予定開始日
    private String workDateStr;
    // 仕事画像アドレス1
    private String workingAddress1;
    private byte[] workingAddress1Pic;
    // 仕事画像アドレス2
    private String workingAddress2;
    private byte[] workingAddress2Pic;
    // 仕事画像アドレス3
    private String workingAddress3;
    private byte[] workingAddress3Pic;
    // 有効期限
    private String expDate;
    // 募集状態
    private String onlineStatus;
    // トップ状態
    private String topStatus;
    // 確認状態
    private String checkStatus;
    // 備考
    private String remarks;
	//更新日時
	private String updateTime;
	//会社名
	private String companyNm;
	
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getUserCd() {
		return userCd;
	}
	public void setUserCd(String userCd) {
		this.userCd = userCd;
	}
	public String getPositionId() {
		return positionId;
	}
	public void setPositionId(String positionId) {
		this.positionId = positionId;
	}
	public String getIndustryId() {
		return industryId;
	}
	public void setIndustryId(String industryId) {
		this.industryId = industryId;
	}
	public String getIndustryNm() {
		return industryNm;
	}
	public void setIndustryNm(String industryNm) {
		this.industryNm = industryNm;
	}
	public String getJobTypeNm() {
		return jobTypeNm;
	}
	public void setJobTypeNm(String jobTypeNm) {
		this.jobTypeNm = jobTypeNm;
	}
	public String getSkillNm() {
		return skillNm;
	}
	public void setSkillNm(String skillNm) {
		this.skillNm = skillNm;
	}
	public String getJobTypeId() {
		return jobTypeId;
	}
	public void setJobTypeId(String jobTypeId) {
		this.jobTypeId = jobTypeId;
	}
	public String getSkillId() {
		return skillId;
	}
	public void setSkillId(String skillId) {
		this.skillId = skillId;
	}
	public String getPositionNm() {
		return positionNm;
	}
	public void setPositionNm(String positionNm) {
		this.positionNm = positionNm;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getPositionInt() {
		return positionInt;
	}
	public void setPositionInt(String positionInt) {
		this.positionInt = positionInt;
	}
	public String getWorkContent() {
		return workContent;
	}
	public void setWorkContent(String workContent) {
		this.workContent = workContent;
	}
	public String getContractSection() {
		return contractSection;
	}
	public void setContractSection(String contractSection) {
		this.contractSection = contractSection;
	}
	public String getWorkTimeFrom() {
		return workTimeFrom;
	}
	public void setWorkTimeFrom(String workTimeFrom) {
		this.workTimeFrom = workTimeFrom;
	}
	public String getWorkTimeTo() {
		return workTimeTo;
	}
	public void setWorkTimeTo(String workTimeTo) {
		this.workTimeTo = workTimeTo;
	}
	public String getPostal() {
		return postal;
	}
	public void setPostal(String postal) {
		this.postal = postal;
	}
	public String getPrefeNm() {
		return prefeNm;
	}
	public void setPrefeNm(String prefeNm) {
		this.prefeNm = prefeNm;
	}
	public String getWorkAddress1() {
		return workAddress1;
	}
	public void setWorkAddress1(String workAddress1) {
		this.workAddress1 = workAddress1;
	}
	public String getWorkAddress2() {
		return workAddress2;
	}
	public void setWorkAddress2(String workAddress2) {
		this.workAddress2 = workAddress2;
	}
	public String getStation() {
		return station;
	}
	public void setStation(String station) {
		this.station = station;
	}
	public String getExpYears() {
		return expYears;
	}
	public void setExpYears(String expYears) {
		this.expYears = expYears;
	}
	public String getSalarySection() {
		return salarySection;
	}
	public void setSalarySection(String salarySection) {
		this.salarySection = salarySection;
	}
	public String getSalaryMin() {
		return salaryMin;
	}
	public void setSalaryMin(String salaryMin) {
		this.salaryMin = salaryMin;
	}
	public String getSalaryMax() {
		return salaryMax;
	}
	public void setSalaryMax(String salaryMax) {
		this.salaryMax = salaryMax;
	}
	public String getPeoCnt() {
		return peoCnt;
	}
	public void setPeoCnt(String peoCnt) {
		this.peoCnt = peoCnt;
	}
	public String getHoliday() {
		return holiday;
	}
	public void setHoliday(String holiday) {
		this.holiday = holiday;
	}
	public String getEmpLaborIns() {
		return empLaborIns;
	}
	public void setEmpLaborIns(String empLaborIns) {
		this.empLaborIns = empLaborIns;
	}
	public String getWelfare() {
		return welfare;
	}
	public void setWelfare(String welfare) {
		this.welfare = welfare;
	}
	public String getTrainingFlg() {
		return trainingFlg;
	}
	public void setTrainingFlg(String trainingFlg) {
		this.trainingFlg = trainingFlg;
	}
	public String getInspectionFlg() {
		return inspectionFlg;
	}
	public void setInspectionFlg(String inspectionFlg) {
		this.inspectionFlg = inspectionFlg;
	}
	public String getConUpdFlg() {
		return conUpdFlg;
	}
	public void setConUpdFlg(String conUpdFlg) {
		this.conUpdFlg = conUpdFlg;
	}
	public String getWorkDateStr() {
		return workDateStr;
	}
	public void setWorkDateStr(String workDateStr) {
		this.workDateStr = workDateStr;
	}
	public String getWorkingAddress1() {
		return workingAddress1;
	}
	public void setWorkingAddress1(String workingAddress1) {
		this.workingAddress1 = workingAddress1;
	}
	public String getWorkingAddress2() {
		return workingAddress2;
	}
	public void setWorkingAddress2(String workingAddress2) {
		this.workingAddress2 = workingAddress2;
	}
	public String getWorkingAddress3() {
		return workingAddress3;
	}
	public void setWorkingAddress3(String workingAddress3) {
		this.workingAddress3 = workingAddress3;
	}
	public String getExpDate() {
		return expDate;
	}
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
	public String getOnlineStatus() {
		return onlineStatus;
	}
	public void setOnlineStatus(String onlineStatus) {
		this.onlineStatus = onlineStatus;
	}
	public String getTopStatus() {
		return topStatus;
	}
	public void setTopStatus(String topStatus) {
		this.topStatus = topStatus;
	}
	public String getCheckStatus() {
		return checkStatus;
	}
	public void setCheckStatus(String checkStatus) {
		this.checkStatus = checkStatus;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	@Override
	public String toString() {
		return "PositionTblBean [companyId=" + companyId + ", userCd=" + userCd + ", positionId=" + positionId
				+ ", industryId=" + industryId + ", industryNm=" + industryNm + ", jobTypeNm=" + jobTypeNm
				+ ", skillNm=" + skillNm + ", jobTypeId=" + jobTypeId + ", skillId=" + skillId + ", positionNm="
				+ positionNm + ", degree=" + degree + ", positionInt=" + positionInt + ", workContent=" + workContent
				+ ", contractSection=" + contractSection + ", workTimeFrom=" + workTimeFrom + ", workTimeTo="
				+ workTimeTo + ", postal=" + postal + ", prefeNm=" + prefeNm + ", workAddress1=" + workAddress1
				+ ", workAddress2=" + workAddress2 + ", station=" + station + ", expYears=" + expYears
				+ ", salarySection=" + salarySection + ", salaryMin=" + salaryMin + ", salaryMax=" + salaryMax
				+ ", peoCnt=" + peoCnt + ", holiday=" + holiday + ", empLaborIns=" + empLaborIns + ", welfare="
				+ welfare + ", trainingFlg=" + trainingFlg + ", inspectionFlg=" + inspectionFlg + ", conUpdFlg="
				+ conUpdFlg + ", workDateStr=" + workDateStr + ", workingAddress1=" + workingAddress1
				+ ", workingAddress2=" + workingAddress2 + ", workingAddress3=" + workingAddress3 + ", expDate="
				+ expDate + ", onlineStatus=" + onlineStatus + ", topStatus=" + topStatus + ", checkStatus="
				+ checkStatus + ", remarks=" + remarks + ", updateTime=" + updateTime + "]";
	}
	public String getCompanyNm() {
		return companyNm;
	}
	public void setCompanyNm(String companyNm) {
		this.companyNm = companyNm;
	}
	public byte[] getWorkingAddress1Pic() {
		return workingAddress1Pic;
	}
	public void setWorkingAddress1Pic(byte[] workingAddress1Pic) {
		this.workingAddress1Pic = workingAddress1Pic;
	}
	public byte[] getWorkingAddress2Pic() {
		return workingAddress2Pic;
	}
	public void setWorkingAddress2Pic(byte[] workingAddress2Pic) {
		this.workingAddress2Pic = workingAddress2Pic;
	}
	public byte[] getWorkingAddress3Pic() {
		return workingAddress3Pic;
	}
	public void setWorkingAddress3Pic(byte[] workingAddress3Pic) {
		this.workingAddress3Pic = workingAddress3Pic;
	}
	
	
}
