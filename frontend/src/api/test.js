import { apiInstance } from "./index.js";

const api = apiInstance();

async function getTestList() {
  try {
    const response = await api.get('/test');
    return response.data;
  } catch (err) {
    console.error(err);
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