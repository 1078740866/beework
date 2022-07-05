package Ansin.web.entity;

import java.util.Date;

public class ApplicantQuaTblEntity {
	
			//応募者資格ID
			private Integer appQuaId;
			//応募者ID
			private Integer applicantId;
			//資格名
			private String quaNm;
			//資格番号
			private String quaNum;
			//資格画像アドレス
			private String quaAddress;
			//取得日
			private Date acquisitionDate;
			//備考
			private String remarks;
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
			public Integer getAppQuaId() {
				return appQuaId;
			}
			public void setAppQuaId(Integer appQuaId) {
				this.appQuaId = appQuaId;
			}
			public Integer getApplicantId() {
				return applicantId;
			}
			public void setApplicantId(Integer applicantId) {
				this.applicantId = applicantId;
			}
			public String getQuaNum() {
				return quaNum;
			}
			public void setQuaNum(String quaNum) {
				this.quaNum = quaNum;
			}
			public String getQuaAddress() {
				return quaAddress;
			}
			public void setQuaAddress(String quaAddress) {
				this.quaAddress = quaAddress;
			}
			public Date getAcquisitionDate() {
				return acquisitionDate;
			}
			public void setAcquisitionDate(Date acquisitionDate) {
				this.acquisitionDate = acquisitionDate;
			}
			public String getRemarks() {
				return remarks;
			}
			public void setRemarks(String remarks) {
				this.remarks = remarks;
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
			public String getQuaNm() {
				return quaNm;
			}
			public void setQuaNm(String quaNm) {
				this.quaNm = quaNm;
			}
			
			
}
