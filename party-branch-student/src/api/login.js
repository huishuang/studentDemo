import store from '@/store'

/**
 * 登录
 * 账号：admin
 * 密码：123456
 * @param {} userId
 * @param {*} password
 */
export function login (userId, password) {
  var data = {
    'userId': userId,
    'password': password
  }
  // 传输数据
  store.dispatch('Login', data)
}

/**
 * 注销
 */
export function logout () {
  store.dispatch('Logout')
}

/**
 * 获取登录状态（Boolean）
 * false代表未登录
 * true代表已登录
 */
export function isLogin () {
  return store.getters.isLogin
}

/**
 * 获取登录用户名
 * 登录返回：admin
 * 未登录返回: ""
 */
export function getUser () {
  return store.getters.nickname
}

/**
 * 测试登录
 */
export function testLogin () {
  login('admin', '123456')
}
