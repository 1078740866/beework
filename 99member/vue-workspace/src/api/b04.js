import request from '@/utils/request' //引入封装好的 axios 请求

export function b0401Search(userCd, companyId, interviewType, interviewDateFrom, interviewDateTo, dateFrom, dateTo, statusFlg, interviewId, interviewIds) {
  return request({
    url: '/B0401/select',
    method: 'post',
    data: {
      userCd,
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

// 削除
export function b0401Delete(
  userCd,
  companyId,
  interviewType,
  interviewDateFrom,
  interviewDateTo,
  dateFrom,
  dateTo,
  statusFlg,
  interviewId,
  interviewIds, ) {
  return request({
    url: '/B0401/delete',
    method: 'post',
    data: {
      userCd,
      companyId,
      interviewType,
      interviewDateFrom,
      interviewDateTo,
      dateFrom,
      dateTo,
      statusFlg,
      interviewId,
      interviewIds,
    }
  })
}