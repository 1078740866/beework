package Ansin.web.vueForm;

public class C010103VueForm {
	
			//sessionから会社ID
			private Integer companyId;
			//sessionから会社usercd
			private Integer userCd;
			//応募者スキルID
			private Integer appSkillId;
			//応募者ID								
			private Integer applicantId;						
			//スキルID
			private Integer skillId;						
			//経験区分
			private String expSection;						
			//その他名前
			private String otherNm;
			public Integer getCompanyId() {
				return companyId;
			}
			public void setCompanyId(Integer companyId) {
				this.companyId = companyId;
			}
			public Integer getUserCd() {
				return userCd;
			}
			public void setUserCd(Integer userCd) {
				this.userCd = userCd;
			}
			public Integer getAppSkillId() {
				return appSkillId;
			}
			public void setAppSkillId(Integer appSkillId) {
				this.appSkillId = appSkillId;
			}
			public Integer getApplicantId() {
				return applicantId;
			}
			public void setApplicantId(Integer applicantId) {
				this.applicantId = applicantId;
			}
			public Integer getSkillId() {
				return skillId;
			}
			public void setSkillId(Integer skillId) {
				this.skillId = skillId;
			}
			public String getExpSection() {
				return expSection;
			}
			public void setExpSection(String expSection) {
				this.expSection = expSection;
			}
			public String getOtherNm() {
				return otherNm;
			}
			public void setOtherNm(String otherNm) {
				this.otherNm = otherNm;
			}
			
			
			
}
