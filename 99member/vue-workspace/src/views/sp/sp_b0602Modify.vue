<template>
  <div class="b0602Vue">
    <el-container
      ><HomeHeader />
      <div class="b0602Body">
        <el-main>
          <el-form
            :model="modifyForm"
            :rules="rules"
            ref="modifyForm"
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
                  <div class="title_name">説明会情報修正</div>
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
                    >
                      <el-input
                        v-model="modifyForm.briefingNm"
                        placeholder="説明会名"
                        maxlength="50"
                      />
                    </el-form-item>
                  </el-col>
                   </el-row>
                   <el-row :gutter="20" type="flex" justify="space-between">
                   <el-col :span="12">
                    <el-form-item
                      prop="briefingType"
                      label="説明会方式："
                    >
                      <el-select
                        v-model="modifyForm.briefingType"
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
                    >
                      <el-input
                        v-model="modifyForm.tel"
                        placeholder="電話番号"
                        maxlength="11"
                        @input="numValid('tel')"
                        @focus="b0602TelOnFocus($event)"
                        @blur="b0602TelOnBlur($event)"
                      />
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="12">
                    <el-form-item
                      prop="charge"
                      label="担当："
                    >
                      <el-input
                        v-model="modifyForm.charge"
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
                      label="説明会日："
                    >
                      <el-date-picker
                        v-model="modifyForm.briefingDate"
                        type="date"
                        placeholder="日付"
                        value-format="yyyy/MM/dd"
                        style="width: 280px"
                      />
                    </el-form-item>
                  </el-col>
                   </el-row>
                <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="12">
                    <el-form-item
                      prop="time"
                      label="説明会時間："
                    >
                      <el-time-picker
                        is-range
                        v-model="modifyForm.date"
                        range-separator="-"
                        start-placeholder="開始時間"
                        end-placeholder="終了時間"
                        value-format="HH:mm:ss"
                        style="width: 280px"
                      />
                    </el-form-item>
                  </el-col>
                </el-row>
                
                  
                    <el-form-item
                      prop="postal1"
                      label="郵便番号："
                    >
                      <el-input
                        v-model="modifyForm.postal1"
                        class="postal1"
                        maxlength="3"
                        @input="numValid('postal1')"
                      />
                      <span class="hyphen">-</span>
                      <el-input
                        v-model="modifyForm.postal2"
                        class="postal2"
                        maxlength="4"
                        @input="numValid('postal2')"
                      />
                      <searchPostal
                        @parentMethod="postalInit"
                        :postal1="modifyForm.postal1"
                        :postal2="modifyForm.postal2"
                      />
                    </el-form-item>
                 
                   
                <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="12">
                    <el-form-item
                      prop="proCntPlan"
                      label="予定人数："
                    >
                      <el-input
                        v-model="modifyForm.proCntPlan"
                        placeholder="予定人数"
                        maxlength="9"
                        @input="numValid('proCnt')"
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
                      style="width: 280px"
                    >
                      <el-input
                        v-model="modifyForm.briefingAddress1"
                        class="address"
                        placeholder="入力された郵便番号に応じて、自動的に取得します"
                        :disabled="true"
                        maxlength="200"
                      >
                        {{ modifyForm.briefingAddress1 }}
                      </el-input>
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="24">
                    <el-form-item
                      prop="briefingAddress2"
                      label="場所詳細："
                      style="width: 280px"
                    >
                      <el-input
                        v-model="modifyForm.briefingAddress2"
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
                      prop="briefingContent"
                      label="説明会内容："
                    >
                      <el-input
                        type="textarea"
                        v-model="modifyForm.briefingContent"
                        rows="5"
                        style="width: 280px"
                        maxlength="1000"
                      />
                    </el-form-item>
                  </el-col>
                   </el-row>
                <el-row :gutter="20" type="flex" justify="space-between">
                    <el-col :span="24">
                      <el-form-item
                        prop="teaNm"
                        label="講師氏名："
                      >
                        <el-input
                          v-model="modifyForm.teaNm"
                          placeholder="講師氏名"
                          maxlength="20"
                        />
                      </el-form-item>
                    </el-col>
                </el-row>
                <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="12">
                    <el-form-item
                      prop="remarks"
                      label="備考："
                    >
                      <el-input
                        type="textarea"
                        v-model="modifyForm.remarks"
                        rows="5"
                        style="width: 280px"
                        maxlength="500"
                      />
                    </el-form-item>
                  </el-col>
                   </el-row>
                <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="12">
                    <el-form-item
                      prop="teaIntro"
                      label="講師説明："
                    >
                      <el-input
                        type="textarea"
                        v-model="modifyForm.teaIntro"
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
                            v-if="modifyForm.photoAddress1"
                            :src="modifyForm.photoAddress1"
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
                  </el-row>
                <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="4">
                    <el-form-item prop="photoAddress2">
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
                            v-if="modifyForm.photoAddress2"
                            :src="modifyForm.photoAddress2"
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
                  </el-row>
                <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="4">
                    <el-form-item prop="photoAddress3">
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
                            v-if="modifyForm.photoAddress3"
                            :src="modifyForm.photoAddress3"
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
                  </el-row>
                <el-row :gutter="20" type="flex" justify="space-between">
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

                  <el-button
                    type="primary"
                    class="b0602Button"
                    @click="toB0602Confirm()"
                  >
                    情報確認
                  </el-button>

                  <el-button @click="clearForm()" class="b0602Button">
                    クリア
                  </el-button>

                  <el-button
                    type="primary"
                    @click="routerBack()"
                    class="b0602Button"
                  >
                    戻る
                  </el-button>

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
import HomeHeader from "../spComponents/HomeHeader";
import HomeFooter from "../spComponents/HomeFooter";
// 郵便番号検索機能導入
import SearchPostal from "../spComponents/SearchPostal";
import '@/css/reset.css';
import '@/css/border.css';
//移动端 解决点击按钮闪和active失效的问题
document.body.addEventListener('touchstart' , function(){});
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
      modifyForm: {
        companyId: "",
        briefingId: "",
        briefingNm: "",
        briefingType: "",
        briefingDate: "",
        date: [],
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
        statusFlg: "",
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
           // 状態リストのデータ
      briefing_type: [
        { value: "0", label: "現場" },
        { value: "1", label: "生放送" },
      ],
      // 画像表示用
      photoAddress: 0,
      isShow: false,
      rules: {
        briefingNm: [validateNecessary("説明会会名")],
        tel: [validateNecessary("電話番号")],
        charge: [validateNecessary("担当")],
        briefingDate: [validateNecessary("説明会日")],
        date: [validateNecessary("説明会時間")],
        postal1: [validateNecessary("郵便番号")],
        proCntPlan: [validateNecessary("人数")],
        briefingAddress2: [validateNecessary("詳細の住所")],
        briefingContent: [validateNecessary("説明会内容")],
      },
    };
  },
  mounted() {
    document.title = "説明会情報修正";
    this.b0602InForm = JSON.parse(this.$route.query.flight);
    this.setModifyForm();
    this.getIndustryCds();
  },
  methods: {
    setModifyForm() {
      this.modifyForm.briefingNm = this.b0602InForm.briefingNm;
      this.modifyForm.tel = this.b0602InForm.tel;
      this.modifyForm.charge = this.b0602InForm.charge;
      this.modifyForm.briefingDate = this.b0602InForm.briefingDate;
      this.modifyForm.briefingType = this.b0602InForm.briefingType;
      this.modifyForm.date = [this.b0602InForm.dateFrom, this.b0602InForm.dateTo];
      if (this.b0602InForm.postal != null) {
        this.modifyForm.postal1 = this.b0602InForm.postal.split("-")[0];
        this.modifyForm.postal2 = this.b0602InForm.postal.split("-")[1];
      }
      this.modifyForm.proCntPlan = this.b0602InForm.proCntPlan;
      this.modifyForm.briefingAddress1 = this.b0602InForm.briefingAddress1;
      this.modifyForm.briefingAddress2 = this.b0602InForm.briefingAddress2;
      this.modifyForm.briefingContent = this.b0602InForm.briefingContent;
      this.modifyForm.teaNm = this.b0602InForm.teaNm;
      this.modifyForm.remarks = this.b0602InForm.remarks;
      this.modifyForm.teaIntro = this.b0602InForm.teaIntro;
      this.modifyForm.photoAddress1 = this.b0602InForm.photoAddress1;
      this.modifyForm.photoAddress2 = this.b0602InForm.photoAddress2;
      this.modifyForm.photoAddress3 = this.b0602InForm.photoAddress3;
      this.modifyForm.companyId = this.b0602InForm.companyId;
      this.modifyForm.companyNm = this.b0602InForm.companyNm;
      this.modifyForm.prefeNm = this.b0602InForm.prefeNm;
      this.modifyForm.statusFlg = this.b0602InForm.statusFlg;
      this.modifyForm.briefingId = this.b0602InForm.briefingId;
    },
    // 住所を取得する
    postalInit(address) {
      this.modifyForm.briefingAddress1 = address;
    },
    // 入力内容数字制限
    numValid(val) {
      this.modifyForm[val] = this.modifyForm[val].replace(/[^0-9]/g, "");
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
      this.modifyForm.photoAddress1 = URL.createObjectURL(file.raw);
    },
    uploadSuccess2(res, file) {
      this.$message.success("アップロード成功");
      this.modifyForm.photoAddress2 = URL.createObjectURL(file.raw);
    },
    uploadSuccess3(res, file) {
      this.$message.success("アップロード成功");
      this.modifyForm.photoAddress3 = URL.createObjectURL(file.raw);
    },
    // 画像アップロード失敗
    uploadFail() {
      this.$message.error("アップロード失敗");
    },
    // 情報確認ボタン
    toB0602Confirm() {
      console.clear();
      console.log("modifyForm:", this.modifyForm);
      this.$router.push({
        path: "/sp/sp_b0602Confirm",
        query: { flight: JSON.stringify(this.modifyForm) },
      });
    },
    // 戻るボタン
    routerBack() {
      this.$router.replace({ name: "b0601" });
      this.$router.back(-1);
    },
    // クリアボタン
    clearForm() {
      this.modifyForm.briefingNm = "";
      this.modifyForm.tel = "";
      this.modifyForm.charge = "";
      this.modifyForm.date = "";
      this.modifyForm.time = "";
      this.modifyForm.postal1 = "";
      this.modifyForm.postal2 = "";
      this.modifyForm.proCntPlan = "";
      this.modifyForm.briefingAddress1 = "";
      this.modifyForm.briefingAddress2 = "";
      this.modifyForm.briefingContent = "";
      this.modifyForm.teaNm = "";
      this.modifyForm.teaIntro = "";
      this.modifyForm.remarks = "";
      this.modifyForm.photoAddress1 = "";
      this.modifyForm.photoAddress2 = "";
      this.modifyForm.photoAddress3 = "";
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
  width: 90vw;
  margin-left: 10vw;
  box-shadow: 0 2px 4px #dce5f4, 0 0 6px #dce5f4;
  background-color: #ffffff;
}
// div内上下距离
.b0602Main {
  padding-top: 0.5vh;
  padding-bottom: 0.5vh;
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
// 邮编前三位输入框
.postal1 {
  width: 60px !important;
  margin-right: 11px;
}
// 邮编后四位输入框
.postal2 {
  width: 100px !important;
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
  margin-left: 1vw;
}
// 下面三个按钮的宽度
.b0602Button {
  width: 100px;
  margin: 10px 5px 15px 20px;
  margin-top: 30px;
}
</style>
