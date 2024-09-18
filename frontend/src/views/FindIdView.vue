<template>
  <!--begin::Root-->
  <div class="d-flex flex-column flex-root" id="kt_app_root" style="height: 100vh;">
    <!--begin::Authentication - Sign-up -->
    <div class="d-flex flex-column flex-lg-row flex-column-fluid">
      <!--begin::Body-->
      <div class="d-flex flex-column flex-lg-row-fluid w-lg-50 p-10 order-2 order-lg-1">
        <!--begin::Form-->
        <div class="d-flex flex-center flex-column flex-lg-row-fluid">
          <!--begin::Wrapper-->
          <div class="w-lg-500px p-10">
            <!--begin::Form-->
            <!--begin::Aside-->
            <!--begin::Body-->
            <div
              class="d-flex flex-column-fluid flex-lg-row-auto justify-content-center justify-content-lg-end p-12"
            >
              <!--begin::Wrapper-->
              <div
                class="bg-body d-flex flex-column flex-center rounded-4 w-md-600px p-10"
              >
                <!--begin::Content-->
                <div
                  class="d-flex flex-center flex-column align-items-stretch h-lg-100 w-md-400px"
                >
                  <!--begin::Wrapper-->
                  <div
                    class="d-flex flex-center flex-column flex-column-fluid pb-15 pb-lg-20"
                  >
                    <!--begin::Form-->
                    <form
                      class="form w-100"
                      novalidate="novalidate"
                      id="kt_new_password_form"
                      data-kt-redirect-url="authentication/layouts/overlay/sign-in.html"
                      action="#"
                    >
                      <!--begin::Heading-->
                      <div class="text-center mb-10">
                        <!--begin::Title-->
                        <h1 class="text-gray-900 fw-bolder mb-3">아이디 찾기</h1>
                        <!--end::Title-->
                        <!--begin::Link-->
                        <div class="text-gray-500 fw-semibold fs-6">
                          계정이 없으신가요 ?
                          <a @click="goToSignUp" class="link-primary fw-bold" style="cursor:pointer">회원가입</a>
                        </div>
                        <!--end::Link-->
                      </div>
                      <!--begin::Heading-->

                   
                      <!--begin::Input group-->
                      <div class="fv-row mb-8" data-kt-password-meter="true">
                        <!--begin::Wrapper-->
                        <div class="mb-1">
                          <!--begin::Input wrapper-->
                          <div class="position-relative mb-3">
                            <input
                              class="form-control bg-transparent"
                              type="name"
                              placeholder="Name"
                              name="name"
                              v-model="name"
                            />
                          </div>
                          <!--end::Input wrapper-->
                        </div>
                        <!--end::Wrapper-->
                      </div>
                      <!--end::Input group=-->

                      <div class="fv-row mb-8">
                        <!--begin::이메일 입력-->
                        <input
                          type="email"
                          placeholder="Email"
                          name="email"
                          autocomplete="off"
                          class="form-control bg-transparent"
                          v-model="email"
                        />
                        <!--end::이메일 입력-->
                      </div>
                      <!--end::Input group=-->

                      <!--begin::Action-->
                      <div class="d-grid mb-10">
                        <button
                          type="button"
                          id="kt_new_password_submit"
                          class="btn btn-primary"
                          @click="handlefindId"
                        >
                          <!--begin::Indicator label-->
                          <span class="indicator-label">아이디 찾기</span>
                          <!--end::Indicator label-->
                        </button>
                      </div>
                      <!--end::Action-->

                    </form>
                    <!--end::Form-->
                  </div>
                  <!--end::Wrapper-->
                  <!--begin::Footer-->
                  <div class="w-lg-500px d-flex flex-stack"></div>
                  <!--end::Footer-->
                </div>
                <!--end::Content-->
              </div>
              <!--end::Wrapper-->
            </div>
            <!--end::Body-->
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref } from "vue";
import { useFindIdStore } from "@/stores/test"; // Pinia 스토어 가져오기
import router from "@/router/index.js";

const name = ref(""); // 이름
const email = ref(""); //email

const store = useFindIdStore(); // Pinia 스토어 사용
const { findId, error } = store; // 스토어에서 함수와 에러 상태 가져오기

// 비밀번호 찾기 함수 호출
function handlefindId() {
  findId(name.value, email.value); // 사용자가 입력한 이름, email을 넘겨줌
}

// 회원가입으로 이동
function goToSignUp() {
  router.push({ path: "/signup" });
}
</script>
