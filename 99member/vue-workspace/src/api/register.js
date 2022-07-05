import request from '@/utils/request' //引入封装好的 axios 请求

export function register(companyInfo) {
  return request({
    url: '/B0002/register',
    method: 'post',
    data: {
      companyInfo
    }
  })
}

export function registerInit() {
  return request({
    url: '/B0002/init',
    method: 'get',
  })
}

export function initPop(companyNm) {
  return request({
    url: '/B0002/initPop',
    method: 'post',
    data: { //提交的数据
      companyNm
    }
  })
}

export function searchPop(companyNm,country,address1,industryCd1,companyScale){
  return request({
    url: '/B0002/searchPop',
    method: 'post',
    data: { //提交的数据
      companyNm,country,address1,industryCd1,companyScale
    }
  })
}

export function userSelect(userMail,companyNm,userName){
  return request({
    url: '/A0801/userPop',
    method: 'post',
    data: { //提交的数据
      userMail,companyNm,userName
    }
  })
}

export function searchPostal(companyPostal){
  return request({
    url: '/B0002/searchPostal',
    method: 'post',
    data: { //提交的数据
      companyPostal
    }
  })
}

export function insertCompany(companyInfo){
  return request({
    url: '/B0002/insertCompany',
    method: 'post',
    data: { //提交的数据
      companyInfo
    }
  })
}