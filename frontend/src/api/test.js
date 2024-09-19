import { apiInstance } from "./index.js";

const api = apiInstance();

//로그인-이건 user에 다시 만들어서 지워도 될듯
async function getTestList(id, password) {
  try {
    const response = await api.get('/auth/login');
    return response.data;
  } catch (err) {
    console.error(err);
  }
}


//userNo에 따른 postlikeslist를 요청
export async function getLikesPostList(userNo) {
  try {
    const response = await api.get(`/auth/likesPostList/${userNo}`);
    console.log("you can use getLikesPostList", response.data);
    return response.data;
  } catch (err) {
    console.error(err); // 에러를 콘솔에 출력
  }
}

//userNo에 따른 likesliest 요청
export async function getLikesList(userNo) {
  try {
    const response = await api.get(`/auth/likesList/${userNo}`);
    console.log("you can use getLikesList", response.data);
    return response.data;
  } catch (err) {
    console.error(err); // 에러를 콘솔에 출력
  }
}

//post_no에 따른 좋아요수 가져오기 요청
export async function getLikeByPostNo(postNo) {
  try {
    console.log("Sending post request with postNo:", postNo);
    const response = await api.get(`/auth/like/${postNo}`);
    console.log("API response:", response);
    return response.data;
  } catch (err) {
    console.error(err); // 에러를 콘솔에 출력
  }
}

// 좋아요 버튼누르면 추가하기
export async function insertLike(data) {
  try {
    const response = await api.post('/auth/insertLike', data);
    return response.data;
  } catch (err) {
    console.error(err);
    throw err;
  }
}

// 좋아요 삭제하기
export async function deleteLikeByNo(likeNo) {
  try {
    const response = await api.delete(`/auth/deleteLike/${likeNo}`);
    return response.data;
  } catch (err) {
    console.error(err);
  }
}


// 좋아요 상태 토글
export async function toggleLikePost(postNo, userNo) {
  try {
    const response = await api.post(`/auth/toggleLike/${postNo}/${userNo}`, {});  // userNo도 함께 전달
    return response.data;
  } catch (err) {
    console.error('Error toggling like:', err);
  }
}


//postlist를 가져오기 요청
export async function getPostList() {
  try { 
    const response = await api.get('/auth/postlist');
    console.log("you can use getPostList", response.data);
    return response.data;
  } catch (err) {
    console.error(err); // 에러를 콘솔에 출력
  }
}

//post_no에 따른 post한개 가져오기 요청
export async function getPostByNo(postNo) {
  try {
    console.log("Sending post request with postNo:", postNo);
    const response = await api.get(`/auth/post/${postNo}`);
    console.log("API response:", response);
    return response.data;
  } catch (err) {
    console.error(err); // 에러를 콘솔에 출력
  }
}

// DELETE 요청
export async function deletePostByNo(postNo) {
  try {
    const response = await api.delete(`/auth/delete/${postNo}`);
    return response.data;
  } catch (err) {
    console.error(err);
  }
}

// PATCH 요청 - 후기글 업데이트
export async function updatePostByNo(postNo, data) {
  try {
    const response = await api.patch(`/auth/update/${postNo}`, data);
    return response.data;
  } catch (err) {
    console.error(err);
  }
}

// 글 작성 요청 - PUT 요청
export async function insertPost(data) {
  try {
    const response = await api.post('/auth/insert', data);
    return response.data;
  } catch (err) {
    console.error(err);
  }
}

// 게시글과 키워드를 함께 추가하기
export async function insertPostAndKeyword(postData, keywordData) {
  const formData = new FormData();
  formData.append('post', new Blob([JSON.stringify(postData)], { type: 'application/json' }));
  formData.append('postkeyword', new Blob([JSON.stringify(keywordData)], { type: 'application/json' }));

  try {
    const response = await api.post('/auth/insert', formData, {
      headers: {
        'Content-Type': 'multipart/form-data',
      },
    });
    return response.data;
  } catch (err) {
    console.error(err);
    throw err;
  }
}



// 글 키워드 추가 요청
export async function insertPostKeyword(data) {
  try {
    const response = await api.post('/auth/insertkeyword', data);
    return response.data;
  } catch (err) {
    console.error(err);
  }
}

// 이미지 저장요청
export async function saveImage(formData) {
  try {
    const response = await api.post('/auth/upload-image', formData, {
      headers: {
        'Content-Type': 'multipart/form-data',
      },
    });
    console.log('서버 응답:', response.data);
    return response.data;
  } catch (err) {
    console.error('이미지 업로드 중 오류 발생:', err); // 에러를 콘솔에 출력
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
