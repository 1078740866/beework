<template>
  <div class="b0301_page">
    <el-container>
      <el-header>
        <div class="header">
          <HomeHeader />
        </div>
      </el-header>
      <el-form
        :model="b0301Form"
        ref="loginForm"
        label-position="left"
        autocomplete="on"
      >
        <el-main class="b0301_body">
          <div class="b0301_select">
            <el-row>
              <el-col :span="24">
                <div class="b0301_title">人材推薦一覧</div>
              </el-col>
            </el-row>
            <div class="select_body">
              <el-row :gutter="1">
                <el-col :span="7" :offset="1">
                  <div>
                    <el-form-item label="業種-職種：" label-width="80px">
                      <el-cascader
                        v-model="b0301Form.industryAndJobtype"
                        :options="IndustryAndJobtypeOptions"
                        :props="IndustryAndJobtypeProps"
                        clearable
                        filterable
                      >
                      </el-cascader>
                    </el-form-item>
                  </div>
                </el-col>
                <el-col :span="6" :offset="1">
                  <div>
                    <el-form-item label="住所：" label-width="80px">
                      <el-select
                        v-model="b0301Form.prefeNm"
                        @change="setPrefeNm"
                        placeholder="住所"
                        clearable>
                          <el-option
                            v-for="item in prefecturesOptions"
                            :key="item.value"
                            :label="item.label"
                            :value="item.value">
                          </el-option>
                      </el-select>
                    </el-form-item>
                  </div>
                </el-col>
                <el-col :span="7" :offset="1">
                  <div>
                    <el-form-item label="希望勤務先：" label-width="100px">
                      <el-select
                        v-model="b0301Form.hopeland"
                        placeholder="希望勤務先"
                        clearable>
                          <el-option
                            v-for="item in prefecturesOptions"
                            :key="item.value"
                            :label="item.label"
                            :value="item.value">
                          </el-option>
                      </el-select>
                    </el-form-item>
                  </div>
                </el-col>
              </el-row>
            </div>
            <el-row :gutter="1">
                <el-col :span="7" :offset="1">
                  <div>
                    <el-form-item label="学位：" label-width="80px">
                      <el-select
                        v-model="b0301Form.finalEducation"
                        placeholder="学位"
                        clearable
                      >
                        <el-option
                          v-for="item in degreeOptions"
                          :key="item.value"
                          :label="item.label"
                          :value="item.value"
                        />
                      </el-select>
                    </el-form-item>
                  </div>
                </el-col>
                <el-col :span="6" :offset="1">
                <div>
                  <el-form-item label="言語能力：" label-width="80px">
                    <el-select
                      v-model="b0301Form.languageId"
                      placeholder="言語能力"
                      clearable>
                        <el-option
                          v-for="item in languageOptions"
                          :key="item.value"
                          :label="item.label"
                          :value="item.value">
                        </el-option>
                    </el-select>
                  </el-form-item>
                </div>
              </el-col>
                <el-col :span="7" :offset="1">
                <div>
                  <el-form-item label="レベル：" label-width="100px">
                    <el-select
                      v-model="b0301Form.levelSection"
                      placeholder="レベル"
                      clearable>
                        <el-option
                          v-for="item in levelOptions"
                          :key="item.value"
                          :label="item.label"
                          :value="item.value">
                        </el-option>
                    </el-select>
                  </el-form-item>
                </div>
              </el-col>
              </el-row>
            <el-row :gutter="1">
              <el-col :span="7" :offset="1">
                    <el-form-item 
                    label="年齢：" 
                    label-width="80px" 
                    >
                    <el-input
                      v-model="b0301Form.ageFrom"
                      class="rangeStyle"
                      align="right"
                      style="width :80px"
                      clearable
                      >
                    </el-input>
                 <label> ~ </label>
                    <el-input
                      v-model="b0301Form.ageTo"
                      class="rangeStyle"
                      align="right"
                      style="width :80px"
                      clearable>
                    </el-input>
               </el-form-item>
                </el-col>
                <el-col :span="6" :offset="1">
                    <el-form-item 
                    label="経験年数：" 
                    label-width="80px" 
                    >
                    <el-input
                      v-model="b0301Form.workYearsFrom"
                      class="rangeStyle"
                      align="right"
                      style="width :80px"
                      clearable>
                    </el-input>
                   <label> ~ </label>
                    <el-input
                      v-model="b0301Form.workYearsTo"
                      class="rangeStyle"
                      align="right"
                      style="width :80px"
                      clearable
                      >
                    </el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="7" :offset="1">
                    <el-form-item 
                    label="給料：" 
                    label-width="100px"
                    >
                    <el-input
                      v-model="b0301Form.hopeSalaryFrom"
                      class="rangeStyle"
                      align="right"
                      style="width :80px"
                      clearable
                      >
                    </el-input>
                    <label> ~ </label>
                    <el-input
                      v-model="b0301Form.hopeSalaryTo"
                      class="rangeStyle"
                      align="right"
                      style="width :80px"
                      clearable
                      >
                    </el-input>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-row :gutter="1">
              <el-col :span="7" :offset="1">
                <div>
                  <el-form-item label="性別：" label-width="80px">
                    <el-select
                      v-model="b0301Form.sex"
                      placeholder="性別"
                      clearable>
                        <el-option
                          v-for="item in genderOptions"
                          :key="item.value"
                          :label="item.label"
                          :value="item.value">
                        </el-option>
                    </el-select>
                  </el-form-item>
                </div>
              </el-col>
             <el-col :span="6" :offset="1">
                <div>
                  <el-form-item label="スキル：" label-width="80px">
                    <el-select
                      v-model="b0301Form.skillId"
                      placeholder="スキル"
                      clearable>
                        <el-option
                          v-for="item in skillOptions"
                          :key="item.value"
                          :label="item.label"
                          :value="item.value">
                        </el-option>
                    </el-select>
                  </el-form-item>
                </div>
              </el-col>
            </el-row>
            <div class="b0301_button">
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
                            <el-link @click="getTrainingData" type="primary" :underline="false">
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
          <div class="b0301_data">
            <div class="data_body">
              <el-table
                ref="multipleTable"
                :data="getTrainingList"
                :default-sort="{ prop: 'b0301Date', order: 'descending' }"
                tooltip-effect="dark"
                style="width: 100%"
                max-height="600px"
                @row-click="getRowData"
                @selection-change="selectionChange"
                highlight-current-row>
                <el-table-column type="expand">
                  <template slot-scope="props">
                    <el-form label-position="left" inline class="table-expand">
                      <el-form-item label="住所">
                        <!-- <el-table-column prop="address1" label="住所" sortable/> -->
                        <span>{{ props.row.address1 }}</span>
                      </el-form-item>
                      <el-form-item label="最寄駅">
                        <!-- <el-table-column prop="station" label="最寄駅" sortable/> -->
                        <span>{{ props.row.station }}</span>
                      </el-form-item>
                      <el-form-item label="希望給料下限">
                        <!-- <el-table-column prop="hopeSalaryFrom" label="希望給料下限" sortable/> -->
                        <span>{{ props.row.hopeSalaryFrom }}円</span>
                      </el-form-item>
                      <el-form-item label="希望給料上限">
                        <!-- <el-table-column prop="hopeSalaryTo" label="希望給料上限" sortable/> -->
                        <span>{{ props.row.hopeSalaryTo }}円</span>
                      </el-form-item>
                      <!-- <el-form-item label="学位"> -->
                        <!-- <span>{{ getDegreeOptions[props.row.finalEducation] }}</span> -->
                      <!-- </el-form-item> -->
                      <el-form-item label="卒業学校">
                        <!-- <el-table-column prop="graduationSchool" label="卒業学校" sortable/> -->
                        <span>{{ props.row.graduationSchool }}</span>
                      </el-form-item>
                      <el-form-item label="更新日時">
                        <!-- <el-table-column prop="updateTime" label="更新日時" sortable /> -->
                        <span>{{ props.row.updateTime }}</span>
                      </el-form-item>
                    </el-form>
                  </template>
                </el-table-column>
                  <!-- <el-table-column type="selection" fixed="left" sortable/> -->
                  <el-table-column prop="name" label="氏名" sortable/>
                  <el-table-column prop="industryNm" label="業種-職種" sortable>
                    <template slot-scope="scope">
                      {{ scope.row.industryNm }}
                      {{ scope.row.jobtypeNm }}
                    </template>
                  </el-table-column>
                  <el-table-column prop="workYears"  label="経験年数" sortable/>
                <el-table-column prop="sex" label="性別" sortable >
                  <template slot-scope="scope">
                    {{ getSexOption[scope.row.sex] }}
                  </template>
                </el-table-column>
                <el-table-column prop="birthday" label="年齢" sortable/>
                <el-table-column prop="finalEducation" label="学位" sortable>
                  <template slot-scope="scope">
                    {{ getDegreeOptions[scope.row.finalEducation] }}
                  </template>
                </el-table-column>
                <el-table-column fixed="right" width="50" >
                  <el-button type="text" size="large" @click="toA0202_01Detail">
                    <em class="el-icon-chat-line-round" />
                  </el-button>
                </el-table-column>
              </el-table>
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
// import * as b0301Select from "@/api/b03";

export default {
  name: "Init",
  components: {
    HomeHeader,
    HomeFooter,
  },
  // mounted() {
  //   document.title = "人材推薦一覧";
  // },
  inject: ["reload"],
  data() {
    return {
      // 検索条件
      b0301Form: {
        companyId: Number,
        userCd: Number,
        trainingNm: "",
        industryAndJobtype: "",
        prefeNm: "",
        finalEducation: "",
        hopeland: "",
        ageFrom: "",
        ageTo: "",
        workYearsFrom: "",
        workYearsTo: "",
        languageId: "",
        languageNm: "",
        levelSection: "",
        skillId: "",
        sex: "",
        hopeSalaryFrom: "",
        hopeSalaryTo: ""
      },
      // 転送用form
      b0301VueForm: {
        companyId: Number,
        userCd: Number,
        skillId: Number,
        industryId: Number,
        jobtypeId: Number,
        prefeNm: "",
        hopeland: Number,
        finalEducation: "",
        workYearsFrom: Number,
        workYearsTo: Number,
        languageId: Number,
        levelSection: "",
        sex: "",
        hopeSalaryFrom: Number,
        hopeSalaryTo: Number,
        ageFrom: Number,
        ageTo: Number
      },
      // 業種-職種リスト
      // IndustryAndJobtypeProps: {multiple: true},
      IndustryAndJobtypeOptions: [],
      // 住所リスト
      prefecturesOptions: [],
      // 学位リスト
      degreeOptions: [
        { value: "0", label: "その他" },
        { value: "1", label: "職業訓練校、予備校" },
        { value: "2", label: "専門学校" },
        { value: "3", label: "短期大学" },
        { value: "4", label: "大学" },
        { value: "5", label: "大学院（修士）" },
        { value: "6", label: "大学院（博士）" }
      ],
      // 性別リスト
      genderOptions: [
        { value: "0", label: "男" },
        { value: "1", label: "女" }
      ],
      // レベルリスト
      levelOptions: [
        { value: "0", label: "初級レベル" },
        { value: "1", label: "簡単会話" },
        { value: "2", label: "日常会話" },
        { value: "3", label: "流暢" },
        { value: "4", label: "ビジネス流暢" },
        { value: "5", label: "ネイティブ" }
      ],
      // スキルリスト
      skillOptions: [],
      // 言語リスト
      languageOptions: [],
      // 取得した業種リスト
      industryCds: "",
      // 取得した性別リスト
      getSexOption: {
        '0': '男',
        '1': '女',
      },
      getDegreeOptions: {
        '0' : 'その他',
        '1' : '職業訓練校、予備校',
        '2' : '専門学校',
        '3' : '短期大学',
        '4' : '大学',
        '5' : '大学院（修士）',
        '6' : '大学院（博士）'
      },
      // 取得したスキルリスト
      skillCds: "",
      // 都道府県を取得
      prefectures: "",
      // 言語リストを取得
      lanCds: "",
      // 状態リストのデータ
      status_flag: [
        { value: "0", label: "未確認" },
        { value: "1", label: "確認済み" },
        { value: "2", label: "拒否する" },
      ],
      // テーブルのデータ
      trainingList: [],
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
      // 複数チェックボックス
      multipleSelection: [],
    };
  },

  mounted() {
    document.title = "人材推薦一覧";
    this.getTrainingData();
  },
  computed: {
    getTrainingList() {
      return (
        this.trainingList.slice(this.pagination.dataStart, this.pagination.dataEnd) || ""
      );
    },
  },
  methods: {
    // クリアボタン
    resetForm() {
      this.b0301Form = {
        trainingNm: "",
        industryId: "",
        industryIdNm: "",
        statusFlg: "",
        date: [],
      };
    },
    // 住所名設定
    setPrefeNm() {
      for (var i = 0; i < this.prefecturesOptions.length; i++) {
        if (this.b0301Form.prefeNm == this.prefecturesOptions[i].value) {
          this.b0301Form.prefeNm = this.prefecturesOptions[i].label;
          break;
        }
      }
    },
    // 戻るボタン
    toLastPage() {
      this.$router.push({
        path: "/b0003",
      });
    },
    // 全選択ボタン
    toggleSelection(rows) {
      if (rows) {
        this.b0301VueForm.trainingIds = rows.trainingIds;
        rows.forEach((row) => {
          this.$refs.multipleTable.toggleRowSelection(row);
        });
      } else {
        this.b0301VueForm.trainingIds = [];
        this.$refs.multipleTable.clearSelection();
      }
    },
    //チェックボックス
    multiSelect(val) {
      this.multipleSelection = val;
      console.log("multipleSelectionMulti", this.multipleSelection);
    },
    // 複数チェックボックス
    selectionChange(val) {
      this.multipleSelection = [];
      for (var i = 0; i < val.length; i++) {
        this.multipleSelection.push(val[i].trainingId);
      }
    },

    //当行目データ削除
    deleteOne(val) {
      console.clear();
      this.confirmMessageBox(val);
    },
    toA0202_01Detail(){
      this.$router.push({ path: "b0502Registered" });
    },
    // 検索ボタンデータ取得
    getTrainingData() {
      this.setTrainingData();
      this.$store
        .dispatch("b0301Search", this.b0301VueForm)
        .then((response) => {
          this.$router.push({
            query: { data: response.data.data },
          });
          // テーブルデータを取得する
          this.trainingList = response.data.data.b0301Beans;
          // データ数を取得する
          this.pagination.total = this.trainingList.length;
          // 業種リストを取得する
          this.industryCds = response.data.data.industryList;
          // 職種リストを取得
          this.jobtypeCds = response.data.data.jobtypeList;


          // 都道府県を取得
          this.prefectures = response.data.data.prefecturesList;
          let setPrefecturesBatch = prefectures  => prefectures.map(({prefeId, prefeNm}) => ({
              value    : prefeId,
              label    : prefeNm
          }));
          this.prefecturesOptions = setPrefecturesBatch(this.prefectures);
          //this.setPrefectures();
          // 言語リストを取得
          this.lanCds = response.data.data.lanList;
          let setLanguageBatch = lanCds  => lanCds.map(({languageId, language}) => ({
              value    : languageId,
              label    : language
          }));
          this.languageOptions = setLanguageBatch(this.lanCds);
          // 業種-職種データを編集する
          let batchdata = this.industryCds.map(industryVal => {
            industryVal.children = [];
            this.jobtypeCds.map(jobtypeVal => {
              if (industryVal.industryId === jobtypeVal.industryId) {
                delete jobtypeVal.industryId;
                industryVal.children.push(jobtypeVal);
              }
            });
            return industryVal;
          });
          let dataValueBatch = batchdata  => batchdata.map(({industryId, industryNm, jobtypeId, jobtypeNm, children}) => (children ? {
                    value    : industryId,
                    label    : industryNm,
                    children : dataValueBatch(children),
                } : {
                    value : jobtypeId,
                    label : jobtypeNm,
                }));
          let industryForChangeList = dataValueBatch(batchdata);
          this.IndustryAndJobtypeOptions = industryForChangeList;
          // スキルリストを取得
          this.skillCds = response.data.data.skillList;
          let setSkillBatch = skillCds  => skillCds.map(({skillId, skillNm}) => ({
              value    : skillId,
              label    : skillNm
          }));
          this.skillOptions = setSkillBatch(this.skillCds);
          // console.clear();
          console.log("vresponse.data.data", response.data.data);
          console.log("b0301VueForm", this.b0301VueForm);
          console.log("trainingList", this.trainingList);
          console.log("skillCds", this.skillCds);
          console.log("prefectures", this.prefectures);
          console.log("lanCds", response.data.data.lanList);
        });
    },
    // 検索条件の値を設定する
    setTrainingData() {
      this.b0301VueForm.companyId = this.b0301Form.companyId
      this.b0301VueForm.userCd = this.b0301Form.userCd
      this.b0301VueForm.skillId = this.b0301Form.skillId
      this.b0301VueForm.industryId = null;
      this.b0301VueForm.jobtypeId = null;
      if(this.b0301Form.industryAndJobtype){
        if(this.b0301Form.industryAndJobtype.length > 1){
          this.b0301VueForm.industryId = this.b0301Form.industryAndJobtype[0];
          this.b0301VueForm.jobtypeId = this.b0301Form.industryAndJobtype[1];
        }else{
          this.b0301VueForm.industryId = this.b0301Form.industryAndJobtype[0];
        }
      }
      this.b0301VueForm.prefeNm = this.b0301Form.prefeNm
      this.b0301VueForm.hopeland = this.b0301Form.hopeland
      this.b0301VueForm.finalEducation = this.b0301Form.finalEducation
      this.b0301VueForm.workYearsFrom = this.b0301Form.workYearsFrom
      this.b0301VueForm.workYearsTo = this.b0301Form.workYearsTo
      this.b0301VueForm.languageId = this.b0301Form.languageId
      this.b0301VueForm.levelSection = this.b0301Form.levelSection
      this.b0301VueForm.sex = this.b0301Form.sex
      this.b0301VueForm.hopeSalaryFrom = this.b0301Form.hopeSalaryFrom
      this.b0301VueForm.hopeSalaryTo = this.b0301Form.hopeSalaryTo
      this.b0301VueForm.ageFrom = this.b0301Form.ageFrom
      this.b0301VueForm.ageTo = this.b0301Form.ageTo
    },
    // 選択され行目内容
    getRowData(row) {
      this.$refs.multipleTable.toggleRowSelection(row);
      this.b0301VueForm.trainingIds = new Array(row.trainingId);
      console.clear();
      console.log("trainingIds", this.b0301VueForm.trainingIds);
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
.b0301_body {
  background-color: #f6f6f6;
}
/* 两个主体部分边框阴影，白色背景 */
.b0301_select,
.b0301_data {
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);
  background-color: #ffffff;
}
/* 内容body、两个主体外边距 */
.b0301_body,
.b0301_data,
.data_select {
  margin: 1vh, 1vh, 0px, 0px;
}
/* 研修一覧标题右移1% */
.b0301_title {
  margin-left: 1%;
}
.el-col {
    border-radius: 4px;
  }
/* 两部分主体宽80vw，居中 */
.b0301_select,
.b0301_data {
  width: 80vw;
  margin: auto;
}
/* 行上下内边距填充1vh */
.el-row {
  padding-top: 1vh;
  padding-bottom: 1vh;
}
/* 部分文字上下边距1vh，白底蓝字粗体 */
.b0301_title,
.blue_font {
  margin-top: 1vh;
  margin-bottom: 1vh;
  background-color: #ffffff;
  color: #006699;
  font-weight: 600;
}
/* 研修一覧字号20 */
.b0301_title {
  font-size: 20px;
}
/* 灰色上边线，上内边距 */
.select_body {
  border-top: 2px solid#f6f6f6;
  padding-top: 2vh;
}
/* 检索按钮所在div内边距，底部外边距 */
.b0301_button {
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
/* 按钮本体 */
.b0301Button {
  width: 110px;
}
.table-expand {
  font-size: 0;
}
.table-expand label {
  width: 100px;
  color: #99a9bf;
}
.table-expand .el-form-item {
  margin-left: 5%;
    margin-right: 0;
    margin-bottom: 0;
    width: 40%;
}
</style>
