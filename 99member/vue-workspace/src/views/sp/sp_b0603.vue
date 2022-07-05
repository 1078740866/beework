<template>
  <div class="pageStyle">
    <HomeHeader />
    <div class="titleStyle">
      <div
        v-text="titleName"
        @click="selectIsShow = !selectIsShow"
        class="titleNameStyle"/>
      <el-collapse-transition>
        <div v-show="selectIsShow" class="selectStyle">
          <el-form ref="loginForm">
            <el-row>
              <el-col :span="22" :offset="1">
                <el-form-item>
                  <el-input
                    v-model="briefingApplSelectForm.name"
                    placeholder="名前を入力してください"
                    clearable
                  >
                  </el-input>
                </el-form-item>
              </el-col>
              </el-row>
     <el-row type="flex" justify="space-between"> 
         <div>
            <el-button
              type="primary"
              @click="getBriefingApplData"
              icon="el-icon-search"
              class="buttonWidth"
            >
              検索
            </el-button>
         </div>
         <div>   
            <el-button type="primary" @click="goBack" class="buttonWidth">
              戻る
            </el-button>
         </div>
        </el-row>
        </el-form>
      </div>
      </el-collapse-transition>
    </div>
    <div class="bodyStyle" @dblclick="tableIsShow = !tableIsShow">
      <el-collapse-transition>
        <div class="tableStyle" v-show="tableIsShow">
          <el-table :data="getBriefingApplList">
            <el-table-column prop="name" label="応募者" width="100">
              <template v-slot="fullName">
                {{ fullName.row.firstName }} {{ fullName.row.lastName }}
              </template>
            </el-table-column>
            <el-table-column prop="birthday" label="生年月日" width="100" sortable />
            <el-table-column prop="sex" label="性別" width="80">
              <template slot-scope="scope">
               {{sex [scope.row.sex]}} 
              </template>
            </el-table-column>
            <el-table-column prop="prefeNm" label="住所" width="120" />
            <el-table-column prop="station" label="最寄駅" width="100" />
            <el-table-column prop="graduationSchool" label="卒業学校" width="100" />
            <el-table-column prop="graduationMajor" label="専攻" width="120"/>
            <el-table-column prop="userTel" label="電話番号" width="100"/>
            <el-table-column prop="workSituation" label="仕事状況" width="120">
              <template slot-scope="scope">
               {{workSituation [scope.row.workSituation]}} 
              </template>
            </el-table-column>

          </el-table>
        </div>
      </el-collapse-transition>

      <div class="paginationStyle">
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
    <HomeFooter />
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
  name: "b0603",
  components: {
    HomeHeader,
    HomeFooter,
  },
  mounted() {
    document.title = "説明会応募者一覧";
    this.getBriefingApplData();
  },
  computed: {
    getBriefingApplList() {
      return (
        this.briefingApplList.slice(this.pagination.dataStart, this.pagination.dataEnd) || ""
      );
    },
  },
  destroyed() {
    // ページジャンプ動作の監視を終了します
    window.removeEventListener("popstate", this.goBack, false);
  },
  data() {
    return {
      // タイトル名
      titleName: "説明会応募者一覧",
      // タイトルをクリック選択が非表示にする
      selectIsShow: true,
      // テーブルが非表示にする
      tableIsShow: true,
      // item内容
      columeList: {
        briefingId: "説明会ID",
        companyId: "会社ID",
        positionId: "応募者ID",
        userCd: "ユーザーコード",
        name: "名",
        userTel: "電話番号",
        birthday: "生年月日",
        sex: "性別",
        graduationSchool: "卒業学校",
        graduationMajor: "専攻",
        workSituation: "仕事状況",
        station: "最寄駅",
        prefeNm: "住所",
      },
      sex: { 
        '0' : '男',
        '1' : '女',
      },
      workSituation: { 
        '0' : '応募中',
        '1' : '在職中',
      },
      // 檢索条件
      briefingApplSelectForm: {
        companyId: 1,
        briefingId: "",
        name: "",
      },
      // テーブルのデータ
      briefingApplList: [],
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
      B0603VueForm: {
        companyId: Number,
        briefingId: Number,
        name: "",
      },
      // 行目内容
      rowData: {
        applicantId: "",
        companyId: "",
        briefingId: "",
        firstName: "",
        lastName: "",
        birthday: "",
        station: "",
        sex: "",
        graduationSchool: "",
        graduationMajor: "",
        userTel: "",
        workSituation: "",
      },

      // dialogの表示
      isShow: false,
    };
  },
  methods: {
    // テーブルデータ取得
    getBriefingApplData() {
      this.setBriefingApplData();
      this.$store.dispatch("b0603Search", this.B0603VueForm).then((response) => {
        this.$router.push({
          query: { data: response.data.data },
        });
        this.briefingApplList = response.data.data;
        this.pagination.total = this.briefingApplList.length;
      });
    },
    // 検索条件の値を設定する
    setBriefingApplData() {
      this.B0603VueForm.name = this.briefingApplSelectForm.name;
      this.B0603VueForm.briefingId = this.$route.query.briefingId;
    },
    // 戻るボタン
    goBack() {
      history.go(-2);
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
    // dialogの表示
    showDialog() {
      this.isShow = true;
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
  width: 90vw;
  margin-left: 2vw;
  margin-right: 1vw;
  box-shadow: 0 2px 4px #0000000c, 0 0 6px #00000028;
}
.titleNameStyle {
  color: #006699;
  margin: 1vh 0;
  padding: 1vh 1vw;
  font-weight: 600;
  font-size: 1em;
  border-bottom: 2px solid#f6f6f6;
}
.selectStyle,
.tableStyle,
.buttonStyle,
.paginationStyle {
  padding: 4vh;
}
.buttonWidth {
  width: 110px;
  margin:10px 5px 15px 20px;
}
.dialogStyle {
  margin: 10px;
  font-size: 12px;
}
.rangeStyle {
  width: 100%;
  max-width: 400px;
}
</style>
