import request from '@/utils/request' //引入封装好的 axios 请求

export function b0901Init(userCd, internalMessageId, address, subject, dateFrom, dateTo,statusFlg) {
  return request({
    url: '/B0901/select',
    method: 'post',
    data: {
      userCd,
      internalMessageId,
      address,
      subject,
      dateFrom,
      dateTo,
      statusFlg
    }
  })
}

export function b0902Message(userCd, internalMessageId, address, subject, dateFrom, dateTo,statusFlg) {
  return request({
    url: '/B0901/getMessage',
    method: 'post',
    data: {
      userCd,
      internalMessageId,
      address,
      subject,
      dateFrom,
      dateTo,
      statusFlg
    }
  })
}