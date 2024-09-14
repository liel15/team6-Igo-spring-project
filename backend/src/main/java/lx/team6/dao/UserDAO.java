package lx.team6.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lx.team6.vo.KeywordVo;
import lx.team6.vo.UserVo;

@Component
public class UserDAO {
	
	@Autowired
	SqlSession session;
	
	//방명록정보를 전달받아서 DB에 저장함
	public void createAddrbook(UserVo vo) {
		session.insert("createAddrbook", vo);
	}
	
	//저장된 정보를 보여줌
	public List<UserVo> showAddrbookList() throws Exception {
		return session.selectList("showAddrbookList");
	}


	public void deleteAddrbookList(int abId) {
		session.delete("deleteAddrbookList",abId);
	}
	
	public void updateAddrbookList(UserVo vo) {
		session.update("updateAddrbookList", vo);
	}
	
	//아이디 찾기
	public UserVo findById(String abId) {
		return session.selectOne("findById", abId);
	}
	
	//회원가입
	public int createUser(UserVo vo) {
		return session.insert("createUser", vo);
		}
	
	// Keyword 테이블에 데이터 삽입
    public int createKeyword(KeywordVo keywordVo) {
        return session.insert("createKeyword", keywordVo);  // Keyword 테이블에 삽입 후 삽입된 행 수 반환
    }
}
