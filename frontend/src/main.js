import { createApp } from 'vue'
import { createPinia } from 'pinia'
import 'bootstrap'

import App from './App.vue'
import router from './router'
import 'bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap-icons/font/bootstrap-icons.css';
import axios from 'axios';


// Axios 인터셉터 설정
axios.defaults.withCredentials = true;

axios.interceptors.response.use(
    response => response, 
    error => {
      if (error.response && error.response.status === 401) {
        // 로그인 페이지로 이동
        alert("로그인 후 이용하실 수 있습니다.")
        router.push({ path: '/login' });
      }
      return Promise.reject(error);
    }
  );

const app = createApp(App)

app.use(createPinia())
app.use(router)

app.mount('#app')
