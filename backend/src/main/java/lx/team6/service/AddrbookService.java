package lx.team6.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lx.team6.dao.AddrbookDAO;
import lx.team6.vo.AddrbookVo;

@Service
public class AddrbookService {

    @Autowired
    AddrbookDAO dao;

    // 로그인
    public AddrbookVo login(String abId, String abPw) {
        AddrbookVo vo = dao.findById(abId);
        if (vo != null && vo.getAbId().equals(abId) && vo.getAbPw().equals(abPw)) {
            return vo;
        } else {
            return null;
        }
    }

    // 회원가입
    public AddrbookVo signup(AddrbookVo reqVo) {
        AddrbookVo newId = dao.findById(reqVo.getAbId());
        if (newId != null) {
            return null;  // 이미 존재하는 ID일 경우 회원가입 실패
        } else {
            dao.createUser(reqVo);  // 신규 사용자 등록
            return reqVo;  // 성공적으로 등록된 사용자 정보 반환
        }
    }
}


