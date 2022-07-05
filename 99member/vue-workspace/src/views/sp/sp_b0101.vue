<template>
  <div class="position_page">
    <el-container>
      <el-header>
        <div class="header">
          <HomeHeader />
        </div>
      </el-header>
      <el-form
        :model="positionForm"
        rules="rules"
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
            <div class="select_body">
              <el-row :gutter="1">
                <el-col :span="2" :offset="1">
                  <div class="blue_font">職位名：</div>
                </el-col>
                <el-col :span="3">
                  <div>
                    <el-input
                      type="text"
                      v-model="positionForm.positionNm"
                      placeholder="職位名"
                    >
                    </el-input>
                  </div>
                </el-col>
                <el-col :span="2" :offset="1">
                  <div class="blue_font">状態：</div>
                </el-col>
                <el-col :span="3">
                  <div>
                    <el-select
                      v-model="positionForm.statusFlg"
                      size="medium"
                      @change="b0101select"
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
                <div>
                  <el-button type="primary" @click="resetForm" class="b0101Button">
                    条件クリア
                  </el-button>
                </div>
              </el-col>
              <el-col :span="4">
                <div>
                  <el-button
                    type="primary"
                    @click="getPositionData"
                    icon="el-icon-search"
                    class="b0101Button"
                  >
                    検索
                  </el-button>
                </div>
              </el-col>
              <el-col :span="4">
                <div>
                  <el-button type="primary" @click="toLastPage" class="b0101Button">
                    戻る
                  </el-button>
                </div>
              </el-col>
            </el-row>
          </div>
          </div>
          
          <div class="position_data">
            <div class="data_body">
              <el-table ref="multipleTable" :data="positionList">
                <el-table-column type="selection" fixed="left" width="50" />
                <el-table-column
                  v-if="false"
                  prop="positionId"
                  label="職位ID"
                  width="120"
                  sortable
                />
                <el-table-column
                  prop="positionNm"
                  label="職位名"
                  width="120"
                  sortable
                />
                <el-table-column
                  prop="industryNm"
                  label="業種"
                  width="120"
                  sortable
                />
                <el-table-column
                  prop="jobTypeNm"
                  label="職種"
                  width="120"
                  sortable
                />
                <el-table-column
                  prop="checkStatus"
                  label="確認状態"
                  width="120"
                  sortable
                >
                <template slot-scope="scope">
               {{checkStatus [scope.row.checkStatus]}} 
                </template>
                </el-table-column>
                <el-table-column
                  prop="workAddress1"
                  label="場所"
                  width="120"
                  sortable
                />
                <el-table-column
                  prop="station"
                  label="最寄駅"
                  width="120"
                  sortable
                />
                <el-table-column
                  prop="expDate"
                  label="有効期限"
                  width="120"
                  sortable
                />
                <el-table-column
                  prop="onlineStatus"
                  label="募集状態"
                  width="120"
                  sortable
                >
                <template slot-scope="scope">
               {{onlineStatus [scope.row.onlineStatus]}} 
                </template>
                </el-table-column>
                <el-table-column
                  prop="peoCnt"
                  label="応集人数"
                  width="120"
                  sortable
                />
                <el-table-column
                  prop="expYears"
                  label="必須経験年数"
                  width="130"
                  sortable
                />
                <el-table-column
                  prop="topStatus"
                  label="トップ状態"
                  width="120"
                  sortable
                >
                <template slot-scope="scope">
               {{topStatus [scope.row.topStatus]}} 
                </template>
                </el-table-column>
                <el-table-column
                  prop="workTimeFrom"
                  label="勤務時間"
                  width="120"
                  sortable
                />
                <el-table-column
                  prop="updateTime"
                  label="更新日時"
                  width="120"
                  sortable
                />
                <el-table-column fixed="right" width="50">
                  <el-button type="text" size="large" @click="toB0502Detailed">
                    <em class="el-icon-document" />
                  </el-button>
                </el-table-column>
                <el-table-column fixed="right" width="50">
                  <el-button type="text" size="large" @click="toB0502Modify">
                    <em class="el-icon-edit" />
                  </el-button>
                </el-table-column>
                <el-table-column fixed="right" width="50">
                  <el-button type="text" size="large" @click="deleteOne">
                    <em class="el-icon-delete" />
                  </el-button>
                </el-table-column>
              </el-table>
            </div>

            <div class="multiple_option">
              <!--トップへ-->
              <el-row type="flex" justify="end">
                <el-col :span="1">
                  <el-button
                    type="text"
                    @click="handleClick(scope.row)"
                    size="large"
                  >
                    <i class="el-icon-top" />
                  </el-button>
                </el-col>
                <!--オンライン-->
                <el-col :span="1">
                  <el-button
                    type="text"
                    @click="handleClick(scope.row)"
                    size="large"
                  >
                    <i class="el-icon-circle-plus" />
                  </el-button>
                </el-col>
                <!--オフライン-->
                <el-col :span="1">
                  <el-button
                    type="text"
                    @click="handleClick(scope.row)"
                    size="large"
                  >
                    <i class="el-icon-remove" />
                  </el-button>
                </el-col>
                <!--削除-->
                <el-col :span="1">
                  <el-button
                    type="text"
                    @click="handleClick(scope.row)"
                    size="large"
                  >
                    <i class="el-icon-delete" />
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
  name: "b0101Select",
  components: {
    HomeHeader,
    HomeFooter,
  },
  created() {
    this.positionForm.displayFlg = this.position_display[1].label;
  },
  mounted() {
    document.title = "職位一覧";
    this.getPositionData();
  },
  data() {
    return {
      positionForm: {
        //状態
        statusFlg: "",
        //職位名称
        positionNm: "",
        //表示件数
        displayNum: "",
        //並び順
        OrderFlg: "",
        //並び順
        industryId: "",
      },
      onlineStatus: { 
        '0' : 'オンライン',
        '1' : 'オフライン',
        },
      checkStatus:{ 
        '0' : '確認未済',
        '1' : '確認済み',
        '2' : '拒否する',
      },
      topStatus: { 
        '0' : '未トップ',
        '1' : 'トップ中',
        },
      // ページネーション
      pagination: {
        // テーブルのデータ
        positionList: "",
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
        companyId: 1,
        userCd: 1,
        positionNm: "",
        onlineStatus: "",
        checkStatus: "",
        positionId: "",
      },
      position_status: [
        { value: "0", label: "確認未済" },
        { value: "1", label: "確認済み" },
        { value: "2", label: "拒否する" },
      ],
      statusFlg: "0",
      multipleSelection: [],
      currentPage1: 5,
      currentPage2: 5,
      currentPage3: 5,
      currentPage4: 4,
    };
  },
  methods: {
    // クリアボタン
    resetForm() {
      this.positionForm = {
        positionNm: "",
        statusFlg: "",
      };
    },
    // 戻るボタン
    toLastPage() {
      console.log("戻る");
      this.$router.replace({ name: "b0003" });
      this.$router.go(-2);
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
          // データ数を取得する
          this.pagination.total = this.positionList.length;
          console.log("response", response.data.data);
        });
    },
// 検索条件の値を設定する
    setPositionData() {
        this.B0101VueForm.positionNm = this.positionForm.positionNm;
        this.B0101VueForm.checkStatus = this.positionForm.statusFlg;
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
          console.log("positionIds", this.B0101VueForm.positionId);
          this.$store
            .dispatch("b0101Delete", this.B0101VueForm.positionId)
            .then((response) => {
              this.$router.push({
                query: { data: response.data.data },
              });
              // テーブルデータを取得する
              this.positionList = response.data.data;
              // データ数を取得する
              this.pagination.total = this.positionList.length;
              console.log("response", response.data.data);
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
  width: 90vw;
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
.position_button {
  padding-top: 2vh;
  padding-bottom: 2vh;
  margin-bottom: 2vh;
}
/* 页眉页脚宽 */
.header,
.footer {
  width: 100vw auto;
}
/* 按钮本体*/
.b0501Button {
  width: 110px;
  margin:10px 5px 15px 20px;
}
</style>
