<template>
  <el-card class="card-style">
    <el-collapse
      v-model="collapseIsActive"
      name="projectExperience"
      value="projectExperience"
      @change="collapseChange"
    >
      <el-collapse-item name="projectExperience" :title="name">
        <el-row>
          <el-col :span="24">
            <el-table
              ref="projectHisTblBean"
              :data="projectHisTblBean"
              :default-sort="{ prop: 'proDateFrom', order: 'ascending' }"
              @row-dblclick="rowDoubleClick"
              row-key="projectId"
              max-height="350"
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
                        <el-form-item :label="labelName.proCnt">
                          <p>{{ props.row.proCnt }} {{ labelName.person }}</p>
                        </el-form-item>
                      </el-col>
                      <el-col :span="12">
                        <el-form-item :label="labelName.proTec">
                          <p>{{ props.row.proTec }}</p>
                        </el-form-item>
                      </el-col>
                    </el-row>
                    <el-row>
                      <el-col :span="12">
                        <el-form-item :label="labelName.proContent">
                          <p>{{ props.row.proContent }}</p>
                        </el-form-item>
                      </el-col>
                      <el-col :span="12">
                        <el-form-item :label="labelName.proDuties">
                          <p>{{ props.row.proDuties }}</p>
                        </el-form-item>
                      </el-col>
                    </el-row>
                  </el-form>
                </template>
              </el-table-column>
              <el-table-column prop="projectNm" :label="labelName.projectNm" />
              <el-table-column prop="proDateFrom" :label="labelName.proDate" sortable>
                <template v-slot="proDateSlot">
                  {{ projectDateComputed(proDateSlot.row) }}
                </template>
              </el-table-column>
              <el-table-column prop="proRole" :label="labelName.proRole" />
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
            ref="c010107VueForm"
            :model="c010107VueForm"
            :rules="rules"
            label-width="21%"
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
              <el-col :span="10" :offset="1">
                <el-form-item prop="projectNm" :label="labelName.projectNm">
                  <el-input
                    v-model.trim="c010107VueForm.projectNm"
                    :placeholder="promptMessage.projectNm"
                    maxlength="40"
                    show-word-limit
                    clearable
                  />
                </el-form-item>
              </el-col>
              <el-col :span="10" :offset="1">
                <el-form-item :label="labelName.proDate" required>
                  <el-col :span="11">
                    <el-form-item prop="proDateFrom">
                      <el-date-picker
                        v-model="c010107VueForm.proDateFrom"
                        :placeholder="labelName.proDateFrom"
                        :picker-options="dateFromPicker"
                        @change="changeEnd"
                        format="yyyy-MM-dd"
                        type="date"
                      />
                    </el-form-item>
                  </el-col>
                  <el-col :span="1">
                    <span>-</span>
                  </el-col>
                  <el-col :span="12">
                    <el-form-item prop="proDateTo">
                      <el-date-picker
                        v-model="c010107VueForm.proDateTo"
                        :placeholder="labelName.proDateTo"
                        :picker-options="dateToPicker"
                        @change="changeStart"
                        format="yyyy-MM-dd"
                        prefix-icon=" "
                        type="date"
                      />
                    </el-form-item>
                  </el-col>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="10" :offset="1">
                <el-form-item prop="proContent" :label="labelName.proContent">
                  <el-input
                    type="textarea"
                    v-model="c010107VueForm.proContent"
                    :placeholder="labelName.proContent"
                    maxlength="500"
                    show-word-limit
                    :autosize="{ minRows: 4 }"
                    clearable
                  />
                </el-form-item>
              </el-col>
              <el-col :span="10" :offset="1">
                <el-row>
                  <el-col :span="24">
                    <el-form-item prop="proCnt" :label="labelName.proCnt">
                      <el-input
                        v-model.number="c010107VueForm.proCnt"
                        :placeholder="labelName.proCnt"
                        @input="numValid('proCnt')"
                        maxlength="5"
                        clearable
                      >
                        <span slot="suffix" v-text="labelName.person" />
                      </el-input>
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row>
                  <el-col :span="24">
                    <el-form-item prop="proRole" :label="labelName.proRole">
                      <el-input
                        v-model.trim="c010107VueForm.proRole"
                        :placeholder="labelName.proRole"
                        maxlength="50"
                        show-word-limit
                        clearable
                      />
                    </el-form-item>
                  </el-col>
                </el-row>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="10" :offset="1">
                <el-form-item prop="proDuties" :label="labelName.proDuties">
                  <el-input
                    v-model.trim="c010107VueForm.proDuties"
                    :placeholder="labelName.proDuties"
                    maxlength="200"
                    show-word-limit
                    clearable
                  />
                </el-form-item>
              </el-col>
              <el-col :span="10" :offset="1">
                <el-form-item prop="proTec" :label="labelName.proTec">
                  <el-input
                    v-model.trim="c010107VueForm.proTec"
                    :placeholder="labelName.proTec"
                    maxlength="200"
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
import { validateNecessary, validateSelect } from "@/utils/validate";
export default {
  name: "c010107",
  props: {
    projectHisTblBean: {},
  },
  watch: {
    // 全角数字を半角に変換の処理
    "c010107VueForm.proCnt": function (v) {
      this.c010107VueForm.proCnt = v.replace(/[０-９]/g, (s) => {
        return String.fromCharCode(s.charCodeAt(0) - 65248);
      });
    },
  },
  data() {
    return {
      name: "プロジェクト",
      rules: {
        projectNm: [validateNecessary("プロ名")],
        proContent: [validateNecessary("プロ内容")],
        proDateFrom: [validateSelect("開始日付")],
        proDateTo: [validateSelect("終了日付")],
      },
      pickerOptions: {
        // 日付は今日以前しか選択可能
        disabledDate(birthday) {
          return birthday.getTime() > Date.now();
        },
      },
      // collapse初期不展開
      collapseIsActive: "",
      // テーブルラベル
      labelName: {
        projectNm: "プロ名",
        proDate: "プロ期間",
        proContent: "プロ内容",
        proDuties: "職務内容",
        proTec: "使用技術",
        proRole: "役割",
        proCnt: "プロ人数",
        projectAdd: "プロジェクト新規",
        projectEdit: "プロジェクト編集",
        person: "人",
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
        serverProblem: "サーバーで問題が発生しました",
        deleteSuccess: "削除完了",
        deleteFailed: "削除失敗",
        noTableData: "プロジェクト経験なし",
      },
      c010107VueForm: {
        companyId: "",
        userCd: "",
        projectId: "",
        applicantId: "",
        projectNm: "",
        proDateFrom: "",
        proDateTo: "",
        proRole: "",
        proCnt: "",
        proDuties: "",
        proTec: "",
        proContent: "",
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
      // 開始日付
      dateFromPicker: {
        // 日付は今日以前しか選択可能
        disabledDate: (date) => {
          return date.getTime() > Date.now();
        },
      },
      // 終了日付
      dateToPicker: {
        // 日付は今日以前しか選択可能
        disabledDate: (date) => {
          return date.getTime() > Date.now();
        },
        // 現在ボタン
        shortcuts: [
          {
            text: "現在",
            // クリックメソッド
            onClick(picker) {
              var date = "9999-01-01 00:00:00.000";
              var t = Date.parse(date);
              if (!isNaN(t)) {
                t = new Date(Date.parse(date.replace(/-/g, "/")));
              } else {
                t = new Date();
              }
              picker.$emit("pick", t);
            },
          },
        ],
      },
    };
  },
  computed: {
    // プロジェクト開始日付-終了日付
    projectDateComputed() {
      return (row) => row.proDateFrom + "-" + row.proDateTo;
    },
    // 新規ボタンと編集ボタンを判断
    showNameComputed() {
      return this.titleChange ? this.labelName.projectAdd : this.labelName.projectEdit;
    },
  },
  methods: {
    // テーブル行目ダブルクリック
    rowDoubleClick(row) {
      let $projectHisTblBean = this.$refs.projectHisTblBean;
      this.projectHisTblBean.map((item) => {
        // 単一の行目展開
        if (row.projectId != item.projectId) {
          $projectHisTblBean.toggleRowExpansion(item, false);
        }
      });
      $projectHisTblBean.toggleRowExpansion(row);
    },
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
      this.$refs.c010107VueForm.resetFields();
    },
    // 編集ボタン
    editButton(row) {
      console.log("edit the data", row);
      this.titleChange = false;
      this.c010107VueForm.applicantId = parseInt(row.applicantId);
      this.c010107VueForm.projectId = parseInt(row.projectId);
      this.setData(row);
      // 入力画面表示
      this.selectOpen();
    },
    // 行目データ取得
    setData(row) {
      this.c010107VueForm.projectId = row.projectId;
      this.c010107VueForm.applicantId = row.applicantId;
      this.c010107VueForm.projectNm = row.projectNm;
      this.c010107VueForm.proDateFrom = row.proDateFrom;
      this.c010107VueForm.proDateTo = row.proDateTo;
      this.c010107VueForm.proRole = row.proRole;
      this.c010107VueForm.proCnt = row.proCnt;
      this.c010107VueForm.proDuties = row.proDuties;
      this.c010107VueForm.proTec = row.proTec;
      this.c010107VueForm.proContent = row.proContent;
    },
    // 新規保存
    saveData() {
      this.c010107VueForm.applicantId = this.projectHisTblBean[0].applicantId;
      console.log("c010107VueForm", this.c010107VueForm);
      // 必須項目チェック
      this.$refs.c010107VueForm.validate((valid) => {
        if (valid) {
          this.$store
            .dispatch("projectExperienceInsertProjectHis", this.c010107VueForm)
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
                // 日付制限をリセット
                this.resetDateFrom();
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
      console.log("c010107VueForm", this.c010107VueForm);
      // 必須項目チェック
      this.$refs.c010107VueForm.validate((valid) => {
        if (valid) {
          this.$store
            .dispatch("projectExperienceUpdateProjectHis", this.c010107VueForm)
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
        .dispatch("projectExperienceDeleteProjectHis", row)
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
    // dateFromをリセット
    resetDateFrom() {
      this.dateFromPicker = {
        disabledDate: (date) => {
          return date.getTime() > Date.now();
        },
      };
    },
    // collapse展開状態
    collapseChange(val) {
      if (val.length == 1) {
        // 展開した行目クローズ
        this.tableRowClose();
        // 新規画面クローズ
        this.selectClose();
      }
    },
    // 展開した行目クローズ
    tableRowClose() {
      this.projectHisTblBean.map((item) => {
        this.$refs.projectHisTblBean.toggleRowExpansion(item, false);
      });
    },
    // 終了日付を開始日付にの制限
    changeStart() {
      // 値削除の場合、制限クリア
      if (!this.c010107VueForm.proDateTo) {
        this.dateFromPicker = {
          disabledDate: (date) => {
            return date.getTime() > Date.now();
          },
        };
        return;
      }
      this.dateFromPicker = Object.assign({}, this.dateFromPicker, {
        // 禁止選択時間帯
        disabledDate: (date) => {
          // 選択日付 < 明日 && 選択日付 < 終了日付
          return (
            date.getTime() > this.c010107VueForm.proDateTo || date.getTime() > Date.now()
          );
        },
      });
    },
    // 開始日付を終了日付にの制限
    changeEnd() {
      // 値削除の場合、制限クリア
      if (!this.c010107VueForm.proDateFrom) {
        this.dateFromPicker = {
          disabledDate: (date) => {
            return date.getTime() > Date.now();
          },
        };
        return;
      }
      this.dateToPicker = Object.assign({}, this.dateToPicker, {
        // 禁止選択時間帯
        disabledDate: (date) => {
          // 選択日付 < 明日 && 選択日付 > 開始日付
          return (
            date.getTime() < this.c010107VueForm.proDateFrom ||
            date.getTime() > Date.now()
          );
        },
      });
    },
    // プロ人数数字制限
    numValid(val) {
      this.c010107VueForm[val] = this.c010107VueForm[val].replace(/[^0-9０-９]/g, "");
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
// インプット欄の幅
::v-deep .el-input,
::v-deep textarea {
  width: 100%;
}
// テクストエリアのスクロールとスラッシュを不表示
::v-deep div > .el-textarea > textarea {
  overflow: hidden;
  resize: none;
}
// 文字数統計透明背景色
::v-deep .el-input__count {
  background-color: transparent;
  // position: relative;
}
</style>
