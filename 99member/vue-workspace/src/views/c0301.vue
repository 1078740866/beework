<template>
  <div>
    <el-container>
      <el-header>
        <div class="header">
          <ApplicantHeader />
        </div>
      </el-header>
      <el-form :model="c0301Form" ref="c0301Form" label-position="left" autocomplete="on">
        <el-main class="b0501_body">
          <div class="b0501_select">
            <el-row>
              <el-col :span="24">
                <div class="b0501_title">研修一覧</div>
              </el-col>
            </el-row>
            <div class="select_body">
              <el-row :gutter="1">
                <el-col :span="7" :offset="1">
                  <div>
                    <el-form-item label-width="80px" label="研修名：">
                      <el-input v-model="c0301Form.trainingNm" placeholder="研修名" />
                    </el-form-item>
                  </div>
                </el-col>

                <el-col :span="6" :offset="1">
                  <div>
                    <el-form-item label="会社名：" label-width="80px">
                      <el-input v-model="c0301Form.companyNm" placeholder="会社名" />
                    </el-form-item>
                  </div>
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
              </el-row>
            </div>

            <el-row>
              <el-col :span="8" :offset="1">
                <div>
                  <el-form-item label="日付：" label-width="50px">
                    <el-date-picker
                      v-model="date1"
                      type="date"
                      align="right"
                      class="datesize"
                      placeholder="開始日付"
                    >
                    </el-date-picker>
                    -
                    <el-date-picker
                      v-model="date2"
                      type="date"
                      align="right"
                      class="datesize"
                      placeholder="終了日付"
                    >
                    </el-date-picker>
                  </el-form-item>
                </div>
              </el-col>
              <el-col :span="8" :offset="0">
                <div>
                  <el-form-item label="時刻：" label-width="50px">
                    <el-time-picker
                      is-range
                      range-separator="-"
                      v-model="timer"
                      class="timesize"
                      value-format="HH:mm:ss"
                    ></el-time-picker>
                    <!-- <el-time-picker v-model="time2" class="datesize" value-format="HH:mm:ss"></el-time-picker> -->
                  </el-form-item>
                </div>
              </el-col>
              <el-col :span="5" :offset="0">
                <div>
                  <el-form-item label="場所：" label-width="50px">
                    <el-select v-model="c0301Form.prefeNm" placeholder="場所" clearable>
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
            </el-row>
            <el-row>
              <el-col :span="9" :offset="1">
                <div>
                  <el-form-item label="料金：" label-width="80px">
                    <el-radio v-model="salary" label="0">有り</el-radio>
                    <el-radio v-model="salary" label="1">無し</el-radio>
                    <el-radio v-model="salary" label="2">両方</el-radio>
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
                </el-col>
                <el-col :span="4">
                  <el-tooltip effect="light" content="検索" placement="top">
                    <el-link @click="getTrainingData" type="primary" :underline="false">
                      <i class="el-icon-search"></i>
                    </el-link>
                  </el-tooltip>
                </el-col>
                <el-col :span="4">
                  <el-tooltip effect="light" content="戻る" placement="top">
                    <el-link @click="toLastPage" type="primary" :underline="false">
                      <i class="el-icon-back"></i>
                    </el-link>
                  </el-tooltip>
                </el-col>
                <!-- <el-col :span="4">
                  <div>
                    <el-button type="primary" @click="clearJoken" class="b0501Button">
                      条件クリア
                    </el-button>
                  </div>
                </el-col>
                <el-col :span="4">
                  <div>
                    <el-button
                      type="primary"
                      @click="getTrainingData"
                      icon="el-icon-search"
                      class="b0501Button"
                    >
                      検索
                    </el-button>
                  </div>
                </el-col>
                <el-col :span="4">
                  <div>
                    <el-button type="primary" @click="toLastPage" class="b0501Button">
                      戻る
                    </el-button>
                  </div>
                </el-col> -->
              </el-row>
            </div>
          </div>
          <div class="b0501_data">
            <el-tabs v-model="activeName" @tab-click="handleClick" type="card">
            <!--<el-tabs v-model="activeName" type="card">-->
              <el-tab-pane label="研修推薦" name="first">
                <el-table
                  ref="suisenTable"
                  :data="getkensyuuList"
                  style="width: 100%"
                  height="350px"
                  @select="handSelect"
                  @select-all="handSelectAll"
                >
                  <el-table-column type="expand">
                    <template slot-scope="props">
                      <el-form label-position="left" inline label-width="100px">
                        <el-form-item label="研修期間" class="biaolanmu">
                          <span> {{ props.row.dateFrom }} - {{ props.row.dateTo }} </span>
                        </el-form-item>
                        <el-form-item label="研修時間" class="biaolanmu">
                          <span> {{ props.row.timeFrom }} - {{ props.row.timeTo }} </span>
                        </el-form-item>
                        <el-form-item label="場所" class="biaolanmu">
                          <span> {{ props.row.trainingAddress1 }}</span>
                        </el-form-item>
                        <el-form-item label="料金" class="biaolanmu">
                          <span> {{ toNumerFilter(props.row.cost) }}円</span>
                        </el-form-item>
                        <el-form-item label="研修内容" class="biaolanmu2">
                          <span> {{ props.row.trainingContent }}</span>
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
                    prop="trainingId"
                    label="trainingId"
                    width="100"
                    v-if="false"
                  />
                  <el-table-column prop="trainingNm" label="研修名" width="150" />
                  <el-table-column prop="industryNm" label="業種" width="150" />
                  <el-table-column prop="companyNm" label="会社名" width="150" />
                  <!-- <el-table-column prop="dateFrom" label="研修開始日" width="100" />
                  <el-table-column prop="dateTo" label="研修終了日" width="100" />
                  <el-table-column prop="timeFrom" label="研修開始時間" width="100" />
                  <el-table-column prop="timeTo" label="研修終了時間" width="100" /> -->
                  <!-- <el-table-column prop="trainingAddress1" label="場所" width="100" /> -->
                  <el-table-column prop="proCnt" label="募集人数" />
                  <!-- <el-table-column prop="cost" label="料金" width="100" />
                  <el-table-column prop="trainingContent" label="研修内容" /> -->

                  <el-table-column fixed="right" label="応募する" width="70">
                    <template slot-scope="scope">
                      <el-button type="text" size="large" @click="insertPost(scope.row)">
                        <em class="el-icon-thumb" />
                      </el-button>
                    </template>
                  </el-table-column>
                  <el-table-column fixed="right" label="気に入る" width="70">
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
              </el-tab-pane>
              <el-tab-pane label="応募済み" name="second">
                <el-table
                  ref="suisenTable"
                  :data="getkensyuuList"
                  style="width: 100%"
                  height="350px"
                >
                  <el-table-column type="expand">
                    <template slot-scope="props">
                      <el-form label-position="left" inline label-width="100px">
                        <el-form-item label="研修期間" class="biaolanmu">
                          <span> {{ props.row.dateFrom }} - {{ props.row.dateTo }} </span>
                        </el-form-item>
                        <el-form-item label="研修時間" class="biaolanmu">
                          <span> {{ props.row.timeFrom }} - {{ props.row.timeTo }} </span>
                        </el-form-item>
                        <el-form-item label="場所" class="biaolanmu">
                          <span> {{ props.row.trainingAddress1 }}</span>
                        </el-form-item>
                        <el-form-item label="料金" class="biaolanmu">
                          <span> {{ toNumerFilter(props.row.cost) }}円</span>
                        </el-form-item>
                        <el-form-item label="研修内容" class="biaolanmu2">
                          <span> {{ props.row.trainingContent }}</span>
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
                    prop="trainingId"
                    label="trainingId"
                    width="100"
                    v-if="false"
                  />
                  <el-table-column prop="trainingNm" label="研修名" width="150" />
                  <el-table-column prop="industryNm" label="業種" width="150" />
                  <el-table-column prop="companyNm" label="会社名" width="150" />
                  <!-- <el-table-column prop="dateFrom" label="研修開始日" width="100" />
                  <el-table-column prop="dateTo" label="研修終了日" width="100" />
                  <el-table-column prop="timeFrom" label="研修開始時間" width="100" />
                  <el-table-column prop="timeTo" label="研修終了時間" width="100" />
                  <el-table-column prop="trainingAddress1" label="場所" width="100" /> -->
                  <el-table-column prop="proCnt" label="募集人数" />
                  <!-- <el-table-column prop="cost" label="料金" width="100" />
                  <el-table-column prop="trainingContent" label="研修内容" /> -->

                  <!-- <el-table-column fixed="right" width="50">
                    <template slot-scope="scope">
                      <el-button type="text" size="large" @click="insertPost(scope.row)">
                        <em class="el-icon-thumb" />
                      </el-button>
                    </template>
                  </el-table-column>
                  <el-table-column fixed="right" width="50">
                    <template slot-scope="scope">
                      <el-button type="text" size="large" @click="insertLike(scope.row)">
                        <em class="el-icon-star-off" />
                      </el-button>
                    </template>
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
              <el-tab-pane label="気に入る" name="third">
                <el-table
                  ref="suisenTable"
                  :data="getkensyuuList"
                  style="width: 100%"
                  height="350px"
                  @select="handSelect"
                  @select-all="handSelectAll"
                >
                  <el-table-column type="expand">
                    <template slot-scope="props">
                      <el-form label-position="left" inline label-width="100px">
                        <el-form-item label="研修期間" class="biaolanmu">
                          <span> {{ props.row.dateFrom }} - {{ props.row.dateTo }} </span>
                        </el-form-item>
                        <el-form-item label="研修時間" class="biaolanmu">
                          <span> {{ props.row.timeFrom }} - {{ props.row.timeTo }} </span>
                        </el-form-item>
                        <el-form-item label="場所" class="biaolanmu">
                          <span> {{ props.row.trainingAddress1 }}</span>
                        </el-form-item>
                        <el-form-item label="料金" class="biaolanmu">
                          <span> {{ toNumerFilter(props.row.cost) }}円</span>
                        </el-form-item>
                        <el-form-item label="研修内容" class="biaolanmu2">
                          <span> {{ props.row.trainingContent }}</span>
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
                    prop="trainingId"
                    label="trainingId"
                    width="100"
                    v-if="false"
                  />
                  <el-table-column prop="trainingNm" label="研修名" width="150" />
                  <el-table-column prop="industryNm" label="業種" width="150" />
                  <el-table-column prop="companyNm" label="会社名" width="150" />
                  <!-- <el-table-column prop="dateFrom" label="研修開始日" width="100" />
                  <el-table-column prop="dateTo" label="研修終了日" width="100" />
                  <el-table-column prop="timeFrom" label="研修開始時間" width="100" />
                  <el-table-column prop="timeTo" label="研修終了時間" width="100" />
                  <el-table-column prop="trainingAddress1" label="場所" width="100" /> -->
                  <el-table-column prop="proCnt" label="募集人数" />
                  <!-- <el-table-column prop="cost" label="料金" width="100" />
                  <el-table-column prop="trainingContent" label="研修内容" /> -->

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
              <el-tab-pane label="研修一覧" name="forth">
                <el-table
                  ref="ichiranTable"
                  :data="getkensyuuList"
                  style="width: 100%"
                  height="350px"
                  @select="handSelect"
                  @select-all="handSelectAll"
                >
                  <el-table-column type="expand">
                    <template slot-scope="props">
                      <el-form label-position="left" inline label-width="100px">
                        <el-form-item label="研修期間" class="biaolanmu">
                          <span> {{ props.row.dateFrom }} - {{ props.row.dateTo }} </span>
                        </el-form-item>
                        <el-form-item label="研修時間" class="biaolanmu">
                          <span> {{ props.row.timeFrom }} - {{ props.row.timeTo }} </span>
                        </el-form-item>
                        <el-form-item label="場所" class="biaolanmu">
                          <span> {{ props.row.trainingAddress1 }}</span>
                        </el-form-item>
                        <el-form-item label="料金" class="biaolanmu">
                          <span> {{ toNumerFilter(props.row.cost) }}円</span>
                        </el-form-item>
                        <el-form-item label="研修内容" class="biaolanmu2">
                          <span> {{ props.row.trainingContent }}</span>
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
                    prop="trainingId"
                    label="trainingId"
                    width="100"
                    v-if="false"
                  />
                  <el-table-column prop="trainingNm" label="研修名" width="100" />
                  <el-table-column prop="industryNm" label="業種" width="100" />
                  <el-table-column prop="companyNm" label="会社名" width="100" />
                  <!-- <el-table-column prop="dateFrom" label="研修開始日" width="100" />
                  <el-table-column prop="dateTo" label="研修終了日" width="100" />
                  <el-table-column prop="timeFrom" label="研修開始時間" width="100" />
                  <el-table-column prop="timeTo" label="研修終了時間" width="100" />
                  <el-table-column prop="trainingAddress1" label="場所" width="100" /> -->
                  <el-table-column prop="proCnt" label="募集人数" />
                  <!-- <el-table-column prop="cost" label="料金" width="100" />
                  <el-table-column prop="trainingContent" label="研修内容" /> -->

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

export default {
  components: {
    ApplicantHeader,
    HomeFooter,
  },

  data() {
    return {
      date1: "",
      date2: "",
      time1: "",
      time2: "",
      timer: ['09:00:00','18:00:00'],
      salary: "2",
      vueForm: {
        c0301VueForm: [],
        c0301ListVueForm: {
          trainingNm: "",
          companyNm: "",
          prefeNm: "",
          salary: "",
          industryId: "",
          dateFrom: "",
          dateTo: "",
          timeFrom: null,
          timeTo: null,
          userCd: Number,
        },
      },
      c0301Form: {
        trainingNm: "",
        companyNm: "",
        prefeNm: "",
        salary: "",
        industryId: "",
        dateFrom: "",
        dateTo: "",
        timeFrom: null,
        timeTo: null,
        userCd: Number,
      },
      prefeId: "",

      industryId: "",
      jobtypeId: "",
      inspectionFlg: "0",
      welfare: "0",
      trainingFlg: "0",
      activeName: "first",

      kensyuuList: [],

      prefecturesMstBean: [],
      industryMstBean: [],

      c0301VueFormzan: [],

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
    document.title = "研修一覧";
    this.getKensyuuData();
  },

  computed: {
    
    getkensyuuList() {
      if (this.kensyuuList != null) {
        return (
          
          this.kensyuuList.slice(this.pagination.dataStart, this.pagination.dataEnd) || ""
        );
      } else {
        return [];
      }
    },
  },

  methods: {
    toNumerFilter(e) {
        //每个三位价格逗号
      if (e=== "") {
        return;
      } else {
        var val = e;
        var int = val.split("").reverse().join(""); // 翻转整数
        var temp = ""; // 临时变量
        for (var i = 0; i < int.length; i++) {
          temp += int[i];
          if ((i + 1) % 3 == 0 && i != int.length - 1) {
            temp += ","; // 每隔三个数字拼接一个逗号
          }
        }
        temp = temp.split("").reverse().join(""); // 加完逗号之后翻转
        e = temp ; // 返回
        return e;
      }
        
    },
    
    getKensyuuData() {
      // this.setForm();
      this.$store.dispatch("c0301Init", this.c0301Form).then((response) => {
        // this.$router.push({
        //   query: { data: response.data.data },
        // });

        this.prefecturesMstBean = response.data.data.prefecturesMstBean;

        this.industryMstBean = response.data.data.industryMstBean;

        if (response.data.data.getTraining != null) {
          this.kensyuuList = response.data.data.getTraining;
          this.pagination.total = this.kensyuuList.length;
        } else {
          this.kensyuuList = [];
          this.pagination.total = 0;
        }
        this.pagination.currentPage = 1;
        this.dataFromTo();
        // console.clear();
      });
    },
    
    //研修一覧(forth:包括获取全部和搜索)
    getKensyuuIchiran() {
      this.setForm();
      this.$store.dispatch("c0301getList", this.c0301Form).then((response) => {
        // this.$router.push({
        //   query: { data: response.data.data },
        // });

        this.prefecturesMstBean = response.data.data.prefecturesMstBean;

        this.industryMstBean = response.data.data.industryMstBean;

        if (response.data.data.getTraining != null) {
          this.kensyuuList = response.data.data.getTraining;
          this.pagination.total = this.kensyuuList.length;
        } else {
          this.kensyuuList = [];
          this.pagination.total = 0;
        }
        this.pagination.currentPage = 1;
        this.dataFromTo();
        // console.clear();
      });
    },

    resetForm() {
      this.c0301Form = {
        trainingNm: "",
        companyNm: "",
        prefeNm: "",
        salary: "",
        industryId: "",
        dateFrom: "",
        dateTo: "",
        timeFrom: null,
        timeTo: null,
        userCd: Number,
      };
    },
    setForm() {
      if (this.industryId != null && this.industryId != "") {
        this.c0301Form.industryId = parseInt(this.industryId, 10);
      } else {
        this.c0301Form.industryId = "";
      }
      this.c0301Form.dateFrom = this.date1;
      this.c0301Form.dateTo = this.date2;
      if (this.timer != null) {
        this.c0301Form.timeFrom = this.timer[0];
        this.c0301Form.timeTo = this.timer[1];
      } else {
        this.c0301Form.timeFrom = null;
        this.c0301Form.timeTo = null;
      }
      if (this.salary == "0") {
        this.c0301Form.salary = 1;
      } else if (this.salary == "1") {
        this.c0301Form.salary = 0;
      } else {
        this.c0301Form.salary = "";
      }
    },

    getTrainingData() {
      this.getKiniIru();
      //this.getKensyuuIchiran();
      // this.activeName = "forth";
      this.c0301VueFormzan = [];
    },

    handleClick() {
      this.c0301VueFormzan = [];
      // this.setForm();
      if (this.activeName == "second") {
        this.resetForm();
        this.$store.dispatch("c0301InitPost", this.c0301Form).then((response) => {
          // this.$router.push({
          //   query: { data: response.data.data },
          // });

          this.prefecturesMstBean = response.data.data.prefecturesMstBean;

          this.industryMstBean = response.data.data.industryMstBean;

          this.kensyuuList = response.data.data.getTrainingPost;
          this.pagination.total = this.kensyuuList.length;
          // console.clear();
        });
        this.pagination.currentPage = 1;
        this.dataFromTo();
      }
      if (this.activeName == "third") {
        this.resetForm();
        this.$store.dispatch("c0301InitLike", this.c0301Form).then((response) => {
          // this.$router.push({
          //   query: { data: response.data.data },
          // });

          this.prefecturesMstBean = response.data.data.prefecturesMstBean;

          this.industryMstBean = response.data.data.industryMstBean;

          this.kensyuuList = response.data.data.getTrainingLike;
          this.pagination.total = this.kensyuuList.length;
          // console.clear();
        });
        this.pagination.currentPage = 1;
        this.dataFromTo();
      }

      if (this.activeName == "first") {
        this.resetForm();
        this.$store.dispatch("c0301Init", this.c0301Form).then((response) => {
          // this.$router.push({
          //   query: { data: response.data.data },
          // });

          this.prefecturesMstBean = response.data.data.prefecturesMstBean;

          this.industryMstBean = response.data.data.industryMstBean;
          if (response.data.data.getTraining != null) {
            this.kensyuuList = response.data.data.getTraining;
            this.pagination.total = this.kensyuuList.length;
          } else {
            this.kensyuuList = [];
            this.pagination.total = 0;
          }
          // console.clear();
        });
        this.pagination.currentPage = 1;
        this.dataFromTo();
      }

      if (this.activeName == "forth") {
        this.setForm();
        this.$store.dispatch("c0301getList", this.c0301Form).then((response) => {
          // this.$router.push({
          //   query: { data: response.data.data },
          // });

          this.prefecturesMstBean = response.data.data.prefecturesMstBean;

          this.industryMstBean = response.data.data.industryMstBean;
          if (response.data.data.getTraining != null) {
            this.kensyuuList = response.data.data.getTraining;
            this.pagination.total = this.kensyuuList.length;
          } else {
            this.kensyuuList = [];
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
      this.c0301VueFormzan = [];
    },
    // 当ページのボタン
    currentChange(val) {
      this.pagination.currentPage = val;
      console.log("currentPage", this.pagination.currentPage);
      this.dataFromTo();
      this.c0301VueFormzan = [];
    },
    // テーブル値行範囲の設定
    dataFromTo() {
      this.pagination.dataStart =
        (this.pagination.currentPage - 1) * this.pagination.pageSize;
      this.pagination.dataEnd = this.pagination.currentPage * this.pagination.pageSize;
      console.log("dataStart", this.pagination.dataStart);
      console.log("dataEnd", this.pagination.dataEnd);
    },

    insertPost(row) {
      // this.setForm();
      // this.vueForm.c0301ListVueForm = this.c0301Form;
      this.vueForm.c0301VueForm = [];
      this.vueForm.c0301VueForm.push({
        companyId: parseInt(row.companyId, 10),
        trainingId: parseInt(row.trainingId, 10),
        applicantId: 0,
        userCd: 0,
      });
      this.$store.dispatch("c0301insertPost", this.vueForm).then((response) => {
        let code = response.data.code;
        if (code == 200) {
          // this.$router.push({
          //   query: { data: response.data.data },
          // });
          this.prefecturesMstBean = response.data.data.prefecturesMstBean;

          this.industryMstBean = response.data.data.industryMstBean;
          if (response.data.data.statusFlg == "0") {
            this.kensyuuList = response.data.data.getTrainingPost;
            this.pagination.total = this.kensyuuList.length;
            this.activeName = "second";
            this.pagination.currentPage = 1;
            this.dataFromTo();
          } else {
            this.$message.error("履歴書まだ完成されていないので、この操作ができません。");
          }
        }
      });
    },

    insertLike(row) {
      // this.setForm();
      // this.vueForm.c0301ListVueForm = this.c0301Form;
      this.vueForm.c0301VueForm = [];
      this.vueForm.c0301VueForm.push({
        companyId: parseInt(row.companyId, 10),
        trainingId: parseInt(row.trainingId, 10),
        applicantId: 0,
        userCd: 0,
      });
      this.$store.dispatch("c0301insertLike", this.vueForm).then((response) => {
        let code = response.data.code;
        if (code == 200) {
          // this.$router.push({
          //   query: { data: response.data.data },
          // });
          this.prefecturesMstBean = response.data.data.prefecturesMstBean;

          this.industryMstBean = response.data.data.industryMstBean;
          if (response.data.data.statusFlg == "0") {
            this.kensyuuList = response.data.data.getTrainingLike;
            this.pagination.total = this.kensyuuList.length;
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
      // this.vueForm.c0301ListVueForm = this.c0301Form;
      this.vueForm.c0301VueForm = [];
      this.vueForm.c0301VueForm.push({
        companyId: parseInt(row.companyId, 10),
        trainingId: parseInt(row.trainingId, 10),
        applicantId: 0,
        userCd: 0,
      });

      this.$store.dispatch("c0301updateLike", this.vueForm).then((response) => {
        let code = response.data.code;
        if (code == 200) {
          // this.$router.push({
          //   query: { data: response.data.data },
          // });
          this.prefecturesMstBean = response.data.data.prefecturesMstBean;

          this.industryMstBean = response.data.data.industryMstBean;

          this.kensyuuList = response.data.data.getTrainingLike;
          this.pagination.total = this.kensyuuList.length;
          this.pagination.currentPage = 1;
          this.dataFromTo();
        }
      });
    },

    deleteApplication(row) {
      // this.setForm();
      // this.vueForm.c0301ListVueForm = this.c0301Form;
      this.vueForm.c0301VueForm = [];
      this.vueForm.c0301VueForm.push({
        companyId: parseInt(row.companyId, 10),
        trainingId: parseInt(row.trainingId, 10),
        applicantId: 0,
        userCd: 0,
      });

      this.$store.dispatch("c0301deleteTrainingAppl", this.vueForm).then((response) => {
        let code = response.data.code;
        if (code == 200) {
          // this.$router.push({
          //   query: { data: response.data.data },
          // });
          this.prefecturesMstBean = response.data.data.prefecturesMstBean;

          this.industryMstBean = response.data.data.industryMstBean;

          this.kensyuuList = response.data.data.getTrainingLike;
          this.pagination.total = this.kensyuuList.length;
          this.pagination.currentPage = 1;
          this.dataFromTo();
        }
      });
    },

    handSelect(selection) {
      this.c0301VueFormzan = selection;
      // console.log(this.c0201VueForm);
    },

    handSelectAll(selection) {
      this.c0301VueFormzan = selection;
      // console.log(this.c0201VueForm);
    },

    selectoubo() {
      // this.setForm();
      // this.vueForm.c0301ListVueForm = this.c0301Form;
      this.vueForm.c0301VueForm = [];
      for (var i = 0; i < this.c0301VueFormzan.length; i++) {
        this.vueForm.c0301VueForm.push({
          companyId: parseInt(this.c0301VueFormzan[i].companyId, 10),
          trainingId: parseInt(this.c0301VueFormzan[i].trainingId, 10),
          applicantId: 0,
          userCd: 0,
        });
      }

      // console.log(this.c0201VueForm);
      if (this.vueForm.c0301VueForm.length > 0) {
        this.$store.dispatch("c0301insertPost", this.vueForm).then((response) => {
          let code = response.data.code;
          if (code == 200) {
            // this.$router.push({
            //   query: { data: response.data.data },
            // });
            this.prefecturesMstBean = response.data.data.prefecturesMstBean;

            this.industryMstBean = response.data.data.industryMstBean;
            if (response.data.data.statusFlg == "0") {
              this.kensyuuList = response.data.data.getTrainingPost;
              this.pagination.total = this.kensyuuList.length;
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
      // this.vueForm.c0301ListVueForm = this.c0301Form;
      this.vueForm.c0301VueForm = [];
      for (var i = 0; i < this.c0301VueFormzan.length; i++) {
        this.vueForm.c0301VueForm.push({
          companyId: parseInt(this.c0301VueFormzan[i].companyId, 10),
          trainingId: parseInt(this.c0301VueFormzan[i].trainingId, 10),
          applicantId: 0,
          userCd: 0,
        });
      }
      if (this.vueForm.c0301VueForm.length > 0) {
        this.$store.dispatch("c0301insertLike", this.vueForm).then((response) => {
          let code = response.data.code;
          if (code == 200) {
            // this.$router.push({
            //   query: { data: response.data.data },
            // });
            this.prefecturesMstBean = response.data.data.prefecturesMstBean;

            this.industryMstBean = response.data.data.industryMstBean;
            if (response.data.data.statusFlg == "0") {
              this.kensyuuList = response.data.data.getTrainingLike;
              this.pagination.total = this.kensyuuList.length;
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
      // this.vueForm.c0301ListVueForm = this.c0301Form;
      this.vueForm.c0301VueForm = [];
      for (var i = 0; i < this.c0301VueFormzan.length; i++) {
        this.vueForm.c0301VueForm.push({
          companyId: parseInt(this.c0301VueFormzan[i].companyId, 10),
          trainingId: parseInt(this.c0301VueFormzan[i].trainingId, 10),
          applicantId: 0,
          userCd: 0,
        });
      }
      if (this.vueForm.c0301VueForm.length > 0) {
        this.$store.dispatch("c0301updateLike", this.vueForm).then((response) => {
          let code = response.data.code;
          if (code == 200) {
            // this.$router.push({
            //   query: { data: response.data.data },
            // });
            this.prefecturesMstBean = response.data.data.prefecturesMstBean;

            this.industryMstBean = response.data.data.industryMstBean;

            this.kensyuuList = response.data.data.getTrainingLike;
            this.pagination.total = this.kensyuuList.length;
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
      // this.vueForm.c0301ListVueForm = this.c0301Form;
      this.vueForm.c0301VueForm = [];
      for (var i = 0; i < this.c0301VueFormzan.length; i++) {
        this.vueForm.c0301VueForm.push({
          companyId: parseInt(this.c0301VueFormzan[i].companyId, 10),
          trainingId: parseInt(this.c0301VueFormzan[i].trainingId, 10),
          applicantId: 0,
          userCd: 0,
        });
      }
      if (this.vueForm.c0301VueForm.length > 0) {
        this.$store.dispatch("c0301deleteTrainingAppl", this.vueForm).then((response) => {
          let code = response.data.code;
          if (code == 200) {
            // this.$router.push({
            //   query: { data: response.data.data },
            // });
            this.prefecturesMstBean = response.data.data.prefecturesMstBean;

            this.industryMstBean = response.data.data.industryMstBean;

            this.kensyuuList = response.data.data.getTrainingLike;
            this.pagination.total = this.kensyuuList.length;
            this.pagination.currentPage = 1;
            this.dataFromTo();
          }
        });
      } else {
        this.$message.error("選択項目がございません。");
      }
    },

    clearJoken() {
      this.c0301Form.trainingNm = "";
      this.c0301Form.companyNm = "";
      this.industryId = "";
      this.date1 = "";
      this.date2 = "";
      this.timer = [];
      this.c0301Form.prefeNm = "";
      this.salary = "2";
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
.datesize {
  width: 10vw;
}
.timesize {
  width: 20vw;
}
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
.biaolanmu2 {
  margin-left: 5%;
  margin-right: 0;
  margin-bottom: 0;
  width: 80%;
}
.hanggao {
  height: 60px;
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
