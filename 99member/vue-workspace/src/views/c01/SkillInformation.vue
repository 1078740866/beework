<template>
  <el-card class="card-style">
    <el-collapse
      v-model="collapseIsActive"
      name="skillInformation"
      value="skillInformation"
      @change="collapseChange"
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
              <el-table-column fixed="right" width="30">
                <template slot-scope="editScope">
                  <el-tooltip
                    :content="promptMessage.editButton"
                    effect="light"
                    placement="top-start"
                    :open-delay="400"
                  >
                    <el-button
                      type="text"
                      size="large"
                      @click.native.prevent="editButton(editScope.row)"
                    >
                      <em class="el-icon-edit-outline" />
                    </el-button>
                  </el-tooltip>
                </template>
              </el-table-column>
              <el-table-column fixed="right" width="30">
                <template slot-scope="deleteScope">
                  <el-tooltip
                    :content="promptMessage.deleteButton"
                    effect="light"
                    placement="right"
                    :open-delay="400"
                  >
                    <el-button
                      @click.native.prevent="confirmMessageBox(deleteScope.row)"
                      type="text"
                    >
                      <em class="el-icon-delete" />
                    </el-button>
                  </el-tooltip>
                </template>
              </el-table-column>
            </el-table>
          </el-col>
        </el-row>
        <el-row>
          <el-col
            :span="21"
            :offset="1"
            v-text="showNameComputed"
            v-show="showSelect"
            class="qua-add"
          />
          <el-col :span="2" :offset="22" v-show="!showSelect">
            <el-tooltip
              :content="promptMessage.addButton"
              effect="light"
              placement="right"
              :open-delay="400"
            >
              <el-button type="text" @click="selectOpen">
                <em class="el-icon-circle-plus" />
              </el-button>
            </el-tooltip>
          </el-col>
          <el-col :span="2" v-show="showSelect">
            <el-tooltip
              :content="promptMessage.closeButton"
              effect="light"
              placement="right"
              :open-delay="400"
            >
              <el-button @click="selectClose" type="text">
                <em class="el-icon-remove" />
              </el-button>
            </el-tooltip>
          </el-col>
        </el-row>
        <transition name="el-zoom-in-center">
          <el-form
            ref="c010103VueForm"
            :model="c010103VueForm"
            :rules="rules"
            label-width="17%"
            v-show="showSelect"
            class="select-style"
          >
            <el-row>
              <el-col :span="2" :offset="20">
                <el-tooltip
                  :content="promptMessage.clearButton"
                  effect="light"
                  placement="left"
                  :open-delay="400"
                >
                  <el-button type="text" @click="clearForm">
                    <em class="el-icon-document-remove" />
                  </el-button>
                </el-tooltip>
              </el-col>
              <el-col :span="2" v-show="titleChange">
                <el-tooltip
                  :content="promptMessage.saveButton"
                  effect="light"
                  placement="right"
                  :open-delay="400"
                >
                  <el-button type="text" @click="saveData">
                    <el-image :src="require('@/assets/save-icon-blue.svg')" />
                  </el-button>
                </el-tooltip>
              </el-col>
              <el-col :span="2" v-show="!titleChange">
                <el-tooltip
                  :content="promptMessage.saveEditButton"
                  effect="light"
                  placement="right"
                  :open-delay="400"
                >
                  <el-button type="text" @click="saveEditData">
                    <el-image :src="require('@/assets/save-icon-blue.svg')" />
                  </el-button>
                </el-tooltip>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="21" :offset="1">
                <el-form-item prop="skillId" :label="labelName.industryJobSkill">
                  <el-cascader
                    @visible-change="setindustryJobSkill"
                    @blur="industryJobCascaderBlur"
                    v-model="c010103VueForm.skillId"
                    :options="industryJobSkill"
                    :props="{ expandTrigger: 'hover' }"
                    size="medium"
                    separator=" / "
                    filterable
                    clearable
                  />
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="21" :offset="1">
                <el-form-item prop="expSection" :label="labelName.expSection">
                  <el-select v-model="c010103VueForm.expSection" clearable>
                    <el-option
                      v-for="experienceItem in expSection"
                      :key="experienceItem.key"
                      :label="experienceItem.value"
                      :value="experienceItem.key"
                    />
                  </el-select>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="21" :offset="1">
                <el-form-item prop="otherNm" :label="labelName.otherName">
                  <el-input
                    v-model.trim="c010103VueForm.otherNm"
                    :placeholder="promptMessage.otherName"
                    maxlength="100"
                    show-word-limit
                    clearable
                  />
                </el-form-item>
              </el-col>
            </el-row>
          </el-form>
        </transition>
      </el-collapse-item>
    </el-collapse>
  </el-card>
</template>
<script>
// 内容チェック機能導入
import { validateSelect } from "@/utils/validate";
export default {
  name: "c010103",
  rules: {},
  props: {
    applicantSkillTblBean: {},
    industryMstBean: {},
    jobtypeMstBean: {},
    skillMstBean: {},
  },
  watch: {
    // 全角を半角に変換の処理
    "c010103VueForm.otherNm": function (v) {
      this.c010103VueForm.otherNm = v.replace(/[０-９]/g, (s) => {
        return String.fromCharCode(s.charCodeAt(0) - 65248);
      });
    },
  },
  data() {
    return {
      name: "スキル",
      rules: {
        skillId: [validateSelect("スキル")],
        expSection: [validateSelect("経験程度")],
      },
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
      // 新規や編集のタイトル切替
      titleChange: true,
      // 選択ラン表示用
      showSelect: false,
      // 提示用メッセージ
      promptMessage: {
        saveButton: "内容を保存",
        saveEditButton: "編集を保存",
        addButton: "内容を追加",
        clearButton: "内容をクリア",
        deleteButton: "内容を削除",
        editButton: "内容を編集",
        closeButton: "クローズ",
        nullMessage: "空いてる必須入力アイテムがあります",
        otherName: "スキルがないの場合、スキル名をここに入力してください",
        serverProblem: "サーバーで問題が発生しました",
        deleteSuccess: "削除完了",
        deleteFailed: "削除失敗",
        noTableData: "スキルは取得していません",
      },
      // 新規
      c010103VueForm: {
        companyId: "",
        userCd: "",
        appSkillId: "",
        applicantId: "",
        skillId: "",
        expSection: "",
        otherNm: "",
      },
      // 削除メッセージ内容
      deleteMessage: {
        title: "削除",
        message: "本当に削除しますか？",
        yes: "はい",
        no: "いいえ",
        success: "削除が成功しました",
        failed: "削除は取り消しされました",
      },
      // 業種-職種-スキル
      industryJobSkill: [],
    };
  },
  computed: {
    // 経験程度判断
    experienceSectionComputed() {
      return (row) => this.expSection[row.expSection].value;
    },
    // 新規ボタンと編集ボタンを判断
    showNameComputed() {
      return this.titleChange ? this.labelName.skillAdd : this.labelName.skillEdit;
    },
  },
  methods: {
    // 入力画面表示
    selectOpen() {
      this.showSelect = true;
    },
    // 入力画面非表示
    selectClose() {
      this.clearForm();
      this.titleChange = true;
      this.showSelect = false;
    },
    // 入力内容をクリア
    clearForm() {
      this.$refs.c010103VueForm.resetFields();
    },
    // 編集ボタン
    editButton(row) {
      console.log("edit the data", row);
      this.titleChange = false;
      this.c010103VueForm.applicantId = parseInt(row.applicantId);
      this.c010103VueForm.appSkillId = parseInt(row.appSkillId);
      this.setData(row);
      this.setindustryJobSkill();
      console.log("c010103VueForm", this.c010103VueForm);
      // 入力画面表示
      this.selectOpen();
    },
    // 行目データ取得
    setData(row) {
      this.c010103VueForm.applicantId = row.applicantId;
      this.c010103VueForm.appSkillId = row.appSkillId;
      this.c010103VueForm.expSection = row.expSection;
      this.c010103VueForm.otherNm = row.otherNm;
      this.c010103VueForm.skillId = this.getJobId(row.skillId);
    },
    // 新規保存
    saveData() {
      this.c010103VueForm.applicantId = this.applicantSkillTblBean[0].applicantId;
      this.c010103VueForm.skillId = this.c010103VueForm.skillId[2];
      console.log("c010103VueForm", this.c010103VueForm);
      // 必須項目チェック
      this.$refs.c010103VueForm.validate((valid) => {
        if (valid) {
          this.$store
            .dispatch("skillInformationInsertSkill", this.c010103VueForm)
            .then((response) => {
              let code = response.data.code;
              if (code == 200) {
                // 提示メッセージ
                this.$message.success(response.data.message);
                // ウィンドウクローズ
                this.selectClose();
                // 画面表示内容リフレッシュ
                this.$parent.initData();
                // フォームクリア
                this.clearForm();
              } else if (code == 400 || code == 404) {
                this.$message.error(response.data.message);
              } else if (code == 500) {
                this.$message.error(response.data.serverProblem);
              } else {
                this.$router.push({
                  path: "/error",
                  query: { message: response.data.message },
                });
                this.$message.error(response.data.message);
              }
            })
            .catch(() => {});
        } else {
          this.$message.warning(this.promptMessage.nullMessage);
        }
      });
    },
    // 編集保存
    saveEditData() {
      this.c010103VueForm.skillId = this.c010103VueForm.skillId[2];
      console.log("c010103VueForm", this.c010103VueForm);
      // 必須項目チェック
      this.$refs.c010103VueForm.validate((valid) => {
        if (valid) {
          this.$store
            .dispatch("skillInformationUpdateSkill", this.c010103VueForm)
            .then((response) => {
              let code = response.data.code;
              if (code == 200) {
                // 提示メッセージ
                this.$message.success(response.data.message);
                // ウィンドウクローズ
                this.selectClose();
                // 画面表示内容リフレッシュ
                this.$parent.initData();
                // フォームクリア
                this.clearForm();
              } else if (code == 400 || code == 404) {
                this.$message.error(response.data.message);
              } else if (code == 500) {
                this.$message.error(response.data.serverProblem);
              } else {
                this.$router.push({
                  path: "/error",
                  query: { message: response.data.message },
                });
                this.$message.error(response.data.message);
              }
            })
            .catch(() => {});
        } else {
          this.$message.warning(this.promptMessage.nullMessage);
        }
      });
    },
    // 削除確認ポップアップ
    confirmMessageBox(row) {
      console.log("delete popup", row);
      // 削除ポップアップ呼び出し
      this.$confirm(this.deleteMessage.message, this.deleteMessage.title, {
        type: "warning",
        confirmButtonText: this.deleteMessage.yes,
        cancelButtonText: this.deleteMessage.no,
      })
        // 削除確認の場合
        .then(() => {
          this.deleteButton(row);
        })
        // 削除取り消しの場合
        .catch(() => {
          this.$message.info(this.deleteMessage.failed);
        });
    },
    // 当行目データ削除
    deleteButton(row) {
      console.log("delete row data", row);
      this.$store
        .dispatch("skillInformationDeleteSkill", row)
        .then((response) => {
          // responseコード取得
          let code = response.data.code;
          // 成功の場合
          if (code == 200) {
            // 画面表示内容リフレッシュ
            this.$parent.initData();
            // 提示メッセージ
            this.$message.success(this.promptMessage.deleteSuccess);
          } else if (code == 400 || code == 404) {
            this.$message.error(this.promptMessage.deleteFailed);
          } else if (code == 500) {
            this.$message.error(response.data.serverProblem);
          } else {
            this.$router.push({
              path: "/error",
              query: { message: response.data.message },
            });
            // 取り消しの場合
            this.$message.error(this.promptMessage.deleteFailed);
          }
        })
        .catch(() => {});
    },
    // 業種職種スキルのデータを編集
    setindustryJobSkill() {
      this.setIndustry();
      this.setJob();
      this.setSkill();
      console.log("industryJobSkill", this.industryJobSkill);
    },
    // 業種のデータを編集
    setIndustry() {
      this.industryJobSkill = [];
      let industryOptions = { value: "", label: "", children: [] };
      this.industryMstBean.forEach((industryElement) => {
        industryOptions.value = industryElement.industryId;
        industryOptions.label = industryElement.industryNm;
        this.industryJobSkill.push(industryOptions);
        industryOptions = { value: "", label: "", children: [] };
      });
    },
    // 職種のデータを編集
    setJob() {
      let jobOptions = { value: "", label: "", children: [] };
      this.jobtypeMstBean.forEach((jobElement) => {
        this.industryJobSkill.forEach((industryJobSkillElement) => {
          if (jobElement.industryId == industryJobSkillElement.value) {
            jobOptions.value = jobElement.jobtypeId;
            jobOptions.label = jobElement.jobtypeNm;
            industryJobSkillElement.children.push(jobOptions);
            jobOptions = { value: "", label: "", children: [] };
          }
        });
      });
    },
    // スキルのデータを編集
    setSkill() {
      let skillOptions = { value: "", label: "" };
      this.skillMstBean.forEach((skillElement) => {
        this.industryJobSkill.forEach((industryJobSkillElement) => {
          industryJobSkillElement.children.forEach((industryJobSkillChildrenElement) => {
            if (
              skillElement.industryId == industryJobSkillElement.value &&
              skillElement.jobtypeId == industryJobSkillChildrenElement.value
            ) {
              skillOptions.value = skillElement.skillId;
              skillOptions.label = skillElement.skillNm;
              industryJobSkillChildrenElement.children.push(skillOptions);
              skillOptions = { value: "", label: "" };
            }
          });
        });
      });
    },
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
    // スキルID→業種ID 職種ID
    getJobId(skillId) {
      var job = "";
      var industry = "";
      this.skillMstBean.forEach((skillElement) => {
        if (skillElement.skillId == skillId) {
          job = skillElement.jobtypeId;
          industry = skillElement.industryId;
        }
      });
      let industryJobSkill = [industry, job, skillId];
      return industryJobSkill;
    },
    // collapse展開状態
    collapseChange(val) {
      if (val.length == 1) {
        // 新規画面クローズ
        this.selectClose();
      }
    },
    // cascaderチェック
    industryJobCascaderBlur() {
      this.$refs.industryJobCascader.validate().catch(() => {});
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
// アイコンの大きさ
.el-icon-circle-plus,
.el-icon-remove,
.el-icon-document-checked,
.el-icon-document-remove,
.el-icon-postcard {
  font-size: 30px;
}
.el-icon-edit-outline,
.el-icon-delete {
  font-size: 20px;
}
// 新規
.qua-add {
  font-size: 20px;
  color: #014099;
  margin-top: 2vh;
}
// セレクト欄
.select-style {
  margin-top: 5vh;
}
// ラベルの青字
::v-deep div > .el-form-item__label {
  font-size: 16px;
  color: #014099;
  font-style: normal;
  font-weight: bold;
}
// インプット欄の下ボルダ
::v-deep .el-input__inner {
  border: none;
  border-bottom: 1px solid #dcdfe6;
}
// インプット欄の幅
::v-deep .el-input,
::v-deep .el-select,
::v-deep .el-cascader {
  width: 100%;
}
</style>
