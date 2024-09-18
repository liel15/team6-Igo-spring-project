import { ref } from "vue";
import { defineStore } from "pinia";
import { login } from "@/api/user";
import router from "@/router/index.js";
import { getTestList, getPostList, getPostByNo, getLikesPostList, toggleLikePost } from '@/api/test';

export const useTestStore = defineStore("test", () => {
  const data = ref(null);  // 로그인 후 데이터를 저장할 상태?
  const error = ref(null); // 에러 메시지를 저장할 상태 => 이건 없어도 될 듯

  async function handleLogin(id, password) {
    try {
      const response = await login(id, password); // 로그인 함수 호출(import)
      data.value = response; // 입력받은 아이디와 비밀번호에 해당하는 값 저장(vo에 있는 것들..?)
      console.log(response);
      error.value = null; // 에러 초기화
      sessionStorage.setItem("userNo", response.userNumber);
      alert("로그인 성공");
      console.log(data.value);
      router.push({ path: "/about"});
    } catch (err) {
      error.value = err.message; // 에러 메시지를 상태에 저장
    }
  }
  return { data, error, handleLogin };
});

//게시글 목록 가져오는 상태
export const usePostListStore = defineStore('postlist', () => {
  const postlist = ref([]);
  async function fetchPost() {
    console.log("Fetching postlist -- 화이팅");
    postlist.value = await getPostList();
    console.log("postlist--",postlist.value);
  }

  return { postlist, fetchPost }
})

//특정 게시글 db 가져오는 상태
export const usePostStore = defineStore('postByNo', () => {
  const postone = ref({});
  async function fetchPostone(postNo) {
    try {
      postone.value = await getPostByNo(postNo);
    } catch (err) {
      console.error('Error fetching post:', err);
    }
  }
  return { postone, fetchPostone };
});

//userNo 관리
export const useUserStore = defineStore('user', {
  state: () => ({
    userNo: sessionStorage.getItem('userNo') || null,
  }),
  actions: {
    setUserNo(userNo) {
      this.userNo = userNo;
      sessionStorage.setItem('userNo', userNo);
    },
    clearUserNo() {
      this.userNo = null;
      sessionStorage.removeItem('userNo');
    }
  }
});


//좋아요 게시글 가져오는 상태
export const usePostLikesListStore = defineStore('postlikeslist', () => {
  const postLikesList = ref([]);
  async function fetchLikesPost() {
    const userNo = sessionStorage.getItem('userNo');
    if (!userNo) {
      console.error('userNo is undefined or null');
      return; // userNo가 없는 경우 중단
    }
    try {
      postLikesList.value = await getLikesPostList(userNo);
      console.log("postlikeslist--", postLikesList.value);
    } catch (err) {
      console.error('Error fetching liked posts:', err);
    }
  }
  return { postLikesList, fetchLikesPost };
});

// 좋아요 토글 상태
export const useLikeStore = defineStore('likeStore', () => {
  async function toggleLike(post) {
    const userNo = sessionStorage.getItem('userNo');
    console.log("userNo from sessionStorage:", userNo);
    if (!userNo) {
      console.error('userNo is undefined or null');
      return;
    }
    try {
      await toggleLikePost(post.postNo, userNo);  // 좋아요 토글 API 호출
      // post.isLiked가 하트 토글 상태에 맞게 업데이트됩니다.
      post.isLiked = !post.isLiked; 
    } catch (err) {
      console.error('Error toggling like:', err);
    }
  }
  return { toggleLike };
});
