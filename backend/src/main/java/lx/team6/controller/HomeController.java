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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lx.team6.service.UserService;
import lx.team6.vo.KeywordVo;
import lx.team6.vo.UserKeywordVo;
import lx.team6.vo.UserVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5173") // vue.js 주소
public class HomeController {

	@Autowired
	UserService userservice;
	
	// 로그인
	//reqvo는 클라이언트에서 받는 JSON key값들, vo는 서버 측 vo
	@PostMapping("/login")
	public ResponseEntity<UserKeywordVo> login(@RequestBody UserKeywordVo reqVo, HttpSession session) { 
		UserKeywordVo vo = userservice.login(reqVo.getUserId(),reqVo.getUserPw());
		if (vo != null) {
			return ResponseEntity.ok(vo);
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
		}
	}
	
	// 로그아웃
	@PostMapping("/logout")
	public String logout(HttpSession session) {
		session.setAttribute("user", null);
		return null;
	}
	
	//회원가입
	 @PostMapping(value = "/signup", consumes = {"multipart/form-data"})
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
	 
	 //Id 중복확인
	 @GetMapping("/checkId")
	 public String findId(@RequestParam String userId) {
	 	return userservice.findId(userId);
	 }
	 
	 //비밀번호 찾기
	 @PostMapping("/findPassword")
	 public  ResponseEntity<String> findPassword(@RequestBody UserVo reqvo) {
		String pw = userservice.findPassword(reqvo.getUserId(),reqvo.getUserName(),reqvo.getUserEmail());
		if (pw != null) {
			return ResponseEntity.ok(pw);
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
		}
	 }
	 
	 //아이디 찾기
	 @PostMapping("/findId")
	 public  ResponseEntity<String> findUserId(@RequestBody UserVo reqvo) {
		 String id = userservice.findUserId(reqvo.getUserName(),reqvo.getUserEmail());
		 if (id != null) {
			 return ResponseEntity.ok(id);
		 } else {
			 return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
		 }
	 }
	 

	//회원정보 수정 통합
	 @PostMapping(value = "/updateuser", consumes = {"multipart/form-data"})
	 public ResponseEntity< UserKeywordVo> updateUser(
	         @RequestPart("userKeyword") UserKeywordVo userKeywordVo, // User와 Keyword 관련 데이터
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
	             userKeywordVo.setUserImage("/images/" + fileName);  // 이미지 경로를 UserVo에 설정
	         }

	         // 2. 회원 정보와 키워드 정보를 수정하는 서비스 호출
	         UserKeywordVo updatedUserKeywordVo =  userservice.updateUserAndKeyword(userKeywordVo);

	         return ResponseEntity.ok(updatedUserKeywordVo);
	     } catch (Exception e) {
	         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	     }
	 }


}
	


