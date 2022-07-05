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
                    <!-- <el-row>
                      <el-col :span="12">
                        <el-form-item :label="labelName.jobtypeId1_2">
                          <p>{{ jobType2Computed(props.row.jobtypeId1_2) }}</p>
                        </el-form-item>
                      </el-col>
                      <el-col :span="12">
                        <el-form-item :label="labelName.jobtypeId1_3">
                          <p>{{ jobType3Computed(props.row.jobtypeId1_3) }}</p>
                        </el-form-item>
                      </el-col>
                    </el-row> -->
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
            ref="c010104VueForm"
            :model="c010104VueForm"
            :rules="rules"
            label-width="23%"
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
                <el-form-item prop="companyNm" :label="labelName.companyNm">
                  <el-input
                    v-model.trim="c010104VueForm.companyNm"
                    :placeholder="labelName.companyNm"
                    maxlength="50"
                    show-word-limit
                    clearable
                  />
                </el-form-item>
              </el-col>
              <el-col :span="10" :offset="1">
                <el-form
                  ref="industryJobCascader"
                  :model="industryJobCascader"
                  :rules="rules"
                  label-width="23%"
                >
                  <el-form-item prop="industryJobType" :label="labelName.industryJob">
                    <el-cascader
                      ref="industryJobCascader"
                      @focus="setindustryJob"
                      @blur="industryJobCascaderBlur"
                      v-model="industryJobCascader.industryJobType"
                      :options="industryJob"
                      :props="{ expandTrigger: 'hover' }"
                      size="medium"
                      separator=" / "
                      filterable
                      clearable
                    />
                  </el-form-item>
                </el-form>
              </el-col>
              <!-- <el-col :span="1">
                <el-tooltip
                  :content="promptMessage.addJobType"
                  placement="top-start"
                  effect="light"
                  :open-delay="400"
                >
                  <span>
                    <el-button
                      type="primary"
                      icon="el-icon-plus"
                      @click="addJobType"
                      :disabled="jobTypeShow == 2 || industryJobIsNull"
                      circle
                    />
                  </span>
                </el-tooltip>
              </el-col> -->
            </el-row>
            <!-- <el-row>
              <el-col :span="10" :offset="1" v-show="jobTypeShow > 0">
                <el-form-item prop="jobtypeId1_2" :label="labelName.jobtypeId1_2">
                  <el-select
                    v-model="c010104VueForm.jobtypeId1_2"
                    :disabled="industryJobIsNull"
                    clearable
                  >
                    <el-option
                      v-for="(jobType1ComputedItem, index) in jobTypeComputed"
                      :key="`jobType1_2-${index}`"
                      :label="jobType1ComputedItem.jobtypeNm"
                      :value="jobType1ComputedItem.jobtypeId"
                    />
                  </el-select>
                </el-form-item>
              </el-col>
              <el-col :span="1" v-show="jobTypeShow > 0">
                <el-tooltip
                  :content="promptMessage.minusJobType"
                  placement="bottom-start"
                  effect="light"
                  :open-delay="400"
                >
                  <span>
                    <el-button
                      type="primary"
                      icon="el-icon-minus"
                      @click="minusJobType"
                      :disabled="jobTypeShow == 0"
                      circle
                    />
                  </span>
                </el-tooltip>
              </el-col>
              <el-col :span="10" v-show="jobTypeShow > 1">
                <el-form-item prop="jobtypeId1_3" :label="labelName.jobtypeId1_3">
                  <el-select
                    v-model="c010104VueForm.jobtypeId1_3"
                    :disabled="industryJobIsNull"
                    clearable
                  >
                    <el-option
                      v-for="(jobType1ComputedItem, index) in jobTypeComputed"
                      :key="`jobType1_3-${index}`"
                      :label="jobType1ComputedItem.jobtypeNm"
                      :value="jobType1ComputedItem.jobtypeId"
                    />
                  </el-select>
                </el-form-item>
              </el-col>
            </el-row> -->
            <el-row>
              <el-col :span="10" :offset="1">
                <el-form-item prop="workPosition" :label="labelName.workPosition">
                  <el-input
                    v-model.trim="c010104VueForm.workPosition"
                    :placeholder="labelName.workPosition"
                    maxlength="50"
                    show-word-limit
                    clearable
                  />
                </el-form-item>
              </el-col>
              <el-col :span="10" :offset="1">
                <el-form-item prop="workPlace" :label="labelName.workPlace">
                  <el-input
                    v-model.trim="c010104VueForm.workPlace"
                    :placeholder="labelName.workPlace"
                    maxlength="200"
                    show-word-limit
                    clearable
                  />
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="10" :offset="1">
                <el-form-item :label="labelName.workDate" required>
                  <el-col :span="11">
                    <el-form-item prop="workDateFrom">
                      <el-date-picker
                        v-model="c010104VueForm.workDateFrom"
                        :placeholder="labelName.workDateFrom"
                        :picker-options="dateFromPicker"
                        @change="changeEnd"
                        format="yyyy-MM-dd"
                        type="date"
                      />
                    </el-form-item>
                  </el-col>
                  <el-col :span="1" :offset="1">
                    <span>-</span>
                  </el-col>
                  <el-col :span="11">
                    <el-form-item prop="workDateTo">
                      <el-date-picker
                        v-model="c010104VueForm.workDateTo"
                        :placeholder="labelName.workDateTo"
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
              <el-col :span="10" :offset="1">
                <el-form-item prop="workContent" :label="labelName.workContent">
                  <el-input
                    type="textarea"
                    v-model="c010104VueForm.workContent"
                    :placeholder="labelName.workContent"
                    maxlength="500"
                    show-word-limit
                    :autosize="{ minRows: 2 }"
                    clearable
                  />
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="10" :offset="1">
                <el-form-item prop="workSkill" :label="labelName.workSkill">
                  <el-input
                    type="textarea"
                    v-model="c010104VueForm.workSkill"
                    :placeholder="labelName.workSkill"
                    maxlength="200"
                    show-word-limit
                    :autosize="{ minRows: 2 }"
                    clearable
                  />
                </el-form-item>
              </el-col>
              <el-col :span="10" :offset="1">
                <el-form-item prop="introduction" :label="labelName.introduction">
                  <el-input
                    type="textarea"
                    v-model="c010104VueForm.introduction"
                    :placeholder="labelName.introduction"
                    maxlength="500"
                    show-word-limit
                    :autosize="{ minRows: 2 }"
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
  name: "c010104",
  props: {
    applicantWorkHisTblBean: {},
    industryMstBean: {},
    jobtypeMstBean: {},
  },
  data() {
    return {
      name: "職歴",
      rules: {
        // 会社名必須入力
        companyNm: [validateNecessary("会社名")],
        industryJobType: [validateSelect("業種-職種")],
        workPosition: [validateNecessary("職位")],
        workPlace: [validateNecessary("勤務地")],
        workDateFrom: [validateSelect("入社日")],
        workDateTo: [validateSelect("退社日")],
        workContent: [validateNecessary("職務内容")],
      },
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
        // jobtypeId1_2: "職種2",
        // jobtypeId1_3: "職種3",
        workPosition: "職位",
        workPlace: "勤務地",
        workDate: "在職期間",
        workContent: "職務内容",
        workSkill: "使用技術",
        introduction: "事業内容",
        workDateFrom: "入社日",
        workDateTo: "退社日",
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
        // addJobType: "業種-職種を選択した後、職種を追加ができます",
        minusJobType: "職種を減少",
        jobSelectAble: "業種-職種を選択後、選択可能です",
        serverProblem: "サーバーで問題が発生しました",
        deleteSuccess: "削除完了",
        deleteFailed: "削除失敗",
        noTableData: "実務経験なし",
      },
      // 新規
      c010104VueForm: {
        companyId: "",
        userCd: "",
        workHisId: Number,
        applicantId: "",
        companyNm: "",
        industryId1: "",
        jobtypeId1_1: "",
        jobtypeId1_2: "",
        jobtypeId1_3: "",
        workPosition: "",
        workPlace: "",
        workSkill: "",
        workDateFrom: "",
        workDateTo: "",
        introduction: "",
        workContent: "",
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
      // 業種-職種
      industryJob: [],
      // 職種表示用
      // jobTypeShow: 0,
      // 選択されたの業種-職種
      industryJobCascader: {
        industryJobType: [],
      },
      // 業種-職種ヌール
      // industryJobIsNull: true,
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
    // jobType2Computed() {
    //   return (jobType2) => this.jobtypeMstBean[jobType2].jobtypeNm;
    // },
    // jobType3Computed() {
    //   return (jobType3) => this.jobtypeMstBean[jobType3].jobtypeNm;
    // },
    // 新規ボタンと編集ボタンを判断
    showNameComputed() {
      return this.titleChange ? this.labelName.workAdd : this.labelName.workEdit;
    },
    // 業種によって職種をスクリーニング
    jobTypeComputed() {
      return this.jobtypeMstBean.filter(
        (item) => item.industryId == this.industryJobCascader.industryJobType[0]
      );
    },
  },
  watch: {
    // 業種-職種がヌールの判断
    // "industryJobCascader.industryJobType": function (v) {
    //   this.industryJobIsNull = v == "" ? true : false;
    //   if (v == "") {
    //     this.c010104VueForm.jobtypeId1_2 = "";
    //     this.c010104VueForm.jobtypeId1_3 = "";
    //   }
    // },
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
      // this.jobTypeShow = 0;
      this.$refs.c010104VueForm.resetFields();
      this.$refs.industryJobCascader.resetFields();
    },
    // 編集ボタン
    editButton(row) {
      console.log("edit the data", row);
      this.titleChange = false;
      this.c010104VueForm.applicantId = parseInt(row.applicantId);
      this.c010104VueForm.workHisId = parseInt(row.workHisId);
      this.setData(row);
      this.setindustryJob();
      // 職種2 3表示の判断
      // this.editShow(row);
      // 入力画面表示
      this.selectOpen();
    },
    // 行目データ取得
    setData(row) {
      this.c010104VueForm.workHisId = row.workHisId;
      this.c010104VueForm.applicantId = row.applicantId;
      this.c010104VueForm.companyNm = row.companyNm;
      this.c010104VueForm.industryId1 = row.industryId1;
      this.c010104VueForm.jobtypeId1_1 = row.jobtypeId1_1;
      this.c010104VueForm.jobtypeId1_2 = row.jobtypeId1_2;
      this.c010104VueForm.jobtypeId1_3 = row.jobtypeId1_3;
      this.c010104VueForm.workPosition = row.workPosition;
      this.c010104VueForm.workPlace = row.workPlace;
      this.c010104VueForm.workSkill = row.workSkill;
      this.c010104VueForm.workDateFrom = row.workDateFrom;
      this.c010104VueForm.workDateTo = row.workDateTo;
      this.c010104VueForm.introduction = row.introduction;
      this.c010104VueForm.workContent = row.workContent;
      this.industryJobCascader.industryJobType = [row.industryId1, row.jobtypeId1_1];
    },
    // 新規保存
    saveData() {
      this.c010104VueForm.applicantId = this.applicantWorkHisTblBean[0].applicantId;
      if (this.industryJobCascader.industryJobType[1]) {
        this.c010104VueForm.industryId1 = this.industryJobCascader.industryJobType[0];
        this.c010104VueForm.jobtypeId1_1 = this.industryJobCascader.industryJobType[1];
      } else this.$message.warning(this.promptMessage.nullMessage);
      console.log("c010104VueForm", this.c010104VueForm);
      // 必須項目チェック
      this.$refs.c010104VueForm.validate((valid) => {
        if (valid) {
          this.$refs.industryJobCascader.validate((valid2) => {
            if (valid2) {
              this.$store
                .dispatch("workExperienceInsertWorkHis", this.c010104VueForm)
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
                    this.$message.error(response.data.message);
                    this.$router.push({
                      path: "/error",
                      query: { message: response.data.message },
                    });
                  }
                })
                .catch(() => {});
            } else {
              this.$message.warning(this.promptMessage.nullMessage);
            }
          });
        } else {
          this.industryJobCascaderBlur();
          this.$message.warning(this.promptMessage.nullMessage);
        }
      });
    },
    // cascaderチェック
    industryJobCascaderBlur() {
      this.$refs.industryJobCascader.validate().catch(() => {});
    },
    // 編集保存
    saveEditData() {
      this.c010104VueForm.jobtypeId1_1 = this.industryJobCascader.industryJobType[1];
      console.log("c010104VueForm", this.c010104VueForm);
      // 必須項目チェック
      this.$refs.c010104VueForm.validate((valid) => {
        if (valid) {
          this.$store
            .dispatch("workExperienceUpdateWorkHis", this.c010104VueForm)
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
        .dispatch("workExperienceDeleteWorkHis", row)
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
    setindustryJob() {
      this.industryJob = [];
      this.setIndustry();
      this.setJob();
      console.log("industryJob", this.industryJob);
    },
    // 業種のデータを編集
    setIndustry() {
      let industryOptions = { value: "", label: "", children: [] };
      this.industryMstBean.forEach((industryElement) => {
        industryOptions.value = industryElement.industryId;
        industryOptions.label = industryElement.industryNm;
        this.industryJob.push(industryOptions);
        industryOptions = { value: "", label: "", children: [] };
      });
    },
    // 職種のデータを編集
    setJob() {
      let jobOptions = { value: "", label: "" };
      this.jobtypeMstBean.forEach((jobElement) => {
        this.industryJob.forEach((industryJobElement) => {
          if (jobElement.industryId == industryJobElement.value) {
            jobOptions.value = jobElement.jobtypeId;
            jobOptions.label = jobElement.jobtypeNm;
            industryJobElement.children.push(jobOptions);
            jobOptions = { value: "", label: "" };
          }
        });
      });
    },
    // 職種増加
    // addJobType() {
    //   if (this.jobTypeShow >= 0 && this.jobTypeShow < 2) {
    //     this.jobTypeShow++;
    //     console.log("jobTypeShow", this.jobTypeShow);
    //   }
    // },
    // 職種減少
    // minusJobType() {
    //   if (this.jobTypeShow > 0 && this.jobTypeShow < 3) {
    //     this.jobTypeShow--;
    //     this.c010104VueForm.jobtypeId1_3 = "";
    //     if (this.jobTypeShow < 1) {
    //       this.c010104VueForm.jobtypeId1_2 = "";
    //     }
    //     console.log("jobTypeShow", this.jobTypeShow);
    //   }
    // },
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
      this.applicantWorkHisTblBean.map((item) => {
        this.$refs.applicantWorkHisTblBean.toggleRowExpansion(item, false);
      });
    },
    // 終了日付を開始日付にの制限
    changeStart() {
      // 値削除の場合、制限クリア
      if (!this.c010104VueForm.workDateTo) {
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
            date.getTime() > this.c010104VueForm.workDateTo || date.getTime() > Date.now()
          );
        },
      });
    },
    // 開始日付を終了日付にの制限
    changeEnd() {
      // 値削除の場合、制限クリア
      if (!this.c010104VueForm.workDateFrom) {
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
            date.getTime() < this.c010104VueForm.workDateFrom ||
            date.getTime() > Date.now()
          );
        },
      });
    },
    // 編集職種2 3の有無の判断
    // editShow(row) {
    //   if (row.jobtypeId1_2 != "") this.jobTypeShow++;
    //   if (row.jobtypeId1_3 != "") this.jobTypeShow++;
    // },
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
// 新規
.qua-add {
  font-size: 20px;
  color: #014099;
  margin-top: 2vh;
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
