<template>
  <div
    :class="['modal fade', { show: isModalOpen }]"
    id="kt_modal_upgrade_plan"
    tabindex="-1"
    :style="{ display: isModalOpen ? 'block' : 'none' }"
    aria-modal="isModalOpen"
    role="dialog"
  >
    <!--begin::Modal dialog-->
    <div class="modal-dialog modal-xl">
      <!--begin::Modal content-->
      <div class="modal-content rounded">
        <!--begin::Modal header-->
        <div class="modal-header justify-content-end border-0 pb-0">
          <!--begin::Close-->
          <div
            class="btn btn-sm btn-icon btn-active-color-primary"
            data-bs-dismiss="modal"
          ></div>
          <!--end::Close-->
        </div>
        <!--end::Modal header-->
        <!--begin::Modal body-->
        <div class="modal-body pt-0 pb-15 px-5 px-xl-20">
          <!--begin::Heading-->
          <div class="mb-13 text-center">
            <h1 class="mb-3">여행기간 선택</h1>
            <div class="text-muted fw-semibold fs-5">
              <p>* 여행 일자는 최대 10일까지 설정 가능합니다.</p>
              <p>
                여행 기간(여행지 도착 날짜, 여행지 출발 날짜)으로 입력해주세요.
              </p>
            </div>
          </div>
          <!--end::Heading-->

          <section class="ftco-section">
            <div class="container">
              <div class="row">
                <div class="col-md-12">
                  <div class="calendar-section">
                    <div class="row no-gutters">
                      <div class="col-md-6">
                        <div
                          class="calendar calendar-first"
                          id="calendar_first"
                        >
                          <div class="calendar_header">
                            <button class="switch-month switch-left">
                              <i class="fa fa-chevron-left"></i>
                            </button>
                            <h2></h2>
                            <button class="switch-month switch-right">
                              <i class="fa fa-chevron-right"></i>
                            </button>
                          </div>
                          <div class="calendar_weekdays"></div>
                          <div class="calendar_content"></div>
                        </div>
                      </div>
                      <div class="col-md-6">
                        <div
                          class="calendar calendar-second"
                          id="calendar_second"
                        >
                          <div class="calendar_header">
                            <button class="switch-month switch-left">
                              <i class="fa fa-chevron-left"></i>
                            </button>
                            <h2></h2>
                            <button class="switch-month switch-right">
                              <i class="fa fa-chevron-right"></i>
                            </button>
                          </div>
                          <div class="calendar_weekdays"></div>
                          <div class="calendar_content"></div>
                        </div>
                      </div>
                    </div>
                    <!-- End Row -->
                  </div>
                  <!-- End Calendar -->
                </div>
              </div>
            </div>
            <div class="text-center">
              <button @click="closeModal" class="btn btn-primary w-30">
                날짜 선택 완료
              </button>
            </div>
          </section>
        </div>
        <!--end::Modal body-->
      </div>
      <!--end::Modal content-->
    </div>
    <!--end::Modal dialog-->
  </div>
</template>

<script setup>
import { useCalenderModalStore } from '@/stores/modal';
import { useScheduleStore } from '@/stores/schedule';
import { storeToRefs } from 'pinia';
import { onMounted } from 'vue';

onMounted(() => {
  const popper = document.createElement('script');
  popper.src = '/src/js/components/popper.js';

  const main = document.createElement('script');
  main.type = 'module';
  main.src = '/src/js/components/calender.js';

  document.head.appendChild(popper);
  document.head.appendChild(main);
});

const modalStore = useCalenderModalStore();
const modalRef = storeToRefs(modalStore);
const isModalOpen = modalRef.isModalOpen;

const schedlueStore = useScheduleStore();
const scehduleRef = storeToRefs(schedlueStore);

const selected = scehduleRef.selected;

function closeModal() {
  if (!selected.value) {
    return alert('날짜를 선택하여 주세요.');
  }
  modalStore.closeModal();
  const result = schedlueStore.extractDataInOrder();
  console.log(result);
}
</script>

<style scoped></style>
