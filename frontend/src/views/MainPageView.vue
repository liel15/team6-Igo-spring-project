<template>
  <div class="d-flex flex-column" style="background-color: #f6f6f6">
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
            <a
              class="navbar-brand ms-2 fw-bold"
              style="font-size: 30px"
              href="#"
              @click="goToMain()"
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

              <button @click="log()" class="btn btn-primary ms-2">
                {{ startBt }}
              </button>
            </div>
          </div>
        </div>
      </nav>
      <!-- 네비바 -->
    </div>
    <!-- 헤더 끝 -->
    <!-- 헤더 끝 -->

    <!-- 몸 1-->
    <div class="d-flex flex-row mt-5" style="height: 400px">
      <div
        v-if="startBt == '로그인'"
        class="card shadow d-flex justify-content-center align-items-start m-2 ms-3"
        style="width: 900px"
      >
        <div class="ms-2 p-5">
          <h1 class="fw-bold">여행을 계획할 땐, I GO!</h1>
          <span>막막했던 여행? I,Go와 함께 가요!</span>
        </div>
      </div>

      <div
        v-if="startBt == '로그아웃'"
        class="card shadow d-flex justify-content-center align-items-start m-2 ms-3"
        style="width: 900px"
      >
        <div class="d-flex flex-row ms-2 p-5 w-100">
          <div
            class="rounded-circle overflow-hidden shadow"
            style="width: 200px; height: 200px"
          >
            <img
              src="https://dcimg1.dcinside.com/viewimage.php?id=23b2de21e1d335a161b2&no=24b0d769e1d32ca73dea81fa11d028311869dac7d33bec80aa651ee0dd05d26f31aa190ab157783060f4f76fa59e2635ad3463abbc4bac0bc7f0edc4feada421976851ef383b38252aebfd5a9ef121e854"
              class="w-100 h-100"
            />
          </div>

          <div
            class="d-flex flex-column justify-content-center align-items-start flex-grow-1 ms-4"
          >
            <h2 class="fw-bold">{{ user.name }}님!</h2>
            <p style="font-size: 12px; color: gray">{{ user.Id }}</p>
            <div class="d-flex align-items-center mt-2">
              <p class="me-2 mb-0">나의 여행:</p>
              <p class="mb-0">{{ user.post }} 개</p>
            </div>

            <div class="mt-4">
              <div class="d-flex flex-wrap">
                <p
                  v-for="(value, key) in type"
                  :key="type.id"
                  class="badge rounded-pill text-dark me-2 mb-2"
                  style="
                    font-size: 0.9em;
                    padding: 8px 15px;
                    background-color: #a7e6ff;
                  "
                >
                  {{ value }}
                </p>
              </div>
            </div>

            <button
              @click=""
              class="btn mt-3"
              style="background-color: #3572ef; color: white"
            >
              마이페이지
            </button>
          </div>
        </div>
      </div>

      <!-- 상단 몸 -->
      <div
        class="card shadow overflow-hidden d-flex w-100 m-2 me-3 position-relative"
        style="height: 385px"
      >
        <div id="carouselExample" class="carousel slide h-100">
          <div class="carousel-inner h-100">
            <!-- 캐러셀 아이템 1 -->
            <div class="carousel-item active h-100">
              <div class="d-flex align-items-center h-100">
                <div
                  class="d-flex justify-content-center align-items-center"
                  style="width: 50%"
                >
                  <img
                    src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQoHwq6780xdecD9iX6N6PQyg-5Te_ZNF2RNQ&s"
                    class="d-block"
                    style="max-width: 80%; max-height: 80%; object-fit: contain"
                    alt="..."
                  />
                </div>
                <div
                  class="d-flex flex-column justify-content-center"
                  style="width: 70%"
                >
                  <h3 class="fw-bold">여행 계획도 I GO!</h3>
                  <p class="mt-3">
                    여행할 지역을 선택해 지도와 함께 계획을 할 수 있어요
                  </p>
                </div>
              </div>
            </div>

            <!-- 캐러셀 아이템 2 (새로 추가된 아이템) -->
            <div class="carousel-item h-100">
              <div class="d-flex align-items-center h-100">
                <div
                  class="d-flex justify-content-center align-items-center"
                  style="width: 50%"
                >
                  <img
                    src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQoHwq6780xdecD9iX6N6PQyg-5Te_ZNF2RNQ&s"
                    class="d-block"
                    style="max-width: 80%; max-height: 80%; object-fit: contain"
                    alt="..."
                  />
                </div>
                <div
                  class="d-flex flex-column justify-content-center"
                  style="width: 70%"
                >
                  <h3 class="fw-bold">여행 기록도 I GO!</h3>
                  <p class="mt-3">
                    여행할 지역을 선택해 지도와 함께 계획을 할 수 있어요
                  </p>
                </div>
              </div>
            </div>

            <!-- 캐러셀 아이템 3 -->
            <div class="carousel-item h-100">
              <div class="d-flex align-items-center h-100">
                <div
                  class="d-flex justify-content-center align-items-center"
                  style="width: 50%"
                >
                  <img
                    src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQoHwq6780xdecD9iX6N6PQyg-5Te_ZNF2RNQ&s"
                    class="d-block"
                    style="max-width: 80%; max-height: 80%; object-fit: contain"
                    alt="..."
                  />
                </div>
                <div
                  class="d-flex flex-column justify-content-center"
                  style="width: 70%"
                >
                  <h3 class="fw-bold">여행 참고도 I Go!</h3>
                  <p class="mt-3">
                    여행할 지역을 선택해 지도와 함께 계획을 할 수 있어요
                  </p>
                </div>
              </div>
            </div>
          </div>

          <!-- 캐러셀 컨트롤 버튼 -->
          <button
            class="carousel-control-prev"
            type="button"
            data-bs-target="#carouselExample"
            data-bs-slide="prev"
            style="width: 5%"
          >
            <span
              class="carousel-control-prev-icon"
              aria-hidden="true"
              style="
                filter: invert(25%) sepia(0%) saturate(0%) hue-rotate(0deg)
                  brightness(100%) contrast(100%);
              "
            ></span>
            <span class="visually-hidden">Previous</span>
          </button>
          <button
            class="carousel-control-next"
            type="button"
            data-bs-target="#carouselExample"
            data-bs-slide="next"
            style="width: 5%"
          >
            <span
              class="carousel-control-next-icon"
              aria-hidden="true"
              style="
                filter: invert(25%) sepia(0%) saturate(0%) hue-rotate(0deg)
                  brightness(100%) contrast(100%);
              "
            ></span>
            <span class="visually-hidden">Next</span>
          </button>
        </div>
      </div>
      <!-- 상단 몸2 -->
    </div>
    <!-- 몸1 -->

    <!-- 몸2 : 영상 -->
    <div
      class="d-flex justify-content-center align-items-center mt-2 overflow-hidden"
      style="height: 600px"
    >
      <iframe
        width="1800"
        height="600"
        src="https://www.youtube.com/embed/pYzX7cqK_JQ&t=29s?autoplay=1&mute=1&loop=1&playlist=pYzX7cqK_JQ&t=29s"
        showinfo="0"
        controls="0"
        frameborder="0"
        allowfullscreen
        allow="autoplay"
      ></iframe>
    </div>
    <!-- 몸2영상 -->

    <div
      class="d-flex flex-column align-items-center mt-5"
      style="height: 1200px"
      id="serch"
    >
      <h1 class="mt-4 mb-5 fw-bold">어디로 여행을 떠나볼까요?</h1>
      <div class="mt-3 mb-4 d-flex" style="width: 800px; height: 50px">
        <input
          class="form-control shadow"
          type="search"
          placeholder="원하시는 여행지를 검색해보세요."
        />
        <i type="submit" class="bi bi-search ms-3" style="font-size: 30px"></i>
      </div>

      <!-- v-for로 처리할 것 -->
      <div class="container mt-5">
        <div class="row">
          <div class="col-3" v-for="(card, index) in postlist" :key="index">
            <div
              class="card mb-3 mt-3"
              style="width: 18rem; height: 240px"
              @click="getpostid(card.postNo)"
            >
              <img
                :src="card.img"
                class="card-img-top"
                alt="..."
                style="width: 18rem; height: 140px"
              />
              <div class="card-body">
                <a class="text-gray-700 fw-bold"
                  >{{ card.userId }} - {{ card.postNo }}</a
                >
                <p class="card-text">{{ card.postTitle }}</p>
                <i
                  class="bi"
                  :class="[isHeartFilled ? 'bi-heart-fill' : 'bi-heart']"
                  @click="toggleHeart"
                  style="
                    position: absolute;
                    bottom: 10px;
                    right: 10px;
                    font-size: 1.5rem;
                    cursor: pointer;
                  "
                ></i>
              </div>
            </div>
          </div>
        </div>
      </div>
      <!-- v-for END -->
      <div>
        <button @click="checkLoginStatus" class="btn btn-primary fs-6 p-2">
          글쓰기
        </button>
      </div>
    </div>

    <div
      class="footer d-flex flex-column justify-content-center align-items-star mt-5"
      style="background-color: #eaeaea; height: 150px; color: gray"
    >
      <div class="container">
        <p class="mb-1">Igo 사업자 정보</p>
        <p class="mb-1 mt-3" style="font-size: 12px">팀 6조 | 대표 김세훈</p>
        <p class="mb-1" style="font-size: 12px">이규태 박정은 최수환 함지수</p>
        <p class="mb-1" style="font-size: 12px">
          서울특별시 강남구 언주로 603 LX공간정보아카데미
        </p>
        <p class="mb-1" style="font-size: 12px">끝나고 여행가요~</p>
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
                class="btn btn-primary"
                @click="createPost()"
              >
                저장
              </button>
              <button
                type="reset"
                class="btn btn-light ms-3"
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
</template>

<script setup>
import { ref, onMounted } from 'vue';
import { usePostListStore, usePostStore } from '@/stores/test';
import { storeToRefs } from 'pinia';
import { useRouter } from 'vue-router'; // 이미 useRouter로 가져옴
import { insertPost, insertPostAndKeyword } from '@/api/test';
import { Modal } from 'bootstrap';
import axios from 'axios';

// useRouter 선언
const router = useRouter();

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

// db에서 posts들 데이터 가져오기
onMounted(() => {
  init();
});

// 스토어 가져와서 리스트 받아오기
const store = usePostListStore();
async function init() {
  store.fetchPost();
}
const { postlist } = storeToRefs(store);

// 포스트 번호에따라 포스트 정보 받아오기
const poststore = usePostStore();
const postone = storeToRefs(poststore);

async function getpostid(id) {
  console.log('Clicked post ID:', id);
  await poststore.fetchPostone(id);
  console.log('Fetched post data:', postone);
  router.replace({ path: '/page' });
}

// 로그인 상태를 확인하는 함수
const checkLoginStatus = () => {
  const userData = sessionStorage.getItem("userData");

  if (!userData) {
    // 로그인 되어 있지 않은 경우
    alert("로그인 후 이용 가능합니다.");
    router.push({ path: "/login" }); // 로그인 페이지로 이동
  } else {
    // 로그인 되어 있는 경우 글쓰기 모달을 띄움
    showCreatePostModal();
  }
};

// 글쓰기 모달 열기 함수, 변수
let createPostModal;

function showCreatePostModal() {
  const elem = document.querySelector('#kt_modal_new_target');
  createPostModal = new Modal(elem);
  createPostModal.show();
}

// 글쓰기 함수 - create
let titleInput = ref('');
let contentInput = ref('');
let mbtiInput = ref('');
let sortInput = ref('');
let locationInput = ref('');
let typeInput = ref('');
let mobilityInput = ref('');
let houseInput = ref('');

async function createPost() {
  const imagePath = await uploadImage();

  const postData = {
    postTitle: titleInput.value,
    content: contentInput.value,
    userNo: sessionStorage.getItem('userNo'),
    img: imagePath || '',
  };

  const keywordData = {
    keywordMbti: mbtiInput.value,
    keywordSort: sortInput.value,
    keywordLocation: locationInput.value,
    keywordType: typeInput.value,
    keywordMobility: mobilityInput.value,
    keywordHouse: houseInput.value,
  };

  try {
    const response = await insertPostAndKeyword(postData, keywordData);
    console.log('서버 응답: ', response);

    createPostModal.hide();
    router.go(0);
  } catch (error) {
    console.error(error);
  }
}

const isHeartFilled = ref(false);

const startBt = ref('로그인'); //초기값

function log() {
  if (startBt.value == '로그인') {
    startBt.value = '로그아웃';
  } else {
    startBt.value = '로그인';
  }
}

function toggleHeart() {
  isHeartFilled.value = !isHeartFilled.value;
}

function goToMain() {
  router.push({ path: "/mainpage" });
}
</script>


<style scoped>
.bi-heart {
  color: gray;
  /* 기본 하트 색상 */
}

.bi-heart-fill {
  color: red;
  /* 하트가 채워졌을 때 색상 */
}
</style>
