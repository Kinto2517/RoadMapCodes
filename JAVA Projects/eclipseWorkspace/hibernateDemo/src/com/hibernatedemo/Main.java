package com.hibernatedemo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(City.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();	
			
			/*
			 * //List<City> cities =
			 * session.createQuery("select countryCode from City c GROUP BY c.countryCode").
			 * getResultList(); List<String> countryCodes =
			 * session.createQuery("select countryCode from City c GROUP BY c.countryCode").
			 * getResultList();
			 * 
			 * for (String countryCode : countryCodes) { System.out.println(countryCode); }
			 */
			/*
			 * City city = new City(); city.setName("Düzce 10"); city.setCountryCode("TUR");
			 * city.setDistrict("Karadeniz"); city.setPopulation(10000);
			 * 
			 * session.save(city);
			 */
			
			City city = session.get(City.class, 100);
			city.setPopulation(40123);
			session.remove(city);
			session.getTransaction().commit();
		
			
		}finally {
			factory.close(); 
		}
	
		
		
		
		
		
	}

}
