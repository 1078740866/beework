package Ansin.web.service;

import java.io.IOException;
import java.util.List;

import Ansin.web.bean.InterviewHisTblBean;
import Ansin.web.vueForm.B0401VueForm;

/**
 * C0501_面接一覧画面Service Interface
 * 
 * @author 楊卿赫
 * @date 2021-01-04 16:49:51
 */

public interface C0501Service {
	/**
	 * C0501_面接一覧画面データ
	 * 
	 * @param b0401VueForm
	 * @return List<InterviewHisTblEntity>
	 */
	List<InterviewHisTblBean> getInterviewHisTblEntityList(B0401VueForm b0401VueForm);
	/**
	 * C0501_面接一覧画面未処理データ
	 * 
	 * @param b0401VueForm
	 * @return List<InterviewHisTblEntity>
	 */
	List<InterviewHisTblBean> getInterviewHisTblEntityList2(B0401VueForm b0401VueForm);

	/**
	 * C0501_面接一覧ユーザー受けたまたは断る
	 * 
	 * @param interviewIdList
	 * @param userCd
	 * @param statusFlg
	 * @return Integer
	 */
	Integer update(List<Integer> interviewIdList, Integer userCd, String statusFlg);
	
	InterviewHisTblBean confirmOutput(InterviewHisTblBean interviewHisTblBean) throws IOException;

}
