import router from './router'
import store from './store'

import NProgress from 'nprogress'
import 'nprogress/nprogress.css'
import { setDocumentTitle, domTitle } from '@/utils/domUtil'

NProgress.configure({ showSpinner: false })

router.beforeEach((to, from, next) => {
  const whiteList = store.getters.whiteList
  const userList = store.getters.roleList
  const isLogin = store.getters.isLogin
  NProgress.start()
  to.meta && (typeof to.meta.title !== 'undefined' && setDocumentTitle(`${to.meta.title} - ${domTitle}`))
  if (isLogin) {
    if (userList.includes(to.name) || whiteList.includes(to.name)) {
      next()
    } else {
      next({ path: from.path, query: { redirect: to.fullPath } })
      NProgress.done()
    }
  } else {
    if (whiteList.includes(to.name)) {
      next()
    } else {
      next({ path: from.path, query: { redirect: to.fullPath } })
      NProgress.done()
    }
  }
})

router.afterEach(() => {
  NProgress.done()
})
