package Ansin.web.mapper;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import Ansin.web.entity.ComChargeTblEntity;
import Ansin.web.vueForm.B0803VueForm;

@Mapper
public interface ComChargeTblMapper {
	
	/**
	 * チャージ履歴リストを取得
	 * @param comcharge
	 * @param dateFroｍ
	 * @param dateTo
	 * @return List<ComchargeTblEntity>
	 */
	List<ComChargeTblEntity> getComchargeTblEntityList(
			@Param("comCharge")ComChargeTblEntity comCharge,
			@Param("dateFrom")Timestamp dateFrom,
			@Param("dateTo") Timestamp dateTo);
	
	/**
	 * 会社チャージ
	 * @param b0803VueForm
	 * @return Integer
	 */
	Integer gerCharge(@Param("b0803VueForm")B0803VueForm b0803VueForm);
	
	/**
	 * チャージ履歴状態変更
	 * @param companyId
	 * @param chargeId
	 * @return Integer
	 */
	Integer changeChargeFlg(@Param("companyId")Integer companyId, @Param("chargeId")Integer chargeId);
	
}
