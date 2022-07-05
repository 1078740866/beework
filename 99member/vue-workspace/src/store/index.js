import Vue from 'vue' //引入 Vue
import Vuex from 'vuex' //引入 Vuex
import user from './modules/user' //引入 user module

Vue.use(Vuex)
 
const store = new Vuex.Store({
  
  state: {
    // 存储token
    Authorization: localStorage.getItem('Authorization') ? localStorage.getItem('Authorization') : '',
    HOST: 'http://localhost:8088'
  },

  modules: {
    user, //使用 user.js 中的 action
  }
})
 
export default store