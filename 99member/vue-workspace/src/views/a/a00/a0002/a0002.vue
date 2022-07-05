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
          <div class="title-required font-blue-22">システム管理者新規登録</div>
          <div class="tips-required font-red-16">※は入力必須項目です。</div>
        </div>
        <hr style="width: 99%" />
        <div class="formcontent">
          <el-form-item label-width="203px" label="メールアドレス:" prop="userMail">
            <el-input
              class="inputwidth"
              v-model="registerForm.userMail"
              placeholder=""
              autocomplete="off"
            >
            </el-input>
          </el-form-item>
          <el-form-item label-width="203px" label="パスワード:" prop="pwd">
            <el-input
              class="inputwidth"
              type="password"
              v-model="registerForm.pwd"
              placeholder=""
              autocomplete="off"
            >
            </el-input>
          </el-form-item>
          <el-form-item label-width="203px" label="パスワード確認:" prop="repwd">
            <el-input
              class="inputwidth"
              type="password"
              v-model="registerForm.repwd"
              placeholder=""
              autocomplete="off"
            >
            </el-input>
          </el-form-item>
          <el-form-item label-width="203px" label="姓:" prop="firstName">
            <el-input
              class="inputwidth"
              v-model="registerForm.firstName"
              placeholder=""
              autocomplete="off"
            >
            </el-input>
          </el-form-item>
          <el-form-item label-width="203px" label="姓（カナ）:" prop="firstNameKana">
            <el-input
              class="inputwidth"
              v-model="registerForm.firstNameKana"
              placeholder=""
              autocomplete="off"
            >
            </el-input>
          </el-form-item>
          <el-form-item label-width="203px" label="名:" prop="lastName">
            <el-input
              class="inputwidth"
              v-model="registerForm.lastName"
              placeholder=""
              autocomplete="off"
            >
            </el-input>
          </el-form-item>
          <el-form-item label-width="203px" label="名（カナ）:" prop="lastNameKana">
            <el-input
              class="inputwidth"
              v-model="registerForm.lastNameKana"
              placeholder=""
              autocomplete="off"
            >
            </el-input>
          </el-form-item>
          <el-form-item label-width="203px" label="性別:" prop="sex">
            <el-radio v-model="registerForm.sex" label="0">男性</el-radio>
            <el-radio v-model="registerForm.sex" label="1">女性</el-radio>
          </el-form-item>
          <el-form-item
            label-width="195px"
            label="電話番号:"
            prop="countryZip"
            @blur="remberTel($event)"
          >
            <el-select size="small" v-model="registerForm.countryZip">
              <el-option
                v-for="item in telCode"
                :key="item.value"
                :label="item.label"
                :value="item.value"
              >
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item class="input-small-position2" prop="userTel">
            <el-input v-model="registerForm.userTel" placeholder="" autocomplete="off">
            </el-input>
          </el-form-item>
          <el-form-item label-width="195px" label="写真:" prop="photoAddress">
            <el-upload
              class="avatar-uploader"
              action="https://www.mocky.io/v2/5185415ba171ea3a00704eed/posts/"
              :on-error="uploadFail"
              :show-file-list="false"
              :on-success="handleAvatarSuccesslicense"
              accept="image/jpeg,image/jpg,image/png,image/svg"
              :before-upload="beforeUpload"
            >
              <img
                v-if="registerForm.photoAddress"
                :src="registerForm.photoAddress"
                class="avatar"
              />
              <i v-else class="el-icon-plus avatar-uploader-icon"></i>
            </el-upload>
          </el-form-item>
          <el-row>
            <el-col :span="12">
              <el-form-item>
                <el-button class="button-confirm" type="primary" @click="handelregister()"
                  >確認画面へ</el-button
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
    let checkUserMail = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("メールアドレスを入力してください。"));
      } else {
        let reg = /^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
        if (!reg.test(value)) {
          callback(new Error("メールアドレスが間違っています。正しく入力してください。"));
        } else {
          callback();
        }
      }
    };
    let checkPassword = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("パスワードを入力してください。"));
      } else {
        let reg = /^.{8,16}$/;
        if (!reg.test(value)) {
          callback(new Error("８～１６文字の英数字・記号を半角で入力してください"));
        } else {
          let reg = /^(?=.*[a-zA-Z])(?=.*[0-9]).*$/;
          if (!reg.test(value)) {
            callback(new Error("英字と数字をそれぞれ１文字以上使用してください"));
          } else {
            let reg = /^[a-zA-Z0-9#$&+-=.:?@/_^`|()]{8,16}$/;
            if (!reg.test(value)) {
              callback(
                new Error("記号は # $ & + - = . : ? @ / _ ^ ` | ( )だけが使用できます")
              );
            } else {
              callback();
            }
            callback();
          }
          callback();
        }
      }
    };
    let checkRepassword = (rule, value, callback) => {
      if (value === this.registerForm.pwd) {
        callback();
      } else {
        callback(new Error("パスワードと確認パスワードが異なる"));
      }
    };
    let checkTel = (rule, value, callback) => {
      let reg = /^[0-9]{6,13}$/;
      if (!reg.test(value)) {
        callback(new Error("電話番号は６～１３半角数字で入力してください。"));
      }
      callback();
    };
    return {
      registerForm: {
        userCd: "",
        pwd: "",
        repwd: "",
        companyId: "",
        authority: "",
        firstNameKana: "",
        firstName: "",
        lastNameKana: "",
        lastName: "",
        sex: "0",
        countryZip: "81",
        userTel: "",
        userMail: "",
        photoAddress: "",
        userStatus: "",
      },
      countryZipTip: "81日本",
      telCode: [
        {
          value: "81",
          label: "81(日本)",
        },
        {
          value: "86",
          label: "86(中国)",
        },
      ],
      value: "81",
      rules: {
        userMail: [
          { required: true, message: "メールを入力してください。" },
          { validator: checkUserMail, trigger: "blur" },
        ],
        pwd: [
          { required: true, message: "パスワードを入力してください。" },
          { validator: checkPassword, trigger: "blur" },
        ],
        repwd: [
          { required: true, message: "パスワードを再入力してください。" },
          { validator: checkRepassword, trigger: "blur" },
        ],
        firstName: [{ required: true, message: "姓を入力してください。" }],
        firstNameKana: [{ required: true, message: "姓(カナ)を入力してください。" }],
        lastName: [{ required: true, message: "名を入力してください。" }],
        lastNameKana: [{ required: true, message: "名（カナ）を入力してください。" }],
        countryZip: [{ required: true, message: "電話番号国番号を入力してください。" }],
        userTel: [
          { required: true, message: "電話番号を入力してください。" },
          { validator: checkTel, trigger: "blur" },
        ],
        photoAddress: [{ required: true, message: "写真をアップロードしてください。" }],
        sex: [{ required: true, message: "性別を選択してください。" }],
      },
    };
  },

  methods: {
    remberTel(event) {
      this.registerForm.countryZip = event.target.value;
    },
    uploadFail() {
      this.$message.error("アップロード失敗");
    },
    handleAvatarSuccesslicense(res, file) {
      this.$message.success("アップロード成功");
      this.registerForm.photoAddress = URL.createObjectURL(file.raw);
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
    handelregister() {
      // console.log(3);
      // this.$refs.registerForm.validate((valid) => {
      // console.log(1);
      // console.log(valid);
      // if (valid) {
      // console.log(2);
      this.loading = true;
      this.$store
        .dispatch("auserConf", this.registerForm)
        .then((response) => {
          this.loading = false;
          let code = response.data.code;
          if (code == 200) {
            this.$router.push({
              path: "/a0002Commit",
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
      //   } else {
      //     // eslint-disable-next-line no-console
      //     this.$message.error("各項目を正しく入力してください。");
      //     return false;
      //   }
      // });
    },
    routerBack() {
      this.$router.back(-1);
    },
    toHomepage() {
      this.$router.push({ path: "/home" });
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
.formcontent-popup {
  background-color: #ffffff;
  width: 900px;
  height: 120px;
  margin-top: 10px;
  padding-top: 20px;
  font-size: 14px;

  .el-select {
    .el-input {
      input {
        height: 40px;
        width: 120px;
        margin: auto;
      }
    }
  }

  #searBox {
    .el-input {
      input {
        height: 40px;
        width: 570px;
        margin: auto;
      }
    }
  }
}
.formcontent {
  .el-input {
    input {
      height: 40px;
      // width: 491px;
      margin: auto;
      border: 0;
      border-bottom: 1px solid #e0e0e084;
      font-size: 14px;
    }
  }
}
.formcontent-popup-content {
  background-color: #ffffff;
  width: 900px;
  height: 440px;
  margin-top: 20px;
  padding-top: 10px;
  font-size: 12px;
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
}
.cash {
  position: fixed;
  width: 100%;
}
.bg_img {
  width: 100%;
  height: 120%;
  background: -webkit-linear-gradient(top, #000099, #0076d1);
  background-size: 100% 100%;
}
.register-form-layout {
  position: relative;
  left: 0;
  right: 0;
  width: 910px;
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
  right: 30px;
  top: 44px;
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
.button-position {
  position: absolute;
  left: 500px;
  top: 0px;
  border: 0px;
}
.button-position2 {
  position: absolute;
  left: 500px;
  top: 0px;
  border: 0px;
}

.button-position3 {
  background: url("~@/assets/b_ok.png") center center no-repeat;
  position: absolute;
  left: 500px;
  width: 32px;
  height: 35px;
  top: 0px;
  border: 0px;
}
.button-position4 {
  position: absolute;
  left: 225px;
  top: 0px;
  border: 0px;
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
  margin-left: 180px;
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
.button-back-pop {
  width: 89px;
  height: 40.4px;
  border-color: #909399;
  background: #909399;
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
  width: 398px;
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
::v-deep div > .el-form-item__label {
  font-size: 16px;
  color: #014099;
  font-style: normal;
  font-weight: bold;
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
.postal1 {
  width: 65px;
  text-align: center;
}
.postal2 {
  width: 65px;
  text-align: center;
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
.inputwidth {
  width: 491px;
}
.loginLogo {
  position: relative;
  width: 400px;
  height: 80px;
}

.loginImgLogo {
  background-size: cover;
  position: absolute;
  margin-left: 15%;
  cursor: pointer;
}
</style>
