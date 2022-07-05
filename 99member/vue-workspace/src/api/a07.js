import request from '@/utils/request' // axios導入

// a070101初期表示
export function a070101Init(
  userMail,userName,authority,userCd,userCds,statusFlg
  ) {
  return request({
    url: '/A070101/init',
    method: 'post',
    data: {
      userMail,userName,authority,userCd,userCds,statusFlg
    }
  })
}
// a070101検索
export function a070101Search(
  userMail,userName,authority,userCd,userCds,statusFlg
    ) {
  return request({
    url: '/A070101/init',
    method: 'post',
    data: {
      userMail,userName,authority,userCd,userCds,statusFlg
    }
  })
}
// a070101承認
export function a070101Confirm(userMail,userName,authority,userCd,userCds,statusFlg) {
  return request({
    url: '/A070101/updateUserStatus',
    method: 'post',
    data: {
      userMail,userName,authority,userCd,userCds,statusFlg
    }
  })
}
// a070101拒否
export function a070101Deny(userMail,userName,authority,userCd,userCds,statusFlg) {
  return request({
    url: '/A070101/updateUserStatus',
    method: 'post',
    data: {
      userMail,userName,authority,userCd,userCds,statusFlg
    }
  })
}
// a070102検索
export function a070102Search(
        companyNm,
        prefeNm,
        industryId,
        companyId,
        companyIds,
        statusFlg
    ) {
  return request({
    url: '/A070102/init',
    method: 'post',
    data: {
      companyNm,
      prefeNm,
      industryId,
      companyId,
      companyIds,
      statusFlg
    }
  })
}
// a070102承認// a070102拒否
export function a070102Confirm(
      companyNm,
      prefeNm,
      industryId,
      companyId,
      companyIds,
      statusFlg,
    ) {
  return request({
    url: '/A070102/companyConfirmOrDeny',
    method: 'post',
    data: {
      companyNm,
      prefeNm,
      industryId,
      companyId,
      companyIds,
      statusFlg
    }
  })
}
// a070103検索
export function a070103Search(
      likeSelect,
      positionNm,
      companyNm,
      prefeNm,
      industryId,
      jobtypeId,
      positionId,
    ) {
  return request({
    url: '/A070103/init',
    method: 'post',
    data: {
        likeSelect,
        positionNm,
        companyNm,
        prefeNm,
        industryId,
        jobtypeId,
        positionId,
    }
  })
}
// a070103承認// a070103拒否
export function a070103Confirm(
      listData,
      statusFlg,
    ) {
  return request({
    url: '/A070103/positionConfirmOrDeny',
    method: 'post',
    data: {
      listData,
      statusFlg,
    }
  })
}
// a070104検索
export function a070104Search(
      companyNm,
      trainingNm,
      prefeNm,
      industryId,
      trainingId,
    ) {
  return request({
    url: '/A070104/init',
    method: 'post',
    data: {
      companyNm,
      trainingNm,
      prefeNm,
      industryId,
      trainingId,
    }
  })
}
// a070104承認// a070104拒否
export function a070104Confirm(
    listData,
    statusFlg,
    ) {
    return request({
    url: '/A070104/trainingConfirmOrDeny',
    method: 'post',
    data: {
      listData,
      statusFlg,
    }
  })
}
// a070105検索
export function a070105Search(
    companyNm,
    briefingNm,
    briefingType,
    dateFromString,
    dateToString,
    briefingId,
    prefeNm,
      ) {
    return request({
      url: '/A070105/init',
      method: 'post',
      data: {
        companyNm,
        briefingNm,
        briefingType,
        dateFromString,
        dateToString,
        briefingId,
        prefeNm,
      }
    })
  }
// a070105承認// a070105拒否
export function a070105Confirm(
    listData,
    statusFlg,
    ) {
    return request({
    url: '/A070105/briefingConfirmOrDeny',
    method: 'post',
    data: {
      listData,
      statusFlg,
    }
  })
}