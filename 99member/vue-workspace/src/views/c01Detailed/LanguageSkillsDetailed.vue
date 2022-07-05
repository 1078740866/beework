<template>
  <el-card class="card-style">
    <el-collapse v-model="collapseIsActive" name="languageSkills" value="languageSkills">
      <el-collapse-item name="languageSkills" :title="name">
        <el-row>
          <el-col :span="24">
            <el-table
              ref="applicantLanTblBean"
              :data="applicantLanTblBean"
              :default-sort="{ prop: 'levelSection', order: 'descending' }"
              max-height="240"
              :empty-text="promptMessage.noTableData"
              highlight-current-row
              stripe
            >
              <el-table-column type="index" />
              <el-table-column prop="languageId" :label="labelName.language">
                <template v-slot="languageIdSlot">
                  {{ languageIdComputed(languageIdSlot.row) }}
                </template>
              </el-table-column>
              <el-table-column
                prop="levelSection"
                :label="labelName.levelSection"
                sortable
              >
                <template v-slot="eduSectionSlot">
                  {{ eduSectionComputed(eduSectionSlot.row) }}
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
  name: "c010105",
  props: {
    applicantLanTblBean: {},
    lanMstBean: {},
  },
  data() {
    return {
      name: "言語能力",
      // collapse初期不展開
      collapseIsActive: "",
      // テーブルラベル
      labelName: {
        language: "言語",
        levelSection: "言語レベル",
      },
      // 言語レベル
      eduSection: [
        { key: "0", value: "初期レベル" },
        { key: "1", value: "簡単会話" },
        { key: "2", value: "日常会話" },
        { key: "3", value: "流暢" },
        { key: "4", value: "ビジネス流暢" },
        { key: "5", value: "ナイティブ" },
      ],
      promptMessage: {
        noTableData: "外国語を学びませんでした",
      },
    };
  },
  computed: {
    // 言語能力数字→名
    eduSectionComputed() {
      return (row) => this.eduSection[row.levelSection].value;
    },
    // 言語ID→言語名
    languageIdComputed() {
      return (row) => this.lanMstBean[row.languageId - 1].language;
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
</style>
