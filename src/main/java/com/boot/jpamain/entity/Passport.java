package com.boot.jpamain.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class Passport {

	@EmbeddedId
	private PassportId passportId;

	private String holderName;

	public PassportId getPassportId() {
		return passportId;
	}

	public void setPassportId(PassportId passportId) {
		this.passportId = passportId;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

}
