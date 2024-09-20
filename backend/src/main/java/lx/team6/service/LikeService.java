package lx.team6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lx.team6.dao.LikeDAO;
import lx.team6.vo.LikeVO;

@Service
public class LikeService {

    @Autowired
    LikeDAO dao;
    
    // 좋아요 중복 여부 체크
    public boolean checkIfUserAlreadyLiked(LikeVO likeVO) {
        return dao.existsByUserNoAndPostNo(likeVO); // 중복 여부 확인
    }

    // 좋아요 추가
    public void insertLike(LikeVO likeVO) throws Exception {
        if (checkIfUserAlreadyLiked(likeVO)) {
            throw new Exception("User already liked this post.");
        }
        dao.insertLike(likeVO); // 좋아요 추가
    }

    // 글번호로 좋아요수 찾기
	public Integer getLikeByPostNo(Integer postNo) {
		return dao.getLikeByPostNo(postNo);
	}

	public List<LikeVO> getLikesList(Integer userNo) {
		return dao.getLikesList(userNo);
	}

	public void deleteLike(Integer likeNo) {
		dao.deleteLike(likeNo);
	}

	public void deleteLikeByPostNo(Integer postNo) {
		dao.deleteLikeByPostNo(postNo);
	}
    
    
}

   



