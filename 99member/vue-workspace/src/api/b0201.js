import request from '@/utils/request' // axios導入

// 初期表示
export function b0201Init() {
  return request({
    url: '/B0201/init',
    method: 'post'
  })
}

export function b0201Search(searchForm) {
  return request({
    url: '/B0201/search',
    method: 'post',
    data: searchForm
  })
}

export function updateStatus(searchForm) {
  return request({
    url: '/B0201/update',
    method: 'post',
    data: searchForm
  })
}