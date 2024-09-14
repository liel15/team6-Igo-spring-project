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
	
	public List<PostVO> getPostList() {
		return session.selectList("getPostList"); 
	}
	
	public PostVO getPostByNo(Integer postNo) {
		return session.selectOne("getPostByNo", postNo);
	}
	
}
