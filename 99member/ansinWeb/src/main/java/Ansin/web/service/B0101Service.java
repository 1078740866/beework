package Ansin.web.service;

import java.io.IOException;
import java.util.List;

import Ansin.web.bean.PositionTblBean;
import Ansin.web.vueForm.B0101VueForm;



public interface B0101Service {
		/**
		 * 職位一覧リスト
		 * @param b0101VueForm
		 * @return 一覧リストposition
		 */
	     List<PositionTblBean> getPositionAll(B0101VueForm b0101VueForm);
		/**
		 * 職位をオンラインするとオフラインするまたは複数操作
		 * @param positionId
		 * @param onlineStatus
		 * @param companyId
		 * @param userCd
		 * @return INT型positionOnlineOrOfflineReturn（IB0101ServiceImpl）
		 */
		int positionOnlineOrOffline(List<Integer> positionIdList,
				String onlineStatus,Integer companyId,Integer userCd);
		/**
		 * 職位を削除または複数削除
		 * @param positionId
		 * @param companyId
		 * @param userCd
		 * @return　INT型positionDeleteReturn(IB0101ServiceImpl)
		 */
		int positionDelete(List<Integer> positionIdList,Integer companyId,Integer userCd);
		/**
		 * 職位をtopまたは複数top
		 * @param positionIdList
		 * @param companyId
		 * @param userCd
		 * @return
		 */
		int positionTop(List<Integer> positionIdList,
				String topStatus,Integer companyId,Integer userCd);
		
		
		/**
		 * 職位をtopまたは複数top
		 * @param bean
		 * @return PositionTblBean
		 */
		List<PositionTblBean> confirmOutput(List<PositionTblBean> bean) throws IOException;
		
}
