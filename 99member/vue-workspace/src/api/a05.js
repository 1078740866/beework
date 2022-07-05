import request from '@/utils/request' //引入封装好的 axios 请求

export function a0501Init(
  userCd, 
  layoutId,
  onlineFlg,
  chargeFlg,
  dateFrom,
  dateTo,
  adId,
  adIds
  ) { //登录接口
  return request({ //使用封装好的 axios 进行网络请求
    url: '/A0501/init',
    method: 'post',
    data: { //提交的数据
        userCd, 
        layoutId,
        onlineFlg,
        chargeFlg,
        dateFrom,
        dateTo,
        adId,
        adIds
    }
  })
}

export function a0501Delete(
  adId,
  adIds
  ) { //登录接口
    return request({ //使用封装好的 axios 进行网络请求
      url: '/A0501/changeDel',
      method: 'post',
      data: { //提交的数据
          adId,
          adIds
      }
    })
  }

  export function a0502registerInit() {
    return request({
      url: '/A0502/init',
      method: 'get',
    })
  }
  
  export function a0502initPop(companyNm) {
    return request({
      url: '/A0502/initPop',
      method: 'post',
      data: { //提交的数据
        companyNm
      }
    })
  }
  
  export function a0502searchPop(companyNm,country,address1,industryCd1,companyScale){
    return request({
      url: '/A0502/searchPop',
      method: 'post',
      data: { //提交的数据
        companyNm,country,address1,industryCd1,companyScale
      }
    })
  }

  // a0502初期
export function a0502InitLayout(LayoutMstBean) {
  return request({
    url: '/A0502/initLayout',
    method: 'post',
    data: {
      LayoutMstBean
    }
  })
}

// 新規
export function sendAdInfo(
        userCd,
        adId,
        companyId,
        layoutId,
        photo,
        link,
        content,
        dateFrom,
        dateTo,
        days,
        sum,
        onlineFlg,
        chargeFlg,
  ) {
  return request({
    url: '/A0502/insert',
    method: 'post',
    data: {
      userCd,
        adId,
        companyId,
        layoutId,
        photo,
        link,
        content,
        dateFrom,
        dateTo,
        days,
        sum,
        onlineFlg,
        chargeFlg,
    }
  })
}