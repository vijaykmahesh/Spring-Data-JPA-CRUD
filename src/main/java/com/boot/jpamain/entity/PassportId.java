package com.boot.jpamain.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class PassportId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5005285599700879419L;
	
	private String passportNumber;
    private String countryCode;
    
    
    
    
	public String getPassportNumber() {
		return passportNumber;
	}


	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}


	public String getCountryCode() {
		return countryCode;
	}


	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}


	public PassportId() {
		super();
		// TODO Auto-generated constructor stub
	}


	public PassportId(String passportNumber, String countryCode) {
		super();
		this.passportNumber = passportNumber;
		this.countryCode = countryCode;
	}


	@Override
	public int hashCode() {
		return Objects.hash(countryCode, passportNumber);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PassportId other = (PassportId) obj;
		return Objects.equals(countryCode, other.countryCode) && Objects.equals(passportNumber, other.passportNumber);
	}
	
	

    
    
	
	
	

}
