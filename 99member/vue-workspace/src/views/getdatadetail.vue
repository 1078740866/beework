<!-- データ採集検証のため、新規作成 -->
<!--https://www.ippuukishi.co.jp/products/detail.php?product_id=100009   -->

<template>
  <div class="HomePage">
    <el-container>
      <el-form ref="loginForm" label-position="left" autocomplete="on">
        <el-main class="homeBody">
          <div id="detailrightbloc">
            <!--▼商品ステータス-->

            <!--★商品コード★-->
            <dl class="product_code">
              <dt>商品コード：</dt>
              <dd>
                <span id="product_code_default"> ip-cha-ba-l-02566 </span
                ><span id="product_code_dynamic"></span>
              </dd>
            </dl>

            <!--★タグ★-->
            <!-- <div class="tag tag_detail">
              <span class="tag_deliv">送料無料</span>
              <span class="tag_used">中古品</span>
              <span class="tag_rankab">ランク&nbsp;AB&nbsp;</span>
              <span class="tag_sexl">レディース</span>
            </div> -->
            <br />
            <div>
              <!--★商品名★-->
              <h2>
                326209【中古】【CHANEL】【シャネル】<br />Wフラップチェーンショルダー
                マトラッセ ラムスキン 水色
              </h2>
            </div>

            <!--★販売価格★-->
            <dl class="sale_price">
              <dt>販売価格(税込)：</dt>
              <dd class="price">
                <span id="price02_default">431,200</span
                ><span id="price02_dynamic"></span>
                円
              </dd>
            </dl>
            <dl>
              <dd class="price_rakuten">
                <a
                  id="price_rakuten"
                  href="http://item.rakuten.co.jp/ippuukishi/ip-cha-ba-l-02566/#sh"
                  target="_blank"
                  data-item-id="ip-cha-ba-l-02566"
                  data-item-price="431200"
                ></a>
              </dd>
            </dl>

            <!--▼買い物カゴ-->
            <div class="cart_area clearfix">
              <input type="hidden" name="mode" value="cart" />
              <input type="hidden" name="product_id" value="77304" />
              <input
                type="hidden"
                name="product_class_id"
                value="57120"
                id="product_class_id"
              />
              <input type="hidden" name="favorite_product_id" value="" />
              <!--★数量★-->
              <dl class="quantity">
                <dt>数量：</dt>
                <dd>
                  <input
                    type="text"
                    class="box60"
                    name="quantity"
                    value="1"
                    maxlength="9"
                    style=""
                  />
                </dd>
              </dl>

              <div class="cartin">
                <div class="cartin_btn">
                  <div id="cartbtn_default">
                    <a href="javascript:void(document.form1.submit())">
                      <img
                        class="hover_change_image"
                        src="https://www.ippuukishi.co.jp/user_data/packages/default/img/button/btn_cartin.png"
                        alt="ご購入はこちら"
                      />
                    </a>
                  </div>
                </div>
              </div>
              <div class="attention" id="cartbtn_dynamic"></div>
            </div>
            <div class="main_comment">
              <h4 class="ttl-ptnA">商品詳細</h4>
              <div class="box03">
                <h4 class="ttl-ptnB">スタッフコメント</h4>
                <p>ショルダーバッグ</p>
                <table>
                  <tr>
                    <td class="td-ttl">ジャンル</td>
                    <td>バッグ / BAG</td>
                  </tr>
                  <tr>
                    <td class="td-ttl">ブランド</td>
                    <td>シャネル / CHANEL</td>
                  </tr>
                  <tr>
                    <td class="td-ttl">商品名</td>
                    <td>Wフラップチェーンショルダー</td>
                  </tr>
                  <tr>
                    <td class="td-ttl">ライン</td>
                    <td>マトラッセ</td>
                  </tr>
                  <tr>
                    <td class="td-ttl">素材</td>
                    <td>ラムスキン</td>
                  </tr>
                  <tr>
                    <td class="td-ttl">カラー</td>
                    <td>水色×シルバー金具</td>
                  </tr>
                  <tr>
                    <td class="td-ttl">型番</td>
                    <td>-</td>
                  </tr>
                  <tr>
                    <td class="td-ttl">シリアル</td>
                    <td>5186473</td>
                  </tr>
                  <tr>
                    <td class="td-ttl">ランク</td>
                    <td>AB</td>
                  </tr>
                  <tr>
                    <td class="td-ttl">外側</td>
                    <td>
                      ・底角に少々薄汚れや擦れあり<br />・フラップ縁に僅かな擦れあり<br />・表面レザーに僅かな擦れや薄傷があり、背面レザーに軽い押し跡あり<br />・チェーンレザーに少々擦れあり<br />・金具に僅かな小傷あり
                    </td>
                  </tr>
                  <tr>
                    <td class="td-ttl">内側</td>
                    <td>
                      ・フラップ表面にチェーン金具による押し跡や薄傷、少々擦れあり
                    </td>
                  </tr>
                  <tr>
                    <td class="td-ttl">仕様</td>
                    <td>
                      ターンロック開閉式<br />内側/ファスナーポケット×1
                      オープンポケット×4<br />外側/オープンポケット×1
                    </td>
                  </tr>
                  <tr>
                    <td class="td-ttl">サイズ</td>
                    <td>
                      横/約25cm 縦/約16cm マチ/約7cm<br />シングルショルダー長さ/約90cm<br />ダブルショルダー長さ/約55cm
                    </td>
                  </tr>
                  <tr>
                    <td class="td-ttl">付属品</td>
                    <td>
                      メーカー箱 保存袋 ギャランティーカード シリアルシール
                    </td>
                  </tr>
                </table>
              </div>
              <iframe src="/iframe/info.html" id="frame_info"></iframe>
            </div>
          </div>
        </el-main>
      </el-form>
    </el-container>
    <el-backtop></el-backtop>
  </div>
</template>


<script lang="" scoped>
import "@/css/reset.css";
import "@/css/border.css";

export default {
  name: "HomePage",
  mounted() {
    this.getGoodsList();
  },
  data() {
    return {
      // 転送用form
      G01VueForm: {
        goodsDetail: "",
        goodsPhoto: "",
        goodsLink: "",
        goodsName: "",
        goodsTag: "",
        goodsPrice: "",
      },
      searchNm: "",
      datalist: [],
    };
  },
  methods: {
    getGoodsList() {
      // this.setTrainingData();
      this.$store.dispatch("g01Search", this.G01VueForm).then((response) => {
        this.$router.push({
          query: { data: response.data.data },
        });
        // 商品リストを取得する
        console.log(response.data.data);
        this.datalist = response.data.data.testGoods2TblBean;
      });
    },
    // 検索条件の値を設定する
    // setTrainingData() {
    //   this.B0501VueForm.trainingNm = this.b0501Form.trainingNm;
    //   this.B0501VueForm.industryId = this.b0501Form.industryId;
    //   this.B0501VueForm.statusFlg = this.b0501Form.statusFlg;
    //   this.B0501VueForm.dateFrom = new Date(this.b0501Form.date[0]);
    //   this.B0501VueForm.dateTo = new Date(this.b0501Form.date[1]);
    // },
    toGetdatadetail() {
      let routeUrl = this.$router.resolve({
        path: "/getdatadetail",
        query: {},
      });
      window.open(routeUrl.href, "_blank");
    },
  },
};
</script>

<style>
.ttl-ptnA {
  margin-bottom: 10px;
  padding: 8px;
  padding-left: 15px;
  color: #fcf4d1;
  background: #0c5727
    url(//www.ippuukishi.co.jp/user_data/packages/default/img/background/bg_tit_sub_01.jpg)
    repeat-x left bottom;
  -webkit-background-size: auto 100%;
  background-size: auto 100%;
  font-size: 120%;
  border: 1px solid #073407;
  -webkit-text-shadow: 0.5px 0.866px 1px rgba(0, 0, 0, 0.35);
  -moz-text-shadow: 0.5px 0.866px 1px rgba(0, 0, 0, 0.35);
  -ms-text-shadow: 0.5px 0.866px 1px rgba(0, 0, 0, 0.35);
  -o-text-shadow: 0.5px 0.866px 1px rgba(0, 0, 0, 0.35);
  text-shadow: 0.5px 0.866px 1px rgb(0 0 0 / 35%);
}
.ttl-ptnB {
  background: url(https://www.ippuukishi.co.jp/user_data/packages/default/img/ip/icn-bar02.png)
    no-repeat 0 0.1em;
  color: #19681a;
  padding-left: 18px;
  padding-bottom: 10px;
  margin-bottom: 20px;
  border-bottom: 1px solid #d1d1d1;
}
h1,
h2,
h3,
h4,
h5 {
  font-size: 100%;
  line-height: 150%;
}
table td.td-ttl {
  background: #e5f4e5;
  width: 6em;
  color: #0c5727;
}
table td {
  padding: 10px 8px 8px;
  border: solid 1px #ccc;
  background-color: #fff;
}
.clearfix,
ul,
dl {
  display: block;
}
#detailrightbloc .product_code dt,
#detailrightbloc .product_code dd {
  display: inline;
}
dt {
  font-weight: bold;
}
.tag .tag_deliv {
  background-color: #389d3d;
}
.tag span {
  font-size: 12px;
  background-color: #000;
  margin-right: 3px;
  padding-top: 2px;
  padding-right: 5px;
  padding-bottom: 2px;
  padding-left: 5px;
  color: #fff;
  border-radius: 2px;
  -webkit-border-radius: 2px;
  -moz-border-radius: 2px;
  white-space: nowrap;
  float: left;
  position: relative;
  margin-bottom: 3px;
}
.tag .tag_used {
  background-color: #f26432;
}
.tag .tag_sexl {
  background-color: #cf0982;
}
h1,
h2,
h3,
h4,
h5,
h6 {
  letter-spacing: 1px;
}
h1,
h2,
h3,
h4,
h5 {
  font-size: 100%;
  line-height: 150%;
}
#detailrightbloc h2 {
  margin: 10px 0 10px 0;
  padding: 0 0 15px 0;
  color: #666;
  /* background: url(../img/background/line_dot_01.gif) repeat-x bottom; */
  font-weight: bold;
  font-size: 150%;
  color: #0c5727;
}
.sale_price {
  color: #c00000;
  font-size: 150%;
}
dt {
  font-weight: bold;
}
#detailarea .sale_price {
  font-size: 150%;
}
body {
  font-size: 13px;
  line-height: 1.5;
  color: #333333;
  font-family: "メイリオ", Meiryo, "ヒラギノ角ゴ Pro W3",
    "Hiragino Kaku Gothic Pro", Osaka, "ＭＳ Ｐゴシック", sans-serif;
}
#detailrightbloc .cart_area {
    padding: 10px;
    background-color: #f8f7ea;
    border: 1px solid #e5e4d0;
    margin-bottom: 20px;
    /* text-align: center; */
}
.HomePage {
  min-width: 1200px;
}
.main_comment {
  margin: 25px 0px;
}
.homeHeader {
  height: 65px !important;
}
.el-menu-header.el-menu--horizontal {
  border-bottom: solid 0px;
}
.homeHeaderRoot {
  position: fixed;
  z-index: 100;
  height: 65px !important;
  top: 0px;
  left: 0px;
  bottom: 0px;
  width: 100%;
  border: 0px;
  background-color: #ffffff;
  box-shadow: 0px 20px 20px -20px #dbdbdb;
}
.space {
  width: 45%;
  pointer-events: none;
}
.space1 {
  width: 1%;
  pointer-events: none;
}
.searchBackground {
  width: 100%;
  height: 100%;
  background-size: contain;
  background-position: left;
}
.searchInput {
  padding: 0px 1%;
  z-index: 0;
}
.searchInputInner .el-input__inner {
  font-size: 18px;
  height: 60px !important;
}
/* .homeBody {
  padding-top: 10px;
  background-color: rgb(240, 240, 240);
} */
.block {
  color: #1d2125;
  width: 100%;
}
.el-input-group__append,
.el-input-group__prepend {
  background-color: #0099ff;
  color: #ffffff;
  border: 1px solid #0099ff;
}
.el-input-group__append button.el-button {
  height: 54px !important;
}
.buttonSelect {
  width: 80px;
}
</style>