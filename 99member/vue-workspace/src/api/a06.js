import request from '@/utils/request' // axios導入

// a060101初期表示
export function a0601Init(typeSection,reportSection,limit,offset) {
    return request({
      url: '/A0601/init',
      method: 'post',
      data: {
        typeSection,
        reportSection,
        limit,
        offset
      }
    })
  }
// a0601通報ボタン押下
export function a0601Confirm(reportIds,statusFlg) {
  return request({
    url: '/A0601/updateSection',
    method: 'post',
    data: {
      reportIds,
      statusFlg
    }
  })
}
// a0601通報ボタン押下
export function a0602Position(positionId) {
  return request({
    url: '/A0602/getPosition',
    method: 'post',
    data: {
      positionId
    }
  })
}
// a0601通報ボタン押下
export function a0602Training(trainingId) {
  return request({
    url: '/A0602/getTraining',
    method: 'post',
    data: {
      trainingId
    }
  })
}
// a0601通報ボタン押下
export function a0602Briefing(briefingId) {
  return request({
    url: '/A0602/getBriefing',
    method: 'post',
    data: {
      briefingId
    }
  })
}