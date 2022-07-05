package Ansin.web.service;

import java.util.List;

import Ansin.web.bean.PositionTblBean;
import Ansin.web.entity.B0003UserEntity;

public interface C0003Service {

	/**
	 * 職位一覧リスト
	 * @param companyId
	 * @param userCd
	 * @return List<PositionTblBean>
	 */
	List<PositionTblBean> getPosition(Integer userCd);
	/**
	 * ユーザー情報
	 * @param companyId
	 * @param userCd
	 * @return B0003UserEntity
	 */
	B0003UserEntity getInfo(Integer companyId,Integer userCd);
}
