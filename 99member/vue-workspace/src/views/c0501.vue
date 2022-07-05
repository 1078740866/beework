<template>
  <div class="pageStyle">
    <ApplicantHeader />
    <div class="titleStyle">
      <div v-text="titleName" class="titleNameStyle" />

      <div class="selectStyle">
        <el-form ref="loginForm">
          <el-row>
            <el-col :span="11" :offset="1">
              <el-form-item label="面接種類：" label-width="6em">
                <el-select
                  v-model="interviewSelectForm.interviewType"
                  placeholder="面接種類"
                  clearable
                >
                  <el-option
                    v-for="item in interviewType"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value"
                  />
                </el-select>
              </el-form-item>
            </el-col>
            <!-- <el-col :span="11" :offset="1">
              <el-form-item label="面接状態：" label-width="6em">
                <el-select
                  v-model="interviewSelectForm.statusFlg"
                  placeholder="面接状態"
                  clearable
                >
                  <el-option
                    v-for="item in statusFlg"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value"
                  />
                </el-select>
              </el-form-item>
            </el-col> -->
          </el-row>
          <el-row>
            <el-col :span="11" :offset="1">
              <el-form-item label="開始日付：" label-width="6em">
                <el-date-picker
                  v-model="interviewSelectForm.interviewDate[0]"
                  type="date"
                  placeholder="開始日付"
                  value-format="yyyy-MM-dd HH:mm:ss"
                  class="rangeStyle"
                />
              </el-form-item>
            </el-col>
            <el-col :span="11" :offset="1">
              <el-form-item label="終了日付：" label-width="6em">
                <el-date-picker
                  v-model="interviewSelectForm.interviewDate[1]"
                  type="date"
                  placeholder="終了日付"
                  value-format="yyyy-MM-dd HH:mm:ss"
                  class="rangeStyle"
                />
              </el-form-item>
            </el-col>
          </el-row>
        </el-form>
      </div>

      <div class="buttonStyle">
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
              <el-link @click="getKensakuData" type="primary" :underline="false">
                <i class="el-icon-search"></i>
              </el-link>
            </el-tooltip>
          </el-col>
          <el-col :span="4">
            <el-tooltip effect="light" content="戻る" placement="top">
              <el-link @click="goBack" type="primary" :underline="false">
                <i class="el-icon-back"></i>
              </el-link>
            </el-tooltip>
          </el-col>
        </el-row>
      </div>
    </div>
    <div class="bodyStyle">
      <el-tabs v-model="activeName" @tab-click="handleClick" type="card">
        <el-tab-pane label="未処理" name="first">
          <div class="tableStyle">
            <el-table
              ref="multipleTable"
              :data="tableDataComputed"
              :default-sort="{ prop: 'interviewDate', order: 'descending' }"
              tooltip-effect="dark"
              height="350px"
              @row-click="getRowData"
              @row-dblclick="showDialog"
              @selection-change="selectionChange"
              highlight-current-row
            >
              <el-table-column type="selection" fixed="left" width="40" />
              <el-table-column prop="positionNm" label="職位" width="100" />
              <el-table-column prop="interviewType" label="面接種類" width="100" sortable>
                <template v-slot="type">
                  {{ interviewType[type.row.interviewType].label }}
                </template>
              </el-table-column>
              <el-table-column prop="responsible" label="担当" width="100" />
              <el-table-column prop="interviewDate" label="面接日時" sortable width="150">
                <template v-slot="dateTime">
                  {{ dateTime.row.interviewDate }}
                  <br />
                  {{ timeComputed(dateTime.row) }}
                </template>
              </el-table-column>
              <!-- <el-table-column prop="name" label="応募者" width="100" /> -->
              <el-table-column prop="statusFlg" label="面接状態" width="100" sortable>
                <template slot-scope="scope">
                  {{ statusFlg[scope.row.statusFlg].label }}
                </template>
              </el-table-column>
              <el-table-column prop="tel" label="連絡先" width="150" sortable />
              <el-table-column prop="interviewAddress" label="面接地" />
              <el-table-column fixed="right" width="40">
                <el-button type="text" @click="showDialog">
                  <em class="el-icon-document" />
                </el-button>
              </el-table-column>
              <el-table-column fixed="right" width="40">
                <el-button @click="ukeireOne" type="text">
                  <em class="el-icon-check" />
                </el-button>
              </el-table-column>
              <el-table-column fixed="right" width="40">
                <el-button @click="deleteOne" type="text">
                  <em class="el-icon-close" />
                </el-button>
              </el-table-column>
            </el-table>
          </div>
          <el-row type="flex" justify="end" class="hanggao">
            <el-col :span="1">
              <el-button type="text" @click="ukeireMulti">
                <em class="el-icon-check" />
              </el-button>
            </el-col>
            <el-col :span="1">
              <el-button type="text" @click="deleteMulti">
                <em class="el-icon-close" />
              </el-button>
            </el-col>
          </el-row>
          <div class="paginationStyle">
            <el-row type="flex" justify="center">
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
        </el-tab-pane>
        <el-tab-pane label="処理済" name="second">
          <div class="tableStyle">
            <el-table
              ref="SyorizumiTable"
              :data="tableDataComputed"
              :default-sort="{ prop: 'interviewDate', order: 'descending' }"
              tooltip-effect="dark"
              height="350px"
              @row-click="getRowData"
              @row-dblclick="showDialog"
              highlight-current-row
            >
              <!-- <el-table-column type="selection" fixed="left" width="40" /> -->
              <el-table-column prop="positionNm" label="職位" width="100" />
              <el-table-column prop="interviewType" label="面接種類" width="100" sortable>
                <template v-slot="type">
                  {{ interviewType[type.row.interviewType].label }}
                </template>
              </el-table-column>
              <el-table-column prop="responsible" label="担当" width="100" />
              <el-table-column prop="interviewDate" label="面接日時" sortable width="150">
                <template v-slot="dateTime">
                  {{ dateTime.row.interviewDate }}
                  <br />
                  {{ timeComputed(dateTime.row) }}
                </template>
              </el-table-column>
              <!-- <el-table-column prop="name" label="応募者" width="100" /> -->
              <el-table-column prop="statusFlg" label="面接状態" width="100" sortable>
                <template slot-scope="scope">
                  {{ statusFlg[scope.row.statusFlg].label }}
                </template>
              </el-table-column>
              <el-table-column prop="tel" label="連絡先" width="150" sortable />
              <el-table-column prop="interviewAddress" label="面接地" />
              <el-table-column fixed="right" width="40">
                <el-button type="text" @click="showDialog">
                  <em class="el-icon-document" />
                </el-button>
              </el-table-column>
              <!-- <el-table-column fixed="right" width="40">
                <el-button @click="ukeireOne" type="text">
                  <em class="el-icon-check" />
                </el-button>
              </el-table-column>
              <el-table-column fixed="right" width="40">
                <el-button @click="deleteOne" type="text">
                  <em class="el-icon-close" />
                </el-button>
              </el-table-column> -->
            </el-table>
          </div>
          <el-row class="hanggao"></el-row>
          <div class="paginationStyle">
            <el-row type="flex" justify="center">
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
        </el-tab-pane>
        <!-- <el-dialog title="詳細情報" :visible.sync="isShow" :append-to-body="true">
        <el-row>
          <el-col :span="9" :offset="1">
            <el-row v-for="(key, i) in columeList" :key="`A-${i}`" class="dialogStyle">
              {{ key }}:
            </el-row>
          </el-col>
          <el-col :span="14">
            <el-row v-for="(value, i) in rowData" :key="`B-${i}`" class="dialogStyle">
              {{ value }}
            </el-row>
          </el-col>
        </el-row>
      </el-dialog> -->
      </el-tabs>
    </div>
    <HomeFooter />
  </div>
</template>
<script>
import ApplicantHeader from "@/views/components/ApplicantHeader";
import HomeFooter from "./components/HomeFooter";
export default {
  name: "c0501",
  components: {
    ApplicantHeader,
    HomeFooter,
  },
  mounted() {
    // ページタイトルの切替
    document.title = this.titleName;
    this.getData();
    // ページジャンプ動作の監視を開始します
    window.addEventListener("popstate", this.goBack, false);
  },
  destroyed() {
    // ページジャンプ動作の監視を終了します
    window.removeEventListener("popstate", this.goBack, false);
  },
  data() {
    return {
      // タイトル名
      titleName: "面接一覧",
      // タイトルをクリック選択が非表示にする

      // 面接種類
      interviewType: [
        { value: "0", label: "現場面接" },
        { value: "1", label: "テレビ面接" },
        { value: "2", label: "電話面接" },
      ],
      // 面接状態
      statusFlg: [
        { value: "0", label: "未処理" },
        { value: "1", label: "受けた" },
        { value: "2", label: "拒否" },
      ],
      // // item内容
      // columeList: {
      //   interviewId: "面接ID",
      //   companyId: "会社ID",
      //   positionId: "応募者ID",
      //   applicantId: "職位ID",
      //   interviewType: "面接方式",
      //   positionNm: "職位名",
      //   firstName: "名",
      //   lastName: "姓",
      //   statusFlg: "面接状態",
      //   responsible: "担当",
      //   tel: "連絡先",
      //   interviewDate: "面接日",
      //   dateFrom: "開始時刻",
      //   dateTo: "終了時刻",
      //   interviewAddress: "面接地",
      //   remarks: "備考",
      //   photo: "写真",
      // },
      // 選択内容
      interviewSelectForm: {
        interviewType: "",
        interviewDate: [],
        statusFlg: "",
      },
      // ページネーション
      pagination: {
        // テーブルのデータ
        trainingList: "",
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
      B0401VueForm: {
        userCd: Number,
        companyId: Number,
        interviewType: "",
        interviewDateFrom: "",
        interviewDateTo: "",
        dateFrom: "",
        dateTo: "",
        statusFlg: "",
        interviewId: Number,
        interviewIds: [],
      },
      // 行目内容
      rowData: {
        applicantId: "",
        companyId: "",
        dateFrom: "",
        dateTo: "",
        name: "",
        interviewAddress: "",
        interviewDate: "",
        interviewId: "",
        interviewType: "",
        photo: "",
        positionId: "",
        positionNm: "",
        remarks: "",
        responsible: "",
        statusFlg: "",
        tel: "",
      },
      // テーブル内容
      tableData: [],
      // 削除メッセージ内容
      deleteMessage: {
        title: "拒否",
        message: "本当に拒否しますか？",
        yes: "はい",
        no: "いいえ",
        success: "拒否しました",
        failed: "拒否は取り消しされました",
      },

      ukeireMessage: {
        title: "受け入れ",
        message: "本当に受け入れますか？",
        yes: "はい",
        no: "いいえ",
        success: "受け入れました",
        failed: "受け入れは取り消しされました",
      },
      // dialogの表示
      isShow: false,
      activeName: "first",
    };
  },
  computed: {
    tableDataComputed() {
      return (
        this.tableData.slice(this.pagination.dataStart, this.pagination.dataEnd) || ""
      );
    },
    timeComputed() {
      return (row) => row.dateFrom + " - " + row.dateTo;
    },
  },
  methods: {
    // クリアボタン
    resetForm() {
      this.interviewSelectForm = {
        interviewType: "",
        interviewDate: [],
        statusFlg: "",
      };
    },
    resetVueForm() {
      this.B0401VueForm = {
        userCd: Number,
        companyId: Number,
        interviewType: "",
        interviewDateFrom: null,
        interviewDateTo: null,
        dateFrom: "",
        dateTo: "",
        statusFlg: "",
        interviewId: Number,
        interviewIds: [],
      };
    },
    // テーブルデータ取得
    getData() {
      this.setData();
      this.$store.dispatch("c0501select", this.B0401VueForm).then((response) => {
        // this.$router.push({
        //   query: { data: response.data.data },
        // });
        if (response.data.data != null) {
          this.tableData = response.data.data;
          this.pagination.total = this.tableData.length;
        } else {
          this.tableData = [];
          this.pagination.total = this.tableData.length;
        }
      });
    },

    getSyoriData() {
      this.resetVueForm();
      // this.setData();
      this.$store.dispatch("c0501selectInfo", this.B0401VueForm).then((response) => {
        // this.$router.push({
        //   query: { data: response.data.data },
        // });
        if (response.data.data != null) {
          this.tableData = response.data.data;
          this.pagination.total = this.tableData.length;
        } else {
          this.tableData = [];
          this.pagination.total = this.tableData.length;
        }
      });
    },
    getKensakuData() {
      this.getData();
      this.activeName = "first";
      this.pagination.currentPage = 1;
      this.dataFromTo();
      this.multipleSelection = [];
    },
    // 検索条件の値を設定する
    setData() {
      this.B0401VueForm.interviewType = this.interviewSelectForm.interviewType;
      // this.B0401VueForm.statusFlg = this.interviewSelectForm.statusFlg;
      // if (this.interviewSelectForm.interviewDate.length != 0) {
      if (this.interviewSelectForm.interviewDate[0] != null) {
        this.B0401VueForm.interviewDateFrom = new Date(
          this.interviewSelectForm.interviewDate[0].substring(0, 10)
        );
        this.B0401VueForm.dateFrom = this.interviewSelectForm.interviewDate[0].substring(
          11,
          19
        );
      } else {
        this.B0401VueForm.interviewDateFrom = null;
        this.B0401VueForm.dateFrom = null;
      }

      if (this.interviewSelectForm.interviewDate[1] != null) {
        this.B0401VueForm.interviewDateTo = new Date(
          this.interviewSelectForm.interviewDate[1].substring(0, 10)
        );
        this.B0401VueForm.dateTo = this.interviewSelectForm.interviewDate[1].substring(
          11,
          19
        );
      } else {
        this.B0401VueForm.interviewDateTo = null;
        this.B0401VueForm.dateTo = null;
      }
      // }
    },
    // 戻るボタン
    goBack() {
      // history.go(-2);
      this.$router.push({
        path: "/c0003",
      });
    },
    // 毎ページ行目数のselect
    sizeChange(val) {
      this.pagination.pageSize = val;
      this.dataFromTo();
      this.multipleSelection = [];
    },
    // 当ページのボタン
    currentChange(val) {
      this.pagination.currentPage = val;
      this.dataFromTo();
      this.multipleSelection = [];
    },
    // テーブル値行範囲の設定
    dataFromTo() {
      this.pagination.dataStart =
        (this.pagination.currentPage - 1) * this.pagination.pageSize;
      this.pagination.dataEnd = this.pagination.currentPage * this.pagination.pageSize;
    },
    // 行目ボタンのクリック
    getRowData(row) {
      this.$refs.multipleTable.toggleRowSelection(row);
      this.rowData = row;
      this.B0401VueForm.interviewId = row.interviewId;
      console.log("interviewId", this.B0401VueForm.interviewId);
    },
    // チェックボックス
    selectionChange(val) {
      this.multipleSelection = [];
      for (var i = 0; i < val.length; i++) {
        this.multipleSelection.push(val[i].interviewId);
      }
      // this.B0401VueForm.interviewIds = this.multipleSelection;
      // console.log("interviewIds", this.B0401VueForm.interviewIds);
    },

    // 多数選択をクリアする
    clearSelection() {
      this.$refs.multipleTable.clearSelection();
    },
    // dialogの表示
    showDialog() {
      // this.clearSelection();
      // this.getRowData(row);
      // this.isShow = true;
      setTimeout(() => {
        this.$router.push({
          path: "/c0502",
          query: { flight: JSON.stringify(this.rowData) },
        });
      }, 1);
    },
    // 選択内容データ削除
    deleteOne() {
      this.clearSelection();
      this.multipleSelection = [];
      this.multipleSelection.push(this.rowData.interviewId);

      this.deleteMulti();
    },

    ukeireOne() {
      this.clearSelection();
      this.multipleSelection = [];
      this.multipleSelection.push(this.rowData.interviewId);

      this.ukeireMulti();
    },

    // 多数選択内容データ削除
    deleteMulti() {
      this.B0401VueForm.interviewIds = this.multipleSelection;
      if (this.B0401VueForm.interviewIds.length > 0) {
        this.B0401VueForm.statusFlg = "2";
        this.confirmMessageBox();
      } else {
        this.$message.error("選択項目がございません。");
      }
    },

    ukeireMulti() {
      this.B0401VueForm.interviewIds = this.multipleSelection;
      if (this.B0401VueForm.interviewIds.length > 0) {
        this.B0401VueForm.statusFlg = "1";
        this.confirmMessageBox2();
      } else {
        this.$message.error("選択項目がございません。");
      }
    },

    // 削除確認ポップアップ
    confirmMessageBox() {
      this.$confirm(this.deleteMessage.message, this.deleteMessage.title, {
        confirmButtonText: this.deleteMessage.yes,
        cancelButtonText: this.deleteMessage.no,
        type: "warning",
      })
        .then(() => {
          this.$store.dispatch("c0501flgChange", this.B0401VueForm).then((response) => {
            let code = response.data.code;
            if (code == 200) {
              this.$message({
                type: "success",
                message: this.deleteMessage.success,
              });
              this.getData();
              this.pagination.currentPage = 1;
              this.dataFromTo();
            } else {
              this.$message.error("更新失敗。");
            }
            // this.$router.push({
            //   query: { data: response.data.data },
            // });
            // 業種リストを取得する
            // this.industryCds = response.data.data.industryMstBean;
            // テーブルデータを取得する
            // this.trainingList = response.data.data.trainingInfoTblBean;
            // データ数を取得する
            // this.pagination.total = this.trainingList.length;
          });
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: this.deleteMessage.failed,
          });
        });
    },

    confirmMessageBox2() {
      this.$confirm(this.ukeireMessage.message, this.ukeireMessage.title, {
        confirmButtonText: this.ukeireMessage.yes,
        cancelButtonText: this.ukeireMessage.no,
        type: "warning",
      })
        .then(() => {
          this.$store.dispatch("c0501flgChange", this.B0401VueForm).then((response) => {
            let code = response.data.code;
            if (code == 200) {
              this.$message({
                type: "success",
                message: this.ukeireMessage.success,
              });
              this.getData();
              this.pagination.currentPage = 1;
              this.dataFromTo();
            } else {
              this.$message.error("更新失敗。");
            }
            // this.$router.push({
            //   query: { data: response.data.data },
            // });
            // 業種リストを取得する
            // this.industryCds = response.data.data.industryMstBean;
            // テーブルデータを取得する
            // this.trainingList = response.data.data.trainingInfoTblBean;
            // データ数を取得する
            // this.pagination.total = this.trainingList.length;
          });
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: this.ukeireMessage.failed,
          });
        });
    },

    handleClick() {
      this.multipleSelection = [];
      if (this.activeName == "second") {
        this.getSyoriData();
        this.pagination.currentPage = 1;
        this.dataFromTo();
      }
      if (this.activeName == "first") {
        this.getData();
        this.pagination.currentPage = 1;
        this.dataFromTo();
      }
    },
  },
};
</script>
<style lang="scss" scoped>
.pageStyle {
  background-color: #f6f6f6;
}
.titleStyle,
.bodyStyle {
  background-color: #ffffff;
  width: 80vw;
  //margin-left: 10vw;
  //margin-bottom: 2vh;
  //box-shadow: 0 2px 4px #0000000c, 0 0 6px #00000028;
  margin: auto;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);

}
.titleNameStyle {
  color: #006699;
  font-weight: 600;
  font-size: 2em;
  margin-top: 1vh;
  border-bottom: 2px solid#f6f6f6;
}
.titleNameStyle,
.selectStyle,
.tableStyle,
.paginationStyle {
  padding: 4vh;
}

.buttonStyle{
  padding-top: 2vh;
  padding-bottom: 3vh;
  margin-bottom: 2vh;
}
.buttonWidth {
  width: 8em;
}
.dialogStyle {
  margin: 10px;
  font-size: 12px;
}
.rangeStyle {
  width: 100%;
  max-width: 220px;
}
.hanggao {
  height: 60px;
}
::v-deep .el-tabs {
  background-color: #fff;
  font-size: 18px;
  .el-tabs__header {
    .el-tabs__nav-wrap {
      .el-tabs__nav-scroll {
        .el-tabs__nav {
          .el-tabs__item {
            font-size: 18px;
            font-family: "微软雅黑";
            font-weight: 600;
            width: 200px;
            text-align: center;
            height: 50px;
            line-height: 50px;
            color: #b8b8b8;
            padding: 0px;
          }
          .el-tabs__active-bar {
            height: 0;
          }
          .el-tabs__item.is-active {
            color: #409eff;
          }
        }
      }
    }
  }
}
</style>
<style lang="scss" scoped>
.el-icon-back,
.el-icon-document-remove,
.el-icon-search {
  font-size: 30px;
}
</style>