package Ansin.web.bean;

import java.util.List;

public class A070104ListBean {
	
	private List<TrainingInfoTblBean> trainingInfoTblBean;
	
	private List<IndustryMstBean> industryMstBean;
		
	private List<PrefecturesMstBean> prefecturesMstBean;

	public List<IndustryMstBean> getIndustryMstBean() {
		return industryMstBean;
	}

	public void setIndustryMstBean(List<IndustryMstBean> industryMstBean) {
		this.industryMstBean = industryMstBean;
	}

	public List<PrefecturesMstBean> getPrefecturesMstBean() {
		return prefecturesMstBean;
	}

	public void setPrefecturesMstBean(List<PrefecturesMstBean> prefecturesMstBean) {
		this.prefecturesMstBean = prefecturesMstBean;
	}

	public List<TrainingInfoTblBean> getTrainingInfoTblBean() {
		return trainingInfoTblBean;
	}

	public void setTrainingInfoTblBean(List<TrainingInfoTblBean> trainingInfoTblBean) {
		this.trainingInfoTblBean = trainingInfoTblBean;
	}
	
	
}
