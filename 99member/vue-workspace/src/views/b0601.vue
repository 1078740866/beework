<template>
  <div class="b0601_page">
    <el-container>
      <el-header>
        <div class="header">
          <HomeHeader />
        </div>
      </el-header>
      <el-form
        :model="b0601Form"
        ref="loginForm"
        label-position="left"
        autocomplete="on"
      >
        <el-main class="b0601_body">
          <div class="b0601_select">
            <el-row>
              <el-col :span="24">
                <div class="b0601_title">説明会一覧</div>
              </el-col>
            </el-row>
            <div class="select_body">
              <el-row :gutter="1">
                <el-col :span="6" :offset="1">
                  <div>
                    <el-form-item label="説明会方式：" label-width="100px">
                      <el-select
                        v-model="b0601Form.briefingType"
                        placeholder="選択してください"
                        clearable
                      >
                        <el-option
                          v-for="item in briefing_type"
                          :key="item.value"
                          :label="item.label"
                          :value="item.value"
                        />
                      </el-select>
                    </el-form-item>
                  </div>
                </el-col>
                <el-col :span="6" :offset="1">
                  <div>
                    <el-form-item label="説明会状態：" label-width="100px">
                      <el-select
                        v-model="b0601Form.statusFlg"
                        placeholder="選択してください"
                        clearable
                      >
                        <el-option
                          v-for="item in briefing_status"
                          :key="item.value"
                          :label="item.label"
                          :value="item.value"
                        />
                      </el-select>
                    </el-form-item>
                  </div>
                </el-col>
                <el-col :span="6" :offset="1">
                  <el-form-item label="説明会名前：" label-width="100px">
                    <el-input
                      v-model="b0601Form.briefingNm"
                      placeholder="説明会名前"
                    />
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row :gutter="1">
                <el-col :span="6" :offset="1">
                  <div>
                    <el-form-item label="説明会日：" label-width="100px">
                      <el-date-picker
                        v-model="b0601Form.briefingDate"
                        type="date"
                        placeholder="説明会日"
                        value-format="yyyy/MM/dd"
                        clearable
                      />
                    </el-form-item>
                  </div>
                </el-col>
                <el-col :span="6" :offset="1">
                  <div>
                    <el-form-item label="説明会時間：" label-width="110px">
                      <el-time-picker
                        is-range
                        v-model="b0601Form.date"
                        range-separator="-"
                        start-placeholder="開始時間"
                        end-placeholder="終了時間"
                        value-format="HH:mm:ss"
                        style="width: 280px"
                        clearable
                      />
                    </el-form-item>
                  </div>
                </el-col>
              </el-row>
              <div class="b0601_button">
                <el-row type="flex" justify="center">
                  <el-col :span="4">
                    <el-tooltip
                      effect="light"
                      content="条件クリア"
                      placement="top"
                    >
                      <el-link
                        @click="resetForm"
                        type="primary"
                        :underline="false"
                      >
                        <i class="el-icon-document-remove"></i>
                      </el-link>
                    </el-tooltip>
                  </el-col>
                  <el-col :span="4">
                    <el-tooltip effect="light" content="検索" placement="top">
                      <el-link
                        @click="getBriefingData"
                        type="primary"
                        :underline="false"
                      >
                        <i class="el-icon-search"></i>
                      </el-link>
                    </el-tooltip>
                  </el-col>
                  <el-col :span="4">
                    <el-tooltip effect="light" content="戻る" placement="top">
                      <el-link
                        @click="toLastPage"
                        type="primary"
                        :underline="false"
                      >
                        <i class="el-icon-back"></i>
                      </el-link>
                    </el-tooltip>
                  </el-col>
                </el-row>
              </div>
            </div>
          </div>

          <div class="b0601_data">
            <div class="data_body">
              <template>


                <el-table
                  ref="multipleTable"
                  :data="getBriefingList"
                  :default-sort="{ prop: 'b0601Date', order: 'descending' }"
                  @row-click="getRowData"
                  tooltip-effect="dark"
                  @selection-change="selectionChange"
                  highlight-current-row
                  style="width: 100%"
                >
                  <el-table-column type="expand">
                    <template slot-scope="props">
                      <el-form
                        label-position="left"
                        inline
                        class="demo-table-expand"
                      >
                        <el-form-item label="確認状態">
                          <span>
                            {{ statusFlg[props.row.statusFlg] }}
                          </span>
                        </el-form-item>
                        <el-form-item label="説明会方式">
                          <span>
                            {{ briefingType[props.row.briefingType] }}
                          </span>
                        </el-form-item>
                        <el-form-item label="説明会日付">
                          <span>
                            {{ props.row.briefingDate }}
                          </span>
                        </el-form-item>
                        <el-form-item label="説明会時間">
                          <span>
                            {{ props.row.dateFrom }} - {{ props.row.dateTo }}
                          </span>
                        </el-form-item>
                        <el-form-item label="予定人数">
                          <span> {{ props.row.proCntPlan }} 人 </span>
                        </el-form-item>
                        <el-form-item label="連絡先">
                          <span>
                            {{ props.row.tel }}
                          </span>
                        </el-form-item>
                        <el-form-item label="講師氏名">
                          <span>
                            {{ props.row.teaNm }}
                          </span>
                        </el-form-item>
                        <el-form-item label="担当">
                          <span>
                            {{ props.row.charge }}
                          </span>
                        </el-form-item>
                        <el-col>
                          <el-form-item label="説明会場所">
                            <span>
                              {{ props.row.briefingAddress1 }}
                            </span>
                          </el-form-item>
                        </el-col>
                        <el-col>
                          <el-form-item label="詳細場所" class="longText">
                            <span>
                              {{ props.row.briefingAddress2 }}
                            </span>
                          </el-form-item>
                        </el-col>
                        <el-col>
                          <el-form-item label="講師説明" class="longText">
                            <span>
                              {{ props.row.teaIntro }}
                            </span>
                          </el-form-item>
                        </el-col>
                        <el-form-item label="備考" class="longText">
                          <span>
                            {{ props.row.remarks }}
                          </span>
                        </el-form-item>
                      </el-form>
                    </template>
                  </el-table-column>
                  <el-table-column type="selection" fixed="left" />
                  <el-table-column
                    v-if="false"
                    prop="briefingId"
                    label="説明会ID"
                    sortable
                  />
                  <el-table-column label="説明会名" sortable prop="briefingNm">
                  </el-table-column>
                  <el-table-column
                    label="説明会日"
                    sortable
                    prop="briefingDate"
                  >
                  </el-table-column>
                  <el-table-column
                    prop="briefingAddress1"
                    sortable
                    label="説明会場所"
                  />
                  <el-table-column label="確認状態" sortable prop="statusFlg">
                    <template slot-scope="scope">
                      {{ statusFlg[scope.row.statusFlg] }}
                    </template>
                  </el-table-column>
                  <el-table-column fixed="right" width="50">
                    <el-tooltip
                      effect="light"
                      content="詳細情報へ"
                      placement="top"
                    >
                      <el-button
                        type="text"
                        size="large"
                        @click="toB0602Detailed"
                      >
                        <em class="el-icon-zoom-in" />
                      </el-button>
                    </el-tooltip>
                  </el-table-column>
                  <el-table-column fixed="right" width="50">
                    <el-tooltip
                      effect="light"
                      content="説明会応募者一覧へ"
                      placement="top"
                    >
                      <el-button type="text" size="large" @click="toB0603">
                        <em class="el-icon-user" />
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
                      @click="toB0602Registered"
                    >
                      <em class="el-icon-circle-plus-outline" />
                    </el-button>
                  </el-tooltip>
                </el-col>
                <el-col :span="1">
                  <el-tooltip effect="light" content="削除" placement="top">
                    <el-button type="text" size="large" @click="deleteMulti">
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

<script>
import HomeHeader from "./components/HomeHeader";
import HomeFooter from "./components/HomeFooter";

export default {
  name: "init",
  components: {
    HomeHeader,
    HomeFooter,
  },
  inject: ["reload"],
  data() {
    return {
      //檢索条件
      b0601Form: {
        companyId: Number,
        userCd: Number,
        briefingType: "",
        briefingDate: "",
        date: [],
        statusFlg: "",
        briefingId: Number,
        briefingIds: [],
        briefingNm: "",
      },
      // 状態リストのデータ
      briefing_type: [
        { value: "0", label: "現場" },
        { value: "1", label: "生放送" },
      ],
      briefing_status: [
        { value: "0", label: "未確認" },
        { value: "1", label: "確認済み" },
        { value: "2", label: "取り消し" },
      ],
      briefingType: {
        0: "現場",
        1: "生放送",
      },
      statusFlg: {
        0: "未確認",
        1: "確認済み",
        2: "取り消し",
      },
      // テーブルのデータ
      briefingList: [],
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
      // 複数チェックボックス
      multipleSelection: [],
      // 転送用form
      B0601VueForm: {
        companyId: Number,
        userCd: Number,
        briefingType: "",
        briefingDate: "",
        date: "",
        statusFlg: "",
        dateFrom: "",
        dateTo: "",
        briefingId: Number,
        briefingIds: [],
        briefingNm: "",
      },
      // 詳細情報form
      detailedForm: {
        briefingId: "",
        companyId: "",
        companyNm: "",
        briefingNm: "",
        briefingType: "",
        briefingDate: "",
        dateFrom: "",
        dateTo: "",
        postal: "",
        prefeNm: "",
        briefingAddress1: "",
        briefingAddress2: "",
        briefingContent: "",
        proCntPlan: "",
        teaNm: "",
        teaIntro: "",
        tel: "",
        charge: "",
        photoAddress1: "",
        photoAddress2: "",
        photoAddress3: "",
//20220705
        photoAddress1Pic:"",
        photoAddress2Pic:"",
        photoAddress3Pic:"",
//20220705 End
        remarks: "",
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
    };
  },
  mounted() {
    document.title = "説明会一覧";
    this.getBriefingData();
  },
  computed: {
    getBriefingList() {
      return (
        this.briefingList.slice(
          this.pagination.dataStart,
          this.pagination.dataEnd
        ) || ""
      );
    },
  },
  methods: {
    // 戻るボタン
    toLastPage() {
      console.log("戻る");
      this.$router.replace({ path: "/b0003" });
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
      this.b0601Form = {
        briefingType: "",
        briefingDate: "",
        date: [],
        statusFlg: "",
        briefingNm: "",
      };
    },

    // 検索ボタンデータ取得
    getBriefingData() {
      this.setBriefingData();
      this.$store
        .dispatch("b0601Search", this.B0601VueForm)
        .then((response) => {
          this.$router.push({
            query: { data: response.data.data },
          });
          // テーブルデータを取得する
          this.briefingList = response.data.data;
          // データ数を取得する
          this.pagination.total = this.briefingList.length;
        });
    },
    // 検索条件の値を設定する
    setBriefingData() {
      this.B0601VueForm.briefingType = this.b0601Form.briefingType;
      this.B0601VueForm.statusFlg = this.b0601Form.statusFlg;
      this.B0601VueForm.briefingDate = new Date(this.b0601Form.briefingDate);
      this.B0601VueForm.dateFrom = this.b0601Form.date[0];
      this.B0601VueForm.dateTo = this.b0601Form.date[1];
      this.B0601VueForm.briefingNm = this.b0601Form.briefingNm;
    },

    // 毎ページ行目数のselect
    sizeChange(val) {
      this.pagination.pageSize = val;
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
      this.pagination.dataEnd =
        this.pagination.currentPage * this.pagination.pageSize;
      console.log("dataStart", this.pagination.dataStart);
      console.log("dataEnd", this.pagination.dataEnd);
    },

    // 選択され行目内容
    getRowData(row) {
      this.$refs.multipleTable.toggleRowSelection(row);
      this.detailedForm = row;
//20220705
      if (this.detailedForm.photoAddress1Pic!==''){
          this.detailedForm.photoAdress1Pic="data:image/gif;base64," + 
          this.detailedForm.photoAddress1Pic
        }
      if (this.this.detailedForm.photoAddress2Pic!==''){
          this.detailedForm.photoAddress2Pic="data:image/gif;base64," + 
          this.detailedForm.photoAddress2Pic
          }
      if (this.this.detailedForm.photoAddress3Pic!==''){
          this.detailedForm.photoAddress3Pic="data:image/gif;base64," + 
          this.detailedForm.photoAddress3Pic
          }
//20220705 End
      this.B0601VueForm.briefingIds = new Array(row.briefingId);
      console.log("briefingIds", this.B0601VueForm.briefingIds);
    },

    //当行目データ削除
    deleteOne() {
      this.clearSelection();
      this.deleteMulti();
    },

    //複数データ削除
    deleteMulti() {
      this.B0601VueForm.briefingIds = this.multipleSelection;
      this.deleteMessageBox();
    },

    // 複数チェックボックス
    selectionChange(val) {
      this.multipleSelection = [];
      for (var i = 0; i < val.length; i++) {
        this.multipleSelection.push(val[i].briefingId);
      }
      this.B0601VueForm.briefingIds = this.multipleSelection;
    },

    // b0101削除確認ポップアップapprovalMessageErr
    deleteMessageBox() {
      this.approvalMessage = this.approvalMessageDelete;
      this.$confirm(this.approvalMessage.message, this.approvalMessage.title, {
        confirmButtonText: this.approvalMessage.yes,
        cancelButtonText: this.approvalMessage.no,
        type: "warning",
      })
        .then(() => {
          this.$store
            .dispatch("b0601Delete", this.B0601VueForm)
            .then((response) => {
              this.$router.push({
                query: { data: response.data.data },
              });
              // テーブルデータを取得する
              this.briefingList = response.data.data;
              // データ数を取得する
              this.pagination.total = this.briefingList.length;
              let code = response.data.code;
              if (code == 200) {
                this.$message({
                  type: "success",
                  message: this.approvalMessage.success,
                });
              } else {
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
        this.B0601VueForm.briefingIds = rows.briefingIds;
        rows.forEach((row) => {
          this.$refs.multipleTable.toggleRowSelection(row);
        });
      } else {
        this.B0601VueForm.briefingIds = [];
        this.$refs.multipleTable.clearSelection();
      }
    },

    // 新規画面へ
    toB0602Registered() {
      this.$router.push({ path: "b0602Registered" });
    },

    // 詳細情報画面へ
    toB0602Detailed() {
      console.log("detailed1", this.detailedForm);
      setTimeout(() => {
        this.$router.push({
          path: "/b0602Detailed",
          query: { flight: JSON.stringify(this.detailedForm) },
        });
      }, 1);
    },

    // 情報修正画面へ
    toB0602Modify() {
      console.log("detailed", this.detailedForm);
//20220705
      if (this.detailedForm.photoAddress1Pic!==''){
        this.detailedForm.photoAddress1Pic="data:image/gif;base64," + 
        this.detailedForm.photoAddress1Pic
        }
      if (this.detailedForm.photoAddress2Pic!==''){
        this.detailedForm.photoAddress2Pic="data:image/gif;base64," + 
        this.detailedForm.photoAddress2Pic
        }
      if (this.detailedForm.photoAddress3Pic!==''){
        this.detailedForm.photoAddress3Pic="data:image/gif;base64," + 
        this.detailedForm.photoAddress3Pic
        }
//20220705 End
      setTimeout(() => {
        this.$router.push({
          path: "/b0602Modify",
          query: { flight: JSON.stringify(this.detailedForm) },
        });
      }, 1);
    },

    // 说明会应募者画面へ
    toB0603() {
      console.log("detailed222", this.detailedForm);
      setTimeout(() => {
        this.$router.push({
          path: "/b0603",
          query: { briefingId: this.detailedForm.briefingId },
        });
      }, 1);
    },
  },
};
</script>

<style lang="scss" scoped>
.el-icon-back,
.el-icon-document-remove,
.el-icon-search {
  font-size: 30px;
}
</style>

<style>
/* 主体页面灰色， */
.b0601_body {
  background-color: #f6f6f6;
}
/* 两个主体部分边框阴影，白色背景 */
.b0601_select,
.b0601_data {
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);
  background-color: #ffffff;
}
/* 内容body、两个主体外边距 */
.b0601_body,
.b0601_data,
.data_select {
  margin: 1vh, 1vh, 0px, 0px;
}
/* 説明会一覧标题右移1% */
.b0601_title {
  margin-left: 1%;
}
/* 两部分主体宽80vw，居中 */
.b0601_select,
.b0601_data {
  width: 80vw;
  margin: auto;
}
/* 行上下内边距填充1vh */
.el-row {
  padding-top: 1vh;
  padding-bottom: 1vh;
}
/* 部分文字上下边距1vh，白底蓝字粗体 */
.b0601_title,
.blue_font {
  margin-top: 1vh;
  margin-bottom: 1vh;
  background-color: #ffffff;
  color: #006699;
  font-weight: 600;
}
/* 説明会一覧字号20 */
.b0601_title {
  font-size: 20px;
}
/* 灰色上边线，上内边距 */
.select_body {
  border-top: 2px solid#f6f6f6;
  padding-top: 2vh;
}
/* 检索按钮所在div内边距，底部外边距 */
.b0601_button {
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
/*按钮本体*/
.b0601Button {
  width: 110px;
}
.demo-table-expand {
  font-size: 0;
}
.demo-table-expand label {
  width: 100px;
  color: #99a9bf;
}
.demo-table-expand .el-form-item {
  margin-left: 5%;
  margin-right: 0;
  margin-bottom: 0;
  width: 40%;
}
.longText {
  width: 80% !important;
}
</style>
