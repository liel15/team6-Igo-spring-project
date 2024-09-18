<template>
  <!--begin::Theme mode setup on page load-->
  <!--begin::Root-->
  <div class="d-flex flex-column flex-root" id="kt_app_root" style="height: 100vh;">
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
                                  <a href="https://accounts.google.com/o/oauth2/auth/oauthchooseaccount?response_type=code&access_type=offline&client_id=622686756548-j87bjniqthcq1e4hbf1msh3fikqn892p.apps.googleusercontent.com&state=UPJIYRYIJHUGKCQZWYMSZRWVTLWQLT&scope=profile%20email&redirect_uri=https%3A%2F%2Fwww.airbnb.co.kr%2Foauth_callback&service=lso&o2v=1&ddm=1&flowName=GeneralOAuthFlow"
                                      class="btn btn-flex btn-outline btn-text-gray-700 btn-active-color-primary bg-state-light flex-center text-nowrap w-100">
                                      <img alt="Logo" src="/images/google.png" class="h-15px me-3" />Sign in with Google</a>
                                  <!--end::Google link=-->
                              </div>
                              <!--end::Col-->

                              <!--begin::Col-->
                              <div class="col-md-6">
                                  <!--begin::apple link=-->
                                  <a href="https://www.icloud.com"
                                      class="btn btn-flex btn-outline btn-text-gray-700 btn-active-color-primary bg-state-light flex-center text-nowrap w-100">
                                      <img alt="Logo" src="/images/apple.png" class="theme-light-show h-15px me-3" />Sign in with Apple
                                  </a>
                                  <!--end::apple link=-->
                              </div>
                              <!--end::Col-->
                          </div>
                          <!--end::Login options-->
                          <!--begin::Separator-->
                          <div class="separator separator-content my-14">
                              <span class="w-200px text-gray-500 fw-semibold fs-7">회원 정보로 로그인</span>
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


                          <!--begin::아이디 찾기-->
                          <div class="d-flex flex-stack flex-wrap gap-3 fs-base fw-semibold mb-8">
                              <div></div>                         
                              <!--begin::Link-->
                              <a @click="goToFinId()" class="link-primary" style="margin-left:55%; cursor:pointer">아이디 찾기</a>
                              <!--end::Link-->

                              <div></div>                         
                              <!--begin::Link-->
                              <a @click="goToFindPassword()" class="link-primary" style="cursor:pointer">비밀번호 찾기</a>
                              <!--end::Link-->
                          </div>
                          <!--end::아이디 찾기-->


                          
                  

                          <!--begin::로그인 버튼-->
                          <div class="d-grid mb-10">
                              <button type="submit" id="kt_sign_in_submit" class="btn btn-primary">

                                  <!--begin::Indicator label-->
                                  <span class="indicator-label">로그인</span>
                                  <!--end::Indicator label-->

                              </button>
                          </div>
                          <!--end::로그인 버튼-->

                          <!--begin::회원가입-->
                          <div class="text-gray-500 text-center fw-semibold fs-6"> 아직 회원이 아니신가요?
                              <a @click="goToSignUp()" class="link-primary" style="cursor:pointer">회원가입</a>
                          </div>
                          <!--end::회원가입-->

           
             

                      </form>
                      <!--end::Form-->

                      
                  </div>
                  <!--end::Wrapper-->
              </div>
              <!--end::Form-->
          </div>
          <!--end::Body-->

            <!--begin::Aside-->
            <div class="d-flex flex-lg-row-fluid bgi-size-cover bgi-position-center order-1 order-lg-2" 
                style="background-image: url('/images/trip.jpg'); width: 100%; ">
            <!--begin::Content-->
            <div class="d-flex flex-column flex-center py-7 py-lg-15 px-5 px-md-15 w-100">
                <!--begin::Logo-->
                <a href="index.html" class="mb-0 mb-lg-12">
                <img alt="Logo" src="" class="h-60px h-lg-75px" />
                </a>
                <!--end::Logo-->
                <!--begin::Image-->
                <img class="d-none d-lg-block mx-auto w-275px w-md-50 w-xl-500px mb-10 mb-lg-20" src="" alt="" />
                <!--end::Image-->
                <!--begin::Title-->
                <h1 class="d-none d-lg-block fs-2qx fw-bolder text-center mb-7" style="color:black">Fast, Efficient and Productive</h1>
                <!--end::Title-->
                <!--begin::Text-->
                <div class="d-none d-lg-block fs-base text-center" style="color:black">
                In this kind of post, 
                <a href="#" class="opacity-75-hover text-warning fw-bold me-1">the blogger</a> introduces a person they’ve interviewed 
                <br /> and provides some background information about 
                <a href="#" class="opacity-75-hover text-warning fw-bold me-1">the interviewee</a> and their 
                <br /> work following this is a transcript of the interview.
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

// 비밀번호 찾기로 이동
function goToFindPassword() {
router.push({ path: "/findpassword"});
}

// 아이디 찾기로 이동
function goToFinId() {
router.push({ path: "/findid"});
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
