import request from '@/utils/request'

// 查询小程序配置列表
export function listWxappconfig(query) {
  return request({
    url: '/abuwx/wxappconfig/list',
    method: 'get',
    params: query
  })
}

// 查询小程序配置详细
export function getWxappconfig(id) {
  return request({
    url: '/abuwx/wxappconfig/' + id,
    method: 'get'
  })
}

// 新增小程序配置
export function addWxappconfig(data) {
  return request({
    url: '/abuwx/wxappconfig',
    method: 'post',
    data: data
  })
}

// 修改小程序配置
export function updateWxappconfig(data) {
  return request({
    url: '/abuwx/wxappconfig',
    method: 'put',
    data: data
  })
}

// 删除小程序配置
export function delWxappconfig(id) {
  return request({
    url: '/abuwx/wxappconfig/' + id,
    method: 'delete'
  })
}
