package Ansin.web.vueForm;

public class B0802VueForm {
			//userCd
			private Integer userCd;
			//会社ID	
			private Integer companyId;
			//クーポンID
			private Integer couponId;
			//有効期間
			private Integer expDays;
			//数量
			private Integer count;
			public Integer getUserCd() {
				return userCd;
			}
			public void setUserCd(Integer userCd) {
				this.userCd = userCd;
			}
			public Integer getCompanyId() {
				return companyId;
			}
			public void setCompanyId(Integer companyId) {
				this.companyId = companyId;
			}
			public Integer getCouponId() {
				return couponId;
			}
			public void setCouponId(Integer couponId) {
				this.couponId = couponId;
			}
			public Integer getExpDays() {
				return expDays;
			}
			public void setExpDays(Integer expDays) {
				this.expDays = expDays;
			}
			public Integer getCount() {
				return count;
			}
			public void setCount(Integer count) {
				this.count = count;
			}
			@Override
			public String toString() {
				return "B0802VueForm [userCd=" + userCd + ", companyId=" + companyId + ", couponId=" + couponId
						+ ", expDays=" + expDays + ", count=" + count + "]";
			}
			
			
			
}
