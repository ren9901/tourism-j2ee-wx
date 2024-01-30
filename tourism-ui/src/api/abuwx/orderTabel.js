import request from '@/utils/request'

// 查询订单列表
export function listOrderTabel(query) {
  return request({
    url: '/abuwx/orderTabel/list',
    method: 'get',
    params: query
  })
}

// 查询订单详细
export function getOrderTabel(id) {
  return request({
    url: '/abuwx/orderTabel/' + id,
    method: 'get'
  })
}

// 新增订单
export function addOrderTabel(data) {
  return request({
    url: '/abuwx/orderTabel',
    method: 'post',
    data: data
  })
}

// 修改订单
export function updateOrderTabel(data) {
  return request({
    url: '/abuwx/orderTabel',
    method: 'put',
    data: data
  })
}

// 删除订单
export function delOrderTabel(id) {
  return request({
    url: '/abuwx/orderTabel/' + id,
    method: 'delete'
  })
}
