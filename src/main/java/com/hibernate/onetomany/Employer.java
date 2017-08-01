package com.hibernate.onetomany;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@Entity
public class Employer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long EmployerId;
	private String name;
	private String company;

	
	@OneToMany(mappedBy = "employer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	// @OrderColumn(name="idx")
	@OrderColumn
	//@Fetch(FetchMode.JOIN) // JOIN(one query to get both course and topic),SELECT(two queries to get course and topic)
	private List<Employee> employees = new ArrayList<>();

	private LocalDateTime createdDateTime;

	@Version
	private LocalDateTime updatedDateTime;


	public Employer() {

	}


	public Employer(Long employerId, String name, String company, List<Employee> employees,
			LocalDateTime createdDateTime, LocalDateTime updatedDateTime) {
		super();
		EmployerId = employerId;
		this.name = name;
		this.company = company;
		this.employees = employees;
		this.createdDateTime = createdDateTime;
		this.updatedDateTime = updatedDateTime;
	}


	public Long getEmployerId() {
		return EmployerId;
	}


	public void setEmployerId(Long employerId) {
		EmployerId = employerId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCompany() {
		return company;
	}


	public void setCompany(String company) {
		this.company = company;
	}


	public List<Employee> getEmployees() {
		return employees;
	}


	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}


	public LocalDateTime getCreatedDateTime() {
		return createdDateTime;
	}


	public void setCreatedDateTime(LocalDateTime createdDateTime) {
		this.createdDateTime = createdDateTime;
	}


	public LocalDateTime getUpdatedDateTime() {
		return updatedDateTime;
	}


	public void setUpdatedDateTime(LocalDateTime updatedDateTime) {
		this.updatedDateTime = updatedDateTime;
	}
	
	
	
}
