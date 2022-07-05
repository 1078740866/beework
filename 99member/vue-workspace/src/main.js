import Vue from 'vue'
import App from './App.vue'
import './plugins/element.js'
import router from './router' //引入路由配置
import store from './store' //引入 Vue x 状态管理
import axios from 'axios' //引入 axios ajax
// 下面import的作用：修复控制台的Vue提示信息
// 提示内容：[Violation] Added non - passive event listener to a scroll - blocking 'mousewheel' event.
// 解决方法：1. powershell运行：npm i default-passive-events -S 2. main.js中加入：import 'default-passive-events'
import 'default-passive-events'

import VueParticles from 'vue-particles'

// vue移动端项目中click事件300ms延迟的解决方法
import fastClick from 'fastclick'

import 'lib-flexible/flexible'

fastClick.attach(document.body);

Vue.config.productionTip = false

Vue.prototype.$axios = axios;
axios.defaults.withCredentials = true;

router.beforeEach((to, from, next) => {
  //无登录状态,跳转到home页面
  if ((to.path === '/login') || (to.path === '/sp/sp_b0001') || (to.path === '/register') || (to.path === '/registerCommit') || (to.path === '/sp/sp_b0002') || (to.path === '/retrievePassword') || (from.path === '/retrievePassword') ||
    (to.path === '/c0001') || (to.path === '/sp/sp_c0001') || (to.path === '/c0002') || (to.path === '/sp/sp_c0002') ||
    (to.path === '/a0001') || (to.path === '/sp/sp_a0001') || (to.path === '/a0002') || (to.path === '/sp/sp_a0002') ||
    (to.path === '/home')  || (to.path === '/positionListFromHome') || (to.path === '/positionDetailFromHome')|| 
    (to.path === '/companyDetailFromHome') || (to.path === '/getdata') || (to.path === '/getdatadetail')){
    next();
  } else {
    let token = localStorage.getItem('Authorization');
    if (token) {
      next();
    } else {
      next({
        path: '/home'    //无登录状态,跳转到home页面
      })
    }
  }
  //判断是否需要缓存
  if (from.name === 'register') {
    to.meta.isBack = true
  }
  if (from.name === 'registerCommit') {
    to.meta.isBack = false
  }
  next()
})
new Vue({
  render: h => h(App),
  router, //使用路由配置
  store //使用 Vue x 进行状态管理
}).$mount('#app')

Vue.use(VueParticles)