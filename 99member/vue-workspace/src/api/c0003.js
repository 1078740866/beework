import request from '@/utils/request' //引入封装好的 axios 请求


export function c0003Search() {
  return request({
    url: '/C0003/init',
    method: 'post',
  })
}