package lx.team6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lx.team6.dao.AddrbookDAO;
import lx.team6.dao.PostDAO;
import lx.team6.vo.AddrbookVo;
import lx.team6.vo.PostVO;

@Service
public class PostService {

    @Autowired
    PostDAO dao;

    // 로그인
    public List<PostVO> getPost() {
        List<PostVO> postList = dao.getPostList();
        return postList;
    }

   
}


