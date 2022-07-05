import request from '@/utils/request' //引入封装好的 axios 请求


export function b0003Search() {
  return request({
    url: '/B0003/init',
    method: 'post',
  })
}