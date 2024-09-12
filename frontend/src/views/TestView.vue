<template>
  <div>
    <div class="container">
      <div>피니아 사용한 데이터</div>
      <ul>
        <li v-for="item in data" :key="item.id">
            {{ item.employeeId }} - {{ item.firstName }}
        </li>
      </ul>
    </div>
  </div>
</template>

<script setup>
import { onMounted } from "vue";
import { useTestStore } from "@/stores/test";
import { storeToRefs } from 'pinia';

onMounted(() => {
 init();
})
const store = useTestStore();
async function init () {
    store.fetchTest();
}
const { data } = storeToRefs(store);
</script>

<style scoped>
  li {
    color: var(--color-bg-blue1);
  }
</style>