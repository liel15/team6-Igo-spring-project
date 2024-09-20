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
                    <div class="d-flex flex-wrap mb-6">
                      <!--begin::Item-->
                      <div class="me-9 my-1">
                        <!--begin::Icon-->
                        <i class="ki-duotone ki-element-11 text-primary fs-2 me-1">
                          <span class="path1"></span>
                          <span class="path2"></span>
                          <span class="path3"></span>
                          <span class="path4"></span>
                        </i>
                        <!--end::Icon-->
                        <!--begin::Label-->
                        <span class="fw-bold text-gray-500"> 글키워드1</span>
                        <!--end::Label-->
                      </div>
                      <!--end::Item-->
                      <!--begin::Item-->
                      <div class="me-9 my-1">
                        <!--begin::Icon-->
                        <i class="ki-duotone ki-briefcase text-primary fs-2 me-1">
                          <span class="path1"></span>
                          <span class="path2"></span>
                        </i>
                        <!--end::Icon-->
                        <!--begin::Label-->
                        <span class="fw-bold text-gray-500"> 글키워드2</span>
                        <!--begin::Label-->
                      </div>
                      <!--end::Item-->
                      <!--begin::Item-->
                      <div class="my-1">
                        <!--begin::Icon-->
                        <i class="ki-duotone ki-message-text-2 text-primary fs-2 me-1">
                          <span class="path1"></span>
                          <span class="path2"></span>
                          <span class="path3"></span>
                        </i>
                        <!--end::Icon-->
                        <!--begin::Label-->
                        <span class="fw-bold text-gray-500"> 글키워드3</span>
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
                        <a
                          href="pages/careers/apply.html"
                          class="btn btn-light-primary ms-3"
                          >일정보기</a
                        >
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
                  <button
                    id="updateButton"
                    @click="showUpdatePostModal(postone.postNo)"
                    class="btn btn-primary fs-6 p-1 me-2"
                  >
                    수정
                  </button>
                  <button
                    id="deleteButton"
                    @click="deletePost(postone.postNo)"
                    class="btn btn-primary fs-6 p-1"
                  >
                    삭제
                  </button>
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
              <div class="d-flex align-items-center mb-5">
                <input
                  v-model="newCommentContent"
                  class="form-control me-3"
                  style="width: 90%"
                  placeholder="댓글을 입력해주세요"
                />
                <button class="btn btn-primary" @click="submitComment">댓글달기</button>
              </div>

              <!-- 댓글 START -->
              <!--begin::Block-->
              <div v-for="comment in commentList" :key="comment.commentNo">
                <div
                  class="d-flex align-items-center border-1 border-dashed card-rounded p-5 p-lg-5 mb-2"
                >
                  <!--begin::Section-->
                  <div class="text-center flex-shrink-0 me-7 me-lg-13">
                    <!--begin::Avatar-->
                    <div class="symbol symbol-50px symbol-circle mb-2">
                      <img :src="comment.img" class="" alt="" />
                    </div>
                    <!--end::Avatar-->
                  </div>
                  <!--end::Section-->
                  <!--begin::Text and Icon-->
                  <div class="flex-grow-1 d-flex flex-column">
                    <div class="d-flex justify-content-between align-items-start">
                      <a class="text-gray-700 fw-bold text-hover-primary">{{
                        comment.userName
                      }}</a>
                      <i
                        class="bi bi-x-square cursor-pointer"
                        @click="deleteComment(comment.commentNo)"
                      ></i>
                    </div>
                    <div class="text-muted fw-semibold lh-lg mb-2">
                      {{ comment.content }}
                    </div>
                  </div>
                  <!--end::Text and Icon-->
                </div>
              </div>
              <!--end::Block-->
              <!-- 댓글 1 END -->

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
              <h1 class="mb-3">후기 글 수정</h1>
              <!--end::Title-->
              <!--begin::Description-->
              <div class="text-muted fw-semibold fs-5">
                글의 제목, 이미지, 내용을 수정해보세요.
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
            <!--begin::하단버튼-->
            <div class="text-center">
              <button
                type="button"
                class="btn btn-primary"
                @click.prevent="updatePost(postone.postNo)"
              >
                저장
              </button>
              <button type="reset" class="btn btn-light ms-3" @click="clearAll()">
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
  <!-- 글 수정 모달 END -->
</template>

<script setup>
import { ref, onMounted } from "vue";
import { usePostStore, useLikeCountStore, usePostLikesListStore, useLikesListStore, useCommentStore } from "@/stores/test";
import { storeToRefs } from "pinia";
import { useRouter } from "vue-router";
import router from "@/router/index.js";
import { deletePostByNo, updatePostByNo, insertLike, deleteLikeByNo } from "@/api/test";
import { Modal } from "bootstrap";
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

onMounted(() => {
  
  init();
  getlikes(); // 좋아요 리스트 가져오기
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


= useRoute

const route = useRoute(); //현재 라우트 정보에 접근
const poststore = usePostStore(); // 글 정보 가져오기 관련 함수, 변수
const commentStore = useCommentStore(); //댓글 스토어 사용하기
const newCommentContent = ref("");

const { postone } = storeToRefs(poststore);
const { commentList } = storeToRefs(commentStore);

const postNo = route.params.postNo;

  console.log("Current post data:", postone);
  console.log("글번호 : ", postone.value.postNo);

onMounted(async () => {
  window.scrollTo(0, 0);
  const postNo = route.params.postNo;
  try {
    await poststore.fetchPostone(postNo);
    if (!postone.value || Object.keys(postNo).length === 0) {
      throw new Error("게시글을 찾을 수 없습니다.");
    }

  
    await commentStore.fetchComments(postNo); //댓글 가져오기

    // 잘 나왔는지 확인
    console.log("Current post data:", postone.value);
    console.log("글번호 : ", postNo);
  } catch (error) {
    console.error("게시글 로딩 중 오류 발생:", error);
    // alert("게시글을 찾을 수 없습니다. 메인 페이지로 이동합니다.");
    // router.push("/");
  }
});

//댓글 작성
const submitComment = async () => {
  if (postNo) {
    try {
      //await commentStore.newComment(postNo);
      await commentStore.newComment({
        content: newCommentContent.value, //여기서 값받고 피니아로 넘어가는 것이다. 
        postNo: postNo,
        userNo: sessionStorage.getItem("userNo"),
      });
    } catch (error) {
      console.error("댓글 작성 오류 : ", error);
      // if (error.response && error.response.status === 401) {
      //   alert("로그인이 필요합니다.");
      // } else {
      //   alert("댓글작성 실패. 다시 시도하기");
      // }
    }
  } else {
    console.error("게시글 번호가 없습니다.");
    alert("유효하지 않은 게시글입니다. 메인 페이지로 이동합니다.");
    router.push("/");
  }
};

//댓글 삭제
async function deleteComment(commentNo) {
  console.log("삭제할 댓글", commentNo);
  if(confirm("정말 댓글을 삭제할까요?") == true) {
    try {
      await commentStore.handleDeleteComment(commentNo, postNo);

      alert("댓글 삭제 완료!");

    }catch (error) {
      console.log("댓글삭제 오류", error);
    }
  }
}

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


  let updatePostModal;

  // 수정 모달 만들기
  function showUpdatePostModal(itemId) {
    if(postone.value.userNo == userNo) {
      console.log(`showUpdate 호출됨 - 아이디 : ${itemId}`);
  
      // 대화상자의 입력값 넣어주기
      titleInput.value = postone.value.postTitle;
      contentInput.value = postone.value.content;
  
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
    updatePostModal.hide();
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

</script>

<style scoped>
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
</style>
