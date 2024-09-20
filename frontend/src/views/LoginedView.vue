<template>
  <div class="about">
    <h1>Logout</h1>

    <form @submit.prevent="logout">
      <button type="submit">Logout</button>
    </form>
  </div>
</template>

<script>
import { useTestStore } from "@/stores/test";

const store = useTestStore();
store.fetchTest();

const { data } = storeToRefs(store);
export default {
  data() {
    return {
      username: "",
      password: "",
      error: null,
    };
  },
  methods: {
    async logout() {
      try {
        const response = await axios.post(
          "http://localhost:9000/backend/api/auth/logout.do",
          {
            abId: this.username,
            abPw: this.password,
          }
        );
        alert(response.data); // 로그아웃 성공 메시지
        this.$router.push({ name: "home" });
      } catch (error) {
        this.error = "로그아웃 실패";
      }
    },
  },
};
</script>

<style>
@media (min-width: 1024px) {
  .about {
    min-height: 100vh;
    display: flex;
    align-items: center;
  }
}
</style>
