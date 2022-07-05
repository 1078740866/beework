package Ansin.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import Ansin.web.entity.CouponMstEntity;
import Ansin.web.entity.ComCouponTblEntity;

public interface CouponMstMapper {

		List<CouponMstEntity> getAll();
		
		/**
		 * 会社クーポン情報取得
		 * @param companyId
		 * @return List<comCouponTblEntity>
		 */
		List<ComCouponTblEntity> getCompanyAll(@Param("companyId") Integer companyId);
		
		/**
		 * 状態によると会社クーポンリスト情報取得
		 * @param companyId
		 * @param statusFlg
		 * @return List<comCouponTblEntity>
		 */
		List<ComCouponTblEntity> getCouponAll(@Param("companyId") Integer companyId,@Param("statusFlg") String statusFlg);
		
		/**
		 * 取得クーポン名前
		 * @param couponId
		 * @return ComCouponTblEntity
		 */
		String getCouponNm(@Param("couponId") Integer couponId);
		
}
