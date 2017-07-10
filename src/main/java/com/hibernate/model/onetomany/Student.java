package com.hibernate.model.onetomany;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Version;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long studentId;

	//@Email(message = "user name is invalid")
	//@NotBlank(message = "user name can not be blank")
	private String userName;
//
	@NotBlank(message = "first name can not be blank")
	private String fName;

	//@NotBlank(message = "last name can not be blank")
	private String lName;

	private String mName;

	//@NotBlank(message = "password can not be blank")
	private String password;

	//@NotNull(message = "date of birth can not be blank")
	private LocalDate dob;

	private String phoneNumber;

	private LocalDateTime createdDateTime;

	@Version
	private LocalDateTime updatedDateTime;

	@ManyToMany(fetch = FetchType.LAZY,cascade =
        {
                CascadeType.DETACH,
                CascadeType.MERGE,
                CascadeType.REFRESH,
                CascadeType.PERSIST
        }, targetEntity=Course.class)
	@JoinTable(name = "Student_Course", joinColumns = {
			@JoinColumn(name = "StudentId", nullable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "CourseId", nullable = false) 
	})	
	private List<Course> courses = new ArrayList<>();

	public Student() {
		super();
	}

	public Student(String userName, String fName, String lName, String mName, String password, LocalDate dob,
			String phoneNumber) {
		super();
		this.userName = userName;
		this.fName = fName;
		this.lName = lName;
		this.mName = mName;
		this.password = password;
		this.dob = dob;
		this.phoneNumber = phoneNumber;
		this.createdDateTime = LocalDateTime.now();
		this.updatedDateTime = LocalDateTime.now();
	}

	public Long getStudentId() {
		return studentId;
	}
	
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
}
