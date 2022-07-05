<template>
  <div>
    <el-container>
      <el-header>
        <div class="header">
          <ApplicantHeader />
        </div>
      </el-header>
      <el-form
        :model="a0501Form"
        ref="a0501Form"
        label-position="left"
        autocomplete="on"
        :rules="rules"
      >
        <el-main class="a0501_body">
          <div class="a0501_select">
            <div class="select_body">
              <el-row :gutter="1">
                <el-col :span="8" :offset="1">
                  <div>
                    <el-form-item label="支払状態：" label-width="80px">
                      <el-radio v-model="a0501Form.chargeFlg" label="0"
                        >支払未済</el-radio
                      >
                      <el-radio v-model="a0501Form.chargeFlg" label="1"
                        >支払済み</el-radio
                      >
                    </el-form-item>
                  </div>
                </el-col>

                <el-col :span="6" :offset="1">
                  <div>
                    <el-form-item
                      label="レイアウトID："
                      label-width="100px"
                      prop="layoutId"
                    >
                      <el-input 
                      type="text"
                      v-model="a0501Form.layoutId"
                      placeholder="レイアウトID" 
                      clearable
                      />
                    </el-form-item>
                  </div>
                </el-col>
              </el-row>
            </div>

            <el-row>
              <el-col :span="8" :offset="1">
                <div>
                  <el-form-item label="オンライン状態：" label-width="120px">
                    <el-radio 
                    v-model="a0501Form.onlineFlg" 
                    label="0"
                      >オフライン</el-radio
                    >
                    <el-radio 
                    v-model="a0501Form.onlineFlg" 
                    label="1"
                      >オンライン</el-radio
                    >
                  </el-form-item>
                </div>
              </el-col>
              <el-col :span="10" :offset="1">
                <div>
                  <el-form-item label="有効期間：" label-width="100px">
                    <el-date-picker
                      v-model="a0501Form.dateFrom"
                      placeholder="有効期間(自)"
                      type="date"
                      align="right"
                      style="width: 150px"
                    >
                    </el-date-picker>
                    -
                    <el-date-picker
                      v-model="a0501Form.dateTo"
                      placeholder="有効期間(至)"
                      type="date"
                      align="right"
                      style="width: 150px"
                    >
                    </el-date-picker>
                  </el-form-item>
                </div>
              </el-col>
            </el-row>

            <div class="a0501_button">
              <el-row type="flex" justify="center">
                <el-col :span="4">
                          <el-tooltip effect="light" content="条件クリア" placement="top">
                            <el-link @click="resetForm" type="primary" :underline="false">
                              <i class="el-icon-document-remove"></i>
                            </el-link>
                          </el-tooltip>
                        </el-col>
                        <el-col :span="4">
                          <el-tooltip effect="light" content="検索" placement="top">
                            <el-link @click="getAdData" type="primary" :underline="false">
                              <i class="el-icon-search"></i>
                            </el-link>
                          </el-tooltip>
                        </el-col>
                        <el-col :span="4">
                          <el-tooltip effect="light" content="戻る" placement="top">
                            <el-link @click="toLastPage" type="primary" :underline="false">
                              <i class="el-icon-back"></i>
                            </el-link>
                          </el-tooltip>
                        </el-col>
              </el-row>
            </div>
          </div>
          <div class="a0501_data">
            <el-row>
              <el-col class="ad-title" > 広告一覧 </el-col>
            </el-row>
            <div class="data_body">
                <template>
                  <el-table
                     ref="multipleTable"
                    :data="getAdList"
                    :default-sort="{ prop: 'a0501Date', order: 'descending' }"
                    @row-click="getRowData"
                    @row-dblclick="toA0502Modify"
                    tooltip-effect="dark"
                    @selection-change="selectionChange"
                    highlight-current-row
                    style="width: 100%">
                    <el-table-column type="expand">
                      <template slot-scope="props">
                        <el-form label-position="left" inline class="demo-table-expand">
                          <el-form-item label="レイアウトID">
                            <span>
                              {{ props.row.layoutId }}
                            </span>
                          </el-form-item>
                          <el-form-item label="レイアウト値段">
                            <span>
                              {{ props.row.layoutMoney }} 円
                            </span>
                          </el-form-item>
                          <el-form-item label="総額">
                            <span>
                              {{ props.row.sum }} 円
                            </span>
                          </el-form-item>
                          <el-form-item label="有効期間">
                            <span>
                              {{ props.row.dateFrom }} ~ {{ props.row.dateTo }}
                            </span>
                          </el-form-item>
                          <el-form-item label="日数">
                            <span>
                              {{ props.row.days }}
                            </span>
                          </el-form-item>
                          <el-form-item label="リンク">
                            <span>
                              {{ props.row.link }}
                            </span>
                          </el-form-item>
                        </el-form>
                      </template>
                    </el-table-column>
                    <el-table-column 
                    type="selection" 
                    fixed="left" 
                    />
                    <el-table-column
                      v-if="false"
                      prop="adId"
                      label="広告ID"
                      sortable
                    />
                    <el-table-column
                      prop="companyId"
                      label="会社ID"
                      v-if="false"
                    />
                    <el-table-column
                      label="レイアウトID"
                      prop="layoutId"
                      v-if="false">
                    </el-table-column>
                    <el-table-column
                      label="会社名"
                      prop="companyNm">
                    </el-table-column>
                    <el-table-column
                      label="オンライン状態"
                      prop="onlineFlg">
                      <template slot-scope="scope">
                       {{onlineFlg [scope.row.onlineFlg]}} 
                       </template>
                    </el-table-column>
                    <el-table-column
                      label="支払状態"
                      prop="chargeFlg">
                      <template slot-scope="scope">
                       {{chargeFlg [scope.row.chargeFlg]}} 
                       </template>
                    </el-table-column>
                    <el-table-column fixed="right" width="50">
                      <el-tooltip effect="light" content="改修画面へ" placement="top">
                        <el-button type="text" size="large" @click="toA0502Modify">
                        <em class="el-icon-edit" />
                        </el-button>
                      </el-tooltip>
                    </el-table-column>
                    <el-table-column fixed="right" width="50">
                      <el-tooltip effect="light" content="削除" placement="top">
                        <el-button type="text" size="large" @click="deleteOne">
                        <em class="el-icon-delete" />
                        </el-button>
                      </el-tooltip>
                    </el-table-column>
                  </el-table>
                </template>
            </div>
            <div>
              <el-row type="flex" justify="end">
                <el-col :span="1">
                  <el-tooltip effect="light" content="新規" placement="top">
                  <el-button
                    type="text"
                    size="large"
                    @click="toA0502"
                  >
                    <em class="el-icon-circle-plus-outline" />
                  </el-button>
                  </el-tooltip>
                </el-col>
                <el-col :span="1">
                  <el-tooltip effect="light" content="削除" placement="top">
                  <el-button 
                  type="text" 
                  size="large" 
                  @click="deleteMulti"
                  >
                    <em class="el-icon-delete" />
                  </el-button>
                  </el-tooltip>
                </el-col>
              </el-row>
            </div>
            <div class="page">
              <el-row type="flex" justify="space-around">
                <el-col :span="12">
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
                </el-col>
              </el-row>
            </div>
          </div>
        </el-main>
      </el-form>
      <el-footer>
        <div class="footer">
          <HomeFooter />
        </div>
      </el-footer>
    </el-container>
  </div>
</template>

<script lang="" scoped>
import ApplicantHeader from "@/views/components/ApplicantHeader";
import HomeFooter from "./components/HomeFooter";

export default {
  components: {
    ApplicantHeader,
    HomeFooter,
  },

  inject: ["reload"],

  data() {

    let checkLayoutId = (rule, value, callback) => {
      let reg = /^[0-9]*$/;
      if (!reg.test(value)) {
        callback(new Error("半角数字で入力してください。"));
      }
      callback();
    };

    return {
      // タイトルをクリック選択が非表示にする
      selectIsShow: true,
      // 複数チェックボックス
      multipleSelection: [],
      //検索条件
      a0501Form: {
        layoutId: "",
        onlineFlg: "",
        chargeFlg: "",
        dateFrom: "",
        dateTo: "",
      },
      // 状態リストのデータ
      onlineFlg: { 
        '0' : 'オフライン',
        '1' : 'オンライン',
        },
      chargeFlg: { 
        '0' : '支払未済',
        '1' : '支払済み',
        },
      // テーブルのデータ
      AdList: [],
      // ページネーション
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
      
      // 転送用form
      A0501VueForm: {
        userCd: Number,
        layoutId: Number,
        onlineFlg: "",
        chargeFlg: "",
        dateFrom: "",
        dateTo: "",
        adId: Number,
        adIds: [],
      },
      detailedForm: {
        adId: "",
        layoutId: "",
        layoutMoney: "",
        salary: "",
        companyId: "",
        companyNm: "",
        photo: "",
        link: "",
        dateFrom: "",
        dateTo: "",
        days: "",
        sum: "",
        onlineFlg: "",
        chargeFlg: "",
      },

      // 削除メッセージ内容
      approvalMessageDelete: {
        title: "削除",
        message: "本当に削除しますか？",
        yes: "はい",
        no: "いいえ",
        success: "削除が成功しました",
        failed: "削除が失敗しました、もう一度お願いします",
        cancel: "削除は取り消しされました",
      },

          
      rules: {
        layoutId: [{ validator: checkLayoutId, trigger: "blur" }],
      },

    };
  },

  //a0501初期
    mounted() {
      document.title = "広告一覧";
      this.getAdData();
    },

  computed: {
    getAdList() {
      return (
        this.AdList.slice(this.pagination.dataStart, this.pagination.dataEnd) || ""
      );
    },
  },


  methods: {
    // 戻るボタン
    toLastPage() {
      this.$router.replace({ path: "/a0003" });
    },

    //チェックボックス
    multiSelect(val) {
      this.multipleSelection = val;
    },

    // 多数選択をクリアする
    clearSelection() {
      this.$refs.multipleTable.clearSelection();
    },

    // クリアボタン
    resetForm() {
      this.a0501Form = {
        layoutId: "",
        onlineFlg: "",
        chargeFlg: "",
        dateFrom: "",
        dateTo: "",
      };
    },

    // 検索ボタンデータ取得
    getAdData() {
      this.setAdData();
      this.$store
        .dispatch("a0501Init", this.A0501VueForm)
        .then((response) => {
          this.$router.push({
            query: { data: response.data.data },
          });
          // テーブルデータを取得する
          this.AdList = response.data.data;
          // データ数を取得する
          this.pagination.total = this.AdList.length;
        });
    },

    // 検索条件の値を設定する
    setAdData() {
        this.A0501VueForm.layoutId = this.a0501Form.layoutId;
        this.A0501VueForm.onlineFlg = this.a0501Form.onlineFlg;
        this.A0501VueForm.chargeFlg = this.a0501Form.chargeFlg;
        this.A0501VueForm.dateFrom = new Date(this.a0501Form.dateFrom);
        this.A0501VueForm.dateTo = new Date(this.a0501Form.dateTo);
    },


    // 毎ページ行目数のselect
    sizeChange(val) {
      this.pagination.pageSize = val;
      this.dataFromTo();
    },

    // 当ページのボタン
    currentChange(val) {
      this.pagination.currentPage = val;
      this.dataFromTo();
    },

    // テーブル値行範囲の設定
    dataFromTo() {
      this.pagination.dataStart =
        (this.pagination.currentPage - 1) * this.pagination.pageSize;
      this.pagination.dataEnd =
        this.pagination.currentPage * this.pagination.pageSize;
    },

    // 選択され行目内容
    getRowData(row) {
      this.$refs.multipleTable.toggleRowSelection(row);
      this.detailedForm = row;
      this.A0501VueForm.adIds = new Array(row.adId);
    },

    //当行目データ削除
    deleteOne() {
      this.clearSelection();
      this.deleteMulti();
    },

    //複数データ削除
    deleteMulti() {
      this.A0501VueForm.adIds = this.multipleSelection;
      this.deleteMessageBox();
    },

    // 複数チェックボックス
    selectionChange(val) {
      this.multipleSelection = [];
      for (var i = 0; i < val.length; i++) {
        this.multipleSelection.push(val[i].adId);
      }
      this.A0501VueForm.adIds = this.multipleSelection;
    },

    // A0501delete確認ポップアップapprovalMessageErr
        deleteMessageBox() {
          this.approvalMessage = this.approvalMessageDelete;
          this.$confirm(this.approvalMessage.message, this.approvalMessage.title, {
            confirmButtonText: this.approvalMessage.yes,
            cancelButtonText: this.approvalMessage.no,
            type: "warning",
          })
          .then(() => {
            this.$store
              .dispatch("a0501Delete", this.A0501VueForm)
                .then((response) => {
                  this.$router.push({
                    query: { data: response.data.data },
                  });
                  // テーブルデータを取得する
                  this.AdList = response.data.data;
                  // データ数を取得する
                  this.pagination.total = this.AdList.length;
                  let code = response.data.code;
                  if (code == 200) {
                    this.$message({
                      type: "success",
                      message: this.approvalMessage.success,
                    });
                  }else {
                    this.$message({
                      type: "info",
                      message: this.approvalMessage.failed,
                    });
                  }
                });
          })
          .catch(() => {
            this.$message({
              type: "info",
              message: this.approvalMessage.cancel,
            });
          });
        },

    // 全選択ボタン
        toggleSelection(rows) {
          if (rows) {
            this.A0501VueForm.adIds = rows.adIds;
            rows.forEach((row) => {
              this.$refs.multipleTable.toggleRowSelection(row);
            });
          } else {
            this.A0501VueForm.adIds = [];
            this.clearSelection();
          }
        },

    // 新規画面へ
    toA0502() {
      this.$router.push({ path: "a0502" });
    },

    // 情報修正画面へ
    toA0502Modify() {
      setTimeout(() => {
        this.$router.push({
        path: "/a0502Modify",
        query: { flight: JSON.stringify(this.detailedForm) },
      });
    }, 1);
    },


  },
};
</script>


<style lang="scss" scoped>
.el-icon-back,
.el-icon-document-remove,
.el-icon-search
 {
  font-size: 30px;
}
</style>

<style>
/* 主体页面灰色 */
.a0501_body {
  background-color: #f6f6f6;
}
/* 两个主体部分边框阴影，白色背景 */
.a0501_select,
.a0501_data {
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);
  background-color: #ffffff;
}
/* 内容body、两个主体外边距 */
.a0501_body,
.a0501_data,
.data_select {
  margin: 1vh, 1vh, 0px, 0px;
}
/*研修一覧标题右移1% */
.a0501_title {
  margin-left: 1%;
}
/* 两部分主体宽80vw，居中 */
.a0501_select,
.a0501_data {
  width: 80vw;
  margin: auto;
}
/*行上下内边距填充1vh */
.el-row {
  padding-top: 1vh;
  padding-bottom: 1vh;
}
/*部分文字上下边距1vh，白底蓝字粗体 */
.a0501_title,
.blue_font {
  margin-top: 1vh;
  margin-bottom: 1vh;
  background-color: #ffffff;
  color: #006699;
  font-weight: 600;
  font-size: 15px;
}
/* 研修一覧字号20 */
.a0501_title {
  font-size: 20px;
}
 /* 灰色上边线，上内边距 */
.select_body {
  border-top: 2px solid#f6f6f6;
  padding-top: 2vh;
}
/* 检索按钮所在div内边距，底部外边距 */
.a0501_button {
  padding-top: 2vh;
  padding-bottom: 5vh;
  margin-bottom: 2vh;
  margin-left: 15vh;
}
/* 页眉页脚宽 */
.header,
.footer {
  width: 100vw auto;
}
/* 按钮本体 */
.a0501Button {
  width: 110px;
}
.ad-title {
  height: 2vw;
  font-size: 15px;
  margin-left: 1vw;
  font-weight: 600;
  color: #56b2e0;
}
.demo-table-expand {
  font-size: 0;
}
.demo-table-expand label {
  width: 120px;
  color: #99a9bf;
}
.demo-table-expand .el-form-item {
  margin-left: 5%;
  margin-right: 0;
  margin-bottom: 0;
  width: 40%;
}
/* テーブル内ボタン */ 
::v-deep .el-table .cell .em {
  padding: 0;
}
</style>
