import request from '@/utils/request' //引入封装好的 axios 请求

export function c0501select(userCd, applicantId,companyId, interviewType, interviewDateFrom, interviewDateTo, dateFrom, dateTo, statusFlg, interviewId, interviewIds) {
  return request({
    url: '/C0501/select',
    method: 'post',
    data: {
      userCd,
      applicantId,
      companyId,
      interviewType,
      interviewDateFrom,
      interviewDateTo,
      dateFrom,
      dateTo,
      statusFlg,
      interviewId,
      interviewIds
    }
  })
}

export function c0501selectInfo(userCd, applicantId,companyId, interviewType, interviewDateFrom, interviewDateTo, dateFrom, dateTo, statusFlg, interviewId, interviewIds) {
    return request({
      url: '/C0501/selectInfo',
      method: 'post',
      data: {
        userCd,
        applicantId,
        companyId,
        interviewType,
        interviewDateFrom,
        interviewDateTo,
        dateFrom,
        dateTo,
        statusFlg,
        interviewId,
        interviewIds
      }
    })
}

export function c0501flgChange(userCd, applicantId,companyId, interviewType, interviewDateFrom, interviewDateTo, dateFrom, dateTo, statusFlg, interviewId, interviewIds) {
    return request({
      url: '/C0501/flgChange',
      method: 'post',
      data: {
        userCd,
        applicantId,
        companyId,
        interviewType,
        interviewDateFrom,
        interviewDateTo,
        dateFrom,
        dateTo,
        statusFlg,
        interviewId,
        interviewIds
      }
    })
}