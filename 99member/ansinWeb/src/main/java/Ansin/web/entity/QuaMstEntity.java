package Ansin.web.entity;

import java.util.Date;

public class QuaMstEntity {
	
		//資格ID
		private Integer quaId;
		//業種ID
		private Integer industryId;
		//資格名前
		private String quaNm;
		//有効期限
		private int expDate;
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
		public Integer getQuaId() {
			return quaId;
		}
		public void setQuaId(Integer quaId) {
			this.quaId = quaId;
		}
		public Integer getIndustryId() {
			return industryId;
		}
		public void setIndustryId(Integer industryId) {
			this.industryId = industryId;
		}
		public String getQuaNm() {
			return quaNm;
		}
		public void setQuaNm(String quaNm) {
			this.quaNm = quaNm;
		}
		public int getExpDate() {
			return expDate;
		}
		public void setExpDate(int expDate) {
			this.expDate = expDate;
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
