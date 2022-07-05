<template>
  <div>
    <system-header />
    <el-main>
      <el-card shadow="hover">
        <div slot="header">
          <el-row>
            <el-col :span="23" :offset="1" v-text="promptMessage.cardTitle" />
          </el-row>
        </div>
        <div>
          <el-form ref="a0201Form" :model="a0201VueForm" label-width="10%">
            <el-form-item :label="labelName.ambiguousBox">
              <el-input
                :placeholder="labelName.ambiguousBox"
                v-model="a0201VueForm.ambiguousBox"
                class="input-with-select"
              >
                <el-button slot="append" icon="el-icon-search" />
              </el-input>
            </el-form-item>
          </el-form>
        </div>
      </el-card>
    </el-main>
    <home-footer />
  </div>
</template>
<script>
import SystemHeader from "@/views/components/SystemHeader";
import HomeFooter from "@/views/components/HomeFooter";
export default {
  name: "a0201",
  components: {
    SystemHeader,
    HomeFooter,
  },
  data() {
    return {
      a0201VueForm: {
        ambiguousBox: "",
        industryId: "",
        jobtypeId: "",
        degree: "",
        ageFrom: "",
        ageTo: "",
        birthdayFrom: "",
        birthdayTo: "",
        hopeSalaryFrom: "",
        hopeSalaryTo: "",
        hopeLand: "",
        workYears: "",
        prefeNm: "",
        languageId: "",
        levelSection: "",
        sex: "",
        applicantIds: [],
      },
      labelName: {
        ambiguousBox: "キーワード",
        jobtypeId: "業種-職種",
        hopeLand: "希望勤務地",
        degree: "学位",
        hopeSalary: "給料",
        ageFrom: "年齢",
        workYears: "経験年数",
        prefeNm: "住所",
        sex: "性別",
        languageId: "言語能力",
        levelSection: "言語レベル",
      },
      promptMessage: {
        cardTitle: "応募者管理",
      },
    };
  },
};
</script>
<style lang="scss">
@import "../../../css/app-css";
</style>
<style lang="scss" scoped>
@import "../../../css/scoped-css";
</style>
