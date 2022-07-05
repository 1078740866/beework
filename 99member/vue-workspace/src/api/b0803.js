import request from '@/utils/request' //引入封装好的 axios 请求

// 初期表示
export function b0803Init() {
    return request({
      url: '/B0803/init',
      method: 'post',

    })
}

export function b0803getCharge(companyId, chargeTime, chargeMoney, chargeHoney, payMethod, statusFlg, remainder, honeyLastDate, userCd,) {
  return request({
      url: '/B0803/charge',
      method: 'post',
      data: {
        companyId, chargeTime, chargeMoney, chargeHoney, payMethod, statusFlg, remainder, honeyLastDate, userCd,
      }
  })
}