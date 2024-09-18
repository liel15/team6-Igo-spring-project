package lx.team6.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		// 세션에서 사용자 로그인 여부 확인 (예: user 세션 속성이 존재하는지 확인)
		HttpSession session = request.getSession();
		Object loggedInUser = session.getAttribute("user"); // "user"는 로그인 시 저장된 세션 속성 이름

		if (loggedInUser == null) {
			// 로그인되어 있지 않으면 로그인 페이지로 리다이렉트
			response.sendRedirect("/mainpage");
			return false; // 요청을 중단하고 리다이렉트 처리
		}

		// 로그인되어 있으면 계속 진행
		return true;
	}
}
