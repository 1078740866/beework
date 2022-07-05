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
                      :required="true"
                    >
                      {{ detailedForm.briefingNm }}
                    </el-form-item>
                  </el-col>
                  </el-row>
                   <el-row :gutter="20" type="flex" justify="space-between">
                   <el-col :span="12">
                    <el-form-item
                      prop="briefingType"
                      label="説明会方式："
                      :required="true"
                    >
                      {{ detailedForm.briefingType }}
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="12">
                    <el-form-item
                      prop="tel"
                      label="電話番号："
                      :required="true"
                    >
                      {{ detailedForm.tel }}
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="12">
                    <el-form-item
                      prop="charge"
                      label="担当："
                      :required="true"
                    >
                      {{ detailedForm.charge }}
                    </el-form-item>
                  </el-col>
                  </el-row>
                <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="12">
                    <el-form-item
                      prop="proCntPlan"
                      label="予定人数："
                      :required="true"
                    >
                      {{ detailedForm.proCntPlan }}
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="12">
                    <el-form-item
                      prop="date"
                      label="説明会日："
                      :required="true"
                    >
                      {{ detailedForm.briefingDate }}
                    </el-form-item>
                  </el-col>
                  </el-row>
                <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="12">
                    <el-form-item
                      prop="time"
                      label="説明会時間："
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
                      :required="true"
                    >
                      {{ detailedForm.postal }}
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="24">
                    <el-form-item
                      prop="briefingAddress1"
                      label="説明会場所："
                      :required="true"
                    >
                      {{ detailedForm.briefingAddress1 }}
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="24">
                    <el-form-item
                      prop="briefingAddress2"
                      label="住所詳細："
                      :required="true"
                    >
                      {{ detailedForm.briefingAddress2 }}
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="12">
                    <el-form-item
                      prop="briefingContent"
                      label="説明会内容："
                      :required="true"
                    >
                      {{ detailedForm.briefingContent }}
                    </el-form-item>
                  </el-col>
                  </el-row>
                <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="12">
                    
                      <el-form-item
                        prop="teaNm"
                        label="講師氏名："
                      >
                        {{ detailedForm.teaNm }}
                      </el-form-item>
                    
                  </el-col>
                </el-row>
                <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="12">
                    <el-form-item
                      prop="teaIntro"
                      label="講師説明："
                    >
                      {{ detailedForm.teaIntro }}
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="12">
                    <el-form-item
                      prop="remarks"
                      label="備考："
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
                    >
                      <div>
                        <img
                          :src="detailedForm.photoAddress1"
                          class="avatar"
                          alt=""
                        />
                      </div>
                    </el-form-item>
                  </el-col>
                  </el-row>
                  <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="4">
                    <el-form-item prop="photoAddress2">
                      <div>
                        <img
                          :src="detailedForm.photoAddress2"
                          class="avatar"
                          alt=""
                        />
                      </div>
                    </el-form-item>
                  </el-col>
                  </el-row>
                <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="4">
                    <el-form-item prop="photoAddress3">
                      <div>
                        <img
                          :src="detailedForm.photoAddress3"
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
import HomeHeader from "../spComponents/HomeHeader";
import HomeFooter from "../spComponents/HomeFooter";
import '@/css/reset.css';
import '@/css/border.css';
//移动端 解决点击按钮闪和active失效的问题
document.body.addEventListener('touchstart' , function(){});
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
    };
  },

  mounted() {
    document.title = "説明会詳細情報";
    this.detailedForm = JSON.parse(this.$route.query.flight);
    console.log(this.detailedForm);
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
        path: "/sp/sp_b0602Modify",
        query: { flight: JSON.stringify(this.detailedForm) },
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
  width: 90vw;
  margin-left: 1vw;
  margin-right: 1vw;
  box-shadow: 0 2px 4px #dce5f4, 0 0 6px #dce5f4;
  background-color: #ffffff;
}
// div内上下距离
.b0602Main {
  padding-top: 1vh;
  padding-bottom: 1vh;
}
// 标题栏上下内外边距
.b0602Title {
  margin-top: 0px;
  margin-bottom: 15px;
  padding-top: 0px;
  padding-bottom: 0px;
  height: 40px;
}
// 标题栏图标宽，边距
.b0602Icon {
  width: 22px;
  margin-left: 13px;
  margin-top: 10px;
  margin-bottom: 10px;
}
// 标题位置大小颜色等
.title_name {
  color: #006699;
  font-weight: 400;
  font-size: 15px;
  margin-top: 10px;
  margin-bottom: 35px;
  margin-left: 10px;
}
// 上传图片尺寸限制在框内
.avatar {
  width: 150px;
  height: 150px;
}
// 表格div左边距
.b0602TableDiv {
  margin-left: 5vw;
}
// 下面三个按钮的宽度
.b0602Button {
  width: 100px;
}
</style>
