import { ref } from "vue";
import { defineStore } from "pinia";



export const useTestStore = defineStore("toggleLog", () => {
    const startBt = ref("로그인"); //초기값

    function log() {
        console.log(startBt);
    if (startBt.value == "로그인") {
        startBt.value = "로그아웃";
    } else {
        startBt.value = "로그인";
    }
    }
  return { startBt, log };
});


//사용자 임시 데이터
export const useTestData = defineStore("logdata", ()=> {
    
    
    const user = ref({ id: "dididi", name: "회원1", mbit: "tttt", post: "5" });

    const type = ref({
        mbit: "tttt",
        num: "num",
        location: "서울",
        type: "익스트림",
        mobility: "대중교통",
        house: "호캉스",
        house: "hotel",
    }
    )
    return { user, type };
})

export const useUserStore = defineStore("user", () => {
    const userData = ref(null); // 로그인시 받는 정보 : 아이디, 비번
    const userInfo = ref(null); // 유저의 상세 정보
    const error = ref(null);
  
    async function handleLogin(id, password) {
      try {
        const response = await login(id, password);
        userData.value = response.data; //저장됨
        error.value = null;
        alert("로그인 성공");
        console.log("Login data:", userData.value); //로그인하면서 유저 데이터가 저장됨(알림).

        await fetchUserInfo(); //유저 정보 가져오는거 : 밑에서 구현
        router.push({ path: "/main" }); //물어보기 : about페이지?
      } catch (err) {
        error.value = err.message;
        console.error("Login error:", err);
      }
    }
  
    async function fetchUserInfo() { //유저정보 가져오는거
      if (!userData.value || !userData.value.id) {
        console.error("User data not available. Please login first.");
        return;
      }
  
      try {
        const response = await getUserInfo(userData.value.id); //아이디에 해당하는 유저 정보 가져오기 (유저아이디)
        userInfo.value = response.data;
        console.log("User info:", userInfo.value);
      } catch (err) {
        error.value = err.message;
        console.error("Error fetching user info:", err);
      }
    }
  
    return { userData, userInfo, error, handleLogin, fetchUserInfo };
  });