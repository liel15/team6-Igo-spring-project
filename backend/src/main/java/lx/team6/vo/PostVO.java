package lx.team6.vo;

import java.util.Date;

public class PostVO {
	Integer postNo;
	String postTitle;
	String content;
	String createdAt;
	String updatedAt;
	String img;
	int userNo;
	String userId;
	
	public Integer getPostNo() {
		return postNo;
	}
	public void setPostNo(Integer postNo) {
		this.postNo = postNo;
	}
	public String getPostTitle() {
		return postTitle;
	}
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "PostVO [postNo=" + postNo + ", postTitle=" + postTitle + ", content=" + content + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + ", img=" + img + ", userNo=" + userNo + ", userId=" + userId
				+ "]";
	}
	
	
	
}
