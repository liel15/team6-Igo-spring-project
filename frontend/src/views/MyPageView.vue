<template>

  <Header></Header>
  <div class="d-flex flex-column">
    <!-- 몸시작 -->
    <div class="d-flex flex-row mt-2" style="height: 1300px">
      <!-- 몸 1 : 왼쪽-->
      <div
        class="card d-flex justify-content-start align-items-center m-5"
        style="width: 500px"
      >
        <div class="d-flex flex-column align-items-center mt-5">
          <div class="card" style="width: 23rem; height: auto; margin-bottom: 10px;">
            <img :src="getImageUrl"  class="card-img-top" alt="..." />
            <div class="card-body" v-if="userData">
                <p class="card-text">
                    <p>이름: {{ userData.userName }}</p>
                    <p>아이디: {{ userData.userId }}</p>
                </p>

                <div class="mt-4">
              <div class="d-flex flex-wrap justify-content-start">
                <p
                  v-for="(value, key) in keywordData"
                  :key="key"
                  class="badge rounded-pill text-dark me-2 mb-3"
                  style="
                    font-size: 0.9em;
                    padding: 8px 15px;
                    background-color: #a7e6ff;
                    flex-basis: calc(33.33% - 10px);
                  "
                >
                  {{ value }}
                </p>
              </div>
            </div>

                <div class="fixed-button">
                    <button class="btn btn-primary mt-3" @click="editProfile">프로필 수정</button>
                </div>
            </div>
          </div>
        </div>
      </div>
      <!-- end 몸1 왼쪽 -->

      <div class="d-flex flex-column w-100 m-2" style="overflow: hidden">
        <!-- 상단의 옵션 선택 및 검색 -->
        <div class="d-flex justify-content-between align-items-center">
          <!-- 왼쪽 옵션 선택 -->
          <div class="fixed-button ms-5 mt-3">
            <select
              v-model="selectedOption"
              class="form-select"
              @change="filterContent"
            >
              <option value="myPosts">내 글 보기</option>
              <option value="likedPosts">관심 글 보기</option>
            </select>
          </div>

            <!-- 오른쪽 검색 입력 -->
            <div class="d-flex p-3 me-5 mt-3">
            
            <input class="form-control" v-model="keyword" placeholder="검색어 입력" />
            <i class="bi bi-search ms-2 mt-2" style="cursor: pointer;" @click="searchMyPost"></i>
            </div>
        </div>

        <div class="main align-items-center ms-10">
            <div class="d-flex flex-row align-items-center justify-content-start gap-15 mb-5 mt-4 flex-wrap">
              <div v-for="(post, index) in userpostlist" :key="index" >
              <div class="card elevate-card" style="cursor: pointer; width: 18rem">
                <img :src="'/images/' + post.img" class="card-img-top" alt="..." />
                <div class="card-body">
                <p class="card-text">
                  {{ post.postTitle }}
                </p>
                <i :class="[isLiked ? 'bi-heart-fill' : 'bi-heart']"  @click="toggleLike(post)" style="position: absolute; bottom: 10px; right: 10px; font-size: 1.5rem; cursor: pointer;"></i>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <!-- 몸 끝 -->
    </div>
  </div>

  <Footer></Footer>

  <!-- 몸1 -->
</template>

<script setup>

import { reactive , ref, onMounted, computed } from 'vue';
import { useUserPostListStore , usePostLikesListStore, useLikeStore, useSearchMyPostListStore } from '@/stores/test'; // Pinia store 가져오기
import { storeToRefs } from 'pinia'; // store의 state 참조
import {useRouter} from 'vue-router';
import Header from '@/components/Header.vue';
import Footer from '@/components/Footer.vue';

const searchStore = useSearchMyPostListStore();
const postStore = useUserPostListStore ();
const likesStore = usePostLikesListStore();
const likeStore = useLikeStore();

const { userpostlist } = storeToRefs(postStore);
const { postLikesList } = storeToRefs(likesStore);
const { postInLike } = storeToRefs(likeStore);


const selectedOption = ref('myPosts'); // 기본으로 '내 글 보기'
const displayedPosts = ref([]); // 보여질 게시물 목록
const keyword = ref(''); //검색어

const router = useRouter();

//검색
async function searchMyPost() {
  if (keyword.value.trim()) {
    await searchStore.searchMyPost(keyword.value);  
    userpostlist.value = searchStore.userpostlist;
    console.log("검색된 포스트 목록:", userpostlist.value); 
  } else {
    // 검색어가 없으면 전체 포스트를 다시 불러옴
    await postStore.fetchUserPost();
  }
}


function editProfile() {
  router.push('/edituser');
}

// userData를 담을 ref 변수
const userData = ref({
  userImage:'',
  userName:'',
  userId:''
});



// 세션에서 유저 데이터를 불러오는 함수
const loadUserData = () => {
  const storedUserData = JSON.parse(sessionStorage.getItem('userData'));
  if (storedUserData) {
    userData.value = storedUserData; // 데이터를 ref에 저장
  }
console.log("불러온 값:" , userData.value.userImage);

// 프로필에 이미지 띄우기 (수정된 값 갱신가능)
};
const getImageUrl = computed(() => {
  console.log('userImage:', userData.value.userImage);
  return userData.value.userImage ? `http://localhost:9000/backend/api/auth${userData.value.userImage}` : '/images/user.png';
  
});

//키워드만 가져오는 computed 생성 : 
//computed 속성을 생성하여 필요한 키워드 데이터만 추출. 이 속성은 userData가 변경될 때마다 자동으로 업데이트
const keywordData = computed(() => {
  if (!userData.value) {
    return {}; // userData가 null이면 빈 객체 반환
  }

  return {
    MBTI: userData.value.keywordMbti,
    여행유형: userData.value.keywordSort,
    선호지역: userData.value.keywordLocation,
    여행타입: userData.value.keywordType,
    이동수단: userData.value.keywordMobility,
    숙소유형: userData.value.keywordHouse
  };
});


const init = async() => {
  console.log(userpostlist.value);
  await postStore.fetchUserPost();
  // await fetchUserPost();
  await filterContent();
};



// 기존 fetchUserPost 함수 대체
// async function fetchUserPost() {
//   // postlist.value를 가공해서 displayedPosts에 저장
//   displayedPosts.value = (postlist.value || []).map(post => ({
//     ...post,
//     isLiked: post.isLiked || false, // 기본값 false로 설정
//   }));
// }

// 이후 객체 속성 변경 시 Vue가 이를 감지함
// post.isLiked = !post.isLiked;





// 게시물 목록 필터링
async function filterContent() {
  if (selectedOption.value === 'myPosts') {
    await postStore.fetchUserPost(); // 내 글 목록 가져오기
    displayedPosts.value = userpostlist.value;
  } else if (selectedOption.value === 'likedPosts') {
    await likesStore.fetchLikesPost(); // 좋아요한 글 목록 가져오기
    displayedPosts.value = postLikesList.value;
  }
}

// 좋아요 토글
async function toggleLike(post) {
  const userNo = sessionStorage.getItem('userNo');
  if (!userNo) {
    console.error('userNo is undefined or null');
    return;
  }

  try {
    if (post.isLiked) {
      // 이미 좋아요를 누른 상태라면, 좋아요 취소
      await likeStore.deleteLike(post.postNo);
      post.isLiked = false; // 상태 변경
    } else {
      // 좋아요 추가
      await likeStore.insertLike(post.postNo);
      post.isLiked = true; // 상태 변경
    }
  } catch (err) {
    console.error('Error toggling like:', err);
  }
}

// 게시물 클릭 시 상세페이지로 이동
// async function getPostId(id) {
//   console.log("Clicked post ID:", id);
//   router.replace({ path: '/page', query: { postNo: id } });
// }


// 페이지가 마운트되면 유저 데이터를 불러옴
onMounted(() => {
  loadUserData();
  init();
});


</script>

<style scoped>
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
