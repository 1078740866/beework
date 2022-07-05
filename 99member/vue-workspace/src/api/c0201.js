import request from '@/utils/request' //引入封装好的 axios 请求

export function c0201Init(likeSelect, companyNm, prefeId, prefeNm, salary, industryId, jobtypeId, degree, expYears, empLaborIns, welfare, trainingFlg, inspectionFlg, userCd) {
    return request({
        url: '/C0201/init',
        method: 'post',
        data: {
            likeSelect, companyNm, prefeId, prefeNm, salary, industryId, jobtypeId, degree, expYears, empLaborIns, welfare, trainingFlg, inspectionFlg, userCd,
        }
    })
}

export function c0201getDate(likeSelect, companyNm, prefeId, prefeNm, salarySection,salary, industryId, jobtypeId, degree, expYears, empLaborIns, welfare, trainingFlg, inspectionFlg, userCd) {
    return request({
        url: '/C0201/getDate',
        method: 'post',
        data: {
            likeSelect, companyNm, prefeId, prefeNm, salarySection,salary, industryId, jobtypeId, degree, expYears, empLaborIns, welfare, trainingFlg, inspectionFlg, userCd,
        }
    })
}

export function c0201InitPost(likeSelect, companyNm, prefeId, prefeNm, salary, industryId, jobtypeId, degree, expYears, empLaborIns, welfare, trainingFlg, inspectionFlg, userCd) {
    return request({
        url: '/C0201/initPost',
        method: 'post',
        data: {
            likeSelect, companyNm, prefeId, prefeNm, salary, industryId, jobtypeId, degree, expYears, empLaborIns, welfare, trainingFlg, inspectionFlg, userCd,
        }
    })
}

export function c0201InitLike(likeSelect, companyNm, prefeId, prefeNm, salary, industryId, jobtypeId, degree, expYears, empLaborIns, welfare, trainingFlg, inspectionFlg, userCd) {
    return request({
        url: '/C0201/initLike',
        method: 'post',
        data: {
            likeSelect, companyNm, prefeId, prefeNm, salary, industryId, jobtypeId, degree, expYears, empLaborIns, welfare, trainingFlg, inspectionFlg, userCd,
        }
    })
}

export function c0201insertPost(c0201VueForm,c0201ListVueForm) {
    return request({
        url: '/C0201/insertPost',
        method: 'post',
        data: {
            c0201VueForm,c0201ListVueForm
        }
    })
}

export function c0201insertLike(c0201VueForm,c0201ListVueForm) {
    return request({
        url: '/C0201/insertLike',
        method: 'post',
        data: {
            c0201VueForm,c0201ListVueForm
        }
    })
}

export function c0201updateLike(c0201VueForm,c0201ListVueForm) {
    return request({
        url: '/C0201/updateLike',
        method: 'post',
        data: {
            c0201VueForm,c0201ListVueForm
        }
    })
}

export function c0201deleteApplication(c0201VueForm,c0201ListVueForm) {
    return request({
        url: '/C0201/deleteApplication',
        method: 'post',
        data: {
            c0201VueForm,c0201ListVueForm
        }
    })
}