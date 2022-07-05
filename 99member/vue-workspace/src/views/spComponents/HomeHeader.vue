<template>
  <div>
    <div class="header">
      <el-menu
        :default-active="activeIndex2"
        class="el-menu-demo"
        mode="horizontal"
        @select="handleSelect"
        background-color="#014099"
        text-color="#fff"
        active-text-color="#ffd04b"
      >
        <el-menu-item style="width: 20vw">
          <div>
            <el-image
              :src="require('@/assets/b_home_logo2.png')"
              class="logoImg"
            />
          </div>
        </el-menu-item>
        <el-menu-item @click="toHome" index="1" style="width: 5vw">
          HOME
        </el-menu-item>
        <el-submenu index="2" style="width: 6vw">
          <template class="positionTem" slot="title" style="">職位</template>
          <el-menu-item index="2-1" class="headerSelect">新規</el-menu-item>
          <el-menu-item index="2-2" class="headerSelect">職位一覧</el-menu-item>
        </el-submenu>
        <el-menu-item index="3" style="width: 6vw">応募者</el-menu-item>
        <el-menu-item index="4" class="headerSelect" style="width: 5vw"
          >求人</el-menu-item
        >
        <el-menu-item
          index="5"
          class="headerSelect"
          @click="toB0401"
          style="width: 5vw"
          >面接</el-menu-item
        >
        <el-submenu index="6" style="width: 6vw">
          <template slot="title">研修</template>
          <el-menu-item
            index="6-1"
            @click="toB0502Registered"
            class="headerSelect"
            >新規</el-menu-item
          >
          <el-menu-item index="6-2" @click="toB0501" class="headerSelect"
            >研修一覧</el-menu-item
          >
        </el-submenu>
        <el-submenu index="7" style="width: 7vw">
          <template slot="title">説明会</template>
          <el-menu-item index="7-1" class="headerSelect">新規</el-menu-item>
          <el-menu-item index="7-2" class="headerSelect"
            >説明会一覧</el-menu-item
          >
        </el-submenu>
        <el-submenu index="8" style="width: 9vw">
          <template slot="title">基本情報</template>
          <el-menu-item index="8-1" class="headerSelect">基本情報</el-menu-item>
          <el-menu-item index="8-2" class="headerSelect">個人情報</el-menu-item>
        </el-submenu>
        <el-submenu index="9" style="width: 9vw">
          <template slot="title">資産管理</template>
          <el-menu-item index="9-1" class="headerSelect"
            >クーポン取得</el-menu-item
          >
          <el-menu-item index="9-2" class="headerSelect"
            >資産情報一覧</el-menu-item
          >
        </el-submenu>
        <el-menu-item style="width: 12vw">
          <el-divider direction="vertical" />
          <em class="el-icon-user"></em>
          <span>{{ user.username }}</span>
        </el-menu-item>
        <el-menu-item style="width: 10vw">
          <el-link @click="logout">
            <em class="el-icon-switch-button"></em>ログアウト</el-link
          >
        </el-menu-item>
      </el-menu>
    </div>
    <div style="height: 47px"></div>
    <div class="line"></div>
  </div>
</template>
<script>
export default {
  name: "homeHeader",
  data() {
    return {
      user: {
        username: "お客さま",
      },
      activeIndex: "1",
      activeIndex2: "1",
    };
  },
  created() {
    this.getUserName();
  },
  methods: {
    getUserName() {
      this.$store.dispatch("getUserName").then((response) => {
        this.$router.push({
          query: { data: response.data.data },
        });
        console.log("response", this.response);
      });
    },
    toHome() {
      console.log("Go to the homepage.");
      this.$router.push({ path: "/b0003" });
    },
    toB0501() {
      console.log("Go to the b0501 page.");
      this.$store.dispatch("b0501Init").then((response) => {
        this.$router.push({
          path: "/b0501",
          query: { data: response.data.data },
        });
      });
    },
    toB0502Registered() {
      console.log("Go to the b0502Registered page.");
      this.$router.push({ path: "/b0502Registered" });
    },
    handleSelect(key, keyPath) {
      console.log(key, keyPath);
    },
    logout() {
      localStorage.removeItem("Authorization");
      this.$router.push("/login");
    },
    toB0401() {
      console.log("Go to the b0401 page.");
      this.$router.push({
        path: "/b0401",
      });
    },
  },
};
</script>
<style lang="scss" scoped>
.header {
  position: absolute;
  height: 50px;
  top: 0px;
  left: 0px;
  bottom: 0px;
  width: 100%;
  border: 0px;
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
}
.headerSelect {
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
  width: 5vw;
}
.line {
  background-color: #bacce9;
  height: 5px;
  top: 60px;
  left: 0px;
  bottom: 0px;
  width: 100%;
}
.el-menu-demo {
  width: 100vw;
  height: 60px;
}
.logoImg {
  width: 200px;
}
::v-deep .el-menu-item {
  padding-left: 1vw;
  padding-right: 1vw;
}
::v-deep div > .el-submenu__title {
  padding-left: 0;
  padding-right: 0;
}
</style>
