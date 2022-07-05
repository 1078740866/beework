<template>
  <div>
    <HomeHeader></HomeHeader>
    <div class="waikuang interview_data">
      <div class="lanse">
        <span style="margin-left: 20px; font-size: 20px">会社情報</span>
        <!-- <span style="margin-left: 700px">レベル情報</span> -->
      </div>
      <div style="height: 100px">
        <el-card
          style="
            margin-left: 20px;
            margin-right: 20px;
            margin-top: 20px;
            margin-bottom: 20px;
          "
          class="lanse huidi"
        >
          <el-row>
            <el-col :span="5" :offset="1">社名：{{ companyInfoBean.companyNm }}</el-col>
            <el-col :span="5">電話番号：{{ companyInfoBean.companyTel }}</el-col>
            <el-col :span="6">メール：{{ companyInfoBean.companyMail }}</el-col>
            <el-col :span="5">会員レベル：{{ companyInfoBean.levelNm }}</el-col>
          </el-row>
          <!-- <span></span>
          <span>電話番号：{{ companyInfoBean.companyTel }}</span>
          <span>メール：{{ companyInfoBean.companyMail }}</span>
          <span>会員レベル：{{ companyInfoBean.levelNm }}</span> -->
        </el-card>
      </div>
    </div>
    <div class="waikuang interview_data">
      <span class="biaoqian lanse">チャージ</span>
      <el-form :model="b0803Form" :rules="rules" ref="b0803Form">
        <div class="lanse juli">
          <span>ハニーコイン残高：{{ companyInfoBean.remainder }}円</span>
        </div>
        <el-form-item label="チャージ金額（税込）" prop="chargeMoney" class="juli">
          <!-- <div class="juli"><span>チャージ金額（税込）</span></div> -->
          <div>
            <span>
              ¥<el-input
                placeholder="金額を入力してください"
                style="width: 200px"
                v-model="b0803Form.chargeMoney"
                @blur="huansuan"
              ></el-input>
              <el-button @click="clear">クリア</el-button></span
            ><el-button style="margin-left: 10px" @click="chongzhi">チャージ</el-button>
          </div>
        </el-form-item>
        <div class="juli">
          <span>
            <el-button @click="anniu1">1000</el-button>
            <el-button @click="anniu2">5000</el-button>
            <el-button @click="anniu3">10000</el-button>
            <el-button @click="anniu4">50000</el-button>
            <el-button @click="anniu5">100000</el-button>
          </span>
        </div>
        <div class="juli">
          <span
            >説明：ハニーコインは1年間の有効期限がありますので、ご注意ください。
          </span>
        </div>
        <div class="juli">
          <span
            >割引後：¥<el-input
              style="width: 150px"
              v-model="chargeMoney"
              disabled
            ></el-input
            >円={{ chargeHoney }}ハニーコイン</span
          >
        </div>
        <div class="juli">
          <span>説明：一度に500円以上チャージした場合、割引があります。 </span>
        </div>
        <!-- <div class="juli"><span>チャージ方式</span></div> -->
        <!-- <div class="juli" style="height: 120px">
          <el-tag class="tag"><img :src="require('@/assets/b_pay1.png')" /></el-tag>
          <div class="zhifu">銀行振込</div>
        </div> -->
      </el-form>
    </div>
    <div class="waikuang interview_data">
      <div class="juli"><span>チャージ方式</span></div>
      <div class="juli">
        <el-image :src="require('@/assets/bank.png')" class="tupian" />
        <!-- <div class="zhifu">銀行振込</div> -->
      </div>
      <el-card
        style="
          margin-left: 20px;
          margin-right: 20px;
          margin-top: 20px;
          margin-bottom: 20px;
        "
        class="huidi"
      >
        <div>振込先情報</div>
        <div>金融機関名：三菱UFJ銀行（金融機関コード：0005）</div>
        <div>支店名：秋葉原駅前支店（支店コード：666）</div>
        <div>口座種別：普通</div>
        <div>口座番号：0112231</div>
        <div>振込先口座名義：ｱﾝｼﾝ ｶﾌﾞｼｷｶﾞｲｼｬ</div>
        <div>なお、振込手数料はお客様負担でお願い致します。</div>
        <!-- <div>依頼人名：</div>
        <div>会員番号：</div> -->
      </el-card>
    </div>
    <Homefooter></Homefooter>
  </div>
</template>

<script>
import HomeHeader from "./components/HomeHeader";
import Homefooter from "./components/HomeFooter";
export default {
  components: {
    HomeHeader,
    Homefooter,
  },

  data() {
    let checkChargeMoney = (rule, value, callback) => {
      let reg = /^[0-9]{1,10}$/;
      if (!reg.test(value)) {
        callback(new Error("チャージ金額は半角数字10桁以下で入力してください。"));
      }
      callback();
    };
    return {
      chargeMoney: "",
      chargeHoney: "",
      b0803Form: {
        chargeMoney: "",
      },
      b0803VueForm: {
        companyId: "",
        chargeTime: "",
        chargeMoney: "",
        chargeHoney: "",
        payMethod: "",
        statusFlg: "",
        remainder: "",
        honeyLastDate: "",
        userCd: "",
      },
      chargejine: "",
      companyInfoBean: "",
      // companyNm:this.$route.query.datab0803.companyNm,
      // companyTel:this.$route.query.datab0803.companyTel,
      // companyMail:this.$route.query.datab0803.companyMail,
      // levelNm:this.$route.query.datab0803.levelNm,
      // remainder:this.$route.query.datab0803.remainder,
      rules: {
        chargeMoney: [
          { required: true, message: "チャージ金額を入力してください。" },
          { validator: checkChargeMoney, trigger: "blur" },
        ],
      },
    };
  },

  mounted() {
    this.chuqi();
  },

  computed: {},
  methods: {
    getChargeHoney() {
      var honeyjine;
      var jine = parseInt(this.chargeMoney);
      var xiaofeishui = parseFloat(this.companyInfoBean.bean.syohizei);
      var zhe1 = parseFloat(this.companyInfoBean.bean.waribiki1);
      var zhe2 = parseFloat(this.companyInfoBean.bean.waribiki2);
      var zhe3 = parseFloat(this.companyInfoBean.bean.waribiki3);
      var zhe4 = parseFloat(this.companyInfoBean.bean.waribiki4);
      var zhe5 = parseFloat(this.companyInfoBean.bean.waribiki5);
      if (jine < 500) {
        honeyjine = parseInt(jine / (1 + xiaofeishui) / (1 - zhe1 / 10));
      } else if (jine >= 500 && jine < 5000) {
        honeyjine = parseInt(jine / (1 + xiaofeishui) / (1 - zhe2 / 10));
      } else if (jine >= 5000 && jine < 10000) {
        honeyjine = parseInt(jine / (1 + xiaofeishui) / (1 - zhe3 / 10));
      } else if (jine >= 10000 && jine < 50000) {
        honeyjine = parseInt(jine / (1 + xiaofeishui) / (1 - zhe4 / 10));
      } else {
        honeyjine = parseInt(jine / (1 + xiaofeishui) / (1 - zhe5 / 10));
      }
      return honeyjine.toString();
    },
    chuqi() {
      this.$store.dispatch("b0803Init").then((response) => {
        let code = response.data.code;
        if (code == 200) {
          this.companyInfoBean = response.data.data;
        }
        // this.$router.push({
        //   path: "/b0802",
        //   query: { datab0802: response.data.data },
        // });
      });
    },

    setForm() {
      if (
        this.companyInfoBean.companyId != null &&
        this.companyInfoBean.companyId != ""
      ) {
        this.b0803VueForm.companyId = parseInt(this.companyInfoBean.companyId, 10);
      }
      this.b0803VueForm.chargeMoney = parseInt(this.b0803Form.chargeMoney, 10);
      this.b0803VueForm.chargeHoney = parseInt(this.chargeHoney, 10);
      this.b0803VueForm.payMethod = "3";
      if (
        this.companyInfoBean.remainder != null &&
        this.companyInfoBean.remainder != ""
      ) {
        this.b0803VueForm.remainder = parseInt(this.companyInfoBean.remainder, 10);
      }
      this.b0803VueForm.chargeTime = new Date();
      this.b0803VueForm.honeyLastDate = new Date();
      this.b0803VueForm.honeyLastDate.setFullYear(
        this.b0803VueForm.honeyLastDate.getFullYear() + 1
      );
    },
    huansuan() {
      this.$refs.b0803Form.validate((valid) => {
        if (valid) {
          this.chargeMoney = this.b0803Form.chargeMoney;
          this.chargeHoney = this.getChargeHoney();
        }
      });
    },
    anniu1() {
      this.b0803Form.chargeMoney = "1000";
      this.chargeMoney = "1000";
      this.chargeHoney = this.getChargeHoney();
    },
    anniu2() {
      this.b0803Form.chargeMoney = "5000";
      this.chargeMoney = "5000";
      this.chargeHoney = this.getChargeHoney();
    },
    anniu3() {
      this.b0803Form.chargeMoney = "10000";
      this.chargeMoney = "10000";
      this.chargeHoney = this.getChargeHoney();
    },
    anniu4() {
      this.b0803Form.chargeMoney = "50000";
      this.chargeMoney = "50000";
      this.chargeHoney = this.getChargeHoney();
    },
    anniu5() {
      this.b0803Form.chargeMoney = "100000";
      this.chargeMoney = "100000";
      this.chargeHoney = this.getChargeHoney();
    },
    clear() {
      this.b0803Form.chargeMoney = "";
      this.chargeMoney = "";
      this.chargeHoney = "0";
    },
    shi() {
      console.log(this.companyInfoBean.bean);
    },

    chongzhi() {
      // console.log(this.chargeHoney);
      if (this.b0803Form.chargeMoney == "0") {
        alert("0以外の金額を入力してください");
      } else {
        this.$refs.b0803Form.validate((valid) => {
          if (valid) {
            this.setForm();
            console.log(this.b0803VueForm);
            this.$store
              .dispatch("b0803getCharge", this.b0803VueForm)
              .then((response) => {
                let code = response.data.code;
                if (code == 200) {
                  // alert(
                  //   "チャージ依頼は受け付けました、銀行振込は完了する次第、反映されます。"
                  // );

                  this.$router.push({
                    path: "/b0804",
                  });
                } else {
                  alert("チャージ失敗しました。");
                }
              })
              .catch(() => {});
          } else {
            // eslint-disable-next-line no-console
            this.$message.error("金額を正しく入力してください。");
            return false;
          }
        });
      }
    },
  },
};
</script>

<style scoped>
.waikuang {
  width: 1000px;
  margin-left: 200px;
  margin-top: 20px;
}

.interview_data {
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);
  background-color: #ffffff;
}

.lanse {
  color: #014099;
}
.juli {
  margin-top: 30px;
  margin-left: 20px;
}

.biaoqian {
  text-align: center;
  margin-left: 20px;
  font-size: 30px;
  /* border: 1px solid black; */
}

.huidi {
  background: whitesmoke;
}

.tag {
  height: 80px;
}

.zhifu {
  width: 140px;
  text-align: center;
}

.tupian {
  width: 100px;
  height: 100px;
}
</style>
