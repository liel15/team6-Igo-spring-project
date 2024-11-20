<h1>IGO</h1>
📍 프로젝트 기간 : 2024.8 ~ 2024.8 
<br>
📍 배포 URL :  배포예정
<br>
<br>

# 📌 개요

```
- 여행 일정을 동선별로 보다 편하게 짤 수 있도록 하고, 계획한 일정을 사용자들이 서로 공유 할 수 있는 웹사이트 프로젝트 입니다.

- 회원가입과 로그인을 통해 웹사이트를 이용 할 수 있습니다.

- 지도 상에서 여행 일정을 계획 할 수 있도록 주소 검색기능과 선택한 주소를 동선별로 추가 할 수 있는 기능이 있습니다. 

- 계획한 일정을 서로 공유 하고 마음에 드는 일정을 저장 할 수 있도록 구현 했습니다. 

- 저장한 일정을 관리 할 수 있고 프로필 관리도 할 수 있는 마이페이지를 구현 했습니다. 


```

</br>

# ⚙️ 기술 및 개발환경

### [기술]

📌 FrontEnd: HTML5, CSS3, JavaScript, Vue.js, Pinia
<br/>
📌 BackEnd: Spring Boot
<br/>
📌 DB: MySQL
<br/>
📌 Version:

- client

```
 "axios": "^1.7.7",
  "bootstrap": "^5.3.3",
  "bootstrap-icons": "^1.11.3",
  "frontend": "file:",
  "install": "^0.13.0",
  "pinia": "^2.1.7",
  "vue": "^3.4.29",
  "vue-router": "^4.3.3"
```

- server

```
spring-context: 5.3.39
spring-webmvc: 5.3.39
spring-dao: 2.0.8
spring-jdbc: 5.3.39
spring-aop: 5.3.39
spring-aspects: 5.3.39

slf4j-api: 2.0.13
jcl-over-slf4j: 2.0.13
slf4j-log4j12: 2.0.13

junit-jupiter-api: 5.10.2

mysql-connector-j: 8.4.0
mybatis: 3.5.16
commons-dbcp2: 2.12.0
mybatis-spring: 2.1.2

jackson-databind: 2.15.2

jaxb-api: 2.3.1
```

</br>

# ⚙️ 구현 기능

- 📄 로그인 페이지
  - 로그인 / 로그아웃
  - 회원가입
  - 아이디 중복검사
  - 프로필 이미지 등록

- 📄 여행일정생성 페이지
  - 여행일정 계획
  - 달력생성 및 여행날짜 추가 기능
  - 생성한 일정 지도에 순번으로 출력
  - 카카오맵 연동
  - 카카오맵 검색 기능 및 마커 사용
    
- 📄 메인페이지
  - 자사 서비스 홍보 및 설명 케러셀
  - 여행관련 일정 영상 출력
  - 모든 사용자가 여행일정 공유 할수 있는 피드 구현

- 📄 마이페이지
  - 내 여행일정 관리
  - 찜한 여행일정 리스트
  - 내 프로필 출력

# ⚙️ 실행 방법

- client

```
  // 루트 폴더 기준
  > cd client
  > npm start
```

- server

```
  // 프론트 실행
  // 루트 폴더 기중
  > cd frontend
  > npm start

  // 백엔드 실행
  // 루트 폴더 기준
  > cd backend
  > mvn spring-boot:run
  
```

# ✨ 코드 포인트

### Vue.js

- CSR 방식을 사용하여 웹사이트가 동작을 빠르게 응답하게 함
- 공통적인 컴포넌트를 미리 작업하여 효율성을 높임

### Pinia

- Pinia을 웹사이트에 필요한 데이터들을 관리
- 전역적으로 사용하는 Modal기능 및 상태값들을 Reducer로 상태관리 하였습니다.
- store 폴더를 생성하여 뷰와 로직을 분리

### Spring Boot / MySQL

- Spring Boot를 사용하여 MySQL 연동
- 경로의 이름과 규칙을 통일하여 RestfulAPI를 도입

### MyBatis

- MyBatis를 사용하여 SQL문을 Mapper를 통해 작성

### AOP / log4j

- AOP를 사용하여 로그를 전역적으로 관리함
- log4j를 사용하고 info, warining, error 3단계로 로그 관리

### Intercepter

- Spring Boot Intercepter를 사용하여 권한이 없는 요청을 받았을 때 차단

### Axios 

- Axios를 사용하여 서버와 통신
- axios intercepter를 사용하여 요청할 때 필요한 공통적인 권한 정보, 헤더 정보들을 삽입하여 전송

</br>

# 🗂 폴더트리

```
📦 src
 ┣📂 client
 ┃ ┣📂 public
 ┃ ┗📂 src
 ┃  ┣📂 api
 ┃  ┣📂 app
 ┃  ┣📂 asset
 ┃  ┣📂 components
 ┃  ┣📂 constant
 ┃  ┣📂 hoc
 ┃  ┣📂 hook
 ┃  ┣📂 lib
 ┃  ┣📂 pages
 ┃  ┣📂 redux
 ┃  ┣📂 router
 ┃  ┣📂 styles
 ┃  ┗📂 types
 ┃
 ┣📂 server
   ┣📂 dist
   ┗📂 src
    ┣📂 config
    ┣📂 controllers
    ┣📂 middleware
    ┣📂 models
    ┣📂 routes
    ┗📂 utils


```

</br>
