package Ansin.web.service;

import java.util.List;

import Ansin.web.bean.A0301ListBean;
import Ansin.web.vueForm.A0301VueForm;

public interface A0301Service {
	/**
	 * 管理者一覧初期表示
	 * @param a0301VueForm
	 * @return List<UserTblBean>
	 */
	List<A0301ListBean> getUserList(A0301VueForm a0301VueForm);

	/**
	 * 使用状態変更
	 * @param a0301VueForm
	 * @return List<UserTblBean>
	 */
	Integer changeUse(A0301VueForm a0301VueForm);

	/**
	 * 削除状態変更
	 * @param a0301VueForm
	 * @return List<UserTblBean>
	 */
	Integer changeDel(A0301VueForm a0301VueForm);
}
