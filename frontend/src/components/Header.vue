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
            @click="goToMain"
          />
          <a class="navbar-brand ms-2 fw-bold" style="font-size: 30px" @click="goToMain"
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

            <!-- 로그인/로그아웃 버튼 -->
            <button @click="handleAuthButton" class="btn btn-primary ms-2">{{ startBt }}</button>
          </div>
        </div>
      </div>
    </nav>
    <!-- 네비바 -->
  </div>
  <!-- 헤더 끝 -->
</template>

<script setup>
import { ref, onMounted } from "vue";
import { useRouter } from 'vue-router';


const startBt = ref('로그인');
const router = useRouter();


const checkLoginStatus = () => {
  const userData = sessionStorage.getItem("userData");
  if (userData) {
    startBt.value = "로그아웃"; 
  } else {
    startBt.value = "로그인";
  }
};


const handleAuthButton = () => {
  if (startBt.value == "로그인") {
 
    router.push({ path: "/login" });
  } else {
   
    sessionStorage.removeItem("userData", null);
    sessionStorage.removeItem("userNo", null); 
    alert("로그아웃 되었습니다.");
    startBt.value = "로그인"; 
    router.push({ path: "/mainpage" }); 
  }
};


const goToMyPage = () => {
  const userData = sessionStorage.getItem("userData");
  if (!userData) {
    alert("로그인 후 이용 가능합니다.");
    router.push({ path: "/login" });
  } else {
    router.push({ path: "/mypage" });
  }
};

function goToMain() {
  router.push({ path: "/mainpage" });
}

// 페이지가 로드될 때 로그인 상태 확인
onMounted(() => {
  checkLoginStatus();
});

</script>
