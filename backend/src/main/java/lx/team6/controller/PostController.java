package lx.team6.controller;

import java.util.List;

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
import lx.team6.service.PostService;
import lx.team6.vo.AddrbookVo;
import lx.team6.vo.PostVO;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5173") // vue.js 주소

public class PostController {

	@Autowired
	PostService postservice;
	
	@PostMapping("/postlist")
	public ResponseEntity<List<PostVO>> signup() {
		List<PostVO> isgetpost = postservice.getPost(); // 서비스에 넣을 함수 이름
		if (isgetpost != null) {
			return ResponseEntity.ok(isgetpost);
		} else {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
	

}
