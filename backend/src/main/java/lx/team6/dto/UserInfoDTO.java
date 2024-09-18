package lx.team6.dto;

public class UserInfoDTO {
	
	
	/*
	 * 데이터 전송을 위해 만든 객체 메인에 해당 정보들을 띄우기 위해 dto를 따로 만들었다. 
	 * (keyword와 user 정보를 join 해서 보여줘야 하기 때문에)
	 */
	
	 private String id;
	    private String name;
	    private String img;
	    private String keywordMbti;
	    private String keywordSort;
	    private String keywordLocation;
	    private String keywordType;
	    private String keywordMobility;
	    private String keywordHouse;
	    
	    
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getImg() {
			return img;
		}
		public void setImg(String img) {
			this.img = img;
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
	    
	    

}
