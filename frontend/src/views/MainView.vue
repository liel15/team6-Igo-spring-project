<template>
  <div class="login-container">
    <h2>Login</h2>
    <form @submit.prevent="login">
      <div>
        <label for="id">Id</label>
        <input v-model="id" type="text" id="id">
      </div>
      <div>
        <label for="password">Password</label>
        <input v-model="password" type="password" id="password">
      </div>
      <div>
        <button type="submit">로그인</button>
      </div>
    </form>
    <button type="button" @click="goToSignUp()">회원가입</button>
    <p v-if="error">{{ error }}</p>
  </div>
</template>

<script setup>
import {useTestStore} from '@/stores/test';

const store = useTestStore();
store.fetchTest();

const { data } = storeToRefs(store);

//const api = '/backend/api/auth/login';

  const data = {
    id: '',
    password: '', 
    error: null
  };

  async function login() {
      try {
        const response = await getTestList(content);
        
        alert("로그인성공"); // 로그인 성공 메시지
        console.log(response);
        this.$router.push({ name: "logined" }).catch(err => {
      console.error("Navigation error:", err);
    });
      } catch (error) {
        this.error = "Invalid username or password";
      }
    };

</script>

<style scoped>
.login-container {
  max-width: 300px;
  margin: auto;
}
</style>
