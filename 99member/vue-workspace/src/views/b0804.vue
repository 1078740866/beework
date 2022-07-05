<template>
  <div>
    <HomeHeader></HomeHeader>
    <el-tabs
      v-model="activeName"
      type="border-card"
      class="juli"
      @tab-click="handleClick"
    >
      <el-tab-pane label="チャージ履歴" name="first">
        <el-form :model="b0804VueForm" ref="b0804VueForm">
          <el-row>
            <el-col :span="5"><div>チャージ履歴</div></el-col>
            <!-- <el-col></el-col> -->
            <el-col :span="5" class="zuoju"
              ><div class="zida">
                <img src="../assets/charge.png" width="20px" heigt="20px" />残高：{{
                  chargeForm.zandaka
                }}ハニーコイン
              </div>
            </el-col>
          </el-row>
          <el-row class="nibuyaoguolai">
            <el-col :span="14">
              <el-form-item label="チャージ日付：" label-width="100px">
                <el-date-picker
                  v-model="date1"
                  type="date"
                  align="right"
                  value-format="yyyy-MM-dd HH:mm:ss"
                  class="datesize"
                >
                </el-date-picker
                >-
                <el-date-picker
                  v-model="date2"
                  type="date"
                  align="right"
                  value-format="yyyy-MM-dd HH:mm:ss"
                  class="datesize"
                >
                </el-date-picker>
              </el-form-item>
            </el-col>
            <el-col :span="7">
              <el-form-item label="注文状態：">
                <el-select class="hizuke" placeholder="" v-model="b0804VueForm.statusFlg">
                  <el-option
                    v-for="item in cyuumons"
                    :key="item.key"
                    :value="item.key"
                    :label="item.label"
                  ></el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="3">
              <el-button type="primary" @click="getChargeResult">検索</el-button>
            </el-col>
          </el-row>
        </el-form>
        <div class="biao">
          <el-table :data="getchargeData">
            <el-table-column label="チャージ日時" prop="chargeTime"></el-table-column>
            <el-table-column label="支払方式" prop="payMethod"></el-table-column>
            <el-table-column label="チャージ金額" prop="chargeMoney"></el-table-column>
            <el-table-column label="状態" prop="statusFlg"></el-table-column>
            <el-table-column
              label="ハニーコイン締切日"
              prop="honeyLastDate"
            ></el-table-column>
            <el-table-column label="ハニーコイン残高" prop="remainder"></el-table-column>
            <el-table-column
              label="チャージハニーコイン"
              prop="chargeHoney"
            ></el-table-column>
          </el-table>
        </div>
        <div>
          <el-pagination
            :total="pagination.total"
            :current-page="pagination.currentPage"
            :pager-count="pagination.pagerCount"
            :page-sizes="pagination.pageSizes"
            :page-size="pagination.pageSize"
            :background="true"
            :layout="pagination.layout"
            @size-change="sizeChange"
            @current-change="currentChange"
          />
        </div>
      </el-tab-pane>
      <el-tab-pane label="消費履歴" name="second">
        <el-form :model="b0804VueForm" ref="b0804VueForm">
          <el-row>
            <el-col :span="5"><div>消費履歴</div></el-col>
            <!-- <el-col></el-col> -->
            <el-col :span="5" class="zuoju"
              ><div class="zida">
                <img src="../assets/charge.png" width="20px" heigt="20px" />残高：{{
                  syohiForm.zandaka
                }}ハニーコイン
              </div>
            </el-col>
          </el-row>
          <el-row class="nibuyaoguolai">
            <el-col :span="14">
              <el-form-item label="消費日付：" label-width="80px">
                <el-date-picker
                  v-model="date3"
                  type="date"
                  align="right"
                  value-format="yyyy-MM-dd HH:mm:ss"
                  class="datesize"
                >
                </el-date-picker
                >-
                <el-date-picker
                  v-model="date4"
                  type="date"
                  align="right"
                  value-format="yyyy-MM-dd HH:mm:ss"
                  class="datesize"
                >
                </el-date-picker>
              </el-form-item>
            </el-col>
            <el-col :span="7">
              <el-form-item label="支払項目：">
                <el-select class="hizuke" placeholder="" v-model="b0804VueForm.itemId">
                  <el-option
                    v-for="item in shiharai"
                    :key="item.key"
                    :value="item.key"
                    :label="item.label"
                  ></el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="3">
              <el-button type="primary" @click="getConsResult">検索</el-button>
            </el-col>
          </el-row>
        </el-form>
        <div class="biao">
          <el-table :data="getconsumeData">
            <el-table-column label="支払ハニーコイン" prop="consHoney"></el-table-column>
            <el-table-column label="支払項目" prop="itemNm"></el-table-column>
            <el-table-column label="消費日付" prop=""></el-table-column>
            <el-table-column label="取得ポイント" prop="earnPoint"></el-table-column>
            <el-table-column label="使用クーポン" prop="couponNm"></el-table-column>
            <el-table-column label="ハニーコイン残高" prop=""></el-table-column>
          </el-table>
        </div>
        <div>
          <el-pagination
            :total="pagination.total"
            :current-page="pagination.currentPage"
            :pager-count="pagination.pagerCount"
            :page-sizes="pagination.pageSizes"
            :page-size="pagination.pageSize"
            :background="true"
            :layout="pagination.layout"
            @size-change="sizeChange"
            @current-change="currentChange"
          />
        </div>
      </el-tab-pane>
    </el-tabs>
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
      date1: "",
      date2: "",
      date3: "",
      date4: "",
      activeName: "first",
      chargeFrom: "",
      chargeTo: "",
      statusFlg: "",
      consFrom: "",
      consTo: "",
      itemId: "",
      chargeForm: {
        zandaka: "0",
        cyuumon: "",
      },
      syohiForm: {
        zandaka: "0",
      },
      b0804VueForm: {
        chargeFrom: "",
        chargeTo: "",
        statusFlg: "",
        consFrom: "",
        consTo: "",
        itemId: "",
        chargeId: "",
        chargeMoney: "",
        chargeHoney: "",
      },
      pagination: {
        // データ数
        total: 0,
        // table page from
        currentPage: 1,
        // データ数per page
        pageSizes: [10, 30, 50],
        // default データ数per page
        pageSize: 10,
        // 展示ページボタン数
        pagerCount: 5,
        // 順序
        layout: "total, sizes, prev, pager, next, jumper",
        // 当ページの最初の行
        dataStart: 0,
        //当ページの最後の行
        dataEnd: 10,
      },
      cyuumons: [
        { key: 0, label: "支払待ち" },
        { key: 1, label: "注文済み" },
      ],
      shiharai: [
        { key: 1, label: "職位トップ(1日)" },
        { key: 2, label: "職位トップ(15日)" },
      ],
      chargeData: [],
      consumeData: [],
      chargeken: 0,
    };
  },

  mounted() {
    this.getChargeResult();
  },

  computed: {
    getchargeData() {
      return (
        this.chargeData.slice(this.pagination.dataStart, this.pagination.dataEnd) || ""
      );
    },
    getconsumeData() {
      return (
        this.consumeData.slice(this.pagination.dataStart, this.pagination.dataEnd) || ""
      );
    },
  },

  methods: {
    setChargeForm() {
      if (this.date1 != null) {
        this.b0804VueForm.chargeFrom = this.date1.substring(0);
      } else {
        this.b0804VueForm.chargeFrom = "";
      }
      if (this.date2 != null) {
        this.b0804VueForm.chargeTo = this.date2.substring(0);
      } else {
        this.b0804VueForm.chargeTo = "";
      }
    },
    getChargeResult() {
      this.setChargeForm();
      console.log(this.b0804VueForm);
      this.loading = true;
      this.$store
        .dispatch("getComchargeResult", this.b0804VueForm)
        .then((response) => {
          this.loading = false;
          let code = response.data.code;
          if (code == 200) {
            // this.$router.push({
            //   // path: "/b0804",
            //   query: { data: response.data.data },
            // });
            this.chargeData = response.data.data;
            this.pagination.total = this.chargeData.length;
            this.pagination.currentPage = 1;
            this.dataFromTo();
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
          this.loading = false;
        });
    },

    setConsForm() {
      if (this.date3 != null) {
        this.b0804VueForm.consFrom = this.date3.substring(0);
      } else {
        this.b0804VueForm.consFrom = "";
      }

      if (this.date4 != null) {
        this.b0804VueForm.consTo = this.date4.substring(0);
      } else {
        this.b0804VueForm.consTo = "";
      }
    },

    getConsResult() {
      this.setConsForm();
      // this.loading = true;
      this.$store
        .dispatch("getComconsResult", this.b0804VueForm)
        .then((response) => {
          // this.loading = false;
          let code = response.data.code;
          if (code == 200) {
            // this.$router.push({
            //   // path: "/b0804",
            //   query: { data: response.data.data },
            // });
            this.consumeData = response.data.data;
            this.pagination.total = this.consumeData.length;
            this.pagination.currentPage = 1;
            this.dataFromTo();
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

    // 毎ページ行目数のselect
    sizeChange(val) {
      this.pagination.pageSize = val;
      console.log("pageSize", this.pagination.pageSize);
      this.dataFromTo();
    },
    // 当ページのボタン
    currentChange(val) {
      this.pagination.currentPage = val;
      console.log("currentPage", this.pagination.currentPage);
      this.dataFromTo();
    },
    // テーブル値行範囲の設定
    dataFromTo() {
      this.pagination.dataStart =
        (this.pagination.currentPage - 1) * this.pagination.pageSize;
      this.pagination.dataEnd = this.pagination.currentPage * this.pagination.pageSize;
      console.log("dataStart", this.pagination.dataStart);
      console.log("dataEnd", this.pagination.dataEnd);
    },

    handleClick() {
      if (this.activeName == "second") {
        this.getConsResult();
      }
      if (this.activeName == "first") {
        this.getChargeResult();
      }
    },
  },
};
</script>

<style>
/* .datesize { */
/* width: 5vw; */
/* } */
.juli {
  margin-top: 20px;
  width: 1200px;
  margin-left: 130px;
}

.zuoju {
  margin-left: 500px;
}
.hizuke {
  width: 100px;
}
.cyuumonjt {
  width: 120px;
}
.biao {
  /* width: 100%; */
  margin-top: 50px;
  box-shadow: 0 2px 2px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);
}

.zida {
  font-size: 20px;
  /* margin: auto; */
}
.nibuyaoguolai {
  margin-top: 20px;
}
</style>
