<template>
  <div>
    <HomeHeader ref="HomeHeader" />

    <el-container class="zongkuan">
      <el-container>
        <el-header class="main interview_data" height="460px">
          <el-row class="b0003ElRow" :gutter="20">
            <el-col class="b0003ElCol" :span="20">
              <div class="center cuti">職位</div>
              <div class="center">
                <img src="../assets/b_box_ico1.png" width="60%" height="40%" alt />
              </div>
              <div class="btsize">
                <!-- <input type="button" value="新規"> -->
                <el-button class="b0003ElButton" size="small" round @click="toB0102"
                  >新 規</el-button
                >
              </div>
              <div class="btsize">
                <el-button class="b0003ElButton" size="small" round @click="toB0101"
                  >職位一覧</el-button
                >
              </div>
              <div
                class="btsize"
                v-if="userTblBean.authority == '会社会員管理員(認証済み)'"
              ></div>
            </el-col>
            <el-col class="b0003ElCol" :span="20">
              <div class="center cuti">応募者</div>
              <div class="center">
                <img src="../assets/b_box_ico2.png" width="60%" height="40%" alt />
              </div>
              <div class="btsize hongzi">
                <!-- <input type="button" value="新規"> -->
                未処理件数
                <lable>
                  {{ misyoricnt }}
                </lable>
                件
              </div>
              <div class="btsize">
                <el-button class="b0003ElButton" @click="toB0201" size="small" round
                  >応募者一覧</el-button
                >
              </div>
              <div
                class="btsize"
                v-if="userTblBean.authority == '会社会員管理員(認証済み)'"
              ></div>
            </el-col>
            <el-col class="b0003ElCol" :span="20">
              <div class="center cuti">求人</div>
              <div class="center">
                <img src="../assets/b_box_ico3.png" width="60%" height="40%" />
              </div>
              <div class="btsize">
                <!-- <input type="button" value="新規"> -->
              </div>
              <div class="btsize">
                <el-button class="b0003ElButton" size="small" @click="toB0301" round
                  >人材一覧</el-button
                >
              </div>
              <div
                class="btsize"
                v-if="userTblBean.authority == '会社会員管理員(認証済み)'"
              ></div>
            </el-col>
            <el-col class="b0003ElCol" :span="20">
              <div class="center cuti">面接</div>
              <div class="center">
                <img src="../assets/b_box_ico4.png" width="60%" height="40%" />
              </div>
              <div class="btsize">
                <!-- <input type="button" value="新規"> -->
              </div>
              <div class="btsize">
                <el-button class="b0003ElButton" size="small" round @click="toB0401"
                  >面接一覧</el-button
                >
              </div>
              <div
                class="btsize"
                v-if="userTblBean.authority == '会社会員管理員(認証済み)'"
              ></div>
            </el-col>
          </el-row>
          <el-row class="b0003ElRow" :gutter="20">
            <el-col class="b0003ElCol" :span="2">
              <div class="center cuti">研修</div>
              <div class="center">
                <img src="../assets/b_box_ico5.png" width="60%" height="40%" />
              </div>
              <div class="btsize">
                <!-- <input type="button" value="新規"> -->
                <el-button
                  class="b0003ElButton"
                  size="small"
                  @click="toB0502Registered"
                  round
                  >新 規</el-button
                >
              </div>
              <div class="btsize">
                <el-button class="b0003ElButton" @click="toB0501" size="small" round
                  >研修一覧</el-button
                >
              </div>
              <div
                class="btsize"
                v-if="userTblBean.authority == '会社会員管理員(認証済み)'"
              ></div>
            </el-col>
            <el-col class="b0003ElCol" :span="2">
              <div class="center cuti">説明会</div>
              <div class="center">
                <img src="../assets/b_box_ico6.png" width="60%" height="40%" />
              </div>
              <div class="btsize">
                <!-- <input type="button" value="新規"> -->
                <el-button
                  class="b0003ElButton"
                  size="small"
                  @click="toB0602Registered"
                  round
                  >新 規
                </el-button>
              </div>
              <div class="btsize">
                <el-button class="b0003ElButton" size="small" @click="toB0601" round
                  >説明会一覧</el-button
                >
              </div>
              <div
                class="btsize"
                v-if="userTblBean.authority == '会社会員管理員(認証済み)'"
              ></div>
            </el-col>
            <el-col class="b0003ElCol" :span="2">
              <div class="center cuti">基本情報</div>
              <div class="center">
                <img src="../assets/b_box_ico7.png" width="60%" height="40%" />
              </div>
              <div class="btsize">
                <!-- <input type="button" value="新規"> -->
                <el-button class="b0003ElButton" size="small" round>基本情報</el-button>
              </div>
              <div class="btsize">
                <el-button class="b0003ElButton" size="small" round @click="toA0901"
                  >個人情報</el-button
                >
              </div>
              <div
                class="btsize"
                v-if="userTblBean.authority == '会社会員管理員(認証済み)'"
              >
                <el-button class="b0003ElButton" size="small" @click="toB0805" round
                  >会員管理</el-button
                >
              </div>
            </el-col>
            <el-col class="b0003ElCol" :span="2">
              <div class="center cuti">資産管理</div>
              <div class="center">
                <img src="../assets/b_box_ico8.png" width="60%" height="40%" />
              </div>
              <div class="btsize">
                <!-- <input type="button" value="新規"> -->
                <el-button class="b0003ElButton" @click="toB0802" size="small" round
                  >クーポン取得</el-button
                >
              </div>
              <div class="btsize">
                <el-button class="b0003ElButton" @click="toB0801" size="small" round
                  >資産情報一覧</el-button
                >
              </div>
              <div
                class="btsize"
                v-if="userTblBean.authority == '会社会員管理員(認証済み)'"
              >
                <el-button class="b0003ElButton" size="small" @click="toB0804" round
                  >履歴一覧</el-button
                >
              </div>
            </el-col>
          </el-row>
        </el-header>
        <el-main class="main interview_data">
          <el-row>
            <el-col :span="1"
              ><el-image :src="require('@/assets/b_titleico.png')" class="tubiao"
            /></el-col>
            <el-col :span="3"><div class="cuti lanzi">人材推薦リスト</div></el-col>
          </el-row>
          <!-- <el-table :data="listdata"> -->
          <el-table ref="listData" :data="listdata" @row-click="getRowData">
            <el-table-column prop="xiezhen" label="写真">
              <template v-slot="xiezhen">
                <el-image
                  :src="'data:image/jpeg;base64,' + xiezhen.row.photoPic"
                  class="zhaopian"
                ></el-image>
              </template>
            </el-table-column>
            <el-table-column prop="name" label="名前"></el-table-column>
            <el-table-column prop="birthday" label="年齢"></el-table-column>
            <el-table-column prop="finalEducation" label="学歴">
              <template v-slot="finalEducation">
                <span v-if="finalEducation.row.finalEducation == '0'">その他</span>
                <span v-if="finalEducation.row.finalEducation == '1'"
                  >職業訓練校、予備校</span
                >
                <span v-if="finalEducation.row.finalEducation == '2'">専門学校</span>
                <span v-if="finalEducation.row.finalEducation == '3'">短期大学</span>
                <span v-if="finalEducation.row.finalEducation == '4'">大学</span>
                <span v-if="finalEducation.row.finalEducation == '5'"
                  >大学院（修士）</span
                >
                <span v-if="finalEducation.row.finalEducation == '6'"
                  >大学院（博士）</span
                >
              </template>
            </el-table-column>
            <el-table-column prop="workYears" label="経験年数"></el-table-column>
            <el-table-column
              prop="address1"
              label="希望仕事地"
              width="110"
            ></el-table-column>
            <el-table-column prop="hopeSalary" label="希望収入" width="110">
              <template v-slot="hopeSalary">
                {{ hopeSalary.row.hopeSalaryFrom }}~{{ hopeSalary.row.hopeSalaryTo }}
              </template>
            </el-table-column>
            <!-- <el-table-column
              prop="hopeSalaryTo"
              label="希望収入TO"
              width="110"
            ></el-table-column> -->
            <el-table-column prop="sex" label="性別">
              <template v-slot="sex">
                <span v-if="sex.row.sex == '0'">男</span>
                <span v-if="sex.row.sex == '1'">女</span>
              </template>
            </el-table-column>
            <el-table-column prop="station" label="最寄駅"></el-table-column>
          </el-table>
        </el-main>
      </el-container>
      <el-aside width="250px" class="side interview_data">
        <div class="youce huiyuan">
          <div class="center cuti lanzi">会員情報</div>
          <div class="center">
            <img :src="this.picurl" width="60%" height="40%" />
          </div>
          <el-row>
            <el-col :offset="1">{{ userTblBean.companyNm }}</el-col>
          </el-row>
          <el-row>
            <el-col :offset="1">{{ userTblBean.userName }}</el-col>
            <el-col :offset="1">{{ userTblBean.authority }}</el-col>
            <el-col :offset="1">{{ userTblBean.levelNm }}</el-col>
          </el-row>
        </div>
        <div class="youce cangaok">
          <el-row class="chongzhi"></el-row>
          <el-row>
            <el-col :span="12" :offset="1"> 残高:{{ userTblBean.remainder }}</el-col>
            <!--<el-input v-model="remainder" :disabled="true" class="cane"> -->
            <!-- <el-input :disabled="true" class="cane"> </el-input> -->
            <!-- <a @click="redirect_to_login" class=""> -->
            <el-tooltip
              :content="'チャージ'"
              placement="top-start"
              effect="light"
              :open-delay="400"
            >
              <img
                style="margin-left: 60px"
                src="../assets/charge.png"
                width="20px"
                heigt="20px"
                class="pointer"
                @click="toB0803"
              />
            </el-tooltip>

            <!-- </a> -->
          </el-row>
        </div>
        <div class="youce xiaozi">
          <el-row class="chongzhi"></el-row>
          <el-row><el-col :offset="1">お問い合わせ</el-col></el-row>
          <el-row><el-col :offset="1">電話番号： 03-5829-8154</el-col></el-row>
          <el-row><el-col :offset="1">メール： hr@an-sin.co.jp</el-col></el-row>
        </div>
      </el-aside>
    </el-container>
    <HomeFooter></HomeFooter>
  </div>
</template>
<script>
import HomeHeader from "./components/HomeHeader";
import HomeFooter from "./components/HomeFooter";
export default {
  name: "b0003",
  components: {
    HomeHeader,
    HomeFooter,
  },
  data() {
    return {
      picurl: "",
      userTblBean: "",
      // remainder: "",
      // userdata: this.$route.query.datab0003.userTblBean,
      misyoricnt: "",
      listdata: "",
    };
  },
  mounted() {
    document.title = "会社管理";
    this.chuqi();
    this.play();
    window.addEventListener("popstate", this.goBack, false);
    // console.clear();
  },
  destroyed() {
    window.removeEventListener("popstate", this.goBack, false);
  },
  methods: {
    // 行目ボタンのクリック
    getRowData(row) {
      this.$router.push({
        path: "/c01Detailed",
        query: {
          applicantId: row.applicantId,
        },
      });
    },
    chuqi() {
      this.$store
        .dispatch("b0003Search")
        .then((response) => {
          let code = response.data.code;
          if (code == 200) {
            this.userTblBean = response.data.data.userTblBean;
            this.misyoricnt = response.data.data.count;
            this.listdata = response.data.data.b0301Beans;
            this.picurl = "data:image/jpeg;base64," + this.userTblBean.photoPic;
            // this.$router.push({
            //   path: "/c0003",
            //   query: { datac0003: response.data.data },
            // });
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
          // this.loading = false;
        });
    },
    toB0601() {
      this.$router.push({
        path: "/b0601",
      });
    },
    goBack() {
      history.go(-2);
    },
    change() {
      // this.listdata.push(this.listdata[0]);
      // this.listdata.shift();
    },

    play() {
      setInterval(this.change, 1000);
    },
    toRegister() {
      this.$router.push({
        path: "/b0401",
      });
    },
    toB0101() {
      console.log("Go to the b0101 page.");
      this.$router.push({
        path: "/b0101",
      });
    },
    toB0805() {
      this.$router.push({
        path: "/b0805",
      });
    },
    toB0804() {
      this.$router.push({
        path: "/b0804",
      });
    },
    toB0102() {
      console.log("Go to the b0102 page.");
      this.$router.push({
        path: "/b0102Registered",
      });
    },
    toB0301() {
      console.log("Go to the b0401 page.");
      this.$router.push({
        path: "/b0301",
      });
    },
    toB0401() {
      console.log("Go to the b0401 page.");
      this.$router.push({
        path: "/b0401",
      });
    },
    toB0803() {
      this.$router.push({
        path: "/b0803",
      });
    },

    toB0501() {
      this.$store.dispatch("b0501Init").then((response) => {
        this.$router.push({
          path: "/b0501",
          query: { data: response.data.data },
        });
      });
    },
    toB0201() {
      this.$router.push({
        path: "/b0201",
      });
    },
    toB0502Registered() {
      this.$store.dispatch("b0501Init").then(() => {
        this.$router.push({
          path: "/b0502Registered",
        });
      });
    },
    toB0602Registered() {
      this.$store.dispatch("b0601Init").then(() => {
        this.$router.push({
          path: "/b0602Registered",
        });
      });
    },
    toB0801() {
      this.$store.dispatch("b0801Init").then((response) => {
        this.$router.push({
          path: "/b0801",
          query: { datab0801: response.data.data },
        });
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
    toA0901() {
      this.$store
        .dispatch("a0901InitUserInfoB")
        .then((response) => {
          let code = response.data.code;
          if (code == 200) {
            this.$router.push({
              path: "/a0901",
              query: { data: response.data.data.userInfoBeanB },
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
          // this.loading = false;
        });
    },

    shi() {
      console.log(this.userTblBean);
      console.log(this.picurl);
      console.log(this.listdata);
    },
  },
};
</script>
<style scoped>
.zongkuan {
  width: 1370px;
  margin-bottom: 10px;
}
.center {
  text-align: center;
  margin: auto;
}
.b0003ElRow {
  border: 1px;
  margin-top: 20px;
  margin-bottom: 20px;
  margin-left: 300px;
}

.b0003ElCol {
  width: 150px;
  /* height: 220px; */
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);
  border-radius: 15px;
  margin-left: 60px;
}
.b0003ElButton {
  width: 90%;
}
.side {
  margin-right: 80px;
}
.main {
  margin-left: 80px;
  margin-top: 10px;
  width: 910px;
}
.window {
  border: 1px solid black;
  margin-bottom: 20px;
}
.cbtn {
  margin-right: 1px;
}
.cane {
  width: 90px;
}
.cangaok {
  height: 50px;
  background-color: rgb(186, 204, 233);
  color: #ffffff;
}
.youce {
  margin-top: 20px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);
  border-radius: 15px;
  width: 90%;
  margin-left: 5%;
}
.interview_data {
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);
  background-color: #ffffff;
}
.xiaozi {
  /* font-size: 15px; */
  background-color: rgb(239, 195, 31);
  color: #ffffff;
  height: 100px;
}
.btsize {
  height: 40px;
}
.pointer {
  cursor: pointer;
}
.chongzhi {
  height: 10px;
}
.hongzi {
  color: crimson;
  font-size: 10px;
  text-align: center;
}
.lanzi {
  color: dodgerblue;
}
.zhaopian {
  width: 50px;
  height: 50px;
}

.tubiao {
  width: 30px;
  height: 30px;
}

.cuti {
  font-weight: bold;
}

.huiyuan {
  background-color: rgb(247, 247, 247);
}
</style>
