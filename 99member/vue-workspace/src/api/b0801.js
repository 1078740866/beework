import request from '@/utils/request' //引入封装好的 axios 请求

// 初期表示
export function b0801Init() {
    return request({
      url: '/B0801/init',
      method: 'post',

    })
}