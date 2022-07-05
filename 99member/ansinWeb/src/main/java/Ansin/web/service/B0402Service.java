package Ansin.web.service;

import Ansin.web.bean.InterviewHisTblBean;
import Ansin.web.vueForm.B0402VueForm;

/**
 * B0402 面接詳細情報 interviewInfo
 * 
 * @author コウ テンキ
 * @date 2020-10-22 14:27:05
 */

public interface B0402Service {

	/**
	 * B0402 面接詳細情報 初期表示
	 * 
	 * @param interviewId
	 * @return B0402VueForm
	 */
	InterviewHisTblBean getInit(Integer interviewId);

	/**
	 * B0402 面接詳細情報 データ更新
	 * 
	 * @param b0402VueForm
	 * @return Integer
	 */
	Integer update(B0402VueForm b0402VueForm);
	
	/**
	 * B0402 面接詳細情報 データ更新
	 * 
	 * @param b0402VueForm
	 * @return Integer
	 */
	Integer insert(B0402VueForm b0402VueForm);

}
