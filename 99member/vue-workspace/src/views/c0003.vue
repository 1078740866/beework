<template>
  <div>
    <ApplicantHeader />

    <el-container class="zongkuan">
      <el-container>
        <el-header class="main interview_data" height="430px">
          <el-row class="b0003ElRow" :gutter="20">
            <el-col class="b0003ElCol" :span="2">
              <div class="center">履歴書管理</div>
              <div class="center">
                <el-image :src="require('@/assets/c_box_ico1.png')" />
                <!-- <img src="../assets/b_box_ico1.png" width="60%" height="40%" /> -->
              </div>
              <div class="btsize">
                <!-- <input type="button" value="新規"> -->
              </div>

              <el-button class="b0003ElButton" size="small" round @click="toC0101"
                >履歴書情報</el-button
              >
            </el-col>
            <el-col class="b0003ElCol" :span="2">
              <div class="center">職位管理</div>
              <div class="center">
                <el-image :src="require('@/assets/c_box_ico2.png')" />
                <!-- <img src="../assets/b_box_ico2.png" width="60%" height="40%" /> -->
              </div>
              <div style="font-size: 15px" class="btsize"></div>
              <div>
                <el-button class="b0003ElButton" @click="toC0201" size="small" round
                  >職位一覧</el-button
                >
              </div>
            </el-col>
            <el-col class="b0003ElCol" :span="2">
              <div class="center">面接管理</div>
              <div class="center">
                <el-image :src="require('@/assets/c_box_ico3.png')" />
                <!-- <img src="../assets/b_box_ico3.png" width="60%" height="40%" /> -->
              </div>
              <div class="btsize">
                <!-- <input type="button" value="新規"> -->
              </div>
              <div>
                <el-button class="b0003ElButton" size="small" round @click="toC0501"
                  >面接一覧</el-button
                >
              </div>
            </el-col>
            <el-col class="b0003ElCol" :span="2">
              <div class="center">研修管理</div>
              <div class="center">
                <el-image :src="require('@/assets/c_box_ico4.png')" />
                <!-- <img src="../assets/b_box_ico4.png" width="60%" height="40%" /> -->
              </div>
              <div class="btsize">
                <!-- <input type="button" value="新規"> -->
              </div>
              <div>
                <el-button class="b0003ElButton" size="small" round @click="toC0301"
                  >研修一覧</el-button
                >
              </div>
            </el-col>
          </el-row>
          <el-row class="b0003ElRow" :gutter="20">
            <el-col class="b0003ElCol" :span="2">
              <div class="center">説明会管理</div>
              <div class="center">
                <el-image :src="require('@/assets/c_box_ico5.png')" />
                <!-- <img src="../assets/b_box_ico5.png" width="60%" height="40%" /> -->
              </div>
              <div class="btsize">
                <!-- <input type="button" value="新規"> -->
              </div>
              <div>
                <el-button class="b0003ElButton" @click="toC0401" size="small" round
                  >説明会一覧</el-button
                >
              </div>
            </el-col>
            <el-col class="b0003ElCol" :span="2">
              <div class="center">個人情報管理</div>
              <div class="center">
                <el-image :src="require('@/assets/c_box_ico6.png')" />
                <!-- <img src="../assets/b_box_ico6.png" width="60%" height="40%" /> -->
              </div>
              <div class="btsize"></div>
              <div>
                <el-button class="b0003ElButton" size="small" round>個人情報</el-button>
              </div>
            </el-col>
          </el-row>
        </el-header>
        <el-main class="main interview_data">
          <!-- <el-footer class="main interview_data"> -->
          <div>職位推薦</div>
          <!-- <el-table :data="listdata"> -->
          <el-table :data="listdata">
            <el-table-column prop="positionNm" label="職位名"></el-table-column>
            <el-table-column prop="industryNm" label="業種"></el-table-column>
            <el-table-column prop="jobTypeNm" label="職種"></el-table-column>
            <el-table-column prop="expYears" label="必須経験年数"></el-table-column>
            <el-table-column prop="workTimeFrom" label="勤務開始時間"></el-table-column>
            <el-table-column prop="workTimeTo" label="勤務終了時間"></el-table-column>
            <el-table-column prop="station" label="最寄駅"></el-table-column>
            <el-table-column prop="peoCnt" label="応募人数"></el-table-column>
            <el-table-column prop="expDate" label="有効期限"></el-table-column>
            <el-table-column prop="updateTime" label="更新日時"></el-table-column>
          </el-table>
        </el-main>
        <!-- </el-footer> -->
      </el-container>
      <el-aside width="250px" class="side interview_data">
        <div class="youce">
          <div class="center">ユーザー情報</div>
          <div class="center">
            <img :src="photo" width="60%" heigt="60%" />
          </div>
          <div>応募者：{{ userName }}</div>
          <div></div>
        </div>
        <div class="youce xiaozi">
          <div>お問い合わせ</div>
          <div>電話番号： 03-5829-8154</div>
          <div>メール： hr@an-sin.co.jp</div>
        </div>
      </el-aside>
    </el-container>
    <HomeFooter></HomeFooter>
  </div>
</template>

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
  margin-left: 200px;
}

.b0003ElCol {
  width: 150px;
  height: 200px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);
  border-radius: 15px;
  margin-left: 60px;
}
.b0003ElButton {
  width: 90%;
}
.side {
  margin-left: 20px;
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
  width: 70px;
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
</style>

<script>
import HomeFooter from "./components/HomeFooter";
import ApplicantHeader from "@/views/components/ApplicantHeader";
export default {
  components: {
    ApplicantHeader,
    HomeFooter,
  },

  data() {
    return {
      photo: "",
      userName: "",
      listdata: "",
    };
  },
  mounted() {
    this.chuqi();
  },
  methods: {
    chuqi() {
      this.$store
        .dispatch("c0003Search")
        .then((response) => {
          // this.loading = false;
          let code = response.data.code;
          if (code == 200) {
            this.userName = response.data.data.userName;
            this.photo = response.data.data.photo;
            this.listdata = response.data.data.positionTblBean;
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
    toC0101() {
      this.$router.push({
        path: "/c0101",
      });
    },
    toC0201() {
      this.$router.push({
        path: "/c0201",
      });
    },
    toC0301() {
      this.$router.push({
        path: "/c0301",
      });
    },
    toC0401() {
      this.$router.push({
        path: "/c0401",
      });
    },
    toC0501() {
      this.$router.push({
        path: "/c0501",
      });
    },
  },
};
</script>
