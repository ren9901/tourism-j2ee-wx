import request from '@/utils/request'

// 查询推荐项目管理列表
export function listItems(query) {
  return request({
    url: '/abuwx/items/list',
    method: 'get',
    params: query
  })
}

// 查询推荐项目管理详细
export function getItems(id) {
  return request({
    url: '/abuwx/items/' + id,
    method: 'get'
  })
}

// 新增推荐项目管理
export function addItems(data) {
  return request({
    url: '/abuwx/items',
    method: 'post',
    data: data
  })
}

// 修改推荐项目管理
export function updateItems(data) {
  return request({
    url: '/abuwx/items',
    method: 'put',
    data: data
  })
}

// 删除推荐项目管理
export function delItems(id) {
  return request({
    url: '/abuwx/items/' + id,
    method: 'delete'
  })
}
