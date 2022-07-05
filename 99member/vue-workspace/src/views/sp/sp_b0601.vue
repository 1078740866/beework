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
                    <el-form-item label="説明会方式：">
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
                    <el-form-item label="説明会状態：">
                      <el-select
                        v-model="b0601Form.statusFlg"
                        placeholder="状態"
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
              </el-row>
              <el-row :gutter="1">
                <el-col :span="6" :offset="1">
                  <div>
                    <el-form-item label="説明会日：">
                      <el-date-picker
                        v-model="b0601Form.briefingDate"
                        type="date"
                        placeholder="日付"
                        value-format="yyyy/MM/dd"
                      />
                    </el-form-item>
                    </div>
                </el-col>
                </el-row>
                <el-row :gutter="1">
                <el-col :span="6" :offset="1">
                  <div>
                    <el-form-item label="説明会時間：">
                      <el-time-picker
                        is-range
                        v-model="b0601Form.date"
                        start-placeholder="開始時間"
                        range-separator="-"
                        end-placeholder="終了時間"
                        value-format="HH:mm:ss"
                        style="width: 280px"
                      />
                    </el-form-item>
                  </div>
                </el-col>
              </el-row>
              <div class="b0601_button">
                <el-row type="flex" justify="center">
                  
                    <div>
                      <el-button
                        type="primary"
                        @click="resetForm"
                        class="b0601Button"
                      >
                        条件クリア
                      </el-button>
                    </div>
                  
                    <div>
                      <el-button
                        type="primary"
                        @click="getBriefingData"
                        icon="el-icon-search"
                        class="b0601Button"
                      >
                        検索
                      </el-button>
                    </div>
                  
                    <div>
                      <el-button
                        type="primary"
                        @click="toLastPage"
                        class="b0601Button"
                      >
                        戻る
                      </el-button>
                    </div>
               
                </el-row>
              </div>
            </div>
          </div>

          <div class="b0601_data">
            <div class="data_body">
              <el-table
                ref="multipleTable"
                :data="getBriefingList"
                :default-sort="{ prop: 'b0601Date', order: 'descending' }"
                tooltip-effect="dark"
                style="width: 100%"
                max-height="600px"
                @row-click.capture="getRowData"
                @selection-change="selectionChange"
                highlight-current-row
              >
                <el-table-column
                  type="selection"
                  fixed="left"
                  width="30"
                  @click="multiSelect"
                />
                <el-table-column
                  prop="briefingNm"
                  label="説明会名"
                  width="100"
                />
                <el-table-column prop="charge" label="担当" width="120" />
                <el-table-column
                  prop="briefingDate"
                  label="説明会日"
                  sortable
                  width="120"
                />
                <el-table-column
                  prop="dateFrom"
                  label="開始時刻"
                  sortable
                  width="120"
                />
                <el-table-column
                  prop="dateTo"
                  label="終了時刻"
                  sortable
                  width="120"
                />
                <el-table-column
                  prop="briefingType"
                  label="説明会方式"
                  width="120"
                >
                <template slot-scope="scope">
               {{type [scope.row.briefingType]}} 
                </template>
                </el-table-column>
                <el-table-column
                  prop="briefingAddress1"
                  label="説明会場所"
                  width="200"
                />
                <el-table-column
                  prop="proCntPlan"
                  label="予定人数"
                  sortable
                  width="120"
                />
                <el-table-column prop="tel" label="連絡先" width="120" />
                <el-table-column
                  prop="statusFlg"
                  label="確認状態"
                  width="120"
                >
                <template slot-scope="scope">
               {{status [scope.row.statusFlg]}} 
                </template>
                </el-table-column>
                <el-table-column fixed="right" width="20">
                  <el-button type="text" size="large" @click="toB0602Detailed">
                    <em class="el-icon-zoom-in" />
                  </el-button>
                </el-table-column>
                <el-table-column fixed="right" width="20">
                  <el-button type="text" size="large" @click="toB0602Modify">
                    <em class="el-icon-edit" />
                  </el-button>
                </el-table-column>
                <el-table-column fixed="right" width="20">
                <el-button type="text" size="large" @click="toB0603">
                  <em class="el-icon-user" />
                </el-button>
              </el-table-column>
                <el-table-column fixed="right" width="20">
                  <el-button type="text" size="large" @click="deleteOne">
                    <em class="el-icon-delete" />
                  </el-button>
                </el-table-column>
              </el-table>
            </div>
            <div>
              <el-row type="flex" justify="end">
                <el-col :span="1">
                  <el-button
                    type="text"
                    size="large"
                    @click="toB0602Registered"
                  >
                    <em class="el-icon-circle-plus-outline" />
                  </el-button>
                </el-col>
                <el-col :span="1">
                  <el-button type="text" size="large" @click="deleteMulti">
                    <em class="el-icon-delete" />
                  </el-button>
                </el-col>
              </el-row>
            </div>
            <div class="page">
              <el-row type="flex" justify="space-between">
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
import HomeHeader from "../spComponents/HomeHeader";
import HomeFooter from "../spComponents/HomeFooter";
import '@/css/reset.css';
import '@/css/border.css';

//移动端 解决点击按钮闪和active失效的问题
document.body.addEventListener('touchstart' , function(){});
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
        companyId: 1,
        userCd: 1,
        briefingType: "",
        briefingDate: "",
        date: [],
        statusFlg: "",
        briefingId: 0,
        briefingIds: [0, 1],
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
      type: { 
        '0' : '現場',
        '1' : '生放送',
        },
      status:{ 
        '0' : '未確認',
        '1' : '確認済み',
        '2' : '取り消し',
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
        companyId: 1,
        userCd: 1,
        briefingType: "",
        statusFlg: "",
        dateFrom: null,
        dateTo: null,
        briefingId: 0,
        briefingIds: [0, 1],
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
        remarks: "",
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
        this.briefingList.slice(this.pagination.dataStart, this.pagination.dataEnd) || ""
      );
    },
  },
  methods: {
    // クリアボタン
    resetForm() {
      this.b0601Form = {
        briefingType: "",
        briefingDate: "",
        date: [],
        statusFlg: "",
      };
    },
    // 戻るボタン
    toLastPage() {
      console.log("戻る");
      this.$router.replace({ name: "b0003" });
      this.$router.go(-1);
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

    //チェックボックス
    multiSelect(val) {
      this.multipleSelection = val;
      console.log("multipleSelectionMulti", this.multipleSelection);
    },

    // 複数チェックボックス
    selectionChange(val) {
      this.multipleSelection = [];
      for (var i = 0; i < val.length; i++) {
        this.multipleSelection.push(val[i].briefingId);
      }
      console.log("multipleSelection", this.multipleSelection);
    },

    //当行目データ削除
    deleteOne(val) {
      this.confirmMessageBox(val);
    },
    deleteMulti() {
      this.B0601VueForm.briefingIds = this.multipleSelection;
      console.log("briefingIds", this.B0601VueForm.briefingIds);
      this.confirmMessageBox(this.B0601VueForm.briefingIds);
    },
// 検索ボタンデータ取得
    getBriefingData() {
      this.setBriefingData();
      this.$store.dispatch("b0601Search", this.B0601VueForm).then((response) => {
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
    },

    // 新規画面へ
    toB0602Registered() {
      console.log(this.detailedForm);
      this.$router.push({ path: "/sp/sp_b0602Registered" });
    },

    // 選択され行目内容
    getRowData(row) {
      this.$refs.multipleTable.toggleRowSelection(row);
      this.detailedForm = row;
      this.B0601VueForm.briefingIds = new Array(row.briefingId);
      console.log("briefingIds", this.B0601VueForm.briefingIds);
    },

    // 詳細情報画面へ
    toB0602Detailed() {
      console.log("detailed", this.detailedForm);
      setTimeout(() => {
      this.$router.push({
        path: "/sp/sp_b0602Detailed",
        query: { flight: JSON.stringify(this.detailedForm) },
      });
    }, 1);
    },
    // 情報修正画面へ
    toB0602Modify() {
      console.log("detailed", this.detailedForm);
      setTimeout(() => {
      this.$router.push({
        path: "/sp/sp_b0602Modify",
        query: { flight: JSON.stringify(this.detailedForm) },
      });
    }, 1);
    },
    // 说明会应募者画面へ
    toB0603() {
      console.log("detailed", this.detailedForm);
      setTimeout(() => {
        this.$router.push({
          path: "/sp/sp_b0603",
          query: { briefingId: this.detailedForm.briefingId },
        });
      }, 1);
    },
    // 毎ページ行目数のselect
    sizeChange(val) {
      this.pagination.pageSize = val;
      console.log("pageSize", this.pagination.pageSize);
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

    // 削除確認ポップアップ
    confirmMessageBox() {
      this.$confirm("本当に削除しますか？", "削除確認", {
        confirmButtonText: "はい",
        cancelButtonText: "いいえ",
        type: "warning",
      })
        .then(() => {
          //console.log("briefingIds", this.B0601VueForm.briefingIds);
          this.$store
            .dispatch("b0601Delete", this.B0601VueForm.briefingIds)
            .then((response) => {
              this.$router.push({
                query: { data: response.data.data },
              });
              // テーブルデータを取得する
              this.briefingList =
                response.data.data.briefingInfoTblBean;
              // データ数を取得する
               this.pagination.total = this.briefingList.length;
            });
          this.$message({
            type: "success",
            message: "削除が成功しました！",
          });
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "削除は取り消しされました！",
          });
        });
    },
  },
};
</script>

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
  width: 90vw;
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
  padding-bottom: 2vh;
  margin-bottom: 2vh;
}
/* 页眉页脚宽 */
.header,
.footer {
  width: 100vw auto;
}
/*按钮本体*/
.b0601Button {
  width: 110px;
  margin:10px 5px 15px 20px;
}
</style>
