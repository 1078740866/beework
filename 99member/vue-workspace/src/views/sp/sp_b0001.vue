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
        <div class="centerLogin">
          <div class="logoSp"></div>
          <div class="logo"></div>
          <div class="kaisya_login">会社ログイン</div>
          <div class="input_login">
            <el-form-item prop="userMail">
              <el-input maxlength="50" class="tet" size="medium" v-model="loginForm.userMail" placeholder="メールアドレス" autocomplete="off">
                <em style="font-size: 24px; color: #ffffff; margin: 20% auto" slot="prefix" class="el-icon-user-solid"></em>
              </el-input>
            </el-form-item>
            <el-form-item prop="password">
              <el-input maxlength="16" tyle="height:10px" type="password" v-model="loginForm.password" placeholder="パスワード" show-password>
                <em style="font-size: 24px; color: #ffffff; margin: 20% auto" slot="prefix" class="el-icon-lock"></em>
              </el-input>
            </el-form-item>
            <div class="divBottom">
              <el-row>
                <el-col :span="12">
                  <el-checkbox v-model="checked">
                    <p class="pStyle1">記憶する</p>
                  </el-checkbox>
              </el-col>
              <el-col
                :span="12"
                @click.native.prevent="toRegister"
              >
                <p class="pStyle2">
                    パスワードを忘れた方
                </p>
              </el-col>
              </el-row>
            </div>
            <el-form-item>
              <el-button
                class="loginButton"
                type="primary"
                round
                @click.native.prevent="handleLogin"
                ><span>
                  ログイン
                  <i class="el-icon-d-arrow-right el-icon--right"></i>
                </span>
              </el-button>
            </el-form-item>
            <el-form-item>
              <div
               class="newLogin"
                @click="toRegister"
              >
                新規登録
              </div>
            </el-form-item>
          </div>
        </div>
      </div>
    </el-form>
  </div>
</template>

<script>
import { mapMutations } from "vuex";
import '@/css/reset.css';
import '@/css/border.css';
//移动端 解决点击按钮闪和active失效的问题
document.body.addEventListener('touchstart' , function(){});
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
    return {
      loading: false,
      loginForm: {
        userMail: "",
        password: "",
      },
      checked: false,
      rules: {
        userMail: [{ validator: checkuserMail, trigger: "blur" }],
        password: [{ validator: checkPassword, trigger: "blur" }],
      },
    };
  },
  mounted() {
    this.getCookie();
    document.title="会社ログイン"
  },
  methods: {
    ...mapMutations(["changeLogin"]),
    showPwd() {
      if (this.pwdType === "password") {
        this.pwdType = "";
      } else {
        this.pwdType = "password";
      }
    },
    handleLogin() {
      let _this = this;
      const self = this;
      //判断复选框是否被勾选 勾选则调用配置cookie方法
      if (self.checked == true) {
        // console.log("checked == true");
        //传入账号名，密码，和保存天数3个参数
        self.setCookie(self.loginForm.userMail, self.loginForm.password, self.checked, 7);
      } else {
        console.log("クリアCookie");
        //清空Cookie
        self.clearCookie();
      }
      this.$refs.loginForm.validate((valid) => {
        if (valid) {
          this.loading = true;
          this.$store
            .dispatch("Login", this.loginForm)
            .then((response) => {
              this.loading = false;
              let code = response.data.code;
              // console.log(code);
              if (code == 200) {
                // console.log("response", response);
                _this.userToken = response.data.data.token.token;
                this.$store.dispatch("changeLogin", _this.userToken);
                this.$router.push({
                  path: "/sp/sp_b0003",
                  query: { data: response.data },
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
          // 会社管理画面の初期表示データを取得
          this.loading = true;
          this.$store
            .dispatch("b0003Search")
            .then((response) => {
              this.loading = false;
              let code = response.data.code;
              if (code == 200) {
                this.$router.push({
                  path: "/sp/sp_b0003",
                  query: { datab0003: response.data.data },
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
        } else {
          // eslint-disable-next-line no-console
          this.$message.error("ユーザーまたはパスワードは間違っています。正しく入力してください。");
          return false;
        }
      });
    },
    //设置cookie
    setCookie(c_name, c_pwd, check, exdays) {
      let exdate = new Date(); //获取时间
      exdate.setTime(exdate.getTime() + 24 * 60 * 60 * 1000 * exdays); //保存的天数
      //字符串拼接cookie
      window.document.cookie =
        "userName" + "=" + c_name + ";path=/;expires=" + exdate.toGMTString();
      window.document.cookie =
        "userPwd" + "=" + c_pwd + ";path=/;expires=" + exdate.toGMTString();
      window.document.cookie =
        "check" + "=" + check + ";path=/;expires=" + exdate.toGMTString();
    },
    //读取cookie
    getCookie: function() {
      if (document.cookie.length > 0) {
        var arr = document.cookie.split("; "); //这里显示的格式需要切割一下自己可输出看下
        for (var i = 0; i < arr.length; i++) {
          var arr2 = arr[i].split("="); //再次切割
          //判断查找相对应的值
          if (arr2[0] == "userName") {
            this.loginForm.userMail = arr2[1]; //保存到保存数据的地方
          } else if (arr2[0] == "userPwd") {
            this.loginForm.password = arr2[1];
          } else if (arr2[0] == "check") {
            if (arr2[1] == "true") {
              this.checked = true;
            }
          }
        }
      }
    },
    //清除cookie
    clearCookie: function() {
      this.setCookie("", "", "", -1); //修改2值都为空，天数为负1天就好了
    },
   toRegister() {
      // this.$router.push({
      //   path: "/register"
      // });
      this.loading = true;
      this.$store
        .dispatch("registerInit")
        .then((response) => {
          this.loading = false;
          let code = response.data.code;
          if (code == 200) {
            this.$router.push({
              path: "/sp/sp_b0002",
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
  background: #013f99;
  background-size: cover;
  overflow: hidden;
}

.logo {
  margin-top: 10px;
  position: relative;
  height: 50px;
  width: 60%;
  margin-left: 20%;
  background: url("~@/spAssets/logo-big.png") center center no-repeat;
  background-size: contain;
  text-align: center;
}

.logoSp {
  margin-top: 10%;
  position: relative;
  height: 350px;
  background: url("~@/spAssets/pic1.png") center center no-repeat;
  background-size: contain;
  text-align: center;
}
.kaisya_login {
  margin-top: 20px;
  position: relative;
  margin-bottom: 40px;
  width: 100%; 
  height: 30px;
  font-size: 28px;
  color: #33abff;
  text-align: center;
}
.input_login {
  position: relative;
  width: 80%;
  margin-left: 10%;
}
.loginButton {
  display: inline-block;
  background-image: linear-gradient(to right, #33a1ff, #33c1ff);
  border: none;
  color: #ffffff;
  text-align: center;
  font-size: 32px;
  height: 60px;
  cursor: pointer;
  vertical-align: middle;
  width: 80%;
  margin-top: 5%;
  margin-left: 10%;
  -webkit-tap-highlight-color:transparent;
}

.loginButton span {
  cursor: pointer;
  display: inline-block;
  position: relative;
  transition: 0.5s;
}
.loginButton:active {
  box-shadow: -6px 6px rgb(129, 129, 129);
  transform: translateY(4px);
}
.divBottom{
  height: 50px;
  margin-top:60px;
  font-size: 20px;
  color: #FFFFFF;
  margin-left: 10%;
}
.newLogin{
  width: 40%;
  height:80px;
  border:0;
  font-size: 24px;
  color:#ffffff;
  margin-left: 30%;
  margin-top: 15px;
  margin-bottom: 30px;
  cursor:pointer;
  text-align: center;
  text-decoration: underline;
  -webkit-tap-highlight-color:transparent;
}
// P标签
.pStyle1{
  font-size: 20px;
  color:#ffffff;
}
.pStyle2{
  font-size: 20px;
  color:#ffffff;
  text-decoration: underline;
}
.lab1{
    height: 100%;
}
.el-checkbox:last-of-type{
  -webkit-tap-highlight-color:transparent;
}
::v-deep  div > .el-input__suffix{
  right:24px;
  -webkit-tap-highlight-color:transparent;
}
::v-deep  div > .el-input .el-input__clear{
  font-size: 24px;
}
::v-deep  div > .el-form-item__error{
 font-size: 20px;
}
::v-deep input::-webkit-input-placeholder {
  color: #ffffff;
}
::v-deep input::-moz-input-placeholder {
  color: #ffffff;
}
::v-deep input::-ms-input-placeholder {
  color: #ffffff;
}

::v-deep div > .el-input > input {
  height: 60px;
  border-top:0px solid #e0e0e0;
  border-left:0px solid #e0e0e0;
  border-right:0px solid #e0e0e0;
  border-bottom:2px solid #e0e0e0;
  padding-left: 60px;
  font-size: 28px;
  color: #ffffff;
  background: transparent;
  outline: none;
  -webkit-appearance: none; 
  -webkit-tap-highlight-color: rgba(0, 0, 0, 0);
  appearance:button;
  -moz-appearance: button; /* Firefox */
  -webkit-appearance: button; /* Safari 和 Chrome */
}

::v-deep div > .el-button--primary {
  background-image: linear-gradient(to right, #33a1ff, #33c1ff);
  border-color: $default_blue_2;
}

::v-deep div > .el-button:active {
  background-image: linear-gradient(to right, #2778be, #318bda);
  border-color: $default_blue_3;
}


::v-deep div > .el-checkbox > .el-checkbox__input > .el-checkbox__inner {
  width: 24px;
  height: 24px;
}


::v-deep div > .el-checkbox > .el-checkbox__input > .el-checkbox__inner:hover {
  border-color: $default_blue_3;
}

::v-deep div > .el-checkbox > .is-checked > .el-checkbox__inner {
  background: $default_blue_3;
  border-color: $default_blue_3;
}

::v-deep div > .el-checkbox > .el-checkbox__input > .el-checkbox__inner::after {
  height: 15px;
  left: 7px;
  width: 8px;
}
</style>
