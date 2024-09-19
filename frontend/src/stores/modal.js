import { defineStore } from 'pinia';
import { ref } from 'vue';

export const useCalenderModalStore = defineStore('calendarModal', () => {
  const isModalOpen = ref(false);
  const selected = ref(null);

  function openModal() {
    isModalOpen.value = true;
  }

  function closeModal() {
    isModalOpen.value = false;
  }

  return { isModalOpen, openModal, closeModal, selected };
});
