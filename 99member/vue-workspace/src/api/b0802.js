import request from '@/utils/request' //引入封装好的 axios 请求

// 初期表示
export function b0802Init() {
    return request({
      url: '/B0802/init',
      method: 'post',

    })
}

export function insertCoupon(beans) {
  return request({
    url: '/B0802/insertCoupon',
    method: 'post',
    data:{
      beans
    }

  })
}