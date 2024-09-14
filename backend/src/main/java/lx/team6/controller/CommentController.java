package lx.team6.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lx.team6.service.CommentService;
import lx.team6.vo.CommentVo;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5173") 
public class CommentController {
	
	@Autowired
	CommentService commentService;
	
	//새 댓글 달기
	@PostMapping("/createComment")
	public ResponseEntity<String> createComment(@RequestBody CommentVo reqComment, HttpSession session) {
		int result = commentService.createComment(reqComment);
		if (result > 0) {
			session.setAttribute("newComment", reqComment);
			return ResponseEntity.ok("댓글 달기 성공");
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("댓글 달기 실패");
		}
	}
	
	//댓글 보여주기(가져오기)
	@GetMapping("/comments")
	public ResponseEntity<List<CommentVo>> getCommentList() {
		List<CommentVo> comments = commentService.getCommentList();
		return ResponseEntity.ok(comments);
	}
	
	//댓글 삭제하기
	@DeleteMapping("/deleteComments")
	public ResponseEntity<String> deleteComment(@PathVariable("commentNo") Integer CommentNo) {
		try {
			System.out.println("삭제할 댓글 : " + CommentNo);
			commentService.deleteComment(CommentNo);
			return ResponseEntity.ok("댓글이 삭제되었습니다.");
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();		
		}
	}
	
	

}
