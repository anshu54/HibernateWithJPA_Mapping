package com.anshu.basic.mapping.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Person {
	@Id
	private String personMobNo;
	private String personName;
	
	@Temporal(TemporalType.DATE)
	private Date personDob;
	private String personGender;
	private String personEmailId;
	private String personAddress;
	private String personState; 
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="aadharId")
	private AadharCard aadharCard;

	public String getPersonMobNo() {
		return personMobNo;
	}

	public void setPersonMobNo(String personMobNo) {
		this.personMobNo = personMobNo;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public Date getPersonDob() {
		return personDob;
	}

	public void setPersonDob(Date personDob) {
		this.personDob = personDob;
	}

	public String getPersonGender() {
		return personGender;
	}

	public void setPersonGender(String personGender) {
		this.personGender = personGender;
	}

	public String getPersonAddress() {
		return personAddress;
	}

	public void setPersonAddress(String personAddress) {
		this.personAddress = personAddress;
	}

	public String getPersonEmailId() {
		return personEmailId;
	}

	public void setPersonEmailId(String personEmailId) {
		this.personEmailId = personEmailId;
	}

	public AadharCard getAadharCard() {
		return aadharCard;
	}

	public void setAadharCard(AadharCard aadharCard) {
		this.aadharCard = aadharCard;
	}

	public String getPersonState() {
		return personState;
	}

	public void setPersonState(String personState) {
		this.personState = personState;
	}
	
	
}
