import http from '@/utils/http.js'

export function getFoodList (query) {
  return http({
    url: '/api/foods/list',
    method: 'get',
    params: query
  })
}
