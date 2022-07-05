package Ansin.web.service;

import java.util.List;

import Ansin.web.bean.PositionTblBean;
import Ansin.web.vueForm.A020205VueForm;



public interface A020205Service {
		/**
		 * 職位一覧リスト
		 * @param b0101VueForm
		 * @return 一覧リストposition
		 */
	     List<PositionTblBean> getPositionAll(A020205VueForm a020205VueForm);
		/**
		 * 職位をオンラインするとオフラインするまたは複数操作
		 * @param positionId
		 * @param onlineStatus
		 * @param applicantId
		 * @param userCd
		 * @return INT型positionOnlineOrOfflineReturn（IB0101ServiceImpl）
		 */
		Integer positionOnlineOrOffline(List<Integer> positionIdList,
				String onlineStatus,Integer companyId,Integer userCd);

	   	//C0201単数または複数削除
	     Integer deleteApplication(A020205VueForm a020205VueForm);
}
