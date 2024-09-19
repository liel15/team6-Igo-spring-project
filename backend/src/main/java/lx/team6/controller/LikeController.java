package lx.team6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lx.team6.service.LikeService;
import lx.team6.vo.LikeVO;
import lx.team6.vo.PostVO;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5173") // vue.js 주소

public class LikeController {

	@Autowired
	LikeService likeservice;
	
	// 게시글에 좋아요 추가 - 정은
	@PostMapping("/insertLike")
	public ResponseEntity<String> insertLike(@RequestBody LikeVO likeVO) {
	    try {
	        likeservice.insertLike(likeVO);
	        return ResponseEntity.status(HttpStatus.CREATED).body("좋아요가 성공적으로 추가되었습니다.");
	    } catch (Exception e) {
	        if (e.getMessage().equals("User already liked this post.")) {
	            return ResponseEntity.status(HttpStatus.CONFLICT).body("이미 좋아요를 누른 게시물입니다.");
	        }
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }
	}
	
	// 게시글 번호에 따른 좋아요 수 가져오기
		@GetMapping("/like/{postNo}")
		public ResponseEntity<Integer> getLikeByPostNo(@PathVariable("postNo") Integer postNo) {
			System.out.println(postNo);
			Integer likeCount = likeservice.getLikeByPostNo(postNo); 
			System.out.printf("좋아요 수 : "+ likeCount);
			return ResponseEntity.ok(likeCount);
		}
	
	// 이 유저의 해당 글 좋아요 정보 불러오기 유/무 - 정은
	@GetMapping("/likesList/{userNo}")
	public ResponseEntity<List<LikeVO>> getLikesList(@PathVariable("userNo") Integer userNo) {
		List<LikeVO> likes = likeservice.getLikesList(userNo); // 서비스에 넣을 함수 이름
		//System.out.println("좋아요 리스트 : " + likes);
		if (likes != null && !likes.isEmpty()) {
			//System.out.println("좋아요 리스트 : " + likes);
			return ResponseEntity.ok(likes);
		} else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
	}
		
	// 좋아요 삭제 - 정은
	@DeleteMapping("/deleteLike/{likeNo}")
	public ResponseEntity<String> deletePost(@PathVariable("likeNo") Integer likeNo) {
		try {
			System.out.println("삭제할 좋아요번호 : " + likeNo);
			likeservice.deleteLike(likeNo);
			return ResponseEntity.ok("좋아요가 성공적으로 삭제되었습니다.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}


}
