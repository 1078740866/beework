package Ansin.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import Ansin.web.vueForm.B0802VueForm;

public interface CompanyCouponTblMapper {

		Integer insertCoupon(@Param("beans") List<B0802VueForm> beans);
		
}
