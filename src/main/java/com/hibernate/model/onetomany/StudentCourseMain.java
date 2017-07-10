package com.hibernate.model.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernate.util.HibernateUtil;

public class StudentCourseMain {

	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session =sf.openSession();
		session.beginTransaction();
//		Student student = new Student();
//		student.setfName("Michael");
//		student.setlName("Marcel");
//		Course course = new Course();
//		course.setName("Java Programming");
//		course.getStudents().add(student);
		
		//session.save(student);
		//session.save(course);

		Student student = session.load(Student.class, 2L);
		session.delete(student);
//		Course course = session.load(Course.class, 1L);
//		session.delete(course);
		
//		Student student = session.load(Student.class, 2L);
//		Course course = session.load(Course.class, 1L);
//		course.getStudents().add(student);
//		session.update(course);

		session.getTransaction().commit();
		session.close();
		sf.close();

	}

}
