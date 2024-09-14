package lx.team6.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lx.team6.vo.CommentVo;

@Component
public class CommentDAO {
	
	@Autowired
	SqlSession session;
	
	public int createComment(CommentVo vo) {
		return session.insert("createComment",vo);
	}
	
	public List<CommentVo> getCommentList() {
		return session.selectList("getCommentList");
	}
	
	public int deleteComment(Integer commentNo) {
		return session.delete("deleteComment", commentNo);
	}

}
