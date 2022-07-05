import request from '@/utils/request' //引入封装好的 axios 请求

export function c0401Init(briefingNm, companyNm, briefingType, dateFrom, dateTo, prefeNm, userCd,applicantId) {
    return request({
        url: '/C0401/init',
        method: 'post',
        data: {
            briefingNm, companyNm, briefingType, dateFrom, dateTo, prefeNm, userCd,applicantId
        }
    })
}

export function c0401getList(briefingNm, companyNm, briefingType, dateFrom, dateTo, prefeNm, userCd,applicantId) {
    return request({
        url: '/C0401/getList',
        method: 'post',
        data: {
            briefingNm, companyNm, briefingType, dateFrom, dateTo, prefeNm, userCd,applicantId
        }
    })
}

export function c0401InitPost(briefingNm, companyNm, briefingType, dateFrom, dateTo, prefeNm, userCd,applicantId) {
    return request({
        url: '/C0401/initPost',
        method: 'post',
        data: {
            briefingNm, companyNm, briefingType, dateFrom, dateTo, prefeNm, userCd,applicantId
        }
    })
}

export function c0401InitLike(briefingNm, companyNm, briefingType, dateFrom, dateTo, prefeNm, userCd,applicantId) {
    return request({
        url: '/C0401/initLike',
        method: 'post',
        data: {
            briefingNm, companyNm, briefingType, dateFrom, dateTo, prefeNm, userCd,applicantId
        }
    })
}

export function c0401insertPost(c0401VueForm,c0401ListVueForm) {
    return request({
        url: '/C0401/insertPost',
        method: 'post',
        data: {
            c0401VueForm,c0401ListVueForm
        }
    })
}

export function c0401insertLike(c0401VueForm,c0401ListVueForm) {
    return request({
        url: '/C0401/insertLike',
        method: 'post',
        data: {
            c0401VueForm,c0401ListVueForm
        }
    })
}

export function c0401updateLike(c0401VueForm,c0401ListVueForm) {
    return request({
        url: '/C0401/updateLike',
        method: 'post',
        data: {
            c0401VueForm,c0401ListVueForm
        }
    })
}

export function c0401deleteBriefingAppl(c0401VueForm,c0401ListVueForm) {
    return request({
        url: '/C0401/deleteBriefingAppl',
        method: 'post',
        data: {
            c0401VueForm,c0401ListVueForm
        }
    })
}