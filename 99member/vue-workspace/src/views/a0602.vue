<template>
  <div class="a0602Vue">
    <el-container
      ><system-header />
      <div class="a0602Body">
        <el-main>
          <el-form :model="detailedForm" ref="detailedForm" label-position="right">
            <div class="a0602Title">
              <el-row>
                <el-col :span="2">
                  <div class="a0602Icon">
                    <el-image :src="require('@/assets/b_titleico2.png')" />
                  </div>
                </el-col>
                <el-col :span="22">
                  <div v-text="titleName" class="titleNameStyle" />
                </el-col>
              </el-row>
            </div>
            <div class="a0602Main">
              <div class="a0602TableDiv">
                <el-row type="flex" justify="space-between">
                  <el-col :span="8">
                    <el-row :gutter="20" type="flex" justify="space-between">
                      <el-col :span="24">
                        <el-form-item
                          prop="name"
                          label="通報スクリーンショット"
                          label-width="200px"
                        >
                        </el-form-item>
                      </el-col>
                    </el-row>
                    <el-row :gutter="20" type="flex" justify="space-between">
                      <el-col :span="24">
                        <el-form-item label-width="100px">
                          <el-image
                            :src="detailedForm.screenshot"
                            fit="contain"
                            class="image-style"
                          >
                            <div slot="error">
                              <em class="el-icon-postcard" />
                            </div>
                          </el-image>
                        </el-form-item>
                      </el-col>
                    </el-row>
                    <el-row
                      :gutter="20"
                      type="flex"
                      justify="space-between"
                      v-show="detailedForm.reportSection == '0' ? true : false"
                    >
                      <el-col :span="24">
                        <el-form-item prop="" label-width="55px">
                          <el-button type="primary" @click="goToApplicantInfo">
                            ページジャンプ
                          </el-button>
                        </el-form-item>
                      </el-col>
                    </el-row>
                    <el-row
                      :gutter="20"
                      type="flex"
                      justify="space-between"
                      v-show="detailedForm.positionId ? true : false"
                    >
                      <el-col :span="24">
                        <el-form-item prop="" label-width="55px">
                          <el-button type="primary" @click="goToPositionInfo">
                            ページジャンプ
                          </el-button>
                        </el-form-item>
                      </el-col>
                    </el-row>
                    <el-row
                      :gutter="20"
                      type="flex"
                      justify="space-between"
                      v-show="detailedForm.trainingId ? true : false"
                    >
                      <el-col :span="24">
                        <el-form-item prop="" label-width="55px">
                          <el-button type="primary" @click="goToTrainingInfo">
                            ページジャンプ
                          </el-button>
                        </el-form-item>
                      </el-col>
                    </el-row>
                    <el-row
                      :gutter="20"
                      type="flex"
                      justify="space-between"
                      v-show="detailedForm.briefingId ? true : false"
                    >
                      <el-col :span="24">
                        <el-form-item prop="" label-width="55px">
                          <el-button type="primary" @click="goToBriefingInfo">
                            ページジャンプ
                          </el-button>
                        </el-form-item>
                      </el-col>
                    </el-row>
                  </el-col>
                  <el-col :span="16">
                    <el-row :gutter="20" type="flex" justify="space-between">
                      <el-col :span="12">
                        <el-form-item
                          prop="reportSection"
                          label="通報区分："
                          label-width="100px"
                        >
                          {{ rsSet[detailedForm.reportSection] }}
                        </el-form-item>
                      </el-col>
                    </el-row>
                    <el-row :gutter="20" type="flex" justify="space-between">
                      <el-col :span="12">
                        <el-form-item
                          prop="typeSection"
                          label="種類区分："
                          label-width="100px"
                        >
                          {{ tsSet[detailedForm.typeSection] }}
                        </el-form-item>
                      </el-col>
                    </el-row>
                    <el-row
                      :gutter="20"
                      type="flex"
                      justify="space-between"
                      v-show="detailedForm.positionId ? true : false"
                    >
                      <el-col :span="12">
                        <el-form-item
                          prop="positionId"
                          label="職位名："
                          label-width="100px"
                        >
                          {{ detailedForm.positionNm }}
                        </el-form-item>
                      </el-col>
                    </el-row>
                    <el-row
                      :gutter="20"
                      type="flex"
                      justify="space-between"
                      v-show="detailedForm.trainingId ? true : false"
                    >
                      <el-col :span="12">
                        <el-form-item
                          prop="tariningId"
                          label="研修会名："
                          label-width="100px"
                        >
                          {{ detailedForm.trainingNm }}
                        </el-form-item>
                      </el-col>
                    </el-row>
                    <el-row
                      :gutter="20"
                      type="flex"
                      justify="space-between"
                      v-show="detailedForm.briefingId ? true : false"
                    >
                      <el-col :span="12">
                        <el-form-item
                          prop="briefingId"
                          label="説明会名："
                          label-width="100px"
                        >
                          {{ detailedForm.briefingNm }}
                        </el-form-item>
                      </el-col>
                    </el-row>
                    <el-row :gutter="20" type="flex" justify="space-between">
                      <el-col :span="12">
                        <el-form-item
                          prop="whistleblower"
                          label="通報者："
                          label-width="100px"
                        >
                          {{ detailedForm.whistleblower }}
                        </el-form-item>
                      </el-col>
                    </el-row>
                    <el-row :gutter="20" type="flex" justify="space-between">
                      <el-col :span="12">
                        <el-form-item
                          prop="whistleblowered"
                          label="被通報者："
                          label-width="100px"
                        >
                          {{ detailedForm.whistleblowered }}
                        </el-form-item>
                      </el-col>
                    </el-row>
                    <el-row :gutter="20" type="flex" justify="space-between">
                      <el-col :span="20">
                        <el-form-item
                          prop="reportText"
                          label="通報内容："
                          label-width="100px"
                          class="newLine"
                        >
                          {{ detailedForm.reportText }}
                        </el-form-item>
                      </el-col>
                    </el-row>
                    <el-row type="flex" justify="space-between">
                      <el-col :span="3" :offset="2">
                        <el-tooltip effect="light" content="通報成功" placement="top">
                          <el-link
                            @click="toReportConfirm"
                            type="primary"
                            :underline="false"
                          >
                            <i class="el-icon-circle-check"></i>
                          </el-link>
                        </el-tooltip>
                      </el-col>
                      <el-col :span="3" :offset="2">
                        <el-tooltip effect="light" content="通報失敗" placement="top">
                          <el-link
                            @click="toReportDeny"
                            type="primary"
                            :underline="false"
                          >
                            <i class="el-icon-circle-close"></i>
                          </el-link>
                        </el-tooltip>
                      </el-col>
                      <el-col :span="3" :offset="2">
                        <el-tooltip effect="light" content="戻る" placement="top">
                          <el-link @click="routerBack" type="primary" :underline="false">
                            <i class="el-icon-back"></i>
                          </el-link>
                        </el-tooltip>
                      </el-col>
                    </el-row>
                  </el-col>
                </el-row>
              </div>
            </div>
          </el-form>
        </el-main>
      </div>
      <el-footer><HomeFooter /></el-footer>
    </el-container>
  </div>
</template>
<script>
import SystemHeader from "./components/SystemHeader";
import HomeFooter from "./components/HomeFooter";
export default {
  name: "a0602",
  components: {
    SystemHeader,
    HomeFooter,
  },
  data() {
    return {
      // タイトル名
      titleName: "通報詳細情報",
      detailedForm: {
        applicantId: "",
        interviewId: "",
        reportSection: "",
        processingSection: "",
        whistleblower: "",
        whistleblowered: "",
        typeSection: "",
        reportText: "",
        screenshot: "",
        updateTime: "",
        positionId: "",
        positionNm: "",
        briefingId: "",
        briefingNm: "",
        companyId: "",
        companyNm: "",
        trainingId: "",
        trainingNm: "",
        reportId: "",
      },
      //職位データ
      detailedForm1: {
        industryId: "",
        positionId: "",
        jobTypeId: "",
        industryNm: "",
        jobTypeNm: "",
        positionNm: "",
        defaultYear: "",
        expDate: "",
        degree: "",
        workTimeFrom: "",
        workTimeTo: "",
        salarySection: "",
        positionInt: "",
        salaryMin: "",
        salaryMax: "",
        empLaborIns: "",
        workContent: "",
        welfare: "",
        expYears: "",
        trainingFlg: "",
        inspectionFlg: "",
        conUpdFlg: "",
        peoCnt: "",
        workDateStr: "",
        holiday: "",
        postal: "",
        workAddress1: "",
        workAddress2: "",
        station: "",
        contractSection: "",
        workingAddress1: "",
        workingAddress2: "",
        workingAddress3: "",
      },
      //研修会データ
      detailedForm2: {
        trainingNm: "",
        tel: "",
        industryNm: "",
        charge: "",
        dateFrom: "",
        dateTo: "",
        timeFrom: "",
        timeTo: "",
        postal: "",
        proCnt: "",
        trainingAddress1: "",
        trainingAddress2: "",
        trainingContent: "",
        cost: "",
        teaNm: "",
        remarks: "",
        teaIntro: "",
        trainingPic1: "",
        trainingPic2: "",
        trainingPic3: "",
        companyId: "",
        companyNm: "",
        industryId: "",
        prefeNm: "",
        statusFlg: "",
        trainingId: "",
      },
      //説明会データ
      detailedForm3: {
        briefingId: "",
        companyId: "",
        companyNm: "",
        briefingNm: "",
        briefingType: "",
        briefingDate: "",
        dateFrom: "",
        dateTo: "",
        postal: "",
        prefeNm: "",
        briefingAddress1: "",
        briefingAddress2: "",
        briefingContent: "",
        proCntPlan: "",
        teaNm: "",
        teaIntro: "",
        tel: "",
        charge: "",
        photoAddress1: "",
        photoAddress2: "",
        photoAddress3: "",
        statusFlg: "",
        remarks: "",
      },
      // 転送用form
      a0601VueForm: {
        typeSection: "",
        reportSection: "",
        statusFlg: "",
        reportId: Number,
        reportIds: [],
      },
      positionId: Number,
      trainingId: Number,
      briefingId: Number,
      // 通報区分
      tsSet: {
        0: "職位",
        1: "研修",
        2: "説明会",
        3: "個人",
      },
      rsSet: {
        0: "応募者を通報",
        1: "会社を通報",
      },
      // 承認メッセージ内容
      approvalMessageSuc: {
        title: "承認",
        message: "本当に承認しますか？",
        yes: "はい",
        no: "いいえ",
        success: "承認が成功しました",
        failed: "承認が失敗しました、もう一度お願いします",
        cancel: "承認は取り消されました",
      },
      approvalMessageErr: {
        title: "拒否",
        message: "本当に拒否しますか？",
        yes: "はい",
        no: "いいえ",
        success: "拒否が成功しました",
        failed: "拒否が失敗しました、もう一度お願いします",
        cancel: "拒否は取り消しされました",
      },
    };
  },
  mounted() {
    // ページタイトルの切替
    document.title = this.titleName;
    this.detailedForm = JSON.parse(this.$route.query.flight);
    if (this.detailedForm.positionId) {
      this.getPosition();
    } else if (this.detailedForm.trainingId) {
      this.getTraining();
    } else if (this.detailedForm.briefingId) {
      this.getBriefing();
    }
    // else{
    //   this.
    // }
  },
  methods: {
    // 戻るボタン
    routerBack() {
      this.$router.push({
        path: "/a0601",
      });
    },
    // 職位データ取得
    getPosition() {
      this.positionId = parseInt(this.detailedForm.positionId);
      this.$store.dispatch("a0602Position", this.positionId).then((response) => {
        // テーブルデータを取得する
        this.detailedForm1 = response.data.data;
      });
    },
    // 研修会データ取得
    getTraining() {
      this.trainingId = parseInt(this.detailedForm.trainingId);
      this.$store.dispatch("a0602Training", this.trainingId).then((response) => {
        // テーブルデータを取得する
        this.detailedForm2 = response.data.data;
      });
    },
    // 説明会データ取得
    getBriefing() {
      this.briefingId = parseInt(this.detailedForm.briefingId);
      this.$store.dispatch("a0602Briefing", this.briefingId).then((response) => {
        // テーブルデータを取得する
        this.detailedForm3 = response.data.data;
      });
    },
    // 応募者履歴詳細へのボタン
    goToApplicantInfo() {
      setTimeout(() => {
        this.$router.push({
          path: "/c01Detailed",
          query: {
            applicantId: this.detailedForm.applicantId,
          },
        });
      }, 1);
    },
    // 職位詳細へのボタン
    goToPositionInfo() {
      this.$router.push({
        path: "/b0102Detailed",
        query: {
          flight: JSON.stringify(this.detailedForm1),
          flight2: JSON.stringify(this.detailedForm),
          flgData: JSON.stringify("2"),
        },
      });
    },
    // 研修会詳細へのボタン
    goToTrainingInfo() {
      setTimeout(() => {
        this.$router.push({
          path: "/b0502Detailed",
          query: {
            flight: JSON.stringify(this.detailedForm2),
            flight2: JSON.stringify(this.detailedForm),
            flgData: JSON.stringify("2"),
          },
        });
      }, 1);
    },
    // 説明会詳細へのボタン
    goToBriefingInfo() {
      setTimeout(() => {
        this.$router.push({
          path: "/b0602Detailed",
          query: {
            flight: JSON.stringify(this.detailedForm3),
            flight2: JSON.stringify(this.detailedForm),
            flgData: JSON.stringify("2"),
          },
        });
      }, 1);
    },
    // a0602当行目データ承认
    toReportConfirm() {
      this.a0601VueForm.statusFlg = "1";
      this.a0601VueForm.reportIds = [this.detailedForm.reportId];
      this.reportConfirmMessageBox();
    },
    // a0602当行目データ拒否
    toReportDeny() {
      this.a0601VueForm.statusFlg = "2";
      this.a0601VueForm.reportIds = [this.detailedForm.reportId];
      this.reportConfirmMessageBox();
    },
    // a0602承認確認ポップアップ
    reportConfirmMessageBox() {
      if (this.a0601VueForm.statusFlg == "1") {
        this.approvalMessage = this.approvalMessageSuc;
      } else {
        this.approvalMessage = this.approvalMessageErr;
      }
      this.$confirm(this.approvalMessage.message, this.approvalMessage.title, {
        confirmButtonText: this.approvalMessage.yes,
        cancelButtonText: this.approvalMessage.no,
        type: "warning",
      })
        .then(() => {
          this.$store.dispatch("a0601Confirm", this.a0601VueForm).then((response) => {
            let code = response.data.code;
            if (code == 200) {
              this.$message({
                type: "success",
                message: this.approvalMessage.success,
              });
              this.$router.push({
                path: "/a0601",
              });
            } else {
              this.$message({
                type: "info",
                message: this.approvalMessage.failed,
              });
            }
          });
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: this.approvalMessage.cancel,
          });
        });
    },
  },
};
</script>
<style lang="scss" scoped>
// 全屏主体灰色背景
.a0602Body {
  background-color: #f6f6f6;
  width: 100%;
  left: 0px;
  top: 66px;
}
// 两个主体部分宽80vw，居中，边框阴影，白色背景
.a0602Title,
.a0602Main {
  width: 80vw;
  margin-left: 10vw;
  box-shadow: 0 2px 4px #dce5f4, 0 0 6px #dce5f4;
  background-color: #ffffff;
}
// div内上下距离
.a0602Main {
  padding-top: 5vh;
  padding-bottom: 5vh;
}
// 标题栏上下内外边距
.a0602Title {
  margin-top: 0px;
  margin-bottom: 15px;
  padding-top: 0px;
  padding-bottom: 0px;
}
// 标题栏图标宽，边距
.a0602Icon {
  width: 53px;
  margin-left: 26px;
  margin-top: 21px;
  margin-bottom: 21px;
}
// 标题位置大小颜色等
.titleNameStyle {
  color: #006699;
  font-weight: 600;
  font-size: 2em;
  padding: 4vh;
  padding-left: 1vh;
}
// 上传图片尺寸限制在框内
.avatar {
  width: 150px;
  height: 150px;
}
// 表格div左边距
.a0602TableDiv {
  margin-left: 5vw;
  margin-right: 5vw;
}
// 下面三个按钮的宽度
.a0602Button {
  width: 100px;
}
// 换行符识别
.newLine {
  white-space: pre-wrap;
}
//el-col中内容为空，则这个el-col整体就不显示
.el-col {
  min-height: 1px;
}
// saveアイコンの大きさ
.el-icon-circle-check,
.el-icon-circle-close,
.el-icon-document-remove,
.el-icon-back,
.el-icon-search,
.el-icon-zoom-in,
.el-icon-postcard {
  font-size: 30px;
}
// 画像サイズ
.image-style {
  max-width: 150px;
}
</style>
