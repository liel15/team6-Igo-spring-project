package lx.team6.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpSession;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lx.team6.service.PostService;
import lx.team6.vo.AddrbookVo;
import lx.team6.vo.PostVO;
import lx.team6.vo.UserVo;
import lx.team6.vo.UserVo;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5173") // vue.js 주소

public class PostController {

	@Autowired
	PostService postservice;

	// 게시글 리스트 불러오기
	@PostMapping("/postlist")
	public ResponseEntity<List<PostVO>> signup() {
		List<PostVO> isgetpost = postservice.getPostList(); // 서비스에 넣을 함수 이름
		if (isgetpost != null) {
			return ResponseEntity.ok(isgetpost);
		} else {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
	
	// 이미지 저장하기
	private static final String UPLOAD_DIR = "C:/lx/team6-spring-project/frontend/public/images/";

    @PostMapping("/upload-image")
    public ResponseEntity<String> uploadImage(@RequestParam("image") MultipartFile file) {
        try {
            // 파일 저장 경로 설정
            Path filePath = Paths.get(UPLOAD_DIR + file.getOriginalFilename());

            // 파일 저장
            Files.write(filePath, file.getBytes());

            // 성공 메시지 반환
            return ResponseEntity.ok("이미지가 성공적으로 저장되었습니다: " + file.getOriginalFilename());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("파일 업로드 실패");
        }
    }

	// 게시글 한개 불러오기
		}
	}
	
	//post 검색기능
	@PostMapping("/serch")
	public ResponseEntity<String> serch(@RequestBody String keyword) { 
		List<PostVO> postList = postservice.serchPostList(keyword);
		if(postList != null) {
			return ResponseEntity.ok(keyword);
		}else {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
	
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

	// 게시글 추가
	@PostMapping("/insert")
	public ResponseEntity<String> insertPost(@RequestBody PostVO post) {
		try {
			System.out.println("받은 게시물 정보 : " + post);
			postservice.insertPost(post);
			return ResponseEntity.ok("게시글이 성공적으로 등록되었습니다.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}

	// 게시글 수정
	@PatchMapping("/update/{postNo}")
	public ResponseEntity<String> updatePost(@PathVariable("postNo") Integer postNo, @RequestBody PostVO post) {
		try {
			System.out.println("수정할 글번호 : "+ postNo);
			System.out.println("받은 글내용 : " + post);
			postservice.updatePost(post);
			return ResponseEntity.ok("게시글이 성공적으로 수정되었습니다.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}

	// 게시글 삭제
	@DeleteMapping("/delete/{postNo}")
	public ResponseEntity<String> deletePost(@PathVariable("postNo") Integer postNo) {
		try {
			System.out.println("삭제할 글번호 : "+ postNo);
			postservice.deletePost(postNo);
			return ResponseEntity.ok("게시글이 성공적으로 삭제되었습니다.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}

}
