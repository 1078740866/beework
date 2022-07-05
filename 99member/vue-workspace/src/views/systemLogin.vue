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
          <div class="logo"></div>
          <div class="kaisya_login">会社ログイン</div>
          <div class="input_login">
            <el-form-item prop="userMail">
              <el-input maxlength="50" class="tet" size="medium" v-model="loginForm.userMail" placeholder="メールアドレス"
                        autocomplete="off">
                <i style="font-size: 36px;color:#ffffff; margin: 20% auto;" slot="prefix" class="el-icon-user"></i>
              </el-input>
            </el-form-item>
            <el-form-item prop="password">
              <el-input maxlength="16" tyle="height:10px" type="password" v-model="loginForm.password"
                        placeholder="パスワード">
                <i style="font-size: 36px;color:#ffffff; margin: 20% auto;" slot="prefix" class="el-icon-lock"></i>
              </el-input>
            </el-form-item>
            <div style="margin-left:75px;margin-top:0px">
              <el-col :span="12">
                <el-checkbox style="margin-left:5px;" v-model="checked"><p style="font-size:14px;color:#ffffff">記憶する</p>
                </el-checkbox>
              </el-col>
              <el-col style="margin-left:-40px;" :span="12" @click.native.prevent="toRegister">
               <p style="font-size:14px;color:#ffffff;cursor:pointer;">パスワードを忘れた方
                </p>
              </el-col>
            </div>
            <el-form-item style="margin-top:80px;">
              <el-button class='loginButton' type="primary"
                        @click.native.prevent="handleLogin"><span>ログイン</span>
              </el-button>
            </el-form-item>
            <el-form-item>
              <div style="width: 80px;height:50px;border:0;font-size: 18px;color:#ffffff;margin-left: 160px;;cursor:pointer;"
                  @click="toRegister">新規登録</div>
            </el-form-item>
          
          </div>
        </div>
      </div>
    </el-form>
  </div>
</template>

<script>
export default {
  name: "login",
  data() {
    let checkuserMail = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('メールアドレスを入力して下さい。'));
      } else {
        let reg = /^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
        if (!reg.test(value)) {
          callback(new Error('メールアドレスは不具合形式が入力されました。'));
        } else {
          callback()
        }
      }
    }
    let checkPassword = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('パスワードを入力して下さい。'))
      } else {
        let reg = /^.{8,16}$/;
        if (!reg.test(value)) {
          callback(new Error('８～１６文字の英数字・記号を半角で入力してください'));
        } else {
          let reg = /^(?=.*[a-zA-Z])(?=.*[0-9]).*$/;
          if (!reg.test(value)) {
            callback(new Error('英字と数字をそれぞれ１文字以上使用してください'));
          } else {
            let reg = /^[a-zA-Z0-9#$&+-=.:?@/_^`|()]{8,16}$/;
            if (!reg.test(value)) {
              callback(new Error('記号は # $ & + - = . : ? @ / _ ^ ` | ( )だけが使用できます'));
            } else {
              callback()
            }
            callback()
          }
          callback()
        }
      }
    }
    return {
      loading: false,
      loginForm: {
        userMail: "",
        password: ""
      },
      checked: false,
      rules: {
        userMail: [{validator: checkuserMail, trigger: 'blur'}],
        password: [{validator: checkPassword, trigger: 'blur'}]
      }
    }
  },
  mounted() {
      this.getCookie();
    },
  methods: {
    showPwd() {
      if (this.pwdType === "password") {
        this.pwdType = "";
      } else {
        this.pwdType = "password";
      }
    },
    handleLogin() {
      const self = this;
      //判断复选框是否被勾选 勾选则调用配置cookie方法
      if (self.checked == true) {
        console.log("checked == true");
        //传入账号名，密码，和保存天数3个参数
        self.setCookie(self.loginForm.userMail, self.loginForm.password, 7);
      } else {
        console.log("クリアCookie");
        //清空Cookie
        self.clearCookie();
      }
      this.$refs.loginForm.validate(valid => {
        if (valid) {
          this.loading = true;
          this.$store
              .dispatch("Login", this.loginForm)
              .then(response => {
                this.loading = false;
                let code = response.data.code;
                 console.log(code);
                if (code == 200) {
                  this.$router.push({
                    path: "/success",
                    query: {data: response.data.data}
                  });
                } else if (code == 404) {
                  this.$message.error(response.data.message);
                } else {
                  this.$router.push({
                    path: "/error",
                    query: {message: response.data.message}
                  });
                }
              })
              .catch(() => {
                this.loading = false;
              });
        } else {
          // eslint-disable-next-line no-console
          this.$message.error('ユーザー又はパスワードを入力してください。');
          return false;
        }
      });
    },
    //设置cookie
    setCookie(c_name, c_pwd, exdays) {
      let exdate = new Date(); //获取时间
      exdate.setTime(exdate.getTime() + 24 * 60 * 60 * 1000 * exdays); //保存的天数
      //字符串拼接cookie
      window.document.cookie = "userName" + "=" + c_name + ";path=/;expires=" + exdate.toGMTString();
      window.document.cookie = "userPwd" + "=" + c_pwd + ";path=/;expires=" + exdate.toGMTString();
    },
    //读取cookie
    getCookie: function () {
      if (document.cookie.length > 0) {
        var arr = document.cookie.split('; '); //这里显示的格式需要切割一下自己可输出看下
        for (var i = 0; i < arr.length; i++) {
          var arr2 = arr[i].split('='); //再次切割
          //判断查找相对应的值
          if (arr2[0] == 'userName') {
            this.loginForm.userMail = arr2[1]; //保存到保存数据的地方
          } else if (arr2[0] == 'userPwd') {
            this.loginForm.password = arr2[1];
          }
        }
      }
    },
    //清除cookie
    clearCookie: function () {
      this.setCookie("", "", -1); //修改2值都为空，天数为负1天就好了
    },
    toRegister() {
      this.$router.push({
        path: "/register"
      });
    }
  }
};
</script>

<style lang="scss" scoped>
$default_blue_1: #014099;
$default_blue_2: #33ccff;
$default_blue_3: #33a1ff;
.cash{
  position:fixed;
  width:100%;
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

.logo {
  position: relative;
  width: 400px;
  height: 80px;
  background: url('~@/assets/b_home_logo2.png') center center no-repeat;
  background-size: auto auto;
}

.kaisya_login {
  position: relative;
  right: 0;
  left: 35%;
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
  width: 395px;
}

.centerLogin{
  position: relative;
  left: 35%;
  top: 10%;
  width: 400px;
}

.loginButton { 
				display: inline-block; 
				border-radius: 4px; 
				background-color: #f4511e; 
				border: none; color: #FFFFFF; 
				text-align: center; 
				font-size: 28px; 
				padding: 20px; 
				width: 395px; 
        height:60px;
				transition: all 0.5s; 
				cursor: pointer; 
				margin: 5px; 
				vertical-align:middle;
}

.loginButton span { 
  cursor: pointer; 
  display: inline-block; 
  position: relative; 
  transition: 0.5s;
}

.loginButton span:after { 
  content: '»'; 
  position: absolute; 
  opacity: 0; top: 0; 
  right: -20px; 
  transition: 0.5s;
  font-size:30px;
}

.loginButton:hover span { 
  padding-right: 25px;
}

.loginButton:hover span:after { 
  opacity: 1; 
  right: 0;
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
  height: 50px;
  border: 0;
  border-bottom: 1px solid #e0e0e084;
  padding-left: 45px;
  font-size: 14px;
  color:#ffffff;
  background:transparent;
  ::-webkit-input-placeholder{
          color: #CCCCCC;
        }
}

::v-deep div > .el-button--primary {
  background-image: linear-gradient(to right, #33a1ff, #33c1ff);
  border-color: $default_blue_2;
}

::v-deep div > .el-button:hover {
  background-image: linear-gradient(to right, #33a1ff, #33c1ff);
  border-color: $default_blue_2;
}

::v-deep div > .el-checkbox > .el-checkbox__input > .el-checkbox__inner {
  width: 20px;
  height: 20px;
}

::v-deep div > .el-checkbox > .el-checkbox__input > .el-checkbox__inner:hover {
  border-color: $default_blue_3;
}

::v-deep div > .el-checkbox > .is-checked > .el-checkbox__inner {
  background: $default_blue_3;
  border-color: $default_blue_3;
}

::v-deep div > .el-checkbox > .el-checkbox__input > .el-checkbox__inner::after {
  height: 13px;
  left: 8px;
  width: 4px;
}
</style>