<template>
  <div class="d-flex flex-column">

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
                    <button class="btn btn-primary" @click="editPost(post.postNo)">수정</button>
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
            <i type="submit" class="bi bi-search ms-2 mt-4" ></i>
            </div>
        </div>

        <div class="main align-items-center ms-10">
            <div class="d-flex flex-row align-items-center justify-content-start gap-15 mb-5 mt-4 flex-wrap">
              <div v-for="(post, index) in postlist" :key="index" >
              <div class="card elevate-card" style="cursor: pointer; width: 18rem">
                <img :src="'/images/' + post.img" class="card-img-top" alt="..." />
                <div class="card-body">
                <p class="card-text">
                  {{ post.postTitle }}
                </p>
                <i :class="{'bi-heart-fill': post.isLiked, 'bi-heart': !post.isLiked}"  @click="toggleLike(post)" style="position: absolute; bottom: 10px; right: 10px; font-size: 1.5rem; cursor: pointer;"></i>
                </div>
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

import { reactive , ref, onMounted } from 'vue';
import { usePostListStore, usePostLikesListStore, useLikeStore } from '@/stores/test'; // Pinia store 가져오기
import { storeToRefs } from 'pinia'; // store의 state 참조

const postStore = usePostListStore();
const likesStore = usePostLikesListStore();
const likeStore = useLikeStore();

const { postlist } = storeToRefs(postStore);
const { postLikesList } = storeToRefs(likesStore); // Pinia 스토어의 posts 참조

const selectedOption = ref('myPosts'); // 기본으로 '내 글 보기'
const displayedPosts = ref([]); // 보여질 게시물 목록



// 기존 fetchPost 함수 대체
async function fetchPost() {
  // postlist.value를 가공해서 displayedPosts에 저장
  displayedPosts.value = (postlist.value || []).map(post => ({
    ...post,
    isLiked: post.isLiked || false, // 기본값 false로 설정
  }));
}

const post = reactive({
  postTitle: '제목',
  isLiked: false,
});

// 이후 객체 속성 변경 시 Vue가 이를 감지함
post.isLiked = !post.isLiked;


const init = async() => {
  console.log(postlist.value);
  await postStore.fetchPost();
  // await fetchPost();
  await filterContent();
}


// db에서 posts들 데이터 가져오기
onMounted(() => {
  sessionStorage.setItem('userNo', 1);  // 가라로 userNo를 세팅
  init();
});

// 카드 목록 필터링 로직을 메서드로 정의
// const showPost = (post) => {
//   if (selectedOption.value === 'myPosts') {
//     return post.isMyPost; // 내 글만 표시
//   } else if (selectedOption.value === 'likedPosts') {
//     return post.isLiked; // 좋아요한 글만 표시
//   }
//   return true; // 기본적으로 모든 카드 표시
// };

// // 좋아요(하트) 토글 함수
// const toggleLike = (post) => {
//   post.isLiked = !post.isLiked;
// };

// 게시물 목록 필터링
async function filterContent() {
  if (selectedOption.value === 'myPosts') {
    await postStore.fetchPost(); // 내 글 목록 가져오기
    displayedPosts.value = postlist.value;
  } else if (selectedOption.value === 'likedPosts') {
    await likesStore.fetchLikesPost(); // 좋아요한 글 목록 가져오기
    displayedPosts.value = likesStore.postLikesList.value;
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
    await likeStore.toggleLike(post);
    post.isLiked = !post.isLiked; // isLiked 상태를 토글
    console.log("After toggle, isLiked:", post.isLiked);
  } catch (err) {
    console.error('Error toggling like:', err);
  }
}


// 게시물 클릭 시 상세페이지로 이동
// async function getPostId(id) {
//   console.log("Clicked post ID:", id);
//   router.replace({ path: '/page', query: { postNo: id } });
// }



// async function init () {
//   store.fetchPost();
//   console.log(postlist);
// }


// const postList = ref(false);
// const newPost = ref({
//   postTitle: '',

// });



// 카드 데이터
// const posts = ref([
//   {
//     img: '1.PNG',
//     content: '내 첫 번째 글입니다.',
//     isLiked: false, // 좋아요 여부
//     isMyPost: true, // 내 글 여부
//   },
//   {
//     img: '2.PNG',
//     content: '내 두 번째 글입니다.',
//     isLiked: true, // 좋아요 여부
//     isMyPost: true, // 내 글 여부
//   },
//   {
//     img: '3.PNG',
//     content: '다른 사용자의 글입니다.',
//     isLiked: true, // 좋아요 여부
//     isMyPost: false, // 내 글 여부
//   },
// ]);






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
