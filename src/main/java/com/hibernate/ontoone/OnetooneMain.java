package com.hibernate.ontoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernate.util.HibernateUtil;

public class OnetooneMain {

	public static void main(String[] args) {
		System.out.println("Hibernate one to one");
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
		session.beginTransaction();
		
		Person person = new Person();
		
		person.setFirstName("kranthi");
		person.setLastName("Mukka");
		
		Passport passport = new Passport();
		passport.setIssuedCountry("India");
		passport.setOccupation("Student");
		
		person.setPassport(passport);
		passport.setPerson(person);
		
		session.save(person);
		session.getTransaction().commit();
		session.close();
		sf.close();
		
		System.out.println("Done");

	}

}
