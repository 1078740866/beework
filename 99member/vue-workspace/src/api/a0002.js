import request from '@/utils/request' //引入封装好的 axios 请求
export function auserConf(userCd, pwd, repwd, companyId, authority, firstNameKana, firstName, lastNameKana, lastName, sex, countryZip, userTel, userMail, photoAddress, userStatus) {
    return request({
        url: '/A0002/userConf',
        method: 'post',
        data: {
            userCd, pwd, repwd, companyId, authority, firstNameKana, firstName, lastNameKana, lastName, sex, countryZip, userTel, userMail, photoAddress, userStatus
        }
    })
}

export function auserInsert(userCd, pwd, repwd, companyId, authority, firstNameKana, firstName, lastNameKana, lastName, sex, countryZip, userTel, userMail, photoAddress, userStatus) {
    return request({
        url: '/A0002/userInsert',
        method: 'post',
        data: {
            userCd, pwd, repwd, companyId, authority, firstNameKana, firstName, lastNameKana, lastName, sex, countryZip, userTel, userMail, photoAddress, userStatus
        }
    })
}