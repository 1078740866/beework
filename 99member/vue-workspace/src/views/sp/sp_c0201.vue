<template>
  <div>
    <el-container>
      <el-header>
        <div class="header">
          <HomeHeader />
        </div>
      </el-header>
      <el-form
        :model="c0201Form"
        ref="c0201Form"
        label-position="left"
        autocomplete="on"
      >
        <el-main class="b0501_body">
          <div class="b0501_select">
            <el-row>
              <el-col :span="24">
                <div class="b0501_title">職位一覧</div>
              </el-col>
            </el-row>
            <div class="select_body">
              <el-row :gutter="1">
                <el-col :span="7" :offset="1">
                  <div>
                    <el-form-item >
                      <el-input
                        v-model="c0201Form.likeSelect"
                        placeholder="名前を入力してください"
                        style="width : 330px"
                      />
                    </el-form-item>
                  </div>
                </el-col>
                </el-row>
                <el-row :gutter="1">
                <el-col :span="6" :offset="1">
                  <div>
                    <el-form-item label="会社名：" label-width="50px"> 
                      <el-input v-model="c0201Form.companyNm" style="width :280px"/>
                    </el-form-item>
                  </div>
                </el-col>
              </el-row>
            </div>
            <el-row :gutter="1">
              <el-col :span="5" :offset="1">
                <div>
                  <el-form-item label="地域：">
                    <el-select
                      v-model="prefeId"
                      @change="setPrefeIdNm"
                      placeholder=""
                      clearable
                    >
                      <el-option
                        v-for="item in prefecturesMstBean"
                        :key="item.prefeId"
                        :label="item.prefeNm"
                        :value="item.prefeId"
                      />
                    </el-select>
                  </el-form-item>
                </div>
              </el-col>
              <el-col :span="4" :offset="1">
                <div>
                  <el-form-item label="給料：">
                    <el-input v-model="salary" />
                  </el-form-item>
                </div>
              </el-col>
              <el-col :span="5" :offset="1">
                <div>
                  <el-form-item label="業種：">
                    <el-select
                      v-model="industryId"
                      @change="setIndustryIdNm"
                      placeholder=""
                      clearable
                    >
                      <el-option
                        v-for="item in industryMstBean"
                        :key="item.industryId"
                        :label="item.industryNm"
                        :value="item.industryId"
                      />
                    </el-select>
                  </el-form-item>
                </div>
              </el-col>
              <el-col :span="5" :offset="1">
                <div>
                  <el-form-item label="職種：">
                    <el-select
                      v-model="jobtypeId"
                      @change="setJobtypeIdNm"
                      placeholder=""
                      clearable
                    >
                      <el-option
                        v-for="item in jobtypeMstBean"
                        :key="item.jobtypeId"
                        :label="item.jobtypeNm"
                        :value="item.jobtypeId"
                      />
                    </el-select>
                  </el-form-item>
                </div>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="6" :offset="1">
                <div>
                  <el-form-item label="学歴要求：">
                    <el-select
                      v-model="c0201Form.degree"
                      @change="setGakurekiIdNm"
                      placeholder=""
                      clearable
                    >
                      <el-option
                        v-for="item in gakurekiList"
                        :key="item.gakurekiId"
                        :label="item.gakurekiNm"
                        :value="item.gakurekiNm"
                      />
                    </el-select>
                  </el-form-item>
                </div>
              </el-col>
              <el-col :span="7" :offset="1">
                <div>
                  <el-form-item label="雇用・労災保険：">
                    <el-select
                      v-model="c0201Form.empLaborIns"
                      @change="setHokenIdNm"
                      placeholder=""
                      clearable
                    >
                      <el-option
                        v-for="item in hokenList"
                        :key="item.hokenId"
                        :label="item.hokenNm"
                        :value="item.hokenNm"
                      />
                    </el-select>
                  </el-form-item>
                </div>
              </el-col>
              <el-col :span="7" :offset="1">
                <div>
                  <el-form-item label="必要経験：">
                    <el-select
                      v-model="c0201Form.expYears"
                      @change="setKeikenIdNm"
                      placeholder=""
                      clearable
                    >
                      <el-option
                        v-for="item in keikenList"
                        :key="item.keikenId"
                        :label="item.keikenNm"
                        :value="item.keikenNm"
                      />
                    </el-select>
                  </el-form-item>
                </div>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="5" :offset="1">
                <div>
                  <el-form-item label="見学：">
                    <el-radio v-model="inspectionFlg" label="0">有り</el-radio>
                    <el-radio v-model="inspectionFlg" label="1">無し</el-radio>
                  </el-form-item>
                </div>
              </el-col>
              <el-col :span="5" :offset="1">
                <div>
                  <el-form-item label="福利厚生：">
                    <el-radio v-model="welfare" label="0">有り</el-radio>
                    <el-radio v-model="welfare" label="2">無し</el-radio>
                  </el-form-item>
                </div>
              </el-col>
              <el-col :span="5" :offset="1">
                <div>
                  <el-form-item label="研修：">
                    <el-radio v-model="trainingFlg" label="0">有り</el-radio>
                    <el-radio v-model="trainingFlg" label="3">無し</el-radio>
                  </el-form-item>
                </div>
              </el-col>
            </el-row>
            <div class="b0501_button">
              <el-row type="flex" justify="center">

                  <div>
                    <el-button type="primary" @click="shi" class="b0501Button">
                      条件クリア
                    </el-button>
                  </div>

                  <div>
                    <el-button
                      type="primary"
                      @click="getTrainingData"
                      icon="el-icon-search"
                      class="b0501Button"
                    >
                      検索
                    </el-button>
                  </div>
     
              </el-row>
            </div>
          </div>
          <div class="b0501_data">
            <el-tabs v-model="activeName" @tab-click="handleClick">
              <el-tab-pane label="職位推薦" name="first">
                <el-table
                  ref="suisenTable"
                  :data="
                    getSyokuiList
                  "
                  style="width: 100%"
                  max-height="600px"
                >
                  <el-table-column type="selection" fixed="left" width="50" />
                  <el-table-column
                    prop="positionNm"
                    label="職位名"
                    width="100"
                  />
                  <el-table-column
                    prop="companyNm"
                    label="会社名"
                    width="100"
                  />
                  <el-table-column
                    prop="expYears"
                    label="必須経験年数"
                    width="100"
                  />
                  <el-table-column prop="industryNm" label="業種" width="100" />
                  <el-table-column prop="jobTypeNm" label="職種" width="100" />
                  <el-table-column
                    prop="salaryMin"
                    label="最低限給料"
                    width="100"
                  />
                  <el-table-column
                    prop="salaryMax"
                    label="最高限給料"
                    width="100"
                  />
                  <el-table-column prop="station" label="最寄駅" width="100" />
                  <el-table-column
                    prop="empLaborIns"
                    label="雇用・労災保険"
                    width="120"
                  />
                  <el-table-column
                    prop="welfare"
                    label="福利厚生"
                    width="100"
                  />
                  <el-table-column
                    prop="trainingFlg"
                    label="研修有無"
                    width="100"
                  />
                  <el-table-column
                    prop="inspectionFlg"
                    label="見学有無"
                    width="100"
                  />
                  <el-table-column fixed="right" width="50">
                    <el-button
                      type="text"
                      size="large"
                      @click="toB0502Detailed"
                    >
                      <em class="el-icon-document" />
                    </el-button>
                  </el-table-column>
                  <el-table-column fixed="right" width="50">
                    <el-button type="text" size="large" @click="toB0502Modify">
                      <em class="el-icon-edit" />
                    </el-button>
                  </el-table-column>
                </el-table>
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
              </el-tab-pane>
              <el-tab-pane label="応募済み" name="second"
                ><el-table
                  ref="suisenTable"
                  :data="
                    getSyokuiList
                  "
                  style="width: 100%"
                  max-height="600px"
                >
                  <el-table-column type="selection" fixed="left" width="50" />
                  <el-table-column
                    prop="positionNm"
                    label="職位名"
                    width="100"
                  />
                  <el-table-column
                    prop="companyNm"
                    label="会社名"
                    width="100"
                  />
                  <el-table-column
                    prop="expYears"
                    label="必須経験年数"
                    width="100"
                  />
                  <el-table-column prop="industryNm" label="業種" width="100" />
                  <el-table-column prop="jobTypeNm" label="職種" width="100" />
                  <el-table-column
                    prop="salaryMin"
                    label="最低限給料"
                    width="100"
                  />
                  <el-table-column
                    prop="salaryMax"
                    label="最高限給料"
                    width="100"
                  />
                  <el-table-column prop="station" label="最寄駅" width="100" />
                  <el-table-column
                    prop="empLaborIns"
                    label="雇用・労災保険"
                    width="120"
                  />
                  <el-table-column
                    prop="welfare"
                    label="福利厚生"
                    width="100"
                  />
                  <el-table-column
                    prop="trainingFlg"
                    label="研修有無"
                    width="100"
                  />
                  <el-table-column
                    prop="inspectionFlg"
                    label="見学有無"
                    width="100"
                  />
                  <el-table-column fixed="right" width="50">
                    <el-button
                      type="text"
                      size="large"
                      @click="toB0502Detailed"
                    >
                      <em class="el-icon-document" />
                    </el-button>
                  </el-table-column>
                  <el-table-column fixed="right" width="50">
                    <el-button type="text" size="large" @click="toB0502Modify">
                      <em class="el-icon-edit" />
                    </el-button>
                  </el-table-column>
                </el-table>
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
              </el-tab-pane>
              <el-tab-pane label="気に入る" name="third"
                ><el-table
                  ref="suisenTable"
                  :data="
                    getSyokuiList
                  "
                  style="width: 100%"
                  max-height="600px"
                >
                  <el-table-column type="selection" fixed="left" width="50" />
                  <el-table-column
                    prop="positionNm"
                    label="職位名"
                    width="100"
                  />
                  <el-table-column
                    prop="companyNm"
                    label="会社名"
                    width="100"
                  />
                  <el-table-column
                    prop="expYears"
                    label="必須経験年数"
                    width="100"
                  />
                  <el-table-column prop="industryNm" label="業種" width="100" />
                  <el-table-column prop="jobTypeNm" label="職種" width="100" />
                  <el-table-column
                    prop="salaryMin"
                    label="最低限給料"
                    width="100"
                  />
                  <el-table-column
                    prop="salaryMax"
                    label="最高限給料"
                    width="100"
                  />
                  <el-table-column prop="station" label="最寄駅" width="100" />
                  <el-table-column
                    prop="empLaborIns"
                    label="雇用・労災保険"
                    width="120"
                  />
                  <el-table-column
                    prop="welfare"
                    label="福利厚生"
                    width="100"
                  />
                  <el-table-column
                    prop="trainingFlg"
                    label="研修有無"
                    width="100"
                  />
                  <el-table-column
                    prop="inspectionFlg"
                    label="見学有無"
                    width="100"
                  />
                  <el-table-column fixed="right" width="50">
                    <el-button
                      type="text"
                      size="large"
                      @click="toB0502Detailed"
                    >
                      <em class="el-icon-document" />
                    </el-button>
                  </el-table-column>
                  <el-table-column fixed="right" width="50">
                    <el-button type="text" size="large" @click="toB0502Modify">
                      <em class="el-icon-edit" />
                    </el-button>
                  </el-table-column>
                </el-table>
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
              </el-tab-pane>
            </el-tabs>
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
import HomeHeader from "../spComponents/HomeHeader";
import HomeFooter from "../spComponents/HomeFooter";
import '@/css/reset.css';
import '@/css/border.css';
//移动端 解决点击按钮闪和active失效的问题
document.body.addEventListener('touchstart' , function(){});
export default {
  components: {
    HomeHeader,
    HomeFooter,
  },

  data() {
    return {
      c0201Form: {
        likeSelect: "",
        companyNm: "",
        prefeId: "",
        prefeNm: "",
        salary: 0,
        industryId: "",
        jobtypeId: "",
        degree: "",
        expYears: "",
        empLaborIns: "",
        welfare: "",
        trainingFlg: "",
        inspectionFlg: "",
        userCd: "",
      },
      prefeId: "",
      salary: "",
      industryId: "",
      jobtypeId: "",
      userCd: "",
      inspectionFlg: "0",
      welfare: "0",
      trainingFlg: "0",
      activeName: "first",

      syokuiList: [{ positionNm: "Cプロ" }],
      gakurekiList: [
        { gakurekiId: "0", gakurekiNm: "その他" },
        { gakurekiId: "1", gakurekiNm: "職業訓練校、予備校" },
        { gakurekiId: "2", gakurekiNm: "専門学校" },
        { gakurekiId: "3", gakurekiNm: "短期大学" },
        { gakurekiId: "4", gakurekiNm: "大学" },
        { gakurekiId: "5", gakurekiNm: "大学院（修士）" },
        { gakurekiId: "6", gakurekiNm: "大学院（博士）" },
      ],
      hokenList: [
        { hokenId: "0", hokenNm: "未加入" },
        { hokenId: "1", hokenNm: "一般の事業" },
        { hokenId: "2", hokenNm: "農林水産" },
        { hokenId: "3", hokenNm: "建計業他" },
      ],
      keikenList: [
        { keikenId: "0", keikenNm: "不問" },
        { keikenId: "1", keikenNm: "1年未満" },
        { keikenId: "2", keikenNm: "1～3年" },
        { keikenId: "3", keikenNm: "3～5年" },
        { keikenId: "4", keikenNm: "5～10年" },
        { keikenId: "5", keikenNm: "10年以上" },
      ],

      prefecturesMstBean: [],
      industryMstBean: [],
      jobtypeMstBean: [],
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
    };
  },

  mounted() {
    this.getSyokuiData();
  },
  computed:{
    getSyokuiList(){
      return (
        this.syokuiList.slice(this.pagination.dataStart, this.pagination.dataEnd) || ""
      );
    },
  },
  methods: {
    
    getSyokuiData() {
      this.setForm();
      this.$store.dispatch("c0201Init", this.c0201Form).then((response) => {
        this.$router.push({
          query: { data: response.data.data },
        });

        this.prefecturesMstBean = response.data.data.prefecturesMstBean;

        this.industryMstBean = response.data.data.industryMstBean;

        this.jobtypeMstBean = response.data.data.jobtypeMstBean;
        this.syokuiList = response.data.data.getAll;
        this.pagination.total = this.syokuiList.length;
        // console.clear();
      });
    },
    setForm() {
      if (this.industryId.length != 0) {
        this.c0201Form.industryId = parseInt(this.industryId, 10);
      }
      if (this.jobtypeId.length != 0) {
        this.c0201Form.jobtypeId = parseInt(this.jobtypeId, 10);
      }
      if (this.prefeId.length != 0) {
        this.c0201Form.prefeId = parseInt(this.prefeId, 10);
      }
      if (this.salary.length != 0) {
        this.c0201Form.salary = parseInt(this.salary, 10);
      }
      this.c0201Form.welfare = this.welfare;
      this.c0201Form.trainingFlg = this.trainingFlg;
      this.c0201Form.inspectionFlg = this.inspectionFlg;
    },

    handleClick() {
      this.setForm();
      if (this.activeName == "second") {
        this.$store
          .dispatch("c0201InitPost", this.c0201Form)
          .then((response) => {
            this.$router.push({
              query: { data: response.data.data },
            });

            this.prefecturesMstBean = response.data.data.prefecturesMstBean;

            this.industryMstBean = response.data.data.industryMstBean;

            this.jobtypeMstBean = response.data.data.jobtypeMstBean;
            this.syokuiList = response.data.data.getPost;
            this.pagination.total = this.syokuiList.length;
            // console.clear();
          });
      }
      if (this.activeName == "third") {
        this.$store
          .dispatch("c0201InitLike", this.c0201Form)
          .then((response) => {
            this.$router.push({
              query: { data: response.data.data },
            });

            this.prefecturesMstBean = response.data.data.prefecturesMstBean;

            this.industryMstBean = response.data.data.industryMstBean;

            this.jobtypeMstBean = response.data.data.jobtypeMstBean;
            this.syokuiList = response.data.data.getLike;
            this.pagination.total = this.syokuiList.length;
            // console.clear();
          });
      }

      if (this.activeName == "first") {
        this.$store
          .dispatch("c0201Init", this.c0201Form)
          .then((response) => {
            this.$router.push({
              query: { data: response.data.data },
            });

            this.prefecturesMstBean = response.data.data.prefecturesMstBean;

            this.industryMstBean = response.data.data.industryMstBean;

            this.jobtypeMstBean = response.data.data.jobtypeMstBean;
            this.syokuiList = response.data.data.getAll;
            this.pagination.total = this.syokuiList.length;
            // console.clear();
          });
      }
    },
    // 毎ページ行目数のselect
    sizeChange(val) {
      this.pagination.pageSize = val;
      console.log("pageSize", this.pagination.pageSize);
      this.dataFromTo();
    },
    // 当ページのボタン
    currentChange(val) {
      this.pagination.currentPage = val;
      console.log("currentPage", this.pagination.currentPage);
      this.dataFromTo();
    },
    // テーブル値行範囲の設定
    dataFromTo() {
      this.pagination.dataStart =
        (this.pagination.currentPage - 1) * this.pagination.pageSize;
      this.pagination.dataEnd =
        this.pagination.currentPage * this.pagination.pageSize;
      console.log("dataStart", this.pagination.dataStart);
      console.log("dataEnd", this.pagination.dataEnd);
    },
    shi() {
      console.log("");
    },
    setPrefeIdNm() {
      for (var i = 0; i < this.prefecturesMstBean.length; i++) {
        if (this.prefeId == this.prefecturesMstBean[i].prefeId) {
          this.c0201Form.prefeNm = this.prefecturesMstBean[i].prefeNm;
          break;
        }
      }
    },
  },
};
</script>

<style lang="scss" scoped>
// 主体页面灰色
.b0501_body {
  background-color: #f6f6f6;
}
// 两个主体部分边框阴影，白色背景
.b0501_select,
.b0501_data {
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);
  background-color: #ffffff;
}
// 内容body、两个主体外边距
.b0501_body,
.b0501_data,
.data_select {
  margin: 1vh, 1vh, 0px, 0px;
}
// 研修一覧标题右移1%
.b0501_title {
  margin-left: 1%;
}
// 两部分主体宽80vw，居中
.b0501_select,
.b0501_data {
  width: 90vw;
  margin: auto;
}
// 行上下内边距填充1vh
.el-row {
  padding-top: 1vh;
  padding-bottom: 1vh;
}
// 部分文字上下边距1vh，白底蓝字粗体
.b0501_title,
.blue_font {
  margin-top: 1vh;
  margin-bottom: 1vh;
  background-color: #ffffff;
  color: #006699;
  font-weight: 600;
}
// 研修一覧字号20
.b0501_title {
  font-size: 20px;
}
// 灰色上边线，上内边距
.select_body {
  border-top: 2px solid#f6f6f6;
  padding-top: 2vh;
}
// 检索按钮所在div内边距，底部外边距
.b0501_button {
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
.b0501Button {
  width: 110px;
  margin:10px 40px 15px 20px;
}
</style>