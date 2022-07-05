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
          <div class="title-required font-blue-22">会社新規(登録)</div>
          <div class="tips-required font-red-16">※項目は入力必須</div>
        </div>
        <hr style="width: 99%" />
        <div class="formcontent">
          <!-- <el-form-item label="会社Id:" prop="companyId" v-if="false">
            <label>{{ registerForm.companyId }}</label>
          </el-form-item> -->
          <el-form-item label-width="195px" label="会社名:" prop="companyNm">
            <label>{{ registerForm.companyInfo.companyNm }}</label>
          </el-form-item>
          <el-form-item label-width="195px" label="電話番号:" prop="companyTel">
            <label>{{ companyTelInfo }}</label>
          </el-form-item>
          <el-form-item label-width="195px" label="メールアドレス:" prop="companyMail">
            <label>{{ registerForm.companyInfo.companyMail }}</label>
          </el-form-item>
          <el-form-item label-width="195px" label="会社規模:" prop="companyScale">
            <label>{{ registerForm.companyInfo.companyScaleNm }}</label>
          </el-form-item>
          <el-form-item label-width="195px" label="国:" prop="countryNm">
            <label>{{ registerForm.companyInfo.countryNm }}</label>
          </el-form-item>
          <el-form-item label-width="195px" label="郵便番号:" prop="companyPostal">
            <label>{{ registerForm.companyInfo.companyPostal }}</label>
          </el-form-item>
          <el-form-item label-width="195px" label="会社所在地:" prop="address1">
            <label>
              {{ registerForm.companyInfo.address1 }}
              {{ registerForm.companyInfo.address2 }}
            </label>
          </el-form-item>
          <!-- <el-form-item class="input-small-position" prop="address2">
            <label>{{ registerForm.companyInfo.address2 }}</label>
          </el-form-item> -->
          <el-form-item label-width="195px" style="margin-top: -70px" prop="address3">
            <label>{{ registerForm.companyInfo.address3 }}</label>
          </el-form-item>
          <el-form-item label-width="195px" label="業種1:" prop="industryId1Nm">
            <label>{{ registerForm.companyInfo.industryId1Nm }}</label>
          </el-form-item>
          <el-form-item
            label-width="195px"
            label="業種2:"
            v-show="registerForm.companyInfo.industryId2 ? true : false"
          >
            <label>{{ registerForm.companyInfo.industryId2Nm }}</label>
          </el-form-item>
          <el-form-item
            label-width="195px"
            label="業種3:"
            v-show="registerForm.companyInfo.industryId3 ? true : false"
          >
            <label>{{ registerForm.companyInfo.industryId3Nm }}</label>
          </el-form-item>
          <el-form-item label-width="195px" label="資本金:" prop="capital">
            <label>{{ registerForm.companyInfo.capital }}</label>
          </el-form-item>
          <el-form-item label-width="195px" label="事業内容:" prop="businessContent">
            <label>{{ registerForm.companyInfo.businessContent }}</label>
          </el-form-item>
          <el-form-item label-width="195px" label="売上:" prop="sales">
            <label>{{ registerForm.companyInfo.salesAmount }}</label>
          </el-form-item>
          <el-form-item label-width="195px" label="ホームページ:" prop="homepage">
            <label>{{ registerForm.companyInfo.homepage }}</label>
          </el-form-item>
          <el-form-item label-width="195px" label="謄本画像:">
            <img v-if="this.pdfHiddenFlag" class="avatar" :src="this.picurl" />
            <pdf
              v-else
              :src="this.picurl"
              ref="pdf"
              class="avatar"
              :page="1"
              @page-loaded="1"
            >
            </pdf
            ><br />
          </el-form-item>
          <el-form-item label-width="195px" label="会社LOGO:" prop="companyLogo">
            <el-image
              style="width: 178px; height: 178px"
              :src="registerForm.companyInfo.companyLogo"
              :fit="fit"
            >
            </el-image>
          </el-form-item>
          <el-form-item label-width="195px" label="会社画像1:" prop="photoAddress1">
            <el-image
              style="width: 178px; height: 178px"
              :src="registerForm.companyInfo.photoAddress1"
              :fit="fit"
            >
            </el-image>
          </el-form-item>
          <el-form-item
            label-width="195px"
            v-show="registerForm.companyInfo.photoAddress2 ? true : false"
            label="会社画像2:"
          >
            <el-image
              style="width: 178px; height: 178px"
              :src="registerForm.companyInfo.photoAddress2"
              :fit="fit"
            >
            </el-image>
          </el-form-item>
          <el-form-item
            label-width="195px"
            label="会社画像3:"
            v-show="registerForm.companyInfo.photoAddress3 ? true : false"
          >
            <el-image
              style="width: 178px; height: 178px"
              :src="registerForm.companyInfo.photoAddress3"
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
          <el-form-item label-width="203px" label="メールアドレス:" prop="userMail">
            <label>{{ registerForm.companyInfo.userMail }}</label>
          </el-form-item>
          <el-form-item label-width="203px" label="パスワード:" prop="password">
            <label>{{ registerForm.companyInfo.password }}</label>
          </el-form-item>
          <el-form-item label-width="203px" label="パスワード確認:" prop="repassword">
            <label>{{ registerForm.companyInfo.repassword }}</label>
          </el-form-item>
          <el-form-item label-width="203px" label="姓:" prop="firstName">
            <label>{{ registerForm.companyInfo.firstName }}</label>
          </el-form-item>
          <el-form-item label-width="203px" label="姓（カナ）:" prop="firstNameKana">
            <label>{{ registerForm.companyInfo.firstNameKana }}</label>
          </el-form-item>
          <el-form-item label-width="203px" label="名:" prop="lastName">
            <label>{{ registerForm.companyInfo.lastName }}</label>
          </el-form-item>
          <el-form-item label-width="203px" label="名（カナ）:" prop="lastNameKana">
            <label>{{ registerForm.companyInfo.lastNameKana }}</label>
          </el-form-item>
          <el-form-item label-width="203px" label="性別:">
            <el-radio
              v-model="registerForm.companyInfo.sex"
              label="0"
              v-show="registerForm.companyInfo.sex == '0'"
              >男性</el-radio
            >
            <el-radio
              v-model="registerForm.companyInfo.sex"
              label="1"
              v-show="registerForm.companyInfo.sex == '1'"
              >女性</el-radio
            >
          </el-form-item>
          <el-form-item label-width="195px" label="電話番号:" prop="countryZip">
            <label>{{ registerForm.companyInfo.countryZip }}</label>
          </el-form-item>
          <el-form-item class="input-small-position2" prop="userTel">
            <label>{{ userTelInfo }}</label>
          </el-form-item>
          <el-form-item
            label-width="203px"
            style="margin-top: -65px"
            label="写真:"
            prop="photoAddress"
          >
            <el-image
              style="width: 178px; height: 178px"
              :src="registerForm.companyInfo.photoAddress"
              :fit="fit"
            >
            </el-image>
          </el-form-item>
          <el-row>
            <el-col :span="12">
              <el-form-item>
                <el-button class="button-confirm" type="primary" @click="insertCompany()"
                  >確認</el-button
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
import pdf from "vue-pdf";
export default {
  name: "register",
  data() {
    return {
      picurl: "",
      pdfHiddenFlag: null,
      title: "弹窗标题",
      show: false,
      zip: null,
      fit: "fit",
      pref_id: null,
      locality: null,
      street: null,
      loading: false,
      companyTelInfo: "",
      userTelInfo: "",
      registerForm: {
        userMail: "",
        password: "",
        repassword: "",
        companyId: "",
        companyNm: "",
        companyTel: "",
        companyMail: "",
        companyScale: "",
        companyScaleNm: "",
        countryId: "",
        countryNm: "",
        companyPostal3keta: "",
        companyPostal4keta: "",
        companyPostal: "",
        address1: "",
        address2: "",
        industryId1: "",
        industryId2: "",
        industryId3: "",
        industryId1Nm: "",
        industryId2Nm: "",
        industryId3Nm: "",
        capital: "",
        businessContent: "",
        salesAmount: "",
        homepage: "",
        licenseAddress: "",
        companyLogo: "",
        photoAddress1: "",
        photoAddress2: "",
        photoAddress3: "",
        videoAddressList: "",
        firstName: "",
        firstNameKana: "",
        lastName: "",
        lastNameKana: "",
        sex: "0",
        countryZip: "81",
        userTel: "",
        photoAddress: "",
        popFlg: "",
      },
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
    this.registerForm = JSON.parse(this.$route.query.flight);
    let filename = this.registerForm.companyInfo.licenseAddress;
    let extension = filename.split(".").pop();
    if (extension == "pdf") {
      this.pdfHiddenFlag = false;
      this.picurl =
        "data:application/pdf;base64," + this.registerForm.companyInfo.licenseAddressPic;
    } else {
      this.pdfHiddenFlag = true;
      this.picurl =
        "data:image/jpeg;base64," + this.registerForm.companyInfo.licenseAddressPic;
    }
    this.companyTelInfo = this.telChange(this.registerForm.companyInfo.companyTel);
    this.userTelInfo = this.telChange(this.registerForm.companyInfo.userTel);
  },
  components: {
    pdf,
  },
  methods: {
    //TITLE会社LOGOクリック
    toHomepage() {
      this.$router.push({ path: "/home" });
    },
    telChange(Num) {
      var val = Num;
      var int = val.split("").reverse().join("");
      var temp = "";
      for (var i = 0; i < int.length; i++) {
        temp += int[i];
        if ((i + 1) % 4 == 0 && i != int.length - 1) {
          temp += "-";
        }
      }
      temp = temp.split("").reverse().join("");
      return temp;
    },
    insertCompany() {
      this.loading = true;
      if (
        this.registerForm.companyInfo.salesAmount != "" &&
        this.registerForm.companyInfo.salesAmount != null
      ) {
        var val = this.registerForm.companyInfo.salesAmount;
        val = val.replace(/,/g, "");
        var temp = val.substr(0, val.length - 1);
        this.registerForm.companyInfo.salesAmount = temp; // 返回
      }
      this.$store
        .dispatch("insertCompany", this.registerForm.companyInfo)
        .then((response) => {
          this.loading = false;
          let code = response.data.code;
          if (code == 200) {
            this.$router.push({
              // path: "/success",
              path: "/login",
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
      this.$router.back();
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
.avatar {
  width: 178px;
  height: 178px;
  display: block;
}
</style>
