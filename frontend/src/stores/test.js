import { ref } from 'vue'
import { defineStore } from 'pinia'
import { getTestList, getPostList } from '../api/test'


export const useTestStore = defineStore('test', () => {
  const data = ref([]);
  async function fetchTest() {
    data.value = await getTestList();
  }

  return { data, fetchTest }
})

export const usePostStore = defineStore('test', () => {
  const postlist = ref([]);
  async function fetchPost() {
    postlist.value = await getPostList();
    console.log(postlist.value);
  }

  return { postlist, fetchPost }
})