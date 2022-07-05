import request from '@/utils/request' //引入封装好的 axios 请求

export function getComchargeResult(chargeFrom, chargeTo,statusFlg,consFrom,consTo,itemId,chargeId,chargeMoney,chargeHoney) {
    return request({ //使用封装好的 axios 进行网络请求
      url: '/B0804/comcharge',
      method: 'post',
      data: { //提交的数据
        chargeFrom,
        chargeTo,
        statusFlg,
        consFrom,
        consTo,
        itemId,
        chargeId,
        chargeMoney,
        chargeHoney
      }
    })
  }

  export function getComconsResult(chargeFrom, chargeTo,statusFlg,consFrom,consTo,itemId,chargeId,chargeMoney,chargeHoney) {
    return request({ //使用封装好的 axios 进行网络请求
      url: '/B0804/comcons',
      method: 'post',
      data: { //提交的数据
        chargeFrom,
        chargeTo,
        statusFlg,
        consFrom,
        consTo,
        itemId,
        chargeId,
        chargeMoney,
        chargeHoney
      }
    })
  }

