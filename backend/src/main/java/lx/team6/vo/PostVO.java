package lx.team6.vo;

import java.util.Date;

public class PostVO {
	Integer postNo;
	String postTitle;
	String postContent;
	String postDate;
	
	@Override
	public String toString() {
		return "PostVO [postNo=" + postNo + ", postTitle=" + postTitle + ", postContent=" + postContent + ", postDate="
				+ postDate + "]";
	}
	
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
	public String getPostContent() {
		return postContent;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	public String getPostDate() {
		return postDate;
	}
	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}
	
}
