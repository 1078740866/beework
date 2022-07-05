<template>
  <div class="c0101DetailedStyle">
    <applicant-header v-if="applicantComputed" />
    <home-header v-else-if="companyComputed" />
    <administrator-header v-else-if="administratorComputed" />
    <personal-information-detailed
      :applicantInfoTblBean="applicantInfoTblBean"
      :userInfoBean="userInfoBean"
      :countryMstBean="countryMstBean"
      :industryMstBean="industryMstBean"
      :jobtypeMstBean="jobtypeMstBean"
      :prefecturesMstBean="prefecturesMstBean"
      :postalCode="postalCode"
    />
    <qualification-certificate-detailed :applicantQuaTblBean="applicantQuaTblBean" />
    <skill-information-detailed
      :applicantSkillTblBean="applicantSkillTblBean"
      :industryMstBean="industryMstBean"
      :jobtypeMstBean="jobtypeMstBean"
      :skillMstBean="skillMstBean"
    />
    <work-experience-detailed
      :applicantWorkHisTblBean="applicantWorkHisTblBean"
      :industryMstBean="industryMstBean"
      :jobtypeMstBean="jobtypeMstBean"
    />
    <language-skills-detailed
      :applicantLanTblBean="applicantLanTblBean"
      :lanMstBean="lanMstBean"
    />
    <educational-background-detailed :applicantEduTblBean="applicantEduTblBean" />
    <project-experience-detailed :projectHisTblBean="projectHisTblBean" />
    <div class="last-page-button">
      <el-tooltip
        :content="promptMessage.pageBack"
        effect="light"
        placement="bottom"
        :open-delay="400"
      >
        <el-button icon="el-icon-back" @click="goBack" circle />
      </el-tooltip>
    </div>
    <el-backtop class="page-top-button" :visibility-height="600">
      <el-button icon="el-icon-caret-top" circle />
    </el-backtop>
    <home-footer />
  </div>
</template>
<script>
import AdministratorHeader from "@/views/components/AdministratorHeader";
import HomeHeader from "@/views/components/HomeHeader";
import ApplicantHeader from "@/views/components/ApplicantHeader";
import HomeFooter from "@/views/components/HomeFooter";
import EducationalBackgroundDetailed from "./c01Detailed/EducationalBackgroundDetailed.vue";
import LanguageSkillsDetailed from "./c01Detailed/LanguageSkillsDetailed.vue";
import PersonalInformationDetailed from "./c01Detailed/PersonalInformationDetailed.vue";
import ProjectExperienceDetailed from "./c01Detailed/ProjectExperienceDetailed.vue";
import QualificationCertificateDetailed from "./c01Detailed/QualificationCertificateDetailed.vue";
import SkillInformationDetailed from "./c01Detailed/SkillInformationDetailed.vue";
import WorkExperienceDetailed from "./c01Detailed/WorkExperienceDetailed.vue";
export default {
  name: "c01Detailed",
  components: {
    AdministratorHeader,
    HomeHeader,
    ApplicantHeader,
    HomeFooter,
    EducationalBackgroundDetailed,
    LanguageSkillsDetailed,
    PersonalInformationDetailed,
    ProjectExperienceDetailed,
    QualificationCertificateDetailed,
    SkillInformationDetailed,
    WorkExperienceDetailed,
  },
  data() {
    return {
      titleName: "履歴書情報",
      applicantId: "",
      // 個人情報
      applicantInfoTblBean: {},
      // ユーザー情報
      userInfoBean: {},
      // 国籍
      countryMstBean: [],
      // 業種
      industryMstBean: [],
      // 職種
      jobtypeMstBean: [],
      // 希望地
      prefecturesMstBean: [],
      // 郵便番号
      postalCode: {
        postal1: "",
        postal2: "",
      },
      // 資格証
      applicantQuaTblBean: [],
      // スキル
      applicantSkillTblBean: [],
      // オールスキル
      skillMstBean: [],
      // 職歴
      applicantWorkHisTblBean: [],
      // 言語能力
      applicantLanTblBean: [],
      // オール言語
      lanMstBean: [],
      // 学歴
      applicantEduTblBean: [],
      // プロジェクト履歴
      projectHisTblBean: [],
      promptMessage: {
        backTop: "画面のトップへ戻る",
        pageBack: "前へ戻る",
      },
    };
  },
  created() {
    console.clear();
    document.title = this.titleName;
  },
  mounted() {
    this.setApplicantId();
    this.initData();
  },
  destroyed() {},
  computed: {
    administratorComputed() {
      var userName = sessionStorage.getItem("userNameA");
      return (
        userName != "" && userName != null && userName != undefined && userName != "null"
      );
    },
    companyComputed() {
      var userName = sessionStorage.getItem("userName");
      return (
        userName != "" && userName != null && userName != undefined && userName != "null"
      );
    },
    applicantComputed() {
      var userName = sessionStorage.getItem("userNameC");
      return (
        userName != "" && userName != null && userName != undefined && userName != "null"
      );
    },
  },
  methods: {
    setApplicantId() {
      // リフレッシュの場合、セットしない
      if (this.$route.query.applicantId) {
        // applicantIdをsessionにセット
        sessionStorage.setItem("applicantId", this.$route.query.applicantId);
      }
      this.applicantId = sessionStorage.getItem("applicantId");
    },
    // 初期表示
    initData() {
      this.$store
        .dispatch("getApplicant", parseInt(this.applicantId))
        .then((response) => {
          var responseData = response.data.data;
          console.log("responseData", responseData);
          var head = "data:image/jpeg;base64,";
          // C010101
          this.countryMstBean = responseData.countryMstBean;
          this.industryMstBean = responseData.industryMstBean;
          this.jobtypeMstBean = responseData.jobtypeMstBean;
          this.prefecturesMstBean = responseData.prefecturesMstBean;
          var postal = responseData.applicantInfoTblBean.applicantPostal;
          this.postalCode.postal1 = postal.split("-")[0];
          this.postalCode.postal2 = postal.split("-")[1];
          // C010103
          this.skillMstBean = responseData.skillMstBean;
          // C010105
          this.lanMstBean = responseData.lanMstBean;
          if (responseData.applicantInfoTblBean != null) {
            // C010101
            this.applicantInfoTblBean = responseData.applicantInfoTblBean;
            this.userInfoBean = responseData.userInfoBean;
            this.applicantInfoTblBean.photoPic =
              head + responseData.applicantInfoTblBean.photoPic;
            // C010102
            this.applicantQuaTblBean = responseData.applicantQuaTblBean;
            this.applicantQuaTblBean.forEach(function (item) {
              item.photoPic = head + item.photoPic;
            });
            // C010103
            this.applicantSkillTblBean = responseData.applicantSkillTblBean;
            // C010104
            this.applicantWorkHisTblBean = responseData.applicantWorkHisTblBean;
            // C010105
            this.applicantLanTblBean = responseData.applicantLanTblBean;
            // C010106
            this.applicantEduTblBean = responseData.applicantEduTblBean;
            this.applicantEduTblBean.forEach(function (item) {
              item.photoPic = head + item.photoPic;
            });
            // C010107
            this.projectHisTblBean = responseData.projectHisTblBean;
          }
        });
    },
    // 戻るボタン
    goBack() {
      this.$router.back();
    },
  },
};
</script>
<style lang="scss" scoped>
// テーブルヘッダ青字
::v-deep .el-table thead {
  color: #014099;
}
//背景色
.c0101DetailedStyle {
  background: -webkit-linear-gradient(top, #000099, #409eff);
  min-height: 98vh;
}
</style>
<style lang="scss">
// 画面の白い縁を削除
body {
  display: block;
  margin: 0;
}
// 前へボタン
.last-page-button {
  position: fixed;
  border-radius: 50%;
  display: flex;
  right: 3vw;
  top: 10vh;
}
// トップボタン
.page-top-button {
  position: fixed;
  border-radius: 50%;
  right: 3vw;
  top: 85vh;
}
</style>
