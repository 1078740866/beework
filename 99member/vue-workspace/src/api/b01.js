import request from '@/utils/request' // axios導入

// 初期表示
export function b0101Init(B0101VueForm) {
  return request({
    url: '/B0101/init',
    method: 'post',
    data: {
      B0101VueForm
    }
  })
}
// 検索
export function b0101Search(companyId, userCd, positionNm, checkStatus) {
  return request({
    url: '/B0101/init',
    method: 'post',
    data: {
      companyId,
      userCd,
      positionNm,
      checkStatus
    }
  })
}

// b0102初期
export function b0102InitIndustry(IndustryMstBean) {
  return request({
    url: '/B0102/initIndustry',
    method: 'post',
    data: {
      IndustryMstBean
    }
  })
}
// b0102初期
export function b0102InitJobtype(JobtypeMstBean) {
  return request({
    url: '/B0102/initJobtype',
    method: 'post',
    data: {
      JobtypeMstBean
    }
  })
}
// b0102初期
export function b0102InitSkill(SkillMstBean) {
  return request({
    url: '/B0102/initSkill',
    method: 'post',
    data: {
      SkillMstBean
    }
  })
}
//
export function b0102register(
        userCd,
        companyId,
        industryId,
        jobTypeId,
        skillId,
        positionNm,
        expDate,
        degree,
        workTimeFrom,
        workTimeTo,
        salarySection,
        positionInt,
        salaryMin,
        salaryMax,
        empLaborIns,
        workContent,
        welfare,
        expYears,
        trainingFlg,
        inspectionFlg,
        conUpdFlg,
        peoCnt,
        workDateStr,
        contractSection,
        holiday,
        postal,
        workAddress1,
        workAddress2,
        station,
        workingAddress1,
        workingAddress2,
        workingAddress3,
  ) {
  return request({
    url: '/B0102/register',
    method: 'post',
    data: {
        userCd,
        companyId,
        industryId,
        jobTypeId,
        skillId,
        positionNm,
        expDate,
        degree,
        workTimeFrom,
        workTimeTo,
        salarySection,
        positionInt,
        salaryMin,
        salaryMax,
        empLaborIns,
        workContent,
        welfare,
        expYears,
        trainingFlg,
        inspectionFlg,
        conUpdFlg,
        peoCnt,
        workDateStr,
        contractSection,
        holiday,
        postal,
        workAddress1,
        workAddress2,
        station,
        workingAddress1,
        workingAddress2,
        workingAddress3,
    }
  })
}
// 新規
export function sendPositionInfo(
        userCd,
        companyId,
        industryId,
        jobTypeId,
        skillId,
        positionNm,
        expDate,
        degree,
        workTimeFrom,
        workTimeTo,
        salarySection,
        positionInt,
        salaryMin,
        salaryMax,
        empLaborIns,
        workContent,
        welfare,
        expYears,
        trainingFlg,
        inspectionFlg,
        conUpdFlg,
        peoCnt,
        workDateStr,
        contractSection,
        holiday,
        postal,
        workAddress1,
        workAddress2,
        station,
        workingAddress1,
        workingAddress2,
        workingAddress3,
  ) {
  return request({
    url: '/B0102/addPosition',
    method: 'post',
    data: {
      userCd,
        companyId,
        industryId,
        jobTypeId,
        skillId,
        positionNm,
        expDate,
        degree,
        workTimeFrom,
        workTimeTo,
        salarySection,
        positionInt,
        salaryMin,
        salaryMax,
        empLaborIns,
        workContent,
        welfare,
        expYears,
        trainingFlg,
        inspectionFlg,
        conUpdFlg,
        peoCnt,
        workDateStr,
        contractSection,
        holiday,
        postal,
        workAddress1,
        workAddress2,
        station,
        workingAddress1,
        workingAddress2,
        workingAddress3,
    }
  })
}
// 改修
export function sendPositionInfoModify(
  userCd,
  positionId,
  companyId,
  industryId,
  jobTypeId,
  skillId,
  positionNm,
  expDate,
  degree,
  workTimeFrom,
  workTimeTo,
  salarySection,
  positionInt,
  salaryMin,
  salaryMax,
  empLaborIns,
  workContent,
  welfare,
  expYears,
  trainingFlg,
  inspectionFlg,
  conUpdFlg,
  peoCnt,
  workDateStr,
  contractSection,
  holiday,
  postal,
  workAddress1,
  workAddress2,
  station,
  workingAddress1,
  workingAddress2,
  workingAddress3,
) {
return request({
url: '/B0102/updPosition',
method: 'post',
data: {
userCd,
  companyId,
  positionId,
  industryId,
  jobTypeId,
  skillId,
  positionNm,
  expDate,
  degree,
  workTimeFrom,
  workTimeTo,
  salarySection,
  positionInt,
  salaryMin,
  salaryMax,
  empLaborIns,
  workContent,
  welfare,
  expYears,
  trainingFlg,
  inspectionFlg,
  conUpdFlg,
  peoCnt,
  workDateStr,
  contractSection,
  holiday,
  postal,
  workAddress1,
  workAddress2,
  station,
  workingAddress1,
  workingAddress2,
  workingAddress3,
}
})
}
// b0101オンライン
export function b0101OnlineOffline(
  positionId,
  positionIds,
  onlineStatus
  ) {
  return request({
    url: '/B0101/onlineoffline',
    method: 'post',
    data: {
      positionId,
      positionIds,
      onlineStatus
    }
  })
}
// b0101トップ
export function b0101Top(
  positionId,
  positionIds,
  topStatus
  ) {
  return request({
    url: '/B0101/top',
    method: 'post',
    data: {
      positionId,
      positionIds,
      topStatus
    }
  })
}
// 削除
export function b0101Delete(
  positionId,
  positionIds
  ) {
  return request({
    url: '/B0101/delete',
    method: 'post',
    data: {
      positionId,
      positionIds
    }
  })
}