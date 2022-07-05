package Ansin.web.service;

import java.util.List;

import Ansin.web.bean.InterviewHisTblBean;
import Ansin.web.vueForm.A020204VueForm;

/**
 * A020204面接一覧画面Service Interface
 * 
 * @author 楊卿赫
 * @date 2020-11-18 16:49:51
 */

public interface A020204Service {
	/**
	 * A020204 面接一覧画面データ
	 * 
	 * @param a020204VueForm
	 * @return List<InterviewHisTblEntity>
	 */
	List<InterviewHisTblBean> getInterviewHisTblEntityList(A020204VueForm a020204VueForm);

	/**
	 * A020204 面接一覧画面削除
	 * 
	 * @param interviewIdList
	 * @param applicantId
	 * @return Integer
	 */
	Integer update(List<Integer> interviewIdList, Integer applicantId);

}
