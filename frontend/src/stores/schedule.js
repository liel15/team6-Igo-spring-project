import { defineStore } from 'pinia';
import { ref } from 'vue';

export const useScheduleStore = defineStore('schedule', () => {
  const selected = ref(null);
  const dateList = ref([]);
  const step = ref(1);
  const scheduleDateIndex = ref(null);
  const placesList = ref([]);
  const scheduleLocationList = ref({});
  const finalSchedule = ref({});

  function extractDataInOrder() {
    if (selected.value) {
      // 연도 순서대로 순회
      Object.keys(selected.value).forEach((year) => {
        const months = selected.value[year];

        // 월 순서대로 순회
        Object.keys(months).forEach((month) => {
          const days = months[month];

          // 일 순서대로 순회
          days.forEach((day) => {
            const date = new Date(year, month - 1, day);
            const daysOfWeek = ['일', '월', '화', '수', '목', '금', '토'];

            dateList.value.push({
              year: year,
              month: parseInt(month) + 1, // 월은 0부터 시작하므로 1을 더해줌
              day: day,
              dayOfWeek: daysOfWeek[date.getDay()],
            });
          });
        });
      });
    } else {
      return null;
    }

    return dateList;
  }

  function changeStep(num) {
    step.value = num;
  }

  function selectScheduleDate(num) {
    scheduleDateIndex.value = num;
  }

  function completeScheduleDate() {
    finalSchedule.value = {
      date: dateList,
    };
  }

  return {
    selected,
    extractDataInOrder,
    dateList,
    step,
    changeStep,
    selectScheduleDate,
    placesList,
    scheduleDateIndex,
    scheduleLocationList,
  };
});
