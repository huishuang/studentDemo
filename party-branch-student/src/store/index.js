import Vue from 'vue'
import Vuex from 'vuex'

import app from './modules/app'
import user from './modules/user'
import permission from './modules/permission'
import getters from './getters'

Vue.use(Vuex)

/**
 * vuex持久化函数
 * @param {*}
 */
const handleStore = store => {
  if (localStorage.store) store.replaceState(JSON.parse(localStorage.store))
  store.subscribe((mutation, state) => {
    localStorage.setItem('store', JSON.stringify(state))
  })
}

export default new Vuex.Store({
  modules: {
    app,
    user,
    permission
  },
  state: {
  },
  mutations: {
  },
  actions: {
  },
  getters,
  plugins: [handleStore]
})
