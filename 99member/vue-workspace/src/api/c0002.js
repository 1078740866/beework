import request from '@/utils/request' //引入封装好的 axios 请求
export function userConf(userCd, pwd, repwd, companyId, authority, firstNameKana, firstName, lastNameKana, lastName, sex, countryZip, userTel, userMail, photoAddress, userStatus) {
    return request({
        url: '/C0002/userConf',
        method: 'post',
        data: {
            userCd, pwd, repwd, companyId, authority, firstNameKana, firstName, lastNameKana, lastName, sex, countryZip, userTel, userMail, photoAddress, userStatus
        }
    })
}

export function userInsert(userCd, pwd, repwd, companyId, authority, firstNameKana, firstName, lastNameKana, lastName, sex, countryZip, userTel, userMail, photoAddress, userStatus) {
    return request({
        url: '/C0002/userInsert',
        method: 'post',
        data: {
            userCd, pwd, repwd, companyId, authority, firstNameKana, firstName, lastNameKana, lastName, sex, countryZip, userTel, userMail, photoAddress, userStatus
        }
    })
}