package lx.team6.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("로그인인터셉터" + request.getRequestURI());
		HttpSession session = request.getSession(true);
		Object loggedInUser = session.getAttribute("user");
		System.out.println(loggedInUser);
		if (loggedInUser == null) {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // 401 Unauthorized 반환
			System.out.println(HttpServletResponse.SC_UNAUTHORIZED);
			return false; // 요청을 중단하고 리다이렉트 처리
		}

		// 로그인되어 있으면 계속 진행
		return true;
	}
}
