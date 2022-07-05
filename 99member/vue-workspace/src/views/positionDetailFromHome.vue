<template>
  <div class="positionDetailFromHome">
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
              <div >
                <el-row>
                  <el-col :span="12"><div class="detail_position_nm">{{pdInitData.positionNm}}</div></el-col>
                  <el-col :span="12"><el-button  class="homePageButton" @click="toC0001" >応募</el-button></el-col>
                </el-row>
              </div>
              <div class="detail_salary">{{pdInitData.salaryMin}}万～
                {{pdInitData.salaryMax}}万({{salarySection[pdInitData.salarySection]}})</div>
            </div>
            <div class="positionDetailRoot">
              <el-row class="detailItemRowTitle detailItemRowTitle1">
                <el-col :span="6"><div>福利厚生</div></el-col>
              </el-row>
              <el-row :gutter="20" class="detailItemRow detailItemRow2">
                <el-col :span="4"><div v-if="pdInitData.empLaborIns != 0 ? true : false" class="detail_flg detail_emp_labor_ins">{{empLaborIns[pdInitData.empLaborIns]}}</div></el-col>
                <el-col :span="3"><div v-if="pdInitData.welfare == 0 ? true : false" class="detail_flg detail_welfare">{{welfare[pdInitData.welfare]}}</div></el-col>
                <el-col :span="3"><div v-if="pdInitData.trainingFlg == 0 ? true : false" class="detail_flg detail_training_flg">{{trainingFlg[pdInitData.trainingFlg]}}</div></el-col>
                <el-col :span="3"><div v-if="pdInitData.inspectionFlg == 0 ? true : false" class="detail_flg detail_inspection_flg">{{inspectionFlg[pdInitData.inspectionFlg]}}</div></el-col>
                <el-col :span="3"><div v-if="pdInitData.conUpdFlg == 0 ? true : false" class="detail_flg detail_con_upd_flg">{{conUpdFlg[pdInitData.conUpdFlg]}}</div></el-col>
                <el-col :span="8"></el-col>
              </el-row>
              <el-row><br><br></el-row>
              <el-row class="detailItemRowTitle detailItemRowTitle1">
                <el-col :span="6"><div>職位説明</div></el-col>
              </el-row>
              <el-row class="detailItemRowTitle detailItemRow1">
                <el-col :span="24"><div class="detail_work_time">{{ pdInitData.positionInt }}</div></el-col>
              </el-row>
              <el-row class="detailItemRow detailItemRow3">
                <el-col :span="3"><div class="detail_work_time">勤務時間：</div></el-col>
                <el-col :span="10"><div class="detail_work_time_from">{{ pdInitData.workTimeFrom }}</div><div class="detail_wavy_line_time">～</div><div class="detail_work_time_to">{{ pdInitData.workTimeTo }}</div></el-col>
              </el-row>
              <el-row class="detailItemRow detailItemRow3">
                <el-col :span="3"><div class="detail_work_time">求人人数：</div></el-col>
                <el-col :span="10"><div class="detail_work_time_from">{{ pdInitData.peoCnt }}人</div></el-col>
              </el-row>
              <el-row class="detailItemRow detailItemRow4">
              </el-row>
              <el-row><br><br></el-row>
              <el-row class="detailItemRowTitle detailItemRowTitle1">
                <el-col :span="6"><div>言語要求</div></el-col>
              </el-row>
              <el-row class="detailItemRow detailItemRow1">
                <div v-for="(lan,index) in pdInitData.positionLanList" :key="index" class="detail_lan">
                  {{lan.language}}: {{lan.levelSection}}
                </div>
              </el-row>
              <el-row><br><br></el-row>
               <el-row class="detailItemRowTitle detailItemRowTitle1">
                <el-col :span="6"><div>学歴要求</div></el-col>
              </el-row>
              <el-row class="detailItemRow detailItemRow1">
                <div class="detail_lan">
                  {{degree[pdInitData.degree]}}
                </div>
              </el-row>
              <el-row><br><br></el-row>
              <el-row class="detailItemRowTitle detailItemRowTitle1">
                <el-col :span="6"><div>勤務地</div></el-col>
              </el-row>
              <el-row class="detailItemRow detailItemRow6">
                <el-col :span="24"><div class="detail_station">{{pdInitData.station}}</div></el-col>
                <el-col :span="24"><div class="detail_palce">{{pdInitData.workAddress1}}{{pdInitData.workAddress2}}</div></el-col>
              </el-row>
            </div>
            <div class="othersRoot" @click="toCompanyInfo">
              <el-row class="detailItemRowTitle detailItemRowTitle5">
                <el-col :span="24">
                  <div class="detail_office">
                    <el-avatar :size="120" @error="errorHandler" fit :src="this.tableData.logoByte" :key="this.tableData.logoByte">
                      <img :size="120" fit :src="require('@/assets/demo.jpg')" />
                    </el-avatar>
                  </div>
                </el-col>
              </el-row>
              <el-row class="detailItemRowTitle detailItemRowTitle5">
                <el-col :span="24"><div class="comNm">{{tableData.companyNm}}</div></el-col>
              </el-row>
              <el-row class="detailItemRowTitle detailItemRowTitle5">
                <el-col :span="24"><div class="detail_office"><em class="el-icon-location-information" /> {{tableData.address1}}</div></el-col>
              </el-row>
              <el-row class="detailItemRowTitle detailItemRowTitle5">
                <el-col :span="24"><div class="detail_office">{{tableData.address2}}</div></el-col>
              </el-row>
              <el-row class="detailItemRowTitle detailItemRowTitle5">
                <el-col :span="24"><div class="cntPosition"><em class="el-icon-loading" /> 求人情報：{{tableData.positionCount}}</div></el-col>
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

<script lang="" scoped>
import HomeFooter from "./components/HomeFooter";
import '@/css/reset.css';
import '@/css/border.css';

export default {
  name: "positionDetailFromHome",
  components: {
    HomeFooter,
  },
  mounted() {
    if (this.$route.query.positionDetailInitData) {
      this.pdInitData = JSON.parse(this.$route.query.positionDetailInitData);
      this.getCompanyData();
    }
    // ページタイトルの切替
    document.title = this.titleName;
  },
  data() {
    return {
      // タイトル名
      titleName: "BeeWork-職位詳細",
      activeIndex2: "1",
      // 画面初期化用データ
      pdInitData: [],
      tableData: [],
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
      degree: {
        '0':'大卒以上',
        '1':'専門卒以上',
        '2':'高卒以上',
        '3':'大卒',
        '4':'院卒',
        '5':'専門卒',
        '6':'高卒',
        '7':'学歴不問',
      },
      companyId: Number,
    };
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
      let routeUrl = this.$router.resolve({
        path: "/c0001",
        query: {}
      });
      window.open(routeUrl.href, '_blank');
    },
    errorHandler() {
      return true;
    },
    // 会社データ取得
    getCompanyData() {
      this.companyId = parseInt(this.pdInitData.companyId)
      this.$store.dispatch("companyDetailFrom", this.companyId).then((response) => {
        this.tableData = response.data.data;
      });
    },
    toCompanyInfo() {
      let routeUrl = this.$router.resolve({
        path: "/companyDetailFromHome",
        query: {companyDetailInitData: JSON.stringify(this.tableData)}
      });
      window.open(routeUrl.href, "/companyDetailFromHome");
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
  width: 100%;
  height: 120px;
  background-color: #f5faff;
  padding: 20px 0px;
}
.detail_position_nm {
  font-size: 28px;
  margin:0px 20px 0px 20px;
}
.positionDetailRoot {
  margin-top: 0px;
  width: 80%;
  background-color: #ffffff;
  padding: 20px;
  float: left;
}
.othersRoot {
  margin-top: 0px;
  margin-left: 2%;
  width: 18%;
  height: auto;
  background-color: #ffffff;
  padding: 20px;
  float: right;
  cursor: pointer;
}
.detail_salary {
  margin: 0px 20px 0px 20px;
  font-size: 24px;
  color: rgb(255, 0, 0);
}
.detailItemRow {
  font-size: 16px;
  color:#666666;
}
.detailItemRow1 {
  padding-top: 10px;
  display: flex;
  flex-wrap: wrap;
  color:#666666;
}
.detail_lan {
  padding-right: 30px;
}
.detailItemRowTitle {
  font-size: 20px;
  color:#333333;
}
.detailItemRowTitle1 {
  padding-top: 16px;
  color:#333333;
  font-weight: 700;
}
.detailItemRowTitle2 {
  padding-top: 30px;
  color:#2D8CF0;
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
  border-color: #2D8CF0;
  background: #F7F9FC;
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
  font-size: 14px;
  padding-top: 25px;
}
.detail_work_content {
  padding-top: 20px;
  white-space: pre-wrap;
}
.detailItemRowTitle5 {
  padding-top: 10px;
  font-weight: bold;
  text-align:center;
  font-size: 16px;
}
.detailItemRowTitle5 .comNm{
  font-size: 24px;
  font-weight: bold;
}
.detailItemRowTitle5 .cntPosition{
  font-weight: bold;
  color: #005ae0;
}
.detailItemRow6 {
  padding-top: 10px;
  font-size: 16px;  
}
.homePageButton {
  float:right;
  background: #2D8CF0;
  color: #fff;
  font-size: 26px;
  font-weight: 400;
  height: 48px;
  width: 150px;
  margin:10px 40px 0px 10px;
}
</style>
