<template>
  <div>
    <div>
      <div class="spb0003head">
        <el-row
          class="el-menu-demo"
          background-color="#014099"
          text-color="#fff"
        >
          <el-col :span="8">
            <div>
              <el-image :src="require('@/spAssets/logo.png')" class="imgAd"/>
            </div>
          </el-col>
          <el-col :span="13" class="colUser">
            <div class="el-icon-user" style="font-size:24px;margin-right:15px"></div>{{this.userDate}}
          </el-col>
          <el-col :span="3">
            <el-link @click="logout">
              <em class="el-icon-switch-button"></em>
            </el-link>
          </el-col>
        </el-row>
      </div>
      <div class="headerLast"></div>
    </div>
    <div>
      <el-carousel class="carousel" arrow="always" trigger="click">
        <el-carousel-item v-for="(img,index) in imgList" :key="index">
         <div style="width:100%;height:100%" @click="comeAd(img.url)">
           <img :src="img.url" class="imgCenter">
         </div>
        </el-carousel-item>
      </el-carousel>
    </div>
    <el-row :gutter="20" class="b0003row">
      <el-col :span="6">
        <el-button
          class="b0003Img"
          size="medium"
          type="text"
          @click="toB0101"
          round
          ><img class="grid-content" src="@/spAssets/b_box_ico1.png"/>
        </el-button>
      </el-col>
      <el-col :span="6">
        <el-button
          class="b0003Img"
          size="medium"
          type="text"
          @click="toB0201"
          round
          ><img class="grid-content" src="@/spAssets/b_box_ico2.png"/>
        </el-button>
      </el-col>
      <el-col :span="6">
        <el-button
          class="b0003Img"
          size="medium"
          type="text"
          @click="toB0301"
          round
          ><img class="grid-content" src="@/spAssets/b_box_ico3.png"/>
        </el-button>
      </el-col>
      <el-col :span="6">
        <el-button
          class="b0003Img"
          size="medium"
          type="text"
          @click="toB0401"
          round
          ><img class="grid-content" src="@/spAssets/b_box_ico4.png"/>
        </el-button>
      </el-col>
    </el-row>
    <el-row :gutter="20" class="b0003row">
      <el-col :span="6" class="col1">
        <el-button
          class="b0003ElButton"
          size="medium"
          type="text"
          @click="toB0101"
          round
          >職位
        </el-button>
      </el-col>
      <el-col :span="6" class="col1">
        <el-button
          class="b0003ElButton"
          size="medium"
          type="text"
          @click="toB0201"
          round
          >応募者
        </el-button>
      </el-col>
      <el-col :span="6" class="col1">
        <el-button
          class="b0003ElButton"
          size="medium"
          type="text"
          @click="toB0301"
          round
          >求人
        </el-button>
      </el-col>
      <el-col :span="6" class="col1">
        <el-button
          class="b0003ElButton"
          size="medium"
          type="text"
          @click="toB0401"
          round
          >面接
        </el-button>
      </el-col>
    </el-row>
    <el-row :gutter="20" class="b0003row">
      <el-col :span="6">
        <el-button
          class="b0003Img"
          size="medium"
          type="text"
          @click="toB0501"
          round
          ><img class="grid-content" src="@/spAssets/b_box_ico5.png"/>
        </el-button>
      </el-col>
      <el-col :span="6">
        <el-button
          class="b0003Img"
          size="medium"
          type="text"
          @click="toB0601"
          round
          ><img class="grid-content" src="@/spAssets/b_box_ico6.png"/>
        </el-button>
      </el-col>
      <el-col :span="6">
        <el-button
          class="b0003Img"
          size="medium"
          type="text"
          @click="toB0701"
          round
          ><img class="grid-content" src="@/spAssets/b_box_ico7.png"/>
        </el-button>
      </el-col>
      <el-col :span="6">
        <el-button
          class="b0003Img"
          size="medium"
          type="text"
          @click="toB0801"
          round
          ><img class="grid-content" src="@/spAssets/b_box_ico8.png"/>
        </el-button>
      </el-col>
    </el-row>
    <el-row :gutter="20" class="b0003row">
      <el-col :span="6" class="col1">
        <el-button
          class="b0003ElButton"
          size="medium"
          type="text"
          @click="toB0501"
          round
          >研修会
        </el-button>
      </el-col>
      <el-col :span="6" class="col1">
        <el-button
          class="b0003ElButton"
          size="medium"
          type="text"
          @click="toB0601"
          round
          >説明会
        </el-button>
      </el-col>
      <el-col :span="6" class="col1">
        <el-button
          class="b0003ElButton"
          size="medium"
          type="text"
          @click="toB0701"
          round
          >基本情報
        </el-button>
      </el-col>
      <el-col :span="6" class="col1">
        <el-button
          class="b0003ElButton"
          size="medium"
          type="text"
          @click="toB0801"
          round
          >資産管理
        </el-button>
      </el-col>
    </el-row>
    <div id="TabBar" class="tab-bar row">
			<div class="cell-3 tab-bar-item">
				<div class="row" @click="layOut(1)">
					<span>
            <img :src="this.aaa == 1?require('@/spAssets/tab1.png'):require('@/spAssets/tab1-1.png')" alt="" />
            <div v-bind:class="{active: actives[0]}">HOME</div>
          </span>
				</div>
			</div>
			<div class="cell-3 tab-bar-item">
				<div class="row" @click="layOut(2)">
					<span>
            <img :src="this.aaa == 2?require('@/spAssets/tab2.png'):require('@/spAssets/tab2-1.png')" alt="" />
            <div v-bind:class="{active: actives[1]}">応募者一覧</div>
          </span>
				</div>
			</div>
			<div class="cell-3 tab-bar-item">	
				<div class="row" @click="layOut(3)">
					<span>
            <img :src="this.aaa == 3?require('@/spAssets/tab3.png'):require('@/spAssets/tab3-1.png')" alt="" />
            <div v-bind:class="{active: actives[2]}">マスター管理</div>
          </span>
				</div>
			</div>
			<div class="cell-3 tab-bar-item">
				<div class="row" @click="layOut(4)">
					<span>
            <img :src="this.aaa == 4?require('@/spAssets/tab4.png'):require('@/spAssets/tab4-1.png')" alt="" />
            <div v-bind:class="{active: actives[3]}">個人情報</div>
          </span>
				</div>
			</div>
		</div>
  </div>
</template>
<style>
/* head头部 ul */
.spb0003head{
  background-color: #014099;
  width: 100%;
  height: 80px;
}
/* head头部 li */
.el-menu--horizontal > .el-menu-item{
  width:50%;
}
/* head头部 用户名+退出 */
.logout1{
  font-size: 24px;
  text-align: right;
  padding-right: 10%;
}
/* head头部 会社logo */
.imgAd {
  margin-top: 10px;
  margin-left: 10px;
  height: 60px;
}
.el-menu{
  height:100%;
}
.el-menu.el-menu--horizontal{
  border-bottom: solid 0px;
}
.el-menu--horizontal>.el-menu-item{
  height:100%;
  border-bottom: solid 0px;
}
.el-icon-switch-button{
  font-size: 48px !important;
  line-height:80px !important;
}
/* head头部 下面阴影 */
.headerLast{
  background-color: #bacce9;
  height: 10px;
}
/* ユーザー名 */
.colUser{
  /* margin-top: 10px;
  margin-left: 30px;
  height: 60px;
  color:#fff;
  font-size: center; */
}
/* logout */
.el-icon-switch-button{
  color:#fff;
}
/* 走马灯 */
.carousel{
  margin-top: 10px;
  margin-left: 12.5px;
  margin-right: 12.5px;
  margin-bottom: 30px;
  border-radius: 15px;
  border: 1px solid #000000;
  background-repeat: no-repeat;
  background-size: contain;
  background-position: center;
  height:350px;
}
/* 走马灯图片 */
.imgCenter{
  width:100%;
  height:100%;
}
/* 走马灯深层 */
.el-carousel__container{
  height:100%;
}
button.el-carousel__arrow.el-carousel__arrow--left, button.el-carousel__arrow.el-carousel__arrow--right {
  font-size: 48px;
  height: 64px;
  width: 64px;
  -webkit-tap-highlight-color:transparent;
}
/* 两个row */
.b0003row{
  margin-bottom: 15px;
  width:90%;
  margin-left: 5%!important;
}
.b0003Img{
  width:100%;
  height: 100%;
  padding-bottom: 0px !important;
  padding-top: 0px !important;
  padding-left: 0px !important;
  padding-right: 0px !important;
}
/* 八个col */
.grid-content {
  height: 100px;
  margin:auto;
  border-radius: 50%;
  border:1px solid #66b3b3;
}
.col1{
  text-align: center;
  margin-top: -10px;
}
/* 八个图片下面的字 */
.b0003ElButton{
  font-size: 20px !important;
  color: #435e8d;
  text-align: center;
  padding-bottom: 0px !important;
  padding-top: 0px !important;
  padding-left: 0px !important;
  padding-right: 0px !important;
  border-radius: 0px !important;
  margin-bottom: 5px;
}
/* 底部 */
.tab-bar {
  box-shadow: 0 -4px 16px -1px #aca9a9;
  color: #d0e0f7;
  background-color: white;
  border: 0 solid rgb(210, 210, 210);
  border-top-width: 0px;
  position: fixed;
  margin: auto;
  bottom: 0;
  width: 100%;
}
.tab-bar .cell-3 {
  display: inline-block;
  width: 24%;
  text-align: center;
  padding-top: 15px;
}
/* 底部 未点击时 */
.tab-bar div{
    font-size: 16px;
}
/* 底部 点击时 */
.tab-bar .active {
  color: #43568e;
  margin-bottom: 10px;
  font-size: 22px;
}
/* 底部 图片 */
.tab-bar img {
  height: 60px;
  margin:auto;
  padding-bottom: 5px;
  display: inline-block;
  font-weight: 700;
}
.el-carousel__button{
  width: 38px;
  height: 10px;
}
.el-carousel__indicators--horizontal{
  left: 20%;
}
</style>
<script>
import '@/css/reset.css';
import '@/css/border.css';
//移动端 解决点击按钮闪和active失效的问题
document.body.addEventListener('touchstart' , function(){});
export default {
  name: "sp_b0003",
  data() {
    return {
      // userNm:this.$route.query.datab0003.userTblBean.userName,
      aaa:1, 
      actives: [true, false, false, false],
      imgList:[
        {
            url:require('@/spAssets/spAd1.png')  
        },
        {
            url:require('@/spAssets/spAd2.png')
        },
        {
            url:require('@/spAssets/spAd3.png')
        },
        {
            url:require('@/spAssets/spAd4.png')
        },
        {
            url:require('@/spAssets/spAd5.png')
        },
      ],
      userDate: "",
    };
  },
  mounted() {
    document.title="会社メイン"
    this.getDate();
  },
  methods: {
    //画面初期処理
    getDate() {
      this.$store
        .dispatch("b0003Search")
        .then((response) => {
          let code = response.data.code;
          if (code == 200) {
            this.userDate = response.data.data.userTblBean.userName;
            // this.$router.push({
            //   path: "/c0003",
            //   query: { datac0003: response.data.data },
            // });
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
          // this.loading = false;
        });
    },
    // tab img
    layOut: function(qqq) {
      if (qqq == 1) {
        this.aaa = 1
        this.actives[0] = true;
        this.actives[1] = false;
        this.actives[2] = false;
        this.actives[3] = false;
      }else if(qqq == 2){
        this.aaa = 2
        this.actives[1] = true;
        this.actives[0] = false;
        this.actives[2] = false;
        this.actives[3] = false;
      }else if(qqq == 3){
        this.aaa = 3
        this.actives[2] = true;
        this.actives[1] = false;
        this.actives[0] = false;
        this.actives[3] = false;
      }else if(qqq == 4){
        this.aaa = 4
        this.actives[3] = true;
        this.actives[1] = false;
        this.actives[2] = false;
        this.actives[0] = false;
      }
    },
    logout() {
      localStorage.removeItem("Authorization");
      this.$router.push("/sp/sp_b0001");
    },
    comeAd(item) {
      if(item == "@/spAssets/banner.png"){
        this.$router.push("/sp/sp_b0001");
      }else if(item == "@/spAssets/pic1.png"){
        this.$router.push("/sp/sp_b0002");
      }else{
        this.$router.push("/sp/sp_b0002Confirm");
      }
    },
    toB0101() {
      this.$store.dispatch("b0101Init").then((response) => {
        this.$router.push({
          path: "/sp/sp_b0101",
          query: { data: response.data.data },
        });
      });
    },
    toB0201() {
        this.$store.dispatch("b0201Init").then((response) => {
        this.$router.push({
          path: "/sp/sp_b0201",
          query: { data: response.data.data },
        });
      });
    },
    toB0301() {
        this.$store.dispatch("b0301Init").then((response) => {
        this.$router.push({
          path: "/sp/sp_b0301",
          query: { data: response.data.data },
        });
      });
    },
    toB0401() {
        this.$router.push({
          path: "/sp/sp_b0401",
        });
    },
    toB0501() {
        this.$store.dispatch("b0501Init").then((response) => {
        this.$router.push({
          path: "/sp/sp_b0501",
          query: { data: response.data.data },
        });
      });
    },
    toB0601() {
        this.$store.dispatch("b0601Init").then((response) => {
        this.$router.push({
          path: "/sp/sp_b0601",
          query: { data: response.data.data },
        });
      });
    },
    toB0701() {
        this.$store.dispatch("b0701Init").then((response) => {
        this.$router.push({
          path: "/sp/sp_b0701",
          query: { data: response.data.data },
        });
      });
    },
    toB0801() {
        this.$store.dispatch("b0801Init").then((response) => {
        this.$router.push({
          path: "/sp/sp_b0801",
          query: { datab0801: response.data.data },
        });
      });
    },
  },
};
</script>
