package Ansin.web.entity;

import java.util.Date;

public class SkillMstEntity {
	
			//スキルID
			private Integer skillId;
			//スキル名
			private String skillNm;
			//業種ID
			private Integer industryId;
			//職種ID
			private Integer jobtypeId;
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
			public Integer getSkillId() {
				return skillId;
			}
			public void setSkillId(Integer skillId) {
				this.skillId = skillId;
			}
			public String getSkillNm() {
				return skillNm;
			}
			public void setSkillNm(String skillNm) {
				this.skillNm = skillNm;
			}
			public Integer getIndustryId() {
				return industryId;
			}
			public void setIndustryId(Integer industryId) {
				this.industryId = industryId;
			}
			public Integer getJobtypeId() {
				return jobtypeId;
			}
			public void setJobtypeId(Integer jobtypeId) {
				this.jobtypeId = jobtypeId;
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
