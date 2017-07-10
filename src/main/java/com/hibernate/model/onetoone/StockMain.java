package com.hibernate.model.onetoone;

import java.time.LocalDateTime;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernate.util.HibernateUtil;

public class StockMain {

	public static void main(String[] args) {
		System.out.println("Hibernate one to one (Annotation)");
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session =sf.openSession();

		session.beginTransaction();

//		Stock stock = new Stock();
//
//		stock.setStockCode("7052");
//		stock.setStockName("PADINI");
//
//		StockDetail stockDetail = new StockDetail();
//		stockDetail.setCompanyName("PADINI Holding Malaysia");
//		stockDetail.setCompanyDesc("one stop shopping");
//		stockDetail.setRemark("vinci vinci");
//		stockDetail.setListedDateTime(LocalDateTime.now());
//
//		stock.setStockDetail(stockDetail);
//		stockDetail.setStock(stock);
//
//		session.save(stock);
//		
		Stock s = session.get(Stock.class, 1L);
		System.out.println(s.getStockCode());
		System.out.println(s.getStockDetail().getCompanyName());
		session.getTransaction().commit();
		session.close();
		sf.close();
		

		System.out.println("Done");
		
		
	}

}
