<template>
  <div class="d-flex flex-column">
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
              <a class="nav-link" href="#">마이페이지</a>
              <span>{{ name }}</span>
            </div>
          </div>
        </div>
      </nav>
      <!-- 네비바 -->
    </div>
    <!-- 헤더 끝 -->

    <!-- 몸시작 -->
    <div class="d-flex flex-row mt-2" style="height: 1300px">
      <!-- 몸 1 : 왼쪽-->
      <div class="card d-flex justify-content-start align-items-center m-5" style="width: 500px;">

        <div class="d-flex flex-column align-items-center mt-5">
          <div class="card" style="width: 18rem; height: auto; margin-bottom: 10px;">
            <img src="https://gongu.copyright.or.kr/gongu/wrt/cmmn/wrtFileImageView.do?wrtSn=9046601&filePath=L2Rpc2sxL25ld2RhdGEvMjAxNC8yMS9DTFM2L2FzYWRhbFBob3RvXzI0MTRfMjAxNDA0MTY=&thumbAt=Y&thumbSe=b_tbumb&wrtTy=10004" class="card-img-top" alt="..." />
            <div class="card-body">
                <p class="card-text">
                    <p>닉네임</p>
                    <p>아이디</p>
                </p>
                <div class="fixed-button">
                    <button class="btn btn-primary">수정</button>
                </div>
            </div>
          </div>
        </div>

        

      </div>
      <!-- end 몸1 왼쪽 -->

      <div class="d-flex flex-column w-100 m-2" style="overflow: hidden;">
      
        <!-- 상단의 옵션 선택 및 검색 -->
        <div class="d-flex justify-content-between align-items-center">
            <!-- 왼쪽 옵션 선택 -->
            <div class="fixed-button ms-5 mt-3">
              <select v-model="selectedOption" class="form-select" @change="filterContent">
                <option value="myPosts">내 글 보기</option>
                <option value="likedPosts">관심 글 보기</option>
              </select>
            </div>

            <!-- 오른쪽 검색 입력 -->
            <div class="d-flex p-3 me-5 mt-3">
            
            <input class="form-control" placeholder="검색어 입력" />
            <i type="submit" class="bi bi-search ms-2 mt-1" ></i>
            </div>
        </div>

        <div class="main align-items-center">
            <div class="d-flex flex-row align-items-center justify-content-center gap-5 mb-5 mt-4">
              <div v-for="(card, index) in cards" :key="index" >
              <div v-if="showCard(card)" class="card elevate-card" style="width: 18rem">
                <img :src="'/assets/images/' + card.img" class="card-img-top" alt="..." />
                <div class="card-body">
                <p class="card-text">
                  {{ card.content }}
                </p>
                <i class="bi":class="[card.isLiked ? 'bi-heart-fill' : 'bi-heart']" @click="toggleLike(card)" style="position: absolute; bottom: 10px; right: 10px; font-size: 1.5rem; cursor: pointer;"></i>
                </div>
              </div>
            </div>

            </div>

            <div class="d-flex flex-row align-items-center justify-content-center gap-5 mb-5 mt-2">
            <div class="card elevate-card" style="width: 18rem">
                <img src="../assets/images/1.PNG" class="card-img-top" alt="..." />
                <div class="card-body">
                <p class="card-text">
                    Some quick example text to build on the card title and make up the bulk of
                    the card's content.
                </p>
                <i class="bi":class="[isHeartFilled ? 'bi-heart-fill' : 'bi-heart']" @click="toggleHeart" style="position: absolute; bottom: 10px; right: 10px; font-size: 1.5rem; cursor: pointer;"></i>
                </div>
            </div>

            </div>

            <div class="d-flex flex-row align-items-center justify-content-center gap-5 mb-5 mt-2">
            <div class="card elevate-card" style="width: 18rem">
                <img src="https://gongu.copyright.or.kr/gongu/wrt/cmmn/wrtFileImageView.do?wrtSn=9046601&filePath=L2Rpc2sxL25ld2RhdGEvMjAxNC8yMS9DTFM2L2FzYWRhbFBob3RvXzI0MTRfMjAxNDA0MTY=&thumbAt=Y&thumbSe=b_tbumb&wrtTy=10004" class="card-img-top" alt="..." />
                <div class="card-body">
                <p class="card-text">
                    Some quick example text to build on the card title and make up the bulk of
                    the card's content.
                </p>
                <i class="bi":class="[isHeartFilled ? 'bi-heart-fill' : 'bi-heart']" @click="toggleHeart" style="position: absolute; bottom: 10px; right: 10px; font-size: 1.5rem; cursor: pointer;"></i>
                </div>
            </div>
            </div>

        </div>

      </div>
      <!-- 몸 끝 -->
    </div>
  </div>

  <!-- 몸1 -->
</template>

<script setup>

import { ref } from 'vue';

const selectedOption = ref('myPosts'); // 기본으로 '내 글 보기'

// 카드 데이터
const cards = ref([
  {
    img: '1.PNG',
    content: '내 첫 번째 글입니다.',
    isLiked: false, // 좋아요 여부
    isMyPost: true, // 내 글 여부
  },
  {
    img: '2.PNG',
    content: '내 두 번째 글입니다.',
    isLiked: true, // 좋아요 여부
    isMyPost: true, // 내 글 여부
  },
  {
    img: '3.PNG',
    content: '다른 사용자의 글입니다.',
    isLiked: true, // 좋아요 여부
    isMyPost: false, // 내 글 여부
  },
]);

// 카드 목록 필터링 로직을 메서드로 정의
const showCard = (card) => {
  console.log(card);
  if (selectedOption.value === 'myPosts') {
    return card.isMyPost; // 내 글만 표시
  } else if (selectedOption.value === 'likedPosts') {
    return card.isLiked; // 좋아요한 글만 표시
  }
  return true; // 기본적으로 모든 카드 표시
};

// 좋아요(하트) 토글 함수
const toggleLike = (card) => {
  card.isLiked = !card.isLiked;
};





//  // 반응형 변수 선언 (isHeartFilled는 하트가 채워졌는지 여부를 저장)
//  const isHeartFilled = ref(false);

//  // 하트를 클릭했을 때 상태를 토글하는 함수
//  function toggleHeart() {
//    isHeartFilled.value = !isHeartFilled.value;
//  }

</script>

<style scoped>

.main {
  cursor: pointer;
}

.elevate-card {
  transition: transform 0.3s ease, box-shadow 0.3s ease; /* 부드러운 전환 효과 */
}

/* 호버 시 떠오르는 효과 */
.elevate-card:hover {
  transform: translateY(-10px); /* 카드가 위로 10px 올라감 */
  box-shadow: 0 10px 15px rgba(0, 0, 0, 0.2); /* 그림자를 추가하여 떠오르는 느낌 강화 */
}

.bi-heart {
  color: gray; /* 기본 하트 색상 */
}

.bi-heart-fill {
  color: red; /* 하트가 채워졌을 때 색상 */
}

</style>
