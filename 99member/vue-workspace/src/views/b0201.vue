<template>
  <div>
    <el-container>
      <el-header>
        <div class="header">
          <HomeHeader />
        </div>
      </el-header>

      <el-form
        :rules="rules"
        autocomplete="on"
        :model="applicantForm"
        ref=""
        label-position="left"
      >
        <el-main class="applicant_body">
          <div class="applicant_select">
            <el-row :gutter="1">
              <el-col>
                <div class="applicant_title">応募者管理</div>
              </el-col>
            </el-row>
            <div class="select_body">
              <el-row :gutter="20">
                <el-col :span="2" :offset="1">
                  <div class="blue_font">職位:</div>
                </el-col>
                <el-col :span="3">
                  <el-select
                    v-model="b0201SearchVueForm.positionId"
                    clearable
                    placeholder="请选择"
                  >
                    <el-option
                      v-for="item in positions"
                      :key="item.positionId"
                      :label="item.positionNm"
                      :value="item.positionId"
                    >
                    </el-option>
                  </el-select>
                </el-col>
                <el-col :span="2.5">
                  <div class="blue_font">経験年数:</div>
                </el-col>
                <el-col :span="3">
                  <el-form-item prop="workYearsFrom">
                    <el-input
                      type="number"
                      v-model="b0201SearchVueForm.workYearsFrom"
                      style="width: 100%"
                    ></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="1">～</el-col>
                <el-col :span="3">
                  <el-form-item prop="workYearsTo">
                    <el-input
                      type="number"
                      v-model="b0201SearchVueForm.workYearsTo"
                      style="width: 100%"
                    ></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="2">
                  <div class="blue_font">学位:</div>
                </el-col>
                <el-col :span="3">
                  <el-select
                    v-model="b0201SearchVueForm.degreeId"
                    clearable
                    placeholder="请选择"
                  >
                    <el-option
                      v-for="item in degrees"
                      :key="item.degreeId"
                      :label="item.degreeNm"
                      :value="item.degreeId"
                    >
                    </el-option>
                  </el-select>
                </el-col>
                <el-col :span="2">
                  <div class="blue_font">年齢:</div>
                </el-col>
                <el-col :span="3">
                  <el-form-item prop="ageFrom">
                    <el-input
                      type="number"
                      v-model="b0201SearchVueForm.ageFrom"
                      style="width: 100%"
                    ></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="1">～</el-col>
                <el-col :span="3">
                  <el-form-item prop="ageTo">
                    <el-input
                      type="number"
                      v-model="b0201SearchVueForm.ageTo"
                      style="width: 100%"
                    ></el-input>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row :gutter="20">
                <el-col :span="2.5" :offset="1">
                  <div class="blue_font">学歴区分:</div>
                </el-col>
                <el-col :span="3">
                  <el-select
                    v-model="b0201SearchVueForm.eduSectionId"
                    clearable
                    placeholder="请选择"
                  >
                    <el-option
                      v-for="item in eduSections"
                      :key="item.eduSectionId"
                      :label="item.eduSectionNm"
                      :value="item.eduSectionId"
                    >
                    </el-option>
                  </el-select>
                </el-col>
                <el-col :span="2">
                  <div class="blue_font">住所:</div>
                </el-col>
                <el-col :span="6">
                  <el-input
                    v-model="b0201SearchVueForm.address"
                    placeholder=""
                    autocomplete="off"
                  >
                  </el-input>
                </el-col>
                <el-col :span="6" :offset="1">
                  <el-input
                    v-model="b0201SearchVueForm.name"
                    placeholder="名前を入力してください。"
                    autocomplete="off"
                  >
                  </el-input>
                </el-col>
              </el-row>
              <div class="applicant_button">
                <el-row type="flex" justify="center">
                  <el-col :span="4">
                    <div>
                      <el-button
                        class="button-confirm"
                        type="primary"
                        @click="b0201Clear"
                        >条件クリア</el-button
                      >
                    </div>
                  </el-col>
                  <el-col :span="4">
                    <div>
                      <el-button
                        class="button-confirm"
                        type="primary"
                        icon="el-icon-search"
                        @click="b0201Search"
                        >検索</el-button
                      >
                    </div>
                  </el-col>
                </el-row>
              </div>
            </div>
          </div>
          <div class="applicant_data">
            <div class="data_body">
              <el-tabs v-model="activeName" @tab-click="tabClick" type="border-card" value="1">
                <el-tab-pane name="1" label="未処理"></el-tab-pane>
                <el-tab-pane name="2" label="気に入る"></el-tab-pane>
                <el-tab-pane name="3" label="面接予約"></el-tab-pane>
                <el-tab-pane name="4" label="見送り"></el-tab-pane>
                <el-tab-pane name="5" label="ゴミ箱"></el-tab-pane>
                <el-table
                  ref="multipleTable"
                  :data="tableDataComputed()"
                  :default-sort="{ prop: 'applicantDate', order: 'descending' }"
                  tooltip-effect="dark"
                  style="width: 100%"
                  max-height="600px"
                  highlight-current-row
                  @row-click="rowClick"
                  @selection-change="handleSelectionChange"
                >
                  <el-table-column
                    type="selection"
                    width="50"
                    v-model="checkAll"
                    @change="handleCheckAllChange"
                    prop="chkBox"
                  >
                  </el-table-column>
                  <el-table-column
                    prop="oubosyaName"
                    width="100"
                    sortable
                    label="応募者名"
                  >
                  </el-table-column>
                  <el-table-column
                    prop="industryNm"
                    width="100"
                    sortable
                    label="業種"
                  >
                  </el-table-column>
                  <el-table-column
                    prop="jobtypeNm"
                    width="100"
                    sortable
                    label="職種"
                  >
                  </el-table-column>
                  <el-table-column
                    prop="station"
                    width="100"
                    sortable
                    label="最寄駅"
                  >
                  </el-table-column>
                  <el-table-column
                    prop="address"
                    width="100"
                    sortable
                    label="住所"
                  >
                  </el-table-column>
                  <el-table-column
                    prop="graduationSchool"
                    sortable
                    width="100"
                    label="卒業学校"
                  >
                  </el-table-column>
                  <el-table-column
                    prop="finalEducation"
                    sortable
                    width="100"
                    label="最終学歴"
                  >
                  </el-table-column>
                  <el-table-column prop="age" sortable width="100" label="年齢">
                  </el-table-column>
                  <el-table-column
                    prop="workYears"
                    sortable
                    width="100"
                    label="経験年数"
                  >
                  </el-table-column>
                  <el-table-column
                    prop="updateTime"
                    sortable
                    width="100"
                    label="応募日"
                  >
                  </el-table-column>
                  <el-table-column
                    prop="positionNm"
                    sortable
                    width="100"
                    label="職位名"
                  >
                  </el-table-column>
                  <el-table-column
                    prop="applicantId"
                    sortable
                    width="100"
                    label="応募者ID"
                    v-if="false"
                  >
                  </el-table-column>
                  <el-table-column
                    prop="positionId"
                    sortable
                    width="100"
                    label="職位ID"
                    v-if="false"
                  >
                  </el-table-column>
                  <el-table-column fixed="right" width="50" v-if='this.b0201SearchVueForm.applicationStatus != 2'>
                    <template slot-scope="scope">
                      <el-button
                        type="text"
                        size="large"
                        @click="rowClick(scope.row, 2)"
                      >
                        <em class="el-icon-star-off" />
                      </el-button>
                    </template>
                  </el-table-column>
                  <el-table-column fixed="right" width="50" v-if='this.b0201SearchVueForm.applicationStatus != 3'>
                    <template slot-scope="scope">
                      <el-button
                        type="text"
                        size="large"
                        @click="rowClick(scope.row, 3)"
                      >
                        <em class="el-icon-mobile-phone" />
                      </el-button>
                    </template>
                  </el-table-column>
                  <el-table-column fixed="right" width="50" v-if='this.b0201SearchVueForm.applicationStatus != 4'>
                    <template slot-scope="scope">
                      <el-button
                        type="text"
                        size="large"
                        @click="rowClick(scope.row, 4)"
                      >
                        <em class="el-icon-message" />
                      </el-button>
                    </template>
                  </el-table-column>
                  <el-table-column fixed="right" width="50" v-if='this.b0201SearchVueForm.applicationStatus != 5'>
                    <template slot-scope="scope">
                      <el-button
                        type="text"
                        size="large"
                        @click="rowClick(scope.row, 5)"
                      >
                        <em class="el-icon-delete" />
                      </el-button>
                    </template>
                  </el-table-column>
                  <el-table-column fixed="right" width="50" v-if='this.b0201SearchVueForm.applicationStatus != 1 && this.b0201SearchVueForm.applicationStatus != ""'>
                    <template slot-scope="scope">
                      <el-button
                        type="text"
                        size="large"
                        @click="rowClick(scope.row, 1)"
                      >
                        <em class="el-icon-caret-left" />
                      </el-button>
                    </template>
                  </el-table-column>
                </el-table>
              </el-tabs>
              <el-input
                v-model="b0201SearchVueForm.applicationStatus"
                v-if="false"/>
              
            </div>
          <div>
            <el-row type="flex" justify="end" v-if='this.tableData !=""'>
              <el-col :span="1" v-if='this.b0201SearchVueForm.applicationStatus != 2'>
                <el-button type="text" size="large" @click="rowClicks(2)">
                  <em class="el-icon-star-off" />
                </el-button>
              </el-col>
              <el-col :span="1" v-if='this.b0201SearchVueForm.applicationStatus != 3'>
                <el-button type="text" size="large" @click="rowClicks(3)">
                  <em class="el-icon-mobile-phone" />
                </el-button>
              </el-col>
              <el-col :span="1" v-if='this.b0201SearchVueForm.applicationStatus != 4'>
                <el-button type="text" size="large" @click="rowClicks(4)">
                  <em class="el-icon-message" />
                </el-button>
              </el-col>
              <el-col :span="1" v-if='this.b0201SearchVueForm.applicationStatus != 5'>
                <el-button type="text" size="large" @click="rowClicks(5)">
                  <em class="el-icon-delete" />
                </el-button>
              </el-col>
              <el-col :span="1" v-if='this.b0201SearchVueForm.applicationStatus != 1 && this.b0201SearchVueForm.applicationStatus != ""'>
                <el-button type="text" size="large" @click="rowClicks(1)">
                  <em class="el-icon-caret-left" />
                </el-button>
              </el-col>
            </el-row>
          </div>
            <div class="page">
              <el-row type="flex" justify="space-around">
                <el-col :span="13">
                  <el-pagination
                    :total="pagination.total"
                    :current-page="pagination.currentPage"
                    :pager-count="pagination.pagerCount"
                    :page-sizes="pagination.pageSizes"
                    :page-size="pagination.pageSize"
                    :layout="this.paginationComputed()"
                    @size-change="handleSizeChange"
                    @current-change="handlePageChange"
                    background
                    highlight-current-row
                  >
                  </el-pagination>
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
  name: "b0201",
  components: {
    HomeHeader,
    HomeFooter,
  },
  mounted() {
    document.title = "応募者管理";
    this.b0201Init();
  },
  data() {
    return {
      positions: "",

      degrees: "",

      eduSections: "",

      tableData: [],

      // 画面内のデータ
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
          layout: "total, sizes, prev, pager, next, ->, jumper",
          // 当ページの最初の行
          dataStart: 0,
          //当ページの最後の行
          dataEnd: 10,
        },
      // 複数チェックボックス
      multipleSelection: [],
      
      b0201SearchVueForm: {
        positionId: "",
        positionNm: "",
        workYearsFrom: Number,
        workYearsTo: Number,
        degreeId: "",
        ageFrom: Number,
        ageTo: Number,
        eduSectionId: "",
        address: "",
        name: "",
        applicationStatus: "",
        hdnSentakuEvent: "",
        applicantIdList: [Number],
        positionIdList: [Number]
      },
    };
  },
  methods: {
    b0201Init(){
      this.loading = true;
      this.$store
      .dispatch("b0201Init")
      .then((response) => {
        this.loading = false;
        let code = response.data.code;
        if (code == 200) {
          this.positions = response.data.data.b0201SearchVueForm.positionBeanList;
          this.degrees = response.data.data.b0201SearchVueForm.degreeBeanList;
          this.eduSections = response.data.data.b0201SearchVueForm.eduSectionList;
        } else if (code == 404) {
            this.$message.error(response.data.message);
        } else {
          this.$router.push({
            path: "/error",
            query: { message: response.data.message },
          });
        }
      })
      .catch(() => {
        this.loading = false;
      });
    },
    b0201Search() {
      this.loading = true;
      this.$store
        .dispatch("b0201Search", this.b0201SearchVueForm)
        .then((response) => {
          this.loading = false;
          let code = response.data.code;
          if (code == 200) {
            if (response.data.data != null) {
              this.activeName = response.data.data[0].applicationStatus
            }
            this.tableData = response.data.data;
            this.pagination.total = response.data.data.length;
          } else if (code == 404) {
            this.$message.error(response.data.message);
          } else {
            this.$router.push({
              path: "/error",
              query: { message: response.data.message },
            });
          }
        })
        .catch(() => {
          this.loading = false;
        });
    },
    b0201Clear() {
      (this.b0201SearchVueForm = {
        positionId: "",
        positionNm: "",
        workYearsFrom: "",
        workYearsTo: "",
        degreeId: "",
        ageFrom: "",
        ageTo: "",
        eduSectionId: "",
        adress: "",
        name: "",
        applicationStatus: "",
      }),
        (this.tableData = []);
    },
    //チェックボックス
    handleSelectionChange(val) {
      this.multipleSelection = val;
    },
    rowClick(row, val) {
      this.b0201SearchVueForm.hdnSentakuEvent = new String(val);
      this.b0201SearchVueForm.applicantIdList[0] = parseInt(row.applicantId);
      this.b0201SearchVueForm.positionIdList[0] = parseInt(row.positionId);
      this.loading = true;
      this.$store
        .dispatch("updateStatus", this.b0201SearchVueForm)
        .then((response) => {
          this.loading = false;
          let code = response.data.code;
          if (code == 200) {
            this.tableData = response.data.data;
            this.b0201SearchVueForm.applicantIdList = [];
            this.b0201SearchVueForm.positionIdList = [];
            this.pagination.total = response.data.data.length;
          } else if (code == 404) {
            this.$message.error(response.data.message);
          } else {
            this.$router.push({
              path: "/error",
              query: { message: response.data.message },
            });
          }
        })
        .catch(() => {
          this.loading = false;
        });
    },
    rowClicks(val) {
      this.b0201SearchVueForm.hdnSentakuEvent = new String(val);
      for (var i = 0; i < this.multipleSelection.length; i++){
        this.b0201SearchVueForm.applicantIdList[i] = this.multipleSelection[i].applicantId;
        this.b0201SearchVueForm.positionIdList[i] = this.multipleSelection[i].positionId;
      }
      this.loading = true;
      this.$store
        .dispatch("updateStatus", this.b0201SearchVueForm)
        .then((response) => {
          this.loading = false;
          let code = response.data.code;
          if (code == 200) {
            this.tableData = response.data.data;
            this.b0201SearchVueForm.applicantIdList = [];
            this.b0201SearchVueForm.positionIdList = [];
            this.pagination.total = response.data.data.length;
          } else if (code == 404) {
            this.$message.error(response.data.message);
          } else {
            this.$router.push({
              path: "/error",
              query: { message: response.data.message },
            });
          }
        })
        .catch(() => {
          this.loading = false;
        });
    },
    // 何件毎ページの選択
    handleSizeChange(val) {
      this.pagination.pageSize = val;
      console.log("pageSize", this.pagination.pageSize);
      this.pagination.dataStart = this.dataStartComputed();
      this.pagination.dataEnd = this.dataEndComputed();
    },
    // 当テーブルのページ数
    handlePageChange(val) {
      this.pagination.currentPage = val;
      console.log("page", this.pagination.currentPage);
      this.pagination.dataStart = this.dataStartComputed();
      this.pagination.dataEnd = this.dataEndComputed();
    },
    // 当ページの最初のデータが取得するデータの中の番目
    dataStartComputed() {
      return (
        (this.pagination.currentPage - 1) *
        this.pagination.pageSize
      );
    },
    // 当ページの最後のデータが取得するデータの中の番目
    dataEndComputed() {
      return (
        this.pagination.currentPage * this.pagination.pageSize
      );
    },
      // ページネーションのモジュール表示用
    paginationComputed() {
      var nowPage = this.pagination.currentPage;
      var firstPage = 1;
      // 数字切り上げ
      var lastPage = Math.ceil(
        this.pagination.total / this.pagination.pageSize
      );
      // 当ページは最初のページの場合、前のページが不表示
      if (nowPage == firstPage) return "total, sizes, pager, next, ->, jumper";
      // 当ページは最後のページの場合、次のページが不表示
      if (nowPage == lastPage) return "total, sizes, prev, pager, ->, jumper";
      // ワンページだけの場合、前のページと次のページが不表示
      if (nowPage == firstPage && nowPage == lastPage) {
        return "total, sizes, prev, pager, ->, jumper";
      }
      // 全部表示の場合
      return "total, sizes, prev, pager, next, jumper";
    },
    // テーブルデータのページネーション
    tableDataComputed() {
      return (
        this.tableData.slice(
          this.pagination.dataStart,
          this.pagination.dataEnd
        ) || []
      );
    },
    tabClick(tab) {
      this.loading = true;
      this.b0201SearchVueForm.applicationStatus = tab.paneName;
      this.$store
        .dispatch("b0201Search", this.b0201SearchVueForm)
        .then((response) => {
          this.loading = false;
          let code = response.data.code;
          if (code == 200) {
            this.tableData = response.data.data;
            this.pagination.total = response.data.data.length;
          } else if (code == 404) {
            this.$message.error(response.data.message);
          } else {
            this.$router.push({
              path: "/error",
              query: { message: response.data.message },
            });
          }
        })
        .catch(() => {
          this.loading = false;
        });
    },
  },
};
</script>
<style lang="scss" scoped>
/* 主体页面灰色 */
.applicant_body {
  background-color: #f6f6f6;
}
/* 两个主体部分边框阴影，白色背景 */
.applicant_select,
.applicant_data {
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);
  background-color: #ffffff;
}
/* 内容body、两个主体外边距 */
.applicant_body,
.applicant_data,
.data_select {
  margin: 1vh, 1vh, 0px, 0px;
}
/* 人材推薦一覧标题右移1% */
.applicant_title {
  margin-left: 1%;
}
/* 两部分主体宽80vw，居中 */
.applicant_select,
.applicant_data {
  width: 80vw;
  margin: auto;
}
/* 行上下内边距填充1vh */
.el-row {
  padding-top: 1vh;
  padding-bottom: 1vh;
}
/* 部分文字上下边距1vh，白底蓝字粗体 */
.applicant_title,
.blue_font {
  margin-top: 1vh;
  margin-bottom: 1vh;
  background-color: #ffffff;
  color: #014099;
  font-weight: 600;
}
/* 人材推薦一覧字号20 */
.applicant_title {
  font-size: 20px;
}
/* 灰色上边线，上内边距 */
.select_body {
  border-top: 2px solid#f6f6f6;
  padding-top: 2vh;
}
/* 检索按钮所在div内边距，底部外边距 */
.applicant_button {
  padding-top: 2vh;
  padding-bottom: 2vh;
  margin-bottom: 2vh;
}
/* 页眉页脚宽 */
.header,
.footer {
  width: 100vw auto;
}
element.style {
  padding-left: 1px;
  padding-right: 1px;
}
.el-col-2 {
  width: 60px;
}
.el-col-3 {
  width: 120px;
}
</style>
