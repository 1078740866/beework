<template>
  <div>
    <!-- <HomeHeader></HomeHeader> -->
    <el-container class="margin zigao">
      <el-header class="interview_data lanse head1"> 資産情報 </el-header>
      <el-main class="interview_data">
        <div class="coinStyle">
          <label class="thicker">ハニーコイン</label>
          <el-side class="sideButton">
                <el-button icon="el-icon-bank-card" @click="toB0803()">チャージ</el-button>
          </el-side>
        </div>
        <el-container>
          <el-container>
            <el-row :gutter="20" class="row1">
              <el-col>残高：</el-col>
              <el-col>今月取得コイン：</el-col>
              <el-col>取得総コイン：</el-col>
              <el-col>チャージ総金額：</el-col>
            </el-row>
            <el-row :gutter="20" class="row2">
              <el-col>{{remainder}}</el-col>
              <el-col>{{monthly_charge_honey}}</el-col>
              <el-col>{{total_charge_honey}}</el-col>
              <el-col>{{pay_cons_sum}}</el-col>
            </el-row>
          </el-container>
        </el-container>
        <el-container >
          <el-container>
            <el-row :gutter="20" class="row1">
              <el-col>まもなく期限切れる：</el-col>
              <el-col>(期限締め日付)：</el-col>
              <el-col>今月利用コイン：</el-col>
              <el-col>利用総コイン：</el-col>
            </el-row>
            <el-row :gutter="20" class="row2">
              <el-col>{{deadline_honey}}</el-col>
              <el-col>
                {{deadline}}
              </el-col>
              <el-col>{{monthly_cons_honey}}</el-col>
              <el-col>{{total_cons_honey}}</el-col>
            </el-row>
          </el-container>
        </el-container>
      </el-main>
      <el-main class="interview_data">
        <div class="coinStyle">
          <label class="thicker">ポイント</label>
        </div>
        <el-container>
          <el-container>
            <el-row :gutter="20" class="row1">
              <el-col>ポイント残高：</el-col>
              <el-col>取得ポイント：</el-col>
            </el-row>
            <el-row :gutter="20" class="row2">
              <el-col>{{point}}</el-col>
              <el-col>{{total_earn_point}}</el-col>
            </el-row>
          </el-container>
        </el-container>
      </el-main>
    </el-container>
    <div class="div1"></div>
    <el-container class="margin">
      <el-main class="interview_data">
        <div class="coinStyle">
          <label class="thicker">クーポン管理</label>
          <el-side class="sideButton">
            <el-button icon="el-icon-bank-card" @click="toB0802()">クーポン取得</el-button>
          </el-side>
        </div>
        <el-tabs type="border-card" v-model="activeName">
          <el-tab-pane label="未使用" name="0">
            <el-row>
              <el-col :span="8" v-for="(item, i) in wsykuponlist" :key="i">
                <el-card>
                  {{item.comCouId}}
                  {{item.companyId}}
                  {{item.statusFlg}}
                  {{item.deadline}}
                  {{item.couponId}}
                  {{item.couponNm}}
                  {{item.pointNum}}
                  {{item.detail}}
                  {{item.expDays}}
                </el-card>
              </el-col>
            </el-row>
            
          </el-tab-pane>
          <el-tab-pane label="使用済" name="1">
            <el-row>
              <el-col :span="8" v-for="(item, i) in sylkuponlist" :key="i">
                <el-card>
                  {{item.comCouId}}
                  {{item.companyId}}
                  {{item.statusFlg}}
                  {{item.deadline}}
                  {{item.couponId}}
                  {{item.couponNm}}
                  {{item.pointNum}}
                  {{item.detail}}
                  {{item.expDays}}
                </el-card>
              </el-col>
            </el-row>
          </el-tab-pane>
          <el-tab-pane label="期限切れ" name="2">
            <el-row>
              <el-col :span="8" v-for="(item, i) in gqlkuponlist" :key="i">
                <el-card>
                  {{item.comCouId}}
                  {{item.companyId}}
                  {{item.statusFlg}}
                  {{item.deadline}}
                  {{item.couponId}}
                  {{item.couponNm}}
                  {{item.pointNum}}
                  {{item.detail}}
                  {{item.expDays}}
                </el-card>
              </el-col>
            </el-row>
          </el-tab-pane>
        </el-tabs>
      </el-main>
      
    </el-container>

    <!-- <Homefooter></Homefooter> -->
  </div>
</template>
<style>
.head1{
  font-size:40px;
  height: 60px !important;
  line-height: 60px;
}
.margin {
  margin-left: 5%;
  width: 90vw;
}
/* 小title */
.thicker{
  font-size: 30px;
}
/* chargeButton */
.sideButton{
  margin-left: 20%;
}
.sideButton .el-button{
  font-size:20px;
  border-radius: 15px;
  border: 1px solid #747474;
  -webkit-tap-highlight-color:transparent;
}
/* coin样式 */
.coinStyle{
  margin-bottom: 13px;
}
/* row1 */
.row1{
  width:45%;
  margin:0px !important;
  padding:0px !important;
  text-align:right;
}
.row1 .el-col-24{
  margin:4px 0px !important;
  padding:0px !important;
  border-bottom:1px solid #8f8f8f;
}
/* row2 */
.row2{
  width:55%;
  margin: 0px !important;
  padding:0px 5% !important;
  text-align:left;
}
.row2 .el-col-24{
  margin:4px 0px !important;
  padding:0px !important;
  border-bottom:1px solid #8f8f8f;
}
/* 中间空白 */
.div1{
  height: 50px;
}
.interview_data {
  box-shadow: 0 2px 20px rgba(0, 0, 0, 0.12), 0 0 6px rgba(224, 11, 11, 0.04);
  background-color: #ffffff;
}
/* 标题字体颜色 */
.lanse{
  color: #0099ff;
}
/* クーポンtab按钮 */
.el-tabs__nav{
  -webkit-tap-highlight-color:transparent;
}
</style>
<script>
// import HomeHeader from "../spComponents/HomeHeader";
// import Homefooter from "../spComponents/HomeFooter";
import '@/css/reset.css';
import '@/css/border.css';
//移动端 解决点击按钮闪和active失效的问题
document.body.addEventListener('touchstart' , function(){});
export default {
  components: {
    // HomeHeader,
    // Homefooter,
  },
  data() {
    return {
      remainder: this.$route.query.datab0801.comHoneyCoinBean.remainderCoin,
      monthly_charge_honey: this.$route.query.datab0801.comHoneyCoinBean
        .monAcquiredCoin,
      total_charge_honey: this.$route.query.datab0801.comHoneyCoinBean
        .sumAcquiredCoin,
      pay_cons_sum: this.$route.query.datab0801.comHoneyCoinBean.chargeSumMoney,
      monthly_cons_honey: this.$route.query.datab0801.comHoneyCoinBean
        .monUsedCoin,
      total_cons_honey: this.$route.query.datab0801.comHoneyCoinBean
        .sumUsedCoin,
      deadline_honey: this.$route.query.datab0801.comHoneyCoinBean
        .deadlineMoney,
      kuponlist: this.$route.query.datab0801.comCouponBeans,
      deadline: this.$route.query.datab0801.comHoneyCoinBean.deadlineSoon,
      point: this.$route.query.datab0801.comPointBean.remainderPoint,
      total_earn_point: this.$route.query.datab0801.comPointBean
        .sumAcquiredPoint,
      mishiyou: 5,
      shiyouzimi: 1,
      kigenkire: 6,
      activeName:"0",
      wsykuponlist:[],
      sylkuponlist:[],
      gqlkuponlist:[],
    };
  },
  mounted() {
    this.weishiyong();
    this.shiyongle();
    this.guoqi();
  },
  methods:{
    weishiyong(){
      var i;
      for (i = 0; i < this.kuponlist.length; i++) {
        if(this.kuponlist[i].statusFlg == "0"){
          this.wsykuponlist.push(this.kuponlist[i]);
        }
      }

    },
    shiyongle(){
      var i;
      for (i = 0; i < this.kuponlist.length; i++) {
        if(this.kuponlist[i].statusFlg == "1"){
          this.sylkuponlist.push(this.kuponlist[i]);
        }
      }
    },
    guoqi(){
      var i;
      for (i = 0; i < this.kuponlist.length; i++) {
        if(this.kuponlist[i].statusFlg == "2"){
          this.gqlkuponlist.push(this.kuponlist[i]);
        }
      }
    },
    toB0802() {
      this.$store.dispatch("b0802Init").then((response) => {
        this.$router.push({
          path: "/sp/sp_b0802",
          query: { datab0802: response.data.data },
        });
      });
    },
    toB0803() {
      this.$store.dispatch("b0803Init").then((response) => {
        this.$router.push({
          path: "/sp/sp_b0803",
          query: { datab0803: response.data.data },
        });
      });
    },
  },
};
</script>
