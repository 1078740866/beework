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
          <el-form ref="receptionSelectForm">
            <el-row>
              <el-col :span="10">
                <el-form-item label="宛先：" label-width="150px">
                  <el-input v-model="receptionSelectForm.address" placeholder="宛先の検索" />
                </el-form-item>
              </el-col>
              <el-col :span="10">
                <el-form-item label="件名：" label-width="150px">
                  <el-input v-model="receptionSelectForm.subject" placeholder="件名の検索" />
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="20">
                <el-form-item label="受信日時：" label-width="150px">
                  <el-date-picker
                    v-model="receptionSelectForm.receptionDate1"
                    placeholder="開始日時"
                    value-format="yyyy/MM/dd HH:mm:ss"
                    class="rangeStyle"
                    align="right"
                    type="datetime"
                  />
                  <label> - </label>
                  <el-date-picker
                    v-model="receptionSelectForm.receptionDate2"
                    placeholder="終了日時"
                    value-format="yyyy/MM/dd HH:mm:ss"
                    class="rangeStyle"
                    align="right"
                    type="datetime"
                  />
                </el-form-item>
              </el-col>
            </el-row>
          </el-form>
        </div>
      </el-collapse-transition>
      <div class="buttonStyle">
        <el-row type="flex" justify="center">
          <el-col :span="4" :offset="2">
            <el-tooltip effect="light" content="条件クリア" placement="top">
              <el-link @click="resetForm" type="primary" :underline="false" class="buttonWidth">
                <i class="el-icon-document-remove"></i>
              </el-link>
            </el-tooltip>
          </el-col>
          <el-col :span="4" :offset="3">
            <el-tooltip effect="light" content="検索" placement="top">
              <el-link @click="getData" type="primary" :underline="false" class="buttonWidth">
                <i class="el-icon-search"></i>
              </el-link>
            </el-tooltip>
          </el-col>
          <el-col :span="4" :offset="3">
            <el-tooltip effect="light" content="戻る" placement="top">
              <el-link @click="goBack" type="primary" :underline="false" class="buttonWidth">
                <i class="el-icon-back"></i>
              </el-link>
            </el-tooltip>
          </el-col>
        </el-row>
      </div>
    </div>
    <div class="bodyStyle">
      <el-collapse-transition>
        <div class="tableStyle">
          <el-table
            ref="multipleTable"
            :data="tableDataComputed"
            :default-sort="{ prop: 'aDate', order: 'descending' }"
            tooltip-effect="dark"
            @row-click.capture="getRowData"
            @row-dblclick="toB0902Detailed"
            highlight-current-row
          >
            <el-table-column prop="internalMessageId" v-if="false" label="メッセージID" sortable />
            <el-table-column prop="name" label="宛先" sortable />
            <el-table-column prop="subject" label="件名" sortable />
            <el-table-column prop="aDate" label="受信日時" sortable />
            <el-table-column prop="status" label="状態" sortable >
              <template slot-scope="scope">
                {{ statusData[scope.row.status] }}
              </template>
            </el-table-column>
            <el-table-column fixed="right" label="詳細">
              <el-tooltip content="詳細" placement="top" effect="light">
                <el-button type="text" @click="toB0902Detailed">
                  <em class="el-icon-document" />
                </el-button>
              </el-tooltip>
            </el-table-column>
          </el-table>
        </div>
      </el-collapse-transition>
    </div>
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
    <HomeFooter />
  </div>
</template>
<script>
import HomeHeader from "./components/HomeHeader";
import HomeFooter from "./components/HomeFooter";
export default {
  name: "b0901",
  components: {
    HomeHeader,
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
      titleName: "受信一覧",
      // 選択内容
      receptionSelectForm: {
        address: "",
        subject: "",
        receptionDate1: "",
        receptionDate2: "",
      },
      statusData: {
        '0': '未閲覧',
        '1': '閲覧済',
        '2': 'システム通知',
      },
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
      B0901VueForm: {
        userCd: Number,
        internalMessageId: Number,
        address: "",
        subject: "",
        dateFrom: "",
        dateTo: "",
        statusFlg: "",
      },
      // 行目内容
      rowData: {
        internalMessageId: "",
        name: "",
        aDate: "",
        subject: "",
        status: "",
      },
      // テーブル内容
      tableData: [],
    };
  },
  computed: {
    tableDataComputed() {
      return (
        this.tableData.slice(this.pagination.dataStart, this.pagination.dataEnd) || ""
      );
    },
  },
  //elementUiが日付範囲を選択すると、セレクターはv-modelの値をnullにクリアするので、
  //watchを追加、このv-modelを動的に監視する
  watch: {
    "receptionSelectForm.receptionDate1"(newVal) {
      if (newVal == null) {
        this.receptionSelectForm.receptionDate1 = '';
      }
    },
    "receptionSelectForm.receptionDate2"(newVal) {
      if (newVal == null) {
        this.receptionSelectForm.receptionDate2 = '';
      }
    },
  },
  methods: {
    // クリアボタン
    resetForm() {
      this.receptionSelectForm = {
        address: "",
        subject: "",
        receptionDate1: "",
        receptionDate2: "",
      };
    },
    // テーブルデータ取得
    getData() {
      this.setData();
      this.$store.dispatch("b0901Init", this.B0901VueForm).then((response) => {
        this.$router.push({
          query: { data: response.data.data },
        });
        this.tableData = response.data.data
        this.pagination.total = this.tableData.length;
      });
    },
    // 検索条件の値を設定する
    setData() {
      this.B0901VueForm.address = this.receptionSelectForm.address;
      this.B0901VueForm.subject = this.receptionSelectForm.subject;
      if (this.receptionSelectForm.receptionDate1.length != 0) {
        this.B0901VueForm.dateFrom = this.receptionSelectForm.receptionDate1.substring(0,19);
      }else{
        this.B0901VueForm.dateFrom = '';
      }
      if (this.receptionSelectForm.receptionDate2.length != 0) {
        this.B0901VueForm.dateTo = this.receptionSelectForm.receptionDate2.substring(0,19);
      }else{
        this.B0901VueForm.dateTo = '';
      }
      
    },
    // 戻るボタン
    goBack() {
      this.$router.push({
        path: "/b0003",
      });
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
     // 行目と詳細ボタンのクリック
    getRowData(row) {
      this.$refs.multipleTable.toggleRowSelection(row);
      this.rowData = row;
      this.B0901VueForm.internalMessageId = this.rowData.internalMessageId;
    },
    // 詳細情報画面へ
    toB0902Detailed() {
      setTimeout(() => {
        this.$router.push({
          path: "/b0902",
          query: { b0902Id: this.B0901VueForm.internalMessageId },
        });
      }, 1);
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
  margin-left: 10vw;
  margin-bottom: 2vh;
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
.tableStyle,
.buttonStyle,
.paginationStyle {
  padding: 4vh;
}
.selectStyle{
   padding-left: 4vh;
   padding-top: 4vh;
   padding-right: 4vh;

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
  max-width: 200px;
}
// saveアイコンの大きさ
.el-icon-circle-check,
.el-icon-circle-close,
.el-icon-document-remove,
.el-icon-back,
.el-icon-search,
.el-icon-document
 {
  font-size: 30px;
}
</style>
