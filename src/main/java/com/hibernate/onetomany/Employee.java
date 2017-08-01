package com.hibernate.onetomany;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long EmployeeId;

	private String firstName;
	private String lastName;

	@ManyToOne
	@JoinColumn(name = "EmployerId")
	private Employer employer;

	private LocalDate dateJoined;

	@Version
	private LocalDateTime updatedDateTime;

	public Employee() {

	}

	

	public Employee(String firstName, String lastName, Employer employer) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.employer = employer;
	}



	public Long getEmployeeId() {
		return EmployeeId;
	}

	public void setEmployeeId(Long employeeId) {
		EmployeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getDateJoined() {
		return dateJoined;
	}

	public void setDateJoined(LocalDate dateJoined) {
		this.dateJoined = dateJoined;
	}

	public LocalDateTime getUpdatedDateTime() {
		return updatedDateTime;
	}

	public void setUpdatedDateTime(LocalDateTime updatedDateTime) {
		this.updatedDateTime = updatedDateTime;
	}



	public Employer getEmployer() {
		return employer;
	}



	public void setEmployer(Employer employer) {
		this.employer = employer;
	}
	
	

}