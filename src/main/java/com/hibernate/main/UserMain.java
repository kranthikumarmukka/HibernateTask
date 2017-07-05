package com.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.model.User;
import com.hibernate.util.HibernateUtil;

public class UserMain {

	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		Transaction tran = s.beginTransaction();
		//User user = new User();
		//user.setUserName("bhiapp4@gmail.com");
		//s.save(user);
		//tran.commit();
		//User user = s.load(User.class, 1L);
		User user = s.get(User.class, 1L);
		System.out.println(user.getUserName());
		user.setUserName("bh1@gmail.com");
		s.update(user);
		tran.commit();
		s.close();
		sf.close();
	}

}
