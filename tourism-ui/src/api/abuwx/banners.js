import request from '@/utils/request'

// 查询轮播图管理列表
export function listBanners(query) {
  return request({
    url: '/abuwx/banners/list',
    method: 'get',
    params: query
  })
}

// 查询轮播图管理详细
export function getBanners(id) {
  return request({
    url: '/abuwx/banners/' + id,
    method: 'get'
  })
}

// 新增轮播图管理
export function addBanners(data) {
  return request({
    url: '/abuwx/banners',
    method: 'post',
    data: data
  })
}

// 修改轮播图管理
export function updateBanners(data) {
  return request({
    url: '/abuwx/banners',
    method: 'put',
    data: data
  })
}

// 删除轮播图管理
export function delBanners(id) {
  return request({
    url: '/abuwx/banners/' + id,
    method: 'delete'
  })
}
