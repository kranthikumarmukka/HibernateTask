package com.hibernate.ontoone;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class Passport implements Serializable{
	private static final long serialVersionUID=1L;
	
	@GenericGenerator(name="generator",strategy="foreign",parameters=@Parameter(name="property",value="person"))
	@Id
	@GeneratedValue(generator="generator")
	private Long personId;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private Person person;
	private String issuedCountry;
	private String occupation;
	
	public Long getPersonId() {
		return personId;
	}
	public void setPersonId(Long personId) {
		this.personId = personId;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public String getIssuedCountry() {
		return issuedCountry;
	}
	public void setIssuedCountry(String issuedCountry) {
		this.issuedCountry = issuedCountry;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	
	
	
	
}
