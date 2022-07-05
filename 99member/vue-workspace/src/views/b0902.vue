<template>
  <div class="b0902Vue">
    <el-container
      ><HomeHeader />
      <div class="b0902Body">
        <el-main>
          <el-form :model="detailedForm" label-position="right">
            <div class="b0902Title">
              <el-row>
                <el-col :span="2">
                  <div class="b0902Icon">
                    <el-image :src="require('@/assets/b_titleico3.png')" />
                  </div>
                </el-col>
                <el-col :span="22">
                  <div class="title_name">メッセージ詳細情報</div>
                </el-col>
              </el-row>
            </div>
            <div class="b0902Main">
              <div class="b0902TableDiv">
                <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="20">
                    <el-form-item
                      label="件名："
                      label-width="150px"
                    >
                      {{ detailedForm.subject }}
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row  :gutter="20" type="flex" justify="space-between">
                 <el-col :span="20">
                    <el-form-item
                      label="送信者："
                      label-width="150px"
                    >
                      {{ detailedForm.sName }}
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="20">
                    <el-form-item
                      label="受信者："
                      label-width="150px"
                    >
                      {{ detailedForm.rName }}
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="20">
                    <el-form-item
                      label="受信時間："
                      label-width="150px"
                    >
                      {{ detailedForm.timeString }}
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row  :gutter="20" type="flex" justify="space-between">
                  <el-col :span="20">
                    <el-form-item
                      label="メッセージ本文："
                      label-width="150px"
                      class="newLine"
                    >
                      {{ detailedForm.internalMessageText }}
                    </el-form-item>
                  </el-col>
                </el-row>
              </div>
              <el-row>
                <el-col :span="4" :offset="10">
                  <el-tooltip effect="light" content="戻る" placement="top">
                    <el-link @click="routerBack" type="primary" :underline="false" class="buttonWidth">
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
import HomeHeader from "./components/HomeHeader";
import HomeFooter from "./components/HomeFooter";
export default {
  name: "b0902",
  components: {
    HomeHeader,
    HomeFooter,
  },
  data() {
    return {
      detailedForm: {
        internalMessageId: "",
        subject: "",
        stutsFlg: "",
        internalMessageTextId: "",
        internalMessageText: "",
        sendId: "",
        sName: "",
        recId: "",
        rName: "",
        timeString: "",
      },
      // 転送用form
      B0902VueForm: {
        userCd: Number,
        internalMessageId: Number,
        address: "",
        subject: "",
        dateFrom: "",
        dateTo: "",
        statusFlg: "",
      },
    };
  },
  mounted() {
    document.title = "メッセージ詳細情報";
    this.getData();
    console.clear();
  },
  methods: {
    // 戻るボタン
    routerBack() {
      this.$router.push({
        path: "/b0901",
      });
    },
    setData() {
      this.B0902VueForm.internalMessageId = this.$route.query.b0902Id;
    },
    // テーブルデータ取得
    getData() {
      this.setData();
      this.$store.dispatch("b0902Message", this.B0902VueForm).then((response) => {
        this.$router.push({
          query: { data: response.data.data },
        });
        this.detailedForm = response.data.data
      });
    },
  },
};
</script>
<style lang="scss" scoped>
// 全屏主体灰色背景
.b0902Body {
  background-color: #f6f6f6;
  width: 100%;
  left: 0px;
  top: 66px;
}
// 两个主体部分宽80vw，居中，边框阴影，白色背景
.b0902Title,
.b0902Main {
  width: 80vw;
  margin-left: 10vw;
  box-shadow: 0 2px 4px #dce5f4, 0 0 6px #dce5f4;
  background-color: #ffffff;
}
// div内上下距离
.b0902Main {
  padding-top: 5vh;
  padding-bottom: 5vh;
}
// 标题栏上下内外边距
.b0902Title {
  margin-top: 0px;
  margin-bottom: 15px;
  padding-top: 0px;
  padding-bottom: 0px;
}
// 标题栏图标宽，边距
.b0902Icon {
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
.b0902TableDiv {
  margin-left: 5vw;
  height: 100%;
}
// 下面三个按钮的宽度
.b0902Button {
  width: 100px;
}
// 换行符识别
.newLine {
  white-space: pre-wrap;
}
.el-icon-back{
  font-size: 30px;
}
</style>
