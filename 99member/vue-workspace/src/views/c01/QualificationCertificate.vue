<template>
  <el-card class="card-style">
    <el-collapse
      v-model="collapseIsActive"
      name="qualificationCertificate"
      value="qualificationCertificate"
      @change="collapseChange"
    >
      <el-collapse-item name="qualificationCertificate" :title="name">
        <el-row>
          <el-col :span="24">
            <el-table
              ref="applicantQuaTblBean"
              :data="applicantQuaTblBean"
              @row-dblclick="rowDoubleClick"
              :default-sort="{ prop: 'acquisitionDate', order: 'descending' }"
              row-key="appQuaId"
              max-height="350"
              highlight-current-row
              :empty-text="promptMessage.noTableData"
              stripe
            >
              <el-table-column type="index" />
              <el-table-column type="expand">
                <template slot-scope="props">
                  <el-form :model="props" label-position="top">
                    <el-row>
                      <el-col :span="12">
                        <el-form-item :label="labelName.quaPhoto">
                          <pdf
                            :src="props.row.photoPic"
                            class="image-style"
                            v-if="rowPhotoIsPDF(props.row.quaAddress)"
                          />
                          <el-image
                            :src="props.row.photoPic"
                            fit="contain"
                            class="image-style"
                            v-else
                          >
                            <div slot="error" class="image-slot">
                              <em class="el-icon-postcard" />
                            </div>
                          </el-image>
                        </el-form-item>
                      </el-col>
                      <el-col :span="12">
                        <el-form-item :label="labelName.remarks">
                          <p>{{ props.row.remarks }}</p>
                        </el-form-item>
                      </el-col>
                    </el-row>
                  </el-form>
                </template>
              </el-table-column>
              <el-table-column prop="quaNm" :label="labelName.quaNm" />
              <el-table-column prop="quaNum" :label="labelName.quaNum" sortable />
              <el-table-column
                prop="acquisitionDate"
                :label="labelName.acquisitionDate"
                sortable
              />
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
            ref="c010102VueForm"
            :model="c010102VueForm"
            :rules="rules"
            label-width="18%"
            v-show="showSelect"
            class="select-style"
          >
            <el-row>
              <el-col :span="10" :offset="1">
                <el-form-item prop="quaAddress" :label="labelName.quaPhoto">
                  <el-upload
                    ref="uploadPhoto"
                    list-type="picture-card"
                    v-model="c010102VueForm.quaAddress"
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
                    :class="{
                      uploadDisabled: noneAvatar,
                    }"
                  >
                    <span v-if="uploadParameter.fileType == 'pdf'">
                      <pdf :src="c010102VueForm.photoPic" v-show="!photoIsNullComputed" />
                    </span>
                    <span v-else>
                      <el-image
                        :src="c010102VueForm.photoPic"
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
              <el-col :span="1" />
              <el-col :span="2" :offset="8">
                <el-tooltip
                  :content="promptMessage.clearButton"
                  effect="light"
                  placement="left"
                  :open-delay="400"
                >
                  <el-button type="text" @click="clearData">
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
                <el-form-item prop="quaNm" :label="labelName.quaNm">
                  <el-input
                    v-model.trim="c010102VueForm.quaNm"
                    :placeholder="labelName.quaNm"
                    maxlength="200"
                    show-word-limit
                    clearable
                  />
                </el-form-item>
              </el-col>
              <el-col :span="10" :offset="1">
                <el-form-item prop="quaNum" :label="labelName.quaNum">
                  <el-input
                    v-model.trim="c010102VueForm.quaNum"
                    :placeholder="labelName.quaNum"
                    maxlength="200"
                    show-word-limit
                    clearable
                  />
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="10" :offset="1">
                <el-form-item prop="acquisitionDate" :label="labelName.acquisitionDate">
                  <el-date-picker
                    v-model="c010102VueForm.acquisitionDate"
                    :picker-options="pickerOptions"
                    :placeholder="labelName.acquisitionDate"
                    type="date"
                  />
                </el-form-item>
              </el-col>
              <el-col :span="10" :offset="1">
                <el-form-item prop="remarks" :label="labelName.remarks">
                  <el-input
                    type="textarea"
                    v-model="c010102VueForm.remarks"
                    :placeholder="labelName.remarks"
                    :autosize="{ minRows: 2 }"
                    maxlength="400"
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
import { validateNecessary, matchFileSuffixType } from "@/utils/validate";
export default {
  name: "c010102",
  props: {
    applicantQuaTblBean: {},
  },
  components: {
    pdf,
  },
  data() {
    return {
      // collapseタイトル
      name: "資格·検定",
      rules: {
        // 資格名必須入力
        quaNm: [validateNecessary("資格名")],
      },
      pickerOptions: {
        // 日付は今日以前しか選択可能
        disabledDate(qualificationDate) {
          return qualificationDate.getTime() > Date.now();
        },
      },
      // collapse初期不展開
      collapseIsActive: "",
      // テーブルラベル
      labelName: {
        quaNm: "資格名",
        quaNum: "資格番号",
        quaPhoto: "資格画像",
        acquisitionDate: "取得日",
        remarks: "備考",
        quaAdd: "資格新規",
        quaEdit: "資格編集",
      },
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
        noTableData: "資格を取得していません",
      },
      // 新規
      c010102VueForm: {
        companyId: "",
        userCd: "",
        appQuaId: "",
        applicantId: "",
        quaNm: "",
        quaNum: "",
        acquisitionDate: "",
        otherNm: "",
        remarks: "",
        quaAddress: "",
        photoPic: "",
      },
      // 選択ラン表示用
      showSelect: false,
      //アバターボタン表示用
      noneAvatar: false,
      // 写真アップロードのパラメータ
      uploadParameter: {
        uploadType: "image/jpeg,image/jpg,image/png,image/svg,application/pdf",
        fileList: [],
        fileType: "",
      },
      // 新規や編集のタイトル切替
      titleChange: true,
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
  watch: {
    // 資格名全角数字と英字自動的に半角に転換
    "c010102VueForm.quaNm": function (v) {
      this.c010102VueForm.quaNm = v.replace(/[Ａ-Ｚａ-ｚ０-９]/g, (s) => {
        return String.fromCharCode(s.charCodeAt(0) - 65248);
      });
    },
    // 資格番号全角数字と英字自動的に半角に転換
    "c010102VueForm.quaNum": function (v) {
      this.c010102VueForm.quaNum = v.replace(/[Ａ-Ｚａ-ｚ０-９]/g, (s) => {
        return String.fromCharCode(s.charCodeAt(0) - 65248);
      });
    },
  },
  computed: {
    // 新規ボタンと編集ボタンを判断
    showNameComputed() {
      return this.titleChange ? this.labelName.quaAdd : this.labelName.quaEdit;
    },
    // 写真が空いているの判断
    photoIsNullComputed() {
      return this.c010102VueForm.photoPic == "";
    },
  },
  methods: {
    // 新規保存
    saveData() {
      this.c010102VueForm.applicantId = this.applicantQuaTblBean[0].applicantId;
      console.log("c010102VueForm", this.c010102VueForm);
      // 必須項目チェック
      this.$refs.c010102VueForm.validate((valid) => {
        if (valid) {
          this.$store
            .dispatch("qualificationCertificateInsertQua", this.c010102VueForm)
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
      console.log("c010102VueForm", this.c010102VueForm);
      // 必須項目チェック
      this.$refs.c010102VueForm.validate((valid) => {
        if (valid) {
          this.$store
            .dispatch("qualificationCertificateUpdateQua", this.c010102VueForm)
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
    // 入力内容をクリア
    clearData() {
      this.clearForm();
      this.handleRemove();
    },
    // 入力文字をクリア
    clearForm() {
      this.$refs.c010102VueForm.resetFields();
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
    // 編集ボタン
    editButton(row) {
      console.log("edit the data", row);
      this.titleChange = false;
      this.c010102VueForm.applicantId = parseInt(row.applicantId);
      this.c010102VueForm.appQuaId = parseInt(row.appQuaId);
      this.setData(row);
      this.uploadParameter.fileType =
        this.rowPhotoIsPDF(row.quaAddress) == true ? "pdf" : "image";
      // 入力画面表示
      this.selectOpen();
    },
    // 行目データ取得
    setData(row) {
      this.c010102VueForm.photoPic = row.photoPic;
      this.c010102VueForm.quaNm = row.quaNm;
      this.c010102VueForm.quaNum = row.quaNum;
      this.c010102VueForm.acquisitionDate = row.acquisitionDate;
      this.c010102VueForm.remarks = row.remarks;
      this.c010102VueForm.quaAddress = row.quaAddress;
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
        .dispatch("qualificationCertificateDeleteQua", row)
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
    // テーブル行目ダブルクリック
    rowDoubleClick(row) {
      let $applicantQuaTblBean = this.$refs.applicantQuaTblBean;
      this.applicantQuaTblBean.map((item) => {
        // 単一の行目展開
        if (row.appQuaId != item.appQuaId) {
          $applicantQuaTblBean.toggleRowExpansion(item, false);
        }
      });
      $applicantQuaTblBean.toggleRowExpansion(row);
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
      this.c010102VueForm.photoPic = URL.createObjectURL(file.raw);
      // 画像ファイル
      this.c010102VueForm.quaAddress = res;
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
      this.c010102VueForm.photoPic = "";
      this.c010102VueForm.quaAddress = "";
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
      this.applicantQuaTblBean.map((item) => {
        this.$refs.applicantQuaTblBean.toggleRowExpansion(item, false);
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
// テーブル内ボタン
::v-deep .el-table .cell {
  padding: 0;
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
//アバターアップロードボタン表示用
::v-deep .uploadDisabled .el-upload--picture-card {
  display: none;
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
  position: relative;
}
// 行目展開アイコンが携帯端末で遮断され問題を修正
::v-deep .el-table__expand-icon {
  height: 1rem;
}
// テーブル数字
::v-deep td.el-table_1_column_1 {
  text-align: center;
}
// collapse本体
.el-collapse {
  border: none;
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
// 空いているのel-rowプレースホルダー
.el-col {
  min-height: 1px;
}
// テーブルボタンの下の黒い線を削除
.el-table__fixed-right::before {
  height: 0;
}
// セレクト欄
.select-style {
  margin-top: 5vh;
}
// 資格新規
.qua-add {
  font-size: 20px;
  color: #014099;
  margin-top: 2vh;
}
// 画像サイズ
.image-style {
  max-width: 150px;
  max-height: 150px;
}
// 保存ボタンサイズ一致化
button.el-button.el-tooltip.el-button--text {
  width: 35px;
  height: 55px;
}
</style>
