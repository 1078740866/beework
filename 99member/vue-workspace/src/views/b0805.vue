<template>
  <div>
    <el-container>
      <el-header>
        <div class="header">
          <HomeHeader />
        </div>
      </el-header>
        <el-main class="a0701_body">
          <div v-text="titleName" class="titleNameStyle" />
          <div class="a0701_data">
            <el-form
              :model="a070101Form"
              ref="a070101Form"
              label-position="left"
              autocomplete="on"
            >
            <div class="a0701_data">
              <div class="data_body">
                <el-table
                  ref="multipleTable"
                  :data="getUserList"
                  :default-sort="{ prop: 'a0701Date', order: 'descending' }"
                  tooltip-effect="dark"
                  @row-click="getRowData"
                  @selection-change="selectionChange"
                  highlight-current-row
                >
                  <el-table-column type="expand">
                    <template slot-scope="props">
                      <el-form label-position="right" inline class="demo-table-expand">
                        <el-form-item label="権限：">
                          <span>{{ props.row.authority }}</span>
                        </el-form-item>
                        <el-form-item label="ユーザー状態：">
                          <span>{{ userStatus[ props.row.userStatus ] }}</span>
                        </el-form-item>
                      </el-form>
                    </template>
                  </el-table-column>
                  <el-table-column 
                    type="selection" 
                    fixed="left" 
                    @click="multiSelect" 
                    sortable
                  />
                  <el-table-column 
                    prop="userName" 
                    label="氏名" 
                    sortable
                  >
                    <template v-slot="fullName">
                      {{ fullName.row.firstName }} {{ fullName.row.lastName }}
                    </template>
                  </el-table-column>
                  <el-table-column 
                    prop="userTel" 
                    label="電話番号" 
                    sortable
                  />
                  <el-table-column 
                    prop="userMail" 
                    label="ユーザーメール"
                    sortable 
                  />
                  
                  <el-table-column fixed="right" label="承認" width="80">
                    <template slot-scope="propsButton1">
                      <el-tooltip effect="light" content="承認" placement="top">
                        <el-link @click="toUserConfirm" type="primary" :underline="false" :disabled="propsButton1.row.authority=='認証済み'?true:false">
                          <em class="el-icon-success" />
                        </el-link>
                      </el-tooltip>
                    </template>
                  </el-table-column>
                  <el-table-column fixed="right" label="拒否" width="80">
                    <template slot-scope="propsButton2">
                      <el-tooltip effect="light" content="拒否" placement="top">
                        <el-link @click="toUserDeny" type="primary" :underline="false" :disabled="propsButton2.row.userStatus=='1'?true:false">
                          <em class="el-icon-error" />
                        </el-link>
                      </el-tooltip>
                    </template>
                  </el-table-column>
                  <el-table-column fixed="right" label="削除" width="80">
                    <el-tooltip effect="light" content="削除" placement="top">
                      <el-link @click="a" type="primary" :underline="false">
                        <em class="el-icon-delete-solid" />
                      </el-link>
                    </el-tooltip>
                  </el-table-column>
                </el-table>
              </div>
              <el-row type="flex" justify="end">
                <el-col :span="1" :offset="1">
                  <el-tooltip effect="light" content="複数承認" placement="top">
                    <el-link @click="confirmUserMulti" type="primary" :underline="false">
                      <em class="el-icon-success" />
                    </el-link>
                  </el-tooltip>
                </el-col>
                <el-col :span="1">
                  <el-tooltip effect="light" content="複数拒否" placement="top">
                    <el-link @click="denyUserMulti" type="primary" :underline="false">
                      <em class="el-icon-error" />
                    </el-link>
                  </el-tooltip>
                </el-col>
                <el-col :span="1">
                  <el-tooltip effect="light" content="複数削除" placement="top">
                    <el-link @click="a" type="primary" :underline="false">
                      <em class="el-icon-delete-solid" />
                    </el-link>
                  </el-tooltip>
                </el-col>
              </el-row>
              <div class="page">
                <el-row type="flex" justify="space-around">
                  <el-col :span="12">
                    <el-pagination
                      :total="userPage.total"
                      :current-page="userPage.currentPage"
                      :pager-count="userPage.pagerCount"
                      :page-sizes="userPage.pageSizes"
                      :page-size="userPage.pageSize"
                      :background="true"
                      :layout="userPage.layout"
                      @size-change="userPageSizeChange"
                      @current-change="userPageCurrentChange"
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
import HomeHeader from "./components/HomeHeader";
import HomeFooter from "./components/HomeFooter";

export default {
  components: {
    HomeHeader,
    HomeFooter,
  },

  data() {
    return {
      // タイトル名
      titleName: "会社会員一覧",
      // a070101検索条件
      a070101Form: {
        userMail: "",
        userName: "",
      },
      // a070101転送用form
      A070101VueForm: {
        userMail: "",
        userName: "",
        authority: "",
        userCds: [],
        userCd: Number,
        statusFlg: "",
      },
      userStatus:{
        '0' : '正常',
        '1' : '禁止',
      },
      // a070101テーブルのデータ
      userList: [],
      activeName2: 'first',
      userPage: {
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
 //a070101初期
  mounted() {
    // ページタイトルの切替
    document.title = this.titleName;
    this.getUserData();
  },
  //a0700101,a070102,a070103,a070104,a070105
  computed: {
    getUserList() {
      return (
        this.userList.slice(this.userPage.dataStart, this.userPage.dataEnd) || ""
      );
    },
    getCompanyList() {
      return (
        this.companyList.slice(this.companyPage.dataStart, this.companyPage.dataEnd) || ""
      );
    },
    getPositionList() {
      return (
        this.positionList.slice(this.positionPage.dataStart, this.positionPage.dataEnd) || ""
      );
    },
    getTrainingList() {
      return (
        this.trainingList.slice(this.trainingPage.dataStart, this.trainingPage.dataEnd) || ""
      );
    },
    getBriefingList() {
      return (
        this.briefingList.slice(this.briefingPage.dataStart, this.briefingPage.dataEnd) || ""
      );
    },
  },
  methods: {
    // a070101クリアボタン
    reset070101Form() {
      this.a070101Form = {
        userMail: "",
        userName: "",
        authority: "",
      };
    },
    //チェックボックス
    multiSelect(val) {
      this.multipleSelection = val;
    },
    //a070101検索ボタンデータ取得
    getUserData() {
      this.setUserData();
      this.$store.dispatch("a070101Search", this.A070101VueForm).then((response) => {
        this.$router.push({
          query: { data: response.data.data },
        });
        // テーブルデータを取得する
        this.userList = response.data.data;
        // データ数を取得する
        this.userPage.total = this.userList.length;
      });
    },
    // a070101検索条件の値を設定する
    setUserData() {
      this.A070101VueForm.userMail = this.a070101Form.userMail;
      this.A070101VueForm.userName = this.a070101Form.userName;
      this.A070101VueForm.authority = this.a070101Form.authority; 
    },
    // a070101毎ページ行目数のselect
    userPageSizeChange(val) {
      this.userPage.pageSize = val;
      this.userPageDataFromTo();
    },
    // a070101当ページのボタン
    userPageCurrentChange(val) {
      this.userPage.currentPage = val;
      this.userPageDataFromTo();
    },
    // a070101テーブル値行範囲の設定
    userPageDataFromTo() {
      this.userPage.dataStart =
        (this.userPage.currentPage - 1) * this.userPage.pageSize;
      this.userPage.dataEnd =
        this.userPage.currentPage * this.userPage.pageSize;
    },
    // 戻るボタン
    toLastPage() {
      history.go(-1);
    },
    //a070101行目ボタンのクリック
    getRowData(row) {
      this.$refs.multipleTable.toggleRowSelection(row);
      this.A070101VueForm.authority = row.authority;
    },
     // 多数選択をクリアする
    clearSelection() {
      this.$refs.multipleTable.clearSelection();
    },
    //a070101当行目データ承认
    toUserConfirm() {
      this.clearSelection();
      this.confirmUserMulti();
    },
    //a070101当行目データ拒否
    toUserDeny() {
      this.clearSelection();
      this.denyUserMulti();
    },
    //a070101複数承認    
    confirmUserMulti() {
      this.A070101VueForm.statusFlg = "0";
      this.A070101VueForm.userCds = this.multipleSelection;
      this.userConfirmMessageBox();
    },
    //a070101複数拒否    
    denyUserMulti() {
      this.A070101VueForm.statusFlg = "1";
      this.A070101VueForm.userCds = this.multipleSelection;
      this.userConfirmMessageBox();
    },
    //a070101チェックボックス
    selectionChange(val) {
      this.multipleSelection = [];
      for (var a = 0; a < val.length; a++) {
        this.multipleSelection.push(val[a].userCd);
      }
      this.A070101VueForm.userCds = this.multipleSelection;
    },
    // a070101承認確認ポップアップapprovalMessageErr
    userConfirmMessageBox() {
      if(this.A070101VueForm.statusFlg == "0"){
        this.approvalMessage = this.approvalMessageSuc;
      }else{
        this.approvalMessage = this.approvalMessageErr;
      }
      this.$confirm(this.approvalMessage.message, this.approvalMessage.title, {
        confirmButtonText: this.approvalMessage.yes,
        cancelButtonText: this.approvalMessage.no,
        type: "warning",
      })
      .then(() => {
        this.$store
          .dispatch("a070101Confirm", this.A070101VueForm)
            .then((response) => {
              this.$router.push({
                query: { data: response.data.data },
              });
              // テーブルデータを取得する
              this.userList = response.data.data;
              // データ数を取得する
              this.userPage.total = this.userList.length;
              let code = response.data.code;
              if (code == 200) {
                this.$message({
                  type: "success",
                  message: this.approvalMessage.success,
                });
              }else {
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
  },
};
</script>

<style lang="scss" scoped>
// 主体页面灰色
.a0701_body {
  background-color: #f6f6f6;
}
/* 两个主体部分边框阴影，白色背景 */
.a0701_select,
.a0701_data {
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 0 rgba(0, 0, 0, 0.04);
  background-color: #ffffff;
}
// 内容body、两个主体外边距
.a0701_body,
.a0701_data,
.data_select {
  margin: 1vh, 1vh, 0px, 0px;
}
// 研修一覧标题右移1%
.a0701_title {
  margin-left: 1%;
  height: 80px;
}
// 两部分主体宽80vw，居中
.a0701_select,
.a0701_data {
  width: 80vw;
  margin: auto;
}
.titleNameStyle {
  color: #006699;
  font-weight: 600;
  font-size: 2em;
  margin-top: 1vh;
  border: 2px solid#dfdfdf;border-bottom:0;border-radius:5px;
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
.a0701_title,
.blue_font {
  margin-top: 5vh;
  margin-bottom: 1vh;
  background-color: #ffffff;
  color: #006699;
  font-weight: 600;
}
// 字号30
.a0701_title {
  font-size: 30px;
}
// 灰色上边线，上内边距
.select_body {
  padding-top: 2vh;
}
// 检索按钮所在div内边距，底部外边距
.a0701_button {
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
.a0701Button {
  width: 110px;
}
// saveアイコンの大きさ
.el-icon-success,
.el-icon-error,
.el-icon-delete-solid {
  font-size: 30px;
}
// TABSytle
::v-deep .el-tabs{
  background-color: #fff;
  font-size: 18px;
  .el-tabs__header {
    .el-tabs__nav-wrap {
      .el-tabs__nav-scroll{
        .el-tabs__nav {
          .el-tabs__item{
            font-size: 18px ;
            font-family: '微软雅黑';
            font-weight: 600;
            width: 200px;
            text-align: center;
            height: 50px;
            line-height: 50px;
            color: 	#B8B8B8;
          }
          .el-tabs__active-bar{
            height: 0;
          }
          .el-tabs__item.is-active{
            color: #409EFF;
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