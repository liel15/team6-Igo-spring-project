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

    // 게시글 리스트 불러오기
    public List<PostVO> getPostList() {

    public List<PostVO> getPostList() {
        List<PostVO> postList = dao.getPostList();
        return postList;
    }
       
    public PostVO getPostByNo(Integer postNo) {
        PostVO post = dao.getPostByNo(postNo);
        return post;
    }

    // 게시글 한개 불러오기
    public PostVO getPostByNo(Integer postNo) {
        PostVO post = dao.getPostByNo(postNo);
        return post;
    }
   
//    // 게시글 등록
//    public void insertPost(PostVO post) {
//    dao.insertPost(post);
//    }
//
//    // 게시글 수정
//    public void updatePost(PostVO post) {
//    dao.updatePost(post);
//    }
//
//    // 게시글 삭제
//    public void deletePost(Integer postNo) {
//    dao.deletePost(postNo);
//    }
}