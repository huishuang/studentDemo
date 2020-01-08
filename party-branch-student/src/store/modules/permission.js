import { constantRouterMap } from '@/config/router.config'
import { whiteList, adminList } from '@/router/map'

function hasPermission (permission, route) {
  if (route.name) {
    let flag = false
    for (let i = 0, len = permission.length; i < len; i++) {
      flag = route.name.includes(permission[i])
      if (flag) {
        return true
      }
    }
    return false
  }
  return true
}

function filterAsyncRouter (routerMap, roles) {
  const accessedRouters = routerMap.filter(route => {
    if (hasPermission(roles, route)) {
      if (route.children && route.children.length) {
        route.children = filterAsyncRouter(route.children, roles)
      }
      return true
    }
    return false
  })
  return accessedRouters
}

const permission = {
  state: {
    addRouters: [],
    roleList: [],
    baseList: whiteList
  },
  mutations: {
    SET_ROUTERS: (state, routers) => {
      state.addRouters = routers
    },
    SET_ROLELIST: (state, list) => {
      state.roleList = list
    }
  },
  actions: {
    GenerateRoutes ({ commit }) {
      commit('SET_ROUTERS', filterAsyncRouter(constantRouterMap, adminList))
      commit('SET_ROLELIST', adminList)
    }
  }
}

export default permission
