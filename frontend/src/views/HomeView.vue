<template>
  <div class="d-flex flex-column" style="background-color: #f6f6f6">
    <!-- 헤더 시작 -->
    <div class="header" style="height: 8vh; background-color: #3abef9">
      <!-- 네비바 -->
      <nav class="navbar navbar-expand-lg navbar-dark w-100 h-100">
        <div class="container-fluid">
          <div class="d-flex align-items-center">
            <img
              width="50"
              height="50"
              src="https://img.icons8.com/stickers/50/airplane-take-off.png"
              alt="airplane-take-off"
            />
            <a class="navbar-brand ms-2 fw-bold" style="font-size: 30px" href="#"
              >I.GO!</a
            >
          </div>
          <button
            class="navbar-toggler"
            type="button"
            data-bs-toggle="collapse"
            data-bs-target="#navbarNavAltMarkup"
            aria-controls="navbarNavAltMarkup"
            aria-expanded="false"
            aria-label="Toggle navigation"
          >
            <span class="navbar-toggler-icon"></span>
          </button>

          <div
            class="collapse navbar-collapse justify-content-end"
            id="navbarNavAltMarkup"
          >
            <div class="navbar-nav justify-content-center align-items-center">
              <a class="nav-link" href="#serch">여행지</a>

              <a class="nav-link" href="#">계획 등록</a>

              <a class="nav-link" href="#">마이페이지</a>

              <button @click="log()" class="btn btn-primary ms-2">{{ startBt }}</button>
            </div>
          </div>
        </div>
      </nav>
      <!-- 네비바 -->
    </div>
    <!-- 헤더 끝 -->
    <!-- 헤더 끝 -->

    <!-- 몸 1-->
    <div class="d-flex flex-row mt-5" style="height: 400px">
      <div
        v-if="startBt == '로그인'"
        class="card shadow d-flex justify-content-center align-items-start m-2 ms-3"
        style="width: 900px"
      >
        <div class="ms-2 p-5">
          <h1 class="fw-bold">여행을 계획할 땐, I GO!</h1>
          <span>막막했던 여행? I,Go와 함께 가요!</span>
        </div>
      </div>

      <div
  v-if="startBt == '로그아웃'"
  class="card shadow d-flex justify-content-center align-items-start m-2 ms-3"
  style="width: 900px"
>
  <div class="d-flex flex-row ms-2 p-5 w-100">
    <!-- 사진 컨테이너: Flexbox를 사용해 좌측 중앙에 고정 -->
    <div
      class="d-flex justify-content-center align-items-center rounded-circle overflow-hidden shadow"
      style="width: 200px; height: 200px"
    >
      <img
        src="https://dcimg1.dcinside.com/viewimage.php?id=23b2de21e1d335a161b2&no=24b0d769e1d32ca73dea81fa11d028311869dac7d33bec80aa651ee0dd05d26f31aa190ab157783060f4f76fa59e2635ad3463abbc4bac0bc7f0edc4feada421976851ef383b38252aebfd5a9ef121e854"
        class="w-100 h-100"
      />
    </div>

    <!-- 카드 내용 -->
    <div
      class="d-flex flex-column justify-content-center align-items-start flex-grow-1 ms-4"
    >
      <h2 class="fw-bold">{{ user.name }}님!</h2>
      <p style="font-size: 12px; color: gray">{{ user.id }}</p>
      <div class="d-flex align-items-center mt-2">
        <p class="me-2 mb-0">나의 여행:</p>
        <p class="mb-0">{{ user.post }} 개</p>
      </div>

      <div class="mt-4">
        <div class="d-flex flex-wrap justify-content-start">
          <p
            v-for="(value, key) in type"
            :key="key"
            class="badge rounded-pill text-dark me-2 mb-3"
            style="
              font-size: 0.9em;
              padding: 8px 15px;
              background-color: #a7e6ff;
              flex-basis: calc(33.33% - 10px);
            "
          >
            {{ value }}
          </p>
        </div>
      </div>
    </div>
  </div>
</div>


      <!-- 상단 몸 -->
      <div
        class="card shadow overflow-hidden d-flex w-100 m-2 me-3 position-relative"
        style="height: 385px"
      >
        <div id="carouselExample" class="carousel slide h-100">
          <div class="carousel-inner h-100">
            <!-- 캐러셀 아이템 1 -->
            <div class="carousel-item active h-100">
              <div class="d-flex align-items-center h-100">
                <div
                  class="d-flex justify-content-center align-items-center"
                  style="width: 50%"
                >
                  <img
                    src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQoHwq6780xdecD9iX6N6PQyg-5Te_ZNF2RNQ&s"
                    class="d-block"
                    style="max-width: 80%; max-height: 80%; object-fit: contain"
                    alt="..."
                  />
                </div>
                <div class="d-flex flex-column justify-content-center" style="width: 70%">
                  <h3 class="fw-bold">여행 계획도 I GO!</h3>
                  <p class="mt-3">여행할 지역을 선택해 지도와 함께 계획을 할 수 있어요</p>
                </div>
              </div>
            </div>

            <!-- 캐러셀 아이템 2 (새로 추가된 아이템) -->
            <div class="carousel-item h-100">
              <div class="d-flex align-items-center h-100">
                <div
                  class="d-flex justify-content-center align-items-center"
                  style="width: 50%"
                >
                  <img
                    src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQoHwq6780xdecD9iX6N6PQyg-5Te_ZNF2RNQ&s"
                    class="d-block"
                    style="max-width: 80%; max-height: 80%; object-fit: contain"
                    alt="..."
                  />
                </div>
                <div class="d-flex flex-column justify-content-center" style="width: 70%">
                  <h3 class="fw-bold">여행 기록도 I GO!</h3>
                  <p class="mt-3">여행할 지역을 선택해 지도와 함께 계획을 할 수 있어요</p>
                </div>
              </div>
            </div>

            <!-- 캐러셀 아이템 3 -->
            <div class="carousel-item h-100">
              <div class="d-flex align-items-center h-100">
                <div
                  class="d-flex justify-content-center align-items-center"
                  style="width: 50%"
                >
                  <img
                    src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQoHwq6780xdecD9iX6N6PQyg-5Te_ZNF2RNQ&s"
                    class="d-block"
                    style="max-width: 80%; max-height: 80%; object-fit: contain"
                    alt="..."
                  />
                </div>
                <div class="d-flex flex-column justify-content-center" style="width: 70%">
                  <h3 class="fw-bold">여행 참고도 I Go!</h3>
                  <p class="mt-3">여행할 지역을 선택해 지도와 함께 계획을 할 수 있어요</p>
                </div>
              </div>
            </div>
          </div>

          <!-- 캐러셀 컨트롤 버튼 -->
          <button
            class="carousel-control-prev"
            type="button"
            data-bs-target="#carouselExample"
            data-bs-slide="prev"
            style="width: 5%"
          >
            <span
              class="carousel-control-prev-icon"
              aria-hidden="true"
              style="
                filter: invert(25%) sepia(0%) saturate(0%) hue-rotate(0deg)
                  brightness(100%) contrast(100%);
              "
            ></span>
            <span class="visually-hidden">Previous</span>
          </button>
          <button
            class="carousel-control-next"
            type="button"
            data-bs-target="#carouselExample"
            data-bs-slide="next"
            style="width: 5%"
          >
            <span
              class="carousel-control-next-icon"
              aria-hidden="true"
              style="
                filter: invert(25%) sepia(0%) saturate(0%) hue-rotate(0deg)
                  brightness(100%) contrast(100%);
              "
            ></span>
            <span class="visually-hidden">Next</span>
          </button>
        </div>
      </div>
      <!-- 상단 몸2 -->
    </div>
    <!-- 몸1 -->

    <!-- 몸2 : 영상 -->
    <div
      class="d-flex justify-content-center align-items-center mt-2 overflow-hidden"
      style="height: 600px"
    >
      <iframe
        width="1800"
        height="600"
        src="https://www.youtube.com/embed/pYzX7cqK_JQ&t=29s?autoplay=1&mute=1&loop=1&playlist=pYzX7cqK_JQ&t=29s"
        showinfo="0"
        controls="0"
        frameborder="0"
        allowfullscreen
        allow="autoplay"
      ></iframe>
    </div>
    <!-- 몸2영상 -->

    <div
      class="d-flex flex-column align-items-center mt-5"
      style="height: 1200px"
      id="serch"
    >
      <h1 class="mt-4 mb-5 fw-bold">어디로 여행을 떠나볼까요?</h1>
      <div class="mt-3 mb-4 d-flex" style="width: 800px; height: 50px">
        <input
          class="form-control shadow"
          type="search"
          placeholder="원하시는 여행지를 검색해보세요."
        />
        <i type="submit" class="bi bi-search ms-3" style="font-size: 30px"></i>
      </div>

      <!-- v-for로 처리할 것 -->
      <div class="d-flex flex-row flex-row gap-4 mt-5">
        <div class="card" style="width: 18rem">
          <img
            src="https://ynoblesse.com/wp-content/uploads/2023/07/359937836_682922003657771_717380477542506344_n.jpg"
            class="card-img-top"
            alt="..."
          />
          <div class="card-body">
            <p class="card-text">
              Some quick example text to build on the card title and make up the bulk of
              the card's content.
            </p>
            <i
              class="bi"
              :class="[isHeartFilled ? 'bi-heart-fill' : 'bi-heart']"
              @click="toggleHeart"
              style="
                position: absolute;
                bottom: 10px;
                right: 10px;
                font-size: 1.5rem;
                cursor: pointer;
              "
            ></i>
          </div>
        </div>

        <div class="card" style="width: 18rem">
          <img
            src="https://ynoblesse.com/wp-content/uploads/2023/07/358520758_1425769678257003_8801872512201663407_n-1024x576.jpg"
            class="card-img-top"
            alt="..."
          />
          <div class="card-body">
            <p class="card-text"></p>
          </div>
        </div>

        <div class="card" style="width: 18rem">
          <img
            src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRIsPcDmVQ7u6x315pDLliwgAQ9EAW9Q3RQUXkXHbCxw-ep4qxs192Pfxfot_BaaHGqsjs&usqp=CAU"
            class="card-img-top"
            alt="..."
          />
          <div class="card-body">
            <p class="card-text">
              Some quick example text to build on the card title and make up the bulk of
              the card's content.
            </p>
          </div>
        </div>

        <div class="card" style="width: 18rem">
          <img
            src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRE6GVBVGHhSqD5PB4yGrzU7BybAJLGwkPQiA&s"
            class="card-img-top"
            alt="..."
          />
          <div class="card-body">
            <p class="card-text">
              Some quick example text to build on the card title and make up the bulk of
              the card's content.
            </p>
          </div>
        </div>
      </div>

      <div class="d-flex flex-row flex-row gap-4 mt-5">
        <div class="card" style="width: 18rem">
          <img
            src="https://ynoblesse.com/wp-content/uploads/2023/07/359937836_682922003657771_717380477542506344_n.jpg"
            class="card-img-top"
            alt="..."
          />
          <div class="card-body">
            <p class="card-text">
              Some quick example text to build on the card title and make up the bulk of
              the card's content.
            </p>
          </div>
        </div>

        <div class="card" style="width: 18rem">
          <img
            src="https://ynoblesse.com/wp-content/uploads/2023/07/358520758_1425769678257003_8801872512201663407_n-1024x576.jpg"
            class="card-img-top"
            alt="..."
          />
          <div class="card-body">
            <p class="card-text">
              Some quick example text to build on the card title and make up the bulk of
              the card's content.
            </p>
          </div>
        </div>

        <div class="card" style="width: 18rem">
          <img
            src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRIsPcDmVQ7u6x315pDLliwgAQ9EAW9Q3RQUXkXHbCxw-ep4qxs192Pfxfot_BaaHGqsjs&usqp=CAU"
            class="card-img-top"
            alt="..."
          />
          <div class="card-body">
            <p class="card-text">
              Some quick example text to build on the card title and make up the bulk of
              the card's content.
            </p>
          </div>
        </div>

        <div class="card" style="width: 18rem">
          <img
            src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRE6GVBVGHhSqD5PB4yGrzU7BybAJLGwkPQiA&s"
            class="card-img-top"
            alt="..."
          />
          <div class="card-body">
            <p class="card-text">
              Some quick example text to build on the card title and make up the bulk of
              the card's content.
            </p>
          </div>
        </div>
      </div>

      <div class="d-flex flex-row flex-row gap-4 mt-5">
        <div class="card" style="width: 18rem">
          <img
            src="https://ynoblesse.com/wp-content/uploads/2023/07/359937836_682922003657771_717380477542506344_n.jpg"
            class="card-img-top"
            alt="..."
          />
          <div class="card-body">
            <p class="card-text">
              Some quick example text to build on the card title and make up the bulk of
              the card's content.
            </p>
          </div>
        </div>

        <div class="card" style="width: 18rem">
          <img
            src="https://ynoblesse.com/wp-content/uploads/2023/07/358520758_1425769678257003_8801872512201663407_n-1024x576.jpg"
            class="card-img-top"
            alt="..."
          />
          <div class="card-body">
            <p class="card-text">
              Some quick example text to build on the card title and make up the bulk of
              the card's content.
            </p>
          </div>
        </div>

        <div class="card" style="width: 18rem">
          <img
            src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRIsPcDmVQ7u6x315pDLliwgAQ9EAW9Q3RQUXkXHbCxw-ep4qxs192Pfxfot_BaaHGqsjs&usqp=CAU"
            class="card-img-top"
            alt="..."
          />
          <div class="card-body">
            <p class="card-text">
              Some quick example text to build on the card title and make up the bulk of
              the card's content.
            </p>
          </div>
        </div>

        <div class="card" style="width: 18rem">
          <img
            src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRE6GVBVGHhSqD5PB4yGrzU7BybAJLGwkPQiA&s"
            class="card-img-top"
            alt="..."
          />
          <div class="card-body">
            <p class="card-text">
              Some quick example text to build on the card title and make up the bulk of
              the card's content.
            </p>
          </div>
        </div>
      </div>
      <!-- v-for -->
    </div>

    <div
      class="footer d-flex flex-column justify-content-center align-items-star mt-5"
      style="background-color: #eaeaea; height: 150px; color: gray"
    >
      <div class="container">
        <p class="mb-1">Igo 사업자 정보</p>
        <p class="mb-1 mt-3" style="font-size: 12px">팀 6조 | 대표 김세훈</p>
        <p class="mb-1" style="font-size: 12px">이규태 박정은 최수환 함지수</p>
        <p class="mb-1" style="font-size: 12px">
          서울특별시 강남구 언주로 603 LX공간정보아카데미
        </p>
        <p class="mb-1" style="font-size: 12px">끝나고 여행가요~</p>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref } from "vue";

const isHeartFilled = ref(false);

const startBt = ref("로그인"); //초기값

function log() {
  if (startBt.value == "로그인") {
    startBt.value = "로그아웃";
  } else {
    startBt.value = "로그인";
  }
}

function toggleHeart() {
  isHeartFilled.value = !isHeartFilled.value;
}

const user = ref({ id: 'dididi', name: "회원1", mbit: "tttt", post: "5" });

const type = ref({
  mbit: "tttt",
  num: "num",
  location: "서울",
  type: "익스트림",
  mobility: "대중교통",
  house: "호캉스",
  house: "hotel",
});
</script>

<style scoped>
.bi-heart {
  color: gray; /* 기본 하트 색상 */
}

.bi-heart-fill {
  color: red; /* 하트가 채워졌을 때 색상 */
}
</style>
