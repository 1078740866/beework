<template>
  <div>
    <el-container>
      <el-header>
        <div class="header">
          <system-header />
        </div>
      </el-header>
      <el-main class="a0601_body">
        <div v-text="titleName" class="titleNameStyle" />
        <div class="a0601_data">
          <el-form
            :model="a0601Form"
            ref="a0601Form"
            label-position="right"
            autocomplete="on"
          >
            <div class="a0601_data">
              <div class="data_body">
                <el-row :gutter="1">
                  <el-col :span="8" :offset="2">
                    <el-form-item label="種類区分：" label-width="100px">
                      <el-select
                        v-model="a0601Form.typeSectionFlg"
                        placeholder="選択してください"
                        clearable
                      >
                        <el-option
                          v-for="item in typeSectionFlg"
                          :key="item.value"
                          :label="item.label"
                          :value="item.value"
                        />
                      </el-select>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8" :offset="2">
                    <el-form-item label="通報区分：" label-width="100px">
                      <el-select
                        v-model="a0601Form.reportSectionFlg"
                        placeholder="選択してください"
                        clearable
                      >
                        <el-option
                          v-for="item in reportSectionFlg"
                          :key="item.value"
                          :label="item.label"
                          :value="item.value"
                        />
                      </el-select>
                    </el-form-item>
                  </el-col>
                </el-row>
                <div class="a0601_button">
                  <el-row type="flex" justify="center">
                    <el-col :span="4">
                      <el-tooltip effect="light" content="条件クリア" placement="top">
                        <el-link @click="reset0601Form" type="primary" :underline="false">
                          <i class="el-icon-document-remove"></i>
                        </el-link>
                      </el-tooltip>
                    </el-col>
                    <el-col :span="4">
                      <el-tooltip effect="light" content="検索" placement="top">
                        <el-link @click="getReportData" type="primary" :underline="false">
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
                <el-table
                  ref="multipleTable"
                  :data="getReportList"
                  tooltip-effect="dark"
                  @row-click="getRowData"
                  @row-dblclick="toA0602"
                  @selection-change="selectionChange"
                  highlight-current-row
                >
                  <el-table-column type="expand">
                    <template slot-scope="props">
                      <el-form label-position="right" inline class="demo-table-expand">
                        <el-form-item
                          v-show="props.row.positionId ? true : false"
                          label="職位名："
                        >
                          <span>{{ props.row.positionNm }}</span>
                        </el-form-item>
                        <el-form-item
                          v-show="props.row.trainingId ? true : false"
                          label="研修会名："
                        >
                          <span>{{ props.row.trainingNm }}</span>
                        </el-form-item>
                        <el-form-item
                          v-show="props.row.briefingId ? true : false"
                          label="説明会名："
                        >
                          <span>{{ props.row.briefingNm }}</span>
                        </el-form-item>
                        <el-form-item label="通報時間：">
                          <span>{{ props.row.updateTime }}</span>
                        </el-form-item>
                      </el-form>
                    </template>
                  </el-table-column>
                  <el-table-column type="selection" fixed="left" @click="multiSelect" />
                  <el-table-column prop="reportSection" label="通報区分" sortable>
                    <template slot-scope="scope">
                      {{ reportSection[scope.row.reportSection] }}
                    </template>
                  </el-table-column>
                  <el-table-column prop="typeSection" label="種類区分" sortable>
                    <template slot-scope="scope">
                      {{ typeSection[scope.row.typeSection] }}
                    </template>
                  </el-table-column>
                  <el-table-column prop="whistleblower" label="通報者" sortable />
                  <el-table-column prop="whistleblowered" label="被通報者" sortable />
                  <el-table-column fixed="right" label="詳細" width="80">
                    <el-tooltip effect="light" content="詳細へ" placement="top">
                      <el-link @click="toA0602" type="primary" :underline="false">
                        <em class="el-icon-document" />
                      </el-link>
                    </el-tooltip>
                  </el-table-column>
                  <el-table-column fixed="right" label="通報成功" width="80">
                    <el-tooltip effect="light" content="通報成功" placement="top">
                      <el-link @click="toReportConfirm" type="primary" :underline="false">
                        <em class="el-icon-circle-check" />
                      </el-link>
                    </el-tooltip>
                  </el-table-column>
                  <el-table-column fixed="right" label="通報失敗" width="80">
                    <el-tooltip effect="light" content="通報失敗" placement="top">
                      <el-link @click="toReportDeny" type="primary" :underline="false">
                        <em class="el-icon-circle-close" />
                      </el-link>
                    </el-tooltip>
                  </el-table-column>
                </el-table>
              </div>
              <el-row type="flex" justify="end">
                <el-col :span="1" :offset="1">
                  <el-tooltip effect="light" content="複数成功" placement="top">
                    <el-link
                      @click="confirmReportMulti"
                      type="primary"
                      :underline="false"
                    >
                      <i class="el-icon-circle-check"></i>
                    </el-link>
                  </el-tooltip>
                </el-col>
                <el-col :span="1">
                  <el-tooltip effect="light" content="複数失敗" placement="top">
                    <el-link @click="denyReportMulti" type="primary" :underline="false">
                      <i class="el-icon-circle-close"></i>
                    </el-link>
                  </el-tooltip>
                </el-col>
              </el-row>
              <div class="page">
                <el-row type="flex" justify="space-around">
                  <el-col :span="12">
                    <el-pagination
                      :total="reportPage.total"
                      :current-page.sync="reportPage.currentPage"
                      :pager-count="reportPage.pagerCount"
                      :page-sizes="reportPage.pageSizes"
                      :page-size="reportPage.limit"
                      :background="true"
                      :layout="reportPage.layout"
                      @size-change="reportPageSizeChange"
                      @current-change="reportPageCurrentChange"
                    />
                  </el-col>
                </el-row>
              </div>
            </div>
          </el-form>
        </div>
      </el-main>
      <el-footer>
        <div class="footer">
          <HomeFooter />
        </div>
      </el-footer>
    </el-container>
  </div>
</template>

<script lang="" scoped>
import SystemHeader from "./components/SystemHeader";
import HomeFooter from "./components/HomeFooter";
export default {
  components: {
    SystemHeader,
    HomeFooter,
  },

  data() {
    return {
      // タイトル名
      titleName: "通報一覧",
      // 複数チェックボックス
      multipleSelection: [],
      // 種類区分
      typeSectionFlg: [
        { value: "0", label: "職位" },
        { value: "1", label: "研修" },
        { value: "2", label: "説明会" },
        { value: "3", label: "個人" },
      ],
      // 通報区分
      reportSectionFlg: [
        { value: "0", label: "応募者を通報" },
        { value: "1", label: "会社を通報" },
      ],
      typeSection: {
        0: "職位",
        1: "研修",
        2: "説明会",
        3: "個人",
      },
      reportSection: {
        0: "応募者を通報",
        1: "会社を通報",
      },
      //検索条件
      a0601Form: {
        typeSectionFlg: "",
        reportSectionFlg: "",
      },
      // 転送用form
      a0601VueForm: {
        typeSection: "",
        reportSection: "",
        statusFlg: "",
        reportId: Number,
        reportIds: [],
        //1ページ件数（Limit）
        limit: Number,
        //fromレコード（offset）
        offset: Number,
      },
      // 行目内容
      reportList: [],
      // ページネーション
      reportPage: {
        // テーブルのデータ
        reportList: "",
        // データ数
        total: 0,
        // table page from
        currentPage: 1,
        // データ数per page
        pageSizes: [10, 30, 50],
        // default データ数per page
        limit: 10,
        // 展示ページボタン数
        pagerCount: 5,
        // 順序
        layout: "total, sizes, prev, pager, next, jumper",
        // 当ページの最初の行
        dataStart: 0,
        //当ページの最後の行
        dataEnd: 10,
      },
      a0602Form: [],
      // 検索ボタン（0）か、改ページボタン(1)かを判断用
      pageFlg: Number,
      // 承認メッセージ内容
      approvalMessageSuc: {
        title: "承認",
        message: "本当に承認しますか？",
        yes: "はい",
        no: "いいえ",
        success: "承認が成功しました",
        failed: "承認が失敗しました、もう一度お願いします",
        cancel: "承認は取り消されました",
      },
      approvalMessageErr: {
        title: "拒否",
        message: "本当に拒否しますか？",
        yes: "はい",
        no: "いいえ",
        success: "拒否が成功しました",
        failed: "拒否が失敗しました、もう一度お願いします",
        cancel: "拒否は取り消しされました",
      },
    };
  },
  //a0601初期
  mounted() {
    // ページタイトルの切替
    document.title = this.titleName;
    this.getReportData();
  },
  //a0601
  computed: {
    getReportList() {
      return (
        this.reportList.slice(this.reportPage.dataStart, this.reportPage.dataEnd) || ""
      );
    },
  },

  methods: {
    // 戻るボタン
    toLastPage() {
      this.$router.push({
        path: "/a0003",
      });
    },
    //チェックボックス
    multiSelect(val) {
      this.multipleSelection = val;
    },
    // 多数選択をクリアする
    clearSelection() {
      this.$refs.multipleTable.clearSelection();
    },
    // a0601クリアボタン
    reset0601Form() {
      this.a0601Form = {
        typeSectionFlg: "",
        reportSectionFlg: "",
      };
    },
    // a0601検索と初期データ取得
    getReportData() {
      this.setReportData();
      this.$store.dispatch("a0601Init", this.a0601VueForm).then((response) => {
        this.$router.push({
          query: { data: response.data.data },
        });
        // テーブルデータを取得する
        this.reportList = response.data.data.bean;
        // データ数を取得する
        this.reportPage.total = parseInt(response.data.data.count);
        if (this.reportPage.total <= 10) {
          this.reportPage.dataStart = 0;
          this.reportPage.dataEnd = 10;
          this.reportPage.currentPage = 1;
        }
      });
    },
    // a0601検索条件の値を設定する
    setReportData() {
      this.a0601VueForm.typeSection = this.a0601Form.typeSectionFlg;
      this.a0601VueForm.reportSection = this.a0601Form.reportSectionFlg;
      this.a0601VueForm.limit = this.reportPage.limit;
      //改ページボタンの場合
      if (this.pageFlg == 1) {
        if (this.reportPage.currentPage == 1) {
          this.a0601VueForm.offset = 0;
        } else {
          this.a0601VueForm.offset =
            (this.reportPage.currentPage - 1) * this.reportPage.limit;
        }
     //検索ボタンの場合
      } else {
        this.reportPage.currentPage = 1;
        this.a0601VueForm.offset = 0;
      }
      this.pageFlg = 0;
    },

    // a0601毎ページ行目数のselect
    reportPageSizeChange(val) {
      this.reportPage.limit = val;
      this.pageFlg = 1;
      this.reportPage.dataStart =
        (this.reportPage.currentPage - 1) * this.reportPage.limit;
      this.reportPage.dataEnd = this.reportPage.currentPage * this.reportPage.limit;
      //バックエンドよりデータを取得
      this.getReportData();
    },
    // a0601当ページのボタン
    reportPageCurrentChange(val) {
      this.reportPage.currentPage = val;
      this.pageFlg = 1;
      //バックエンドよりデータを取得
      this.getReportData();
    },
    // a0601テーブル値行範囲の設定
    // reportPageDataFromTo() {
    //   this.reportPage.dataStart =
    //     (this.reportPage.currentPage - 1) * this.reportPage.limit;
    //   this.reportPage.dataEnd =
    //     this.reportPage.currentPage * this.reportPage.limit;
    // },
    // a0601行目ボタンのクリック
    getRowData(row) {
      this.a0602Form = row;
      this.$refs.multipleTable.toggleRowSelection(row);
    },
    // a0601当行目データ承认
    toReportConfirm() {
      this.clearSelection();
      this.confirmReportMulti();
    },
    // a0601当行目データ拒否
    toReportDeny() {
      this.clearSelection();
      this.denyReportMulti();
    },
    // a0601複数承認
    confirmReportMulti() {
      this.a0601VueForm.statusFlg = "1";
      this.a0601VueForm.reportIds = this.multipleSelection;
      this.reportConfirmMessageBox();
    },
    //a0601複数拒否
    denyReportMulti() {
      this.a0601VueForm.statusFlg = "2";
      this.a0601VueForm.reportIds = this.multipleSelection;
      this.reportConfirmMessageBox();
    },
    // a0601チェックボックス
    selectionChange(val) {
      this.multipleSelection = [];
      for (var a = 0; a < val.length; a++) {
        this.multipleSelection.push(val[a].reportId);
      }
      this.a0601VueForm.reportIds = this.multipleSelection;
    },
    // a0601承認確認ポップアップ
    reportConfirmMessageBox() {
      if (this.a0601VueForm.statusFlg == "1") {
        this.approvalMessage = this.approvalMessageSuc;
      } else {
        this.approvalMessage = this.approvalMessageErr;
      }
      this.$confirm(this.approvalMessage.message, this.approvalMessage.title, {
        confirmButtonText: this.approvalMessage.yes,
        cancelButtonText: this.approvalMessage.no,
        type: "warning",
      })
        .then(() => {
          this.$store.dispatch("a0601Confirm", this.a0601VueForm).then((response) => {
            this.$router.push({
              query: { data: response.data.data },
            });
            // テーブルデータを取得する
            this.reportList = response.data.data.bean;
            // データ数を取得する
            this.reportPage.total = parseInt(response.data.data.count);
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
    toA0602() {
      setTimeout(() => {
        this.$router.push({
          path: "/a0602",
          query: { flight: JSON.stringify(this.a0602Form) },
        });
      }, 1);
    },
  },
};
</script>

<style lang="scss" scoped>
// 主体页面灰色
.a0601_body {
  background-color: #f6f6f6;
}
/* 两个主体部分边框阴影，白色背景 */
.a0601_select,
.a0601_data {
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 0 rgba(0, 0, 0, 0.04);
  background-color: #ffffff;
}
// 内容body、两个主体外边距
.a0601_body,
.a0601_data,
.data_select {
  margin: 1vh, 1vh, 0px, 0px;
}
// 研修一覧标题右移1%
.a0601_title {
  margin-left: 1%;
  height: 80px;
}
// 两部分主体宽80vw，居中
.a0601_select,
.a0601_data {
  width: 80vw;
  margin: auto;
}
.titleNameStyle {
  color: #006699;
  font-weight: 600;
  font-size: 2em;
  margin-top: 1vh;
  border: 2px solid#dfdfdf;
  border-bottom: 0;
  border-radius: 5px;
  text-indent: 2vw;
  padding: 4vh 0vh;
  width: 80vw;
  margin: auto;
  background-color: #fff;
}
// 行上下内边距填充1vh
.el-row {
  padding-top: 1vh;
  padding-bottom: 1vh;
}
// 部分文字上下边距1vh，白底蓝字粗体
.a0601_title,
.blue_font {
  margin-top: 5vh;
  margin-bottom: 1vh;
  background-color: #ffffff;
  color: #006699;
  font-weight: 600;
}
// 字号30
.a0601_title {
  font-size: 30px;
}
// 灰色上边线，上内边距
.select_body {
  padding-top: 2vh;
}
// 检索按钮所在div内边距，底部外边距
.a0601_button {
  padding-top: 2vh;
  padding-bottom: 2vh;
  margin-bottom: 2vh;
}
// 页眉页脚宽
.header,
.footer {
  width: 100vw auto;
}
// 按钮本体
.a0601Button {
  width: 110px;
}
// saveアイコンの大きさ
.el-icon-circle-check,
.el-icon-circle-close,
.el-icon-document-remove,
.el-icon-back,
.el-icon-search,
.el-icon-document {
  font-size: 30px;
}
// TABSytle
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
.demo-table-expand {
  font-size: 0;
}
.demo-table-expand label {
  width: 80px;
  color: #99a9bf;
}
.demo-table-expand .el-form-item {
  margin-left: 5%;
  margin-right: 0;
  margin-bottom: 0;
  width: 40%;
}
// テーブル内ボタン
::v-deep .el-table .cell .em {
  padding: 0;
}
</style>
