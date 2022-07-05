<template>
  <span>
    <el-button
      type="primary"
      icon="el-icon-search"
      @click="addressGet()"
      circle
    />
    <el-dialog title="検索結果" :visible.sync="dialogTableVisible">
      <div class="postalFont">
        <span>ご入力の郵便番号：</span>
        <span>{{ postal1 }}</span>
        <span>-</span>
        <span>{{ postal2 }}</span>
      </div>
      <el-col :span="24">
        <el-alert
          type="info"
          :closable="false"
          show-icon
          title="以下の住所の中から該当の住所をお選びいただき、ボタンを押してください。"
        />
      </el-col>
      <el-table :data="postalData" class="postalTable">
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
    };
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
// 整体布局
::v-deep  div > .el-dialog{
  width: 80%;
  margin-top:20% !important;
}
// title
::v-deep  div > .el-dialog .el-dialog__title {
  font-size: 28px;
}
// 返回按钮
::v-deep  div > .el-dialog .el-dialog__headerbtn{
  width: 30px;
  height: 30px;
  font-size: 28px;
}
// 注意事项i图标
::v-deep  div > .el-dialog .el-alert__icon{
  font-size:24px;
}
// 注意事项
::v-deep  div > .el-dialog .el-alert__content{
  padding-left:20px;
}
// 注意事项字体
::v-deep  div > .el-dialog .el-alert__title{
  font-size:20px;
}
// table字体
.el-table{
  font-size:20px;
}
// 选择图标
.el-button--mini, .el-button--small{
  font-size:24px;
}
// ポスタル内容
.postalFont {
  text-align: center;
  font-weight: 600;
  font-size: 24px;
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
  font-size:24px;
}
</style>
