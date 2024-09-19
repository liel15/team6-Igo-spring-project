<template>

 <!-- 헤더 시작 -->
 <div class="header" style="height: 8vh; background-color: #3abef9">
      <!-- 네비바 -->
      <nav class="navbar navbar-expand-lg navbar-dark w-100 h-100">
        <div class="container-fluid">
          <div class="d-flex align-items-center">
            <img
              width="50"
              height="50"
              src="https://img.icons8.com/stickers/50/airplane-take-off.png"
              alt="airplane-take-off"
              @click="goToMain()"
            />
            <a class="navbar-brand ms-2 fw-bold" style="font-size: 30px" @click="goToMain()"
              >I.GO!</a
            >
          </div>
          <button
            class="navbar-toggler"
            type="button"
            data-bs-toggle="collapse"
            data-bs-target="#navbarNavAltMarkup"
            aria-controls="navbarNavAltMarkup"
            aria-expanded="false"
            aria-label="Toggle navigation"
          >
            <span class="navbar-toggler-icon"></span>
          </button>

          <div
            class="collapse navbar-collapse justify-content-end"
            id="navbarNavAltMarkup"
          >
            <div class="navbar-nav justify-content-center align-items-center">
              <a class="nav-link" href="#serch">여행지</a>

              <a class="nav-link" href="#">계획 등록</a>

              <a class="nav-link" @click="goToMyPage">마이페이지</a>

              <button @click="storeLog.log()" class="btn btn-primary ms-2">{{ startBt }}</button>
            </div>
          </div>
        </div>
      </nav>
      <!-- 네비바 -->
    </div>
    <!-- 헤더 끝 -->


</template>

<script setup>

import { ref } from "vue";
import { useTestStore } from "@/stores/user";
import { storeToRefs } from "pinia";
import router from '@/router/index.js';

const storeLog = useTestStore();
const { startBt } = storeToRefs(storeLog);


// 로그인 상태를 확인하는 함수
const goToMyPage = () => {
  const userData = sessionStorage.getItem("userData");

  if (!userData) {
    // 로그인 되어 있지 않은 경우
    alert("로그인 후 이용 가능합니다.");
    router.push({ path: "/login" }); // 로그인 페이지로 이동
  } else {
    // 로그인 되어 있는 경우 글쓰기 모달을 띄움
    router.push({ path: "/mypage" });
  }
};


function goToMain() {
  router.push({ path: "/mainpage" });
}

</script>