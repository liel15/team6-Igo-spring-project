package lx.team6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lx.team6.dao.PostDAO;
import lx.team6.vo.PostVO;

@Service
public class PostService {

    @Autowired
    PostDAO dao;


    public List<PostVO> getPostList() {
        List<PostVO> postList = dao.getPostList();
        return postList;
    }
    
    public PostVO getPostByNo(Integer postNo) {
        PostVO post = dao.getPostByNo(postNo);
        return post;
    }

   
}


