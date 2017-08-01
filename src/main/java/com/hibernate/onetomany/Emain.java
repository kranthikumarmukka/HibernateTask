package com.hibernate.onetomany;

import java.time.LocalDate;
import java.time.Month;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernate.model.onetomany.Course;
import com.hibernate.model.onetomany.Topic;
import com.hibernate.util.HibernateUtil;

public class Emain {

	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session =sf.openSession();
		session.beginTransaction();
		Employer employer = new Employer();
		employer.setCompany("JNIT");
		Employee employee = new Employee();
		employee.setLastName("Mukka");
		employee.setDateJoined(LocalDate.of(2017, Month.JUNE, 10));
		employee.setEmployer(employer);
		Employee employee1 = new Employee();
		employee1.setLastName("chinnam");
		employee.setDateJoined(LocalDate.of(2017, Month.JULY, 02));
		employee1.setEmployer(employer);
		employer.getEmployees().add(employee);
		employer.getEmployees().add(employee1);
		session.save(employer);
		session.getTransaction().commit();
		session.close();
		sf.close();

	}

}
