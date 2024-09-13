import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/test',
      name: 'test',
      component: () => import("../views/TestView.vue"),
    },
    {
      path: '/mypage',
      name: 'mypage',
      component: () => import('../views/MypageView.vue')
    },
    {
      path: '/main',
      name: 'main',
      component: () => import("../views/MainView.vue")
    },
    {
      path: '/logined',
      name: 'logined',
      component: () => import("../views/LoginedView.vue")
    },
    {
      path: '/page',
      name: 'page',
      component: () => import("../views/PageView.vue")
    }
  ]
})

export default router
