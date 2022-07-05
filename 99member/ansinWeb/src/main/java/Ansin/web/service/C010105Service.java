package Ansin.web.service;

import java.util.List;

import Ansin.web.bean.ApplicantLanTblBean;
import Ansin.web.vueForm.C010105VueForm;

public interface C010105Service {
	/**
	 * C0101応募者の言語リスト			
	 * @param applicantId
	 * @return getApplicantLan
	 */
	List<ApplicantLanTblBean> getAll(Integer applicantId);
	/**
	 * C0101応募者の言語を新規
	 * @param c010105VueForm
	 * @return lanInsert
	 */
	int lanInsert(C010105VueForm c010105VueForm);
	/**
	 * C0101応募者の言語を更新
	 * @param c010105VueForm
	 * @return lanUpdate
	 */
	int lanUpdate(C010105VueForm c010105VueForm);
	/**
	 * C0101応募者の言語を削除
	 * @param applicantId
	 * @param languageId
	 * @return lanDelete
	 */
	int lanDelete(Integer applicantId,Integer languageId, Integer userCd);
}
