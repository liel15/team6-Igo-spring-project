import { ref } from "vue";
import { defineStore } from "pinia";
import { login } from "@/api/user";
import router from "@/router/index.js";
import { getTestList, getPostList, getPostByNo } from '@/api/test'

export const useTestStore = defineStore("test", () => {
  const data = ref(null);  // 로그인 후 데이터를 저장할 상태?
  const error = ref(null); // 에러 메시지를 저장할 상태 => 이건 없어도 될 듯

  async function handleLogin(id, password) {
    try {
      const response = await login(id, password); // 로그인 함수 호출(import)
      data.value = response; // 입력받은 아이디와 비밀번호에 해당하는 값 저장(vo에 있는 것들..?)
      error.value = null; // 에러 초기화
      alert("로그인 성공");
      console.log(data.value);
      router.push({ path: "/about"});
    } catch (err) {
      error.value = err.message; // 에러 메시지를 상태에 저장
    }
  }
  return { data, error, handleLogin };
});

export const usePostListStore = defineStore('test', () => {
  const postlist = ref([]);
  async function fetchPost() {
    console.log("Fetching postlist -- 화이팅");
    postlist.value = await getPostList();
    console.log("postlist--",postlist.value);
  }

  return { postlist, fetchPost }
})

export const usePostStore = defineStore('test', () => {
  const postone = ref({});
  async function fetchPostone(postNo) {
    console.log("Fetching post with ID:", postNo);
    postone.value = await getPostByNo(postNo);
  }

  return { postone, fetchPostone }
})
