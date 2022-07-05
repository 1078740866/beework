package Ansin.web.service;

import java.util.List;

import Ansin.web.bean.A0802Bean;
import Ansin.web.bean.A0803Bean;
import Ansin.web.bean.MessageBean;
import Ansin.web.vueForm.A0801VueForm;
import Ansin.web.vueForm.A0802VueForm;
import Ansin.web.vueForm.A0803VueForm;

public interface A0801Service {
	
	/**
	 * 送信ボタン押下
	 * @param a0801VueForm
	 * @return Integer
	 */
	Integer send(A0801VueForm a0801VueForm);
	/**
	 * 宛先一覧画面初期表示と検索ボタン押下
	 * @param a0802VueForm
	 * @return List<A0802Bean>
	 */
	List<A0802Bean> getUserList(A0802VueForm a0802VueForm);
	/**
	 * 送信一覧画面初期表示と検索ボタン押下
	 * @param a0803VueForm
	 * @return List<A0803Bean>
	 */
	List<A0803Bean> getAddress(A0803VueForm a0803VueForm);
	/**
	 * 一つメッセージ情報取得
	 * @param a0803VueForm
	 * @return MessageBean
	 */
	MessageBean getMessage(A0803VueForm a0803VueForm);
	

}
