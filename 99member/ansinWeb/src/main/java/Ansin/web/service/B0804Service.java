package Ansin.web.service;

import java.sql.Timestamp;
import java.util.List;

import Ansin.web.bean.ComChargeTblBean;
import Ansin.web.bean.ComConsTblBean;
import Ansin.web.entity.ComChargeTblEntity;
import Ansin.web.entity.ComConsTblEntity;

public interface B0804Service {

	// チャージ履歴リストを取得
	List<ComChargeTblBean> getComchargeTblEntityList(ComChargeTblEntity comCharge,Timestamp dateFrom,Timestamp dateTo);
	
	// 消費履歴リストを取得
	List<ComConsTblBean> getComconsTblEntityList(ComConsTblEntity comCons,Timestamp dateFrom,Timestamp dateTo);
	
	//チャージ状態変更
	Integer changeChargeFlg(Integer companyId,Integer chargeId);
	
	//会社データ更新
	Integer changeCom(Integer companyId,Integer Money,Integer coin);
	
}
