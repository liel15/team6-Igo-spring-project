package lx.team6.vo;

public class LikeVO {
	Integer likeNo;
	String createdAt;
	String updatedAt;
	Integer postNo;
	int userNo;
	
	public Integer getLikeNo() {
		return likeNo;
	}
	public void setLikeNo(Integer likeNo) {
		this.likeNo = likeNo;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public String getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}
	public Integer getPostNo() {
		return postNo;
	}
	public void setPostNo(Integer postNo) {
		this.postNo = postNo;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	@Override
	public String toString() {
		return "LikeVO [likeNo=" + likeNo + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", postNo="
				+ postNo + ", userNo=" + userNo + "]";
	}
	
	
}
