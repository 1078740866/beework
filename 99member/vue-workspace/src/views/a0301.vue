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
                <div class="applicant_title">管理者管理</div>
              </el-col>
            </el-row>
            <div class="select_body">
              <el-row :gutter="20">
                <el-col :span="3" :offset="1">
                  <div class="blue_font">氏名:</div>
                </el-col>
                <el-col :span="5">
                  <el-input
                    v-model="a0301SearchVueForm.userName"
                    placeholder=""
                    autocomplete="off"
                  >
                  </el-input>
                </el-col>
                <el-col :span="3">
                  <div class="blue_font">メール:</div>
                </el-col>
                <el-col :span="5">
                  <el-input
                    v-model="a0301SearchVueForm.userMail"
                    placeholder=""
                    autocomplete="off"
                  >
                  </el-input>
                </el-col>
                <el-col :span="3">
                  <div class="blue_font">電話番号:</div>
                </el-col>
                <el-col :span="5">
                  <el-input
                    v-model="a0301SearchVueForm.userTel"
                    placeholder=""
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
                        @click="a0301Clear"
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
                        @click="a0301Search"
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
                <el-table
                  ref="multipleTable"
                  :data="tableDataComputed()"
                  :default-sort="{ prop: 'applicantDate', order: 'descending' }"
                  tooltip-effect="dark"
                  style="width: 100%"
                  max-height="600px"
                  highlight-current-row
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
                    prop="userName"
                    width="100"
                    sortable
                    label="管理者"
                  >
                  </el-table-column>
                  <el-table-column
                    prop="sex"
                    width="100"
                    sortable
                    label="性別"
                  >
                  </el-table-column>
                  <el-table-column
                    prop="userStatus"
                    width="100"
                    sortable
                    label="状態"
                  >
                  </el-table-column>
                  <el-table-column
                    prop="userTel"
                    width="150"
                    sortable
                    label="電話番号"
                  >
                  </el-table-column>
                  <el-table-column
                    prop="userMail"
                    width="200"
                    sortable
                    label="メール"
                  >
                  </el-table-column>
                  <el-table-column
                    prop="updateTime"
                    sortable
                    width="200"
                    label="最後ログイン日時"
                  >
                  </el-table-column>
                  <el-table-column
                    prop="userCd"
                    sortable
                    width="100"
                    label="ユーザーコード"
                    v-if="false"
                  >
                  </el-table-column>
                  <el-table-column
                    prop="userStatusCd"
                    width="100"
                    sortable
                    label="状態"
                    v-if="false"
                  >
                  </el-table-column>
                  <el-table-column  fixed="right" width="50">
                    <template slot-scope="scope">
                      <el-button
                        type="text"
                        size="large"
                        @click="rowClick(scope.row,1)"
                      >
                        <em class="el-icon-edit-outline" />
                      </el-button>
                    </template>
                  </el-table-column>
                  <el-table-column  fixed="right" width="50">
                    <template slot-scope="scope">
                      <el-button
                        type="text"
                        size="large"
                        @click="rowClick(scope.row,2)"
                      >
                        <em class="el-icon-unlock" v-if='scope.row.userStatusCd == "0"'/>
                        <em class="el-icon-lock" v-if='scope.row.userStatusCd == "1"'/>
                      </el-button>
                    </template>
                  </el-table-column>
                  <el-table-column  fixed="right" width="50">
                    <template slot-scope="scope">
                      <el-button
                        type="text"
                        size="large"
                        @click="rowClick(scope.row,3)"
                      >
                        <em class="el-icon-delete" />
                      </el-button>
                    </template>
                  </el-table-column>
                </el-table>
              <el-input
                v-model="b0201SearchVueForm.applicationStatus"
                v-if="false"/>
            </div>
          <div>
            <el-row type="flex" justify="end" v-if='this.tableData !=""'>
              <el-col :span="1">
                <el-button type="text" size="large" @click="rowClicks(1)">
                  <em class="el-icon-plus" />
                </el-button>
              </el-col>
              <el-col :span="1">
                <el-button type="text" size="large" @click="rowClicks(20)">
                  <em class="el-icon-unlock" />
                </el-button>
              </el-col>
              <el-col :span="1">
                <el-button type="text" size="large" @click="rowClicks(21)">
                  <em class="el-icon-lock" />
                </el-button>
              </el-col>
              <el-col :span="1">
                <el-button type="text" size="large" @click="rowClicks(3)">
                  <em class="el-icon-delete" />
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
  },
  data() {
    return {
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

        rules: {
          userTel: [
            {
              pattern: /^[0-9]*$/,
              message: "電話番号は半角数字で入力してください。",
              trigger: "blur",
            },
          ],
        },

      // 複数チェックボックス
      multipleSelection: [],
      
      a0301SearchVueForm: {
        userName: "",
        userMail: "",
        userTel: "",
        eventFlg: "",
        userStatusCd: "",
        userCdList: [Number]
      },
    };
  },
  methods: {
    a0301Search() {
      this.loading = true;
      this.$store
        .dispatch("a0301Search", this.a0301SearchVueForm)
        .then((response) => {
          this.loading = false;
          let code = response.data.code;
          if (code == 200) {
            this.tableData = [];
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
    a0301Clear() {
      (this.a0301SearchVueForm = {
        userName: "",
        userMail: "",
        userTel: "",
        userCd: []
      }),
        (this.tableData = []);
    },
    //チェックボックス
    handleSelectionChange(val) {
      this.multipleSelection = val;
    },
    rowClick(row,val) {
      this.loading = true;
      if (val == 1) {
        this.toA0901(row.userCd);
      } else {
        this.a0301SearchVueForm.eventFlg = new String(val);
        if (row.userStatusCd == "0") {
          this.a0301SearchVueForm.userStatusCd = "1";
        } else {
          this.a0301SearchVueForm.userStatusCd = "0";
        }
        this.a0301SearchVueForm.userCdList[0] = parseInt(row.userCd);      
        this.$store
          .dispatch("a0301Update", this.a0301SearchVueForm)
          .then((response) => {
            this.loading = false;
            let code = response.data.code;
            if (code == 200) {
              this.tableData = response.data.data;
              this.a0301SearchVueForm.userCdList = [Number];
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
      }
    },
    rowClicks(val) {
      if (val == 1) {
        this.toA0002();
      } else {
        this.a0301SearchVueForm.eventFlg = new String(val).substring(0,1);
        
        if (val == 20) {
          this.a0301SearchVueForm.userStatusCd = "0";
        } else {
          this.a0301SearchVueForm.userStatusCd = "1";
        }
        this.a0301SearchVueForm.userCdList = [];
        for (var i = 0; i < this.multipleSelection.length; i++){
          this.a0301SearchVueForm.userCdList[i] = parseInt(this.multipleSelection[i].userCd);
        }
        this.loading = true;
        this.$store
          .dispatch("a0301Update", this.a0301SearchVueForm)
          .then((response) => {
            this.loading = false;
            let code = response.data.code;
            if (code == 200) {
              this.tableData = response.data.data;
              this.a0301SearchVueForm.userCd = [];
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
        }
    },
    toA0901(val) {
      this.$router.push({
        path: "/a0901",
        query: { flight: JSON.stringify(val) },
      });
    },
    toA0002() {
      this.$router.push({
        path: "/a0002"
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
    // // テーブルデータのページネーション
    tableDataComputed() {
      return (
        this.tableData.slice(
          this.pagination.dataStart,
          this.pagination.dataEnd
        ) || []
      );
    },
    // tabClick(tab) {
    //   this.loading = true;
    //   this.b0201SearchVueForm.applicationStatus = tab.paneName;
    //   this.$store
    //     .dispatch("b0201Search", this.b0201SearchVueForm)
    //     .then((response) => {
    //       this.loading = false;
    //       let code = response.data.code;
    //       if (code == 200) {
    //         this.tableData = response.data.data;
    //         this.pagination.total = response.data.data.length;
    //       } else if (code == 404) {
    //         this.$message.error(response.data.message);
    //       } else {
    //         this.$router.push({
    //           path: "/error",
    //           query: { message: response.data.message },
    //         });
    //       }
    //     })
    //     .catch(() => {
    //       this.loading = false;
    //     });
    // },
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
