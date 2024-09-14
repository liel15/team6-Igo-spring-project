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

