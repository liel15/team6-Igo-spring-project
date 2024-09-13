package lx.team6.vo;

public class UserVo {
	
	public String userNumber;
	public String userId;
	public String userPw;
	public String userName;
	public String userEmail;
	public String userTel;
	public String userBirth;
	public String userGender;
	public String userImage;
	
	public String getUserNumber() {
		return userNumber;
	}
	public void setUserNumber(String userNumber) {
		this.userNumber = userNumber;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserTel() {
		return userTel;
	}
	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}
	public String getUserBirth() {
		return userBirth;
	}
	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public String getUserImage() {
		return userImage;
	}
	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}
	@Override
	public String toString() {
		return "UserVo [userNumber=" + userNumber + ", userId=" + userId + ", userPw=" + userPw + ", userName="
				+ userName + ", userEmail=" + userEmail + ", userTel=" + userTel + ", userBirth=" + userBirth
				+ ", userGender=" + userGender + ", userImage=" + userImage + "]";
	}
	
	
	
	
	

}
