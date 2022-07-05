<template>
  <div class="b0102Vue">
    <el-container
      ><HomeHeader />
      <div class="b0102Body">
        <el-main>
          <el-form :model="b0102Form" ref="b0102Form" label-position="right">
            <div class="b0102Title">
              <el-row>
                <el-col :span="2">
                  <div class="b0102Icon">
                    <el-image :src="require('@/assets/b_titleico3.png')" />
                  </div>
                </el-col>
                <el-col :span="22">
                  <div class="title_name">職位情報確認</div>
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
                      {{ b0102Form.positionNm }}
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
                      {{expYears [b0102Form.expYears] }}
                    </template>
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
                    {{ industryComputed }}
                    </el-form-item>
                  </el-col>
                  <el-col :span="12">
                    <el-form-item
                      prop="jobTypeId"
                      label="職種："
                      label-width="130px"
                      :required="true"
                    >
                      {{ jobTypeComputed }}
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="12">
                    <el-form-item
                      prop="skillId"
                      label="スキル："
                      label-width="100px"
                      :required="true"
                    >
                      {{ skillComputed }}
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
                      {{degree [b0102Form.degree] }}
                    </template>
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="12">
                    <el-form-item
                      prop="time"
                      label="勤務时间："
                      label-width="100px"
                      :required="false"
                    >
                      {{ b0102Form.workTimeFrom }} - {{ b0102Form.workTimeTo }}
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
                      {{salarySection [b0102Form.salarySection] }}
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
                      :required="false"
                      class="newLine"
                    >
                      {{ b0102Form.positionInt }}
                    </el-form-item>
                  </el-col>
                  <el-col :span="12">
                    <el-form-item
                      prop="salary"
                      label="給料区間："
                      label-width="130px"
                      :required="false"
                    >
                      {{ b0102Form.salaryMin }}円 - {{ b0102Form.salaryMax }}円   
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="12">
                    <el-form-item
                      prop="workContent"
                      label="仕事内容："
                      label-width="100px"
                      :required="false"
                      class="newLine"
                    >
                      {{ b0102Form.workContent }}
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
                      {{empLaborIns [b0102Form.empLaborIns] }}
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
                      {{welfare [b0102Form.welfare] }}
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
                      {{trainingFlg [b0102Form.trainingFlg] }}
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
                      {{inspectionFlg [b0102Form.inspectionFlg] }}
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
                      {{conUpdFlg [b0102Form.conUpdFlg] }}
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
                      :required="false"
                    >
                      {{ b0102Form.peoCnt }}人
                    </el-form-item>
                  </el-col>
                  <el-col :span="12">
                    <el-form-item
                      prop="workDateStr"
                      label="仕事予定開始日："
                      label-width="130px"
                      :required="true"
                    >
                      {{ b0102Form.workDateStr }}
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="12">
                    <el-form-item
                      prop="holiday"
                      label="休日・休暇："
                      label-width="100px"
                      :required="false"
                    >
                    {{ b0102Form.holiday }}
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
                      {{contractSection [b0102Form.contractSection] }}
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
                      {{ b0102Form.postal1 }}-{{ b0102Form.postal2 }}
                    </el-form-item>
                  </el-col>
                  <el-col :span="12">
                    <el-form-item
                      prop="workAddress1"
                      label="職位場所："
                      label-width="130px"
                      :required="true"
                    >
                      {{ b0102Form.workAddress1 }}
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
                      class="newLine"
                    >
                      {{ b0102Form.workAddress2 }}
                    </el-form-item>
                  </el-col>
                  <el-col :span="12">
                    <el-form-item
                      prop="station"
                      label="最寄駅："
                      label-width="130px"
                      :required="true"
                    >
                    {{ b0102Form.station }}
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
                      {{ b0102Form.expDate }}
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="6">
                    <el-form-item
                      label="仕事画像："
                      label-width="100px"
                    >
                      <div>
                        <img 
                        class="avatar" 
                        :src="this.picurl1"
                        />
                      </div>
                    </el-form-item>
                  </el-col>
                  <el-col :span="4" v-show="this.picurl2?true:false">
                    <el-form-item prop="workingAddress2">
                      <div>
                        <img :src="this.picurl2" class="avatar" alt />
                      </div>
                    </el-form-item>
                  </el-col>
                  <el-col :span="11" v-show="this.picurl2?true:false">
                    <el-form-item prop="workingAddress3">
                      <div>
                        <img :src="this.picurl3" class="avatar" alt />
                      </div>
                    </el-form-item>
                  </el-col>
                  <el-col :span="10" />
                </el-row>
              </div>
              <el-row>
                <el-col :span="4" :offset="7">
                  <el-button type="primary" class="b0102Button" @click="sendPositionInfo">
                    引き渡す
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
      picurl1: "",
      picurl2: "",
      picurl3: "",
      b0102Form: [],
      b0102Form2: [],
      b0102VueForm: {
        userCd: "",
        companyId: "",
        industryId: "",
        jobTypeId: "",
        skillId: "",
        positionId: "",
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
        workingAddress1Pic: "",
        workingAddress2Pic: "",
        workingAddress3Pic: "",
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
    };
  },
  mounted() {
    document.title = "職位情報確認";
    this.b0102Form = JSON.parse(this.$route.query.flight);
    this.b0102Form2 = JSON.parse(this.$route.query.flight2);
    console.log("b0102Form", this.b0102Form);
    if (this.b0102Form.workingAddress1Pic) {
      this.picurl1 = "data:image/jpeg;base64," + this.b0102Form.workingAddress1Pic;
    }
    if (this.b0102Form.workingAddress2Pic) {
      this.picurl2 = "data:image/jpeg;base64," + this.b0102Form.workingAddress2Pic;
    }
    if (this.b0102Form.workingAddress3Pic) {
      this.picurl3 = "data:image/jpeg;base64," + this.b0102Form.workingAddress3Pic;
    }
  },
  computed: {
    industryComputed() {
      return this.b0102Form2.industryCds[this.b0102Form2.industryId-1].industryNm;
    },
    jobTypeComputed() {
      return this.b0102Form2.jobTypeCds[this.b0102Form2.jobTypeId-1].jobtypeNm;
    },
    skillComputed() {
      return this.b0102Form2.skillCds[this.b0102Form2.skillId-1].skillNm;
    },
  },
  methods: {
    
    // 値を設定する
    setb0102VueForm() {
      this.b0102VueForm.positionId = this.b0102Form.positionId;
      this.b0102VueForm.companyId = this.b0102Form.companyId;
      this.b0102VueForm.industryId = this.b0102Form.industryId;
      this.b0102VueForm.jobTypeId = this.b0102Form.jobTypeId;
      this.b0102VueForm.skillId = this.b0102Form.skillId;
      this.b0102VueForm.positionNm = this.b0102Form.positionNm;
      this.b0102VueForm.expYears = this.b0102Form.expYears;
      this.b0102VueForm.expDate = new Date(this.b0102Form.expDate);
      this.b0102VueForm.degree = this.b0102Form.degree;
      this.b0102VueForm.workTimeFrom = this.b0102Form.workTimeFrom;
      this.b0102VueForm.workTimeTo = this.b0102Form.workTimeTo;
      this.b0102VueForm.salarySection = this.b0102Form.salarySection;
      this.b0102VueForm.positionInt = this.b0102Form.positionInt;
      this.b0102VueForm.salaryMin = this.b0102Form.salaryMin;
      this.b0102VueForm.salaryMax = this.b0102Form.salaryMax;
      this.b0102VueForm.empLaborIns = this.b0102Form.empLaborIns;
      this.b0102VueForm.workContent = this.b0102Form.workContent;
      this.b0102VueForm.welfare = this.b0102Form.welfare;
      this.b0102VueForm.expYears = this.b0102Form.expYears;
      this.b0102VueForm.trainingFlg = this.b0102Form.trainingFlg;
      this.b0102VueForm.inspectionFlg = this.b0102Form.inspectionFlg;
      this.b0102VueForm.conUpdFlg = this.b0102Form.conUpdFlg;
      this.b0102VueForm.peoCnt = this.b0102Form.peoCnt;
      this.b0102VueForm.workDateStr = new Date(this.b0102Form.workDateStr);
      this.b0102VueForm.holiday = this.b0102Form.holiday;
      this.b0102VueForm.postal = this.b0102Form.postal1 + "-" + this.b0102Form.postal2;
      this.b0102VueForm.workAddress1 = this.b0102Form.workAddress1;
      this.b0102VueForm.workAddress2 = this.b0102Form.workAddress2;
      this.b0102VueForm.station = this.b0102Form.station;
      this.b0102VueForm.contractSection = this.b0102Form.contractSection;
      this.b0102VueForm.workingAddress1 = this.b0102Form.workingAddress1;
      this.b0102VueForm.workingAddress2 = this.b0102Form.workingAddress2;
      this.b0102VueForm.workingAddress3 = this.b0102Form.workingAddress3;
    },

    sendPositionInfo() {
      this.setb0102VueForm();
      this.loading = true;
      this.$store
        .dispatch("sendPositionInfo", this.b0102VueForm)
        .then((response) => {
          this.loading = false;
          let code = response.data.code;
          console.clear();
          console.log("b0102VueForm:", this.b0102VueForm);
          if (code == 200) {
            this.$message.success("成功しました！");
            this.$router.push({
              path: "/b0101",
            });
          } else if (code == 404) {
            this.$message.error(response.data.message);
            this.$message.warning("失敗しました！");
          } else if (code == 400) {
            this.$message.error(response.data.message);
            this.$message.warning("失敗しました！");
          }else {
            this.$router.push({
              path: "/error",
              query: { message: response.data.message },
            });
            this.$message.error("失敗しました！");
          }
        })
        .catch(() => {
          this.loading = false;
        });
    },
    // 戻るボタン
    routerBack() {
      console.log("b0102Form", this.b0102Form);
      setTimeout(() => {
        this.$router.push({
          path: "/b0102Registered",
          query: { flight: JSON.stringify(this.b0102Form) },
        });
      }, 1);
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
</style>
