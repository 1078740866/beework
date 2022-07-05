<template>
  <div class="pageStyle">
    <!-- <HomeHeader /> -->
    <div class="titleStyle">
      <div
        v-text="titleName"
        @click="selectIsShow = !selectIsShow"
        class="titleNameStyle"
      />
      <el-collapse-transition>
        <div v-show="selectIsShow" class="selectStyle">
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
              <el-col :span="11" :offset="1">
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
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="14" :offset="1">
                <el-form-item label="開始日時：" label-width="6em">
                  <el-date-picker
                    v-model="interviewSelectForm.interviewDate[0]"
                    type="datetime"
                    placeholder="開始日時"
                    value-format="yyyy-MM-dd HH:mm:ss"
                    class="rangeStyle"
                    :clearable="false"
                  />
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="14" :offset="1">
                <el-form-item label="終了日時：" label-width="6em">
                  <el-date-picker
                    v-model="interviewSelectForm.interviewDate[1]"
                    type="datetime"
                    placeholder="終了日時"
                    value-format="yyyy-MM-dd HH:mm:ss"
                    class="rangeStyle"
                    :clearable="false"
                  />
                </el-form-item>
              </el-col>
            </el-row>
          </el-form>
        </div>
      </el-collapse-transition>
      <div class="buttonStyle">
        <el-row type="flex" justify="center">
          <el-col :span="6" :offset="1">
            <el-button type="primary" @click="resetForm" class="buttonWidth">
              条件クリア
            </el-button>
          </el-col>
          <el-col :span="6" :offset="1">
            <el-button
              type="primary"
              @click="getData"
              icon="el-icon-search"
              class="buttonWidth"
            >
              検索
            </el-button>
          </el-col>
          <el-col :span="6" :offset="1">
            <el-button type="primary" @click="goBack" class="buttonWidth">
              戻る
            </el-button>
          </el-col>
        </el-row>
      </div>
    </div>
    <div class="bodyStyle">
      <div class="tableStyle">
        <el-table
          ref="multipleTable"
          :data="tableDataComputed"
          :default-sort="{ prop: 'interviewDate', order: 'descending' }"
          tooltip-effect="dark"
          height="350px"
          @row-click="getRowData"
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
          <el-table-column prop="name" label="応募者" width="100" />
          <el-table-column prop="statusFlg" label="面接状態" width="100" sortable>
            <template slot-scope="scope">
              {{ statusFlg[scope.row.statusFlg].label }}
            </template>
          </el-table-column>
          <el-table-column prop="tel" label="連絡先" width="150" sortable />
          <el-table-column prop="interviewAddress" label="面接地" width="200" />
          <el-table-column fixed="right" width="40">
            <el-button type="text" @click="showDialog">
              <em class="el-icon-document" />
            </el-button>
          </el-table-column>
          <el-table-column fixed="right" width="40">
            <el-button @click="deleteOne" type="text">
              <em class="el-icon-delete" />
            </el-button>
          </el-table-column>
        </el-table>
      </div>
      <el-row type="flex" justify="end">
        <el-col :span="1">
          <el-button type="text" @click="deleteMulti">
            <em class="el-icon-delete" />
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
    </div>
    <!-- <HomeFooter /> -->
  </div>
</template>
<script>
// import HomeHeader from "../components/HomeHeader";
// import HomeFooter from "../components/HomeFooter";
// import DetailedInfo from "../spComponents/DetailedInfo";
import '@/css/reset.css';
import '@/css/border.css';
//移动端 解决点击按钮闪和active失效的问题
document.body.addEventListener('touchstart' , function(){});
export default {
  name: "sp_b0401",
  components: {
    // HomeHeader,
    // HomeFooter,
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
      selectIsShow: true,
      // 面接種類
      interviewType: [
        { value: "0", label: "現場面接" },
        { value: "1", label: "テレビ面接" },
        { value: "2", label: "電話面接" },
      ],
      // 面接状態
      statusFlg: [
        { value: "0", label: "未処理" },
        { value: "1", label: "受け入れる" },
        { value: "2", label: "拒否する" },
      ],
      // item内容
      columeList: {
        interviewId: "面接ID",
        companyId: "会社ID",
        positionId: "応募者ID",
        applicantId: "職位ID",
        interviewType: "面接方式",
        positionNm: "職位名",
        firstName: "名",
        lastName: "姓",
        statusFlg: "面接状態",
        responsible: "担当",
        tel: "連絡先",
        interviewDate: "面接日",
        dateFrom: "開始時刻",
        dateTo: "終了時刻",
        interviewAddress: "面接地",
        remarks: "備考",
        photo: "写真",
      },
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
        title: "削除",
        message: "本当に削除しますか？",
        yes: "はい",
        no: "いいえ",
        success: "削除が成功しました",
        failed: "削除は取り消しされました",
      },
      // dialogの表示
      isShow: false,
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
    // テーブルデータ取得
    getData() {
      this.setData();
      this.$store.dispatch("b0401Search", this.B0401VueForm).then((response) => {
        this.$router.push({
          query: { data: response.data.data },
        });
        this.tableData = response.data.data;
        this.pagination.total = this.tableData.length;
      });
    },
    // 検索条件の値を設定する
    setData() {
      this.B0401VueForm.interviewType = this.interviewSelectForm.interviewType;
      this.B0401VueForm.statusFlg = this.interviewSelectForm.statusFlg;
      if (this.interviewSelectForm.interviewDate.length !== 0) {
        this.B0401VueForm.interviewDateFrom = new Date(
          this.interviewSelectForm.interviewDate[0].substring(0, 10)
        );
        this.B0401VueForm.interviewDateTo = new Date(
          this.interviewSelectForm.interviewDate[0].substring(11, 19)
        );
        this.B0401VueForm.dateFrom = this.interviewSelectForm.interviewDate[1].substring(
          0,
          10
        );
        this.B0401VueForm.dateTo = this.interviewSelectForm.interviewDate[1].substring(
          11,
          19
        );
      }
    },
    // 戻るボタン
    goBack() {
      history.go(-2);
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
      this.B0401VueForm.interviewIds = this.multipleSelection;
      console.log("interviewIds", this.B0401VueForm.interviewIds);
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
          path: "/sp/sp_b0402Detailed",
          query: { flight: JSON.stringify(this.rowData) },
        });
      }, 1);
    },
    // 選択内容データ削除
    deleteOne() {
      this.clearSelection();
      this.deleteMulti();
    },
    // 多数選択内容データ削除
    deleteMulti() {
      this.B0401VueForm.interviewIds = this.multipleSelection;
      this.confirmMessageBox(this.B0401VueForm.interviewIds);
    },

    // 削除確認ポップアップ
    confirmMessageBox() {
      this.$confirm(this.deleteMessage.message, this.deleteMessage.title, {
        confirmButtonText: this.deleteMessage.yes,
        cancelButtonText: this.deleteMessage.no,
        type: "warning",
      })
        .then(() => {
          this.$store.dispatch("b0401Delete", this.B0401VueForm).then((response) => {
            this.$router.push({
              query: { data: response.data.data },
            });
            // 業種リストを取得する
            this.industryCds = response.data.data.industryMstBean;
            // テーブルデータを取得する
            this.trainingList = response.data.data.trainingInfoTblBean;
            // データ数を取得する
            this.pagination.total = this.trainingList.length;
          });
          this.$message({
            type: "success",
            message: this.deleteMessage.success,
          });
          this.getData();
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: this.deleteMessage.failed,
          });
        });
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
  width: 90vw;
  margin-left: 5vw;
  margin-bottom: 2vh;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);
}
.rangeStyle {
  width: 100%;
}
// 画面标题 
.titleNameStyle {
  color: #006699;
  font-size: 32px;
  border-bottom: 2px solid#f6f6f6;
}
/* 
画面标题 
检索部分
按钮部分
分页部分
*/
.titleNameStyle,
.selectStyle,
.tableStyle,
.buttonStyle,
.paginationStyle {
  padding: 2vh;
}
// 检索条件三个button
.buttonWidth {
  -webkit-tap-highlight-color:transparent;
  width: 8em;
}
.el-date-editor--datetimerange.el-input, .el-date-editor--datetimerange.el-input__inner{
  width: 100%;
}
// 所有选择框
::v-deep div > .el-input--suffix .el-input__inner{
  -webkit-tap-highlight-color:transparent;
}
// 所有选择框箭头
::v-deep div > .el-input__suffix{
  -webkit-tap-highlight-color:transparent;
}
</style>
