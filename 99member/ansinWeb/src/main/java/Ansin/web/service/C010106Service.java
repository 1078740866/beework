package Ansin.web.service;

import java.util.List;

import Ansin.web.bean.ApplicantEduTblBean;
import Ansin.web.vueForm.C010106VueForm;

public interface C010106Service {
	/**
	 * C0101応募者の学歴リスト
	 * @param applicantId
	 * @return getApplicantEdu
	 */
	List<ApplicantEduTblBean> getEdu(Integer applicantId);
	/**
	 * C0101応募者の学歴を新規
	 * @param c010106VueForm
	 * @return eduInsert
	 */
	int eduInsert(C010106VueForm c010106VueForm);
	/**
	 * C0101応募者の学歴を更新
	 * @param c010106VueForm
	 * @return eduUpdate
	 */
	int eduUpdate(C010106VueForm c010106VueForm);
	/**
	 * C0101応募者の学歴を削除
	 * @param applicantId
	 * @param educationId
	 * @return eduDelete
	 */
	int eduDelete(Integer applicantId,Integer educationId, Integer userCd);
}
