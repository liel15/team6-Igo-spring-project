<template>
  <Header></Header>
  <div class="d-flex flex-column" style="min-height: 100vh;">
    <!-- 메인 레이아웃 시작 -->
    <div class="d-flex flex-row justify-content-between mt-2 ms-4" style="width: 100%; padding: 0;">
      <!-- 프로필 카드 -->
      <div class="card profile-card d-flex justify-content-start align-items-center m-5" style="width: 400px; background: linear-gradient(135deg, #74ebd5 0%, #9face6 100%); ">
        <div class="d-flex flex-column align-items-center mt-5">
          <div class="card profile-details">
            <img :src="getImageUrl" class="card-img-top profile-img" alt="프로필 이미지" />
            <div class="card-body text-center" v-if="userData">
              <p class="card-text user-info">
                <div class="user-info-item">
                <i class="bi bi-person-fill me-2"></i>
                <span><strong>{{ userData.userName }}</strong></span>
                </div>
                <div class="user-info-item">
                <p>아이디: <strong>{{ userData.userId }}</strong></p>
              </div>
              </p>
              <div class="mt-4 keyword-container">
                <div class="d-flex flex-wrap justify-content-center">
                  <p v-for="(value, key) in keywordData" :key="key" class="badge keyword-pill">{{ value }}</p>
                </div>
              </div>
              <div class="fixed-button">
                <button class="btn btn-primary custom-btn mt-3" @click="editProfile">프로필 수정</button>
              </div>
            </div>
          </div>
            <button class="btn btn-primary custom-btn mt-4 mb-1" @click="showCreatePostModal()">+ 글쓰기</button>
        </div>
      </div>

      <!-- 게시글 목록 -->
      <div class="d-flex flex-column w-100 m-2" style="overflow: hidden;">
        <!-- 상단의 옵션 선택 및 검색 -->
        <div class="d-flex justify-content-between align-items-center">
          <!-- 왼쪽 옵션 선택 -->
          <div class="fixed-button ms-4 mt-3">
            <select v-model="selectedOption" class="form-select" @change="filterContent">
              <option value="myPosts">내 글 보기</option>
              <option value="likedPosts">관심 글 보기</option>
            </select>
          </div>

          <!-- 오른쪽 검색 입력 -->
          <div class="d-flex p-3 me-5 mt-3">
            <input class="form-control" v-model="keyword" placeholder="검색어 입력" @keyup.enter="searchMyPost"/>
            <i class="bi bi-search me-5 ms-2 mt-1" style="color: #0077c2; font-size: 18px; cursor: pointer;" @click="searchMyPost"></i>
          </div>
        </div>

        <!-- 게시글 목록 출력 -->
        <div class="main align-items-center w-100">
          <div class="d-flex flex-row align-items-center justify-content-start gap-3 mb-5 mt-4 flex-wrap" style="width: 100%;">
            <div v-for="(post, index) in userpostlist" :key="index" class="card elevate-card" style="cursor: pointer;">
              <img :src="post.img" class="card-img-top" alt="..." @click="getpostid(post.postNo)"/>
              <div class="card-body">
                <p class="card-text post-title">{{ post.postTitle }}</p>
                <i :class="[post.isLiked ? 'bi-heart-fill' : 'bi-heart']" @click="toggleLike(post.postNo)" style="position: absolute; bottom: 10px; right: 10px; font-size: 1.5rem; cursor: pointer;"></i>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>


  

<!-- 글 작성 모달 START -->
  <!--begin::대화상자 - 검사일정수정 -->
  <div
    class="modal fade"
    id="kt_modal_new_target"
    tabindex="-1"
    aria-hidden="true"
  >
    <div class="modal-dialog modal-dialog-centered mw-650px">
      <div class="modal-content rounded">
        <div class="modal-header pb-0 border-0 justify-content-end">
          <!--begin::닫기 아이콘-->
          <div
            class="btn btn-sm btn-icon btn-active-color-primary"
            data-bs-dismiss="modal"
          >
            <i class="ki-duotone ki-cross fs-1">
              <span class="path1"></span>
              <span class="path2"></span>
            </i>
          </div>
          <!--end::닫기 아이콘-->
        </div>

        <div class="modal-body scroll-y px-10 px-lg-15 pt-0 pb-15">
          <form id="kt_modal_new_target_form" class="form" action="#">
            <!--begin::제목-->
            <div class="mb-13 text-center">
              <!--begin::Title-->
              <h1 class="mb-3">글쓰기</h1>
              <!--end::Title-->
              <!--begin::Description-->
              <div class="text-muted fw-semibold fs-5">
                글의 제목, 이미지, 내용을 입력해주세요.
              </div>
              <!--end::Description-->
            </div>
            <!--end::제목-->

            <!--begin::이름 입력상자-->
            <div class="d-flex flex-column mb-8 fv-row">
              <label class="d-flex align-items-center fs-6 fw-semibold mb-2">
                <span class="required">제목</span>
                <span
                  class="ms-1"
                  data-bs-toggle="tooltip"
                  title="제목을 입력하세요. 필수랍니다~"
                >
                  <i class="ki-duotone ki-information-5 text-gray-500 fs-6">
                    <span class="path1"></span>
                    <span class="path2"></span>
                    <span class="path3"></span>
                  </i>
                </span>
              </label>
              <input
                type="text"
                class="form-control form-control-solid"
                name="target_title"
                v-model="titleInput"
              />
            </div>
            <!--end::이름 입력상자-->
            <!-- 이미지 선택 START -->
            <div class="d-flex flex-column mb-8 fv-row">
              <label class="d-flex align-items-center fs-6 fw-semibold mb-2">
                <span class="required">파일 선택</span>
              </label>
              <input
                type="file"
                id="image"
                @change="onFileChange"
                ref="image"
              />
            </div>
            <!-- 이미지 선택 END -->
            <!--begin::내용 입력상자-->
            <div class="d-flex flex-column mb-8 fv-row">
              <label class="d-flex align-items-center fs-6 fw-semibold mb-2">
                <span class="required">내용</span>
                <span
                  class="ms-1"
                  data-bs-toggle="tooltip"
                  title="내용을 입력하세요. 필수랍니다~"
                >
                  <i class="ki-duotone ki-information-5 text-gray-500 fs-6">
                    <span class="path1"></span>
                    <span class="path2"></span>
                    <span class="path3"></span>
                  </i>
                </span>
              </label>
              <textarea
                class="form-control form-control-solid"
                name="target_content"
                v-model="contentInput"
                rows="5"
              ></textarea>
            </div>
            <!--end::내용 입력상자-->
            <!-- start::키워드 선택상자 -->
            <!--begin::키워드-->
            <div class="fv-row mb-8 mt-8">
              <fieldset
                style="
                  border: 1px solid #ccc;
                  padding: 15px;
                  margin-bottom: 20px;
                "
              >
                <!--begin::mbti-->
                <div class="form-group mt-3">
                  <label for="mbti">MBTI</label>
                  <select
                    v-model="mbtiInput"
                    id="mbti"
                    name="mbti"
                    class="form-control"
                    style="cursor: pointer"
                  >
                    <option value="" disabled>선택하기</option>
                    <option value="ISTJ">ISTJ</option>
                    <option value="ISFJ">ISFJ</option>
                    <option value="INFJ">INFJ</option>
                    <option value="INTJ">INTJ</option>
                    <option value="ISTP">ISTP</option>
                    <option value="ISFP">ISFP</option>
                    <option value="INFP">INFP</option>
                    <option value="INTP">INTP</option>
                    <option value="ESTP">ESTP</option>
                    <option value="ESFP">ESFP</option>
                    <option value="ENFP">ENFP</option>
                    <option value="ENTP">ENTP</option>
                    <option value="ESTJ">ESTJ</option>
                    <option value="ESFJ">ESFJ</option>
                    <option value="ENFJ">ENFJ</option>
                    <option value="ENTJ">ENTJ</option>
                  </select>
                </div>
                <!--end::mbti-->

                <div class="form-group mt-3">
                  <label for="category">구분</label>
                  <select
                    v-model="sortInput"
                    id="number"
                    name="number"
                    class="form-control"
                    style="cursor: pointer"
                  >
                    <option value="" disabled>선택하기</option>
                    <option value="개인">개인</option>
                    <option value="단체">단체</option>
                  </select>
                </div>

                <div class="form-group mt-3">
                  <label for="region">선호 지역</label>
                  <select
                    v-model="locationInput"
                    id="location"
                    name="location"
                    class="form-control"
                    style="cursor: pointer"
                  >
                    <option value="" disabled>선택하기</option>
                    <option value="서울특별시">서울특별시</option>
                    <option value="부산광역시">부산광역시</option>
                    <option value="대구광역시">대구광역시</option>
                    <option value="인천광역시">인천광역시</option>
                    <option value="광주광역시">광주광역시</option>
                    <option value="대전광역시">대전광역시</option>
                    <option value="울산광역시">울산광역시</option>
                    <option value="세종특별자치시">세종특별자치시</option>
                    <option value="제주도">제주도</option>
                  </select>
                </div>

                <div class="form-group mt-3">
                  <label for="preference">여행 취향</label>
                  <select
                    v-model="typeInput"
                    id="type"
                    name="type"
                    class="form-control"
                    style="cursor: pointer"
                  >
                    <option value="" disabled>선택하기</option>
                    <option value="익스트림">익스트림</option>
                    <option value="힐링">힐링</option>
                  </select>
                </div>

                <div class="form-group mt-3">
                  <label for="transport">이동수단</label>
                  <select
                    v-model="mobilityInput"
                    id="mobility"
                    name="mobility"
                    class="form-control"
                    style="cursor: pointer"
                  >
                    <option value="" disabled>선택하기</option>
                    <option value="뚜벅이">뚜벅이</option>
                    <option value="차">차</option>
                    <option value="대중교통">대중교통</option>
                  </select>
                </div>

                <div class="form-group mt-3">
                  <label for="accommodation">숙소</label>
                  <select
                    v-model="houseInput"
                    id="house"
                    name="house"
                    class="form-control"
                    style="cursor: pointer"
                  >
                    <option value="" disabled>선택하기</option>
                    <option value="게스트하우스">게스트하우스</option>
                    <option value="호텔">호텔</option>
                    <option value="펜션">펜션</option>
                    <option value="캠핑">캠핑</option>
                  </select>
                </div>
              </fieldset>
            </div>

            <!--end::키워드-->
            <!-- end:: 키워드 선택상자 -->
            <!--begin::하단버튼-->
            <div class="text-center">
              <button
                type="button"
                class="btn btn-primary custom-btn"
                @click="createPost()"
              >
                저장
              </button>
              <button
                type="reset"
                class="btn btn-light ms-3 custom-btn2" style="border-radius: 30px; box-shadow: 0 6px 12px rgba(0, 0, 0, 0.1); font-size: 16px; font-weight: bold; "
                @click="clearAll()"
              >
                모두 지우기
              </button>
            </div>
            <!--end::하단버튼-->
          </form>
          <!--end:Form-->
        </div>
        <!--end::Modal body-->
      </div>
      <!--end::Modal content-->
    </div>
    <!--end::Modal dialog-->
  </div>
  <!--end::대화상자 - 검사일정수정-->
  <!-- 글 작성 모달 END -->

  <Footer></Footer>
</template>

<script setup>

import { reactive , ref, onMounted, computed } from 'vue';
import { useUserPostListStore , usePostLikesListStore, useLikeStore, useSearchMyPostListStore, usePostStore, useLikeCountStore, useLikesListStore } from '@/stores/test'; 
import { insertLike, deleteLikeByNo, insertPostAndKeyword } from '@/api/test';// Pinia store 가져오기
import { storeToRefs } from 'pinia'; // store의 state 참조
import {useRouter} from 'vue-router';
import { Modal } from 'bootstrap';
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

// 로그인한 유저 넘버
let userNo = sessionStorage.getItem("userNo");

// 좋아요 리스트 가져오기
const likesstore = useLikesListStore();
const { likesList } = storeToRefs(likesstore);

let mode = 'no'; // 기본적으로 좋아요를 누르지 않은 상태
let lnum = null; // 해당 글의 좋아요 번호 저장

async function getlikes() {
  await likesstore.fetchLikesList();
  console.log("likesList:", likesList.value);
  console.log("postone:", postone.value);
  likesList.value.forEach((item) => {
    console.log(`Post No: ${item.postNo}, User No: ${item.userNo}`);
    if (postone.value.postNo == item.postNo) {
      console.log('이 글에 좋아요를 눌렀습니다.');
      mode = 'yes'; // 이미 좋아요를 누른 상태로 설정
      lnum = item.likeNo; // 좋아요 번호 저장
    }
  });
}

// 글에 좋아요 관련 함수, 변수
const likestore = useLikeCountStore();
const { likeCount } = storeToRefs(likestore);

async function addLike() {
  await likestore.fetchLikeCount(postone.value.postNo);
  console.log("좋아요 수 : " + likeCount.value);
}

const toggleLike = async (id) => {
  const data = {
    postNo: id,
    userNo: userNo,
  };
  
  if (mode == 'yes') {
    // 이미 좋아요를 눌렀다면, 좋아요 취소
    try {
      await deleteLikeByNo(lnum); // 좋아요 삭제
      console.log("좋아요가 취소되었습니다.");
      alert("좋아요가 취소되었습니다.");
      mode = 'no'; // 상태 변경
      lnum = null; // 좋아요 번호 초기화
      await addLike(); // 좋아요 수 업데이트
      await getlikes(); // 좋아요 리스트 업데이트
    } catch (error) {
      console.error("좋아요 취소에 실패했습니다:", error);
    }
    } else {
    // 좋아요 추가
    try {
      const response = await insertLike(data);
      console.log("서버 응답: ", response);
      alert("좋아요가 추가되었습니다!");
      mode = 'yes'; // 상태 변경
      await addLike(); // 좋아요 수 업데이트
      await getlikes(); // 좋아요 리스트 업데이트
    } catch (error) {
      console.error("좋아요 추가에 실패했습니다:", error);
    }
  }
};

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

// 포스트 번호에따라 포스트 정보 받아오기
const poststore = usePostStore();
const postone = storeToRefs(poststore);
//const result = ref({});

async function getpostid(id) {
  console.log('Clicked post ID:', id);
  //result.value = await getPostByNo(id);
  await poststore.fetchPostone(id);
  console.log('Fetched post data:', postone);
  router.replace({ path: '/page' });
}

//수정
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

// 이미지 주소로 넘기기
const selectedFile = ref(null);

const onFileChange = (event) => {
  selectedFile.value = event.target.files[0];
};

const uploadImage = async () => {
  if (!selectedFile.value) {
    return null; // 이미지가 없으면 null 반환
  }

  const formData = new FormData();
  formData.append('file', selectedFile.value);

  try {
    const response = await axios.post(
      'http://localhost:9000/backend/api/auth/upload',
      formData,
      {
        headers: {
          'Content-Type': 'multipart/form-data',
        },
      }
    );
    return response.data; // 서버에서 반환한 이미지 경로
  } catch (error) {
    console.error('Error uploading image', error);
    return null;
  }
};

// 글작성 모달 열기 함수, 변수
let createPostModal;

function showCreatePostModal() {
  // 대화상자 띄우기
  const elem = document.querySelector('#kt_modal_new_target');
  createPostModal = new Modal(elem);
  createPostModal.show();
}

// 글작성 함수 - create
let titleInput = ref('');
let contentInput = ref('');
let mbtiInput = ref('');
let sortInput = ref('');
let locationInput = ref('');
let typeInput = ref('');
let mobilityInput = ref('');
let houseInput = ref('');

async function createPost() {
  // 이미지 먼저 업로드하고 경로를 받음
  const imagePath = await uploadImage();

  const postData = {
    postTitle: titleInput.value,
    content: contentInput.value,
    userNo: sessionStorage.getItem('userNo'),
    img: imagePath || '', // 이미지 경로가 있으면 넣고 없으면 빈 값
  };

  const keywordData = {
    keywordMbti: mbtiInput.value,
    keywordSort: sortInput.value,
    keywordLocation: locationInput.value,
    keywordType: typeInput.value,
    keywordMobility: mobilityInput.value,
    keywordHouse: houseInput.value,
  };

  console.log('작정자 넘버 : ' + postData.userNo);
  console.log('작성한 글제목 : ' + titleInput.value);
  console.log('전달할 내용 : ' + postData.content);
  console.log('전달할 이미지 경로:', postData.img);
  console.log('전달할 키워드: ' + keywordData.keywordMbti);

  try {
    const response = await insertPostAndKeyword(postData, keywordData);
    console.log('서버 응답: ', response);

    createPostModal.hide();
    router.go(0);
  } catch (error) {
    console.error(error);
  }
}



// 기존 fetchUserPost 함수 대체
// async function fetchUserPost() {
//   // userpostlist.value를 가공해서 displayedPosts에 저장
//   displayedPosts.value = (userpostlist.value || []).map(post => ({
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

// 페이지가 마운트되면 유저 데이터를 불러옴
onMounted(() => {
  loadUserData();
  getlikes();
  init();
});


</script>

<style scoped>
.elevate-card {
  flex-basis: calc(18% - 20px); /* 카드가 한 줄에 5개 나오도록 */
  margin: 10px;
  transition: transform 0.3s ease, box-shadow 0.3s ease; /* 부드러운 전환 효과 */
}

/* 호버 시 떠오르는 효과 */
.elevate-card:hover {
  transform: translateY(-10px); /* 카드가 위로 10px 올라감 */
  box-shadow: 0 10px 15px rgba(0, 0, 0, 0.2); /* 그림자를 추가하여 떠오르는 느낌 강화 */
}

.bi-heart:hover {
  color: gray; /* 기본 하트 색상 */
  transform: scale(1.2);
  transition: color 0.3s ease, transform 0.2s ease;
}

.bi-heart-fill:hover {
  color: red; /* 하트가 채워졌을 때 색상 */
  transform: scale(1.2);
  transition: color 0.3s ease, transform 0.2s ease;
}

.profile-card {
  background-color: #f9f9f9;
  border-radius: 15px;
  padding: 25px;
  box-shadow: 0 12px 24px rgba(0, 0, 0, 0.15);
}

/* 프로필 이미지 */
.profile-img {
  width: 130px;
  height: 130px;
  object-fit: cover;
  border-radius: 50%;
  margin-top: -65px;
  border: 5px solid white;
  box-shadow: 0 8px 15px rgba(0, 0, 0, 0.15);
}

.profile-details {
  background-color: #ffffff;
  border-radius: 15px;
  padding: 25px;
  box-shadow: 0 8px 16px rgba(0, 0, 0, 0.15);
  text-align: center;
  width: 100%;
}

.user-info {
  font-size: 18px;
  color: #333;
  margin: 20px 0;
}

/* 키워드 */
.keyword-container {
  padding: 10px;
}

.keyword-pill {
  font-size: 14px;
  padding: 10px 18px;
  background-color: #e3f2fd;
  color: #1e88e5;
  border-radius: 30px;
  margin: 5px;
  transition: all 0.3s ease;
}

.keyword-pill:hover {
  background-color: #90caf9;
  color: #1565c0;
  transform: scale(1.05);
}

/* 버튼 */
.custom-btn {
  background: linear-gradient(45deg, #42a5f5, #0077c2);
  border: none;
  color: white;
  padding: 14px 30px;
  font-size: 16px;
  font-weight: bold;
  border-radius: 30px;
  transition: all 0.3s ease;
  box-shadow: 0 6px 12px rgba(0, 0, 0, 0.1);
  cursor: pointer;
}

.custom-btn:hover {
  background: linear-gradient(45deg, #0077c2, #42a5f5);
  transform: translateY(-2px);
  box-shadow: 0 10px 20px rgba(0, 0, 0, 0.2);
}

.custom-btn:active {
  transform: translateY(2px);
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

.custom-btn2:hover {
  background: linear-gradient(45deg, #0077c2, #42a5f5);
  transform: translateY(-2px);
  box-shadow: 0 10px 20px rgba(0, 0, 0, 0.2);
}

.custom-btn2:active {
  transform: translateY(2px);
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

.user-info {
  color: #333;
  font-size: 18px; /* 기존 18px에서 24px으로 확대 */
}

.user-info-item {
  margin-bottom: 10px; /* 각 항목 사이의 여백 */
}

.user-info-item i {
  font-size: 24px; /* 아이콘 크기 */
  margin-right: 10px; /* 아이콘과 텍스트 사이 여백 */
  color: #0077c2; /* 아이콘 색상 */
}

.user-info-item strong {
  font-weight: bold;
  color: #1c5485; /* 이름과 아이디 강조 */
}

.post-title {
  font-size: 1.3rem;
  font-weight: bold;
  color: #333;
  transition: color 0.3s ease;
}

.elevate-card:hover .post-title {
  color: #0077c2; /* 호버 시 제목 색상 변경 */
}

.bi-search:hover {
  font-size: 1.7rem; /* 마우스를 올리면 커짐 */
}


</style>