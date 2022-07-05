<template>
  <div class="PositionListFromHome">
    <el-container>
      <el-header class="homeHeader">
        <div class="homeHeaderRoot">
          <el-menu
            class="el-menu-header"
            mode="horizontal"
            text-color="#2d8cf0"
          >
            <div class="logoImg" @click="toHome(seatchNm)">
              <el-image :src="require('@/assets/b_home_logo2.png')" class="logoImg" />
            </div>
            <el-menu-item class="space"></el-menu-item>
            <el-menu-item class="login">
              <el-link :underline="false" @click="toLogin" class="companyLogin"
                >会社ログイン</el-link
              >
            </el-menu-item>
            <el-menu-item class="login">
              <el-link :underline="false" @click="toC0001" class="applicantLogin">応募者ログイン</el-link>
            </el-menu-item>
          </el-menu>
        </div>
      </el-header>
      <div
        class="searchBackground"
      >
      <!--         :style="{ backgroundImage: 'url(' + require('@/assets/6.png') + ')' }" -->
        <div class="searchInput">
          <el-input
            placeholder="職位または会社を入力してください"
            v-model="searchNm"
            class="searchInputInner"
          >
            <el-button class="buttonSelect" slot="append" icon="el-icon-search" @click="getDataBySearchNm()"></el-button>
          </el-input>
        </div>
      </div>
      <el-form ref="loginForm" label-position="left" autocomplete="on">
        <el-main class="homeBody">
          <div class="bodyRoot">
            <div class="selectCoditionInfo">
              <el-row>
                <el-col :span="2"><div class="selectCodition">職位：</div></el-col>
                <el-col :span="2"><div v-bind:class=" activeClassForIndustryId==99 ? 'active' : '' " @click="chargeColorForIndustryId(99)" class="selectCodition">すべて</div></el-col>
                <el-col :span="2"><div v-bind:class=" activeClassForIndustryId==1 ? 'active' : '' " @click="chargeColorForIndustryId(1)" class="selectCodition">営業</div></el-col>
                <el-col :span="2"><div v-bind:class=" activeClassForIndustryId==3 ? 'active' : '' " @click="chargeColorForIndustryId(3)" class="selectCodition">販売</div></el-col>
                <el-col :span="5"><div v-bind:class=" activeClassForIndustryId==11 ? 'active' : '' " @click="chargeColorForIndustryId(11)" class="selectCodition">製造</div></el-col>
                <el-col :span="5"><div v-bind:class=" activeClassForIndustryId==5 ? 'active' : '' " @click="chargeColorForIndustryId(5)" class="selectCodition">サービス</div></el-col>
                <el-col :span="6"><div v-bind:class=" activeClassForIndustryId==6 ? 'active' : '' " @click="chargeColorForIndustryId(6)" class="selectCodition">娯楽</div></el-col>
              </el-row>
              <el-row>
                <el-col :span="2"><div class="selectCodition selectCodition_space"></div></el-col>
                <el-col :span="2"><div v-bind:class=" activeClassForIndustryId==8 ? 'active' : '' " @click="chargeColorForIndustryId(8)" class="selectCodition">理・美容</div></el-col>
                <el-col :span="4"><div v-bind:class=" activeClassForIndustryId==4 ? 'active' : '' " @click="chargeColorForIndustryId(4)" class="selectCodition">飲食</div></el-col>
                <el-col :span="5"><div v-bind:class=" activeClassForIndustryId==9 ? 'active' : '' " @click="chargeColorForIndustryId(9)" class="selectCodition">医療・介護</div></el-col>
                <el-col :span="5"><div v-bind:class=" activeClassForIndustryId==10 ? 'active' : '' " @click="chargeColorForIndustryId(10)" class="selectCodition">配達</div></el-col>
                <el-col :span="6"><div v-bind:class=" activeClassForIndustryId==7 ? 'active' : '' " @click="chargeColorForIndustryId(7)" class="selectCodition">教育・文化</div></el-col>
              </el-row>
              <el-row>
                <el-col :span="2"><div class="selectCodition selectCodition_space"></div></el-col>
                <el-col :span="2"><div v-bind:class=" activeClassForIndustryId==14 ? 'active' : '' " @click="chargeColorForIndustryId(14)" class="selectCodition">専門職</div></el-col>
                <el-col :span="4"><div v-bind:class=" activeClassForIndustryId==12 ? 'active' : '' " @click="chargeColorForIndustryId(12)" class="selectCodition">IT</div></el-col>
                <el-col :span="5"><div v-bind:class=" activeClassForIndustryId==15 ? 'active' : '' " @click="chargeColorForIndustryId(15)" class="selectCodition">土木・農水産</div></el-col>
                <el-col :span="5"><div v-bind:class=" activeClassForIndustryId==2 ? 'active' : '' " @click="chargeColorForIndustryId(2)" class="selectCodition">事務</div></el-col>
                <el-col :span="6"><div v-bind:class=" activeClassForIndustryId==13 ? 'active' : '' " @click="chargeColorForIndustryId(13)" class="selectCodition">出版</div></el-col>
              </el-row>
              <el-row class="selectCoditionRow2">
                <el-col :span="2"><div class="selectCodition">勤務地：</div></el-col>
                <el-col :span="2"><div v-bind:class=" activeClassForPrefeNm=='99' ? 'active' : '' " @click="chargeColorForPrefeNm('99')" class="selectCodition">すべて</div></el-col>
                <el-col :span="2"><div v-bind:class=" activeClassForPrefeNm=='東京都' ? 'active' : '' " @click="chargeColorForPrefeNm('東京都')" class="selectCodition">東京都</div></el-col>
                <el-col :span="2"><div v-bind:class=" activeClassForPrefeNm=='大阪府' ? 'active' : '' " @click="chargeColorForPrefeNm('大阪府')" class="selectCodition">大阪府</div></el-col>
                <el-col :span="2"><div v-bind:class=" activeClassForPrefeNm=='神奈川県' ? 'active' : '' " @click="chargeColorForPrefeNm('神奈川県')" class="selectCodition">神奈川県</div></el-col>
                <el-col :span="2"><div v-bind:class=" activeClassForPrefeNm=='埼玉県' ? 'active' : '' " @click="chargeColorForPrefeNm('埼玉県')" class="selectCodition">埼玉県</div></el-col>
                <el-col :span="2"><div v-bind:class=" activeClassForPrefeNm=='千葉県' ? 'active' : '' " @click="chargeColorForPrefeNm('千葉県')" class="selectCodition">千葉県</div></el-col>
                <el-col :span="2"><div v-bind:class=" activeClassForPrefeNm=='茨城県' ? 'active' : '' " @click="chargeColorForPrefeNm('茨城県')" class="selectCodition">茨城県</div></el-col>
                <el-col :span="2"><div v-bind:class=" activeClassForPrefeNm=='栃木県' ? 'active' : '' " @click="chargeColorForPrefeNm('栃木県')" class="selectCodition">栃木県</div></el-col>
                <el-col :span="6"><div v-bind:class=" activeClassForPrefeNm=='他の都道府県' ? 'active' : '' " @click="chargeColorForPrefeNm('他の都道府県')" class="selectCodition">他の都道府県</div></el-col>
              </el-row>
              <el-row class="selectCoditionRow3">
                <el-col :span="2"><div class="selectCodition">日本語：</div></el-col>
                <el-col :span="2"><div v-bind:class=" activeClassForLan=='99' ? 'active' : '' " @click="chargeColorForLan('99')" class="selectCodition">すべて</div></el-col>
                <el-col :span="3"><div v-bind:class=" activeClassForLan=='初級レベル' ? 'active' : '' " @click="chargeColorForLan('初級レベル')" class="selectCodition">初級レベル</div></el-col>
                <el-col :span="3"><div v-bind:class=" activeClassForLan=='簡単会話' ? 'active' : '' " @click="chargeColorForLan('簡単会話')" class="selectCodition">簡単会話</div></el-col>
                <el-col :span="3"><div v-bind:class=" activeClassForLan=='日常会話' ? 'active' : '' " @click="chargeColorForLan('日常会話')" class="selectCodition">日常会話</div></el-col>
                <el-col :span="2"><div v-bind:class=" activeClassForLan=='流暢' ? 'active' : '' " @click="chargeColorForLan('流暢')" class="selectCodition">流暢</div></el-col>
                <el-col :span="3"><div v-bind:class=" activeClassForLan=='ビジネス' ? 'active' : '' " @click="chargeColorForLan('ビジネス')" class="selectCodition">ビジネス</div></el-col>
                <el-col :span="6"><div v-bind:class=" activeClassForLan=='ネイティブ' ? 'active' : '' " @click="chargeColorForLan('ネイティブ')" class="selectCodition">ネイティブ</div></el-col>
              </el-row>
            </div>
            <div class="positionRoot">
              <div v-for="(item,index) in tableDataComputed" :key="index" @click="toPositionDetailFromHome(item)" class="positionList">
                <el-row class="positionListRow1">
                  <el-col :span="13"><div class="position_nm">{{item.positionNm}}</div></el-col>
                  <el-col :span="11"><div class="salary">{{item.salaryMin}}万～{{item.salaryMax}}万({{salarySection[item.salarySection]}})</div></el-col>
                </el-row>
                <el-row class="positionListRow2">
                  <el-col :span="4"><div class="company_nm">{{item.companyNm}}</div></el-col>
                  <el-col :span="20"><div class="exp_years">{{item.industryNm}} / {{item.jobtypeNm}}</div></el-col>
                </el-row>
                <el-row class="positionListRow3">
                  <el-col :span="4">
                      <div v-for="(lan,index) in item.positionLanList" :key="index" class="lan">
                        {{lan.language}}: {{lan.levelSection}}
                      </div>
                  </el-col>
                  <el-col :span="6"><div class="exp_years">経験: {{expYears[item.expYears]}}</div></el-col>
                  <el-col :span="14"><div class="contract_section">{{contractSection[item.contractSection]}}</div></el-col>
                </el-row>
                <el-row class="positionListRow4">
                  <el-col :span="4"><div class="prefe_nm"><em class="el-icon-location-information" />{{item.prefeNm}}</div></el-col>
                  <el-col :span="16"><div class="station">{{item.station}} 駅</div></el-col>
                </el-row>
                <el-row :gutter="10" class="positionListRow5">
                  <el-col :span="3" v-if="item.empLaborIns != 0 ? true : false"><div class="emp_labor_ins">{{empLaborIns[item.empLaborIns]}}</div></el-col>
                  <el-col :span="2" v-if="item.welfare == 0 ? true : false"><div class="welfare">{{welfare[item.welfare]}}</div></el-col>
                  <el-col :span="2" v-if="item.trainingFlg == 0 ? true : false"><div class="training_flg">{{trainingFlg[item.trainingFlg]}}</div></el-col>
                  <el-col :span="2" v-if="item.inspectionFlg == 0 ? true : false"><div class="inspection_flg">{{inspectionFlg[item.inspectionFlg]}}</div></el-col>
                  <el-col :span="2" v-if="item.conUpdFlg == 0 ? true : false"><div class="con_upd_flg">{{conUpdFlg[item.conUpdFlg]}}</div></el-col>
                  <el-col :span="13"></el-col>
                </el-row>
              </div>
              <div v-if="tableDataComputed == '' ? true : false" class="noData">
                検索条件に一致するデータが見つかりません。
              </div>
            </div>
            <div class="othersRoot">
            </div>
          </div>
        </el-main>
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
      </el-form>
      <el-footer>
        <div class="footer">
          <HomeFooter />
        </div>
      </el-footer>
    </el-container>
    <el-backtop></el-backtop>
  </div>
</template>

<script lang="" scoped>
import HomeFooter from "./components/HomeFooter";
import '@/css/reset.css';
import '@/css/border.css';

export default {
  name: "PositionListFromHome",
  components: {
    HomeFooter,
  },
  mounted() {
    if (this.$route.query.searchNm) {
      this.searchNm = this.$route.query.searchNm;
      this.getDataBySearchNm();
    }
    if (this.$route.query.searchNm == "") {
      this.searchNm = this.$route.query.searchNm;
      this.getDataBySearchNm();
    }
    if (!this.$route.query.searchNm) {
      this.getDataBySearchNm();
    }
    if (this.$route.query.industryId) {
    this.industryId = this.$route.query.industryId;
    this.getDataByIndustryId(this.industryId);
    }
    if (this.$route.query.jobtypeId) {
    this.jobtypeId = this.$route.query.jobtypeId;
    this.getDataByJobtypeId(this.jobtypeId);
    }
    // ページタイトルの切替
    document.title = this.titleName;
  },
  data() {
    return {
      // タイトル名
      titleName: "BeeWork-職位一覧",
      activeClassForIndustryId: Number,
      activeClassForPrefeNm: "",
      activeClassForLan: "",
      homeVueForm: {
        searchNm: "",
        industryId: Number,
        jobtypeId: Number,
        prefeNm: "",
        language: "",
        levelSection: "",
        adId: Number,
      },
      // ホームページからパラメータ用
      searchNm: "",
      industryId: Number,
      jobtypeId: Number,
      // 画面初期化用データ
      positionListInitData: [],
      salarySection: {
        '0':'年俸',
        '1':'月給',
      },
      expYears: {
        '0':'不問',
        '1':'1年未満',
        '2':'1～3年',
        '3':'3～5年',
        '4':'5～10年',
        '5':'10年以上',
      },
      contractSection: {
        '0':'正社員',
        '1':'契約社員',
        '2':'アルバイト',
      },
      empLaborIns: {
        1:'雇用・労災保険',
        2:'雇用・労災保険',
        3:'雇用・労災保険',
      },
      welfare: {
        '0':'福利厚生',
      },
      trainingFlg: {
        '0':'研修',
      },
      inspectionFlg: {
        '0':'見学',
      },
      conUpdFlg: {
        '0':'契約更新',
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
        pageSizes: [5, 10, 20],
        // default データ数per page
        pageSize: 5,
        // 展示ページボタン数
        pagerCount: 5,
        // 順序
        layout: "total, sizes, prev, pager, next, jumper",
        // 当ページの最初の行
        dataStart: 0,
        //当ページの最後の行
        dataEnd: 5,
      },
    };
  },
  computed: {
    tableDataComputed() {
      return (
        this.positionListInitData.slice(this.pagination.dataStart, this.pagination.dataEnd) || ""
      );
    },
  },
  methods: {
    getDataBySearchNm() {
      this.homeVueForm.searchNm = this.searchNm;
      this.$store.dispatch("getPositionBySearchId", this.homeVueForm).then((response) => {
        this.$router.push({
          query: { data: response.data.data },
        });
        this.positionListInitData = response.data.data;
        this.pagination.total = this.positionListInitData.length;
      })
      this.activeClassForIndustryId = 99;
      this.activeClassForPrefeNm = '99';
      this.activeClassForLan = '99';
    },
    getDataByIndustryId(index) {
      this.homeVueForm.industryId = index;
      this.$store.dispatch("getPositionBySearchId", this.homeVueForm).then((response) => {
        this.$router.push({
          query: { data: response.data.data },
        });
        this.positionListInitData = response.data.data;
        this.pagination.total = this.positionListInitData.length;
      })
      this.activeClassForIndustryId = index;
      this.activeClassForPrefeNm = '99';
      this.activeClassForLan = '99';
    },
    getDataByJobtypeId(index) {
      this.homeVueForm.jobtypeId = index;
      this.$store.dispatch("getPositionBySearchId", this.homeVueForm).then((response) => {
        this.$router.push({
          query: { data: response.data.data },
        });
        this.positionListInitData = response.data.data;
        this.pagination.total = this.positionListInitData.length;
      })
      let indexInt = parseInt(index);
      if (1<=indexInt && indexInt<=9) {
        this.activeClassForIndustryId = 1;
      } else if (10<=indexInt && indexInt<=19) {
        this.activeClassForIndustryId = 2;
      } else if (20<=indexInt && indexInt<=33) {
        this.activeClassForIndustryId = 3;
      } else if (34<=indexInt && indexInt<=52) {
        this.activeClassForIndustryId = 4;
      } else if (53<=indexInt && indexInt<=72) {
        this.activeClassForIndustryId = 5;
      } else if (73<=indexInt && indexInt<=83) {
        this.activeClassForIndustryId = 6;
      } else if (84<=indexInt && indexInt<=88) {
        this.activeClassForIndustryId = 7;
      } else if (89<=indexInt && indexInt<=97) {
        this.activeClassForIndustryId = 8;
      } else if (98<=indexInt && indexInt<=120) {
        this.activeClassForIndustryId = 9;
      } else if (121<=indexInt && indexInt<=132) {
        this.activeClassForIndustryId = 10;
      } else if (133<=indexInt && indexInt<=146) {
        this.activeClassForIndustryId = 11;
      } else if (147<=indexInt && indexInt<=150) {
        this.activeClassForIndustryId = 12;
      } else if (151<=indexInt && indexInt<=159) {
        this.activeClassForIndustryId = 13;
      } else if (160<=indexInt && indexInt<=173) {
        this.activeClassForIndustryId = 14;
      } else if (174<=indexInt && indexInt<=182) {
        this.activeClassForIndustryId = 15;
      }
      this.activeClassForPrefeNm = '99';
      this.activeClassForLan = '99';
    },
    toHome(index) {
      console.log("Go to the homepage.");
      let routeUrl = this.$router.resolve({
        path: "/home",
        query: {seatchNm: index}
      });
      window.open(routeUrl.href, "/home");
    },
    toLogin() {
      console.log("Go to the login page.");
      this.$router.push({
        path: "/login",
      });
    },
    toC0001() {
      console.log("Go to the c0001 page.");
      this.$router.push({
        path: "/c0001",
      });
    },
    chargeColorForIndustryId(index) {
      this.homeVueForm.searchNm = '';
      this.homeVueForm.industryId = index;
      this.homeVueForm.jobtypeId = '';
      this.homeVueForm.prefeNm = this.activeClassForPrefeNm;
      this.homeVueForm.language = '日本語';
      this.homeVueForm.levelSection = this.activeClassForLan;
      this.homeVueForm.jobtypeId = null;

      this.activeClassForIndustryId = index;
      this.$store.dispatch("getPositionBySearchId", this.homeVueForm).then((response) => {
        this.$router.push({
          query: { data: response.data.data },
        });
        this.positionListInitData = response.data.data;
        this.pagination.total = this.positionListInitData.length;
      })
    },
    chargeColorForPrefeNm(index) {
      this.homeVueForm.searchNm = '';
      this.homeVueForm.industryId = this.activeClassForIndustryId;
      this.homeVueForm.jobtypeId = '';
      this.homeVueForm.prefeNm = index;
      this.homeVueForm.language = '日本語';
      this.homeVueForm.levelSection = this.activeClassForLan;
      this.homeVueForm.jobtypeId = null;

      this.activeClassForPrefeNm = index;
      this.$store.dispatch("getPositionBySearchId", this.homeVueForm).then((response) => {
        this.$router.push({
          query: { data: response.data.data },
        });
        this.positionListInitData = response.data.data;
        this.pagination.total = this.positionListInitData.length;
      })
    },
    chargeColorForLan(index) {
      this.homeVueForm.searchNm = '';
      this.homeVueForm.industryId = this.activeClassForIndustryId;
      this.homeVueForm.jobtypeId = '';
      this.homeVueForm.prefeNm = this.activeClassForPrefeNm;
      this.homeVueForm.language = '日本語';
      this.homeVueForm.levelSection = index;
      this.homeVueForm.jobtypeId = null;

      this.activeClassForLan = index;
      this.$store.dispatch("getPositionBySearchId", this.homeVueForm).then((response) => {
        this.$router.push({
          query: { data: response.data.data },
        });
        this.positionListInitData = response.data.data;
        this.pagination.total = this.positionListInitData.length;
      })
    },
    toPositionDetailFromHome(index) {
      console.log("Go to the positionDetailFromHome page.");
      let routeUrl = this.$router.resolve({
        path: "/positionDetailFromHome",
        query: {positionDetailInitData: JSON.stringify(index)}
      });
      window.open(routeUrl.href, "/positionDetailFromHome");
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
  },
};
</script>

<style>
.HomePage {
  min-width: 1200px;
}
.homeHeader {
  height: 65px !important;
}
.logoImg {
  display: inline;
  float: left;
  outline:none;
  cursor:pointer;
  line-height: 50px;
}
.el-menu-header.el-menu--horizontal {
  border-bottom: solid 0px;
}
.homeHeaderRoot {
  position: fixed;
  z-index: 100;
  height: 65px !important;
  top: 0px;
  left: 0px;
  bottom: 0px;
  width: 100%;
  border: 0px;
  background-color:#FFFFFF;
  box-shadow: 0px 20px 20px -20px #dbdbdb;
}
.el-menu-header {
  padding: 0 11%;
}
.space {
  width: 53%;
  pointer-events: none;
}
.searchBackground {
  width: 100%;
  height: 100%;
  background-size: contain;
  background-position: center;
}
.searchInput {
  padding: 25px 11%;
  z-index: 1;
}
.searchInputInner .el-input__inner {
  font-size: 18px;
  height: 60px !important;
}
.homeBody {
  padding-top: 10px;
  background-color: rgb(241, 241, 241);
}
.bodyRoot {
  width: 80%;
  margin: auto;
  padding-top: 20px;
}
.selectCoditionInfo {
  font-size: 14px;
  padding: 18px 0;
  width: 100%;
  background-color: #ffffff;
  padding: 20px;
}
.selectCodition {
  font-size: 16px;
  color: #000000;
}
.selectCodition:hover {
  cursor: pointer;
}
.selectCodition_space {
  min-height: 1px;
}
.selectCoditionRow2 {
  margin-top: 10px;
}
.selectCoditionRow3 {
  margin-top: 10px;
}
.positionRoot {
  width: 80%;
  float: left;
}
.positionList {
  margin-top: 20px;
  width: 100%;
  background-color: #ffffff;
  padding: 20px;
}
.positionList:hover {
  cursor: pointer;
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
}
.positionListRow1 {
  margin-bottom: 0px;
}
.position_nm {
  font-size: 20px;
  margin-top: 5px;
}
.salary {
  font-size: 25px;
  color: rgb(255, 0, 0);
  text-align: right;
}
.wavy_line {
  font-size: 25px;
  color: rgb(255, 0, 0);
  text-align: center;
}
.salary_max {
  font-size: 25px;
  color: rgb(255, 0, 0);
  display: inline;
}
.salary_section {
  font-size: 25px;
  color: rgb(255, 0, 0);
  display: inline;
}
.positionListRow2 {
  font-size: 16px;
  margin-top: 5px;
}
.company_nm {
  color: rgb(138, 138, 138);
}
.positionListRow3 {
  margin-top: 10px;
}
.lan {
  font-size: 14px;
  color: rgb(138, 138, 138);
}
.exp_years {
  font-size: 14px;
  color: rgb(138, 138, 138);
}
.contract_section {
  text-align: right;
  font-size: 14px;
  color: rgb(138, 138, 138);
}
.positionListRow4 {
  margin-top: 5px;
}
.prefe_nm {
  color: rgb(138, 138, 138);
}
.station {
  color: rgb(138, 138, 138);
}
.work_date_str {
  text-align: right;
  color: rgb(138, 138, 138);
}
.positionListRow5 {
  margin-top: 5px;
}
.emp_labor_ins {
  height: 20px;
  font-size: 10px;
  color: rgb(138, 138, 138);
  text-align: center;
  border: solid 1px;
  border-radius: 5px;
  border-color: #e2e2e2;
}
.welfare {
  height: 20px;
  font-size: 10px;
  color: rgb(138, 138, 138);
  text-align: center;
  border: solid 1px;
  border-radius: 5px;
  border-color: #e2e2e2;
}
.training_flg {
  height: 20px;
  font-size: 10px;
  color: rgb(138, 138, 138);
  text-align: center;
  border: solid 1px;
  border-radius: 5px;
  border-color: #e2e2e2;
}
.inspection_flg {
  height: 20px;
  font-size: 10px;
  color: rgb(138, 138, 138);
  text-align: center;
  border: solid 1px;
  border-radius: 5px;
  border-color: #e2e2e2;
}
.con_upd_flg {
  height: 20px;
  font-size: 10px;
  color: rgb(138, 138, 138);
  text-align: center;
  border: solid 1px;
  border-radius: 5px;
  border-color: #e2e2e2;
}
.noData {
  margin-top: 20px;
  width: 100%;
  height: 600px;
  font-size: 25px;
  background-color: #ffffff;
  color: grey;
  padding: 10% 0;
  text-align: center;
}
.othersRoot {
  margin-top: 20px;
  margin-left: 2%;
  width: 18%;
  height: 500px;
  background-color: #ffffff;
  padding: 20px;
  float: right;
}
.active{
  color:blue;
}
.paginationStyle {
  padding: 4vh;
  background-color: rgb(241, 241, 241);
}
.el-input-group__append, .el-input-group__prepend{
  background-color: #0099ff;
  color:#ffffff;
  border: 1px solid #0099ff;
}
.el-input-group__append button.el-button{
  height: 54px !important;
}
.buttonSelect{
  width:80px;
}
/* ページネーションのデータ数毎ページの幅 */
::v-deep .el-pagination .el-select .el-input {
  width: 2rem;
}
</style>
