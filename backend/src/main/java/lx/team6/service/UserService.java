package lx.team6.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import lx.team6.dao.UserDAO;
import lx.team6.vo.UserVo;

@Service
public class UserService {

    @Autowired
    UserDAO dao;

    // 로그인
    public UserVo login(String userId, String userPw) {
        UserVo vo = dao.findById(userId);
        if (vo != null && vo.getUserId().equals(userId) && vo.getUserPw().equals(userPw)) {
            return vo;
        } else {
            return null;
        }
    }

    // 회원가입
    public UserVo signup(UserVo reqVo) {
        UserVo newId = dao.findById(reqVo.getUserId());
        if (newId != null) {
            return null;  // 이미 존재하는 ID일 경우 회원가입 실패
        } else {
            dao.createUser(reqVo);  // 신규 사용자 등록
            return reqVo;  // 성공적으로 등록된 사용자 정보 반환
        }
    }
}


