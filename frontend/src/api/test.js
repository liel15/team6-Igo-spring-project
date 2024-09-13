import { apiInstance } from "./index.js";

const api = apiInstance();

async function getTestList(id, password) {
  try {
    const response = await api.post('/auth/login', {
      abId: this.id,
      abPw: this.password,
    });
    return response.data;
  } catch (err) {
    console.error(err);
  }
}

//post들 가져오기 요청
export async function getPostList() {
  try {
    const response = await api.post('/auth/postlist');
    console.log(response.data);
    return response.data;
  } catch (err) {
    console.error(err); // 에러를 콘솔에 출력
  }
}



// params 예시
async function getTestListById(params) {
  try {
    const response = await api.get('/test', {params});
    return response.data;
  } catch (err) {
    console.error(err);
  }
}

// POST 요청
async function createReservation(data) {
  try {
    const response = await api.post('/test', data);
    return response.data;
  } catch (err) {
    console.error(err); // 에러를 콘솔에 출력
  }
}

// PUT 요청
async function updateReservation(id, data) {
  try {
    const response = await api.put(`/test/${id}`, data);
    return response.data;
  } catch (err) {
    console.error(err);
  }
}

// DELETE 요청
async function deleteReservation(id) {
  try {
    const response = await api.delete(`/test/${id}`);
    return response.data;
  } catch (err) {
    console.error(err);
  }
}

// PATCH 요청
async function partialUpdateReservation(id, data) {
  try {
    const response = await api.patch(`/test/${id}`, data);
    return response.data;
  } catch (err) {
    console.error(err);
  }
}

export { getTestList };