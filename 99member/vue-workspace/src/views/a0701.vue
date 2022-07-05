<template>
  <div>
    <el-container>
      <el-header>
        <div class="header">
          <HomeHeader />
        </div>
      </el-header>
        <el-main class="a0701_body">
          <div v-text="titleName" class="titleNameStyle" />
          <div class="a0701_data">
            <el-tabs v-model="activeName" type="card" ref="tabs"> 
              
            <!-- 会社承認 -->
            <el-tab-pane name="second">
              <div slot="label" @click="getCompanyInit">会社承認</div>
              <el-form
                :model="a070102Form"
                ref="a070102Form"
                label-position="right"
                autocomplete="on"
              >
                <div class="a0701_select">
                  <div class="select_body">
                    <el-row :gutter="1">
                      <el-col :span="8" :offset="1">
                        <el-form-item label="会社名：" label-width="70px">
                          <el-input
                            v-model="a070102Form.companyNm"
                            placeholder="会社名を入力してください"
                            clearable
                          >
                          </el-input>
                        </el-form-item>
                      </el-col>
                      <el-col :span="6" :offset="1">
                        <el-form-item label="業種：" label-width="50px">
                          <el-select
                            v-model="a070102Form.industryId"
                            @change="setIndustryIdNm02"
                            placeholder="選択してください"
                            clearable
                          >
                            <el-option
                              v-for="item in industryIds"
                              :key="item.industryId"
                              :label="item.industryNm"
                              :value="item.industryId"
                            />
                          </el-select>
                        </el-form-item>
                      </el-col>
                      <el-col :span="6" :offset="1">
                        <el-form-item label="都道府県：" label-width="80px">
                          <el-select
                            v-model="a070102Form.prefeId"
                            @change="setPrefeIdNm02"
                            placeholder="選択してください"
                            clearable
                          >
                            <el-option
                              v-for="item in prefeIds"
                              :key="item.prefeId"
                              :label="item.prefeNm"
                              :value="item.prefeId"
                            />
                          </el-select>
                        </el-form-item>
                      </el-col>
                    </el-row>
                    <div class="a0701_button">
                      <el-row type="flex" justify="center">
                        <el-col :span="4">
                          <!-- <el-button
                            type="primary"
                            @click="reset070102Form"
                            class="a0701Button"
                          >
                            条件クリア
                          </el-button> -->
                          <el-tooltip effect="light" content="条件クリア" placement="top">
                            <el-link @click="reset070102Form" type="primary" :underline="false">
                              <em class="el-icon-document-remove"/>
                            </el-link>
                          </el-tooltip>
                        </el-col>
                        <el-col :span="4">
                          <!-- <el-button
                            type="primary"
                            @click="getCompanyData"
                            icon="el-icon-search"
                            class="a0701Button"
                          >
                            検索
                          </el-button> -->
                          <el-tooltip effect="light" content="検索" placement="top">
                            <el-link @click="getCompanyData" type="primary" :underline="false">
                              <em class="el-icon-search"/>
                            </el-link>
                          </el-tooltip>
                        </el-col>
                        <el-col :span="4">
                          <!-- <el-button
                            type="primary"
                            @click="toLastPage"
                            class="a0701Button"
                          >
                            戻る
                          </el-button> -->
                          <el-tooltip effect="light" content="戻る" placement="top">
                            <el-link @click="toLastPage" type="primary" :underline="false">
                              <em class="el-icon-back"/>
                            </el-link>
                          </el-tooltip>
                        </el-col>
                      </el-row>
                    </div>
                  </div>
                </div>
                <div class="a0701_data">
                  <div class="data_body">
                    <el-table
                      ref="multipleTable2"
                      :data="getCompanyList"
                      tooltip-effect="dark"
                      @row-click="getRowData2"
                      @selection-change="selectionChange2"
                      highlight-current-row
                    >
                      <el-table-column type="expand">
                        <template slot-scope="props">
                          <el-form label-position="right" inline class="demo-table-expand">
                            <el-form-item label="業種：">
                              <span>{{ props.row.industryNm1 }}</span>
                              <span v-show="props.row.industryNm2?true:false"> / </span>
                              <span>{{ props.row.industryNm2 }}</span>
                              <span  v-show="props.row.industryNm3?true:false"> / </span>
                              <span>{{ props.row.industryNm3 }}</span>
                            </el-form-item>
                            <el-form-item label="会社所在地：">
                              <span>{{ props.row.address1 }}</span>
                              <span>{{ props.row.address2 }}</span>
                            </el-form-item>
                          </el-form>
                        </template>
                      </el-table-column>
                      <el-table-column 
                        type="selection" 
                        fixed="left" 
                        @click="multiSelect" 
                      />
                      <el-table-column 
                        prop="companyNm" 
                        label="会社名" 
                        sortable
                      >
                      </el-table-column>
                      <el-table-column 
                        prop="companyTel" 
                        label="電話番号" 
                        sortable
                      />
                      <el-table-column
                        prop="companyMail"
                        label="会社メール"
                        sortable
                      />
                      <el-table-column
                        prop="companyPostal"
                        label="郵便番号"
                        sortable
                      />
                      <el-table-column fixed="right" label="詳細" width="80">
                        <el-tooltip effect="light" content="詳細へ" placement="top">
                          <el-link @click="getRowData2" type="primary" :underline="false">
                            <em class="el-icon-document"/>
                          </el-link>
                        </el-tooltip>
                      </el-table-column>
                      <el-table-column fixed="right" label="承認" width="80">
                        <el-tooltip effect="light" content="承認" placement="top">
                          <el-link @click="toCompanyConfirm" type="primary" :underline="false">
                            <em class="el-icon-circle-check"/>
                          </el-link>
                        </el-tooltip>
                      </el-table-column>
                      <el-table-column fixed="right" label="拒否" width="80">
                        <el-tooltip effect="light" content="拒否" placement="top">
                          <el-link @click="toCompanyDeny" type="primary" :underline="false">
                            <em class="el-icon-circle-close"/>
                          </el-link>
                        </el-tooltip>
                      </el-table-column>
                    </el-table>
                  </div>
                  <el-row type="flex" justify="end">
                    <el-col :span="1" :offset="1">
                      <el-tooltip effect="light" content="複数承認" placement="top">
                        <el-link @click="confirmCompanyMulti" type="primary" :underline="false">
                          <em class="el-icon-circle-check"/>
                        </el-link>
                      </el-tooltip>
                    </el-col>
                    <el-col :span="1">
                      <el-tooltip effect="light" content="複数拒否" placement="top">
                        <el-link @click="denyCompanyMulti" type="primary" :underline="false">
                          <em class="el-icon-circle-close"/>
                        </el-link>
                      </el-tooltip>
                    </el-col>
                  </el-row>
                  <div class="page">
                    <el-row type="flex" justify="space-around">
                      <el-col :span="12">
                        <el-pagination
                          :total="companyPage.total"
                          :current-page="companyPage.currentPage"
                          :pager-count="companyPage.pagerCount"
                          :page-sizes="companyPage.pageSizes"
                          :page-size="companyPage.pageSize"
                          :background="true"
                          :layout="companyPage.layout"
                          @size-change="companyPageSizeChange"
                          @current-change="companyPageCurrentChange"
                        />
                      </el-col>
                    </el-row>
                  </div>
                </div>
              </el-form>
            </el-tab-pane>



            <!-- 職位承認 -->
            <el-tab-pane name="third">
              <div slot="label" @click="getPositionInit">職位承認</div>
              <el-form
                :model="a070103Form"
                ref="a070103Form"
                label-position="right"
                autocomplete="on"
              >
                <div class="a0701_select">
                  <div class="select_body">
                    <el-row :gutter="1">
                      <el-col :span="8" :offset="2">
                        <el-form-item label="検索：" label-width="60px">
                          <el-input
                            v-model="a070103Form.likeSelect"
                            placeholder="職種、業種または職位を入力してください"
                            clearable
                          >
                          </el-input>
                        </el-form-item>
                      </el-col>
                      <el-col :span="8" :offset="3">
                        <el-form-item label="会社名：" label-width="70px">
                          <el-input
                            v-model="a070103Form.companyNm"
                            placeholder="会社名を入力してください"
                            clearable
                          >
                          </el-input>
                        </el-form-item>
                      </el-col>
                    </el-row>
                    <el-row :gutter="1">
                      <el-col :span="6" :offset="2">
                        <el-form-item label="都道府県：" label-width="80px">
                          <el-select
                            v-model="a070103Form.prefeId"
                            @change="setPrefeIdNm03"
                            placeholder="選択してください"
                            clearable
                          >
                            <el-option
                              v-for="item in prefeList03"
                              :key="item.prefeId"
                              :label="item.prefeNm"
                              :value="item.prefeId"
                            />
                          </el-select>
                        </el-form-item>
                      </el-col>
                      <el-col :span="6" :offset="1">
                        <el-form-item label="業種：" label-width="60px">
                          <el-select
                            v-model="a070103Form.industryId"
                            @change="setIndustryIdNm03"
                            placeholder="選択してください"
                            clearable
                          >
                            <el-option
                              v-for="item in industryList03"
                              :key="item.industryId"
                              :label="item.industryNm"
                              :value="item.industryId"
                            />
                          </el-select>
                        </el-form-item>
                      </el-col>
                      <el-col :span="6" :offset="1">
                        <el-form-item label="職種：" label-width="70px">
                          <el-select
                            v-model="a070103Form.jobtypeId"
                            @change="setJobtypeIdNm03"
                            placeholder="選択してください"
                            clearable
                          >
                            <el-option
                              v-for="item in jobtypeList03"
                              :key="item.jobtypeId"
                              :label="item.jobtypeNm"
                              :value="item.jobtypeId"
                            />
                          </el-select>
                        </el-form-item>
                      </el-col>
                    </el-row>
                    <div class="a0701_button">
                      <el-row type="flex" justify="center">
                        <el-col :span="4">
                          <!-- <el-button
                            type="primary"
                            @click="reset070103Form"
                            class="a0701Button"
                          >
                            条件クリア
                          </el-button> -->
                          <el-tooltip effect="light" content="条件クリア" placement="top">
                            <el-link @click="reset070103Form" type="primary" :underline="false">
                              <em class="el-icon-document-remove"/>
                            </el-link>
                          </el-tooltip>
                        </el-col>
                        <el-col :span="4">
                          <!-- <el-button
                            type="primary"
                            @click="getPositionData"
                            icon="el-icon-search"
                            class="a0701Button"
                          >
                            検索
                          </el-button> -->
                          <el-tooltip effect="light" content="検索" placement="top">
                            <el-link @click="getPositionData" type="primary" :underline="false">
                              <em class="el-icon-search"/>
                            </el-link>
                          </el-tooltip>
                        </el-col>
                        <el-col :span="4">
                          <!-- <el-button
                            type="primary"
                            @click="toLastPage"
                            class="a0701Button"
                          >
                            戻る
                          </el-button> -->
                          <el-tooltip effect="light" content="戻る" placement="top">
                            <el-link @click="toLastPage" type="primary" :underline="false">
                              <em class="el-icon-back"/>
                            </el-link>
                          </el-tooltip>
                        </el-col>
                      </el-row>
                    </div>
                  </div>
                </div>
                <div class="a0701_data">
                  <div class="data_body">
                    <el-table
                      ref="multipleTable3"
                      :data="getPositionList"
                      tooltip-effect="dark"
                      @row-click="getRowData3"
                      @row-dblclick="toB0102Detailed"
                      @selection-change="selectionChange3"
                      highlight-current-row
                    >
                      <el-table-column type="expand">
                        <template slot-scope="props">
                          <el-form label-position="right" inline class="demo-table-expand">
                            <el-form-item label="業種：">
                              <span>{{ props.row.industryNm }}</span>
                            </el-form-item>
                            <el-form-item label="職種：">
                              <span>{{ props.row.jobTypeNm }}</span>
                            </el-form-item>
                            <el-form-item label="場所：">
                              <span>{{ props.row.workAddress1 }}</span>
                              <span>{{ props.row.workAddress2 }}</span>
                            </el-form-item>
                            <el-form-item label="雇用・労災保険：">
                              <span>{{empLaborIns [props.row.empLaborIns]}}</span>
                            </el-form-item>
                            <el-form-item label="福利厚生：">
                              <span>{{welfare [props.row.welfare]}}</span>
                            </el-form-item>
                            <el-form-item label="研修有無：">
                              <span>{{trainingFlg [props.row.trainingFlg]}}</span>
                            </el-form-item>
                            <el-form-item label="給料区分：">
                              <span>{{salarySection [props.row.salarySection]}}</span>
                            </el-form-item>
                            <el-form-item label="見学有無：">
                              <span>{{inspectionFlg [props.row.inspectionFlg]}}</span>
                            </el-form-item>
                            <el-form-item label="最低限給料：">
                              <span>{{ props.row.salaryMin }}</span>
                              <span>円</span>
                            </el-form-item>
                            <el-form-item label="最高限給料：">
                              <span>{{ props.row.salaryMax }}</span>
                              <span>円</span>
                            </el-form-item>
                          </el-form>
                        </template>
                      </el-table-column>
                      <el-table-column 
                        type="selection" 
                        fixed="left" 
                        @click="multiSelect" 
                      />
                      <el-table-column 
                        prop="positionNm" 
                        label="職位名" 
                        sortable
                      />
                      <el-table-column 
                        prop="companyNm" 
                        label="会社名" 
                        sortable
                      />
                      <el-table-column 
                        prop="peoCnt" 
                        label="募集要員" 
                        sortable
                      >
                      </el-table-column>
                      <el-table-column
                        prop="expYears"
                        label="必須経験年数"
                        sortable
                      >
                        <template slot-scope="scope">
                          {{expYears [scope.row.expYears]}} 
                        </template>
                      </el-table-column>
                      <el-table-column 
                        prop="degree" 
                        label="学歴要求" 
                        sortable
                      >
                        <template slot-scope="scope">
                          {{degree [scope.row.degree]}} 
                        </template>
                      </el-table-column>
                      <el-table-column fixed="right" label="詳細" width="80">
                        <el-tooltip effect="light" content="詳細へ" placement="top">
                          <el-link @click="toB0102Detailed" type="primary" :underline="false">
                            <em class="el-icon-document"/>
                          </el-link>
                        </el-tooltip>
                      </el-table-column>
                      <el-table-column fixed="right" label="承認" width="80">
                        <el-tooltip effect="light" content="承認" placement="top">
                          <el-link @click="toPositionConfirm" type="primary" :underline="false">
                            <em class="el-icon-circle-check"/>
                          </el-link>
                        </el-tooltip>
                      </el-table-column>
                      <el-table-column fixed="right" label="拒否" width="80">
                        <el-tooltip effect="light" content="拒否" placement="top">
                          <el-link @click="toPositionDeny" type="primary" :underline="false">
                            <em class="el-icon-circle-close"/>
                          </el-link>
                        </el-tooltip>
                      </el-table-column>
                    </el-table>
                  </div>
                  <el-row type="flex" justify="end">
                    <el-col :span="1" :offset="1">
                      <el-tooltip effect="light" content="複数承認" placement="top">
                        <el-link @click="confirmPositionMulti" type="primary" :underline="false">
                          <em class="el-icon-circle-check"/>
                        </el-link>
                      </el-tooltip>
                    </el-col>
                    <el-col :span="1">
                      <el-tooltip effect="light" content="複数拒否" placement="top">
                        <el-link @click="denyPositionMulti" type="primary" :underline="false">
                          <em class="el-icon-circle-close"/>
                        </el-link>
                      </el-tooltip>
                    </el-col>
                  </el-row>
                  <div class="page">
                    <el-row type="flex" justify="space-around">
                      <el-col :span="12">
                        <el-pagination
                          :total="positionPage.total"
                          :current-page="positionPage.currentPage"
                          :pager-count="positionPage.pagerCount"
                          :page-sizes="positionPage.pageSizes"
                          :page-size="positionPage.pageSize"
                          :background="true"
                          :layout="positionPage.layout"
                          @size-change="positionPageSizeChange"
                          @current-change="positionPageCurrentChange"
                        />
                      </el-col>
                    </el-row>
                  </div>
                </div>
              </el-form>
            </el-tab-pane>




            <!-- 研修承認 -->
            <el-tab-pane name="forth">
              <div slot="label" @click="getTrainingInit">研修承認</div>
              <el-form
                :model="a070104Form"
                ref="a070104Form"
                label-position="right"
                autocomplete="on"
              >
                <div class="a0701_select">
                  <div class="select_body">
                    <el-row :gutter="1">
                      <el-col :span="8" :offset="2">
                        <el-form-item label="研修名：" label-width="70px">
                          <el-input
                            v-model="a070104Form.trainingNm"
                            placeholder="研修名を入力してください"
                            clearable
                          >
                          </el-input>
                        </el-form-item>
                      </el-col>
                      <el-col :span="6" :offset="2">
                        <el-form-item label="都道府県：" label-width="80px">
                          <el-select
                            v-model="a070104Form.prefeId"
                            @change="setPrefeIdNm04"
                            placeholder="選択してください"
                            clearable
                          >
                            <el-option
                              v-for="item in prefeList04"
                              :key="item.prefeId"
                              :label="item.prefeNm"
                              :value="item.prefeId"
                            />
                          </el-select>
                        </el-form-item>
                      </el-col>
                    </el-row>
                    <el-row :gutter="1">
                      <el-col :span="8" :offset="2">
                        <el-form-item label="会社名：" label-width="70px">
                          <el-input
                            v-model="a070104Form.companyNm"
                            placeholder="会社名を入力してください"
                            clearable
                          >
                          </el-input>
                        </el-form-item>
                      </el-col>
                      <el-col :span="6" :offset="2">
                        <el-form-item label="業種：" label-width="80px">
                          <el-select
                            v-model="a070104Form.industryId"
                            @change="setIndustryIdNm04"
                            placeholder="選択してください"
                            clearable
                          >
                            <el-option
                              v-for="item in industryList04"
                              :key="item.industryId"
                              :label="item.industryNm"
                              :value="item.industryId"
                            />
                          </el-select>
                        </el-form-item>
                      </el-col>
                    </el-row>
                    <div class="a0701_button">
                      <el-row type="flex" justify="center">
                        <el-col :span="4">
                          <!-- <el-button
                            type="primary"
                            @click="reset070104Form"
                            class="a0701Button"
                          >
                            条件クリア
                          </el-button> -->
                          <el-tooltip effect="light" content="条件クリア" placement="top">
                            <el-link @click="reset070104Form" type="primary" :underline="false">
                              <em class="el-icon-document-remove"/>
                            </el-link>
                          </el-tooltip>
                        </el-col>
                        <el-col :span="4">
                          <!-- <el-button
                            type="primary"
                            @click="getTrainingData"
                            icon="el-icon-search"
                            class="a0701Button"
                          >
                            検索
                          </el-button> -->
                          <el-tooltip effect="light" content="検索" placement="top">
                            <el-link @click="getTrainingData" type="primary" :underline="false">
                              <em class="el-icon-search"/>
                            </el-link>
                          </el-tooltip>
                        </el-col>
                        <el-col :span="4">
                          <!-- <el-button
                            type="primary"
                            @click="toLastPage"
                            class="a0701Button"
                          >
                            戻る
                          </el-button> -->
                          <el-tooltip effect="light" content="戻る" placement="top">
                            <el-link @click="toLastPage" type="primary" :underline="false">
                              <em class="el-icon-back"/>
                            </el-link>
                          </el-tooltip>
                        </el-col>
                      </el-row>
                    </div>
                  </div>
                </div>
                <div class="a0701_data">
                  <div class="data_body">
                    <el-table
                      ref="multipleTable4"
                      :data="getTrainingList"
                      tooltip-effect="dark"
                      @row-click="getRowData4"
                      @row-dblclick="toB0502Detailed"
                      @selection-change="selectionChange4"
                      highlight-current-row
                    >
                      <el-table-column type="expand">
                        <template slot-scope="props">
                          <el-form label-position="right" inline class="demo-table-expand">
                            <el-form-item label="開始時刻：">
                              <span>{{ props.row.timeFrom }}</span>
                            </el-form-item>
                            <el-form-item label="終了時刻：">
                              <span>{{ props.row.timeTo }}</span>
                            </el-form-item>
                            <el-form-item label="研修場所：">
                              <span>{{ props.row.trainingAddress1 }}</span>
                              <span>{{ props.row.trainingAddress2 }}</span>
                            </el-form-item>
                            <el-form-item label="担当者：">
                              <span>{{ props.row.charge }}</span>
                            </el-form-item>
                            <el-form-item label="連絡先：">
                              <span>{{ props.row.tel }}</span>
                            </el-form-item>
                            <el-form-item label="人数：">
                              <span>{{ props.row.proCnt }}</span>
                            </el-form-item>
                          </el-form>
                        </template>
                      </el-table-column>
                      <el-table-column 
                        type="selection" 
                        fixed="left" 
                        @click="multiSelect" 
                      />
                      <el-table-column 
                        prop="trainingNm" 
                        label="研修名" 
                        sortable
                      />
                      <el-table-column 
                        prop="companyNm" 
                        label="会社名" 
                        sortable
                      />
                      <el-table-column 
                        prop="industryNm" 
                        label="業種" 
                        sortable
                      >
                      </el-table-column>
                      <el-table-column 
                        prop="dateFrom" 
                        label="開始日付" 
                        sortable
                      />
                      <el-table-column 
                        prop="dateTo" 
                        label="終了日付" 
                        sortable 
                      />
                      <el-table-column fixed="right" label="詳細" width="80">
                        <el-tooltip effect="light" content="詳細へ" placement="top">
                          <el-link @click="toB0502Detailed" type="primary" :underline="false">
                            <em class="el-icon-document"/>
                          </el-link>
                        </el-tooltip>
                      </el-table-column>
                      <el-table-column fixed="right" label="承認" width="80">
                        <el-tooltip effect="light" content="承認" placement="top">
                          <el-link @click="toTrainingConfirm" type="primary" :underline="false">
                            <em class="el-icon-circle-check"/>
                          </el-link>
                        </el-tooltip>
                      </el-table-column>
                      <el-table-column fixed="right" label="拒否" width="80">
                        <el-tooltip effect="light" content="拒否" placement="top">
                          <el-link @click="toTrainingDeny" type="primary" :underline="false">
                            <em class="el-icon-circle-close"/>
                          </el-link>
                        </el-tooltip>
                      </el-table-column>
                    </el-table>
                  </div>
                  <el-row type="flex" justify="end">
                    <el-col :span="1" :offset="1">
                      <el-tooltip effect="light" content="複数承認" placement="top">
                        <el-link @click="confirmTrainingMulti" type="primary" :underline="false">
                          <em class="el-icon-circle-check"/>
                        </el-link>
                      </el-tooltip>
                    </el-col>
                    <el-col :span="1">
                      <el-tooltip effect="light" content="複数拒否" placement="top">
                        <el-link @click="denyTrainingMulti" type="primary" :underline="false">
                          <em class="el-icon-circle-close"/>
                        </el-link>
                      </el-tooltip>
                    </el-col>
                  </el-row>
                  <div class="page">
                    <el-row type="flex" justify="space-around">
                      <el-col :span="12">
                        <el-pagination
                          :total="trainingPage.total"
                          :current-page="trainingPage.currentPage"
                          :pager-count="trainingPage.pagerCount"
                          :page-sizes="trainingPage.pageSizes"
                          :page-size="trainingPage.pageSize"
                          :background="true"
                          :layout="trainingPage.layout"
                          @size-change="trainingPageSizeChange"
                          @current-change="trainingPageCurrentChange"
                        />
                      </el-col>
                    </el-row>
                  </div>
                </div>
              </el-form>
            </el-tab-pane>



            <!-- 説明会承認 -->
            <el-tab-pane name="fifth">
              <div slot="label" @click="getBriefingInit">説明会承認</div>
              <el-form
                :model="a070105Form"
                ref="a070105Form"
                label-position="right"
                autocomplete="on"
              >
                <div class="a0701_select">
                  <div class="select_body">
                    <el-row :gutter="1">
                      <el-col :span="8" :offset="2">
                        <el-form-item label="説明会名：" label-width="80px">
                          <el-input
                            v-model="a070105Form.briefingNm"
                            placeholder="説明会名を入力してください"
                            clearable
                          >
                          </el-input>
                        </el-form-item>
                      </el-col>
                      <el-col :span="6" :offset="3">
                        <el-form-item label="説明会方式：" label-width="90px">
                          <el-select
                            v-model="a070105Form.briefingType"
                            placeholder="選択してください"
                            clearable
                          >
                            <el-option
                              v-for="item in briefing_Type"
                              :key="item.value"
                              :label="item.label"
                              :value="item.value"
                            />
                          </el-select>
                        </el-form-item>
                      </el-col>
                    </el-row>
                    <el-row :gutter="1">
                      <el-col :span="8" :offset="2">
                        <el-form-item label="会社名：" label-width="80px">
                          <el-input
                            v-model="a070105Form.companyNm"
                            placeholder="会社名を入力してください"
                            clearable
                          >
                          </el-input>
                        </el-form-item>
                      </el-col>
                      <el-col :span="6" :offset="3">
                        <el-form-item label="都道府県：" label-width="90px">
                          <el-select
                            v-model="a070105Form.prefeId"
                            @change="setPrefeIdNm05"
                            placeholder="選択してください"
                            clearable
                          >
                            <el-option
                              v-for="item in prefeList05"
                              :key="item.prefeId"
                              :label="item.prefeNm"
                              :value="item.prefeId"
                            />
                          </el-select>
                        </el-form-item>
                      </el-col>
                    </el-row>
                    <el-row :gutter="1">
                      <el-col :span="18" :offset="2">
                        <el-form-item label="説明会時間：" label-width="90px">
                          <el-time-picker
                            v-model="a070105Form.dateFrom"
                            placeholder="開始時間"
                            value-format="HH:mm:ss"
                            class="rangeStyle"
                            align="right"
                            type="time"
                          />
                          <label> - </label>
                          <el-time-picker
                            v-model="a070105Form.dateTo"
                            placeholder="終了時間"
                            value-format="HH:mm:ss"
                            class="rangeStyle"
                            align="right"
                            type="time"
                          />
                        </el-form-item>
                      </el-col>
                    </el-row>
                    <div class="a0701_button">
                      <el-row type="flex" justify="center">
                        <el-col :span="4">
                          <!-- <el-button
                            type="primary"
                            @click="reset070105Form"
                            class="a0701Button"
                          >
                            条件クリア
                          </el-button> -->
                          <el-tooltip effect="light" content="条件クリア" placement="top">
                            <el-link @click="reset070105Form" type="primary" :underline="false">
                              <em class="el-icon-document-remove"/>
                            </el-link>
                          </el-tooltip>
                        </el-col>
                        <el-col :span="4">
                          <!-- <el-button
                            type="primary"
                            @click="getBriefingData"
                            icon="el-icon-search"
                            class="a0701Button"
                          >
                            検索
                          </el-button> -->
                          <el-tooltip effect="light" content="検索" placement="top">
                            <el-link @click="getBriefingData" type="primary" :underline="false">
                              <em class="el-icon-search"/>
                            </el-link>
                          </el-tooltip>
                        </el-col>
                        <el-col :span="4">
                          <!-- <el-button
                            type="primary"
                            @click="toLastPage"
                            class="a0701Button"
                          >
                            戻る
                          </el-button> -->
                          <el-tooltip effect="light" content="検索" placement="top">
                            <el-link @click="toLastPage" type="primary" :underline="false">
                              <em class="el-icon-back"/>
                            </el-link>
                          </el-tooltip>
                        </el-col>
                      </el-row>
                    </div>
                  </div>
                </div>
                <div class="a0701_data">
                  <div class="data_body">
                    <el-table
                      ref="multipleTable5"
                      :data="getBriefingList"
                      tooltip-effect="dark"
                      @row-click="getRowData5"
                      @row-dblclick="toB0602Detailed"
                      @selection-change="selectionChange5"
                      highlight-current-row
                    >
                      <el-table-column type="expand">
                        <template slot-scope="props">
                          <el-form label-position="right" inline class="demo-table-expand">
                            <el-form-item label="説明会場所：">
                              <span>{{ props.row.briefingAddress1 }}</span>
                              <span>{{ props.row.briefingAddress2 }}</span>
                            </el-form-item>
                            <el-form-item label="予定人数：">
                              <span>{{ props.row.proCntPlan }}</span>
                            </el-form-item>
                            <el-form-item label="連絡先：">
                              <span>{{ props.row.tel }}</span>
                            </el-form-item>
                            <el-form-item label="担当者：">
                              <span>{{ props.row.charge }}</span>
                            </el-form-item>
                          </el-form>
                        </template>
                      </el-table-column>
                      <el-table-column 
                        type="selection" 
                        fixed="left" 
                        @click="multiSelect" 
                      />
                      <el-table-column 
                        prop="briefingNm" 
                        label="説明会名" 
                        sortable
                      />
                      <el-table-column 
                        prop="companyNm" 
                        label="会社名" 
                        sortable
                      />
                      <el-table-column 
                        prop="briefingDate" 
                        label="説明会日"
                        sortable 
                      >
                      </el-table-column>
                      <el-table-column 
                        prop="dateFrom" 
                        label="開始時刻" 
                        sortable
                      />
                      <el-table-column 
                        prop="dateTo" 
                        label="終了時刻" 
                        sortable 
                      />
                      <el-table-column
                        prop="briefingType"
                        label="説明会方式"
                        sortable
                      >
                        <template slot-scope="scope">
                          {{briefingType [scope.row.briefingType]}} 
                        </template>
                      </el-table-column>
                      <el-table-column fixed="right" label="詳細" width="80">
                        <el-tooltip effect="light" content="詳細へ" placement="top">
                          <el-link @click="toB0602Detailed" type="primary" :underline="false">
                            <em class="el-icon-document"/>
                          </el-link>
                        </el-tooltip>
                      </el-table-column>
                      <el-table-column fixed="right" label="承認" width="80">
                        <el-tooltip effect="light" content="承認" placement="top">
                          <el-link @click="toBriefingConfirm" type="primary" :underline="false">
                            <em class="el-icon-circle-check"/>
                          </el-link>
                        </el-tooltip>
                      </el-table-column>
                      <el-table-column fixed="right" label="拒否" width="80">
                        <el-tooltip effect="light" content="拒否" placement="top">
                          <el-link @click="toBriefingDeny" type="primary" :underline="false">
                            <em class="el-icon-circle-close"/>
                          </el-link>
                        </el-tooltip>
                      </el-table-column>
                    </el-table>
                  </div>
                  <el-row type="flex" justify="end">
                    <el-col :span="1" :offset="1">
                      <el-tooltip effect="light" content="複数承認" placement="top">
                        <el-link @click="confirmBriefingMulti" type="primary" :underline="false">
                          <em class="el-icon-circle-check"/>
                        </el-link>
                      </el-tooltip>
                    </el-col>
                    <el-col :span="1">
                      <el-tooltip effect="light" content="複数拒否" placement="top">
                        <el-link @click="denyBriefingMulti" type="primary" :underline="false">
                          <em class="el-icon-circle-close"/>
                        </el-link>
                      </el-tooltip>
                    </el-col>
                  </el-row>
                  <div class="page">
                    <el-row type="flex" justify="space-around">
                      <el-col :span="12">
                        <el-pagination
                          :total="briefingPage.total"
                          :current-page="briefingPage.currentPage"
                          :pager-count="briefingPage.pagerCount"
                          :page-sizes="briefingPage.pageSizes"
                          :page-size="briefingPage.pageSize"
                          :background="true"
                          :layout="briefingPage.layout"
                          @size-change="briefingPageSizeChange"
                          @current-change="briefingPageCurrentChange"
                        />
                      </el-col>
                    </el-row>
                  </div>
                </div>
              </el-form>
            </el-tab-pane>




            <!-- ユーザー承認 -->
            <el-tab-pane name="first" id="userConfig">
              <div slot="label" @click="getUserInit">ユーザー承認</div>
                <el-form
                  :model="a070101Form"
                  ref="a070101Form"
                  label-position="right"
                  autocomplete="on"
                >
                <div class="a0701_select">
                  <div class="select_body">
                    <el-row :gutter="1">
                      <el-col :span="8" :offset="2">
                        <el-form-item label="名前：" label-width="50px">
                          <el-input
                            v-model="a070101Form.userName"
                            placeholder="名前を入力してください"
                            clearable
                          >
                          </el-input>
                        </el-form-item>
                      </el-col>
                      <el-col :span="8" :offset="2">
                        <el-form-item label="メールアドレス：" label-width="120px">
                          <el-input
                            v-model="a070101Form.userMail"
                            placeholder="メールを入力してください"
                            clearable
                          >
                          </el-input>
                        </el-form-item>
                      </el-col>
                    </el-row>
                    <div class="a0701_button">
                      <el-row type="flex" justify="center">
                        <el-col :span="4">
                          <!-- <el-button
                            type="primary"
                            @click="reset070101Form"
                            class="a0701Button"
                          >
                            条件クリア
                          </el-button> -->
                          <el-tooltip effect="light" content="条件クリア" placement="top">
                            <el-link @click="reset070101Form" type="primary" :underline="false">
                              <em class="el-icon-document-remove"/>
                            </el-link>
                          </el-tooltip>
                        </el-col>
                        <el-col :span="4">
                          <!-- <el-button
                            type="primary"
                            @click="getUserData"
                            icon="el-icon-search"
                            class="a0701Button"
                          >
                            検索
                          </el-button> -->
                          <el-tooltip effect="light" content="検索" placement="top">
                            <el-link @click="getUserData" type="primary" :underline="false">
                              <em class="el-icon-search"/>
                            </el-link>
                          </el-tooltip>
                        </el-col>
                        <el-col :span="4">
                          <!-- <el-button
                            type="primary"
                            @click="toLastPage"
                            class="a0701Button"
                          >
                            戻る
                          </el-button> -->
                          <el-tooltip effect="light" content="戻る" placement="top">
                            <el-link @click="toLastPage" type="primary" :underline="false">
                              <em class="el-icon-back"/>
                            </el-link>
                          </el-tooltip>
                        </el-col>
                      </el-row>
                    </div>
                  </div>
                </div>
                <div class="a0701_data">
                  <div class="data_body">
                    <el-table
                      ref="multipleTable"
                      :data="getUserList"
                      tooltip-effect="dark"
                      @row-click="getRowData"
                      @selection-change="selectionChange"
                      highlight-current-row
                    >
                      <el-table-column type="expand">
                        <template slot-scope="props">
                          <el-form label-position="right" inline class="demo-table-expand">
                            <el-form-item label="会社名：">
                              <span>{{ props.row.companyNm }}</span>
                            </el-form-item>
                            <el-form-item label="ユーザー状態：">
                              <span>{{userStatus [props.row.userStatus]}}</span>
                            </el-form-item>
                          </el-form>
                        </template>
                      </el-table-column>
                      <el-table-column 
                      type="selection" 
                      fixed="left" 
                      @click="multiSelect" 
                      />
                      <el-table-column 
                        prop="userName" 
                        label="名前" 
                        sortable
                      >
                        <template v-slot="fullName">
                            {{ fullName.row.firstName }} {{ fullName.row.lastName }}
                        </template>
                      </el-table-column>
                      <el-table-column 
                        prop="userMail" 
                        label="メールアドレス" 
                        sortable
                      />
                      <el-table-column
                        prop="authority"
                        label="権限"
                        sortable
                      />
                      <el-table-column
                        prop="userTel"
                        label="電話番号"
                        sortable
                      />
                      <el-table-column fixed="right" label="詳細" width="80">
                        <el-tooltip effect="light" content="詳細へ" placement="top">
                          <el-link @click="getRowData" type="primary" :underline="false">
                            <em class="el-icon-document"/>
                          </el-link>
                        </el-tooltip>
                      </el-table-column>
                      <el-table-column fixed="right" label="承認" width="80">
                        <el-tooltip effect="light" content="承認" placement="top">
                          <el-link @click="toUserConfirm" type="primary" :underline="false">
                            <em class="el-icon-circle-check"/>
                          </el-link>
                        </el-tooltip>
                      </el-table-column>
                      <el-table-column fixed="right" label="拒否" width="80">
                        <el-tooltip effect="light" content="拒否" placement="top">
                          <el-link @click="toUserDeny" type="primary" :underline="false">
                            <em class="el-icon-circle-close"/>
                          </el-link>
                        </el-tooltip>
                      </el-table-column>
                    </el-table>
                  </div>
                  <el-row type="flex" justify="end">
                    <el-col :span="1" :offset="1">
                      <el-tooltip effect="light" content="複数承認" placement="top">
                        <el-link @click="confirmUserMulti" type="primary" :underline="false">
                          <em class="el-icon-circle-check"/>
                        </el-link>
                      </el-tooltip>
                    </el-col>
                    <el-col :span="1">
                      <el-tooltip effect="light" content="複数拒否" placement="top">
                        <el-link @click="denyUserMulti" type="primary" :underline="false">
                          <em class="el-icon-circle-close"/>
                        </el-link>
                      </el-tooltip>
                    </el-col>
                  </el-row>
                  <div class="page">
                    <el-row type="flex" justify="space-around">
                      <el-col :span="12">
                        <el-pagination
                          :total="userPage.total"
                          :current-page="userPage.currentPage"
                          :pager-count="userPage.pagerCount"
                          :page-sizes="userPage.pageSizes"
                          :page-size="userPage.pageSize"
                          :background="true"
                          :layout="userPage.layout"
                          @size-change="userPageSizeChange"
                          @current-change="userPageCurrentChange"
                        />
                      </el-col>
                    </el-row>
                  </div>
                </div>
              </el-form>
            </el-tab-pane>


          </el-tabs>
        </div>
      </el-main>
      <el-footer>
        <div class="footer">
          <HomeFooter />
        </div>
      </el-footer>
    </el-container>
  </div>
</template>


<script lang="" scoped>
import HomeHeader from "./components/HomeHeader";
import HomeFooter from "./components/HomeFooter";
// 内容チェック機能導入
import {
  telOnInfo
} from "@/utils/validate";
export default {
  components: {
    HomeHeader,
    HomeFooter,
  },

  data() {
    return {
      // タイトル名
      titleName: "未承認一覧",
      //tabs初期表示
      activeName: 'second',
      // 複数チェックボックス
      multipleSelection: [],
      authority: "",

      // a070101検索条件
      a070101Form: {
        userMail: "",
        userName: "",
      },
      // a070101転送用form
      A070101VueForm: {
        userMail: "",
        userName: "",
        authority: "",
        userCds: [],
        userCd: Number,
        statusFlg: "",
      },
      userStatus:{
        '0' : '正常',
        '1' : '禁止',
      },
      // a070101テーブルのデータ
      userList: [],
      // a070101ページ設定
      userPage: {
        // データ数
        total: 0,
        // table page from
        currentPage: 1,
        // データ数per page
        pageSizes: [10, 30, 50],
        // default データ数per page
        pageSize: 10,
        // 展示ページボタン数
        pagerCount: 5,
        // 順序
        layout: "total, sizes, prev, pager, next, jumper",
        // 当ページの最初の行
        dataStart: 0,
        //当ページの最後の行
        dataEnd: 10,
      },

      // a070102検索条件
      a070102Form: {
        companyNm: "",
        industryId: "",
        industryNm: "",
        prefeId: "",
        prefeNm: "",
      },
      // a070102転送用form
      A070102VueForm: {
        companyNm: "",
        prefeNm: "",
        industryId: Number,
        companyId: Number,
        companyIds: [],
        statusFlg: "",
      },
      // a070102テーブルのデータ
      companyList: [],
      // a070102ページ設定
      companyPage: {
        // データ数
        total: 0,
        // table page from
        currentPage: 1,
        // データ数per page
        pageSizes: [10, 30, 50],
        // default データ数per page
        pageSize: 10,
        // 展示ページボタン数
        pagerCount: 5,
        // 順序
        layout: "total, sizes, prev, pager, next, jumper",
        // 当ページの最初の行
        dataStart: 0,
        //当ページの最後の行
        dataEnd: 10,
      },

      // a070103検索条件
      a070103Form: {
        likeSelect: "",
        companyNm: "",
        positionNm: "",
        industryId: "",
        industryIdNm: "",
        jobtypeId: "",
        jobtypeIdNm: "",
        prefeId: "",
        prefeNm: "",
        positionId: Number,
      },
      degree:{
        '0' : 'その他',
        '1' : '職業訓練校、予備校',
        '2' : '専門学校',
        '3' : '短期大学',
        '4' : '大学',
        '5' : '大学院（修士）',
        '6' : '大学院（博士）',
      },
      salarySection:{
        '0' : '年俸',
        '1' : '月給',
        '2' : '日給',
        '3' : '時給',
        '4' : '出来高払い',
        '5' : 'その他',
      },
      expYears:{
        '0' : '不問',
        '1' : '1年未満',
        '2' : '1～3年',
        '3' : '3～5年',
        '4' : '5～10年',
        '5' : '10年以上',
      },
      empLaborIns:{
        '0' : '未加入',
        '1' : '一般の事業',
        '2' : '農林水産',
        '3' : '建計業他',
      },
      welfare:{
        '0' : '有',
        '1' : '無',
      },
      trainingFlg:{
        '0' : '有',
        '1' : '無',
      },
      inspectionFlg:{
        '0' : '有',
        '1' : '無',
      },
      // a070103テーブルのデータ
      positionList: [],
      positionPage: {
        // データ数
        total: 0,
        // table page from
        currentPage: 1,
        // データ数per page
        pageSizes: [10, 30, 50],
        // default データ数per page
        pageSize: 10,
        // 展示ページボタン数
        pagerCount: 5,
        // 順序
        layout: "total, sizes, prev, pager, next, jumper",
        // 当ページの最初の行
        dataStart: 0,
        //当ページの最後の行
        dataEnd: 10,
      },
      // a070103転送用form
      A070103VueForm: {
        likeSelect: "",
        positionNm: "",
        companyNm: "",
        prefeNm: "",
        industryId: "",
        jobtypeId: "",
        positionId: Number,
        statusFlg: "",
        salary: Number,
        companyId: Number,
        listData:[],
      },
      detailedForm3: {
        positionId: "",
        industryNm: "",
        jobTypeNm: "",
        industryId: "",
        jobTypeId: "",
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
        welfare: "",
        expYears: "",
        trainingFlg: "",
        inspectionFlg: "",
        conUpdFlg: "",
        peoCnt: "",
        workDateStr: "",
        holiday: "",
        postal: "",
        workAddress1: "",
        workAddress2: "",
        station: "",
        contractSection: "",
        workingAddress1: "",
        workingAddress2: "",
        workingAddress3: "",
      },



      // a070104検索条件
      a070104Form: {
        companyNm: "",
        trainingNm: "",
        industryId: "",
        industryIdNm: "",
        prefeId: "",
        prefeNm: "",
        trainingId: Number,
      },
      // a070104テーブルのデータ
      trainingList: [],
      trainingPage: {
        // データ数
        total: 0,
        // table page from
        currentPage: 1,
        // データ数per page
        pageSizes: [10, 30, 50],
        // default データ数per page
        pageSize: 10,
        // 展示ページボタン数
        pagerCount: 5,
        // 順序
        layout: "total, sizes, prev, pager, next, jumper",
        // 当ページの最初の行
        dataStart: 0,
        //当ページの最後の行
        dataEnd: 10,
      },
      // a070104転送用form
      A070104VueForm: {
        companyNm: "",
        trainingNm: "",
        prefeNm: "",
        industryId: "",
        trainingId: Number,
        listData:[],
      },
      // 詳細情報form
      detailedForm4: {
        charge: "",
        companyId: "",
        companyNm: "",
        cost: "",
        dateFrom: "",
        dateTo: "",
        industryId: "",
        industryNm: "",
        postal: "",
        prefeNm: "",
        proCnt: "",
        remarks: "",
        statusFlg: "",
        teaIntro: "",
        teaNm: "",
        tel: "",
        timeFrom: "",
        timeTo: "",
        trainingAddress1: "",
        trainingAddress2: "",
        trainingContent: "",
        trainingId: Number,
        trainingNm: "",
        trainingPic1: "",
        trainingPic2: "",
        trainingPic3: "",
      },



      //a070105檢索条件
      a070105Form: {
        companyNm: "",
        briefingNm: "",
        prefeNm: "",
        briefingType: "",
        dateFrom: "",
        dateTo: "",
        briefingId: Number,
      },
      briefing_Type: [
        { value: "0", label: "現場" },
        { value: "1", label: "生放送" },
      ],
      // a070105状態リストのデータ
      briefingType: { 
        '0' : '現場',
        '1' : '生放送',
      },
      // a070105テーブルのデータ
      briefingList: [],
      briefingPage: {
        // データ数
        total: 0,
        // table page from
        currentPage: 1,
        // データ数per page
        pageSizes: [10, 30, 50],
        // default データ数per page
        pageSize: 10,
        // 展示ページボタン数
        pagerCount: 5,
        // 順序
        layout: "total, sizes, prev, pager, next, jumper",
        // 当ページの最初の行
        dataStart: 0,
        //当ページの最後の行
        dataEnd: 10,
      },
      //a070105 転送用form
      A070105VueForm: {
        companyNm: "",
        briefingNm: "",
        prefeNm: "",
        briefingType: "",
        dateFromString:"",
        dateToString: "",
        briefingId: Number,
        listData:[],
      },
      // 詳細情報form
      detailedForm5: {
        briefingId: "",
        companyId: "",
        companyNm: "",
        briefingNm: "",
        briefingType: "",
        briefingDate: "",
        dateFrom: "",
        dateTo: "",
        postal: "",
        prefeNm: "",
        briefingAddress1: "",
        briefingAddress2: "",
        briefingContent: "",
        proCntPlan: "",
        teaNm: "",
        teaIntro: "",
        tel: "",
        charge: "",
        photoAddress1: "",
        photoAddress2: "",
        photoAddress3: "",
        remarks: "",
      },
      
      
      // 取得した業種リスト
      industryIds: "",
      // 取得した都道府県リスト
      prefeIds: "",
      // 取得した業種リスト
      industryList03: "",
      // 取得した職種リスト
      jobtypeList03: "",
      // 取得した都道府県リスト
      prefeList03: "",
      // 取得した業種リスト
      industryList04: "",
      // 取得した都道府県リスト
      prefeList04: "",
      // 取得した業種リスト
      industryList05: "",
      // 取得した都道府県リスト
      prefeList05: "",
      // 承認メッセージ内容
      approvalMessageSuc: {
        title: "承認",
        message: "本当に承認しますか？",
        yes: "はい",
        no: "いいえ",
        success: "承認が成功しました",
        failed: "承認が失敗しました、もう一度お願いします",
        cancel: "承認は取り消されました",
      },
       approvalMessageErr: {
        title: "拒否",
        message: "本当に拒否しますか？",
        yes: "はい",
        no: "いいえ",
        success: "拒否が成功しました",
        failed: "拒否が失敗しました、もう一度お願いします",
        cancel: "拒否は取り消しされました",
      },
    };
  },
 //a070101初期
  mounted() {
    // ページタイトルの切替
    document.title = this.titleName;
    this.administratorComputed();
    this.getCompanyData();
  },
  //a0700101,a070102,a070103,a070104,a070105
  computed: {
    getUserList() {
      return (
        this.userList.slice(this.userPage.dataStart, this.userPage.dataEnd) || ""
      );
    },
    getCompanyList() {
      return (
        this.companyList.slice(this.companyPage.dataStart, this.companyPage.dataEnd) || ""
      );
    },
    getPositionList() {
      return (
        this.positionList.slice(this.positionPage.dataStart, this.positionPage.dataEnd) || ""
      );
    },
    getTrainingList() {
      return (
        this.trainingList.slice(this.trainingPage.dataStart, this.trainingPage.dataEnd) || ""
      );
    },
    getBriefingList() {
      return (
        this.briefingList.slice(this.briefingPage.dataStart, this.briefingPage.dataEnd) || ""
      );
    },
  },
  // beforeRouteEnter(to, from, next) {
  //   next(vm => {
  //     if (!vm.$route.query.authority){
  //       vm.hideTabs();
  //     }else{
  //       vm.authority = JSON.parse(vm.$route.query.authority);
  //       if(vm.authority != "1"){
  //         vm.hideTabs();
  //       }
  //     }
  //   });
  // },
  methods: {
    // hideTabs() {
    //   this.$nextTick(function(){
    //     // 此处的id为tab- name
    //     let dom = document.getElementById('userConfig');
    //     dom.style.display = 'none';
    //     this.$refs.tabs.$children[0].$refs.tabs[4].style.display = 'none';
    //   })
    // },
    administratorComputed() {
      let authority = sessionStorage.getItem("authority");
      if(authority != "スーパー管理者"){
        let dom = document.getElementById('userConfig');
        dom.style.display = 'none';
        this.$refs.tabs.$children[0].$refs.tabs[4].style.display = 'none';
      }else{
        return;
      }
    },

    // 戻るボタン
    toLastPage() {
      this.$router.push({
        path: "/a0003",
      });
    },
    //チェックボックス
    multiSelect(val) {
      this.multipleSelection = val;
    },
    // 多数選択をクリアする
    clearSelection() {
      this.$refs.multipleTable.clearSelection();
      this.$refs.multipleTable2.clearSelection();
      this.$refs.multipleTable3.clearSelection();
      this.$refs.multipleTable4.clearSelection();
      this.$refs.multipleTable5.clearSelection();
    },


    // a070101クリアボタン
    reset070101Form() {
      this.a070101Form = {
        userMail: "",
        userName: "",
        authority: "",
      };
    },
    // a070101初期データ取得
    getUserInit() {
      this.reset070101Form();
      this.setUserData();
      this.$store.dispatch("a070101Search", this.A070101VueForm).then((response) => {
        this.$router.push({
          query: { data: response.data.data },
        });
        // テーブルデータを取得する
        this.userList = response.data.data;
        this.userList.forEach(user => {
          user.userTel = telOnInfo(user.userTel);
        });
        // データ数を取得する
        this.userPage.total = this.userList.length;
      });
    },
    // a070101検索ボタンデータ取得
    getUserData() {
      this.setUserData();
      this.$store.dispatch("a070101Search", this.A070101VueForm).then((response) => {
        this.$router.push({
          query: { data: response.data.data },
        });
        // テーブルデータを取得する
        this.userList = response.data.data;
        this.userList.forEach(user => {
          user.userTel = telOnInfo(user.userTel);
        });
        // データ数を取得する
        this.userPage.total = this.userList.length;
      });
    },
    // a070101検索条件の値を設定する
    setUserData() {
      this.A070101VueForm.userMail = this.a070101Form.userMail;
      this.A070101VueForm.userName = this.a070101Form.userName;
      this.A070101VueForm.authority = this.a070101Form.authority; 
    },
    // a070101毎ページ行目数のselect
    userPageSizeChange(val) {
      this.userPage.pageSize = val;
      this.userPageDataFromTo();
    },
    // a070101当ページのボタン
    userPageCurrentChange(val) {
      this.userPage.currentPage = val;
      this.userPageDataFromTo();
    },
    // a070101テーブル値行範囲の設定
    userPageDataFromTo() {
      this.userPage.dataStart =
        (this.userPage.currentPage - 1) * this.userPage.pageSize;
      this.userPage.dataEnd =
        this.userPage.currentPage * this.userPage.pageSize;
    },
    // a070101行目ボタンのクリック
    getRowData(row) {
      this.$refs.multipleTable.toggleRowSelection(row);
      this.A070101VueForm.authority = row.authority;
    },
    // a070101当行目データ承认
    toUserConfirm() {
      this.clearSelection();
      this.confirmUserMulti();
    },
    // a070101当行目データ拒否
    toUserDeny() {
      this.clearSelection();
      this.denyUserMulti();
    },
    // a070101複数承認    
    confirmUserMulti() {
      this.A070101VueForm.statusFlg = "0";
      this.A070101VueForm.userCds = this.multipleSelection;
      this.userConfirmMessageBox();
    },
    //a070101複数拒否    
    denyUserMulti() {
      this.A070101VueForm.statusFlg = "1";
      this.A070101VueForm.userCds = this.multipleSelection;
      this.userConfirmMessageBox();
    },
    // a070101チェックボックス
    selectionChange(val) {
      this.multipleSelection = [];
      for (var a = 0; a < val.length; a++) {
        this.multipleSelection.push(val[a].userCd);
      }
      this.A070101VueForm.userCds = this.multipleSelection;
    },
    // a070101承認確認ポップアップ
    userConfirmMessageBox() {
      if(this.A070101VueForm.statusFlg == "0"){
        this.approvalMessage = this.approvalMessageSuc;
      }else{
        this.approvalMessage = this.approvalMessageErr;
      }
      this.$confirm(this.approvalMessage.message, this.approvalMessage.title, {
        confirmButtonText: this.approvalMessage.yes,
        cancelButtonText: this.approvalMessage.no,
        type: "warning",
      })
      .then(() => {
        this.$store
          .dispatch("a070101Confirm", this.A070101VueForm)
            .then((response) => {
              this.$router.push({
                query: { data: response.data.data },
              });
              // テーブルデータを取得する
              this.userList = response.data.data;
              // データ数を取得する
              this.userPage.total = this.userList.length;
              this.userList.forEach(user => {
                user.userTel = telOnInfo(user.userTel);
              });
              let code = response.data.code;
              if (code == 200) {
                this.$message({
                  type: "success",
                  message: this.approvalMessage.success,
                });
              }else {
                this.$message({
                  type: "info",
                  message: this.approvalMessage.failed,
                });
              }
            });
      })
      .catch(() => {
        this.$message({
          type: "info",
          message: this.approvalMessage.cancel,
        });
        
      });
    },




    // a070102クリアボタン
    reset070102Form() {
      this.a070102Form = {
        companyNm: "",
        industryId: "",
        industryNm: "",
        prefeId: "",
        prefeNm: "",
      };
    },
    // a070102初期データ取得
    getCompanyInit() {
      this.reset070102Form();
      this.setCompanyData();
      this.$store.dispatch("a070102Search", this.A070102VueForm).then((response) => {
        this.$router.push({
          query: { data: response.data.data },
        });
        // 業種リストを取得する
        this.industryIds = response.data.data.industryMstBean;
        // 業種リストを取得する
        this.prefeIds = response.data.data.prefecturesMstBean;
        // テーブルデータを取得する
        this.companyList = response.data.data.companyListBean;
        this.companyList.forEach(company => {
          company.companyTel = telOnInfo(company.companyTel);
        });
        // データ数を取得する
        this.companyPage.total = this.companyList.length;
      });
    },
    // a070102検索ボタンデータ取得
    getCompanyData() {
      this.setCompanyData();
      this.$store.dispatch("a070102Search", this.A070102VueForm).then((response) => {
        this.$router.push({
          query: { data: response.data.data },
        });
        // 業種リストを取得する
        this.industryIds = response.data.data.industryMstBean;
        // 業種リストを取得する
        this.prefeIds = response.data.data.prefecturesMstBean;
        // テーブルデータを取得する
        this.companyList = response.data.data.companyListBean;
        this.companyList.forEach(company => {
          company.companyTel = telOnInfo(company.companyTel);
        });
        // データ数を取得する
        this.companyPage.total = this.companyList.length;
      });
    },
    // a070102検索条件の値を設定する
    setCompanyData() {
      this.A070102VueForm.industryId = this.a070102Form.industryId;
      this.A070102VueForm.companyNm = this.a070102Form.companyNm;
      this.A070102VueForm.prefeNm = this.a070102Form.prefeNm;
    },
    // 業種select
    setIndustryIdNm02() {
      for (var i = 0; i < this.industryIds.length; i++) {
        if (this.a070102Form.industryId == this.industryIds[i].industryId) {
          this.a070102Form.industryNm = this.industryIds[i].industryNm;
          break;
        }
      }
    },
    // 都道府県select
    setPrefeIdNm02() {
      for (var i = 0; i < this.prefeIds.length; i++) {
        if (this.a070102Form.prefeId == this.prefeIds[i].prefeId) {
          this.a070102Form.prefeNm = this.prefeIds[i].prefeNm;
          break;
        }
      }
    },
    // a070102毎ページ行目数のselect
    companyPageSizeChange(val) {
      this.companyPage.pageSize = val;
      this.companyPageDataFromTo();
    },
    // a070102当ページのボタン
    companyPageCurrentChange(val) {
      this.companyPage.currentPage = val;
      this.companyPageDataFromTo();
    },
    // a070102テーブル値行範囲の設定
    companyPageDataFromTo() {
      this.companyPage.dataStart =
        (this.companyPage.currentPage - 1) * this.companyPage.pageSize;
      this.companyPage.dataEnd =
        this.companyPage.currentPage * this.companyPage.pageSize;
    },
    //a070102行目ボタンのクリック
    getRowData2(row) {
      this.$refs.multipleTable2.toggleRowSelection(row);
    },
    //a070102当行目データ承认
    toCompanyConfirm() {
      this.clearSelection();
      this.confirmCompanyMulti();
    },
    //a070102当行目データ拒否
    toCompanyDeny() {
      this.clearSelection();
      this.denyCompanyMulti();
    },
    //a070102複数承認    
    confirmCompanyMulti() {
      this.A070102VueForm.statusFlg = "1";
      this.A070102VueForm.companyIds = this.multipleSelection;
      this.companyConfirmMessageBox();
    },
    //a070102複数拒否    
    denyCompanyMulti() {
      this.A070102VueForm.statusFlg = "2";
      this.A070102VueForm.companyIds = this.multipleSelection;
      this.companyConfirmMessageBox();
    },
    //a070102チェックボックス
    selectionChange2(val) {
      this.multipleSelection = [];
      for (var a = 0; a < val.length; a++) {
        this.multipleSelection.push(val[a].companyId);
      }
      this.A070102VueForm.companyIds = this.multipleSelection;
    },
    // a070102承認確認ポップアップ
    companyConfirmMessageBox() {
      if(this.A070102VueForm.statusFlg == "1"){
        this.approvalMessage = this.approvalMessageSuc;
      }else{
        this.approvalMessage = this.approvalMessageErr;
      }
      this.$confirm(this.approvalMessage.message, this.approvalMessage.title, {
        confirmButtonText: this.approvalMessage.yes,
        cancelButtonText: this.approvalMessage.no,
        type: "warning",
      })
      .then(() => {
        this.$store
          .dispatch("a070102Confirm", this.A070102VueForm)
            .then((response) => {
              this.$router.push({
                query: { data: response.data.data },
              });
              // 業種リストを取得する
              this.industryIds = response.data.data.industryMstBean;
              // 業種リストを取得する
              this.prefeIds = response.data.data.prefecturesMstBean;
              // テーブルデータを取得する
              this.companyList = response.data.data.companyListBean;
              // データ数を取得する
              this.companyPage.total = this.companyList.length;
              this.companyList.forEach(company => {
                company.companyTel = telOnInfo(company.companyTel);
              });
              let code = response.data.code;
              if (code == 200) {
                this.$message({
                  type: "success",
                  message: this.approvalMessage.success,
                });
              }else {
                this.$message({
                  type: "info",
                  message: this.approvalMessage.failed,
                });
              }
            });
      })
      .catch(() => {
        this.$message({
          type: "info",
          message: this.approvalMessage.cancel,
        });
        
      });
    },




    // a070103クリアボタン
    reset070103Form() {
      this.a070103Form = {
        positionNm: "",
        likeSelect: "",
        industryId: "",
        industryIdNm: "",
        jobtypeId: "",
        jobtypeIdNm: "",
        companyNm: "",
        prefeId: "",
        prefeNm: "",
      };
    },
    // a070103初期データ取得
    getPositionInit() {
      this.reset070103Form();
      this.setPositionData();
      this.$store.dispatch("a070103Search", this.A070103VueForm).then((response) => {
        this.$router.push({
          query: { data: response.data.data },
        });
        // 業種リストを取得する
        this.industryList03 = response.data.data.industryMstBean;
        //職種リストを取得する
        this.jobtypeList03 = response.data.data.jobtypeMstBean;
        //都道府県リストを取得する
        this.prefeList03 = response.data.data.prefecturesMstBean;
        // テーブルデータを取得する
        this.positionList = response.data.data.positionTblBean;
        // データ数を取得する
        this.positionPage.total = this.positionList.length;
      });
    },
    //a070103検索ボタンデータ取得
    getPositionData() {
      this.setPositionData();
      this.$store.dispatch("a070103Search", this.A070103VueForm).then((response) => {
        this.$router.push({
          query: { data: response.data.data },
        });
        // 業種リストを取得する
        this.industryList03 = response.data.data.industryMstBean;
        //職種リストを取得する
        this.jobtypeList03 = response.data.data.jobtypeMstBean;
        //都道府県リストを取得する
        this.prefeList03 = response.data.data.prefecturesMstBean;
        // テーブルデータを取得する
        this.positionList = response.data.data.positionTblBean;
        // データ数を取得する
        this.positionPage.total = this.positionList.length;
      });
    },
    // a070103検索条件の値を設定する
    setPositionData() {
      this.A070103VueForm.likeSelect = this.a070103Form.likeSelect;
      this.A070103VueForm.positionNm = this.a070103Form.positionNm;
      this.A070103VueForm.industryId = this.a070103Form.industryId;
      this.A070103VueForm.jobtypeId = this.a070103Form.jobtypeId;
      this.A070103VueForm.companyNm = this.a070103Form.companyNm;
      this.A070103VueForm.prefeNm = this.a070103Form.prefeNm;
    },
    // 業種select
    setIndustryIdNm03() {
      for (var i = 0; i < this.industryList03.length; i++) {
        if (this.a070103Form.industryId == this.industryList03[i].industryId) {
          this.a070103Form.industryIdNm = this.industryList03[i].industryNm;
          break;
        }
      }
    },
    //職種select
    setJobtypeIdNm03(){
      for (var i = 0; i < this.jobtypeList03.length; i++) {
        if (this.a070103Form.jobtypeId == this.jobtypeList03[i].jobtypeId) {
          this.a070103Form.jobtypeIdNm = this.jobtypeList03[i].jobtypeNm;
          break;
        }
      }
    },
    // 都道府県select
    setPrefeIdNm03() {
      for (var i = 0; i < this.prefeList03.length; i++) {
        if (this.a070103Form.prefeId == this.prefeList03[i].prefeId) {
          this.a070103Form.prefeNm = this.prefeList03[i].prefeNm;
          break;
        }
      }
    },
    // a070103毎ページ行目数のselect
    positionPageSizeChange(val) {
      this.positionPage.pageSize = val;
      this.positionPageDataFromTo();
    },
    // a070103当ページのボタン
    positionPageCurrentChange(val) {
      this.positionPage.currentPage = val;
      this.positionPageDataFromTo();
    },
    // a070103テーブル値行範囲の設定
    positionPageDataFromTo() {
      this.positionPage.dataStart =
        (this.positionPage.currentPage - 1) * this.positionPage.pageSize;
      this.positionPage.dataEnd =
        this.positionPage.currentPage * this.positionPage.pageSize;
    },
    //a070103行目ボタンのクリック
    getRowData3(row) {
      this.detailedForm3 = row;
      this.$refs.multipleTable3.toggleRowSelection(row);
    },
    //a070103当行目データ承认
    toPositionConfirm() {
      this.clearSelection();
      this.confirmPositionMulti();
    },
    //a070103当行目データ拒否
    toPositionDeny() {
      this.clearSelection();
      this.denyPositionMulti();
    },
    //a070103複数承認    
    confirmPositionMulti() {
      this.A070103VueForm.statusFlg = "1";
      this.A070103VueForm.listData = this.listData;
      this.PositionConfirmMessageBox();
    },
    //a070103複数拒否    
    denyPositionMulti() {
      this.A070103VueForm.statusFlg = "2";
      this.A070103VueForm.listData = this.listData;
      this.PositionConfirmMessageBox();
    },
    //a070103チェックボックス
    selectionChange3(val) {
      this.listData = [];
      for (var a = 0; a < val.length; a++) {
        this.multipleSelection.push(val[a].positionId);
        var listDatas = {positionId : val[a].positionId,companyId : val[a].companyId}
        this.listData.push(listDatas);
      }
      this.A070103VueForm.listData = this.listData;
    },
    // a070103承認確認ポップアップ
    PositionConfirmMessageBox() {
      if(this.A070103VueForm.statusFlg == "1"){
        this.approvalMessage = this.approvalMessageSuc;
      }else{
        this.approvalMessage = this.approvalMessageErr;
      }
      this.$confirm(this.approvalMessage.message, this.approvalMessage.title, {
        confirmButtonText: this.approvalMessage.yes,
        cancelButtonText: this.approvalMessage.no,
        type: "warning",
      })
      .then(() => {
        this.$store
          .dispatch("a070103Confirm", this.A070103VueForm)
            .then((response) => {
              this.$router.push({
                query: { data: response.data.data },
              });
               // 業種リストを取得する
              this.industryList03 = response.data.data.industryMstBean;
              //職種リストを取得する
              this.jobtypeList03 = response.data.data.jobtypeMstBean;
              //都道府県リストを取得する
              this.prefeList03 = response.data.data.prefecturesMstBean;
              // テーブルデータを取得する
              this.positionList = response.data.data.positionTblBean;
              // データ数を取得する
              this.positionPage.total = this.positionList.length;
              let code = response.data.code;
              if (code == 200) {
                this.$message({
                  type: "success",
                  message: this.approvalMessage.success,
                });
              }else {
                this.$message({
                  type: "info",
                  message: this.approvalMessage.failed,
                });
              }
            });
      })
      .catch(() => {
        this.$message({
          type: "info",
          message: this.approvalMessage.cancel,
        });
        
      });
    },
    // 詳細情報画面へ
    toB0102Detailed() {
      setTimeout(() => {
        this.$router.push({
          path: "/b0102Detailed",
          query: { flight: JSON.stringify(this.detailedForm3), flgData: JSON.stringify("1") },
        });
      }, 1);
    },



    // a070104クリアボタン
    reset070104Form() {
      this.a070104Form = {
        trainingNm: "",
        industryId: "",
        industryIdNm: "",
        companyNm: "",
        prefeId: "",
        prefeNm: "",
      };
    },
    // a070104初期データ取得
    getTrainingInit() {
      this.reset070104Form();
      this.setTrainingData();
      this.$store.dispatch("a070104Search", this.A070104VueForm).then((response) => {
        this.$router.push({
          query: { data: response.data.data },
        });
        // 業種リストを取得する
        this.industryList04 = response.data.data.industryMstBean;
        //都道府県リストを取得する
        this.prefeList04 = response.data.data.prefecturesMstBean;
        // テーブルデータを取得する
        this.trainingList = response.data.data.trainingInfoTblBean;
        this.trainingList.forEach(training => {
          training.tel = telOnInfo(training.tel);
        });
        // データ数を取得する
        this.trainingPage.total = this.trainingList.length;
      });
    },
    //a070104検索ボタンデータ取得
    getTrainingData() {
      this.setTrainingData();
      this.$store.dispatch("a070104Search", this.A070104VueForm).then((response) => {
        this.$router.push({
          query: { data: response.data.data },
        });
        // 業種リストを取得する
        this.industryList04 = response.data.data.industryMstBean;
        //都道府県リストを取得する
        this.prefeList04 = response.data.data.prefecturesMstBean;
        // テーブルデータを取得する
        this.trainingList = response.data.data.trainingInfoTblBean;
        this.trainingList.forEach(training => {
          training.tel = telOnInfo(training.tel);
        });
        // データ数を取得する
        this.trainingPage.total = this.trainingList.length;
      });
    },
    // a070104検索条件の値を設定する
    setTrainingData() {
      this.A070104VueForm.trainingNm = this.a070104Form.trainingNm;
      this.A070104VueForm.industryId = this.a070104Form.industryId;
      this.A070104VueForm.companyNm = this.a070104Form.companyNm;
      this.A070104VueForm.prefeNm = this.a070104Form.prefeNm;
    },
    // 業種select
    setIndustryIdNm04() {
      for (var i = 0; i < this.industryList04.length; i++) {
        if (this.a070104Form.industryId == this.industryList04[i].industryId) {
          this.a070104Form.industryIdNm = this.industryList04[i].industryNm;
          break;
        }
      }
    },
    // 都道府県select
    setPrefeIdNm04() {
      for (var i = 0; i < this.prefeList04.length; i++) {
        if (this.a070104Form.prefeId == this.prefeList04[i].prefeId) {
          this.a070104Form.prefeNm = this.prefeList04[i].prefeNm;
          break;
        }
      }
    },
    // a070104毎ページ行目数のselect
    trainingPageSizeChange(val) {
      this.trainingPage.pageSize = val;
      this.trainingPageDataFromTo();
    },
    // a070104当ページのボタン
    trainingPageCurrentChange(val) {
      this.trainingPage.currentPage = val;
      this.trainingPageDataFromTo();
    },
    // a070104テーブル値行範囲の設定
    trainingPageDataFromTo() {
      this.trainingPage.dataStart =
        (this.trainingPage.currentPage - 1) * this.trainingPage.pageSize;
      this.trainingPage.dataEnd =
        this.trainingPage.currentPage * this.trainingPage.pageSize;
    },
    //a070104行目ボタンのクリック
    getRowData4(row) {
      this.detailedForm4 = row;
      this.$refs.multipleTable4.toggleRowSelection(row);
    },
    //a070104当行目データ承认
    toTrainingConfirm() {
      this.clearSelection();
      this.confirmTrainingMulti();
    },
    //a070104当行目データ拒否
    toTrainingDeny() {
      this.clearSelection();
      this.denyTrainingMulti();
    },
    //a070104複数承認    
    confirmTrainingMulti() {
      this.A070104VueForm.statusFlg = "1";
      this.A070104VueForm.listData = this.listData;
      this.TrainingConfirmMessageBox();
    },
    //a070104複数拒否    
    denyTrainingMulti() {
      this.A070104VueForm.statusFlg = "2";
      this.A070104VueForm.listData = this.listData;
      this.TrainingConfirmMessageBox();
    },
    //a070104チェックボックス
    selectionChange4(val) {
      this.listData = [];
      for (var a = 0; a < val.length; a++) {
        this.multipleSelection.push(val[a].trainingId);
        var listDatas = {trainingId : val[a].trainingId,companyId : val[a].companyId}
        this.listData.push(listDatas);
      }
      this.A070104VueForm.listData = this.listData;
    },
    // a070104承認確認ポップアップ
    TrainingConfirmMessageBox() {
      if(this.A070104VueForm.statusFlg == "1"){
        this.approvalMessage = this.approvalMessageSuc;
      }else{
        this.approvalMessage = this.approvalMessageErr;
      }
      this.$confirm(this.approvalMessage.message, this.approvalMessage.title, {
        confirmButtonText: this.approvalMessage.yes,
        cancelButtonText: this.approvalMessage.no,
        type: "warning",
      })
      .then(() => {
        this.$store
          .dispatch("a070104Confirm", this.A070104VueForm)
            .then((response) => {
              this.$router.push({
                query: { data: response.data.data },
              });
              // 業種リストを取得する
              this.industryList04 = response.data.data.industryMstBean;
              //都道府県リストを取得する
              this.prefeList04 = response.data.data.prefecturesMstBean;
              // テーブルデータを取得する
              this.trainingList = response.data.data.trainingInfoTblBean;
              this.trainingList.forEach(training => {
                training.tel = telOnInfo(training.tel);
              });
              // データ数を取得する
              this.trainingPage.total = this.trainingList.length;
              let code = response.data.code;
              if (code == 200) {
                this.$message({
                  type: "success",
                  message: this.approvalMessage.success,
                });
              }else {
                this.$message({
                  type: "info",
                  message: this.approvalMessage.failed,
                });
              }
            });
      })
      .catch(() => {
        this.$message({
          type: "info",
          message: this.approvalMessage.cancel,
        });
        
      });
    },
    // 詳細情報画面へ
    toB0502Detailed() {
      setTimeout(() => {
        this.$router.push({
          path: "/b0502Detailed",
          query: { flight: JSON.stringify(this.detailedForm4),flgData: JSON.stringify("1") },
        });
      }, 1);
    },




    // a070105クリアボタン
    reset070105Form() {
      this.a070105Form = {
        companyNm: "",
        briefingNm: "",
        briefingType: "",
        dateFrom: "",
        dateTo: "",
        prefeNm: "",
      };
    },
    //a070105初期データ取得
    getBriefingInit() {
      this.reset070105Form();
      this.setBriefingData();
      this.$store.dispatch("a070105Search", this.A070105VueForm).then((response) => {
         this.$router.push({
            query: { data: response.data.data },
          });
          // テーブルデータを取得する
          this.briefingList = response.data.data.briefingInfoTblBean;
          //都道府県リストを取得する
          this.prefeList05 = response.data.data.prefecturesMstBean;
          this.briefingList.forEach(briefing => {
            briefing.tel = telOnInfo(briefing.tel);
          });
          // データ数を取得する
           this.briefingPage.total = this.briefingList.length;
        });
    },
    //a070105検索ボタンデータ取得
    getBriefingData() {
      this.setBriefingData();
      this.$store.dispatch("a070105Search", this.A070105VueForm).then((response) => {
         this.$router.push({
            query: { data: response.data.data },
          });
          // テーブルデータを取得する
          this.briefingList = response.data.data.briefingInfoTblBean;
          //都道府県リストを取得する
          this.prefeList05 = response.data.data.prefecturesMstBean;
          this.briefingList.forEach(briefing => {
            briefing.tel = telOnInfo(briefing.tel);
          });
          // データ数を取得する
           this.briefingPage.total = this.briefingList.length;
        });
    },
    //a070105検索条件の値を設定する
    setBriefingData() {
      this.A070105VueForm.briefingType = this.a070105Form.briefingType;
      this.A070105VueForm.companyNm = this.a070105Form.companyNm;
      this.A070105VueForm.briefingNm = this.a070105Form.briefingNm;
      this.A070105VueForm.prefeNm = this.a070105Form.prefeNm;
      this.A070105VueForm.dateFromString = this.a070105Form.dateFrom;
      this.A070105VueForm.dateToString = this.a070105Form.dateTo;
    },
    // 都道府県select
    setPrefeIdNm05() {
      for (var i = 0; i < this.prefeList05.length; i++) {
        if (this.a070105Form.prefeId == this.prefeList05[i].prefeId) {
          this.a070105Form.prefeNm = this.prefeList05[i].prefeNm;
          break;
        }
      }
    },
    // a070105毎ページ行目数のselect
    briefingPageSizeChange(val) {
      this.briefingPage.pageSize = val;
      this.briefingPageDataFromTo();
    },
    // a070105当ページのボタン
    briefingPageCurrentChange(val) {
      this.briefingPage.currentPage = val;
      this.briefingPageDataFromTo();
    },
    // a070105テーブル値行範囲の設定
    briefingPageDataFromTo() {
      this.briefingPage.dataStart =
        (this.briefingPage.currentPage - 1) * this.briefingPage.pageSize;
      this.briefingPage.dataEnd =
        this.briefingPage.currentPage * this.briefingPage.pageSize;
    },
    //a070105行目ボタンのクリック
    getRowData5(row) {
      this.detailedForm5 = row;
      this.$refs.multipleTable5.toggleRowSelection(row);
    },
    //a070105当行目データ承认
    toBriefingConfirm() {
      this.clearSelection();
      this.confirmBriefingMulti();
    },
    //a070105当行目データ拒否
    toBriefingDeny() {
      this.clearSelection();
      this.denyBriefingMulti();
    },
    //a070105複数承認    
    confirmBriefingMulti() {
      this.A070105VueForm.statusFlg = "1";
      this.A070105VueForm.listData = this.listData;
      this.BriefingConfirmMessageBox();
    },
    //a070105複数拒否    
    denyBriefingMulti() {
      this.A070105VueForm.statusFlg = "2";
      this.A070105VueForm.listData = this.listData;
      this.BriefingConfirmMessageBox();
    },
    //a070105チェックボックス
    selectionChange5(val) {
      this.listData = [];
      for (var a = 0; a < val.length; a++) {
        this.multipleSelection.push(val[a].briefingId);
        var listDatas = {briefingId : val[a].briefingId,companyId : val[a].companyId}
        this.listData.push(listDatas);
      }
      this.A070105VueForm.listData = this.listData;
    },
    // a070105承認確認ポップアップ
    BriefingConfirmMessageBox() {
      if(this.A070105VueForm.statusFlg == "1"){
        this.approvalMessage = this.approvalMessageSuc;
      }else{
        this.approvalMessage = this.approvalMessageErr;
      }
      this.$confirm(this.approvalMessage.message, this.approvalMessage.title, {
        confirmButtonText: this.approvalMessage.yes,
        cancelButtonText: this.approvalMessage.no,
        type: "warning",
      })
      .then(() => {
        this.$store
          .dispatch("a070105Confirm", this.A070105VueForm)
            .then((response) => {
              this.$router.push({
                query: { data: response.data.data },
              });
              // テーブルデータを取得する
              this.briefingList = response.data.data.briefingInfoTblBean;
              //都道府県リストを取得する
              this.prefeList05 = response.data.data.prefecturesMstBean;
              this.briefingList.forEach(briefing => {
                briefing.tel = telOnInfo(briefing.tel);
              });
              // データ数を取得する
              this.briefingPage.total = this.briefingList.length;
              let code = response.data.code;
              if (code == 200) {
                this.$message({
                  type: "success",
                  message: this.approvalMessage.success,
                });
              }else {
                this.$message({
                  type: "info",
                  message: this.approvalMessage.failed,
                });
              }
            });
      })
      .catch(() => {
        this.$message({
          type: "info",
          message: this.approvalMessage.cancel,
        });
      });
    },
    // 詳細情報画面へ
    toB0602Detailed() {
      setTimeout(() => {
        this.$router.push({
          path: "/b0602Detailed",
          query: { flight: JSON.stringify(this.detailedForm5),flgData: JSON.stringify("1") },
        });
      }, 1);
    },


  },
};
</script>

<style lang="scss" scoped>
// 主体页面灰色
.a0701_body {
  background-color: #f6f6f6;
}
/* 两个主体部分边框阴影，白色背景 */
.a0701_select,
.a0701_data {
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 0 rgba(0, 0, 0, 0.04);
  background-color: #ffffff;
}
// 内容body、两个主体外边距
.a0701_body,
.a0701_data,
.data_select {
  margin: 1vh, 1vh, 0px, 0px;
}
// 研修一覧标题右移1%
.a0701_title {
  margin-left: 1%;
  height: 80px;
}
// 两部分主体宽80vw，居中
.a0701_select,
.a0701_data {
  width: 80vw;
  margin: auto;
}
.titleNameStyle {
  color: #006699;
  font-weight: 600;
  font-size: 2em;
  margin-top: 1vh;
  border: 2px solid#dfdfdf;border-bottom:0;border-radius:5px;
  text-indent: 2vw;
  padding: 4vh 0vh;
  width: 80vw;
  margin: auto;
  background-color: #fff;
}
// 行上下内边距填充1vh
.el-row {
  padding-top: 1vh;
  padding-bottom: 1vh;
}
// 部分文字上下边距1vh，白底蓝字粗体
.a0701_title,
.blue_font {
  margin-top: 5vh;
  margin-bottom: 1vh;
  background-color: #ffffff;
  color: #006699;
  font-weight: 600;
}
// 字号30
.a0701_title {
  font-size: 30px;
}
// 灰色上边线，上内边距
.select_body {
  padding-top: 2vh;
}
// 检索按钮所在div内边距，底部外边距
.a0701_button {
  padding-top: 2vh;
  padding-bottom: 2vh;
  margin-bottom: 2vh;
}
// 页眉页脚宽
.header,
.footer {
  width: 100vw auto;
}
// 按钮本体
.a0701Button {
  width: 110px;
}
// saveアイコンの大きさ
.el-icon-circle-check,
.el-icon-circle-close,
.el-icon-document-remove,
.el-icon-back,
.el-icon-search,
.el-icon-document
 {
  font-size: 30px;
}
// TABSytle
::v-deep .el-tabs{
  background-color: #fff;
  font-size: 18px;
  .el-tabs__header {
    .el-tabs__nav-wrap {
      .el-tabs__nav-scroll{
        .el-tabs__nav {
          .el-tabs__item{
            font-size: 18px ;
            font-family: '微软雅黑';
             font-weight: 600;
            width: 200px;
            text-align: center;
            height: 50px;
            line-height: 50px;
            color: 	#B8B8B8;
            padding: 0px;
          }
          .el-tabs__active-bar{
            height: 0;
          }
          .el-tabs__item.is-active{
            color: #409EFF;
          }
        }
      }
    }
  }
}
.demo-table-expand {
  font-size: 0;
}
.demo-table-expand label {
  width: 80px;
  color: #99a9bf;
}
.demo-table-expand .el-form-item {
  margin-left: 5%;
  margin-right: 0;
  margin-bottom: 0;
  width: 40%;
}
// テーブル内ボタン
::v-deep .el-table .cell .em {
  padding: 0;
}
// ページネーションのデータ数毎ページの幅
::v-deep .el-pagination .el-select .el-input {
  width: 2rem;
}
</style>