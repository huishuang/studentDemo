const getters = {
  device: state => state.app.device,
  theme: state => state.app.theme,
  color: state => state.app.color,
  avatar: state => state.user.avatar,
  nickname: state => state.user.name,
  welcome: state => state.user.welcome,
  addRouters: state => state.permission.addRouters,
  multiTab: state => state.app.multiTab,
  whiteList: state => state.permission.baseList,
  roleList: state => state.permission.roleList,
  role: state => state.user.role,
  isLogin: state => state.user.login
}

export default getters
