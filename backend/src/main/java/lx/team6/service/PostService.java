package lx.team6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lx.team6.dao.PostDAO;
import lx.team6.dao.PostKeywordDAO;
import lx.team6.vo.KeywordVo;
import lx.team6.vo.PostKeywordVO;
import lx.team6.vo.PostVO;
import lx.team6.vo.UserVo;

@Service
public class PostService {

    @Autowired
    PostDAO dao;

    @Autowired
    PostKeywordDAO keydao;
    
    // 게시글 리스트 불러오기
    public List<PostVO> getPostList() { 
        return dao.getPostList();
    };
    
    // 특정 유저의 게시글 리스트 불러오기
    public List<PostVO> getUserPostList(Integer userNo) {
   	 return dao.getUserPostList(userNo);
   }
    
    // 메인페이지 검색하는 메서드
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
    
    // 회원가입 및 키워드 저장을 트랜잭션으로 처리
    @Transactional
    public int insertPostAndKeyword(PostVO postVo, PostKeywordVO postkeywordVo) {
        // 1. post 테이블에 데이터 삽입
        int postInsertResult = dao.insertPost(postVo);  // userVo의 userNo 필드에 자동으로 PK가 들어감

        // 2. postKeyword 테이블에 데이터 삽입 (post의 PK를 FK로 사용)
        postkeywordVo.setPostNo(postVo.getPostNo());  // User 테이블의 PK를 FK로 설정
        int postkeywordInsertResult = keydao.insertPostKeyword(postkeywordVo);

        // 삽입 결과 반환
        return postInsertResult + postkeywordInsertResult;  // 두 테이블 삽입 결과를 더한 값 반환 (성공한 삽입 수)
    }
    
    // 포스트와 키워드 수정 트랜잭션
    @Transactional
    public void updatePostAndKeyword(Integer postNo, PostVO postVo, PostKeywordVO postkeywordVo) {
        try {
            // 1. 게시글 업데이트
            postVo.setPostNo(postNo); // 게시글의 식별자를 설정
            int postUpdateResult = dao.updatePost(postVo);

            if (postUpdateResult == 0) {
                throw new RuntimeException("게시글 업데이트 실패");
            }

            // 2. 키워드 업데이트
            postkeywordVo.setPostNo(postNo); // 키워드와 관련된 게시글 식별자 설정
            int keywordUpdateResult = keydao.updatePostKeyword(postkeywordVo);

            if (keywordUpdateResult == 0) {
                throw new RuntimeException("키워드 업데이트 실패");
            }
        } catch (Exception e) {
            // 예외 처리 및 로그 기록
            throw e; // 트랜잭션 롤백을 위해 예외를 다시 던짐
        }
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



	 // 메인페이지 검색하는 메서드
    public List<PostVO> searchPostList(String keyword) {
    	return dao.searchPostList(keyword);

    }
    
    //마이페이지 검색
    public List<PostVO> searchMyPostList(Integer userNo, String keyword) {
    	return dao.searchMyPostList(userNo, keyword);

    }
    
}

   

