<template>
  <span>
    <el-tooltip
      :content="buttonMessage"
      effect="light"
      placement="right"
      :open-delay="400"
    >
      <span>
        <el-button
          type="primary"
          icon="el-icon-search"
          @click="addressGet"
          :disabled="isDisabled"
          circle
        />
      </span>
    </el-tooltip>
    <el-dialog title="検索結果" :visible.sync="dialogTableVisible">
      <div class="postalFont">
        <span>ご入力の郵便番号：</span>
        <span>{{ postal1 }}</span>
        <span>-</span>
        <span>{{ postal2 }}</span>
      </div>
      <el-col :span="24">
        <el-alert type="info" :closable="false" show-icon :title="alertTitle" />
      </el-col>
      <el-table :data="postalData" @row-click="returnAddress" class="postalTable">
        <el-table-column property="address" label="住所" />
        <el-table-column label="選択" class="tableSelect" width="50px">
          <template slot-scope="scope">
            <el-button
              size="mini"
              type="primary"
              icon="el-icon-check"
              @click="returnAddress(scope.row)"
              circle
            />
          </template>
        </el-table-column>
      </el-table>
      <div class="totalDiv">
        <span>計：</span>
        <span class="red">{{ count }}</span>
        <span>件</span>
      </div>
    </el-dialog>
  </span>
</template>
<script>
export default {
  data() {
    return {
      address: "",
      postalData: [],
      count: 0,
      dialogTableVisible: false,
      alertTitle:
        "以下の住所の中から該当の住所をお選びいただき、ボタンを押してください。",
      buttonMessage: "入力された郵便番号を検索する",
    };
  },
  computed: {
    // 郵便番号不規範の場合、ボタンは使用できない
    isDisabled() {
      return !(this.postal1.length == 3 && this.postal2.length == 4);
    },
  },
  methods: {
    postalSelect(row) {
      // テーブル行目データ
      console.log(row);
    },
    returnAddress(row) {
      // 子画面を閉める
      this.dialogTableVisible = false;
      // 住所データを輸入欄に転送
      this.$emit("parentMethod", row.address);
    },
    // 住所を取得する
    addressGet() {
      // 子画面を表示する
      this.dialogTableVisible = true;
      this.loading = true;
      this.$store
        // Stringスプライシング
        .dispatch("searchPostal", this.postal1 + "-" + this.postal2)
        .then((response) => {
          this.loading = false;
          let code = response.data.code;
          if (code == 200) {
            let objarr = [];
            for (let i in response.data.data) {
              var j = {};
              j.address = response.data.data[i];
              objarr.push(j);
            }
            this.postalData = objarr;
            this.count = objarr.length;
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
  },
  // 親画面からのパラメーター
  props: {
    postal1: String,
    postal2: String,
  },
};
</script>
<style lang="scss" scoped>
// ポスタル内容
.postalFont {
  text-align: center;
  font-weight: 600;
  font-size: 16px;
  margin-bottom: 24px;
}
// テーブル幅
.postalTable {
  width: 100%;
}
// 赤字
.red {
  color: red;
  margin-right: 5px;
}

// 総計div
.totalDiv {
  margin-top: 20px;
  margin-left: 10px;
}
</style>
