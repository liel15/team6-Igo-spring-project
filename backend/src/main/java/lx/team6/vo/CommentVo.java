package lx.team6.vo;

public class CommentVo {
	
	Integer commentNo;
	String content;
	
	
	public int getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(Integer commentNo) {
		this.commentNo = commentNo;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	@Override
	public String toString() {
		return "CommentVo [commentNo=" + commentNo + ", content=" + content + "]";
	}
	
	

}
