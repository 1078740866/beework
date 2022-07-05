package Ansin.web.bean;

import java.util.List;

public class A0201Bean {
	//業種リスト
	private List<IndustryMstBean> industryMstBeans;
	//職種リスト
	private List<JobtypeMstBean> jobtypeMstBeans;
	//都道府県リスト
	private List<PrefecturesMstBean> prefecturesMstBeans;
	//言語リスト
	private List<LanMstBean> lanMstBeans;
	//応募者情報リスト
	private List<A0201ListBean> a0201ListBean;
	
	public List<IndustryMstBean> getIndustryMstBeans() {
		return industryMstBeans;
	}

	public void setIndustryMstBeans(List<IndustryMstBean> industryMstBeans) {
		this.industryMstBeans = industryMstBeans;
	}

	public List<JobtypeMstBean> getJobtypeMstBeans() {
		return jobtypeMstBeans;
	}

	public void setJobtypeMstBeans(List<JobtypeMstBean> jobtypeMstBeans) {
		this.jobtypeMstBeans = jobtypeMstBeans;
	}

	public List<PrefecturesMstBean> getPrefecturesMstBeans() {
		return prefecturesMstBeans;
	}

	public void setPrefecturesMstBeans(List<PrefecturesMstBean> prefecturesMstBeans) {
		this.prefecturesMstBeans = prefecturesMstBeans;
	}

	public List<LanMstBean> getLanMstBeans() {
		return lanMstBeans;
	}

	public void setLanMstBeans(List<LanMstBean> lanMstBeans) {
		this.lanMstBeans = lanMstBeans;
	}

	public List<A0201ListBean> getA0201ListBean() {
		return a0201ListBean;
	}

	public void setA0201ListBean(List<A0201ListBean> a0201ListBean) {
		this.a0201ListBean = a0201ListBean;
	}

	@Override
	public String toString() {
		return "A0201Bean [industryMstBeans=" + industryMstBeans + ", jobtypeMstBeans=" + jobtypeMstBeans
				+ ", prefecturesMstBeans=" + prefecturesMstBeans + ", lanMstBeans=" + lanMstBeans + ", a0201ListBean="
				+ a0201ListBean + ", getIndustryMstBeans()=" + getIndustryMstBeans() + ", getJobtypeMstBeans()="
				+ getJobtypeMstBeans() + ", getPrefecturesMstBeans()=" + getPrefecturesMstBeans()
				+ ", getLanMstBeans()=" + getLanMstBeans() + ", getA0201ListBean()=" + getA0201ListBean()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
}
