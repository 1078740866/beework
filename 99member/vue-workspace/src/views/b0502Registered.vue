<template>
  <div class="b0502Vue">
    <el-container
      ><HomeHeader />
      <div class="b0502Body">
        <el-main>
          <el-form
            :model="b0502VueForm"
            :rules="rules"
            ref="b0502VueForm"
            autocomplete="on"
            label-position="right"
          >
            <div class="b0502Title">
              <el-row>
                <el-col :span="2">
                  <div class="b0502Icon">
                    <el-image :src="require('@/assets/b_titleico3.png')" />
                  </div>
                </el-col>
                <el-col :span="22">
                  <div class="title_name">研修新規入力</div>
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
                    >
                      <el-input
                        v-model="b0502VueForm.trainingNm"
                        placeholder="研修会名"
                        maxlength="50"
                      />
                    </el-form-item>
                  </el-col>
                  <el-col :span="12">
                    <el-form-item
                      prop="tel"
                      label="電話番号："
                      label-width="100px"
                    >
                      <el-input
                        v-model="b0502VueForm.tel"
                        placeholder="電話番号"
                        maxlength="11"
                        @input="numValid('tel')"
                        @focus="b0502TelOnFocus($event)"
                        @blur="b0502TelOnBlur($event)"
                      />
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
                      <el-select
                        v-model="b0502VueForm.industryId"
                        placeholder="業種"
                        :clearable="true"
                      >
                        <el-option
                          v-for="item in b0502VueForm.industryCds"
                          :key="item.industryId"
                          :label="item.industryNm"
                          :value="item.industryId"
                        >
                        </el-option>
                      </el-select>
                    </el-form-item>
                  </el-col>
                  <el-col :span="12">
                    <el-form-item
                      prop="charge"
                      label="担当："
                      label-width="100px"
                    >
                      <el-input
                        v-model="b0502VueForm.charge"
                        placeholder="担当"
                        maxlength="20"
                      />
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="12">
                    <el-form-item
                      prop="date"
                      label="研修期間："
                      label-width="100px"
                    >
                      <el-date-picker
                        v-model="b0502VueForm.date"
                        type="daterange"
                        range-separator="-"
                        start-placeholder="開始日付"
                        end-placeholder="終了日付"
                        value-format="yyyy-MM-dd"
                        style="width: 280px"
                      />
                    </el-form-item>
                  </el-col>
                  <el-col :span="12">
                    <el-form-item
                      prop="time"
                      label="研修時間："
                      label-width="100px"
                    >
                      <el-time-picker
                        is-range
                        v-model="b0502VueForm.time"
                        range-separator="-"
                        start-placeholder="開始時間"
                        end-placeholder="終了時間"
                        value-format="HH:mm:ss"
                        style="width: 280px"
                      />
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="12">
                    <el-form-item
                      prop="postal1"
                      label="郵便番号："
                      label-width="100px"
                    >
                      <el-input
                        v-model="b0502VueForm.postal1"
                        class="postal1"
                        maxlength="3"
                        @input="numValid('postal1')"
                      />
                      <span class="hyphen">-</span>
                      <el-input
                        v-model="b0502VueForm.postal2"
                        class="postal2"
                        maxlength="4"
                        @input="numValid('postal2')"
                      />
                      <SearchPostal
                        @parentMethod="postalInit"
                        :postal1="b0502VueForm.postal1"
                        :postal2="b0502VueForm.postal2"
                      />
                    </el-form-item>
                  </el-col>
                  <el-col :span="12">
                    <el-form-item
                      prop="proCnt"
                      label="人数："
                      label-width="100px"
                    >
                      <el-input
                        v-model="b0502VueForm.proCnt"
                        placeholder="人数"
                        maxlength="9"
                        @input="numValid('proCnt')"
                        @focus="b0502NumOnFocus"
                        @blur="b0502PersonOnBlur"
                      />
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
                      <el-input
                        v-model="b0502VueForm.trainingAddress1"
                        class="address"
                        placeholder="入力された郵便番号に応じて、自動的に取得します"
                        :disabled="true"
                        maxlength="200"
                      >
                        {{ b0502VueForm.trainingAddress1 }}
                      </el-input>
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="24">
                    <el-form-item
                      prop="trainingAddress2"
                      label="住所詳細："
                      label-width="100px"
                    >
                      <el-input
                        v-model="b0502VueForm.trainingAddress2"
                        placeholder="住所詳細"
                        class="address"
                        maxlength="200"
                      />
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="12">
                    <el-form-item
                      prop="trainingContent"
                      label="研修内容："
                      label-width="100px"
                    >
                      <el-input
                        type="textarea"
                        v-model="b0502VueForm.trainingContent"
                        rows="5"
                        style="width: 280px"
                        maxlength="1000"
                      />
                    </el-form-item>
                  </el-col>
                  <el-col :span="12">
                    <el-col :span="24">
                      <el-form-item
                        prop="cost"
                        label="料金："
                        label-width="100px"
                      >
                        <el-input
                          v-model="b0502VueForm.cost"
                          placeholder="料金"
                          maxlength="9"
                          @input="numValid('cost')"
                          @blur="b0502MoneyOnBlur"
                          @focus="b0502NumOnFocus"
                        />
                      </el-form-item>
                    </el-col>
                    <el-col :span="24">
                      <el-form-item
                        prop="teaNm"
                        label="講師氏名："
                        label-width="100px"
                      >
                        <el-input
                          v-model="b0502VueForm.teaNm"
                          placeholder="講師氏名"
                          maxlength="20"
                        />
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
                    >
                      <el-input
                        type="textarea"
                        v-model="b0502VueForm.remarks"
                        rows="5"
                        style="width: 280px"
                        maxlength="500"
                      />
                    </el-form-item>
                  </el-col>
                  <el-col :span="12">
                    <el-form-item
                      prop="teaIntro"
                      label="講師説明："
                      label-width="100px"
                    >
                      <el-input
                        type="textarea"
                        v-model="b0502VueForm.teaIntro"
                        rows="5"
                        style="width: 280px"
                        maxlength="200"
                      />
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
                        <el-upload
                          action="https://www.mocky.io/v2/5185415ba171ea3a00704eed/posts/"
                          :before-upload="imgSize"
                          :on-success="uploadSuccess"
                          :on-error="uploadFail"
                          :show-file-list="false"
                          accept="image/jpeg,image/jpg,image/png,image/svg"
                          list-type="picture-card"
                        >
                          <img
                            v-if="b0502VueForm.trainingPic1"
                            :src="b0502VueForm.trainingPic1"
                            class="avatar"
                            alt=""
                          />
                          <em
                            v-else
                            class="el-icon-plus avatar-uploader-icon"
                          />
                        </el-upload>
                      </div>
                    </el-form-item>
                  </el-col>
                  <el-col :span="4">
                    <el-form-item prop="trainingPic2">
                      <div v-show="photoAddress > 0">
                        <el-upload
                          action="https://www.mocky.io/v2/5185415ba171ea3a00704eed/posts/"
                          :before-upload="imgSize"
                          :on-success="uploadSuccess2"
                          :on-error="uploadFail"
                          :show-file-list="false"
                          accept="image/jpeg,image/jpg,image/png,image/svg"
                          list-type="picture-card"
                        >
                          <img
                            v-if="b0502VueForm.trainingPic2"
                            :src="b0502VueForm.trainingPic2"
                            class="avatar"
                            alt=""
                          />
                          <em
                            v-else
                            class="el-icon-plus avatar-uploader-icon"
                          />
                        </el-upload>
                      </div>
                    </el-form-item>
                  </el-col>
                  <el-col :span="4">
                    <el-form-item prop="trainingPic3">
                      <div v-show="photoAddress > 1">
                        <el-upload
                          action="https://www.mocky.io/v2/5185415ba171ea3a00704eed/posts/"
                          :before-upload="imgSize"
                          :on-success="uploadSuccess3"
                          :on-error="uploadFail"
                          :show-file-list="false"
                          accept="image/jpeg,image/jpg,image/png,image/svg"
                          list-type="picture-card"
                        >
                          <img
                            v-if="b0502VueForm.trainingPic3"
                            :src="b0502VueForm.trainingPic3"
                            class="avatar"
                            alt=""
                          />
                          <em
                            v-else
                            class="el-icon-plus avatar-uploader-icon"
                          />
                        </el-upload>
                      </div>
                    </el-form-item>
                  </el-col>
                  <el-col :span="10">
                    <el-button
                      type="primary"
                      icon="el-icon-plus"
                      @click="photoAddress++"
                      v-show="photoAddress < 2"
                      circle
                    />
                  </el-col>
                </el-row>
              </div>
              <el-row>
                <el-col :span="4" :offset="5">
                  <el-button
                    type="primary"
                    class="b0502Button"
                    @click="toB0502Confirm"
                  >
                    情報確認
                  </el-button>
                </el-col>
                <el-col :span="4" :offset="1">
                  <el-button @click="clearForm" class="b0502Button">
                    クリア
                  </el-button>
                </el-col>
                <el-col :span="4" :offset="1">
                  <el-button
                    type="primary"
                    @click="routerBack"
                    class="b0502Button"
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
// ヘッダー フッター
import HomeHeader from "./components/HomeHeader";
import HomeFooter from "./components/HomeFooter";
// 郵便番号検索機能導入
import SearchPostal from "./components/SearchPostal";
// 内容チェック機能導入
import {
  validateNecessary,
  numOnBlur,
  numOnFocus,
  telOnFocus,
  telOnBlur,
} from "@/utils/validate";
export default {
  name: "b0502Registered",
  components: {
    HomeHeader,
    HomeFooter,
    SearchPostal,
  },
  data() {
    return {
      name: "b0502Registered",
      b0502VueForm: {
        userCd: Number,
        companyId: Number,
        industryId: "",
        trainingNm: "",
        date: "",
        time: "",
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
        industryCds: "",
        remarks: "",
      },
      // 画像表示用
      photoAddress: 0,
      isShow: false,
      rules: {
        trainingNm: [validateNecessary("研修会名")],
        tel: [validateNecessary("電話番号")],
        industryId: [validateNecessary("業種")],
        charge: [validateNecessary("担当")],
        date: [validateNecessary("研修期間")],
        time: [validateNecessary("研修時間")],
        postal1: [validateNecessary("郵便番号")],
        proCnt: [validateNecessary("人数")],
        trainingAddress1: [validateNecessary("研修場所")],
        trainingAddress2: [validateNecessary("詳細の住所")],
        trainingContent: [validateNecessary("研修内容")],
      },
    };
  },
  mounted() {
    console.log("hello");
    document.title = "研修新規入力";
    this.getIndustryCds();
  },
  methods: {
    // 業種取得
    getIndustryCds() {
      this.$store.dispatch("b0502Init").then((response) => {
        this.$router.push({
          query: { data: response.data.data },
        });
        this.b0502VueForm.industryCds = response.data.data;
        console.log("industryCds", this.b0502VueForm.industryCds);
      });
    },
    // 住所を取得する
    postalInit(address) {
      this.b0502VueForm.trainingAddress1 = address;
    },
    // 入力内容数字制限
    numValid(val) {
      this.b0502VueForm[val] = this.b0502VueForm[val].replace(/[^0-9]/g, "");
    },
    // 数字の処理
    b0502NumOnFocus($event) {
      numOnFocus($event);
    },
    b0502PersonOnBlur($event, endBy = "人") {
      numOnBlur($event, endBy);
    },
    b0502MoneyOnBlur($event, endBy = "円") {
      numOnBlur($event, endBy);
    },
    // 電話番号の処理
    b0502TelOnFocus($event) {
      telOnFocus($event);
    },
    b0502TelOnBlur($event, endBy = "人") {
      telOnBlur($event, endBy);
    },
    // 画像クリック増やす
    clickHide() {
      this.isShow = !this.isShow;
    },
    // 画像サイズ制限
    imgSize(file) {
      const isLt10M = file.size / 1024 / 1024 < 10;
      if (!isLt10M) {
        this.$message.error("10MB以下の画像をアップロードしてください");
      }
      return isLt10M;
    },
    // 画像アップロード成功
    uploadSuccess(res, file) {
      this.$message.success("アップロード成功");
      this.b0502VueForm.trainingPic1 = URL.createObjectURL(file.raw);
    },
    uploadSuccess2(res, file) {
      this.$message.success("アップロード成功");
      this.b0502VueForm.trainingPic2 = URL.createObjectURL(file.raw);
    },
    uploadSuccess3(res, file) {
      this.$message.success("アップロード成功");
      this.b0502VueForm.trainingPic3 = URL.createObjectURL(file.raw);
    },
    // 画像アップロード失敗
    uploadFail() {
      this.$message.error("アップロード失敗");
    },
    // 情報確認ボタン
    toB0502Confirm() {
      console.log("b0502VueForm:", this.b0502VueForm);
      this.$refs.b0502VueForm.validate((valid) => {
        if (valid) {
          this.$router.push({
            path: "/b0502Confirm",
            query: { flight: JSON.stringify(this.b0502VueForm) },
          });
        }
      });
    },
    // 戻るボタン
    routerBack() {
      history.go(-2);
    },
    // クリアボタン
    clearForm() {
      this.b0502VueForm.trainingNm = "";
      this.b0502VueForm.tel = "";
      this.b0502VueForm.industryId = "";
      this.b0502VueForm.charge = "";
      this.b0502VueForm.date = "";
      this.b0502VueForm.time = "";
      this.b0502VueForm.postal1 = "";
      this.b0502VueForm.postal2 = "";
      this.b0502VueForm.proCnt = "";
      this.b0502VueForm.trainingAddress1 = "";
      this.b0502VueForm.trainingAddress2 = "";
      this.b0502VueForm.trainingContent = "";
      this.b0502VueForm.cost = "";
      this.b0502VueForm.teaNm = "";
      this.b0502VueForm.teaIntro = "";
      this.b0502VueForm.remarks = "";
      this.b0502VueForm.trainingPic1 = "";
      this.b0502VueForm.trainingPic2 = "";
      this.b0502VueForm.trainingPic3 = "";
      this.photoAddress = 0;
      this.isShow = false;
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
// 邮编前三位输入框
.postal1 {
  width: 80px !important;
  margin-right: 11px;
}
// 邮编后四位输入框
.postal2 {
  width: 120px !important;
  margin-left: 11px;
  margin-right: 11px;
}
// 上传图片尺寸限制在框内
.avatar {
  width: 150px;
  height: 150px;
}
// 输入框下拉框标签宽度修改
.el-input,
.el-select {
  width: 280px;
}
// 地址栏宽度
.address {
  width: 82% !important;
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
