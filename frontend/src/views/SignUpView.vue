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
             <div class="w-lg-500px p-10">
               <!--begin::Form-->
               <form class="form w-100" @submit.prevent="signup" novalidate="novalidate" id="kt_sign_up_form" data-kt-redirect-url="authentication/layouts/corporate/sign-in.html" action="#">
                 <!--begin::Heading-->
                 <div class="text-center mb-11">
                   <!--begin::Title-->
                   <h1 class="text-gray-900 fw-bolder mb-3">회원가입</h1>
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
 
 
                      <!-- 이미지 파일 선택 -->
                      <div>
                        <input type="file" id="image" @change="getFileName" />
                        <label for="image">
                          <!-- 파일을 선택하면 이 부분이 갱신 -->
                          <img :src="previewUrl || '/images/user.png'" alt="Selected Image" />

                        </label>
                      </div>
 
 
                   </div>
                   <!--end::Col-->
                   <!--begin::Col-->
                   <div class="col-md-6">
                     <!--begin::Google link=-->
                     <a href="#" class="btn btn-flex btn-outline btn-text-gray-700 btn-active-color-primary bg-state-light flex-center text-nowrap w-100">
                     <img alt="Logo" src="/images/cat_run.png" class="theme-light-show h-15px me-3" />
                     <img alt="Logo" src="/images/cat_run.png" class="theme-dark-show h-15px me-3" />Sign in with Apple</a>
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
                     <input type="text" placeholder="id" name="id" autocomplete="off" class="form-control bg-transparent" v-model="id">
                     <!--end::아이디-->
 
                   </div>
                   <!--begin::Input group-->
                   <div class="fv-row mb-8" data-kt-password-meter="true">
                     <!--begin::Wrapper-->
                     <div class="mb-1">
 
                       <!--begin::비밀번호-->
                       <div class="position-relative mb-3">
                         <input class="form-control bg-transparent" type="password" placeholder="Password" name="password" autocomplete="off" v-model="password">
                         <span class="btn btn-sm btn-icon position-absolute translate-middle top-50 end-0 me-n2" data-kt-password-meter-control="visibility">
                           <i class="ki-duotone ki-eye-slash fs-2"></i>
                           <i class="ki-duotone ki-eye fs-2 d-none"></i>
                         </span>
                       </div>
                       <!--end::비밀번호-->
 
                       <!--begin::Meter-->
                       <div class="d-flex align-items-center mb-3" data-kt-password-meter-control="highlight">
                         <div class="flex-grow-1 bg-secondary bg-active-success rounded h-5px me-2"></div>
                         <div class="flex-grow-1 bg-secondary bg-active-success rounded h-5px me-2"></div>
                         <div class="flex-grow-1 bg-secondary bg-active-success rounded h-5px me-2"></div>
                         <div class="flex-grow-1 bg-secondary bg-active-success rounded h-5px"></div>
                       </div>
                       <!--end::Meter-->
                     </div>
                     <!--end::Wrapper-->
                     <!--begin::Hint-->
                     <div class="text-muted">Use 8 or more characters with a mix of letters, numbers & symbols.</div>
                     <!--end::Hint-->
                   </div>
                   <!--end::Input group=-->
                   <!--end::Input group=-->
                   <div class="fv-row mb-8">
                     <!--begin::Repeat Password-->
                     <input placeholder="Repeat Password" name="confirm-password" type="password" autocomplete="off" class="form-control bg-transparent" />
                     <!--end::Repeat Password-->
 
                   <!--begin::Input group=-->
                   <div class="fv-row mb-8 mt-8">
 
                     <!--begin::이름-->
                     <input type="text" placeholder="name" name="name" autocomplete="off" class="form-control bg-transparent" v-model="name">
                     <!--end::이름-->
 
                   </div>
 
                   <!--begin::Input group=-->
                   <div class="fv-row mb-8 mt-8">
 
                     <!--begin::이메일-->
                     <input type="email" placeholder="email" name="email" autocomplete="off" class="form-control bg-transparent" v-model="email">
                     <!--end::이메일-->
 
                   </div>
 
                   <!--begin::Input group=-->
                   <div class="fv-row mb-8 mt-8">
 
                     <!--begin::전화번호-->
                     <input type="tel" placeholder="tel" name="tel" autocomplete="off" class="form-control bg-transparent" v-model="tel">
                     <!--end::전화번호-->
 
                   </div>
 
                   <!--begin::Input group=-->
                   <div class="fv-row mb-8 mt-8">
 
                     <!--begin::생일-->
                     <input type="date" class="form-control bg-transparent" v-model="birth">
                     <!--end::생일-->
 
                   </div>
 
                   <!--begin::Input group=-->
                   <div class="fv-row mb-8 mt-8">
 
                   </div>
 
                   <!--begin::키워드-->
                  <div class="fv-row mb-8 mt-8">
                   
                   <fieldset style="border: 1px solid #ccc; padding: 15px; margin-bottom: 20px;">
                     <legend style="font-size: 1.2em; padding: 0 10px;">당신에 대해 알려주세요!</legend>
 
                     <!--begin::성별-->
                     <div>
                        <input type="radio" id="male" value="M" v-model="selectedgender" />
                        <label for="male">남성</label>
                        
                        <input type="radio" id="female" value="W" v-model="selectedgender" class="ms-10" />
                        <label for="female">여성</label>
                      </div>

                     <!--end::성별-->
                     
                      <!--begin::mbti-->
                     <div class="form-group mt-3">
                       <label for="mbti" >MBTI:</label>
                       <select v-model="mbti" id="mbti" name="mbti" class="form-control">
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
                       <label for="category">구분:</label>
                       <select v-model="number" id="number" name="number" class="form-control">
                         <option value="" disabled>선택하기</option>
                         <option value="개인">개인</option>
                         <option value="단체">단체</option>
                       </select>
                     </div>
                     
                     <div class="form-group mt-3">
                       <label for="region">선호 지역:</label>
                       <select  v-model="location" id="location" name="location" class="form-control">
                         <option value="" disabled>선택하기</option>
                         <option value="서울특별시">서울특별시</option>
                         <option value="부산광역시">부산광역시</option>
                         <option value="대구광역시">대구광역시</option>
                         <option value="인천광역시">인천광역시</option>
                         <option value="광주광역시">광주광역시</option>
                         <option value="대전광역시">대전광역시</option>
                         <option value="울산광역시">울산광역시</option>
                         <option value="세종특별자치시">세종특별자치시</option>
                       </select>
                     </div>
                     
                     <div class="form-group mt-3">
                       <label for="preference">여행 취향:</label>
                       <select  v-model="type" id="type" name="type" class="form-control">
                         <option value="" disabled>선택하기</option>
                         <option value="익스트림">익스트림</option>
                         <option value="힐링">힐링</option>
                       </select>
                     </div>
                     
                     <div class="form-group mt-3">
                       <label for="transport">이동수단:</label>
                       <select  v-model="mobility" id="mobility" name="mobility" class="form-control">
                         <option value="" disabled>선택하기</option>
                         <option value="뚜벅이">뚜벅이</option>
                         <option value="차">차</option>
                         <option value="대중교통">대중교통</option>
                       </select>
                     </div>
                     
                     <div class="form-group mt-3">
                       <label for="accommodation">숙소:</label>
                       <select  v-model="house" id="house" name="house" class="form-control">
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
                 <!--begin::Accept-->
                 <div class="fv-row mb-8">
                   <label class="form-check form-check-inline">
                     <input class="form-check-input" type="checkbox" name="toc" value="1" />
                     <span class="form-check-label fw-semibold text-gray-700 fs-base ms-1">I Accept the 
                     <a href="#" class="ms-1 link-primary">Terms</a></span>
                   </label>
                 </div>
                 <!--end::Accept-->
                 <!--begin::Submit button-->
                 <div class="d-grid mb-10">
                   <button type="submit" id="kt_sign_up_submit" class="btn btn-primary">
                     <!--begin::Indicator label-->
                     <span class="indicator-label">회원가입하기</span>
                     <!--end::Indicator label-->
                     <!--begin::Indicator progress-->
                     <span class="indicator-progress">Please wait... 
                     <span class="spinner-border spinner-border-sm align-middle ms-2"></span></span>
                     <!--end::Indicator progress-->
                   </button>
                 </div>
                 <!--end::Submit button-->
                 <!--begin::Sign up-->
                 <div class="text-gray-500 text-center fw-semibold fs-6">Already have an Account? 
                 <a href="authentication/layouts/corporate/sign-in.html" class="link-primary fw-semibold">Sign in</a></div>
                 <!--end::Sign up-->
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
               <button class="btn btn-flex btn-link btn-color-gray-700 btn-active-color-primary rotate fs-base" data-kt-menu-trigger="click" data-kt-menu-placement="bottom-start" data-kt-menu-offset="0px, 0px">
                 <img data-kt-element="current-lang-flag" class="w-20px h-20px rounded me-3" src="/images/cat_run.png" alt="" />
                 <span data-kt-element="current-lang-name" class="me-1">English</span>
                 <span class="d-flex flex-center rotate-180">
                   <i class="ki-duotone ki-down fs-5 text-muted m-0"></i>
                 </span>
               </button>
               <!--end::Toggle-->
               <!--begin::Menu-->
               <div class="menu menu-sub menu-sub-dropdown menu-column menu-rounded menu-gray-800 menu-state-bg-light-primary fw-semibold w-200px py-4 fs-7" data-kt-menu="true" id="kt_auth_lang_menu">
                 <!--begin::Menu item-->
                 <div class="menu-item px-3">
                   <a href="#" class="menu-link d-flex px-5" data-kt-lang="English">
                     <span class="symbol symbol-20px me-4">
                       <img data-kt-element="lang-flag" class="rounded-1" src="/images/cat_run.png
                       " alt="" />
                     </span>
                     <span data-kt-element="lang-name">English</span>
                   </a>
                 </div>
                 <!--end::Menu item-->
                 <!--begin::Menu item-->
                 <div class="menu-item px-3">
                   <a href="#" class="menu-link d-flex px-5" data-kt-lang="Spanish">
                     <span class="symbol symbol-20px me-4">
                       <img data-kt-element="lang-flag" class="rounded-1" src="/images/cat_run.png
                       " alt="" />
                     </span>
                     <span data-kt-element="lang-name">Spanish</span>
                   </a>
                 </div>
                 <!--end::Menu item-->
                 <!--begin::Menu item-->
                 <div class="menu-item px-3">
                   <a href="#" class="menu-link d-flex px-5" data-kt-lang="German">
                     <span class="symbol symbol-20px me-4">
                       <img data-kt-element="lang-flag" class="rounded-1" src="/images/cat_run.png" alt="" />
                     </span>
                     <span data-kt-element="lang-name">German</span>
                   </a>
                 </div>
                 <!--end::Menu item-->
                 <!--begin::Menu item-->
                 <div class="menu-item px-3">
                   <a href="#" class="menu-link d-flex px-5" data-kt-lang="Japanese">
                     <span class="symbol symbol-20px me-4">
                       <img data-kt-element="lang-flag" class="rounded-1" src="/images/cat_run.png" alt="" />
                     </span>
                     <span data-kt-element="lang-name">Japanese</span>
                   </a>
                 </div>
                 <!--end::Menu item-->
                 <!--begin::Menu item-->
                 <div class="menu-item px-3">
                   <a href="#" class="menu-link d-flex px-5" data-kt-lang="French">
                     <span class="symbol symbol-20px me-4">
                       <img data-kt-element="lang-flag" class="rounded-1" src="/images/cat_run.png" alt="" />
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
         <div class="d-flex flex-lg-row-fluid w-lg-50 bgi-size-cover bgi-position-center order-1 order-lg-2" style="background-image: url(assets/media/misc/auth-bg.png)">
           <!--begin::Content-->
           <div class="d-flex flex-column flex-center py-7 py-lg-15 px-5 px-md-15 w-100">
             <!--begin::Logo-->
             <a href="index.html" class="mb-0 mb-lg-12">
               <img alt="Logo" src="/images/cat_run.png" class="h-60px h-lg-75px" />
             </a>
             <!--end::Logo-->
             <!--begin::Image-->
             <img class="d-none d-lg-block mx-auto w-275px w-md-50 w-xl-500px mb-10 mb-lg-20" src="/images/cat_run.png" alt="" />
             <!--end::Image-->
             <!--begin::Title-->
             <h1 class="d-none d-lg-block text-white fs-2qx fw-bolder text-center mb-7">Fast, Efficient and Productive</h1>
             <!--end::Title-->
             <!--begin::Text-->
             <div class="d-none d-lg-block text-white fs-base text-center">In this kind of post, 
             <a href="#" class="opacity-75-hover text-warning fw-bold me-1">the blogger</a>introduces a person they’ve interviewed 
             <br />and provides some background information about 
             <a href="#" class="opacity-75-hover text-warning fw-bold me-1">the interviewee</a>and their 
             <br />work following this is a transcript of the interview.</div>
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

export default {
  data() {
    return {
      id: "",
      password: "",
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
    };
  },

  methods: {
    async signup() {
      try {
        // FormData를 사용하여 JSON 데이터와 이미지 데이터를 함께 전송
        const formData = new FormData();
        
        // 1. user JSON 데이터를 FormData에 추가
        const signupData = {
          userId: this.id,
          userPw: this.password,
          userName: this.name,
          userEmail: this.email,
          userTel: this.tel,
          userBirth: this.birth,
          userGender : this.selectedgender
        };

        // 1. keyword JSON 데이터를 FormData에 추가
        const keywordData = {
          keywordMbti: this.mbti,
          keywordSort: this.number,
          keywordLocation: this.location,
          keywordType: this.type,
          keywordMobility: this.mobility,
          keywordHouse: this.house,
        };
        
        // Blob으로 변환하여 JSON 데이터를 추가
        formData.append(
          "user", 
          new Blob([JSON.stringify(signupData)], { type: "application/json" })
        );
        formData.append(
          "keyword",
          new Blob([JSON.stringify(keywordData)], {type : "application/json" })
        );
        
        // 2. 이미지 파일이 선택된 경우 FormData에 이미지 추가
        if (this.img) {
          formData.append("userImage", this.img); // 이미지 파일 추가
          
          // 값이 잘 넘어가는지 확인
          for (let pair of formData.entries()) {
            console.log(pair[0] + ": " + pair[1]); // key와 value 출력
          }

          // 파일 정보 출력
          console.log("파일명:", this.img.name);
          console.log("파일 크기:", this.img.size);
          console.log("파일 타입:", this.img.type);
        }

        // 서버로 회원가입 정보 및 이미지 파일 전송
        const response = await axios.post(
          "http://localhost:9000/backend/api/auth/signup.do",
          formData,
          {
            headers: {
              "Content-Type": "multipart/form-data",
            },
          }
        );

        alert("회원가입 성공!");
        this.$router.push({ name: "home" });
      } catch (error) {
        this.error = "회원가입 실패: " + error.message;
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
  },
};
</script>

 
 
 <style scoped>
 .form-container {
   display: flex;
   flex-direction: column; /* 요소들을 세로로 배치 */
   max-width: 100px; /* 적절한 너비 설정 */
   margin: auto; /* 가운데 정렬을 원한다면 사용 */
 }
 </style> 