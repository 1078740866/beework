<template>
  <div class="b0402Vue">
    <el-container
      ><ApplicantHeader />
      <div class="b0402Body">
        <el-main>
          <el-form :model="detailedForm" ref="detailedForm" label-position="right">
            <div class="b0402Title">
              <el-row>
                <el-col :span="2">
                  <div class="b0402Icon">
                    <el-image :src="require('@/assets/b_titleico3.png')" />
                  </div>
                </el-col>
                <el-col :span="22">
                  <div class="title_name">面接詳細情報</div>
                </el-col>
              </el-row>
            </div>
            <div class="b0402Main">
              <div class="b0402TableDiv">
                <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="6">
                    <el-row :gutter="20" type="flex" justify="space-between">
                      <el-col :span="24">
                        <el-form-item prop="photo" :required="true">
                          <el-image :src="detailedForm.photo" :fit="fit"> </el-image>
                        </el-form-item>
                      </el-col>
                    </el-row>
                    <el-row :gutter="20" type="flex" justify="space-between">
                      <el-col :span="24">
                        <el-form-item
                          prop="name"
                          label="応募者："
                          label-width="100px"
                          :required="true"
                        >
                          <a>{{ detailedForm.name }}</a>
                        </el-form-item>
                      </el-col>
                    </el-row>
                  </el-col>
                  <el-col :span="18">
                    <el-row :gutter="20" type="flex" justify="space-between">
                      <el-col :span="12">
                        <el-form-item
                          prop="interviewType"
                          label="面接種類："
                          label-width="100px"
                          :required="true"
                        >
                          {{ ivType[detailedForm.interviewType] }}
                        </el-form-item>
                      </el-col>
                      <el-col :span="12">
                        <el-form-item
                          prop="responsible"
                          label="担当："
                          label-width="100px"
                          :required="true"
                        >
                          {{ detailedForm.responsible }}
                        </el-form-item>
                      </el-col>
                    </el-row>
                    <el-row :gutter="20" type="flex" justify="space-between">
                      <el-col :span="12">
                        <el-form-item
                          prop="positionNm"
                          label="職位："
                          label-width="100px"
                          :required="true"
                        >
                          {{ detailedForm.positionNm }}
                        </el-form-item>
                      </el-col>
                      <el-col :span="12">
                        <el-form-item
                          prop="statusFlg"
                          label="面接状態："
                          label-width="100px"
                          :required="true"
                        >
                          {{ stFlg[detailedForm.statusFlg] }}
                        </el-form-item>
                      </el-col>
                    </el-row>
                    <el-row :gutter="20" type="flex" justify="space-between">
                      <el-col :span="12">
                        <el-form-item
                          prop="interviewDate"
                          label="面接日時："
                          label-width="100px"
                          :required="true"
                        >
                          {{ detailedForm.interviewDate }}
                        </el-form-item>
                      </el-col>
                      <el-col :span="12">
                        <el-form-item
                          prop="tel"
                          label="連絡先："
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
                          prop="date"
                          label="面接時間："
                          label-width="100px"
                          :required="true"
                        >
                          {{ detailedForm.dateFrom }} - {{ detailedForm.dateTo }}
                        </el-form-item>
                      </el-col>
                      <el-col :span="12">
                        <el-form-item
                          prop="interviewAddress"
                          label="面接場所："
                          label-width="100px"
                          :required="true"
                        >
                          {{ detailedForm.interviewAddress }}
                        </el-form-item>
                      </el-col>
                    </el-row>
                    <el-row :gutter="20" type="flex" justify="space-between">
                      <el-col :span="20">
                        <el-form-item
                          prop="remarks"
                          label="備考："
                          label-width="100px"
                          :required="true"
                          class="newLine"
                        >
                          {{ detailedForm.remarks }}
                        </el-form-item>
                      </el-col>
                      <el-col :span="4"> </el-col>
                    </el-row>
                  </el-col>
                </el-row>
              </div>
              <el-row>
                <el-col :span="4" :offset="10">
                  <el-tooltip effect="light" content="戻る" placement="top">
                    <el-link @click="routerBack()" type="primary" :underline="false">
                      <i class="el-icon-back"></i>
                    </el-link>
                  </el-tooltip>
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
import ApplicantHeader from "@/views/components/ApplicantHeader";
import HomeFooter from "./components/HomeFooter";
export default {
  name: "c0502",
  components: {
    ApplicantHeader,
    HomeFooter,
  },
  data() {
    return {
      detailedForm: {
        applicantId: "",
        companyId: "",
        dateFrom: "",
        dateTo: "",
        name: "",
        interviewAddress: "",
        interviewDate: "",
        interviewId: "",
        interviewType: "",
        photo: "",
        positionId: "",
        positionNm: "",
        remarks: "",
        responsible: "",
        statusFlg: "",
        tel: "",
      },
      // 面接種類
      ivType: {
        0: "現場面接",
        1: "テレビ面接",
        2: "電話面接",
      },
      // 面接状態
      stFlg: {
        0: "未処理",
        1: "受け入れる",
        2: "拒否",
      },
    };
  },
  mounted() {
    document.title = "面接詳細情報";
    this.detailedForm = JSON.parse(this.$route.query.flight);
  },
  methods: {
    // 戻るボタン
    routerBack() {
      history.go(-1);
    },
  },
};
</script>
<style lang="scss" scoped>
// 全屏主体灰色背景
.b0402Body {
  background-color: #f6f6f6;
  width: 100%;
  left: 0px;
  top: 66px;
}
// 两个主体部分宽80vw，居中，边框阴影，白色背景
.b0402Title,
.b0402Main {
  width: 80vw;
  margin-left: 10vw;
  box-shadow: 0 2px 4px #dce5f4, 0 0 6px #dce5f4;
  background-color: #ffffff;
}
// div内上下距离
.b0402Main {
  padding-top: 5vh;
  padding-bottom: 5vh;
}
// 标题栏上下内外边距
.b0402Title {
  margin-top: 0px;
  margin-bottom: 15px;
  padding-top: 0px;
  padding-bottom: 0px;
}
// 标题栏图标宽，边距
.b0402Icon {
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
.b0402TableDiv {
  margin-left: 5vw;
}
// 下面三个按钮的宽度
.el-icon-back {
  font-size: 30px;
}
// 换行符识别
.newLine {
  white-space: pre-wrap;
}
//el-col中内容为空，则这个el-col整体就不显示
.el-col {
  min-height: 1px;
}
</style>
