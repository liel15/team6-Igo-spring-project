package lx.team6.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lx.team6.service.UserService;
import lx.team6.vo.KeywordVo;
import lx.team6.vo.UserVo;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5173") // vue.js 주소

public class HomeController {

	@Autowired
	UserService userservice;
	
	// 로그인
	//reqvo는 클라이언트에서 받는 JSON key값들, vo는 서버 측 vo
	@PostMapping("/login.do")
	public ResponseEntity<UserVo> login(@RequestBody UserVo reqVo, HttpSession session) { 
		UserVo vo = userservice.login(reqVo.getUserId(), reqVo.getUserPw());
		if (vo != null) {
			session.setAttribute("user", vo);
			return ResponseEntity.ok(vo);
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
		}
	}
	
	// 로그아웃
	@PostMapping("/logout.do")
	public String logout(HttpSession session) {
		session.setAttribute("user", null);
		return "redirect:/login_form.do";
	}
	
	 @PostMapping(value = "/signup.do", consumes = {"multipart/form-data"})
	    public ResponseEntity<String> createUserAndService(
	            @RequestPart("user") UserVo userVo,  // User 관련 데이터
	            @RequestPart("keyword") KeywordVo keywordVo,  // Keyword 관련 데이터
	            @RequestPart(value = "userImage", required = false) MultipartFile image) {

	        try {
	            // 1. 이미지 파일 처리 (선택 사항)
	            if (image != null && !image.isEmpty()) {
	                String uploadDirectory = "C:/images/";
	                String fileName = image.getOriginalFilename();
	                String filePath = Paths.get(uploadDirectory, fileName).toString();

	                // 디렉토리 생성
	                File directory = new File(uploadDirectory);
	                if (!directory.exists()) {
	                    directory.mkdirs();
	                }

	                // 이미지 파일 저장
	                File file = new File(filePath);
	                image.transferTo(file);

	                // 이미지 경로 설정
	                userVo.setUserImage("/images/" + fileName);
	            }

	            // 2. 회원 정보와 키워드 정보를 트랜잭션으로 저장
	            userservice.createUserAndKeyword(userVo, keywordVo);

	            return ResponseEntity.ok("회원가입 성공");

	        } catch (IOException e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("파일 처리 중 오류가 발생했습니다.");
	        }
	    }


}
	


