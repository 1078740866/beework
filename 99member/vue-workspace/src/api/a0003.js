import request from '@/utils/request' //引入封装好的 axios 请求


export function a0003Search() {
  return request({
    url: '/A0003/init',
    method: 'post',
  })
}