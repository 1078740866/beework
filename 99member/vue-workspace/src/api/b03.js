import request from '@/utils/request' // axios導入

  // 初期表示
  export function b0301Init(B0301VueForm) {
    return request({
      url: '/B0301/init',
      method: 'post',
      data: {
        B0301VueForm
      }
    })
  }
  export function b0301Search(companyId, userCd, skillId, industryId , jobtypeId , prefeNm, hopeland, finalEducation, workYearsFrom, workYearsTo, languageId, levelSection, sex, hopeSalaryFrom, hopeSalaryTo, ageFrom, ageTo) {
      console.log(industryId);
    return request({
      url: '/B0301/init',
      method: 'post',
      data: {
        companyId, 
        userCd, 
        skillId, 
        industryId , 
        jobtypeId , 
        prefeNm, 
        hopeland, 
        finalEducation, 
        workYearsFrom, 
        workYearsTo, 
        languageId, 
        levelSection, 
        sex, 
        hopeSalaryFrom, 
        hopeSalaryTo, 
        ageFrom, 
        ageTo
      }
    })
  }