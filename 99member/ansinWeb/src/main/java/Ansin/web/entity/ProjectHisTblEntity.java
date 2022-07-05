package Ansin.web.entity;

import java.util.Date;

public class ProjectHisTblEntity {
			//プロジェクトID
			private Integer projectId;
			//応募者ID
			private Integer applicantId;
			//プロジェクト名前
			private String projectNm;
			//開始日付
			private Date proDateFrom;
			//終了日付
			private Date proDateTo;
			//プロジェクト内容
			private String proContent;
			//職務内容
			private String proDuties;
			//使用技術
			private String proTec;
			//役割
			private String proRole;
			//プロジェクト人数
			private int proCnt;
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
			
			public Integer getProjectId() {
				return projectId;
			}
			public void setProjectId(Integer projectId) {
				this.projectId = projectId;
			}
			public Integer getApplicantId() {
				return applicantId;
			}
			public void setApplicantId(Integer applicantId) {
				this.applicantId = applicantId;
			}
			public String getProjectNm() {
				return projectNm;
			}
			public void setProjectNm(String projectNm) {
				this.projectNm = projectNm;
			}
			public Date getProDateFrom() {
				return proDateFrom;
			}
			public void setProDateFrom(Date proDateFrom) {
				this.proDateFrom = proDateFrom;
			}
			public Date getProDateTo() {
				return proDateTo;
			}
			public void setProDateTo(Date proDateTo) {
				this.proDateTo = proDateTo;
			}
			public String getProContent() {
				return proContent;
			}
			public void setProContent(String proContent) {
				this.proContent = proContent;
			}
			public String getProDuties() {
				return proDuties;
			}
			public void setProDuties(String proDuties) {
				this.proDuties = proDuties;
			}
			public String getProTec() {
				return proTec;
			}
			public void setProTec(String proTec) {
				this.proTec = proTec;
			}
			public String getProRole() {
				return proRole;
			}
			public void setProRole(String proRole) {
				this.proRole = proRole;
			}
			public int getProCnt() {
				return proCnt;
			}
			public void setProCnt(int proCnt) {
				this.proCnt = proCnt;
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
