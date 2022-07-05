<!-- データ採集検証のため、新規作成 -->

<template>
  <div class="HomePage">
    <el-container>
      <el-header class="homeHeader">
        <div class="homeHeaderRoot">
          <el-menu
            :default-active="activeIndex2"
            class="el-menu-header"
            mode="horizontal"
            text-color="#2d8cf0"
          >
            <el-menu-item class="space"></el-menu-item>
            <el-menu-item> </el-menu-item>
            <el-menu-item class="space1"></el-menu-item>
            <el-menu-item> </el-menu-item>
          </el-menu>
        </div>
      </el-header>
      <div class="searchBackground">
        <div class="searchInput">
          <el-input
            placeholder="商品を入力してください"
            v-model="searchNm"
            class="searchInputInner"
          >
            <el-button
              class="buttonSelect"
              slot="append"
              icon="el-icon-search"
              @click="toPositionListBySearchNm"
            ></el-button>
          </el-input>
        </div>
      </div>
      <!-- <ul>
        <li v-for="data in datalist"  :key="data.col2">
          <img :src="data.col2" />{{data.col4}} {{data.col5}} {{data.col6}} 
        </li>
      </ul> -->
      <!-- <p v-for="data in datalist" :key="data.col2">{{data.col2}} {{data.col4}} {{data.col5}} {{data.col6}} </p> -->

      <el-form ref="loginForm" label-position="left" autocomplete="on">
        <el-main class="homeBody">
          <div class="block">
            <el-table
              :data="datalist"
              style="width: 100%"
              highlight-current-row
            >
              <el-table-column prop="goodsPhoto" label="写真" width="200">
                <template slot-scope="scope">
                  <img :src="scope.row.goodsPhoto" @click="toGetdatadetail" class="pointer"/>
                </template>
              </el-table-column>
              <el-table-column
                prop="goodsName"
                label="商品名"
                width="520"
                class="pointer"
                @click="toGetdatadetail"
              />
              <el-table-column prop="goodsTag" label="タグ" width="300" />
              <el-table-column prop="goodsPrice" label="価格" width="200" />
            </el-table>
          </div>
        </el-main>
      </el-form>
    </el-container>
    <el-backtop></el-backtop>
  </div>
</template>


<script lang="" scoped>
import "@/css/reset.css";
import "@/css/border.css";

export default {
  name: "HomePage",
  mounted() {
    this.getGoodsList();
  },
  data() {
    return {
          // 転送用form
      G01VueForm: {
        goodsDetail:"",
        goodsPhoto:"",
        goodsLink:"",
        goodsName:"",
        goodsTag:"",
        goodsPrice:"",
      },
      searchNm: "",
      datalist: [],

    };
  },
  methods: {
    getGoodsList() {
      // this.setTrainingData();
      this.$store.dispatch("g01Search", this.G01VueForm).then((response) => {
        this.$router.push({
          query: { data: response.data.data },
        });
        // 商品リストを取得する
        console.log(response.data.data);
        this.datalist = response.data.data.testGoods2TblBean;
      });
    },
    // 検索条件の値を設定する
    // setTrainingData() {
    //   this.B0501VueForm.trainingNm = this.b0501Form.trainingNm;
    //   this.B0501VueForm.industryId = this.b0501Form.industryId;
    //   this.B0501VueForm.statusFlg = this.b0501Form.statusFlg;
    //   this.B0501VueForm.dateFrom = new Date(this.b0501Form.date[0]);
    //   this.B0501VueForm.dateTo = new Date(this.b0501Form.date[1]);
    // },     
    toGetdatadetail() {
      let routeUrl = this.$router.resolve({
        path: "/getdatadetail",
        query: {}
      });
      window.open(routeUrl.href, '_blank');
    },
  },
};
</script>

<style>
.pointer {
  cursor:pointer
}
.HomePage {
  min-width: 1200px;
}
.homeHeader {
  height: 65px !important;
}
.el-menu-header.el-menu--horizontal {
  border-bottom: solid 0px;
}
.homeHeaderRoot {
  position: fixed;
  z-index: 100;
  height: 65px !important;
  top: 0px;
  left: 0px;
  bottom: 0px;
  width: 100%;
  border: 0px;
  background-color: #ffffff;
  box-shadow: 0px 20px 20px -20px #dbdbdb;
}
.space {
  width: 45%;
  pointer-events: none;
}
.space1 {
  width: 1%;
  pointer-events: none;
}
.searchBackground {
  width: 100%;
  height: 100%;
  background-size: contain;
  background-position: left;
}
.searchInput {
  padding: 0px 1%;
  z-index: 0;
}
.searchInputInner .el-input__inner {
  font-size: 18px;
  height: 60px !important;
}
.homeBody {
  padding-top: 10px;
  background-color: rgb(240, 240, 240);
}
.block {
  color: #1d2125;
  width: 100%;
}
.el-input-group__append,
.el-input-group__prepend {
  background-color: #0099ff;
  color: #ffffff;
  border: 1px solid #0099ff;
}
.el-input-group__append button.el-button {
  height: 54px !important;
}
.buttonSelect {
  width: 80px;
}
</style>