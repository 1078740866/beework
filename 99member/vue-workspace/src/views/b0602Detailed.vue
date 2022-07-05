<template>
  <div class="b0602Vue">
    <el-container
      ><HomeHeader />
      <div class="b0602Body">
        <el-main>
          <el-form
            :model="detailedForm"
            ref="detailedForm"
            label-position="right"
          >
            <div class="b0602Title">
              <el-row>
                <el-col :span="2">
                  <div class="b0602Icon">
                    <el-image :src="require('@/assets/b_titleico3.png')" />
                  </div>
                </el-col>
                <el-col :span="22">
                  <div class="title_name">説明会詳細情報</div>
                </el-col>
              </el-row>
            </div>
            <div class="b0602Main">
              <div class="b0602TableDiv">
                <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="12">
                    <el-form-item
                      prop="briefingNm"
                      label="説明会名："
                      label-width="120px"
                      :required="true"
                    >
                      {{ detailedForm.briefingNm }}
                    </el-form-item>
                  </el-col>
                  <el-col :span="12">
                    <el-form-item
                      prop="briefingType"
                      label="説明会方式："
                      label-width="120px"
                      :required="true"
                    >
                    <template>
                    {{type [detailedForm.briefingType]}} 
                    </template>
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="12">
                    <el-form-item
                      prop="charge"
                      label="担当："
                      label-width="120px"
                      :required="true"
                    >
                      {{ detailedForm.charge }}
                    </el-form-item>
                  </el-col>
                  <el-col :span="12">
                    <el-form-item
                      prop="tel"
                      label="電話番号："
                      label-width="120px"
                      :required="true"
                    >
                      {{ detailedForm.tel }}
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="12">
                    <el-form-item
                      prop="date"
                      label="説明会日："
                      label-width="120px"
                      :required="true"
                    >
                      {{ detailedForm.briefingDate }}
                    </el-form-item>
                  </el-col>
                  <el-col :span="12">
                    <el-form-item
                      prop="time"
                      label="説明会時間："
                      label-width="120px"
                      :required="true"
                    >
                      {{ detailedForm.dateFrom }} - {{ detailedForm.dateTo }}
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="12">
                    <el-form-item
                      prop="postal"
                      label="郵便番号："
                      label-width="120px"
                      :required="true"
                    >
                      {{ detailedForm.postal }}
                    </el-form-item>
                  </el-col>
                  <el-col :span="12">
                    <el-form-item
                      prop="proCntPlan"
                      label="予定人数："
                      label-width="120px"
                      :required="true"
                    >
                      {{ detailedForm.proCntPlan }}人
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="24">
                    <el-form-item
                      prop="briefingAddress1"
                      label="説明会場所："
                      label-width="120px"
                      :required="true"
                    >
                      {{ detailedForm.briefingAddress1 }}
                    </el-form-item>
                  </el-col>
                  <el-col :span="24">
                      <el-form-item
                        prop="teaNm"
                        label="講師氏名："
                        label-width="120px"
                      >
                        {{ detailedForm.teaNm }}
                      </el-form-item>
                    </el-col>
                </el-row>
                <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="12">
                    <el-form-item
                      prop="briefingAddress2"
                      label="住所詳細："
                      label-width="120px"
                      :required="true"
                      class="newLine"
                    >
                      {{ detailedForm.briefingAddress2 }}
                    </el-form-item>
                  </el-col>
                   <el-col :span="12">
                    <el-form-item
                      prop="teaIntro"
                      label="講師説明："
                      label-width="120px"
                      class="newLine"
                    >
                      {{ detailedForm.teaIntro }}
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="12">
                    <el-form-item
                      prop="briefingContent"
                      label="説明会内容："
                      label-width="120px"
                      :required="true"
                      class="newLine"
                    >
                      {{ detailedForm.briefingContent }}
                    </el-form-item>
                  </el-col>
                    <el-col :span="12">
                    <el-form-item
                      prop="remarks"
                      label="備考："
                      label-width="120px"
                      class="newLine"
                    >
                      {{ detailedForm.remarks }}
                    </el-form-item>
                  </el-col>
                </el-row>
                
                <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="6">
                    <el-form-item
                      prop="photoAddress1"
                      label="説明会写真："
                      label-width="90px"
                    >
                      <div v-if="detailedForm.photoAddress1Pic!==''">
                        <img
                          :src="detailedForm.photoAddress1Pic"
                          class="avatar"
                          alt=""
                        />
                      </div>
                    </el-form-item>
                  </el-col>
                  <el-col :span="6">
                    <el-form-item prop="photoAddress2">
                      <div v-if="detailedForm.photoAddress2Pic!==''">
                        <img
                          :src="detailedForm.photoAddress2Pic"
                          class="avatar"
                          alt=""
                        />
                      </div>
                    </el-form-item>
                  </el-col>
                  <el-col :span="13">
                    <el-form-item prop="photoAddress3">
                      <div v-if="detailedForm.photoAddress3Pic!==''">
                        <img
                          :src="detailedForm.photoAddress3Pic"
                          class="avatar"
                          alt=""
                        />
                      </div>
                    </el-form-item>
                  </el-col>
                  <el-col :span="10" />
                </el-row>
              </div>
              <el-row v-show="this.flgData == '1'">
                <el-col :span="4" :offset="4">
                  <el-tooltip effect="light" content="承認" placement="top">
                    <el-button type="text" size="large" @click="confirmBriefingMulti">
                      <em class="el-icon-circle-check" />
                    </el-button>
                  </el-tooltip>
                </el-col>
                <el-col :span="4" :offset="2">
                  <el-tooltip effect="light" content="拒否" placement="top">
                    <el-button type="text" size="large" @click="denyBriefingMulti">
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
                  <el-button
                    type="primary"
                    class="b0602Button"
                    @click="toB0602Modify()"
                  >
                    情報修正
                  </el-button>
                </el-col>
                <el-col :span="4" :offset="2">
                  <el-button
                    type="primary"
                    @click="routerBack()"
                    class="b0602Button"
                  >
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
  name: "b0602",
  components: {
    HomeHeader,
    HomeFooter,
  },
  data() {
    return {
      detailedForm: {
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
      type: { 
        '0' : '現場',
        '1' : '生放送',
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
      A070105VueForm:{
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
    document.title = "説明会詳細情報";
    if (this.$route.query.flight) {
      this.detailedForm = JSON.parse(this.$route.query.flight);
    }
    if (this.$route.query.flgData) {
      this.flgData = JSON.parse(this.$route.query.flgData);
    }
    if (this.$route.query.flight2) {
      this.detailedForm1 = JSON.parse(this.$route.query.flight2);
    }
    console.log(this.detailedForm);
    this.photoAddress1 = "data:image/jpeg;base64," + this.registerForm.photoAddress1;
  },
  methods: {
    // 戻るボタン
    routerBack() {
      this.$router.replace({ name: "b0601" });
      this.$router.back(-1);
    },
    // 情報修正画面へ
    toB0602Modify() {
      console.clear();
      console.log("detailedForm:", this.detailedForm);
      this.$router.push({
        path: "/b0602Modify",
        query: { flight: JSON.stringify(this.detailedForm) },
      });
    },
    //a070105複数承認    
    confirmBriefingMulti() {
      this.A070105VueForm.statusFlg = "1";
      this.A070105VueForm.listData = [{briefingId : this.detailedForm.briefingId,companyId : this.detailedForm.companyId}];
      this.MessageBox();
    },
    //a070105複数拒否    
    denyBriefingMulti() {
      this.A070105VueForm.statusFlg = "2";
      this.A070105VueForm.listData = [{briefingId : this.detailedForm.briefingId,companyId : this.detailedForm.companyId}];
      this.MessageBox();
    },
    // a070105承認確認ポップアップ
    MessageBox() {
      if(this.A070105VueForm.statusFlg == "1"){
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
          .dispatch("a070105Confirm", this.A070105VueForm)
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
.b0602Body {
  background-color: #f6f6f6;
  width: 100%;
  left: 0px;
  top: 66px;
}
// 两个主体部分宽80vw，居中，边框阴影，白色背景
.b0602Title,
.b0602Main {
  width: 80vw;
  margin-left: 10vw;
  box-shadow: 0 2px 4px #dce5f4, 0 0 6px #dce5f4;
  background-color: #ffffff;
}
// div内上下距离
.b0602Main {
  padding-top: 5vh;
  padding-bottom: 5vh;
}
// 标题栏上下内外边距
.b0602Title {
  margin-top: 0px;
  margin-bottom: 15px;
  padding-top: 0px;
  padding-bottom: 0px;
}
// 标题栏图标宽，边距
.b0602Icon {
  width: 53px;
  margin-left: 26px;
  margin-top: 21px;
  margin-bottom: 21px;
}
// 标题位置大小颜色等
.title_name {
  color: #006699;
  font-weight: 400;
  font-size: 24px;
  margin-top: 35px;
  margin-bottom: 35px;
  margin-left: 14px;
}
// 上传图片尺寸限制在框内
.avatar {
  width: 150px;
  height: 150px;
}
// 表格div左边距
.b0602TableDiv {
  margin-left: 5vw;
  margin-right: 5vw;
}
// 下面三个按钮的宽度
.b0602Button {
  width: 100px;
}
// saveアイコンの大きさ
.el-icon-circle-check,
.el-icon-circle-close,
.el-icon-back
{
  font-size: 30px;
}
</style>
