package lx.team6.dao;

import java.util.List;
import java.util.Map;

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
		try {
	        return session.selectList("mapper-post.getPostList");
	    } catch (Exception e) {
	        e.printStackTrace(); // 쿼리 실행 중 오류 발생 시 로그 출력
	        return null;
	    }
	}

	// 게시글 한개 불러오기
	public PostVO getPostByNo(Integer postNo) {
		return session.selectOne("getPostByNo", postNo);
	}

	public List<PostVO> serchPostList(String keyword) {
		return session.selectList("serchPostList", keyword);
	}
	
	// 게시글 등록
	public int insertPost(PostVO post) {
		return session.insert("insertPost", post);
	}
	
	// 게시글 수정
	public int updatePost(PostVO post) {
		return session.update("updatePost", post);

	}

	// 게시글 삭제
	public int deletePost(Integer postNo) {
		return session.delete("deletePost", postNo);

	}
	
	//좋아요 리스트 가져오기
	public List<PostVO> getLikesPostList(Integer userNo) {
		List<PostVO> test =  session.selectList("getLikesPostList");
		System.out.println(test);
		return session.selectList("getLikesPostList", userNo);
	}
	
	// 좋아요 여부 체크
    public boolean checkIfLiked(Integer postNo, Integer userNo) {
        Integer count = session.selectOne("checkIfLiked", Map.of("postNo", postNo, "userNo", userNo));
        return count != null && count > 0;
    }

    // 좋아요 추가
    public void addLike(Integer postNo, Integer userNo) {
        session.insert("addLike", Map.of("postNo", postNo, "userNo", userNo));
    }

    // 좋아요 제거
    public void removeLike(Integer postNo, Integer userNo) {
        session.delete("removeLike", Map.of("postNo", postNo, "userNo", userNo));
    }
	
	
}
