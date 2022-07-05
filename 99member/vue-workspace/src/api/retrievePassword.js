import request from '@/utils/request' //引入封装好的 axios 请求

export function sendPwMail(userMail) {
  return request({
    url: '/B0004/sendPwMail',
    method: 'post',
    data: {
      userMail
    }
  })
}

export function checkMailCode(mailCode) {
  return request({
    url: '/B0004/checkMailCode',
    method: 'post',
    data: {
      mailCode
    }
  })
}

export function changePassword(userMail,password,passwordConfirm) {
  return request({
    url: '/B0004/changePassword',
    method: 'post',
    data: {
      userMail,
      password,
      passwordConfirm
    }
  })
}
