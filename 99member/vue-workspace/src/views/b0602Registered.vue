<template>
  <div class="b0602Vue">
    <el-container
      ><HomeHeader />
      <div class="b0602Body">
        <el-main>
          <el-form
            :model="b0602VueForm"
            :rules="rules"
            ref="b0602VueForm"
            autocomplete="on"
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
                  <div class="title_name">説明会新規入力</div>
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
                      label-width="100px"
                    >
                      <el-input
                        v-model="b0602VueForm.briefingNm"
                        placeholder="説明会名"
                        maxlength="50"
                      />
                    </el-form-item>
                  </el-col>
                  <el-col :span="12">
                    <el-form-item
                      prop="briefingType"
                      label="説明会方式："
                      label-width="110px"
                    >
                      <el-select
                        v-model="b0602VueForm.briefingType"
                        placeholder="選択してください"
                      >
                      <el-option
                          v-for="item in briefing_type"
                          :key="item.value"
                          :label="item.label"
                          :value="item.value"
                        />
                      </el-select>
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="12">
                    <el-form-item
                      prop="tel"
                      label="電話番号："
                      label-width="100px"
                    >
                      <el-input
                        v-model="b0602VueForm.tel"
                        placeholder="電話番号"
                        maxlength="11"
                        @input="numValid('tel')"
                        @focus="b0602TelOnFocus($event)"
                        @blur="b0602TelOnBlur($event)"
                      />
                    </el-form-item>
                  </el-col>
                  <el-col :span="12">
                    <el-form-item
                      prop="charge"
                      label="担当："
                      label-width="110px"
                    >
                      <el-input
                        v-model="b0602VueForm.charge"
                        placeholder="担当"
                        maxlength="20"
                      />
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="12">
                    <el-form-item
                      prop="briefingDate"
                      label="説明会日："
                      label-width="100px"
                    >
                      <el-date-picker
                        v-model="b0602VueForm.briefingDate"
                        type="date"
                        placeholder="日付"
                        value-format="yyyy/MM/dd"
                        style="width: 280px"
                        :picker-options="pickerOptions"
                      />

                    </el-form-item>
                  </el-col>
                  <el-col :span="12">
                    <el-form-item
                      prop="time"
                      label="説明会時間："
                      label-width="110px"
                    >
                     <el-time-picker
                    v-model="b0602VueForm.dateFrom"
                    placeholder="開始時間"
                    value-format="HH:mm:ss"
                    class="rangeStyle"
                    align="right"
                    type="time"
                    style="width :115px"
                  />
                  <label> ~ </label>
                  <el-time-picker
                    v-model="b0602VueForm.dateTo"
                    placeholder="終了時間"
                    value-format="HH:mm:ss"
                    class="rangeStyle"
                    align="right"
                    type="time"
                    style="width :115px"
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
                        v-model="b0602VueForm.postal1"
                        class="postal1"
                        maxlength="3"
                        @input="numValid('postal1')"
                      />
                      <span class="hyphen">-</span>
                      <el-input
                        v-model="b0602VueForm.postal2"
                        class="postal2"
                        maxlength="4"
                        @input="numValid('postal2')"
                      />
                      <searchPostal
                        @parentMethod="postalInit"
                        :postal1="b0602VueForm.postal1"
                        :postal2="b0602VueForm.postal2"
                      />
                    </el-form-item>
                  </el-col>
                  <el-col :span="12">
                    <el-form-item
                      prop="proCntPlan"
                      label="予定人数："
                      label-width="110px"
                    >
                      <el-input
                        v-model="b0602VueForm.proCntPlan"
                        placeholder="人数"
                        maxlength="9"
                        @input="numValid('proCntPlan')"
                        @focus="b0602NumOnFocus($event)"
                        @blur="b0602PersonOnBlur($event)"
                      />
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="24">
                    <el-form-item
                      prop="briefingAddress1"
                      label="説明会場所："
                      label-width="100px"
                      :required="true"
                    >
                      <el-input
                        v-model="b0602VueForm.briefingAddress1"
                        class="address"
                        placeholder="入力された郵便番号に応じて、自動的に取得します"
                        :disabled="true"
                        maxlength="200"
                      >
                        {{ b0602VueForm.briefingAddress1 }}
                      </el-input>
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="24">
                    <el-form-item
                      prop="briefingAddress2"
                      label="住所詳細："
                      label-width="100px"
                    >
                      <el-input
                        v-model="b0602VueForm.briefingAddress2"
                        placeholder="住所詳細"
                        class="address"
                        maxlength="50"
                      />
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="12">
                    <el-form-item
                      prop="briefingContent"
                      label="説明会内容："
                      label-width="100px"
                    >
                      <el-input
                        type="textarea"
                        v-model="b0602VueForm.briefingContent"
                        rows="5"
                        style="width: 280px"
                        maxlength="500"
                      />
                    </el-form-item>
                  </el-col>
                  <el-col :span="12">
                    <el-col :span="24">
                      <el-form-item
                        prop="teaNm"
                        label="講師氏名："
                        label-width="100px"
                      >
                        <el-input
                          v-model="b0602VueForm.teaNm"
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
                        v-model="b0602VueForm.remarks"
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
                      label-width="110px"
                    >
                      <el-input
                        type="textarea"
                        v-model="b0602VueForm.teaIntro"
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
                      prop="photoAddress1"
                      label="会社画像："
                      label-width="100px"
                    >
                      <div>
                        <el-upload
                            class="avatar-uploader"
                            :action="uploadUrl()"
                            :on-error="uploadFail"
                            :show-file-list="false"
                            :on-success="handleAvatarSuccesslicense1"
                            accept="image/jpeg,image/jpg,image/png"
                            :before-upload="beforeUpload"
                            list-type="picture-card"
                          >
                          <img
                            v-if="b0602VueForm.photoAddress1"
                            :src="photoAddress1Pic"
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
                    <el-form-item prop="photoAddress2">
                      <div v-show="photoAddress > 0">
                        <el-upload
                            class="avatar-uploader"
                            :action="uploadUrl()"
                            :on-error="uploadFail"
                            :show-file-list="false"
                            :on-success="handleAvatarSuccesslicense2"
                            accept="image/jpeg,image/jpg,image/png"
                            :before-upload="beforeUpload"
                            list-type="picture-card"
                          >
                          <img
                            v-if="b0602VueForm.photoAddress2"
                            :src="photoAddress2Pic"
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
                    <el-form-item prop="photoAddress3">
                      <div v-show="photoAddress > 1">
                        <el-upload
                            class="avatar-uploader"
                            :action="uploadUrl()"
                            :on-error="uploadFail"
                            :show-file-list="false"
                            :on-success="handleAvatarSuccesslicense3"
                            accept="image/jpeg,image/jpg,image/png"
                            :before-upload="beforeUpload"
                            list-type="picture-card"
                          >
                          <img
                            v-if="b0602VueForm.photoAddress3"
                            :src="photoAddress3Pic"
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
                    class="b0602Button"
                    @click="toB0602Confirm()"
                  >
                    情報確認
                  </el-button>
                </el-col>
                <el-col :span="4" :offset="1">
                  <el-button @click="clearForm()" class="b0602Button">
                    クリア
                  </el-button>
                </el-col>
                <el-col :span="4" :offset="1">
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
  name: "b0602Registered",
  components: {
    HomeHeader,
    HomeFooter,
    SearchPostal,
  },
  data() {
    return {
      name: "b0602Registered",
      b0602VueForm: {
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
      b0602InForm: {
        companyId: "",
        companyNm: "",
        briefingId: "",
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
        useFlg: "",
      },
      pickerOptions: {
          disabledDate(time) {
          //如果没有后面的-8.64e7就是不可以选择今天的 
            return time.getTime() < Date.now() - 8.64e7;
         }
      },
      // 状態リストのデータ
      briefing_type: [
        { value: "0", label: "現場" },
        { value: "1", label: "生放送" },
      ],
      // 画像表示用
      photoAddress: 0,
      isShow: false,
      rules: {
        briefingNm: [validateNecessary("説明会名")],
        briefingType: [validateNecessary("説明会方式")],
        tel: [validateNecessary("電話番号")],
        charge: [validateNecessary("担当")],
        briefingDate: [validateNecessary("説明会日")],
        dateFrom: [validateNecessary("開始時間")],
        dateTo: [validateNecessary("終了時間")],
        postal1: [validateNecessary("郵便番号")],
        proCntPlan: [validateNecessary("人数")],
        briefingAddress1: [validateNecessary("住所")],
        briefingAddress2: [validateNecessary("詳細の住所")],
        briefingContent: [validateNecessary("説明会内容")],
      },
    };
  },
  created: function() {
    this.$store.dispatch("b0601Init", this.b0602VueForm).then((response) => {
      this.$router.push({
        query: { data: response.data.data },
      });
    });
  },
  mounted() {
    document.title = "説明会情報新規";
    this.b0602InForm = JSON.parse(this.$route.query.flight);
    this.setb0602VueForm();
  },
  methods: {
    setb0602VueForm() {
       this.b0602VueForm.briefingNm = this.b0602InForm.briefingNm;
      this.b0602VueForm.tel = this.b0602InForm.tel;
      this.b0602VueForm.charge = this.b0602InForm.charge;
      this.b0602VueForm.briefingDate = this.b0602InForm.briefingDate;
      this.b0602VueForm.briefingType = this.b0602InForm.briefingType;
      this.b0602VueForm.dateFrom = this.b0602InForm.dateFrom;
      this.b0602VueForm.dateTo = this.b0602InForm.dateTo;
      this.b0602VueForm.postal1 = this.b0602InForm.postal1;
      this.b0602VueForm.postal2 = this.b0602InForm.postal2;
      this.b0602VueForm.proCntPlan = this.b0602InForm.proCntPlan;
      this.b0602VueForm.briefingAddress1 = this.b0602InForm.briefingAddress1;
      this.b0602VueForm.briefingAddress2 = this.b0602InForm.briefingAddress2;
      this.b0602VueForm.briefingContent = this.b0602InForm.briefingContent;
      this.b0602VueForm.teaNm = this.b0602InForm.teaNm;
      this.b0602VueForm.remarks = this.b0602InForm.remarks;
      this.b0602VueForm.teaIntro = this.b0602InForm.teaIntro;
      this.b0602VueForm.photoAddress1 = this.b0602InForm.photoAddress1;
      this.b0602VueForm.photoAddress2 = this.b0602InForm.photoAddress2;
      this.b0602VueForm.photoAddress3 = this.b0602InForm.photoAddress3;
      this.b0602VueForm.companyId = this.b0602InForm.companyId;
      this.b0602VueForm.companyNm = this.b0602InForm.companyNm;
      this.b0602VueForm.prefeNm = this.b0602InForm.prefeNm;
      this.b0602VueForm.statusFlg = this.b0602InForm.statusFlg;
      this.b0602VueForm.briefingId = this.b0602InForm.briefingId;
    },
    // 住所を取得する
    postalInit(address) {
      this.b0602VueForm.briefingAddress1 = address;
    },
    // 入力内容数字制限
    numValid(val) {
      this.b0602VueForm[val] = this.b0602VueForm[val].replace(/[^0-9]/g, "");
    },
    // 数字の処理
    b0602NumOnFocus($event) {
      numOnFocus($event);
    },
    b0602PersonOnBlur($event, endBy = "人") {
      numOnBlur($event, endBy);
    },
    b0602MoneyOnBlur($event, endBy = "円") {
      numOnBlur($event, endBy);
    },
    // 電話番号の処理
    b0602TelOnFocus($event) {
      telOnFocus($event);
    },
    b0602TelOnBlur($event, endBy = "人") {
      telOnBlur($event, endBy);
    },
    
    uploadFail() {
      this.$message.error("アップロード失敗");
    },

    handleAvatarSuccesslicense1(res, file) {
      this.$message.success("アップロード成功");
      this.photoAddress1Pic = URL.createObjectURL(file.raw);
      this.b0602VueForm.photoAddress1 = res;
    },

    handleAvatarSuccesslicense2(res, file) {
      this.$message.success("アップロード成功");
      this.photoAddress2Pic = URL.createObjectURL(file.raw);
      this.b0602VueForm.photoAddress2 = res;
    },

    handleAvatarSuccesslicense3(res, file) {
      this.$message.success("アップロード成功");
      this.photoAddress3Pic = URL.createObjectURL(file.raw);
      this.b0602VueForm.photoAddress3 = res;
    },

    beforeUpload(file) {
      const isJPG = file.type === "image/jpeg";
      const isPNG = file.type === "image/png";
      const isLt2M = file.size / 1024 / 1024 < 5;

      if (!isJPG && !isPNG) {
        this.$message.error("画像をアップロードするのはJPGやPNG形式だけです。");
      }
      if (!isLt2M) {
        this.$message.error("アップロード画像のサイズは5MBを超えてはいけません。");
      }
      return (isJPG || isPNG) && isLt2M;
    },

    uploadUrl() {
          return `${this.$store.state.HOST}/B0002/upload`;
        },
        
    // 情報確認ボタン
    toB0602Confirm() {
      console.log("b0602VueForm:", this.b0602VueForm);
      this.$refs.b0602VueForm.validate((valid) => {
        if (valid) {
          this.$router.push({
            path: "/b0602Confirm",
            query: { flight: JSON.stringify(this.b0602VueForm) },
          });
        }
      });
    },
    // 戻るボタン
    routerBack() {
      console.log("戻る");
      this.$router.replace({ path: "b0003" });
    },

    // クリアボタン
    clearForm() {
      this.b0602VueForm.briefingNm = "";
      this.b0602VueForm.tel = "";
      this.b0602VueForm.charge = "";
      this.b0602VueForm.date = "";
      this.b0602VueForm.time = "";
      this.b0602VueForm.postal1 = "";
      this.b0602VueForm.postal2 = "";
      this.b0602VueForm.proCntPlan = "";
      this.b0602VueForm.briefingAddress1 = "";
      this.b0602VueForm.briefingAddress2 = "";
      this.b0602VueForm.briefingContent = "";
      this.b0602VueForm.teaNm = "";
      this.b0602VueForm.teaIntro = "";
      this.b0602VueForm.remarks = "";
      this.b0602VueForm.photoAddress1 = "";
      this.b0602VueForm.photoAddress2 = "";
      this.b0602VueForm.photoAddress3 = "";
      this.photoAddress = 0;
      this.isShow = false;
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
.b0602TableDiv {
  margin-left: 5vw;
}
// 下面三个按钮的宽度
.b0602Button {
  width: 100px;
}
</style>
