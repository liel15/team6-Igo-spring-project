<template>
  <div class="d-flex flex-column">
    <!-- 헤더 시작 -->
    <div class="header" style="height: 8vh; background-color: #3abef9">
      <!-- 네비바 -->
      <nav class="navbar navbar-expand-lg navbar-dark w-100 h-100">
        <div class="container-fluid">
          <div class="d-flex align-items-center">
            <img width="50" height="50" src="https://img.icons8.com/stickers/50/airplane-take-off.png"
              alt="airplane-take-off" />
            <a class="navbar-brand ms-2 fw-bold" style="font-size: 30px" href="#">I.GO!</a>
          </div>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
            aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>

          <div class="collapse navbar-collapse justify-content-end" id="navbarNavAltMarkup">
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
        <div v-for="item in postlist" class="card">
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
                    <span class="fw-bold text-muted fs-5 ps-1 me-4">유저 아이디 자리</span>
                    <span class="text-gray-900 fs-1 fw-bold">{{ item.postTitle }}</span>
                    <!--end::Title-->
                    <!--begin::Container-->
                    <div class="overlay mt-8">
                      <!--begin::Image-->
                      <div class="bgi-no-repeat bgi-position-center bgi-size-cover card-rounded min-h-400px"
                        style="background-image: url(src/assets/img_trip.png);"></div>
                      <!--end::Image-->
                      <!--begin::Links-->
                      <div class="overlay-layer card-rounded bg-dark bg-opacity-25">
                        <a href="pages/about.html" class="btn btn-primary">About Us</a>
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
                    <p class="mb-8">{{ item.postContent }}</p>
                    <!--end::Text-->
                  </div>
                  <!--end::Description-->

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
</template>

<script setup>

import { ref, onMounted } from 'vue';
import { usePostStore } from '@/stores/test';
import { storeToRefs } from 'pinia';

// db에서 posts들 데이터 가져오기
onMounted(() => {
  init();
})

const store = usePostStore();
async function init () {
  store.fetchPost();
  console.log(postlist);
}
const { postlist } = storeToRefs(store);
// 반응형 변수 선언 (isHeartFilled는 하트가 채워졌는지 여부를 저장)
const isHeartFilled = ref(false);

// 하트를 클릭했을 때 상태를 토글하는 함수
function toggleHeart() {
  isHeartFilled.value = !isHeartFilled.value;
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
</style>