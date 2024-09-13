<template>
  <div class="about">
    <h1>Logout</h1>
    
  <form @submit.prevent="logout">
      <button type="submit">Logout</button>
  </form>

  </div>

</template>



<script>
import axios from 'axios';
  
  export default {
    data() {
      return {
        username: '',
        password: '',
        error: null,
      };
    },
    methods: {
 async logout() {
        try {
          const response = await axios.post('http://localhost:9000/backend/api/auth/logout.do', {
            abId: this.username,
            abPw: this.password
          });
          alert("로그아웃 성공");  // 로그아웃 성공 메시지
          this.$router.push({name : 'login'});
        } catch (error) {
          this.error = '로그아웃 실패';
        }
      }
    }
  }
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