<template>
  <div class="login-container">
    <el-form
      :rules="rules"
      autocomplete="on"
      :model="loginForm"
      ref="loginForm"
      label-position="left"
      class="login-form-layout"
    >
      <div class="login-container2">
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
        <div class="centerLogin">
          <div class="loginLogo" @click="toHomepage">
            <el-image
              :src="require('@/assets/b_home_logo2.png')"
              class="loginImgLogo"
            />
          </div>
          <div class="kaisya_login">パスワード再設定</div>
          <div class="input_login">
            <el-steps :active="active" finish-status="success" align-center>
              <el-step title="メール検証"></el-step>
              <el-step title="新パスワード設定"></el-step>
              <el-step title="完成"></el-step>
            </el-steps>
              <div v-if="active === 0" align="center">
                <el-form-item prop="userMail">
                  <el-input
                    maxlength="50"
                    class="tet"
                    size="medium"
                    v-model="loginForm.userMail"
                    placeholder="メールアドレス"
                    autocomplete="off"
                  >
                    <i
                      style="font-size: 36px;color:#ffffff; margin: 20% auto;"
                      slot="prefix"
                      class="el-icon-user-solid"
                    ></i>
                  </el-input>
                </el-form-item>
                <el-form-item prop="mailCode">
                  <el-input
                    maxlength="4"
                    type="code"
                    v-model="loginForm.mailCode"
                    placeholder="確認コード"
                  >
                    <i
                      style="font-size: 36px;color:#ffffff; margin: 20% auto;"
                      slot="prefix"
                      class="el-icon-lock"
                    ></i>
                    <el-button v-if="show" style="padding-right:18px" slot="suffix" type="primary" @click="dialogVisibleOpen">メールを送る</el-button>
                    <el-button v-if="!show" style="padding-right:18px" slot="suffix" type="primary">{{ times }}s</el-button>
                  </el-input>
                </el-form-item>
                <el-button style="margin-top: 12px;" @click="nextTwo">次へ</el-button>
                <el-button style="margin-top: 12px;" @click="toLogin">取り消し</el-button>
              </div>
              <div v-if="active === 1" align="center">
                <el-form-item prop="passwordNew">
                  <el-input
                    maxlength="16"
                    type="passwordNew"
                    v-model="loginForm.passwordNew"
                    placeholder="新パスワード"
                    show-password
                  >
                    <i
                      style="font-size: 36px;color:#ffffff; margin: 20% auto;"
                      slot="prefix"
                      class="el-icon-lock"
                    ></i>
                  </el-input>
                </el-form-item>
                <el-form-item prop="passwordC">
                  <el-input
                    maxlength="16"
                    type="passwordC"
                    v-model="loginForm.passwordC"
                    placeholder="新パスワード確認"
                    show-password
                  >
                    <i
                      style="font-size: 36px;color:#ffffff; margin: 20% auto;"
                      slot="prefix"
                      class="el-icon-lock"
                    ></i>
                  </el-input>
                </el-form-item>
                <el-button style="margin-top: 12px;" @click="nextThree">次へ</el-button>
                <el-button style="margin-top: 12px;" @click="toLogin">取り消し</el-button>
              </div>
              <div v-if="active === 2" align="center">
                <el-button style="margin-top: 12px;" @click="toLogin">確定</el-button>
              </div>
          </div>
        </div>
      </div>
      <el-dialog
          title="識別コード入力"
          :visible.sync="dialogVisible"
          width="30%">
              <el-form-item prop="code">
                  <el-input
                    maxlength="8"
                    style="height:10px;"
                    type="code"
                    v-model="loginForm.code"
                    placeholder="識別コード"
                    class="rt-input"
                  >
                    <i
                      style="font-size: 36px;color:#000000; margin: 20% auto;"
                      slot="prefix"
                      class="el-icon-lock"
                    ></i>
                  </el-input>
                </el-form-item>
                <el-form-item style="width: 100%" class="login_remember">
                  <!--验证码-->
                  <el-tooltip effect="light" content="写真をクリック、リフレッシュ" placement="bottom">
                    <el-image :src="kaptcha" @click="refreshCode" alt="load fail" >
                      <div slot="placeholder" class="image-slot">
                          <i class="el-icon-loading"></i>
                      </div>
                    </el-image>
                  </el-tooltip>
                </el-form-item>
          <el-button @click="dialogVisible = false">キャンセル</el-button>
          <el-button type="primary" @click="verifyCode">確定</el-button>
      </el-dialog>
    </el-form>
  </div>
</template>

<script>
import { mapMutations } from "vuex";
import baseUrl from "@/api/baseUrl";
export default {
  name: "login",
  data() {
    let checkuserMail = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("メールアドレスは必須入力項目です。"));
      } else {
        let reg = /^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
        if (!reg.test(value)) {
          callback(new Error("メールアドレスは正しく入力してください。"));
        } else {
          callback();
        }
      }
    };
    let checkPassword = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("パスワードは必須入力項目です。"));
      } else {
        let reg = /^.{8,16}$/;
        if (!reg.test(value)) {
          callback(new Error("パスワードは正しく入力してください。"));
        } else {
          let reg = /^(?=.*[a-zA-Z])(?=.*[0-9]).*$/;
          if (!reg.test(value)) {
            callback(new Error("パスワードは正しく入力してください。"));
          } else {
            let reg = /^[a-zA-Z0-9#$&+-=.:?@/_^`|()]{8,16}$/;
            if (!reg.test(value)) {
              callback(new Error("パスワードは正しく入力してください。"));
            } else {
              callback();
            }
            callback();
          }
          callback();
        }
      }
    };
    let checkPasswordC = (rule, value, callback) => {
      if (this.loginForm.passwordNew != this.loginForm.passwordC) {
        callback();
      } else {
        callback(new Error("パスワードと確認パスワードが異なる"));
      }
    };
    return {
      // タイトル名
      titleName: "パスワード再設定",
      loading: false,
      loginForm: {
        userMail: "",
        passwordNew: "",
        code: "",
        mailCode: "",
        passwordC:"",
      },
      checked: false,
      rules: {
        userMail: [
          { required: true, message: "メールを入力してください。" },
          { validator: checkuserMail, trigger: "blur" },
        ],
        passwordNew: [
          { required: true, message: "パスワードを入力してください。" },
          { validator: checkPassword, trigger: "blur" },
        ],
        passwordC: [
          { required: true, message: "パスワードを再入力してください。" },
          { validator: checkPasswordC, trigger: "blur" },
        ],
      },
      // rules: {
      //   userMail: [{ validator: checkuserMail, trigger: "blur" }],
      //   passwordNew: [{ validator: checkPassword, trigger: "blur" }],
      //   passwordC: [{ validator: checkPasswordC, trigger: "blur" }],
      // },
      active: 0,
      kaptcha: baseUrl+"defaultKaptcha?t=" + new Date().getTime(),
      times: "60", //60秒倒计时,
      show:true,
      dialogVisible: false
    };
  },

  mounted() {
    // this.getCookie();
    document.title = this.titleName;
  },
  methods: {
    ...mapMutations(["changeLogin"]),
    toLogin() {
      this.active = 0;
      this.$router.push({ path: '/Login' })
    },
    verifyCode() {
      this.$store
            .dispatch("verifyCode", this.loginForm.code)
            .then((response) => {
              this.loading = false;
              let code = response.data.code;
              // console.log(code);
              if (code == 200) {
                if (response.data.data == "入力成功") {
                  this.dialogVisible=false;
                  this.$message("メール発信中");
                  this.sendMail();
                }else if(response.data.data == "入力エラー") {
                  this.$message.error("コード不正");
                }
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
    nextTwo() {
      this.$store
        .dispatch("checkMailCode", this.loginForm)
        .then((response) => {
          this.loading = false;
          let code = response.data.code;
          if (code == 200) {
            if (response.data.data == "输入正确") {
                  //this.$store.dispatch("checkmail", this.loginForm.userMail)                  
                  if (this.active++ > 2) this.active = 0;
                }else if(response.data.data == "输入错误") {
                  this.$message.error("コード不正");
                }
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
    nextThree() {
      if (this.loginForm.passwordNew != this.loginForm.passwordC) {
        this.$message.error("二回入力したパスワードは不一致です");
      }else{
        this.$store
        .dispatch("changePassword", this.loginForm)
        .then((response) => {
          this.loading = false;
          let code = response.data.code;
          if (code == 200) {              
            if (this.active++ > 2) this.active = 0;
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
      }
    },
    sendMail() {
      this.$store
        .dispatch("sendPwMail", this.loginForm)
        .then((response) => {
          this.loading = false;
          let code = response.data.code;
          if (code == 200) {
            this.dialogVisible=false;
            this.$message("送信成功");
            this.show = false;
            this.times=60;
            this.timer = setInterval(()=>{
            this.times--
              if(this.times===0){
                this.show = true
                clearInterval(this.timer)
              }
            },1000)
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
    refreshCode() {
      this.kaptcha = baseUrl+"defaultKaptcha?t=" + new Date().getTime();
    }, 
    dialogVisibleOpen() {
      this.dialogVisible=true;
      this.kaptcha = baseUrl+"defaultKaptcha?t=" + new Date().getTime();
      this.loginForm.code="";
    }, 
    //TITLE会社LOGOクリック
    toHomepage() {
      this.$router.push({ path: "/home" });
    },
  },
};
</script>

<style lang="scss" scoped>
$default_blue_1: #014099;
$default_blue_2: #33ccff;
$default_blue_3: #33a1ff;
.cash {
  position: fixed;
  width: 100%;
}
.login-container {
  width: 100%;
  height: calc(97vh);
  //background: -webkit-linear-gradient(top, #0076d1, #5db8ff);
  background: -webkit-linear-gradient(top, #000099, #0076d1);
  background-size: cover;
  overflow: hidden;
}

.login-container2 {
  position: relative;
  width: 100%;
  height: 100%;
}

.login-form-layout {
  position: relative;
  width: 100%;
  height: 100%;
  //margin: 97px auto 60px auto;
  border-radius: 10px;
  //background: url('~@/assets/b_bg3.jpg') center center no-repeat;
  background-size: 100% 100%;
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
  cursor:pointer
}

.kaisya_login {
  position: relative;
  right: 0;
  left: 30%;
  top: 10px;
  width: 100%;
  height: 35px;
  font-size: 20px;
  color: #ffffff;
}

.input_login {
  position: relative;
  right: 0;
  top: 50px;
  width: 400px;
}

.centerLogin {
  position: relative;
  left: 35%;
  top: 10%;
  width: 400px;
}

.loginButton {
  display: inline-block;
  border-radius: 4px;
  background-color: #f4511e;
  border: none;
  color: #ffffff;
  text-align: center;
  font-size: 28px;
  padding: 20px;
  width: 395px;
  height: 60px;
  transition: all 0.5s;
  cursor: pointer;
  margin: 5px;
  vertical-align: middle;
}

.loginButton span {
  cursor: pointer;
  display: inline-block;
  position: relative;
  transition: 0.5s;
}
.formcontent-popup-content {
  background-color: #ffffff;
  width: 900px;
  height: 440px;
  margin-top: 20px;
  padding-top: 10px;
  font-size: 12px;
}
.loginButton span:after {
  content: "»";
  position: absolute;
  opacity: 0;
  top: 0;
  right: -20px;
  transition: 0.5s;
  font-size: 30px;
}

.loginButton:hover span {
  padding-right: 25px;
}

.loginButton:hover span:after {
  opacity: 1;
  right: 0;
}


/deep/ input::-webkit-input-placeholder {
  color: #ffffff;
}
/deep/ input::-moz-input-placeholder {
  color: #ffffff;
}
/deep/ input::-ms-input-placeholder {
  color: #ffffff;
}
.rt-input /deep/ .el-input__inner {
  color:#000000;
}
/deep/ div > .el-input > input {
  height: 50px;
  border: 0;
  border-bottom: 1px solid #e0e0e084;
  padding-left: 45px;
  font-size: 14px;
  color: #ffffff;
  background: transparent;
  ::-webkit-input-placeholder {
    color: #cccccc;
  }
}

/deep/ div > .el-button--primary {
  background-image: linear-gradient(to right, #33a1ff, #33c1ff);
  border-color: $default_blue_2;
}

/deep/ div > .el-button:hover {
  background-image: linear-gradient(to right, #33a1ff, #33c1ff);
  border-color: $default_blue_2;
}

/deep/ div > .el-checkbox > .el-checkbox__input > .el-checkbox__inner {
  width: 20px;
  height: 20px;
}

/deep/ div > .el-checkbox > .el-checkbox__input > .el-checkbox__inner:hover {
  border-color: $default_blue_3;
}

/deep/ div > .el-checkbox > .is-checked > .el-checkbox__inner {
  background: $default_blue_3;
  border-color: $default_blue_3;
}

/deep/ div > .el-checkbox > .el-checkbox__input > .el-checkbox__inner::after {
  height: 13px;
  left: 8px;
  width: 4px;
}
//步骤条当前步骤的字
/deep/ div > .el-step__title.is-process{
  color: #f4511e;
}
//步骤条当前步骤的圆圈的字
/deep/ div > .el-step__head.is-process{
  color: #f4511e;
  border-color: #f4511e;
}
//步骤条的圆圈
/deep/ div > .el-step__icon{
  width: 40px;
  height: 40px;
}
//步骤条的横线
/deep/ div > .el-step.is-horizontal .el-step__line{
  top: 50%;
}
//步骤条未执行的文字
/deep/ div > .el-step__title.is-wait{
  color: #020202;
}
//步骤条未执行的圆圈
/deep/ div >.el-step__head.is-wait{
  color: #020202;
}
</style>
