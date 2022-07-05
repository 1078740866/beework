package Ansin.web.service;

import java.util.List;

import Ansin.web.bean.ApplicantWorkHisTblBean;
import Ansin.web.vueForm.C010104VueForm;

public interface C010104Service {
	/**
	 * C0101応募者の職歴リスト	
	 * @param applicantId
	 * @return getApplicantWorkHis
	 */
	List<ApplicantWorkHisTblBean> getApplicantWorkHis(Integer applicantId);
	/**
	 * C0101応募者の職歴を新規
	 * @param c010104VueForm
	 * @return workHisInsert
	 */
	int workHisInsert(C010104VueForm c010104VueForm);
	/**
	 * C0101応募者の職歴を更新
	 * @param c010104VueForm
	 * @return workHisUpdate
	 */
	int workHisUpdate(C010104VueForm c010104VueForm);
	/**
	 * C0101応募者の職歴を削除
	 * @param applicantId
	 * @param workHisId
	 * @return workHisDelete
	 */
	int workHisDelete(Integer applicantId,Integer workHisId, Integer userCd);
}
