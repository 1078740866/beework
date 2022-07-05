<template>
  <el-card class="card-style">
    <el-collapse
      v-model="collapseIsActive"
      name="educationBackground"
      value="educationBackground"
      @change="collapseChange"
    >
      <el-collapse-item name="educationBackground" :title="name">
        <el-row>
          <el-col :span="24">
            <el-table
              ref="applicantEduTblBean"
              :data="applicantEduTblBean"
              :default-sort="{ prop: 'eduDateFrom', order: 'ascending' }"
              @row-dblclick="rowDoubleClick"
              row-key="educationId"
              max-height="360"
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
                        <el-form-item :label="labelName.eduPhoto">
                          <pdf
                            :src="props.row.photoPic"
                            class="image-style"
                            v-if="rowPhotoIsPDF(props.row.degreePic1)"
                          />
                          <el-image
                            :src="props.row.photoPic"
                            fit="contain"
                            class="image-style"
                            v-else
                          >
                            <div slot="error" class="image-slot">
                              <em class="" />
                            </div>
                          </el-image>
                        </el-form-item>
                      </el-col>
                      <el-col :span="12">
                        <el-form-item :label="labelName.eduSection">
                          <p>{{ eduSectionComputed(props.row) }}</p>
                        </el-form-item>
                      </el-col>
                    </el-row>
                  </el-form>
                </template>
              </el-table-column>
              <el-table-column prop="schoolNm" :label="labelName.schoolNm" />
              <el-table-column prop="eduDateFrom" :label="labelName.eduDate" sortable>
                <template v-slot="eduDateSlot">
                  {{ eduDateComputed(eduDateSlot.row) }}
                </template>
              </el-table-column>
              <el-table-column prop="degree" :label="labelName.degree" sortable>
                <template v-slot="degreeSlot">
                  {{ degreeComputed(degreeSlot.row) }}
                </template>
              </el-table-column>
              <el-table-column prop="majorNm" :label="labelName.majorNm" />
            </el-table>
          </el-col>
        </el-row>
      </el-collapse-item>
    </el-collapse>
  </el-card>
</template>
<script>
import pdf from "vue-pdf";
export default {
  name: "c010106",
  props: {
    applicantEduTblBean: {},
  },
  components: {
    pdf,
  },
  data() {
    return {
      name: "学歴",
      // collapse初期不展開
      collapseIsActive: "",
      // テーブルラベル
      labelName: {
        eduSection: "学歴区分",
        eduDate: "学歴期間",
        eduDateFrom: "入学日",
        eduDateTo: "卒業日",
        degree: "学位",
        schoolNm: "学校名",
        majorNm: "専攻",
        eduPhoto: "証明写真",
        eduAdd: "学歴新規",
        eduEdit: "学歴編集",
      },
      // 学歴区分
      eduSection: [
        { key: "0", value: "非大学" },
        { key: "1", value: "私立大学" },
        { key: "2", value: "国立大学" },
      ],
      // 学位
      degree: [
        { key: "0", value: "その他" },
        { key: "1", value: "職業訓練校、予備校" },
        { key: "2", value: "専門学校" },
        { key: "3", value: "短期大学" },
        { key: "4", value: "大学" },
        { key: "5", value: "大学院（修士）" },
        { key: "6", value: "大学院（博士）" },
      ],
      promptMessage: {
        noTableData: "学歴情報を記入しなかった",
      },
    };
  },
  computed: {
    // 学歴開始日付-終了日付
    eduDateComputed() {
      return (row) => row.eduDateFrom + "-" + row.eduDateTo;
    },
    // 学位数字→学位名
    degreeComputed() {
      return (row) => this.degree[row.degree].value;
    },
    // 学歴区分数字→名
    eduSectionComputed() {
      return (row) => this.eduSection[row.eduSection].value;
    },
  },
  methods: {
    // テーブル行目ダブルクリック
    rowDoubleClick(row) {
      let $applicantEduTblBean = this.$refs.applicantEduTblBean;
      this.applicantEduTblBean.map((item) => {
        // 単一の行目展開
        if (row.educationId != item.educationId) {
          $applicantEduTblBean.toggleRowExpansion(item, false);
        }
      });
      $applicantEduTblBean.toggleRowExpansion(row);
    },
    // テーブル内の写真タイプ判断
    rowPhotoIsPDF(file) {
      var fileType = "";
      if (file.split(".")[1]) fileType = file.split(".")[file.split(".").length - 1];
      return fileType == "pdf" ? true : false;
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
      this.applicantEduTblBean.map((item) => {
        this.$refs.applicantEduTblBean.toggleRowExpansion(item, false);
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
