import request from '@/utils/request' //引入封装好的 axios 请求

export function a0301Search(searchForm) {
  return request({
    url: '/A0301/search',
    method: 'post',
    data: searchForm
  })
}
export function a0301Update(searchForm) {
  return request({
    url: '/A0301/update',
    method: 'post',
    data: searchForm
  })
}