<template>
  <div class="pageStyle">
    <HomeHeader />
    <div class="titleStyle">
      <el-row>
        <el-col :span="24"> 
          <el-tabs type="border-card" v-model="activeName">
            <el-tab-pane name="send">
              <div slot="label"><i class="el-icon-s-comment"></i> 送信</div>
              <el-collapse-transition>
                <div v-show="selectIsShow" class="selectStyle">
                  <el-form 
                  :rules="rules" 
                  :model="receptionSelectForm" 
                  :label-position="labelPosition"
                  ref="receptionSelectForm"
                  :validate-event="false"
                  >
                    <el-form-item prop="address" label="宛先選択：" label-width="250px" class="itemStyle">
                      <el-input 
                        class="userInput" 
                        disabled 
                        v-model="receptionSelectForm.address" 
                        placeholder="宛先を選択してください" 
                      />
                      <userSelect
                        class="userButton"
                        @userSet="userSet"
                      />
                      <!-- <el-tooltip class="item" effect="light" placement="top" v-show="receptionSelectForm.address">
                        <div slot="content">
                          {{ receptionSelectForm.address }}
                        </div>
                        <i class="el-icon-info"/>
                      </el-tooltip> -->
                    </el-form-item>
                    <el-form-item prop="subject" label="件名：" label-width="250px" class="itemStyle">
                      <el-input 
                      class="userInput" 
                      v-model="receptionSelectForm.subject" 
                      placeholder="件名を入力してください" 
                      show-word-limit
                      maxlength="50"
                      />
                    </el-form-item>
                    <el-form-item prop="message" label="メッセージ：" label-width="250px" class="itemStyle"> 
                      <el-input
                      type="textarea"
                      class="userInput"
                      :rows="10"
                      placeholder="メッセージを入力してください"
                      v-model="receptionSelectForm.message"
                      maxlength="1000"
                      show-word-limit
                      >
                      </el-input>
                    </el-form-item>
                    <el-form-item label-width="30%" class="itemStyle">
                      <!-- <el-button icon="el-icon-refresh" type="primary" @click="resetForm()" class="buttonWidth">
                        クリア
                      </el-button> -->
                      <!-- <el-button icon="el-icon-message" type="primary" @click="sendForm()" class="buttonWidth">
                        送信
                      </el-button> -->
                      <el-tooltip effect="light" content="条件クリア" placement="top">
                        <el-link @click="resetForm" type="primary" :underline="false" class="buttonWidth">
                          <i class="el-icon-document-remove"></i>
                        </el-link>
                      </el-tooltip>
                      <el-tooltip effect="light" content="送信" placement="top">
                        <el-link @click="sendForm" type="primary" :underline="false" class="buttonWidth">
                          <i class="el-icon-message"></i>
                        </el-link>
                      </el-tooltip>
                      <el-tooltip effect="light" content="戻る" placement="top">
                        <el-link @click="routerBack" type="primary" :underline="false" class="buttonWidth">
                          <em class="el-icon-back"/>
                        </el-link>
                      </el-tooltip>
                    </el-form-item>
                  </el-form>
                </div>
              </el-collapse-transition>
            </el-tab-pane>
            <el-tab-pane name="sendList">
              <div slot="label" @click="getData"><i class="el-icon-tickets"></i>送信履歴</div>
              <div>
                <el-collapse-transition>
                  <div class="selectStyle">
                    <el-form ref="receptionSelectForm2">
                      <el-row>
                        <el-col :span="10">
                          <el-form-item label="宛先：" label-width="150px">
                            <el-input v-model="receptionSelectForm2.addr" placeholder="宛先の検索" />
                          </el-form-item>
                        </el-col>
                        <el-col :span="10">
                          <el-form-item label="件名：" label-width="150px">
                            <el-input v-model="receptionSelectForm2.subj" placeholder="件名の検索" />
                          </el-form-item>
                        </el-col>
                      </el-row>
                      <el-row>
                        <el-col :span="20">
                          <el-form-item label="送信日時：" label-width="150px">
                            <el-date-picker
                              v-model="receptionSelectForm2.dateTime1"
                              placeholder="開始日時"
                              value-format="yyyy/MM/dd HH:mm:ss"
                              class="rangeStyle"
                              align="right"
                              type="datetime"
                            />
                            <label> - </label>
                            <el-date-picker
                              v-model="receptionSelectForm2.dateTime2"
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
                    <el-col :span="6">
                      <!-- <el-button type="primary" @click="resetForm2" class="buttonWidth">
                        条件クリア
                      </el-button> -->
                      <el-tooltip effect="light" content="条件クリア" placement="top">
                        <el-link @click="resetForm2" type="primary" :underline="false">
                          <i class="el-icon-document-remove"></i>
                        </el-link>
                      </el-tooltip>
                    </el-col>
                    <el-col :span="6">
                      <!-- <el-button
                        type="primary"
                        @click="getData"
                        icon="el-icon-search"
                        class="buttonWidth"
                      >
                        検索
                      </el-button> -->
                      <el-tooltip effect="light" content="検索" placement="top">
                        <el-link @click="getData" type="primary" :underline="false" class="buttonWidth">
                          <i class="el-icon-search"></i>
                        </el-link>
                      </el-tooltip>
                    </el-col>
                    <el-col :span="6">
                      <el-tooltip effect="light" content="戻る" placement="top">
                        <el-link @click="routerBack" type="primary" :underline="false" class="buttonWidth">
                          <em class="el-icon-back"/>
                        </el-link>
                      </el-tooltip>
                    </el-col>
                  </el-row>
                </div>
              </div>
              <div>
                <el-collapse-transition>
                  <div class="tableStyle">
                    <el-table
                      ref="multipleTable"
                      :data="tableDataComputed"
                      :default-sort="{ prop: 'aDate', order: 'descending' }"
                      tooltip-effect="dark"
                      @row-click.capture="getRowData"
                      highlight-current-row
                      @row-dblclick="toA0802Detailed"
                    >
                      <el-table-column prop="internalMessageId" v-if="false" label="メッセージID" sortable />
                      <el-table-column prop="name" label="宛先" sortable />
                      <el-table-column prop="subject" label="件名" sortable />
                      <el-table-column prop="aDate" label="送信日時" sortable />
                      <el-table-column prop="status" label="状態" sortable >
                        <template slot-scope="scope"> 
                          {{ statusData[scope.row.status] }}
                        </template>
                      </el-table-column>
                      <el-table-column fixed="right" label="操作">
                        <el-tooltip content="詳細" placement="top" effect="light">
                          <el-button type="text" @click="toA0802Detailed">
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
            </el-tab-pane>
          </el-tabs>
        </el-col>
      </el-row>
    </div>
    <HomeFooter />
  </div>
</template>
<script>
import HomeHeader from "./components/AdministratorHeader";
import HomeFooter from "./components/HomeFooter";
import userSelect from "./components/userSelectPop";
import { validateNecessary } from '../utils/validate'
export default {
  name: "a0801",
  components: {
    HomeHeader,
    HomeFooter,
    userSelect,
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
      titleName: "送信",
      // タイトルをクリック選択が非表示にする
      selectIsShow: true,
      //表单对齐位置
      labelPosition: 'right',
      disabled: false,
      //初期表示TABS
      activeName: 'send',
      // 入力内容
      receptionSelectForm: {
        userCd:Number,
        address: "",
        subject: "",
        message: "",
      },
      // 入力内容
      receptionSelectForm2: {
        addr: "",
        subj: "",
        dateTime1: "",
        dateTime2: "",
      },
      //チェック用
      rules: {
        address: { required: true, message: '宛先を選択してください', trigger: 'blur'},
        subject: [validateNecessary("件名")],
        message: [validateNecessary("メッセージ")],
      },
      // 転送用form
      A0801VueForm: {
        sendId: Number,
        recid: [],
        subject: "",
        internalMessageTextId: Number,
        internalMessageText: "",
      },
      // dialogの表示
      isShow: false,
      statusData: {
        '0': '未閲覧',
        '1': '閲覧済',
        '2': 'システム通知',
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
    "receptionSelectForm2.dateTime1"(newVal) {
      if (newVal == null) {
        this.receptionSelectForm2.dateTime1 = '';
      }
    },
    "receptionSelectForm2.dateTime2"(newVal) {
      if (newVal == null) {
        this.receptionSelectForm2.dateTime2 = '';
      }
    },
  },
  methods: {
    //POP画面取得データ
    userSet(date1,date2) {
      if(date1 === 0){
        this.receptionSelectForm.userCd = [0];
        this.receptionSelectForm.address = "すべてユーザー";
      }else if(date1 == null){
        this.receptionSelectForm.address = "すべてユーザー";
      }else{
        this.receptionSelectForm.userCd = date1;
        this.receptionSelectForm.address = date2;
      }
    },
    // クリアボタン
    resetForm() { 
      this.$refs.receptionSelectForm.resetFields(); 
    },
    // クリアボタン
    resetForm2() {
      this.receptionSelectForm2 = {
        addr: "",
        subj: "",
        dateTime1: "",
        dateTime2: "",
      };
    },
    // 戻るボタン
    goBack() {
      history.go(-2)
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
    // 検索条件の値を設定する
    setData() {
      this.A0801VueForm.recid = this.receptionSelectForm.userCd;
      this.A0801VueForm.subject = this.receptionSelectForm.subject;
      this.A0801VueForm.internalMessageText = this.receptionSelectForm.message;
    },
    // 送信ボタン押下
    sendForm() {
      // 提出FORM時チェック
      this.$refs.receptionSelectForm.validate((valid) => {
        if (valid) {
          this.setData();
          this.$store.dispatch("a0801Insert", this.A0801VueForm).then((response) => {
            this.loading = false;
            let code = response.data.code;
            if (code == 200) {
              this.$message.success(response.data.message);
              this.resetForm();
            } else if (code == 404) {
              this.$message.error(response.data.message);
            } else {
              this.$router.push({
                path: "/error",
                query: { message: response.data.message },
              });
            }
          });
        }
      }); 
    },
    // 検索条件の値を設定する
    setData2() {
      this.B0901VueForm.address = this.receptionSelectForm2.addr;
      this.B0901VueForm.subject = this.receptionSelectForm2.subj;
      if (this.receptionSelectForm2.dateTime1.length != 0) {
        this.B0901VueForm.dateFrom = this.receptionSelectForm2.dateTime1.substring(0,19);
      }else{
        this.B0901VueForm.dateFrom = '';
      }
      if (this.receptionSelectForm2.dateTime2.length != 0) {
        this.B0901VueForm.dateTo = this.receptionSelectForm2.dateTime2.substring(0,19);
      }else{
        this.B0901VueForm.dateTo = '';
      }
    },
     // テーブルデータ取得
    getData() {
      this.setData2();
      this.$store.dispatch("a0801AddressList", this.B0901VueForm).then((response) => {
        this.$router.push({
          query: { data: response.data.data },
        });
        this.tableData = response.data.data
        this.pagination.total = this.tableData.length;
      });
    },
    // 詳細情報画面へ
    toA0802Detailed() {
      console.log(this.B0901VueForm);
      setTimeout(() => {
        this.$router.push({
          path: "/a0802",
          query: { a0802Id: this.B0901VueForm.internalMessageId },
        });
      }, 1);
    },
    routerBack(){
      this.$router.push({
        path: "/a0003",
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
  width: 80vw;
  margin-left: 10vw;
  margin-top: 5vh;
  margin-bottom: 2vh;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);
}
.titleNameStyle {
  color: #006699;
  font-weight: 600;
  font-size: 24px;
  margin-top: 1vh;
  padding: 2vh;
  border-bottom: 2px solid#cfcfcf;
}
.buttonStyle,
.paginationStyle {
  font-size: 18px;
  padding: 4vh;
}
.tableStyle{
  border-top: 1px solid #cfcfcf;
}
.selectStyle{
  font-size: 18px;
  padding: 4vh;
}
.buttonWidth {
  width: 8em;
  margin-right: 50px;
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
            font-size: 24px ;
            width: 70%;
            text-align: center;
            height: 50px;
            line-height: 50px;
            padding: 0px;
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
// 宛先按钮
.userButton{
  width: 8em;
  display: inline;
  padding-left: 15px;
}
// 宛先输入框
.userInput{
  width: 80%;
}
// 宛先输入框
.userInput1{
  margin-left: 2%;
  width: 75%;
}
// 宛先输入框深层
::v-deep div > .el-input.is-disabled .el-input__inner{
  display: inline;
}
// rowStyle
.rowStyle{
  margin-bottom: 4vh;
}
// colStyle
.colStyle{
  text-align: right;
}
// Tooltip 
.item{
  margin-left: 1vw;
  font-size: 24px;
}
.itemStyle{
  margin: 40px 0px;
}
.subjectLabel{
  width: 8em;
  display: inline;
  text-align: right;
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
.el-icon-message
 {
  font-size: 40px;
}
.el-icon-document{
  font-size: 30px;
}
/* ページネーションのデータ数毎ページの幅 */
::v-deep .el-pagination .el-select .el-input {
  width: 2rem;
}
</style>
