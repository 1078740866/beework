package Ansin.web.bean;

import java.util.List;

public class B0501ListBean {
	
	private List<TrainingInfoTblBean> trainingInfoTblBean;
	
	private List<IndustryMstBean> industryMstBean;

	public List<TrainingInfoTblBean> getTrainingInfoTblBean() {
		return trainingInfoTblBean;
	}

	public void setTrainingInfoTblBean(List<TrainingInfoTblBean> trainingInfoTblBean) {
		this.trainingInfoTblBean = trainingInfoTblBean;
	}

	public List<IndustryMstBean> getIndustryMstBean() {
		return industryMstBean;
	}

	public void setIndustryMstBean(List<IndustryMstBean> industryMstBean) {
		this.industryMstBean = industryMstBean;
	}

	@Override
	public String toString() {
		return "B0501ListEntity [trainingInfoTblBean=" + trainingInfoTblBean + ", industryMstBean=" + industryMstBean
				+ "]";
	}

}
