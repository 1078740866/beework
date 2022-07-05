import request from '@/utils/request' //引入封装好的 axios 请求

export function getPositionByCompanyId(companyId) { //登录接口
  return request({ //使用封装好的 axios 进行网络请求
    url: '/positionListFromHome/getPositionByCompany',
    method: 'post',
    data: {
      companyId
    }
  })
}

