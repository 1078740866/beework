<template>
  <div>
    <HomeHeader></HomeHeader>
    <div class="waikuang">
      <div class="interview_data tougao">
        <el-row>
          <el-col :span="8" class="touzi">クーポン引換</el-col>
          <el-col :span="6" :offset="8" class="touzi"
            >ポイント残高：{{ couponBalance }}</el-col
          >
        </el-row>
        <!-- <span class="touzi">クーポン引換</span>
        <span class="touzi">ポイント残高：{{ couponBalance }}</span> -->
      </div>
      <el-form>
        <div class="interview_data">
          <el-row>
            <el-col
              v-for="(item, i) in couponList"
              :key="item.couponId"
              :span="6"
              :offset="1"
              class="nibuyaoguolai"
            >
              <el-card class="kapian">
                <div>
                  <el-image
                    :src="require('@/assets/kupon' + item.couponId + '.png')"
                    class="tupian"
                  />
                </div>
                <div>有効期間:{{ item.expDays }}日</div>
                <!-- {{ item.couponNm }} -->

                <div>
                  {{ item.pointNum }}x
                  <el-input-number
                    size="mini"
                    :precision="0"
                    :step="1"
                    v-model="num[i]"
                    :min="0"
                    @change="heji()"
                  ></el-input-number>
                </div>
              </el-card>
            </el-col>
          </el-row>
        </div>

        <div class="interview_data">
          <el-form-item>
            <span style="margin-left: 700px">合計：{{ goukei }}</span>
            <span style="margin-left: 30px"
              ><el-button
                type="primary"
                icon="el-icon-shopping-cart-full"
                @click="zan"
                :disabled="goukei == 0"
                >引換</el-button
              ></span
            >
          </el-form-item>
        </div>
      </el-form>
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
      b0802VueForm: {
        beans: [],
      },
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

    guiling(ia) {
      console.log(ia);
      // for (var i = 0; i < this.num.length; i++) {
      if (!(this.num[ia] > 0)) {
        this.num[ia] = 0;
      }

      // }
    },

    heji() {
      var a = 0;
      var i;
      for (i = 0; i < this.num.length; i++) {
        if (!(this.num[i] > 0)) {
          this.num[i] = 0;
        }
        a = a + this.num[i] * parseInt(this.couponList[i].pointNum, 10);
      }
      this.goukei = a;
    },

    zan() {
      for (var i = 0; i < this.couponList.length; i++) {
        this.b0802VueForm.beans.push(
          // Object.assign(
          // {},
          {
            userCd: 0,
            companyId: 0,
            couponId: parseInt(this.couponList[i].couponId, 10),
            expDays: parseInt(this.couponList[i].expDays, 10),
            count: this.num[i],
          }
          // )
        );
      }
      console.log(this.b0802VueForm.beans);
      this.$store.dispatch("insertCoupon", this.b0802VueForm).then((response) => {
        this.$router.push({
          query: { data: response.data.data },
        });
      });
    },
  },
};
</script>

<style scoped>
.waikuang {
  width: 1000px;
  margin-left: 200px;
}
.interview_data {
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);
  background-color: #ffffff;
}

/* .kapian {
  width: 200px;
  margin-left: 50px;
} */
.kuan {
  width: 900px;
}

.tougao {
  height: 50px;
}
.touzi {
  margin-top: 20px;
}
.nibuyaoguolai {
  margin-top: 10px;
  margin-bottom: 10px;
}

.tupian {
  width: 200px;
  height: 100px;
}
</style>
