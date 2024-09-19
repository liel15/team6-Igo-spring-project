package lx.team6.vo;

public class PostKeywordVO {
	
	public int keywordNumber;
	public String keywordMbti;
	public String keywordSort;
	public String keywordLocation;
	public String keywordType;
	public String keywordMobility;
	public String keywordHouse;
	public int postNo;
	
	public int getKeywordNumber() {
		return keywordNumber;
	}
	public void setKeywordNumber(int keywordNumber) {
		this.keywordNumber = keywordNumber;
	}
	public String getKeywordMbti() {
		return keywordMbti;
	}
	public void setKeywordMbti(String keywordMbti) {
		this.keywordMbti = keywordMbti;
	}
	public String getKeywordSort() {
		return keywordSort;
	}
	public void setKeywordSort(String keywordSort) {
		this.keywordSort = keywordSort;
	}
	public String getKeywordLocation() {
		return keywordLocation;
	}
	public void setKeywordLocation(String keywordLocation) {
		this.keywordLocation = keywordLocation;
	}
	public String getKeywordType() {
		return keywordType;
	}
	public void setKeywordType(String keywordType) {
		this.keywordType = keywordType;
	}
	public String getKeywordMobility() {
		return keywordMobility;
	}
	public void setKeywordMobility(String keywordMobility) {
		this.keywordMobility = keywordMobility;
	}
	public String getKeywordHouse() {
		return keywordHouse;
	}
	public void setKeywordHouse(String keywordHouse) {
		this.keywordHouse = keywordHouse;
	}
	public int getPostNo() {
		return postNo;
	}
	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}
	
	@Override
	public String toString() {
		return "PostKeywordVO [keywordNumber=" + keywordNumber + ", keywordMbti=" + keywordMbti + ", keywordSort="
				+ keywordSort + ", keywordLocation=" + keywordLocation + ", keywordType=" + keywordType
				+ ", keywordMobility=" + keywordMobility + ", keywordHouse=" + keywordHouse + ", postNo=" + postNo
				+ "]";
	}
	

}
