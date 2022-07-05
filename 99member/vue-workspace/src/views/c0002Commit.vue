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
        :rules="rules"
        autocomplete="on"
        :model="registerForm"
        ref="registerForm"
        label-position="right"
      >
        <div class="title">
          <div class="loginLogo" @click="toHomepage">
            <el-image :src="require('@/assets/b_home_logo2.png')" class="loginImgLogo" />
          </div>
          <div class="title-required font-blue-22">応募者新規登録確認</div>
          <div class="tips-required font-red-16">※項目は入力必須</div>
        </div>
        <hr style="width: 99%" />
        <div class="formcontent">
          <el-form-item label-width="203px" label="メールアドレス:" prop="userMail">
            <label>{{ registerForm.userMail }}</label>
          </el-form-item>
          <el-form-item label-width="203px" label="パスワード:" prop="pwd">
            <label>{{ password }}</label>
          </el-form-item>
          <el-form-item label-width="203px" label="パスワード確認:" prop="repwd">
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
            <img :src="registerForm.photoAddress" class="avatar" />
          </el-form-item>
          <el-row>
            <el-col :span="12">
              <el-form-item>
                <el-button class="button-confirm" type="primary" @click="insertObousha()"
                  >ログイン画面へ</el-button
                >
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item>
                <el-button class="button-back" @click="routerBack()">戻る</el-button>
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
      password: "",
      registerForm: {
        userCd: "",
        companyId: "",
        authority: "",
        userStatus: "",
        userMail: this.$route.query.data.userMail,
        pwd: this.$route.query.data.pwd,
        repwd: this.$route.query.data.repwd,
        firstName: this.$route.query.data.firstName,
        firstNameKana: this.$route.query.data.firstNameKana,
        lastName: this.$route.query.data.lastName,
        lastNameKana: this.$route.query.data.lastNameKana,
        sex: this.$route.query.data.sex,
        countryZip: this.$route.query.data.countryZip,
        userTel: this.$route.query.data.userTel,
        photoAddress: this.$route.query.data.photoAddress,
      },
    };
  },

  mounted() {
    for (var i = 0; i < this.registerForm.pwd.length; i++) {
      this.password = this.password + "*";
    }
  },
  methods: {
    //TITLE会社LOGOクリック
    toHomepage() {
      this.$router.push({ path: "/home" });
    },
    insertObousha() {
      this.loading = true;
      this.$store
        .dispatch("userInsert", this.registerForm)
        .then((response) => {
          this.loading = false;
          let code = response.data.code;
          if (code == 200) {
            this.$router.push({
              // path: "/success",
              path: "/c0001",
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

.loginLogo {
  position: relative;
  width: 260px;
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
</style>
