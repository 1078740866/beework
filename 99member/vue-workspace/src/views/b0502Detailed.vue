<template>
  <div class="b0502Vue">
    <el-container
      ><HomeHeader />
      <div class="b0502Body">
        <el-main>
          <el-form :model="detailedForm" ref="detailedForm" label-position="right">
            <div class="b0502Title">
              <el-row>
                <el-col :span="2">
                  <div class="b0502Icon">
                    <el-image :src="require('@/assets/b_titleico3.png')" />
                  </div>
                </el-col>
                <el-col :span="22">
                  <div class="title_name">研修詳細情報</div>
                </el-col>
              </el-row>
            </div>
            <div class="b0502Main">
              <div class="b0502TableDiv">
                <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="12">
                    <el-form-item
                      prop="trainingNm"
                      label="研修会名："
                      label-width="100px"
                      :required="true"
                    >
                      {{ detailedForm.trainingNm }}
                    </el-form-item>
                  </el-col>
                  <el-col :span="12">
                    <el-form-item
                      prop="tel"
                      label="電話番号："
                      label-width="100px"
                      :required="true"
                    >
                      {{ detailedForm.tel }}
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="12">
                    <el-form-item
                      prop="industryId"
                      label="業種："
                      label-width="100px"
                      :required="true"
                    >
                      {{ detailedForm.industryNm }}
                    </el-form-item>
                  </el-col>
                  <el-col :span="12">
                    <el-form-item
                      prop="charge"
                      label="担当："
                      label-width="100px"
                      :required="true"
                    >
                      {{ detailedForm.charge }}
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="12">
                    <el-form-item
                      prop="date"
                      label="研修期間："
                      label-width="100px"
                      :required="true"
                    >
                      {{ detailedForm.dateFrom }} - {{ detailedForm.dateTo }}
                    </el-form-item>
                  </el-col>
                  <el-col :span="12">
                    <el-form-item
                      prop="time"
                      label="研修時間："
                      label-width="100px"
                      :required="true"
                    >
                      {{ detailedForm.timeFrom }} - {{ detailedForm.timeTo }}
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="12">
                    <el-form-item
                      prop="postal"
                      label="郵便番号："
                      label-width="100px"
                      :required="true"
                    >
                      {{ detailedForm.postal }}
                    </el-form-item>
                  </el-col>
                  <el-col :span="12">
                    <el-form-item
                      prop="proCnt"
                      label="人数："
                      label-width="100px"
                      :required="true"
                    >
                      {{ detailedForm.proCnt }}人
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="24">
                    <el-form-item
                      prop="trainingAddress1"
                      label="研修場所："
                      label-width="100px"
                      :required="true"
                    >
                      {{ detailedForm.trainingAddress1 }}
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="24">
                    <el-form-item
                      prop="trainingAddress2"
                      label="住所詳細："
                      label-width="100px"
                      :required="true"
                    >
                      {{ detailedForm.trainingAddress2 }}
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="12">
                    <el-form-item
                      prop="trainingContent"
                      label="研修内容："
                      label-width="100px"
                      :required="true"
                      class="newLine"
                    >
                      {{ detailedForm.trainingContent }}
                    </el-form-item>
                  </el-col>
                  <el-col :span="12">
                    <el-col :span="24">
                      <el-form-item prop="cost" label="料金：" label-width="100px">
                        {{ detailedForm.cost }}円
                      </el-form-item>
                    </el-col>
                    <el-col :span="24">
                      <el-form-item prop="teaNm" label="講師氏名：" label-width="100px">
                        {{ detailedForm.teaNm }}
                      </el-form-item>
                    </el-col>
                  </el-col>
                </el-row>
                <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="12">
                    <el-form-item
                      prop="remarks"
                      label="備考："
                      label-width="100px"
                      class="newLine"
                    >
                      {{ detailedForm.remarks }}
                    </el-form-item>
                  </el-col>
                  <el-col :span="12">
                    <el-form-item
                      prop="teaIntro"
                      label="講師説明："
                      label-width="100px"
                      class="newLine"
                    >
                      {{ detailedForm.teaIntro }}
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="6">
                    <el-form-item
                      prop="trainingPic1"
                      label="研修写真："
                      label-width="100px"
                    >
                      <div>
                        <img :src="detailedForm.trainingPic1" class="avatar" alt="" />
                      </div>
                    </el-form-item>
                  </el-col>
                  <el-col :span="4">
                    <el-form-item prop="trainingPic2">
                      <div>
                        <img :src="detailedForm.trainingPic2" class="avatar" alt="" />
                      </div>
                    </el-form-item>
                  </el-col>
                  <el-col :span="4">
                    <el-form-item prop="trainingPic3">
                      <div>
                        <img :src="detailedForm.trainingPic3" class="avatar" alt="" />
                      </div>
                    </el-form-item>
                  </el-col>
                  <el-col :span="10" />
                </el-row>
              </div>
              <el-row v-show="this.flgData == '1'">
                <el-col :span="4" :offset="4">
                  <el-tooltip effect="light" content="承認" placement="top">
                    <el-button type="text" size="large" @click="confirmTrainingMulti">
                      <em class="el-icon-circle-check" />
                    </el-button>
                  </el-tooltip>
                </el-col>
                <el-col :span="4" :offset="2">
                  <el-tooltip effect="light" content="拒否" placement="top">
                    <el-button type="text" size="large" @click="denyTrainingMulti">
                      <em class="el-icon-circle-close" />
                    </el-button>
                  </el-tooltip>
                </el-col>
                <el-col :span="4" :offset="2">
                  <el-tooltip effect="light" content="戻る" placement="top">
                    <el-button type="text" size="large" @click="toLastPage">
                      <em class="el-icon-back" />
                    </el-button>
                  </el-tooltip>
                </el-col>
              </el-row>
              <el-row v-show="this.flgData == '2'">
                <el-col :span="4" :offset="10">
                  <el-tooltip effect="light" content="戻る" placement="top">
                    <el-button type="text" size="large" @click="toLastPage2">
                      <em class="el-icon-back" />
                    </el-button>
                  </el-tooltip>
                </el-col>
              </el-row>
              <el-row v-show="this.flgData == ''?true:false">
                <el-col :span="4" :offset="7">
                  <el-button type="primary" class="b0502Button" @click="toB0502Modify()">
                    情報修正
                  </el-button>
                </el-col>
                <el-col :span="4" :offset="2">
                  <el-button type="primary" @click="routerBack()" class="b0502Button">
                    戻る
                  </el-button>
                </el-col>
              </el-row>
            </div>
          </el-form>
        </el-main>
      </div>
      <el-footer><HomeFooter /></el-footer>
    </el-container>
  </div>
</template>
<script>
import HomeHeader from "./components/HomeHeader";
import HomeFooter from "./components/HomeFooter";
export default {
  name: "b0502",
  components: {
    HomeHeader,
    HomeFooter,
  },
  data() {
    return {
      detailedForm: {
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
      detailedForm1: {
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
      flgData: "",
      //他用
      A070104VueForm:{
        statusFlg: "",
        listData: [],
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
    document.title = "研修詳細情報";
    if (this.$route.query.flight) {
      this.detailedForm = JSON.parse(this.$route.query.flight);
    }
    if (this.$route.query.flgData) {
      this.flgData = JSON.parse(this.$route.query.flgData);
    }
    if (this.$route.query.flight2) {
      this.detailedForm1 = JSON.parse(this.$route.query.flight2);
    }
    console.clear();
  },
  methods: {
    // 戻るボタン
    routerBack() {
      history.go(-1);
    },
    // 情報修正画面へ
    toB0502Modify() {
      console.clear();
      console.log("detailedForm:", this.detailedForm);
      this.$router.push({
        path: "/b0502Modify",
        query: { flight: JSON.stringify(this.detailedForm) },
      });
    },
    //a070104複数承認    
    confirmTrainingMulti() {
      this.A070104VueForm.statusFlg = "1";
      this.A070104VueForm.listData = [{trainingId : this.detailedForm.trainingId,companyId : this.detailedForm.companyId}];
      this.MessageBox();
    },
    //a070104複数拒否    
    denyTrainingMulti() {
      this.A070104VueForm.statusFlg = "2";
      this.A070104VueForm.listData = [{trainingId : this.detailedForm.trainingId,companyId : this.detailedForm.companyId}];
      this.MessageBox();
    },
    // a070104承認確認ポップアップ
    MessageBox() {
      if(this.A070104VueForm.statusFlg == "1"){
        this.approvalMessage = this.approvalMessageSuc;
      }else{
        this.approvalMessage = this.approvalMessageErr;
      }
      this.$confirm(this.approvalMessage.message, this.approvalMessage.title, {
        confirmButtonText: this.approvalMessage.yes,
        cancelButtonText: this.approvalMessage.no,
        type: "warning",
      })
      .then(() => {
        this.$store
          .dispatch("a070104Confirm", this.A070104VueForm)
            .then((response) => {
              this.$router.push({
                query: { data: response.data.data },
              });
              let code = response.data.code;
              if (code == 200) {
                this.$message({
                  type: "success",
                  message: this.approvalMessage.success,
                });
                this.$router.push({
                  path: "/a0701",
                });
              }else {
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
    toLastPage() {
      this.$router.push({
        path: "/a0701",
      });
    },
    toLastPage2() {
      this.$router.push({
        path: "/a0602",
        query: { flight: JSON.stringify(this.detailedForm1) },
      });
    },
  },
};
</script>
<style lang="scss" scoped>
// 全屏主体灰色背景
.b0502Body {
  background-color: #f6f6f6;
  width: 100%;
  left: 0px;
  top: 66px;
}
// 两个主体部分宽80vw，居中，边框阴影，白色背景
.b0502Title,
.b0502Main {
  width: 80vw;
  margin-left: 10vw;
  box-shadow: 0 2px 4px #dce5f4, 0 0 6px #dce5f4;
  background-color: #ffffff;
}
// div内上下距离
.b0502Main {
  padding-top: 5vh;
  padding-bottom: 5vh;
}
// 标题栏上下内外边距
.b0502Title {
  margin-top: 0px;
  margin-bottom: 15px;
  padding-top: 0px;
  padding-bottom: 0px;
}
// 标题栏图标宽，边距
.b0502Icon {
  width: 53px;
  margin-left: 26px;
  margin-top: 21px;
  margin-bottom: 21px;
}
// 标题位置大小颜色等
.title_name {
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
.b0502TableDiv {
  margin-left: 5vw;
}
// 下面三个按钮的宽度
.b0502Button {
  width: 100px;
}
// 换行符识别
.newLine {
  white-space: pre-wrap;
}
// saveアイコンの大きさ
.el-icon-circle-check,
.el-icon-circle-close,
.el-icon-back
{
  font-size: 30px;
}
</style>
