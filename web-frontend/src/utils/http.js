import axios from 'axios'
import vueCookie from 'vue-cookie'
import { Message } from 'element-ui'

// 创建实例并设置超时时间
const http = axios.create({
  timeout: 50000
})

// 拦截所有HTTP请求
// request拦截器
http.interceptors.request.use(config => {
  // 给所有的http请求加上token，如果vueCookie中没有，则先让用户去登录
  if (vueCookie.get('NToken') !== null) {
    config.headers['Authorization'] = 'Bearer ' + vueCookie.get('NToken')
  } else {
    window.location = 'http://localhost:80/login'
    return
  }
  return config
}, error => {
  return Promise.reject(error)
})

// 防止一次性出现太多错误的弹框
let messageIsOnShow = false

// response拦截器
http.interceptors.response.use(
  res => res,
  error => {
    console.log('response.error = ' + JSON.stringify(error))
    // 401未进行认证，403认证失败（重定向到扫描登录页面，扫描刷新cookie中的token）
    if (error.response.status === 401 || error.response.status === 403 || error.response.data.message === 'JWT过期') {
      window.location = 'http://localhost:80/login'
    }
    if (!messageIsOnShow) {
      messageIsOnShow = true
      Message({
        message: error.response.data.msg === undefined ? '系统错误' : error.response.data.msg,
        type: 'error',
        duration: 3 * 1000,
        onClose: function () {
          messageIsOnShow = false
        }
      })
    }
    return Promise.reject(error)
  })

export default http
