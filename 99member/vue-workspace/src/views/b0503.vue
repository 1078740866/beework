<template>
  <el-container>
    <el-header>
      <HomeHeader />
    </el-header>
    <el-main class="mainStyle">
      <el-row class="blockStyle">
        <div @click="clickTitle">
          <el-row>
            <el-col v-text="pageContent.titleName" class="titleNameStyle" />
          </el-row>
        </div>
        <el-collapse-transition>
          <div v-show="pageContent.searchIsShow">
            <el-row>
              <el-col>
                <el-input
                  v-model="pageContent.inputText"
                  :placeholder="pageContent.inputPlaceholder"
                  size="large"
                  class="inputStyle"
                >
                  <el-button
                    slot="append"
                    icon="el-icon-search"
                    type="primary"
                    @click="clickSearchButton"
                    @keydown.enter="clickSearchButton"
                  />
                </el-input>
              </el-col>
            </el-row>
            <el-row>
              <el-col>
                <el-select
                  v-model="B0503VueForm.status"
                  placeholder="状態"
                  class="selectStyle"
                  @change="handleSelectChange"
                  clearable
                >
                  <el-option
                    v-for="item in pageContent.trainingStatus"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value"
                  />
                </el-select>
              </el-col>
            </el-row>
          </div>
        </el-collapse-transition>
        <div class="buttonAreaStyle">
          <el-row>
            <el-col :span="7" />
            <el-col :span="2">
              <el-tooltip
                effect="light"
                :content="pageContent.contentText[0]"
                placement="top-start"
                :open-delay="200"
              >
                <el-button
                  type="primary"
                  icon="el-icon-search"
                  @click="clickSearchButton"
                  class="buttonStyle"
                />
              </el-tooltip>
            </el-col>
            <el-col :span="2" :offset="6">
              <el-tooltip
                effect="light"
                :content="pageContent.contentText[1]"
                placement="top-start"
                :open-delay="200"
              >
                <el-button
                  type="primary"
                  icon="el-icon-refresh-left"
                  @click="goBack"
                  class="buttonStyle"
                />
              </el-tooltip>
            </el-col>
            <el-col :span="7" />
          </el-row>
        </div>
      </el-row>
      <el-row class="blockStyle">
        <el-row>
          <el-col>
            <el-table
              ref="multipleTable"
              :data="tableDataComputed"
              @selection-change="handleSelectionChange"
              @current-change="handleCurrentChange"
              @row-click="handleClickRow"
              height="380"
              highlight-current-row
            >
              <el-table-column type="selection" fixed="left" width="39" />
              <el-table-column label="姓名" width="150">
                <template v-slot="fullName">
                  {{ nameComputed(fullName.row) }}
                </template>
              </el-table-column>
              <el-table-column prop="birthday" label="年齢" width="100" sortable />
              <el-table-column prop="sex" label="性別" width="100" sortable>
                <template v-slot="applicantSex">
                  {{ sexComputed(applicantSex.row) }}
                </template>
              </el-table-column>
              <el-table-column prop="status" label="状態" width="100" sortable>
                <template v-slot="comStatus">
                  {{ comStatusComputed(comStatus.row) }}
                </template>
              </el-table-column>
              <el-table-column prop="userTel" label="連絡先" width="200" />
              <el-table-column label="最寄駅" width="150">
                <template v-slot="address">
                  {{ address.row.prefeNm }}
                  <br />
                  {{ addressComputed(address.row) }}
                </template>
              </el-table-column>
              <el-table-column label="卒業学校" width="200">
                <template v-slot="gradution">
                  {{ gradution.row.graduationSchool }}
                  <br />
                  {{ gradution.row.graduationMajor }}
                </template>
              </el-table-column>
              <el-table-column label="仕事状況" width="100" sortable>
                <template v-slot="workSituation">
                  {{ workSituationComputed(workSituation.row) }}
                </template>
              </el-table-column>
              <el-table-column fixed="right">
                <el-button type="text" @click="clickDocument">
                  <em class="el-icon-document" />
                </el-button>
              </el-table-column>
              <el-table-column fixed="right" width="33">
                <el-button type="text">
                  <em class="el-icon-delete" width="33" />
                </el-button>
              </el-table-column>
            </el-table>
          </el-col>
        </el-row>
        <el-row class="paginationStyle" type="flex" justify="center">
          <el-col :span="11">
            <el-pagination
              :total="pageContent.pagination.total"
              :current-page="pageContent.pagination.currentPage"
              :pager-count="pageContent.pagination.pagerCount"
              :page-sizes="pageContent.pagination.pageSizes"
              :page-size="pageContent.pagination.pageSize"
              :layout="paginationComputed"
              @size-change="handleSizeChange"
              @current-change="handlePageChange"
              background
            />
            <el-col :span="1" />
          </el-col>
        </el-row>
      </el-row>
    </el-main>
    <el-footer>
      <HomeFooter />
    </el-footer>
  </el-container>
</template>
<script>
import HomeHeader from "./components/HomeHeader";
import HomeFooter from "./components/HomeFooter";

export default {
  name: "b0503",
  components: {
    HomeHeader,
    HomeFooter,
  },

  data() {
    return {
      // 画面内のデータ
      pageContent: {
        // タイトル名
        titleName: "研修応募者管理",
        // インプットの提示内容
        inputPlaceholder: "名前を入力してください",
        // インプット欄の値
        inputText: "",
        // ブロック表示用
        searchIsShow: true,
        // テーブルデータのパラメータ
        tableData: [
          {
            companyId: "会社ID",
            trainingId: "説明会ID",
            applicantId: "応募者ID",
            userCd: "ユーザーコード",
            firstName: "姓",
            lastName: "名",
            birthday: "年齢",
            prefeNm: "都道府県",
            station: "最寄",
            sex: "0",
            graduationSchool: "卒業学校",
            graduationMajor: "専攻",
            userTel: "電話番号",
            workSituation: "0",
            status: "0",
          },
        ],
        // 性別
        sex: {
          0: "男",
          1: "女",
        },
        // 対応状態
        comStatus: {
          0: "未処理",
          1: "受け入れる",
          2: "拒否する",
        },
        // 仕事状況
        workSituations: {
          0: "応募中",
          1: "在職中",
        },
        contentText: {
          0: "検索する",
          1: "前のページへ戻る",
        },
        // 選択ランの処理状態
        trainingStatus: [
          { value: "0", label: "未処理" },
          { value: "1", label: "受け入れる" },
          { value: "2", label: "拒否する" },
        ],
        // 選択されるの行目データ
        currentRow: null,
        // 多数選択の行目データ
        multipleSelection: [],
        // ページネーションのデータ
        pagination: {
          // テーブルのデータ
          trainingList: "",
          // データ数
          total: 0,
          // デフォルトページ
          currentPage: 1,
          // 毎ページのデータ数
          pageSizes: [10, 30, 50],
          // 毎ページのデフォルトデータ数
          pageSize: 10,
          // 展示ページボタン数
          pagerCount: 5,
          // モジュールの順序
          layout: "total, sizes, prev, pager, next, jumper",
          // 当ページの最初の行
          dataStart: 0,
          //当ページの最後の行
          dataEnd: 10,
        },
      },
      // 転送用
      B0503VueForm: {
        userCd: "",
        companyId: Number,
        trainingId: Number,
        name: "",
        status: "",
        applicantId: [],
        statusFlg: "",
      },
    };
  },

  created() {
    // コンソールをクリアする
    console.clear();
    // タイトルを設定する
    document.title = this.pageContent.titleName;
  },

  mounted() {
    // 前のページからのcompanyIdとtrainingId
    console.log("training", JSON.parse(this.$route.query.flight));
    this.B0503VueForm.trainingId = JSON.parse(this.$route.query.flight).trainingId;
    this.B0503VueForm.companyId = JSON.parse(this.$route.query.flight).companyId;
    // テーブルデータ取得
    this.getData();
    // ブラウザのページジャンプ動作の監視を開始します
    this.browserGoBack(true);
  },

  destroyed() {
    // ブラウザのページジャンプ動作の監視を終了します
    this.browserGoBack(false);
  },

  // データの処理
  computed: {
    nameComputed() {
      return (row) => row.firstName + " " + row.lastName;
    },
    sexComputed() {
      return (row) => this.pageContent.sex[row.sex];
    },
    comStatusComputed() {
      return (row) => this.pageContent.comStatus[row.status];
    },
    workSituationComputed() {
      return (row) => this.pageContent.workSituations[row.workSituation];
    },
    addressComputed() {
      return (row) => row.station + "駅";
    },
    // 当ページの最初のデータが取得するデータの中の番目
    dataStartComputed() {
      return (
        (this.pageContent.pagination.currentPage - 1) *
        this.pageContent.pagination.pageSize
      );
    },
    // 当ページの最後のデータが取得するデータの中の番目
    dataEndComputed() {
      return (
        this.pageContent.pagination.currentPage * this.pageContent.pagination.pageSize
      );
    },
    // テーブルのデータ数を計算する
    dataLengthComputed() {
      return this.pageContent.tableData.length;
    },
    // テーブルデータのページネーション
    tableDataComputed() {
      return (
        this.pageContent.tableData.slice(
          this.pageContent.pagination.dataStart,
          this.pageContent.pagination.dataEnd
        ) || ""
      );
    },
    // ページネーションのモジュール表示用
    paginationComputed() {
      var nowPage = this.pageContent.pagination.currentPage;
      var firstPage = 1;
      // 数字切り上げ
      var lastPage = Math.ceil(
        this.pageContent.pagination.total / this.pageContent.pagination.pageSize
      );
      // ワンページだけの場合、一部分が不表示
      if (nowPage == firstPage && nowPage >= lastPage) {
        return "total, sizes, pager";
      }
      // 当ページは最初のページの場合、前のページが不表示
      if (nowPage == firstPage) return "total, sizes, pager, next, jumper";
      // 当ページは最後のページの場合、次のページが不表示
      if (nowPage == lastPage) return "total, sizes, prev, pager, jumper";
      // 全部表示の場合
      return "total, sizes, prev, pager, next, jumper";
    },
  },

  methods: {
    // タイトルをクリックする場合、サーチ欄が不表示します
    clickTitle() {
      this.pageContent.searchIsShow = !this.pageContent.searchIsShow;
      if (this.pageContent.searchIsShow) {
        console.log("show");
      } else {
        console.log("hide");
      }
    },
    // 検索ボタンをクリックする
    clickSearchButton() {
      this.setData();
      console.log("search", this.B0503VueForm);
      this.getData();
    },
    // ドキュメントアイコンをクリックする
    clickDocument() {
      // 選択クリア
      this.clearSelection();
      console.log("click document icon");
    },
    // ドキュメントアイコンをクリックする
    clickDelete() {
      // 選択クリア
      this.clearSelection();
      console.log("click delete icon");
    },
    // テーブルデータを取得する
    getData() {
      this.$store.dispatch("b0503Search", this.B0503VueForm).then((response) => {
        this.$router.push({
          query: { data: response.data.data },
        });
        this.pageContent.tableData = response.data.data;
        this.pageContent.pagination.total = this.dataLengthComputed;
        console.log("tableData", this.pageContent.tableData);
        console.log("total", this.pageContent.pagination.total);
      });
    },
    // 検索内容を設定する
    setData() {
      this.B0503VueForm.name = this.pageContent.inputText;
    },
    // 行目を切替の場合、行目データを表示する
    handleCurrentChange(val) {
      this.pageContent.currentRow = val;
      console.log("currentRow", this.pageContent.currentRow);
    },
    // チェックボックスをクリックする場合、多数選択の行目データを表示する
    handleSelectionChange(val) {
      this.pageContent.multipleSelection = val;
      console.log("multipleSelection", this.pageContent.multipleSelection);
    },
    // 行目をクリックする場合、チェックボックスを選択します
    handleClickRow(row) {
      this.$refs.multipleTable.toggleRowSelection(row);
    },
    // 多数選択をクリアする
    clearSelection() {
      this.$refs.multipleTable.clearSelection();
    },
    // 何件毎ページの選択
    handleSizeChange(val) {
      this.pageContent.pagination.pageSize = val;
      console.log("pageSize", this.pageContent.pagination.pageSize);
      this.pageContent.pagination.dataStart = this.dataStartComputed;
      this.pageContent.pagination.dataEnd = this.dataEndComputed;
    },
    // 当テーブルのページ数
    handlePageChange(val) {
      this.pageContent.pagination.currentPage = val;
      console.log("page", this.pageContent.pagination.currentPage);
      this.pageContent.pagination.dataStart = this.dataStartComputed;
      this.pageContent.pagination.dataEnd = this.dataEndComputed;
    },
    // 戻るボタン
    goBack() {
      history.go(-2);
    },
    // ブラウザの前のページに戻るボタンをページ内の戻るボタンと一致させるため
    browserGoBack(bool) {
      // 監視開始
      if (bool == true) window.addEventListener("popstate", this.goBack, false);
      // 監視終了
      else window.removeEventListener("popstate", this.goBack, false);
    },
    // セレクトを変更する
    handleSelectChange() {
      console.log("status", this.B0503VueForm.status);
    },
  },
};
</script>
<style lang="scss" scoped>
.mainStyle {
  background-color: #f6f6f6;
  margin: 0 0 1vh 0;
  padding: 1vh 0;
}
.blockStyle {
  background-color: #ffffff;
  width: 80vw;
  margin: 1vh 10vw;
  padding: 1vh 1vw;
  box-shadow: 0 2px 4px #0000000c, 0 0 6px #00000028;
}
.titleNameStyle {
  color: #006699;
  font-weight: 600;
  font-size: 2em;
  border-bottom: 2px solid#f6f6f6;
}
.inputStyle {
  width: 80%;
}
.inputStyle,
.selectStyle {
  margin: 2vh 10%;
}
.paginationRowStyle {
  width: 100%;
}
.buttonStyle {
  width: 10vw;
  width: 100px;
}
.titleNameStyle,
.paginationStyle,
.buttonAreaStyle {
  margin: 1vh 1vw;
  padding: 1vh 1vw;
}
// 空いているのel-rowプレースホルダー
.el-col {
  min-height: 1px;
}
// ページネーションのデータ数毎ページの幅
::v-deep .el-pagination .el-select .el-input {
  width: 2rem;
}
</style>
