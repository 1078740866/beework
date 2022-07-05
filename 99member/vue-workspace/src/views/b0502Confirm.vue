<template>
  <div class="b0502Vue">
    <el-container
      ><HomeHeader />
      <div class="b0502Body">
        <el-main>
          <el-form :model="b0502Form" ref="b0502Form" label-position="right">
            <div class="b0502Title">
              <el-row>
                <el-col :span="2">
                  <div class="b0502Icon">
                    <el-image :src="require('@/assets/b_titleico3.png')" />
                  </div>
                </el-col>
                <el-col :span="22">
                  <div class="title_name">研修情報確認</div>
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
                      {{ b0502Form.trainingNm }}
                    </el-form-item>
                  </el-col>
                  <el-col :span="12">
                    <el-form-item
                      prop="tel"
                      label="電話番号："
                      label-width="100px"
                      :required="true"
                    >
                      {{ b0502Form.tel }}
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
                      {{ getIndustry }}
                    </el-form-item>
                  </el-col>
                  <el-col :span="12">
                    <el-form-item
                      prop="charge"
                      label="担当："
                      label-width="100px"
                      :required="true"
                    >
                      {{ b0502Form.charge }}
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
                      {{ b0502Form.date[0] }} - {{ b0502Form.date[1] }}
                    </el-form-item>
                  </el-col>
                  <el-col :span="12">
                    <el-form-item
                      prop="time"
                      label="研修時間："
                      label-width="100px"
                      :required="true"
                    >
                      {{ b0502Form.time[0] }}-{{ b0502Form.time[1] }}
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
                      {{ b0502Form.postal1 }}-{{ b0502Form.postal2 }}
                    </el-form-item>
                  </el-col>
                  <el-col :span="12">
                    <el-form-item
                      prop="proCnt"
                      label="人数："
                      label-width="100px"
                      :required="true"
                    >
                      {{ b0502Form.proCnt }}
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
                      {{ b0502Form.trainingAddress1 }}
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
                      {{ b0502Form.trainingAddress2 }}
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
                    >
                      {{ b0502Form.trainingContent }}
                    </el-form-item>
                  </el-col>
                  <el-col :span="12">
                    <el-col :span="24">
                      <el-form-item prop="cost" label="料金：" label-width="100px">
                        {{ b0502Form.cost }}
                      </el-form-item>
                    </el-col>
                    <el-col :span="24">
                      <el-form-item prop="teaNm" label="講師氏名：" label-width="100px">
                        {{ b0502Form.teaNm }}
                      </el-form-item>
                    </el-col>
                  </el-col>
                </el-row>
                <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="12">
                    <el-form-item prop="remarks" label="備考：" label-width="100px">
                      {{ b0502Form.remarks }}
                    </el-form-item>
                  </el-col>
                  <el-col :span="12">
                    <el-form-item prop="teaIntro" label="講師説明：" label-width="100px">
                      {{ b0502Form.teaIntro }}
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
                        <img :src="b0502Form.trainingPic1" class="avatar" alt />
                      </div>
                    </el-form-item>
                  </el-col>
                  <el-col :span="4">
                    <el-form-item prop="trainingPic2">
                      <div>
                        <img :src="b0502Form.trainingPic2" class="avatar" alt />
                      </div>
                    </el-form-item>
                  </el-col>
                  <el-col :span="4">
                    <el-form-item prop="trainingPic3">
                      <div>
                        <img :src="b0502Form.trainingPic3" class="avatar" alt />
                      </div>
                    </el-form-item>
                  </el-col>
                  <el-col :span="10" />
                </el-row>
              </div>
              <el-row>
                <el-col :span="4" :offset="7">
                  <el-button type="primary" class="b0502Button" @click="sendTrainingInfo">
                    引き渡す
                  </el-button>
                </el-col>
                <el-col :span="4" :offset="2">
                  <el-button type="primary" @click="routerBack" class="b0502Button">
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
      b0502Form: {
        userCd: Number,
        companyId: Number,
        industryId: Number,
        trainingNm: "",
        date: { dateFrom: "", dateTo: "" },
        time: { timeFrom: "", timeTo: "" },
        postal1: "",
        postal2: "",
        trainingAddress1: "",
        trainingAddress2: "",
        trainingContent: "",
        proCnt: "",
        teaNm: "",
        teaIntro: "",
        cost: "",
        tel: "",
        charge: "",
        trainingPic1: "",
        trainingPic2: "",
        trainingPic3: "",
        industryCds: [{ industryId: "", industryNm: "" }],
        remarks: "",
      },
      B0502VueForm: {
        userCd: "",
        trainingId: "",
        companyId: "",
        industryId: "",
        trainingNm: "",
        dateFrom: "",
        dateTo: "",
        timeFrom: "",
        timeTo: "",
        postal: "",
        prefingNm: "",
        charge: "",
        cost: "",
        proCnt: "",
        remarks: "",
        teaIntro: "",
        teaNm: "",
        tel: "",
        trainingAddress1: "",
        trainingAddress2: "",
        trainingContent: "",
        trainingPic1: "",
        trainingPic2: "",
        trainingPic3: "",
      },
    };
  },
  mounted() {
    document.title = "研修情報確認";
    this.b0502Form = JSON.parse(this.$route.query.flight);
    console.log("b0502Form", this.b0502Form);
  },
  computed: {
    getIndustry() {
      return this.b0502Form.industryCds[this.b0502Form.industryId - 1].industryNm;
    },
  },
  methods: {
    // 値を設定する
    setB0502VueForm() {
      this.B0502VueForm.trainingId = this.b0502Form.trainingId;
      this.B0502VueForm.companyId = this.b0502Form.companyId;
      this.B0502VueForm.industryId = this.b0502Form.industryId;
      this.B0502VueForm.trainingNm = this.b0502Form.trainingNm;
      this.B0502VueForm.dateFrom = this.b0502Form.date[0];
      this.B0502VueForm.dateTo = this.b0502Form.date[1];
      this.B0502VueForm.timeFrom = this.b0502Form.time[0];
      this.B0502VueForm.timeTo = this.b0502Form.time[1];
      this.B0502VueForm.postal = this.b0502Form.postal1 + "-" + this.b0502Form.postal2;
      this.B0502VueForm.prefingNm = this.b0502Form.prefingNm;
      this.B0502VueForm.trainingAddress1 = this.b0502Form.trainingAddress1;
      this.B0502VueForm.trainingAddress2 = this.b0502Form.trainingAddress2;
      this.B0502VueForm.trainingContent = this.b0502Form.trainingContent;
      this.B0502VueForm.proCnt = this.b0502Form.proCnt;
      this.B0502VueForm.teaNm = this.b0502Form.teaNm;
      this.B0502VueForm.teaIntro = this.b0502Form.teaIntro;
      this.B0502VueForm.cost = this.b0502Form.cost;
      this.B0502VueForm.tel =
        this.b0502Form.tel.substring(0, 3) +
        "-" +
        this.b0502Form.tel.substring(3, 7) +
        "-" +
        this.b0502Form.tel.substring(7, 11);
      this.B0502VueForm.charge = this.b0502Form.charge;
      this.B0502VueForm.remarks = this.b0502Form.remarks;
    },
    sendTrainingInfo() {
      this.setB0502VueForm();
      this.loading = true;
      this.$store
        .dispatch("sendTrainingInfo", this.B0502VueForm)
        .then((response) => {
          this.loading = false;
          let code = response.data.code;
          console.clear();
          console.log("B0502VueForm:", this.B0502VueForm);
          if (code == 200) {
            this.$message.success("成功しました！");
            this.$router.push({
              path: "/b0501",
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
      history.go(-2);
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
</style>
