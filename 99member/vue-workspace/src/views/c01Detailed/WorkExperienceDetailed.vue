<template>
  <el-card class="card-style">
    <el-collapse
      v-model="collapseIsActive"
      name="workExperience"
      value="workExperience"
      @change="collapseChange"
    >
      <el-collapse-item name="workExperience" :title="name">
        <el-row>
          <el-col :span="24">
            <el-table
              ref="applicantWorkHisTblBean"
              :data="applicantWorkHisTblBean"
              :default-sort="{ prop: 'workDateFrom', order: 'descending' }"
              @row-dblclick="rowDoubleClick"
              row-key="workHisId"
              max-height="420"
              :empty-text="promptMessage.noTableData"
              highlight-current-row
              stripe
            >
              <el-table-column type="index" />
              <el-table-column type="expand">
                <template slot-scope="props">
                  <el-form :model="props" label-position="top">
                    <el-row>
                      <el-col :span="12">
                        <el-form-item :label="labelName.workPlace">
                          <p>{{ props.row.workPlace }}</p>
                        </el-form-item>
                      </el-col>
                      <el-col :span="12">
                        <el-form-item :label="labelName.industryId1">
                          <p>{{ industryIdComputed(props.row) }}</p>
                        </el-form-item>
                      </el-col>
                    </el-row>
                    <el-row>
                      <el-col :span="12">
                        <el-form-item :label="labelName.introduction">
                          <p>{{ props.row.introduction }}</p>
                        </el-form-item>
                      </el-col>
                      <el-col :span="12">
                        <el-form-item :label="labelName.workSkill">
                          <p>{{ props.row.workSkill }}</p>
                        </el-form-item>
                      </el-col>
                    </el-row>
                  </el-form>
                </template>
              </el-table-column>
              <el-table-column prop="jobtypeId1_1" :label="labelName.jobType1">
                <template v-slot="jobTypeSlot">
                  {{ jobType1Computed(jobTypeSlot.row) }}
                </template>
              </el-table-column>
              <el-table-column prop="workPosition" :label="labelName.workPosition" />
              <el-table-column prop="companyNm" :label="labelName.companyNm" />
              <el-table-column prop="workDateFrom" :label="labelName.workDate" sortable>
                <template v-slot="workDateSlot">
                  {{ workDateComputed(workDateSlot.row) }}
                </template>
              </el-table-column>
            </el-table>
          </el-col>
        </el-row>
      </el-collapse-item>
    </el-collapse>
  </el-card>
</template>
<script>
export default {
  name: "c010104",
  props: {
    applicantWorkHisTblBean: {},
    industryMstBean: {},
    jobtypeMstBean: {},
  },
  data() {
    return {
      name: "職歴",
      // collapse初期不展開
      collapseIsActive: "",
      // テーブルラベル
      labelName: {
        workAdd: "職歴新規",
        workEdit: "職歴編集",
        companyNm: "会社名",
        industryJob: "業種-職種",
        industryId1: "業種",
        jobType1: "職種",
        workPosition: "職位",
        workPlace: "勤務地",
        workDate: "在職期間",
        workContent: "職務内容",
        workSkill: "使用技術",
        introduction: "事業内容",
        workDateFrom: "入社日",
        workDateTo: "退社日",
      },
      promptMessage: {
        noTableData: "実務経験なし",
      },
    };
  },
  computed: {
    // 仕事開始日付-終了日付
    workDateComputed() {
      return (row) => row.workDateFrom + "-" + row.workDateTo;
    },
    // 業種ID→業種名
    industryIdComputed() {
      return (row) => this.industryMstBean[row.industryId1 - 1].industryNm;
    },
    // 職種ID→職種名
    jobType1Computed() {
      return (row) => this.jobtypeMstBean[row.jobtypeId1_1].jobtypeNm;
    },
  },
  methods: {
    // テーブル行目ダブルクリック
    rowDoubleClick(row) {
      let $applicantWorkHisTblBean = this.$refs.applicantWorkHisTblBean;
      this.applicantWorkHisTblBean.map((item) => {
        // 単一の行目展開
        if (row.workHisId != item.workHisId) {
          $applicantWorkHisTblBean.toggleRowExpansion(item, false);
        }
      });
      $applicantWorkHisTblBean.toggleRowExpansion(row);
    },
    // collapse展開状態
    collapseChange(val) {
      if (val.length == 1) {
        // 展開した行目クローズ
        this.tableRowClose();
      }
    },
    // 展開した行目クローズ
    tableRowClose() {
      this.applicantWorkHisTblBean.map((item) => {
        this.$refs.applicantWorkHisTblBean.toggleRowExpansion(item, false);
      });
    },
  },
};
</script>
<style lang="scss" scoped>
// カードのマージン
.card-style {
  margin: 2vh 10%;
}
// collapse本体
.el-collapse {
  border: none;
}
// collapseのタイトル
::v-deep .el-collapse-item__header {
  font-size: 28px;
  color: #409eff;
}
// coolapseボルダ
::v-deep .el-collapse-item__header,
::v-deep .el-collapse-item__wrap {
  border-bottom: none;
}
// ラベルの青字
::v-deep div > .el-form-item__label {
  font-size: 16px;
  color: #014099;
  font-style: normal;
  font-weight: bold;
}
</style>
