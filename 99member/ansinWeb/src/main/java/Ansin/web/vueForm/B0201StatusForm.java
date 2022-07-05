package Ansin.web.vueForm;

import java.util.ArrayList;

public class B0201StatusForm {

	// 選択されたイベント
	private String hdnSentakuEvent;
	// 応募者ID
	private ArrayList<Integer> applicantIdList;
	// 職位ID
	private ArrayList<Integer> positionIdList;


	public String getHdnSentakuEvent() {
		return hdnSentakuEvent;
	}

	public void setHdnSentakuEvent(String hdnSentakuEvent) {
		this.hdnSentakuEvent = hdnSentakuEvent;
	}

	public ArrayList<Integer> getApplicantIdList() {
		return applicantIdList;
	}

	public void setApplicantIdList(ArrayList<Integer> applicantIdList) {
		this.applicantIdList = applicantIdList;
	}

	public ArrayList<Integer> getPositionIdList() {
		return positionIdList;
	}

	public void setPositionIdList(ArrayList<Integer> positionIdList) {
		this.positionIdList = positionIdList;
	}
}
