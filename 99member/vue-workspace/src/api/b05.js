import request from '@/utils/request' // axios導入

// 初期表示
export function b0501Init(B0501VueForm) {
  return request({
    url: '/B0501/init',
    method: 'post',
    data: {
      B0501VueForm
    }
  })
}
// 検索
export function b0501Search(companyId, userCd, trainingNm, industryId, statusFlg, dateFrom, dateTo, trainingId, trainingIds) {
  return request({
    url: '/B0501/init',
    method: 'post',
    data: {
      companyId,
      userCd,
      trainingNm,
      industryId,
      statusFlg,
      dateFrom,
      dateTo,
      trainingId,
      trainingIds
    }
  })
}
// 削除
export function b0501Delete(trainingIds) {
  return request({
    url: '/B0501/update',
    method: 'post',
    data: {
      trainingIds
    }
  })
}
// 初期
export function b0502Init(IndustryMstBean) {
  return request({
    url: '/B0502/init',
    method: 'post',
    data: {
      IndustryMstBean
    }
  })
}
// 新規
export function sendTrainingInfo(
  userCd,
  trainingId,
  companyId,
  industryId,
  trainingNm,
  dateFrom,
  dateTo,
  timeFrom,
  timeTo,
  postal,
  prefingNm,
  charge,
  cost,
  proCnt,
  remarks,
  teaIntro,
  teaNm,
  tel,
  trainingAddress1,
  trainingAddress2,
  trainingContent,
  trainingPic1,
  trainingPic2,
  trainingPic3, ) {
  return request({
    url: '/B0502/updateOrInsert',
    method: 'post',
    data: {
      userCd,
      trainingId,
      companyId,
      industryId,
      trainingNm,
      dateFrom,
      dateTo,
      timeFrom,
      timeTo,
      postal,
      prefingNm,
      charge,
      cost,
      proCnt,
      remarks,
      teaIntro,
      teaNm,
      tel,
      trainingAddress1,
      trainingAddress2,
      trainingContent,
      trainingPic1,
      trainingPic2,
      trainingPic3,
    }
  })
}

export function b0503Search(
  userCd,
  companyId,
  trainingId,
  name,
  status,
  applicantId,
  statusFlg,
) {
  console.log("b05.js: b0503Search")
  return request({
    url: '/B0503/init',
    method: 'post',
    data: {
      userCd,
      companyId,
      trainingId,
      name,
      status,
      applicantId,
      statusFlg,
    },
  })
}