package Ansin.web.service;

import java.util.List;

import Ansin.web.bean.ApplicantSkillTblBean;
import Ansin.web.vueForm.C010103VueForm;

public interface C010103Service {
	/**
	 * C0101応募者のスキルリスト
	 * 
	 * @param applicantId
	 * @return getApplicantSkill
	 */
	List<ApplicantSkillTblBean> getApplicantSkill(Integer applicantId);

	/**
	 * C0101応募者のスキルを新規
	 * 
	 * @param c010103VueForm
	 * @return skillInsert
	 */
	int skillInsert(C010103VueForm c010103VueForm);

	/**
	 * C0101応募者のスキルを更新
	 * 
	 * @param c010103VueForm
	 * @return skillUpdate
	 */
	int skillUpdate(C010103VueForm c010103VueForm);

	/**
	 * C0101応募者のスキルを削除
	 * 
	 * @param applicantId
	 * @param appSkillId
	 * @return skillDelete
	 */
	int skillDelete(String applicantId, String appSkillId, Integer userCd);

}
