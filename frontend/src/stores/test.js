import { ref } from 'vue'
import { defineStore } from 'pinia'
import { getTestList } from '@/api/test'

export const useTestStore = defineStore('test', () => {
  const data = ref([]);
  async function fetchTest() {
    data.value = await getTestList();
  }

  return { data, fetchTest }
})
