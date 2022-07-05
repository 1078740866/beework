<template>
  <div>
    <el-container>
      <el-header>
        <div class="header">
          <ApplicantHeader />
        </div>
      </el-header>
      <el-form :model="c0201Form" ref="c0201Form" label-position="left" autocomplete="on">
        <el-main class="b0501_body">
          <div class="b0501_select">
            <el-row>
              <el-col :span="24">
                <div class="b0501_title">職位一覧</div>
              </el-col>
            </el-row>
            <div class="select_body">
              <el-row :gutter="1">
                <el-col :span="7" :offset="1">
                  <div>
                    <el-form-item label-width="0px">
                      <el-input
                        v-model="c0201Form.likeSelect"
                        placeholder="職位名を入力してください"
                      />
                    </el-form-item>
                  </div>
                </el-col>
                <el-col :span="4" :offset="1">
                  <div>
                    <el-form-item label="地域：" label-width="50px">
                      <el-select v-model="c0201Form.prefeNm" placeholder="地域" clearable>
                        <el-option
                          v-for="item in prefecturesMstBean"
                          :key="item.prefeId"
                          :label="item.prefeNm"
                          :value="item.prefeNm"
                        />
                      </el-select>
                    </el-form-item>
                  </div>
                </el-col>
                <el-col :span="6" :offset="1">
                  <div>
                    <el-form-item label="会社名：" label-width="65px">
                      <el-input v-model="c0201Form.companyNm" placeholder="会社名" />
                    </el-form-item>
                  </div>
                </el-col>
              </el-row>
            </div>
            <el-row :gutter="1">
              <el-col :span="5" :offset="1">
                <div>
                  <el-form-item label="給料区分：" label-width="80px">
                    <el-select
                      v-model="c0201Form.salarySection"
                      placeholder="給料区分"
                      clearable
                    >
                      <el-option
                        v-for="item in kyuryoKbList"
                        :key="item.salarySection"
                        :label="item.label"
                        :value="item.salarySection"
                      />
                    </el-select>
                  </el-form-item>
                </div>
              </el-col>
              <el-col :span="5" :offset="1">
                <el-row class="c0201row">
                  <el-col :span="19">
                    <el-form-item label="給料：" label-width="50px">
                      <el-input
                        v-model="salary"
                        @input="numValid()"
                        maxlength="10"
                        placeholder="給料"
                    /></el-form-item>
                  </el-col>
                  <el-col :span="5" class="xialaiyidian">円以上</el-col>
                </el-row>
              </el-col>
              <el-col :span="5" :offset="1">
                <div>
                  <el-form-item label="業種：" label-width="50px">
                    <el-select v-model="industryId" placeholder="業種" clearable>
                      <el-option
                        v-for="item in industryMstBean"
                        :key="item.industryId"
                        :label="item.industryNm"
                        :value="item.industryId"
                      />
                    </el-select>
                  </el-form-item>
                </div>
              </el-col>
              <el-col :span="5" :offset="1">
                <div>
                  <el-form-item label="職種：" label-width="50px">
                    <el-select v-model="jobtypeId" placeholder="職種" clearable>
                      <el-option
                        v-for="item in jobtypeMstBean"
                        :key="item.jobtypeId"
                        :label="item.jobtypeNm"
                        :value="item.jobtypeId"
                      />
                    </el-select>
                  </el-form-item>
                </div>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="5" :offset="1">
                <div>
                  <el-form-item label="学歴要求：" label-width="80px">
                    <el-select
                      v-model="c0201Form.degree"
                      placeholder="学歴要求"
                      clearable
                    >
                      <el-option
                        v-for="item in gakurekiList"
                        :key="item.gakurekiId"
                        :label="item.gakurekiNm"
                        :value="item.gakurekiNm"
                      />
                    </el-select>
                  </el-form-item>
                </div>
              </el-col>
              <el-col :span="5" :offset="1">
                <div>
                  <el-form-item label="雇用・労災保険：" label-width="120px">
                    <el-select
                      v-model="c0201Form.empLaborIns"
                      placeholder="雇用・労災保険"
                      clearable
                    >
                      <el-option
                        v-for="item in hokenList"
                        :key="item.hokenId"
                        :label="item.hokenNm"
                        :value="item.hokenNm"
                      />
                    </el-select>
                  </el-form-item>
                </div>
              </el-col>
              <el-col :span="5" :offset="1">
                <div>
                  <el-form-item label="必要経験：" label-width="80px">
                    <el-select
                      v-model="c0201Form.expYears"
                      placeholder="必要経験"
                      clearable
                    >
                      <el-option
                        v-for="item in keikenList"
                        :key="item.keikenId"
                        :label="item.keikenNm"
                        :value="item.keikenNm"
                      />
                    </el-select>
                  </el-form-item>
                </div>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="5" :offset="1">
                <div>
                  <el-form-item label="見学：" label-width="50px">
                    <el-radio v-model="inspectionFlg" label="0">有り</el-radio>
                    <el-radio v-model="inspectionFlg" label="1">無し</el-radio>
                  </el-form-item>
                </div>
              </el-col>
              <el-col :span="6" :offset="1">
                <div>
                  <el-form-item label="福利厚生：" label-width="80px">
                    <el-radio v-model="welfare" label="0">有り</el-radio>
                    <el-radio v-model="welfare" label="1">無し</el-radio>
                  </el-form-item>
                </div>
              </el-col>
              <el-col :span="5" :offset="1">
                <div>
                  <el-form-item label="研修：" label-width="50px">
                    <el-radio v-model="trainingFlg" label="0">有り</el-radio>
                    <el-radio v-model="trainingFlg" label="1">無し</el-radio>
                  </el-form-item>
                </div>
              </el-col>
            </el-row>
            <div class="b0501_button">
              <el-row type="flex" justify="center">
                <el-col :span="4">
                  <el-tooltip effect="light" content="条件クリア" placement="top">
                    <el-link @click="clearJoken" type="primary" :underline="false">
                      <i class="el-icon-document-remove"></i>
                    </el-link>
                  </el-tooltip>
                  <!-- <div>
                    <el-button type="primary" @click="clearJoken" class="b0501Button">
                      条件クリア
                    </el-button>
                  </div> -->
                </el-col>
                <el-col :span="4">
                  <el-tooltip effect="light" content="検索" placement="top">
                    <el-link @click="getKensakuData" type="primary" :underline="false">
                      <i class="el-icon-search"></i>
                    </el-link>
                  </el-tooltip>
                  <!-- <div>
                    <el-button
                      type="primary"
                      @click="getKensakuData"
                      icon="el-icon-search"
                      class="b0501Button"
                    >
                      検索
                    </el-button>
                  </div> -->
                </el-col>
                <el-col :span="4">
                  <el-tooltip effect="light" content="戻る" placement="top">
                    <el-link @click="toLastPage" type="primary" :underline="false">
                      <i class="el-icon-back"></i>
                    </el-link>
                  </el-tooltip>
                  <!-- <div>
                    <el-button type="primary" @click="toLastPage" class="b0501Button">
                      戻る
                    </el-button>
                  </div> -->
                </el-col>
              </el-row>
            </div>
          </div>
          <div class="b0501_data">
            <el-tabs v-model="activeName" @tab-click="handleClick" type="card">
              <el-tab-pane name="first" label="職位推薦">
                <el-table
                  ref="suisenTable"
                  :data="getSyokuiList"
                  style="width: 100%"
                  height="350px"
                  @select="handSelect"
                  @select-all="handSelectAll"
                >
                  <el-table-column type="expand">
                    <template slot-scope="props">
                      <el-form
                        label-position="left"
                        inline
                        class="demo-table-expand"
                        label-width="100px"
                      >
                        <el-form-item label="必須経験年数" class="biaolanmu">
                          <span>
                            {{ keikenList[props.row.expYears].keikenNm }}
                          </span>
                        </el-form-item>
                        <el-form-item label="給料" class="biaolanmu">
                          <span>
                            {{ props.row.salaryMin }} - {{ props.row.salaryMax }}円
                          </span>
                        </el-form-item>
                        <el-form-item label="学歴" class="biaolanmu">
                          <span v-if="props.row.degree == '0'">大卒以上</span>
                          <span v-if="props.row.degree == '1'">専門卒以上</span>
                          <span v-if="props.row.degree == '2'">高卒以上</span>
                          <span v-if="props.row.degree == '3'">大卒</span>
                          <span v-if="props.row.degree == '4'">専門卒</span>
                          <span v-if="props.row.degree == '5'">高卒</span>
                          <span v-if="props.row.degree == '6'">学歴不問</span>
                        </el-form-item>
                        <el-form-item label="最寄駅" class="biaolanmu">
                          <span>
                            {{ props.row.station }}
                          </span>
                        </el-form-item>
                        <el-form-item label="雇用・労災保険" class="biaolanmu">
                          <span v-if="props.row.empLaborIns == '0'">未加入</span>
                          <span v-if="props.row.empLaborIns == '1'">一般の事業</span>
                          <span v-if="props.row.empLaborIns == '2'">農林水産</span>
                          <span v-if="props.row.empLaborIns == '3'">建計業他</span>
                        </el-form-item>
                        <el-form-item label="福利厚生" class="biaolanmu">
                          <span v-if="props.row.welfare == '0'">有り</span>
                          <span v-if="props.row.welfare == '1'">無し</span>
                        </el-form-item>
                        <el-form-item label="研修有無" class="biaolanmu">
                          <span v-if="props.row.trainingFlg == '0'">有り</span>
                          <span v-if="props.row.trainingFlg == '1'">無し</span>
                        </el-form-item>
                        <el-form-item label="見学有無" class="biaolanmu">
                          <span v-if="props.row.inspectionFlg == '0'">有り</span>
                          <span v-if="props.row.inspectionFlg == '1'">無し</span>
                        </el-form-item>
                      </el-form>
                    </template>
                  </el-table-column>
                  <el-table-column type="selection" fixed="left" width="50" />
                  <el-table-column
                    prop="companyId"
                    label="companyId"
                    width="100"
                    v-if="false"
                  />
                  <el-table-column
                    prop="positionId"
                    label="positionId"
                    width="100"
                    v-if="false"
                  />
                  <el-table-column prop="positionNm" label="職位名" width="150" />
                  <el-table-column prop="companyNm" label="会社名" width="150" />
                  <!-- <el-table-column prop="expYears" label="必須経験年数" width="100" /> -->
                  <el-table-column prop="industryNm" label="業種" width="150" />
                  <el-table-column prop="jobTypeNm" label="職種" />
                  <!-- <el-table-column prop="salaryMin" label="最低限給料" width="100" />
                  <el-table-column prop="salaryMax" label="最高限給料" width="100" /> -->
                  <!-- <el-table-column prop="station" label="最寄駅" width="100" />
                  <el-table-column
                    prop="empLaborIns"
                    label="雇用・労災保険"
                    width="120"
                  /> -->
                  <!-- <el-table-column prop="welfare" label="福利厚生" width="100" />
                  <el-table-column prop="trainingFlg" label="研修有無" width="100" />
                  <el-table-column prop="inspectionFlg" label="見学有無" width="100" /> -->
                  <el-table-column fixed="right" width="70" label="応募する">
                    <template slot-scope="scope">
                      <el-button type="text" size="large" @click="insertPost(scope.row)">
                        <em class="el-icon-thumb" />
                      </el-button>
                    </template>
                  </el-table-column>
                  <el-table-column fixed="right" width="70" label="気に入る">
                    <template slot-scope="scope">
                      <el-button type="text" size="large" @click="insertLike(scope.row)">
                        <em class="el-icon-star-off" />
                      </el-button>
                    </template>
                  </el-table-column>
                </el-table>
                <el-row type="flex" justify="end" class="hanggao">
                  <el-col :span="1">
                    <el-button type="text" size="large" @click="selectoubo">
                      <em class="el-icon-thumb" />
                    </el-button>
                  </el-col>
                  <el-col :span="1">
                    <el-button type="text" size="large" @click="selectkiniiru">
                      <em class="el-icon-star-off" />
                    </el-button>
                  </el-col>
                </el-row>
                <div class="page">
                  <el-row type="flex" justify="space-around">
                    <el-col :span="12">
                      <el-pagination
                        :total="pagination.total"
                        :current-page="pagination.currentPage"
                        :pager-count="pagination.pagerCount"
                        :page-sizes="pagination.pageSizes"
                        :page-size="pagination.pageSize"
                        :background="true"
                        :layout="pagination.layout"
                        @size-change="sizeChange"
                        @current-change="currentChange"
                      />
                    </el-col>
                  </el-row>
                </div>
                <!-- <el-row type="flex" justify="end">
                  <el-col :span="1">
                    <el-button type="text" size="large" @click="selectoubo">
                      <em class="el-icon-thumb" />
                    </el-button>
                  </el-col>
                  <el-col :span="1">
                    <el-button type="text" size="large" @click="selectkiniiru">
                      <em class="el-icon-star-off" />
                    </el-button>
                  </el-col>
                </el-row> -->
              </el-tab-pane>
              <el-tab-pane label="応募済み" name="second"
                ><el-table
                  ref="ouboTable"
                  :data="getSyokuiList"
                  style="width: 100%"
                  height="350px"
                >
                  <el-table-column type="expand">
                    <template slot-scope="props">
                      <el-form label-position="left" inline class="demo-table-expand">
                        <el-form-item label="必須経験年数" class="biaolanmu">
                          <span>
                            {{ keikenList[props.row.expYears].keikenNm }}
                          </span>
                        </el-form-item>
                        <el-form-item label="給料" class="biaolanmu">
                          <span>
                            {{ props.row.salaryMin }} - {{ props.row.salaryMax }}円
                          </span>
                        </el-form-item>
                        <el-form-item label="学歴" class="biaolanmu">
                          <span v-if="props.row.degree == '0'">大卒以上</span>
                          <span v-if="props.row.degree == '1'">専門卒以上</span>
                          <span v-if="props.row.degree == '2'">高卒以上</span>
                          <span v-if="props.row.degree == '3'">大卒</span>
                          <span v-if="props.row.degree == '4'">専門卒</span>
                          <span v-if="props.row.degree == '5'">高卒</span>
                          <span v-if="props.row.degree == '6'">学歴不問</span>
                        </el-form-item>
                        <el-form-item label="最寄駅" class="biaolanmu">
                          <span>
                            {{ props.row.station }}
                          </span>
                        </el-form-item>
                        <el-form-item label="雇用・労災保険" class="biaolanmu">
                          <span v-if="props.row.empLaborIns == '0'">未加入</span>
                          <span v-if="props.row.empLaborIns == '1'">一般の事業</span>
                          <span v-if="props.row.empLaborIns == '2'">農林水産</span>
                          <span v-if="props.row.empLaborIns == '3'">建計業他</span>
                        </el-form-item>
                        <el-form-item label="福利厚生" class="biaolanmu">
                          <span v-if="props.row.welfare == '0'">有り</span>
                          <span v-if="props.row.welfare == '1'">無し</span>
                        </el-form-item>
                        <el-form-item label="研修有無" class="biaolanmu">
                          <span v-if="props.row.trainingFlg == '0'">有り</span>
                          <span v-if="props.row.trainingFlg == '1'">無し</span>
                        </el-form-item>
                        <el-form-item label="見学有無" class="biaolanmu">
                          <span v-if="props.row.inspectionFlg == '0'">有り</span>
                          <span v-if="props.row.inspectionFlg == '1'">無し</span>
                        </el-form-item>
                      </el-form>
                    </template>
                  </el-table-column>
                  <!-- <el-table-column type="selection" fixed="left" width="50" /> -->
                  <el-table-column
                    prop="companyId"
                    label="companyId"
                    width="100"
                    v-if="false"
                  />
                  <el-table-column
                    prop="positionId"
                    label="positionId"
                    width="100"
                    v-if="false"
                  />
                  <el-table-column prop="positionNm" label="職位名" width="150" />
                  <el-table-column prop="companyNm" label="会社名" width="150" />
                  <!-- <el-table-column prop="expYears" label="必須経験年数" width="100" /> -->
                  <el-table-column prop="industryNm" label="業種" width="150" />
                  <el-table-column prop="jobTypeNm" label="職種" />
                  <!-- <el-table-column prop="salaryMin" label="最低限給料" width="100" />
                  <el-table-column prop="salaryMax" label="最高限給料" width="100" />
                  <el-table-column prop="station" label="最寄駅" width="100" />
                  <el-table-column
                    prop="empLaborIns"
                    label="雇用・労災保険"
                    width="120"
                  />
                  <el-table-column prop="welfare" label="福利厚生" width="100" />
                  <el-table-column prop="trainingFlg" label="研修有無" width="100" />
                  <el-table-column prop="inspectionFlg" label="見学有無" width="100" /> -->
                  <!-- <el-table-column fixed="right" width="50">
                    <el-button type="text" size="large" @click="toB0502Detailed">
                      <em class="el-icon-document" />
                    </el-button>
                  </el-table-column>
                  <el-table-column fixed="right" width="50">
                    <el-button type="text" size="large" @click="toB0502Modify">
                      <em class="el-icon-edit" />
                    </el-button>
                  </el-table-column> -->
                </el-table>
                <el-row class="hanggao"></el-row>
                <div class="page">
                  <el-row type="flex" justify="space-around">
                    <el-col :span="12">
                      <el-pagination
                        :total="pagination.total"
                        :current-page="pagination.currentPage"
                        :pager-count="pagination.pagerCount"
                        :page-sizes="pagination.pageSizes"
                        :page-size="pagination.pageSize"
                        :background="true"
                        :layout="pagination.layout"
                        @size-change="sizeChange"
                        @current-change="currentChange"
                      />
                    </el-col>
                  </el-row>
                </div>
              </el-tab-pane>
              <el-tab-pane label="気に入る" name="third"
                ><el-table
                  ref="kiniTable"
                  :data="getSyokuiList"
                  style="width: 100%"
                  height="350px"
                  @select="handSelect"
                  @select-all="handSelectAll"
                >
                  <el-table-column type="expand">
                    <template slot-scope="props">
                      <el-form
                        label-position="left"
                        inline
                        class="demo-table-expand"
                        label-width="100px"
                      >
                        <el-form-item label="必須経験年数" class="biaolanmu">
                          <span>
                            {{ keikenList[props.row.expYears].keikenNm }}
                          </span>
                        </el-form-item>
                        <el-form-item label="給料" class="biaolanmu">
                          <span>
                            {{ props.row.salaryMin }} - {{ props.row.salaryMax }}円
                          </span>
                        </el-form-item>
                        <el-form-item label="学歴" class="biaolanmu">
                          <span v-if="props.row.degree == '0'">大卒以上</span>
                          <span v-if="props.row.degree == '1'">専門卒以上</span>
                          <span v-if="props.row.degree == '2'">高卒以上</span>
                          <span v-if="props.row.degree == '3'">大卒</span>
                          <span v-if="props.row.degree == '4'">専門卒</span>
                          <span v-if="props.row.degree == '5'">高卒</span>
                          <span v-if="props.row.degree == '6'">学歴不問</span>
                        </el-form-item>
                        <el-form-item label="最寄駅" class="biaolanmu">
                          <span>
                            {{ props.row.station }}
                          </span>
                        </el-form-item>
                        <el-form-item label="雇用・労災保険" class="biaolanmu">
                          <span v-if="props.row.empLaborIns == '0'">未加入</span>
                          <span v-if="props.row.empLaborIns == '1'">一般の事業</span>
                          <span v-if="props.row.empLaborIns == '2'">農林水産</span>
                          <span v-if="props.row.empLaborIns == '3'">建計業他</span>
                        </el-form-item>
                        <el-form-item label="福利厚生" class="biaolanmu">
                          <span v-if="props.row.welfare == '0'">有り</span>
                          <span v-if="props.row.welfare == '1'">無し</span>
                        </el-form-item>
                        <el-form-item label="研修有無" class="biaolanmu">
                          <span v-if="props.row.trainingFlg == '0'">有り</span>
                          <span v-if="props.row.trainingFlg == '1'">無し</span>
                        </el-form-item>
                        <el-form-item label="見学有無" class="biaolanmu">
                          <span v-if="props.row.inspectionFlg == '0'">有り</span>
                          <span v-if="props.row.inspectionFlg == '1'">無し</span>
                        </el-form-item>
                      </el-form>
                    </template>
                  </el-table-column>
                  <el-table-column type="selection" fixed="left" width="50" />
                  <el-table-column
                    prop="companyId"
                    label="companyId"
                    width="100"
                    v-if="false"
                  />
                  <el-table-column
                    prop="positionId"
                    label="positionId"
                    width="100"
                    v-if="false"
                  />
                  <el-table-column prop="positionNm" label="職位名" width="150" />
                  <el-table-column prop="companyNm" label="会社名" width="150" />
                  <!-- <el-table-column prop="expYears" label="必須経験年数" width="100" /> -->
                  <el-table-column prop="industryNm" label="業種" width="150" />
                  <el-table-column prop="jobTypeNm" label="職種" />
                  <!-- <el-table-column prop="salaryMin" label="最低限給料" width="100" />
                  <el-table-column prop="salaryMax" label="最高限給料" width="100" />
                  <el-table-column prop="station" label="最寄駅" width="100" />
                  <el-table-column
                    prop="empLaborIns"
                    label="雇用・労災保険"
                    width="120"
                  />
                  <el-table-column prop="welfare" label="福利厚生" width="100" />
                  <el-table-column prop="trainingFlg" label="研修有無" width="100" />
                  <el-table-column prop="inspectionFlg" label="見学有無" width="100" /> -->
                  <el-table-column fixed="right" width="70" label="応募する">
                    <template slot-scope="scope">
                      <el-button type="text" size="large" @click="updateLike(scope.row)">
                        <em class="el-icon-thumb" />
                      </el-button>
                    </template>
                  </el-table-column>
                  <el-table-column fixed="right" width="70" label="削除する">
                    <template slot-scope="scope">
                      <el-button
                        type="text"
                        size="large"
                        @click="deleteApplication(scope.row)"
                      >
                        <em class="el-icon-delete" />
                      </el-button>
                    </template>
                  </el-table-column>
                </el-table>
                <el-row type="flex" justify="end" class="hanggao">
                  <el-col :span="1">
                    <el-button type="text" size="large" @click="selectupdate">
                      <em class="el-icon-thumb" />
                    </el-button>
                  </el-col>
                  <el-col :span="1">
                    <el-button type="text" size="large" @click="selectdelete">
                      <em class="el-icon-delete" />
                    </el-button>
                  </el-col>
                </el-row>
                <div class="page">
                  <el-row type="flex" justify="space-around">
                    <el-col :span="12">
                      <el-pagination
                        :total="pagination.total"
                        :current-page="pagination.currentPage"
                        :pager-count="pagination.pagerCount"
                        :page-sizes="pagination.pageSizes"
                        :page-size="pagination.pageSize"
                        :background="true"
                        :layout="pagination.layout"
                        @size-change="sizeChange"
                        @current-change="currentChange"
                      />
                    </el-col>
                  </el-row>
                </div>
              </el-tab-pane>
              <el-tab-pane label="職位一覧" name="forth">
                <el-table
                  ref="ichiranTable"
                  :data="getSyokuiList"
                  style="width: 100%"
                  height="350px"
                  @select="handSelect"
                  @select-all="handSelectAll"
                >
                  <el-table-column type="expand">
                    <template slot-scope="props">
                      <el-form
                        label-position="left"
                        inline
                        class="demo-table-expand"
                        label-width="100px"
                      >
                        <el-form-item label="必須経験年数" class="biaolanmu">
                          <span>
                            {{ keikenList[props.row.expYears].keikenNm }}
                          </span>
                        </el-form-item>
                        <el-form-item label="給料" class="biaolanmu">
                          <span>
                            {{ props.row.salaryMin }} - {{ props.row.salaryMax }}円
                          </span>
                        </el-form-item>
                        <el-form-item label="学歴" class="biaolanmu">
                          <span v-if="props.row.degree == '0'">大卒以上</span>
                          <span v-if="props.row.degree == '1'">専門卒以上</span>
                          <span v-if="props.row.degree == '2'">高卒以上</span>
                          <span v-if="props.row.degree == '3'">大卒</span>
                          <span v-if="props.row.degree == '4'">専門卒</span>
                          <span v-if="props.row.degree == '5'">高卒</span>
                          <span v-if="props.row.degree == '6'">学歴不問</span>
                        </el-form-item>
                        <el-form-item label="最寄駅" class="biaolanmu">
                          <span>
                            {{ props.row.station }}
                          </span>
                        </el-form-item>
                        <el-form-item label="雇用・労災保険" class="biaolanmu">
                          <span v-if="props.row.empLaborIns == '0'">未加入</span>
                          <span v-if="props.row.empLaborIns == '1'">一般の事業</span>
                          <span v-if="props.row.empLaborIns == '2'">農林水産</span>
                          <span v-if="props.row.empLaborIns == '3'">建計業他</span>
                        </el-form-item>
                        <el-form-item label="福利厚生" class="biaolanmu">
                          <span v-if="props.row.welfare == '0'">有り</span>
                          <span v-if="props.row.welfare == '1'">無し</span>
                        </el-form-item>
                        <el-form-item label="研修有無" class="biaolanmu">
                          <span v-if="props.row.trainingFlg == '0'">有り</span>
                          <span v-if="props.row.trainingFlg == '1'">無し</span>
                        </el-form-item>
                        <el-form-item label="見学有無" class="biaolanmu">
                          <span v-if="props.row.inspectionFlg == '0'">有り</span>
                          <span v-if="props.row.inspectionFlg == '1'">無し</span>
                        </el-form-item>
                      </el-form>
                    </template>
                  </el-table-column>
                  <el-table-column type="selection" fixed="left" width="50" />
                  <el-table-column
                    prop="companyId"
                    label="companyId"
                    width="100"
                    v-if="false"
                  />
                  <el-table-column
                    prop="positionId"
                    label="positionId"
                    width="100"
                    v-if="false"
                  />
                  <el-table-column prop="positionNm" label="職位名" width="150" />
                  <el-table-column prop="companyNm" label="会社名" width="150" />
                  <!-- <el-table-column prop="expYears" label="必須経験年数" width="100" /> -->
                  <el-table-column prop="industryNm" label="業種" width="150" />
                  <el-table-column prop="jobTypeNm" label="職種" />
                  <!-- <el-table-column prop="salaryMin" label="最低限給料" width="100" />
                  <el-table-column prop="salaryMax" label="最高限給料" width="100" />
                  <el-table-column prop="station" label="最寄駅" width="100" />
                  <el-table-column
                    prop="empLaborIns"
                    label="雇用・労災保険"
                    width="120"
                  />
                  <el-table-column prop="welfare" label="福利厚生" width="100" />
                  <el-table-column prop="trainingFlg" label="研修有無" width="100" />
                  <el-table-column prop="inspectionFlg" label="見学有無" width="100" /> -->
                  <el-table-column fixed="right" width="70" label="応募する">
                    <template slot-scope="scope">
                      <el-button type="text" size="large" @click="insertPost(scope.row)">
                        <em class="el-icon-thumb" />
                      </el-button>
                    </template>
                  </el-table-column>
                  <el-table-column fixed="right" width="70" label="気に入る">
                    <template slot-scope="scope">
                      <el-button type="text" size="large" @click="insertLike(scope.row)">
                        <em class="el-icon-star-off" />
                      </el-button>
                    </template>
                  </el-table-column>
                </el-table>
                <el-row type="flex" justify="end" class="hanggao">
                  <el-col :span="1">
                    <el-button type="text" size="large" @click="selectoubo">
                      <em class="el-icon-thumb" />
                    </el-button>
                  </el-col>
                  <el-col :span="1">
                    <el-button type="text" size="large" @click="selectkiniiru">
                      <em class="el-icon-star-off" />
                    </el-button>
                  </el-col>
                </el-row>
                <div class="page">
                  <el-row type="flex" justify="space-around">
                    <el-col :span="12">
                      <el-pagination
                        :total="pagination.total"
                        :current-page="pagination.currentPage"
                        :pager-count="pagination.pagerCount"
                        :page-sizes="pagination.pageSizes"
                        :page-size="pagination.pageSize"
                        :background="true"
                        :layout="pagination.layout"
                        @size-change="sizeChange"
                        @current-change="currentChange"
                      />
                    </el-col>
                  </el-row>
                </div>
                <!-- <el-row type="flex" justify="end">
                  <el-col :span="1">
                    <el-button type="text" size="large" @click="selectoubo">
                      <em class="el-icon-thumb" />
                    </el-button>
                  </el-col>
                  <el-col :span="1">
                    <el-button type="text" size="large" @click="selectkiniiru">
                      <em class="el-icon-star-off" />
                    </el-button>
                  </el-col>
                </el-row> -->
              </el-tab-pane>
            </el-tabs>
          </div>
        </el-main>
      </el-form>
      <el-footer>
        <div class="footer">
          <HomeFooter />
        </div>
      </el-footer>
    </el-container>
  </div>
</template>

<script lang="" scoped>
import ApplicantHeader from "@/views/components/ApplicantHeader";
import HomeFooter from "./components/HomeFooter";
// 内容チェック機能導入
// import {
//   validateNecessary,
//   numOnBlur,
//   numOnFocus,
//   telOnFocus,
//   telOnBlur,
// } from "@/utils/validate";

export default {
  components: {
    ApplicantHeader,
    HomeFooter,
  },

  data() {
    return {
      vueForm: {
        c0201VueForm: [],
        c0201ListVueForm: {
          likeSelect: "",
          companyNm: "",
          prefeId: "",
          prefeNm: "",
          salary: Number,
          industryId: "",
          jobtypeId: "",
          degree: "",
          expYears: "",
          empLaborIns: "",
          welfare: "",
          trainingFlg: "",
          inspectionFlg: "",
          userCd: "",
        },
      },
      c0201Form: {
        likeSelect: "",
        companyNm: "",
        prefeId: "",
        prefeNm: "",
        salarySection: "",
        salary: Number,
        industryId: "",
        jobtypeId: "",
        degree: "",
        expYears: "",
        empLaborIns: "",
        welfare: "",
        trainingFlg: "",
        inspectionFlg: "",
        userCd: "",
      },
      prefeId: "",
      salary: "",
      industryId: "",
      jobtypeId: "",
      userCd: "",
      inspectionFlg: "0",
      welfare: "0",
      trainingFlg: "0",
      activeName: "first",

      syokuiList: [
        // { positionNm: "fdsf", companyNm: "eerwer" ,companyId:"1",positionId:"1"},
        // { positionNm: "fdsf", companyNm: "eerwer" ,companyId:"2",positionId:"2"},
      ],

      c0201VueFormzan: [],
      gakurekiList: [
        { gakurekiId: "0", gakurekiNm: "大卒以上" },
        { gakurekiId: "1", gakurekiNm: "専門卒以上" },
        { gakurekiId: "2", gakurekiNm: "高卒以上" },
        { gakurekiId: "3", gakurekiNm: "大卒" },
        { gakurekiId: "4", gakurekiNm: "専門卒" },
        { gakurekiId: "5", gakurekiNm: "高卒" },
        { gakurekiId: "6", gakurekiNm: "学歴不問" },
      ],
      hokenList: [
        { hokenId: "0", hokenNm: "未加入" },
        { hokenId: "1", hokenNm: "一般の事業" },
        { hokenId: "2", hokenNm: "農林水産" },
        { hokenId: "3", hokenNm: "建計業他" },
      ],
      keikenList: [
        { keikenId: "0", keikenNm: "不問" },
        { keikenId: "1", keikenNm: "1年未満" },
        { keikenId: "2", keikenNm: "1～3年未満" },
        { keikenId: "3", keikenNm: "3～5年未満" },
        { keikenId: "4", keikenNm: "5～10年未満" },
        { keikenId: "5", keikenNm: "10年以上" },
      ],

      kyuryoKbList: [
        { salarySection: "0", label: "月給" },
        { salarySection: "1", label: "年俸" },
        { salarySection: "2", label: "日給" },
        { salarySection: "3", label: "時給" },
        { salarySection: "4", label: "出来高払い" },
        { salarySection: "5", label: "その他" },
      ],

      prefecturesMstBean: [],
      industryMstBean: [],
      jobtypeMstBean: [],
      pagination: {
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
    };
  },

  mounted() {
    document.title = "職位一覧";
    this.getSyokuiData();
  },
  computed: {
    getSyokuiList() {
      if (this.syokuiList != null) {
        return (
          this.syokuiList.slice(this.pagination.dataStart, this.pagination.dataEnd) || ""
        );
      } else {
        return [];
      }
    },
  },
  methods: {
    numValid() {
      this.salary = this.salary.replace(/[^0-9]/g, "");
    },
    getSyokuiData() {
      // this.setForm();
      this.$store.dispatch("c0201Init", this.c0201Form).then((response) => {
        // this.$router.push({
        //   query: { data: response.data.data },
        // });

        this.prefecturesMstBean = response.data.data.prefecturesMstBean;

        this.industryMstBean = response.data.data.industryMstBean;

        this.jobtypeMstBean = response.data.data.jobtypeMstBean;
        if (response.data.data.getAll != null) {
          this.syokuiList = response.data.data.getAll;
          this.pagination.total = this.syokuiList.length;
        } else {
          this.syokuiList = [];
          this.pagination.total = 0;
        }
        this.pagination.currentPage = 1;
        this.dataFromTo();
        // console.clear();
      });
    },
    resetForm() {
      this.c0201Form = {
        likeSelect: "",
        companyNm: "",
        prefeId: "",
        prefeNm: "",
        salarySection: "",
        salary: Number,
        industryId: "",
        jobtypeId: "",
        degree: "",
        expYears: "",
        empLaborIns: "",
        welfare: "",
        trainingFlg: "",
        inspectionFlg: "",
        userCd: "",
      };
    },
    setForm() {
      if (this.industryId != null && this.industryId != "") {
        this.c0201Form.industryId = parseInt(this.industryId, 10);
      } else {
        this.c0201Form.industryId = "";
      }
      if (this.jobtypeId != null && this.jobtypeId != "") {
        this.c0201Form.jobtypeId = parseInt(this.jobtypeId, 10);
      } else {
        this.c0201Form.jobtypeId = "";
      }
      // if (this.prefeId != null && this.prefeId != "") {
      //   this.c0201Form.prefeId = parseInt(this.prefeId, 10);
      // }

      if (this.salary != null && this.salary != "") {
        this.c0201Form.salary = parseInt(this.salary, 10);
      } else {
        this.c0201Form.salary = "";
      }
      this.c0201Form.welfare = this.welfare;
      this.c0201Form.trainingFlg = this.trainingFlg;
      this.c0201Form.inspectionFlg = this.inspectionFlg;
    },

    handleClick() {
      this.c0201VueFormzan = [];
      // this.setForm();
      if (this.activeName == "second") {
        this.resetForm();
        this.$store.dispatch("c0201InitPost", this.c0201Form).then((response) => {
          // this.$router.push({
          //   query: { data: response.data.data },
          // });

          this.prefecturesMstBean = response.data.data.prefecturesMstBean;

          this.industryMstBean = response.data.data.industryMstBean;

          this.jobtypeMstBean = response.data.data.jobtypeMstBean;
          this.syokuiList = response.data.data.getPost;
          this.pagination.total = this.syokuiList.length;
          // console.clear();
        });
        this.pagination.currentPage = 1;
        this.dataFromTo();
      }
      if (this.activeName == "third") {
        this.resetForm();
        this.$store.dispatch("c0201InitLike", this.c0201Form).then((response) => {
          // this.$router.push({
          //   query: { data: response.data.data },
          // });

          this.prefecturesMstBean = response.data.data.prefecturesMstBean;

          this.industryMstBean = response.data.data.industryMstBean;

          this.jobtypeMstBean = response.data.data.jobtypeMstBean;
          this.syokuiList = response.data.data.getLike;
          this.pagination.total = this.syokuiList.length;
          // console.clear();
        });
        this.pagination.currentPage = 1;
        this.dataFromTo();
      }

      if (this.activeName == "first") {
        this.resetForm();
        this.$store.dispatch("c0201Init", this.c0201Form).then((response) => {
          // this.$router.push({
          //   query: { data: response.data.data },
          // });

          this.prefecturesMstBean = response.data.data.prefecturesMstBean;

          this.industryMstBean = response.data.data.industryMstBean;

          this.jobtypeMstBean = response.data.data.jobtypeMstBean;

          // this.syokuiList = response.data.data.getAll;
          // this.pagination.total = this.syokuiList.length;
          if (response.data.data.getAll != null) {
            this.syokuiList = response.data.data.getAll;
            this.pagination.total = this.syokuiList.length;
          } else {
            this.syokuiList = [];
            this.pagination.total = 0;
          }
          // console.clear();
        });
        this.pagination.currentPage = 1;
        this.dataFromTo();
      }

      if (this.activeName == "forth") {
        this.setForm();
        this.$store.dispatch("c0201getDate", this.c0201Form).then((response) => {
          // this.$router.push({
          //   query: { data: response.data.data },
          // });

          this.prefecturesMstBean = response.data.data.prefecturesMstBean;

          this.industryMstBean = response.data.data.industryMstBean;

          this.jobtypeMstBean = response.data.data.jobtypeMstBean;

          // this.syokuiList = response.data.data.getAll;
          // this.pagination.total = this.syokuiList.length;
          if (response.data.data.getAll != null) {
            this.syokuiList = response.data.data.getAll;
            this.pagination.total = this.syokuiList.length;
          } else {
            this.syokuiList = [];
            this.pagination.total = 0;
          }
          // console.clear();
        });
        this.pagination.currentPage = 1;
        this.dataFromTo();
      }
    },
    // 毎ページ行目数のselect
    sizeChange(val) {
      this.pagination.pageSize = val;
      console.log("pageSize", this.pagination.pageSize);
      this.dataFromTo();
      this.c0201VueFormzan = [];
    },
    // 当ページのボタン
    currentChange(val) {
      this.pagination.currentPage = val;
      console.log("currentPage", this.pagination.currentPage);
      this.dataFromTo();
      this.c0201VueFormzan = [];
    },
    // テーブル値行範囲の設定
    dataFromTo() {
      this.pagination.dataStart =
        (this.pagination.currentPage - 1) * this.pagination.pageSize;
      this.pagination.dataEnd = this.pagination.currentPage * this.pagination.pageSize;
      console.log("dataStart", this.pagination.dataStart);
      console.log("dataEnd", this.pagination.dataEnd);
    },
    clearJoken() {
      this.c0201Form.likeSelect = "";
      this.c0201Form.companyNm = "";
      // this.prefeId = "";
      this.c0201Form.prefeNm = "";
      this.salary = "";
      this.industryId = "";
      this.jobtypeId = "";
      this.c0201Form.degree = "";
      this.c0201Form.empLaborIns = "";
      this.c0201Form.expYears = "";
    },

    getSyokuiIchiran() {
      this.setForm();
      this.$store.dispatch("c0201getDate", this.c0201Form).then((response) => {
        // this.$router.push({
        //   query: { data: response.data.data },
        // });

        this.prefecturesMstBean = response.data.data.prefecturesMstBean;

        this.industryMstBean = response.data.data.industryMstBean;

        this.jobtypeMstBean = response.data.data.jobtypeMstBean;
        if (response.data.data.getAll != null) {
          this.syokuiList = response.data.data.getAll;
          this.pagination.total = this.syokuiList.length;
        } else {
          this.syokuiList = [];
          this.pagination.total = 0;
        }
        this.pagination.currentPage = 1;
        this.dataFromTo();
        // console.clear();
      });
    },

    getKensakuData() {
      this.getSyokuiIchiran();
      this.activeName = "forth";
      this.c0201VueFormzan = [];
    },
    setPrefeIdNm() {
      for (var i = 0; i < this.prefecturesMstBean.length; i++) {
        if (this.prefeId == this.prefecturesMstBean[i].prefeId) {
          this.c0201Form.prefeNm = this.prefecturesMstBean[i].prefeNm;
          break;
        }
      }
    },

    insertPost(row) {
      // this.setForm();
      // this.vueForm.c0201ListVueForm = this.c0201Form;
      this.vueForm.c0201VueForm = [];
      this.vueForm.c0201VueForm.push({
        companyId: parseInt(row.companyId, 10),
        positionId: parseInt(row.positionId, 10),
        applicantId: 0,
        userCd: 0,
      });
      console.log(this.vueForm.c0201VueForm);
      console.log(this.vueForm.c0201ListVueForm);
      this.$store.dispatch("c0201insertPost", this.vueForm).then((response) => {
        let code = response.data.code;
        if (code == 200) {
          // this.$router.push({
          //   query: { data: response.data.data },
          // });
          this.prefecturesMstBean = response.data.data.prefecturesMstBean;

          this.industryMstBean = response.data.data.industryMstBean;

          this.jobtypeMstBean = response.data.data.jobtypeMstBean;
          if (response.data.data.statusFlg == "0") {
            this.syokuiList = response.data.data.getPost;
            this.pagination.total = this.syokuiList.length;
            this.activeName = "second";
            this.pagination.currentPage = 1;
            this.dataFromTo();
          } else {
            this.$message.error("履歴書まだ完成されていないので、この操作ができません。");
          }
        }
      });
      // this.activeName = "second";
    },

    insertLike(row) {
      // this.setForm();
      // this.vueForm.c0201ListVueForm = this.c0201Form;
      this.vueForm.c0201VueForm = [];
      this.vueForm.c0201VueForm.push({
        companyId: parseInt(row.companyId, 10),
        positionId: parseInt(row.positionId, 10),
        applicantId: 0,
        userCd: 0,
      });
      console.log(this.vueForm.c0201VueForm);
      console.log(this.vueForm.c0201ListVueForm);
      this.$store.dispatch("c0201insertLike", this.vueForm).then((response) => {
        let code = response.data.code;
        if (code == 200) {
          // this.$router.push({
          //   query: { data: response.data.data },
          // });
          this.prefecturesMstBean = response.data.data.prefecturesMstBean;

          this.industryMstBean = response.data.data.industryMstBean;

          this.jobtypeMstBean = response.data.data.jobtypeMstBean;
          if (response.data.data.statusFlg == "0") {
            this.syokuiList = response.data.data.getLike;
            this.pagination.total = this.syokuiList.length;
            this.activeName = "third";
            this.pagination.currentPage = 1;
            this.dataFromTo();
          } else {
            this.$message.error("履歴書まだ完成されていないので、この操作ができません。");
          }
        }
      });
    },

    updateLike(row) {
      // this.setForm();
      // this.vueForm.c0201ListVueForm = this.c0201Form;
      this.vueForm.c0201VueForm = [];
      this.vueForm.c0201VueForm.push({
        companyId: parseInt(row.companyId, 10),
        positionId: parseInt(row.positionId, 10),
        applicantId: 0,
        userCd: 0,
      });

      this.$store.dispatch("c0201updateLike", this.vueForm).then((response) => {
        let code = response.data.code;
        if (code == 200) {
          // this.$router.push({
          //   query: { data: response.data.data },
          // });
          this.prefecturesMstBean = response.data.data.prefecturesMstBean;

          this.industryMstBean = response.data.data.industryMstBean;

          this.jobtypeMstBean = response.data.data.jobtypeMstBean;
          this.syokuiList = response.data.data.getLike;
          this.pagination.total = this.syokuiList.length;
          this.pagination.currentPage = 1;
          this.dataFromTo();
        }
      });
    },

    deleteApplication(row) {
      // this.setForm();
      // this.vueForm.c0201ListVueForm = this.c0201Form;
      this.vueForm.c0201VueForm = [];
      this.vueForm.c0201VueForm.push({
        companyId: parseInt(row.companyId, 10),
        positionId: parseInt(row.positionId, 10),
        applicantId: 0,
        userCd: 0,
      });

      this.$store.dispatch("c0201deleteApplication", this.vueForm).then((response) => {
        let code = response.data.code;
        if (code == 200) {
          // this.$router.push({
          //   query: { data: response.data.data },
          // });
          this.prefecturesMstBean = response.data.data.prefecturesMstBean;

          this.industryMstBean = response.data.data.industryMstBean;

          this.jobtypeMstBean = response.data.data.jobtypeMstBean;
          this.syokuiList = response.data.data.getLike;
          this.pagination.total = this.syokuiList.length;
          this.pagination.currentPage = 1;
          this.dataFromTo();
        }
      });
    },

    handSelect(selection) {
      this.c0201VueFormzan = selection;
      // console.log(this.c0201VueForm);
    },

    handSelectAll(selection) {
      this.c0201VueFormzan = selection;
      // console.log(this.c0201VueForm);
    },

    selectoubo() {
      // this.setForm();
      // this.vueForm.c0201ListVueForm = this.c0201Form;
      this.vueForm.c0201VueForm = [];
      for (var i = 0; i < this.c0201VueFormzan.length; i++) {
        this.vueForm.c0201VueForm.push({
          companyId: parseInt(this.c0201VueFormzan[i].companyId, 10),
          positionId: parseInt(this.c0201VueFormzan[i].positionId, 10),
          applicantId: 0,
          userCd: 0,
        });
      }

      // console.log(this.c0201VueForm);
      if (this.vueForm.c0201VueForm.length > 0) {
        this.$store.dispatch("c0201insertPost", this.vueForm).then((response) => {
          let code = response.data.code;
          if (code == 200) {
            // this.$router.push({
            //   query: { data: response.data.data },
            // });
            this.prefecturesMstBean = response.data.data.prefecturesMstBean;

            this.industryMstBean = response.data.data.industryMstBean;

            this.jobtypeMstBean = response.data.data.jobtypeMstBean;
            if (response.data.data.statusFlg == "0") {
              this.syokuiList = response.data.data.getPost;
              this.pagination.total = this.syokuiList.length;
              this.activeName = "second";
              this.pagination.currentPage = 1;
              this.dataFromTo();
            } else {
              this.$message.error(
                "履歴書まだ完成されていないので、この操作ができません。"
              );
            }
          }
        });
      } else {
        this.$message.error("選択項目がございません。");
      }
    },

    selectkiniiru() {
      // this.setForm();
      // this.vueForm.c0201ListVueForm = this.c0201Form;
      this.vueForm.c0201VueForm = [];
      for (var i = 0; i < this.c0201VueFormzan.length; i++) {
        this.vueForm.c0201VueForm.push({
          companyId: parseInt(this.c0201VueFormzan[i].companyId, 10),
          positionId: parseInt(this.c0201VueFormzan[i].positionId, 10),
          applicantId: 0,
          userCd: 0,
        });
      }
      if (this.vueForm.c0201VueForm.length > 0) {
        this.$store.dispatch("c0201insertLike", this.vueForm).then((response) => {
          let code = response.data.code;
          if (code == 200) {
            // this.$router.push({
            //   query: { data: response.data.data },
            // });
            this.prefecturesMstBean = response.data.data.prefecturesMstBean;

            this.industryMstBean = response.data.data.industryMstBean;

            this.jobtypeMstBean = response.data.data.jobtypeMstBean;
            if (response.data.data.statusFlg == "0") {
              this.syokuiList = response.data.data.getLike;
              this.pagination.total = this.syokuiList.length;
              this.activeName = "third";
              this.pagination.currentPage = 1;
              this.dataFromTo();
            } else {
              this.$message.error(
                "履歴書まだ完成されていないので、この操作ができません。"
              );
            }
          }
        });
      } else {
        this.$message.error("選択項目がございません。");
      }
    },

    selectupdate() {
      // this.setForm();
      // this.vueForm.c0201ListVueForm = this.c0201Form;
      this.vueForm.c0201VueForm = [];
      for (var i = 0; i < this.c0201VueFormzan.length; i++) {
        this.vueForm.c0201VueForm.push({
          companyId: parseInt(this.c0201VueFormzan[i].companyId, 10),
          positionId: parseInt(this.c0201VueFormzan[i].positionId, 10),
          applicantId: 0,
          userCd: 0,
        });
      }
      if (this.vueForm.c0201VueForm.length > 0) {
        this.$store.dispatch("c0201updateLike", this.vueForm).then((response) => {
          let code = response.data.code;
          if (code == 200) {
            // this.$router.push({
            //   query: { data: response.data.data },
            // });
            this.prefecturesMstBean = response.data.data.prefecturesMstBean;

            this.industryMstBean = response.data.data.industryMstBean;

            this.jobtypeMstBean = response.data.data.jobtypeMstBean;
            this.syokuiList = response.data.data.getLike;
            this.pagination.total = this.syokuiList.length;
            this.pagination.currentPage = 1;
            this.dataFromTo();
          }
        });
      } else {
        this.$message.error("選択項目がございません。");
      }
    },

    selectdelete() {
      // this.setForm();
      // this.vueForm.c0201ListVueForm = this.c0201Form;
      this.vueForm.c0201VueForm = [];
      for (var i = 0; i < this.c0201VueFormzan.length; i++) {
        this.vueForm.c0201VueForm.push({
          companyId: parseInt(this.c0201VueFormzan[i].companyId, 10),
          positionId: parseInt(this.c0201VueFormzan[i].positionId, 10),
          applicantId: 0,
          userCd: 0,
        });
      }
      if (this.vueForm.c0201VueForm.length > 0) {
        this.$store.dispatch("c0201deleteApplication", this.vueForm).then((response) => {
          let code = response.data.code;
          if (code == 200) {
            // this.$router.push({
            //   query: { data: response.data.data },
            // });
            this.prefecturesMstBean = response.data.data.prefecturesMstBean;

            this.industryMstBean = response.data.data.industryMstBean;

            this.jobtypeMstBean = response.data.data.jobtypeMstBean;
            this.syokuiList = response.data.data.getLike;
            this.pagination.total = this.syokuiList.length;
            this.pagination.currentPage = 1;
            this.dataFromTo();
          }
        });
      } else {
        this.$message.error("選択項目がございません。");
      }
    },

    toLastPage() {
      // console.log(this.c0201VueFormzan);
      this.$router.push({
        path: "/c0003",
      });
    },
  },
};
</script>

<style lang="scss" scoped>
// 主体页面灰色
.b0501_body {
  background-color: #f6f6f6;
}
// 两个主体部分边框阴影，白色背景
.b0501_select,
.b0501_data {
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);
  background-color: #ffffff;
}
// 内容body、两个主体外边距
.b0501_body,
.b0501_data,
.data_select {
  margin: 1vh, 1vh, 0px, 0px;
}
// 研修一覧标题右移1%
.b0501_title {
  margin-left: 1%;
}
// 两部分主体宽80vw，居中
.b0501_select,
.b0501_data {
  width: 80vw;
  margin: auto;
}
// 行上下内边距填充1vh
.el-row {
  padding-top: 1vh;
  padding-bottom: 1vh;
}
.c0201row {
  padding-top: 0vh;
  padding-bottom: 0vh;
}
// 部分文字上下边距1vh，白底蓝字粗体
.b0501_title,
.blue_font {
  margin-top: 1vh;
  margin-bottom: 1vh;
  background-color: #ffffff;
  color: #006699;
  font-weight: 600;
}
// 研修一覧字号20
.b0501_title {
  font-size: 20px;
}
// 灰色上边线，上内边距
.select_body {
  border-top: 2px solid#f6f6f6;
  padding-top: 2vh;
}
// 检索按钮所在div内边距，底部外边距
.b0501_button {
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
.b0501Button {
  width: 110px;
}

.biaolanmu {
  margin-left: 5%;
  margin-right: 0;
  margin-bottom: 0;
  width: 40%;
}
.demo-table-expand {
  font-size: 0;
}
.demo-table-expand label {
  width: 100px;
  color: #99a9bf;
}
.hanggao {
  height: 60px;
}
.geiliao {
  width: 180px;
}
.xialaiyidian {
  margin-top: 8px;
}
::v-deep .el-tabs {
  background-color: #fff;
  font-size: 18px;
  .el-tabs__header {
    .el-tabs__nav-wrap {
      .el-tabs__nav-scroll {
        .el-tabs__nav {
          .el-tabs__item {
            font-size: 18px;
            font-family: "微软雅黑";
            font-weight: 600;
            width: 200px;
            text-align: center;
            height: 50px;
            line-height: 50px;
            color: #b8b8b8;
            padding: 0px;
          }
          .el-tabs__active-bar {
            height: 0;
          }
          .el-tabs__item.is-active {
            color: #409eff;
          }
        }
      }
    }
  }
}
::v-deep .el-pagination .el-select .el-input {
  width: 2rem;
}
</style>
<style lang="scss" scoped>
.el-icon-back,
.el-icon-document-remove,
.el-icon-search {
  font-size: 30px;
}
</style>
