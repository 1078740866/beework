<template>
  <div>
    <HomeHeader></HomeHeader>
    <el-container class="margin zigao">
      <el-header class="interview_data lanse" style="font-size: 40px">
        資産情報
      </el-header>
      <el-main class="interview_data">
        <div><label class="thicker">ハニーコイン</label></div>
        <el-container>
          <!-- <el-main> -->
          <el-container style="width: 450px">
            <el-container>
              <el-main class="biaoqian1 lanse" style="">
                <div>残高：</div>
                <div>今月取得コイン：</div>
                <div>取得総コイン：</div>
                <div>チャージ総金額：</div>
              </el-main>
              <el-side class="jine">
                <div style="margin-top: 22px">
                  <lable>{{ remainder }}</lable>
                </div>
                <div style="margin-top: 4px">
                  <lable>{{ monthly_charge_honey }}</lable>
                </div>
                <div style="margin-top: 4px">
                  <lable>{{ total_charge_honey }}</lable>
                </div>
                <div style="margin-top: 4px">
                  <lable>{{ pay_cons_sum }}</lable>
                </div>
              </el-side>
            </el-container>
            <el-side>
              <el-button style="margin-top: 10px" @click="toB0803">チャージ</el-button>
            </el-side>
          </el-container>
          <!-- </el-main> -->
          <!-- <el-side style="width: 450px"> -->
          <el-container>
            <el-container>
              <el-main class="biaoqian1 lanse" style="">
                <div>まもなく有効期限切れる：</div>
                <div>今月利用コイン：</div>
                <div>利用総コイン：</div>
              </el-main>
              <el-side class="jine">
                <div style="margin-top: 22px">{{ deadline_honey }}</div>
                <div style="margin-top: 4px">{{ monthly_cons_honey }}</div>
                <div style="margin-top: 4px">{{ total_cons_honey }}</div>
              </el-side>
            </el-container>
            <el-side class="xiayi">（有効期限）{{ deadline }}</el-side>
          </el-container>
          <!-- </el-side> -->
        </el-container>
      </el-main>
      <el-footer class="interview_data" height="100px">
        <div><label class="thicker">ポイント</label></div>
        <span class="cangao">ポイント残高：</span>
        <label>{{ point }}</label>
        <span class="dianquan">取得ポイント：</span>
        <label>{{ total_earn_point }}</label>
      </el-footer>
    </el-container>
    <el-container class="margin">
      <el-header class="interview_data thicker"
        >クーポン管理
        <el-link class="thicker youyi" @click="toB0802">クーポン取得</el-link>
      </el-header>
      <el-main class="interview_data">
        <el-tabs type="border-card" v-model="activeName">
          <el-tab-pane label="未使用" name="0">
            <el-row>
              <el-col :span="8" v-for="(item, i) in wsykuponlist" :key="i">
                <el-card>
                  {{ item.comCouId }}
                  {{ item.companyId }}
                  {{ item.statusFlg }}
                  {{ item.deadline }}
                  {{ item.couponId }}
                  {{ item.couponNm }}
                  {{ item.pointNum }}
                  {{ item.detail }}
                  {{ item.expDays }}
                </el-card>
              </el-col>
            </el-row>
          </el-tab-pane>
          <el-tab-pane label="使用済" name="1">
            <el-row>
              <el-col :span="8" v-for="(item, i) in sylkuponlist" :key="i">
                <el-card>
                  {{ item.comCouId }}
                  {{ item.companyId }}
                  {{ item.statusFlg }}
                  {{ item.deadline }}
                  {{ item.couponId }}
                  {{ item.couponNm }}
                  {{ item.pointNum }}
                  {{ item.detail }}
                  {{ item.expDays }}
                </el-card>
              </el-col>
            </el-row>
          </el-tab-pane>
          <el-tab-pane label="有効期限切れ" name="2">
            <el-row>
              <el-col :span="8" v-for="(item, i) in gqlkuponlist" :key="i">
                <el-card>
                  {{ item.comCouId }}
                  {{ item.companyId }}
                  {{ item.statusFlg }}
                  {{ item.deadline }}
                  {{ item.couponId }}
                  {{ item.couponNm }}
                  {{ item.pointNum }}
                  {{ item.detail }}
                  {{ item.expDays }}
                </el-card>
              </el-col>
            </el-row>
          </el-tab-pane>
        </el-tabs>
      </el-main>
    </el-container>

    <Homefooter></Homefooter>
  </div>
</template>
<style scoped>
.margin {
  margin-left: 100px;
  margin-top: 50px;
  width: 1250px;
}

.interview_data {
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);
  background-color: #ffffff;
}
.biaoqian1 {
  width: 200px;
  text-align: right;
}
.jine {
  width: 100px;
}
.cangao {
  margin-left: 100px;
  color: #0099ff;
}
.dianquan {
  margin-left: 300px;
  color: #0099ff;
}

.xiayi {
  margin-top: 20px;
}

.thicker {
  font-weight: 900;
  font-size: 30px;
}
.lanse {
  color: #0099ff;
}

.youyi {
  margin-left: 50px;
}
</style>
<script>
import HomeHeader from "./components/HomeHeader";
import Homefooter from "./components/HomeFooter";
export default {
  components: {
    HomeHeader,
    Homefooter,
  },
  data() {
    return {
      remainder: this.$route.query.datab0801.comHoneyCoinBean.remainderCoin,
      monthly_charge_honey: this.$route.query.datab0801.comHoneyCoinBean.monAcquiredCoin,
      total_charge_honey: this.$route.query.datab0801.comHoneyCoinBean.sumAcquiredCoin,
      pay_cons_sum: this.$route.query.datab0801.comHoneyCoinBean.chargeSumMoney,
      monthly_cons_honey: this.$route.query.datab0801.comHoneyCoinBean.monUsedCoin,
      total_cons_honey: this.$route.query.datab0801.comHoneyCoinBean.sumUsedCoin,
      deadline_honey: this.$route.query.datab0801.comHoneyCoinBean.deadlineMoney,
      kuponlist: this.$route.query.datab0801.comCouponBeans,
      deadline: this.$route.query.datab0801.comHoneyCoinBean.deadlineSoon,
      point: this.$route.query.datab0801.comPointBean.remainderPoint,
      total_earn_point: this.$route.query.datab0801.comPointBean.sumAcquiredPoint,
      mishiyou: 5,
      shiyouzimi: 1,
      kigenkire: 6,
      activeName: "0",
      wsykuponlist: [],
      sylkuponlist: [],
      gqlkuponlist: [],
    };
  },
  mounted() {
    this.weishiyong();
    this.shiyongle();
    this.guoqi();
  },
  methods: {
    weishiyong() {
      var i;
      for (i = 0; i < this.kuponlist.length; i++) {
        if (this.kuponlist[i].statusFlg == "0") {
          this.wsykuponlist.push(this.kuponlist[i]);
        }
      }
    },
    shiyongle() {
      var i;
      for (i = 0; i < this.kuponlist.length; i++) {
        if (this.kuponlist[i].statusFlg == "1") {
          this.sylkuponlist.push(this.kuponlist[i]);
        }
      }
    },
    guoqi() {
      var i;
      for (i = 0; i < this.kuponlist.length; i++) {
        if (this.kuponlist[i].statusFlg == "2") {
          this.gqlkuponlist.push(this.kuponlist[i]);
        }
      }
    },

    toB0803() {
      this.$router.push({
        path: "/b0803",
      });
    },

    toB0802() {
      this.$store.dispatch("b0802Init").then((response) => {
        this.$router.push({
          path: "/b0802",
          query: { datab0802: response.data.data },
        });
      });
    },
  },
};
</script>
