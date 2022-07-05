package Ansin.web.entity;

import java.util.Date;

public class CouMstEntity {
			//国ID
			private Integer countryId;
			//国名
			private String countryNm;
			//国番号
			private String countryZip;
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
			
			public Integer getCountryId() {
				return countryId;
			}
			public void setCountryId(Integer ountryId) {
				this.countryId = ountryId;
			}
			public String getCountryNm() {
				return countryNm;
			}
			public void setCountryNm(String countryNm) {
				this.countryNm = countryNm;
			}
			public String getCountryZip() {
				return countryZip;
			}
			public void setCountryZip(String countryZip) {
				this.countryZip = countryZip;
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
