package lx.team6.vo;

public class UserVo {

	public String abId;
	public String abPw;
	public String abName;
	public String abEmail;
	public String abTel;
	public String abBirth;
	public String abComdept;
	public String abMemo;
	
	
	
	public String getAbMemo() {
		return abMemo;
	}
	public void setAbMemo(String abMemo) {
		this.abMemo = abMemo;
	}
	public String getAbName() {
		return abName;
	}
	public void setAbName(String abName) {
		this.abName = abName;
	}
	public String getAbEmail() {
		return abEmail;
	}
	public void setAbEmail(String abEmail) {
		this.abEmail = abEmail;
	}
	public String getAbTel() {
		return abTel;
	}
	public void setAbTel(String abTel) {
		this.abTel = abTel;
	}
	public String getAbBirth() {
		return abBirth;
	}
	public void setAbBirth(String abBirth) {
		this.abBirth = abBirth;
	}
	public String getAbComdept() {
		return abComdept;
	}
	public void setAbComdept(String abComdept) {
		this.abComdept = abComdept;
	}
	public String getAbId() {
		return abId;
	}
	public void setAbId(String abId) {
		this.abId = abId;
	}
	public String getAbPw() {
		return abPw;
	}
	public void setAbPw(String abPw) {
		this.abPw = abPw;
	}
	@Override
	public String toString() {
		return "AddrbookVo [abId=" + abId + ", abPw=" + abPw + ", abName=" + abName + ", abEmail=" + abEmail
				+ ", abTel=" + abTel + ", abBirth=" + abBirth + ", abComdept=" + abComdept + ", abMemo=" + abMemo + "]";
	}
	
	

}
