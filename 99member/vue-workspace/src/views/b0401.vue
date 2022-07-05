<template>
  <div class="pageStyle">
    <HomeHeader />
    <div class="titleStyle">
      <div
        v-text="titleName"
        class="titleNameStyle"
      />
      <el-collapse-transition>
        <div class="selectStyle">
          <el-form ref="loginForm">
            <el-row>
              <el-col :span="10" :offset="2">
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
              <el-col :span="10" :offset="2">
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
              <el-col :span="20" :offset="2">
                <el-form-item label="面接日付：" label-width="6em">
                  <el-date-picker
                    v-model="interviewSelectForm.interviewDate1"
                    placeholder="開始日付"
                    value-format="yyyy/MM/dd"
                    class="rangeStyle"
                    align="right"
                    type="date"
                  />
                  <label> ~ </label>
                  <el-date-picker
                    v-model="interviewSelectForm.interviewDate2"
                    placeholder="終了日付"
                    value-format="yyyy/MM/dd"
                    class="rangeStyle"
                    align="right"
                    type="date"
                  />
                </el-form-item>
              </el-col>
            </el-row>
          </el-form>
        </div>
      </el-collapse-transition>
      <div class="buttonStyle">
        <el-row type="flex" justify="center">
          <el-col :span="4" :offset="3">
            <el-tooltip effect="light" content="条件クリア" placement="top">
              <el-link @click="resetForm" type="primary" :underline="false">
                <i class="el-icon-document-remove"></i>
              </el-link>
            </el-tooltip>
          </el-col>
          <el-col :span="4" :offset="3">
            <el-tooltip effect="light" content="検索" placement="top">
              <el-link @click="getData" type="primary" :underline="false">
                <i class="el-icon-search"></i>
              </el-link>
            </el-tooltip>
          </el-col>
          <el-col :span="4" :offset="3">
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
          <el-table-column type="expand">
            <template slot-scope="props">
              <el-form label-position="right" inline class="demo-table-expand">
                <el-form-item label="担当：">
                  <span>{{ props.row.responsible }}</span>
                </el-form-item>
                <el-form-item label="連絡先：">
                  <span>{{ props.row.tel }}</span>
                </el-form-item>
                <el-form-item label="面接地：">
                  <span>{{ props.row.interviewAddress }}</span>
                </el-form-item>
              </el-form>
            </template>
          </el-table-column>
          <el-table-column type="selection" fixed="left" />
          <el-table-column prop="positionNm" label="職位" sortable/>
          <el-table-column prop="interviewType" label="面接種類" sortable>
            <template v-slot="type">
              {{ interviewType[type.row.interviewType].label }}
            </template>
          </el-table-column>
          <el-table-column prop="interviewDate" label="面接日時" sortable>
            <template v-slot="dateTime">
              {{ dateTime.row.interviewDate }}
              <br />
              {{ timeComputed(dateTime.row) }}
            </template>
          </el-table-column>
          <el-table-column prop="name" label="応募者" sortable/>
          <el-table-column prop="statusFlg" label="面接状態" sortable>
            <template slot-scope="scope">
              {{ statusFlg[scope.row.statusFlg].label }}
            </template>
          </el-table-column>
          <el-table-column fixed="right" label="詳細" min-width="50%">
            <el-tooltip effect="light" content="詳細" placement="top">
              <el-link @click="showDialog" type="primary" :underline="false">
                <i class="el-icon-document"></i>
              </el-link>
            </el-tooltip>
          </el-table-column>
           <el-table-column fixed="right" label="削除" min-width="50%">
            <el-tooltip effect="light" content="削除" placement="top">
              <el-link @click="deleteOne" type="primary" :underline="false">
                <i class="el-icon-delete"></i>
              </el-link>
            </el-tooltip>
          </el-table-column>
        </el-table>
      </div>
      <el-row type="flex" justify="end">
        <el-col :span="1">
          <el-tooltip effect="light" content="複数削除" placement="top">
            <el-link @click="deleteMulti" type="primary" :underline="false">
              <i class="el-icon-delete"></i>
            </el-link>
          </el-tooltip>
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
    <HomeFooter />
  </div>
</template>
<script>
import HomeHeader from "./components/HomeHeader";
import HomeFooter from "./components/HomeFooter";
export default {
  name: "b0401",
  components: {
    HomeHeader,
    HomeFooter,
  },
  mounted() {
    // ページタイトルの切替
    document.title = this.titleName;
    this.interviewSelectForm.interviewDate1 = this.timeDefault;
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
        interviewDate1: "",
        interviewDate2: "",
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
      date:new Date(),
    };
  },
  computed: {
    tableDataComputed() {
      return (
        this.tableData.slice(this.pagination.dataStart, this.pagination.dataEnd) || ""
      );
    },
    timeComputed() {
      return (row) => row.dateFrom + "-" + row.dateTo;
    },
    timeDefault() {
      let date = new Date();
      let year = date.getFullYear();
      /* 在日期格式中，月份是从0开始的，因此要加0
      * 使用三元表达式在小于10的前面加0，以达到格式统一  如 09:11:05
      * */
      let month = date.getMonth()+1<10 ? "0"+(date.getMonth()+1) : date.getMonth()+1;
      let day = date.getDate()<10 ? "0"+date.getDate() : date.getDate();
      return year + "/" + month + "/" + day;
    }
  },
  //elementUiが日付範囲を選択すると、セレクターはv-modelの値をnullにクリアするので、
  //watchを追加、このv-modelを動的に監視する
  watch: {
    "interviewSelectForm.interviewDate1"(newVal) {
      if (newVal == null) {
        this.interviewSelectForm.interviewDate1 = '';
      }
    },
    "interviewSelectForm.interviewDate2"(newVal) {
      if (newVal == null) {
        this.interviewSelectForm.interviewDate2 = '';
      }
    },
  },
  methods: {
    // クリアボタン
    resetForm() {
      this.interviewSelectForm = {
        interviewType: "",
        interviewDate1: "",
        interviewDate2: "",
        statusFlg: "",
      };
      this.interviewSelectForm.interviewDate1 = this.timeDefault;
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
      if (this.interviewSelectForm.interviewDate1.length != 0) {
        this.B0401VueForm.interviewDateFrom = this.interviewSelectForm.interviewDate1;
      }else{
        this.B0401VueForm.interviewDateFrom = '';
      }
      if (this.interviewSelectForm.interviewDate2.length != 0) {
        this.B0401VueForm.interviewDateTo = this.interviewSelectForm.interviewDate2;
      }else{
        this.B0401VueForm.interviewDateTo = '';
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
          path: "/b0402Detailed",
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
    getDate(){
      let now = new Date();
      this.date = now
    }
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
  margin-left: 10vw;
  margin-bottom: 2vh;
  box-shadow: 0 2px 4px #0000000c, 0 0 6px #00000028;
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
.buttonStyle,
.paginationStyle {
  padding: 4vh;
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
// saveアイコンの大きさ
.el-icon-circle-check,
.el-icon-circle-close,
.el-icon-document-remove,
.el-icon-back,
.el-icon-search,
.el-icon-zoom-in,
.el-icon-delete,
.el-icon-document
 {
  font-size: 30px;
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
</style>
