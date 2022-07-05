<template>
  <div class="b0501_page">
    <el-container>
      <el-header>
        <div class="header">
          <homeHeader />
        </div>
      </el-header>
      <el-form :model="b0501Form" ref="loginForm" label-position="left" autocomplete="on">
        <el-main class="b0501_body">
          <div class="b0501_select">
            <el-row>
              <el-col :span="24">
                <div class="b0501_title">研修一覧</div>
              </el-col>
            </el-row>
            <div class="select_body">
              <el-row :gutter="1">
                <el-col :span="7" :offset="1">
                  <div>
                    <el-form-item label="研修名前：">
                      <el-input v-model="b0501Form.trainingNm" placeholder="研修名前" />
                    </el-form-item>
                  </div>
                </el-col>
                <el-col :span="7" :offset="1">
                  <div>
                    <el-form-item label="業種：">
                      <el-select v-model="b0501Form.industryId" @change="setIndustryIdNm" placeholder="業種" clearable>
                        <el-option v-for="item in industryCds" :key="item.industryId" :label="item.industryNm" :value="item.industryId" />
                      </el-select>
                    </el-form-item>
                  </div>
                </el-col>
                <el-col :span="6" :offset="1">
                  <div>
                    <el-form-item label="状態：">
                      <el-select v-model="b0501Form.statusFlg" placeholder="状態" clearable>
                        <el-option v-for="item in status_flag" :key="item.value" :label="item.label" :value="item.value" />
                      </el-select>
                    </el-form-item>
                  </div>
                </el-col>
              </el-row>
            </div>
            <el-row :gutter="1">
              <el-col :span="6" :offset="1">
                <div>
                  <el-form-item label="研修期間：">
                    <el-date-picker v-model="b0501Form.date" type="daterange" start-placeholder="開始日付" range-separator="-" end-placeholder="終了日付" value-format="yyyy/MM/dd" />
                  </el-form-item>
                </div>
              </el-col>
            </el-row>
            <div class="b0501_button">
              <el-row type="flex" justify="center">
                
                  <div>
                    <el-button type="primary" @click="resetForm" class="b0501Button"> 条件クリア </el-button>
                  </div>
                
                  <div>
                    <el-button type="primary" @click="getTrainingData" icon="el-icon-search" class="b0501Button"> 検索 </el-button>
                  </div>
               
                  <div>
                    <el-button type="primary" @click="toLastPage" class="b0501Button"> 戻る </el-button>
                  </div>
                
              </el-row>
            </div>
          </div>
          <div class="b0501_data">
            <div class="data_body">
              <el-table
                ref="multipleTable"
                :data="trainingList.slice(pagination.dataStart, pagination.dataEnd) || ''"
                :default-sort="{ prop: 'b0501Date', order: 'descending' }"
                tooltip-effect="dark"
                style="width: 100%"
                max-height="600px"
                @row-click="getRowData"
                @selection-change="selectionChange"
                highlight-current-row
              >
                <el-table-column type="selection" fixed="left" width="30" @click="multiSelect" />
                <el-table-column prop="trainingNm" label="研修名" width="100" />
                <el-table-column prop="industryNm" label="業種" width="120" />
                <el-table-column prop="charge" label="担当者" width="120" />
                <el-table-column prop="dateFrom" label="開始日付" sortable width="120" />
                <el-table-column prop="dateTo" label="終了日付" sortable width="120" />
                <el-table-column prop="timeFrom" label="開始時刻" sortable width="120" />
                <el-table-column prop="timeTo" label="終了時刻" sortable width="120" />
                <el-table-column prop="statusFlg" label="研修状態" width="120" />
                <el-table-column prop="trainingAddress1" label="研修場所" width="200" />
                <el-table-column fixed="right" width="20">
                  <el-button type="text" size="large" @click="toB0502Detailed()">
                    <em class="el-icon-document" />
                  </el-button>
                </el-table-column>
                <el-table-column fixed="right" width="20">
                  <el-button type="text" size="large" @click="toB0502Modify()">
                    <em class="el-icon-edit" />
                  </el-button>
                </el-table-column>
                <el-table-column fixed="right" width="20">
                <el-button type="text" size="large" @click="toB0503()">
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
                  <el-button type="text" size="large" @click="toB0502Registered()">
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
                  <el-pagination :total="pagination.total" :current-page="pagination.currentPage" :pager-count="pagination.pagerCount" :page-sizes="pagination.pageSizes" :page-size="pagination.pageSize" :background="true" :layout="pagination.layout" @size-change="sizeChange" @current-change="currentChange" />
                </el-col>
              </el-row>
            </div>
          </div>
        </el-main>
      </el-form>
      <el-footer>
        <div class="footer">
          <homeFooter />
        </div>
      </el-footer>
    </el-container>
  </div>
</template>

<script lang="" scoped>
import HomeHeader from "../spComponents/HomeHeader";
import HomeFooter from "../spComponents/HomeFooter";
import '@/css/reset.css';
import '@/css/border.css';

//移动端 解决点击按钮闪和active失效的问题
document.body.addEventListener('touchstart' , function(){});
export default {
  name: "Init",
  components: {
    HomeHeader,
    HomeFooter,
  },
  inject: ["reload"],
  data() {
    return {
      // 検索条件
      b0501Form: {
        companyId: 1,
        userCd: 1,
        trainingNm: "",
        industryId: "",
        industryIdNm: "",
        statusFlg: "",
        date: [],
        trainingId: 0,
        trainingIds: [0, 1],
      },
      // 取得した業種リスト
      industryCds: "",
      // 状態リストのデータ
      status_flag: [
        { value: "0", label: "未確認" },
        { value: "1", label: "確認済み" },
        { value: "2", label: "拒否する" },
      ],
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
      B0501VueForm: {
        companyId: 1,
        userCd: 1,
        trainingNm: "",
        industryId: "",
        statusFlg: "",
        dateFrom: "",
        dateTo: "",
        trainingId: 0,
        trainingIds: [0, 1],
      },
      // 詳細情報form
      detailedForm: {
        charge: "",
        companyId: "",
        companyNm: "",
        cost: "",
        dateFrom: "",
        dateTo: "",
        industryId: "",
        industryNm: "",
        postal: "",
        prefeNm: "",
        proCnt: "",
        remarks: "",
        statusFlg: "",
        teaIntro: "",
        teaNm: "",
        tel: "",
        timeFrom: "",
        timeTo: "",
        trainingAddress1: "",
        trainingAddress2: "",
        trainingContent: "",
        trainingId: 0,
        trainingNm: "",
        trainingPic1: "",
        trainingPic2: "",
        trainingPic3: "",
      },
    };
  },
  created() {
    document.title = "研修一覧";
    this.getTrainingData();
  },
  methods: {
    // クリアボタン
    resetForm() {
      this.b0501Form = {
        trainingNm: "",
        industryId: "",
        industryIdNm: "",
        statusFlg: "",
        date: [],
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
        this.B0501VueForm.trainingIds = rows.trainingIds;
        rows.forEach((row) => {
          this.$refs.multipleTable.toggleRowSelection(row);
        });
      } else {
        this.B0501VueForm.trainingIds = [];
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
        this.multipleSelection.push(val[i].trainingId);
      }
      console.log("multipleSelection", this.multipleSelection);
    },

    //当行目データ削除
    deleteOne(val) {
      console.clear();
      this.confirmMessageBox(val);
    },
    deleteMulti() {
      console.clear();
      this.B0501VueForm.trainingIds = this.multipleSelection;
      console.log("trainingIds", this.B0501VueForm.trainingIds);
      this.confirmMessageBox(this.B0501VueForm.trainingIds);
    },
    // 業種select
    setIndustryIdNm() {
      for (var i = 0; i < this.industryCds.length; i++) {
        if (this.b0501Form.industryId == this.industryCds[i].industryId) {
          this.b0501Form.industryIdNm = this.industryCds[i].industryNm;
          break;
        }
      }
    },
    // 検索ボタンデータ取得
    getTrainingData() {
      this.setTrainingData();
      this.$store.dispatch("b0501Search", this.B0501VueForm).then((response) => {
        this.$router.push({
          query: { data: response.data.data },
        });
        // 業種リストを取得する
        this.industryCds = response.data.data.industryMstBean;
        // テーブルデータを取得する
        this.trainingList = response.data.data.trainingInfoTblBean;
        // データ数を取得する
        this.pagination.total = this.trainingList.length;
        console.clear();
        console.log("industryCds", response.data.data.industryMstBean);
        console.log("response", response.data.data.trainingInfoTblBean);
      });
    },
    // 検索条件の値を設定する
    setTrainingData() {
      this.B0501VueForm.trainingNm = this.b0501Form.trainingNm;
      this.B0501VueForm.industryId = this.b0501Form.industryId;
      this.B0501VueForm.statusFlg = this.b0501Form.statusFlg;
      this.B0501VueForm.dateFrom = new Date(this.b0501Form.date[0]);
      this.B0501VueForm.dateTo = new Date(this.b0501Form.date[1]);
    },
    // 新規画面へ
    toB0502Registered() {
      console.log(this.detailedForm);
      this.$router.push({ path: "/sp/sp_b0502Registered" });
    },
    // 選択され行目内容
    getRowData(row) {
      this.$refs.multipleTable.toggleRowSelection(row);
      this.detailedForm = row;
      this.B0501VueForm.trainingIds = new Array(row.trainingId);
      console.clear();
      console.log("trainingIds", this.B0501VueForm.trainingIds);
    },
    // 詳細情報画面へ
    toB0502Detailed() {
      console.log("detailed", this.detailedForm);
      this.$router.push({
        path: "/sp/sp_b0502Detailed",
        query: { flight: JSON.stringify(this.detailedForm) },
      });
    },
    // 情報修正画面へ
    toB0502Modify() {
      console.log("detailed", this.detailedForm);
      this.$router.push({
        path: "/sp/sp_b0502Modify",
        query: { flight: JSON.stringify(this.detailedForm) },
      });
    },
    // 情報修正画面へ
    toB0503() {
      setTimeout(() => {
        this.$router.push({
          path: "/sp/sp_b0503",
          query: { flight: JSON.stringify(this.detailedForm) },
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
      this.pagination.dataStart = (this.pagination.currentPage - 1) * this.pagination.pageSize;
      this.pagination.dataEnd = this.pagination.currentPage * this.pagination.pageSize;
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
          console.clear();
          console.log("trainingIds", this.B0501VueForm.trainingIds);
          this.$store.dispatch("b0501Delete", this.B0501VueForm.trainingIds).then((response) => {
            this.$router.push({
              query: { data: response.data.data },
            });
            // 業種リストを取得する
            this.industryCds = response.data.data.industryMstBean;
            // テーブルデータを取得する
            this.trainingList = response.data.data.trainingInfoTblBean;
            // データ数を取得する
            this.pagination.total = this.trainingList.length;
            console.log("industryCds", response.data.data.industryMstBean);
            console.log("response", response.data.data.trainingInfoTblBean);
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

<style lang="scss" scoped>
// 主体页面灰色
.b0501_body {
  background-color: #f6f6f6;
}
// 两个主体部分边框阴影，白色背景
.b0501_select,
.b0501_data {
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);
  background-color: #ffffff;
}
// 内容body、两个主体外边距
.b0501_body,
.b0501_data,
.data_select {
  margin: 1vh, 1vh, 0px, 0px;
}
// 研修一覧标题右移1%
.b0501_title {
  margin-left: 1%;
}
// 两部分主体宽80vw，居中
.b0501_select,
.b0501_data {
  width: 90vw;
  margin: auto;
}
// 行上下内边距填充1vh
.el-row {
  padding-top: 1vh;
  padding-bottom: 1vh;
}
// 部分文字上下边距1vh，白底蓝字粗体
.b0501_title,
.blue_font {
  margin-top: 1vh;
  margin-bottom: 1vh;
  background-color: #ffffff;
  color: #006699;
  font-weight: 600;
}
// 研修一覧字号20
.b0501_title {
  font-size: 20px;
}
// 灰色上边线，上内边距
.select_body {
  border-top: 2px solid#f6f6f6;
  padding-top: 2vh;
}
// 检索按钮所在div内边距，底部外边距
.b0501_button {
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
.b0501Button {
  width: 110px;
  margin:10px 5px 15px 20px;
}
</style>
