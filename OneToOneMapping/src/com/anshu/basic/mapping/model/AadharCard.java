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
public class AadharCard {
	@Id
	private String aadharId;
	private String website;
	private String helpLineNumber;
	private String aadharEmail;
	
	@Temporal(TemporalType.DATE)
	private Date issueDate;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="personMobNo")
	private Person person;
	
	
	public String getAadharId() {
		return aadharId;
	}
	public void setAadharId(String aadharId) {
		this.aadharId = aadharId;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getHelpLineNumber() {
		return helpLineNumber;
	}
	public void setHelpLineNumber(String helpLineNumber) {
		this.helpLineNumber = helpLineNumber;
	}
	public String getAadharEmail() {
		return aadharEmail;
	}
	public void setAadharEmail(String aadharEmail) {
		this.aadharEmail = aadharEmail;
	}
	public Date getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
}
