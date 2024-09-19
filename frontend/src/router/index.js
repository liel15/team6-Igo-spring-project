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
  ],
  scrollBehavior(to, from, savedPosition) {
    // 페이지를 이동할 때 항상 맨 위로 스크롤
    if (savedPosition) {
      return savedPosition; // 브라우저의 백 버튼을 눌렀을 때 이전 위치로 돌아가도록 설정
    } else {
      return { top: 0 }; // 페이지 맨 위로 스크롤
    }
  }
})

export default router
