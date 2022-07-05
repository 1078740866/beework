<template>
  <div>
    <el-container>
      <el-header>
        <div class="header">
          <ApplicantHeader />
        </div>
      </el-header>
      <el-form :model="c0401Form" ref="c0401Form" label-position="left" autocomplete="on">
        <el-main class="b0501_body">
          <div class="b0501_select">
            <el-row>
              <el-col :span="24">
                <div class="b0501_title">説明会一覧</div>
              </el-col>
            </el-row>
            <div class="select_body">
              <el-row :gutter="1">
                <el-col :span="7" :offset="1">
                  <div>
                    <el-form-item label-width="80px" label="説明会名：">
                      <el-input v-model="c0401Form.briefingNm" placeholder="説明会名" />
                    </el-form-item>
                  </div>
                </el-col>

                <el-col :span="6" :offset="1">
                  <div>
                    <el-form-item label="会社名：" label-width="80px">
                      <el-input v-model="c0401Form.companyNm" placeholder="会社名"/>
                    </el-form-item>
                  </div>
                </el-col>
                <el-col :span="5" :offset="1">
                  <div>
                    <el-form-item label="説明会方式：" label-width="90px">
                      <el-select
                        v-model="c0401Form.briefingType"
                        placeholder="説明会方式"
                        clearable
                      >
                        <el-option
                          v-for="item in briefing_type"
                          :key="item.typeId"
                          :label="item.typeNm"
                          :value="item.typeId"
                        />
                      </el-select>
                    </el-form-item>
                  </div>
                </el-col>
              </el-row>
            </div>

            <el-row>
              <el-col :span="12" :offset="1">
                <div>
                  <el-form-item label="日付：" label-width="50px">
                    <el-date-picker
                      v-model="date1"
                      type="date"
                      align="right"
                      value-format="yyyy-MM-dd"
                      class="datesize"
                      placeholder="開始日付"
                    >
                    </el-date-picker>
                    -
                    <el-date-picker
                      v-model="date2"
                      type="date"
                      align="right"
                      value-format="yyyy-MM-dd"
                      class="datesize"
                      placeholder="終了日付"
                    >
                    </el-date-picker>
                  </el-form-item>
                </div>
              </el-col>
              <el-col :span="5" :offset="0">
                <div>
                  <el-form-item label="場所：" label-width="50px">
                    <el-select v-model="c0401Form.prefeNm" placeholder="場所" clearable>
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
                    <el-link @click="getBriefingData" type="primary" :underline="false">
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
                      @click="getBriefingData"
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
              <el-tab-pane label="説明会推薦" name="first">
                <el-table
                  ref="suisenTable"
                  :data="getsetsumeikaiList"
                  style="width: 100%"
                  height="350px"
                  @select="handSelect"
                  @select-all="handSelectAll"
                >
                  <el-table-column type="expand">
                    <template slot-scope="props">
                      <el-form label-position="left" inline label-width="100px">
                        <el-form-item label="説明会時間" class="biaolanmu">
                          <span
                            >{{ props.row.briefingDate }} {{ props.row.dateFrom }}-{{
                              props.row.dateTo
                            }}
                          </span>
                        </el-form-item>
                        <el-form-item label="説明会場所" class="biaolanmu">
                          <span>{{ props.row.briefingAddress1 }}</span>
                        </el-form-item>
                        <el-form-item label="担当" class="biaolanmu">
                          <span>{{ props.row.teaNm }}</span>
                        </el-form-item>
                        <el-form-item label="連絡先" class="biaolanmu">
                          <span>{{ props.row.tel }}</span>
                        </el-form-item>
                        <el-form-item label="説明会内容" class="biaolanmu2">
                          <span> {{ props.row.briefingContent}}</span>
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
                    prop="briefingId"
                    label="briefingId"
                    width="100"
                    v-if="false"
                  />
                  <el-table-column prop="briefingNm" label="説明会名" width="150" />
                  <el-table-column prop="companyNm" label="会社名" width="150" />
                  <!-- <el-table-column prop="dateFrom" label="開始時間" width="100" />
                  <el-table-column prop="dateTo" label="終了時間" width="100" /> -->
                  <el-table-column prop="briefingType" label="説明会方式" width="150">
                    <template v-slot="briefingType">
                      <span v-if="briefingType.row.briefingType == '0'">現場</span>
                      <span v-if="briefingType.row.briefingType == '1'">生放送</span>
                    </template>
                  </el-table-column>
                  <!-- <el-table-column
                    prop="briefingAddress1"
                    label="説明会場所"
                    width="100"
                  /> -->
                  <el-table-column prop="proCntPlan" label="予定人数" />
                  <!-- <el-table-column prop="teaNm" label="担当" width="100" />
                  <el-table-column prop="tel" label="連絡先" /> -->

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
              <el-tab-pane label="応募済み" name="second">
                <el-table
                  ref="ouboTable"
                  :data="getsetsumeikaiList"
                  style="width: 100%"
                  height="350px"
                >
                  <el-table-column type="expand">
                    <template slot-scope="props">
                      <el-form label-position="left" inline label-width="100px">
                        <el-form-item label="説明会時間" class="biaolanmu">
                          <span
                            >{{ props.row.briefingDate }} {{ props.row.dateFrom }}-{{
                              props.row.dateTo
                            }}
                          </span>
                        </el-form-item>
                        <el-form-item label="説明会場所" class="biaolanmu">
                          <span>{{ props.row.briefingAddress1 }}</span>
                        </el-form-item>
                        <el-form-item label="担当" class="biaolanmu">
                          <span>{{ props.row.teaNm }}</span>
                        </el-form-item>
                        <el-form-item label="連絡先" class="biaolanmu">
                          <span>{{ props.row.tel }}</span>
                        </el-form-item>
                        <el-form-item label="説明会内容" class="biaolanmu2">
                          <span> {{ props.row.briefingContent}}</span>
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
                    prop="briefingId"
                    label="briefingId"
                    width="100"
                    v-if="false"
                  />
                  <el-table-column prop="briefingNm" label="説明会名" width="150" />
                  <el-table-column prop="companyNm" label="会社名" width="150" />
                  <!-- <el-table-column prop="dateFrom" label="開始時間" width="100" />
                  <el-table-column prop="dateTo" label="終了時間" width="100" /> -->
                  <el-table-column prop="briefingType" label="説明会方式" width="150">
                    <template v-slot="briefingType">
                      <span v-if="briefingType.row.briefingType == '0'">現場</span>
                      <span v-if="briefingType.row.briefingType == '1'">生放送</span>
                    </template>
                  </el-table-column>
                  <!-- <el-table-column
                    prop="briefingAddress1"
                    label="説明会場所"
                    width="100"
                  /> -->
                  <el-table-column prop="proCntPlan" label="予定人数" />
                  <!-- <el-table-column prop="teaNm" label="担当" width="100" />
                  <el-table-column prop="tel" label="連絡先" /> -->

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
                  ref="kiniTable"
                  :data="getsetsumeikaiList"
                  style="width: 100%"
                  height="350px"
                  @select="handSelect"
                  @select-all="handSelectAll"
                >
                  <el-table-column type="expand">
                    <template slot-scope="props">
                      <el-form label-position="left" inline label-width="100px">
                        <el-form-item label="説明会時間" class="biaolanmu">
                          <span
                            >{{ props.row.briefingDate }} {{ props.row.dateFrom }}-{{
                              props.row.dateTo
                            }}
                          </span>
                        </el-form-item>
                        <el-form-item label="説明会場所" class="biaolanmu">
                          <span>{{ props.row.briefingAddress1 }}</span>
                        </el-form-item>
                        <el-form-item label="担当" class="biaolanmu">
                          <span>{{ props.row.teaNm }}</span>
                        </el-form-item>
                        <el-form-item label="連絡先" class="biaolanmu">
                          <span>{{ props.row.tel }}</span>
                        </el-form-item>
                        <el-form-item label="説明会内容" class="biaolanmu2">
                          <span> {{ props.row.briefingContent}}</span>
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
                    prop="briefingId"
                    label="briefingId"
                    width="100"
                    v-if="false"
                  />
                  <el-table-column prop="briefingNm" label="説明会名" width="150" />
                  <el-table-column prop="companyNm" label="会社名" width="150" />
                  <!-- <el-table-column prop="dateFrom" label="開始時間" width="100" />
                  <el-table-column prop="dateTo" label="終了時間" width="100" /> -->
                  <el-table-column prop="briefingType" label="説明会方式" width="150">
                    <template v-slot="briefingType">
                      <span v-if="briefingType.row.briefingType == '0'">現場</span>
                      <span v-if="briefingType.row.briefingType == '1'">生放送</span>
                    </template>
                  </el-table-column>
                  <!-- <el-table-column
                    prop="briefingAddress1"
                    label="説明会場所"
                    width="100"
                  /> -->
                  <el-table-column prop="proCntPlan" label="予定人数" />
                  <!-- <el-table-column prop="teaNm" label="担当" width="100" />
                  <el-table-column prop="tel" label="連絡先" /> -->

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
              <el-tab-pane label="説明会一覧" name="forth">
                <el-table
                  ref="ichiranTable"
                  :data="getsetsumeikaiList"
                  style="width: 100%"
                  height="350px"
                  @select="handSelect"
                  @select-all="handSelectAll"
                >
                  <el-table-column type="expand">
                    <template slot-scope="props">
                      <el-form label-position="left" inline label-width="100px">
                        <el-form-item label="説明会時間" class="biaolanmu">
                          <span
                            >{{ props.row.briefingDate }} {{ props.row.dateFrom }}-{{
                              props.row.dateTo
                            }}
                          </span>
                        </el-form-item>
                        <el-form-item label="説明会場所" class="biaolanmu">
                          <span>{{ props.row.briefingAddress1 }}</span>
                        </el-form-item>
                        <el-form-item label="担当" class="biaolanmu">
                          <span>{{ props.row.teaNm }}</span>
                        </el-form-item>
                        <el-form-item label="連絡先" class="biaolanmu">
                          <span>{{ props.row.tel }}</span>
                        </el-form-item>
                        <el-form-item label="説明会内容" class="biaolanmu2">
                          <span> {{ props.row.briefingContent}}</span>
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
                    prop="briefingId"
                    label="briefingId"
                    width="100"
                    v-if="false"
                  />
                  <el-table-column prop="briefingNm" label="説明会名" width="150" />
                  <el-table-column prop="companyNm" label="会社名" width="150" />
                  <!-- <el-table-column prop="dateFrom" label="開始時間" width="100" />
                  <el-table-column prop="dateTo" label="終了時間" width="100" /> -->
                  <el-table-column prop="briefingType" label="説明会方式" width="150">
                    <template v-slot="briefingType">
                      <span v-if="briefingType.row.briefingType == '0'">現場</span>
                      <span v-if="briefingType.row.briefingType == '1'">生放送</span>
                    </template>
                  </el-table-column>
                  <!-- <el-table-column
                    prop="briefingAddress1"
                    label="説明会場所"
                    width="100"
                  /> -->
                  <el-table-column prop="proCntPlan" label="予定人数" />
                  <!-- <el-table-column prop="teaNm" label="担当" width="100" />
                  <el-table-column prop="tel" label="連絡先" /> -->

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
      vueForm: {
        c0401VueForm: [],
        c0401ListVueForm: {
          briefingNm: "",
          companyNm: "",
          briefingType: "",
          prefeNm: "",
          dateFrom: "",
          dateTo: "",
          userCd: Number,
          applicantId: Number,
        },
      },
      c0401Form: {
        briefingNm: "",
        companyNm: "",
        briefingType: "",
        prefeNm: "",
        dateFrom: "",
        dateTo: "",
        userCd: Number,
        applicantId: Number,
      },
      prefeId: "",

      activeName: "first",

      setsumeikaiList: [],

      prefecturesMstBean: [],
      briefing_type: [
        { typeId: "0", typeNm: "現場" },
        { typeId: "1", typeNm: "生放送" },
      ],

      c0401VueFormzan: [],

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
    document.title = "説明会一覧";
    this.getSetsumeiData();
  },

  computed: {
    getsetsumeikaiList() {
      if (this.setsumeikaiList != null) {
        return (
          this.setsumeikaiList.slice(
            this.pagination.dataStart,
            this.pagination.dataEnd
          ) || ""
        );
      } else {
        return [];
      }
    },
  },

  methods: {
    getSetsumeiData() {
      this.setForm();
      this.$store.dispatch("c0401Init", this.c0401Form).then((response) => {
        // this.$router.push({
        //   query: { data: response.data.data },
        // });

        this.prefecturesMstBean = response.data.data.prefecturesMstBean;

        if (response.data.data.getBriefing != null) {
          this.setsumeikaiList = response.data.data.getBriefing;
          this.pagination.total = this.setsumeikaiList.length;
        } else {
          this.setsumeikaiList = [];
          this.pagination.total = 0;
        }
        this.pagination.currentPage = 1;
        this.dataFromTo();
        // console.clear();
      });
    },

    getSetsumeiIchiran() {
      this.setForm();
      this.$store.dispatch("c0401getList", this.c0401Form).then((response) => {
        // this.$router.push({
        //   query: { data: response.data.data },
        // });

        this.prefecturesMstBean = response.data.data.prefecturesMstBean;

        if (response.data.data.getBriefing != null) {
          this.setsumeikaiList = response.data.data.getBriefing;
          this.pagination.total = this.setsumeikaiList.length;
        } else {
          this.setsumeikaiList = [];
          this.pagination.total = 0;
        }
        this.pagination.currentPage = 1;
        this.dataFromTo();
        // console.clear();
      });
    },

    setForm() {
      this.c0401Form.dateFrom = this.date1;
      this.c0401Form.dateTo = this.date2;
    },

    getBriefingData() {
      this.getSetsumeiIchiran();
      this.activeName = "forth";
      this.c0401VueFormzan = [];
    },

    handleClick() {
      this.c0401VueFormzan = [];
      this.setForm();
      if (this.activeName == "second") {
        this.$store.dispatch("c0401InitPost", this.c0401Form).then((response) => {
          // this.$router.push({
          //   query: { data: response.data.data },
          // });

          this.prefecturesMstBean = response.data.data.prefecturesMstBean;

          this.setsumeikaiList = response.data.data.getBriefingPost;
          this.pagination.total = this.setsumeikaiList.length;

          // console.clear();
        });
        this.pagination.currentPage = 1;
        this.dataFromTo();
        // console.log(this.pagination.currentPage);
      }
      if (this.activeName == "third") {
        this.$store.dispatch("c0401InitLike", this.c0401Form).then((response) => {
          // this.$router.push({
          //   query: { data: response.data.data },
          // });

          this.prefecturesMstBean = response.data.data.prefecturesMstBean;

          this.setsumeikaiList = response.data.data.getBriefingLike;
          this.pagination.total = this.setsumeikaiList.length;

          // console.clear();
        });
        this.pagination.currentPage = 1;
        this.dataFromTo();
        // console.log(this.pagination.currentPage);
      }

      if (this.activeName == "first") {
        this.$store.dispatch("c0401Init", this.c0401Form).then((response) => {
          // this.$router.push({
          //   query: { data: response.data.data },
          // });

          this.prefecturesMstBean = response.data.data.prefecturesMstBean;
          if (response.data.data.getBriefing != null) {
            this.setsumeikaiList = response.data.data.getBriefing;
            this.pagination.total = this.setsumeikaiList.length;
          } else {
            this.setsumeikaiList = [];
            this.pagination.total = 0;
          }

          // console.clear();
        });
        this.pagination.currentPage = 1;
        this.dataFromTo();
        // console.log(this.pagination.currentPage);
      }

      if (this.activeName == "forth") {
        this.$store.dispatch("c0401getList", this.c0401Form).then((response) => {
          // this.$router.push({
          //   query: { data: response.data.data },
          // });

          this.prefecturesMstBean = response.data.data.prefecturesMstBean;
          if (response.data.data.getBriefing != null) {
            this.setsumeikaiList = response.data.data.getBriefing;
            this.pagination.total = this.setsumeikaiList.length;
          } else {
            this.setsumeikaiList = [];
            this.pagination.total = 0;
          }

          // console.clear();
        });
        this.pagination.currentPage = 1;
        this.dataFromTo();
        // console.log(this.pagination.currentPage);
      }
    },
    // 毎ページ行目数のselect
    sizeChange(val) {
      this.pagination.pageSize = val;
      console.log("pageSize", this.pagination.pageSize);
      this.dataFromTo();
      this.c0401VueFormzan = [];
    },
    // 当ページのボタン
    currentChange(val) {
      this.pagination.currentPage = val;
      console.log("currentPage", this.pagination.currentPage);
      this.dataFromTo();
      this.c0401VueFormzan = [];
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
      this.setForm();
      this.vueForm.c0401ListVueForm = this.c0401Form;
      this.vueForm.c0401VueForm = [];
      this.vueForm.c0401VueForm.push({
        companyId: parseInt(row.companyId, 10),
        briefingId: parseInt(row.briefingId, 10),
        applicantId: 0,
        userCd: 0,
      });
      this.$store.dispatch("c0401insertPost", this.vueForm).then((response) => {
        let code = response.data.code;
        if (code == 200) {
          // this.$router.push({
          //   query: { data: response.data.data },
          // });
          this.prefecturesMstBean = response.data.data.prefecturesMstBean;
          if (response.data.data.statusFlg == "0") {
            this.setsumeikaiList = response.data.data.getBriefingPost;
            this.pagination.total = this.setsumeikaiList.length;
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
      this.setForm();
      this.vueForm.c0401ListVueForm = this.c0401Form;
      this.vueForm.c0401VueForm = [];
      this.vueForm.c0401VueForm.push({
        companyId: parseInt(row.companyId, 10),
        briefingId: parseInt(row.briefingId, 10),
        applicantId: 0,
        userCd: 0,
      });
      this.$store.dispatch("c0401insertLike", this.vueForm).then((response) => {
        let code = response.data.code;
        if (code == 200) {
          // this.$router.push({
          //   query: { data: response.data.data },
          // });
          this.prefecturesMstBean = response.data.data.prefecturesMstBean;
          if (response.data.data.statusFlg == "0") {
            this.setsumeikaiList = response.data.data.getBriefingLike;
            this.pagination.total = this.setsumeikaiList.length;

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
      this.setForm();
      this.vueForm.c0401ListVueForm = this.c0401Form;
      this.vueForm.c0401VueForm = [];
      this.vueForm.c0401VueForm.push({
        companyId: parseInt(row.companyId, 10),
        briefingId: parseInt(row.briefingId, 10),
        applicantId: 0,
        userCd: 0,
      });
      console.log(this.vueForm.c0401VueForm);

      this.$store.dispatch("c0401updateLike", this.vueForm).then((response) => {
        let code = response.data.code;
        if (code == 200) {
          // this.$router.push({
          //   query: { data: response.data.data },
          // });
          this.prefecturesMstBean = response.data.data.prefecturesMstBean;

          this.setsumeikaiList = response.data.data.getBriefingLike;
          this.pagination.total = this.setsumeikaiList.length;
          this.pagination.currentPage = 1;
          this.dataFromTo();
        }
      });
    },

    deleteApplication(row) {
      this.setForm();
      this.vueForm.c0401ListVueForm = this.c0401Form;
      this.vueForm.c0401VueForm = [];
      this.vueForm.c0401VueForm.push({
        companyId: parseInt(row.companyId, 10),
        briefingId: parseInt(row.briefingId, 10),
        applicantId: 0,
        userCd: 0,
      });

      this.$store.dispatch("c0401deleteBriefingAppl", this.vueForm).then((response) => {
        let code = response.data.code;
        if (code == 200) {
          // this.$router.push({
          //   query: { data: response.data.data },
          // });
          this.prefecturesMstBean = response.data.data.prefecturesMstBean;

          this.setsumeikaiList = response.data.data.getBriefingLike;
          this.pagination.total = this.setsumeikaiList.length;
          this.pagination.currentPage = 1;
          this.dataFromTo();
        }
      });
    },

    handSelect(selection) {
      this.c0401VueFormzan = selection;
      // console.log(this.c0201VueForm);
    },

    handSelectAll(selection) {
      this.c0401VueFormzan = selection;
      // console.log(this.c0201VueForm);
    },

    selectoubo() {
      this.setForm();
      this.vueForm.c0401ListVueForm = this.c0401Form;
      this.vueForm.c0401VueForm = [];
      for (var i = 0; i < this.c0401VueFormzan.length; i++) {
        this.vueForm.c0401VueForm.push({
          companyId: parseInt(this.c0401VueFormzan[i].companyId, 10),
          briefingId: parseInt(this.c0401VueFormzan[i].briefingId, 10),
          applicantId: 0,
          userCd: 0,
        });
      }

      // console.log(this.c0201VueForm);
      if (this.vueForm.c0401VueForm.length > 0) {
        this.$store.dispatch("c0401insertPost", this.vueForm).then((response) => {
          let code = response.data.code;
          if (code == 200) {
            // this.$router.push({
            //   query: { data: response.data.data },
            // });
            this.prefecturesMstBean = response.data.data.prefecturesMstBean;
            if (response.data.data.statusFlg == "0") {
              this.setsumeikaiList = response.data.data.getBriefingPost;
              this.pagination.total = this.setsumeikaiList.length;
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
      this.setForm();
      this.vueForm.c0401ListVueForm = this.c0401Form;
      this.vueForm.c0401VueForm = [];
      for (var i = 0; i < this.c0401VueFormzan.length; i++) {
        this.vueForm.c0401VueForm.push({
          companyId: parseInt(this.c0401VueFormzan[i].companyId, 10),
          briefingId: parseInt(this.c0401VueFormzan[i].briefingId, 10),
          applicantId: 0,
          userCd: 0,
        });
      }
      if (this.vueForm.c0401VueForm.length > 0) {
        this.$store.dispatch("c0401insertLike", this.vueForm).then((response) => {
          let code = response.data.code;
          if (code == 200) {
            // this.$router.push({
            //   query: { data: response.data.data },
            // });
            this.prefecturesMstBean = response.data.data.prefecturesMstBean;
            if (response.data.data.statusFlg == "0") {
              this.setsumeikaiList = response.data.data.getBriefingLike;
              this.pagination.total = this.setsumeikaiList.length;
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
      this.setForm();
      this.vueForm.c0401ListVueForm = this.c0401Form;
      this.vueForm.c0401VueForm = [];
      for (var i = 0; i < this.c0401VueFormzan.length; i++) {
        this.vueForm.c0401VueForm.push({
          companyId: parseInt(this.c0401VueFormzan[i].companyId, 10),
          briefingId: parseInt(this.c0401VueFormzan[i].briefingId, 10),
          applicantId: 0,
          userCd: 0,
        });
      }
      if (this.vueForm.c0401VueForm.length > 0) {
        this.$store.dispatch("c0401updateLike", this.vueForm).then((response) => {
          let code = response.data.code;
          if (code == 200) {
            // this.$router.push({
            //   query: { data: response.data.data },
            // });
            this.prefecturesMstBean = response.data.data.prefecturesMstBean;

            this.setsumeikaiList = response.data.data.getBriefingLike;
            this.pagination.total = this.setsumeikaiList.length;
            this.pagination.currentPage = 1;
            this.dataFromTo();
          }
        });
      } else {
        this.$message.error("選択項目がございません。");
      }
    },

    selectdelete() {
      this.setForm();
      this.vueForm.c0401ListVueForm = this.c0401Form;
      this.vueForm.c0401VueForm = [];
      for (var i = 0; i < this.c0401VueFormzan.length; i++) {
        this.vueForm.c0401VueForm.push({
          companyId: parseInt(this.c0401VueFormzan[i].companyId, 10),
          briefingId: parseInt(this.c0401VueFormzan[i].briefingId, 10),
          applicantId: 0,
          userCd: 0,
        });
      }
      if (this.vueForm.c0401VueForm.length > 0) {
        this.$store.dispatch("c0401deleteBriefingAppl", this.vueForm).then((response) => {
          let code = response.data.code;
          if (code == 200) {
            // this.$router.push({
            //   query: { data: response.data.data },
            // });
            this.prefecturesMstBean = response.data.data.prefecturesMstBean;

            this.setsumeikaiList = response.data.data.getBriefingLike;
            this.pagination.total = this.setsumeikaiList.length;
            this.pagination.currentPage = 1;
            this.dataFromTo();
          }
        });
      } else {
        this.$message.error("選択項目がございません。");
      }
    },

    clearJoken() {
      this.c0401Form.briefingNm = "";
      this.c0401Form.companyNm = "";
      this.date1 = "";
      this.date2 = "";
      this.c0401Form.prefeNm = "";
      this.c0401Form.briefingType = "";
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
  width: 14vw;
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
