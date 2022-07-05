<template>
  <span>
    <el-tooltip effect="light" content="宛先" placement="top">
      <el-link @click="userGet" type="primary" :underline="false">
        <i class="el-icon-search"></i>
      </el-link>
    </el-tooltip>
    <el-dialog title="宛先一覧" :visible.sync="dialogTableVisible" width="80%" @close="resetForm">
      <el-row type="flex" justify="end" class="buttonRow">
      <!-- </el-row> -->
        <!-- <el-row > -->
        <el-col :span="1"></el-col>
        <el-col :span="7">
          <el-form-item label="ユーザー名：" label-width="100px"  prop="userName">
            <el-input v-model="SelectForm.userName" placeholder="ユーザー名を入力してください" />
          </el-form-item>
          
        </el-col>
        <el-col :span="7">
          <el-form-item label="会社名：" label-width="100px"  prop="companyNm">
            <el-input v-model="SelectForm.companyNm" placeholder="会社名を入力してください" />
          </el-form-item>
        </el-col>
        <el-col :span="7">
          <el-form-item label="ユーザーメール：" label-width="150px" prop="userMail">
            <el-input v-model="SelectForm.userMail" placeholder="メールを入力してください" />
          </el-form-item>
        </el-col>
        <el-col :span="2"></el-col>
      </el-row>
      <div class="a0701_button">
        <el-row type="flex" justify="center">
          <el-col :span="4">
            <el-tooltip effect="light" content="条件クリア" placement="top">
              <el-link @click="resetForm" type="primary" :underline="false" class="buttonWidth">
                <i class="el-icon-delete"></i>
              </el-link>
            </el-tooltip>
          </el-col>
          <el-col :span="4">
            <el-tooltip effect="light" content="検索" placement="top">
              <el-link @click="userGet" type="primary" :underline="false" class="buttonWidth">
                <i class="el-icon-search"></i>
              </el-link>
            </el-tooltip>
          </el-col>
          <el-col :span="4">
            <el-tooltip effect="light" content="選択" placement="top">
              <el-link @click="selectData" type="primary" :underline="false" class="buttonWidth">
                <i class="el-icon-user"></i>
              </el-link>
            </el-tooltip>
          </el-col>
          <el-col :span="4">
            <el-tooltip effect="light" content="全体選択" placement="top">
              <el-link @click="selectAll" type="primary" :underline="false" class="buttonWidth">
                <i class="el-icon-monitor"></i>
              </el-link>
            </el-tooltip>
          </el-col>
        </el-row>
      </div>
      <div class="divStyle"></div>
      <div class="dialogHeight">
        <!-- <div class="postalFont">
          <el-form :model="SelectForm" ref="SelectForm">
            
            <el-form-item class="itemStyle"> -->
              <!-- <el-button type="primary" @click="resetForm" class="buttonWidth">
                条件クリア
              </el-button>
              <el-button icon="el-icon-search" type="primary" @click="submitForm('ruleForm')" class="buttonWidth">
                検索
              </el-button> -->
              
            <!-- </el-form-item>
          </el-form>
        </div> -->
        <el-table
          class="postalTable"
          ref="multipleTable"
          :data="tableDataComputed"
          tooltip-effect="dark"
          @row-click="getRowData"
          @selection-change="selectionChange"
          highlight-current-row
          :row-key="getRowKeys"
          height="250"
        >
          <el-table-column type="selection" :reserve-selection="true"/>
          <el-table-column
            prop="userNm"
            label="ユーザー名"
            sortable
          />
          <el-table-column
            prop="companyNm"
            label="会社名"
            sortable
          />
          <el-table-column
            prop="authority"
            label="権限"
            sortable
          />
          <el-table-column
            prop="tel"
            label="電話番号"
            sortable
          />
          <el-table-column
            prop="mail"
            label="メール"
            sortable
          />
        </el-table>
        <div class="paginationStyle">
          <el-row type="flex" justify="center">
            <el-col :span="12">
              <el-pagination
                small
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
    </el-dialog>
  </span>
</template>
<script>
export default {
  data() {
    return {
      // 入力内容
      SelectForm: {
        userMail: "",
        companyNm: "",
        userName: "",
      },
      dialogTableVisible: false,
      // 複数チェックボックス
      multipleSelection: [],
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
      // 転送用form
      SelectVueForm: {
        userCd: Number,
        userCds: Number,
        userNm: "",
      },
      // 行目内容
      rowData: {
        userCd: "",
        userNm: "",
        companyNm: "",
        authority: "",
        tel: "",
        mail: "",
      },
      // テーブル内容
      tableData: [],
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
  },
  methods: {
    // クリアボタン
    resetForm() {
      this.SelectForm = {
        userMail: "",
        companyNm: "",
        userName: "",
      };
      this.$nextTick(()=>{
        this.$refs["SelectForm"].clearValidate(); 
      });
    },
    // チェックボックスたくさん選択
    getRowKeys(row){
      return row.userCd;
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
      this.SelectVueForm.userCd = row.userCd;
    },
    // チェックボックス
    selectionChange(val) {
      this.multipleSelection1 = [];
      this.multipleSelection2 = [];
      for (var i = 0; i < val.length; i++) {
        this.multipleSelection1.push(val[i].userCd);
        this.multipleSelection2.push(val[i].userNm);
      }
      this.SelectVueForm.userCds = this.multipleSelection1;
      this.SelectVueForm.userNm = this.multipleSelection2;
    },
    // dialogの表示
    showDialog() {
      this.isShow = true;
    },
    // 全体選択
    selectAll() {
       // 子画面を閉める
      this.dialogTableVisible = false;
      // すべてユーザーを輸入欄に転送
      this.$emit("userSet",0,"");
    },
    // 選択
    selectData() {
       // 子画面を閉める
      this.dialogTableVisible = false;
      // 選択ユーザーを輸入欄に転送
      this.$emit("userSet", this.SelectVueForm.userCds, this.SelectVueForm.userNm);
    },
    // ユーザーを取得する
    userGet() {
      this.$parent.clearValidate();
      // 子画面を表示する
      this.dialogTableVisible = true;
      this.loading = true;
      this.$store
        // Stringスプライシング
        .dispatch("userSelect", this.SelectForm)
        .then((response) => {
          this.loading = false;
          let code = response.data.code;
          if (code == 200) {
            // this.$router.push({
            //   query: { data: response.data.data },
            // });
            this.tableData = response.data.data
            this.pagination.total = this.tableData.length;
            //画面チェックボックスクリア
            this.$refs.multipleTable.clearSelection(); 
            // this.resetForm();
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
// POP HEIGHT設定
.dialogHeight{
  height: auto;
  overflow: auto;
}
// 選択ボタン
.buttonRow{
  margin-bottom: 30px;
}
// 检索按钮所在div内边距，底部外边距
.a0701_button {
  margin-bottom: 2vh;
}
// 検索枠STYLE
.postalFont {
  text-align: center;
  font-weight: 600;
  font-size: 16px;
  margin-right: 20px;
  margin-bottom: 24px;
}
// テーブル幅
.postalTable {
  width: 100%;
}
// 赤字
.red {
  color: red;
  margin-right: 5px;
}
// 総計div
.totalDiv {
  margin-top: 20px;
  margin-left: 10px;
}
.buttonWidth{
  margin-right: 10%;
  width: 8em;
}
.itemStyle{
  margin: 40px 0px;
}
// saveアイコンの大きさ
.el-icon-circle-check,
.el-icon-circle-close,
.el-icon-delete,
.el-icon-refresh-left,
.el-icon-search,
.el-icon-monitor,
.el-icon-user
 {
  font-size: 30px;
}
.el-dialog__body{
  padding: 10px 10px;
}
::v-deep div > .el-table th {
  overflow: hidden;
  -ms-user-select: none;
  -webkit-user-select: none;
  -moz-user-select: none;
  user-select: none;
  background: #e4f5f7;
}
/* ページネーションのデータ数毎ページの幅 */
::v-deep .el-pagination .el-select .el-input {
  width: 2rem;
}
</style>
