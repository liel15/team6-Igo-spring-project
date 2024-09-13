package lx.team6.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lx.team6.service.UserService;
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
	
	// 회원가입
	@PostMapping("/signup.do")
	public ResponseEntity<String> signup(@RequestBody UserVo reqVo) {
		UserVo isSignUp = userservice.signup(reqVo); // 서비스에 넣을 함수 이름
	        if (isSignUp != null) {
	        	return ResponseEntity.ok().build();
	        } else {
	        	 return ResponseEntity.status(HttpStatus.CONFLICT).build();
	        }
	    }
	
	// 이미지 업로드 (FormData로 이미지 전송)
    @PostMapping("/uploadImage.do")
    public Map<String, String> uploadImage(@RequestParam("userImage") MultipartFile image) throws IOException {
        // 이미지 파일 저장 경로 설정 (예: 로컬 경로)
        String uploadDirectory = "C:/images/";
        String fileName = image.getOriginalFilename();
        
        // 파일 타입 체크 (예: 이미지 파일만 허용)
        if (!image.getContentType().startsWith("image/")) {
            throw new IOException("이미지 파일만 업로드할 수 있습니다.");
        }
        
        // 파일 크기 제한 (예: 5MB 이하)
        long maxFileSize = 5 * 1024 * 1024; // 5MB
        if (image.getSize() > maxFileSize) {
            throw new IOException("파일 크기는 5MB 이하로 제한됩니다.");
        }

        String filePath = Paths.get(uploadDirectory, fileName).toString();

        // 파일을 저장할 디렉토리가 없으면 생성
        File directory = new File(uploadDirectory);
        if (!directory.exists()) {
            directory.mkdirs(); // 폴더가 없으면 폴더 생성
        }

        // 파일을 서버에 저장
        File file = new File(filePath);
        image.transferTo(file);

        // 이미지 파일 경로를 반환
        Map<String, String> result = new HashMap<>();
        result.put("filePath", "/images/" + fileName);
        return result;
    }
	

}
