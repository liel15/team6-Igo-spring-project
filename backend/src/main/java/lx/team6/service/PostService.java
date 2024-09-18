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
        return dao.getPostList();
    };
    
    
    // 포스트 검색하는 메서드
    public List<PostVO> serchPostList(String keyword) {
    	List<PostVO> resultPost = dao.serchPostList(keyword);
    	return resultPost;
    }
       

    // 게시글 한개 불러오기
    public PostVO getPostByNo(Integer postNo) {
        PostVO post = dao.getPostByNo(postNo);
        return post;
    }
    
    // 게시글 등록
    public void insertPost(PostVO post) {
    	dao.insertPost(post);
    }

    // 게시글 수정
    public void updatePost(PostVO post) {
    	dao.updatePost(post);
    }

    // 게시글 삭제
    public void deletePost(Integer postNo) {
    	dao.deletePost(postNo);
    }
    
    // 좋아요 리스트 불러오기
    public List<PostVO> getLikesPostList(Integer userNo) {
    	 return dao.getLikesPostList(userNo);
    }


	public void toggleLike(Integer postNo, Integer userNo) {
		boolean isLiked = dao.checkIfLiked(postNo, userNo);
		
		        if (isLiked) {
		            // 좋아요가 이미 눌렸으면 삭제
		        	dao.removeLike(postNo, userNo);
		        } else {
		            // 좋아요가 없으면 추가
		        	dao.addLike(postNo, userNo);
		        }
		    }

    
    
}

   



