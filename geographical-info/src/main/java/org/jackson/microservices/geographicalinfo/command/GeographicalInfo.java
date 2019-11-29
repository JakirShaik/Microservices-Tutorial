package org.jackson.microservices.geographicalinfo.command;

public class GeographicalInfo {
	private String city;
	private String district;
	private String state;
	private String country;
	private Integer pincode;

	public GeographicalInfo() {

	}

	public GeographicalInfo(String city, String district, String state, String country, Integer pincode) {
		super();
		this.city = city;
		this.district = district;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "GeographicalInfo [city=" + city + ", district=" + district + ", state=" + state + ", country=" + country
				+ ", pincode=" + pincode + "]";
	}

}
