<template>
  <!--begin::Root-->
  <div class="d-flex flex-column flex-root" id="kt_app_root">
    <!--begin::Authentication - Sign-up -->
    <div class="d-flex flex-column flex-lg-row flex-column-fluid">
      <!--begin::Body-->
      <div class="d-flex flex-column flex-lg-row-fluid w-lg-50 p-10 order-2 order-lg-1">
        <!--begin::Form-->
        <div class="d-flex flex-center flex-column flex-lg-row-fluid">
          <!--begin::Wrapper-->
          <div class="w-lg-400px p-10">
            <!--begin::Form-->
            <form
              class="form w-100"
              @submit.prevent="edituser"
              novalidate="novalidate"
              id="kt_sign_up_form"
              data-kt-redirect-url="authentication/layouts/corporate/sign-in.html"
              action="#"
            >
              <!--begin::Heading-->
              <div class="text-center mb-11">
                <!--begin::Title-->
                <h1 class="text-gray-900 fw-bolder mb-3">회원정보수정</h1>
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
                  <h2>프로필사진</h2>
                  <!-- 이미지 파일 선택 -->
                  <div>
                    <input type="file" id="image" @change="getFileName" style="display: none;"/>
                    <label for="image">
                      <!-- 파일을 선택하면 이 부분이 갱신 -->
                      <img
                        :src="previewUrl || img || '/images/user.png'"
                        alt="Selected Image"
                        class="profile-image"                      
                      />
                    </label>
                  </div>
                </div>

                <!--end::Col-->
                <!--begin::Col-->
                <div class="col-md-6">
                  <!--begin::여행로고=-->               
                  <img
                    src="/images/travel_logo.jpg"
                    alt="Travel Logo"
                    class="logo-image ms-4"
                  />                
                  <!--end::여행로고=-->
                </div>
                <!--end::Col-->
              </div>
              <!--end::Login options-->
              <!--begin::Separator-->
              <div class="separator separator-content my-14">
                <span class="w-200px text-gray-500 fw-semibold fs-7">기본 정보 입력</span>
              </div>
              <!--end::Separator-->
              <!--begin::Input group=-->
              <div class="fv-row mb-8">
                <!--begin::아이디-->
                <input
                  type="text"
                  placeholder="id"
                  name="id"
                  autocomplete="off"
                  class="form-control bg-transparent"
                  v-model="id"
                  readonly="readonly"
                />
                <!--end::아이디-->           

              </div>
              <!--begin::Input group-->
              <div class="fv-row mb-8" data-kt-password-meter="true">
                <!--begin::Wrapper-->
                <div class="mb-1">
                  <!--begin::비밀번호-->
                  <div class="position-relative mb-3">
                    <input
                      class="form-control bg-transparent"
                      type="password"
                      placeholder="Password"
                      name="password"
                      autocomplete="off"
                      v-model="password"
                    />
                    <span
                      class="btn btn-sm btn-icon position-absolute translate-middle top-50 end-0 me-n2"
                      data-kt-password-meter-control="visibility"
                    >
                      <i class="ki-duotone ki-eye-slash fs-2"></i>
                      <i class="ki-duotone ki-eye fs-2 d-none"></i>
                    </span>
                  </div>
                  <!--end::비밀번호-->

                  <!--begin::Meter-->
                  <div
                    class="d-flex align-items-center mb-3"
                    data-kt-password-meter-control="highlight"
                  >
                    <div
                      class="flex-grow-1 bg-secondary bg-active-success rounded h-5px me-2"
                    ></div>
                    <div
                      class="flex-grow-1 bg-secondary bg-active-success rounded h-5px me-2"
                    ></div>
                    <div
                      class="flex-grow-1 bg-secondary bg-active-success rounded h-5px me-2"
                    ></div>
                    <div
                      class="flex-grow-1 bg-secondary bg-active-success rounded h-5px"
                    ></div>
                  </div>
                  <!--end::Meter-->
                </div>
                <!--end::Wrapper-->
                <!--begin::Hint-->
                <div class="text-muted">
                  Use 8 or more characters with a mix of letters, numbers & symbols.
                </div>
                <!--end::Hint-->
              </div>
              <!--end::Input group=-->
              <!--end::Input group=-->

              <div class="fv-row mb-8">
                <!--begin::비밀번호 확인-->
                <input
                  placeholder="Repeat Password"
                  name="confirmPassword"
                  type="password"
                  autocomplete="off"
                  class="form-control bg-transparent"
                  v-model="confirmPassword"
                />
                <!--end::비밀번호 확인-->

                <!--begin::Input group=-->
                <div class="fv-row mb-8 mt-8">
                  <!--begin::이름-->
                  <input
                    type="text"
                    placeholder="name"
                    name="name"
                    autocomplete="off"
                    class="form-control bg-transparent"
                    v-model="name"
                  />
                  <!--end::이름-->
                </div>

                <!--begin::Input group=-->
                <div class="fv-row mb-8 mt-8">
                  <!--begin::이메일-->
                  <input
                    type="email"
                    placeholder="email"
                    name="email"
                    autocomplete="off"
                    class="form-control bg-transparent"
                    v-model="email"
                  />
                  <!--end::이메일-->
                </div>

                <!--begin::Input group=-->
                <div class="fv-row mb-8 mt-8">
                  <!--begin::전화번호-->
                  <input
                    type="tel"
                    placeholder="tel"
                    name="tel"
                    autocomplete="off"
                    class="form-control bg-transparent"
                    v-model="tel"
                  />
                  <!--end::전화번호-->
                </div>

                <!--begin::Input group=-->
                <div class="fv-row mb-8 mt-8">
                  <!--begin::생일-->
                  <input
                    type="date"
                    class="form-control bg-transparent"
                    v-model="birth"
                    style="cursor:pointer"
                  />
                  <!--end::생일-->
                </div>

                <!--begin::Input group=-->
                <div class="fv-row mb-8 mt-8"></div>

                <!--begin::키워드-->
                <div class="fv-row mb-8 mt-8">
                  <fieldset
                    style="border: 1px solid #ccc; padding: 15px; margin-bottom: 20px"
                  >
                    <legend style="font-size: 1.2em; padding: 0 10px">
                      당신에 대해 알려주세요!
                    </legend>

                    <!--begin::성별-->
                    <div>
                      <input type="radio" id="male" value="M" v-model="selectedgender" style="cursor:pointer"/>
                      <label for="male">남성</label>

                      <input
                        type="radio"
                        id="female"
                        value="Y"
                        v-model="selectedgender"
                        class="ms-10"
                        style="cursor:pointer"
                      />
                      <label for="female">여성</label>
                    </div>

                    <!--end::성별-->

                    <!--begin::mbti-->
                    <div class="form-group mt-3" >
                      <label for="mbti">MBTI:</label>
                      <select v-model="mbti" id="mbti" name="mbti" class="form-control" style="cursor:pointer">
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
                        <option value="ESTJ" >ESTJ</option>
                        <option value="ESFJ">ESFJ</option>
                        <option value="ENFJ">ENFJ</option>
                        <option value="ENTJ">ENTJ</option>
                      </select>
                    </div>
                    <!--end::mbti-->

                    <div class="form-group mt-3">
                      <label for="category">구분:</label>
                      <select
                        v-model="number"
                        id="number"
                        name="number"
                        class="form-control"
                         style="cursor:pointer"
                      >
                        <option value="" disabled>선택하기</option>
                        <option value="개인">개인</option>
                        <option value="단체">단체</option>
                      </select>
                    </div>

                    <div class="form-group mt-3">
                      <label for="region">선호 지역:</label>
                      <select
                        v-model="location"
                        id="location"
                        name="location"
                        class="form-control"
                         style="cursor:pointer"
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
                      <label for="preference">여행 취향:</label>
                      <select v-model="type" id="type" name="type" class="form-control" style="cursor:pointer">
                        <option value="" disabled>선택하기</option>
                        <option value="익스트림">익스트림</option>
                        <option value="힐링">힐링</option>
                      </select>
                    </div>

                    <div class="form-group mt-3">
                      <label for="transport">이동수단:</label>
                      <select
                        v-model="mobility"
                        id="mobility"
                        name="mobility"
                        class="form-control"
                         style="cursor:pointer"
                      >
                        <option value="" disabled>선택하기</option>
                        <option value="뚜벅이">뚜벅이</option>
                        <option value="차">차</option>
                        <option value="대중교통">대중교통</option>
                      </select>
                    </div>

                    <div class="form-group mt-3">
                      <label for="accommodation">숙소:</label>
                      <select
                        v-model="house"
                        id="house"
                        name="house"
                        class="form-control"
                         style="cursor:pointer"
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
              </div>
              <!--end::Input group=-->

              <!--begin::Submit button-->
              <div class="d-grid mb-10">
                <button type="submit" id="kt_sign_up_submit" class="btn btn-primary">
                  <!--begin::Indicator label-->
                  <span class="indicator-label">수정하기</span>
                  <!--end::Indicator label-->
                </button>
              </div>

              <!--end::Submit button-->
              <!--begin::Sign up-->
              <div class="text-gray-500 text-center fw-semibold fs-6">
                우리와의 여행을 끝내고 싶은신가요?
                <a @click="" class="link-primary fw-semibold" style="cursor:pointer">탈퇴하기</a>
              </div>
              <!--end::Sign up-->
            </form>
            <!--end::Form-->
          </div>
          <!--end::Wrapper-->
        </div>
        <!--end::Form-->
        <!--begin::Footer-->
        <div class="w-lg-500px d-flex flex-stack px-10 mx-auto"></div>
        <!--end::Footer-->
      </div>
      <!--end::Body-->

<!--begin::Aside-->
<div
        class="d-flex flex-lg-row-fluid bgi-size-cover bgi-position-center order-1 order-lg-2"
        style="background-image: url('/images/moonback.jpg'); width: 70%; background-size: cover; background-repeat: no-repeat; background-position: center;"
      >
        <!--begin::Content-->
        <div class="d-flex flex-column flex-center py-7 py-lg-15 px-5 px-md-15 w-100">

          <!--begin::Image-->
          <img
            class="d-none d-lg-block mx-auto w-275px w-md-50 w-xl-500px mb-10 mb-lg-20"
            src=""
            alt=""
          />
          <!--end::Image-->
          <!--begin::Title-->
          <h1
            class="d-none d-lg-block fs-2qx fw-bolder text-center mb-7"
            style="color: black"
          >
            Fast, Efficient and Productive
          </h1>
          <!--end::Title-->
          <!--begin::Text-->
          <div class="d-none d-lg-block fs-base text-center" style="color: black">
            In this kind of post,
            <a href="#" class="opacity-75-hover text-warning fw-bold me-1">the blogger</a>
            introduces a person they’ve interviewed <br />
            and provides some background information about
            <a href="#" class="opacity-75-hover text-warning fw-bold me-1"
              >the interviewee</a
            >
            and their <br />
            work following this is a transcript of the interview.
          </div>
          <!--end::Text-->
        </div>
        <!--end::Content-->
      </div>

      <!--end::Aside-->

    </div>
    <!--end::Authentication - Sign-up-->
  </div>
  <!--end::Root-->
</template>

<script>
import axios from "axios";
import { ref } from 'vue';
import {useRouter} from 'vue-router';

const router = useRouter();

export default {
  data() {
    return {
      id: "",
      password: "",
      confirmPassword: "",
      name: "",
      email: "",
      tel: "",
      birth: "",
      selectedgender: "",
      mbti: "",
      number: "",
      location: "",
      type: "",
      mobility: "",
      house: "",
      img: null,
      previewUrl: null,
      error: null,
      idCheckResult: ref('')
    };
  },
  
  mounted() {
    this.loadUserData();
  },

  methods: {
    loadUserData() {
      const userData = JSON.parse(sessionStorage.getItem("userData"));
    if (userData) {
      console.log("가져온 데이터 : ", userData);
      
      this.img = userData.userImage;
      this.previewUrl = `http://localhost:9000/backend/api/auth${userData.userImage}`;
      this.id = userData.userId;
      this.name = userData.userName;
      this.email = userData.userEmail;
      this.tel = userData.userTel;
      this.birth = userData.userBitrh;
      this.selectedgender = userData.userGender;
      this.mbti = userData.keywordMbti;
      this.number = userData.keywordSort;
      this.location = userData.keywordLocation;
      this.type = userData.keywordType;
      this.mobility = userData.keywordMobility;
      this.house = userData.keywordHouse;
   }
    },

    async edituser() {
      try {

        if (!this.password) {
          alert("비밀번호를 입력해주세요.");
          return;
        }

        if (!this.confirmPassword) {
          alert("비밀번호 확인을 입력해주세요.");
          return;
        }

        if (this.password.trim() !== this.confirmPassword.trim()) {
          alert("비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
          return;
        }

        if (!this.name) {
          alert("이름을 입력해주세요.");
          return;
        }
        if (!this.email) {
          alert("이메일을 입력해주세요.");
          return;
        }
        if (!this.tel) {
          alert("전화번호를 입력해주세요.");
          return;
        }
        if (!this.birth) {
          alert("생년월일을 입력해주세요.");
          return;
        }
        if (!this.selectedgender) {
          alert("성별을 선택해주세요.");
          return;
        }
        if (!this.mbti) {
          alert("MBTI를 선택해주세요.");
          return;
        }
        if (!this.number) {
          alert("구분을 선택해주세요.");
          return;
        }
        if (!this.location) {
          alert("선호 지역을 선택해주세요.");
          return;
        }
        if (!this.type) {
          alert("여행 취향을 선택해주세요.");
          return;
        }
        if (!this.mobility) {
          alert("이동 수단을 선택해주세요.");
          return;
        }
        if (!this.house) {
          alert("숙소를 선택해주세요.");
          return;
        }

        // FormData를 사용하여 JSON 데이터와 이미지 데이터를 함께 전송
        const formData = new FormData();

        
        const userKeywordData = {
          userId: this.id,
          userPw: this.password,
          userName: this.name,
          userEmail: this.email,
          userTel: this.tel,
          userBirth: this.birth,
          userGender: this.selectedgender,
          keywordMbti: this.mbti,
          keywordSort: this.number,
          keywordLocation: this.location,
          keywordType: this.type,
          keywordMobility: this.mobility,
          keywordHouse: this.house,
        };

        // Blob으로 변환하여 JSON 데이터를 추가
        formData.append(
          "userKeyword",
          new Blob([JSON.stringify(userKeywordData)], { type: "application/json" })
        );
  
       // 이미지가 변경된 경우에만 FormData에 추가
      if (this.img && this.previewUrl !== `http://localhost:9000/backend/api/auth${this.img}`) {
        formData.append("userImage", this.img); // 이미지 파일 추가
      } else {
        // 이미지가 변경되지 않았다면 기존 이미지 정보 추가
        formData.append("existingImagePath", this.img);
      }

        // 서버로 회원가입 정보 및 이미지 파일 전송
        const response = await axios.post(
          "http://localhost:9000/backend/api/auth/updateuser",
          formData,
          {
            headers: {
              "Content-Type": "multipart/form-data",
            },
          }
        );
        const updateUserData = response.data;
        sessionStorage.setItem("userData", JSON.stringify(updateUserData));

        alert("회원정보 수정 성공!");
        this.$router.push('/mypage');
        // 수정코드가 화면에 반영되게 설정
        this.loadUserData();
       
      } catch (error) {
        this.error = "회원정보 수정 실패: " + error.message;
      }
    },

    // 이미지 파일 선택 시 미리보기 URL 설정
    getFileName(event) {
      const file = event.target.files[0];
      if (file) {
        this.img = file; // 선택된 이미지를 저장
        this.previewUrl = URL.createObjectURL(file); // 이미지 미리보기 URL 생성
      }
    },
    goToLogin() {
      this.$router.push({ path: "/login" });
    },
  },
};
</script>

<style scoped>

/* 프로필 사진 */
.profile-image {
  width: 100px; 
  height: 100px;
  object-fit: cover; 
  border-radius: 50%;
  margin-top: 30px; 
  cursor:pointer;
  margin-left: 10px;
}

.logo-image {
  width: 150px;
  height: 150px;
  object-fit: cover;
  margin-top: 30px;
  border-radius: 20px;
}


</style>
