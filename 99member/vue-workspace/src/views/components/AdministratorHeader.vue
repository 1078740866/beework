<template>
  <el-row class="menuRow">
    <el-menu
      :default-active="defaultActive"
      mode="horizontal"
      background-color="#014099"
      text-color="#fff"
      active-text-color="#E6A23C"
      class="menuStyle"
      router
    >
      <el-menu-item
        index="1"
        :route="{ path: routerPath.path1 }"
        @click="logout"
        class="menuItem1"
      >
        <el-image
          :src="require('@/assets/BeeWork.png')"
          fit="contain"
          class="logoStyle"
          alt
        />
      </el-menu-item>
      <el-menu-item index="2" :route="{ path: routerPath.path2 }" class="menuItem2">
        <span>{{ menuItem.menuItem2 }}</span>
      </el-menu-item>
      <el-submenu index="3" class="menuItem3 textCenter">
        <template slot="title">{{ menuItem.menuItem3 }}</template>
        <el-menu-item
          index="3-1"
          :route="{ path: routerPath.path3_1 }"
          v-text="menuItem.menuItem3_1"
        />
        <el-menu-item
          index="3-2"
          :route="{ path: routerPath.path3_2 }"
          v-text="menuItem.menuItem3_2"
        />
        <el-menu-item
          index="3-3"
          :route="{ path: routerPath.path3_3 }"
          v-text="menuItem.menuItem3_3"
        />
      </el-submenu>
      <el-menu-item
        index="4"
        v-text="menuItem.menuItem4"
        :route="{ path: routerPath.path4 }"
        class="menuItem4 textCenter"
      />
      <el-menu-item
        index="5"
        v-text="menuItem.menuItem5"
        :route="{ path: routerPath.path5 }"
        class="menuItem5 textCenter"
      />
      <el-menu-item
        index="6"
        v-text="menuItem.menuItem6"
        :route="{ path: routerPath.path6 }"
        class="menuItem6 textCenter"
      />
      <el-submenu index="7" class="menuItem7 textCenter">
        <template slot="title">{{ menuItem.menuItem7 }}</template>
        <el-menu-item
          index="7-1"
          :route="{ path: routerPath.path7_1 }"
          v-text="menuItem.menuItem7_1"
        />
        <el-menu-item
          index="7-2"
          :route="{ path: routerPath.path7_2 }"
          v-text="menuItem.menuItem7_2"
        />
        <el-menu-item
          index="7-3"
          :route="{ path: routerPath.path7_3 }"
          v-text="menuItem.menuItem7_3"
        />
      </el-submenu>
      <el-menu-item
        index="8"
        v-text="menuItem.menuItem8"
        :route="{ path: routerPath.path8 }"
        class="menuItem8 textCenter"
      />
      <el-menu-item
        index="9"
        v-text="menuItem.menuItem9"
        :route="{ path: routerPath.path9 }"
        class="menuItem9 textCenter"
      />
      <el-menu-item
        index="10"
        v-text="menuItem.menuItem10"
        :route="{ path: routerPath.path10 }"
        class="menuItem10 textCenter"
      />
      <el-menu-item
        index="12"
        :route="{ path: routerPath.path12 }"
        class="menuItem12 textCenter"
        @click="logout"
      >
        <em class="el-icon-switch-button" />
        <span>{{ menuItem.menuItem12 }}</span>
      </el-menu-item>
      <el-menu-item index="11" :route="{ path: routerPath.path11 }" class="menuItem11">
        <el-divider direction="vertical" />
        <em class="el-icon-user"></em>
        <span>{{ userName }}</span>
      </el-menu-item>
    </el-menu>
  </el-row>
</template>
<script>
export default {
  name: "administratorHeader",
  data() {
    return {
      menuItem: {
        menuItem2: "HOME",
        menuItem3: "審査管理",
        menuItem4: "会社管理",
        menuItem5: "応募者管理",
        menuItem6: "承認管理",
        menuItem7: "広告管理",
        menuItem8: "管理者管理",
        menuItem9: "通報管理",
        menuItem10: "メッセージ管理",
        menuItem12: "ログアウト",
        menuItem3_1: "会社審査",
        menuItem3_2: "職位審査",
        menuItem3_3: "管理者審査",
        menuItem7_1: "会社広告審査",
        menuItem7_2: "職位広告審査",
        menuItem7_3: "広告一覧審査",
      },
      routerPath: {
        path1: "/home",
        path2: "/a0003",
        path3_1: "/error",
        path3_2: "/error",
        path3_3: "/error",
        path4: "/a0101",
        path5: "/a0201",
        path6: "/a0701",
        path7_1: "/a0501",
        path7_2: "/a0501",
        path7_3: "/a0501",
        path8: "/a0301",
        path9: "/a0601",
        path10: "/a0801",
        path11: "/a0901",
        path12: "/a0001",
      },
    };
  },
  computed: {
    // ブラウザを更新する、以前に選択したルートを見つけることができるため
    defaultActive() {
      return "/" + this.$route.path.split("/").reverse()[0];
    },
    // ユーザーネームの取得
    userName() {
      return sessionStorage.getItem("userNameA") + " さま";
    },
  },
  methods: {
    logout() {
      localStorage.clear();
      sessionStorage.clear();
    },
  },
};
</script>
<style lang="scss" scoped>
// メニュー固定高さ
.menuStyle {
  height: 100%;
  width: 100%;
  border: 0;
}
// メニューitem固定幅
.menuItem1 {
  width: 15%;
}
.menuItem2 {
  width: 5%;
}
.menuItem3,
.menuItem7 {
  width: 6%;
}
.menuItem4,
.menuItem5,
.menuItem6 {
  width: 7%;
}
.menuItem8 {
  width: 7%;
}
.menuItem9 {
  width: 7%;
}
// 右側のメニュー
.menuItem11,
.menuItem12 {
  float: right;
}
.menuItem11 {
  width: 13%;
  text-align: left;
  padding-left: 0;
}
.menuItem12 {
  width: 9%;
}
.logoStyle {
  padding: 0 1vw;
}
.textCenter {
  text-align: center;
}
.logoStyle[data-v-87a3c98a] {
  padding: 0 0;
}
</style>
