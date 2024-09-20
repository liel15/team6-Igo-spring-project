package lx.team6.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lx.team6.vo.PostKeywordVO;
import lx.team6.vo.PostVO;

@Component
public class PostKeywordDAO {

	@Autowired
	SqlSession session;

	// 키워드 추가
	public int insertPostKeyword(PostKeywordVO postkeyword) {
		return session.insert("insertPostKeyword", postkeyword);
	}

	public PostKeywordVO getPostKeywordByNo(Integer postNo) {
		return session.selectOne("getPostKeywordByNo", postNo);
	}

	public int updatePostKeyword(PostKeywordVO postkeyword) {
		return session.update("updatePostKeyword", postkeyword);
	}

	public void deletePostKeyword(Integer keywordNumber) {
		session.delete("deletePostKeyword", keywordNumber);
	}
	
	
}
