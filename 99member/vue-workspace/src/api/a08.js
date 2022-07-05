import request from '@/utils/request' //引入封装好的 axios 请求

export function a0801Insert(sendId, recid, subject, internalMessageTextId, internalMessageText) {
  return request({
    url: '/A0801/send',
    method: 'post',
    data: {
      sendId,
      recid,
      subject,
      internalMessageTextId,
      internalMessageText,
    }
  })
}

export function a0801AddressList(userCd, internalMessageId, address, subject, dateFrom, dateTo,statusFlg) {
  return request({
    url: '/A0801/addressList',
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

export function a0802GetMessage(userCd, internalMessageId, address, subject, dateFrom, dateTo,statusFlg) {
  return request({
    url: '/A0801/getMessage',
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