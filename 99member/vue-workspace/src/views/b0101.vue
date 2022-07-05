<template>
      <div class="position_page">
       <el-container>
       <el-header>
        <div class="header">
          <HomeHeader />
        </div>
        </el-header>
        <el-form
        :model="b0101Form"
        autocomplete="on"
        ref="loginForm"
        label-position="left"
       >
        <el-main class="position_body">
          <div class="position_select">
            <el-row>
              <el-col :span="24">
                <div class="position_title">職位一覧</div>
              </el-col>
            </el-row>
            <div class="select_body" style="height : 80px">
              <el-row :gutter="1">
                <el-col :span="2" :offset="1">
                  <div class="blue_font">職位名：</div>
                </el-col>
                <el-col :span="4">
                  <div>
                    <el-input
                      type="text"
                      v-model="b0101Form.positionNm"
                      placeholder="職位名"
                      clearable
                    >
                    </el-input>
                  </div>
                </el-col>
                
                <el-col :span="2" :offset="1">
                  <div class="blue_font">審査状態：</div>
                </el-col>
                <el-col :span="4">
                  <div>
                    <el-select
                      v-model="b0101Form.statusFlg"
                      size="medium"
                     
                      clearable
                    >
                      <el-option
                        v-for="item in position_status"
                        :key="item.value"
                        :label="item.label"
                        :value="item.value"
                      />
                    </el-select>
                  </div>
                </el-col>
              </el-row>
            </div>
            <div class="b0101_button" style="height : 80px">
            <el-row type="flex" justify="center">
              <el-col :span="4">
                          <el-tooltip effect="light" content="条件クリア" placement="top">
                            <el-link @click="resetForm" type="primary" :underline="false">
                              <i class="el-icon-document-remove"></i>
                            </el-link>
                          </el-tooltip>
                        </el-col>
                        <el-col :span="4">
                          <el-tooltip effect="light" content="検索" placement="top">
                            <el-link @click="getPositionData" type="primary" :underline="false">
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
          </div>

          <div class="position_data">
              <div class="data_body">
                <template>
                  <el-table
                     ref="multipleTable"
                    :data="getPositionList"
                    :default-sort="{ prop: 'b0101Date', order: 'descending' }"
                    @row-click="getRowData"
                    @row-dblclick="toB0102Detailed"
                    tooltip-effect="dark"
                    @selection-change="selectionChange"
                    highlight-current-row
                    style="width: 100%">
                    <el-table-column type="expand">
                      <template slot-scope="props">
                        <el-form label-position="left" inline class="demo-table-expand">
                          <el-form-item label="場所">
                            <span>
                              {{ props.row.workAddress1 }}
                            </span>
                          </el-form-item>
                          <el-form-item label="最寄駅">
                            <span>
                              {{ props.row.station }}
                            </span>
                          </el-form-item>
                          <el-form-item label="勤務時間">
                            <span>
                              {{ props.row.workTimeFrom }} - {{ props.row.workTimeTo }}
                            </span>
                          </el-form-item>
                          <el-form-item label="給料">
                            <span>
                              {{salarySection [props.row.salarySection]}} : {{ props.row.salaryMin }}円 - {{ props.row.salaryMax }}円
                            </span>
                          </el-form-item>
                          <el-form-item label="有効期限">
                            <span>
                              {{ props.row.expDate }}
                            </span>
                          </el-form-item>
                          <el-form-item label="募集人数">
                            <span>
                              {{ props.row.peoCnt }} 人
                            </span>
                          </el-form-item>
                          <el-form-item label="必須経験年数">
                            <span>
                              {{ expYears[props.row.expYears] }}
                            </span>
                          </el-form-item>
                          <el-form-item label="トップ状態">
                            <span>
                              {{topStatus [props.row.topStatus]}} 
                            </span>
                          </el-form-item>
                          <!-- <el-form-item label="確認状態">
                            <span>
                              {{checkStatus [props.row.checkStatus]}} 
                            </span>
                          </el-form-item> -->
                        </el-form>
                      </template>
                    </el-table-column>
                    <el-table-column 
                    type="selection" 
                    fixed="left" 
                    />
                    <el-table-column
                      v-if="false"
                      prop="positionId"
                      label="職位ID"
                      sortable
                    />
                    <!-- <el-table-column
                      v-if="false"
                      label="会社名"
                      prop="companyNm"
                      sortable
                      >
                    </el-table-column> -->
                    <el-table-column
                      label="職位名"
                      prop="positionNm">
                    </el-table-column>
                    <el-table-column
                      label="業種"
                      prop="industryNm">
                    </el-table-column>
                    <el-table-column
                      prop="jobTypeNm"
                      label="職種"
                    />
                    <el-table-column
                      label="募集状態"
                      prop="onlineStatus">
                      <template slot-scope="scope">
                       {{onlineStatus [scope.row.onlineStatus]}} 
                       </template>
                    </el-table-column>
                    <el-table-column
                      label="確認状態"
                      prop="checkStatus">
                      <template slot-scope="scope">
                       {{checkStatus [scope.row.checkStatus]}} 
                       </template>
                    </el-table-column>
                    <el-table-column fixed="right" width="50">
                      <template slot-scope="scope">
                       <el-tooltip effect="light" content="オンライン" placement="top">
                        <el-button  type="text" :disabled="scope.row.onlineStatus==0" size="large" @click="toB0102Online" >
                        <em class="el-icon-upload2" />
                        </el-button>
                       </el-tooltip>
                     </template>
                    </el-table-column>
                    <el-table-column fixed="right" width="50">
                      <template slot-scope="scope">
                      <el-tooltip effect="light" content="オフライン" placement="top">
                        <el-button type="text"  :disabled="scope.row.onlineStatus==1" size="large" @click="toB0102Offline">
                        <em class="el-icon-download" />
                        </el-button>
                      </el-tooltip>  
                     </template>
                    </el-table-column>
                    <el-table-column fixed="right" width="50">
                      <template slot-scope="scope">
                       <el-tooltip effect="light" content="トップ" placement="top">
                        <el-button type="text" :disabled="scope.row.topStatus==1" size="large" @click="toB0102Top">
                        <em class="el-icon-upload" />
                        </el-button>
                       </el-tooltip>
                     </template>
                    </el-table-column>
                    <el-table-column fixed="right" width="50">
                       <el-tooltip effect="light" content="削除" placement="top">
                        <el-button type="text" size="large" @click="deleteOne">
                        <em class="el-icon-delete" />
                        </el-button>
                       </el-tooltip>
                    </el-table-column>

                  </el-table>
                </template>
              </div>
              <div>
                <el-row type="flex" justify="end">
                <el-col :span="1">
                   <el-tooltip effect="light" content="オンライン" placement="top">
                  <el-button 
                  type="text" 
                  size="large" 
                  @click="onlineMulti">
                    <em class="el-icon-upload2" />
                  </el-button>
                   </el-tooltip>
                </el-col>
                <el-col :span="1">
                   <el-tooltip effect="light" content="オフライン" placement="top">
                  <el-button 
                  type="text" 
                  size="large" 
                  @click="offlineMulti">
                    <em class="el-icon-download" />
                  </el-button>
                   </el-tooltip>
                </el-col>
                <el-col :span="1">
                   <el-tooltip effect="light" content="トップ" placement="top">
                  <el-button
                    type="text"
                    size="large"
                    @click="topMulti">
                    <em class="el-icon-upload" />
                  </el-button>
                   </el-tooltip>
                </el-col>
                <el-col :span="1">
                   <el-tooltip effect="light" content="削除" placement="top">
                  <el-button 
                  type="text" 
                  size="large" 
                  @click="deleteMulti">
                    <em class="el-icon-delete" />
                  </el-button>
                   </el-tooltip>
                </el-col>
                <el-col :span="1">
                   <el-tooltip effect="light" content="新規" placement="top">
                <el-button type="text" size="large" @click="toB0102Registered">
                  <em class="el-icon-circle-plus-outline" />
                </el-button>
                   </el-tooltip>
              </el-col>
                </el-row>
              </div>
           <div class="page">
              <el-row type="flex" justify="space-around">
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
import HomeHeader from "./components/HomeHeader";
import HomeFooter from "./components/HomeFooter";
import '@/css/reset.css';
import '@/css/border.css';

//移动端 解决点击按钮闪和active失效的问题
document.body.addEventListener('touchstart' , function(){});

export default {
  // name: "b0101Select",
  components: {
    HomeHeader,
    HomeFooter,
  },
  inject: ["reload"],
  data() {
    return {
      // タイトルをクリック選択が非表示にする
      selectIsShow: true,
      // 複数チェックボックス
      multipleSelection: [],
      // 検索条件
      b0101Form: {
        statusFlg: "",
        positionNm: "",
      },
      // 状態リストのデータ
      onlineStatus: { 
        '0' : 'オンライン',
        '1' : 'オフライン',
        },
      checkStatus:{ 
        '0' : '確認未済',
        '1' : '確認済み',
        '2' : '拒否されました',
      },
      topStatus: { 
        '0' : '未トップ',
        '1' : 'トップ中',
        },
      salarySection: {
        '0' : '月給',
        '1' : '年俸',
        '2' : '日給',
        '3' : '時給',
        '4' : '出来高払い',
        '5' : 'その他',
      },  
      expYears: {
        '0' : '不問',
        '1' : '1年未満',
        '2' : '3年未満',
        '3' : '5年未満',
        '4' : '10年未満',
        '5' : '10年以上',
      },
      // テーブルのデータ
      positionList: [],
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
      B0101VueForm: {
        companyId: Number,
        userCd: Number,
        positionNm: "",
        onlineStatus: "",
        checkStatus: "",
        topStatus: "",
        positionId: Number,
        positionIds: [],
      },
      detailedForm: {
        industryNm: "",
        jobTypeNm: "",
        industryId: "",
        jobTypeId: "",
        positionId: "",
        positionNm: "",
        defaultYear: "",
        expDate: "",
        degree: "",
        workTimeFrom: "",
        workTimeTo: "",
        salarySection: "",
        positionInt: "",
        salaryMin: "",
        salaryMax: "",
        empLaborIns: "",
        workContent: "",
        welfare: "",
        expYears: "",
        trainingFlg: "",
        inspectionFlg: "",
        conUpdFlg: "",
        peoCnt: "",
        workDateStr: "",
        holiday: "",
        postal: "",
        workAddress1: "",
        workAddress2: "",
        station: "",
        contractSection: "",
        workingAddress1: "",
        workingAddress2: "",
        workingAddress3: "",
      },

      position_status: [
        { value: "0", label: "確認未済" },
        { value: "1", label: "確認済み" },
        { value: "2", label: "拒否する" },
      ],
      // Onlineメッセージ内容
      approvalMessageSuc: {
        title: "オンライン",
        message: "本当にオンラインしますか？",
        yes: "はい",
        no: "いいえ",
        success: "オンラインが成功しました",
        failed: "オンラインが失敗しました。もう一度お願いします",
        cancel: "オンラインは取り消されました",
      },
       approvalMessageErr: {
        title: "オフライン",
        message: "本当にオフラインしますか？",
        yes: "はい",
        no: "いいえ",
        success: "オフラインが成功しました",
        failed: "オフラインが失敗しました。もう一度お願いします",
        cancel: "オフラインは取り消されました",
      },
      approvalMessageTop: {
        title: "トップ",
        message: "本当にトップしますか？",
        yes: "はい",
        no: "いいえ",
        success: "トップが成功しました",
        failed: "トップが失敗しました。もう一度お願いします",
        cancel: "トップは取り消されました",
      },
      approvalMessageDelete: {
        title: "削除",
        message: "本当に削除しますか？",
        yes: "はい",
        no: "いいえ",
        success: "削除が成功しました",
        failed: "削除が失敗しました。もう一度お願いします",
        cancel: "削除は取り消されました",
      },
    };
  },
  //b0101初期
    mounted() {
    document.title = "職位一覧";
    this.getPositionData();
  },

  computed: {
    getPositionList() {
      return (
        this.positionList.slice(this.pagination.dataStart, this.pagination.dataEnd) || ""
      );
    },
  },

  methods: { 
    // 戻るボタン
    toLastPage() {
      this.$router.replace({ path: "/b0003" });
    },

    //チェックボックス
    multiSelect(val) {
      this.multipleSelection = val;
    },

    // 複数選択をクリアする
    clearSelection() {
      this.$refs.multipleTable.clearSelection();
    },

    // クリアボタン
    resetForm() {
      this.b0101Form = {
        positionNm: "",
        statusFlg: "",
      };
    },

    // 検索ボタンデータ取得
    getPositionData() {
      this.setPositionData();
      this.$store
        .dispatch("b0101Search", this.B0101VueForm)
        .then((response) => {
          this.$router.push({
            query: { data: response.data.data },
          });
          // テーブルデータを取得する
          this.positionList = response.data.data;
          this.positionList.forEach(list => {
            list.workingAddress1 =  "data:image/jpeg;base64," + list.workingAddress1Pic;
            list.workingAddress2 =  "data:image/jpeg;base64," + list.workingAddress2Pic;
            list.workingAddress3 =  "data:image/jpeg;base64," + list.workingAddress3Pic;
          });
          // データ数を取得する
          this.pagination.total = this.positionList.length;
        });
    },

    // 検索条件の値を設定する
    setPositionData() {
        this.B0101VueForm.positionNm = this.b0101Form.positionNm;
        this.B0101VueForm.checkStatus = this.b0101Form.statusFlg;
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
      this.pagination.dataEnd =
        this.pagination.currentPage * this.pagination.pageSize;
    },

    // 選択され行目内容
    getRowData(row) {
      this.$refs.multipleTable.toggleRowSelection(row);
      this.detailedForm = row;
      this.B0101VueForm.positionIds = new Array(row.positionId);
    },
    
    //単数オンラインする
    toB0102Online(){
      this.clearSelection();
      this.onlineMulti();
    },

    //単数オフラインする
    toB0102Offline(){
      this.clearSelection();
      this.offlineMulti();
    },

    //複数オンラインする
    onlineMulti(){
      this.B0101VueForm.onlineStatus = "0";
      this.B0101VueForm.positionIds = this.multipleSelection;
      this.onlineMessageBox();
    },

    //複数オフラインする
    offlineMulti(){
      this.B0101VueForm.onlineStatus = "1";
      this.B0101VueForm.positionIds = this.multipleSelection;
      this.onlineMessageBox();
    },

    //単数トップする
    toB0102Top(){
      this.clearSelection();
      this.topMulti();
    },

    //複数トップする
    topMulti(){
      this.B0101VueForm.topStatus = "1";
      this.B0101VueForm.positionIds = this.multipleSelection;
      this.topMessageBox();
    },

    //当行目データ削除
    deleteOne() {
      this.clearSelection();
      this.deleteMulti();
    },

    //複数データ削除
    deleteMulti() {
      this.B0101VueForm.positionIds = this.multipleSelection;
      this.deleteMessageBox();
    },

    // 複数チェックボックス
    selectionChange(val) {
      this.multipleSelection = [];
      for (var i = 0; i < val.length; i++) {
        this.multipleSelection.push(val[i].positionId);
      }
      this.B0101VueForm.positionIds = this.multipleSelection;
    },

    // b0101オンライン確認ポップアップapprovalMessageErr
    onlineMessageBox() {
      if(this.B0101VueForm.onlineStatus == "0"){
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
          .dispatch("b0101OnlineOffline", this.B0101VueForm)
            .then((response) => {
              this.$router.push({
                query: { data: response.data.data },
              });
              // テーブルデータを取得する
              this.positionList = response.data.data;
              // データ数を取得する
              this.pagination.total = this.positionList.length;
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

    // b0101delete確認ポップアップapprovalMessageErr
        deleteMessageBox() {
          this.approvalMessage = this.approvalMessageDelete;
          this.$confirm(this.approvalMessage.message, this.approvalMessage.title, {
            confirmButtonText: this.approvalMessage.yes,
            cancelButtonText: this.approvalMessage.no,
            type: "warning",
          })
          .then(() => {
            this.$store
              .dispatch("b0101Delete", this.B0101VueForm)
                .then((response) => {
                  this.$router.push({
                    query: { data: response.data.data },
                  });
                  // テーブルデータを取得する
                  this.positionList = response.data.data;
                  // データ数を取得する
                  this.pagination.total = this.positionList.length;
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

    // b0101トップ確認ポップアップapprovalMessageErr
        topMessageBox() {
          if(this.B0101VueForm.topStatus == "1"){
            this.approvalMessage = this.approvalMessageTop;
          }
          this.$confirm(this.approvalMessage.message, this.approvalMessage.title, {
            confirmButtonText: this.approvalMessage.yes,
            cancelButtonText: this.approvalMessage.no,
            type: "warning",
          })
          .then(() => {
            this.$store
              .dispatch("b0101Top", this.B0101VueForm)
                .then((response) => {
                  this.$router.push({
                    query: { data: response.data.data },
                  });
                  // テーブルデータを取得する
                  this.positionList = response.data.data;
                  // データ数を取得する
                  this.pagination.total = this.positionList.length;
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

    // 全選択ボタン
        toggleSelection(rows) {
          if (rows) {
            this.B0101VueForm.positionIds = rows.positionIds;
            rows.forEach((row) => {
              this.$refs.multipleTable.toggleRowSelection(row);
            });
          } else {
            this.B0101VueForm.positionIds = [];
            this.clearSelection();
          }
        },

    // 新規画面へ
    toB0102Registered() {
      this.$router.push({ path: "b0102Registered" });
    },

    // 詳細情報画面へ
    toB0102Detailed() {
      console.log("detailed", this.detailedForm);
      setTimeout(() => {
        this.$router.push({
          path: "/b0102Detailed",
          query: { flight: JSON.stringify(this.detailedForm) },
          
        });
      }, 1);
    },

    // 情報修正画面へ
    toB0102Modify() {
      setTimeout(() => {
        this.$router.push({
        path: "/b0102Modify",
        query: { flight: JSON.stringify(this.detailedForm) },
      });
    }, 1);
    },
 
  },
};
</script>


<style lang="scss" scoped>
.el-icon-back,
.el-icon-document-remove,
.el-icon-search
 {
  font-size: 30px;
}
</style>

<style>
/* 主体页面灰色 */
.position_body {
  background-color: #f6f6f6;
}
/* 两个主体部分边框阴影，白色背景 */
.position_select,
.position_data {
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);
  background-color: #ffffff;
}
/* 内容body、两个主体外边距 */
.position_body,
.position_data,
.data_select {
  margin: 1vh, 1vh, 0px, 0px;
}
/* 面接一覧标题右移1% */
.position_title {
  margin-left: 1%;
}
/* 两部分主体宽80vw，居中 */
.position_select,
.position_data {
  width: 80vw;
  margin: auto;
}
/* 行上下内边距填充1vh */
.el-row {
  padding-top: 1vh;
  padding-bottom: 1vh;
}
/* 部分文字上下边距1vh，白底蓝字粗体 */
.position_title,
.blue_font {
  margin-top: 1vh;
  margin-bottom: 1vh;
  background-color: #ffffff;
  color: #006699;
  font-weight: 600;
  font-size: 15px;
}
/* 一般表示文字用 */
.nomail_font {
  margin-top: 1vh;
  margin-bottom: 1vh;
  font-size: 15px;
}
/* 職位一覧字号20 */
.position_title {
  font-size: 20px;
}
/* 灰色上边线，上内边距 */
.select_body {
  border-top: 2px solid#f6f6f6;
  padding-top: 2vh;
}
/* 检索按钮所在div内边距，底部外边距 */
.b0101_button {
  padding-top: 2vh;
  padding-bottom: 5vh;
  margin-bottom: 2vh;
  margin-left: 15vh;
}
/* 页眉页脚宽 */
.header,
.footer {
  width: 100vw auto;
}
/*按钮本体*/
.b0101Button {
  width: 110px;
}
.button {
  margin-left: 90%;
  margin-bottom: 2vh;
}
.demo-table-expand {
    font-size: 0;
  }
  .demo-table-expand label {
    width: 100px;
    color: #99a9bf;
  }
  .demo-table-expand .el-form-item {
    margin-left: 5%;
    margin-right: 0;
    margin-bottom: 0;
    width: 40%;
  }

</style>
