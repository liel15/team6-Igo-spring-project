package lx.team6.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lx.team6.vo.PostVO;

@Component
public class PostDAO {

	@Autowired
	SqlSession session;

	// 게시글 리스트 불러오기
	public List<PostVO> getPostList() {
		return session.selectList("getPostList");
	}

	// 게시글 한개 불러오기
	public PostVO getPostByNo(Integer postNo) {
		return session.selectOne("getPostByNo", postNo);
	}

	// 게시글 등록
	public void insertPost(PostVO post) {
		session.insert("insertPost", post);

	}
	
	// 게시글 수정
	public int updatePost(PostVO post) {
		return session.update("updatePost", post);

	}

	// 게시글 삭제
	public int deletePost(Integer postNo) {
		return session.delete("deletePost", postNo);

	}
}
