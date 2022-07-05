<template>
  <div class="HomePage">
    <el-container>
      <el-header class="homeHeader">
        <div class="homeHeaderRoot">
          <el-menu
            :default-active="activeIndex2"
            class="el-menu-header"
            mode="horizontal"
            text-color="#2d8cf0"
          >
            <!-- <div>
              <el-button type="primary" @click="toGetdata" >
                商品一覧
              </el-button>
            </div> -->

            <div class="logoImg" @click="toA0001">
              <el-image :src="require('@/assets/b_home_logo2.png')" class="logoImg" />
            </div>
            <el-menu-item class="space"></el-menu-item>
            <el-menu-item>
              <em class="el-icon-s-custom"/>
              <el-link :underline="false" @click="toLogin">会社ログイン</el-link>
            </el-menu-item>
            <el-menu-item class="space1"></el-menu-item>
            <el-menu-item>
              <em class="el-icon-s-custom"/>
              <el-link :underline="false" @click="toC0001" >応募者ログイン</el-link>
            </el-menu-item>
          </el-menu>
        </div>
      </el-header>
      <div
        class="searchBackground"
      >
        <div class="searchInput">
          <el-input
            placeholder="職位または会社を入力してください"
            v-model="searchNm"
            class="searchInputInner"
          >
            <el-button class="buttonSelect" slot="append" icon="el-icon-search" @click="toPositionListBySearchNm"></el-button>
          </el-input>
        </div>
      </div>
      <el-form ref="loginForm" label-position="left" autocomplete="on">
        <el-main class="homeBody">
          <div class="block">
            <div class="bodyRoot">
              <el-row class="nav">
                <!-- 侧边导航 -->
                <div class="nav-side" ref="navSide">
                  <ul>
                    <li @mouseenter="showDetail(1)" @mouseleave="hideDetail(1)" class="nav-side-item">
                      <span v-show="false">1</span>
                      <span @click="toPositionListByIndustryId(1)">営業</span>
                      <span class="spanLeftStyle" v-show="seen1"> 〉 </span>
                    </li>
                    <li @mouseenter="showDetail(2)" @mouseleave="hideDetail(2)" class="nav-side-item">
                      <span v-show="false">2</span>
                      <span @click="toPositionListByIndustryId(2)" >事務</span>
                      <span class="spanLeftStyle" v-show="seen2"> 〉</span>
                    </li>
                    <li @mouseenter="showDetail(3)" @mouseleave="hideDetail(3)" class="nav-side-item">
                      <span v-show="false">3</span>
                      <span @click="toPositionListByIndustryId(3)">販売</span>
                      <span class="spanLeftStyle" v-show="seen3"> 〉 </span>
                    </li>
                    <li @mouseenter="showDetail(4)" @mouseleave="hideDetail(4)" class="nav-side-item">
                      <span v-show="false">4</span>
                      <span @click="toPositionListByIndustryId(4)">飲食</span>
                      <span class="spanLeftStyle" v-show="seen4"> 〉 </span>
                    </li>
                    <li @mouseenter="showDetail(5)" @mouseleave="hideDetail(5)" class="nav-side-item">
                      <span v-show="false">5</span>
                      <span @click="toPositionListByIndustryId(5)">サービス</span>
                      <span class="spanLeftStyle" v-show="seen5"> 〉 </span>
                    </li>
                    <li @mouseenter="showDetail(6)" @mouseleave="hideDetail(6)" class="nav-side-item">
                      <span v-show="false">6</span>
                      <span @click="toPositionListByIndustryId(6)">娯楽</span>
                      <span class="spanLeftStyle" v-show="seen6"> 〉 </span>
                    </li>
                    <li @mouseenter="showDetail(7)" @mouseleave="hideDetail(7)" class="nav-side-item">
                      <span v-show="false">7</span>
                      <span @click="toPositionListByIndustryId(7)">教育・文化</span>
                      <span class="spanLeftStyle" v-show="seen7"> 〉 </span>
                    </li>
                    <li @mouseenter="showDetail(8)" @mouseleave="hideDetail(8)" class="nav-side-item">
                      <span v-show="false">8</span>
                      <span @click="toPositionListByIndustryId(8)">理・美容</span>
                      <span class="spanLeftStyle" v-show="seen8"> 〉 </span>
                    </li>
                    <li @mouseenter="showDetail(9)" @mouseleave="hideDetail(9)" class="nav-side-item">
                      <span v-show="false">9</span>
                      <span @click="toPositionListByIndustryId(9)">医療・介護</span>
                      <span class="spanLeftStyle" v-show="seen9"> 〉 </span>
                    </li>
                    <li @mouseenter="showDetail(10)" @mouseleave="hideDetail(10)" class="nav-side-item">
                      <span v-show="false">10</span>
                      <span @click="toPositionListByIndustryId(10)">配達</span>
                      <span class="spanLeftStyle" v-show="seen10"> 〉 </span>
                    </li>
                    <li @mouseenter="showDetail(11)" @mouseleave="hideDetail(11)" class="nav-side-item">
                      <span v-show="false">11</span>
                      <span @click="toPositionListByIndustryId(11)">製造</span>
                      <span class="spanLeftStyle" v-show="seen11"> 〉 </span>
                    </li>
                    <li @mouseenter="showDetail(12)" @mouseleave="hideDetail(12)" class="nav-side-item">
                      <span v-show="false">12</span>
                      <span @click="toPositionListByIndustryId(12)">IT</span>
                      <span class="spanLeftStyle" v-show="seen12"> 〉 </span>
                    </li>
                    <li @mouseenter="showDetail(13)" @mouseleave="hideDetail(13)" class="nav-side-item">
                      <span v-show="false">13</span>
                      <span @click="toPositionListByIndustryId(13)">出版</span>
                      <span class="spanLeftStyle" v-show="seen13"> 〉 </span>
                    </li>
                    <li @mouseenter="showDetail(14)" @mouseleave="hideDetail(14)" class="nav-side-item">
                      <span v-show="false">14</span>
                      <span @click="toPositionListByIndustryId(14)">専門職</span>
                      <span class="spanLeftStyle" v-show="seen14"> 〉 </span>
                    </li>
                    <li @mouseenter="showDetail(15)" @mouseleave="hideDetail(15)" class="nav-side-item">
                      <span v-show="false">15</span>
                      <span @click="toPositionListByIndustryId(15)">土木・農水産</span>
                      <span class="spanLeftStyle" v-show="seen15"> 〉 </span>
                    </li>
                  </ul>
                </div>
                <transition name="fade">
                  <div class="detail-item-panel panel-1" :duration="{ enter: 100, leave: 100 }" v-show="panel1" 
                    @mouseenter="showDetail(1)" ref="itemPanel1" @mouseleave="hideDetail(1)">
                    <div class="navTitle">
                      <span>{{navTitle1}}</span>
                    </div>
                    <div class="navDetails">
                      <div v-for="(items, index) in panelData1.classNav" :key="index" class="detail-item-row">
                        <span v-show="false">{{items.jobtypeId}}</span>
                        <span @click="toPositionListByJobtypeId(items.jobtypeId)" class="detail-item">{{items.jobtypeNm}}</span>
                      </div>
                    </div>
                  </div>
                </transition>
                <transition name="fade">
                  <div class="detail-item-panel panel-1" :duration="{ enter: 100, leave: 100 }" v-show="panel2" 
                    @mouseenter="showDetail(2)" ref="itemPanel2" @mouseleave="hideDetail(2)">
                    <div class="navTitle">
                      <span>{{navTitle2}}</span>
                    </div>
                    <div class="navDetails">
                      <div v-for="(items, index) in panelData2.classNav" :key="index" class="detail-item-row">
                        <span v-show="false">{{items.jobtypeId}}</span>
                        <span @click="toPositionListByJobtypeId(items.jobtypeId)" class="detail-item">{{items.jobtypeNm}}</span>
                      </div>
                    </div>
                  </div>
                </transition>
                <transition name="fade">
                  <div class="detail-item-panel panel-1" :duration="{ enter: 100, leave: 100 }" v-show="panel3" 
                    @mouseenter="showDetail(3)" ref="itemPanel3" @mouseleave="hideDetail(3)">
                    <div class="navTitle">
                      <span>{{navTitle3}}</span>
                    </div>
                    <div class="navDetails">
                      <div v-for="(items, index) in panelData3.classNav" :key="index" class="detail-item-row">
                        <span v-show="false">{{items.jobtypeId}}</span>
                        <span @click="toPositionListByJobtypeId(items.jobtypeId)" class="detail-item">{{items.jobtypeNm}}</span>
                      </div>
                    </div>
                  </div>
                </transition>
                <transition name="fade">
                  <div class="detail-item-panel panel-1" :duration="{ enter: 100, leave: 100 }" v-show="panel4" 
                    @mouseenter="showDetail(4)" ref="itemPanel4" @mouseleave="hideDetail(4)">
                    <div class="navTitle">
                      <span>{{navTitle4}}</span>
                    </div>
                    <div class="navDetails">
                      <div v-for="(items, index) in panelData4.classNav" :key="index" class="detail-item-row">
                        <span v-show="false">{{items.jobtypeId}}</span>
                        <span @click="toPositionListByJobtypeId(items.jobtypeId)" class="detail-item">{{items.jobtypeNm}}</span>
                      </div>
                    </div>
                  </div>
                </transition>
                <transition name="fade">
                  <div class="detail-item-panel panel-1" :duration="{ enter: 100, leave: 100 }" v-show="panel5" 
                    @mouseenter="showDetail(5)" ref="itemPanel5" @mouseleave="hideDetail(5)">
                    <div class="navTitle">
                      <span>{{navTitle5}}</span>
                    </div>
                    <div class="navDetails">
                      <div v-for="(items, index) in panelData5.classNav" :key="index" class="detail-item-row">
                        <span v-show="false">{{items.jobtypeId}}</span>
                        <span @click="toPositionListByJobtypeId(items.jobtypeId)" class="detail-item">{{items.jobtypeNm}}</span>
                      </div>
                    </div>
                  </div>
                </transition>
                <transition name="fade">
                  <div class="detail-item-panel panel-1" :duration="{ enter: 100, leave: 100 }" v-show="panel6" 
                    @mouseenter="showDetail(6)" ref="itemPanel6" @mouseleave="hideDetail(6)">
                    <div class="navTitle">
                      <span>{{navTitle6}}</span>
                    </div>
                    <div class="navDetails">
                      <div v-for="(items, index) in panelData6.classNav" :key="index" class="detail-item-row">
                        <span v-show="false">{{items.jobtypeId}}</span>
                        <span @click="toPositionListByJobtypeId(items.jobtypeId)" class="detail-item">{{items.jobtypeNm}}</span>
                      </div>
                    </div>
                  </div>
                </transition>
                <transition name="fade">
                  <div class="detail-item-panel panel-1" :duration="{ enter: 100, leave: 100 }" v-show="panel7" 
                    @mouseenter="showDetail(7)" ref="itemPanel7" @mouseleave="hideDetail(7)">
                    <div class="navTitle">
                      <span>{{navTitle7}}</span>
                    </div>
                    <div class="navDetails">
                      <div v-for="(items, index) in panelData7.classNav" :key="index" class="detail-item-row">
                          <span v-show="false">{{items.jobtypeId}}</span>
                          <span @click="toPositionListByJobtypeId(items.jobtypeId)" class="detail-item">{{items.jobtypeNm}}</span>
                      </div>
                    </div>
                  </div>
                </transition>
                <transition name="fade">
                  <div class="detail-item-panel panel-1" :duration="{ enter: 100, leave: 100 }" v-show="panel8" 
                    @mouseenter="showDetail(8)" ref="itemPanel8" @mouseleave="hideDetail(8)">
                    <div class="navTitle">
                      <span>{{navTitle8}}</span>
                    </div>
                    <div class="navDetails">
                      <div v-for="(items, index) in panelData8.classNav" :key="index" class="detail-item-row">
                        <span v-show="false">{{items.jobtypeId}}</span>
                        <span @click="toPositionListByJobtypeId(items.jobtypeId)" class="detail-item">{{items.jobtypeNm}}</span>
                      </div>
                    </div>
                  </div>
                </transition>
                <transition name="fade">
                  <div class="detail-item-panel panel-1" :duration="{ enter: 100, leave: 100 }" v-show="panel9" 
                    @mouseenter="showDetail(9)" ref="itemPanel9" @mouseleave="hideDetail(9)">
                    <div class="navTitle">
                      <span>{{navTitle9}}</span>
                    </div>
                    <div class="navDetails">
                      <div v-for="(items, index) in panelData9.classNav" :key="index" class="detail-item-row">
                        <span v-show="false">{{items.jobtypeId}}</span>
                        <span @click="toPositionListByJobtypeId(items.jobtypeId)" class="detail-item">{{items.jobtypeNm}}</span>
                      </div>
                    </div>
                  </div>
                </transition>
                <transition name="fade">
                  <div class="detail-item-panel panel-1" :duration="{ enter: 100, leave: 100 }" v-show="panel10" 
                    @mouseenter="showDetail(10)" ref="itemPanel10" @mouseleave="hideDetail(10)">
                    <div class="navTitle">
                      <span>{{navTitle10}}</span>
                    </div>
                    <div class="navDetails">
                      <div v-for="(items, index) in panelData10.classNav" :key="index" class="detail-item-row">
                        <span v-show="false">{{items.jobtypeId}}</span>
                        <span @click="toPositionListByJobtypeId(items.jobtypeId)" class="detail-item">{{items.jobtypeNm}}</span>
                      </div>
                    </div>
                  </div>
                </transition>
                <transition name="fade">
                  <div class="detail-item-panel panel-1" :duration="{ enter: 100, leave: 100 }" v-show="panel11" 
                    @mouseenter="showDetail(11)" ref="itemPanel11" @mouseleave="hideDetail(11)">
                    <div class="navTitle">
                      <span>{{navTitle11}}</span>
                    </div>
                    <div class="navDetails">
                      <div v-for="(items, index) in panelData11.classNav" :key="index" class="detail-item-row">
                        <span v-show="false">{{items.jobtypeId}}</span>
                        <span @click="toPositionListByJobtypeId(items.jobtypeId)" class="detail-item">{{items.jobtypeNm}}</span>
                      </div>
                    </div>
                  </div>
                </transition>
                <transition name="fade">
                  <div class="detail-item-panel panel-1" :duration="{ enter: 100, leave: 100 }" v-show="panel12" 
                    @mouseenter="showDetail(12)" ref="itemPanel12" @mouseleave="hideDetail(12)">
                    <div class="navTitle">
                      <span>{{navTitle12}}</span>
                    </div>
                    <div class="navDetails">
                      <div v-for="(items, index) in panelData12.classNav" :key="index" class="detail-item-row">
                        <span v-show="false">{{items.jobtypeId}}</span>
                        <span @click="toPositionListByJobtypeId(items.jobtypeId)" class="detail-item">{{items.jobtypeNm}}</span>
                      </div>
                    </div>
                  </div>
                </transition>
                <transition name="fade">
                  <div class="detail-item-panel panel-1" :duration="{ enter: 100, leave: 100 }" v-show="panel13" 
                    @mouseenter="showDetail(13)" ref="itemPanel13" @mouseleave="hideDetail(13)">
                    <div class="navTitle">
                      <span>{{navTitle13}}</span>
                    </div>
                    <div class="navDetails">
                      <div v-for="(items, index) in panelData13.classNav" :key="index" class="detail-item-row">
                        <span v-show="false">{{items.jobtypeId}}</span>
                        <span @click="toPositionListByJobtypeId(items.jobtypeId)" class="detail-item">{{items.jobtypeNm}}</span>
                      </div>
                    </div>
                  </div>
                </transition>
                <transition name="fade">
                  <div class="detail-item-panel panel-1" :duration="{ enter: 100, leave: 100 }" v-show="panel14" 
                    @mouseenter="showDetail(14)" ref="itemPanel14" @mouseleave="hideDetail(14)">
                    <div class="navTitle">
                      <span>{{navTitle14}}</span>
                    </div>
                    <div class="navDetails">
                      <div v-for="(items, index) in panelData14.classNav" :key="index" class="detail-item-row">
                        <span v-show="false">{{items.jobtypeId}}</span>
                        <span @click="toPositionListByJobtypeId(items.jobtypeId)" class="detail-item">{{items.jobtypeNm}}</span>
                      </div>
                    </div>
                  </div>
                </transition>
                <transition name="fade">
                  <div class="detail-item-panel panel-1" :duration="{ enter: 100, leave: 100 }" v-show="panel15" 
                    @mouseenter="showDetail(15)" ref="itemPanel15" @mouseleave="hideDetail(15)">
                    <div class="navTitle">
                      <span>{{navTitle15}}</span>
                    </div>
                    <div class="navDetails">
                      <div v-for="(items, index) in panelData15.classNav" :key="index" class="detail-item-row">
                        <span v-show="false">{{items.jobtypeId}}</span>
                        <span @click="toPositionListByJobtypeId(items.jobtypeId)" class="detail-item">{{items.jobtypeNm}}</span>
                      </div>
                    </div>
                  </div>
                </transition>
                <!-- 広告 -->
                <el-carousel class="carousel">
                  <el-carousel-item v-for="(img, item) in this.adList1" :key="item">
                    <el-image :src="img.photo" :fit="fit" class="imgCenter" @click="toLink(img.link)" :title="img.content"/>
                  </el-carousel-item>
                </el-carousel>
              </el-row>
              <el-row class="adRow1">
                <el-col :span="8">
                  <el-carousel trigger="click" class="ad1">
                    <el-carousel-item v-for="(img, item) in this.adList2" :key="item" class="ad1Img">
                      <el-image :src="img.photo" :fit="fit" class="imgCenter" @click="toLink(img.link)" :title="img.content"/>
                    </el-carousel-item>
                  </el-carousel>
                </el-col>
                <el-col :span="1" style="height:200px"></el-col>
                <el-col :span="15" v-for="(img, item) in this.adList3" :key="item">
                  <el-card class="ad ad2" style="margin-bottom:5px">
                    <el-image :src="img.photo" :fit="fit" class="imgCenter" @click="toLink(img.link)" :title="img.content"/>
                  </el-card>
                </el-col>
              </el-row>
              <el-row class="adRow adRow2" v-for="(img, item) in this.adList4" :key="item">
                <el-col :span="24">
                  <el-card class="ad ad5">
                    <el-image :src="img.photo" :fit="fit" class="imgCenter" @click="toLink(img.link)" :title="img.content"/>
                  </el-card>
                </el-col>
              </el-row>
              <el-row :gutter="20" class="adRow adRow8">
                <el-col :span="8" v-for="(img, item) in this.adList5" :key="item">
                  <el-card class="ad ad2" style="margin-bottom:5px;margin-top:15px">
                    <el-image :src="img.photo" :fit="fit" class="imgCenter" @click="toLink(img.link)" :title="img.content"/>
                  </el-card>
                </el-col>
              </el-row>
              <el-row :gutter="20" class="cpyRow1">
                <el-col :span="4" v-for="(img, item) in this.adList6" :key="item">
                  <el-card class="cpy cpy1" style="margin-bottom:5px">
                    <el-image :src="img.photo" :fit="fit" class="imgCenter" @click="toLink(img.link)" :title="img.content"/>
                  </el-card>
                </el-col>
              </el-row>
            </div>
          </div>
        </el-main>
      </el-form>
      <el-footer>
        <div class="footer">
          <HomeFooter />
        </div>
      </el-footer>
    </el-container>
    <el-backtop></el-backtop>
  </div>
</template>


<script lang="" scoped>
import HomeFooter from "./components/HomeFooter";
import '@/css/reset.css';
import '@/css/border.css';

export default {
  name: "HomePage",
  components: {
    HomeFooter,
  },
  mounted() {
    // ページタイトルの切替
    document.title = this.titleName;
    this.getData();
    // ページジャンプ動作の監視を開始します
    window.addEventListener("popstate", this.goBack, false);
    this.$refs.itemPanel1.style.left =
      this.$refs.navSide.offsetLeft + this.$refs.navSide.offsetWidth + 'px';
    this.$refs.itemPanel2.style.left =
      this.$refs.navSide.offsetLeft + this.$refs.navSide.offsetWidth + 'px';
    this.$refs.itemPanel3.style.left =
      this.$refs.navSide.offsetLeft + this.$refs.navSide.offsetWidth + 'px';
    this.$refs.itemPanel4.style.left =
      this.$refs.navSide.offsetLeft + this.$refs.navSide.offsetWidth + 'px';
    this.$refs.itemPanel5.style.left =
      this.$refs.navSide.offsetLeft + this.$refs.navSide.offsetWidth + 'px';
    this.$refs.itemPanel6.style.left =
      this.$refs.navSide.offsetLeft + this.$refs.navSide.offsetWidth + 'px';
    this.$refs.itemPanel7.style.left =
      this.$refs.navSide.offsetLeft + this.$refs.navSide.offsetWidth + 'px';
    this.$refs.itemPanel8.style.left =
      this.$refs.navSide.offsetLeft + this.$refs.navSide.offsetWidth + 'px';
    this.$refs.itemPanel9.style.left =
      this.$refs.navSide.offsetLeft + this.$refs.navSide.offsetWidth + 'px';
    this.$refs.itemPanel10.style.left =
      this.$refs.navSide.offsetLeft + this.$refs.navSide.offsetWidth + 'px';
    this.$refs.itemPanel11.style.left =
      this.$refs.navSide.offsetLeft + this.$refs.navSide.offsetWidth + 'px';
    this.$refs.itemPanel12.style.left =
      this.$refs.navSide.offsetLeft + this.$refs.navSide.offsetWidth + 'px';
    this.$refs.itemPanel13.style.left =
      this.$refs.navSide.offsetLeft + this.$refs.navSide.offsetWidth + 'px';
    this.$refs.itemPanel14.style.left =
      this.$refs.navSide.offsetLeft + this.$refs.navSide.offsetWidth + 'px';
    this.$refs.itemPanel15.style.left =
      this.$refs.navSide.offsetLeft + this.$refs.navSide.offsetWidth + 'px';
    this.$refs.itemPanel1.style.top = this.$refs.navSide.offsetTop + 'px';
    this.$refs.itemPanel2.style.top = this.$refs.navSide.offsetTop + 'px';
    this.$refs.itemPanel3.style.top = this.$refs.navSide.offsetTop + 'px';
    this.$refs.itemPanel4.style.top = this.$refs.navSide.offsetTop + 'px';
    this.$refs.itemPanel5.style.top = this.$refs.navSide.offsetTop + 'px';
    this.$refs.itemPanel6.style.top = this.$refs.navSide.offsetTop + 'px';
    this.$refs.itemPanel7.style.top = this.$refs.navSide.offsetTop + 'px';
    this.$refs.itemPanel8.style.top = this.$refs.navSide.offsetTop + 'px';
    this.$refs.itemPanel9.style.top = this.$refs.navSide.offsetTop + 'px';
    this.$refs.itemPanel10.style.top = this.$refs.navSide.offsetTop + 'px';
    this.$refs.itemPanel11.style.top = this.$refs.navSide.offsetTop + 'px';
    this.$refs.itemPanel12.style.top = this.$refs.navSide.offsetTop + 'px';
    this.$refs.itemPanel13.style.top = this.$refs.navSide.offsetTop + 'px';
    this.$refs.itemPanel14.style.top = this.$refs.navSide.offsetTop + 'px';
    this.$refs.itemPanel15.style.top = this.$refs.navSide.offsetTop + 'px';
  },
  updated () {
    this.$refs.itemPanel1.style.left =
      this.$refs.navSide.offsetLeft + this.$refs.navSide.offsetWidth + 'px';
    this.$refs.itemPanel2.style.left =
      this.$refs.navSide.offsetLeft + this.$refs.navSide.offsetWidth + 'px';
    this.$refs.itemPanel3.style.left =
      this.$refs.navSide.offsetLeft + this.$refs.navSide.offsetWidth + 'px';
    this.$refs.itemPanel4.style.left =
      this.$refs.navSide.offsetLeft + this.$refs.navSide.offsetWidth + 'px';
    this.$refs.itemPanel5.style.left =
      this.$refs.navSide.offsetLeft + this.$refs.navSide.offsetWidth + 'px';
    this.$refs.itemPanel6.style.left =
      this.$refs.navSide.offsetLeft + this.$refs.navSide.offsetWidth + 'px';
    this.$refs.itemPanel7.style.left =
      this.$refs.navSide.offsetLeft + this.$refs.navSide.offsetWidth + 'px';
    this.$refs.itemPanel8.style.left =
      this.$refs.navSide.offsetLeft + this.$refs.navSide.offsetWidth + 'px';
    this.$refs.itemPanel9.style.left =
      this.$refs.navSide.offsetLeft + this.$refs.navSide.offsetWidth + 'px';
    this.$refs.itemPanel10.style.left =
      this.$refs.navSide.offsetLeft + this.$refs.navSide.offsetWidth + 'px';
    this.$refs.itemPanel11.style.left =
      this.$refs.navSide.offsetLeft + this.$refs.navSide.offsetWidth + 'px';
    this.$refs.itemPanel12.style.left =
      this.$refs.navSide.offsetLeft + this.$refs.navSide.offsetWidth + 'px';
    this.$refs.itemPanel13.style.left =
      this.$refs.navSide.offsetLeft + this.$refs.navSide.offsetWidth + 'px';
    this.$refs.itemPanel14.style.left =
      this.$refs.navSide.offsetLeft + this.$refs.navSide.offsetWidth + 'px';
    this.$refs.itemPanel15.style.left =
      this.$refs.navSide.offsetLeft + this.$refs.navSide.offsetWidth + 'px';
    this.$refs.itemPanel1.style.top = this.$refs.navSide.offsetTop + 'px';
    this.$refs.itemPanel2.style.top = this.$refs.navSide.offsetTop + 'px';
    this.$refs.itemPanel3.style.top = this.$refs.navSide.offsetTop + 'px';
    this.$refs.itemPanel4.style.top = this.$refs.navSide.offsetTop + 'px';
    this.$refs.itemPanel5.style.top = this.$refs.navSide.offsetTop + 'px';
    this.$refs.itemPanel6.style.top = this.$refs.navSide.offsetTop + 'px';
    this.$refs.itemPanel7.style.top = this.$refs.navSide.offsetTop + 'px';
    this.$refs.itemPanel8.style.top = this.$refs.navSide.offsetTop + 'px';
    this.$refs.itemPanel9.style.top = this.$refs.navSide.offsetTop + 'px';
    this.$refs.itemPanel10.style.top = this.$refs.navSide.offsetTop + 'px';
    this.$refs.itemPanel11.style.top = this.$refs.navSide.offsetTop + 'px';
    this.$refs.itemPanel12.style.top = this.$refs.navSide.offsetTop + 'px';
    this.$refs.itemPanel13.style.top = this.$refs.navSide.offsetTop + 'px';
    this.$refs.itemPanel14.style.top = this.$refs.navSide.offsetTop + 'px';
    this.$refs.itemPanel15.style.top = this.$refs.navSide.offsetTop + 'px';
  },
  data() {
    return {
      // タイトル名
      titleName: "BeeWork-求人サイト",
      searchNm: "",
      // 画面初期化用データ
      initData: {
        jobtypeList: [],
        adList: [],
      },
      positionInfo: [],
      user: {
        username: "お客さま",
      },
      activeIndex: "1",
      activeIndex2: "1",
      isCollapse: true,
      seen1: true,
      seen2: true,
      seen3: true,
      seen4: true,
      seen5: true,
      seen6: true,
      seen7: true,
      seen8: true,
      seen9: true,
      seen10: true,
      seen11: true,
      seen12: true,
      seen13: true,
      seen14: true,
      seen15: true,
      fit:"fit",
      picurl:"",
      adList: [],
      adList1: [],
      adList2: [],
      adList3: [],
      adList4: [],
      adList5: [],
      adList6: [],
      drawer: false,
      innerDrawer: false,
      panel1: false,
      panel2: false,
      panel3: false,
      panel4: false,
      panel5: false,
      panel6: false,
      panel7: false,
      panel8: false,
      panel9: false,
      panel10: false,
      panel11: false,
      panel12: false,
      panel13: false,
      panel14: false,
      panel15: false,
      navTitle1: "営業",
      panelData1: {
        classNav: [],
      },
      navTitle2: "事務",
      panelData2: {
        classNav: [],
      },
      navTitle3: "販売",
      panelData3: {
        classNav: [],
      },
      navTitle4: "飲食",
      panelData4: {
        classNav: [],
      },
      navTitle5: "サービス",
      panelData5: {
        classNav: [],
      },
      navTitle6: "娯楽",
      panelData6: {
        classNav: [],
      },
      navTitle7: "教育・文化",
      panelData7: {
        classNav: [],
      },
      navTitle8: "理・美容",
      panelData8: {
        classNav: [],
      },
      navTitle9: "医療・介護",
      panelData9: {
        classNav: [],
      },
      navTitle10: "配達",
      panelData10: {
        classNav: [],
      },
      navTitle11: "製造",
      panelData11: {
        classNav: [],
      },
      navTitle12: "IT",
      panelData12: {
        classNav: [],
      },
      navTitle13: "出版",
      panelData13: {
        classNav: [],
      },
      navTitle14: "専門職",
      panelData14: {
        classNav: [],
      },
      navTitle15: "土木・農水産", 
      panelData15: {
        classNav: [],
      },
    };
  },
  methods: {
    // テーブルデータ取得
    getData() {
      this.$store.dispatch("homeinit").then((response) => {
        this.$router.push({
          query: { data: response.data.data },
        });
        this.initData = response.data.data;
        this.adList = response.data.data.adList;
        for (let i = 0; i < this.adList.length; i++) {
          this.adList[i].photo = "data:image/jpeg;base64," + this.adList[i].photoAddress;
          if(this.adList[i].layoutId == 1){
            if(this.adList1.length < 5){
            this.adList1.push(this.adList[i]);
            }
          } else if (this.adList[i].layoutId == 2) {
            if(this.adList2.length < 4){
              this.adList2.push(this.adList[i]);
            }
          } else if (this.adList[i].layoutId == 3) {
            if(this.adList3.length < 3){
              this.adList3.push(this.adList[i]);
            }
          } else if (this.adList[i].layoutId == 4) {
            this.adList4.push(this.adList[i]);
          } else if (this.adList[i].layoutId == 5) {
            this.adList5.push(this.adList[i]);
          } else {
            this.adList6.push(this.adList[i]);
          }
        }
        for (let i = 0; i < this.initData.jobtypeList.length; i++) {
          if (this.initData.jobtypeList[i].industryId == 1) {
            this.panelData1.classNav.push(this.initData.jobtypeList[i]);
          } else if (this.initData.jobtypeList[i].industryId == 2) {
            this.panelData2.classNav.push(this.initData.jobtypeList[i]);
          } else if (this.initData.jobtypeList[i].industryId == 3) {
            this.panelData3.classNav.push(this.initData.jobtypeList[i]);
          } else if (this.initData.jobtypeList[i].industryId == 4) {
            this.panelData4.classNav.push(this.initData.jobtypeList[i]);
          } else if (this.initData.jobtypeList[i].industryId == 5) {
            this.panelData5.classNav.push(this.initData.jobtypeList[i]);
          } else if (this.initData.jobtypeList[i].industryId == 6) {
            this.panelData6.classNav.push(this.initData.jobtypeList[i]);
          } else if (this.initData.jobtypeList[i].industryId == 7) {
            this.panelData7.classNav.push(this.initData.jobtypeList[i]);
          } else if (this.initData.jobtypeList[i].industryId == 8) {
            this.panelData8.classNav.push(this.initData.jobtypeList[i]);
          } else if (this.initData.jobtypeList[i].industryId == 9) {
            this.panelData9.classNav.push(this.initData.jobtypeList[i]);
          } else if (this.initData.jobtypeList[i].industryId == 10) {
            this.panelData10.classNav.push(this.initData.jobtypeList[i]);
          } else if (this.initData.jobtypeList[i].industryId == 11) {
            this.panelData11.classNav.push(this.initData.jobtypeList[i]);
          } else if (this.initData.jobtypeList[i].industryId == 12) {
            this.panelData12.classNav.push(this.initData.jobtypeList[i]);
          } else if (this.initData.jobtypeList[i].industryId == 13) {
            this.panelData13.classNav.push(this.initData.jobtypeList[i]);
          } else if (this.initData.jobtypeList[i].industryId == 14) {
            this.panelData14.classNav.push(this.initData.jobtypeList[i]);
          } else  {
            this.panelData15.classNav.push(this.initData.jobtypeList[i]);
          }
        }
      })
    },
    toLogin() {
      let routeUrl = this.$router.resolve({
        path: "/login",
        query: {}
      });
      window.open(routeUrl.href, '_blank');
},
    toC0001() {
      let routeUrl = this.$router.resolve({
        path: "/c0001",
        query: {}
      });
      window.open(routeUrl.href, '_blank');
    },
    toA0001() {
      let routeUrl = this.$router.resolve({
        path: "/a0001",
        query: {}
      });
      window.open(routeUrl.href, '_blank');
    },
    toGetdata() {
      let routeUrl = this.$router.resolve({
        path: "/getdata",
        query: {}
      });
      window.open(routeUrl.href, '_blank');
    },
    toPositionListByIndustryId(index) {
      let routeUrl = this.$router.resolve({
        path: "/positionListFromHome",
        query: {industryId: index}
      });
      window.open(routeUrl.href, "/positionListFromHome");
    },
      toPositionListByJobtypeId(index) {
      let routeUrl = this.$router.resolve({
        path: "/positionListFromHome",
        query: {jobtypeId: index}
      });
      window.open(routeUrl.href, "/positionListFromHome");
    },
    toPositionListBySearchNm() {
      let routeUrl = this.$router.resolve({
        path: "/positionListFromHome",
        query: {searchNm: this.searchNm}
      });
      window.open(routeUrl.href, "/positionListFromHome");
    },
    toLink(url) {
      window.open(url);
    },
    showDetail (index) {
      switch(index){
        case 1:
          this.panel1 = true;
          this.seen1 = false;
          break;
        case 2:
          this.panel2 = true;
          this.seen2 = false;
          break;
        case 3:
          this.panel3 = true;
          this.seen3 = false;
          break;
        case 4:
          this.panel4 = true;
          this.seen4 = false;
          break;
        case 5:
          this.panel5 = true;
          this.seen5 = false;
          break;
        case 6:
          this.panel6 = true;
          this.seen6 = false;
          break;
        case 7:
          this.panel7 = true;
          this.seen7 = false;
          break;
        case 8:
          this.panel8 = true;
          this.seen8 = false;
          break;
        case 9:
          this.panel9 = true;
          this.seen9 = false;
          break;
        case 10:
          this.panel10 = true;
          this.seen10 = false;
          break;
        case 11:
          this.panel11 = true;
          this.seen11 = false;
          break;
        case 12:
          this.panel12 = true;
          this.seen12 = false;
          break;
        case 13:
          this.panel13 = true;
          this.seen13 = false;
          break;
        case 14:
          this.panel14 = true;
          this.seen14 = false;
          break;
        case 15:
          this.panel15 = true;
          this.seen15 = false;
          break;
        default:
          break;
      }
    },
    hideDetail (index) {
      switch(index){
        case 1:
          this.panel1 = false;
          this.seen1 = true;
          break;
        case 2:
          this.panel2 = false;
          this.seen2 = true;
          break;
        case 3:
          this.panel3 = false;
          this.seen3 = true;
          break;
        case 4:
          this.panel4 = false;
          this.seen4 = true;
          break;
        case 5:
          this.panel5 = false;
          this.seen5 = true;
          break;
        case 6:
          this.panel6 = false;
          this.seen6 = true;
          break;
        case 7:
          this.panel7 = false;
          this.seen7 = true;
          break;
        case 8:
          this.panel8 = false;
          this.seen8 = true;
          break;
        case 9:
          this.panel9 = false;
          this.seen9 = true;
          break;
        case 10:
          this.panel10 = false;
          this.seen10 = true;
          break;
        case 11:
          this.panel11 = false;
          this.seen11 = true;
          break;
        case 12:
          this.panel12 = false;
          this.seen12 = true;
          break;
        case 13:
          this.panel13 = false;
          this.seen13 = true;
          break;
        case 14:
          this.panel14 = false;
          this.seen14 = true;
          break;
        case 15:
          this.panel15 = false;
          this.seen15 = true;
          break;
        default:
          break;
      }
    },
  },
};
</script>

<style>
.HomePage {
  min-width: 1200px;
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
  background-color:#FFFFFF;
  box-shadow: 0px 20px 20px -20px #dbdbdb;
}
.el-menu-header {
  padding: 0 11%;
}
.logoImg {
  display: inline;
  float: left;
  outline:none;
  cursor:pointer;
  line-height: 50px;
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
  background-position: center;
}
.searchInput {
  padding: 25px 11%;
  z-index: 1;
}
.searchInputInner .el-input__inner {
  font-size: 18px;
  height: 60px !important;
}
.homeBody {
  padding-top: 10px;
  background-color: rgb(240, 240, 240);
}
.block {
  color: #1d2125;
  width: 100%;
}
.bodyRoot {
  width: 80%;
  margin: auto;
  padding-top: 20px;
}
.nav {
  height: 510px;;
}
.nav-side {
  width: 20%;
  height: 100%;
  padding: 5px 0px;
  color: #020202;
  float: left;
  background-color: #ffffff;
}
.nav-side ul {
  width: 100%;
  padding: 0px;
  list-style: none;
}
.nav-side li {
  padding: 7.5px;
  padding-left: 20px;
  font-size: 16px;
  line-height: 18px;
}
.nav-side li:hover {
  border-top: solid 1px rgb(155, 155, 155);
  border-bottom: solid 1px rgb(155, 155, 155);
}
.nav-side-item:hover {
  cursor: pointer;
  color: #008cff;
}
/*显示商品详细信息*/
.detail-item-panel {
  width: 80%;
  height: 100%;
  padding: 10px 20px;
  background-color: #fff;
  position: absolute;
  color: #589de7;
  top: 168px;
  left: 389px;
  border: solid 1px rgb(238, 237, 237);
  z-index: 99;
}
.nav-detail-item {
  margin-left: 26px;
  margin-top: 15px;
  margin-bottom: 15px;
  cursor: pointer;
  color: #eee;
}
.nav-detail-item span {
  padding: 6px;
  padding-left: 12px;
  margin-left: 15px;
  font-size: 12px;
  background-color: #6e6568;
}
.nav-detail-item span:hover {
  margin-left: 15px;
  background-color: #919191;
}
.navTitle {
  font-size: 20px;
  font-weight: bold;
  color: #000000;
  border-bottom: #afafaf 1px solid;
}
.navDetails {
  padding: 0px 50px;
  margin-top: 25px;
  display: flex;
  flex-wrap: wrap;
}
.detail-item-row {
  width: 50%;
  height: 35px;
}
.detail-item-title:hover {
  color: #3106f5;
}
.detail-item-row a {
  color: #555555;
}
.detail-item{
  font-size: 16px;
  padding-left: 12px;
  padding-right: 8px;
  cursor: pointer;
  color: #474747;
}
.detail-item:hover {
  color: #008cff;
}
a {
  text-decoration: none;
}
.carousel {
  width: 78%;
  height: 100%;
  overflow: hidden;
  float: right;
  background-repeat: no-repeat;
  background-size: contain;
  background-position: center;
  z-index: 1;
}
.carousel .el-carousel__container {
  cursor : pointer;
  height: 100%;
}
.imgCenter {
  width: 100%;
  height: 100%;
}
.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n + 1) {
  background-color: #d3dce6;
}
.el-menu-vertical-demo:not(.el-menu--collapse) {
  width: 200px;
  min-height: 400px;
}
.navigationTitle {
  padding: 0px !important;
  width: 200px;
}
.el-menu-vertical-demo {
  margin-top: 50px !important;
  width: 200px !important;
}
.navigationTitle1 {
  font-size: 20px;
  font-style: normal;
}
.cpyRow1 {
  margin-top: 30px;
}
.cpyRow2 {
  margin-top: 10px;
}
.cpy {
  cursor : pointer;
  height: 10em;
  width: 100%;
}
.cpy .el-card__body {
  padding: 0em;
}
.adRow1 {
  margin-top: 30px;
}
.ad1 {
  height: 206px;
  width: 392px;
}
.ad1 .el-carousel__container {
  height: 206px;
}
.ad_Row1 {
  margin-top: 7px;
}
.adRow {
  margin-top: 7px;
}
.ad .el-card__body {
  padding: 0em;
}
.ad {
  cursor : pointer;
  height: 64px;
  width: 100%;
}
.spanLeftStyle{
  float: right;
  color: #9c9c9c;
}
.el-input-group__append, .el-input-group__prepend{
  background-color: #0099ff;
  color:#ffffff;
  border: 1px solid #0099ff;
}
.el-input-group__append button.el-button{
  height: 54px !important;
}
.buttonSelect{
  width:80px;
}
</style>

