<template>

  <Header></Header>
  <div class="d-flex flex-column">
   

    <!-- 블로그 포스트 형식 가져온거 START -->
    <!--begin::Content-->
    <div id="kt_app_content" class="app-content flex-column-fluid m-4">
      <!--begin::Content container-->
      <div id="kt_app_content_container" class="app-container container-xxl">
        <!--begin::Post card-->
        <div class="card">
          <!--begin::Body-->
          <div class="card-body p-lg-20 pb-lg-0">
            <!--begin::Layout-->
            <div class="d-flex flex-column flex-xl-row">
              <!--begin::Content-->
              <div class="flex-lg-row-fluid me-xl-15">
                <!--begin::Post content-->
                <div class="mb-17">
                  <!--begin::Wrapper-->
                  <div class="mb-8">
                    <!--begin::Info-->
                    <div class="d-flex flex-wrap mb-2">
                      <!--begin::Item-->
                      <div>
                        <button class="styled-button" @click="goToMainPage()">뒤로가기</button></br>
                        <!--begin::Label-->
                        <span v-if="postkeyword.keywordMbti != null" class="fw-bold text-gray-500 fs-4"> #{{ postkeyword.keywordMbti }}</span>
                        <span class="fw-bold text-gray-500 fs-4"> #{{ postkeyword.keywordSort }}</span>
                        <span class="fw-bold text-gray-500 fs-4"> #{{ postkeyword.keywordLocation }}</span>
                        <span class="fw-bold text-gray-500 fs-4"> #{{ postkeyword.keywordType }}</span>
                        <span class="fw-bold text-gray-500 fs-4"> #{{ postkeyword.keywordMobility }}</span>
                        <span class="fw-bold text-gray-500 fs-4"> #{{ postkeyword.keywordHouse }}</span>
                        <!--end::Label-->
                      </div>
                      <!--end::Item-->
                    </div>
                    <!--end::Info-->
                    <!--begin::Title-->
                    <span class="fw-bold text-muted fs-5 ps-1 me-4">글 넘버 : {{ postone.postNo }} 작성자 넘버 : {{
                      postone.userNo }} 작성자 아이디 : {{ postone.userId }}</span>
                    <span class="text-gray-900 fs-1 fw-bold">{{ postone.postTitle }}</span>
                    <!--end::Title-->
                    <!--begin::Container-->
                    <div class="overlay mt-8">
                      <!--begin::Image-->
                      <div class="bgi-no-repeat bgi-position-center bgi-size-contain card-rounded min-h-400px"
                        :style="{ backgroundImage: 'url(' + postone.img + ')', backgroundRepeat: 'no-repeat', width: '100%', height: 'auto' }">
                      </div>
                      <!--end::Image-->
                      <!--begin::Links-->
                      <div class="overlay-layer card-rounded bg-dark bg-opacity-25">
                        <a @click="goHome()" class="btn btn-primary">홈으로</a>
                        <a href="pages/careers/apply.html" class="btn btn-light-primary ms-3">일정보기</a>
                      </div>
                      <!--end::Links-->
                    </div>
                    <!--end::Container-->
                  </div>
                  <!--end::Wrapper-->
                  <!--begin::Description-->
                  <div class="fs-5 fw-semibold text-gray-600">
                    <!--begin::Text-->
                    <p class="mb-8">{{ postone.content }}</p>
                    <!--end::Text-->
                  </div>
                  <!--end::Description-->
                  <div class="d-flex flex-center">
                    <button type="button" @click="clickLike(postone.postNo)" style="background-color: #0dcaf0; color: white;" class="btn fs-4 p-2 me-2 d-flex align-items-center">
                      <i style="color: white; font-size: 20px;" class="fa-solid fa-thumbs-up ms-2"></i>
                      <span class="ms-2 me-2">{{ likeCount }}</span>
                    </button>
                  </div>
                  <button id="updateButton" @click="showUpdatePostModal(postone.postNo)"
                    class="btn btn-primary fs-6 p-1 me-2">수정</button>
                  <button id="deleteButton" @click="deletePost(postone.postNo)"
                    class="btn btn-primary fs-6 p-1">삭제</button>
                </div>
                <!--end::Post content-->
              </div>
              <!--end::Content-->
            </div>
            <!--end::Layout-->

            <!-- 댓글 내용 START -->
            <!--begin::Section-->
            <div class="mb-17">
              <!--begin::Content-->
              <div class="d-flex flex-stack mb-5">
                <!--begin::Title-->
                <h3 class="text-gray-900">댓글 보기</h3>
                <!--end::Title-->
                <!--begin::Link-->
                <a href="#" class="fs-6 fw-semibold link-primary">댓글 촤라락</a>
                <!--end::Link-->
              </div>
              <!--end::Content-->
              <!--begin::Separator-->
              <div class="separator separator-dashed mb-9"></div>
              <!--end::Separator-->

              <!-- 댓글 작성 START -->
              <!-- 댓글 1 START -->
              <!--begin::Block-->
              <div class="d-flex align-items-center border-1 border-dashed card-rounded p-5 p-lg-5 mb-2">
                <!--begin::Section-->
                <div class="text-center flex-shrink-0 me-7 me-lg-13">
                  <!--begin::Avatar-->
                  <div class="symbol symbol-50px symbol-circle mb-2">
                    <img src="@/assets/cat.jpg" class="" alt="" />
                  </div>
                  <!--end::Avatar-->
                </div>
                <!--end::Section-->
                <!--begin::Text-->
                <div class="mb-0 fs-6">
                  <a class="text-gray-700 fw-bold text-hover-primary">댓글단 아이디</a>
                  <div class="text-muted fw-semibold lh-lg mb-2">
                    지중해 감성 제대로네요!! 가보고 싶어요 - 댓글 내용
                  </div>
                </div>
                <!--end::Text-->
              </div>
              <!--end::Block-->
              <!-- 댓글 1 END -->
              <!-- 댓글 2 START -->
              <!--begin::Block-->
              <div class="d-flex align-items-center border-1 border-dashed card-rounded p-5 p-lg-5 mb-2">
                <!--begin::Section-->
                <div class="text-center flex-shrink-0 me-7 me-lg-13">
                  <!--begin::Avatar-->
                  <div class="symbol symbol-50px symbol-circle mb-2">
                    <img src="@/assets/img_trip.jpg" class="" alt="" />
                  </div>
                  <!--end::Avatar-->
                </div>
                <!--end::Section-->
                <!--begin::Text-->
                <div class="mb-0 fs-6">
                  <a class="text-gray-700 fw-bold text-hover-primary">댓글단 아이디2</a>
                  <div class="text-muted fw-semibold lh-lg mb-2">
                    사진 진짜 청량하네요 저도 남부여행 가고 싶네요 - 댓글 내용2
                  </div>
                </div>
                <!--end::Text-->
              </div>
              <!--end::Block-->
              <!-- 댓글 2 END -->
              <!-- 댓글 작성 END -->

            </div>
            <!--end::Section-->
          </div>
          <!--end::Body-->
        </div>
        <!--end::Post card-->
      </div>
      <!--end::Content container-->
    </div>
    <!--end::Content-->


    <!-- 블로그 포스트 형식 가져온거 END -->
  </div>

  <!-- 몸1 -->

  <!-- 글 수정 모달 START -->
  <!--begin::대화상자 - 검사일정수정 -->
  <div class="modal fade" id="kt_modal_new_target" tabindex="-1" aria-hidden="true">

    <div class="modal-dialog modal-dialog-centered mw-650px">

      <div class="modal-content rounded">

        <div class="modal-header pb-0 border-0 justify-content-end">
          <!--begin::닫기 아이콘-->
          <div class="btn btn-sm btn-icon btn-active-color-primary" data-bs-dismiss="modal">
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
              <h1 class="mb-3">후기 글 수정</h1>
              <!--end::Title-->
              <!--begin::Description-->
              <div class="text-muted fw-semibold fs-5">글의 제목, 이미지, 내용을 수정해보세요.</div>
              <!--end::Description-->
            </div>
            <!--end::제목-->

            <!--begin::이름 입력상자-->
            <div class="d-flex flex-column mb-8 fv-row">
              <label class="d-flex align-items-center fs-6 fw-semibold mb-2">
                <span class="required">제목</span>
                <span class="ms-1" data-bs-toggle="tooltip" title="제목을 입력하세요. 필수랍니다~">
                  <i class="ki-duotone ki-information-5 text-gray-500 fs-6">
                    <span class="path1"></span>
                    <span class="path2"></span>
                    <span class="path3"></span>
                  </i>
                </span>
              </label>
              <input type="text" class="form-control form-control-solid" name="target_title" v-model="titleInput" />
            </div>
            <!--end::이름 입력상자-->
            <!-- 이미지 선택 START -->
            <div class="d-flex flex-column mb-8 fv-row">
              <label class="d-flex align-items-center fs-6 fw-semibold mb-2">
                <span class="required">파일 선택</span>
              </label>
              <input type="file" id="image" @change="onFileChange" ref="image" />
            </div>
            <!-- 이미지 선택 END -->
            <!--begin::내용 입력상자-->
            <div class="d-flex flex-column mb-8 fv-row">
              <label class="d-flex align-items-center fs-6 fw-semibold mb-2">
                <span class="required">내용</span>
                <span class="ms-1" data-bs-toggle="tooltip" title="내용을 입력하세요. 필수랍니다~">
                  <i class="ki-duotone ki-information-5 text-gray-500 fs-6">
                    <span class="path1"></span>
                    <span class="path2"></span>
                    <span class="path3"></span>
                  </i>
                </span>
              </label>
              <textarea class="form-control form-control-solid" name="target_content" v-model="contentInput"
                rows="5"></textarea>
            </div>
            <!--end::내용 입력상자-->
            <!-- start::키워드 선택상자 -->
            <!--begin::키워드-->
            <div class="fv-row mb-8 mt-8">
                  <fieldset
                    style="border: 1px solid #ccc; padding: 15px; margin-bottom: 20px"
                  >
                    <!--begin::mbti-->
                    <div class="form-group mt-3" >
                      <label for="mbti">MBTI</label>
                      <select v-model="mbtiInput" id="mbti" name="mbti" class="form-control" style="cursor:pointer">
                        <option value="" disabled >선택하기</option>
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
                      <select v-model="sortInput" id="number" name="number" class="form-control" style="cursor:pointer">
                        <option value="" disabled>선택하기</option>
                        <option value="개인">개인</option>
                        <option value="단체">단체</option>
                      </select>
                    </div>

                    <div class="form-group mt-3">
                      <label for="region">선호 지역</label>
                      <select v-model="locationInput" id="location" name="location" class="form-control" style="cursor:pointer">
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

                    <div class="form-group mt-3" >
                      <label for="preference">여행 취향</label>
                      <select v-model="typeInput" id="type" name="type" class="form-control" style="cursor:pointer">
                        <option value="" disabled>선택하기</option>
                        <option value="익스트림">익스트림</option>
                        <option value="힐링">힐링</option>
                      </select>
                    </div>

                    <div class="form-group mt-3">
                      <label for="transport">이동수단</label>
                      <select v-model="mobilityInput" id="mobility" name="mobility" class="form-control" style="cursor:pointer">
                        <option value="" disabled>선택하기</option>
                        <option value="뚜벅이">뚜벅이</option>
                        <option value="차">차</option>
                        <option value="대중교통">대중교통</option>
                      </select>
                    </div>

                    <div class="form-group mt-3">
                      <label for="accommodation">숙소</label>
                      <select v-model="houseInput" id="house" name="house" class="form-control" style="cursor:pointer">
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
              <button type="button" class="btn btn-primary" @click.prevent="updatePost(postone.postNo)">저장</button>
              <button type="reset" class="btn btn-light ms-3" @click="clearAll()">모두 지우기</button>
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
  <!-- 글 수정 모달 END -->
</template>

<script setup>

import { ref, onMounted } from 'vue';
import { usePostStore, useLikeCountStore, usePostLikesListStore, useLikesListStore, usePostKeywordStore } from '@/stores/test';
import { storeToRefs } from 'pinia';
import { useRouter } from 'vue-router';
import router from '@/router/index.js';
import { deletePostByNo, updatePostByNo, insertLike, deleteLikeByNo, updatePostKeywordByNo } from '@/api/test';
import { Modal } from 'bootstrap';
import Header from '@/components/Header.vue';
// 로그인한 유저 넘버
let userNo = sessionStorage.getItem("userNo");

// 좋아요 리스트 가져오기
const likesstore = useLikesListStore();
const { likesList } = storeToRefs(likesstore);

let mode = 'no'; // 기본적으로 좋아요를 누르지 않은 상태
let lnum = null; // 해당 글의 좋아요 번호 저장

async function getlikes() {
  await likesstore.fetchLikesList();
  likesList.value.forEach((item) => {
    console.log(`Post No: ${item.postNo}, User No: ${item.userNo}`);
    if (postone.value.postNo == item.postNo) {
      console.log('이 글에 좋아요를 눌렀습니다.');
      mode = 'yes'; // 이미 좋아요를 누른 상태로 설정
      lnum = item.likeNo; // 좋아요 번호 저장
    }
  });
}

// 글 키워드 가져오기
const keywordstore = usePostKeywordStore();
const { postkeyword } = storeToRefs(keywordstore);

async function getPostKeywordByNo() {
  await keywordstore.fetchpostkeyword(postone.value.postNo);
  console.log("키워드들 : " + postkeyword.value);
}

onMounted(() => {
  
  init();
  getlikes(); // 좋아요 리스트 가져오기
  getPostKeywordByNo();
});

// 글에 좋아요 관련 함수, 변수
const likestore = useLikeCountStore();
const { likeCount } = storeToRefs(likestore);

async function init() {
  await likestore.fetchLikeCount(postone.value.postNo);
  console.log("좋아요 수 : " + likeCount.value);
}

const clickLike = async (id) => {
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
      await init(); // 좋아요 수 업데이트
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
      await init(); // 좋아요 수 업데이트
      await getlikes(); // 좋아요 리스트 업데이트
    } catch (error) {
      console.error("좋아요 추가에 실패했습니다:", error);
    }
  }
};



  // 글 정보 가져오기 관련 함수, 변수
  const poststore = usePostStore();
  const { postone } = storeToRefs(poststore);

  console.log("Current post data:", postone);
  console.log("글번호 : ", postone.value.postNo);


  // 글 삭제하기 버튼 함수
  //const deleteButton = document.querySelector('#deleteButton');
  //deleteButton.addEventListener("click", function (postNo) {
  //console.log("삭제할 번호 : ", postNo);
  //deletePostByNo(postNo);
  //})

  // 글 삭제하기
  function deletePost(postNo) {
    if(postone.value.userNo == userNo) {
      console.log("삭제할 번호 : ", postNo);
      if (confirm("정말 삭제하시겠습니까??") == true) {
        deletePostByNo(postNo);
        router.replace({ path: '/mainpage' });
      } else {
        return false;
      }
    } else {
      alert("글 작성자만 삭제가능합니다! 어딜 감히... 떽!");
    }
  }

  // 글 업데이트하기 버튼 - 모달 함수
  let titleInput = ref('');
  let contentInput = ref('');
  let mbtiInput = ref('');
  let sortInput = ref('');
  let locationInput = ref('');
  let typeInput = ref('');
  let mobilityInput = ref('');
  let houseInput = ref('');

  let updatePostModal;

  // 수정 모달 만들기
  function showUpdatePostModal(itemId) {
    if(postone.value.userNo == userNo) {
      console.log(`showUpdate 호출됨 - 아이디 : ${itemId}`);
  
      // 대화상자의 입력값 넣어주기
      titleInput.value = postone.value.postTitle;
      contentInput.value = postone.value.content;
      mbtiInput.value = postkeyword.value.keywordMbti;
      sortInput.value = postkeyword.value.keywordSort;
      locationInput.value = postkeyword.value.keywordLocation;
      typeInput.value = postkeyword.value.keywordType;
      mobilityInput.value = postkeyword.value.keywordMobility;
      houseInput.value = postkeyword.value.keywordHouse;
  
      // 선택한 아이템의 아이디
      //selected.value = itemId;
  
      // 대화상자 띄우기
      const elem = document.querySelector('#kt_modal_new_target');
      updatePostModal = new Modal(elem);
      updatePostModal.show();
    } else {
      alert("글 작성자만 수정가능합니다! 어딜 감히... 떽!");
    }

  }

  // 글 업데이트 함수
  function updatePost(postNo) {
    console.log("수정할 글번호 : ", postNo);
    const data = {
      postNo: postNo,
      postTitle: titleInput.value,
      content: contentInput.value
    }
    console.log("수정한 글제목 : " + titleInput.value);
    postone.value.postTitle = titleInput.value;
    postone.value.content = contentInput.value;
    console.log("전달할 내용 : " + data);
    
    updatePostByNo(postNo, data);
    updateKeywordByNo(postNo);
    updatePostModal.hide();
  }

  // 키워드 업데이트 함수
  function updateKeywordByNo(postNo) {
    const kdata = {
      keywordMbti: mbtiInput.value,
      keywordSort: sortInput.value,
      keywordLocation: locationInput.value,
      keywordType: typeInput.value,
      keywordMobility: mobilityInput.value,
      keywordHouse: houseInput.value
    }
    updatePostKeywordByNo(postNo, kdata);
  }

  // 반응형 변수 선언 (isHeartFilled는 하트가 채워졌는지 여부를 저장)
  const isHeartFilled = ref(false);

  // 하트를 클릭했을 때 상태를 토글하는 함수
  function toggleHeart() {
    isHeartFilled.value = !isHeartFilled.value;
  }

  // 메인페이지로 돌아가기 버튼 함수
  function goHome() {
    router.replace({ path: '/mainpage' });
  }

  function clearAll() {
    // 내용 초기화 하기
    titleInput.value = '';
    contentInput.value = '';
    mbtiInput.value = '';
    sortInput.value = '';
    locationInput.value = '';
    typeInput.value = '';
    mobilityInput.value = '';
    houseInput.value = '';
    // 파일 입력 요소 초기화
    const fileInput = document.querySelector('input[type="file"]');
    if (fileInput) {
      fileInput.value = ''; // HTML 파일 입력 요소의 값 초기화
    }
  }

  function goToMainPage() {
  router.push({ path: "/mainpage" });
}
</script>

<style scoped>
.card {
  cursor: pointer;
}

.elevate-card {
  transition: transform 0.3s ease, box-shadow 0.3s ease;
  /* 부드러운 전환 효과 */
}

/* 호버 시 떠오르는 효과 */
.elevate-card:hover {
  transform: translateY(-10px);
  /* 카드가 위로 10px 올라감 */
  box-shadow: 0 10px 15px rgba(0, 0, 0, 0.2);
  /* 그림자를 추가하여 떠오르는 느낌 강화 */
}

.bi-heart {
  color: gray;
  /* 기본 하트 색상 */
}

.bi-heart-fill {
  color: red;
  /* 하트가 채워졌을 때 색상 */
}

.styled-button {
  background: linear-gradient(#d3d3d3, #a9a9a9); 
  color: white;
  padding: 10px 20px;
  border: none; 
  border-radius: 25px; 
  font-size: 16px;
  font-weight: bold; 
  cursor: pointer;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
  transition: all 0.3s ease;
}

</style>