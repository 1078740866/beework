<template>
  <div class="c0101Style">
    <div>
      <applicant-header />
      <personal-information
        :applicantInfoTblBean="applicantInfoTblBean"
        :countryMstBean="countryMstBean"
        :industryMstBean="industryMstBean"
        :jobtypeMstBean="jobtypeMstBean"
        :prefecturesMstBean="prefecturesMstBean"
        :postalCode="postalCode"
        :flgData="flgData"
      />
      <qualification-certificate :applicantQuaTblBean="applicantQuaTblBean" />
      <skill-information
        :applicantSkillTblBean="applicantSkillTblBean"
        :industryMstBean="industryMstBean"
        :jobtypeMstBean="jobtypeMstBean"
        :skillMstBean="skillMstBean"
      />
      <work-experience
        :applicantWorkHisTblBean="applicantWorkHisTblBean"
        :industryMstBean="industryMstBean"
        :jobtypeMstBean="jobtypeMstBean"
      />
      <language-skills
        :applicantLanTblBean="applicantLanTblBean"
        :lanMstBean="lanMstBean"
      />
      <educational-background :applicantEduTblBean="applicantEduTblBean" />
      <project-experience :projectHisTblBean="projectHisTblBean" />
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
      <div class="detailed-button">
        <el-tooltip
          :content="promptMessage.detailed"
          effect="light"
          placement="bottom"
          :open-delay="400"
        >
          <el-button icon="el-icon-document" @click="toDetailed" circle />
        </el-tooltip>
      </div>
      <el-backtop class="page-top-button" :visibility-height="600">
        <el-button icon="el-icon-caret-top" circle />
      </el-backtop>
    </div>
    <home-footer />
  </div>
</template>

<script>
import ApplicantHeader from "@/views/components/ApplicantHeader";
import PersonalInformation from "@/views/c01/PersonalInformation";
import QualificationCertificate from "@/views/c01/QualificationCertificate";
import SkillInformation from "@/views/c01/SkillInformation.vue";
import WorkExperience from "@/views/c01/WorkExperience";
import LanguageSkills from "@/views/c01/LanguageSkills";
import EducationalBackground from "@/views/c01/EducationalBackground";
import ProjectExperience from "@/views/c01/ProjectExperience";
import HomeFooter from "@/views/components/HomeFooter";
export default {
  name: "c0101",
  components: {
    ApplicantHeader,
    PersonalInformation,
    QualificationCertificate,
    SkillInformation,
    WorkExperience,
    LanguageSkills,
    EducationalBackground,
    ProjectExperience,
    HomeFooter,
  },
  data() {
    return {
      titleName: "履歴書管理",
      // 個人情報
      applicantInfoTblBean: {},
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
      // 個人情報初期または修正の判断
      flgData: Number,
      promptMessage: {
        backTop: "画面のトップへ戻る",
        pageBack: "前へ戻る",
        detailed: "詳細確認",
      },
    };
  },
  created() {
    console.clear();
    // ページタイトルの切替
    document.title = this.titleName;
    // エラー対策: Unable to preventDefault inside passive event listener invocation
    window.addEventListener("touchmove", { passive: false });
    this.initData();
  },
  mounted() {
    // ブラウザのページジャンプ動作監視開始
    this.browserGoBack(true);
  },
  destroyed() {
    // ブラウザのページジャンプ動作監視終了
    this.browserGoBack(false);
  },
  methods: {
    // 戻るボタン
    goBack() {
      this.$router.push({ path: "/c0003" });
    },
    // 初期表示
    initData() {
      this.$store.dispatch("personalInformationInit").then((response) => {
        // 初期データを取得する
        this.$router
          .push({
            query: { data: response.data.data },
          })
          .catch(() => {});
        var responseData = response.data.data;
        var head = "data:image/jpeg;base64,";
        // C010101
        this.countryMstBean = responseData.countryMstBean;
        this.industryMstBean = responseData.industryMstBean;
        this.jobtypeMstBean = responseData.jobtypeMstBean;
        this.prefecturesMstBean = responseData.prefecturesMstBean;
        this.flgData = responseData.flgData;
        // C010103
        this.skillMstBean = responseData.skillMstBean;
        // C010105
        this.lanMstBean = responseData.lanMstBean;
        if (responseData.applicantInfoTblBean != null) {
          // C010101
          this.applicantInfoTblBean = responseData.applicantInfoTblBean;
          var postal = responseData.applicantInfoTblBean.applicantPostal;
          this.postalCode.postal1 = postal.split("-")[0];
          this.postalCode.postal2 = postal.split("-")[1];
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
    // TODO: 目標機能無効
    // ブラウザの前のページに戻るボタンをページ内の戻るボタンと一致させるため
    browserGoBack(bool) {
      // 監視開始
      if (bool == true) window.addEventListener("popstate", this.goBack, false);
      // 監視終了
      else window.removeEventListener("popstate", this.goBack, false);
    },
    // C0101 Detailed
    toDetailed() {
      console.log("session", sessionStorage.getItem("applicantId"));
      this.$router.push({
        path: "/c01Detailed",
        query: {
          applicantId: this.applicantInfoTblBean.applicantId,
        },
      });
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
.c0101Style {
  background: -webkit-linear-gradient(top, #000099, #409eff);
  min-height: 98vh;
}
// 前へボタン
.last-page-button {
  position: fixed;
  border-radius: 50%;
  display: flex;
  right: 3vw;
  top: 10vh;
}
// 詳細確認ボタン
.detailed-button {
  position: fixed;
  border-radius: 50%;
  display: flex;
  right: 3vw;
  top: 45vh;
}
// トップボタン
.page-top-button {
  position: fixed;
  border-radius: 50%;
  right: 3vw;
  top: 85vh;
}
</style>
<style lang="scss">
// 画面の白い縁を削除
body {
  display: block;
  margin: 0;
}
// el-date-picker内の選択ボタンを左から下に移動
.el-date-picker.has-sidebar {
  width: 320px;
  .el-picker-panel__sidebar {
    top: auto;
    width: 100%;
    border: none;
    .el-picker-panel__shortcut {
      border-top: 1px solid #dcdfe6;
      text-align: center;
      padding: 5px 0;
    }
  }
  .el-picker-panel__body {
    margin: 0;
    .el-picker-panel__content {
      width: auto;
      margin-bottom: 50px;
    }
  }
}
</style>
