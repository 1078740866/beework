<template>
  <div class="b0602Vue">
    <el-container
      ><HomeHeader />
      <div class="b0602Body">
        <el-main>
          <el-form :model="b0602Form" ref="b0602Form" label-position="right">
            <div class="b0602Title">
              <el-row>
                <el-col :span="2">
                  <div class="b0602Icon">
                    <el-image :src="require('@/assets/b_titleico3.png')" />
                  </div>
                </el-col>
                <el-col :span="22">
                  <div class="title_name">説明会新規確認</div>
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
                      {{ b0602Form.briefingNm }}
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
                    {{type [b0602Form.briefingType]}} 
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
                      {{ b0602Form.charge }}
                    </el-form-item>
                  </el-col>
                  <el-col :span="12">
                    <el-form-item
                      prop="tel"
                      label="電話番号："
                      label-width="120px"
                      :required="true"
                    >
                      {{ b0602Form.tel }}
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
                      {{ b0602Form.briefingDate }}
                    </el-form-item>
                  </el-col>
                  <el-col :span="12">
                    <el-form-item
                      prop="time"
                      label="説明会時間："
                      label-width="120px"
                      :required="true"
                    >
                      {{ b0602Form.dateFrom }}-{{ b0602Form.dateTo }}
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
                      {{ b0602Form.postal1 }}-{{ b0602Form.postal2 }}
                    </el-form-item>
                  </el-col>
                   <el-col :span="12">
                    <el-form-item
                      prop="proCntPlan"
                      label="人数："
                      label-width="120px"
                      :required="true"
                    >
                      {{ b0602Form.proCntPlan }}人
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
                      {{ b0602Form.briefingAddress1 }}
                    </el-form-item>
                  </el-col>
                  <el-col :span="24">
                      <el-form-item
                        prop="teaNm"
                        label="講師氏名："
                        label-width="120px"
                      >
                        {{ b0602Form.teaNm }}
                      </el-form-item>
                    </el-col>
                </el-row>
                <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="12">
                    <el-form-item
                      prop="briefingAddress2"
                      label="説明会場所詳細："
                      label-width="130px"
                      :required="true"
                      class="newLine"
                    >
                      {{ b0602Form.briefingAddress2 }}
                    </el-form-item>
                  </el-col>
                  <el-col :span="12">
                    <el-form-item
                      prop="teaIntro"
                      label="講師説明："
                      label-width="120px"
                      class="newLine"
                    >
                      {{ b0602Form.teaIntro }}
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
                      {{ b0602Form.briefingContent }}
                    </el-form-item>
                  </el-col>
                  <el-col :span="12">
                    <el-form-item
                      prop="remarks"
                      label="備考："
                      label-width="120px"
                      class="newLine"
                      >
                      {{ b0602Form.remarks }}
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
                      <div>
                        <img
                          :src="this.picurl"
                          class="avatar"
                          alt=""
                        />
                      </div>
                    </el-form-item>
                  </el-col>
                  <el-col :span="6">
                    <el-form-item prop="photoAddress2">
                      <div>
                        <img
                          :src="b0602Form.photoAddress2"
                          class="avatar"
                          alt=""
                        />
                      </div>
                    </el-form-item>
                  </el-col>
                  <el-col :span="13">
                    <el-form-item prop="photoAddress3">
                      <div>
                        <img
                          :src="b0602Form.photoAddress3"
                          class="avatar"
                          alt=""
                        />
                      </div>
                    </el-form-item>
                  </el-col>
                  <el-col :span="10" />
                </el-row>
              </div>
              <el-row>
                <el-col :span="4" :offset="7">
                  <el-button
                    type="primary"
                    class="b0602Button"
                    @click="sendBriefingInfo"
                  >
                    引き渡す
                  </el-button>
                </el-col>
                <el-col :span="4" :offset="2">
                  <el-button
                    type="primary"
                    @click="routerBack"
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
      picurl:"",
      b0602Form: {
        userCd: Number,
        companyId: Number,
        briefingNm: "",
        briefingType: "",
        briefingDate: "",
        dateFrom: "", 
        dateTo: "",
        postal1: "",
        postal2: "",
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
        photoAddress1Pic: "",
        photoAddress2Pic: "",
        photoAddress3Pic: "",
        remarks: "",
      },
      B0602VueForm: {
        userCd: "",
        companyId: "",
        briefingId: "",
        briefingNm: "",
        briefingType: "",
        briefingDate: "",
        dateFrom: "",
        dateTo: "",
        postal: "",
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
        remarks: "",
      },
      type: { 
        '0' : '現場',
        '1' : '生放送',
        },
    };
    
  },
  mounted() {
    document.title = "説明会情報確認";
    this.b0602Form = JSON.parse(this.$route.query.flight);
    console.log("b0602Form:", this.b0602Form);
    let filename = this.b0602Form.photoAddress1Pic;
    let extension = filename.split('.').pop();
    if (extension == "pdf") {
      this.pdfHiddenFlag=false;
      this.picurl = "data:application/pdf;base64," + this.registerForm.photoAddress1Pic;
    }else{
      this.pdfHiddenFlag=true;
      this.picurl = "data:image/jpeg;base64," + this.registerForm.photoAddress1Pic;
    }
  },
  methods: {
    setB0602VueForm() {
      // 値を設定する
      this.B0602VueForm.companyId = this.b0602Form.companyId;
      this.B0602VueForm.briefingId = this.b0602Form.briefingId;
      this.B0602VueForm.briefingNm = this.b0602Form.briefingNm;
      this.B0602VueForm.briefingType = this.b0602Form.briefingType;
      this.B0602VueForm.briefingDate = new Date(this.b0602Form.briefingDate);
      this.B0602VueForm.dateFrom = this.b0602Form.dateFrom;
      this.B0602VueForm.dateTo = this.b0602Form.dateTo;
      this.B0602VueForm.postal = this.b0602Form.postal1 + "-" + this.b0602Form.postal2;
      this.B0602VueForm.briefingAddress1 = this.b0602Form.briefingAddress1;
      this.B0602VueForm.briefingAddress2 = this.b0602Form.briefingAddress2;
      this.B0602VueForm.briefingContent = this.b0602Form.briefingContent;
      this.B0602VueForm.proCntPlan = this.b0602Form.proCntPlan;
      this.B0602VueForm.teaNm = this.b0602Form.teaNm;
      this.B0602VueForm.teaIntro = this.b0602Form.teaIntro;
      this.B0602VueForm.tel =
        this.b0602Form.tel.substring(0, 3) +
        "-" +
        this.b0602Form.tel.substring(3, 7) +
        "-" +
        this.b0602Form.tel.substring(7, 11);
      this.B0602VueForm.charge = this.b0602Form.charge;
      this.B0602VueForm.photoAddress1 = this.b0602Form.photoAddress1;
      this.B0602VueForm.photoAddress2 = this.b0602Form.photoAddress2;
      this.B0602VueForm.photoAddress3 = this.b0602Form.photoAddress3;
      this.B0602VueForm.remarks = this.b0602Form.remarks;
    },
    sendBriefingInfo() {
      this.setB0602VueForm();
      this.loading = true;
      this.$store
        .dispatch("sendBriefingInfo", this.B0602VueForm)
        .then((response) => {
          this.loading = false;
          let code = response.data.code;
          console.clear();
          console.log("B0602VueForm:", this.B0602VueForm);
          if (code == 200) {
            this.$message.success("成功しました！");
            this.$router.push({
              path: "/b0601",
            });
          } else if (code == 404) {
            this.$message.error(response.data.message);
            this.$message.warning("失敗しました！");
          } else {
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
      console.log("b0602Form", this.b0602Form);
      setTimeout(() => {
        this.$router.push({
          path: "/b0602Modify",
          query: { flight: JSON.stringify(this.b0602Form) },
          
        });
      }, 1);
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
  margin-right: 10vw;
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
//换行符识别
.newLine {
  white-space: pre-wrap;
}
</style>
