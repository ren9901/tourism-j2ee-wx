import request from '@/utils/request'

// 查询景区表列表
export function listJingdianTable(query) {
  return request({
    url: '/abuwx/jingdianTable/list',
    method: 'get',
    params: query
  })
}

// 查询景区表详细
export function getJingdianTable(id) {
  return request({
    url: '/abuwx/jingdianTable/' + id,
    method: 'get'
  })
}

// 新增景区表
export function addJingdianTable(data) {
  return request({
    url: '/abuwx/jingdianTable',
    method: 'post',
    data: data
  })
}

// 修改景区表
export function updateJingdianTable(data) {
  return request({
    url: '/abuwx/jingdianTable',
    method: 'put',
    data: data
  })
}

// 删除景区表
export function delJingdianTable(id) {
  return request({
    url: '/abuwx/jingdianTable/' + id,
    method: 'delete'
  })
}
