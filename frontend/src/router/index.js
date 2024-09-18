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
      path: '/logined',
      name: 'logined',
      component: () => import("../views/LoginedView.vue")
    },
    {
      path: '/page',
      name: 'page',
      component: () => import("../views/PageView.vue")
    },
    {
      path: '/mainpage',
      name: 'mainpage',
      component: () => import("../views/MainPageView.vue")
    },
    {
      path: '/signup',
      name: 'signup',
      component: () => import("../views/SignUpView.vue")
    },
    {
      path: '/login',
      name: 'login',
      component: () => import("../views/LoginTestView.vue")
    },
    {
      path: '/about',
      name: 'about',
      component: () => import("../views/AboutView.vue")
    },
    {
      path: '/findpassword',
      name: 'findpassword',
      component: () => import("../views/FindPasswordView.vue")
    },
    {
      path: '/findid',
      name: 'findid',
      component: () => import("../views/FindIdView.vue")
    },
    {
      path: '/edituser',
      name: 'edituser',
      component: () => import("../views/EditUserView.vue")
    }
  ]
})

export default router
