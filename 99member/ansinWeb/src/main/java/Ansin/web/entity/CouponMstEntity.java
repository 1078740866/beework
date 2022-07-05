package Ansin.web.entity;

import java.util.Date;

public class CouponMstEntity {
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
		//削除フラグ
		private String delFlg;
		//作成日時
		private Date createTime;
		//作成者
		private String createBy;
		//更新日時
		private Date updateTime;
		//更新者
		private String updateBy;
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
		public String getDelFlg() {
			return delFlg;
		}
		public void setDelFlg(String delFlg) {
			this.delFlg = delFlg;
		}
		public Date getCreateTime() {
			return createTime;
		}
		public void setCreateTime(Date createTime) {
			this.createTime = createTime;
		}
		public String getCreateBy() {
			return createBy;
		}
		public void setCreateBy(String createBy) {
			this.createBy = createBy;
		}
		public Date getUpdateTime() {
			return updateTime;
		}
		public void setUpdateTime(Date updateTime) {
			this.updateTime = updateTime;
		}
		public String getUpdateBy() {
			return updateBy;
		}
		public void setUpdateBy(String updateBy) {
			this.updateBy = updateBy;
		}
		
		
}
