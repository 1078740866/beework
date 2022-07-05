package Ansin.web.vueForm;

import java.util.ArrayList;

import javax.validation.Valid;

import Ansin.web.bean.OubosyaListBean;

public class B0201VueForm {

	// 検索条件
	@Valid
	private B0201SearchVueForm b0201SearchVueForm;
	// 明細リスト
	private ArrayList<OubosyaListBean> oubosyaList;
	// 選択されたイベント
	private String hdnSentakuEvent;
	// ユーザーコード
	private Integer userCd;
	// 状態更新
	private B0201StatusForm b0201StatusForm;

	public B0201SearchVueForm getB0201SearchVueForm() {
		return b0201SearchVueForm;
	}

	public void setB0201SearchVueForm(B0201SearchVueForm b0201SearchVueForm) {
		this.b0201SearchVueForm = b0201SearchVueForm;
	}

	public ArrayList<OubosyaListBean> getOubosyaList() {
		return oubosyaList;
	}

	public String getHdnSentakuEvent() {
		return hdnSentakuEvent;
	}

	public Integer getUserCd() {
		return userCd;
	}

	public void setOubosyaList(ArrayList<OubosyaListBean> oubosyaList) {
		this.oubosyaList = oubosyaList;
	}

	public void setHdnSentakuEvent(String hdnSentakuEvent) {
		this.hdnSentakuEvent = hdnSentakuEvent;
	}

	public void setUserCd(Integer userCd) {
		this.userCd = userCd;
	}


	public B0201StatusForm getB0201StatusForm() {
		return b0201StatusForm;
	}

	public void setB0201StatusForm(B0201StatusForm b0201StatusForm) {
		this.b0201StatusForm = b0201StatusForm;
	}
}
