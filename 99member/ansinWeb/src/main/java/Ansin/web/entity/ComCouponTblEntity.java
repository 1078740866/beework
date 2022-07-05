package Ansin.web.entity;

import java.sql.Timestamp;

public class ComCouponTblEntity {
		
		//会社クーポンID
		private Integer comCouId;
		//会社ID
		private Integer companyId;
		//使用状態
		private String statusFlg;
		//締切日
		private Timestamp deadline;
		//クーポンID
		private Integer couponId;       
		//クーポン名前
		private String couponNm;
		//必要なハニーポイント
		private Integer pointNum;
		//詳細内容
		private String detail;
		//有効期間
		private Integer expDays;

		
		public Integer getComCouId() {
			return comCouId;
		}
		public void setComCouId(Integer comCouId) {
			this.comCouId = comCouId;
		}
		public Integer getCompanyId() {
			return companyId;
		}
		public void setCompanyId(Integer companyId) {
			this.companyId = companyId;
		}
		public String getStatusFlg() {
			return statusFlg;
		}
		public void setStatusFlg(String statusFlg) {
			this.statusFlg = statusFlg;
		}
		public Timestamp getDeadline() {
			return deadline;
		}
		public void setDeadline(Timestamp deadline) {
			this.deadline = deadline;
		}
		public Integer getCouponId() {
			return couponId;
		}
		public void setCouponId(Integer couponId) {
			this.couponId = couponId;
		}
		public String getCouponNm() {
			return couponNm;
		}
		public void setCouponNm(String couponNm) {
			this.couponNm = couponNm;
		}
		public Integer getPointNum() {
			return pointNum;
		}
		public void setPointNum(Integer pointNum) {
			this.pointNum = pointNum;
		}
		public String getDetail() {
			return detail;
		}
		public void setDetail(String detail) {
			this.detail = detail;
		}
		public Integer getExpDays() {
			return expDays;
		}
		public void setExpDays(Integer expDays) {
			this.expDays = expDays;
		}
		@Override
		public String toString() {
			return "comCouponTblEntity [comCouId=" + comCouId + ", companyId=" + companyId + ", statusFlg=" + statusFlg
					+ ", deadline=" + deadline + ", couponId=" + couponId + ", couponNm=" + couponNm + ", pointNum="
					+ pointNum + ", detail=" + detail + ", expDays=" + expDays + ", getComCouId()=" + getComCouId()
					+ ", getCompanyId()=" + getCompanyId() + ", getStatusFlg()=" + getStatusFlg() + ", getDeadline()="
					+ getDeadline() + ", getCouponId()=" + getCouponId() + ", getCouponNm()=" + getCouponNm()
					+ ", getPointNum()=" + getPointNum() + ", getDetail()=" + getDetail() + ", getExpDays()="
					+ getExpDays() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
					+ super.toString() + "]";
		}
		
		
}
