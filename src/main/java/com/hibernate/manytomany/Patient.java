package com.hibernate.manytomany;

import java.time.LocalDate;
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

import com.hibernate.model.onetomany.Course;

@Entity
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long patientId;
	private String name;
	private LocalDate dateAdmitted;
	
	@ManyToMany(fetch = FetchType.LAZY,cascade =
        {
                CascadeType.DETACH,
                CascadeType.MERGE,
                CascadeType.REFRESH,
                CascadeType.PERSIST
        }, targetEntity=Doctor.class)
	@JoinTable(name = "Patient_Doctor", joinColumns = {
			@JoinColumn(name = "PatientId", nullable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "DoctorId", nullable = false) 
	})	
	private List<Doctor> doctors = new ArrayList<>();
	
	public Patient() {
		super();
	}

	public Patient(Long patientId, String name, LocalDate dateAdmitted) {
		super();
		this.patientId = patientId;
		this.name = name;
		this.dateAdmitted = dateAdmitted;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDateAdmitted() {
		return dateAdmitted;
	}

	public void setDateAdmitted(LocalDate dateAdmitted) {
		this.dateAdmitted = dateAdmitted;
	}

	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}
	
	
	
	

}
