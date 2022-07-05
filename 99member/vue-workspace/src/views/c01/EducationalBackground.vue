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
            class="edu-add"
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
            ref="c010106VueForm"
            :model="c010106VueForm"
            :rules="rules"
            label-width="21%"
            v-show="showSelect"
            class="select-style"
          >
            <el-row v-show="showSelect">
              <el-col :span="10" :offset="1">
                <el-form-item prop="degreePic1" :label="labelName.eduPhoto">
                  <el-upload
                    ref="uploadPhoto"
                    list-type="picture-card"
                    v-model="c010106VueForm.degreePic1"
                    :limit="1"
                    :multiple="false"
                    :action="uploadURL()"
                    :accept="uploadParameter.uploadType"
                    :file-list="uploadParameter.fileList"
                    :before-upload="uploadSize"
                    :on-error="uploadFailed"
                    :on-success="uploadSuccess"
                    :on-remove="handleRemove"
                    :on-exceed="uploadExceed"
                  >
                    <span v-if="uploadParameter.fileType == 'pdf'">
                      <pdf :src="c010106VueForm.photoPic" v-show="!photoIsNullComputed" />
                    </span>
                    <span v-else>
                      <el-image
                        :src="c010106VueForm.photoPic"
                        v-show="!photoIsNullComputed"
                        fit="contain"
                      >
                        <div slot="error">
                          <el-avatar shape="square" :size="130" icon="el-icon-postcard" />
                        </div>
                      </el-image>
                    </span>
                    <em class="el-icon-plus" v-show="photoIsNullComputed" />
                  </el-upload>
                </el-form-item>
              </el-col>
              <el-col :span="2" :offset="9">
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
                <el-form-item prop="schoolNm" :label="labelName.schoolNm">
                  <el-input
                    v-model.trim="c010106VueForm.schoolNm"
                    :placeholder="labelName.schoolNm"
                    maxlength="50"
                    show-word-limit
                    clearable
                  />
                </el-form-item>
              </el-col>
              <el-col :span="10" :offset="1">
                <el-form-item :label="labelName.eduDate" required>
                  <el-col :span="11">
                    <el-form-item prop="eduDateFrom">
                      <el-date-picker
                        v-model="c010106VueForm.eduDateFrom"
                        :placeholder="labelName.eduDateFrom"
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
                    <el-form-item prop="eduDateTo">
                      <el-date-picker
                        v-model="c010106VueForm.eduDateTo"
                        :placeholder="labelName.eduDateTo"
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
                <el-form-item prop="eduSection" :label="labelName.eduSection">
                  <el-select v-model="c010106VueForm.eduSection" clearable>
                    <el-option
                      v-for="(eduSectionItem, index) in eduSection"
                      :key="`eduSection-${index}`"
                      :label="eduSectionItem.value"
                      :value="eduSectionItem.key"
                    />
                  </el-select>
                </el-form-item>
              </el-col>
              <el-col :span="10" :offset="1">
                <el-form-item prop="degree" :label="labelName.degree">
                  <el-select v-model="c010106VueForm.degree" clearable>
                    <el-option
                      v-for="(degreeItem, index) in degree"
                      :key="`degree-${index}`"
                      :label="degreeItem.value"
                      :value="degreeItem.key"
                    />
                  </el-select>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="10" :offset="1">
                <el-form-item prop="majorNm" :label="labelName.majorNm">
                  <el-input
                    v-model.trim="c010106VueForm.majorNm"
                    :placeholder="labelName.majorNm"
                    maxlength="50"
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
import pdf from "vue-pdf";
import { validateNecessary, validateSelect, matchFileSuffixType } from "@/utils/validate";
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
      rules: {
        majorNm: [validateNecessary("専攻")],
        schoolNm: [validateSelect("学校名")],
        eduDateFrom: [validateSelect("開始日付")],
        eduDateTo: [validateSelect("終了日付")],
        eduSection: [validateSelect("学歴区分")],
        degree: [validateSelect("学位")],
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
        avatarSize: "10MB以下の画像をアップロードしてください",
        uploadSuccess: "アップロード成功",
        uploadFailed: "アップロード失敗",
        uploadExceed: "最大一枚の写真をアップロードしてください",
        nullMessage: "空いてる必須入力アイテムがあります",
        deleteSuccess: "削除完了",
        deleteFailed: "削除失敗",
        serverProblem: "サーバーで問題が発生しました",
        noTableData: "学歴情報を記入しなかった",
      },
      // 新規
      c010106VueForm: {
        companyId: "",
        userCd: "",
        educationId: "",
        applicantId: "",
        schoolNm: "",
        majorNm: "",
        eduDateFrom: "",
        eduDateTo: "",
        degree: "",
        eduSection: "",
        degreePic1: "",
        photoPic: "",
      },
      //アバターボタン表示用
      noneAvatar: false,
      // 写真アップロードのパラメータ
      uploadParameter: {
        uploadType: "image/jpeg,image/jpg,image/png,image/svg,application/pdf",
        fileList: [],
        fileType: "",
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
    // 新規ボタンと編集ボタンを判断
    showNameComputed() {
      return this.titleChange ? this.labelName.eduAdd : this.labelName.eduEdit;
    },
    // 写真が空いているの判断
    photoIsNullComputed() {
      return this.c010106VueForm.photoPic == "";
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
    // 入力画面表示
    selectOpen() {
      this.showSelect = true;
    },
    // 入力画面非表示
    selectClose() {
      this.clearData();
      this.titleChange = true;
      this.showSelect = false;
    },
    // 入力内容をクリア
    clearData() {
      this.clearForm();
      this.handleRemove();
    },
    // 入力文字をクリア
    clearForm() {
      this.$refs.c010106VueForm.resetFields();
    },
    // 新規保存
    saveData() {
      this.c010106VueForm.applicantId = this.applicantEduTblBean[0].applicantId;
      console.log("c010106VueForm", this.c010106VueForm);
      // 必須項目チェック
      this.$refs.c010106VueForm.validate((valid) => {
        if (valid) {
          this.$store
            .dispatch("educationalBackgroundInsertEdu", this.c010106VueForm)
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
                this.clearData();
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
      console.log("c010106VueForm", this.c010106VueForm);
      // 必須項目チェック
      this.$refs.c010106VueForm.validate((valid) => {
        if (valid) {
          this.$store
            .dispatch("educationalBackgroundUpdateEdu", this.c010106VueForm)
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
                this.clearData();
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
    // 画像アップロード
    uploadURL() {
      return `${this.$store.state.HOST}/B0002/upload`;
    },
    // 画像アップロード一枚以上の場合、提示する
    uploadExceed() {
      this.$message.warning(this.promptMessage.uploadExceed);
    },
    // 画像アップロード失敗
    uploadFailed() {
      this.$message.error(this.promptMessage.uploadFailed);
      // 画像アップロード失敗の場合、画像アップロードのボタンが表示
      this.noneAvatar = false;
    },
    // 画像アップロード成功
    uploadSuccess(res, file) {
      // 成功提示メッセージ
      this.$message.success(this.promptMessage.uploadSuccess);
      // 画像URL
      this.c010106VueForm.photoPic = URL.createObjectURL(file.raw);
      this.uploadFile(file);
      // 画像ファイル
      this.c010106VueForm.degreePic1 = res;
      console.log("upload success", this.$refs.uploadPhoto);
    },
    // 画像サイズ制限
    uploadSize(file) {
      // 画像サイズ合格の場合、画像アップロードのボタンが不表示
      this.noneAvatar = true;
      // boolean 画像サイズ10MB以内
      const fileSize = file.size / 1024 / 1024 < 10;
      // 不合格の場合、エラー提示
      if (!fileSize) this.$message.error(this.promptMessage.avatarSize);
      return fileSize;
    },
    // アップロードした画像を削除
    handleRemove() {
      // 画像アップロードのボタンが表示
      this.noneAvatar = false;
      this.$refs.uploadPhoto.clearFiles();
      this.c010106VueForm.photoPic = "";
      this.c010106VueForm.degreePic1 = "";
    },
    // アップロードファイル名の判断
    uploadFile(file) {
      this.uploadParameter.fileType = matchFileSuffixType(file.name);
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
        // 新規画面クローズ
        this.selectClose();
      }
    },
    // 展開した行目クローズ
    tableRowClose() {
      this.applicantEduTblBean.map((item) => {
        this.$refs.applicantEduTblBean.toggleRowExpansion(item, false);
      });
    },
    // 終了日付を開始日付にの制限
    changeStart() {
      // 値削除の場合、制限クリア
      if (!this.c010106VueForm.eduDateTo) {
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
            date.getTime() > this.c010106VueForm.eduDateTo || date.getTime() > Date.now()
          );
        },
      });
    },
    // 開始日付を終了日付にの制限
    changeEnd() {
      // 値削除の場合、制限クリア
      if (!this.c010106VueForm.eduDateFrom) {
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
            date.getTime() < this.c010106VueForm.eduDateFrom ||
            date.getTime() > Date.now()
          );
        },
      });
    },
    // 編集ボタン
    editButton(row) {
      console.log("edit the data", row);
      this.titleChange = false;
      this.c010106VueForm.applicantId = parseInt(row.applicantId);
      this.c010106VueForm.educationId = parseInt(row.educationId);
      this.setData(row);
      this.uploadParameter.fileType =
        this.rowPhotoIsPDF(row.degreePic1) == true ? "pdf" : "image";
      // 入力画面表示
      this.selectOpen();
    },
    // 行目データ取得
    setData(row) {
      this.c010106VueForm.photoPic = row.photoPic;
      this.c010106VueForm.schoolNm = row.schoolNm;
      this.c010106VueForm.majorNm = row.majorNm;
      this.c010106VueForm.eduDateFrom = row.eduDateFrom;
      this.c010106VueForm.eduDateTo = row.eduDateTo;
      this.c010106VueForm.degree = row.degree;
      this.c010106VueForm.eduSection = row.eduSection;
      this.c010106VueForm.degreePic1 = row.degreePic1;
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
        .dispatch("educationalBackgroundDeleteEdu", row)
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
.edu-add {
  font-size: 20px;
  color: #014099;
  margin-top: 2vh;
}
// セレクト欄
.select-style {
  margin-top: 5vh;
}
// 画像サイズ
.image-style {
  max-width: 150px;
  max-height: 150px;
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
::v-deep .el-select,
::v-deep textarea {
  width: 100%;
}
//アバターアップロードボタン表示用
::v-deep .uploadDisabled .el-upload--picture-card {
  display: none;
}
</style>
