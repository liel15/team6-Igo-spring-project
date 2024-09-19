package lx.team6.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lx.team6.service.PostKeywordService;
import lx.team6.service.PostService;
import lx.team6.vo.PostKeywordVO;
import lx.team6.vo.PostVO;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5173") // vue.js 주소

public class PostKeywordController {

	@Autowired
	PostKeywordService postkeywordservice;

	Logger logger = LoggerFactory.getLogger(this.getClass());
/*
	// 키워드 한세트 불러오기 - 정은
	@GetMapping("/postkeyword/{postNo}")
	public ResponseEntity<PostVO> getpost(@PathVariable("postNo") Integer postNo) {
		logger.info("info : MyBatis로 getpost()기능 처리");
		System.out.println(postNo);
		PostVO post = postkeywordservice.getPostByNo(postNo); // 서비스에 넣을 함수 이름
		if (post != null) {
			return ResponseEntity.ok(post);
		} else {
			return ResponseEntity.notFound().build();
		}
	}*/
	
	// 키워드 한세트 추가 - 정은
	@PostMapping("/insertkeyword")
	public ResponseEntity<String> insertPostKeyword(@RequestBody PostKeywordVO postkeyword) {
		logger.info("info : MyBatis로 insertPostKeyword()기능 처리");
		try {
			postkeywordservice.insertPostKeyword(postkeyword);
			return ResponseEntity.status(HttpStatus.CREATED).body("키워드가 성공적으로 등록되었습니다.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
	
}
