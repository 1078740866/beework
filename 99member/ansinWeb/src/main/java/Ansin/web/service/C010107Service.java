package Ansin.web.service;

import java.util.List;

import Ansin.web.bean.ProjectHisTblBean;
import Ansin.web.vueForm.C010107VueForm;

public interface C010107Service {
	/**
	 * C0101応募者のプロジェクト履歴リスト			
	 * @param applicantId
	 * @return getProjectHisAll
	 */
	List<ProjectHisTblBean> getAll(Integer applicantId);
	/**
	 * C0101応募者のプロジェクト履歴を新規
	 * @param c010107VueForm
	 * @return projectHisInsert
	 */
	int projectHisInsert(C010107VueForm c010107VueForm);
	/**
	 * C0101応募者のプロジェクト履歴を更新
	 * @param c010107VueForm
	 * @return projectHisUpdate
	 */
	int projectHisUpdate(C010107VueForm c010107VueForm);
	/**
	 * C0101応募者のプロジェクト履歴を削除
	 * @param applicantId
	 * @param projectId
	 * @return projectHisDelete
	 */
	int projectHisDelete(Integer applicantId,Integer projectId, Integer userCd);
}
