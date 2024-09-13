<template>
  <h1>홈페이지입니다.</h1>
  <button ref="btnRef">테스트페이지로 이동하기</button>
</template>

<script setup>
import router from "@/router";
import { ref } from "vue";
import { onMounted } from "vue";

const btnRef = ref(null);

onMounted(() => {
  init();
})

function init() {
  // test페이지 이동
  btnRef.value.addEventListener('click', (e) => {
    router.push({ path: '/test' })
  })
}

</script>

