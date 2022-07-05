<template>
  <div class="b0102Vue">
    <el-container
      ><HomeHeader />
      <div class="b0102Body">
        <el-main>
          <el-form :model="detailedForm" ref="detailedForm" label-position="right">
            <div class="b0102Title">
              <el-row>
                <el-col :span="2">
                  <div class="b0102Icon">
                    <el-image :src="require('@/assets/b_titleico3.png')" />
                  </div>
                </el-col>
                <el-col :span="22">
                  <div class="title_name">職位詳細情報</div>
                </el-col>
              </el-row>
            </div>
            <div class="b0102Main">
              <div class="b0102TableDiv">
                <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="12">
                    <el-form-item
                      prop="positionNm"
                      label="職位名："
                      label-width="100px"
                      :required="true"
                    >
                      {{ detailedForm.positionNm }}
                    </el-form-item>
                  </el-col>
                  <el-col :span="12">
                    <el-form-item
                      prop="expYears"
                      label="必須経験年数："
                      label-width="130px"
                      :required="true"
                    >
                    <template>
                      {{expYears [detailedForm.expYears] }}
                    </template>
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="12">
                    <el-form-item
                      prop="industryNm"
                      label="業種："
                      label-width="100px"
                      :required="true"
                    >
                      {{ detailedForm.industryNm }}
                    </el-form-item>
                  </el-col>
                  <el-col :span="12">
                    <el-form-item
                      prop="jobTypeNm"
                      label="職種："
                      label-width="130px"
                      :required="true"
                    >
                      {{ detailedForm.jobTypeNm }}
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="12">
                    <el-form-item
                      prop="skillNm"
                      label="スキル："
                      label-width="100px"
                      :required="true"
                    >
                      {{ detailedForm.skillNm }}
                    </el-form-item>
                  </el-col>
                  <el-col :span="12">
                    <el-form-item
                      prop="degree"
                      label="学歴要求："
                      label-width="130px"
                      :required="true"
                    >
                    <template>
                      {{degree [detailedForm.degree] }}
                    </template>
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="12">
                    <el-form-item
                      prop="time"
                      label="勤務期間："
                      label-width="100px"
                      :required="true"
                    >
                      {{ detailedForm.workTimeFrom }} - {{ detailedForm.workTimeTo }}
                    </el-form-item>
                  </el-col>
                  <el-col :span="12">
                    <el-form-item
                      prop="salarySection"
                      label="給料区分："
                      label-width="130px"
                      :required="true"
                    >
                    <template>
                      {{salarySection [detailedForm.salarySection] }}
                    </template>
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="12">
                    <el-form-item
                      prop="positionInt"
                      label="職位説明："
                      label-width="100px"
                      :required="true"
                    >
                      {{ detailedForm.positionInt }}
                    </el-form-item>
                  </el-col>
                  <el-col :span="12">
                    <el-form-item
                      prop="salary"
                      label="給料区間："
                      label-width="130px"
                      :required="true"
                    >
                      {{ detailedForm.salaryMin }}円 - {{ detailedForm.salaryMax }}円
                      </el-form-item>
                  </el-col>
                </el-row>
                <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="12">
                    <el-form-item
                      prop="workContent"
                      label="仕事内容："
                      label-width="100px"
                      :required="true"
                    >
                      {{ detailedForm.workContent }}
                    </el-form-item>
                  </el-col>
                  <el-col :span="12">
                    <el-form-item
                      prop="empLaborIns"
                      label="雇用・労災保険："
                      label-width="130px"
                      :required="true"
                    >
                    <template>
                      {{empLaborIns [detailedForm.empLaborIns] }}
                    </template>
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="12">
                    <el-form-item
                      prop="welfare"
                      label="福利厚生："
                      label-width="100px"
                      :required="true"
                    >
                    <template>
                      {{welfare [detailedForm.welfare] }}
                    </template>
                    </el-form-item>
                  </el-col>
                  <el-col :span="12">
                    <el-form-item
                      prop="trainingFlg"
                      label="研修有無："
                      label-width="130px"
                      :required="true"
                    >
                      <template>
                      {{trainingFlg [detailedForm.trainingFlg] }}
                    </template>
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="12">
                    <el-form-item
                      prop="inspectionFlg"
                      label="見学有無："
                      label-width="100px"
                      :required="true"
                    >
                      <template>
                      {{inspectionFlg [detailedForm.inspectionFlg] }}
                    </template>
                    </el-form-item>
                  </el-col>
                  <el-col :span="12">
                    <el-form-item
                      prop="conUpdFlg"
                      label="契約更新有無："
                      label-width="130px"
                      :required="true"
                    >
                      <template>
                      {{conUpdFlg [detailedForm.conUpdFlg] }}
                    </template>
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="12">
                    <el-form-item
                      prop="peoCnt"
                      label="募集人数："
                      label-width="100px"
                      :required="true"
                    >
                      {{ detailedForm.peoCnt }}人
                    </el-form-item>
                  </el-col>
                  <el-col :span="12">
                    <el-form-item
                      prop="workDateStr"
                      label="仕事予定開始日："
                      label-width="130px"
                      :required="true"
                    >
                      {{ detailedForm.workDateStr }}
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="12">
                    <el-form-item
                      prop="holiday"
                      label="休日・休暇："
                      label-width="100px"
                      :required="true"
                    >
                    {{ detailedForm.holiday }}
                    </el-form-item>
                  </el-col>
                  <el-col :span="12">
                    <el-form-item
                      prop="contractSection"
                      label="雇用方式："
                      label-width="130px"
                      :required="true"
                    >
                    <template>
                      {{contractSection [detailedForm.contractSection] }}
                    </template>
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
                      prop="workAddress1"
                      label="職位場所："
                      label-width="130px"
                      :required="true"
                    >
                      {{ detailedForm.workAddress1 }}
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="12">
                    <el-form-item
                      prop="workAddress2"
                      label="住所詳細："
                      label-width="100px"
                      :required="true"
                    >
                      {{ detailedForm.workAddress2 }}
                    </el-form-item>
                  </el-col>
                  <el-col :span="12">
                    <el-form-item
                      prop="station"
                      label="最寄駅："
                      label-width="130px"
                      :required="true"
                    >
                    {{ detailedForm.station }}
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="12">
                    <el-form-item
                      prop="expDate"
                      label="有効期限："
                      label-width="100px"
                      :required="true"
                    >
                      {{ detailedForm.expDate }}
                    </el-form-item>
                  </el-col>
                  </el-row>
                <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="6">
                    <el-form-item
                      prop="workingAddress1"
                      label="仕事画像："
                      label-width="100px"
                    >
                      <div>
                        <img :src="detailedForm.workingAddress1" class="avatar" alt />
                      </div>
                    </el-form-item>
                  </el-col>
                  <el-col :span="5">
                    <el-form-item prop="workingAddress2">
                      <div>
                        <img :src="detailedForm.workingAddress2" class="avatar" alt />
                      </div>
                    </el-form-item>
                  </el-col>
                  <el-col :span="11">
                    <el-form-item prop="workingAddress3">
                      <div>
                        <img :src="detailedForm.workingAddress3" class="avatar" alt />
                      </div>
                    </el-form-item>
                  </el-col>
                  <el-col :span="10" />
                </el-row>
              </div>
              <el-row v-show="this.flgData == '1'">
                <el-col :span="4" :offset="4">
                  <el-tooltip effect="light" content="承認" placement="top">
                    <el-button type="text" size="large" @click="confirmPositionMulti">
                      <em class="el-icon-circle-check" />
                    </el-button>
                  </el-tooltip>
                </el-col>
                <el-col :span="4" :offset="2">
                  <el-tooltip effect="light" content="拒否" placement="top">
                    <el-button type="text" size="large" @click="denyPositionMulti">
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
                  <el-button type="primary" class="b0102Button" @click="toB0102Modify()">
                    情報修正
                  </el-button>
                </el-col>
                <el-col :span="4" :offset="2">
                  <el-button type="primary" @click="routerBack" class="b0102Button">
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
  name: "b0102",
  components: {
    HomeHeader,
    HomeFooter,
  },
  data() {
    return {
      detailedForm: {
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
      contractSection: {
        '0' : '正社員',
        '1' : '契約社員',
        '2' : 'アルバイト',
        '3' : 'パート',
        '4' : '派遣',
      },

      expYears : {
        '0' : '不問',
        '1' : '1年未満',
        '2' : '3年未満',
        '3' : '5年未満',
        '4' : '10年未満',
        '5' : '10年以上',
      },

      salarySection: {
        '0' : '月給',
        '1' : '年俸',
        '2' : '日給',
        '3' : '時給',
        '4' : '出来高払い',
        '5' : 'その他',
      },

      empLaborIns: {
        '0' : '未加入',
        '1' : '一般の事業',
        '2' : '農林水産',
        '3' : '建計業他',
      },

      welfare: {
        '0' : '有',
        '1' : '無',
      },

      trainingFlg: {
        '0' : '有',
        '1' : '無',
      },

      inspectionFlg: {
        '0' : '有',
        '1' : '無',
      },

      conUpdFlg: {
        '0' : '有',
        '1' : '無',
      },

      degree : {
        '0' : '大卒以上',
        '1' : '専門卒以上',
        '2' : '高卒以上',
        '3' : '大卒',
        '4' : '院卒',
        '5' : '専門卒',
        '6' : '高卒',
        '7' : '学歴不問',
      },
      flgData: "",
      //他用
      A070103VueForm:{
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
    document.title = "職位詳細情報";
    if (this.$route.query.flight) {
      this.detailedForm = JSON.parse(this.$route.query.flight);
    }
    if(this.$route.query.flgData){
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
      history.go(-2);
    },
    // 情報修正画面へ
    toB0102Modify() {
      this.$router.push({
        path: "/b0102Modify",
        query: { flight: JSON.stringify(this.detailedForm) },
      });
    },
    //a070103複数承認    
    confirmPositionMulti() {
      this.A070103VueForm.statusFlg = "1";
      this.A070103VueForm.listData = [{positionId : this.detailedForm.positionId,companyId : this.detailedForm.companyId}];
      this.MessageBox();
    },
    //a070103複数拒否    
    denyPositionMulti() {
      this.A070103VueForm.statusFlg = "2";
      this.A070103VueForm.listData = [{positionId : this.detailedForm.positionId,companyId : this.detailedForm.companyId}];
      this.MessageBox();
    },
    // a070103承認確認ポップアップ
    MessageBox() {
      if(this.A070103VueForm.statusFlg == "1"){
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
          .dispatch("a070103Confirm", this.A070103VueForm)
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
.b0102Body {
  background-color: #f6f6f6;
  width: 100%;
  left: 0px;
  top: 66px;
}
// 两个主体部分宽80vw，居中，边框阴影，白色背景
.b0102Title,
.b0102Main {
  width: 80vw;
  margin-left: 10vw;
  box-shadow: 0 2px 4px #dce5f4, 0 0 6px #dce5f4;
  background-color: #ffffff;
}
// div内上下距离
.b0102Main {
  padding-top: 5vh;
  padding-bottom: 5vh;
}
// 标题栏上下内外边距
.b0102Title {
  margin-top: 0px;
  margin-bottom: 15px;
  padding-top: 0px;
  padding-bottom: 0px;
}
// 标题栏图标宽，边距
.b0102Icon {
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
.b0102TableDiv {
  margin-left: 5vw;
}
// 下面三个按钮的宽度
.b0102Button {
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
