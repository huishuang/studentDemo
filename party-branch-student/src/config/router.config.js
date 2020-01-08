// eslint-disable-next-line
import { UserLayout, BasicLayout, RouteView, BlankLayout, PageView } from '@/layouts'
/**
 * 基础路由
 * @type { *[] }
 */
export const constantRouterMap = [
  {
    path: '/',
    name: 'Login',
    component: () => import('@/views/login'),
    meta: {
      title: '登录',
      requireLogin: true
    }
  },
  {
    path: '/back',
    name: 'Back',
    component: BasicLayout,
    redirect: '/back/mainboard',
    children: [
      {
        path: 'mainboard',
        name: 'BackMainBoard',
        component: () => import('@/views/back/mainboard'),
        meta: { title: '新生报到', icon: 'user'}
      }
    ]
  }
]
