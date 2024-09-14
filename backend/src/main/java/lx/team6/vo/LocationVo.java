package lx.team6.vo;

public class LocationVo {
	
	int location_no;
	String address;
	double latitude;
	double longtitude;
	
	
	public int getLocation_no() {
		return location_no;
	}
	public void setLocation_no(int location_no) {
		this.location_no = location_no;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongtitude() {
		return longtitude;
	}
	public void setLongtitude(double longtitude) {
		this.longtitude = longtitude;
	}
	@Override
	public String toString() {
		return "LocationVo [location_no=" + location_no + ", address=" + address + ", latitude=" + latitude
				+ ", longtitude=" + longtitude + "]";
	}
	

}
