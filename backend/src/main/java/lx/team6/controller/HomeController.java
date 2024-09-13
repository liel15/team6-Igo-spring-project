package lx.team6.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lx.team6.service.AddrbookService;
import lx.team6.vo.AddrbookVo;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5173") // vue.js 주소

public class HomeController {

	@Autowired
	AddrbookService addrbookservice;
	

	@PostMapping("/login")
	public ResponseEntity<AddrbookVo> login(@RequestBody AddrbookVo reqVo, HttpSession session) { 
		AddrbookVo vo = addrbookservice.login(reqVo.getAbId(), reqVo.getAbPw());
		//reqvo는 클라이언트 vo, vo는 서버 vo
		if (vo != null) {
			session.setAttribute("user", vo);
			return ResponseEntity.ok(vo);
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
		}
	}

	@PostMapping("/logout.do")
	public String logout(HttpSession session) {
		session.setAttribute("user", null);
		return "redirect:/login_form.do";
	}
	
	@PostMapping("/signup.do")
	public ResponseEntity<String> signup(@RequestBody AddrbookVo reqVo) {
		AddrbookVo isSignUp = addrbookservice.signup(reqVo); // 서비스에 넣을 함수 이름
	        if (isSignUp != null) {
	            return ResponseEntity.ok("회원가입성공");
	        } else {
	            return ResponseEntity.status(HttpStatus.CONFLICT).body("아이디가 이미 있습니다");
	        }
	    }
	
	/*
	 * @RequestMapping("/logout.do") public String login(HttpSession session) throws
	 * IOException { session.setAttribute("userId", null); return
	 * "redirect:/login_form.do"; }
	 */
	
	@RequestMapping("/home.do")
	public String home() {
		System.out.println("home.do");
		return "home";
	}

	/*
	 * @RequestMapping("/login_form.do") public String getLoginForm() {
	 * System.out.println("login_form.do"); return "addrbook/login_form"; }
	 */

	/*
	 * @RequestMapping("/login.do") public String login(String userId, String
	 * password, HttpSession session) throws IOException { String page =
	 * "login_form.do"; if (userId.equals(password)) {
	 * session.setAttribute("userId", userId); page = "list.do"; } return
	 * "redirect:/" + page; }
	 */


}
