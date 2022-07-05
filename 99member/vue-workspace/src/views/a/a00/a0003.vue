<template>
  <div>
    <AdministratorHeader ref="systemHeader" />

    <el-container class="zongkuan">
      <el-container class="main interview_data">
        <el-main>
          <el-row class="b0003ElRow" :gutter="20">
            <el-col class="b0003ElCol" :span="20">
              <div class="center">審査</div>
              <div class="center">
                <img :src="require('@/assets/a_box_ico1.png')" />
              </div>
              <div class="btsize">
                <!-- <input type="button" value="新規"> -->
                <el-button class="xiaobutton center" size="small" round
                  >会社審査</el-button
                >
                <el-button class="xiaobutton center" size="small" round
                  >職位審査</el-button
                >
              </div>

              <el-button class="b0003ElButton" size="small" round>管理者審査</el-button>
            </el-col>
            <el-col class="b0003ElCol" :span="20">
              <div class="center">会社</div>
              <div class="center">
                <img :src="require('@/assets/a_box_ico2.png')" />
              </div>
              <div class="btsize hongzi">
                <!-- <input type="button" value="新規"> -->
              </div>
              <div>
                <el-button class="b0003ElButton" size="small" round>会社一覧</el-button>
              </div>
            </el-col>
            <el-col class="b0003ElCol" :span="20">
              <div class="center">応募者</div>
              <div class="center">
                <img :src="require('@/assets/a_box_ico3.png')" />
              </div>
              <div class="btsize">
                <!-- <input type="button" value="新規"> -->
              </div>
              <div>
                <el-button class="b0003ElButton" size="small" @click="toA0201" round
                  >応募者一覧</el-button
                >
              </div>
            </el-col>
            <el-col class="b0003ElCol" :span="20">
              <div class="center">承認管理</div>
              <div class="center">
                <img :src="require('@/assets/a_box_ico4.png')" />
              </div>
              <div class="btsize">
                <!-- <input type="button" value="新規"> -->
              </div>
              <div>
                <el-button class="b0003ElButton" size="small" @click="toA0701" round
                  >未承認一覧</el-button
                >
              </div>
            </el-col>
          </el-row>
          <el-row class="b0003ElRow" :gutter="20">
            <el-col class="b0003ElCol" :span="2">
              <div class="center">広告</div>
              <div class="center">
                <img :src="require('@/assets/a_box_ico5.png')" />
              </div>
              <div class="btsize">
                <!-- <input type="button" value="新規"> -->
                <el-button class="xiaobutton" size="small" round>会社審査</el-button>
                <el-button class="xiaobutton" size="small" round>職位審査</el-button>
              </div>
              <div>
                <el-button class="b0003ElButton" size="small" @click="toA0501" round
                  >広告一覧審査</el-button
                >
              </div>
            </el-col>
            <el-col class="b0003ElCol" :span="2">
              <div class="center">管理者</div>
              <div class="center">
                <img :src="require('@/assets/a_box_ico6.png')" />
              </div>
              <div class="btsize">
                <!-- <input type="button" value="新規"> -->
                <!-- <el-button
                  class="b0003ElButton"
                  size="small"
                  @click="toB0602Registered"
                  round
                  >新 規</el-button
                > -->
              </div>
              <div>
                <el-button class="b0003ElButton" size="small" round
                  >管理者一覧画面</el-button
                >
              </div>
            </el-col>
            <el-col class="b0003ElCol" :span="2">
              <div class="center">通報管理</div>
              <div class="center">
                <img :src="require('@/assets/a_box_ico7.png')" />
              </div>
              <div class="btsize">
                <!-- <input type="button" value="新規"> -->
                <!-- <el-button class="b0003ElButton" size="small" round>基本情報</el-button> -->
              </div>
              <div>
                <el-button class="b0003ElButton" size="small" @click="toA0601" round
                  >通報一覧画面</el-button
                >
              </div>
            </el-col>
            <el-col class="b0003ElCol" :span="2">
              <div class="center">メッセージ管理</div>
              <div class="center">
                <img :src="require('@/assets/a_box_ico8.png')" />
              </div>
              <div class="btsize">
                <!-- <input type="button" value="新規"> -->
                <el-button class="b0003ElButton" size="small" @click="toA0801" round
                  >送信画面</el-button
                >
              </div>
              <div>
                <el-button class="b0003ElButton" size="small" round
                  >送信履歴一覧画面</el-button
                >
              </div>
            </el-col>
          </el-row>
        </el-main>
      </el-container>
      <el-aside width="250px" class="side interview_data">
        <div class="youce">
          <div class="center">システム管理者情報</div>
          <div class="center">
            <img src="@/assets/b_box_ico1.png" width="60%" heigt="60%" />
          </div>
          <div class="center">
            <el-tag size="medium">超小标签</el-tag>
            <el-tag size="medium" class="nibuyaoguolaia"
              ><el-link type="primary" @click="toA0901">個人情報</el-link></el-tag
            >
          </div>
        </div>
        <!-- <div class="youce cangaok">
          <el-row class="chongzhi"></el-row> -->
        <!-- <el-row>
            <el-col :span="12"> 残高:{{ remainder }}</el-col>
            <el-input v-model="remainder" :disabled="true" class="cane">
            <el-input :disabled="true" class="cane"> </el-input> -->
        <!-- <a @click="redirect_to_login" class=""> -->

        <!-- <img
              style="margin-left: 60px"
              src="../assets/charge.png"
              width="20px"
              heigt="20px"
              class="pointer"
              @click="redirect_to_login"
            /> -->

        <!-- </a> -->
        <!-- </el-row>  -->
        <!-- </div> -->
        <div class="youce xiaozi">
          <div>お問い合わせ</div>
          <div>電話番号： 03-5829-8154</div>
          <div>メール： hr@an-sin.co.jp</div>
        </div>
      </el-aside>
    </el-container>
    <home-footer />
  </div>
</template>
<script>
import AdministratorHeader from "@/views/components/AdministratorHeader";
import HomeFooter from "@/views/components/HomeFooter";
export default {
  name: "b0003",
  components: {
    AdministratorHeader,
    HomeFooter,
  },
  data() {
    return {
      remainder: "",

      // userdata: this.$route.query.datab0003.userTblBean,
      // misyoricnt: this.$route.query.datab0003.count,
      // listdata: this.$route.query.datab0003.b0301Beans,
      vueForm: [],
      authority: "",
    };
  },
  mounted() {
    // document.title = "会社管理";
    this.chuqi();
    // this.play();
    // window.addEventListener("popstate", this.goBack, false);
    // console.clear();
  },
  destroyed() {
    window.removeEventListener("popstate", this.goBack, false);
  },
  methods: {
    chuqi() {
      this.$store
        .dispatch("a0003Search")
        .then((response) => {
          let code = response.data.code;
          this.vueForm = response.data.data;
          if (this.vueForm.authority == "スーパー管理者") {
            this.authority = "1";
          }
          if (code == 200) {
            this.remainder = response.data.data.remainder;
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

    toA0901() {
      this.$store
        .dispatch("a0901InitUserInfoA")
        .then((response) => {
          let code = response.data.code;
          if (code == 200) {
            this.$router.push({
              path: "/a0901",
              query: { data: response.data.data.userInfoBeanA },
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
    toA0201() {
      this.$router.push({
        path: "/a0201",
      });
    },
    toA0501() {
      setTimeout(() => {
        this.$router.push({
          path: "/a0501",
        });
      }, 1);
    },
    toA0601() {
      setTimeout(() => {
        this.$router.push({
          path: "/a0601",
        });
      }, 1);
    },
    toA0701() {
      setTimeout(() => {
        this.$router.push({
          path: "/a0701",
          query: { flight: JSON.stringify(this.authority) },
        });
      }, 1);
    },
    toA0801() {
      this.$router.push({
        path: "/a0801",
      });
    },
  },
};
</script>
<style scoped>
.zongkuan {
  width: 1500px;
  /* border: 1px solid black; */
  margin-bottom: 10px;
}
.center {
  text-align: center;
  margin: auto;
}
.b0003ElRow {
  border: 1px;
  margin-bottom: 20px;
  margin-left: 300px;
}

.b0003ElCol {
  width: 200px;
  height: 250px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);
  border-radius: 15px;
  margin-left: 45px;
}
.b0003ElButton {
  width: 95%;
}
.xiaobutton {
  width: 45%;
}
.side {
  margin-right: 80px;
  margin-left: 20px;
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
  height: 40px;
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
  font-size: 15px;
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
}
.nibuyaoguolaia {
  margin-left: 20px;
}
</style>
