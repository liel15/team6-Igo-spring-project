package lx.team6.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lx.team6.dao.UserDAO;
import lx.team6.vo.KeywordVo;
import lx.team6.vo.UserVo;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    // 회원가입 및 키워드 저장을 트랜잭션으로 처리
    @Transactional
    public int createUserAndKeyword(UserVo userVo, KeywordVo keywordVo) {
        // 1. User 테이블에 데이터 삽입
        int userInsertResult = userDAO.createUser(userVo);  // userVo의 userNo 필드에 자동으로 PK가 들어감

        // 2. Keyword 테이블에 데이터 삽입 (User의 PK를 FK로 사용)
        keywordVo.setKeywordUserNumber(userVo.getUserNumber());  // User 테이블의 PK를 FK로 설정
        int keywordInsertResult = userDAO.createKeyword(keywordVo);

        // 삽입 결과 반환
        return userInsertResult + keywordInsertResult;  // 두 테이블 삽입 결과를 더한 값 반환 (성공한 삽입 수)
    }

    // 로그인 처리
    public UserVo login(String userId, String userPw) {
        UserVo user = userDAO.findById(userId);
        if (user != null && user.getUserPw().equals(userPw)) {
            return user;
        }
        return null;
    }
}
