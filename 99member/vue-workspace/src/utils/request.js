import axios from 'axios' //引入 axios ajax
import baseUrl from '../api/baseUrl' //使用环境变量 + 模式的方式定义基础URL

// 创建 axios 实例
const service = axios.create({
  baseURL: baseUrl, // api 的 base_url
  timeout: 15000, // 请求超时时间
  withCredentials:true,
})

// 添加请求拦截器，在请求头中加token
service.interceptors.request.use(
  config => {
    if (localStorage.getItem('Authorization')) {
      config.headers.Authorization = localStorage.getItem('Authorization');
    }
    return config;
  },
  error => {
    return Promise.reject(error);
  });

//添加响应拦截器
service.interceptors.response.use(function (response) {
  // 对响应数据做点什么
  let data = response.data;
  if (data.code !== 200) {
    if (data.code === 10010) {
      return response;
    } else if (data.code == 401) {
      localStorage.removeItem('Authorization');
      this.$router.push('/login');
    } else {
      return response;
    }
  } else {
    return response;
  }
}, function (error) {
  return Promise.reject(error);
});

export default service