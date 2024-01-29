import request from '@/utils/request'

// 查询推荐开源项目列表
export function listPrograms(query) {
  return request({
    url: '/abuwx/programs/list',
    method: 'get',
    params: query
  })
}

// 查询推荐开源项目详细
export function getPrograms(id) {
  return request({
    url: '/abuwx/programs/' + id,
    method: 'get'
  })
}

// 新增推荐开源项目
export function addPrograms(data) {
  return request({
    url: '/abuwx/programs',
    method: 'post',
    data: data
  })
}

// 修改推荐开源项目
export function updatePrograms(data) {
  return request({
    url: '/abuwx/programs',
    method: 'put',
    data: data
  })
}

// 删除推荐开源项目
export function delPrograms(id) {
  return request({
    url: '/abuwx/programs/' + id,
    method: 'delete'
  })
}
