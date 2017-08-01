package com.hibernate.manytomany;

import java.time.LocalDate;
import java.time.Month;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernate.util.HibernateUtil;

public class Pdmain {
	
	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		Patient patient = new Patient();
		patient.setName("Alex");
		patient.setDateAdmitted(LocalDate.of(2017, Month.FEBRUARY, 20));
		Doctor doctor = new Doctor();
		doctor.setName("John");
		doctor.getPatients().add(patient);
		
		session.save(patient);
		session.save(doctor);
		
		session.getTransaction().commit();
		session.close();
		sf.close();
		
	}
	

}
