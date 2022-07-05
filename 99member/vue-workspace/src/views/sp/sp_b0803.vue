<template>
  <div>
    <!-- <HomeHeader></HomeHeader> -->
    <div class="waikuang interview_data">
      <div class="lanse">
        <span style="margin-left: 20px; font-size: 30px">会社情報</span>
        <span style="margin-left: 700px">レベル情報</span>
      </div>
      <div style="height: 100px">
        <el-card
          style="
            margin-left: 20px;
            margin-right: 20px;
            margin-top: 20px;
            margin-bottom: 20px;
          "
          class="lanse"
        >
          <span>社名：{{ companyNm }}</span>
          <span>電話番号：{{ companyTel }}</span>
          <span>メール：{{ companyMail }}</span>
          <span>会員レベル：{{ levelNm }}</span>
        </el-card>
      </div>
    </div>
    <div class="waikuang interview_data">
      <div class="lanse juli">
        <span>A幣残高：{{ remainder }}円</span>
      </div>
      <div class="juli"><span>チャージ金額（税込）</span></div>
      <div class="juli">
        <span>
          ¥<el-input
            placeholder="金額を入力してください"
            style="width: 300px"
            v-model="chargejine"
          ></el-input>
          <el-button @click="clear">クリア</el-button></span
        >
      </div>
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
          >説明：チャージされたA幣は使用期限を過ぎると無効になりますのでご注意ください</span
        >
      </div>
      <div class="juli">
        <span
          >割引後：¥<el-input style="width: 150px"></el-input>円={{}}A幣</span
        >
      </div>
      <div class="juli">
        <span>説明：一度に500円以上にチャージする場合、割引があります</span>
      </div>
      <div class="juli"><span>チャージ方式</span></div>
      <div class="juli" style="height: 50px">
        <span>
          <el-button>クレジットカード</el-button>
          <el-button>コンビニ</el-button>
          <el-button>携帯</el-button>
          <el-button>銀行振込</el-button>
        </span>
      </div>
    </div>
    <div class="waikuang interview_data" style="height: 250px">
      <el-card
        style="
          margin-left: 20px;
          margin-right: 20px;
          margin-top: 20px;
          margin-bottom: 20px;
        "
      >
        <div>金融機関名：みずほ銀行（金融機関コード：0036）</div>
        <div>支店名：赤羽支店（支店コード：2707）</div>
        <div>預金種目：普通</div>
        <div>口座番号：1223321</div>
        <div>振込先口座名義：</div>
        <div>依頼人名：</div>
        <div>会員番号：</div>
      </el-card>
    </div>
    <!-- <Homefooter></Homefooter> -->
  </div>
</template>

<script>
// import HomeHeader from "./components/HomeHeader";
// import Homefooter from "./components/HomeFooter";
export default {
  components: {
    // HomeHeader,
    // Homefooter,
  },

  data() {
    return {
      chargejine: "",
      // companyNm:this.$route.query.datab0803.companyNm,
      // companyTel:this.$route.query.datab0803.companyTel,
      // companyMail:this.$route.query.datab0803.companyMail,
      // levelNm:this.$route.query.datab0803.levelNm,
      // remainder:this.$route.query.datab0803.remainder,
    };
  },

  methods: {
    anniu1() {
      this.chargejine = "1000";
    },
    anniu2() {
      this.chargejine = "5000";
    },
    anniu3() {
      this.chargejine = "10000";
    },
    anniu4() {
      this.chargejine = "50000";
    },
    anniu5() {
      this.chargejine = "100000";
    },
    clear() {
      this.chargejine = "";
    },
  },
};
</script>

<style>
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
  color: #0099ff;
}
.juli {
  margin-top: 30px;
  margin-left: 20px;
}
</style>
