<template>
  <!--begin::Theme mode setup on page load-->
  <!--begin::Root-->
  <div class="d-flex flex-column flex-root" id="kt_app_root">
      <!--begin::Authentication - Sign-in -->
      <div class="d-flex flex-column flex-lg-row flex-column-fluid">
          <!--begin::Body-->
          <div class="d-flex flex-column flex-lg-row-fluid w-lg-50 p-10 order-2 order-lg-1">
              <!--begin::Form-->
              <div class="d-flex flex-center flex-column flex-lg-row-fluid">
                  <!--begin::Wrapper-->
                  <div class="w-lg-500px p-10">
                      <!--begin::Form-->
                      <form class="form w-100" novalidate="novalidate" id="kt_sign_in_form"
                          data-kt-redirect-url="index.html" action="#" @submit.prevent="login">
                          <!--begin::Heading-->
                          <div class="text-center mb-11">
                              <!--begin::Title-->
                              <h1 class="text-gray-900 fw-bolder mb-3">로그인</h1>
                              <!--end::Title-->
                              <!--begin::Subtitle-->
                              <div class="text-gray-500 fw-semibold fs-6">Igo</div>
                              <!--end::Subtitle=-->
                          </div>
                          <!--begin::Heading-->
                          <!--begin::Login options-->
                          <div class="row g-3 mb-9">
                              <!--begin::Col-->
                              <div class="col-md-6">
                                  <!--begin::Google link=-->
                                  <a href="#"
                                      class="btn btn-flex btn-outline btn-text-gray-700 btn-active-color-primary bg-state-light flex-center text-nowrap w-100">
                                      <img alt="Logo" src="@/assets/images/cat_run.png" class="h-15px me-3" />Sign in with Google</a>
                                  <!--end::Google link=-->
                              </div>
                              <!--end::Col-->
                              <!--begin::Col-->
                              <div class="col-md-6">
                                  <!--begin::Google link=-->
                                  <a href="#"
                                      class="btn btn-flex btn-outline btn-text-gray-700 btn-active-color-primary bg-state-light flex-center text-nowrap w-100">
                                      <img alt="Logo" src="@/assets/images/cat_run.png" class="theme-light-show h-15px me-3" />
                                      <img alt="Logo" src="@/assets/images/cat_run.png" class="theme-dark-show h-15px me-3" />Sign in with Apple</a>
                                  <!--end::Google link=-->
                              </div>
                              <!--end::Col-->
                          </div>
                          <!--end::Login options-->
                          <!--begin::Separator-->
                          <div class="separator separator-content my-14">
                              <span class="w-125px text-gray-500 fw-semibold fs-7">Or with email</span>
                          </div>
                          <!--end::Separator-->

                          <!--begin::Input group=-->
                          <div class="fv-row mb-8">
                              <!--begin::아이디-->
                              <input type="text"  v-model="id" placeholder="id" name="id" 
                                  class="form-control bg-transparent" />
                              <!--end::아이디-->
                          </div>
                          <!--end::Input group=-->

                          <div class="fv-row mb-3">
                              <!--begin::비밀번호-->
                              <input type="password" v-model="password" placeholder="Password" name="password" autocomplete="off"
                                  class="form-control bg-transparent" />
                              <!--end::비밀번호-->
                          </div>
                          <!--end::Input group=-->

                          <!--begin::Wrapper-->
                          <div class="d-flex flex-stack flex-wrap gap-3 fs-base fw-semibold mb-8">
                              <div></div>
                              <!--begin::Link-->
                              <a href="authentication/layouts/corporate/reset-password.html"
                                  class="link-primary">Forgot Password ?</a>
                              <!--end::Link-->
                          </div>
                          <!--end::Wrapper-->
                          <!--begin::Submit button-->
                          <div class="d-grid mb-10">
                              <button type="submit" id="kt_sign_in_submit" class="btn btn-primary">
                                  <!--begin::Indicator label-->
                                  <span class="indicator-label">로그인</span>
                                  <!--end::Indicator label-->
                                  <!--begin::Indicator progress-->
                                  <span class="indicator-progress">Please wait...
                                      <span class="spinner-border spinner-border-sm align-middle ms-2"></span></span>
                                  <!--end::Indicator progress-->
                              </button>
                          </div>
                          <!--end::Submit button-->

                          <!--begin::회원가입-->
                          <div class="text-gray-500 text-center fw-semibold fs-6">Not a Member yet?
                              <a @click="goToSignUp()" class="link-primary">회원가입</a>
                          </div>
                          <!--end::회원가입-->

                      </form>
                      <!--end::Form-->
                  </div>
                  <!--end::Wrapper-->
              </div>
              <!--end::Form-->
              <!--begin::Footer-->
              <div class="w-lg-500px d-flex flex-stack px-10 mx-auto">
                  <!--begin::Languages-->
                  <div class="me-10">
                      <!--begin::Toggle-->
                      <button class="btn btn-flex btn-link btn-color-gray-700 btn-active-color-primary rotate fs-base"
                          data-kt-menu-trigger="click" data-kt-menu-placement="bottom-start"
                          data-kt-menu-offset="0px, 0px">
                          <img data-kt-element="current-lang-flag" class="w-20px h-20px rounded me-3" alt="" />
                          <span data-kt-element="current-lang-name" class="me-1">English</span>
                          <span class="d-flex flex-center rotate-180">
                              <i class="ki-duotone ki-down fs-5 text-muted m-0"></i>
                          </span>
                      </button>
                      <!--end::Toggle-->
                      <!--begin::Menu-->
                      <div class="menu menu-sub menu-sub-dropdown menu-column menu-rounded menu-gray-800 menu-state-bg-light-primary fw-semibold w-200px py-4 fs-7"
                          data-kt-menu="true" id="kt_auth_lang_menu">
                          <!--begin::Menu item-->
                          <div class="menu-item px-3">
                              <a href="#" class="menu-link d-flex px-5" data-kt-lang="English">
                                  <span class="symbol symbol-20px me-4">
                                      <img data-kt-element="lang-flag" class="rounded-1" alt="" />
                                  </span>
                                  <span data-kt-element="lang-name">English</span>
                              </a>
                          </div>
                          <!--end::Menu item-->
                          <!--begin::Menu item-->
                          <div class="menu-item px-3">
                              <a href="#" class="menu-link d-flex px-5" data-kt-lang="Spanish">
                                  <span class="symbol symbol-20px me-4">
                                      <img data-kt-element="lang-flag" class="rounded-1" alt="" />
                                  </span>
                                  <span data-kt-element="lang-name">Spanish</span>
                              </a>
                          </div>
                          <!--end::Menu item-->
                          <!--begin::Menu item-->
                          <div class="menu-item px-3">
                              <a href="#" class="menu-link d-flex px-5" data-kt-lang="German">
                                  <span class="symbol symbol-20px me-4">
                                      <img data-kt-element="lang-flag" class="rounded-1" alt="" />
                                  </span>
                                  <span data-kt-element="lang-name">German</span>
                              </a>
                          </div>
                          <!--end::Menu item-->
                          <!--begin::Menu item-->
                          <div class="menu-item px-3">
                              <a href="#" class="menu-link d-flex px-5" data-kt-lang="Japanese">
                                  <span class="symbol symbol-20px me-4">
                                      <img data-kt-element="lang-flag" class="rounded-1" alt="" />
                                  </span>
                                  <span data-kt-element="lang-name">Japanese</span>
                              </a>
                          </div>
                          <!--end::Menu item-->
                          <!--begin::Menu item-->
                          <div class="menu-item px-3">
                              <a href="#" class="menu-link d-flex px-5" data-kt-lang="French">
                                  <span class="symbol symbol-20px me-4">
                                      <img data-kt-element="lang-flag" class="rounded-1" alt="" />
                                  </span>
                                  <span data-kt-element="lang-name">French</span>
                              </a>
                          </div>
                          <!--end::Menu item-->
                      </div>
                      <!--end::Menu-->
                  </div>
                  <!--end::Languages-->
                  <!--begin::Links-->
                  <div class="d-flex fw-semibold text-primary fs-base gap-5">
                      <a href="pages/team.html" target="_blank">Terms</a>
                      <a href="pages/pricing/column.html" target="_blank">Plans</a>
                      <a href="pages/contact.html" target="_blank">Contact Us</a>
                  </div>
                  <!--end::Links-->
              </div>
              <!--end::Footer-->
          </div>
          <!--end::Body-->
          <!--begin::Aside-->
          <div class="d-flex flex-lg-row-fluid w-lg-50 bgi-size-cover bgi-position-center order-1 order-lg-2"
              style="background-image: url(src/assets/images/cat_sit.png); background-size: contain; background-position: center;">
              <!--begin::Content-->
              <div class="d-flex flex-column flex-center py-7 py-lg-15 px-5 px-md-15 w-100">
                  <!--begin::Logo-->
                  <a href="index.html" class="mb-0 mb-lg-12">
                      
                  </a>
                  <!--end::Logo-->
                  <!--begin::Image-->
                  <img class="d-none d-lg-block mx-auto w-275px w-md-50 w-xl-500px mb-10 mb-lg-20" alt="" />
                  <!--end::Image-->
                  <!--begin::Title-->
                  <h1 class="d-none d-lg-block text-white fs-2qx fw-bolder text-center mb-7">Fast, Efficient and
                      Productive</h1>
                  <!--end::Title-->
                  <!--begin::Text-->
                  <div class="d-none d-lg-block text-white fs-base text-center">In this kind of post,
                      <a href="#" class="opacity-75-hover text-warning fw-bold me-1">the blogger</a>introduces a
                      person they’ve interviewed
                      <br />and provides some background information about
                      <a href="#" class="opacity-75-hover text-warning fw-bold me-1">the interviewee</a>and their
                      <br />work following this is a transcript of the interview.
                  </div>
                  <!--end::Text-->
              </div>
              <!--end::Content-->
          </div>
          <!--end::Aside-->
      </div>
      <!--end::Authentication - Sign-in-->
  </div>


</template>

<script setup>

import { ref } from "vue";
import { useTestStore } from "@/stores/test"; // Pinia 스토어 가져오기
import router from "@/router/index.js";

const id = ref("");          // 사용자 ID
const password = ref("");    // 비밀번호

const store = useTestStore(); // Pinia 스토어 사용
const { handleLogin, error } = store; // 스토어에서 함수와 에러 상태 가져오기

// 로그인 함수 호출
function login() {
  handleLogin(id.value, password.value); // 사용자가 입력한 ID와 비밀번호를 넘겨줌
}

// 회원가입으로 이동
function goToSignUp() {
router.push({ path: "/signup"});
}


//  import axios from "axios";

// export default {
//   data() {
//     return {
//       id: "",
//       password: "",
//       error: null,
//     };
//   },
//   methods: {
//     async login() {
//       try {
//         const response = await axios.post(
//           "http://localhost:9000/springtest/api/auth/login.do",
//           {
//             abId: this.id,
//             abPw: this.password,
//           }
//         );
//         alert("로그인성공"); // 로그인 성공 메시지
//         console.log(response.data);
//         this.$router.push({ name: "about" });
//       } catch (error) {
//         this.error = "Invalid username or password";
//       }
//     },
//     goToSignUp() {
//       this.$router.push({ path: "/signup" });
//     },
//   },
// };

</script>
