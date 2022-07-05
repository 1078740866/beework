import request from '@/utils/request' //引入封装好的 axios 请求

export function c0301Init(trainingNm, companyNm, prefeNm, industryId, dateFrom, dateTo, timeFrom, timeTo, salary, userCd) {
    return request({
        url: '/C0301/init',
        method: 'post',
        data: {
            trainingNm, companyNm, prefeNm, industryId, dateFrom, dateTo, timeFrom, timeTo, salary, userCd
        }
    })
}

export function c0301getList(trainingNm, companyNm, prefeNm, industryId, dateFrom, dateTo, timeFrom, timeTo, salary, userCd) {
    return request({
        url: '/C0301/getList',
        method: 'post',
        data: {
            trainingNm, companyNm, prefeNm, industryId, dateFrom, dateTo, timeFrom, timeTo, salary, userCd
        }
    })
}

export function c0301InitPost(trainingNm, companyNm, prefeNm, industryId, dateFrom, dateTo, timeFrom, timeTo, salary, userCd) {
    return request({
        url: '/C0301/initPost',
        method: 'post',
        data: {
            trainingNm, companyNm, prefeNm, industryId, dateFrom, dateTo, timeFrom, timeTo, salary, userCd
        }
    })
}

export function c0301InitLike(trainingNm, companyNm, prefeNm, industryId, dateFrom, dateTo, timeFrom, timeTo, salary, userCd) {
    return request({
        url: '/C0301/initLike',
        method: 'post',
        data: {
            trainingNm, companyNm, prefeNm, industryId, dateFrom, dateTo, timeFrom, timeTo, salary, userCd
        }
    })
}

export function c0301insertPost(c0301VueForm,c0301ListVueForm) {
    return request({
        url: '/C0301/insertPost',
        method: 'post',
        data: {
            c0301VueForm,c0301ListVueForm
        }
    })
}

export function c0301insertLike(c0301VueForm,c0301ListVueForm) {
    return request({
        url: '/C0301/insertLike',
        method: 'post',
        data: {
            c0301VueForm,c0301ListVueForm
        }
    })
}

export function c0301updateLike(c0301VueForm,c0301ListVueForm) {
    return request({
        url: '/C0301/updateLike',
        method: 'post',
        data: {
            c0301VueForm,c0301ListVueForm
        }
    })
}

export function c0301deleteTrainingAppl(c0301VueForm,c0301ListVueForm) {
    return request({
        url: '/C0301/deleteTrainingAppl',
        method: 'post',
        data: {
            c0301VueForm,c0301ListVueForm
        }
    })
}