package Ansin.web.bean;

public class CouponMstBean {
			//クーポンID
			private String couponId;       
			//クーポン名前
			private String couponNm;
			//必要なハニーポイント
			private String pointNum;
			//詳細内容
			private String detail;
			//有効期間
			private String expDays;
			public String getCouponId() {
				return couponId;
			}
			public void setCouponId(String couponId) {
				this.couponId = couponId;
			}
			public String getCouponNm() {
				return couponNm;
			}
			public void setCouponNm(String couponNm) {
				this.couponNm = couponNm;
			}
			public String getPointNum() {
				return pointNum;
			}
			public void setPointNum(String pointNum) {
				this.pointNum = pointNum;
			}
			public String getDetail() {
				return detail;
			}
			public void setDetail(String detail) {
				this.detail = detail;
			}
			public String getExpDays() {
				return expDays;
			}
			public void setExpDays(String expDays) {
				this.expDays = expDays;
			}
			
			
}
