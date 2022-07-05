<template>
  <div class="bg_img">
    <vue-particles
      color="#dedede"
      :particleOpacity="0.7"
      :particlesNumber="20"
      shapeType="star"
      :particleSize="6"
      linesColor="#FFFFFF"
      :linesWidth="2"
      :lineLinked="true"
      :lineOpacity="0.4"
      :linesDistance="150"
      :moveSpeed="3"
      :hoverEffect="true"
      hoverMode="grab"
      :clickEffect="true"
      clickMode="repulse"
      class="cash"
    >
    </vue-particles>
    <el-card class="register-form-layout">
      <el-form
        autocomplete="on"
        :model="registerForm"
        ref="registerForm"
        label-position="right"
      >
        <div class="title">
          <div class="loginLogo" @click="toHomepage">
            <el-image :src="require('@/assets/b_home_logo2.png')" class="loginImgLogo" />
          </div>
          <div class="title-required font-blue-22">ユーザー情報</div>
          <div class="tips-required font-red-16"></div>
        </div>
        <hr style="width: 99%" />
        <div class="formcontent">
          <el-form-item label-width="203px" label="メールアドレス:" prop="userMail">
            <label>{{ registerForm.userMail }}</label>
          </el-form-item>
          <el-form-item label-width="203px" label="パスワード:" prop="pwd">
            <label>{{ password }}</label>
          </el-form-item>
          <el-form-item label-width="203px" label="姓:" prop="firstName">
            <label>{{ registerForm.firstName }}</label>
          </el-form-item>
          <el-form-item label-width="203px" label="姓（カナ）:" prop="firstNameKana">
            <label>{{ registerForm.firstNameKana }}</label>
          </el-form-item>
          <el-form-item label-width="203px" label="名:" prop="lastName">
            <label>{{ registerForm.lastName }}</label>
          </el-form-item>
          <el-form-item label-width="203px" label="名（カナ）:" prop="lastNameKana">
            <label>{{ registerForm.lastNameKana }}</label>
          </el-form-item>
          <el-form-item label-width="203px" label="性別:">
            <span v-show="registerForm.sex == '0'">男性</span>
            <span v-show="registerForm.sex == '1'">女性</span>
          </el-form-item>
          <el-form-item label-width="195px" label="電話番号:" prop="countryZip">
            <label>{{ registerForm.countryZip }}</label>
          </el-form-item>
          <el-form-item class="input-small-position2" prop="userTel">
            <label>{{ registerForm.userTel }}</label>
          </el-form-item>
          <el-form-item label-width="195px" label="写真:" prop="photoAddress">
            <img :src="this.picurl" class="avatar" />
          </el-form-item>
          <el-row>
            <el-col :span="12">
              <el-form-item>
                <el-button class="button-confirm" type="primary" @click="syuusei()"
                  >修 正</el-button
                >
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item>
                <el-button class="button-back" @click="shi()">戻る</el-button>
              </el-form-item>
            </el-col>
          </el-row>
        </div>
      </el-form>
    </el-card>
  </div>
</template>
<script>
export default {
  data() {
    return {
      picurl: "",
      password: "",
      registerForm: this.$route.query.data,
      // registerForm: {
      //   userCd: "",
      //   companyId: "",
      //   authority: "",
      //   userStatus: "",
      //   userMail: this.$route.query.data.userMail,
      //   pwd: this.$route.query.data.pwd,
      //   repwd: "",
      //   firstName: this.$route.query.data.firstName,
      //   firstNameKana: this.$route.query.data.firstNameKana,
      //   lastName: this.$route.query.data.lastName,
      //   lastNameKana: this.$route.query.data.lastNameKana,
      //   sex: this.$route.query.data.sex,
      //   countryZip: this.$route.query.data.countryZip,
      //   userTel: this.$route.query.data.userTel,
      //   photoAddress: this.$route.query.data.photoAddress,
      // },
    };
  },

  mounted() {
    this.picurl = "data:image/jpeg;base64," + this.registerForm.photoAddressPic;

    // this.picurl =
    //   "data:image/jpeg;base64,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";
  },

  methods: {
    toHomepage() {
      this.$router.push({ path: "/home" });
    },
    syuusei() {
      this.$router.push({
        path: "/a0901Modify",
        query: { flight: JSON.stringify(this.registerForm) },
      });
    },

    shi() {
      if (
        this.registerForm.authority == "システム管理者（認証済み）" ||
        this.registerForm.authority == "システム管理者（未認証）" ||
        this.registerForm.authority == "スーパー管理者"
      ) {
        this.$router.push({
          path: "/a0003",
        });
      } else if (
        this.registerForm.authority == "会社会員管理員(認証済み)" ||
        this.registerForm.authority == "会社会員管理員(未認証)" ||
        this.registerForm.authority == "会社会員(認証済み)" ||
        this.registerForm.authority == "会社会員(未認証)"
      ) {
        this.$router.push({
          path: "/b0003",
        });
      } else if (this.registerForm.authority == "応募者") {
        this.$router.push({
          path: "/c0003",
        });
      }
      // this.$router.replace({ path: "/a0003" });
      // console.log(this.registerForm.photoAddress);
      // console.log(this.picurl);
    },
  },
};
</script>
<style lang="scss">
body {
  margin: 0px;
}
.el-form-item.is-required:not(.is-no-asterisk) > .el-form-item__label:before {
  content: "※";
}
.formcontent {
  .el-input {
    input {
      height: 40px;
      width: 491px;
      margin: auto;
      border: 0;
      border-bottom: 1px solid #e0e0e084;
      font-size: 12px;
    }
  }
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
  height: 70px;
  background-color: #5db8ff;
  color: #ffffff;
  font-size: 24px;
  font-weight: bolder;
  line-height: 70px;
}
.cash {
  position: fixed;
  width: 100%;
}
.bg_img {
  width: 100%;
  height: 100%;
  background: -webkit-linear-gradient(top, #000099, #0076d1);
  background-size: 100% 100%;
}
.register-form-layout {
  position: relative;
  left: 0;
  right: 0;
  width: 900px;
  margin: 0 auto;
  border-radius: 10px;
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
  left: 280px;
  top: 44px;
  font-weight: normal;
}
.tips-required {
  position: absolute;
  left: 740px;
  top: 57px;
  font-weight: normal;
}
.font-blue-22 {
  color: #014099;
  font-size: 22px;
}
.font-red-16 {
  color: #ff0000;
  font-size: 16px;
}

.input-small-position {
  position: relative;
  left: 470px;
  top: -63px;
}
.input-small-position2 {
  position: relative;
  left: 295px;
  top: -62px;
}
.button-confirm {
  margin-left: 300px;
  width: 250px;
  height: 70px;
  background-image: linear-gradient(to right, #33a1ff, #33cdff);
  border-color: #33ccff;
}
.button-back {
  margin-left: 150px;
  width: 100px;
  height: 70px;
}
::v-deep div > .el-form-item__label {
  font-size: 16px;
  color: #014099;
  font-style: normal;
  font-weight: bold;
}

::v-deep div > .el-input--small > input {
  height: 40px;
  width: 240px;
  margin: auto;
  border: 0;
  border-bottom: 1px solid #e0e0e084;
}
::v-deep div > .el-select > .el-input--small > input {
  height: 40px;
  width: 95px;
  margin: auto;
  border: 0;
  border-bottom: 1px solid #e0e0e084;
}
::v-deep div > .input-small-position2 > .el-form-item__content > .el-input > input {
  height: 40px;
  width: 860px;
  margin: auto;
  border: 0;
  border-bottom: 1px solid #e0e0e084;
}
::v-deep div > .el-textarea > textarea {
  height: 40px;
  width: 491px;
  border: 0;
  border-bottom: 1px solid #e0e0e084;
}
::v-deep div > .el-radio > .el-radio__label {
  font-size: 12px;
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
::v-deep div > .el-checkbox > .is-checked > .el-checkbox__inner {
}
::v-deep div > .el-checkbox > .el-checkbox__input > .el-checkbox__inner::after {
  height: 18px;
  left: 10px;
  width: 6px;
}
::v-deep div > .el-upload-list {
  margin: -40px 0px 0px 110px;
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
::v-deep div > .avatar-uploader > .el-upload {
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
  border: 1px dashed #d9d9d9;
}
::v-deep .avatar-uploader .el-upload:hover {
  border-color: #409eff;
}
.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
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
  font-size: 14px;
}
.loginLogo {
  position: relative;
  width: 260px;
}
</style>
