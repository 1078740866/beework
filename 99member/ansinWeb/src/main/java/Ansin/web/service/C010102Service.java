package Ansin.web.service;

import java.util.List;

import Ansin.web.bean.ApplicantQuaTblBean;
import Ansin.web.vueForm.C010102VueForm;

public interface C010102Service {
	/**
	 * C0101応募者の資格リスト
	 * 
	 * @param applicantId
	 * @return
	 */
	List<ApplicantQuaTblBean> getApplicantQua(Integer applicantId);

	/**
	 * C0101応募者の資格を新規
	 * 
	 * @param c010102VueForm
	 * @return
	 */
	int insertQua(C010102VueForm c010102VueForm);

	/**
	 * C0101応募者の資格を更新
	 * 
	 * @param c010102VueForm
	 * @return
	 */
	int updateQua(C010102VueForm c010102VueForm);

	/**
	 * C0101応募者の資格を削除
	 * 
	 * @param applicantId
	 * @param appQuaId
	 * @return
	 */
	int deleteQua(Integer applicantId, Integer appQuaId, Integer userCd);
}
