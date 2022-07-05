<template>
  <el-card class="card-style">
    <el-collapse
      v-model="collapseIsActive"
      name="skillInformation"
      value="skillInformation"
    >
      <el-collapse-item name="skillInformation" :title="name">
        <el-row>
          <el-col :span="24">
            <el-table
              ref="applicantSkillTblBean"
              :data="applicantSkillTblBean"
              :default-sort="{
                prop: 'expSection',
                order: 'descending',
              }"
              row-key="applicantskillId"
              max-height="240"
              :empty-text="promptMessage.noTableData"
              highlight-current-row
              stripe
            >
              <el-table-column type="index" />
              <el-table-column prop="skillId" :label="labelName.industryNm">
                <template v-slot="industrySlot">
                  <div v-for="skillItem in skillMstBean" :key="skillItem.skillId">
                    <div v-if="skillItem.skillId == industrySlot.row.skillId">
                      <div
                        v-for="industryItem in industryMstBean"
                        :key="industryItem.industryId"
                      >
                        <span v-if="industryItem.industryId == skillItem.industryId">
                          {{ industryItem.industryNm }}
                        </span>
                      </div>
                    </div>
                  </div>
                </template>
              </el-table-column>
              <el-table-column
                prop="skillId"
                :label="labelName.jobTypeNm"
                min-width="100%"
              >
                <template v-slot="jobTypeSlot">
                  <div v-for="skillItem in skillMstBean" :key="skillItem.skillId">
                    <div v-if="skillItem.skillId == jobTypeSlot.row.skillId">
                      <div
                        v-for="jobTypeItem in jobtypeMstBean"
                        :key="jobTypeItem.jobtypeId"
                      >
                        <span v-if="jobTypeItem.jobtypeId == skillItem.jobtypeId">
                          {{ jobTypeItem.jobtypeNm }}
                        </span>
                      </div>
                    </div>
                  </div>
                </template>
              </el-table-column>
              <el-table-column prop="skillNm" :label="labelName.skillNm">
                <template v-slot="skillNameSlot">
                  <span v-if="skillNameSlot.row.skillNm !== labelName.otherNm">
                    {{ skillNameSlot.row.skillNm }}
                  </span>
                  <span v-else>
                    {{ skillNameSlot.row.otherNm }}
                  </span>
                </template>
              </el-table-column>
              <el-table-column prop="expSection" :label="labelName.expSection" sortable>
                <template v-slot="experienceSectionSlot">
                  {{ experienceSectionComputed(experienceSectionSlot.row) }}
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
// 内容チェック機能導入
export default {
  name: "c010103",
  rules: {},
  props: {
    applicantSkillTblBean: {},
    industryMstBean: {},
    jobtypeMstBean: {},
    skillMstBean: {},
  },
  data() {
    return {
      name: "スキル",
      // collapse初期不展開
      collapseIsActive: "",
      // 経験程度
      expSection: [
        { key: "0", value: "知識有り、未経験" },
        { key: "1", value: "経験あり、1年以下" },
        { key: "2", value: "経験あり、3年以下" },
        { key: "3", value: "精通、指導できる" },
      ],
      // テーブルラベル
      labelName: {
        applicantID: "応募者ID",
        skillNm: "スキル",
        expSection: "経験程度",
        skillAdd: "スキル新規",
        skillEdit: "スキル編集",
        industryNm: "業種",
        jobTypeNm: "職種",
        industryJobSkill: "業種-職種-スキル",
        otherName: "スキル名前",
        otherNm: "その他",
      },
      promptMessage: {
        noTableData: "スキルは取得していません",
      },
    };
  },
  computed: {
    // 経験程度判断
    experienceSectionComputed() {
      return (row) => this.expSection[row.expSection].value;
    },
  },
  methods: {
    // その他選択の場合、その他名前ラン表示
    isOtherNm() {
      this.oterNameShow = false;
      this.skillMstBean.forEach((skillElement) => {
        if (
          skillElement.skillNm == this.labelName.otherNm &&
          this.c010103VueForm.skillId[2] == skillElement.skillId
        ) {
          this.oterNameShow = true;
        }
      });
      console.log("oterNameShow", this.oterNameShow);
      return this.oterNameShow;
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
