<template>
  <div class="b0102Vue">
    <el-container
      ><HomeHeader />
      <div class="b0102Body">
        <el-main>
          <el-form
            :model="b0102VueForm"
            :rules="rules"
            ref="b0102VueForm"
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
                  <div class="title_name">職位新規入力</div>
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
                        v-model="b0102VueForm.positionNm"
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
                        v-model="b0102VueForm.expYears"
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
                        v-model="b0102VueForm.expDate"
                        type="date"
                        placeholder="有効期限："
                        value-format="yyyy/MM/dd"
                        style="width: 250px"
                        :picker-options="pickerOptions"
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
                        v-model="b0102VueForm.degree"
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
                    v-model="b0102VueForm.workTimeFrom"
                    placeholder="開始時間"
                    value-format="HH:mm:ss"
                    class="rangeStyle"
                    align="right"
                    type="time"
                    style="width :115px"
                  />
                  <label> ~ </label>
                  <el-time-picker
                    v-model="b0102VueForm.workTimeTo"
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
                        v-model="b0102VueForm.salarySection"
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
                        v-model="b0102VueForm.positionInt"
                        rows="5"
                        style="width: 280px"
                        maxlength="200"
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
                        v-model="b0102VueForm.salaryMin"
                        placeholder="下限(半角数字)"
                        style="width: 120px"
                        @input="numValid('salaryMin')"
                        @focus="b0102NumOnFocus($event)"
                        @blur="b0102MoneyOnBlur($event)"
                        :clearable="true"
                      />－
                      <el-input
                        type="text"
                        v-model="b0102VueForm.salaryMax"
                        placeholder="上限(半角数字)"
                        style="width: 120px"
                        @input="numValid('salaryMax')"
                        @focus="b0102NumOnFocus($event)"
                        @blur="b0102MoneyOnBlur($event)"
                        :clearable="true"
                      />
                    </el-form-item>
                    <el-form-item
                      prop="empLaborIns"
                      label="雇用・労災保険："
                      label-width="130px"
                    >
                      <el-select
                        v-model="b0102VueForm.empLaborIns"
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
                        v-model="b0102VueForm.workContent"
                        rows="5"
                        style="width: 280px"
                        maxlength="200"
                      />
                    </el-form-item>
                  </el-col>
                  <el-col :span="12">
                    <el-form-item
                      prop="welfare"
                      label="福利厚生："
                      label-width="115px"
                    >
                    <el-radio v-model="b0102VueForm.welfare" label="0">有り</el-radio>
                    <el-radio v-model="b0102VueForm.welfare" label="1">無し</el-radio>
                      </el-form-item>
                    <el-form-item
                      prop="trainingFlg"
                      label="研修有無："
                      label-width="115px"
                    >
                    <el-radio v-model="b0102VueForm.trainingFlg" label="0">有り</el-radio>
                    <el-radio v-model="b0102VueForm.trainingFlg" label="1">無し</el-radio>
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
                        v-model="b0102VueForm.industryId"
                        placeholder="業種"
                        :clearable="true"
                      >
                        <el-option
                          v-for="item in b0102VueForm.industryCds"
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
                        v-model="b0102VueForm.jobTypeId"
                        placeholder="職種"
                        :clearable="true"
                      >
                        <el-option
                          v-for="item in b0102VueForm.jobTypeCds"
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
                    <el-radio v-model="b0102VueForm.inspectionFlg" label="0">有り</el-radio>
                    <el-radio v-model="b0102VueForm.inspectionFlg" label="1">無し</el-radio>
                      </el-form-item>
                    <el-form-item
                      prop="conUpdFlg"
                      label="契約更新有無:"
                      label-width="115px"
                    >
                    <el-radio v-model="b0102VueForm.conUpdFlg" label="0">有り</el-radio>
                    <el-radio v-model="b0102VueForm.conUpdFlg" label="1">無し</el-radio>
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
                        v-model="b0102VueForm.skillId"
                        placeholder="スキル"
                        :clearable="true"
                      >
                        <el-option
                          v-for="item in b0102VueForm.skillCds"
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
                        v-model="b0102VueForm.workDateStr"
                        type="date"
                        placeholder="日付"
                        value-format="yyyy/MM/dd"
                        style="width: 220px"
                        :picker-options="pickerOptions"
                      />
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row :gutter="20" type="flex" justify="space-between">
                  <el-col :span="12">
                    <el-form-item
                      prop="contractSection"
                      label="雇用形態："
                      label-width="100px"
                    >
                      <el-select
                        v-model="b0102VueForm.contractSection"
                        placeholder="雇用形態："
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
                        v-model="b0102VueForm.holiday"
                        placeholder="休日・休暇"
                        maxlength="50"
                        style="width : 225px"
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
                        v-model="b0102VueForm.postal1"
                        class="postal1"
                        maxlength="3"
                        @input="numValid('postal1')"
                      />
                      <span class="hyphen">-</span>
                      <el-input
                        v-model="b0102VueForm.postal2"
                        class="postal2"
                        maxlength="4"
                        @input="numValid('postal2')"
                      />
                      <searchPostal
                        @parentMethod="postalInit"
                        :postal1="b0102VueForm.postal1"
                        :postal2="b0102VueForm.postal2"
                      />
                    </el-form-item>
                  </el-col>
                  <el-col :span="12">
                    <el-form-item
                      prop="peoCnt"
                      label="募集人数："
                      label-width="90px"
                    >
                      <el-input
                        v-model="b0102VueForm.peoCnt"
                        placeholder="半角数字"
                        maxlength="50"
                        @input="numValid('peoCnt')"
                        @focus="b0102NumOnFocus($event)"
                        @blur="b0102PersonOnBlur($event)"
                        :required="false"
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
                        v-model="b0102VueForm.workAddress1"
                        class="address"
                        placeholder="入力された郵便番号に応じて、自動的に取得します"
                        :disabled="true"
                        maxlength="200"
                      >
                        {{ b0102VueForm.workAddress1 }}
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
                        v-model="b0102VueForm.workAddress2"
                        placeholder="住所詳細"
                        class="address"
                        maxlength="100"
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
                        v-model="b0102VueForm.station"
                        placeholder="最寄駅"
                        maxlength="20"
                      />
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row :gutter="20" type="flex" justify="space-between" v-show="this.picurl1 == ''?false:true">
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
                              v-if="b0102VueForm.workingAddress1"
                              :src="this.picurl1"
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
                              v-if="b0102VueForm.workingAddress2"
                              :src="this.picurl2"
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
                              v-if="b0102VueForm.workingAddress3"
                              :src="this.picurl3"
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
                      @click="workingAddress++"
                      v-show="workingAddress < 2"
                      circle
                    />
                  </el-col>
                </el-row>
                <el-row :gutter="20" type="flex" justify="space-between" v-show="this.picurl1 == ''?true:false">
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
                              v-if="b0102VueForm.workingAddress1"
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
                              v-if="b0102VueForm.workingAddress2"
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
                              v-if="b0102VueForm.workingAddress3"
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
                      @click="workingAddress++"
                      v-show="workingAddress < 2"
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
                    @click="routerBack"
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
  validateSelect,
  numOnBlur,
  numOnFocus,
  telOnBlur,
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
      b0102VueForm: {
        userCd: Number,
        companyId: Number,
        industryId: "",
        industryNm: "",
        industryCds: "",
        jobTypeId: "",
        jobTypeNm: "",
        jobTypeCds: "",
        skillId: "",
        skillNm: "",
        skillCds: "",
        positionNm: "",
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
        welfare: "",
        expYears: "",
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
        workingAddress1Pic: "",
        workingAddress2Pic: "",
        workingAddress3Pic: "",
      },
      b0102InForm: {
        companyId: "",
        industryId: "",
        industryNm: "",
        industryCds: "",
        jobTypeId: "",
        jobTypeNm: "",
        jobTypeCds: "",
        skillId: "",
        skillNm: "",
        skillCds: "",
        positionNm: "",
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
        welfare: "",
        expYears: "",
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
        workingAddress1Pic: "",
        workingAddress2Pic: "",
        workingAddress3Pic: "",
      },

      pickerOptions: {
          disabledDate(time) {
          //如果没有后面的-8.64e7就是不可以选择今天的 
            return time.getTime() < Date.now() - 8.64e7;
         }
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
      
      workingAddress: 0,
      
      isShow: false,
      picurl1: "",
      picurl2: "",
      picurl3: "",
      rules: {
        positionNm: [validateNecessary("職位名")],
        expYears: [validateNecessary("必須経験年数")],
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
        welfare: [validateSelect("福利厚生")],
        trainingFlg: [validateSelect("研修有無")],
        inspectionFlg: [validateSelect("見学有無")],
        conUpdFlg: [validateSelect("契約更新有無")],
        postal1: [validateNecessary("郵便番号")],
        contractSection: [validateNecessary("雇用形態")],
        workDateStr: [validateNecessary("仕事予定開始日")],
        workAddress1: [validateNecessary("住所")],
        workAddress2: [validateNecessary("住所詳細")],
        station: [validateNecessary("最寄駅")],
      },
    };
  },
  mounted() {
    document.title = "職位新規入力";
    this.getIndustryCds();
    this.getJobTypeCds();
    this.getSkillCds();
    this.b0102InForm = JSON.parse(this.$route.query.flight);
    if (this.b0102InForm.workingAddress1Pic) {
      this.picurl1 = "data:image/jpeg;base64," + this.b0102InForm.workingAddress1Pic;
    }
    if (this.b0102InForm.workingAddress2Pic) {
      this.picurl2 = "data:image/jpeg;base64," + this.b0102InForm.workingAddress2Pic;
    }
    if (this.b0102InForm.workingAddress3Pic) {
      this.picurl3 = "data:image/jpeg;base64," + this.b0102InForm.workingAddress3Pic;
    }
    this.setb0102VueForm();
  },
  methods: {
    // 業種取得
    getIndustryCds() {
      this.$store.dispatch("b0102InitIndustry").then((response) => {
        this.$router.push({
          query: { data: response.data.data },
        });
        this.b0102VueForm.industryCds = response.data.data;
        console.log("industryCds", this.b0102VueForm.industryCds);
      });
    },
    // 職種取得
    getJobTypeCds() {
      this.$store.dispatch("b0102InitJobtype").then((response) => {
        this.$router.push({
          query: { data: response.data.data },
        });
        this.b0102VueForm.jobTypeCds = response.data.data;
        console.log("jobtTypeCds", this.b0102VueForm.jobTypeCds);
      });
    },
    //skill取得
    getSkillCds() {
      this.$store.dispatch("b0102InitSkill").then((response) => {
        this.$router.push({
          query: { data: response.data.data },
        });
        this.b0102VueForm.skillCds = response.data.data;
        console.log("skillCds", this.b0102VueForm.skillCds);
      });
    },
    // 住所を取得する
    postalInit(address) {
      this.b0102VueForm.workAddress1 = address;
    },
    // 入力内容数字制限
    numValid(val) {
      this.b0102VueForm[val] = this.b0102VueForm[val].replace(/[^0-9]/g, "");
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

    b0102TelOnBlur($event, endBy = "人") {
      telOnBlur($event, endBy);
    },

    uploadFail() {
      this.$message.error("アップロード失敗");
    },

    handleAvatarSuccesslicense1(res, file) {
      this.$message.success("アップロード成功");
      this.workingAddress1Pic = URL.createObjectURL(file.raw);
      this.b0102VueForm.workingAddress1 = res;
    },

    handleAvatarSuccesslicense2(res, file) {
      this.$message.success("アップロード成功");
      this.workingAddress2Pic = URL.createObjectURL(file.raw);
      this.b0102VueForm.workingAddress2 = res;
    },

    handleAvatarSuccesslicense3(res, file) {
      this.$message.success("アップロード成功");
      this.workingAddress3Pic = URL.createObjectURL(file.raw);
      this.b0102VueForm.workingAddress3 = res;
    },

    beforeUpload(file) {
      const isJPG = file.type === "image/jpeg";
      const isPNG = file.type === "image/png";
      const isLt2M = file.size / 1024 / 1024 < 5;

      if (!isJPG && !isPNG) {
        this.$message.error("画像をアップロードするのはJPGやPNG形式だけです。");
      }
      if (!isLt2M) {
        this.$message.error("アップロード画像のサイズは5MBを超えてはいけません。");
      }
      return (isJPG || isPNG) && isLt2M;
    },

    uploadUrl() {
          return `${this.$store.state.HOST}/B0002/upload`;
        },

    // 情報確認ボタン
    tob0102Confirm() {
      this.b0102VueForm.expDate = new Date(this.b0102VueForm.expDate);
      this.b0102VueForm.workDateStr = new Date(this.b0102VueForm.workDateStr);
      console.log("b0102VueForm:", this.b0102VueForm);
      this.$store
      .dispatch("b0102register", this.b0102VueForm)
      .then((response)=> {
      this.loading = false;
      let code = response.data.code;
      if (code == 200) {
      this.$refs.b0102VueForm.validate((valid) => {
        if (valid) {
          this.$router.push({
            path: "/b0102Confirm",
            query: { flight: JSON.stringify(response.data.data),flight2: JSON.stringify(this.b0102VueForm)  },
          });
        }
      });
      console.log("b0102VueForm000:", this.b0102VueForm);
      }
      else if (code == 404) {
            this.$message.error(response.data.message);
          } else {
            this.$router.push({
              path: "/error",
              query: { message: response.data.message },
            });
          }
      })
      .catch(() => {
          this.loading = false;
        });
    },

    // 戻るボタン
    routerBack() {
      this.$router.replace({ path: "b0003" });
    },
   
    // クリアボタン
    clearForm() {
      this.b0102VueForm.industryId = "",
      this.b0102VueForm.jobTypeId = "",
      this.b0102VueForm.skillId = "",
      this.b0102VueForm.positionNm = "",
      this.b0102VueForm.degree = "",
      this.b0102VueForm.expYears = "",
      this.b0102VueForm.expDate = "",
      this.b0102VueForm.defaultDegree = "",
      this.b0102VueForm.workTimeFrom = "",
      this.b0102VueForm.workTimeTo = "",
      this.b0102VueForm.salarySection = "",
      this.b0102VueForm.positionInt = "",
      this.b0102VueForm.salaryMin = "",
      this.b0102VueForm.salaryMax = "",
      this.b0102VueForm.empLaborIns = "",
      this.b0102VueForm.workContent = "",
      this.b0102VueForm.welfare = "",
      this.b0102VueForm.trainingFlg = "",
      this.b0102VueForm.inspectionFlg = "",
      this.b0102VueForm.conUpdFlg = "",
      this.b0102VueForm.peoCnt = "",
      this.b0102VueForm.workDateStr = "",
      this.b0102VueForm.contractSection = "",
      this.b0102VueForm.holiday = "",
      this.b0102VueForm.postal1 = "",
      this.b0102VueForm.postal2 = "",
      this.b0102VueForm.workAddress1 = "",
      this.b0102VueForm.workAddress2 = "",
      this.b0102VueForm.station = "",
      this.b0102VueForm.workingAddress1 = "",
      this.b0102VueForm.workingAddress2 = "",
      this.b0102VueForm.workingAddress3 = "",
      this.b0102VueForm.workingAddress1Pic = "",
      this.b0102VueForm.workingAddress2Pic = "",
      this.b0102VueForm.workingAddress3Pic = "",
      this.photoAddress = 0;
      this.isShow = false;
    },

    setb0102VueForm() {
        this.b0102VueForm.companyId = this.b0102InForm.companyId;
        this.b0102VueForm.industryId = this.b0102InForm.industryId;
        this.b0102VueForm.jobTypeId = this.b0102InForm.jobTypeId;
        this.b0102VueForm.skillId = this.b0102InForm.skillId;
        this.b0102VueForm.positionNm = this.b0102InForm.positionNm;
        this.b0102VueForm.expDate = this.b0102InForm.expDate;
        this.b0102VueForm.degree = this.b0102InForm.degree;
        this.b0102VueForm.workTimeFrom = this.b0102InForm.workTimeFrom;
        this.b0102VueForm.workTimeTo = this.b0102InForm.workTimeTo;
        this.b0102VueForm.salarySection = this.b0102InForm.salarySection;
        this.b0102VueForm.positionInt = this.b0102InForm.positionInt;
        this.b0102VueForm.salaryMin = this.b0102InForm.salaryMin;
        this.b0102VueForm.salaryMax = this.b0102InForm.salaryMax;
        this.b0102VueForm.empLaborIns = this.b0102InForm.empLaborIns;
        this.b0102VueForm.workContent = this.b0102InForm.workContent;
        this.b0102VueForm.welfare = this.b0102InForm.welfare;
        this.b0102VueForm.expYears = this.b0102InForm.expYears;
        this.b0102VueForm.trainingFlg = this.b0102InForm.trainingFlg;
        this.b0102VueForm.inspectionFlg = this.b0102InForm.inspectionFlg;
        this.b0102VueForm.conUpdFlg = this.b0102InForm.conUpdFlg;
        this.b0102VueForm.peoCnt = this.b0102InForm.peoCnt;
        this.b0102VueForm.workDateStr = this.b0102InForm.workDateStr;
        this.b0102VueForm.contractSection = this.b0102InForm.contractSection;
        this.b0102VueForm.holiday = this.b0102InForm.holiday;
        this.b0102VueForm.postal1 = this.b0102InForm.postal1;
        this.b0102VueForm.postal2 = this.b0102InForm.postal2;
        this.b0102VueForm.workAddress1 = this.b0102InForm.workAddress1;
        this.b0102VueForm.workAddress2 = this.b0102InForm.workAddress2;
        this.b0102VueForm.station = this.b0102InForm.station;
        this.b0102VueForm.workingAddress1 = this.b0102InForm.workingAddress1;
        this.b0102VueForm.workingAddress2 = this.b0102InForm.workingAddress2;
        this.b0102VueForm.workingAddress3 = this.b0102InForm.workingAddress3;
        this.b0102VueForm.workingAddress1Pic = this.b0102InForm.workingAddress1Pic;
        this.b0102VueForm.workingAddress2Pic = this.b0102InForm.workingAddress2Pic;
        this.b0102VueForm.workingAddress3Pic = this.b0102InForm.workingAddress3Pic;
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
