// データ採集検証のため、新規作成
import request from '@/utils/request' // axios導入

// 初期表示
export function g01Search(goodsDetail,goodsPhoto,goodsLink,goodsName,goodsTag,goodsPrice) {
  return request({
    url: '/getdata/init',
    method: 'post',
    data: {
      goodsDetail,
      goodsPhoto,
      goodsLink,
      goodsName,
      goodsTag,
      goodsPrice
    }
  })
}
