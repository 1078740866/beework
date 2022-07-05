<template>
  <div class="companyDetailFromHome">
    <el-container>
      <el-header class="homeHeader">
        <div class="homeHeaderRoot">
          <el-menu
            :default-active="activeIndex2"
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
      <el-form ref="loginForm" label-position="left" autocomplete="on">
        <el-main class="homeBody">
          <div class="bodyRoot">
            <div class="detailTitleInfo">
              <el-row>
                <el-col :span="5" align="middle" type="flex">
                  <el-avatar :size="160" @error="errorHandler" fit :src="this.cdInitData.companyLogo" :key="this.cdInitData.companyLogo">
                    <img fit :src="require('@/assets/b_titleico3.png')" />
                  </el-avatar>
                </el-col>
                <el-col :span="19">
                  <el-row>
                    <el-col class="detail_position_nm">
                      <span>{{cdInitData.companyNm}}</span>
                    </el-col>
                  </el-row>
                  <el-row>
                    <el-col class="detail_salary" :span="12">
                      <span>{{cdInitData.industryNm1}}</span>
                      <span v-show="cdInitData.industryNm2?true:false"> / {{cdInitData.industryNm2}}</span>
                      <span v-show="cdInitData.industryNm3?true:false"> / {{cdInitData.industryNm3}}</span>
                    </el-col>
                    <el-col class="detail_salary" :span="12">
                      <span>法人：{{cdInitData.userName}}</span>
                    </el-col>
                  </el-row>
                </el-col>
              </el-row>
            </div>
            <div class="positionDetailRoot">
              <el-row class="detailItemRowTitle detailItemRowTitle2">
                <el-col :span="6"><div class="detail_welfare_program"><em class="el-icon-notebook-2" /> 事業内容</div></el-col>
              </el-row>
              <el-row class="detailItemRow detailItemRow1">
                <div class="detail_lan">
                  {{cdInitData.businessContent}}
                </div>
              </el-row>
              <el-row class="detailItemRowTitle detailItemRowTitle1">
                <el-col :span="6"><div><em class="el-icon-office-building" /> 会社場所</div></el-col>
              </el-row>
              <el-row class="detailItemRow detailItemRow1">
                <div class="detail_lan">
                  {{cdInitData.countryNm}}
                </div>
              </el-row>
              <el-row class="detailItemRow detailItemRow1">
                <div class="detail_lan">
                  {{cdInitData.address1}}{{cdInitData.address2}}
                </div>
              </el-row>
               <el-row class="detailItemRowTitle detailItemRowTitle1">
                <el-col :span="6"><div><em class="el-icon-user" /> 会社規模</div></el-col>
              </el-row>
              <el-row class="detailItemRow detailItemRow1">
                <div class="detail_lan">
                  {{companyScale[cdInitData.companyScale]}}
                </div>
              </el-row>
            </div>
            <el-card class="box-card">
              <el-row class="detailItemRowTitle detailItemRowTitle5">
                <el-col :span="24"><div class="cntPosition1"><em class="el-icon-loading" /> 求人情報</div></el-col>
              </el-row>
              <el-row class="detailItemRowTitle detailItemRowTitle5">
                <el-col :span="24"><div class="cntPosition2">{{cdInitData.positionCount}}</div></el-col>
              </el-row>
            </el-card>
          </div>
        </el-main>
      </el-form>
      <el-form ref="loginForm" label-position="left" autocomplete="on">
        <el-main class="homeBody">
          <div class="bodyRoot">
            <div class="positionRoot">
              <div class="positionTitle">
                <em class="el-icon-pie-chart" /> 当会社の求人情報
              </div>
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
                当会社の職位がありません。
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
  </div>
</template>

<script lang="" scoped>
import HomeFooter from "./components/HomeFooter";
import '@/css/reset.css';
import '@/css/border.css';

export default {
  name: "companyDetailFromHome",
  components: {
    HomeFooter,
  },
  mounted() {
    if (this.$route.query.companyDetailInitData) {
      this.cdInitData = JSON.parse(this.$route.query.companyDetailInitData);
      this.getPositionData();
    }
    // ページタイトルの切替
    document.title = this.titleName;
  },
  data() {
    return {
      // タイトル名
      titleName: "BeeWork-会社詳細",
      activeIndex2: "1",
      // 画面初期化用データ
      cdInitData: [],
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
      companyScale: {
        '0':'20人以下',
        '1':'20～99人',
        '2':'100～299人',
        '3':'300～499人',
        '4':'500人以上',
      },
      companyId: Number,
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
    errorHandler() {
      return true;
    },
    // 会社の職位データ取得
    getPositionData() {
      this.companyId = parseInt(this.cdInitData.companyId)
      this.$store.dispatch("getPositionByCompanyId", this.companyId).then((response) => {
        this.positionListInitData = response.data.data;
        this.pagination.total = this.positionListInitData.length;
      })
    },
    toPositionDetailFromHome(index) {
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
  width: 200px;
  outline:none;
  cursor:pointer;
  height: 50px;
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
  width: 54%;
  pointer-events: none;
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
.detailTitleInfo {
  padding: 18px 0;
}
.detail_position_nm {
  font-size: 36px;
  margin-top: 30px;
}
.positionDetailRoot {
  margin-top: 20px;
  width: 80%;
  background-color: #ffffff;
  padding: 20px;
  float: left;
}
.detail_salary {
  margin-top: 30px;
  font-size: 20px;
  color: rgb(100, 100, 100);
}
.detailItemRow {
  font-size: 16px;
}
.detailItemRow1 {
  padding-top: 10px;
  display: flex;
  flex-wrap: wrap;
}
.detail_lan {
  padding-right: 30px;
}
.detailItemRowTitle {
  font-size: 28px;
}
.detailItemRowTitle1 {
  padding-top: 30px;
  font-weight: bold;
}
.detailItemRowTitle2 {
  padding-top: 30px;
  font-weight: bold;
}
.detailItemRow2 {
  padding-top: 10px;
}
.detail_flg {
  height: 30px;
  line-height: 30px;
  text-align: center;
  border: solid 1px;
  border-radius: 5px;
  border-color: #c2c1c1;
}
.detailItemRowTitle3 {
  padding-top: 30px;
  font-weight: bold;
}
.detailItemRow3 {
  padding-top: 15px;
}
.detail_work_time {
  font-size: 16px;
}
.detail_work_time_from {
  font-size: 16px;
  display: inline;
}
.detail_wavy_line_time {
  font-size: 16px;
  display: inline;
}
.detail_work_time_to {
  font-size: 16px;
  display: inline;
}
.detailItemRow5 {
  font-size: 16px;
  padding-top: 25px;
}
.detail_work_content {
  padding-top: 20px;
  white-space: pre-wrap;
}
.detailItemRowTitle4 {
  padding-top: 30px;
  font-weight: bold;
}
.detailItemRowTitle5 {
  padding-top: 10px;
  text-align:center;
  font-size: 16px;
  font-weight: bold;
}
.detailItemRowTitle5 .comNm{
  font-size: 24px;
  font-weight: bold;
}
.detailItemRowTitle5 .cntPosition1{
  font-size: 20px;
  font-weight: bold;
  color: #ffffff;
}
.detailItemRowTitle5 .cntPosition2{
  font-size: 64px;
  font-weight: bold;
  color: #190088;
}
.detailItemRow6 {
  padding-top: 10px;
  font-size: 14px;  
}

.box-card{ 
  margin-top: 20px;
  margin-left: 2%;
  width: 18%;
  height: auto;
  padding: 20px;
  float: right;
  background-image: linear-gradient(to bottom right, #0063b9, #33cdff);
} 

.paginationStyle {
  padding: 4vh;
  background-color: rgb(241, 241, 241);
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
.noData {
  margin-top: 20px;
  width: 100%;
  height: 300px;
  font-size: 25px;
  background-color: #ffffff;
  padding: 10% 0;
  text-align: center;
}
.positionTitle{
  font-size: 30px;
  background-color: #ffffff;
  font-weight: bold;
  padding: 20px;
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
/* ページネーションのデータ数毎ページの幅 */
::v-deep .el-pagination .el-select .el-input {
  width: 2rem;
}
</style>
