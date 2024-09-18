package lx.team6.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lx.team6.vo.LikeVO;

@Component
public class LikeDAO {

	@Autowired
	SqlSession session;

	// 게시글 등록
	public void insertLike(LikeVO like) {
		session.insert("insertLike", like);

	}
	
	// LikeDAO
	public boolean existsByUserNoAndPostNo(LikeVO like) {
	    return session.selectOne("existsByUserNoAndPostNo", like);
	}

	// 게시글 번호로 좋아요 수 찾기
	public Integer getLikeByPostNo(Integer postNo) {
		return session.selectOne("getLikeByPostNo", postNo);
	}
	
	
}
