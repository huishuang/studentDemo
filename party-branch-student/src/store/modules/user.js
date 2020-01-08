const user = {
  state: {
    login: false,
    name: '',
    avatar: '/avatar2.jpg'
  },

  mutations: {
    SET_LOGIN: (state, login) => {
      state.login = login
    },
    SET_NAME: (state, name) => {
      state.name = name
    }
  },

  actions: {
    // 登录
    Login ({ commit }, data) {
      var userId = data.userId
      var password = data.password
      if (userId === 'admin' && password === '123456') {
        commit('SET_LOGIN', true)
        commit('SET_NAME', userId)
      }
    },
    // 登出
    Logout ({ commit }) {
      commit('SET_LOGIN', false)
      commit('SET_NAME', '')
    }

  }
}

export default user
