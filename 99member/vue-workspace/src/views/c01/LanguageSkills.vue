<template>
  <el-card class="card-style">
    <el-collapse
      v-model="collapseIsActive"
      name="languageSkills"
      value="languageSkills"
      @change="collapseChange"
    >
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
            ref="c010105VueForm"
            :model="c010105VueForm"
            :rules="rules"
            label-width="15%"
            v-show="showSelect"
            class="select-style"
          >
            <el-row v-show="showSelect">
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
                <el-form-item prop="languageId" :label="labelName.language">
                  <el-select v-model="c010105VueForm.languageId" clearable>
                    <el-option
                      v-for="langItem in lanMstBean"
                      :key="langItem.languageId"
                      :label="langItem.language"
                      :value="langItem.languageId"
                    />
                  </el-select>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="21" :offset="1">
                <el-form-item prop="levelSection" :label="labelName.levelSection">
                  <el-select v-model="c010105VueForm.levelSection" clearable>
                    <el-option
                      v-for="langItem in eduSection"
                      :key="langItem.key"
                      :label="langItem.value"
                      :value="langItem.key"
                    />
                  </el-select>
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
import { validateNecessary, validateSelect } from "@/utils/validate";
export default {
  name: "c010105",
  props: {
    applicantLanTblBean: {},
    lanMstBean: {},
  },
  data() {
    return {
      name: "言語能力",
      rules: {
        // 言語必須選択
        languageId: [validateSelect("言語")],
        // 言語レベル必須選択
        levelSection: [validateNecessary("言語レベル")],
      },
      // collapse初期不展開
      collapseIsActive: "",
      // テーブルラベル
      labelName: {
        language: "言語",
        levelSection: "言語レベル",
        languageAdd: "言語新規",
        languageEdit: "言語編集",
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
        serverProblem: "サーバーで問題が発生しました",
        deleteSuccess: "削除完了",
        deleteFailed: "削除失敗",
        languageExists: "入力言語はすでに存在します",
        noTableData: "外国語を学びませんでした",
      },
      // 新規
      c010105VueForm: {
        companyId: "",
        userCd: "",
        applicantId: "",
        languageId: "",
        levelSection: "",
        appLanId: Number,
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
    // 新規ボタンと編集ボタンを判断
    showNameComputed() {
      return this.titleChange ? this.labelName.languageAdd : this.labelName.languageEdit;
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
      this.$refs.c010105VueForm.resetFields();
    },
    // 編集ボタン
    editButton(row) {
      console.log("edit the data", row);
      this.titleChange = false;
      this.c010105VueForm.applicantId = parseInt(row.applicantId);
      this.c010105VueForm.languageId = parseInt(row.languageId);
      this.setData(row);
      // 入力画面表示
      this.selectOpen();
    },
    // 行目データ取得
    setData(row) {
      this.c010105VueForm.applicantId = row.applicantId;
      this.c010105VueForm.languageId = row.languageId;
      this.c010105VueForm.levelSection = row.levelSection;
      this.c010105VueForm.appLanId = row.appLanId;
    },
    // 新規保存
    saveData() {
      this.c010105VueForm.applicantId = this.applicantLanTblBean[0].applicantId;
      console.log("c010105VueForm", this.c010105VueForm);
      // 必須項目チェック
      this.$refs.c010105VueForm.validate((valid) => {
        if (valid) {
          var flag = true;
          this.applicantLanTblBean.forEach((element) => {
            if (element.languageId == this.c010105VueForm.languageId) {
              flag = false;
            }
          });
          if (flag) {
            this.$store
              .dispatch("languageSkillsInsertLan", this.c010105VueForm)
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
            this.$message.warning(this.promptMessage.languageExists);
            this.clearForm();
          }
        } else {
          this.$message.warning(this.promptMessage.nullMessage);
        }
      });
    },
    // 編集保存
    saveEditData() {
      console.log("c010105VueForm", this.c010105VueForm);
      // 必須項目チェック
      this.$refs.c010105VueForm.validate((valid) => {
        if (valid) {
          this.$store
            .dispatch("languageSkillsUpdateLan", this.c010105VueForm)
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
        .dispatch("languageSkillsDeleteLan", row)
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
    // collapse展開状態
    collapseChange(val) {
      if (val.length == 1) {
        // 新規画面クローズ
        this.selectClose();
      }
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
::v-deep .el-input--suffix .el-input__inner {
  border: none;
  border-bottom: 1px solid #dcdfe6;
}
// 選択ラン
::v-deep .el-select {
  width: 100%;
}
</style>
