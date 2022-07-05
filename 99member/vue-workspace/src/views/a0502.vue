<template>
  <div class="a0502Vue">
    <el-container
      ><HomeHeader />
      <div class="a0502Body">
        <el-main>
          <el-form
            :model="a0502VueForm"
            :rules="rules"
            ref="a0502VueForm"
            autocomplete="on"
            label-position="right"
          >
            <div class="a0502Title">
              <el-row>
                <el-col :span="2">
                  <div class="a0502Icon">
                    <el-image :src="require('@/assets/b_titleico3.png')" />
                  </div>
                </el-col>
                <el-col :span="22">
                  <div class="title_name">広告新規入力</div>
                </el-col>
              </el-row>
            </div>
            <div class="a0502Main">
              <div class="a0502TableDiv">
                <el-row :gutter="20" type="flex" justify="end">
                  <el-col :span="14">
                    <el-form-item
                      prop="layoutId"
                      label="レイアウト値段："
                      label-width="130px"
                      :required="true"
                    >
                      <el-select
                        v-model="a0502VueForm.layoutId"
                        placeholder="レイアウト値段"
                        :clearable="true"
                      >
                      <el-option
                          v-for="item in a0502VueForm.layoutIds"
                          :key="item.layoutId"
                          :label="item.layoutMoney"
                          :value="item.layoutId"
                        />
                      </el-select>
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row :gutter="20" type="flex" justify="end">
                  <el-col :span="14">
                    <el-form-item 
                    label-width="130px" 
                    label="会社名:" 
                    prop="companyNm"
                    :required="true"
                    >
                        <el-input
                        class="inputwidth"
                        v-model="a0502VueForm.companyNm"
                        placeholder=""
                        autocomplete="off"
                        v-bind:disabled="a0502VueForm.popFlg != ''"
                        style="width : 275px"
                        >
                        </el-input>
                        <el-button
                        v-if="buttonViewNum"
                        type="primary"
                        icon="el-icon-search"
                        @click="initPop()"
                        class="button-position"
                        circle
                        />
                        <el-button
                        v-else
                        type="primary"
                        icon="el-icon-delete"
                        @click="cleanAll()"
                        class="button-position"
                        circle
                        />
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row :gutter="20" type="flex" justify="end">
                    <el-col :span="10">
                    <el-form-item
                      prop="photo"
                      label="広告写真："
                      label-width="130px"
                      :required="true"
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
                            v-if="a0502VueForm.photo"
                            :src="photoPic"
                            class="avatar"
                            alt=""
                          />
                          <em
                            v-else
                            class="el-icon-plus avatar-uploader-icon"
                          />
                        </el-upload>
                      </div>
                    </el-form-item>
                  </el-col>
                  <el-col :span="14">
                    <el-form-item
                      prop="link"
                      label="リンク："
                      label-width="130px"
                      :required="true"
                    >
                      <el-input
                        v-model="a0502VueForm.link"
                        class="link"
                        maxlength="100"
                        style="width : 275px"
                      />
                    </el-form-item>
                     <el-form-item
                      prop="content"
                      label="プロンプト文字:"
                      label-width="130px"
                    >
                      <el-input
                        type="textarea"
                        v-model="a0502VueForm.content"
                        rows="5"
                        style="width: 275px"
                        maxlength="30"
                      />
                    </el-form-item>
                     <el-form-item 
                    label="有効期間：" 
                    label-width="130px"
                    :required="true"
                    >
                    <el-date-picker
                        v-model="a0502VueForm.dateFrom"
                        type="date"
                        placeholder="有効期間(自)："
                        value-format="yyyy/MM/dd"
                        style="width: 130px"
                        :picker-options="pickerOptions"
                      />
                    -
                    <el-date-picker
                        v-model="a0502VueForm.dateTo"
                        type="date"
                        placeholder="有効期間(至)："
                        value-format="yyyy/MM/dd"
                        style="width: 130px"
                        :picker-options="pickerOptions"
                      />
                  </el-form-item>
                   <el-form-item
                      prop="days"
                      label="日数："
                      label-width="130px"
                      :required="true"
                    >
                      <el-input
                        v-model="a0502VueForm.days"
                        placeholder="日数"
                        style="width : 275px"
                        maxlength="50"
                        @input="numValid('days')"
                        @focus="a0502NumOnFocus($event)"
                        @blur="a0502PersonOnBlur($event)"
                        clearable
                      />
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row :gutter="20" type="flex" justify="end">
                  <el-col :span="14">
                    <el-form-item
                      prop="sum"
                      label="総額："
                      label-width="130px"
                      :required="true"
                    >
                      <el-input
                        v-model="a0502VueForm.sum"
                        placeholder="総額"
                        style="width : 275px"
                        maxlength="500"
                        @focus="sum"
                        @blur="a0502MoneyOnBlur($event)"

                      />
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row :gutter="20" type="flex" justify="end">
                  <el-col :span="14">
                    <el-form-item
                      prop="chargeFlg"
                      label="支払状態："
                      label-width="130px"
                      :required="true"
                    >
                    <el-radio v-model="a0502VueForm.chargeFlg" label="0">支払未済</el-radio>
                    <el-radio v-model="a0502VueForm.chargeFlg" label="1">支払済み</el-radio>
                      </el-form-item>
                  </el-col>
                </el-row>
                <el-row :gutter="20" type="flex" justify="end">
                  <el-col :span="14">
                    <el-form-item
                      prop="onlineFlg"
                      label="オンライン状態："
                      label-width="130px"
                      :required="true"
                    >
                    <el-radio v-model="a0502VueForm.onlineFlg" label="0">オフライン</el-radio>
                    <el-radio v-model="a0502VueForm.onlineFlg" label="1">オンライン</el-radio>
                      </el-form-item>
                  </el-col>
                </el-row>
              </div>
              <el-row>
                <el-col :span="4" :offset="5">
                  <el-button
                    type="primary"
                    class="a0502Button"
                    @click="sendAdInfo()"
                  >
                    確認
                  </el-button>
                </el-col>
                <el-col :span="4" :offset="1">
                  <el-button @click="clearForm()" class="a0502Button">
                    クリア
                  </el-button>
                </el-col>
                <el-col :span="4" :offset="1">
                  <el-button
                    type="primary"
                    @click="routerBack()"
                    class="a0502Button"
                  >
                    戻る
                  </el-button>
                </el-col>
              </el-row>
            </div>
             <modal :show="show" :title="title" @hideModal="hideModal" @submit="submit">
          <el-form
            :rules="rulesPop"
            autocomplete="on"
            :model="companySearchForm"
            ref="companySearchForm"
            label-position="right"
            :inline="true"
          >
            
              <div class="formcontent-popup">
                <el-row>
                  <el-col :span="12">
                  <el-form-item label-width="50px" label="国:" prop="country">
                    <el-select 
                    v-model="companySearchForm.country" 
                    clearable
                    placeholder="国">
                      <el-option
                        v-for="item in countrys"
                        :key="item.countryId"
                        :label="item.countryNm"
                        :value="item.countryId"
                      >
                      </el-option>
                    </el-select>
                  </el-form-item>
                  </el-col>
                  <el-col :span="12">
                  <el-form-item label-width="80px" label="都道府県:" prop="address1">
                    <el-select
                      v-model="companySearchForm.address1"
                      placeholder="選択してください"
                      clearable
                    >
                      <el-option
                        v-for="item in todohuken"
                        :key="item.prefeId"
                        :label="item.prefeNm"
                        :value="item.prefeId"
                      >
                      </el-option>
                    </el-select>
                  </el-form-item>
                  </el-col>
                </el-row>
                <el-row>
                  <el-col :span="12">
                  <el-form-item label-width="50px" label="業種:" prop="industryId1">
                    <el-select
                      v-model="companySearchForm.industryId1"
                      placeholder="選択してください"
                      clearable
                    >
                      <el-option
                        v-for="item in industryIds"
                        :key="item.industryId"
                        :label="item.industryNm"
                        :value="item.industryId"
                      >
                      </el-option>
                    </el-select>
                  </el-form-item>
                  </el-col>
                   <el-col :span="12"> 
                  <el-form-item label-width="110px" label="規模:" prop="companyScale" class="scale">
                    <el-select
                      v-model="companySearchForm.companyScale"
                      placeholder="選択してください"
                      clearable
                    >
                      <el-option
                        v-for="item in companyScales"
                        :key="item.companyScale"
                        :label="item.companyScaleNm"
                        :value="item.companyScale"
                      >
                      </el-option>
                    </el-select>
                  </el-form-item>
                  </el-col>
                </el-row>  
                  <div id="searBox">
                    <el-form-item label-width="60px" label="会社名:" prop="companyNm">
                      <el-input
                        v-model="companySearchForm.companyNm"
                        autocomplete="off"
                      >
                      </el-input>
                    </el-form-item>
                    <el-button
                      margin-left="-5px"
                      @click="searchPop()"
                      type="primary"
                      icon="el-icon-search"
                      >検索</el-button
                    >
                    <el-button
                      margin-left="-5px"
                      @click="hideModal()"
                      type="info"
                      class="button-back-pop"
                      >戻る</el-button
                    >
                  </div>
                
                </div>
          </el-form>
          <div class="formcontent-popup-content">
            <span class="persion2">検索結果</span>
            <hr style="width: 99%; background-color: #f6f6f6; opacity: 0.4" />
            <el-table
              :data="tableData"
              style="width: 100%"
              :show-header="true"
              @row-click="rowClick"
              max-height="380px"
            >
              :row-class-name="tableRowClassName">
              <el-table-column prop="companyId" v-if="false"> </el-table-column>
              <!-- <el-table-column prop="companyLogo" label="アイコン" width="80">
              </el-table-column> -->
              <el-table-column prop="companyNm" label="会社名" width="150" fixed>
              </el-table-column>
              <el-table-column prop="industryNm1" width="100" label="業種">
              </el-table-column>
              <el-table-column prop="countryNm" width="150" label="国籍">
              </el-table-column>
              <el-table-column prop="address1" width="180" label="会社所在地">
              </el-table-column>
              <el-table-column prop="companyTel" width="120" label="連絡先">
              </el-table-column>
              <el-table-column prop="companyScaleNm" label="規模" width="100">
              </el-table-column>
              <el-table-column prop="" label="操作" width="50" fixed="right">
                <template slot-scope="scope">
                  <el-button @click="rowClick(scope.row)" type="text" size="small"
                    >設定</el-button
                  >
                </template>
              </el-table-column>
              <el-table-column prop="companyMail" v-if="false"></el-table-column>
              <el-table-column prop="companyPostal" v-if="false"></el-table-column>
              <el-table-column prop="capital" v-if="false"></el-table-column>
              <el-table-column prop="businessContent" v-if="false"></el-table-column>
              <el-table-column prop="salesAmount" v-if="false"></el-table-column>
              <el-table-column prop="homepage" v-if="false"></el-table-column>
              <el-table-column prop="licenseAddress" v-if="false"></el-table-column>
              <el-table-column prop="companyLogo" v-if="false"></el-table-column>
              <el-table-column prop="photoAddress1" v-if="false"></el-table-column>
              <el-table-column prop="photoAddress2" v-if="false"></el-table-column>
              <el-table-column prop="photoAddress3" v-if="false"></el-table-column>
              <el-table-column prop="videoAddress1" v-if="false"></el-table-column>
              <el-table-column prop="videoAddress2" v-if="false"></el-table-column>
              <el-table-column prop="videoAddress3" v-if="false"></el-table-column>
              <el-table-column prop="industryId1" v-if="false"></el-table-column>
              <el-table-column prop="industryId2" v-if="false"></el-table-column>
              <el-table-column prop="industryId3" v-if="false"></el-table-column>
              <el-table-column prop="industryNm1" v-if="false"></el-table-column>
              <el-table-column prop="industryNm2" v-if="false"></el-table-column>
              <el-table-column prop="industryNm3" v-if="false"></el-table-column>
              <el-table-column prop="countryId" v-if="false"></el-table-column>
            </el-table>
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
          </div>
        </modal>
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
import modal from "./modal.vue";

// 内容チェック機能導入
import {
  validateNecessary,
  numOnBlur,
  numOnFocus,
} from "@/utils/validate";
export default {
  name: "a0502Registered",
  components: {
    HomeHeader,
    HomeFooter,
    modal,
  },
  data() {
    return {
      countrys:"",
      todohuken:"",
      companyScales:"",
      industryIds:"",
      title:"",     
      buttonViewNum: true,
      show: false,
      loading: false,
    
      name: "a0502",
      a0502VueForm: {
        userCd: "",
        adId: "",
        companyId: "",
        companyNm: "",
        layoutId: "",
        layoutIds: "",
        photo: "",
        link: "",
        content: "",
        dateFrom: "",
        dateTo: "",
        days: "",
        sum: "",
        onlineFlg: "",
        chargeFlg: "",
        popFlg: "",
      },
      a0502InForm: {
        adId: "",
        layoutId: "",
        layoutIds: "",
        companyId: "",
        companyNm: "",
        photo: "",
        link: "",
        content: "",
        dateFrom: "",
        dateTo: "",
        days: "",
        sum: "",
        onlineFlg: "",
        chargeFlg: "",
      },
      companySearchForm: {
        companyNm: "",
        country: "",
        address1: "",
        industryId1: "",
        companyScale: "",
      },

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

      tableData: [],

      pickerOptions: {
          disabledDate(time) {
          //如果没有后面的-8.64e7就是不可以选择今天的 
            return time.getTime() < Date.now() - 8.64e7;
         }
      },

      // 画像表示用
      isShow: false,

      rules: {
        layoutId: [validateNecessary("レイアウトID")],
        layoutMoney: [validateNecessary("値段")],
        companyNm: [validateNecessary("会社名")],
        photo: [validateNecessary("広告写真")],
        link: [validateNecessary("リンク")],
        content: [validateNecessary("内容")],
        dateFrom: [validateNecessary("有効期間(自)")],
        dateTo: [validateNecessary("有効期間(至)")],
        days: [validateNecessary("日数")],
        sum: [validateNecessary("総額")],
        chargeFlg: [validateNecessary("支払状態")],
        onlineFlg: [validateNecessary("オンライン状態")],
      },
      rulesPop: {
        country: [{ required: false, message: "国を選択してください。" }],
        address1: [{ required: false, message: "都道府県を入力してください。" }],
        industryId1: [{ required: false, message: "業種を入力してください。" }],
      },
      industryId: 0,
    };
  },
  mounted() {
    document.title = "広告情報新規";
    this.initList();
    this.getLayoutIds();
  },
  methods: {
    sum(){
         this.a0502VueForm.sum = this.a0502VueForm.layoutIds[this.a0502VueForm.layoutId-1].layoutMoney * this.a0502VueForm.days;
        console.log("a0502VueForm", this.a0502VueForm);
        },
    seta0502VueForm() {
      this.a0502VueForm.dateFrom = new Date(this.a0502VueForm.dateFrom);
      this.a0502VueForm.dateTo = new Date(this.a0502VueForm.dateTo);
    },
      // 業種取得
    getLayoutIds() {
      this.$store.dispatch("a0502InitLayout").then((response) => {
        this.$router.push({
          query: { data: response.data.data },
        });
        this.a0502VueForm.layoutIds = response.data.data;
        console.log("layoutIds", this.a0502VueForm.layoutIds);
      });
    },

    sendAdInfo() {
      this.seta0502VueForm();
      this.loading = true;
      this.$store
        .dispatch("sendAdInfo", this.a0502VueForm)
        .then((response) => {
          this.loading = false;
          let code = response.data.code;
          console.clear();
          console.log("a0502VueForm:", this.a0502VueForm);
          if (code == 200) {
            this.$message.success("成功しました！");
            this.$router.push({
              path: "/a0501",
            });
          } else if (code == 404) {
            this.$message.error(response.data.message);
            this.$message.warning("失敗しました！");
          } else {
            this.$router.push({
              path: "/error",
              query: { message: response.data.message },
            });
            this.$message.error("失敗しました！");
          }
        })
        .catch(() => {
          this.loading = false;
        });
    },

    // 毎ページ行目数のselect
    sizeChange(val) {
      this.pagination.pageSize = val;
      console.log("pageSize", this.pagination.pageSize);
      this.dataFromTo();
    },

    // 当ページのボタン
    currentChange(val) {
      this.pagination.currentPage = val;
      console.log("currentPage", this.pagination.currentPage);
      this.dataFromTo();
    },

    // テーブル値行範囲の設定
    dataFromTo() {
      this.pagination.dataStart =
        (this.pagination.currentPage - 1) * this.pagination.pageSize;
      this.pagination.dataEnd = this.pagination.currentPage * this.pagination.pageSize;
    },

    // 入力内容数字制限
    numValid(val) {
      this.a0502VueForm[val] = this.a0502VueForm[val].replace(/[^0-9]/g, "");
    },
    // 数字の処理
    a0502NumOnFocus($event) {
      numOnFocus($event);
    },
    a0502PersonOnBlur($event, endBy = "日") {
      numOnBlur($event, endBy);
    },
    a0502MoneyOnBlur($event, endBy = "円") {
      numOnBlur($event, endBy);
    },

    
    uploadFail() {
      this.$message.error("アップロード失敗");
    },

    handleAvatarSuccesslicense1(res, file) {
      this.$message.success("アップロード成功");
      this.photoPic = URL.createObjectURL(file.raw);
      this.a0502VueForm.photo = res;
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

    // 戻るボタン
    routerBack() {
      console.log("戻る");
      this.$router.replace({ path: "a0003" });
    },

    // クリアボタン
    clearForm() {
      this.a0502VueForm.layoutId = "";
      this.a0502VueForm.companyNm = "";
      this.a0502VueForm.link = "";
      this.a0502VueForm.content = "",
      this.a0502VueForm.dateFrom = "";
      this.a0502VueForm.dateTo = "";
      this.a0502VueForm.days = "";
      this.a0502VueForm.sum = "";
      this.a0502VueForm.chargeFlg = "";
      this.a0502VueForm.onlineFlg = "";
      this.isShow = false;
    },

    //会社メッセージクリア
    cleanAll() {
      this.a0502VueForm.popFlg = "";
      this.buttonViewNum = true;
      this.$refs["a0502VueForm"].resetFields();
      if (this.industryId > 1) {
        this.$refs.buttonDown.$emit("click");
      }
      if (this.industryId > 0) {
        this.$refs.buttonDown.$emit("click");
      }
      if (this.photoAddress > 1) {
        this.$refs.buttonDown1.$emit("click");
      }
      if (this.photoAddress > 0) {
        this.$refs.buttonDown1.$emit("click");
      }
      if (this.vedioAddress > 1) {
        this.$refs.buttonDown2.$emit("click");
      }
      if (this.vedioAddress > 0) {
        this.$refs.buttonDown2.$emit("click");
      }
    },


    initList() {
      this.$store.dispatch("registerInit").then((response) => {
        this.$router.push({
          query: { data: response.data.data },
        });
        this.industryIds = response.data.data.industryList;
        this.companyScales = response.data.data.companyScaleList;
        this.countrys = response.data.data.countryList;
        this.todohuken = response.data.data.prefecturesList;
        this.a0502VueForm.popFlg = "";
      });
    },
    initPop() {
      this.loading = true;
      this.$store
        .dispatch("initPop", this.a0502VueForm.companyNm)
        .then((response) => {
          this.loading = false;
          let code = response.data.code;
          this.companySearchForm.companyNm = this.a0502VueForm.companyNm;
          if (code == 200) {
            this.tableData = response.data.data.companyTblBeanList;
            this.show = true;
          } else if (code == 404) {
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

     searchPop() {
      this.loading = true;
      this.$store
        .dispatch("searchPop", this.companySearchForm)
        .then((response) => {
          this.loading = false;
          let code = response.data.code;
          if (code == 200) {
            this.tableData = response.data.data.companyTblBeanList;
            // データ数を取得する
            this.pagination.total = response.data.data.companyTblBeanList.length;
            // データ数を取得する
            this.pagination.total = response.data.data.companyTblBeanList.length;
          } else if (code == 404) {
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

    //POP画面戻る
    rowClick(row) {
      this.show = false;
      this.a0502VueForm.popFlg = "1";
      this.a0502VueForm.companyNm = row.companyNm;
      this.a0502VueForm.companyId = row.companyId;
      this.a0502VueForm.companyScaleNm = row.companyScaleNm;
      this.buttonViewNum = false;
    },
    setCountryNm() {
      for (var i = 0; i < this.countrys.length; i++) {
        if (this.a0502VueForm.countryId == this.countrys[i].countryId) {
          this.a0502VueForm.countryNm = this.countrys[i].countryNm;
          break;
        }
      }
    },
    setCompanyScaleNm() {
      for (var i = 0; i < this.companyScale.length; i++) {
        if (this.a0502VueForm.companyScale == this.companyScale[i].value) {
          this.a0502VueForm.companyScaleNm = this.companyScale[i].label;
          break;
        }
      }
    },
    setIndustryId1Nm() {
      for (var i = 0; i < this.industryIds.length; i++) {
        if (this.a0502VueForm.industryId1 == this.industryIds[i].industryId1) {
          this.a0502VueForm.industryId1Nm = this.industryIds[i].industryId1Nm;
          break;
        }
      }
    },
    setIndustryId2Nm() {
      for (var i = 0; i < this.industryIds.length; i++) {
        if (this.a0502VueForm.industryId2 == this.industryIds[i].industryId2) {
          this.a0502VueForm.industryId2Nm = this.industryIds[i].industryId2Nm;
          break;
        }
      }
    },
    setIndustryId3Nm() {
      for (var i = 0; i < this.industryIds.length; i++) {
        if (this.a0502VueForm.industryId3 == this.industryIds[i].industryId3) {
          this.a0502VueForm.industryId3Nm = this.industryIds[i].industryId3Nm;
          break;
        }
      }
    },
    hideModal() {
      // 取消弹窗回调
      this.show = false;
    },
    submit() {
      // 确认弹窗回调
      this.show = false;
    },

  },
};
</script>


<style >
/* 全屏主体灰色背景 */
.a0502Body {
  background-color: #f6f6f6;
  width: 100%;
  left: 0px;
  top: 66px;
}
/* 两个主体部分宽80vw，居中，边框阴影，白色背景 */
.a0502Title,
.a0502Main {
  width: 80vw;
  margin-left: 10vw;
  box-shadow: 0 2px 4px #dce5f4, 0 0 6px #dce5f4;
  background-color: #ffffff;
}
/* div内上下距离 */
.a0502Main {
  padding-top: 5vh;
  padding-bottom: 5vh;
}
/* 标题栏上下内外边距 */
.a0502Title {
  margin-top: 0px;
  margin-bottom: 15px;
  padding-top: 0px;
  padding-bottom: 0px;
}
/* 标题栏图标宽，边距 */
.a0502Icon {
  width: 53px;
  margin-left: 26px;
  margin-top: 21px;
  margin-bottom: 21px;
}
/* 标题位置大小颜色等 */
.title_name {
  color: #006699;
  font-weight: 400;
  font-size: 24px;
  margin-top: 35px;
  margin-bottom: 35px;
  margin-left: 14px;
}
/* 邮编前三位输入框 */
.postal1 {
  width: 80px !important;
  margin-right: 11px;
}
/* 邮编后四位输入框 */
.postal2 {
  width: 120px !important;
  margin-left: 11px;
  margin-right: 11px;
}
/* 上传图片尺寸限制在框内 */
.avatar {
  width: 150px;
  height: 150px;
}
/* 输入框下拉框标签宽度修改 */
.el-input,
.el-select {
  width: 280px;
}
/* 地址栏宽度 */
.address {
  width: 82% !important;
}
/* 表格div左边距 */
.a0502TableDiv {
  margin-left: 5vw;
}
/* 下面三个按钮的宽度 */
.a0502Button {
  width: 100px;
  margin-top: 50px;
}
</style>
<style lang="scss" scoped>
body {
  margin-top: 50px;
}

.formcontent-popup {
  background-color: #ffffff;
  width: 900px;
  height: 180px;
  margin-top: 10px;
  padding-top: 20px;
  font-size: 14px;
  .scale{
    margin-left: -33px;
  }

  .el-select {
    .el-input {
      input {
        height: 40px;
        width: 180px;
      }
    }
  }

  #searBox {
    .el-input {
      input {
        height: 40px;
        width: 570px;
      }
    }
  }
}
.formcontent {
  .el-input {
    input {
      height: 40px;
      // width: 491px;
      margin: auto;
      border: 0;
      border-bottom: 1px solid #e0e0e084;
      font-size: 14px;
    }
  }
}
.formcontent-popup-content {
  background-color: #ffffff;
  width: 900px;
  height: 440px;
  margin-top: 20px;
  padding-top: 10px;
  font-size: 12px;
}
.el-table .warning-row {
  background: oldlace;
}

.el-table .success-row {
  background: #f0f9eb;
}
.persion2 {
  color: #014099;
  margin-left: 8px;
  font-size: 14px;
}


</style>
