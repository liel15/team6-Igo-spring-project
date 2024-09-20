package lx.team6.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lx.team6.dto.UserInfoDTO;
import lx.team6.vo.KeywordVo;
import lx.team6.vo.UserKeywordVo;
import lx.team6.vo.UserVo;

@Component
public class UserDAO {
	
	@Autowired
	SqlSession session;
	
	//방명록정보를 전달받아서 DB에 저장함
	public void createAddrbook(UserVo vo) {
		session.insert("createAddrbook", vo);
	}
	
	//dto에 저장된 유저정보를 보여줌
	public UserInfoDTO showUserInfo(String userId) {
		return session.selectOne("showUserInfo", userId);
	}

	public void deleteAddrbookList(int abId) {
		session.delete("deleteAddrbookList",abId);
	}
	
	public void updateAddrbookList(UserVo vo) {
		session.update("updateAddrbookList", vo);
	}
	
	//로그인 및 아이디 중복확인
	public UserKeywordVo findById(String abId) {
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
    
    //비밀번호 찾기
    public UserVo findByPassword(UserVo param) {
        return session.selectOne("findByPassword", param);
    }
    
    //아이디 찾기
    public UserVo findUserId(UserVo param) {
    	return session.selectOne("findUserId", param);
    }
    
    //회원정보수정 통합
    public int updateUserAndKeyword(UserKeywordVo userKeywordVo) {
        return session.update("updateUserAndKeyword", userKeywordVo);
    }

}
