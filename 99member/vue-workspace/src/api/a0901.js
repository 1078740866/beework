import request from '@/utils/request' //引入封装好的 axios 请求


export function a0901InitUserInfoA() {
  return request({
    url: '/A0901/initUserInfoA',
    method: 'post',
  })
}

export function a0901InitUserInfoB() {
    return request({
      url: '/A0901/initUserInfoB',
      method: 'post',
    })
}


export function a0901InitUserInfoC() {
    return request({
      url: '/A0901/initUserInfoC',
      method: 'post',
    })
}

export function a0901userInfoUpdate(userCd, pwd, repwd, companyId, authority, firstNameKana, firstName, lastNameKana, lastName, sex, countryZip, userTel, userMail, photoAddress, userStatus) {
    return request({
        url: '/A0901/userInfoUpdate',
        method: 'post',
        data: {
            userCd, pwd, repwd, companyId, authority, firstNameKana, firstName, lastNameKana, lastName, sex, countryZip, userTel, userMail, photoAddress, userStatus
        }
    })
}