package com.hibernate.inheritance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernate.util.HibernateUtil;

public class VehicleMain {

	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		Vehicle vehicle = new Vehicle();
		  vehicle.setVehicleName("Car");
		  
		  TwoWheeler twoWheeler = new TwoWheeler();
		  twoWheeler.setVehicleName("Bike");
		  twoWheeler.setSteeringTwoWheeler("Bike Steering Handle");
		  
		  FourWheeler fourWheeler = new FourWheeler();
		  fourWheeler.setVehicleName("Alto");
		  fourWheeler.setSteeringFourWheeler("Alto Steering Wheel");
		  
		  session.save(vehicle);
		  session.save(twoWheeler);
		  session.save(fourWheeler);
		
		
		session.getTransaction().commit();
		session.close();
		sf.close();

	}

}
