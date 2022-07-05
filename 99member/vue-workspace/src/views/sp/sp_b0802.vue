<template>
  <div>
    <!-- <HomeHeader></HomeHeader> -->
    <div class="waikuang">
      <div class="interview_data title">
        <span class="couponTitle">クーポン引換</span>
        <span class="pointBalance">
          ポイント残高：{{ couponBalance }}
        </span>
      </div>
      <div class="interview_data">
        <div>
          <template>
            <el-row>
              <el-col v-for="(item, i) in couponList" :key="item.couponId">
                <el-card class="kapian">
                  {{ item.couponNm }}
                  {{ item.couponId }}
                  {{ item.pointNum }}
                  <el-input-number
                  :precision="0"
                  :step="1"
                    v-model="num[i]"
                    :min="0"
                    :max="10"
                    @change="heji()"
                  ></el-input-number>
                </el-card>
              </el-col>
            </el-row>
          </template>
        </div>
      </div>
      <div class="interview_data footer">
        <span class="countPoint">合計：{{ goukei }}</span>
        <span class="countButton">
          <el-button type="primary" icon="el-icon-shopping-cart-full" @click="zan" :disabled="(goukei==0)">購入</el-button>
        </span>
      </div>
    </div>
    <!-- <Homefooter></Homefooter> -->
  </div>
</template>

<script>
// import HomeHeader from "./components/HomeHeader";
// import Homefooter from "./components/HomeFooter";
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
      couponList: this.$route.query.datab0802.lists,
      couponBalance: this.$route.query.datab0802.couponBalance,
      //   couponList: [
      //     {
      //       couponId: "001",
      //       couponNm: "3割り",
      //       pointNum: "600",
      //       detail: "期限限定",
      //       expDays: "2021/01/31",
      //     },
      //     {
      //       couponId: "002",
      //       couponNm: "5割り",
      //       pointNum: "1000",
      //       detail: "期限限定",
      //       expDays: "2020/02/31",
      //     },
      //     {
      //       couponId: "003",
      //       couponNm: "7割り",
      //       pointNum: "1400",
      //       detail: "期限限定",
      //       expDays: "2020/03/31",
      //     },

      //     {
      //       couponId: "004",
      //       couponNm: "9割り",
      //       pointNum: "1800",
      //       detail: "期限限定",
      //       expDays: "2020/03/31",
      //     },
      //   ],
      num: [],
      goukei: 0,
    };
  },
  mounted() {
    this.reset();
  },
  methods: {
    reset() {
      var i;
      for (i = 0; i < this.num.length; i++) {
        this.num[i] = 0;
      }
    },

    heji() {
      var a = 0;
      var i;
      for (i = 0; i < this.num.length; i++) {
        if(!(this.num[i] >0)){
          this.num[i]=0;
        }
        a = a + this.num[i] * parseInt(this.couponList[i].pointNum, 10);
      }
      this.goukei = a;
    },
    zan() {
      
      for (var i = 0; i < this.couponList.length; i++) {
        this.b0802VueForm.beans.push(
            {
              userCd: 0,
              companyId: 0,
              couponId: parseInt(this.couponList[i].couponId, 10),
              expDays: parseInt(this.couponList[i].expDays, 10),
              count: this.num[i],
            }
        );
      }
       this.$store.dispatch("insertCoupon",this.b0802VueForm).then((response) => {
        this.$router.push({
          query: { data: response.data.data },
        });
      });
    },
  },
};
</script>

<style>
/* 整体div布局 */
.waikuang {
  width: 80%;
  margin-left: 10%;
}
/* 标题 */
.title{
  height: 80px;
}
/* coupon引换标题 */
.couponTitle{
  padding: 10px 10px;
  color: #0099ff;
  font-size: 32px;
  height: 80px;
  line-height: 80px;
}
/* point残高 */
.pointBalance{
  font-size: 20px;
  float: right;
  height: 80px;
  line-height: 130px;
}
.interview_data {
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);
  background-color: #ffffff;
}
/* 卡片 */
.kapian {
  width: 50%;
  margin: 10px 10px;
}
/* 尾部 */
.footer{
  height: 60px;
}
/* 尾部合计 */
.countPoint{
  font-size: 24px;
  height: 60px;
  line-height: 60px;
  margin-left: 45%;
}
/* 尾部合计按钮 */
.countButton{
  float: right;
  line-height: 55px;
  margin-right: 10px;
  -webkit-tap-highlight-color:transparent;
}
</style>
