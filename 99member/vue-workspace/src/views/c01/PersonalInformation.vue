<template>
  <el-card class="card-style">
    <el-collapse
      v-model="collapseIsActive"
      name="personalInformation"
      value="personalInformation"
      @change="collapseChange"
    >
      <el-collapse-item name="personalInformation" :title="name">
        <el-form
          ref="applicantInfoTblBean"
          :model="applicantInfoTblBean"
          :rules="rules"
          label-width="8vw"
        >
          <el-row class="avatar-row">
            <el-col :span="11">
              <el-form-item>
                <el-upload
                  list-type="picture-card"
                  v-model="applicantInfoTblBean.photo"
                  :multiple="false"
                  :action="uploadURL"
                  :accept="uploadParameter.uploadType"
                  :before-upload="pictureSize"
                  :on-success="uploadSuccess"
                  :on-error="uploadFailed"
                  :on-remove="handleRemove"
                  :on-exceed="uploadExceed"
                  :file-list="uploadParameter.fileList"
                  :limit="1"
                  :class="{
                    uploadDisabled: noneAvatar,
                  }"
                >
                  <el-image
                    v-show="photoIsNull"
                    :src="applicantInfoTblBean.photoPic"
                    fit="contain"
                  >
                    <div slot="error" class="image-slot">
                      <el-avatar shape="square" :size="130" icon="el-icon-user-solid" />
                    </div>
                  </el-image>
                </el-upload>
              </el-form-item>
            </el-col>
            <el-col :span="11" :offset="2">
              <el-row>
                <el-col :span="8" :offset="16" v-if="flgData == '1'">
                  <el-tooltip
                    :content="promptMessage.insertButton"
                    effect="light"
                    placement="top-end"
                    :open-delay="400"
                  >
                    <el-button type="primary" @click="insertData" circle>
                      <em class="el-icon-upload2" />
                    </el-button>
                  </el-tooltip>
                </el-col>
                <el-col :span="8" :offset="16" v-else>
                  <el-tooltip
                    :content="promptMessage.saveButton"
                    effect="light"
                    placement="top-end"
                    :open-delay="400"
                  >
                    <el-button type="primary" @click="saveData" class="save-image" circle>
                      <el-image :src="require('@/assets/save-icon.svg')" />
                    </el-button>
                  </el-tooltip>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="24" class="user-name-style">
                  {{ userName }}
                </el-col>
              </el-row>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="10" :offset="1">
              <el-form-item prop="countryId" :label="labelName.countryId">
                <el-select v-model="applicantInfoTblBean.countryId" clearable>
                  <el-option
                    v-for="countryIdItem in countryMstBean"
                    :key="countryIdItem.countryId"
                    :label="countryIdItem.countryNm"
                    :value="countryIdItem.countryId"
                  />
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="11" :offset="1">
              <el-form-item prop="birthday" :label="labelName.birthday">
                <el-date-picker
                  v-model="applicantInfoTblBean.birthday"
                  :picker-options="pickerOptions"
                  :placeholder="labelName.birthday"
                  format="yyyy-MM-dd"
                  type="date"
                />
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="9" :offset="1">
              <el-form-item :label="labelName.applicantPostal" required>
                <el-form ref="postalCode" :model="postalCode" :rules="rules">
                  <el-col :span="11">
                    <!-- TODO:輸入満了の場合、自動的に次の欄に移動する -->
                    <el-form-item prop="postal1">
                      <el-input
                        v-model="postalCode.postal1"
                        @input="postalNumValid('postal1')"
                        maxlength="3"
                        class="half-input-style"
                        clearable
                      />
                    </el-form-item>
                  </el-col>
                  <el-col :span="1">
                    <span>-</span>
                  </el-col>
                  <el-col :span="12">
                    <el-form-item prop="postal2">
                      <el-input
                        v-model="postalCode.postal2"
                        @input="postalNumValid('postal2')"
                        maxlength="4"
                        @keyup.enter.native="searchPostal"
                        class="half-input-style"
                        clearable
                      />
                    </el-form-item>
                  </el-col>
                </el-form>
              </el-form-item>
            </el-col>
            <el-col :span="1">
              <SearchPostal
                ref="searchPostal"
                @parentMethod="getAddress"
                :postal1="postalCode.postal1"
                :postal2="postalCode.postal2"
              />
            </el-col>
            <!-- TODO: 新規の場合、自動的に輸入できない -->
            <el-col :span="10" :offset="1">
              <el-form-item prop="address1" :label="labelName.address1">
                <el-tooltip
                  :content="promptMessage.address1"
                  effect="light"
                  placement="top-end"
                  :open-delay="400"
                >
                  <span @click="address1Prompt">
                    <el-input
                      v-model.trim="applicantInfoTblBean.address1"
                      :placeholder="promptMessage.address1"
                      maxlength="200"
                      disabled
                    />
                  </span>
                </el-tooltip>
              </el-form-item>
            </el-col>
            <el-col :span="1">
              <el-tooltip
                :content="promptMessage.clearAddress1"
                effect="light"
                placement="right"
                :open-delay="400"
              >
                <span>
                  <el-button
                    type="primary"
                    icon="el-icon-delete"
                    @click="clearAddress1"
                    v-show="!addressButtonDisabled"
                    :disabled="addressButtonDisabled"
                    circle
                  />
                </span>
              </el-tooltip>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="10" :offset="1">
              <el-form-item prop="station" :label="labelName.station">
                <el-input
                  v-model.trim="applicantInfoTblBean.station"
                  :placeholder="labelName.station"
                  maxlength="30"
                  clearable
                >
                  <span slot="suffix" v-text="labelName.stationUnit" />
                </el-input>
              </el-form-item>
            </el-col>
            <el-col :span="11" :offset="1">
              <el-form-item prop="address2" :label="labelName.address2">
                <el-input
                  v-model="applicantInfoTblBean.address2"
                  :placeholder="labelName.address2"
                  maxlength="200"
                  show-word-limit
                  clearable
                />
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="10" :offset="1">
              <el-form-item prop="graduationSchool" :label="labelName.graduationSchool">
                <el-input
                  v-model.trim="applicantInfoTblBean.graduationSchool"
                  :placeholder="labelName.graduationSchool"
                  maxlength="50"
                  show-word-limit
                  clearable
                />
              </el-form-item>
            </el-col>
            <el-col :span="11" :offset="1">
              <el-form-item prop="graduationMajor" :label="labelName.graduationMajor">
                <el-input
                  v-model.trim="applicantInfoTblBean.graduationMajor"
                  :placeholder="labelName.graduationMajor"
                  maxlength="50"
                  show-word-limit
                  clearable
                />
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="10" :offset="1">
              <el-form-item prop="finalEducation" :label="labelName.finalEducation">
                <el-select v-model="applicantInfoTblBean.finalEducation" clearable>
                  <el-option
                    v-for="(finalEducationItem, index) in finalEducation"
                    :key="`finalEducation-${index}`"
                    :label="finalEducationItem.label"
                    :value="finalEducationItem.value"
                  />
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="11" :offset="1">
              <el-form-item prop="workYears" :label="labelName.workYears">
                <el-input
                  v-model="applicantInfoTblBean.workYears"
                  :placeholder="labelName.workYears"
                  @input="moneyValid('workYears')"
                  maxlength="2"
                  clearable
                >
                  <span slot="suffix" v-text="labelName.year" />
                </el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="10" :offset="1">
              <el-form-item :label="labelName.hopeSalary" required>
                <el-col :span="11">
                  <el-form-item prop="hopeSalaryFrom">
                    <el-input
                      v-model="applicantInfoTblBean.hopeSalaryFrom"
                      @input="moneyValid('hopeSalaryFrom')"
                      @blur="salaryFromBlur"
                      maxlength="4"
                      class="half-input-style"
                      clearable
                    >
                      <span slot="suffix" v-text="labelName.salaryUnit" />
                    </el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="1">
                  <span>-</span>
                </el-col>
                <el-col :span="12">
                  <el-form-item prop="hopeSalaryTo">
                    <el-input
                      v-model="applicantInfoTblBean.hopeSalaryTo"
                      @input="moneyValid('hopeSalaryTo')"
                      @blur="salaryToBlur"
                      maxlength="4"
                      class="half-input-style"
                      clearable
                    >
                      <span slot="suffix" v-text="labelName.salaryUnit" />
                    </el-input>
                  </el-form-item>
                </el-col>
              </el-form-item>
            </el-col>
            <el-col :span="11" :offset="1">
              <el-form-item prop="workSituation" :label="labelName.workSituation">
                <el-switch
                  v-model="applicantInfoTblBean.workSituation"
                  :active-text="labelName.workSituation2"
                  :inactive-text="labelName.workSituation1"
                  inactive-value="0"
                  active-value="1"
                />
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="9" :offset="1">
              <!-- 新規の場合、選択後、データ更新は遅延 -->
              <el-form-item prop="industryId1" :label="labelName.industryId">
                <el-select
                  v-model="applicantInfoTblBean.industryId1"
                  @change="clearJobType"
                  clearable
                >
                  <el-option
                    v-for="(industryTypeItem, index) in industryId1Computed"
                    :key="`industryType-${index}`"
                    :label="industryTypeItem.industryNm"
                    :value="industryTypeItem.industryId"
                  />
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="1">
              <el-tooltip
                :content="promptMessage.addIndustryType"
                placement="top-start"
                effect="light"
                :open-delay="400"
              >
                <span>
                  <el-button
                    type="primary"
                    icon="el-icon-plus"
                    @click="addIndustryType"
                    :disabled="industryTypeShow == 2"
                    circle
                  />
                </span>
              </el-tooltip>
            </el-col>
            <el-col :span="10" :offset="1">
              <el-form-item prop="jobtypeId1_1" :label="labelName.jobtypeId">
                <el-select
                  v-model="applicantInfoTblBean.jobtypeId1_1"
                  :no-data-text="promptMessage.jobTypeNoData"
                  clearable
                >
                  <el-option
                    v-for="(jobType1ComputedItem, index) in jobType1_1Computed"
                    :key="`jobType1_1Computed-${index}`"
                    :label="jobType1ComputedItem.jobtypeNm"
                    :value="jobType1ComputedItem.jobtypeId"
                  />
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="1">
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
                    v-show="jobTypeShow != 2"
                    :disabled="jobTypeShow == 2"
                    circle
                  />
                </span>
              </el-tooltip>
            </el-col>
          </el-row>
          <el-row>
            <el-col
              :span="10"
              :offset="12"
              v-show="
                (jobTypeShow > 0 && applicantInfoTblBean.jobtypeId1_1 != '') ||
                jobTypeShow > 1
              "
            >
              <el-form-item prop="jobtypeId1_2" :label="labelName.jobtypeId2">
                <el-select
                  v-model="applicantInfoTblBean.jobtypeId1_2"
                  :no-data-text="promptMessage.jobTypeNoData"
                  clearable
                >
                  <el-option
                    v-for="(jobType1ComputedItem, index) in jobType1_2Computed"
                    :key="`jobType1_2Computed-${index}`"
                    :label="jobType1ComputedItem.jobtypeNm"
                    :value="jobType1ComputedItem.jobtypeId"
                  />
                </el-select>
              </el-form-item>
            </el-col>
            <el-col
              :span="1"
              v-show="
                (jobTypeShow > 0 && applicantInfoTblBean.jobtypeId1_1 != '') ||
                jobTypeShow > 1
              "
            >
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
                    v-show="jobTypeShow != 0"
                    :disabled="jobTypeShow == 0"
                    circle
                  />
                </span>
              </el-tooltip>
            </el-col>
          </el-row>
          <el-row>
            <el-col
              :span="10"
              :offset="12"
              v-show="
                (jobTypeShow > 1 && applicantInfoTblBean.jobtypeId1_2 != '') ||
                jobTypeShow == 2
              "
            >
              <el-form-item prop="jobtypeId1_3" :label="labelName.jobtypeId3">
                <el-select
                  v-model="applicantInfoTblBean.jobtypeId1_3"
                  :no-data-text="promptMessage.jobTypeNoData"
                  clearable
                >
                  <el-option
                    v-for="(jobType1ComputedItem, index) in jobType1_3Computed"
                    :key="`jobType1_3Computed-${index}`"
                    :label="jobType1ComputedItem.jobtypeNm"
                    :value="jobType1ComputedItem.jobtypeId"
                  />
                </el-select>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row v-show="industryTypeShow > 0">
            <el-col :span="9" :offset="1">
              <el-form-item prop="industryId2" :label="labelName.industryId2">
                <el-select
                  v-model="applicantInfoTblBean.industryId2"
                  @change="clearJobType2"
                  clearable
                >
                  <el-option
                    v-for="(industryTypeItem, index) in industryId2Computed"
                    :key="`industryType2-${index}`"
                    :label="industryTypeItem.industryNm"
                    :value="industryTypeItem.industryId"
                  />
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="1">
              <el-tooltip
                :content="promptMessage.minusIndustryType"
                placement="top-start"
                effect="light"
                :open-delay="400"
              >
                <span>
                  <el-button
                    type="primary"
                    icon="el-icon-minus"
                    @click="minusIndustryType"
                    v-show="industryTypeShow > 0"
                    :disabled="industryTypeShow == 0"
                    circle
                  />
                </span>
              </el-tooltip>
            </el-col>
            <el-col :span="10" :offset="1">
              <el-form-item prop="jobtypeId2_1" :label="labelName.jobtypeId2_1">
                <el-select
                  v-model="applicantInfoTblBean.jobtypeId2_1"
                  :no-data-text="promptMessage.jobType2NoData"
                  clearable
                >
                  <el-option
                    v-for="(jobType2ComputedItem, index) in jobType2_1Computed"
                    :key="`jobType2_1Computed-${index}`"
                    :label="jobType2ComputedItem.jobtypeNm"
                    :value="jobType2ComputedItem.jobtypeId"
                  />
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="1">
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
                    @click="addJobType2"
                    v-show="jobType2Show < 2"
                    :disabled="jobType2Show == 2"
                    circle
                  />
                </span>
              </el-tooltip>
            </el-col>
          </el-row>
          <el-row>
            <el-col
              :span="10"
              :offset="12"
              v-show="industryTypeShow > 0 && jobType2Show > 0"
            >
              <el-form-item prop="jobtypeId2_2" :label="labelName.jobtypeId2_2">
                <el-select
                  v-model="applicantInfoTblBean.jobtypeId2_2"
                  :no-data-text="promptMessage.jobType2NoData"
                  clearable
                >
                  <el-option
                    v-for="(jobType2ComputedItem, index) in jobType2_2Computed"
                    :key="`jobType2_2Computed-${index}`"
                    :label="jobType2ComputedItem.jobtypeNm"
                    :value="jobType2ComputedItem.jobtypeId"
                  />
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="1" v-show="industryTypeShow > 0 && jobType2Show > 0">
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
                    @click="minusJobType2"
                    v-show="jobType2Show > 0"
                    :disabled="jobType2Show == 0"
                    circle
                  />
                </span>
              </el-tooltip>
            </el-col>
          </el-row>
          <el-row>
            <el-col
              :span="10"
              :offset="12"
              v-show="
                (industryTypeShow > 0 &&
                  jobType2Show > 1 &&
                  applicantInfoTblBean.jobtypeId2_2 != '') ||
                (industryTypeShow > 0 && jobType2Show == 2)
              "
            >
              <el-form-item prop="jobtypeId2_3" :label="labelName.jobtypeId2_3">
                <el-select
                  v-model="applicantInfoTblBean.jobtypeId2_3"
                  :no-data-text="promptMessage.jobType2NoData"
                  clearable
                >
                  <el-option
                    v-for="(jobType2ComputedItem, index) in jobType2_3Computed"
                    :key="`jobType2_3Computed-${index}`"
                    :label="jobType2ComputedItem.jobtypeNm"
                    :value="jobType2ComputedItem.jobtypeId"
                  />
                </el-select>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row v-show="industryTypeShow > 1">
            <el-col :span="9" :offset="1">
              <el-form-item prop="industryId3" :label="labelName.industryId3">
                <el-select
                  v-model="applicantInfoTblBean.industryId3"
                  @change="clearJobType3"
                  clearable
                >
                  <el-option
                    v-for="(industryTypeItem, index) in industryId3Computed"
                    :key="`industryType3-${index}`"
                    :label="industryTypeItem.industryNm"
                    :value="industryTypeItem.industryId"
                  />
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="1">
              <el-tooltip
                :content="promptMessage.minusIndustryType"
                placement="top-start"
                effect="light"
                :open-delay="400"
              >
                <span>
                  <el-button
                    type="primary"
                    icon="el-icon-minus"
                    @click="minusIndustryType"
                    v-show="industryTypeShow > 0"
                    :disabled="industryTypeShow == 0"
                    circle
                  />
                </span>
              </el-tooltip>
            </el-col>
            <el-col :span="10" :offset="1" v-show="industryTypeShow > 1">
              <el-form-item prop="jobtypeId3_1" :label="labelName.jobtypeId3_1">
                <el-select
                  v-model="applicantInfoTblBean.jobtypeId3_1"
                  :no-data-text="promptMessage.jobType3NoData"
                  clearable
                >
                  <el-option
                    v-for="(jobType3ComputedItem, index) in jobType3_1Computed"
                    :key="`jobType3_1Computed-${index}`"
                    :label="jobType3ComputedItem.jobtypeNm"
                    :value="jobType3ComputedItem.jobtypeId"
                  />
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="1" v-show="industryTypeShow > 1">
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
                    @click="addJobType3"
                    v-show="jobType3Show < 2"
                    :disabled="jobType3Show == 2"
                    circle
                  />
                </span>
              </el-tooltip>
            </el-col>
          </el-row>
          <el-row>
            <el-col
              :span="10"
              :offset="12"
              v-show="industryTypeShow > 1 && jobType3Show > 0"
            >
              <el-form-item prop="jobtypeId3_2" :label="labelName.jobtypeId3_2">
                <el-select
                  v-model="applicantInfoTblBean.jobtypeId3_2"
                  :no-data-text="promptMessage.jobType3NoData"
                  clearable
                >
                  <el-option
                    v-for="(jobType3ComputedItem, index) in jobType3_2Computed"
                    :key="`jobType3_2Computed-${index}`"
                    :label="jobType3ComputedItem.jobtypeNm"
                    :value="jobType3ComputedItem.jobtypeId"
                  />
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="1" v-show="industryTypeShow > 1 && jobType3Show > 0">
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
                    @click="minusJobType3"
                    v-show="jobType3Show > 0"
                    :disabled="jobType3Show == 0"
                    circle
                  />
                </span>
              </el-tooltip>
            </el-col>
          </el-row>
          <el-row>
            <el-col
              :span="10"
              :offset="12"
              v-show="
                (industryTypeShow > 1 &&
                  jobType3Show > 1 &&
                  applicantInfoTblBean.jobtypeId3_2 != '') ||
                (industryTypeShow == 2 && jobType3Show == 2)
              "
            >
              <el-form-item prop="jobtypeId3_3" :label="labelName.jobtypeId3_3">
                <el-select
                  v-model="applicantInfoTblBean.jobtypeId3_3"
                  :no-data-text="promptMessage.jobType3NoData"
                  clearable
                >
                  <el-option
                    v-for="(jobType3ComputedItem, index) in jobType3_3Computed"
                    :key="`jobType3_3Computed-${index}`"
                    :label="jobType3ComputedItem.jobtypeNm"
                    :value="jobType3ComputedItem.jobtypeId"
                  />
                </el-select>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="9" :offset="1">
              <el-form-item prop="hopeLand1" :label="labelName.hopeLand">
                <el-select v-model="applicantInfoTblBean.hopeLand1" clearable>
                  <el-option
                    v-for="(hopeLandItem, index) in hopeLand1Computed"
                    :key="`hopeLand-${index}`"
                    :label="hopeLandItem.prefeNm"
                    :value="hopeLandItem.prefeId"
                  />
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="3" v-show="applicantInfoTblBean.hopeLand1 != ''">
              <el-tooltip
                :content="promptMessage.addHopeLand"
                placement="top-start"
                effect="light"
                :open-delay="400"
              >
                <span>
                  <el-button
                    type="primary"
                    icon="el-icon-plus"
                    @click="addHopeLand"
                    v-show="hopeLandShow < 2"
                    :disabled="hopeLandShow == 2"
                    circle
                  />
                </span>
              </el-tooltip>
            </el-col>
          </el-row>
          <el-row>
            <el-col
              :span="9"
              :offset="1"
              v-show="hopeLandShow > 0 && applicantInfoTblBean.hopeLand1 != ''"
            >
              <el-form-item prop="hopeLand2" :label="labelName.hopeLand2">
                <el-select v-model="applicantInfoTblBean.hopeLand2" clearable>
                  <el-option
                    v-for="(hopeLandItem, index) in hopeLand2Computed"
                    :key="`hopeLand2-${index}`"
                    :label="hopeLandItem.prefeNm"
                    :value="hopeLandItem.prefeId"
                  />
                </el-select>
              </el-form-item>
            </el-col>
            <el-col
              :span="1"
              v-show="
                (hopeLandShow > 0 && applicantInfoTblBean.hopeLand1 != '') ||
                hopeLandShow == 1
              "
            >
              <el-tooltip
                :content="promptMessage.minusHopeLand"
                placement="bottom-start"
                effect="light"
                :open-delay="400"
              >
                <span>
                  <el-button
                    type="primary"
                    icon="el-icon-minus"
                    @click="minusHopeLand"
                    v-show="hopeLandShow != 0"
                    :disabled="hopeLandShow == 0"
                    circle
                  />
                </span>
              </el-tooltip>
            </el-col>
            <el-col
              :span="10"
              :offset="1"
              v-show="
                (hopeLandShow > 1 && applicantInfoTblBean.hopeLand2 != '') ||
                hopeLandShow == 2
              "
            >
              <el-form-item prop="hopeLand3" :label="labelName.hopeLand3">
                <el-select v-model="applicantInfoTblBean.hopeLand3" clearable>
                  <el-option
                    v-for="(hopeLandItem, index) in hopeLand3Computed"
                    :key="`hopeLand3-${index}`"
                    :label="hopeLandItem.prefeNm"
                    :value="hopeLandItem.prefeId"
                  />
                </el-select>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="10" :offset="1">
              <el-form-item prop="interest" :label="labelName.interest">
                <el-input
                  v-model.trim="applicantInfoTblBean.interest"
                  :placeholder="labelName.interest"
                  maxlength="100"
                  show-word-limit
                  clearable
                />
              </el-form-item>
            </el-col>
            <el-col :span="10" :offset="1">
              <el-form-item prop="specialty" :label="labelName.specialty">
                <el-input
                  v-model.trim="applicantInfoTblBean.specialty"
                  :placeholder="labelName.specialty"
                  maxlength="200"
                  show-word-limit
                  clearable
                />
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="21" :offset="1">
              <el-form-item prop="reason" :label="labelName.reason">
                <el-input
                  type="textarea"
                  v-model="applicantInfoTblBean.reason"
                  :placeholder="labelName.reason"
                  maxlength="500"
                  show-word-limit
                  :autosize="{ minRows: 2 }"
                  clearable
                />
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="21" :offset="1">
              <el-form-item prop="introduce" :label="labelName.introduce">
                <el-input
                  type="textarea"
                  v-model="applicantInfoTblBean.introduce"
                  :placeholder="labelName.introduce"
                  maxlength="1000"
                  show-word-limit
                  :autosize="{ minRows: 2 }"
                  clearable
                />
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="21" :offset="1">
              <el-form-item prop="remarks" :label="labelName.remarks">
                <el-input
                  type="textarea"
                  v-model="applicantInfoTblBean.remarks"
                  :placeholder="labelName.remarks"
                  maxlength="400"
                  show-word-limit
                  :autosize="{ minRows: 2 }"
                  clearable
                />
              </el-form-item>
            </el-col>
          </el-row>
        </el-form>
      </el-collapse-item>
    </el-collapse>
  </el-card>
</template>
<script>
// 内容チェック機能導入
import { validateNecessary, validateSelect } from "@/utils/validate";
// 郵便番号検索機能導入
import SearchPostal from "@/views/components/SearchPostal";
export default {
  name: "c010101",
  components: {
    SearchPostal,
  },
  mounted() {
    // 初期増加内容の有無の判断
    this.initShow();
  },
  data() {
    return {
      name: "個人情報",
      rules: {
        countryId: [validateSelect("国籍")],
        birthday: [validateNecessary("生年月日")],
        postal1: [validateNecessary("上3桁")],
        postal2: [validateNecessary("下4桁")],
        address1: [validateNecessary("住所")],
        address2: [validateNecessary("詳細住所")],
        station: [validateNecessary("最寄駅")],
        graduationSchool: [validateNecessary("卒業学校")],
        graduationMajor: [validateNecessary("専攻")],
        finalEducation: [validateSelect("最終学歴")],
        workYears: [validateNecessary("仕事経験")],
        hopeSalaryFrom: [validateNecessary("下限")],
        industryId1: [validateSelect("業種")],
        jobtypeId1_1: [validateSelect("職種")],
        hopeLand1: [validateSelect("希望勤務地")],
      },
      pickerOptions: {
        // 日付は今日以前しか選択可能
        disabledDate: (birthday) => {
          return birthday.getTime() > Date.now();
        },
      },
      // 初期collapse展開
      collapseIsActive: ["", "personalInformation"],
      // フォームラベルの名前
      labelName: {
        countryId: "国籍",
        birthday: "生年月日",
        applicantPostal: "郵便番号",
        address1: "住所",
        address2: "詳細住所",
        station: "最寄駅",
        stationUnit: "駅",
        industryId: "業種",
        industryId2: "業種2",
        industryId3: "業種3",
        jobtypeId: "職種",
        jobtypeId2: "職種",
        jobtypeId3: "職種",
        jobtypeId2_1: "職種",
        jobtypeId2_2: "職種",
        jobtypeId2_3: "職種",
        jobtypeId3_1: "職種",
        jobtypeId3_2: "職種",
        jobtypeId3_3: "職種",
        hopeLand: "希望勤務地",
        hopeLand2: "希望勤務地2",
        hopeLand3: "希望勤務地3",
        graduationSchool: "卒業学校",
        graduationMajor: "専攻",
        finalEducation: "最終学歴",
        workYears: "仕事経験",
        year: "年",
        hopeSalary: "希望月給",
        hopeSalaryFrom: "希望下限",
        salaryUnit: "万円",
        hopeSalaryTo: "希望上限",
        workSituation: "仕事状況",
        workSituation1: "就活中",
        workSituation2: "在職中",
        specialty: "特技",
        reason: "志望理由",
        introduce: "アピール",
        interest: "趣味",
        remarks: "備考",
      },
      // 写真アップロードのパラメータ
      uploadParameter: {
        uploadType: "image/jpeg,image/jpg,image/png,image/svg",
        fileList: [],
      },
      // 提示用メッセージ
      promptMessage: {
        saveButton: "内容を保存",
        insertButton: "内容を登録",
        avatarSize: "10MB以下の画像をアップロードしてください",
        uploadSuccess: "アップロード成功",
        uploadFailed: "アップロード失敗",
        uploadExceed: "最大一枚の写真をアップロードしてください",
        address1: "入力された郵便番号に応じて取得",
        clearAddress1: "住所の内容をクリア",
        addJobType: "職種を増加",
        minusJobType: "職種を減少",
        addIndustryType: "業種を増加",
        minusIndustryType: "業種を減少",
        addHopeLand: "希望勤務地を増加",
        minusHopeLand: "希望勤務地を減少",
        successMessage: "保存が成功しました",
        failedMessage: "保存が失敗しました",
        nullMessage: "未入力必須項目があります",
        postalCheck: "郵便番号数が不足しています",
        jobTypeNoData: "業種を選択後、データを取得できます",
        jobType2NoData: "業種2を選択後、データを取得できます",
        jobType3NoData: "業種3を選択後、データを取得できます",
        salaryFromLessThanTo: "給与下限は給与上限よりも低くなければなりません",
        serverProblem: "サーバーで問題が発生しました",
      },
      //アバターボタン表示用
      noneAvatar: false,
      //最終学歴
      finalEducation: [
        { value: "1", label: "職業訓練校、予備校" },
        { value: "2", label: "専門学校" },
        { value: "3", label: "短期大学" },
        { value: "4", label: "大学" },
        { value: "5", label: "大学院（修士）" },
        { value: "6", label: "大学院（博士）" },
        { value: "0", label: "その他" },
      ],
      // 職種表示用
      jobTypeShow: 0,
      jobType2Show: 0,
      jobType3Show: 0,
      // 業種表示用
      industryTypeShow: 0,
      // 希望勤務地表示用
      hopeLandShow: 0,
    };
  },
  props: {
    // 個人情報
    applicantInfoTblBean: {},
    // 国籍
    countryMstBean: {},
    // 業種
    industryMstBean: {},
    // 職種
    jobtypeMstBean: {},
    // 希望地
    prefecturesMstBean: {},
    // 郵便番号
    postalCode: {
      postal1: "",
      postal2: "",
    },
    // 個人情報初期または修正の判断
    flgData: {},
  },
  watch: {
    // 全角数字を半角に変換の処理
    "postalCode.postal1": function (v) {
      this.postalCode.postal1 = v.replace(/[０-９]/g, (s) => {
        return String.fromCharCode(s.charCodeAt(0) - 65248);
      });
    },
    "postalCode.postal2": function (v) {
      this.postalCode.postal2 = v.replace(/[０-９]/g, (s) => {
        return String.fromCharCode(s.charCodeAt(0) - 65248);
      });
    },
    "applicantInfoTblBean.workYears": function (v) {
      this.applicantInfoTblBean.workYears = v.replace(/[０-９]/g, (s) => {
        return String.fromCharCode(s.charCodeAt(0) - 65248);
      });
    },
    "applicantInfoTblBean.hopeSalaryFrom": function (v) {
      this.applicantInfoTblBean.hopeSalaryFrom = v.replace(/[０-９]/g, (s) => {
        return String.fromCharCode(s.charCodeAt(0) - 65248);
      });
    },
    "applicantInfoTblBean.hopeSalaryTo": function (v) {
      this.applicantInfoTblBean.hopeSalaryTo = v.replace(/[０-９]/g, (s) => {
        return String.fromCharCode(s.charCodeAt(0) - 65248);
      });
    },
    "applicantInfoTblBean.address2": function (v) {
      // 半角を全角に変換の処理
      this.applicantInfoTblBean.address2 = v.replace(/[A-Z a-z 0-9]/g, (s) => {
        return String.fromCharCode(s.charCodeAt(0) + 65248);
      });
    },
    "applicantInfoTblBean.industryId1": function () {
      if (this.applicantInfoTblBean.industryId1 == "") {
        this.applicantInfoTblBean.industryId1 = this.applicantInfoTblBean.industryId2;
        this.applicantInfoTblBean.jobtypeId1_1 = this.applicantInfoTblBean.jobtypeId2_1;
        this.applicantInfoTblBean.jobtypeId1_2 = this.applicantInfoTblBean.jobtypeId2_2;
        this.applicantInfoTblBean.jobtypeId1_3 = this.applicantInfoTblBean.jobtypeId2_3;
        this.applicantInfoTblBean.industryId2 = "";
        this.applicantInfoTblBean.jobtypeId2_1 = "";
        this.applicantInfoTblBean.jobtypeId2_2 = "";
        this.applicantInfoTblBean.jobtypeId2_3 = "";
      }
    },
    "applicantInfoTblBean.industryId2": function () {
      if (this.applicantInfoTblBean.industryId1 == "") {
        this.applicantInfoTblBean.industryId1 = this.applicantInfoTblBean.industryId2;
        this.applicantInfoTblBean.jobtypeId1_1 = this.applicantInfoTblBean.jobtypeId2_1;
        this.applicantInfoTblBean.jobtypeId1_2 = this.applicantInfoTblBean.jobtypeId2_2;
        this.applicantInfoTblBean.jobtypeId1_3 = this.applicantInfoTblBean.jobtypeId2_3;
        this.applicantInfoTblBean.industryId2 = "";
        this.applicantInfoTblBean.jobtypeId2_1 = "";
        this.applicantInfoTblBean.jobtypeId2_2 = "";
        this.applicantInfoTblBean.jobtypeId2_3 = "";
      }
      if (this.applicantInfoTblBean.industryId2 == "") {
        this.applicantInfoTblBean.industryId2 = this.applicantInfoTblBean.industryId3;
        this.applicantInfoTblBean.jobtypeId2_1 = this.applicantInfoTblBean.jobtypeId3_1;
        this.applicantInfoTblBean.jobtypeId2_2 = this.applicantInfoTblBean.jobtypeId3_2;
        this.applicantInfoTblBean.jobtypeId2_3 = this.applicantInfoTblBean.jobtypeId3_3;
        this.applicantInfoTblBean.industryId3 = "";
        this.applicantInfoTblBean.jobtypeId3_1 = "";
        this.applicantInfoTblBean.jobtypeId3_2 = "";
        this.applicantInfoTblBean.jobtypeId3_3 = "";
      }
    },
    "applicantInfoTblBean.industryId3": function () {
      if (this.applicantInfoTblBean.industryId2 == "") {
        this.applicantInfoTblBean.industryId2 = this.applicantInfoTblBean.industryId3;
        this.applicantInfoTblBean.jobtypeId2_1 = this.applicantInfoTblBean.jobtypeId3_1;
        this.applicantInfoTblBean.jobtypeId2_2 = this.applicantInfoTblBean.jobtypeId3_2;
        this.applicantInfoTblBean.jobtypeId2_3 = this.applicantInfoTblBean.jobtypeId3_3;
        this.applicantInfoTblBean.industryId3 = "";
        this.applicantInfoTblBean.jobtypeId3_1 = "";
        this.applicantInfoTblBean.jobtypeId3_2 = "";
        this.applicantInfoTblBean.jobtypeId3_3 = "";
      }
    },
    "applicantInfoTblBean.jobtypeId1_1": function () {
      if (this.applicantInfoTblBean.jobtypeId1_1 == "") {
        this.applicantInfoTblBean.jobtypeId1_1 = this.applicantInfoTblBean.jobtypeId1_2;
        this.applicantInfoTblBean.jobtypeId1_2 = this.applicantInfoTblBean.jobtypeId1_3;
        this.applicantInfoTblBean.jobtypeId1_3 = "";
      }
    },
    "applicantInfoTblBean.jobtypeId1_2": function () {
      if (this.applicantInfoTblBean.jobtypeId1_1 == "") {
        this.applicantInfoTblBean.jobtypeId1_1 = this.applicantInfoTblBean.jobtypeId1_2;
        this.applicantInfoTblBean.jobtypeId1_2 = "";
      }
      if (this.applicantInfoTblBean.jobtypeId1_2 == "") {
        this.applicantInfoTblBean.jobtypeId1_2 = this.applicantInfoTblBean.jobtypeId1_3;
        this.applicantInfoTblBean.jobtypeId1_3 = "";
      }
    },
    "applicantInfoTblBean.jobtypeId1_3": function () {
      if (this.applicantInfoTblBean.jobtypeId1_2 == "") {
        this.applicantInfoTblBean.jobtypeId1_2 = this.applicantInfoTblBean.jobtypeId1_3;
        this.applicantInfoTblBean.jobtypeId1_3 = "";
      }
    },
    "applicantInfoTblBean.jobtypeId2_1": function () {
      if (this.applicantInfoTblBean.jobtypeId2_1 == "") {
        this.applicantInfoTblBean.jobtypeId2_1 = this.applicantInfoTblBean.jobtypeId2_2;
        this.applicantInfoTblBean.jobtypeId2_2 = this.applicantInfoTblBean.jobtypeId2_3;
        this.applicantInfoTblBean.jobtypeId2_3 = "";
      }
    },
    "applicantInfoTblBean.jobtypeId2_2": function () {
      if (this.applicantInfoTblBean.jobtypeId2_1 == "") {
        this.applicantInfoTblBean.jobtypeId2_1 = this.applicantInfoTblBean.jobtypeId2_2;
        this.applicantInfoTblBean.jobtypeId2_2 = "";
      }
      if (this.applicantInfoTblBean.jobtypeId2_2 == "") {
        this.applicantInfoTblBean.jobtypeId2_2 = this.applicantInfoTblBean.jobtypeId2_3;
        this.applicantInfoTblBean.jobtypeId2_3 = "";
      }
    },
    "applicantInfoTblBean.jobtypeId2_3": function () {
      if (this.applicantInfoTblBean.jobtypeId2_2 == "") {
        this.applicantInfoTblBean.jobtypeId2_2 = this.applicantInfoTblBean.jobtypeId2_3;
        this.applicantInfoTblBean.jobtypeId2_3 = "";
      }
    },
    "applicantInfoTblBean.jobtypeId3_1": function () {
      if (this.applicantInfoTblBean.jobtypeId3_1 == "") {
        this.applicantInfoTblBean.jobtypeId3_1 = this.applicantInfoTblBean.jobtypeId3_2;
        this.applicantInfoTblBean.jobtypeId3_2 = this.applicantInfoTblBean.jobtypeId3_3;
        this.applicantInfoTblBean.jobtypeId3_3 = "";
      }
    },
    "applicantInfoTblBean.jobtypeId3_2": function () {
      if (this.applicantInfoTblBean.jobtypeId3_1 == "") {
        this.applicantInfoTblBean.jobtypeId3_1 = this.applicantInfoTblBean.jobtypeId3_2;
        this.applicantInfoTblBean.jobtypeId3_2 = "";
      }
      if (this.applicantInfoTblBean.jobtypeId3_2 == "") {
        this.applicantInfoTblBean.jobtypeId3_2 = this.applicantInfoTblBean.jobtypeId3_3;
        this.applicantInfoTblBean.jobtypeId3_3 = "";
      }
    },
    "applicantInfoTblBean.jobtypeId3_3": function () {
      if (this.applicantInfoTblBean.jobtypeId3_2 == "") {
        this.applicantInfoTblBean.jobtypeId3_2 = this.applicantInfoTblBean.jobtypeId3_3;
        this.applicantInfoTblBean.jobtypeId3_3 = "";
      }
    },
    "applicantInfoTblBean.hopeLand1": function () {
      if (this.applicantInfoTblBean.hopeLand1 == "") {
        this.applicantInfoTblBean.hopeLand1 = this.applicantInfoTblBean.hopeLand2;
        this.applicantInfoTblBean.hopeLand2 = this.applicantInfoTblBean.hopeLand3;
        this.applicantInfoTblBean.hopeLand3 = "";
      }
    },
    "applicantInfoTblBean.hopeLand2": function () {
      if (this.applicantInfoTblBean.hopeLand1 == "") {
        this.applicantInfoTblBean.hopeLand1 = this.applicantInfoTblBean.hopeLand2;
        this.applicantInfoTblBean.hopeLand2 = "";
      }
      if (this.applicantInfoTblBean.hopeLand2 == "") {
        this.applicantInfoTblBean.hopeLand2 = this.applicantInfoTblBean.hopeLand3;
        this.applicantInfoTblBean.hopeLand3 = "";
      }
    },
    "applicantInfoTblBean.hopeLand3": function () {
      if (this.applicantInfoTblBean.hopeLand2 == "") {
        this.applicantInfoTblBean.hopeLand2 = this.applicantInfoTblBean.hopeLand3;
        this.applicantInfoTblBean.hopeLand3 = "";
      }
    },
  },
  computed: {
    // ユーザーネームの取得
    userName() {
      return sessionStorage.getItem("userNameC");
    },
    // 住所内容がないの場合、郵便番号検索ボタンは使用できない
    addressButtonDisabled() {
      return this.applicantInfoTblBean.address1 == "";
    },
    // 写真がないの場合、写真ロード失敗が不表示
    photoIsNull() {
      return this.applicantInfoTblBean.photo !== "";
    },
    // 業種重複不可
    industryId1Computed() {
      return this.industryMstBean.filter(
        (item) =>
          item.industryId != this.applicantInfoTblBean.industryId2 &&
          item.industryId != this.applicantInfoTblBean.industryId3
      );
    },
    industryId2Computed() {
      return this.industryMstBean.filter(
        (item) =>
          item.industryId != this.applicantInfoTblBean.industryId1 &&
          item.industryId != this.applicantInfoTblBean.industryId3
      );
    },
    industryId3Computed() {
      return this.industryMstBean.filter(
        (item) =>
          item.industryId != this.applicantInfoTblBean.industryId1 &&
          item.industryId != this.applicantInfoTblBean.industryId2
      );
    },
    // 希望勤務地重複不可
    hopeLand1Computed() {
      return this.prefecturesMstBean.filter(
        (item) =>
          item.prefeId != this.applicantInfoTblBean.hopeLand2 &&
          item.prefeId != this.applicantInfoTblBean.hopeLand3
      );
    },
    hopeLand2Computed() {
      return this.prefecturesMstBean.filter(
        (item) =>
          item.prefeId != this.applicantInfoTblBean.hopeLand1 &&
          item.prefeId != this.applicantInfoTblBean.hopeLand3
      );
    },
    hopeLand3Computed() {
      return this.prefecturesMstBean.filter(
        (item) =>
          item.prefeId != this.applicantInfoTblBean.hopeLand1 &&
          item.prefeId != this.applicantInfoTblBean.hopeLand2
      );
    },
    // 業種によって職種をスクリーニング
    jobType1_1Computed() {
      return this.jobtypeMstBean.filter(
        (item) =>
          item.industryId == this.applicantInfoTblBean.industryId1 &&
          item.jobtypeId != this.applicantInfoTblBean.jobtypeId1_2 &&
          item.jobtypeId != this.applicantInfoTblBean.jobtypeId1_3
      );
    },
    jobType1_2Computed() {
      return this.jobtypeMstBean.filter(
        (item) =>
          item.industryId == this.applicantInfoTblBean.industryId1 &&
          item.jobtypeId != this.applicantInfoTblBean.jobtypeId1_1 &&
          item.jobtypeId != this.applicantInfoTblBean.jobtypeId1_3
      );
    },
    jobType1_3Computed() {
      return this.jobtypeMstBean.filter(
        (item) =>
          item.industryId == this.applicantInfoTblBean.industryId1 &&
          item.jobtypeId != this.applicantInfoTblBean.jobtypeId1_1 &&
          item.jobtypeId != this.applicantInfoTblBean.jobtypeId1_2
      );
    },
    jobType2_1Computed() {
      return this.jobtypeMstBean.filter(
        (item) =>
          item.industryId == this.applicantInfoTblBean.industryId2 &&
          item.jobtypeId != this.applicantInfoTblBean.jobtypeId2_2 &&
          item.jobtypeId != this.applicantInfoTblBean.jobtypeId2_3
      );
    },
    jobType2_2Computed() {
      return this.jobtypeMstBean.filter(
        (item) =>
          item.industryId == this.applicantInfoTblBean.industryId2 &&
          item.jobtypeId != this.applicantInfoTblBean.jobtypeId2_1 &&
          item.jobtypeId != this.applicantInfoTblBean.jobtypeId2_3
      );
    },
    jobType2_3Computed() {
      return this.jobtypeMstBean.filter(
        (item) =>
          item.industryId == this.applicantInfoTblBean.industryId2 &&
          item.jobtypeId != this.applicantInfoTblBean.jobtypeId2_1 &&
          item.jobtypeId != this.applicantInfoTblBean.jobtypeId2_2
      );
    },
    jobType3_1Computed() {
      return this.jobtypeMstBean.filter(
        (item) =>
          item.industryId == this.applicantInfoTblBean.industryId3 &&
          item.jobtypeId != this.applicantInfoTblBean.jobtypeId3_2 &&
          item.jobtypeId != this.applicantInfoTblBean.jobtypeId3_3
      );
    },
    jobType3_2Computed() {
      return this.jobtypeMstBean.filter(
        (item) =>
          item.industryId == this.applicantInfoTblBean.industryId3 &&
          item.jobtypeId != this.applicantInfoTblBean.jobtypeId3_1 &&
          item.jobtypeId != this.applicantInfoTblBean.jobtypeId3_3
      );
    },
    jobType3_3Computed() {
      return this.jobtypeMstBean.filter(
        (item) =>
          item.industryId == this.applicantInfoTblBean.industryId3 &&
          item.jobtypeId != this.applicantInfoTblBean.jobtypeId3_1 &&
          item.jobtypeId != this.applicantInfoTblBean.jobtypeId3_2
      );
    },
    // 画像アップロード
    uploadURL() {
      return `${this.$store.state.HOST}/B0002/upload`;
    },
  },
  methods: {
    // collapse展開状態
    collapseChange(val) {
      if (val.length == 1) {
        this.initShow();
      }
    },
    // 情報保存
    insertData() {
      // 郵便番号スプライシング
      this.setPostal();
      console.log("insertApplicantInfoTblBean", this.applicantInfoTblBean);
      // 必須入力チェック
      this.$refs.applicantInfoTblBean.validate((valid) => {
        if (valid) {
          this.$store
            .dispatch("personalInformationInsert", this.applicantInfoTblBean)
            .then((response) => {
              let code = response.data.code;
              if (code == 200) {
                // 保存成功提示メッセージ
                this.$message.success(this.promptMessage.successMessage);
                // 画面表示内容リフレッシュ
                this.$parent.initData();
              } else if (code == 400 || code == 404) {
                this.$message.warning(this.promptMessage.failedMessage);
              } else if (code == 500) {
                this.$message.error(response.data.serverProblem);
              } else {
                // エラー画面へジャンプ
                this.$router.push({
                  path: "/error",
                  query: { message: response.data.message },
                });
                // エラー提示メッセージ
                this.$message.error(this.promptMessage.failedMessage);
              }
            })
            // エラーのキャッチ。ないの場合、DevToolsにエラー発生
            .catch(() => {});
        } else {
          // 空いている必須入力内容がある場合、提示する
          this.$message.warning(this.promptMessage.nullMessage);
        }
      });
    },
    // 情報保存
    saveData() {
      // 郵便番号スプライシング
      this.setPostal();
      console.log("saveApplicantInfoTblBean", this.applicantInfoTblBean);
      // 必須入力チェック
      this.$refs.applicantInfoTblBean.validate((valid) => {
        if (valid) {
          this.$refs.postalCode.validate((valid) => {
            if (valid) {
              this.$store
                .dispatch("personalInformationUpdate", this.applicantInfoTblBean)
                .then((response) => {
                  let code = response.data.code;
                  if (code == 200) {
                    // 保存成功提示メッセージ
                    this.$message.success(this.promptMessage.successMessage);
                    // 画面表示内容リフレッシュ
                    this.$parent.initData();
                  } else if (code == 400 || code == 404) {
                    this.$message.warning(this.promptMessage.failedMessage);
                  } else if (code == 500) {
                    this.$message.error(response.data.serverProblem);
                  } else {
                    // エラー画面へジャンプ
                    this.$router.push({
                      path: "/error",
                      query: { message: response.data.message },
                    });
                    // エラー提示メッセージ
                    this.$message.error(this.promptMessage.failedMessage);
                  }
                })
                // エラーのキャッチ。ないの場合、DevToolsにエラー発生
                .catch(() => {});
            } else {
              // 空いている必須入力内容がある場合、提示する
              this.$message.warning(this.promptMessage.nullMessage);
            }
          });
        } else {
          // 空いている必須入力内容がある場合、提示する
          this.$message.warning(this.promptMessage.nullMessage);
        }
      });
    },
    // 郵便番号保存
    setPostal() {
      this.applicantInfoTblBean.applicantPostal =
        this.postalCode.postal1 + "-" + this.postalCode.postal2;
    },
    // 郵便番号2のインプット欄にキーボードのエンターをクリックする場合
    searchPostal() {
      // 格式チェック
      if (this.postalCode.postal1.length != 3 || this.postalCode.postal2.length != 4) {
        this.$message.warning(this.promptMessage.postalCheck);
      } else {
        this.$refs.searchPostal.addressGet();
      }
    },
    // 画像サイズ制限
    pictureSize(file) {
      // 画像サイズ合格の場合、画像アップロードのボタンが不表示
      this.noneAvatar = true;
      // boolean 画像サイズ10MB以内
      const fileSize = file.size / 1024 / 1024 < 10;
      // 不合格の場合、エラー提示
      if (!fileSize) this.$message.error(this.promptMessage.avatarSize);
      return fileSize;
    },
    // 画像アップロード成功
    uploadSuccess(res, file) {
      this.$message.success(this.promptMessage.uploadSuccess);
      this.applicantInfoTblBean.photoPic = URL.createObjectURL(file.raw);
      this.applicantInfoTblBean.photo = res;
    },
    // 画像アップロード失敗
    uploadFailed() {
      this.$message.error(this.promptMessage.uploadFailed);
      // 画像アップロード失敗の場合、画像アップロードのボタンが表示
      this.noneAvatar = false;
    },
    // 画像アップロード一枚以上の場合、提示する
    uploadExceed() {
      this.$message.warning(this.promptMessage.uploadExceed);
    },
    // アップロードした画像を削除
    handleRemove() {
      // 画像アップロードのボタンが表示
      this.noneAvatar = false;
      this.applicantInfoTblBean.photo = "";
    },
    // 郵便番号入力内容数字制限
    postalNumValid(val) {
      this.postalCode[val] = this.postalCode[val].replace(/[^0-9０-９]/g, "");
    },
    // 希望月給入力内容数字制限
    moneyValid(val) {
      this.applicantInfoTblBean[val] = this.applicantInfoTblBean[val].replace(
        /[^0-9０-９]/g,
        ""
      );
    },
    // 住所を取得
    getAddress(address) {
      this.$set(this.applicantInfoTblBean, "address1", address);
    },
    // 住所内容をクリア
    clearAddress1() {
      this.applicantInfoTblBean.address1 = "";
    },
    // 業種増加
    addIndustryType() {
      if (this.industryTypeShow >= 0 && this.industryTypeShow < 2) {
        this.industryTypeShow++;
      }
    },
    // 業種減少
    minusIndustryType() {
      if (this.industryTypeShow > 0 && this.industryTypeShow < 3) {
        this.industryTypeShow--;
        this.applicantInfoTblBean.industryId3 = "";
        this.applicantInfoTblBean.jobtypeId3_1 = "";
        this.applicantInfoTblBean.jobtypeId3_2 = "";
        this.applicantInfoTblBean.jobtypeId3_3 = "";
        if (this.industryTypeShow < 1) {
          this.applicantInfoTblBean.industryId2 = "";
          this.applicantInfoTblBean.jobtypeId2_1 = "";
          this.applicantInfoTblBean.jobtypeId2_2 = "";
          this.applicantInfoTblBean.jobtypeId2_3 = "";
        }
      }
    },
    // 職種増加
    addJobType() {
      if (this.jobTypeShow >= 0 && this.jobTypeShow < 2) {
        this.jobTypeShow++;
      }
    },
    // 職種減少
    minusJobType() {
      if (this.jobTypeShow > 0 && this.jobTypeShow < 3) {
        this.jobTypeShow--;
        this.applicantInfoTblBean.jobtypeId1_3 = "";
        if (this.jobTypeShow < 1) {
          this.applicantInfoTblBean.jobtypeId1_2 = "";
        }
      }
    },
    // 職種2増加
    addJobType2() {
      if (this.jobType2Show >= 0 && this.jobType2Show < 2) {
        this.jobType2Show++;
      }
    },
    // 職種2減少
    minusJobType2() {
      if (this.jobType2Show > 0 && this.jobType2Show < 3) {
        this.jobType2Show--;
        this.applicantInfoTblBean.jobtypeId2_3 = "";
        if (this.jobType2Show < 1) {
          this.applicantInfoTblBean.jobtypeId2_2 = "";
        }
      }
    },
    // 職種3増加
    addJobType3() {
      if (this.jobType3Show >= 0 && this.jobType3Show < 2) {
        this.jobType3Show++;
        console.log("jobType3Show", this.jobType3Show);
      }
    },
    // 職種3減少
    minusJobType3() {
      if (this.jobType3Show > 0 && this.jobType3Show < 3) {
        this.jobType3Show--;
        this.applicantInfoTblBean.jobtypeId3_3 = "";
        if (this.jobType3Show < 1) {
          this.applicantInfoTblBean.jobtypeId3_2 = "";
        }
        console.log("jobType3Show", this.jobType3Show);
      }
    },
    // 希望勤務地増加
    addHopeLand() {
      if (this.hopeLandShow >= 0 && this.hopeLandShow < 2) {
        this.hopeLandShow++;
      }
    },
    // 希望勤務地減少
    minusHopeLand() {
      if (this.hopeLandShow > 0 && this.hopeLandShow < 3) {
        this.hopeLandShow--;
        this.applicantInfoTblBean.hopeLand3 = "";
        if (this.hopeLandShow < 1) {
          this.applicantInfoTblBean.hopeLand2 = "";
        }
      }
    },
    // 変更内容保存
    saveForm() {
      console.log("applicantInfoTblBean", this.applicantInfoTblBean);
    },
    // 初期増加内容の有無の判断
    initShow() {
      this.industryTypeShow = 0;
      this.jobTypeShow = 0;
      this.jobType2Show = 0;
      this.jobType3Show = 0;
      this.hopeLandShow = 0;
      if (this.applicantInfoTblBean.industryId2 != "") {
        this.industryTypeShow++;
      }
      if (this.applicantInfoTblBean.industryId3 != "") this.industryTypeShow++;
      if (this.applicantInfoTblBean.jobtypeId1_2 != "") this.jobTypeShow++;
      if (this.applicantInfoTblBean.jobtypeId1_3 != "") this.jobTypeShow++;
      if (this.applicantInfoTblBean.jobtypeId2_2 != "") this.jobType2Show++;
      if (this.applicantInfoTblBean.jobtypeId2_3 != "") this.jobType2Show++;
      if (this.applicantInfoTblBean.jobtypeId3_2 != "") this.jobType3Show++;
      if (this.applicantInfoTblBean.jobtypeId3_3 != "") this.jobType3Show++;
      if (this.applicantInfoTblBean.hopeLand2 != "") this.hopeLandShow++;
      if (this.applicantInfoTblBean.hopeLand3 != "") {
        this.hopeLandShow++;
      }
    },
    // 業種を選択の時、職種をクリア
    clearJobType() {
      this.applicantInfoTblBean.jobtypeId1_1 = "";
      this.applicantInfoTblBean.jobtypeId1_2 = "";
      this.applicantInfoTblBean.jobtypeId1_3 = "";
      this.jobTypeShow = 0;
    },
    clearJobType2() {
      this.applicantInfoTblBean.jobtypeId2_1 = "";
      this.applicantInfoTblBean.jobtypeId2_2 = "";
      this.applicantInfoTblBean.jobtypeId2_3 = "";
      this.jobType2Show = 0;
    },
    clearJobType3() {
      this.applicantInfoTblBean.jobtypeId3_1 = "";
      this.applicantInfoTblBean.jobtypeId3_2 = "";
      this.applicantInfoTblBean.jobtypeId3_3 = "";
      this.jobType3Show = 0;
    },
    // 焦点が失う場合、希望給与下限と上限の判断
    salaryFromBlur() {
      if (this.applicantInfoTblBean.hopeSalaryTo != "") {
        if (
          parseInt(this.applicantInfoTblBean.hopeSalaryFrom) >
          parseInt(this.applicantInfoTblBean.hopeSalaryTo)
        ) {
          console.log("hello");
          this.$message.warning(this.promptMessage.salaryFromLessThanTo);
          this.applicantInfoTblBean.hopeSalaryFrom = "";
        }
      }
    },
    salaryToBlur() {
      if (this.applicantInfoTblBean.hopeSalaryFrom != "") {
        if (
          parseInt(this.applicantInfoTblBean.hopeSalaryFrom) >
          parseInt(this.applicantInfoTblBean.hopeSalaryTo)
        ) {
          this.$message.warning(this.promptMessage.salaryFromLessThanTo);
          this.applicantInfoTblBean.hopeSalaryTo = "";
        }
      }
    },
    // TODO: address1をクリック、郵便番号ランがチェック提示
    address1Prompt() {
      console.log(this.$refs.postalCode);
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
// アバターのマージン
.avatar-row {
  margin: 2vh 0;
}
// 範囲インプット欄
.half-input-style {
  width: 100% !important;
}
.save-image {
  width: 40px;
  height: 40px;
  padding: 6px;
}
// 空いているのel-rowプレースホルダー
el-col {
  min-height: 1px;
  min-width: 1px;
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
//アバターアップロードボタン表示用
::v-deep .uploadDisabled .el-upload--picture-card {
  display: none;
}
// インプット、セレクト欄の下ボルダ
::v-deep .el-input__inner,
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
// ラベルの青字
::v-deep div > .el-form-item__label {
  font-size: 16px;
  color: #014099;
  font-style: normal;
  font-weight: bold;
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
// ユーザー名の大きさ
.user-name-style {
  font-size: 30px;
  font-weight: 400;
}
</style>
