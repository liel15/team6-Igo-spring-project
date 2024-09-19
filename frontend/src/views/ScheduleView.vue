<template>
  <CalenderModal></CalenderModal>
  <div class="w-100" style="height: 100vh">
    <div class="h-100 d-flex">
      <nav class="nav-sidebar">
        <a class="navbar-brand ms-2 fw-bold" style="font-size: 16px" href="#">
          <img
            width="50"
            height="50"
            src="https://img.icons8.com/stickers/50/airplane-take-off.png"
            alt="airplane-take-off"
          />
        </a>
        <ul class="p-2">
          <li
            class="list-step w-full text-center mb-4 p-1 rounded"
            :class="{ selected: schedlueStore.step === 1 }"
          >
            <a
              class="text-xs py-2 block cursor-pointer duration-200 selected"
              data-toggle="tab"
              @click.prevent="schedlueStore.changeStep(1)"
              role="tablist"
              >STEP 1<br />날짜 확인</a
            >
          </li>
          <li
            class="list-step w-full text-center mb-4 p-1 rounded"
            :class="{ selected: schedlueStore.step === 2 }"
          >
            <a
              class="list-steptext-xs py-2 block cursor-pointer duration-200"
              data-toggle="tab"
              @click.prevent="schedlueStore.changeStep(2)"
              role="tablist"
              >STEP 2<br />장소 선택</a
            >
          </li>
          <li
            class="list-step w-full text-center mb-3 p-1 rounded"
            :class="{ selected: schedlueStore.step === 3 }"
          >
            <a
              class="text-xs py-2 block cursor-pointer duration-200"
              data-toggle="tab"
              @click.prevent="schedlueStore.changeStep(3)"
              role="tablist"
              >STEP 3<br />숙소 설정</a
            >
          </li>
        </ul>
      </nav>
      <div class="h-100 container-sidebar">
        <div class="container-left">
          <h2 class="mb-3">제주도</h2>
          <div class="mb-3 fs-4">
            <span>2024.09.15</span>
            <span>(일)</span>
            <span>-</span>
            <span>2024.09.19</span>
            <span>(화)</span>
          </div>
          <!-- step1 페이지 START -->
          <div v-if="step === 1">
            <div class="link-btn-container d-flex mb-3">
              <button class="btn btn-primary flex-grow-1 m-1 fs-5">
                항공권
              </button>
              <button class="btn btn-primary flex-grow-1 m-1 fs-5">숙소</button>
              <button class="btn btn-primary flex-grow-1 m-1 fs-5">
                로밍 + e심
              </button>
            </div>
            <p>
              여행시간 상세설정 총 <span class="time-detail">24시간 00분</span>
            </p>
            <p>
              여행 기간과 일정 시간을 시차를 고려해 현지시간으로 설정하세요.
            </p>
            <p>
              기본 일정 시간은 오전 10시부터 오후 10시까지 총 12시간 입니다.
            </p>
            <ul class="p-0 list-group-time">
              <li
                v-for="(item, index) in dateList"
                :key="index"
                class="d-flex justify-content-between p-3 rounded border border-light-subtle mb-3"
              >
                <div>
                  <p class="sub-title-list">일자</p>
                  <p class="fs-4 mt-2">
                    {{ item.month + '/' + item.day + item.dayOfWeek }}
                  </p>
                </div>
                <div>
                  <p class="sub-title-list">시작시간</p>
                  <input
                    class="input-time fs-4"
                    id="start-day-start-time"
                    type="time"
                    value="10:00"
                    v-model="item.startTime"
                  />
                </div>
                <div>
                  <p class="sub-title-list">종료시간</p>
                  <input
                    class="fs-4 input-time"
                    id="start-day-start-time "
                    type="time"
                    value="22:00"
                    v-model="item.endTime"
                  />
                </div>
              </li>
            </ul>
            <button @click="onClickTimeSelect()" class="btn btn-dark w-100">
              시간 설정 완료
            </button>
          </div>
          <!-- step1 페이지 END -->

          <!-- step2 페이지 START -->
          <div v-if="step === 2">
            <div v-for="(item, index) in dateList" :key="index">
              <div class="d-flex justify-content-between">
                <div>
                  <p class="fs-4 mb-0">
                    {{ item.month + '월' + item.day + '일' }}
                  </p>
                </div>
                <button
                  class="fs-5 btn btn-outline-primary p-1 btn-sm schedule-create-btn mb-0"
                  @click="onClickOpenSearch(index)"
                >
                  일정 추가 <i class="bi bi-plus-circle fs-5"></i>
                </button>
              </div>
              <span class="fs-5">{{
                item.startTime + '~' + item.endTime
              }}</span>
              <div class="card-body pt-6" :class="`schedule-list-${index}`">
                <!--begin::Item-->
                <div class="d-flex flex-stack">
                  <div class="index-num fs-6">1</div>
                  <!--begin::Symbol-->
                  <div class="symbol symbol-40px me-4">
                    <div
                      class="symbol-label fs-2 fw-semibold bg-danger text-inverse-danger"
                    >
                      M
                    </div>
                  </div>
                  <!--end::Symbol-->
                  <!--begin::Section-->
                  <div
                    class="d-flex align-items-center flex-row-fluid flex-wrap"
                  >
                    <!--begin:Author-->
                    <div class="flex-grow-1 me-2">
                      <a
                        href="pages/user-profile/overview.html"
                        class="text-gray-800 text-hover-primary fs-6 fw-bold"
                        >UI/UX Design</a
                      >
                      <span class="text-muted fw-semibold d-block fs-7"
                        >40+ Courses</span
                      >
                    </div>
                    <!--end:Author-->

                    <!--begin::Actions-->
                    <a
                      href="#"
                      class="btn btn-sm btn-icon btn-bg-light btn-active-color-primary w-30px h-30px"
                    >
                      <i class="bi bi-x-square fs-2 color-danger"></i>
                    </a>
                    <!--begin::Actions-->
                  </div>
                  <!--end::Section-->
                </div>
                <!--end::Item-->
                <!--begin::Separator-->
                <div class="separator separator-dashed my-4"></div>
                <!--end::Separator-->
              </div>
            </div>
          </div>

          <!-- step2 페이지 END -->
        </div>
      </div>

      <div v-if="step == 2" class="sub-container-sidebar p-8">
        <div class="mb-3 fs-4">
          <h2>장소 검색</h2>
        </div>

        <div class="map_wrap">
          <div
            id="map"
            style="
              width: 100%;
              height: 100%;
              position: relative;
              overflow: hidden;
            "
          ></div>

          <div id="menu_wrap" class="bg_white">
            <div class="option">
              <div class="mt-3 mb-4 d-flex" style="width: auto">
                <input
                  class="form-control p-4"
                  type="text"
                  placeholder="원하시는 여행지를 검색해보세요."
                  @keyup.enter="searchPlaces"
                />
                <i type="submit" class="bi bi-search ms-3 fs-2 search-icon"></i>
              </div>
            </div>
            <hr />
            <!-- 주소리스트 START -->
            <div class="card-body pt-6">
              <!--begin::Item-->
              <ul id="placesList">
                <li></li>
                <!--end::Separator-->
              </ul>
            </div>
            <!-- 주소리스트 END -->

            <div id="pagination"></div>
          </div>
        </div>
      </div>

      <div
        class="bg-info h-100 p-0 map-container"
        :class="{ step2: step == 2 }"
      >
        <div
          id="map"
          ref="mapContainer"
          style="width: 100%; height: 100%"
        ></div>
      </div>
    </div>
  </div>
</template>

<script setup>
import CalenderModal from '@/components/CalenderModal.vue';
import { useCalenderModalStore } from '@/stores/modal';
import { useScheduleStore } from '@/stores/schedule';
import { ref, onMounted } from 'vue';
import { storeToRefs } from 'pinia';
// import { placesSearchCB } from '@/lib/kakao-map';

const schedlueStore = useScheduleStore();
const scehduleRef = storeToRefs(schedlueStore);
const dateList = scehduleRef.dateList;
const step = scehduleRef.step;

const modalStore = useCalenderModalStore();

const mapContainer = ref(null);

onMounted(() => {
  loadKakaoMap(mapContainer);
  modalStore.openModal();
  console.log(step);
});

var markers = [];
var map = null;
var ps = null;
var infowindow = null;

function loadKakaoMap(container) {
  const scriptKakao = document.createElement('script');
  scriptKakao.src =
    'https://dapi.kakao.com/v2/maps/sdk.js?appkey=86282b101f22d3f1dd8f419e50fb5c8c&libraries=services&&autoload=false';

  document.head.appendChild(scriptKakao);

  scriptKakao.onload = () => {
    window.kakao.maps.load(() => {
      const mapOption = {
        //지도를 생성할 때 필요한 기본 옵션
        center: new window.kakao.maps.LatLng(33.450701, 126.570667), //지도의 중심좌표.
        level: 3, //지도의 레벨(확대, 축소 정도)
      };

      map = new window.kakao.maps.Map(container.value, mapOption);
      ps = new kakao.maps.services.Places();
      infowindow = new kakao.maps.InfoWindow({ zIndex: 1 });
    });
  };
}

// 키워드 검색을 요청하는 함수입니다
function searchPlaces(e) {
  const keyword = e.target.value.trim();
  if (keyword.length === 0) return;
  const ps = new window.kakao.maps.services.Places();
  // 장소검색 객체를 통해 키워드로 장소검색을 요청합니다
  ps.keywordSearch(keyword, placesSearchCB);
}
// 장소검색이 완료됐을 때 호출되는 콜백함수 입니다
function placesSearchCB(data, status, pagination) {
  if (status === kakao.maps.services.Status.OK) {
    // 정상적으로 검색이 완료됐으면
    // 검색 목록과 마커를 표출합니다
    displayPlaces(data);

    // 페이지 번호를 표출합니다
    displayPagination(pagination);
  } else if (status === kakao.maps.services.Status.ZERO_RESULT) {
    alert('검색 결과가 존재하지 않습니다.');
    return;
  } else if (status === kakao.maps.services.Status.ERROR) {
    alert('검색 결과 중 오류가 발생했습니다.');
    return;
  }
}

// 검색 결과 목록과 마커를 표출하는 함수입니다
function displayPlaces(places) {
  var listEl = document.getElementById('placesList'),
    menuEl = document.getElementById('menu_wrap'),
    fragment = document.createDocumentFragment(),
    bounds = new kakao.maps.LatLngBounds(),
    listStr = '';

  // 검색 결과 목록에 추가된 항목들을 제거합니다
  removeAllChildNods(listEl);

  // 지도에 표시되고 있는 마커를 제거합니다
  removeMarker();

  for (var i = 0; i < places.length; i++) {
    // 마커를 생성하고 지도에 표시합니다
    var placePosition = new kakao.maps.LatLng(places[i].y, places[i].x),
      marker = addMarker(placePosition, i),
      itemEl = getListItem(i, places[i]); // 검색 결과 항목 Element를 생성합니다

    // 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
    // LatLngBounds 객체에 좌표를 추가합니다
    bounds.extend(placePosition);

    // 마커와 검색결과 항목에 mouseover 했을때
    // 해당 장소에 인포윈도우에 장소명을 표시합니다
    // mouseout 했을 때는 인포윈도우를 닫습니다
    (function (marker, title) {
      kakao.maps.event.addListener(marker, 'mouseover', function () {
        displayInfowindow(marker, title);
      });

      kakao.maps.event.addListener(marker, 'mouseout', function () {
        infowindow.close();
      });

      itemEl.onmouseover = function () {
        displayInfowindow(marker, title);
      };

      itemEl.onmouseout = function () {
        infowindow.close();
      };
    })(marker, places[i].place_name);

    fragment.appendChild(itemEl);
  }

  // 검색결과 항목들을 검색결과 목록 Element에 추가합니다
  listEl.appendChild(fragment);
  menuEl.scrollTop = 0;

  // 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
  map.setBounds(bounds);
}

// 검색결과 항목을 Element로 반환하는 함수입니다
function getListItem(index, places) {
  var el = document.createElement('li');
  const [searchList, separator] = createSearchList(places);
  el.appendChild(searchList);
  el.appendChild(separator);
  el.classList.add('item');
  return el;
}

function createSearchList(places) {
  // 1. 최상위 컨테이너 div
  const containerDiv = document.createElement('div');
  containerDiv.classList.add('d-flex', 'flex-stack');

  // 2. Symbol 부분 생성
  const symbolDiv = document.createElement('div');
  symbolDiv.classList.add('symbol', 'symbol-40px', 'me-4');
  symbolDiv.innerHTML = selectCategoryGroup(places);

  // 3. Section 부분 생성
  const sectionDiv = document.createElement('div');
  sectionDiv.classList.add(
    'd-flex',
    'align-items-center',
    'flex-row-fluid',
    'flex-wrap'
  );

  // 4. Author 부분 생성
  const authorDiv = document.createElement('div');
  authorDiv.classList.add('flex-grow-1', 'me-2');

  const locationSpan = document.createElement('span');
  locationSpan.href = `${places.place_url}`;
  locationSpan.classList.add(
    'text-gray-800',
    'text-hover-primary',
    'fs-6',
    'fw-bold'
  );
  locationSpan.textContent = places.address_name;

  const addressSpan = document.createElement('span');
  addressSpan.classList.add('text-muted', 'fw-semibold', 'd-block', 'fs-7');
  addressSpan.textContent = places.place_name;

  const description = document.createElement('span');
  description.classList.add('text-muted', 'fw-semibold', 'd-block', 'fs-7');
  const descriptionText = places.category_name.split('>');
  description.textContent =
    descriptionText[0] + '>' + descriptionText[descriptionText.length - 1];

  authorDiv.appendChild(locationSpan);
  authorDiv.appendChild(addressSpan);
  authorDiv.appendChild(description);

  // 5. Actions 부분 생성
  const phoneActionLink = createPhoneActionElement(places);

  const actionsLink = document.createElement('a');
  actionsLink.href = '#';
  actionsLink.classList.add(
    'btn',
    'btn-sm',
    'btn-icon',
    'btn-bg-light',
    'btn-active-color-primary',
    'w-30px',
    'h-30px',
    'me-3'
  );

  const plusIcon = document.createElement('i');
  plusIcon.classList.add('bi', 'bi-plus-square', 'fs-2');
  actionsLink.appendChild(plusIcon);
  actionsLink.addEventListener('click', () => onClickAddLocation(places));
  // 6. 모든 요소 조립
  sectionDiv.appendChild(authorDiv);
  sectionDiv.appendChild(phoneActionLink);
  sectionDiv.appendChild(actionsLink);

  containerDiv.appendChild(symbolDiv);
  containerDiv.appendChild(sectionDiv);

  // 7. Separator 추가
  const separatorDiv = document.createElement('div');
  separatorDiv.classList.add('separator', 'separator-dashed', 'my-4');

  // 8. 결과 반환 (containerDiv와 separatorDiv를 포함한 완전한 구조)
  return [containerDiv, separatorDiv];
}

function createSelectLocatioList(places) {
  // 1. 최상위 컨테이너 div
  const containerDiv = document.createElement('div');
  containerDiv.classList.add('d-flex', 'flex-stack', 'selected-location');

  // 2. Symbol 부분 생성
  const symbolDiv = document.createElement('div');
  symbolDiv.classList.add('symbol', 'symbol-40px', 'me-4');
  symbolDiv.innerHTML = selectCategoryGroup(places);

  // 3. Section 부분 생성
  const sectionDiv = document.createElement('div');
  sectionDiv.classList.add(
    'd-flex',
    'align-items-center',
    'flex-row-fluid',
    'flex-wrap'
  );

  // 4. Author 부분 생성
  const authorDiv = document.createElement('div');
  authorDiv.classList.add('flex-grow-1', 'me-2');

  const locationSpan = document.createElement('span');
  locationSpan.href = `${places.place_url}`;
  locationSpan.classList.add(
    'text-gray-800',
    'text-hover-primary',
    'fs-6',
    'fw-bold'
  );
  locationSpan.textContent = places.address_name;

  const addressSpan = document.createElement('span');
  addressSpan.classList.add('text-muted', 'fw-semibold', 'd-block', 'fs-7');
  addressSpan.textContent = places.place_name;

  const description = document.createElement('span');
  description.classList.add('text-muted', 'fw-semibold', 'd-block', 'fs-7');
  const descriptionText = places.category_name.split('>');
  description.textContent =
    descriptionText[0] + '>' + descriptionText[descriptionText.length - 1];

  authorDiv.appendChild(locationSpan);
  authorDiv.appendChild(addressSpan);
  authorDiv.appendChild(description);

  // 5. Actions 부분 생성
  const phoneActionLink = createPhoneActionElement(places);

  const actionsLink = document.createElement('a');
  actionsLink.href = '#';
  actionsLink.classList.add(
    'btn',
    'btn-sm',
    'btn-icon',
    'btn-bg-light',
    'btn-active-color-primary',
    'w-30px',
    'h-30px',
    'me-3'
  );

  const plusIcon = document.createElement('i');
  plusIcon.classList.add('bi', 'bi-x-square', 'fs-2');
  plusIcon.addEventListener('click', () => onClickAddLocation(places));
  actionsLink.appendChild(plusIcon);

  // 6. 모든 요소 조립
  sectionDiv.appendChild(authorDiv);
  sectionDiv.appendChild(phoneActionLink);
  sectionDiv.appendChild(actionsLink);

  containerDiv.appendChild(symbolDiv);
  containerDiv.appendChild(sectionDiv);

  // 7. Separator 추가
  const separatorDiv = document.createElement('div');
  separatorDiv.classList.add('separator', 'separator-dashed', 'my-4');

  const wrapperEl = document.querySelector(
    `.schedule-list-${scheduleDateIndex.value}`
  );
  wrapperEl.appendChild(containerDiv);
  wrapperEl.appendChild(separatorDiv);
}

function selectCategoryGroup(places) {
  let symbolEl = '<div></div>';
  if (places.category_group_code === 'FD6') {
    //음식점
    symbolEl = `
                      <div
                        class="symbol-label fs-2 fw-semibold bg-danger text-inverse-danger"
                      >
                        <i
                          class="bi bi-shop fs-2 fw-semibold text-inverse-danger"
                        ></i>
                      </div>`;
  } else if (places.category_group_code === 'AD5') {
    //숙박
    symbolEl = `
                      <div
                        class="symbol-label fs-2 fw-semibold bg-success text-inverse-success"
                      >
                        <i
                          class="bi bi-building fs-2 fw-semibold text-inverse-success"
                        ></i>
                      </div>`;
  } else if (places.category_group_code === 'AT4') {
    //관광명소
    symbolEl = `
                      <div
                        class="symbol-label fs-2 fw-semibold bg-info text-inverse-info"
                      >
                        <i
                          class="bi bi-compass fs-2 fw-semibold text-inverse-info"
                        ></i>
                      </div>`;
  } else if (places.category_group_code === 'CE7') {
    // 카페
    symbolEl = `
                      <div
                        class="symbol-label fs-2 fw-semibold bg-warning text-inverse-warning"
                      >
                        <i
                          class="bi bi-cup-hot fs-2 fw-semibold text-inverse-warning"
                        ></i>
                      </div>`;
  } else {
    // 기타
    symbolEl = `
                      <div
                        class="symbol-label fs-2 fw-semibold bg-primary text-inverse-primary"
                      >
                        <i
                          class="bi bi-geo-alt fs-2 fw-semibold text-inverse-primary"
                        ></i>
                      </div>`;
  }

  return symbolEl;
}

function createPhoneActionElement(places) {
  // Create the phone action link element
  const phoneActionLink = document.createElement('a');
  phoneActionLink.classList.add(
    'btn',
    'btn-sm',
    'btn-icon',
    'btn-bg-light',
    'btn-active-color-primary',
    'w-30px',
    'h-30px',
    'me-3'
  );

  // Create the phone icon
  const phoneIcon = document.createElement('i');
  phoneIcon.classList.add('bi', 'bi-telephone', 'fs-2');
  phoneActionLink.appendChild(phoneIcon);

  const isMobile = /Mobi|Android/i.test(navigator.userAgent);

  if (isMobile) {
    phoneActionLink.href = `tel:${places.phone}`;
  } else {
    phoneActionLink.href = '#'; // Prevent default link behavior
    phoneActionLink.addEventListener('click', (event) => {
      event.preventDefault(); // Prevent navigation
      navigator.clipboard
        .writeText(places.phone)
        .then(() => {
          alert(`전화번호가 복사되었습니다: ${places.phone}`);
        })
        .catch((err) => {
          console.error('전화번호 복사에 실패했습니다', err);
        });
    });
  }

  return phoneActionLink;
}

// 마커를 생성하고 지도 위에 마커를 표시하는 함수입니다
function addMarker(position, idx, title) {
  var imageSrc =
      'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png', // 마커 이미지 url, 스프라이트 이미지를 씁니다
    imageSize = new kakao.maps.Size(36, 37), // 마커 이미지의 크기
    imgOptions = {
      spriteSize: new kakao.maps.Size(36, 691), // 스프라이트 이미지의 크기
      spriteOrigin: new kakao.maps.Point(0, idx * 46 + 10), // 스프라이트 이미지 중 사용할 영역의 좌상단 좌표
      offset: new kakao.maps.Point(13, 37), // 마커 좌표에 일치시킬 이미지 내에서의 좌표
    },
    markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imgOptions),
    marker = new kakao.maps.Marker({
      position: position, // 마커의 위치
      image: markerImage,
    });

  marker.setMap(map); // 지도 위에 마커를 표출합니다
  markers.push(marker); // 배열에 생성된 마커를 추가합니다

  return marker;
}

// 지도 위에 표시되고 있는 마커를 모두 제거합니다
function removeMarker() {
  for (var i = 0; i < markers.length; i++) {
    markers[i].setMap(null);
  }
  markers = [];
}

// 검색결과 목록 하단에 페이지번호를 표시는 함수입니다
function displayPagination(pagination) {
  var paginationEl = document.getElementById('pagination'),
    fragment = document.createDocumentFragment(),
    i;

  // 기존에 추가된 페이지번호를 삭제합니다
  while (paginationEl.hasChildNodes()) {
    paginationEl.removeChild(paginationEl.lastChild);
  }

  for (i = 1; i <= pagination.last; i++) {
    var el = document.createElement('a');
    el.href = '#';
    el.innerHTML = i;

    if (i === pagination.current) {
      el.className = 'on';
    } else {
      el.onclick = (function (i) {
        return function () {
          pagination.gotoPage(i);
        };
      })(i);
    }

    fragment.appendChild(el);
  }
  paginationEl.appendChild(fragment);
}

// 검색결과 목록 또는 마커를 클릭했을 때 호출되는 함수입니다
// 인포윈도우에 장소명을 표시합니다
function displayInfowindow(marker, title) {
  var content = '<div style="padding:5px;z-index:1;">' + title + '</div>';

  infowindow.setContent(content);
  infowindow.open(map, marker);
}

// 검색결과 목록의 자식 Element를 제거하는 함수입니다
function removeAllChildNods(el) {
  while (el.hasChildNodes()) {
    el.removeChild(el.lastChild);
  }
}

function onClickTimeSelect() {
  const errList = [];
  dateList.value.forEach((el) => {
    if (convertToMinutes(el['startTime']) >= convertToMinutes(el['endTime'])) {
      errList.push(
        `${el['month']}월 ${el['day']}일:'시작시간'을 '종료시간' 이후 시간으로 설정 할 수 없습니다.`
      );
    }
  });

  if (errList.length > 0) {
    console.log(errList);
    alert(errList.join('\n'));
  } else {
    schedlueStore.changeStep(2);
  }
}

function convertToMinutes(time) {
  const [hours, minutes] = time.split(':').map(Number);
  return hours * 60 + minutes; // 시간을 분으로 변환
}

function onClickOpenSearch(index) {
  schedlueStore.selectScheduleDate(index);
  console.log(scehduleRef.scheduleDateIndex.value);
}

const { placesList, scheduleDateIndex, scheduleLocationList } =
  storeToRefs(schedlueStore);

function onClickAddLocation(places) {
  let index = scheduleDateIndex.value;
  console.log(index);
  createSelectLocatioList(places);
}

function onClickRemoveLocation(dateKey, index) {
  const list = scheduleLocationList.value.dateKey.splice(index, 1);
  if (index > -1 && index < list.length) {
    list.splice(index, 1);
  }
}

function onClickComplteSchedule() {
  // const finalData = {
  //   schedules: [
  //     { year: '2024', month: 9, day: 19, dayOfWeek: '월' },
  //     { year: '2024', month: 9, day: 20, dayOfWeek: '화' },
  //   ],
  // };
  dateList.forEach((date, index) => {
    const container = document.querySelector(`schedule-list-${index}`);
    const listDiv = container.querySelector('.selected-location');
    console.log(listDiv);
    date.finalData.schedules.push();
  });
}
</script>

<style>
a {
  text-decoration: none;
}

li {
  list-style: none;
}

.container-sidebar {
  width: 35%;
  transition: width 0.3s ease;
  overflow: scroll;
}

.container-sidebar.step2 {
  width: 40%;
  transition: width 0.3s ease;
}

/* nav bar */
.nav-sidebar {
  width: 100px;
  height: 100%;
  left: 0;
  top: 0;
  position: fixed;
  text-align: center;
  z-index: 999;
  background-color: var(--color-bg-blue4);
}

.list-step.selected {
  background-color: var(--color-bg-blue3);
}

.list-step.selected a {
  /* color: var(--color-bg-blue2); */
  color: white;
  opacity: 1;
}

.list-step a {
  color: black;
  opacity: 0.5;
  font-weight: 900;
}

/* container-left */
.container-left {
  padding: 20px 20px 20px 130px;
  font-weight: 900;
}

.link-btn-container button {
  background-color: var(--color-bg-blue3) !important;
}

.time-detail {
  color: var(--color-bg-blue1);
}

.list-group-time li p {
  margin-bottom: 0;
}

.sub-title-list {
  color: var(--color-text-grey);
  font-weight: 900;
  font-size: 1.2rem;
}

.input-time {
  color: var(--color-text-grey);
  padding: 0.375rem 0.75rem;
  background-color: var(--bs-body-bg);
  background-clip: padding-box;
  border: var(--bs-border-width) solid var(--bs-border-color);
  border-radius: var(--bs-border-radius);
  transition: border-color 0.15s ease-in-out, box-shadow 0.15s ease-in-out;
}

/* step2 style */
.search-icon {
  line-height: 40px;
}

.sub-step2-container {
  position: absolute;
  top: 0;
  left: 0;
  margin-left: 100%;
  width: 500px;
  z-index: 9999999;
}

.map-container {
  width: 65%;
}

.map-container.step2 {
  width: 40%;
  transition: width 0.3s ease;
}

.sub-container-sidebar {
  width: 30%;
  transition: width 0.3s ease;
  overflow: scroll;
}

.index-num {
  color: white;
  margin-right: 5px;
  background-color: var(--color-bg-blue2);
  width: 20px;
  height: 20px;
  border-radius: 100%;
  text-align: center;
}

.schedule-create-btn {
  height: 30px;
}

.schedule-create-btn i {
  color: var(--color-bg-blue2);
}

.schedule-create-btn:hover i {
  color: white;
}
</style>
