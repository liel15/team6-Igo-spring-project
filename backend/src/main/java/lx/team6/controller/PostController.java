package lx.team6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lx.team6.service.PostService;
import lx.team6.vo.PostVO;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5173") // vue.js 주소

public class PostController {

	@Autowired
	PostService postservice;

	// 게시글 리스트 불러오기
	@GetMapping("/postlist")
	public ResponseEntity<List<PostVO>> getPostList() {
		List<PostVO> isgetpost = postservice.getPostList(); // 서비스에 넣을 함수 이름
		if (isgetpost != null) {
			return ResponseEntity.ok(isgetpost);
		} else {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}

	// post 검색기능
	@PostMapping("/serch")
	public ResponseEntity<String> serch(@RequestBody String keyword) {
		List<PostVO> postList = postservice.serchPostList(keyword);
		if (postList != null) {
			return ResponseEntity.ok(keyword);
		} else {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}

	// 게시글 한개 불러오기 - 정은
	@GetMapping("/post/{postNo}")
	public ResponseEntity<PostVO> getpost(@PathVariable("postNo") Integer postNo) {
		System.out.println(postNo);
		PostVO post = postservice.getPostByNo(postNo); // 서비스에 넣을 함수 이름
		if (post != null) {
			return ResponseEntity.ok(post);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// 게시글 추가 - 정은
	@PostMapping("/insert")
	public ResponseEntity<String> insertPost(@RequestBody PostVO post) {
		try {
			postservice.insertPost(post);
			return ResponseEntity.status(HttpStatus.CREATED).body("게시글이 성공적으로 등록되었습니다.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}

	// 게시글 수정 - 정은
	@PatchMapping("/update/{postNo}")
	public ResponseEntity<String> updatePost(@PathVariable("postNo") Integer postNo, @RequestBody PostVO post) {
		try {
			System.out.println("수정할 글번호 : " + postNo);
			System.out.println("받은 글내용 : " + post);
			postservice.updatePost(post);
			return ResponseEntity.ok("게시글이 성공적으로 수정되었습니다.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}

	// 게시글 삭제 - 정은
	@DeleteMapping("/delete/{postNo}")
	public ResponseEntity<String> deletePost(@PathVariable("postNo") Integer postNo) {
		try {
			System.out.println("삭제할 글번호 : " + postNo);
			postservice.deletePost(postNo);
			return ResponseEntity.ok("게시글이 성공적으로 삭제되었습니다.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}

	// 좋아요 리스트 가져오기
	@GetMapping("/likesPostList/{userNo}")
	public ResponseEntity<List<PostVO>> getLikesPost(@PathVariable("userNo") Integer userNo) {
		List<PostVO> likedPosts = postservice.getLikesPostList(userNo); // 서비스에 넣을 함수 이름
		if (likedPosts != null && !likedPosts.isEmpty()) {
			return ResponseEntity.ok(likedPosts);
		} else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
	}

	// 좋아요 토글
	@PostMapping("/toggleLike/{postNo}/{userNo}")
	public ResponseEntity<String> toggleLike(@PathVariable("postNo") Integer postNo,
			@PathVariable("userNo") Integer userNo) {
		System.out.println("좋아요 토글된 게시물 번호: " + postNo);
		postservice.toggleLike(postNo, userNo);
		return ResponseEntity.ok("Like toggled");
	}

	
}
