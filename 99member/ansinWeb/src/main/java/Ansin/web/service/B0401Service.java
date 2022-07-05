package Ansin.web.service;

import java.util.List;

import Ansin.web.bean.InterviewHisTblBean;
import Ansin.web.vueForm.B0401VueForm;

/**
 * B0401 面接一覧画面Service Interface
 * 
 * @author コウ テンキ
 * @date 2020-10-20 16:49:51
 */

public interface B0401Service {
	/**
	 * B0401 面接一覧画面データ
	 * 
	 * @param b0401VueForm
	 * @return List<InterviewHisTblEntity>
	 */
	List<InterviewHisTblBean> getInterviewHisTblEntityList(B0401VueForm b0401VueForm);

	/**
	 * B0401 面接一覧画面削除
	 * 
	 * @param interviewIdList
	 * @param companyId
	 * @return Integer
	 */
	Integer update(List<Integer> interviewIdList, Integer companyId,  Integer userCd);

}
