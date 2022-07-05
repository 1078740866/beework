<template>
    <el-card class="register-form-layout">
      <el-form
        :rules="rules"
        autocomplete="on"
        :model="registerForm"
        ref="registerForm"
        label-position="right"
      >
        <div class="title">
          <div class="logo"></div>
          <div class="title-required font-blue-22">会社新規(登録)</div>
          <div class="tips-required font-red-16">※項目は入力必須</div>
        </div>
        <hr style="width: 99%" />
        <div class="headT">会社情報</div>
        <div class="formCommit">
          <el-form-item label-width="195px" label="会社名:" prop="companyNm">
            <label>{{ registerForm.companyNm }}</label>
          </el-form-item>
          <el-form-item label-width="195px" label="電話番号:" prop="companyTel">
            <label>{{ registerForm.companyTel }}</label>
          </el-form-item>
          <el-form-item
            label-width="195px"
            label="メールアドレス:"
            prop="companyMail"
          >
            <label>{{ registerForm.companyMail }}</label>
          </el-form-item>
          <el-form-item
            label-width="195px"
            label="会社規模:"
            prop="companyScale"
          >
            <label>{{ registerForm.companyScaleNm }}</label>
          </el-form-item>
          <el-form-item label-width="195px" label="国:" prop="country">
            <label>{{ registerForm.countryNm }}</label>
          </el-form-item>
          <el-form-item
            label-width="195px"
            label="郵便番号:"
            prop="companyPostal"
          >
            <label>{{ registerForm.companyPostal }}</label>
          </el-form-item>
          <el-form-item label-width="195px" label="会社所在地:">
            <label>{{ registerForm.address1 }}</label>
            <label>{{ registerForm.address2 }}</label>
          </el-form-item>
          <el-form-item
            label-width="195px"
            style="margin-top: -70px"
            prop="address3"
          >
            <label>{{ registerForm.address3 }}</label>
          </el-form-item>
          <el-form-item label-width="195px" label="業種1:" prop="industryCd1">
            <label>{{ registerForm.industryId1Nm }}</label>
          </el-form-item>
          <el-form-item
            label-width="195px"
            label="業種2:"
            v-show="registerForm.industryId2 != null"
          >
            <label>{{ registerForm.industryId2Nm }}</label>
          </el-form-item>
          <el-form-item
            label-width="195px"
            label="業種3:"
            v-show="registerForm.industryId3 != null"
          >
            <label>{{ registerForm.industryId3Nm }}</label>
          </el-form-item>
          <el-form-item label-width="195px" label="資本金:" prop="capital">
            <label>{{ registerForm.capital }}</label>
          </el-form-item>
          <el-form-item
            label-width="195px"
            label="事業内容:"
            prop="businessContent"
          >
            <label>{{ registerForm.businessContent }}</label>
          </el-form-item>
          <el-form-item label-width="195px" label="売上:" prop="sales">
            <label>{{ registerForm.salesAmount }}</label>
          </el-form-item>
          <el-form-item
            label-width="195px"
            label="ホームページ:"
            prop="homepage"
          >
            <label>{{ registerForm.homepage }}</label>
          </el-form-item>
          <el-form-item
            label-width="195px"
            label="謄本画像:"
            prop="licenseAddress"
          >
            <el-image
              style="width: 178px; height: 178px"
              :src="registerForm.licenseAddress"
              :fit="fit"
            >
            </el-image>
          </el-form-item>
          <el-form-item
            label-width="195px"
            label="会社LOGO:"
            prop="companyLogo"
          >
            <el-image
              style="width: 178px; height: 178px"
              :src="registerForm.companyLogo"
              :fit="fit"
            >
            </el-image>
          </el-form-item>
          <el-form-item
            label-width="195px"
            label="会社画像1:"
            prop="photoAddress1"
          >
            <el-image
              style="width: 178px; height: 178px"
              :src="registerForm.photoAddress1"
              :fit="fit"
            >
            </el-image>
          </el-form-item>
          <el-form-item
            label-width="195px"
            v-show="photoAddress2 != null"
            label="会社画像2:"
          >
            <el-image
              style="width: 178px; height: 178px"
              :src="registerForm.photoAddress2"
              :fit="fit"
            >
            </el-image>
          </el-form-item>
          <el-form-item
            label-width="195px"
            label="会社画像3:"
            v-show="photoAddress3 != null"
          >
            <el-image
              style="width: 178px; height: 178px"
              :src="registerForm.photoAddress3"
              :fit="fit"
            >
            </el-image>
          </el-form-item>
          <el-form-item label-width="195px" label="会社ビデオ1:" prop="">
            <!-- TODO -->
          </el-form-item>
          <el-form-item
            label-width="195px"
            label="会社ビデオ2:"
            v-show="vedioAddress > 0"
          >
            <!-- TODO -->
          </el-form-item>
          <el-form-item
            label-width="195px"
            label="会社ビデオ3:"
            v-show="vedioAddress > 1"
          >
            <!-- TODO -->
          </el-form-item>
          <hr style="width: 99%" />
          <div class="headT">ユーザー情報</div>
          <el-form-item
            label-width="203px"
            label="メールアドレス:"
            prop="userMail"
          >
            <label>{{ registerForm.userMail }}</label>
          </el-form-item>
          <el-form-item label-width="203px" label="パスワード:" prop="password">
            <label>{{ registerForm.password }}</label>
          </el-form-item>
          <el-form-item
            label-width="203px"
            label="パスワード確認:"
            prop="repassword"
          >
            <label>{{ registerForm.repassword }}</label>
          </el-form-item>
          <el-form-item label-width="203px" label="姓:" prop="firstName">
            <label>{{ registerForm.firstName }}</label>
          </el-form-item>
          <el-form-item
            label-width="203px"
            label="姓（カナ）:"
            prop="firstNameKana"
          >
            <label>{{ registerForm.firstNameKana }}</label>
          </el-form-item>
          <el-form-item label-width="203px" label="名:" prop="lastName">
            <label>{{ registerForm.lastName }}</label>
          </el-form-item>
          <el-form-item
            label-width="203px"
            label="名（カナ）:"
            prop="lastNameKana"
          >
            <label>{{ registerForm.lastNameKana }}</label>
          </el-form-item>
          <el-form-item label-width="203px" label="性別:">
            <el-radio
              v-model="registerForm.sex"
              label="1"
              v-show="registerForm.sex == '1'"
              >男性</el-radio
            >
            <el-radio
              v-model="registerForm.sex"
              label="2"
              v-show="registerForm.sex == '2'"
              >女性</el-radio
            >
          </el-form-item>
          <el-form-item label-width="195px" label="電話番号:">
            <label>{{ registerForm.countryZip }}</label>
            <label>{{ registerForm.userTel }}</label>
          </el-form-item>
          <el-form-item
            label-width="203px"
            label="写真:"
            prop="photoAddress"
          >
            <el-image
              style="width: 178px; height: 178px"
              :src="registerForm.photoAddress"
              :fit="fit"
            >
            </el-image>
          </el-form-item>
          <el-row>
            <el-col :span="12">
              <el-form-item>
                <el-button
                  class="button-confirm"
                  type="primary"
                  @click="insertCompany()"
                  >確認</el-button
                >
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item>
                <el-button class="button-back" @click="routerBack()"
                  >戻る</el-button
                >
              </el-form-item>
            </el-col>
          </el-row>
        </div>
      </el-form>
    </el-card>
</template>

<script>
import '@/css/reset.css';
import '@/css/border.css';
//移动端 解决点击按钮闪和active失效的问题
document.body.addEventListener('touchstart' , function(){});
export default {
  name: "register",
  data() {
    return {
      title: "弹窗标题",
      show: false,
      zip: null,
      pref_id: null,
      locality: null,
      street: null,
      loading: false,
      registerForm: this.$route.query.data.companyInfo,
      industryCd: 0,
      photoAddress: 0,
      vedioAddress: 0,
      rules: {
        userMail: [{ required: true }],
        companyMail: [{ required: true }],
        password: [{ required: true }],
        repassword: [{ required: true }],
        companyNm: [{ required: true }],
        countryZip: [{ required: true }],
        companyTel: [{ required: true }],
        companyScale: [{ required: true }],
        countryId: [{ required: true }],
        companyPostal: [{ required: true }],
        address1: [{ required: true }],
        address2: [{ required: true }],
        address3: [{ required: true }],
        capital: [{ required: true }],
        industryId1: [{ required: true }],
        businessContent: [{ required: true }],
        licenseAddress: [{ required: true }],
        firstName: [{ required: true }],
        firstNameKana: [{ required: true }],
        lastName: [{ required: true }],
        lastNameKana: [{ required: true }],
        userTel: [{ required: true }],
      },
    };
  },
  mounted() {
    document.title="会社新規登録確認"
  },
  methods: {
    insertCompany() {
      this.loading = true;
      if (
        this.registerForm.salesAmount != "" &&
        this.registerForm.salesAmount != null
      ) {
        var val = this.registerForm.salesAmount;
        val = val.replace(/,/g, "");
        var temp = val.substr(0, val.length - 1);
        this.registerForm.salesAmount = temp; // 返回
      }
      this.$store
        .dispatch("insertCompany", this.registerForm)
        .then((response) => {
          this.loading = false;
          let code = response.data.code;
          if (code == 200) {
            this.$router.push({
              // path: "/success",
              path: "/sp/sp_b0003",
              query: { data: response.data.data },
            });
          } else if (code == 404) {
            this.$message.error(response.data.message);
          } else {
            this.$router.push({
              path: "/error",
              query: { message: response.data.message },
            });
          }
        })
        .catch(() => {
          this.loading = false;
        });
    },
    routerBack() {
      this.$router.back(-1);
    },
  },
};
</script>
<style lang="scss">
.el-form-item.is-required:not(.is-no-asterisk) > .el-form-item__label:before {
  content: "※";
}
.el-form-item{
  margin-bottom: 20px;
}
.formCommit-popup {
  background-color: #ffffff;
  margin-top: 5px;
  padding-top: 10px;
  font-size: 16px;
  padding-left: 10px;

  .el-select {
    .el-input {
      input {
        height: 40px;
        margin: auto;
      }
    }
  }
}
.formCommit {
  .el-input {
    input {
      height: 40px;
      margin: auto;
      font-size: 16px;
    }
  }
}
.formCommit-popup .el-form-item__label{
  width: 20% !important;
}

.formCommit-popup-content {
  background-color: #ffffff;  
  margin-top: 20px;
  padding-top: 10px;
  font-size: 16px;
}
.el-table .warning-row {
  background: oldlace;
}

.el-table .success-row {
  background: #f0f9eb;
}
</style>
<style scoped>
.headT {
  width: 100%;
  height: 40px;
  background-color: #5db8ff;
  color: #ffffff;
  font-size: 20px;
  font-weight: bolder;
  line-height: 40px;
  margin-bottom: 20px;
}
.cash {
  position: fixed;
  width: 100%;
}
.register-form-layout {
  position: relative;
  left: 0;
  right: 0;
  width: 100vw;
  margin: 0 auto;
  border-radius: 10px;
}
.logo {
  float: left;
  position: relative;
  right: 0;
  width: 200px;
  height: 50px;
  background: url("~@/assets/b_home_logo2.png");
  background-repeat: no-repeat;
  background-size: contain;
  background-position: center;
}
.title {
  width: 100%;
  height: 60px;
}
.tit {
  position: absolute;
  left: 370px;
  top: 51px;
  font-weight: normal;
}
.title-required {
  position: absolute;
  right: 10px;
  top: 44px;
  font-weight: normal;
}
.tips-required {
  position: absolute;
  right: 10px;
  font-weight: normal;
}
.font-blue-22 {
  color: #014099;
  font-size: 24px;
}
.font-red-16 {
  color: #ff0000;
  font-size: 16px;
}
.button1 {
  position: absolute;
  border: 0px;
  margin-left: 10px;
}
.button-position{
  position: absolute;
  margin-left: 10px;
}
.button-position2 {
  position: absolute;
  margin-left: 10px;
}
.button-position4 {
  position: absolute;
  margin-left: 15px;
}
.button-position5 {
  position: absolute;
  right: 30px;
  top: 40px;
}
.span-position {
  background: url("~@/assets/b_control2.png") center center no-repeat;
  position: absolute;
  left: 500px;
  width: 32px;
  height: 35px;
  top: 0px;
  border: 0px;
}
.select1{
  width: 35% !important;
  border-radius: 6px;
  border: 1px solid #464545;
}
.select1:hover {
  border: 1px solid #35a7e9;
}
.photoInput{
  width: 61% !important;
  margin-left: 3%;
}
.button-confirm {
  width: 250px;
  height: 70px;
  background-image: linear-gradient(to right, #33a1ff, #33cdff);
  border-color: #33ccff;
}
.button-back {
  margin-left: 100px;
  width: 100px;
  height: 70px;
  border-color: #909399;
  background: #b7b7b8;
  color:#ffffff;
}
/* 会社pop検索ボタン */
.button-select-pop {
  margin-left: 20px;
  margin-bottom: 10px;
}
/* 会社pop戻るボタン */
.button-back-pop {
  width: 89px;
  height: 40.4px;
  border-color: #909399;
  background: #909399;
  margin-left: 50px;
  margin-bottom: 10px;
}
.el-input,
.el-select {
  width: 100%;
}
/* popup全局画面 */
::v-deep .modal-container{
  width: 80%;
}
/* 邮编前三位输入框 */
.postal1 {
 width: 30vw !important;
 margin-left: 5px;
 vertical-align:middle;
}
/* 邮编后四位输入框 */
.postal2 {
 width: 43.7vw !important;
 margin-left: 5px;
 vertical-align:middle;
}
/* 解决点击后出现蓝色默认背景色 */
body{
  margin: 0px;
  -webkit-tap-highlight-color:rgba(0,0,0,0);
}
/* 解决点击后出现蓝色默认背景色 */
::v-deep .el-select >.el-input:focus-within{
 -webkit-tap-highlight-color: transparent!important;
}
::v-deep .el-select >.el-input__suffix:focus-within{
 -webkit-tap-highlight-color: transparent!important;
}
/* 输入框边框颜色变更 */
::v-deep div >.el-input__inner{
  border: 1px solid #464545;
}
::v-deep div > .el-input__inner:focus{  
  border: 1px solid #35a7e9;
}
/* textarea */
::v-deep div >.el-textarea__inner{
  height: 120px!important;
  border: 1px solid #464545;
}
/* 错误信息 */
::v-deep div > .el-form-item__error{
 font-size: 16px;
}
/* アップロード */
::v-deep div >.el-button--small{
  padding: 15px 30px;
}
::v-deep div > .el-input--small > input {
  height: 40px;
  width: 240px;
  margin: auto;
  border: 0;
}
::v-deep div > .el-select > .el-input--small > input {
  height: 40px;
  width: 95px;
  margin: auto;
  border: 0;
}
::v-deep
  div
  > .el-form-item__content
  > .el-input
  > input {
  height: 40px;
  margin: auto;
}
::v-deep div > .el-form-item__label {
  font-size: 16px;
  color: #014099;
  font-style: normal;
  font-weight: bold;
  width: 40% !important;
  text-align: left !important;
  margin-left: 5px;
}
::v-deep div > .el-form-item__content {
  margin-left: 5px!important;
}
::v-deep div > .el-radio > .el-radio__label {
  font-size: 18px;
}
::v-deep div > .el-radio > .el-radio__input > .el-radio__inner {
  width: 20px;
  height: 20px;
}
::v-deep div > .el-radio > .el-radio__input > .el-radio__inner {
  width: 20px;
  height: 20px;
}
::v-deep div > .el-radio > .is-checked > .el-radio__inner {
  background: #33a1ff;
  border-color: #33a1ff;
}
::v-deep div > .el-checkbox > .el-checkbox__input > .el-checkbox__inner:hover {
  border-color: #33a1ff;
}
::v-deep div > .el-checkbox > .el-checkbox__input > .el-checkbox__inner::after {
  height: 18px;
  left: 10px;
  width: 6px;
}
/* upload */
::v-deep div > .el-upload-list {
  width: 350px;
}
.register-center-layout {
  background: #409eff;
  width: auto;
  height: auto;
  max-width: 100%;
  max-height: 100%;
  margin-top: 200px;
}
.postal1 {
  width: 10vw;
  text-align: center;
}
.postal2 {
  width: 50vw;
  text-align: center;
}
::v-deep div > .avatar-uploader > .el-upload {
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
  border: 1px dashed #464545;
}
::v-deep .avatar-uploader .el-upload:hover {
  border-color: #35a7e9;
}
.avatar-uploader-icon {
  font-size: 28px;
  color: #464545;
  width: 178px;
  height: 178px;
  line-height: 178px;
  text-align: center;
}
.avatar {
  width: 178px;
  height: 178px;
  display: block;
}
.persion {
  color: #014099;
  font-size: 16px;
  margin: 8px 0;
  font-weight: 600;
  position: absolute;
}
.persion2 {
  color: #014099;
  margin-left: 8px;
  font-size: 16px;
}
/* 会社popselect */
.popForm{
  width: 28vw !important;
  margin-bottom: 5px!important;
}
/* 会社popinput */
.popFormInput{
  width: 56vw !important;
  margin-bottom: 5px!important;
}
</style>
