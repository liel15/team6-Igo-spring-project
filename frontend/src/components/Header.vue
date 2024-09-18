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
            />
            <a class="navbar-brand ms-2 fw-bold" style="font-size: 30px" href="#"
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

              <a class="nav-link" href="#">마이페이지</a>

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


const storeLog = useTestStore();
const { startBt } = storeToRefs(storeLog);


</script>