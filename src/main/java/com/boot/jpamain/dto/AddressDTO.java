package com.boot.jpamain.dto;

import com.boot.jpamain.entity.AddressType;

public class AddressDTO {

	private AddressType addressType;

	private String addressLine1;

	private String city;

	private Integer studentId;

	public AddressType getAddressType() {
	    return addressType;
	}
	
	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressType(AddressType addressType) {
		this.addressType = addressType;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

}
