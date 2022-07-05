<template>
  <div id="app">
    <!-- 路由的出入口，路由的内容将被显示在这里 -->

    <keep-alive>
      <router-view v-if="$route.meta.keepAlive" />
    </keep-alive>
    <router-view v-if="!$route.meta.keepAlive" />
    <!-- <router-view v-if="isRouterAlive" /> -->
    <!-- 解决同路由但不同查询参数跳转后数据不更新 -->
    <!-- <router-view :key="$route.fullPath" /> -->
  </div>
</template>

<script>
export default {
  name: "App",
  // 修改内容参考链接 https://segmentfault.com/a/1190000017007631
  provide() {
    return {
      reload: this.reload,
    };
  },
  data() {
    return {
      isRouterAlive: true,
    };
  },
  methods: {
    reload() {
      this.isRouterAlive = false;
      this.$nextTick(function () {
        this.isRouterAlive = true;
      });
    },
  },
};
</script>
