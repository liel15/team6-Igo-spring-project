
import { apiInstance } from "./index.js";

const api = apiInstance();

export async function login(id, password) {
  try {
    const response = await api.post("/auth/login.do", {
      userId: id,
      userPw: password,
    });
    return response.data;
  } catch (error) {
    throw new Error("Invalid username or password");
  }
}
