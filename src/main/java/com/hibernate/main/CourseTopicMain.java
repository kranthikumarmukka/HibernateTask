package com.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernate.model.onetomany.Course;
import com.hibernate.model.onetomany.SkillLevel;
import com.hibernate.model.onetomany.Topic;
import com.hibernate.util.HibernateUtil;

public class CourseTopicMain {

	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session =sf.openSession();
		session.beginTransaction();
//		Course course = new Course();
//		course.setName("Java Programming");
//		Topic topic = new Topic();
//		topic.setName("Datatypes");
//		topic.setCourse(course);
//		Topic topic1 = new Topic();
//		topic1.setName("Collections");
//		topic1.setCourse(course);
//		Topic topic2 = new Topic();
//		topic2.setName("OOPS");
//		topic2.setCourse(course);
//		course.getTopics().add(topic);
//		course.getTopics().add(topic1);
//		course.getTopics().add(topic2);
		Course course = session.get(Course.class, 2L);
		session.delete(course);
		//session.saveOrUpdate(course);
		//System.out.println(course.getName());
		//System.out.println(course.getTopics().size());
		session.getTransaction().commit();
		session.close();
		sf.close();
		
		
		
		
		

	}

}
