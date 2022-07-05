<template>
  <el-container>
    <el-header>
      <HomeHeader />
    </el-header>
    <el-main class="mainStyle">
      <el-row class="blockStyle">
        <div @click="clickTitle">
          <el-row>
            <el-col v-text="pageContent.titleName" class="titleNameStyle" />
          </el-row>
        </div>
        <el-collapse-transition>
          <div v-show="pageContent.searchIsShow">
            <el-row>
              <el-col>
                <el-input
                  v-model="pageContent.inputText"
                  :placeholder="pageContent.inputPlaceholder"
                  size="large"
                  class="inputStyle"
                >
                  <el-button
                    slot="append"
                    icon="el-icon-search"
                    @click="clickSearchButton"
                    class="searchButtonStyle"
                  />
                </el-input>
              </el-col>
            </el-row>
          </div>
        </el-collapse-transition>
      </el-row>
      <el-row class="blockStyle">
        <el-col>
          <el-table :data="pageContent.tableData">
            <el-table-column type="selection" fixed="left" width="39" />
            <el-table-column label="姓名">
              <template v-slot="fullName">
                {{ fullName.row.firstName }} {{ fullName.row.lastName }}
              </template>
            </el-table-column>
            <el-table-column prop="birthday" label="年齢" sortable />
            <el-table-column prop="sex" label="性別" />
            <el-table-column prop="status" label="状態" sortable />
            <el-table-column prop="userTel" label="連絡先" />
            <el-table-column label="住所">
              <template v-slot="address">
                {{ address.row.prefeNm }}
                <br />
                {{ address.row.station }}
              </template>
            </el-table-column>
            <el-table-column label="卒業学校">
              <template v-slot="gradution">
                {{ gradution.row.graduationSchool }}
                <br />
                {{ gradution.row.graduationMajor }}
              </template>
            </el-table-column>
            <el-table-column prop="workSituation" label="仕事状況" sortable />
            <el-table-column fixed="right">
              <el-button type="text">
                <em class="el-icon-document" />
              </el-button>
            </el-table-column>
            <el-table-column fixed="right" width="33">
              <el-button type="text">
                <em class="el-icon-delete" width="33" />
              </el-button>
            </el-table-column>
          </el-table>
        </el-col>
      </el-row>
    </el-main>
    <el-footer>
      <HomeFooter />
    </el-footer>
  </el-container>
</template>
<script>
import HomeHeader from "../spComponents/HomeHeader";
import HomeFooter from "../spComponents/HomeFooter";
import '@/css/reset.css';
import '@/css/border.css';
//移动端 解决点击按钮闪和active失效的问题
document.body.addEventListener('touchstart' , function(){});
export default {
  name: "b0503",
  components: {
    HomeHeader,
    HomeFooter,
  },

  data() {
    return {
      pageContent: {
        titleName: "研修応募者管理",
        inputPlaceholder: "検索内容を入力してください",
        inputText: "",
        searchIsShow: true,
        tableData: [
          {
            companyId: "会社ID",
            trainingId: "説明会ID",
            applicantId: "応募者ID",
            userCd: "ユーザーコード",
            firstName: "姓",
            lastName: "名",
            birthday: "年齢",
            prefeNm: "都道府県",
            station: "最寄駅",
            sex: "性別",
            graduationSchool: "卒業学校",
            graduationMajor: "専攻",
            userTel: "電話番号",
            workSituation: "仕事状況",
            status: "状態",
          },
        ],
      },
      B0503VueForm: {
        userCd: "",
        companyId: Number,
        trainingId: Number,
        name: "",
        status: "",
        applicantId: [],
        statusFlg: "",
      },
    };
  },

  created() {
    console.clear();
    document.title = this.pageContent.titleName;
  },

  mounted() {
    this.getData();
  },

  methods: {
    getData() {
      this.setData();
      this.$store.dispatch("b0503Search", this.B0503VueForm).then((response) => {
        this.$router.push({
          query: { data: response.data.data },
        });
        console.log("getData", response.data.data);
        this.tableData = response.data.data;
        this.pagination.total = this.tableData.length;
      });
    },

    clickTitle() {
      this.pageContent.searchIsShow = !this.pageContent.searchIsShow;
      if (this.pageContent.searchIsShow) {
        console.log("show");
      } else {
        console.log("hide");
      }
    },

    clickSearchButton() {
      console.log("search");
    },
  },

  computed: {},
};
</script>
<style lang="scss" scoped>
.mainStyle {
  background-color: #f6f6f6;
  padding: 1vh 0;
  margin: 0 0 1vh 0;
}
.blockStyle {
  background-color: #ffffff;
  width: 90vw;
  margin-left: 1vh;
  padding: 1vh 1vw;
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
.inputStyle {
  margin: 2vh 10%;
  width: 80%;
}
</style>
