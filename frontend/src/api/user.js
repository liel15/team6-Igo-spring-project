
import { apiInstance } from "./index.js";

const api = apiInstance();

//로그인 요청-lgt
export async function login(id, password) {
  try {
    const response = await api.post("/auth/login", {     
        userId: id,
        userPw: password   
    }, 
    );
    return response.data;
  } catch (error) {
    throw new Error("잘못된 정보입니다. 다시 입력하세요");
  }
}


//비밀번호 찾기-lgt
export async function findPassword(id, name, email) {
  try {
    const response = await api.post('/auth/findPassword', {
      userId: id,
      userName: name,
      userEmail: email,
    });
    console.log("API response:", response);
    return response.data;
  } catch (error) {
    throw new Error("잘못된 정보입니다. 다시 입력하세요")
  }
}

//아이디 찾기-lgt
export async function findById(name, email) {
  try {
    const response = await api.post('/auth/findId', {
      userName: name,
      userEmail: email,
    });
    console.log("API response:", response);
    return response.data;
  } catch (error) {
    throw new Error("잘못된 정보입니다. 다시 입력하세요")
  }
}

