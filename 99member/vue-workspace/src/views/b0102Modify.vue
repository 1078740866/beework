<template>
  <div class="b0102Vue">
    <el-container
      ><HomeHeader />
      <div class="b0102Body">
        <el-main>
          <el-form
            :model="modifyForm"
            :rules="rules"
            ref="modifyForm"
            autocomplete="on"
            label-position="right"
          >
            <div class="b0102Title">
              <el-row>
                <el-col :span="2">
                  <div class="b0102Icon">
                    <el-image :src="require('@/assets/b_titleico3.png')" />
                  </div>
                </el-col>
                <el-col :span="22">
                  <div class="title_name">職位情報修正</div>
                </el-col>
              </el-row>
            </div>
            <div class="b0102Main">
              <div class="b0102TableDiv">
                <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="12">
                    <el-form-item
                      prop="positionNm"
                      label="職位名："
                      label-width="100px"
                    >
                      <el-input
                        v-model="modifyForm.positionNm"
                        placeholder="職位名"
                        maxlength="50"
                      />
                    </el-form-item>
                  </el-col>
                  <el-col :span="12">
                    <el-form-item
                      prop="expYears"
                      label="必須経験年数："
                      label-width="110px"
                      :required="true"
                    >
                      <el-select
                        v-model="modifyForm.expYears"
                        placeholder="必須経験年数："
                        :clearable="true"
                      >
                      <el-option
                          v-for="item in expYears"
                          :key="item.value"
                          :label="item.label"
                          :value="item.value"
                        />
                      </el-select>
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="12">
                    <el-form-item
                      prop="expDate"
                      label="有効期限："
                      label-width="100px"
                      :required="true"
                    >
                      <el-date-picker
                        v-model="modifyForm.expDate"
                        type="date"
                        placeholder="有効期限："
                        value-format="yyyy/MM/dd"
                        style="width: 250px"
                      />
                    </el-form-item>
                  </el-col>
                  <el-col :span="12">
                    <el-form-item
                      prop="degree"
                      label="学歴要求："
                      label-width="110px"
                    >
                      <el-select
                        v-model="modifyForm.degree"
                        placeholder="学歴要求："
                      >
                      <el-option
                          v-for="item in degree"
                          :key="item.value"
                          :label="item.label"
                          :value="item.value"
                        />
                      </el-select>
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row :gutter="20" type="flex" justify="space-between">
                   <el-col :span="12">
                    <el-form-item
                    prop="time"
                      label="勤務時間："
                      label-width="100px"
                    >
                      <el-time-picker
                    v-model="modifyForm.workTimeFrom"
                    placeholder="開始時間"
                    value-format="HH:mm:ss"
                    class="rangeStyle"
                    align="right"
                    type="time"
                    style="width :115px"
                  />
                  <label> ~ </label>
                  <el-time-picker
                    v-model="modifyForm.workTimeTo"
                    placeholder="終了時間"
                    value-format="HH:mm:ss"
                    class="rangeStyle"
                    align="right"
                    type="time"
                    style="width :115px"
                  />
                    </el-form-item>
                  </el-col>
                 <el-col :span="12">
                    <el-form-item
                      prop="salarySection"
                      label="給料区分："
                      label-width="110px"
                    >
                      <el-select
                        v-model="modifyForm.salarySection"
                        placeholder="給料区分："
                      >
                      <el-option
                          v-for="item in salarySection"
                          :key="item.value"
                          :label="item.label"
                          :value="item.value"
                        />
                      </el-select>
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="12">
                    <el-form-item
                      prop="positionInt"
                      label="職位説明："
                      label-width="100px"
                    >
                      <el-input
                        type="textarea"
                        v-model="modifyForm.positionInt"
                        rows="5"
                        style="width: 280px"
                        maxlength="1000"
                      />
                    </el-form-item>
                  </el-col>
                  <el-col :span="12">
                    <el-form-item
                      prop="salary"
                      label="給料区間："
                      label-width="110px"
                    >
                      <el-input
                        type="text"
                        v-model="modifyForm.salaryMin"
                        placeholder="下限(半角数字)"
                        style="width: 120px"
                        @input="numValid('salaryMin')"
                        @focus="b0102NumOnFocus($event)"
                        @blur="b0102MoneyOnBlur($event)"
                      />－
                      <el-input
                        type="text"
                        v-model="modifyForm.salaryMax"
                        placeholder="上限(半角数字)"
                        style="width: 120px"
                        @input="numValid('salaryMax')"
                        @focus="b0102NumOnFocus($event)"
                        @blur="b0102MoneyOnBlur($event)"
                      />
                    </el-form-item>
                    <el-form-item
                    prop="empLaborIns"
                      label="雇用・労災保険："
                      label-width="130px"
                    >
                        <el-select
                        v-model="modifyForm.empLaborIns"
                        placeholder="雇用・労災保険："
                        style="width :235px"
                      >
                      <el-option
                          v-for="item in empLaborIns"
                          :key="item.value"
                          :label="item.label"
                          :value="item.value"
                        />
                      </el-select>
                      </el-form-item>
                  </el-col>
                </el-row>
                <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="12">
                    <el-form-item
                      prop="workContent"
                      label="仕事内容:"
                      label-width="100px"
                    >
                      <el-input
                        type="textarea"
                        v-model="modifyForm.workContent"
                        rows="5"
                        style="width: 280px"
                        maxlength="1000"
                      />
                    </el-form-item>
                  </el-col>
                  <el-col :span="12">
                    <el-form-item
                      prop="welfare"
                      label="福利厚生："
                      label-width="115px"
                    >
                    <el-radio v-model="modifyForm.welfare" label="0">有り</el-radio>
                    <el-radio v-model="modifyForm.welfare" label="1">無し</el-radio>
                      </el-form-item>
                    <el-form-item
                      prop="trainingFlg"
                      label="研修有無："
                      label-width="115px"
                    >
                    <el-radio v-model="modifyForm.trainingFlg" label="0">有り</el-radio>
                    <el-radio v-model="modifyForm.trainingFlg" label="1">無し</el-radio>
                      </el-form-item>
                  </el-col>
                </el-row>
                <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="12">
                    <el-form-item
                      prop="industryId"
                      label="業種："
                      label-width="100px"
                      :required="true"
                    >
                      <el-select
                        v-model="modifyForm.industryId"
                        placeholder="業種"
                        :clearable="true"
                      >
                        <el-option
                          v-for="item in modifyForm.industryCds"
                          :key="item.industryId"
                          :label="item.industryNm"
                          :value="item.industryId"
                        >
                        </el-option>
                      </el-select>
                    </el-form-item>
                    <el-form-item
                      prop="jobTypeId"
                      label="職種："
                      label-width="100px"
                      :required="true"
                    >
                      <el-select
                        v-model="modifyForm.jobTypeId"
                        placeholder="職種"
                        :clearable="true"
                      >
                        <el-option
                          v-for="item in modifyForm.jobTypeCds"
                          :key="item.jobtypeId"
                          :label="item.jobtypeNm"
                          :value="item.jobtypeId"
                        >
                        </el-option>
                      </el-select>
                    </el-form-item>
                  </el-col>
                  <el-col :span="12">
                    <el-form-item
                      prop="inspectionFlg"
                      label="見学有無："
                      label-width="115px"
                    >
                    <el-radio v-model="modifyForm.inspectionFlg" label="0">有り</el-radio>
                    <el-radio v-model="modifyForm.inspectionFlg" label="1">無し</el-radio>
                      </el-form-item>
                    <el-form-item
                      prop="conUpdFlg"
                      label="契約更新有無:"
                      label-width="115px"
                    >
                    <el-radio v-model="modifyForm.conUpdFlg" label="0">有り</el-radio>
                    <el-radio v-model="modifyForm.conUpdFlg" label="1">無し</el-radio>
                      </el-form-item>
                  </el-col>
                </el-row>
                <el-row :gutter="20" type="flex" justify="space-between">
                   <el-col :span="12">
                    <el-form-item
                      prop="skillId"
                      label="スキル："
                      label-width="100px"
                      :required="true"
                    >
                      <el-select
                        v-model="modifyForm.skillId"
                        placeholder="スキル"
                        :clearable="true"
                      >
                        <el-option
                          v-for="item in modifyForm.skillCds"
                          :key="item.skillId"
                          :label="item.skillNm"
                          :value="item.skillId"
                        >
                        </el-option>
                      </el-select>
                    </el-form-item>
                  </el-col>
                  <el-col :span="12">
                    <el-form-item
                      prop="workDateStr"
                      label="仕事予定開始日："
                      label-width="125px"
                    >
                      <el-date-picker
                        v-model="modifyForm.workDateStr"
                        type="date"
                        placeholder="日付"
                        value-format="yyyy/MM/dd"
                        style="width: 230px"
                      />
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="12">
                    <el-form-item
                      prop="contractSection"
                      label="雇用方式："
                      label-width="100px"
                    >
                      <el-select
                        v-model="modifyForm.contractSection"
                        placeholder="雇用方式："
                      >
                      <el-option
                          v-for="item in contractSection"
                          :key="item.value"
                          :label="item.label"
                          :value="item.value"
                        />
                      </el-select>
                    </el-form-item>
                  </el-col>
                 <el-col :span="12">
                    <el-form-item
                      prop="holiday"
                      label="休日・休暇："
                      label-width="120px"
                    >
                      <el-input
                        v-model="modifyForm.holiday"
                        placeholder="休日・休暇"
                        maxlength="50"
                      />
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row :gutter="20" type="flex" justify="space-between">
                 <el-col :span="12">
                    <el-form-item
                      prop="postal1"
                      label="郵便番号："
                      label-width="100px"
                    >
                      <el-input
                        v-model="modifyForm.postal1"
                        class="postal1"
                        maxlength="3"
                        @input="numValid('postal1')"
                      />
                      <span class="hyphen">-</span>
                      <el-input
                        v-model="modifyForm.postal2"
                        class="postal2"
                        maxlength="4"
                        @input="numValid('postal2')"
                      />
                      <searchPostal
                        @parentMethod="postalInit"
                        :postal1="modifyForm.postal1"
                        :postal2="modifyForm.postal2"
                      />
                    </el-form-item>
                  </el-col>
                   <el-col :span="12">
                    <el-form-item
                      prop="peoCnt"
                      label="募集人数："
                      label-width="100px"
                    >
                      <el-input
                        v-model="modifyForm.peoCnt"
                        placeholder="半角数字"
                        maxlength="50"
                        @input="numValid('peoCnt')"
                        @focus="b0102NumOnFocus($event)"
                        @blur="b0102PersonOnBlur($event)"
                      />
                    </el-form-item>
                  </el-col>
                </el-row>
                 <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="24">
                    <el-form-item
                      prop="workAddress1"
                      label="職位場所："
                      label-width="100px"
                      :required="true"
                    >
                      <el-input
                        v-model="modifyForm.workAddress1"
                        class="address"
                        placeholder="入力された郵便番号に応じて、自動的に取得します"
                        :disabled="true"
                        maxlength="200"
                      >
                        {{ modifyForm.workAddress1 }}
                      </el-input>
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="24">
                    <el-form-item
                      prop="workAddress2"
                      label="住所詳細："
                      label-width="100px"
                    >
                      <el-input
                        v-model="modifyForm.workAddress2"
                        placeholder="住所詳細"
                        class="address"
                        maxlength="200"
                      />
                    </el-form-item>
                  </el-col>
                </el-row>
                 <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="24">
                    <el-form-item
                      prop="station"
                      label="最寄駅："
                      label-width="100px"
                    >
                      <el-input
                        v-model="modifyForm.station"
                        placeholder="最寄駅"
                        maxlength="20"
                      />
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="6">
                    <el-form-item
                      prop="workingAddress1"
                      label="仕事画像："
                      label-width="100px"
                    >
                      <div>
                        <el-upload
                            class="avatar-uploader"
                            :action="uploadUrl()"
                            :on-error="uploadFail"
                            :show-file-list="false"
                            :on-success="handleAvatarSuccesslicense1"
                            accept="image/jpeg,image/jpg,image/png"
                            :before-upload="beforeUpload"
                            list-type="picture-card"
                          >
                          <img
                              v-if="modifyForm.workingAddress1"
                              :src="workingAddress1Pic"
                              class="avatar"
                              alt
                            />
                            <em v-else class="el-icon-plus avatar-uploader-icon" alt></em>
                          </el-upload>
                      </div>
                    </el-form-item>
                  </el-col>
                  <el-col :span="4">
                    <el-form-item prop="workingAddress2">
                      <div v-show="workingAddress > 0">
                        <el-upload
                            class="avatar-uploader"
                            :action="uploadUrl()"
                            :on-error="uploadFail"
                            :show-file-list="false"
                            :on-success="handleAvatarSuccesslicense2"
                            accept="image/jpeg,image/jpg,image/png"
                            :before-upload="beforeUpload"
                            list-type="picture-card"
                          >
                            <img
                              v-if="modifyForm.workingAddress2"
                              :src="workingAddress2Pic"
                              class="avatar"
                              alt
                            />
                            <em v-else class="el-icon-plus avatar-uploader-icon" alt></em>
                          </el-upload>
                      </div>
                    </el-form-item>
                  </el-col>
                  <el-col :span="4">
                    <el-form-item prop="workingAddress3">
                      <div v-show="workingAddress > 1">
                        <el-upload
                            class="avatar-uploader"
                            :action="uploadUrl()"
                            :on-error="uploadFail"
                            :show-file-list="false"
                            :on-success="handleAvatarSuccesslicense3"
                            accept="image/jpeg,image/jpg,image/png"
                            :before-upload="beforeUpload"
                            list-type="picture-card"
                          >
                            <img
                              v-if="modifyForm.workingAddress3"
                              :src="workingAddress3Pic"
                              class="avatar"
                              alt
                            />
                            <em v-else class="el-icon-plus avatar-uploader-icon" alt></em>
                          </el-upload>
                      </div>
                    </el-form-item>
                  </el-col>
                  <el-col :span="10">
                    <el-button
                      type="primary"
                      icon="el-icon-plus"
                      @click="photoAddress++"
                      v-show="photoAddress < 2"
                      circle
                    />
                  </el-col>
                </el-row>
              </div>
              <el-row>
                <el-col :span="4" :offset="5">
                  <el-button
                    type="primary"
                    class="b0102Button"
                    @click="tob0102Confirm"
                  >
                    情報確認
                  </el-button>
                </el-col>
                <el-col :span="4" :offset="1">
                  <el-button @click="clearForm" class="b0102Button">
                    クリア
                  </el-button>
                </el-col>
                <el-col :span="4" :offset="1">
                  <el-button
                    type="primary"
                    @click="routerBack()"
                    class="b0102Button"
                  >
                    戻る
                  </el-button>
                </el-col>
              </el-row>
            </div>
          </el-form>
        </el-main>
      </div>
      <el-footer><HomeFooter /></el-footer>
    </el-container>
  </div>
</template>
<script>
// ヘッダー フッター
import HomeHeader from "./components/HomeHeader";
import HomeFooter from "./components/HomeFooter";
// 郵便番号検索機能導入
import SearchPostal from "./components/SearchPostal";
// 内容チェック機能導入
import {
  validateNecessary,
  numOnBlur,
  numOnFocus,
} from "@/utils/validate";
export default {
  name: "b0102Registered",
  components: {
    HomeHeader,
    HomeFooter,
    SearchPostal,
  },
  data() {
    return {
      name: "b0102Registered",
      modifyForm: {
        userCd: Number,
        companyId: Number,
        positionId: "",
        industryId: "",
        industryNm: "",
        jobTypeId: "",
        jobTypeNm: "",
        industryCds: "",
        jobTypeCdS: "",
        skillId: "",
        skillNm: "",
        skillCds: "",
        positionNm: "",
        defaultYear: "",
        expDate: "",
        degree: "",
        workTimeFrom: "",
        workTimeTo: "",
        salarySection: "",
        positionInt: "",
        salaryMin: "",
        salaryMax: "",
        empLaborIns: "",
        workContent: "",
        expYears: "",
        welfare: "",
        trainingFlg: "",
        inspectionFlg: "",
        conUpdFlg: "",
        peoCnt: "",
        workDateStr: "",
        contractSection: "",
        holiday: "",
        postal1: "",
        postal2: "",
        workAddress1: "",
        workAddress2: "",
        station: "",
        workingAddress1: "",
        workingAddress2: "",
        workingAddress3: "",
      },
      b0102InForm: {
        industryId: "",
        jobTypeId: "",
        industryNm: "",
        jobTypeNm: "",
        skillId: "",
        skillNm: "",
        positionId: "",
        positionNm: "",
        defaultYear: "",
        expDate: "",
        degree: "",
        workTimeFrom: "",
        workTimeTo: "",
        salarySection: "",
        positionInt: "",
        salaryMin: "",
        salaryMax: "",
        empLaborIns: "",
        workContent: "",
        expYears: "",
        welfare: "",
        trainingFlg: "",
        inspectionFlg: "",
        conUpdFlg: "",
        peoCnt: "",
        workDateStr: "",
        contractSection: "",
        holiday: "",
        postal: "",
        workAddress1: "",
        workAddress2: "",
        station: "",
        workingAddress1: "",
        workingAddress2: "",
        workingAddress3: "",
      },
      b0102ReturnForm: {
        industryId: "",
        jobTypeId: "",
        industryNm: "",
        jobTypeNm: "",
        skillId: "",
        skillNm: "",
        positionId: "",
        positionNm: "",
        defaultYear: "",
        expDate: "",
        degree: "",
        workTimeFrom: "",
        workTimeTo: "",
        salarySection: "",
        positionInt: "",
        salaryMin: "",
        salaryMax: "",
        empLaborIns: "",
        workContent: "",
        expYears: "",
        welfare: "",
        trainingFlg: "",
        inspectionFlg: "",
        conUpdFlg: "",
        peoCnt: "",
        workDateStr: "",
        contractSection: "",
        holiday: "",
        postal: "",
        postal1: "",
        postal2: "",
        workAddress1: "",
        workAddress2: "",
        station: "",
        workingAddress1: "",
        workingAddress2: "",
        workingAddress3: "",
      },

      expYears: [
        {value: "0", label: "不問"},
        {value: "1", label: "1年未満"},
        {value: "2", label: "3年未満"},
        {value: "3", label: "5年未満"},
        {value: "4", label: "10年未満"},
        {value: "5", label: "10年以上"},
      ],

      degree: [
        {value: "0", label: "大卒以上"},
        {value: "1", label: "専門卒以上"},
        {value: "2", label: "高卒以上"},
        {value: "3", label: "大卒"},
        {value: "4", label: "院卒"},
        {value: "5", label: "専門卒"},
        {value: "6", label: "高卒"},
        {value: "7", label: "学歴不問"},
      ],

      salarySection: [
        {value: "0", label: "月給"},
        {value: "1", label: "年俸"},
        {value: "2", label: "日給"},
        {value: "3", label: "時給"},
        {value: "4", label: "出来高払い"},
        {value: "5", label: "その他"},
      ],

      contractSection: [
        {value: "0", label: "正社員"},
        {value: "1", label: "契約社員"},
        {value: "2", label: "アルバイト"},
        {value: "3", label: "パート"},
        {value: "4", label: "派遣"},
      ],

      empLaborIns: [
        {value: "0", label: "未加入"},
        {value: "1", label: "一般の事業"},
        {value: "2", label: "農林水産"},
        {value: "3", label: "建計業他"},
      ],
      // 画像表示用
      photoAddress: 0,
      isShow: false,
      rules: {
        positionNm: [validateNecessary("職位名")],
        defaultYear: [validateNecessary("必須経験年数")],
        industryId: [validateNecessary("業種")],
        jobTypeId: [validateNecessary("職種")],
        skillId: [validateNecessary("スキル")],
        charge: [validateNecessary("担当")],
        expDate: [validateNecessary("有効期限")],
        degree: [validateNecessary("学歴要求")],
        workTimeFrom: [validateNecessary("出勤時間")],
        workTimeTo: [validateNecessary("退勤時間")],
        salarySection: [validateNecessary("給料区分")],
        salaryMin: [validateNecessary("最低限給料")],
        salaryMax: [validateNecessary("最高限給料")],
        empLaborIns: [validateNecessary("雇用・労災保険")],
        welfare: [validateNecessary("福利厚生")],
        trainingFlg: [validateNecessary("研修有無")],
        inspectionFlg: [validateNecessary("見学有無")],
        conUpdFlg: [validateNecessary("契約更新有無")],
        postal1: [validateNecessary("郵便番号")],
        contractSection: [validateNecessary("雇用方式")],
        workDateStr: [validateNecessary("仕事予定開始日")],
        workAddress2: [validateNecessary("住所詳細")],
        station: [validateNecessary("最寄駅")],
      },
    };
  },
  mounted() {
    document.title = "職位情報修正";
    this.getIndustryCds();
    this.getJobTypeCds();
    this.getSkillCds();
    this.b0102InForm = JSON.parse(this.$route.query.flight);
    this.b0102ReturnForm = JSON.parse(this.$route.query.flight);
    console.log("b0102InForm", this.b0102InForm);
    this.setModifyForm();
    
  },
  methods: {
    // 業種取得
    getIndustryCds() {
      this.$store.dispatch("b0102InitIndustry").then((response) => {
        this.$router.push({
          query: { data: response.data.data },
        });
        this.modifyForm.industryCds = response.data.data;
        console.log("industryCds", this.modifyForm.industryCds);
      });
    },
    // 職種取得
    getJobTypeCds() {
      this.$store.dispatch("b0102InitJobtype").then((response) => {
        this.$router.push({
          query: { data: response.data.data },
        });
        this.modifyForm.jobTypeCds = response.data.data;
        console.log("jobTypeCds", this.modifyForm.jobTypeCds);
      });
    },
    //skill取得
        getSkillCds() {
          this.$store.dispatch("b0102InitSkill").then((response) => {
            this.$router.push({
              query: { data: response.data.data },
            });
            this.modifyForm.skillCds = response.data.data;
            console.log("skillCds", this.modifyForm.skillCds);
          });
        },

      setModifyForm() {
      this.modifyForm.positionNm = this.b0102InForm.positionNm;
      this.modifyForm.defaultYear = this.b0102InForm.defaultYear;
      this.modifyForm.positionId = this.b0102InForm.positionId;
      this.modifyForm.industryId = this.b0102InForm.industryId;
      this.modifyForm.jobTypeId = this.b0102InForm.jobTypeId;
      this.modifyForm.skillId = this.b0102InForm.skillId;
      this.modifyForm.expDate = this.b0102InForm.expDate;
      this.modifyForm.degree = this.b0102InForm.degree;
      this.modifyForm.workTimeFrom = this.b0102InForm.workTimeFrom;
      this.modifyForm.workTimeTo = this.b0102InForm.workTimeTo;
      if (this.b0102InForm.postal != null) {
        this.modifyForm.postal1 = this.b0102InForm.postal.split("-")[0];
        this.modifyForm.postal2 = this.b0102InForm.postal.split("-")[1];
      }
      else{
        this.modifyForm.postal1 = this.b0102ReturnForm.postal1;
        this.modifyForm.postal2 = this.b0102ReturnForm.postal2;
      }
      this.modifyForm.salarySection = this.b0102InForm.salarySection;
      this.modifyForm.positionInt = this.b0102InForm.positionInt;
      this.modifyForm.salaryMin = this.b0102InForm.salaryMin;
      this.modifyForm.salaryMax = this.b0102InForm.salaryMax;
      this.modifyForm.empLaborIns = this.b0102InForm.empLaborIns;
      this.modifyForm.workContent = this.b0102InForm.workContent;
      this.modifyForm.expYears = this.b0102InForm.expYears;
      this.modifyForm.welfare = this.b0102InForm.welfare;
      this.modifyForm.trainingFlg = this.b0102InForm.trainingFlg;
      this.modifyForm.inspectionFlg = this.b0102InForm.inspectionFlg;
      this.modifyForm.conUpdFlg = this.b0102InForm.conUpdFlg;
      this.modifyForm.peoCnt = this.b0102InForm.peoCnt;
      this.modifyForm.workDateStr = this.b0102InForm.workDateStr;
      this.modifyForm.contractSection = this.b0102InForm.contractSection;
      this.modifyForm.holiday = this.b0102InForm.holiday;
      this.modifyForm.workAddress1 = this.b0102InForm.workAddress1;
      this.modifyForm.workAddress2 = this.b0102InForm.workAddress2;
      this.modifyForm.station = this.b0102InForm.station;
      this.modifyForm.workingAddress1 = this.b0102InForm.workingAddress1;
      this.modifyForm.workingAddress2 = this.b0102InForm.workingAddress2;
      this.modifyForm.workingAddress3 = this.b0102InForm.workingAddress3;
    },

    uploadUrl() {
          return `${this.$store.state.HOST}/B0002/upload`;
        },

    // 住所を取得する
    postalInit(address) {
      this.modifyForm.workAddress1 = address;
    },
    // 入力内容数字制限
    numValid(val) {
      this.modifyForm[val] = this.modifyForm[val].replace(/[^0-9]/g, "");
    },
    // 数字の処理
    b0102NumOnFocus($event) {
      numOnFocus($event);
    },
    b0102PersonOnBlur($event, endBy = "人") {
      numOnBlur($event, endBy);
    },
    b0102MoneyOnBlur($event, endBy = "円") {
      numOnBlur($event, endBy);
    },

    // 情報確認ボタン
    tob0102Confirm() {
      console.log("modifyForm:", this.modifyForm);
       this.$router.push({
        path: "/b0102ModifyConfirm",
        query: {
          flight: JSON.stringify(this.modifyForm),
        },
      });
    },
    // 戻るボタン
    routerBack() {
      this.$router.replace({ path: "/b0101" });
    },
    // クリアボタン
    clearForm() {
      this.modifyForm.industryId = "",
      this.modifyForm.jobtypeId = "",
      this.modifyForm.positionNm = "",
      this.modifyForm.defaultYear = "",
      this.modifyForm.expDate = "",
      this.modifyForm.defaultDegree = "",
      this.modifyForm.workTimeFrom = "",
       this.modifyForm.workTimeTo = "",
      this.modifyForm.salarySection = "",
      this.modifyForm.positionInt = "",
      this.modifyForm.salaryMin = "",
      this.modifyForm.salaryMax = "",
      this.modifyForm.empLaborIns = "",
      this.modifyForm.workContent = "",
      this.modifyForm.welfare = "",
      this.modifyForm.trainingFlg = "",
      this.modifyForm.inspectionFlg = "",
      this.modifyForm.conUpdFlg = "",
      this.modifyForm.peoCnt = "",
      this.modifyForm.workDateStr = "",
      this.modifyForm.contractSection = "",
      this.modifyForm.holiday = "",
      this.modifyForm.postal1 = "",
      this.modifyForm.postal2 = "",
      this.modifyForm.workAddress1 = "",
      this.modifyForm.workAddress2 = "",
      this.modifyForm.station = "",
      this.modifyForm.workingAddress1 = "",
      this.modifyForm.workingAddress2 = "",
      this.modifyForm.workingAddress3 = "",
      this.photoAddress = 0;
      this.isShow = false;
    },
  },
};
</script>
<style lang="scss" scoped>
// 全屏主体灰色背景
.b0102Body {
  background-color: #f6f6f6;
  width: 100%;
  left: 0px;
  top: 66px;
}
// 两个主体部分宽80vw，居中，边框阴影，白色背景
.b0102Title,
.b0102Main {
  width: 80vw;
  margin-left: 10vw;
  box-shadow: 0 2px 4px #dce5f4, 0 0 6px #dce5f4;
  background-color: #ffffff;
}
// div内上下距离
.b0102Main {
  padding-top: 5vh;
  padding-bottom: 5vh;
}
// 标题栏上下内外边距
.b0102Title {
  margin-top: 0px;
  margin-bottom: 15px;
  padding-top: 0px;
  padding-bottom: 0px;
}
// 标题栏图标宽，边距
.b0102Icon {
  width: 53px;
  margin-left: 26px;
  margin-top: 21px;
  margin-bottom: 21px;
}
// 标题位置大小颜色等
.title_name {
  color: #006699;
  font-weight: 600;
  font-size: 2em;
  padding: 4vh;
  padding-left: 1vh;
}
// 邮编前三位输入框
.postal1 {
  width: 80px !important;
  margin-right: 11px;
}
// 邮编后四位输入框
.postal2 {
  width: 120px !important;
  margin-left: 11px;
  margin-right: 11px;
}
// 上传图片尺寸限制在框内
.avatar {
  width: 150px;
  height: 150px;
}
// 输入框下拉框标签宽度修改
.el-input,
.el-select {
  width: 280px;
}
// 地址栏宽度
.address {
  width: 82% !important;
}
// 表格div左边距
.b0102TableDiv {
  margin-left: 5vw;
}
// 下面三个按钮的宽度
.b0102Button {
  width: 100px;
}
</style>
